CREATE TABLE ch(
    mvname VARCHAR2(20) not null,
    mvtime NUMBER(10) not null,
    loc VARCHAR2(20) not null
);
alter table ch modify mvname varchar2(100);
alter table ch modify mvtime varchar2(20);
alter table ch add mvcode varchar2(20);
alter table ch add sitnum varchar2(20);
commit;