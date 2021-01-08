create database Person; -- 创建数据库

use Person; -- 切换到数据库
go

create table department -- 部门表
(
	id int identity primary key,
	department varchar(50) not null
)
go
insert into department -- 添加信息
values('行政部'),('人力资源部'),('财务部'),('信息部'),('后勤部')
go

select * from department -- 查询信息


create table personlnfo -- 员工表
(
	id int identity primary key, -- 编号
	name varchar(50) not null,  -- 姓名
	gender char(2) default '男' check(gender='男' or gender='女'), -- 性别
	idno char(18) unique not null, -- 身份证号
	address varchar(100) default ('地址不详'), -- 家庭住址
	phone varchar(20) check(len(phone)=11), -- 联系方式
	hiredate datetime default getdate(), -- 入职日期
	department varchar(20) not null, -- 部门
	position varchar(20), -- 职位
	education varchar(20), -- 学历
	company varchar(20) --公司
)
go
insert into personlnfo values -- 添加信息
('张三','男','362421200008051410','江西省吉安市吉州区','13879685422',
'2015-08-01','信息部','职员','本科','金山');
go

select * from personlnfo; -- 查询信息
