/* 첨부된 이미지 파일은 각 문제의 실행결과입니다. 실행 결과를 참고하여 SQL문을 작성하세요.
 * 3개의 예시 테이블의 데이터를 첨부된 이미지와 동일하게 초기화하여 실행하세요.
 * 답을 첨부한 문제룰 참고하여 나머지 문제를 풀어보세요. */


/* A조  */
--A-1. 'mina012' 가 구매한 상품 금액 합계(이광원)
SELECT X.customid, sum(X.price) AS "구매 금액"
FROM
	(
		SELECT CUSTOMID , (price * QUANTITY) AS price, buy_date
		FROM  TBL_PRODUCT tp 
			 ,TBL_BUY tb
		WHERE tp.pcode = tb.pcode
			  AND tb.CUSTOMID = 'mina012'
	) X
GROUP BY X.CUSTOMID
;	  
	  

--A-2. 이름에 '길동'이 들어가는 회원 구매한 상품 구매현황 (권태윤)
SELECT tb.CUSTOMID, tp.PNAME, tp.PRICE, tb.BUY_DATE, tb.BUY_DATE 
FROM 
	  TBL_PRODUCT tp 
	, TBL_BUY tb 
WHERE 
	 tp.pcode = tb.pcode
AND EXISTS 
	(
		SELECT 1
		FROM TBL_CUSTOM tc 
		WHERE tc.custom_id = tb.CUSTOMID  
		AND name LIKE  '%길동%'
	) 
;

-- 데이터 추가 후 실행하세요.
INSERT INTO TBL_CUSTOM 
			VALUES ('dongL','이길동','lee@daum.net',25,sysdate);
INSERT INTO TBL_BUY 
			VALUES (buy_pk_seq.nextval,'dongL','DOWON123a',2,sysdate);
			
--A-3. `25살`이상 고객님들의 `구매`한 `상품명` 조회하기 (강주찬) => 테이블 3개
SELECT tc.CUSTOM_ID, tc.name, tb.PCODE, tb.QUANTITY, tb.BUY_DATE 
FROM
	  TBL_CUSTOM tc
	, TBL_BUY tb 
WHERE tb.customid = tc.custom_id
  AND tc.AGE >= 25;

		

--A-4. 상품명에 '사과' 단어가 포함된 상품을 구매한 고객에 대해 상품별 구매금액의 합을 구하기.(고길현)
 SELECT tb.CUSTOMID, tb.pcode, sum(QUANTITY*price)
 FROM TBL_BUY tb,
 	  TBL_PRODUCT tp 
 WHERE tb.pcode = tp.pcode  
   AND tp.PNAME LIKE '%사과%'
 GROUP BY tb.CUSTOMID, tb.pcode
 ;



-- 데이터 추가 후 실행하세요.
INSERT INTO TBL_PRODUCT
			VALUES ('BUSA211','B2','부사 사과 3kg 박스',25000);
INSERT INTO TBL_BUY  
			VALUES (buy_pk_seq.nextval,'hongGD','BUSA211',2,TO_date('2024-01-03','yyyy-mm-dd'));

--A-5. 총 구매합산 금액이 100000~200000 값인 고객 ID를 조회하시오.(김태완)
SELECT tb.CUSTOMID, sum(tp.price*tb.quantity)
FROM TBL_PRODUCT tp, 
	 tbl_buy tb
WHERE tp.PCODE = tb.PCODE
GROUP BY tb.customid
HAVING  sum(price*quantity) BETWEEN 100000 AND 200000;


/*  B조 */
--B-1. 20대 나이 고객의 구매 상품 코드와 나이를 나이순으로 정렬 조회 (이대환) /* C조 조이루 */
SELECT tb.CUSTOMID,  tc.AGE , tb.pcode
FROM TBL_BUY tb
	, TBL_CUSTOM tc 
WHERE tc.CUSTOM_ID  = tb.CUSTOMID 
ORDER BY age ASC;

--B-2. 나이가 가장 많은 고객이 상품을 구매한 횟수를 조회하세요.-서브쿼리 사용하기 (김승한)
SELECT CUSTOMID, count(*)
FROM tbl_buy tb
WHERE tb.CUSTOMID IN (  
						SELECT t.customid 
						FROM (
							SELECT  custom_id AS customid
								   ,MAX(age) AS age
								   ,DENSE_RANK() OVER (ORDER BY MAX(age) DESC) AS age_rank
							FROM tbl_custom
							GROUP BY custom_id
						) t
						WHERE age_rank = 1
					)
GROUP BY CUSTOMID;


--B-3. 2023년 하반기 구매금액을 고객ID별로 조회하시오. 금액이 높은 순서부터 조회하세요. (노희영)
SELECT  tb.CUSTOMID ,  (tp.price * tb.QUANTITY) "구매 금액" 
FROM    TBL_PRODUCT tp 
	  , tbl_buy tb
WHERE tp.pcode = tb.pcode  
  AND to_char(BUY_DATE,'yyyy-mm-dd') BETWEEN '2023-07-01' AND '2023-12-31'
ORDER BY "구매 금액" DESC;


--B-4. 2024년에 구매횟수가 1회 이상인 고객id, 고객이름, 나이,이메일을 조회하세요.(이재훈)
SELECT tb.CUSTOMID, name, age, email
FROM  TBL_CUSTOM tc   
	 ,TBL_BUY tb
WHERE tc.CUSTOM_ID = tb.CUSTOMID 
  AND to_char(tb.BUY_DATE,'yyyy') = '2024'  
;


--B-5. 고객별-상품별 구매금액을 조회하세요. 정렬도 고객ID,상품코드 오름차순으로 정렬하세요.(이예진)
SELECT  tb.customid, tb.pcode, sum(tp.price * tb.quantity) "구매 금액"
FROM tbl_buy tb,
	 tbl_product tp 
WHERE tb.pcode = tp.pcode 
GROUP BY tb.customid, tb.pcode 
ORDER BY customid, pcode ASC
;


/* C조 */
--C-1. 가격 1만원 이상의 상품에 대해 각각 고객들이 구매한 평균 개수를 출력하시오.상품코드 순서로 정렬 (임현범)
SELECT tb.pcode, max(tp.PNAME) "상품명", avg(QUANTITY)
FROM TBL_PRODUCT tp, 
	 TBL_BUY tb
WHERE tp.PCODE = tb.PCODE
  AND tp.PRICE >= 10000
GROUP BY tb.PCODE
ORDER BY tb.pcode;

	 
	 
--C-2. 진라면을 구매한 고객의 이름, 구매수량, 구매날짜를 조회하자. (출제자 : 전예진)
SELECT 
	(SELECT name FROM TBL_CUSTOM tc WHERE tc.CUSTOM_ID = tb.CUSTOMID) name
FROM TBL_PRODUCT tp, TBL_BUY tb 
WHERE tp.PCODE = tb.PCODE 
	AND tb.pcode = 'JINRMn5';

--C-3. B조 1번 유사 문제 (조이루)

--C-4. 2023년에 팔린 상품의 이름과 코드, 총 판매액 그리고 총 판매개수를 상품코드 순서로 정렬하여 조회하시오. (정제원)
SELECT tb.pcode, max(tp.pname) pname , count(*) "총 판매개수", sum(price*quantity) "총 가격"
FROM tbl_buy tb, TBL_PRODUCT tp 
WHERE 	tb.pcode = tp.pcode 
	AND to_char(buy_date,'yyyy') = '2023'
GROUP BY tb.pcode;




--C-5. 'twice'와 'hongGD'는 한집에 살고 있습니다. 이들이 구매한 상품,수량,가격을 조회하세요.-가격이 높은순서부터 정렬 (장성우)
SELECT pname, QUANTITY , tp.PRICE 
FROM  tbl_buy tb, tbl_product tp 
WHERE tb.pcode = tp.pcode 
 AND  CUSTOMID IN('twice','hongGD')
ORDER BY price desc;


/* D조 */
--D-1. 진라면을 가장 많이 구매한 회원을 구매금액이 높은 순으로 회원아이디와 총 진라면 구매금액을 보여주세요.(조하연)
-- 							ㄴ 서브쿼리 없이 조인만 사용
SELECT  tb.customid
	   ,sum(price*quantity) AS sum
FROM TBL_PRODUCT tp, 
	 tbl_buy tb
WHERE tp.pcode = tb.pcode
  AND tb.pcode = 'JINRMn5'
GROUP BY tb.customid;

 
--D-2. 판매 갯수가 가장 많은 순서로 상품 을 정렬하고 총 팔린 금액을 출력하시오.(한진만)
-- 	   판매 개수가 같으면 상품 코드 순서로 정렬합니다.			ㄴ 동등 조인으로 조회
SELECT tb.PCODE 
		, (SELECT pname FROM TBL_PRODUCT tp2 WHERE tp2.pcode = tb.pcode) AS pname
		, sum(QUANTITY) AS "팔린 갯수" 
		, sum(price * QUANTITY) AS "총 팔린 금액"
FROM  TBL_BUY tb
	, TBL_PRODUCT tp
WHERE tb.PCODE = tp.PCODE 
GROUP BY tb.PCODE
ORDER BY "총 팔린 금액" DESC;





SELECT * FROM TBL_BUY tb WHERE pcode = 'MANGOTK4r';
--D-3. 진라면을 구매한 고객들의 평균 나이를 제품코드(PCODE)와 함께출력해 주세요.(황병훈)
SELECT pcode, AVG(age) 
FROM  TBL_CUSTOM tc 
	, TBL_BUY tb 
WHERE tc.CUSTOM_ID = tb.CUSTOMID 
  AND tb.PCODE  = 'JINRMn5'
GROUP BY tb.pcode; 


--D-4. 30세 미만 회원별 구매금액을 구하고 회원으로 그룹바이해서 구매금액 합계가 큰 순으로 정렬(조지수)
-- 						ㄴ 3개의 테이블 조인

 SELECT tb.CUSTOMID,(price * QUANTITY) AS "구매 금액"
 FROM TBL_BUY tb
 	  , TBL_PRODUCT tp 
 WHERE tb.PCODE = tp.PCODE 
  AND EXISTS (
 	SELECT 1
 	FROM TBL_CUSTOM tc 
 	WHERE tb.CUSTOMID = tc.custom_id
 	 AND tc.age < 30
  )
 ORDER BY "구매 금액" DESC
 ;
 
 
--D-5. A조 5번  유사 문제 (김태완)
--D-6. D조 1번  유사 문제 (차정호)
 