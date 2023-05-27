create table heart(
    m_id number(38) 
    ,p_no number(38)
   --상품삭제시 좋아요표시된 상품도 삭제
);

create sequence heart_no_seq
start with 1
increment by 1
nocache;

drop table heart;
select * from heart;