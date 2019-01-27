-- auto Generated on 2019-01-27
-- DROP TABLE IF EXISTS student_entity;
CREATE TABLE student_entity(
	id INT (11) NOT NULL AUTO_INCREMENT COMMENT '功能描述：主键id',
	name VARCHAR (50) NOT NULL DEFAULT '' COMMENT '属性描述：姓名',
	age INT (11) NOT NULL DEFAULT -1 COMMENT '功能描述：年龄',
	class_num INT (11) NOT NULL DEFAULT -1 COMMENT '功能描述：班级号',
	PRIMARY KEY (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT 'student_entity';
