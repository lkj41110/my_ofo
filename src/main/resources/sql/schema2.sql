-- 删除原来的
drop database if exists ofoproject;
-- 创建
CREATE DATABASE ofoproject DEFAULT CHARACTER SET utf8;
USE ofoproject;
-- 用户表
CREATE TABLE _user(
`id` INT NOT NULL AUTO_INCREMENT COMMENT '管理员ID',
`name` VARCHAR(50) NOT NULL COMMENT '用户名',
`password` VARCHAR(50) NOT NULL COMMENT '密码',
`phone` VARCHAR(11) NOT NULL COMMENT '手机号',
`grade` VARCHAR(3) NOT NULL DEFAULT '3' COMMENT '权限  1:admin管理员  2.管理员 3.普通用户',
`score` INT DEFAULT'0' COMMENT '积分',
`create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
`del_time` DATETIME  COMMENT '删除时间',
`update_Time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
PRIMARY KEY (`id`)
)ENGINE=INNODB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT='管理员表';

-- 自行车表
CREATE TABLE _bicycle(
`id` INT NOT NULL AUTO_INCREMENT COMMENT '自行车ID',
`address_X` INT  COMMENT '经度X',
`address_Y` INT  COMMENT '维度Y',
`password` VARCHAR(50) NOT NULL COMMENT '密码',
`status` VARCHAR(3) NOT NULL DEFAULT '4' COMMENT '自行车状态',
`create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
`del_time` DATETIME  COMMENT '删除时间',
`update_Time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
PRIMARY KEY (`id`)
)ENGINE=INNODB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT='自行车表';


-- 插入用户
INSERT INTO 
	_user(name, password, phone,grade)
VALUES
	('lk','123456', '18758114722','1'),
	('lk1','123456', '18758114721','3'),
	('lk2','123456', '18758114723','3'),
	('lk3','123456', '18758114724','3'),
	('lk4','123456', '18758114725','3');

	-- 自行车表
INSERT INTO 
	_bicycle(password)
VALUES
	('1111'),
	('2222'),
	('3333'),
	('2444');



