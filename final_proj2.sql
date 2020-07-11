�솮占�
/* Drop Tables */

DROP TABLE cast CASCADE CONSTRAINTS;
DROP TABLE actor CASCADE CONSTRAINTS;
DROP TABLE reply CASCADE CONSTRAINTS;
DROP TABLE ask CASCADE CONSTRAINTS;
DROP TABLE charge CASCADE CONSTRAINTS;
DROP TABLE mReview CASCADE CONSTRAINTS;
DROP TABLE book CASCADE CONSTRAINTS;
DROP TABLE missing CASCADE CONSTRAINTS;
DROP TABLE revenue CASCADE CONSTRAINTS;
DROP TABLE salary CASCADE CONSTRAINTS;
DROP TABLE wSchedule CASCADE CONSTRAINTS;
DROP TABLE staff CASCADE CONSTRAINTS;
DROP TABLE storeInfo CASCADE CONSTRAINTS;
DROP TABLE store CASCADE CONSTRAINTS;
DROP TABLE mSchedule CASCADE CONSTRAINTS;
DROP TABLE brInfo CASCADE CONSTRAINTS;
DROP TABLE seat CASCADE CONSTRAINTS;
DROP TABLE theather CASCADE CONSTRAINTS;
DROP TABLE branch CASCADE CONSTRAINTS;
DROP TABLE cuponDetail CASCADE CONSTRAINTS;
DROP TABLE cupon CASCADE CONSTRAINTS;
DROP TABLE division CASCADE CONSTRAINTS;
DROP TABLE movieImg CASCADE CONSTRAINTS;
DROP TABLE total CASCADE CONSTRAINTS;
DROP TABLE film CASCADE CONSTRAINTS;
DROP TABLE genre CASCADE CONSTRAINTS;
DROP TABLE mile CASCADE CONSTRAINTS;
DROP TABLE membership CASCADE CONSTRAINTS;
DROP TABLE proposal CASCADE CONSTRAINTS;
DROP TABLE qna CASCADE CONSTRAINTS;
DROP TABLE staffType CASCADE CONSTRAINTS;

/* Create Tables */

CREATE TABLE actor
(
	actorNum number(38) NOT NULL,
	actorName varchar2(500),
	actorAge varchar2(500),
	actorImg varchar2(500),
	actorNation varchar2(500),
	PRIMARY KEY (actorNum)
);


CREATE TABLE genre
(
	genreNum number(38) NOT NULL,
	sffPosition varchar2(500),
	PRIMARY KEY (genreNum)
);

CREATE TABLE proposal
(
	proNum number(38) NOT NULL,
	memberId varchar2(500),
	proAddr varchar2(500),
	proGoal varchar2(500),
	proScale varchar2(500),
	proStatus varchar2(500),
	proRegdate Date,
	PRIMARY KEY (proNum)
);

CREATE TABLE membership
(
	memNum number(38) NOT NULL,
	memName varchar2(380),
	memId varchar2(500) UNIQUE,
	memPwd varchar2(500),
	memPhone varchar2(500),
	birth varchar2(500),
	email varchar2(500),
	grade varchar2(500),
	memRegdate date,
	money number(38),
	PRIMARY KEY (memNum)
);

CREATE TABLE qna
(
	qnaNum number(38) NOT NULL,
	qnaTitle varchar2(500),
	qnaContent varchar2(500),
	PRIMARY KEY (qnaNum)
);
CREATE TABLE division
(
	divisionNum number(38) NOT NULL,
	divisionName varchar2(500),
	PRIMARY KEY (divisionNum)
);
CREATE TABLE staffType
(
	sffNum number(38) NOT NULL,
	sffPosition varchar2(500),
	wage number(38),
	PRIMARY KEY (sffNum)
);


CREATE TABLE film
(
	filmNum number(38) NOT NULL,
	filmName varchar2(500),
	filmStory varchar2(500),
	filmStart date,
	filmEnd date,
	filmPrice number(38),
	runnigTime varchar2(500),
	filmStatus varchar2(500),
	genreNum number(38) NOT NULL,
	PRIMARY KEY (filmNum)
);

CREATE TABLE movieImg
(
	movieImgnum number(38) NOT NULL,
	fileName varchar2(500),
	savedFileName varchar2(500),
	filmNum number(38) NOT NULL,
	PRIMARY KEY (movieImgnum)
);
CREATE TABLE total
(
	totalNum number(38) NOT NULL,
	totalPeople number(38),
	totalPrice number(38),
	totalDate date,
	filmNum number(38) NOT NULL,
	PRIMARY KEY (totalNum)
);

CREATE TABLE cast
(
	castNum number(38) NOT NULL,
	actorNum number(38) NOT NULL,
	filmNum number(38) NOT NULL,
	PRIMARY KEY (castNum)
);
CREATE TABLE branch
(
	branchNum number(38) NOT NULL,
	proNum number(38) NOT NULL,
	brName varchar2(500),
	memId varchar2(500),
	brStatus varchar2(500),
	brRegdate date,
	PRIMARY KEY (branchNum)
);
CREATE TABLE theather
(
	theatherNum number(38) NOT NULL,
	branchNum number(38) NOT NULL,
	theatherName varchar2(500),
	PRIMARY KEY (theatherNum)
);
CREATE TABLE seat
(
	seatNum number(38) NOT NULL,
	theatherNum number(38) NOT NULL,
	seatX number(38),
	seatY number(38),
	seatSale number(38),
	PRIMARY KEY (seatNum)
);
CREATE TABLE brInfo
(
	brInfoNum number(38) NOT NULL,
	filmNum number(38) NOT NULL,
	theatherNum number(38) NOT NULL,
	PRIMARY KEY (brInfoNum)
);
CREATE TABLE mSchedule
(
	mScheduleNum number(38) NOT NULL,
	brInfoNum number(38) NOT NULL,
	mStartTime varchar2(500),
	PRIMARY KEY (mScheduleNum)
);
CREATE TABLE cupon
(
	cuponNum number(38) NOT NULL,
	cuponStatus varchar2(500),
	cName varchar2(500),
	cuponStart date,
	cuponEnd date,
	cSort varchar2(500),
	memNum number(38) NOT NULL,
	cuponRate number(38),
	PRIMARY KEY (cuponNum)
);
CREATE TABLE cuponDetail
(
	cDetailNum number(38) NOT NULL,
	cArea varchar2(500),
	ableDate varchar2(500),
	cuponNum number(38) NOT NULL,
	PRIMARY KEY (cDetailNum)
);
CREATE TABLE charge
(
	chargeNum number(38) NOT NULL,
	memNum number(38),
	cDetailNum number(38) NOT NULL,
	payment varchar2(500),
	memStatus varchar2(500),
	chRegdate date,
	bookNum number(38) NOT NULL,
	phone varchar2(500),
	PRIMARY KEY (chargeNum)
);
CREATE TABLE mile
(
	mileNum number(38) NOT NULL,
	mileDate date,
	mile number(38),
	memNum number(38) NOT NULL,
	PRIMARY KEY (mileNum)
);
CREATE TABLE ask
(
	askNum number(38) NOT NULL,
	memNum number(38) NOT NULL,
	qnaTitle varchar2(500),
	askContent varchar2(500),
	askRegdate date,
	PRIMARY KEY (askNum)
);
CREATE TABLE reply
(
	replyNum number(38) NOT NULL,
	staffId varchar2(500) NOT NULL,
	qnaTitle varchar2(500),
	replyContent varchar2(500),
	replyRegdate date,
	askNum number(38) NOT NULL,
	PRIMARY KEY (replyNum)
);
CREATE TABLE book
(
	bookNum number(38) NOT NULL,
	bookStatus varchar2(500),
	seatNum number(38) NOT NULL,
	mScheduleNum number(38) NOT NULL,
	chargeNum number(38) NOT NULL,
	PRIMARY KEY (bookNum)
);
CREATE TABLE store
(
	storeNum number(38) NOT NULL,
	branchNum number(38) NOT NULL,
	storeName number(38),
	storePrice number(38),
	storeStatus varchar2(500),
	PRIMARY KEY (storeNum)
);
CREATE TABLE storeInfo
(
	storeInfoNum number(38) NOT NULL,
	memNum number(38) NOT NULL,
	storeNum number(38) NOT NULL,
	buyRegdate date,
	usedMoment date,
	PRIMARY KEY (storeInfoNum)
);

CREATE TABLE revenue
(
	revenueNum number(38) NOT NULL,
	outcome number(38),
	ticketIncome number(38),
	storeIncome number(38),
	branchNum number(38) NOT NULL,
	revenueDate date,
	PRIMARY KEY (revenueNum)
);
CREATE TABLE staff
(
	staffNum number(38) NOT NULL,
	sffNum number(38) NOT NULL,
	divisionNum number(38) NOT NULL,
	sffName varchar2(500),
	sffAge varchar2(500),
	sffAddr varchar2(500),
	jumin varchar2(500),
	gender varchar2(500),
	accountNum number(38),
	sffStatus varchar2(500),
	branchNum number(38) NOT NULL,
	PRIMARY KEY (staffNum)
);
CREATE TABLE missing
(
	missNum number(38) NOT NULL,
	branchNum number(38) NOT NULL,
	getDate date,
	findDate date,
	missDetail varchar2(500),
	missTitle varchar2(500),
	PRIMARY KEY (missNum)
);
CREATE TABLE salary
(
	salNum number(38) NOT NULL,
	salDate date,
	salary number(38),
	staffNum number(38) NOT NULL,
	PRIMARY KEY (salNum)
);
CREATE TABLE mReview
(
	mReviewNum number(38) NOT NULL,
	rContent varchar2(500),
	likeTotal number(38),
	mScore number(38),
	memNum number(38) NOT NULL,
	filmNum number(38) NOT NULL,
	bookNum number(38) NOT NULL,
	PRIMARY KEY (mReviewNum)
);

CREATE TABLE wSchedule
(
	sNum number(38) NOT NULL,
	staffNum number(38) NOT NULL,
	workStart date,
	workEnd date,
	workDate date,
	PRIMARY KEY (sNum)
);
=======================================================================================










create sequence actorNum;
create sequence askNum;
create sequence bookNum;
create sequence branchNum;
create sequence brInfoNum;
create sequence castNum;
create sequence chargeNum;
create sequence cuponNum;
create sequence cDetailNum;
create sequence divisionNum;
create sequence filmNum;
create sequence genreNum;
create sequence memNum;
create sequence mileNum;
create sequence missNum;
create sequence movieImgnum;
create sequence mReviewNum;
create sequence mScheduleNum;
create sequence proNum;
create sequence qnaNum;
create sequence replyNum;
create sequence revenueNum;
create sequence salNum;
create sequence seatNum;
create sequence staffNum;
create sequence sffNum;
create sequence storeNum;
create sequence storeInfoNum;
create sequence theatherNum;
create sequence totalNum;
create sequence sNum;


/* Create Foreign Keys */

ALTER TABLE cast
	ADD FOREIGN KEY (actorNum)
	REFERENCES actor (actorNum)
;


ALTER TABLE reply
	ADD FOREIGN KEY (askNum)
	REFERENCES ask (askNum)
;


ALTER TABLE charge
	ADD FOREIGN KEY (bookNum)
	REFERENCES book (bookNum)
;


ALTER TABLE mReview
	ADD FOREIGN KEY (bookNum)
	REFERENCES book (bookNum)
;


ALTER TABLE missing
	ADD FOREIGN KEY (branchNum)
	REFERENCES branch (branchNum)
;


ALTER TABLE revenue
	ADD FOREIGN KEY (branchNum)
	REFERENCES branch (branchNum)
;


ALTER TABLE staff
	ADD FOREIGN KEY (branchNum)
	REFERENCES branch (branchNum)
;


ALTER TABLE store
	ADD FOREIGN KEY (branchNum)
	REFERENCES branch (branchNum)
;


ALTER TABLE theather
	ADD FOREIGN KEY (branchNum)
	REFERENCES branch (branchNum)
;


ALTER TABLE mSchedule
	ADD FOREIGN KEY (brInfoNum)
	REFERENCES brInfo (brInfoNum)
;


ALTER TABLE cuponDetail
	ADD FOREIGN KEY (cuponNum)
	REFERENCES cupon (cuponNum)
;


ALTER TABLE charge
	ADD FOREIGN KEY (cDetailNum)
	REFERENCES cuponDetail (cDetailNum)
;


ALTER TABLE staff
	ADD FOREIGN KEY (divisionNum)
	REFERENCES division (divisionNum)
;


ALTER TABLE brInfo
	ADD FOREIGN KEY (filmNum)
	REFERENCES film (filmNum)
;


ALTER TABLE cast
	ADD FOREIGN KEY (filmNum)
	REFERENCES film (filmNum)
;


ALTER TABLE movieImg
	ADD FOREIGN KEY (filmNum)
	REFERENCES film (filmNum)
;


ALTER TABLE mReview
	ADD FOREIGN KEY (filmNum)
	REFERENCES film (filmNum)
;


ALTER TABLE total
	ADD FOREIGN KEY (filmNum)
	REFERENCES film (filmNum)
;


ALTER TABLE film
	ADD FOREIGN KEY (genreNum)
	REFERENCES genre (genreNum)
;


ALTER TABLE ask
	ADD FOREIGN KEY (memNum)
	REFERENCES membership (memNum)
;


ALTER TABLE charge
	ADD FOREIGN KEY (memNum)
	REFERENCES membership (memNum)
;


ALTER TABLE cupon
	ADD FOREIGN KEY (memNum)
	REFERENCES membership (memNum)
;


ALTER TABLE mile
	ADD FOREIGN KEY (memNum)
	REFERENCES membership (memNum)
;


ALTER TABLE mReview
	ADD FOREIGN KEY (memNum)
	REFERENCES membership (memNum)
;


ALTER TABLE storeInfo
	ADD FOREIGN KEY (memNum)
	REFERENCES membership (memNum)
;


ALTER TABLE book
	ADD FOREIGN KEY (mScheduleNum)
	REFERENCES mSchedule (mScheduleNum)
;


ALTER TABLE branch
	ADD FOREIGN KEY (proNum)
	REFERENCES proposal (proNum)
;


ALTER TABLE book
	ADD FOREIGN KEY (seatNum)
	REFERENCES seat (seatNum)
;


ALTER TABLE salary
	ADD FOREIGN KEY (staffNum)
	REFERENCES staff (staffNum)
;


ALTER TABLE wSchedule
	ADD FOREIGN KEY (staffNum)
	REFERENCES staff (staffNum)
;


ALTER TABLE staff
	ADD FOREIGN KEY (sffNum)
	REFERENCES staffType (sffNum)
;


ALTER TABLE storeInfo
	ADD FOREIGN KEY (storeNum)
	REFERENCES store (storeNum)
;


ALTER TABLE brInfo
	ADD FOREIGN KEY (theatherNum)
	REFERENCES theather (theatherNum)
;


ALTER TABLE seat
	ADD FOREIGN KEY (theatherNum)
	REFERENCES theather (theatherNum)
;