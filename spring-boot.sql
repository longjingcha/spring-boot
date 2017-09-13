# Host: 127.0.0.1  (Version 5.5.5-10.1.22-MariaDB)
# Date: 2017-09-13 17:13:25
# Generator: MySQL-Front 5.4  (Build 1.6)

/*!40101 SET NAMES utf8 */;

#
# Structure for table "user"
#

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "user"
#

INSERT INTO `user` VALUES (1,'longjingcha',18,'123456'),(2,'miaodaye',33,'123456');
