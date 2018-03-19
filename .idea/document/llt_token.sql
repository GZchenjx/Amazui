/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50716
Source Host           : localhost:3306
Source Database       : llt_token

Target Server Type    : MYSQL
Target Server Version : 50716
File Encoding         : 65001

Date: 2018-03-19 20:29:41
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(20) NOT NULL,
  `pwd` varchar(100) NOT NULL,
  `qq` varchar(20) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  `phone` char(11) DEFAULT NULL,
  `twitter` varchar(100) DEFAULT NULL,
  `intro` varchar(100) DEFAULT NULL,
  `head_image` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', '302936105@qq.com', '4QrcOUm6Wau+VuBX8g+IPg==', '302936105', '刘德华', '15818339836', '微博天下', '这是我的微博', '/static/uploads/img/ChMkJlnJyHOIaplmANMoO_mcDx0AAgyrQFjxeUA0yhT105.jpg');
