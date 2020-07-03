/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80013
 Source Host           : localhost:3306
 Source Schema         : sust

 Target Server Type    : MySQL
 Target Server Version : 80013
 File Encoding         : 65001

 Date: 03/07/2020 15:47:36
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for basic_data
-- ----------------------------
DROP TABLE IF EXISTS `basic_data`;
CREATE TABLE `basic_data`  (
  `type` smallint(10) NOT NULL COMMENT '基础数据类型',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '基础类型名称',
  `basic_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '基础数据编号',
  `basic_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '基础编号名称',
  PRIMARY KEY (`type`, `basic_code`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of basic_data
-- ----------------------------
INSERT INTO `basic_data` VALUES (1, '运动会项目', '1', '男子100米');
INSERT INTO `basic_data` VALUES (1, '运动会项目', '2', '男子200米');
INSERT INTO `basic_data` VALUES (1, '运动会项目', '3', '男子400米');
INSERT INTO `basic_data` VALUES (1, '运动会项目', '4', '男子800米');
INSERT INTO `basic_data` VALUES (1, '运动会项目', '5', '男子1500米');
INSERT INTO `basic_data` VALUES (1, '运动会项目', '6', '男子跳远');
INSERT INTO `basic_data` VALUES (1, '运动会项目', '7', '男子跳高');
INSERT INTO `basic_data` VALUES (2, '学生类型', '1', '专科');
INSERT INTO `basic_data` VALUES (2, '学生类型', '2', '本科');
INSERT INTO `basic_data` VALUES (2, '学生类型', '3', '研究生');
INSERT INTO `basic_data` VALUES (2, '学生类型', '4', '留学生');
INSERT INTO `basic_data` VALUES (2, '学生类型', '5', '交换生');
INSERT INTO `basic_data` VALUES (2, '学生类型', '6', '国防生');
INSERT INTO `basic_data` VALUES (3, '学生状态', '1', '待审批');
INSERT INTO `basic_data` VALUES (3, '学生状态', '2', '已注册');
INSERT INTO `basic_data` VALUES (3, '学生状态', '3', '已锁定');
INSERT INTO `basic_data` VALUES (4, '日志类型', '1', '学生');
INSERT INTO `basic_data` VALUES (4, '日志类型', '2', '教师');
INSERT INTO `basic_data` VALUES (4, '日志类型', '3', '超级管理员');

-- ----------------------------
-- Table structure for log
-- ----------------------------
DROP TABLE IF EXISTS `log`;
CREATE TABLE `log`  (
  `id` bigint(40) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `content` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '日志内容',
  `type` tinyint(2) NULL DEFAULT NULL COMMENT '日志类型（1：学生；2：教师；3：超级管理员）',
  `person_id` bigint(40) NULL DEFAULT NULL COMMENT '对应的人员ID',
  `person_name` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '对应的人员姓名',
  `log_time` datetime(0) NULL DEFAULT NULL COMMENT '日志时间',
  `remark` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 52 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of log
-- ----------------------------
INSERT INTO `log` VALUES (1, '系统登录', 3, 1, 'admin', '2019-09-18 15:52:03', NULL);
INSERT INTO `log` VALUES (2, '系统登录', 3, 1, 'admin', '2019-09-18 15:54:23', NULL);
INSERT INTO `log` VALUES (3, '审核学生注册通过', 3, 1, 'admin', '2019-09-18 16:05:44', NULL);
INSERT INTO `log` VALUES (4, '系统登录', 1, 2, 'wangpan', '2019-09-18 16:10:29', NULL);
INSERT INTO `log` VALUES (5, '系统登录', 1, 2, 'wangpan', '2019-09-18 16:12:50', NULL);
INSERT INTO `log` VALUES (6, '系统登录', 1, 2, 'wangpan', '2019-09-18 16:16:51', NULL);
INSERT INTO `log` VALUES (7, '系统退出', 1, 2, 'wangpan', '2019-09-18 16:16:57', NULL);
INSERT INTO `log` VALUES (8, '系统登录', 1, 2, 'wangpan', '2019-09-18 16:22:07', NULL);
INSERT INTO `log` VALUES (9, '系统退出', 1, 2, 'wangpan', '2019-09-18 16:25:41', NULL);
INSERT INTO `log` VALUES (10, '系统登录', 1, 2, 'wangpan', '2019-09-18 16:25:43', NULL);
INSERT INTO `log` VALUES (11, '系统退出', 1, 2, 'wangpan', '2019-09-18 16:29:37', NULL);
INSERT INTO `log` VALUES (12, '系统登录', 1, 2, 'wangpan', '2019-09-18 16:29:40', NULL);
INSERT INTO `log` VALUES (13, '系统退出', 1, 2, 'wangpan', '2019-09-18 16:35:34', NULL);
INSERT INTO `log` VALUES (14, '系统登录', 3, 1, 'admin', '2019-09-18 16:35:39', NULL);
INSERT INTO `log` VALUES (15, '系统退出', 3, 1, 'admin', '2019-09-18 16:36:27', NULL);
INSERT INTO `log` VALUES (16, '系统登录', 2, 2, 'teacher', '2019-09-18 16:36:30', NULL);
INSERT INTO `log` VALUES (17, '系统登录', 3, 1, 'admin', '2019-09-18 16:37:49', NULL);
INSERT INTO `log` VALUES (18, '系统登录', 3, 1, 'admin', '2019-09-18 16:43:32', NULL);
INSERT INTO `log` VALUES (19, '系统退出', 3, 1, 'admin', '2019-09-18 16:44:42', NULL);
INSERT INTO `log` VALUES (20, '系统登录', 1, 2, 'wangpan', '2019-09-18 16:44:47', NULL);
INSERT INTO `log` VALUES (21, '系统退出', 1, 2, 'wangpan', '2019-09-18 16:45:10', NULL);
INSERT INTO `log` VALUES (22, '系统登录', 3, 1, 'admin', '2019-09-18 16:45:12', NULL);
INSERT INTO `log` VALUES (23, '系统退出', 3, 1, 'admin', '2019-09-18 16:46:03', NULL);
INSERT INTO `log` VALUES (24, '系统登录', 3, 1, 'admin', '2019-09-18 16:46:05', NULL);
INSERT INTO `log` VALUES (25, '系统退出', 3, 1, 'admin', '2019-09-18 16:46:11', NULL);
INSERT INTO `log` VALUES (26, '系统登录', 1, 2, 'wangpan', '2019-09-18 16:46:19', NULL);
INSERT INTO `log` VALUES (27, '系统退出', 1, 2, 'wangpan', '2019-09-18 16:46:23', NULL);
INSERT INTO `log` VALUES (28, '系统登录', 3, 1, 'admin', '2019-09-18 16:46:26', NULL);
INSERT INTO `log` VALUES (29, '系统退出', 3, 1, 'admin', '2019-09-18 17:02:31', NULL);
INSERT INTO `log` VALUES (30, '系统登录', 1, 2, 'wangpan', '2019-09-18 17:02:32', NULL);
INSERT INTO `log` VALUES (31, '系统退出', 1, 2, 'wangpan', '2019-09-18 17:07:22', NULL);
INSERT INTO `log` VALUES (32, '系统登录', 3, 1, 'admin', '2019-09-18 17:07:25', NULL);
INSERT INTO `log` VALUES (33, '系统退出', 3, 1, 'admin', '2019-09-18 17:17:37', NULL);
INSERT INTO `log` VALUES (34, '系统登录', 1, 2, 'wangpan', '2019-09-18 17:17:39', NULL);
INSERT INTO `log` VALUES (35, '系统退出', 1, 2, 'wangpan', '2019-09-18 17:20:11', NULL);
INSERT INTO `log` VALUES (36, '系统登录', 3, 1, 'admin', '2019-09-18 17:20:13', NULL);
INSERT INTO `log` VALUES (37, '系统退出', 3, 1, 'admin', '2019-09-18 17:20:54', NULL);
INSERT INTO `log` VALUES (38, '系统登录', 1, 2, 'wangpan', '2019-09-18 17:20:56', NULL);
INSERT INTO `log` VALUES (39, '系统退出', 1, 2, 'wangpan', '2019-09-18 17:20:59', NULL);
INSERT INTO `log` VALUES (40, '系统登录', 2, 2, 'teacher', '2019-09-18 17:21:07', NULL);
INSERT INTO `log` VALUES (41, '系统退出', 2, 2, 'teacher', '2019-09-18 17:22:16', NULL);
INSERT INTO `log` VALUES (42, '系统登录', 1, 2, 'wangpan', '2019-09-18 17:22:18', NULL);
INSERT INTO `log` VALUES (43, '系统退出', 1, 2, 'wangpan', '2019-09-18 17:22:22', NULL);
INSERT INTO `log` VALUES (44, '系统登录', 2, 2, 'teacher', '2019-09-18 17:22:29', NULL);
INSERT INTO `log` VALUES (45, '系统退出', 2, 2, 'teacher', '2019-09-18 17:22:33', NULL);
INSERT INTO `log` VALUES (46, '系统登录', 3, 1, 'admin', '2019-09-18 17:22:36', NULL);
INSERT INTO `log` VALUES (47, '系统退出', 3, 1, 'admin', '2019-09-18 17:30:44', NULL);
INSERT INTO `log` VALUES (48, '系统登录', 2, 2, 'teacher', '2019-09-18 17:30:52', NULL);
INSERT INTO `log` VALUES (49, '系统登录', 2, 2, 'teacher', '2019-09-19 11:15:22', NULL);
INSERT INTO `log` VALUES (50, '系统登录', 2, 2, 'teacher', '2019-09-20 11:24:09', NULL);
INSERT INTO `log` VALUES (51, '系统退出', 2, 2, 'teacher', '2019-09-20 16:19:07', NULL);
INSERT INTO `log` VALUES (52, '系统登录', 2, 2, 'teacher', '2019-09-20 16:23:46', NULL);

-- ----------------------------
-- Table structure for score
-- ----------------------------
DROP TABLE IF EXISTS `score`;
CREATE TABLE `score`  (
  `id` bigint(40) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `student_id` bigint(40) NOT NULL COMMENT '学生id',
  `project` tinyint(4) NULL DEFAULT NULL COMMENT '比赛项目（对应基础数据表type=1）',
  `score` decimal(5, 0) NULL DEFAULT NULL COMMENT '分数',
  `ranking` smallint(5) NULL DEFAULT NULL COMMENT '排名',
  `unit` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '单位',
  `teacher_id` bigint(40) NOT NULL COMMENT '教师id',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of score
-- ----------------------------
INSERT INTO `score` VALUES (1, 7, 3, 111, 111, '米', 1, '2019-09-18 11:24:14', '111');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `id` bigint(40) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `password` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码md5加密',
  `code` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学号',
  `birthday` date NULL DEFAULT NULL COMMENT '出生日期',
  `sex` tinyint(2) NULL DEFAULT 1 COMMENT '性别（1：男；2：女）',
  `nation` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '民族',
  `college` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学院',
  `major` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '专业',
  `nationality` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '国籍',
  `entrance_date` date NULL DEFAULT NULL COMMENT '入学日期',
  `student_type` tinyint(2) NULL DEFAULT 2 COMMENT '学生类型（1：专科；2：本科；3：研究生；4：留学生；5：交换生；6：国防生）',
  `identity` varchar(18) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '身份证',
  `phone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电话',
  `native_place` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '籍贯',
  `status` tinyint(2) NULL DEFAULT 1 COMMENT '状态（1:待审批；2：已注册；3：已锁定）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES (2, 'xiaomidou', '14e1b600b1fd579f47433b88e8d85291', 'DB1001', '1987-09-11', 1, '汉族', '信息技术学院', '计算机与技术', '中国', '2018-09-11', 2, '462198188511170011', '18598764556', '北京市海淀区', 2);
INSERT INTO `student` VALUES (7, 'xiaoabu', '14e1b600b1fd579f47433b88e8d85291', 'DB1002', '1990-11-13', 2, '汉族', '信息管理学院', '计算机应用科学', '中国', '2018-09-20', 2, '110786199011130012', '18609876882', '黑龙江省哈尔滨市', 2);
INSERT INTO `student` VALUES (14, 'xiaowangxi', '14e1b600b1fd579f47433b88e8d85291', 'DB1003', '2003-05-02', 1, '汉族', '信息管理学院', '计算机应用科学', '中国', '2019-09-09', 2, '110786199011130012', '18744523665', '湖北省武汉市', 2);
INSERT INTO `student` VALUES (15, 'lxk', '14e1b600b1fd579f47433b88e8d85291', NULL, NULL, 1, NULL, NULL, NULL, NULL, NULL, 2, NULL, NULL, NULL, 2);
INSERT INTO `student` VALUES (16, 'zyt', '14e1b600b1fd579f47433b88e8d85291', NULL, NULL, 1, NULL, NULL, NULL, NULL, NULL, 2, NULL, NULL, NULL, 1);
INSERT INTO `student` VALUES (17, 'zhangsan', '14e1b600b1fd579f47433b88e8d85291', '1006', '2020-05-18', 1, '汉族', '文理学院', '物理', '中国', '2020-05-31', 2, '123456789', '123456789', '中国', 1);

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher`  (
  `id` bigint(40) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `password` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码md5加密',
  `code` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '教师编号',
  `birthday` date NULL DEFAULT NULL COMMENT '出生日期',
  `sex` tinyint(4) NULL DEFAULT 1 COMMENT '性别（1：男；2：女）',
  `phone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电话',
  `identity` varchar(18) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '身份证',
  `nation` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '民族',
  `nationality` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '国籍',
  `native_place` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '籍贯',
  `major` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '教师科目',
  `entrance_date` date NULL DEFAULT NULL COMMENT '来校时间',
  `remark` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES (1, 'admin', '14e1b600b1fd579f47433b88e8d85291', NULL, NULL, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `teacher` VALUES (2, 'xiaoliu', '14e1b600b1fd579f47433b88e8d85291', 'DBT001', '1982-09-21', 1, '18500698774', '420111177712140456', '汉族', '中国', '湖北省安陆市', '计算机应用', '2015-06-09', NULL);
INSERT INTO `teacher` VALUES (3, 'xiaobai', '14e1b600b1fd579f47433b88e8d85291', 'DBT002', '2020-06-18', 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`  (
  `userid` int(32) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `sex` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`userid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES (2, 'lxk', '4C14DFF6314535D0EEC4082BDE9D6DA5', '男');

SET FOREIGN_KEY_CHECKS = 1;
