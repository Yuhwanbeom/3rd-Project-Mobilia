create table cart(
    cart_no number(38) primary key
    ,m_id varchar2(30) not null --회원아이디
    ,p_no number(38) not null --상품번호
    ,cart_color varchar2(1000) not null --선택한 상품 색상
    ,cart_size varchar2(2000) not null --선택한 상품 사이즈
    ,amount_count number(38) not null --선택한 개수
);

select * from cart;

create sequence cart_no_seq
start with 1
increment by 1
nocache;