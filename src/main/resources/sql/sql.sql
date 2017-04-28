-- 删除原来的
DROP DATABASE IF EXISTS ofoproject;
-- 创建
CREATE DATABASE ofoproject
  DEFAULT CHARACTER SET utf8;
USE ofoproject;
-- 用户表
CREATE TABLE _user (
  `id`          INT         NOT NULL AUTO_INCREMENT
  COMMENT '管理员ID',
  `name`        VARCHAR(50) NOT NULL
  COMMENT '用户名',
  `name2`       VARCHAR(50)
  COMMENT '真实姓名',
  `password`    VARCHAR(50) NOT NULL
  COMMENT '密码',
  `phone`       VARCHAR(11) NOT NULL
  COMMENT '手机号',
  `id_card`     VARCHAR(20) COMMENT '身份证',
  `grade`       VARCHAR(3)  NOT NULL DEFAULT '3'
  COMMENT '权限  1:admin管理员  2.管理员 3.普通用户',
  `score`       INT                  DEFAULT '0'
  COMMENT '积分',
  `create_time` TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP
  COMMENT '创建时间',
  `del_time`    DATETIME COMMENT '删除时间',
  `update_Time` TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP
  COMMENT '更新时间',
  PRIMARY KEY (`id`)
)
  ENGINE = INNODB
  AUTO_INCREMENT = 1000
  DEFAULT CHARSET = utf8
  COMMENT = '管理员表';

-- 用户个人资料表
CREATE TABLE _user2 (
  `id`          INT        NOT NULL
  COMMENT '用户ID',
  `photo`       VARCHAR(2) COMMENT '头像',
  `sex`         VARCHAR(2)
  COMMENT '性别',
  cash          VARCHAR(2) NOT NULL
  COMMENT '压金'                      DEFAULT '2',
  `hobby`       TEXT
  COMMENT '爱好',
  `create_time` TIMESTAMP  NOT NULL DEFAULT CURRENT_TIMESTAMP
  COMMENT '创建时间',
  `del_time`    DATETIME COMMENT '删除时间',
  `update_time` TIMESTAMP  NOT NULL DEFAULT CURRENT_TIMESTAMP
  COMMENT '更新时间',
  PRIMARY KEY (`id`),
  FOREIGN KEY (`id`) REFERENCES _user (`id`)
)
  ENGINE = INNODB
  AUTO_INCREMENT = 1000
  DEFAULT CHARSET = utf8
  COMMENT = '资料表';

-- 自行车表
CREATE TABLE _bicycle (
  `id`          INT         NOT NULL
  COMMENT '自行车ID',
  `address_X`   VARCHAR(10) COMMENT '经度X',
  `address_Y`   VARCHAR(10) COMMENT '维度Y',
  `password`    VARCHAR(50) NOT NULL
  COMMENT '密码',
  `status`      VARCHAR(3)  NOT NULL DEFAULT '4'
  COMMENT '自行车状态',
  `create_time` TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP
  COMMENT '创建时间',
  `del_time`    DATETIME COMMENT '删除时间',
  `update_Time` TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP
  COMMENT '更新时间',
  PRIMARY KEY (`id`)
)
  ENGINE = INNODB
  DEFAULT CHARSET = utf8
  COMMENT = '自行车表';

-- 自行车损坏表
CREATE TABLE _destroy_bicycle (
  `id`          INT        NOT NULL
  COMMENT 'id',
  `number`      INT        NOT NULL DEFAULT 0
  COMMENT '次数',
  `status`      VARCHAR(3) NOT NULL DEFAULT '0'
  COMMENT '自行车损坏状态',
  `address_X`   VARCHAR(10) COMMENT '经度X',
  `address_Y`   VARCHAR(10) COMMENT '维度Y',
  `create_time` TIMESTAMP  NOT NULL DEFAULT CURRENT_TIMESTAMP
  COMMENT '创建时间',
  `del_time`    DATETIME COMMENT '删除时间',
  `update_Time` TIMESTAMP  NOT NULL DEFAULT CURRENT_TIMESTAMP
  COMMENT '更新时间',
  PRIMARY KEY (`id`),
  FOREIGN KEY (`id`) REFERENCES _bicycle (`id`)
)
  ENGINE = INNODB
  DEFAULT CHARSET = utf8
  COMMENT = '自行车损坏表';

-- 订单表
CREATE TABLE _order (
  `id`          INT        NOT NULL AUTO_INCREMENT
  COMMENT '订单ID',
  `user_id`     INT        NOT NULL
  COMMENT '用户id',
  `bicycle_id`  INT        NOT NULL
  COMMENT '车辆id',
  `start_time`  DATETIME COMMENT '创建订单时间',
  `end_time`    DATETIME COMMENT '结束订单时间',
  `cost`        DOUBLE(5, 2) COMMENT '费用',
  `start_X`     VARCHAR(10) COMMENT '开始的x',
  `start_y`     VARCHAR(10) COMMENT '开始的x',
  `end_X`       VARCHAR(10) COMMENT '结束的x',
  `end_Y`       VARCHAR(10) COMMENT '结束的y',
  `status`      VARCHAR(3) NOT NULL DEFAULT '0'
  COMMENT '结算状态',
  `create_time` TIMESTAMP  NOT NULL DEFAULT CURRENT_TIMESTAMP
  COMMENT '创建时间',
  `del_time`    DATETIME COMMENT '删除时间',
  `update_Time` TIMESTAMP  NOT NULL DEFAULT CURRENT_TIMESTAMP
  COMMENT '更新时间',
  PRIMARY KEY (`id`),
  FOREIGN KEY (`user_id`) REFERENCES _user (`id`),
  FOREIGN KEY (`bicycle_id`) REFERENCES _bicycle (`id`)
)
  ENGINE = INNODB
  AUTO_INCREMENT = 1000
  DEFAULT CHARSET = utf8
  COMMENT = '订单表';

-- 维修表
CREATE TABLE _maintain (
  `id`          INT        NOT NULL AUTO_INCREMENT
  COMMENT '维修id',
  `bicycle_id`  INT        NOT NULL
  COMMENT '车辆id',
  `name`        VARCHAR(10) COMMENT '维修的人员',
  `start_time`  DATETIME COMMENT '创建时间',
  `end_time`    DATETIME COMMENT '结束时间',
  `start_X`     VARCHAR(10) COMMENT '开始的x',
  `start_Y`     VARCHAR(10) COMMENT '开始的x',
  `status`      VARCHAR(3) NOT NULL DEFAULT '0'
  COMMENT '结算状态',
  `create_time` TIMESTAMP  NOT NULL DEFAULT CURRENT_TIMESTAMP
  COMMENT '创建时间',
  `del_time`    DATETIME COMMENT '删除时间',
  `update_Time` TIMESTAMP  NOT NULL DEFAULT CURRENT_TIMESTAMP
  COMMENT '更新时间',
  PRIMARY KEY (`id`),
  FOREIGN KEY (`bicycle_id`) REFERENCES _bicycle (`id`)
)
  ENGINE = INNODB
  AUTO_INCREMENT = 1000
  DEFAULT CHARSET = utf8
  COMMENT = '维修表';

-- 消息表
CREATE TABLE _message (
  `id`          INT        NOT NULL AUTO_INCREMENT
  COMMENT '订单ID',
  `from_user`   INT        NOT NULL
  COMMENT '发出的user',
  `to_user`     INT        NOT NULL
  COMMENT '收到的user',
  `title`       TEXT       NOT NULL
  COMMENT '标题',
  `content`     TEXT       NOT NULL
  COMMENT '内容',
  `status`      VARCHAR(3) NOT NULL DEFAULT '0'
  COMMENT '阅读状态',
  `create_time` TIMESTAMP  NOT NULL DEFAULT CURRENT_TIMESTAMP
  COMMENT '创建时间',
  `del_time`    DATETIME COMMENT '删除时间',
  `update_time` TIMESTAMP  NOT NULL DEFAULT CURRENT_TIMESTAMP
  COMMENT '更新时间',
  PRIMARY KEY (`id`),
  FOREIGN KEY (`from_user`) REFERENCES _user (`id`),
  FOREIGN KEY (`to_user`) REFERENCES _user (`id`)
)
  ENGINE = INNODB
  AUTO_INCREMENT = 1000
  DEFAULT CHARSET = utf8
  COMMENT = '消息表';

-- 插入用户
INSERT INTO
  _user (name, password, phone, grade)
VALUES
  ('超级管理员', '123456', '18758114722', '1'),
  ('普通用户', '123456', '18758114721', '3'),
  ('lk2', '123456', '18758114723', '3'),
  ('lk3', '123456', '18758114724', '3'),
  ('lk4', '123456', '18758114725', '3');
UPDATE _user
SET id_card = '330282199406244674'
WHERE id = '1000';

-- 自行车表
INSERT INTO
  _bicycle (id, password)
VALUES
  ('1001', '1111'),
  ('1002', '2222'),
  ('1003', '3333'),
  ('1004', '2444');

-- 插入消息列表
INSERT INTO
  _message (from_user, to_user, title, content)
VALUES
  (1000, 1000, '标题', '收到消息了没asdasdsadjsldkjskldjlkasjdlkjsaldjslkadjlsjldjzcxmncmzxbcmejhwieruerweeeeeee'),
  (1001, 1000, '标题2', '收到消息了没2aaad尿素氮你会看见俺说的安好就好卡仕达');

-- 插入订单表
INSERT INTO
  _order (user_id, bicycle_id, start_time, end_time, cost, start_X, start_Y, end_X, end_y, status)
VALUES
  ('1000', '1001', '2017-03-27 22:47:10', '2017-03-27 22:47:10', 1.1, '1', '2', '3', '4', 3);

-- 用户具体信息表格
INSERT INTO
  _user2 (id, photo, sex)
VALUES
  (1000, "aa", "1");

