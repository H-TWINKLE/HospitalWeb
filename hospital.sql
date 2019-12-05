/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 50622
 Source Host           : localhost:3306
 Source Schema         : hospital

 Target Server Type    : MySQL
 Target Server Version : 50622
 File Encoding         : 65001

 Date: 05/12/2019 23:04:31
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu`  (
  `menuId` int(255) NOT NULL AUTO_INCREMENT,
  `menuTitle` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `menuUrl` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `menuPlate` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`menuId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES (1, '医院信息', '/hospital', 3);
INSERT INTO `menu` VALUES (2, '动态推送', '/news', 3);
INSERT INTO `menu` VALUES (3, '用户信息', '/user', 2);
INSERT INTO `menu` VALUES (4, '挂号信息', '/guahao', 2);
INSERT INTO `menu` VALUES (5, '意见反馈', '/feedback', 3);
INSERT INTO `menu` VALUES (6, '公告', '/notice', 3);
INSERT INTO `menu` VALUES (7, '就诊情况', '/seek', 2);
INSERT INTO `menu` VALUES (9, '部门管理', '/department', 3);

SET FOREIGN_KEY_CHECKS = 1;
