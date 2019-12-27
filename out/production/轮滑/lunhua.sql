create database if not exists lunhua default character set utf8;
use lunhua;

 CREATE TABLE `tb_user` (
  `id` bigint(20) auto_increment,
  `name` varchar(20) ,
  `password` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`,`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `tb_topic` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `writingDate` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `contents` text,
  `writer` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK2dojj1jjt566paskttqaqhjny` (`writer`),
  CONSTRAINT `FK2dojj1jjt566paskttqaqhjny` FOREIGN KEY (`writer`) REFERENCES `tb_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=62 DEFAULT CHARSET=utf8;

create table `tb_order` (
	`id` bigint(20) NOT NULL AUTO_INCREMENT primary key,
    orderNumber varchar(255) ,
    user_id bigint(20) ,
    constraint jj foreign key (`user_id`) references tb_user(`ID`)
);

INSERT INTO `lunhua`.`tb_order` ( `orderNumber`, `user_id`) VALUES ('单一', '13');
INSERT INTO `lunhua`.`tb_order` (`orderNumber`, `user_id`) VALUES ('蛋儿', '13');
INSERT INTO `lunhua`.`tb_order` (`orderNumber`, `user_id`) VALUES ('嗷嗷', '13');
INSERT INTO `lunhua`.`tb_order` (`orderNumber`, `user_id`) VALUES ('大多', '13');

create table tb_detail(
	`id` bigint(20) NOT NULL AUTO_INCREMENT primary key,
    love varchar(255) ,
     user_id bigint(20) ,
    constraint jdj foreign key (`user_id`) references tb_user(`ID`)
); 

INSERT INTO `lunhua`.`tb_detail` (`love`, `user_id`) VALUES ('篮球', '14');
INSERT INTO `lunhua`.`tb_detail` (`love`, `user_id`) VALUES ('羽毛球', '15');
INSERT INTO `lunhua`.`tb_detail` (`love`, `user_id`) VALUES ('大多', '21');
INSERT INTO `lunhua`.`tb_detail` (`love`, `user_id`) VALUES ('订单求', '26');
