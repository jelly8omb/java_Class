/*
 * `단어장` 프로그램을 위한 테이블
 * 0. 테이블명 : tbl_javaword
 * 1. 테이블 구조
 * 												3. TO DO : 컬럼 값들의 규칙 => 요구사항에 대한 제약조건
 * 		idx		number(8)							같은 값을 가질수 없다. 반드시 값이 있어야한다.
 * 		english		varchar2(100)					같은 값을 가질수 없다. 반드시 값이 있어야한다.
 * 		korean		varchar2(100)					반드시 값이 있어야한다.
 * 		step		number(1)						반드시 값이 없는 null도 가능하다. 1~4 범위로만 한다.
 * 		4. TO DO : 검색 속도를 향상시키기 위한 컬럼을 정하자. `데이터 행을 식별` 할수 있는 컬럼을 정해라(기본키 설정)
 * 
 * 2. 테이블 행 추가 - 데이터 입력하기
 * 
 * */

CREATE TABLE tbl_javaword(
	idx number(8),
	english varchar2(100),
	korean varchar2(100),
	step number(1)
)

INSERT INTO TBL_JAVAWORD VALUES (1,'public','공공의',1);
INSERT INTO TBL_JAVAWORD VALUES (2,'private','개인적인',1);
INSERT INTO TBL_JAVAWORD VALUES (3,'iterate','반복하다',2);
INSERT INTO TBL_JAVAWORD VALUES (4,'collection','수집',1);
INSERT INTO TBL_JAVAWORD VALUES (5,'application','응용프로그램',3);
INSERT INTO TBL_JAVAWORD VALUES (6,'binary','2진수의',2);

-- SELECT 컬럼명1, 컬럼명2,... FROM 테이블명 : 부분 컬럼만 보고 싶을때 \\ 모든 컬럼을 보고 싶을 땐 *
SELECT * FROM TBL_JAVAWORD tj;
TRUNCATE TABLE TBL_JAVAWORD;

-- SELECT 컬럼명1, 컬럼명2... FROM 테이블명 = 값		
--							[WHERE 컬럼명 = 값] => 특정 컬럼을 조건식으로 조회
SELECT * FROM TBL_JAVAWORD WHERE STEP IS NOT NULL;
SELECT * FROM TBL_JAVAWORD WHERE STEP IS NULL;
SELECT * FROM TBL_JAVAWORD WHERE IDX = 2;
SELECT * FROM TBL_JAVAWORD WHERE ENGLISH = 'public';
SELECT * FROM TBL_JAVAWORD WHERE ENGLISH = 'public' AND STEP = 2;	-- NOT,AND,OR : 논리연산
SELECT * FROM TBL_JAVAWORD WHERE ENGLISH LIKE '%ic';	-- ic로 끝나는, %기호는 상관 ㄴ
SELECT * FROM TBL_JAVAWORD WHERE ENGLISH LIKE '%ic%';	-- ic로 끝나는, %기호는 상관 ㄴ
SELECT * FROM TBL_JAVAWORD WHERE IDX BETWEEN 10 AND 20;		-- 10~20
SELECT * FROM TBL_JAVAWORD WHERE ENGLISH < 'public';