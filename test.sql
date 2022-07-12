# show variables like "%character%";
# show collation like "%utf8%";
# SHOW VARIABLES WHERE Variable_name LIKE 'character\_set\_%' OR Variable_name LIKE 'collation%';
# set character_set_server =utf8mb4;
# set character_set_database =utf8mb4;
# -- Current Database: `sg_security`
# --
#
# CREATE DATABASE /*!32312 IF NOT EXISTS*/ `sg_security` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `sg_security`;

--
-- Table structure for table `data_category`
--

DROP TABLE IF EXISTS `data_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `data_category` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(10) DEFAULT NULL,
  `description` varchar(500) DEFAULT NULL,
  `createBy` int DEFAULT NULL,
  `created` varchar(100) DEFAULT NULL,
  `updateBy` int DEFAULT NULL,
  `updated` varchar(100) DEFAULT NULL,
  `status` int DEFAULT NULL,
  `path` varchar(100) DEFAULT '/',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `data_category`
--

LOCK TABLES `data_category` WRITE;
/*!40000 ALTER TABLE `data_category` DISABLE KEYS */;
INSERT INTO `data_category` VALUES (2,'婚纱礼服','<p>这是栏<span style=\"color:#c0392b\">目一</span>💛💚</p>',NULL,NULL,NULL,NULL,0,'/婚纱礼服'),(5,'婚礼摄影','<p></p>',NULL,NULL,NULL,NULL,0,'/婚礼摄影'),(13,'婚庆公司','<p></p>',NULL,NULL,NULL,NULL,0,'/婚庆公司'),(14,'婚车车队','<p></p>',NULL,NULL,NULL,NULL,0,'/婚车车队');
/*!40000 ALTER TABLE `data_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `data_collection`
--

DROP TABLE IF EXISTS `data_collection`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `data_collection` (
  `uid` int DEFAULT NULL,
  `cid` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `data_collection`
--

LOCK TABLES `data_collection` WRITE;
/*!40000 ALTER TABLE `data_collection` DISABLE KEYS */;
INSERT INTO `data_collection` VALUES (2,26),(2,27);
/*!40000 ALTER TABLE `data_collection` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `data_comment`
--

DROP TABLE IF EXISTS `data_comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `data_comment` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `pid` bigint DEFAULT NULL,
  `content` varchar(900) DEFAULT NULL,
  `uid` bigint DEFAULT NULL,
  `date_time` datetime DEFAULT NULL,
  `user_name` varchar(100) DEFAULT NULL,
  `avatar` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `data_comment_id_uindex` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `data_comment`
--

LOCK TABLES `data_comment` WRITE;
/*!40000 ALTER TABLE `data_comment` DISABLE KEYS */;
INSERT INTO `data_comment` VALUES (2,26,'这个婚纱很好',2,'2022-04-08 21:44:01','normal',NULL),(3,26,'这个婚纱整的挺好',2,'2022-04-08 21:56:24','normal',NULL),(4,26,'这个婚纱的质感挺好',2,'2022-04-08 22:00:02','normal',NULL),(8,26,'强烈推荐',2,'2022-04-11 00:46:36','normal',NULL),(9,28,'第二条评论',2,'2022-04-11 00:47:04','normal',NULL),(10,40,'这个婚车整的挺好',2,'2022-04-12 19:12:41','normal',NULL),(11,39,'婚庆公司挺好',2,'2022-04-12 19:13:04','normal',NULL);
/*!40000 ALTER TABLE `data_comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `data_products`
--

DROP TABLE IF EXISTS `data_products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `data_products` (
  `pid` int NOT NULL AUTO_INCREMENT,
  `cid` int DEFAULT NULL,
  `status` int DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  `images` varchar(100) DEFAULT NULL,
  `description` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `data_products`
--

LOCK TABLES `data_products` WRITE;
/*!40000 ALTER TABLE `data_products` DISABLE KEYS */;
INSERT INTO `data_products` VALUES (26,2,0,'婚纱1','/img/hsbl.jpg','<p><span style=\"color:#000000\"><span style=\"letter-spacing:5px\"><span style=\"font-size:30px\">为吾绾青丝，相濡以沫，一夕到白头</span></span><br/><span style=\"letter-spacing:5px\"><span style=\"font-size:30px\">不离不弃，相伴相携</span></span><br/><span style=\"letter-spacing:5px\"><span style=\"font-size:30px\">绾青丝，挽情思</span></span><br/><span style=\"letter-spacing:5px\"><span style=\"font-size:30px\">任风雨，人生不惧</span></span><br/><span style=\"letter-spacing:5px\"><span style=\"font-size:30px\">浮生一梦醉眼看</span></span><br/><span style=\"letter-spacing:5px\"><span style=\"font-size:30px\">海如波，心如皓月</span></span><br/><span style=\"letter-spacing:5px\"><span style=\"font-size:30px\">你自妖娆，我自伴，</span></span><br/><span style=\"letter-spacing:5px\"><span style=\"font-size:30px\">永相随！</span></span></span></p>'),(28,2,0,'婚纱3','/img/1513193553292808193.webp','<p></p>'),(30,2,0,'婚纱5','/img/hs5.jpg','<p></p>'),(36,2,0,'凡尔赛玫瑰','/img/fesmg.jpg','<p></p><p></p><p><span style=\"font-size:30px\"><span style=\"color:#f32784\">爱情如</span><span style=\"color:#8e44ad\">红玫</span><span style=\"color:#f32784\">般纯粹热烈。</span></span></p><p><span style=\"font-size:30px\"><span style=\"color:#f32784\">如白纱般圣洁唯美。</span></span></p><p></p><p><span style=\"font-size:30px\"><span style=\"color:#f32784\">采用纵向玫瑰花树蕾丝，托底珍珠密缝，优雅鱼尾款。</span></span></p><p><span style=\"font-size:30px\"><span style=\"color:#f32784\">手工立体玫瑰花瓣蕾丝拼接，栩栩如生。</span></span></p><p></p><p></p><p></p><p></p><p></p><p></p><p></p><p></p>'),(37,5,0,'test01','/img/hlsy.jpg','<p></p>'),(38,5,0,'婚礼摄影02','/img/hlsy2.jpg','<p></p>'),(39,13,0,'婚庆1','/img/1513821989979934721.jpg','<p></p><p></p><p><span style=\"font-size:30px\"><span style=\"line-height:2.5\"><span style=\"letter-spacing:1px\"><span style=\"color:#c0392b\">品牌介绍：成立于2006年，国内首家上市婚庆公司。用口碑代言，让满意度说话。新人的选择是我们成功的根本。</span></span></span></span></p><p><span style=\"font-size:30px\"><span style=\"line-height:2.5\"><span style=\"letter-spacing:1px\"><span style=\"color:#c0392b\">具体地址：无锡市西水东商业街167-6</span></span></span></span></p><p><span style=\"font-size:30px\"><span style=\"line-height:2.5\"><span style=\"letter-spacing:1px\"><span style=\"color:#c0392b\">联系方式：051082729799</span></span></span></span></p>'),(40,14,NULL,'test01','/img/1513825204842647553.jpg','<p style=\"text-align:start;text-indent:2em;\"><span style=\"font-size:30px\"><span style=\"line-height:2.5\"><span style=\"letter-spacing:1px\"><span style=\"color:#f39c12\">品牌介绍：成立于1999年，国内首家上市婚车公司。用口碑代言，让满意度说话。新人的选择是我们成功的根本。</span></span></span></span></p><p style=\"text-align:start;text-indent:2em;\"><span style=\"font-size:30px\"><span style=\"line-height:2.5\"><span style=\"letter-spacing:1px\"><span style=\"color:#f39c12\">具体地址：杭州市滨江区167-6</span></span></span></span></p><p style=\"text-align:start;text-indent:2em;\"><span style=\"font-size:30px\"><span style=\"line-height:2.5\"><span style=\"letter-spacing:1px\"><span style=\"color:#f39c12\">联系方式：17630804633</span></span></span></span></p>');
/*!40000 ALTER TABLE `data_products` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `data_setting`
--

DROP TABLE IF EXISTS `data_setting`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `data_setting` (
  `id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(20) DEFAULT NULL,
  `description` varchar(500) DEFAULT NULL,
  `visit` bigint DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `data_setting`
--

LOCK TABLES `data_setting` WRITE;
/*!40000 ALTER TABLE `data_setting` DISABLE KEYS */;
/*!40000 ALTER TABLE `data_setting` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_menu`
--

DROP TABLE IF EXISTS `sys_menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_menu` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `menu_name` varchar(64) NOT NULL DEFAULT 'NULL' COMMENT '菜单名',
  `path` varchar(200) DEFAULT NULL COMMENT '路由地址',
  `component` varchar(255) DEFAULT NULL COMMENT '组件路径',
  `visible` char(1) DEFAULT '0' COMMENT '菜单状态（0显示 1隐藏）',
  `status` char(1) DEFAULT '0' COMMENT '菜单状态（0正常 1停用）',
  `perms` varchar(100) DEFAULT NULL COMMENT '权限标识',
  `icon` varchar(100) DEFAULT '#' COMMENT '菜单图标',
  `create_by` bigint DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_by` bigint DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `del_flag` int DEFAULT '0' COMMENT '是否删除（0未删除 1已删除）',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1504082935077269507 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci  COMMENT='菜单表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_menu`
--

LOCK TABLES `sys_menu` WRITE;
/*!40000 ALTER TABLE `sys_menu` DISABLE KEYS */;
INSERT INTO `sys_menu` VALUES (0,'hello world !',NULL,NULL,'0','0','system:test:list','#',NULL,NULL,NULL,NULL,0,NULL),(1,'栏目','',NULL,'0','0','category:insert','#',NULL,NULL,NULL,NULL,0,NULL),(2,'栏目','',NULL,'0','0','category:delete','#',NULL,NULL,NULL,NULL,0,NULL),(3,'栏目','',NULL,'0','0','category:update','#',NULL,NULL,NULL,NULL,0,NULL),(4,'栏目','',NULL,'0','0','category:select','#',NULL,NULL,NULL,NULL,0,NULL);
/*!40000 ALTER TABLE `sys_menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_role`
--

DROP TABLE IF EXISTS `sys_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_role` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(128) DEFAULT NULL,
  `role_key` varchar(100) DEFAULT NULL COMMENT '角色权限字符串',
  `status` char(1) DEFAULT '0' COMMENT '角色状态（0正常 1停用）',
  `del_flag` int DEFAULT '0' COMMENT 'del_flag',
  `create_by` bigint DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_by` bigint DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci  COMMENT='角色表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_role`
--

LOCK TABLES `sys_role` WRITE;
/*!40000 ALTER TABLE `sys_role` DISABLE KEYS */;
INSERT INTO `sys_role` VALUES (1,'管理员','admin','0',0,NULL,NULL,NULL,NULL,NULL),(2,'普通用户','user','0',0,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `sys_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_role_menu`
--

DROP TABLE IF EXISTS `sys_role_menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_role_menu` (
  `role_id` bigint NOT NULL AUTO_INCREMENT COMMENT '角色ID',
  `menu_id` bigint NOT NULL DEFAULT '0' COMMENT '菜单id',
  PRIMARY KEY (`role_id`,`menu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_role_menu`
--

LOCK TABLES `sys_role_menu` WRITE;
/*!40000 ALTER TABLE `sys_role_menu` DISABLE KEYS */;
INSERT INTO `sys_role_menu` VALUES (1,0),(1,1),(1,2),(1,3),(1,4),(2,0);
/*!40000 ALTER TABLE `sys_role_menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_user`
--

DROP TABLE IF EXISTS `sys_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_user` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_name` varchar(64) NOT NULL DEFAULT 'NULL' COMMENT '用户名',
  `nick_name` varchar(64) NOT NULL DEFAULT 'NULL' COMMENT '昵称',
  `password` varchar(64) NOT NULL DEFAULT 'NULL' COMMENT '密码',
  `status` char(1) DEFAULT '0' COMMENT '账号状态（0正常 1停用）',
  `email` varchar(64) DEFAULT NULL COMMENT '邮箱',
  `phonenumber` varchar(32) DEFAULT NULL COMMENT '手机号',
  `sex` char(1) DEFAULT NULL COMMENT '用户性别（0男，1女，2未知）',
  `avatar` varchar(128) DEFAULT NULL COMMENT '头像',
  `user_type` char(1) NOT NULL DEFAULT '1' COMMENT '用户类型（0管理员，1普通用户）',
  `create_by` bigint DEFAULT NULL COMMENT '创建人的用户id',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` bigint DEFAULT NULL COMMENT '更新人',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `del_flag` int DEFAULT '0' COMMENT '删除标志（0代表未删除，1代表已删除）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci  COMMENT='用户表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_user`
--

LOCK TABLES `sys_user` WRITE;
/*!40000 ALTER TABLE `sys_user` DISABLE KEYS */;
INSERT INTO `sys_user` VALUES (1,'root','NULL','$2a$10$npv5JSeFR6/wLz8BBMmSBOMb8byg2eyfK4/vvoBk3RKtTLBhIhcpy','0','chengaoang00@gmail.com',NULL,NULL,NULL,'1',NULL,NULL,NULL,NULL,0),(2,'normal','NULL','$2a$10$UB03u1obEYNRsJXsea4ESu6NXFAd9y5bInBruHwYoppt2I3SPNU8S','0','309557269@qq.com',NULL,NULL,NULL,'0',NULL,NULL,NULL,NULL,0),(4,'234','NULL','123','0','234',NULL,NULL,NULL,'1',NULL,NULL,NULL,NULL,0);
/*!40000 ALTER TABLE `sys_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_user_role`
--

DROP TABLE IF EXISTS `sys_user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_user_role` (
  `user_id` bigint NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `role_id` bigint NOT NULL DEFAULT '0' COMMENT '角色id',
  PRIMARY KEY (`user_id`,`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_user_role`
--

LOCK TABLES `sys_user_role` WRITE;
/*!40000 ALTER TABLE `sys_user_role` DISABLE KEYS */;
INSERT INTO `sys_user_role` VALUES (1,1),(2,2);
/*!40000 ALTER TABLE `sys_user_role` ENABLE KEYS */;
UNLOCK TABLES;