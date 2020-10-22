/*
 Navicat Premium Data Transfer

 Source Server         : dev
 Source Server Type    : MySQL
 Source Server Version : 50731
 Source Host           : localhost:3306
 Source Schema         : fast-admin

 Target Server Type    : MySQL
 Target Server Version : 50731
 File Encoding         : 65001

 Date: 13/10/2020 12:30:00
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Records of auth_resource
-- ----------------------------
INSERT INTO `auth_resource` VALUES ('1', '权限管理', NULL, '#', '', 0, 'fa fa-cog', 2, '1', 0, 0, '0', 'admin', 'admin', '2019-08-30 13:36:41', '2019-08-30 16:59:14');
INSERT INTO `auth_resource` VALUES ('100', '用户管理', '1', '/auth/user', 'auth:user:view', 1, '#', 1, '1', 0, 0, '0', 'admin', 'admin', '2019-08-30 11:26:27', '2019-08-30 11:26:27');
INSERT INTO `auth_resource` VALUES ('1000', '用户查询', '100', '#', 'auth:user:list', 2, '#', 1, '1', 0, 0, '0', 'admin', 'admin', '2019-08-30 11:26:27', '2019-08-30 11:26:27');
INSERT INTO `auth_resource` VALUES ('1001', '用户新增', '100', '#', 'auth:user:add', 2, '#', 2, '1', 0, 0, '0', 'admin', 'admin', '2019-08-30 11:26:27', '2019-08-30 11:26:27');
INSERT INTO `auth_resource` VALUES ('1002', '用户修改', '100', '#', 'auth:user:edit', 2, '#', 3, '1', 0, 0, '0', 'admin', 'admin', '2019-08-30 11:26:28', '2019-08-30 11:26:28');
INSERT INTO `auth_resource` VALUES ('1003', '用户删除', '100', '#', 'auth:user:remove', 2, '#', 4, '1', 0, 0, '0', 'admin', 'admin', '2019-08-30 11:26:28', '2019-08-30 11:26:28');
INSERT INTO `auth_resource` VALUES ('1004', '用户导出', '100', '#', 'auth:user:export', 2, '#', 5, '1', 0, 0, '0', 'admin', 'admin', '2019-08-30 11:26:28', '2019-08-30 11:26:28');
INSERT INTO `auth_resource` VALUES ('1005', '用户导入', '100', '#', 'auth:user:import', 2, '#', 6, '1', 0, 0, '0', 'admin', 'admin', '2019-08-30 11:26:28', '2019-08-30 11:26:28');
INSERT INTO `auth_resource` VALUES ('1006', '重置密码', '100', '#', 'auth:user:resetPwd', 2, '#', 7, '1', 0, 0, '0', 'admin', 'admin', '2019-08-30 11:26:28', '2019-08-30 11:26:28');
INSERT INTO `auth_resource` VALUES ('1007', '角色查询', '101', '#', 'auth:role:list', 2, '#', 1, '1', 0, 0, '0', 'admin', 'admin', '2019-08-30 11:26:28', '2019-08-30 11:26:28');
INSERT INTO `auth_resource` VALUES ('1008', '角色新增', '101', '#', 'auth:role:add', 2, '#', 2, '1', 0, 0, '0', 'admin', 'admin', '2019-08-30 11:26:28', '2019-08-30 11:26:28');
INSERT INTO `auth_resource` VALUES ('1009', '角色修改', '101', '#', 'auth:role:edit', 2, '#', 3, '1', 0, 0, '0', 'admin', 'admin', '2019-08-30 11:26:28', '2019-08-30 11:26:28');
INSERT INTO `auth_resource` VALUES ('101', '角色管理', '1', '/auth/role', 'auth:role:view', 1, '#', 2, '1', 0, 0, '0', 'admin', 'admin', '2019-08-30 11:26:27', '2019-08-30 11:26:27');
INSERT INTO `auth_resource` VALUES ('1010', '角色删除', '101', '#', 'auth:role:remove', 2, '#', 4, '1', 0, 0, '0', 'admin', 'admin', '2019-08-30 11:26:28', '2019-08-30 11:26:28');
INSERT INTO `auth_resource` VALUES ('1011', '角色导出', '101', '#', 'auth:role:export', 2, '#', 5, '1', 0, 0, '0', 'admin', 'admin', '2019-08-30 11:26:28', '2019-08-30 11:26:28');
INSERT INTO `auth_resource` VALUES ('1012', '菜单查询', '102', '#', 'auth:resource:list', 2, '#', 1, '1', 0, 0, '0', 'admin', 'admin', '2019-08-30 11:26:28', '2019-08-30 11:26:28');
INSERT INTO `auth_resource` VALUES ('1013', '菜单新增', '102', '#', 'auth:resource:add', 2, '#', 2, '1', 0, 0, '0', 'admin', 'admin', '2019-08-30 11:26:28', '2019-08-30 11:26:28');
INSERT INTO `auth_resource` VALUES ('1014', '菜单修改', '102', '#', 'auth:resource:edit', 2, '#', 3, '1', 0, 0, '0', 'admin', 'admin', '2019-08-30 11:26:28', '2019-08-30 11:26:28');
INSERT INTO `auth_resource` VALUES ('1015', '菜单删除', '102', '#', 'auth:resource:remove', 2, '#', 4, '1', 0, 0, '0', 'admin', 'admin', '2019-08-30 11:26:28', '2019-08-30 11:26:28');
INSERT INTO `auth_resource` VALUES ('102', '资源管理', '1', '/auth/resource', 'auth:resource:view', 1, '#', 3, '1', 0, 0, '0', 'admin', 'admin', '2019-08-30 11:26:27', '2019-08-30 11:26:27');
INSERT INTO `auth_resource` VALUES ('1025', '字典查询', '105', '#', 'auth:dict:list', 2, '#', 1, '1', 0, 0, '1', 'admin', 'admin', '2019-08-30 14:54:06', '2019-08-30 14:54:06');
INSERT INTO `auth_resource` VALUES ('1026', '字典新增', '105', '#', 'auth:dict:add', 2, '#', 2, '1', 0, 0, '1', 'admin', 'admin', '2019-08-30 14:54:06', '2019-08-30 14:54:06');
INSERT INTO `auth_resource` VALUES ('1027', '字典修改', '105', '#', 'auth:dict:edit', 2, '#', 3, '1', 0, 0, '1', 'admin', 'admin', '2019-08-30 14:54:06', '2019-08-30 14:54:06');
INSERT INTO `auth_resource` VALUES ('1028', '字典删除', '105', '#', 'auth:dict:remove', 2, '#', 4, '1', 0, 0, '1', 'admin', 'admin', '2019-08-30 14:54:06', '2019-08-30 14:54:06');
INSERT INTO `auth_resource` VALUES ('1029', '字典导出', '105', '#', 'auth:dict:export', 2, '#', 5, '1', 0, 0, '1', 'admin', 'admin', '2019-08-30 14:54:06', '2019-08-30 14:54:06');
INSERT INTO `auth_resource` VALUES ('105', '字典管理', '1', '/auth/dictionary', 'auth:dictionary:view', 1, '#', 5, '1', 0, 0, '1', 'admin', 'admin', '2019-08-30 14:54:06', '2019-08-30 14:54:06');
INSERT INTO `auth_resource` VALUES ('2', '系统监控', NULL, '#', '', 0, 'fa fa-desktop', 2, '1', 0, 0, '1', 'admin', 'admin', '2019-08-30 14:55:51', '2019-08-30 14:55:51');


-- ----------------------------
-- Records of auth_role
-- ----------------------------
INSERT INTO `auth_role` VALUES ('740f0fe57e835e284a8a546727599e80', '操作用户', 'USER', NULL, NULL, '', '0', 'admin', 'admin', '2020-10-09 14:04:03', '2020-10-09 14:04:03');
INSERT INTO `auth_role` VALUES ('9993e995718b20e0a95a28d7005be141', '管理员', 'ADMIN', NULL, NULL, '', '0', 'admin', 'admin', '2020-09-30 17:15:08', '2020-09-30 17:15:08');


-- ----------------------------
-- Records of auth_role_resource
-- ----------------------------


-- ----------------------------
-- Records of auth_user
-- ----------------------------
INSERT INTO `auth_user` VALUES ('b6791575e4b2556ca6d4b72856e0147e', '阿酱', 'admin', '{bcrypt}$2a$10$NvWbNfbK7g7QM2MeEIb2c.EClWTfdI7P0VIYB7ch8oc5iaBJA/uJi', NULL, '704365036@qq.com', '13417830504', 0, 1, NULL, '', NULL, '2028-12-30 18:26:43', '0', 'admin', 'admin', '2020-09-30 18:05:22', '2020-10-09 13:44:59');


-- ----------------------------
-- Records of auth_user_role
-- ----------------------------
INSERT INTO `auth_user_role` VALUES ('0d45e0f0250db3dd76a52e8408104be9', 'b6791575e4b2556ca6d4b72856e0147e', '9993e995718b20e0a95a28d7005be141', 'ADMIN', '0');
INSERT INTO `auth_user_role` VALUES ('dc75fa0c9bf787697cd41198fd7558c7', 'b6791575e4b2556ca6d4b72856e0147e', '9993e995718b20e0a95a28d7005be141', 'ADMIN', NULL);

SET FOREIGN_KEY_CHECKS = 1;
