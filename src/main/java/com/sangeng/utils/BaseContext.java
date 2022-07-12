package com.sangeng.utils;

/**
 * 对ThreadLocal中存的变量的读写操作
 */
public class BaseContext {
    public static ThreadLocal<Long> tl = new ThreadLocal<>();

    /**
     * 设置值
     * @param id 当前登录的用户的id
     */
    public static void set(Long id){
        tl.set(id);
    }

    /**
     * 获取值
     * @return threadLocal 中存的变量
     */
    public static Long get(){
        return tl.get();
    }
}
