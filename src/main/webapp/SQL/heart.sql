create table heart(
    like_no number(5) NOT NULL PRIMARY KEY
    ,p_no number(5) NOT NULL, 
    m_id                        NUMBER(6)    NOT NULL,
    like_check                 NUMBER(5)    DEFAULT 0 NULL,
    FOREIGN KEY (m_id) REFERENCES m_member (m_no),
    FOREIGN KEY (p_no) REFERENCES product (p_no)
);

create sequence heart_no_seq
start with 1
increment by 1
nocache;

drop table heart;
select * from heart;