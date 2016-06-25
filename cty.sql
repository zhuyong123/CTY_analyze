/*
SQLyog Community v12.2.4 (64 bit)
MySQL - 5.6.31 : Database - cyt_analyze
*********************************************************************
*/


/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`cyt_analyze` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `cyt_analyze`;

/*Table structure for table `report` */

DROP TABLE IF EXISTS `report`;

CREATE TABLE `report` (
  `rep_name` varchar(100) NOT NULL COMMENT '报表名',
  `rep_url` varchar(100) DEFAULT NULL COMMENT 'url',
  `rep_desc` varchar(100) DEFAULT NULL COMMENT '报表描述',
  `createDate` date DEFAULT NULL COMMENT '创建时间',
  `createPerson` varchar(100) DEFAULT NULL COMMENT '创建人',
  PRIMARY KEY (`rep_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `report` */

insert  into `report`(`rep_name`,`rep_url`,`rep_desc`,`createDate`,`createPerson`) values 

('报表1','/html/baobiao1.html','baidu',NULL,NULL),

('报表2','/html/baobiao2.html','google',NULL,NULL),

('报表3','/html/baobiao3.html','sougou',NULL,NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
