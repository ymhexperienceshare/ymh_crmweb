/*
Navicat MySQL Data Transfer

Source Server         : guigu
Source Server Version : 50173
Source Host           : localhost:3306
Source Database       : crm

Target Server Type    : MYSQL
Target Server Version : 50173
File Encoding         : 65001

Date: 2017-09-12 12:33:51
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `crm_activity`
-- ----------------------------
DROP TABLE IF EXISTS `crm_activity`;
CREATE TABLE `crm_activity` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cust_no` varchar(50) DEFAULT NULL,
  `cust_name` varchar(100) DEFAULT NULL,
  `date` date NOT NULL,
  `place` varchar(200) NOT NULL,
  `title` varchar(500) NOT NULL,
  `desc` varchar(2000) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `key_activity_cust` (`cust_no`),
  CONSTRAINT `key_activity_cust` FOREIGN KEY (`cust_no`) REFERENCES `crm_customer` (`no`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of crm_activity
-- ----------------------------
INSERT INTO `crm_activity` VALUES ('1', 'abc001', '张三', '2017-09-01', '杭州下沙', '初次交往', '吃饭');
INSERT INTO `crm_activity` VALUES ('2', 'abc002', '李四', '2017-08-21', '杭州江滨', '深入交往', '游乐场');
INSERT INTO `crm_activity` VALUES ('3', 'abc003', '王五', '2017-08-25', '杭州西湖', '准备成功', '喝茶');
INSERT INTO `crm_activity` VALUES ('5', 'abc001', '张三', '2017-08-15', '浙江滨江', '喝喝咖啡', '办公');
INSERT INTO `crm_activity` VALUES ('7', 'abc001', '张三', '2017-09-03', '浙江滨江', '签合同', '下单');
INSERT INTO `crm_activity` VALUES ('8', 'abc003', '王五', '2017-09-03', '街头', '碰面', '戴墨镜');

-- ----------------------------
-- Table structure for `crm_change`
-- ----------------------------
DROP TABLE IF EXISTS `crm_change`;
CREATE TABLE `crm_change` (
  `id` int(11) NOT NULL,
  `source` varchar(50) DEFAULT NULL,
  `cust_name` varchar(100) DEFAULT NULL,
  `title` varchar(200) DEFAULT NULL,
  `rate` int(11) DEFAULT NULL,
  `linkman` varchar(50) DEFAULT NULL,
  `tel` varchar(50) DEFAULT NULL,
  `dese` varchar(2000) DEFAULT NULL,
  `create_id` int(11) DEFAULT NULL,
  `create_by` varchar(50) DEFAULT NULL,
  `create_date` date DEFAULT NULL,
  `due_id` int(11) DEFAULT NULL,
  `due_to` varchar(50) DEFAULT NULL,
  `due_date` date DEFAULT NULL,
  `status` char(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `key_change_role_create` (`create_id`),
  KEY `key_change_role_due` (`due_id`),
  CONSTRAINT `key_change_role_create` FOREIGN KEY (`create_id`) REFERENCES `crm_role` (`id`),
  CONSTRAINT `key_change_role_due` FOREIGN KEY (`due_id`) REFERENCES `crm_role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of crm_change
-- ----------------------------
INSERT INTO `crm_change` VALUES ('1', '苹果', '小明', '苹果摊', '10', '小红', '111', '111', null, '王五', '2017-09-11', null, '王五', '2017-09-20', '1');

-- ----------------------------
-- Table structure for `crm_customer`
-- ----------------------------
DROP TABLE IF EXISTS `crm_customer`;
CREATE TABLE `crm_customer` (
  `no` varchar(50) NOT NULL,
  `name` varchar(100) NOT NULL,
  `region` varchar(50) DEFAULT NULL,
  `manager_id` int(11) DEFAULT NULL,
  `level` int(11) DEFAULT NULL,
  `level_lable` varchar(50) DEFAULT NULL,
  `satisfy` int(11) DEFAULT NULL,
  `credit` int(11) DEFAULT NULL,
  `addr` varchar(300) DEFAULT NULL,
  `zip` varchar(50) DEFAULT NULL,
  `tel` varchar(50) DEFAULT NULL,
  `fax` varchar(50) DEFAULT NULL,
  `website` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `licence_no` varchar(50) DEFAULT NULL,
  `chieftain` varchar(50) DEFAULT NULL,
  `bankroll` int(11) DEFAULT NULL,
  `turnover` int(11) DEFAULT NULL,
  `bank` varchar(200) DEFAULT NULL,
  `bank_account` varchar(50) DEFAULT NULL,
  `local_tax_no` varchar(50) DEFAULT NULL,
  `nation_tax_no` varchar(50) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`no`),
  KEY `key_customer_role` (`manager_id`),
  CONSTRAINT `key_customer_role` FOREIGN KEY (`manager_id`) REFERENCES `crm_role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of crm_customer
-- ----------------------------
INSERT INTO `crm_customer` VALUES ('abc001', '张三风', '杭州', '1', '4', null, null, null, '杭州下沙', '12332', '123', 'asdfasdf', 'sdf', 'sdf', '', '2000', '555', '交通银行', '', '', '', '2');
INSERT INTO `crm_customer` VALUES ('abc002', '李四风', '杭州', '3', '1', null, null, null, '杭州下沙', '12332', '234', '', '', '', '', null, null, '工商银行', '', '', '', '1');
INSERT INTO `crm_customer` VALUES ('abc003', '王五fff', '杭州', '1', '4', null, null, null, '杭州下沙', '12332', '345', '', '', '', '', null, null, '工商银行', '', '', '', '1');
INSERT INTO `crm_customer` VALUES ('abc004', '赵六', '中国', '1', '1', '普通客户', null, null, '浙江杭州', '', '678', '', '', '', '', null, null, '工商银行', '', '', '', '1');
INSERT INTO `crm_customer` VALUES ('abc005', '田七', '中国', '1', '1', '普通客户', null, null, '浙江杭州', '234', '567', '', '', '', '', null, null, '交通银行', '', '', '', '1');

-- ----------------------------
-- Table structure for `crm_linkman`
-- ----------------------------
DROP TABLE IF EXISTS `crm_linkman`;
CREATE TABLE `crm_linkman` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cust_no` varchar(50) NOT NULL,
  `cust_name` varchar(100) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `sex` varchar(5) DEFAULT NULL,
  `position` varchar(50) DEFAULT NULL,
  `tel` varchar(50) NOT NULL,
  `mobile` varchar(50) DEFAULT NULL,
  `memo` varchar(300) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `key_linkman_customer` (`cust_no`),
  CONSTRAINT `key_linkman_customer` FOREIGN KEY (`cust_no`) REFERENCES `crm_customer` (`no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of crm_linkman
-- ----------------------------

-- ----------------------------
-- Table structure for `crm_login`
-- ----------------------------
DROP TABLE IF EXISTS `crm_login`;
CREATE TABLE `crm_login` (
  `login_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `login_ip` varchar(20) DEFAULT NULL,
  `login_date` datetime DEFAULT NULL,
  PRIMARY KEY (`login_id`)
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of crm_login
-- ----------------------------
INSERT INTO `crm_login` VALUES ('1', '2', '127.0.0.1', '2017-09-11 08:57:56');
INSERT INTO `crm_login` VALUES ('3', '1', '127.0.0.1', '2017-09-11 08:59:24');
INSERT INTO `crm_login` VALUES ('4', '3', '127.0.0.1', '2017-09-11 08:59:41');
INSERT INTO `crm_login` VALUES ('5', '4', '127.0.0.1', '2017-09-11 08:59:56');
INSERT INTO `crm_login` VALUES ('6', '5', '127.0.0.1', '2017-09-11 09:00:13');
INSERT INTO `crm_login` VALUES ('7', '2', '127.0.0.1', '2017-09-12 08:40:01');
INSERT INTO `crm_login` VALUES ('8', '2', '127.0.0.1', '2017-09-12 09:16:46');
INSERT INTO `crm_login` VALUES ('9', '2', '127.0.0.1', '2017-09-12 09:20:50');
INSERT INTO `crm_login` VALUES ('10', '2', '127.0.0.1', '2017-09-12 09:28:11');
INSERT INTO `crm_login` VALUES ('11', '2', '127.0.0.1', '2017-09-12 09:36:56');
INSERT INTO `crm_login` VALUES ('12', '2', '127.0.0.1', '2017-09-12 09:37:25');
INSERT INTO `crm_login` VALUES ('13', '2', '127.0.0.1', '2017-09-12 09:37:48');
INSERT INTO `crm_login` VALUES ('14', '2', '127.0.0.1', '2017-09-12 09:45:26');
INSERT INTO `crm_login` VALUES ('15', '2', '127.0.0.1', '2017-09-12 09:45:58');
INSERT INTO `crm_login` VALUES ('16', '2', '127.0.0.1', '2017-09-12 09:47:07');
INSERT INTO `crm_login` VALUES ('17', '2', '127.0.0.1', '2017-09-12 09:49:13');
INSERT INTO `crm_login` VALUES ('18', '2', '127.0.0.1', '2017-09-12 09:49:52');
INSERT INTO `crm_login` VALUES ('19', '2', '127.0.0.1', '2017-09-12 09:50:30');
INSERT INTO `crm_login` VALUES ('20', '3', '127.0.0.1', '2017-09-12 09:53:23');
INSERT INTO `crm_login` VALUES ('21', '3', '127.0.0.1', '2017-09-12 09:55:47');
INSERT INTO `crm_login` VALUES ('22', '2', '127.0.0.1', '2017-09-12 09:56:26');
INSERT INTO `crm_login` VALUES ('23', '2', '127.0.0.1', '2017-09-12 09:57:53');
INSERT INTO `crm_login` VALUES ('24', '2', '127.0.0.1', '2017-09-12 10:00:15');
INSERT INTO `crm_login` VALUES ('25', '2', '127.0.0.1', '2017-09-12 10:00:39');
INSERT INTO `crm_login` VALUES ('26', '2', '127.0.0.1', '2017-09-12 10:00:57');
INSERT INTO `crm_login` VALUES ('27', '2', '127.0.0.1', '2017-09-12 10:05:06');
INSERT INTO `crm_login` VALUES ('28', '2', '127.0.0.1', '2017-09-12 10:07:18');
INSERT INTO `crm_login` VALUES ('29', '2', '127.0.0.1', '2017-09-12 10:10:15');
INSERT INTO `crm_login` VALUES ('30', '2', '127.0.0.1', '2017-09-12 10:12:15');
INSERT INTO `crm_login` VALUES ('31', '2', '127.0.0.1', '2017-09-12 10:53:23');
INSERT INTO `crm_login` VALUES ('32', '2', '127.0.0.1', '2017-09-12 10:55:15');
INSERT INTO `crm_login` VALUES ('33', '3', '127.0.0.1', '2017-09-12 10:57:27');
INSERT INTO `crm_login` VALUES ('34', '2', '127.0.0.1', '2017-09-12 10:58:26');
INSERT INTO `crm_login` VALUES ('35', '3', '127.0.0.1', '2017-09-12 11:01:28');
INSERT INTO `crm_login` VALUES ('36', '2', '127.0.0.1', '2017-09-12 11:02:40');
INSERT INTO `crm_login` VALUES ('37', '3', '127.0.0.1', '2017-09-12 11:03:20');
INSERT INTO `crm_login` VALUES ('38', '2', '127.0.0.1', '2017-09-12 11:03:51');
INSERT INTO `crm_login` VALUES ('39', '3', '127.0.0.1', '2017-09-12 11:04:35');
INSERT INTO `crm_login` VALUES ('40', '1', '127.0.0.1', '2017-09-12 11:10:51');
INSERT INTO `crm_login` VALUES ('41', '8', '127.0.0.1', '2017-09-12 11:13:04');
INSERT INTO `crm_login` VALUES ('42', '1', '127.0.0.1', '2017-09-12 11:13:30');
INSERT INTO `crm_login` VALUES ('43', '8', '127.0.0.1', '2017-09-12 11:13:54');
INSERT INTO `crm_login` VALUES ('44', '8', '127.0.0.1', '2017-09-12 11:14:46');
INSERT INTO `crm_login` VALUES ('45', '1', '127.0.0.1', '2017-09-12 11:15:31');
INSERT INTO `crm_login` VALUES ('46', '1', '127.0.0.1', '2017-09-12 11:16:25');
INSERT INTO `crm_login` VALUES ('47', '2', '127.0.0.1', '2017-09-12 11:16:42');
INSERT INTO `crm_login` VALUES ('48', '3', '127.0.0.1', '2017-09-12 11:17:13');
INSERT INTO `crm_login` VALUES ('49', '4', '127.0.0.1', '2017-09-12 11:17:37');

-- ----------------------------
-- Table structure for `crm_orders`
-- ----------------------------
DROP TABLE IF EXISTS `crm_orders`;
CREATE TABLE `crm_orders` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `custtomer` varchar(100) NOT NULL,
  `date` date NOT NULL,
  `addr` varchar(200) DEFAULT NULL,
  `status` char(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of crm_orders
-- ----------------------------
INSERT INTO `crm_orders` VALUES ('1', 'abc001', '2017-09-03', '浙江杭州', '1');
INSERT INTO `crm_orders` VALUES ('2', 'abc002', '2017-09-03', '浙江滨江', '1');
INSERT INTO `crm_orders` VALUES ('3', 'abc003', '2017-09-12', '杭州西湖', '0');

-- ----------------------------
-- Table structure for `crm_orders_line`
-- ----------------------------
DROP TABLE IF EXISTS `crm_orders_line`;
CREATE TABLE `crm_orders_line` (
  `id` int(11) NOT NULL,
  `order_id` int(11) NOT NULL,
  `prod_id` int(11) NOT NULL,
  `count` int(11) NOT NULL,
  `unit` varchar(50) DEFAULT NULL,
  `price` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `key_orders_line_orders` (`order_id`),
  KEY `key_orders_line_product` (`prod_id`),
  CONSTRAINT `key_orders_line_product` FOREIGN KEY (`prod_id`) REFERENCES `crm_product` (`id`),
  CONSTRAINT `key_orders_line_orders` FOREIGN KEY (`order_id`) REFERENCES `crm_orders` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of crm_orders_line
-- ----------------------------
INSERT INTO `crm_orders_line` VALUES ('1', '1', '1', '20', '箱', '120');
INSERT INTO `crm_orders_line` VALUES ('2', '2', '1', '23', '箱', '148');

-- ----------------------------
-- Table structure for `crm_plan`
-- ----------------------------
DROP TABLE IF EXISTS `crm_plan`;
CREATE TABLE `crm_plan` (
  `id` int(11) NOT NULL,
  `chc_id` int(11) NOT NULL,
  `date` date NOT NULL,
  `todo` varchar(500) NOT NULL,
  `result` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `key_plan_change` (`chc_id`),
  CONSTRAINT `key_plan_change` FOREIGN KEY (`chc_id`) REFERENCES `crm_change` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of crm_plan
-- ----------------------------

-- ----------------------------
-- Table structure for `crm_product`
-- ----------------------------
DROP TABLE IF EXISTS `crm_product`;
CREATE TABLE `crm_product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) NOT NULL,
  `type` varchar(100) NOT NULL,
  `batch` varchar(100) DEFAULT NULL,
  `unit` varchar(50) DEFAULT NULL,
  `price` int(11) DEFAULT NULL,
  `memo` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of crm_product
-- ----------------------------
INSERT INTO `crm_product` VALUES ('1', '苹果', '水果', '30', '箱', '20', null);

-- ----------------------------
-- Table structure for `crm_right`
-- ----------------------------
DROP TABLE IF EXISTS `crm_right`;
CREATE TABLE `crm_right` (
  `code` varchar(50) NOT NULL,
  `parent_code` varchar(50) DEFAULT NULL,
  `type` varchar(50) DEFAULT NULL,
  `text` varchar(100) DEFAULT NULL,
  `url` varchar(100) DEFAULT NULL,
  `tip` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of crm_right
-- ----------------------------
INSERT INTO `crm_right` VALUES ('0000', '10,20,30,40,50,62', 'X', '权限管理,修改所有用户信息', null, null);
INSERT INTO `crm_right` VALUES ('1111', '12,20,33,61', 'V', '销售机会;服务创建,服务分配,服务反馈,服务查询;统计报表;基础数据;密码修改', null, null);
INSERT INTO `crm_right` VALUES ('2222', '11,31,32,34,35,61', 'V', '客户开发;客户信息管理,交往记录管理;服务处理;统计报表;基础数据;密码修改', null, null);
INSERT INTO `crm_right` VALUES ('3333', '10,20,30,61', 'II', '统计报表;基础数据;密码修改', null, null);

-- ----------------------------
-- Table structure for `crm_role`
-- ----------------------------
DROP TABLE IF EXISTS `crm_role`;
CREATE TABLE `crm_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `desc` varchar(50) NOT NULL,
  `flag` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of crm_role
-- ----------------------------
INSERT INTO `crm_role` VALUES ('1', '系统管理员', '只负责维护系统', '1');
INSERT INTO `crm_role` VALUES ('2', '销售主管', '坐办公室的', '1');
INSERT INTO `crm_role` VALUES ('3', '客户经理', '干活的', '0');
INSERT INTO `crm_role` VALUES ('4', '主管', '吃瓜群众', '1');

-- ----------------------------
-- Table structure for `crm_role_right`
-- ----------------------------
DROP TABLE IF EXISTS `crm_role_right`;
CREATE TABLE `crm_role_right` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) NOT NULL,
  `role_code` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `key_mapper_role` (`role_id`),
  KEY `key_mapper_right` (`role_code`),
  CONSTRAINT `key_mapper_right` FOREIGN KEY (`role_code`) REFERENCES `crm_right` (`code`),
  CONSTRAINT `key_mapper_role` FOREIGN KEY (`role_id`) REFERENCES `crm_role` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of crm_role_right
-- ----------------------------
INSERT INTO `crm_role_right` VALUES ('1', '1', '0000');
INSERT INTO `crm_role_right` VALUES ('2', '2', '1111');
INSERT INTO `crm_role_right` VALUES ('3', '3', '2222');
INSERT INTO `crm_role_right` VALUES ('4', '4', '3333');

-- ----------------------------
-- Table structure for `crm_service`
-- ----------------------------
DROP TABLE IF EXISTS `crm_service`;
CREATE TABLE `crm_service` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `type` varchar(20) CHARACTER SET utf8 DEFAULT NULL,
  `title` varchar(500) CHARACTER SET utf8 DEFAULT NULL,
  `cust_no` char(17) CHARACTER SET utf8 DEFAULT NULL,
  `cust_name` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `status` varchar(10) CHARACTER SET utf8 DEFAULT NULL,
  `request` varchar(3000) CHARACTER SET utf8 DEFAULT NULL,
  `create_id` int(11) DEFAULT NULL,
  `create_by` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `create_date` date DEFAULT NULL,
  `due_id` int(11) DEFAULT NULL,
  `due_to` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `due_date` date DEFAULT NULL,
  `deal` varchar(3000) CHARACTER SET utf8 DEFAULT NULL,
  `deal_id` int(11) DEFAULT NULL,
  `deal_by` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `deal_date` date DEFAULT NULL,
  `result` varchar(500) CHARACTER SET utf8 DEFAULT NULL,
  `satisfy` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `key_service_customer` (`cust_no`),
  CONSTRAINT `key_service_customer` FOREIGN KEY (`cust_no`) REFERENCES `crm_customer` (`no`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=ascii;

-- ----------------------------
-- Records of crm_service
-- ----------------------------
INSERT INTO `crm_service` VALUES ('1', '咨询', '哈哈', 'abc002', '李四风', '2', '3232', '2', '李四', '2017-09-04', null, null, '2017-09-06', null, null, null, null, '购买,购买', '2');
INSERT INTO `crm_service` VALUES ('11', '1', 'heieh', 'abc003', '小红', '4', '11', '2', '李四', '2017-09-11', null, null, '2017-09-13', null, null, null, null, '购买', '5');

-- ----------------------------
-- Table structure for `crm_user`
-- ----------------------------
DROP TABLE IF EXISTS `crm_user`;
CREATE TABLE `crm_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `role_id` int(11) DEFAULT NULL,
  `flag` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `key_user_role` (`role_id`),
  CONSTRAINT `key_user_role` FOREIGN KEY (`role_id`) REFERENCES `crm_role` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of crm_user
-- ----------------------------
INSERT INTO `crm_user` VALUES ('1', '张三', 'zhangsan', '1', '1');
INSERT INTO `crm_user` VALUES ('2', '李四', 'lisi', '2', '0');
INSERT INTO `crm_user` VALUES ('3', '王五', 'wangwu', '3', '1');
INSERT INTO `crm_user` VALUES ('4', '赵六', 'zhaoliu', '3', '1');
INSERT INTO `crm_user` VALUES ('5', '田七', 'tianqi', '4', '1');
INSERT INTO `crm_user` VALUES ('8', '111', '3333', '4', '1');
