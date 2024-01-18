/*
 * 제약 조건 constraint - 테이블에 저장되는 데이터가 `요구사항에 대한 부적절한 값`을 갖지 않도록 규정
 * 1. 반드시 값이 있어야한다.	NULL 허용안함
 * 2. 같은 값을 가질수 없다.		UNIQUE (유일한)	*무결성 : 데이터 정확성 유지
 * 3. 1~4 범위로만 한다.		CHECK
 * -----------------------
 * 4. 기본키
 * 5. 
 * */
-- 제약 조건 컬럼레벨 설정하기
CREATE TABLE tbl_constr(	
	aname varchar2(20) NOT null,
	bname varchar2(20) UNIQUE,	--NULL 허용
	cno number(4) NOT NULL UNIQUE,
	dno number(4) CHECK (dno BETWEEN 1 AND 4)	--NULL 허용
	-- eno number(4)	-- 형식이 맞는 모든 데이터 허용.
);
INSERT INTO TBL_CONSTR (aname,cno) VALUES ('apple',3);		--필수 입력 컬럼
-- 입력 오류 발생하는 경우 : unique 위반
-- INSERT INTO TBL_CONSTR (aname,bname,cno) VALUES ('apple','banana',3);	-- cno 컬럼값 중복
INSERT INTO TBL_CONSTR (aname,bname,cno) VALUES ('apple','banana',4);
-- INSERT INTO TBL_CONSTR (aname,bname,cno) VALUES ('apple','banana',5);	-- bname 컬럼값 중복

-- 2. 입력 오류 발생하는 경우 : not null 위반
-- INSERT INTO TBL_CONSTR (cno) VALUES (3);

-- 3. 입력 오류 발생하는 경우 : check 위반
INSERT INTO TBL_CONSTR (aname,cno,dno) VALUES ('apple',7,3);
-- INSERT INTO TBL_CONSTR (aname,cno,dno) VALUES ('apple',8,13);	-- 값의 범위 1~4 아님

SELECT * FROM TBL_CONSTR tc;
