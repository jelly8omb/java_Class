CREATE TABLE tbl_viewer (
   custom_id varchar2(20) PRIMARY KEY ,  
   name varchar2(40) NOT NULL,   
   age number(3) NOT NULL
);



CREATE TABLE tbl_movie(
   title varchar2(50) PRIMARY KEY ,
   category varchar2(10) NOT NULL,
   view_age NUMBER(10) NOT NULL,
   price number(20) NOT NULL 
);



CREATE TABLE tbl_reserve(
   res_idx number(8) PRIMARY KEY ,      
   custom_id varchar2(20) NOT NULL ,         
   title varchar2(50) NOT NULL ,      
   res_date DATE ,
   FOREIGN KEY (custom_id)            
         REFERENCES tbl_viewer(custom_id),   
   FOREIGN KEY (title)
         REFERENCES tbl_movie(title)
);

SELECT * FROM tbl_reserve tr;
SELECT * FROM tbl_viewer tv;
SELECT * FROM tbl_movie tm;



CREATE SEQUENCE res_pk_seq START WITH 101;

INSERT INTO tbl_viewer VALUES ('app1e','고길현',17);
INSERT INTO tbl_viewer VALUES ('mond', '이광원', 17);
INSERT INTO tbl_viewer VALUES ('abcd', '김태완', 14);
INSERT INTO tbl_viewer VALUES ('chane', '강주찬', 19);
INSERT INTO tbl_viewer VALUES('xodbs', '권태윤', 25);

INSERT INTO tbl_movie VALUES ('샤이닝','공포',19,15000);
INSERT INTO tbl_movie VALUES ('더 넌','공포',19,14000);
INSERT INTO tbl_movie VALUES ('대충액션영화제목', '액션', 15, 15000);
INSERT INTO tbl_movie VALUES ('대충야한영화제목', '로맨스', 19, 20000);
INSERT INTO tbl_movie VALUES ('어바웃타임', '로맨스', 15, 15000);
INSERT INTO tbl_movie VALUES ('말죽거리 잔혹사', '코미디', 12, 12000);
INSERT INTO tbl_movie VALUES( '서울의봄', '드라마', 19, 30000);
INSERT INTO tbl_movie VALUES( '워낭소리', '기타', 8, 50000);
INSERT INTO tbl_movie VALUES ('너의 결혼식', '로맨스', 12, 15000);
INSERT INTO tbl_movie VALUES ('어스', '공포', 15, 15000);

INSERT INTO tbl_reserve VALUES (res_pk_seq.nextval, 'abcd' , '서울의봄' ,to_date('2023-12-10 09:13:30','yyyy-mm-dd hh24:mi:ss'));
INSERT INTO tbl_reserve VALUES (res_pk_seq.nextval, 'abcd' , '워낭소리' ,to_date('2024-01-21 19:53:11','yyyy-mm-dd hh24:mi:ss'));
INSERT INTO tbl_reserve VALUES (res_pk_seq.nextval, 'app1e', '샤이닝', to_date('2024-01-30 14:32:30', 'yyyy-mm-dd hh24:mi:ss'));
INSERT INTO tbl_reserve VALUES (res_pk_seq.nextval, 'app1e', '더 넌', to_date('2024-01-16 15:32:41', 'yyyy-mm-dd hh24:mi:ss'));
INSERT INTO tbl_reserve VALUES (res_pk_seq.nextval, 'xodbs' , '어바웃타임' ,to_date('2024-01-01 12:12:12','yyyy-mm-dd hh24:mi:ss'));
INSERT INTO tbl_reserve VALUES (res_pk_seq.nextval, 'xodbs' , '말죽거리 잔혹사' ,to_date('2024-01-01 12:12:12','yyyy-mm-dd hh24:mi:ss'));

SELECT RES_IDX , tv.CUSTOM_ID , NAME , TITLE , RES_DATE  
FROM TBL_RESERVE tr
JOIN TBL_VIEWER tv  ON
tr.CUSTOM_ID = tv.CUSTOM_ID 
WHERE tv.CUSTOM_ID = 'app1e';

SELECT * FROM TBL_MOVIE WHERE CATEGORY = '공포';


SELECT VIEW_AGE FROM TBL_MOVIE tm  WHERE TITLE = '서울의봄';





