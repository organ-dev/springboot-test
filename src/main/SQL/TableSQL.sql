/*
SQLyog Ultimate v11.33 (64 bit)
MySQL - 5.6.41 : Database - dbgril
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`dbgril` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `dbgril`;

/*Table structure for table `girl` */

DROP TABLE IF EXISTS `girl`;

CREATE TABLE `girl` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cupSize` varchar(32) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `cup_size` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `girl` */

insert  into `girl`(`id`,`cupSize`,`age`,`cup_size`) values (1,'A',12,NULL),(2,NULL,14,NULL),(3,NULL,16,NULL),(4,NULL,17,NULL),(5,NULL,11,NULL);

/*Table structure for table `pay` */

DROP TABLE IF EXISTS `pay`;

CREATE TABLE `pay` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `amt` decimal(16,2) DEFAULT NULL,
  `conment` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `pay` */

insert  into `pay`(`id`,`amt`,`conment`) values (1,'12.00',NULL),(2,'15.00',NULL),(3,'16.00',NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
