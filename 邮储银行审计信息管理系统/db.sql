/*
SQLyog 企业版 - MySQL GUI v8.14 
MySQL - 5.6.23-log : Database - shenji
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`shenji` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `shenji`;

/*Table structure for table `admin` */

DROP TABLE IF EXISTS `admin`;

CREATE TABLE `admin` (
  `adminId` int(8) NOT NULL AUTO_INCREMENT COMMENT '审计员编号',
  `adminName` varchar(20) NOT NULL COMMENT '审计员用户名',
  `adminPass` varchar(20) NOT NULL COMMENT '审计员登录密码',
  `adminType` varchar(20) NOT NULL COMMENT '审计员级别',
  `adminPic` varchar(200) NOT NULL COMMENT '员审计头像路径',
  PRIMARY KEY (`adminId`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

/*Data for the table `admin` */

insert  into `admin`(`adminId`,`adminName`,`adminPass`,`adminType`,`adminPic`) values (1,'admin','admin','1','upload_img/file_1488594213903.png'),(2,'6','1','1','upload_img/file_1488624057222.png'),(3,'3','3','0','upload_img/file_1488624983727.png'),(4,'4','4','0','upload_img/file_1488625093343.png'),(5,'5','7','0','upload_img/file_1488625211560.png'),(6,'7','7','普通员工','upload_img/file_1488626714235.png'),(7,'admin1','admin','普通员工','upload_img/file_1488686250797.png'),(8,'admin2','admin','普通员工','upload_img/file_1488686612920.png'),(9,'admin3','admin','普通员工','upload_img/file_1488687447947.png'),(10,'admin6','admin','普通员工','upload_img/file_1488879847356.png');

/*Table structure for table `fangan` */

DROP TABLE IF EXISTS `fangan`;

CREATE TABLE `fangan` (
  `fangAnId` int(8) NOT NULL AUTO_INCREMENT COMMENT '方案编号',
  `danWeiName` varchar(20) NOT NULL COMMENT '单位名称',
  `projectId` int(8) NOT NULL COMMENT '相关项目',
  `shenJiYiJu` varchar(255) NOT NULL COMMENT '审计依据',
  `startTime` date DEFAULT NULL COMMENT '会计期间',
  `endTime` date DEFAULT NULL COMMENT '会计结束时间',
  `fangAnContent` varchar(255) NOT NULL COMMENT '审计内容',
  `fangUrl` varchar(255) DEFAULT NULL COMMENT '审计清单地址',
  `res` varchar(20) DEFAULT '不通过' COMMENT '结果',
  `adminId` int(8) DEFAULT NULL COMMENT '对应的项目负责人',
  PRIMARY KEY (`fangAnId`),
  KEY `FK_fangan` (`projectId`),
  KEY `FK_fangan2` (`adminId`),
  CONSTRAINT `FK_fangan` FOREIGN KEY (`projectId`) REFERENCES `project` (`projectId`),
  CONSTRAINT `FK_fangan2` FOREIGN KEY (`adminId`) REFERENCES `admin` (`adminId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `fangan` */

insert  into `fangan`(`fangAnId`,`danWeiName`,`projectId`,`shenJiYiJu`,`startTime`,`endTime`,`fangAnContent`,`fangUrl`,`res`,`adminId`) values (1,'1',1,'1','2016-01-01','2016-01-01','1','1','不通过',1),(2,'1',1,'1','2016-01-01','2016-01-01','1','1','通过',1),(3,'1',1,'1','2016-01-01','2016-01-01','1','1','不通过',2),(4,'1',1,'1','2016-01-01','2016-01-01','1','1','不通过',1);

/*Table structure for table `info` */

DROP TABLE IF EXISTS `info`;

CREATE TABLE `info` (
  `infoId` int(8) NOT NULL AUTO_INCREMENT COMMENT '通知书编号',
  `infoTitle` varchar(20) DEFAULT NULL COMMENT '通知书标题',
  `infoTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '发出时间',
  `forBook` varchar(20) DEFAULT NULL COMMENT '授权书名字',
  `forBookUrl` varchar(200) DEFAULT NULL COMMENT '授权书路劲',
  `state` varchar(10) DEFAULT '未通过' COMMENT '通知书状态',
  `projectId` int(8) DEFAULT NULL COMMENT '相关项目编号',
  PRIMARY KEY (`infoId`),
  KEY `FK_info` (`projectId`),
  CONSTRAINT `FK_info` FOREIGN KEY (`projectId`) REFERENCES `project` (`projectId`)
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8;

/*Data for the table `info` */

insert  into `info`(`infoId`,`infoTitle`,`infoTime`,`forBook`,`forBookUrl`,`state`,`projectId`) values (1,'1','2017-03-04 18:16:12','1','1','未通过',1),(2,'2','2017-03-04 18:16:33','2','2','未通过',2),(3,'3','2017-03-05 02:14:43','3','3','通过',3),(18,NULL,'2017-03-05 04:11:19',NULL,NULL,'未通过',9),(19,NULL,'2017-03-05 04:13:59',NULL,NULL,'通过',NULL),(22,NULL,'2017-03-05 04:36:38',NULL,NULL,'未通过',11),(23,NULL,'2017-03-05 04:36:56',NULL,NULL,'通过',NULL),(24,NULL,'2017-03-05 04:39:38',NULL,NULL,'通过',NULL),(25,NULL,'2017-03-05 04:57:12',NULL,NULL,'通过',NULL),(26,NULL,'2017-03-05 04:59:03',NULL,NULL,'通过',NULL),(27,NULL,'2017-03-05 04:59:30',NULL,NULL,'通过',NULL),(28,NULL,'2017-03-05 05:09:32',NULL,NULL,'通过',NULL),(29,NULL,'2017-03-05 05:14:08',NULL,NULL,'通过',NULL),(30,NULL,'2017-03-05 05:18:26',NULL,NULL,'通过',NULL),(31,NULL,'2017-03-05 05:18:30',NULL,NULL,'通过',NULL),(32,NULL,'2017-03-05 05:21:49',NULL,NULL,'通过',NULL),(33,NULL,'2017-03-05 05:23:49',NULL,NULL,'通过',NULL),(34,NULL,'2017-03-05 05:24:03',NULL,NULL,'通过',NULL),(35,NULL,'2017-03-05 05:24:41',NULL,NULL,'通过',NULL),(36,NULL,'2017-03-05 05:26:49',NULL,NULL,'通过',NULL),(37,NULL,'2017-03-05 05:28:16',NULL,NULL,'通过',NULL),(38,NULL,'2017-03-05 05:30:00',NULL,NULL,'通过',NULL),(39,NULL,'2017-03-05 05:33:34',NULL,NULL,'通过',NULL),(40,NULL,'2017-03-05 05:35:59',NULL,NULL,'通过',NULL),(41,NULL,'2017-03-05 05:40:17',NULL,NULL,'通过',NULL),(42,NULL,'2017-03-05 05:41:06',NULL,NULL,'通过',NULL),(43,NULL,'2017-03-05 12:08:08',NULL,NULL,'未通过',12),(44,NULL,'2017-03-07 01:57:35',NULL,NULL,'未通过',13),(45,NULL,'2017-03-07 02:15:47',NULL,NULL,'未通过',14),(47,NULL,'2017-03-07 18:04:31',NULL,NULL,NULL,NULL);

/*Table structure for table `meeting` */

DROP TABLE IF EXISTS `meeting`;

CREATE TABLE `meeting` (
  `meetingId` int(8) NOT NULL AUTO_INCREMENT COMMENT '会议编号',
  `meetingTime` date NOT NULL COMMENT '会议时间',
  `meetingAdminId` int(8) NOT NULL COMMENT '会议负责人',
  `meetingAdress` varchar(20) NOT NULL COMMENT '会议地点',
  PRIMARY KEY (`meetingId`),
  KEY `FK_meeting` (`meetingAdminId`),
  CONSTRAINT `FK_meeting` FOREIGN KEY (`meetingAdminId`) REFERENCES `admin` (`adminId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `meeting` */

/*Table structure for table `project` */

DROP TABLE IF EXISTS `project`;

CREATE TABLE `project` (
  `projectId` int(8) NOT NULL AUTO_INCREMENT COMMENT '项目编号',
  `projectName` varchar(20) NOT NULL COMMENT '项目名字',
  `projectContent` varchar(255) DEFAULT NULL COMMENT '项目简单描述',
  `projectAdmin` int(8) DEFAULT NULL COMMENT '项目审核负责人',
  `projectState` varchar(20) DEFAULT '未开启' COMMENT '项目状态',
  `startDate` date DEFAULT NULL COMMENT '开启时间',
  `endDate` date DEFAULT NULL COMMENT '结束时间',
  `shenQingUrl` varchar(100) NOT NULL COMMENT '申请书路劲',
  `ifopr` varchar(100) DEFAULT '未审' COMMENT '是否审批过',
  `baseEn` varchar(255) DEFAULT NULL COMMENT '基本情况',
  `baseInfo` varchar(255) DEFAULT NULL COMMENT '基本情况介绍',
  `baseFz` varchar(255) DEFAULT NULL COMMENT '基本辅助信息',
  `baseWay` varchar(255) DEFAULT '主审评估' COMMENT '基本实现方式',
  `ProEn` varchar(255) DEFAULT NULL COMMENT '进展情况',
  `ProInfo` varchar(255) DEFAULT NULL COMMENT '进展介绍',
  `ProFz` varchar(255) DEFAULT NULL COMMENT '进展辅助信息',
  `ProWay` varchar(255) DEFAULT '主审评估' COMMENT '进展实现方式',
  `baseUrl` varchar(255) DEFAULT NULL COMMENT '基本情况',
  `ProUrl` varchar(255) DEFAULT NULL COMMENT '进展情况',
  PRIMARY KEY (`projectId`),
  KEY `FK_project` (`projectAdmin`),
  CONSTRAINT `FK_project` FOREIGN KEY (`projectAdmin`) REFERENCES `admin` (`adminId`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

/*Data for the table `project` */

insert  into `project`(`projectId`,`projectName`,`projectContent`,`projectAdmin`,`projectState`,`startDate`,`endDate`,`shenQingUrl`,`ifopr`,`baseEn`,`baseInfo`,`baseFz`,`baseWay`,`ProEn`,`ProInfo`,`ProFz`,`ProWay`,`baseUrl`,`ProUrl`) values (1,'枯','1',1,'未开启','2016-01-01','2016-01-11','2','未审',NULL,NULL,NULL,'主审评估',NULL,NULL,NULL,'主审评估',NULL,NULL),(2,'2','2',2,'未开启','2016-01-01','2016-01-01','2','未审',NULL,NULL,NULL,'主审评估',NULL,NULL,NULL,'主审评估',NULL,NULL),(3,'3','3',3,'进行中','2017-02-28',NULL,'2','已审',NULL,NULL,NULL,'主审评估',NULL,NULL,NULL,'主审评估',NULL,NULL),(9,'4','4',1,'为开启',NULL,NULL,'申报书','未审',NULL,NULL,NULL,'主审评估',NULL,NULL,NULL,'主审评估',NULL,NULL),(11,'5','5',3,'未开启','2017-02-28',NULL,'申报书','未审',NULL,NULL,NULL,'主审评估',NULL,NULL,NULL,'主审评估',NULL,NULL),(12,'2','2',8,'未开启','2017-02-28',NULL,'申报书/file_1488686888129.txt','未审',NULL,NULL,NULL,'主审评估',NULL,NULL,NULL,'主审评估',NULL,NULL),(13,'x','x',2,'未开启','2017-03-02',NULL,'申报书/file_1488823055652.png','未审','x','x','x','x','x','x','x','x','C:\\Program Files\\Apache Software Foundation\\Tomcat 7.0\\webapps\\ShenJi\\申报书1','C:\\Program Files\\Apache Software Foundation\\Tomcat 7.0\\webapps\\ShenJi\\申报书2'),(14,'s','s',2,'未开启','2017-03-02',NULL,'申报书/file_1488824147244.png','未审','s','s','s','s','s','s','s','s','C:\\Program Files\\Apache Software Foundation\\Tomcat 7.0\\webapps\\ShenJi\\申报书1','C:\\Program Files\\Apache Software Foundation\\Tomcat 7.0\\webapps\\ShenJi\\申报书2');

/*Table structure for table `report` */

DROP TABLE IF EXISTS `report`;

CREATE TABLE `report` (
  `reportId` int(8) NOT NULL AUTO_INCREMENT COMMENT '审计报告',
  `suggest` varchar(20) NOT NULL COMMENT '审计意见',
  `content` varchar(255) DEFAULT NULL COMMENT '审计内容',
  `guiDang` varchar(20) DEFAULT '未归档' COMMENT '审计归档',
  `sugUrl` varchar(100) DEFAULT NULL COMMENT '审计意见书',
  `tzUrl` varchar(100) DEFAULT NULL COMMENT '台账报表',
  PRIMARY KEY (`reportId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `report` */

insert  into `report`(`reportId`,`suggest`,`content`,`guiDang`,`sugUrl`,`tzUrl`) values (1,'6','6','6','审计意见书/file_1488851248804.png','台账报表/file_1488851248809.png');

/*Table structure for table `xcsj` */

DROP TABLE IF EXISTS `xcsj`;

CREATE TABLE `xcsj` (
  `xcSheJ` int(8) NOT NULL AUTO_INCREMENT COMMENT '现场审计编号',
  `xcShenJtitle` varchar(20) NOT NULL COMMENT '现场审计内容',
  `xcFind` varchar(255) NOT NULL COMMENT '现场审计发现',
  `question` varchar(255) NOT NULL COMMENT '发现的问题',
  `url` varchar(100) NOT NULL COMMENT '现场结算报表',
  PRIMARY KEY (`xcSheJ`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `xcsj` */

/*Table structure for table `zhishiku` */

DROP TABLE IF EXISTS `zhishiku`;

CREATE TABLE `zhishiku` (
  `zhiShiId` int(8) NOT NULL AUTO_INCREMENT COMMENT '知识编号',
  `shiShiTitle` varchar(20) NOT NULL COMMENT '知识专题',
  `zhishiContent` varchar(255) NOT NULL COMMENT '专题内容',
  `publishTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '发表时间',
  `author` varchar(20) DEFAULT NULL COMMENT '作者',
  PRIMARY KEY (`zhiShiId`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `zhishiku` */

insert  into `zhishiku`(`zhiShiId`,`shiShiTitle`,`zhishiContent`,`publishTime`,`author`) values (1,'1','1','2017-03-04 15:24:36','1'),(2,'2','2','2017-03-04 15:45:56','2'),(3,'3','3','2017-03-04 15:46:02','3'),(4,'3','4','2017-03-04 15:46:08','4'),(5,'5','5','2017-03-04 15:46:11','5');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
