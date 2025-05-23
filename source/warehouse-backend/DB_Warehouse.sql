/*
 Navicat Premium Data Transfer

 Source Server         : local
 Source Server Type    : MySQL
 Source Server Version : 80029
 Source Host           : localhost:3306
 Source Schema         : DB_Warehouse

 Target Server Type    : MySQL
 Target Server Version : 80029
 File Encoding         : 65001

 Date: 11/01/2024 14:08:37
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8_general_ci NOT NULL COMMENT '货名',
  `storage` int NOT NULL COMMENT '仓库',
  `goodsType` int NOT NULL COMMENT '分类',
  `count` int DEFAULT NULL COMMENT '数量',
  `remark` varchar(1000) CHARACTER SET utf8mb3 COLLATE utf8_general_ci DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb3 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of goods
-- ----------------------------
BEGIN;
INSERT INTO `goods` VALUES (1, 'iPhone14', 2, 2, 95, '货物不可以挤压');
INSERT INTO `goods` VALUES (4, '洁面乳', 1, 1, 1047, '货物不可以挤压');
INSERT INTO `goods` VALUES (5, '葡萄', 5, 5, 500, '货物不可以挤压');
INSERT INTO `goods` VALUES (6, '西红柿', 5, 6, 800, '货物不可以挤压');
INSERT INTO `goods` VALUES (7, '皮皮虾', 4, 4, 500, '货物不可以挤压');
INSERT INTO `goods` VALUES (8, 'AD钙', 3, 3, 400, '货物不可以挤压');
INSERT INTO `goods` VALUES (11, 'iPad Air5', 2, 2, 800, '货物不可以挤压');
INSERT INTO `goods` VALUES (12, '旺仔牛奶', 3, 3, 1550, '');
COMMIT;

-- ----------------------------
-- Table structure for goodstype
-- ----------------------------
DROP TABLE IF EXISTS `goodstype`;
CREATE TABLE `goodstype` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8_general_ci NOT NULL COMMENT '分类名',
  `remark` varchar(1000) CHARACTER SET utf8mb3 COLLATE utf8_general_ci DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb3 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of goodstype
-- ----------------------------
BEGIN;
INSERT INTO `goodstype` VALUES (1, '日用品', '日常生活用品');
INSERT INTO `goodstype` VALUES (2, '数码产品', '数码产品');
INSERT INTO `goodstype` VALUES (3, '食品', '食品');
INSERT INTO `goodstype` VALUES (4, '冷冻品', '冷冻食品');
INSERT INTO `goodstype` VALUES (5, '水果', '水果产品');
INSERT INTO `goodstype` VALUES (6, '蔬菜', '蔬菜产品');
INSERT INTO `goodstype` VALUES (7, '测试', '1');
COMMIT;

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
  `id` int NOT NULL COMMENT '主键',
  `menuCode` varchar(8) CHARACTER SET utf8mb3 COLLATE utf8_general_ci DEFAULT NULL COMMENT '菜单编码',
  `menuName` varchar(16) CHARACTER SET utf8mb3 COLLATE utf8_general_ci DEFAULT NULL COMMENT '菜单名字',
  `menuLevel` varchar(2) CHARACTER SET utf8mb3 COLLATE utf8_general_ci DEFAULT NULL COMMENT '菜单级别',
  `menuParentCode` varchar(8) CHARACTER SET utf8mb3 COLLATE utf8_general_ci DEFAULT NULL COMMENT '菜单的父code',
  `menuClick` varchar(16) CHARACTER SET utf8mb3 COLLATE utf8_general_ci DEFAULT NULL COMMENT '点击触发的函数',
  `menuRight` varchar(8) CHARACTER SET utf8mb3 COLLATE utf8_general_ci DEFAULT NULL COMMENT '权限 0超级管理员，1表示管理员，2表示普通用户，可以用逗号组合使用',
  `menuComponent` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8_general_ci DEFAULT NULL COMMENT '对应Vue菜单组件',
  `menuIcon` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8_general_ci DEFAULT NULL COMMENT '菜单图标',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of menu
-- ----------------------------
BEGIN;
INSERT INTO `menu` VALUES (1, '001', '管理员信息管理', '1', NULL, 'Admin', '0', 'admin/AdminManage.vue', 'iconfont  icon-admin-menu');
INSERT INTO `menu` VALUES (2, '002', '用户信息管理', '1', NULL, 'User', '0,1', 'user/UserManage.vue', 'iconfont icon-login-logo');
INSERT INTO `menu` VALUES (3, '003', '仓库信息管理', '1', NULL, 'Storage', '0,1', 'storage/StorageManage', 'iconfont icon-warehouse-menu');
INSERT INTO `menu` VALUES (4, '004', '物品分类管理', '1', NULL, 'Goodstype', '0,1', 'goodstype/GoodstypeManage', 'iconfont icon-good-type-menu');
INSERT INTO `menu` VALUES (5, '005', '物品信息管理 ', '1', NULL, 'Goods', '0,1,2', 'goods/GoodsManage', 'iconfont icon-good-info-menu');
INSERT INTO `menu` VALUES (6, '006', '操作日志', '1', NULL, 'Record', '0,1,2', 'record/RecordManage', 'iconfont icon-log-menu');
COMMIT;

-- ----------------------------
-- Table structure for record
-- ----------------------------
DROP TABLE IF EXISTS `record`;
CREATE TABLE `record` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `goods` int NOT NULL COMMENT '货品id',
  `userId` int DEFAULT NULL COMMENT '取货人/补货人',
  `admin_id` int DEFAULT NULL COMMENT '操作人id',
  `count` int DEFAULT NULL COMMENT '数量',
  `createtime` datetime DEFAULT NULL COMMENT '操作时间',
  `remark` varchar(1000) CHARACTER SET utf8mb3 COLLATE utf8_general_ci DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb3 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of record
-- ----------------------------
BEGIN;
INSERT INTO `record` VALUES (1, 1, 3, 2, 100, '2023-01-06 20:46:48', '取货');
INSERT INTO `record` VALUES (12, 1, 3, 1, -5, '2023-01-19 15:32:27', '');
INSERT INTO `record` VALUES (15, 4, 3, 1, 100, '2023-06-11 21:08:13', '');
INSERT INTO `record` VALUES (16, 4, 3, 1, -50, '2023-06-11 21:08:25', '');
INSERT INTO `record` VALUES (17, 4, 3, 1, 100, '2023-06-11 21:17:24', '');
INSERT INTO `record` VALUES (18, 4, 3, 1, -200, '2023-06-11 21:17:33', '');
INSERT INTO `record` VALUES (19, 4, 3, 1, 100, '2023-08-06 11:15:11', '');
COMMIT;

-- ----------------------------
-- Table structure for storage
-- ----------------------------
DROP TABLE IF EXISTS `storage`;
CREATE TABLE `storage` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8_general_ci NOT NULL COMMENT '仓库名',
  `remark` varchar(1000) CHARACTER SET utf8mb3 COLLATE utf8_general_ci DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb3 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of storage
-- ----------------------------
BEGIN;
INSERT INTO `storage` VALUES (1, '日用品仓库', '用于存放日用品');
INSERT INTO `storage` VALUES (2, '数码仓库', '用于存放数码产品');
INSERT INTO `storage` VALUES (3, '食品仓库', '用于存放食品');
INSERT INTO `storage` VALUES (4, '冷冻仓库', '用于存放冷冻食品');
INSERT INTO `storage` VALUES (5, '果蔬仓库', '用于存放水果和蔬菜');
INSERT INTO `storage` VALUES (6, '服装仓库', '用于存放服装');
INSERT INTO `storage` VALUES (7, '水产仓库', '用于存放水产品');
COMMIT;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `no` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8_general_ci DEFAULT NULL COMMENT '账号',
  `name` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8_general_ci NOT NULL COMMENT '名字',
  `password` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `age` int DEFAULT NULL COMMENT '年龄',
  `sex` int DEFAULT NULL COMMENT '性别',
  `phone` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8_general_ci DEFAULT NULL COMMENT '电话',
  `role_id` int DEFAULT NULL COMMENT '角色 0超级管理员，1管理员，2普通账号',
  `isValid` varchar(4) CHARACTER SET utf8mb3 COLLATE utf8_general_ci DEFAULT 'Y' COMMENT '是否有效，Y有效，其他无效',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb3 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of user
-- ----------------------------
BEGIN;
INSERT INTO `user` VALUES (1, 'superadmin', '超级管理', '123456', 18, 1, '18855079621', 0, 'Y');
INSERT INTO `user` VALUES (2, 'admin', '管理员', '123456', 19, 0, '18855079621', 1, 'Y');
INSERT INTO `user` VALUES (3, 'user', '普通用户', '123456', 23, 0, '13333333333', 2, 'Y');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
