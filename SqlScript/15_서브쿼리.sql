/*
 * 서브 쿼리(sub query) : select 조회 결과(여러 개의 행)가 다른 DML 명령어에 쓰일 수 있습니다.
 *                                           ㄴ select,insert,update,delete
 *                   select,insert,update,delete에 포함되는 select 를 서브 쿼리라고 합니다.
 * 
 * select와 함께 쓰이는 서브쿼리
 *                   : select 컬럼 1, 컬럼 2 from (select...)
 *                                    where 컬럼명 1 = 값(select...)
 * select 서브쿼리는 join으로도 가능합니다.
 * */

-- 1) where에서 쓰는 서브쿼리 : twice 가 구매한 상품 정보
SELECT tp.*
FROM TBL_PRODUCT tp, TBL_BUY tb  
WHERE tp.PCODE  = tb.PCODE            -- 1) 크로스 연산
AND tb.CUSTOMID = 'twice';            -- 2) 조건식 연산

-- 서브쿼리
SELECT tp.*
FROM TBL_PRODUCT tp 
WHERE PCODE IN       -- 2) 조건식 연산
--('CJBAb12g','APLE5kg','DOWON123a')
(SELECT PCODE FROM TBL_BUY tb WHERE CUSTOMID = 'twice');
 -- 1) 조건식 연산

-- 2) from에서 사용되는 서브 쿼리 : 컬럼명 또는 테이블명 별칭을 줄 때 한글을 쓰려면 "" 안에 사용합니다.
SELECT 
   saleMoney.PCODE, sum(QUANTITY), sum("구매 금액")
FROM 
   (SELECT tp.PCODE, PNAME, QUANTITY, PRICE , QUANTITY * PRICE "구매 금액" 
   FROM TBL_PRODUCT tp, TBL_BUY tb  
   WHERE tp.PCODE  = tb.PCODE) saleMoney
GROUP BY saleMoney.PCODE;

-- join
SELECT 
   tp.PCODE,
   SUM(tb.QUANTITY) AS TotalQuantity,
   SUM(tp.PRICE * tb.QUANTITY) AS TotalAmount
FROM 
   TBL_PRODUCT tp 
JOIN 
   TBL_BUY tb ON tp.PCODE = tb.PCODE
GROUP BY 
    tp.PCODE;
    
-- 오라클 with 구문 : select 조회 결과를 저장해 놓고 사용하도록 합니다.
WITH saleMoney
AS
(
	SELECT tp.PCODE, PNAME, QUANTITY, PRICE, tb.QUANTITY * tp.PRICE "구매 금액"
	FROM TBL_PRODUCT tp , TBL_BUY tb
	WHERE tp.PCODE = tb.PCODE
)
SELECT SALEMONEY.PCODE, SUM(SALEMONEY.QUANTITY), SUM("구매 금액")  FROM SALEMONEY GROUP BY SALEMONEY.pcode;

-- 서브 쿼리와 조인을 이용한 문제를 한 개씩 만들어서 조원끼리 공유 .
SELECT * FROM TBL_PRODUCT tp , TBL_BUY tb , TBL_CUSTOM tc  ;


-- 사과를 구매한 사람의 이름과 구매한 갯수만큼의 가격의 합을 구해줘.
SELECT tc.NAME, sum("구매 금액의 합") FROM 
(SELECT NAME, tp.PRICE , tp.PRICE * tb.QUANTITY "구매 금액의 합" FROM TBL_CUSTOM tc JOIN TBL_BUY tb ON tc.CUSTOM_ID = tb.CUSTOMID JOIN TBL_PRODUCT tp ON tp.PCODE = tb.PCODE AND tp.PNAME = '청송사과 5kg')
tc GROUP BY tc.NAME;

-- 20살이상 고객님들의 구매한 상품
SELECT tp.*
FROM TBL_PRODUCT tp 
JOIN TBL_BUY tb 
ON tp.PCODE  = tb.PCODE 
JOIN TBL_CUSTOM tc
ON tb.CUSTOMID = tc.CUSTOM_ID
WHERE tc.AGE > 20;

--홍길동이 구매한 상품의 갯수는?
SELECT NAME ,SUM(QUANTITY) "상품 갯수"
FROM  TBL_CUSTOM tc 
JOIN  TBL_BUY tb ON tc.CUSTOM_ID = tb.CUSTOMID 
AND NAME ='홍길동'
GROUP BY NAME ;

--김미나가 구매한 상품 금액 합계
SELECT CUSTOMID  ,SUM(PRICE * QUANTITY) "구매 금액"
FROM  TBL_PRODUCT tp
JOIN  TBL_BUY tb ON tp.PCODE = tb.PCODE
AND CUSTOMID ='mina012'
GROUP BY CUSTOMID  ;

-- with 구문이용하여 saleMoney를 그룹으로 묶고 그 중 구매합산 금액 중 20000~70000사이 값을 출력하시오.
WITH saleMoney
AS
(SELECT tp.PCODE, QUANTITY, PRICE, QUANTITY*PRICE "구매 금액"
      FROM TBL_PRODUCT tp ,TBL_BUY tb 
      WHERE tp.PCODE = tb.PCODE
)
SELECT saleMoney.PCODE,SUM(saleMoney.QUANTITY),SUM("구매 금액")
FROM saleMoney
GROUP BY saleMoney.pcode
HAVING SUM("구매 금액") BETWEEN 20000 AND 70000;