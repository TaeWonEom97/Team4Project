CREATE TABLE customer_log(
    userid varchar2(10) CONSTRAINT pk_customer_log PRIMARY KEY,
    username varchar2(20) not null,
    userpwd  varchar2(10) not null);
        
CREATE TABLE customer_ch(
    userid varchar2(10) CONSTRAINT customer_ch_FK REFERENCES customer_log(userid),
    mvcode VARCHAR2(20) constraint pk_customer_ch PRIMARY KEY,
    mvname VARCHAR2(20) not null,
    mvtime NUMBER(10) not null,
    loc VARCHAR2(20) not null,
    sitnum VARCHAR2(20) not null
);


create table MV_LIST(
mvcode varchar2(20) constraint MV_LIST_mvcode_pk primary key,
mvname varchar2(50) not null);



insert into MV_LIST values('m1','보이스');

insert into MV_LIST values('m2','007 노 타임 투 다이');

insert into MV_LIST values('m3','기적');

insert into MV_LIST values('m4','F20');

create table SEAT_LIST(
sitnum varchar2(20) constraint SEAT_LIST_sitnum_pk primary key,
seat_T1 varchar2(20),
seat_T2 varchar2(20),
seat_T3 varchar2(20),
seat_T4 varchar2(20),
seat_T5 varchar2(20),
seat_T6 varchar2(20),
seat_T7 varchar2(20),
seat_T8 varchar2(20),
seat_T9 varchar2(20),
seat_T10 varchar2(20)
);

insert into customer_ch values('hong', 'm1', '보이스', '15', '서울', 'seat_T1');

insert into customer_ch values('hong', 'm3', '기적', '15', '부산', 'seat_T3');

DELETE FROM customer_ch;
ALTER TABLE customer_ch MODIFY mvtime VARCHAR2(20);
select * from customer_ch;

commit;

CREATE TABLE ch(
    mvname VARCHAR2(20) not null,
    mvtime NUMBER(10) not null,
    loc VARCHAR2(20) not null
);

alter table ch modify mvname varchar2(100);
alter table customer_ch modify mvtime varchar2(20);

commit;