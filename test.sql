CREATE TABLE customer_ch(
    userid VARCHAR2(20) CONSTRAINT customer_ch_FK REFERENCES customer_log(userid),
    mvcode VARCHAR2(20) constraint pk_customer_ch PRIMARY KEY,
    mvname VARCHAR2(20) not null,
    mvtime NUMBER(10) not null,
    loc VARCHAR2(20) not null,
    sitnum VARCHAR2(20) not null
);
select * from customer_ch;
insert into customer_ch values('hong', 'm1', '보이스', '15', '서울', 'seat_T1');
select * from mv_list;
commit;

delete from mv_list where mvcode='m1';
delete from customer_ch where mvcode='m1';

alter table customer_ch modify mvtime varchar2(20);

insert into MV_LIST values('m1','보이스');

select * from customer_ch;
commit;

