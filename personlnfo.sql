create database Person; -- �������ݿ�

use Person; -- �л������ݿ�
go

create table department -- ���ű�
(
	id int identity primary key,
	department varchar(50) not null
)
go
insert into department -- �����Ϣ
values('������'),('������Դ��'),('����'),('��Ϣ��'),('���ڲ�')
go

select * from department -- ��ѯ��Ϣ


create table personlnfo -- Ա����
(
	id int identity primary key, -- ���
	name varchar(50) not null,  -- ����
	gender char(2) default '��' check(gender='��' or gender='Ů'), -- �Ա�
	idno char(18) unique not null, -- ���֤��
	address varchar(100) default ('��ַ����'), -- ��ͥסַ
	phone varchar(20) check(len(phone)=11), -- ��ϵ��ʽ
	hiredate datetime default getdate(), -- ��ְ����
	department varchar(20) not null, -- ����
	position varchar(20), -- ְλ
	education varchar(20), -- ѧ��
	company varchar(20) --��˾
)
go
insert into personlnfo values -- �����Ϣ
('����','��','362421200008051410','����ʡ�����м�����','13879685422',
'2015-08-01','��Ϣ��','ְԱ','����','��ɽ');
go

select * from personlnfo; -- ��ѯ��Ϣ
