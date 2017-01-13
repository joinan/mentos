--회원정보 테이블
create table client_info(
c_no number primary key,
c_name nvarchar2(20) not null,
c_email nvarchar2(40) not null,
c_pw nvarchar2(40) not null,
c_nickname nvarchar2(30) not null,
c_age number,
c_gender char(1)
);

--작성된 글 테이블
create table memo_info(
m_no number primary key,
m_content nvarchar2(2000),
m_date date default sysdate,
m_longitude number,
m_latitude number,
m_writer number
);

--외래키 지정
alter table memo_info
add constraints memo1 foreign key (m_writer)
references client_info(c_no);

-- 색 테이블
create table memo_color(
mc_no number primary key,
mc_r number not null,
mc_g number not null,
mc_b number not null
);

-- 감정 테이블
create table emotion(
e_no number primary key,
e_name nvarchar2(20) not null
);

--분석 테이블(미완)
create table analysis( 
a_no number primary key,
a_keyword nvarchar2(30) not null,
a_color number, 
constraints color1 foreign key(a_color)
references color(c_no),

