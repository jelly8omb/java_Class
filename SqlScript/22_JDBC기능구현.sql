-- JDBC 프로젝트 위한 SQL 테스트
-- SQL 테스트하고 자바 프로그래밍 합시다.

-- 회원 정보 수정 email, age
UPDATE TBL_CUSTOM 
	SET EMAIL = 'test@gmail.com', AGE = 22
	WHERE CUSTOM_ID = 'nayeon33';
	
-- 회원 탈퇴 :
DELETE FROM TBL_CUSTOM 
		WHERE custom_id 'sana77';
		
-- 주요 정리 : 컬럼 조회한 결과는 1개 또는 1개 이상에 따라 리턴 형식을 결정 하자(List ? Not List?)
-- 상품 검색하기 SQL : ProductVo, TblProductDao 만들기
--									ㄴ selectByCategory, selectByPname 메소드
--1. 어떤 카테고리가 있는지 보여주기
SELECT DISTINCT CATEGORY FROM TBL_PRODUCT ;
--2. 특정 카테고리에 대해 상품 목록 보여주기	-- 조회 결과는 1 or N 개
SELECT * FROM TBL_PRODUCT tp 
WHERE CATEGORY = 'B1';

-- 데이터 추가
INSERT INTO TBL_PRODUCT tp VALUES ('BUSA211','B2','부사 사과 3kg 박스',25000);

-- 3. 상품명 유사(like) 검색
SELECT * FROM TBL_PRODUCT tp 
WHERE PNAME LIKE '%'|| '사과' ||'%'; -- 프로그램에서 매개변수 처리를 위해 연결 연산으로 합니다.

-- MyPage 기능의 메소드를 위한 SQL
-- selectCustomerBuyList => TblBuyDao 에 만드세요.
--						 => 아래 조회된 행들에 대해 컬럼과 매핑되는 CustomerBuyVo를 만들어야한다.
SELECT BUY_IDX , tb.PCODE , PNAME , PRICE , QUANTITY , BUY_DATE 
FROM TBL_BUY tb 
JOIN TBL_PRODUCT tp 
ON tb.PCODE = tp.PCODE 
WHERE tb.CUSTOMID = 'mina012';

SELECT * FROM TBL_BUY tb ;