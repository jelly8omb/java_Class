/*
	FOREIGN key(성적테이블컬럼) REFERENCES 참조관계테이블(참조테이블컬럼)   
-		* 참조테이블 컬럼(학생테이블 stuno) 조건은 ? `기본키` 또는 `unique` 컬럼이어야합니다.
-	    * 참조관계를 만들 떄 사용한 성적테이블의 stuno는 값의 제약이 생깁니다.
-		  tbl_student 테이블 stuno 컬럼에 입력된 값으로 제한됩니다.	
-   	* `성적 테이블의 stuno 컬럼은 학생 테이블의 stuno 컬럼을 참조한다` 고
-		 하며 참조컬럼은 학생테이블의 stuno 이고 , 외래키 컬럼은 성적테이블의 stuno 입니다.	
*/
CREATE TABLE excustomer (
    cid VARCHAR2(20) PRIMARY KEY,
    name VARCHAR2(50) NOT NULL,
    email VARCHAR2(100) UNIQUE NOT NULL,
    age NUMBER NOT NULL,
    rgdate DATE default sysdate
);
TRUNCATE TABLE excustomer;



CREATE TABLE exproduct (
    pcode VARCHAR2(20) PRIMARY KEY,
    cg VARCHAR2(50) NOT NULL,
    pname VARCHAR2(100) NOT NULL,
    price NUMBER NOT NULL
);


CREATE TABLE exbuy (
    customer_id VARCHAR2(20),
    pd_code VARCHAR2(20),
    pq NUMBER NOT NULL,
    pd TIMESTAMP NOT NULL,
    PRIMARY KEY (customer_id, pd_code),
    FOREIGN KEY (customer_id) REFERENCES excustomer(cid),
    FOREIGN KEY (pd_code) REFERENCES exproduct(pcode)
);

INSERT INTO excustomer VALUES ('mina012', '김미나', 'kimm@gmail.com', 20, to_date('2022-03-10 14:23:25','yyyy-mm-dd hh24:mi:ss')); 
INSERT INTO excustomer VALUES ('hongGD', '홍길동', 'gil@korea.com', 32, to_date('2021-10-21 11:12:23','yyyy-mm-dd hh24:mi:ss')); 
INSERT INTO excustomer VALUES ('twice', '박모모', 'momo@daum.net', 29, to_date('2021-12-25 19:23:45','yyyy-mm-dd hh24:mi:ss')); 
INSERT INTO excustomer (cid, name, email, age) VALUES ('wonder', '이나나', 'lee@naver.com', 40); --error

SELECT * FROM excustomer ;

INSERT INTO exproduct VALUES ('DOWON123a', 'B2', '동원참치선물세트', 54000);
INSERT INTO exproduct VALUES ('CJBAb12g', 'B1', '햇반 12개입', 14500);
INSERT INTO exproduct VALUES ('JINRMn5', 'B1', '진라면 5개입', 6350);
INSERT INTO exproduct VALUES ('APLE5kg', 'A1', '청송사과 5kg', 66000);
INSERT INTO exproduct VALUES ('MANGOTK4r', 'A2', '애플망고 1kg', 32000);

SELECT * FROM exproduct;

INSERT INTO exbuy VALUES ('mina012' , 'CJBAb12g' , 5 , '2022-03-10 14:33:15');
INSERT INTO exbuy VALUES ('mina012' , 'APLE5kg' , 2 , '2022-03-10 14:33:15');
INSERT INTO exbuy VALUES ('mina012' , 'JINRMn5' , 2 , '2022-03-16 10:13:15');
INSERT INTO exbuy VALUES ('twice' , 'JINRMn5' , 3 , '2021-12-25 19:32:15');
INSERT INTO exbuy VALUES ('twice' , 'MANGOTK4r' , 2 , '2021-12-25 19:32:15');
INSERT INTO exbuy VALUES ('hongGD' , 'DOWON123a' , 1 , '2021-10-21 11:13:25');
INSERT INTO exbuy VALUES ('hongGD' , 'APLE5kg' , 1 , '2021-10-21 11:13:25');

SELECT * FROM exbuy;

--문제 ↓

-- 1. 30살 미만인 고객정보 출력 ↓

SELECT * FROM excustomer WHERE age < 30;

-- 2. 고객 정보에서 이름, 이메일, 날짜 출력 ↓

SELECT name, email, rgdate FROM excustomer;

-- 3. 구매 횟수에서 1~3 번까지의 구매 정보 출력 ↓

SELECT * FROM exbuy WHERE pq BETWEEN 1 AND 3;

-- 4. 상품 가격의 총합과 평균 구하기 ↓

SELECT SUM(price) "합계", AVG(price) "평균" FROM exproduct;

-- 5. 고객 정보의 이름 순으로 모든 정보를 출력 ↓

SELECT * FROM excustomer ORDER BY name;

-- 출제자 강주찬) 10000원 이상 60000원 이하의 상품은 ?
SELECT * FROM  exproduct WHERE price BETWEEN 10000 AND 60000; 





DROP TABLE excustomer;
DROP TABLE exproduct;
DROP TABLE exbuy;












-- 구매 테이블에 기본키 만들기
-- 1. 기본키에 들어갈 값은 시퀀스로 만듭니다. exbuy_pk_seq 시작값은 1001 로 합시다.
CREATE SEQUENCE exbuy_pk_seq;
DROP SEQUENCE exbuy_pk_seq;

CREATE SEQUENCE exbuy_pk_seq START WITH 1001;


-- 2. 기본키 컬럼을 buy_idx로 컬럼추가하기. number(8)
ALTER TABLE exbuy ADD buy_idx number(8);

-- 3. 기본 행에 적용할 buy_idx 컬럼값을 저장하기. not null 과 unique 적용하여 설정하기
UPDATE EXBUY SET BUY_IDX = exbuy_pk_seq.nextval;


-- 4. buy_idx 컬럼에 대해 primary 키 설정하기
alter TABLE EXBUY ADD CONSTRAINT exbuy_pk PRIMARY KEY (buy_idx);


-- 5. 이제부터 새로운 행을 추가할 때에는 시퀀스 함수로 pk값을 INSERT 합니다.
INSERT INTO EXBUY (buy_idx, customer_id, pd_code, pq, pd) VALUES (exbuy_pk_seq.nextval, 'mina012' , 'CJBAb12g' , 5, '2022-03-10 14:33:15');

SELECT * FROM EXBUY e ;




