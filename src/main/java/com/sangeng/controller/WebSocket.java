package com.sangeng.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sangeng.domain.LoginUser;
import com.sangeng.domain.User;
import com.sangeng.utils.JwtUtil;
import com.sangeng.utils.RedisCache;
import io.jsonwebtoken.Claims;
import lombok.Data;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.*;

import java.io.IOException;
import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

//https://www.skypyb.com/2019/02/uncategorized/813/
@Component
public class WebSocket implements WebSocketHandler {
    /**
     * webSocket 是多例模式，自动装配注入会是null，所以采用static+set注入
     */
    private static RedisCache redis;
    @Autowired
    public void setRedis(RedisCache redisCache) {
        WebSocket.redis = redisCache;
    }

    // key=token，value=可以发消息的WebSocketSession
    public static final Map<User, WebSocketSession> SESSIONS = new ConcurrentHashMap<>();
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        // 建立新的socket连接后回调的方法。
        LoginUser loginUser = getLoginUser(session);
        SESSIONS.put(loginUser.getUser(), session);
        System.out.println(String.format("成功建立连接~ : %s", loginUser));
        System.out.println("------------------------------------------");
        System.out.println("当前有"+SESSIONS.entrySet().size()+"个socket连接！");
        for (Map.Entry<User, WebSocketSession> entry : SESSIONS.entrySet()) {
            System.out.println(entry.getKey().getUserName());
        }
        System.out.println("-----------------------------------------");
        // 欢迎socket新用户
        HashMap<String, String> map = new HashMap<>();
        map.put("from","manager");
        map.put("to","me");
        map.put("msg","欢迎："+loginUser.getUsername());
        HashMap<String, Map> result = new HashMap<>();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        String format = simpleDateFormat.format(new Date().getTime());
        result.put(format,map);
        String jsonString = JSON.toJSONString(result);
        sendMessage(loginUser.getUser(),jsonString);
        // ======================================================================
        Set<Map.Entry<User, WebSocketSession>> entries = SESSIONS.entrySet();
        // 过滤用户 usertype==0
        List<Map.Entry<User, WebSocketSession>> collect = entries.stream().filter(user -> Integer.parseInt(user.getKey().getUserType()) == 0).collect(Collectors.toList());
        List<String> onlineUser = collect.stream().map(entry -> entry.getKey().getUserName()).collect(Collectors.toList());
        System.out.println("显示在线用户："+onlineUser);
        for (Map.Entry<User, WebSocketSession> entry : entries) {
            if (Integer.parseInt(entry.getKey().getUserType())==1){ // 找到管理员，发送在线用户
                // admin
                HashMap<String, Object> onlineUserMap = new HashMap<>();
                onlineUserMap.put("online", onlineUser);
                String onlineJson = JSON.toJSONString(onlineUserMap);
                sendMessage(entry.getKey(),onlineJson); // {"online":["normal"]}
            }else {
                // normal
            }
        }
    }

    @NotNull // 参数不能为空
    private LoginUser getLoginUser(WebSocketSession session) {
        String jwt = session.getAttributes().get("token").toString(); // 取出问号后面传过来的jwt
        String userid; // 获取userid 用于从redis取出用户信息
        try {
            Claims claims = JwtUtil.parseJWT(jwt);
            userid = claims.getSubject();
        }catch (Exception e){
            throw new RuntimeException("token 非法！");
        }
        LoginUser loginUser = redis.getCacheObject("login:" + userid);
        if (Objects.isNull(loginUser)){
            throw new RuntimeException("用户未登录！");
        }
        return loginUser;
    }

    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
        // 接收客户端发送的Socket
        LoginUser loginUser = getLoginUser(session);
        if (Integer.parseInt(loginUser.getUser().getUserType())==1) { // 如果是管理员发送的消息，发给对应普通用户
            System.out.println("管理员 message:"+message.getPayload());
            JSONObject jsonObject = JSON.parseObject((String) message.getPayload());// 客户端发送过来的消息
            Set<Map.Entry<String, Object>> entries = jsonObject.entrySet();
            for (Map.Entry<String, Object> entry : entries) {
                String key = entry.getKey();
                String s = entry.getValue().toString();
                JSONObject jsonObject1 = JSON.parseObject(s);
                Map<String, Object> innerMap = jsonObject1.getInnerMap();
                String msg = innerMap.get("msg").toString();
                // String from = innerMap.get("from").toString();
                String to = innerMap.get("to").toString();
                sendMessage(to,msg);
            }
        }else { // 如果是普通用户的消息，发给全部管理员
            System.out.println("普通用户 message:"+message.getPayload());
            Set<Map.Entry<User, WebSocketSession>> entries = SESSIONS.entrySet();
            // 过滤用户 usertype==0
            List<Map.Entry<User, WebSocketSession>> collect = entries.stream().filter(user -> Integer.parseInt(user.getKey().getUserType()) == 0).collect(Collectors.toList());
            List<String> onlineUser = collect.stream().map(entry -> entry.getKey().getUserName()).collect(Collectors.toList());
            System.out.println("显示在线用户："+onlineUser);
            for (Map.Entry<User, WebSocketSession> entry : entries) {
                if (Integer.parseInt(entry.getKey().getUserType())==1){ // 找到管理员，发送在线用户
                    // admin
                    sendMessage(entry.getKey(),message.getPayload().toString());
                }else {
                    // normal
                }
            }
        }

    }
    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        // 连接出错时，回调的方法
        System.out.println("连接出错");
        if (session.isOpen()) {
            session.close();
        }
    }
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
        // 连接关闭时，回调的方法
        System.out.println("连接已关闭,status:" + closeStatus);
    }
    @Override
    public boolean supportsPartialMessages() {
        // 这个是WebSocketHandler是否处理部分消息，没什么卵用 返回false就完事了。
        return false;
    }
    /**
     * 指定发消息
     * @param message
     */
    public static void sendMessage(User user, String message) {
        WebSocketSession webSocketSession = SESSIONS.get(user);
        if (webSocketSession == null || !webSocketSession.isOpen()) return;
        try {
            webSocketSession.sendMessage(new TextMessage(message));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * 指定username发消息
     * @param message
     */
    public static void sendMessage(String userName, String message) {
        Set<User> users = SESSIONS.keySet();
        for (User user : users) {
            if (Objects.equals(user.getUserName(), userName)){
                WebSocketSession webSocketSession = SESSIONS.get(user);
                if (webSocketSession == null || !webSocketSession.isOpen()) return;
                try {
                    webSocketSession.sendMessage(new TextMessage(message));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    /**
     * 群发消息
     * @param message
     */
    public static void fanoutMessage(String message) {
        SESSIONS.keySet().forEach(user -> sendMessage(user, message));
    }
}
