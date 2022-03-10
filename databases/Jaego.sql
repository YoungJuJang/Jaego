-- MEMBER 회원 테이블
create table MEMBER(
	member_id  int auto_increment primary key,
	member_email1 varchar(50) not null,
	member_email2 varchar(50) not null,
	member_password varchar(50) not null,
	member_name varchar(20) not null,
	member_phone1 varchar(10) not null,
	member_phone2 varchar(10) not null,
	member_phone3 varchar(10) not null,
	member_gender varchar(10) not null,
	member_age varchar(15) not null,
	member_mentorstatus int default 0 not null,
	member_regdate datetime default now() not null
);


-- MENTOR 멘토 테이블
create table MENTOR(
	mentor_id  int auto_increment primary key,
	member_id int not null,
	mentor_img varchar(100) not null,
	mentor_content varchar(500) not null,
	mentor_career1 varchar(100) not null,
	mentor_career2 varchar(100) default null,
	mentor_career3 varchar(100) default null,
	mentor_career4 varchar(100) default null,
	mentor_career5 varchar(100) default null,
	mentor_link1 varchar(100) not null,
	mentor_link2 varchar(100) default null,
	mentor_link3 varchar(100) default null,
	mentor_account varchar(50) not null,
	mentor_bank varchar(20) not null,
	mentor_status int default 0 not null,
	FOREIGN KEY (member_id) REFERENCES MEMBER (member_id) on update cascade
);


-- LECTURE 클래스 테이블
create table LECTURE (
	lecture_id int auto_increment primary key,
	mentor_id	int	not null,
	member_id	int	not null,
	lecture_title	varchar(100) not null,
	lecture_content	varchar(500) not null,
	lecture_price	int not null,
	lecture_start	 date not null,
	lecture_end	 date not null,
	lecture_category	varchar(30) not null,
	lecture_zipcode	varchar(20)	not null,
	lecture_roadAddress	varchar(100) not null,
	lecture_jibunAddress	varchar(100) not null,
	lecture_namujiAddress	varchar(50)	null,
	lecture_regdate	datetime not null default now(),
	lecture_maxcount	VARCHAR(10)	not null,
	lecture_status	int default 0 not null,
	FOREIGN KEY (member_id) REFERENCES MEMBER (member_id) on update cascade,
	FOREIGN KEY (mentor_id) REFERENCES MENTOR (mentor_id) on update cascade
);


-- LECTURE 클래스 이미지 테이블
create table LECTURE_IMGFILE (
	lecture_img_id int auto_increment primary key,
	lecture_id	int	not null,
	lecture_img	varchar(100),
	FOREIGN KEY (lecture_id) REFERENCES LECTURE (lecture_id) on update cascade
);


-- LECTUREROOM 클래스룸 테이블
create table LECTUREROOM(
	lectureroom_id int auto_increment primary key,
	lecture_id int not null,
	member_id int not null,
	lectureroom_title varchar(50) not null,
	lectureroom_content varchar(500),
	lectureroom_regdate datetime default now() not null,
	lectureroom_fname varchar(50),
	lectureroom_password varchar(50),
	FOREIGN KEY (member_id) REFERENCES MEMBER (member_id) on update cascade,
	FOREIGN KEY (lecture_id) REFERENCES LECTURE (lecture_id) on update cascade
);


-- REPLY 클래스룸 댓글 테이블
create table REPLY(
	reply_id int auto_increment primary key, 
	lectureroom_id int not null,
	replyer varchar(20) not null, 
	reply_content varchar(500) not null,
	reply_regdate datetime default now() not null,
	FOREIGN KEY (lectureroom_id) REFERENCES LECTUREROOM (lectureroom_id) on update cascade
);


-- LECTURE_REVIEW 클래스 리뷰 테이블
create table LECTURE_REVIEW(
	review_id int auto_increment primary key,
	lecture_id int not null,
    member_id int not null,
    review_writer varchar(20) not null,
	review_content varchar(500) not null,
	review_score int not null,
	review_regdate datetime default now() not null,
	FOREIGN KEY (lecture_id) REFERENCES LECTURE (lecture_id) on update cascade,
    FOREIGN KEY (member_id) REFERENCES MEMBER (member_id) on update cascade
);


-- ORDERS 주문 테이블
create table ORDERS(
	orders_id varchar(40) not null,
	lecture_id int not null,
	member_id int not null,
    FOREIGN KEY (member_id) REFERENCES MEMBER (member_id) on update cascade,
	FOREIGN KEY (lecture_id) REFERENCES LECTURE (lecture_id) on update cascade
);

