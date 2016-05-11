/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50627
Source Host           : 127.0.0.1:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50627
File Encoding         : 65001

Date: 2016-04-19 17:35:02
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `order_no` varchar(16) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `busi_type` varchar(4) DEFAULT NULL,
  `amt` int(11) DEFAULT NULL,
  `remark` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of order
-- ----------------------------
INSERT INTO `order` VALUES ('1', '132345345635', '0', '0001', '800', null);
INSERT INTO `order` VALUES ('2', '122222222225', '0', '0001', '800', null);

-- ----------------------------
-- Table structure for persistent_logins
-- ----------------------------
DROP TABLE IF EXISTS `persistent_logins`;
CREATE TABLE `persistent_logins` (
  `username` varchar(64) NOT NULL,
  `series` varchar(64) NOT NULL,
  `token` varchar(64) NOT NULL,
  `last_used` date NOT NULL,
  PRIMARY KEY (`series`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of persistent_logins
-- ----------------------------

-- ----------------------------
-- Table structure for sys_authorities
-- ----------------------------
DROP TABLE IF EXISTS `sys_authorities`;
CREATE TABLE `sys_authorities` (
  `AUTHORITY_ID` varchar(32) CHARACTER SET utf8 NOT NULL,
  `AUTHORITY_NAME` varchar(40) CHARACTER SET utf8 DEFAULT NULL,
  `AUTHORITY_DESC` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `ENABLED` int(1) DEFAULT NULL,
  `ISSYS` int(1) DEFAULT NULL,
  `MODULE` varchar(4) CHARACTER SET utf8mb4 DEFAULT NULL,
  PRIMARY KEY (`AUTHORITY_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of sys_authorities
-- ----------------------------
INSERT INTO `sys_authorities` VALUES ('001', 'ROLE_ADMIN', '系统超级管理员权限', '1', '1', null);
INSERT INTO `sys_authorities` VALUES ('002', 'ROLE_USER', '普通用户权限', '1', '0', null);

-- ----------------------------
-- Table structure for sys_authorities_resources
-- ----------------------------
DROP TABLE IF EXISTS `sys_authorities_resources`;
CREATE TABLE `sys_authorities_resources` (
  `ID` bigint(13) NOT NULL,
  `AUTHORITY_ID` varchar(32) CHARACTER SET utf8 DEFAULT NULL,
  `RESOURCE_ID` varchar(32) CHARACTER SET utf8 DEFAULT NULL,
  `ENABLED` int(1) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_PUB_AUTHORITIES_RE_AU` (`AUTHORITY_ID`),
  KEY `FK_PUB_AUTHORITIES_RE_RE` (`RESOURCE_ID`),
  CONSTRAINT `FK_PUB_AUTHORITIES_RE_AU` FOREIGN KEY (`AUTHORITY_ID`) REFERENCES `sys_authorities` (`AUTHORITY_ID`),
  CONSTRAINT `FK_PUB_AUTHORITIES_RE_RE` FOREIGN KEY (`RESOURCE_ID`) REFERENCES `sys_resources` (`RESOURCE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of sys_authorities_resources
-- ----------------------------
INSERT INTO `sys_authorities_resources` VALUES ('1', '001', '001', '1');
INSERT INTO `sys_authorities_resources` VALUES ('2', '002', '002', '1');

-- ----------------------------
-- Table structure for sys_config
-- ----------------------------
DROP TABLE IF EXISTS `sys_config`;
CREATE TABLE `sys_config` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `parent_id` int(11) DEFAULT NULL,
  `catalog` int(11) DEFAULT NULL,
  `config_key` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `config_value` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `mark` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of sys_config
-- ----------------------------
INSERT INTO `sys_config` VALUES ('2', '1', '1', '1', '1', '1');
INSERT INTO `sys_config` VALUES ('3', '2', '2', '2', '2', '2');
INSERT INTO `sys_config` VALUES ('4', '1', '0', null, '007', 'aa');
INSERT INTO `sys_config` VALUES ('5', '1', '0', null, '007', 'aa');
INSERT INTO `sys_config` VALUES ('6', '1', '0', null, '007', 'aa');
INSERT INTO `sys_config` VALUES ('7', '1', '0', null, '007', 'aa');
INSERT INTO `sys_config` VALUES ('8', '1', '0', null, '007', 'aa');
INSERT INTO `sys_config` VALUES ('9', '1', '0', null, '007', 'aa');
INSERT INTO `sys_config` VALUES ('10', '1', '0', null, '007', 'aa');
INSERT INTO `sys_config` VALUES ('11', '1', '0', null, '007', 'aa');

-- ----------------------------
-- Table structure for sys_resources
-- ----------------------------
DROP TABLE IF EXISTS `sys_resources`;
CREATE TABLE `sys_resources` (
  `RESOURCE_ID` varchar(32) CHARACTER SET utf8 DEFAULT NULL,
  `RESOURCE_NAME` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `RESOURCE_DESC` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `RESOURCE_TYPE` varchar(40) CHARACTER SET utf8 DEFAULT NULL,
  `RESOURCE_STRING` varchar(200) CHARACTER SET utf8 DEFAULT NULL,
  `PRIORITY` int(1) DEFAULT NULL,
  `ENABLED` int(1) DEFAULT NULL,
  `ISSYS` int(1) DEFAULT NULL,
  `MODULE` varchar(4) CHARACTER SET utf8 DEFAULT NULL,
  KEY `RESOURCE_ID` (`RESOURCE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of sys_resources
-- ----------------------------
INSERT INTO `sys_resources` VALUES ('001', null, '管理员页面', null, '/pages/admin.jsp', null, '1', '0', null);
INSERT INTO `sys_resources` VALUES ('002', null, '应用首页', null, '/pages/test.jsp', null, '1', '0', null);

-- ----------------------------
-- Table structure for sys_roles
-- ----------------------------
DROP TABLE IF EXISTS `sys_roles`;
CREATE TABLE `sys_roles` (
  `ROLE_ID` varchar(32) CHARACTER SET utf8 NOT NULL,
  `ROLE_NAME` varchar(40) CHARACTER SET utf8 DEFAULT NULL,
  `ROLE_DESC` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `ENABLED` int(1) DEFAULT NULL,
  `ISSYS` int(1) DEFAULT NULL,
  `MODULE` varchar(4) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`ROLE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of sys_roles
-- ----------------------------
INSERT INTO `sys_roles` VALUES ('001', 'ROLE_ADMIN', '普通用户', '1', '0', null);
INSERT INTO `sys_roles` VALUES ('002', 'ROLE_USER', '系统管理员', '1', '1', null);

-- ----------------------------
-- Table structure for sys_roles_authorities
-- ----------------------------
DROP TABLE IF EXISTS `sys_roles_authorities`;
CREATE TABLE `sys_roles_authorities` (
  `ID` bigint(13) NOT NULL,
  `ROLE_ID` varchar(32) CHARACTER SET utf8 DEFAULT NULL,
  `AUTHORITY_ID` varchar(32) CHARACTER SET utf8 DEFAULT NULL,
  `ENABLED` int(1) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_PUB_ROLES_AUTHORITIES_AU` (`AUTHORITY_ID`),
  KEY `FK_PUB_ROLES_AUTHORITIES_ROLES` (`ROLE_ID`),
  CONSTRAINT `FK_PUB_ROLES_AUTHORITIES_AU` FOREIGN KEY (`AUTHORITY_ID`) REFERENCES `sys_authorities` (`AUTHORITY_ID`),
  CONSTRAINT `FK_PUB_ROLES_AUTHORITIES_ROLES` FOREIGN KEY (`ROLE_ID`) REFERENCES `sys_roles` (`ROLE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of sys_roles_authorities
-- ----------------------------
INSERT INTO `sys_roles_authorities` VALUES ('1', '001', '001', '1');
INSERT INTO `sys_roles_authorities` VALUES ('2', '002', '002', '1');

-- ----------------------------
-- Table structure for sys_users
-- ----------------------------
DROP TABLE IF EXISTS `sys_users`;
CREATE TABLE `sys_users` (
  `USER_ID` varchar(32) CHARACTER SET utf8 NOT NULL,
  `USER_ACCOUNT` varchar(30) CHARACTER SET utf8 DEFAULT NULL,
  `USER_NAME` varchar(40) CHARACTER SET utf8 DEFAULT NULL,
  `USER_PASSWORD` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `USER_DESC` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `ENABLED` int(1) DEFAULT NULL,
  `ISSYS` int(1) DEFAULT NULL,
  `USER_DEPT` varchar(20) CHARACTER SET utf8 DEFAULT NULL,
  `USER_DUTY` varchar(10) CHARACTER SET utf8 DEFAULT NULL,
  `SUB_SYSTEM` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`USER_ID`),
  UNIQUE KEY `USER_NAME` (`USER_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of sys_users
-- ----------------------------
INSERT INTO `sys_users` VALUES ('001', 'mer_account', 'admin', '21232f297a57a5a743894a0e4a801fc3', '管理员', '1', '0', '', null, null);
INSERT INTO `sys_users` VALUES ('002', 'sys_account', 'user', 'ee11cbb19052e40b07aac0ca060c23ee', '普通用户', '1', '1', '', null, null);
INSERT INTO `sys_users` VALUES ('25', 'test_account', 'test', '098f6bcd4621d373cade4e832627b4f6', null, '1', '0', null, null, null);
INSERT INTO `sys_users` VALUES ('28', 'test_account', 'haipengTest', 'e10adc3949ba59abbe56e057f20f883e', null, '1', '0', null, null, null);

-- ----------------------------
-- Table structure for sys_users_roles
-- ----------------------------
DROP TABLE IF EXISTS `sys_users_roles`;
CREATE TABLE `sys_users_roles` (
  `ID` bigint(15) NOT NULL,
  `USER_ID` varchar(32) CHARACTER SET utf8 DEFAULT NULL,
  `ROLE_ID` varchar(32) CHARACTER SET utf8 DEFAULT NULL,
  `ENABLED` int(1) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_USERS_ROLES_ROLES` (`ROLE_ID`),
  KEY `FK_USERS_ROLES_USERS` (`USER_ID`),
  CONSTRAINT `FK_USERS_ROLES_ROLES` FOREIGN KEY (`ROLE_ID`) REFERENCES `sys_roles` (`ROLE_ID`),
  CONSTRAINT `FK_USERS_ROLES_USERS` FOREIGN KEY (`USER_ID`) REFERENCES `sys_users` (`USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of sys_users_roles
-- ----------------------------
INSERT INTO `sys_users_roles` VALUES ('1', '001', '001', '1');
INSERT INTO `sys_users_roles` VALUES ('2', '002', '002', '1');
INSERT INTO `sys_users_roles` VALUES ('25', '25', '002', '1');
INSERT INTO `sys_users_roles` VALUES ('28', '28', '002', '1');

-- ----------------------------
-- Table structure for t_sequence
-- ----------------------------
DROP TABLE IF EXISTS `t_sequence`;
CREATE TABLE `t_sequence` (
  `name` varchar(50) NOT NULL,
  `current_val` int(11) NOT NULL DEFAULT '1',
  `increment` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of t_sequence
-- ----------------------------
INSERT INTO `t_sequence` VALUES ('user_id', '29', '1');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(32) CHARACTER SET utf8 DEFAULT NULL COMMENT '姓名',
  `age` int(11) DEFAULT NULL,
  `email` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '???', '26', 'chengban.ban@126.com');
INSERT INTO `user` VALUES ('2', '??', '26', 'chengban.ban@126.com');
INSERT INTO `user` VALUES ('3', 'banban', '26', 'chengban.ban@126.com');

-- ----------------------------
-- Function structure for nextVal
-- ----------------------------
DROP FUNCTION IF EXISTS `nextVal`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `nextVal`(seq_name varchar(50)) RETURNS int(11)
begin
 
declare cur_val int;
 
set cur_val = (select current_val from t_sequence where name = name);
 
update t_sequence set current_val = current_val + increment where name = name;
 
return cur_val;
 
end
;;
DELIMITER ;
