/*
 * 테이블 조인 : 테이블의 컬럼을 합하는 연산입니다.
 * 		       참고 UNION 연산은 테이블의 행을 합하는 연산입니다.
 * 
 * */

-- STEP1. from 뒤에 2개의 테이블을 나열
SELECT * FROM TBL_CUSTOM tc, TBL_BUY tb ;
-- 결과 : 2개의 테이블 공통 컬럼인 custom_id 로 모든 경우의 수를 조합하여 합친다.

-- STEP2. 동등 조인은 위의 결과 중 고객ID값이 같은 것만 의미가 있으므로 조건식을 추가한 것 입니다.
SELECT * FROM TBL_CUSTOM tc , TBL_BUY tb WHERE tc.CUSTOM_ID = tb.CUSTOMID ;
-- 참고 : 고객 중 한번도 구매를 하지않았다면 조인 결과에 없습니다.

-- STEP3. 위 2단계 결과로 예시를 만듭시다.
--1) 2024년에 상품을 구매한 고객의 이메일을 모두 조회하세요.
SELECT CUSTOMID , EMAIL FROM TBL_CUSTOM tc , TBL_BUY tb WHERE tc.CUSTOM_ID = tb.CUSTOMID AND TO_CHAR(BUY_DATE, 'yyyy')='2024'; 

--2) 테이블을 바꾼 예시 : 회원 'twice'가 구매한 상품명과 가격을 조회하세요.
SELECT * FROM TBL_PRODUCT tp , TBL_BUY tb WHERE tp.PCODE = tb.PCODE ;
SELECT tp.PNAME , tb.QUANTITY , tp.PRICE , QUANTITY * PRICE "구매 금액" FROM TBL_PRODUCT tp , TBL_BUY tb WHERE tp.PCODE = tb.PCODE AND tb.CUSTOMID = 'twice';
SELECT PNAME, PRICE FROM TBL_PRODUCT tp , TBL_BUY tb WHERE tp.PCODE = tb.PCODE ;

--3) 2개의 테이블을 조인하는 예시 생각해보세요. B1 카테고리 상품의 구매 현황(상품명, 가격, 구매수량, 구매날짜)을 조회하세요.
SELECT tp.PNAME , tp.PRICE , tb.QUANTITY , tb.BUY_DATE  FROM TBL_PRODUCT tp , TBL_BUY tb WHERE tp.PCODE = tb.PCODE AND tp.CATEGORY = 'B1' ;

-- 동등 조인 형식 1) select * from 테이블1 t1, 테이블2 t2 where t1.공통컬럼 = t2.공통컬럼;
--			   2) select * from 테이블1 t1 join 테이블2 t2 on t1.공통컬럼 = t2.공통컬럼;

SELECT * FROM TBL_PRODUCT tp JOIN TBL_BUY tb ON tp.PCODE = tb.PCODE ;
-- 외부 조인 : 
/*
 * select * from 테이블1 t1 left [outer] join 테이블2 t2 on t1.공통컬럼 = t2.공통컬럼;
 * 
 * 테이블2에 없는 값도 테이블1에 있으면 조인에 포함시킵니다. 테이블2에 해당하는 컬럼값은 null 입니다.
 * 
 * */
SELECT * FROM TBL_CUSTOM tc LEFT JOIN TBL_BUY tb ON tc.CUSTOM_ID = tb.CUSTOMID ; 
-- 예시 : 구매이력이 없는 회원을 조회하세요.
SELECT CUSTOM_ID , NAME , EMAIL , AGE, BUY_IDX FROM TBL_CUSTOM tc LEFT JOIN TBL_BUY tb ON tc.CUSTOM_ID = tb.CUSTOMID AND tb.CUSTOMID IS NOT NULL ;

-- 상품과  구매에 대한 외부 조인 연습
INSERT INTO TBL_PRODUCT tp (pcode, category, pname, price) VALUES ('SNACK99','C1','새우깡번들','5500');

-- 구매 이력이 없는 상품(이름, 가격)을 조회하세요.
SELECT tp.* FROM TBL_PRODUCT tp LEFT JOIN TBL_BUY tb ON tp.PCODE = tb.PCODE WHERE tb.PCODE IS NULL ;

-- 형식3 : 오라클에서만 사용하는 조인 형식(외부 outer 조인)
SELECT * FROM TBL_PRODUCT tp , TBL_BUY tb WHERE tp.PCODE = tb.PCODE(+); -- null 값이 발생하는 테이블 컬럼에 + 표시하기