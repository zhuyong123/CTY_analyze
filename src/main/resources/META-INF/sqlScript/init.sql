/*Table structure for table `feedback` */

DROP TABLE IF EXISTS `feedback`;

CREATE TABLE `feedback` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL,
  `description` varchar(500) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Table structure for table `gp_property` */

DROP TABLE IF EXISTS `property`;

CREATE TABLE `property` (
  `name` varchar(100) NOT NULL,
  `propValue` varchar(200) NOT NULL,
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `locations` */

DROP TABLE IF EXISTS `locations`;

CREATE TABLE `locations` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `district` varchar(255) DEFAULT NULL,
  `street` varchar(255) DEFAULT NULL,
  `latitude` double DEFAULT NULL,
  `longitude` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Table structure for table `user_client_info` */

DROP TABLE IF EXISTS `user_client_info`;

CREATE TABLE `user_client_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL,
  `device_id` varchar(255) DEFAULT NULL,
  `device_name` varchar(255) DEFAULT NULL,
  `device_token` varchar(255) DEFAULT NULL,
  `network` int(11) DEFAULT NULL,
  `os` varchar(255) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `version` varchar(255) DEFAULT NULL,
  `ip` varchar(255) DEFAULT NULL,
  `uninstall` int(11) DEFAULT NULL,
  `uninstall_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Table structure for table `user_friend` */

DROP TABLE IF EXISTS `user_friend`;

CREATE TABLE `user_friend` (
  `user_id` bigint(20) DEFAULT NULL,
  `friend_id` bigint(20) DEFAULT NULL,
  `is_black` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Table structure for table `user_like` */

DROP TABLE IF EXISTS `user_like`;

CREATE TABLE `user_like` (
  `user_id` bigint(20) DEFAULT NULL,
  `target_id` bigint(20) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Table structure for table `user_setting` */

DROP TABLE IF EXISTS `user_setting`;

CREATE TABLE `user_setting` (
  `user_id` bigint(20) DEFAULT NULL,
  `TYPE` varchar(20) DEFAULT NULL,
  `VALUE` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `users` */

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(64) DEFAULT NULL,
  `account` varchar(128) DEFAULT NULL,
  `account_type` int(11) DEFAULT NULL,
  `passward` varchar(128) DEFAULT NULL,
  `nickname` varchar(50) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `gender` int(11) DEFAULT NULL,
  `icon` varchar(128) DEFAULT NULL,
  `local_id` bigint(20) DEFAULT NULL,
  `phone` varchar(50) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `is_vip` int(11) DEFAULT NULL,
  `match_icon` varchar(128) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Table structure for table `user_adress_book` */

DROP TABLE IF EXISTS `user_adress_book`;

CREATE TABLE `user_adress_book` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL,
  `phone` varchar(50) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
