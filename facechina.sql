/*
 Navicat Premium Data Transfer

 Source Server         : FaceChina
 Source Server Type    : MySQL
 Source Server Version : 50553
 Source Host           : localhost:3306
 Source Schema         : facechina

 Target Server Type    : MySQL
 Target Server Version : 50553
 File Encoding         : 65001

 Date: 28/02/2019 15:13:17
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for friend
-- ----------------------------
DROP TABLE IF EXISTS `friend`;
CREATE TABLE `friend`  (
  `friend_id` int(11) NOT NULL AUTO_INCREMENT,
  `friend_userid` int(11) NOT NULL,
  `friend_friendid` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`friend_id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 134 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Fixed;

-- ----------------------------
-- Table structure for liuyan
-- ----------------------------
DROP TABLE IF EXISTS `liuyan`;
CREATE TABLE `liuyan`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `friend_id` int(11) NOT NULL,
  `content` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `createtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `readstate` tinyint(4) NOT NULL DEFAULT 1,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 45 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for picture
-- ----------------------------
DROP TABLE IF EXISTS `picture`;
CREATE TABLE `picture`  (
  `picture_id` int(11) NOT NULL AUTO_INCREMENT,
  `picture_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `picture_src` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`picture_id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 255 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for ping
-- ----------------------------
DROP TABLE IF EXISTS `ping`;
CREATE TABLE `ping`  (
  `ping_id` int(11) NOT NULL AUTO_INCREMENT,
  `ping_userid` int(11) NOT NULL,
  `ping_createtime` datetime NULL DEFAULT NULL,
  `ping_content` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`ping_id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 165 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for shuo
-- ----------------------------
DROP TABLE IF EXISTS `shuo`;
CREATE TABLE `shuo`  (
  `shuo_id` int(11) NOT NULL AUTO_INCREMENT,
  `shuo_text` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `shuo_createtime` datetime NOT NULL,
  `shuo_likecount` int(11) NOT NULL,
  PRIMARY KEY (`shuo_id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 96 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for shuo_picture
-- ----------------------------
DROP TABLE IF EXISTS `shuo_picture`;
CREATE TABLE `shuo_picture`  (
  `shuo_picture_id` int(11) NOT NULL AUTO_INCREMENT,
  `shuo_picture_shuoid` int(11) NOT NULL,
  `shuo_picture_pictureid` int(11) NOT NULL,
  PRIMARY KEY (`shuo_picture_id`, `shuo_picture_shuoid`, `shuo_picture_pictureid`) USING BTREE,
  INDEX `Refshuo12`(`shuo_picture_shuoid`) USING BTREE,
  INDEX `Refpicture13`(`shuo_picture_pictureid`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 65 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Fixed;

-- ----------------------------
-- Table structure for shuo_ping
-- ----------------------------
DROP TABLE IF EXISTS `shuo_ping`;
CREATE TABLE `shuo_ping`  (
  `shuo_ping_id` int(11) NOT NULL AUTO_INCREMENT,
  `shuo_ping_shuoid` int(11) NOT NULL,
  `shuo_ping_pingid` int(11) NOT NULL,
  PRIMARY KEY (`shuo_ping_id`, `shuo_ping_shuoid`, `shuo_ping_pingid`) USING BTREE,
  INDEX `Refshuo10`(`shuo_ping_shuoid`) USING BTREE,
  INDEX `Refping11`(`shuo_ping_pingid`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 59 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Fixed;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `user_id` int(11) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT,
  `user_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `user_password` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `user_salt` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_email` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `user_phonenum` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `user_gender` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_birthday` date NULL DEFAULT NULL,
  `user_age` int(11) NULL DEFAULT NULL,
  `user_star` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_colleage` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_note` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `user_createtime` datetime NULL DEFAULT NULL,
  `user_state` tinyint(4) NULL DEFAULT NULL,
  `user_pictureid` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '1',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 67 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user_picture
-- ----------------------------
DROP TABLE IF EXISTS `user_picture`;
CREATE TABLE `user_picture`  (
  `user_picture_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_picture_userid` int(11) NOT NULL,
  `user_picture_pictureid` int(11) NOT NULL,
  PRIMARY KEY (`user_picture_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 65 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for user_shuo
-- ----------------------------
DROP TABLE IF EXISTS `user_shuo`;
CREATE TABLE `user_shuo`  (
  `user_shuo_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_shuo_userid` int(11) NOT NULL,
  `user_shuo_shuoid` int(11) NOT NULL,
  PRIMARY KEY (`user_shuo_id`, `user_shuo_userid`, `user_shuo_shuoid`) USING BTREE,
  INDEX `Refuser3`(`user_shuo_userid`) USING BTREE,
  INDEX `Refshuo4`(`user_shuo_shuoid`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 101 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Fixed;

-- ----------------------------
-- Table structure for user_xiangce
-- ----------------------------
DROP TABLE IF EXISTS `user_xiangce`;
CREATE TABLE `user_xiangce`  (
  `user_xiangce_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_xiangce_userid` int(11) NOT NULL,
  `user_xiangce_xiangceid` int(11) NOT NULL,
  PRIMARY KEY (`user_xiangce_id`, `user_xiangce_userid`, `user_xiangce_xiangceid`) USING BTREE,
  INDEX `Refuser7`(`user_xiangce_userid`) USING BTREE,
  INDEX `Refxiang8`(`user_xiangce_xiangceid`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Fixed;

-- ----------------------------
-- Table structure for xiang
-- ----------------------------
DROP TABLE IF EXISTS `xiang`;
CREATE TABLE `xiang`  (
  `xiang_id` int(11) NOT NULL AUTO_INCREMENT,
  `xiang_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `xiang_picturenum` int(11) NOT NULL,
  PRIMARY KEY (`xiang_id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for xiang_picture
-- ----------------------------
DROP TABLE IF EXISTS `xiang_picture`;
CREATE TABLE `xiang_picture`  (
  `xiang_picture_id` int(11) NOT NULL AUTO_INCREMENT,
  `xiang_picture_xiangid` int(11) NOT NULL,
  `xiang_picture_pictureid` int(11) NOT NULL,
  PRIMARY KEY (`xiang_picture_id`, `xiang_picture_xiangid`, `xiang_picture_pictureid`) USING BTREE,
  INDEX `Refxiang14`(`xiang_picture_xiangid`) USING BTREE,
  INDEX `Refpicture15`(`xiang_picture_pictureid`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Fixed;

SET FOREIGN_KEY_CHECKS = 1;
