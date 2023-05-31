create table heart(
    like_no number(5) PRIMARY KEY,
    p_no number(38) NOT NULL, 
    m_no   number(38)   NOT NULL  
);

create sequence heart_no_seq
start with 1
increment by 1
nocache;

drop table heart;
select * from heart;