/*
 * 	SQL의 집계(개수, 최대 최소 값, 합계, 평균) 함수 - 그룹 함수
 * 											ㄴ GROUP BY 구문에서 많이 사용됩니다.
 * 											ㄴ 집계 함수는 다른 컬럼과 함께 조회하려면 group by 가 필요합니다.
 * 
 * */
SELECT COUNT(*) "COUNT", SUM(JUMSU) "합계", AVG(JUMSU) "평균" FROM TBL_SCORE ts ; 
-- 1. `성적`테이블의 전체 행 개수
SELECT COUNT(*) AS "COUNT" FROM TBL_SCORE ts ;

-- 조회된 함수 결과에 컬럼명을 주려면 as "컬럼명"으로 합니다. (as 생략가능)
-- 2. `성적`테이블의 과목 컬럼 `국어` 값을 갖는 전체 행 개수
SELECT COUNT(*) AS "COUNT" FROM TBL_SCORE ts WHERE SUBJECT = '국어';

-- 3. `성적`테이블의 `jumsu` 컬럼의 합계
SELECT SUM(Jumsu) FROM TBL_SCORE ts ;

-- 4. `성적`테이블의 `국어` 과목 `jumsu` 컬럼의 합계
SELECT SUM(Jumsu) FROM TBL_SCORE ts WHERE SUBJECT = '국어';

-- 5. `성적`테이블의 `jumsu` 컬럼의 평균
SELECT AVG(Jumsu) FROM TBL_SCORE ts ;

-- 6. `성적`테이블의 `국어` 과목 `jumsu` 컬럼의 평균
SELECT AVG(Jumsu) FROM TBL_SCORE ts WHERE SUBJECT = '국어';

-- 7. `성적`테이블의 `jumsu` 컬럼의 최대값
SELECT MAX(JUMSU)  FROM TBL_SCORE ts ;

-- 8. `성적`테이블의 `국어` 과목 `jumsu` 컬럼의 최대값
SELECT MAX(JUMSU) FROM TBL_SCORE ts WHERE SUBJECT = '국어';

-- 오류 : 집계 함수는 다른 컬럼과 함께 조회하려면 group by 가 필요합니다.
-- SELECT subject , COUNT(*) FROM TBL_SCORE ts ;
-- SELECT subject , COUNT(*) FROM TBL_SCORE ts ; 


--GROUP BY SUBJECT 구문이 있으므로 조회 컬럼에 SUBJECT 를 추가할 수 있습니다.
SELECT COUNT(*) FROM TBL_SCORE ts GROUP BY SUBJECT ;

--GROUP BY STUNO 구문이 있으므로 조회 컬럼에 STUNO 를 추가할 수 있습니다.
SELECT COUNT(*) FROM TBL_SCORE ts GROUP BY STUNO ;

/*
 * 집계함수 count, avg , sum, min, max 등 그룹 함수라고도 합니다. 
 * 그룹화 - 지정한 컬럼값이 같을 것을 갖는 행에 대해 집계 함수를 실행합니다.
 *      
 * 
 * select 
 *       그룹화컬럼, 그룹함수
 * from 테이블이름
 * [WHERE] 그룹화하기 이전의 조건식
 * GROUP BY 그룹화에 사용할 컬럼명
 * [HAVING] 그룹화 후에 사용하는 조건식
 * [ORDER BY] 정렬 컬럼
 */
SELECT * FROM TBL_SCORE ts ;
-- GROUP BY는 그룹화컬럼명1, 그룹화컬럼명2,,..... 로 할수 있습니다.

-- 에시1. 학번(학생) 별로 수강한 갯수와 평균을 구해보세요.
SELECT stuno count(*), avg(JUMSU) FROM TBL_SCORE GROUP BY STUNO;

-- 예시2. 위의 결과에 대해 평균이 89점 미만인 학번(학생)을 조회해 보세요.
SELECT stuno count(*), avg(JUMSU) FROM TBL_SCORE GROUP BY STUNO HAVING AVG(JUMSU) < 80; -- HAVING 은 집계함수 결과에 대한 조건식입니다.
-- 예시3. 예를 들어서 점수가 80점이상인 데이터만 예시 1번을 실행하도록 한다면 where jumsu >= 80 group by stuno
SELECT stuno count(*), AVG(Jumsu) FROM TBL_SCORE WHERE JUMSU >= 80 GROUP BY STUNO ; 

-- 예시4. 예시1 번의 결과를 평균 내림차순으로 조회하세요.
SELECT stuno count(*), AVG(JUMSU) FROM TBL_SCORE GROUP BY STUNO ORDER BY "학생별 평균" DESC; -- avg(JUMSU) DESC;

-- 예시5. 학기-교사별 count, avg 조회하기
SELECT TERM, TEACHER, COUNT(*), AVG(JUMSU) FROM TBL_SCORE GROUP BY TERM, TEACHER ; -- 학기별로 먼저 그룹을 해두고 2차로 학기각 같은 결과 안에서 선생님 별로 그룹화.