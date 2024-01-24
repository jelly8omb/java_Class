-- 수업날짜 : 1월 19일

-- 실제로는 테이블의 컬럼으로 함수 실행합니다. select lower(컬럼명) from 테이블명;


-- 1. 날짜 함수 : to_char(날짜를 문자열로 변환) 와 to_date (문자열을 날짜형식으로 변환)
SELECT SYSDATE, SYSTIMESTAMP FROM dual;		--systimestamp 는 표준시와의 시차(타임존) 표시
SELECT TO_CHAR(SYSDATE,'yyyy"년 "mm"월 "dd"일"') FROM dual; 
SELECT TO_CHAR(SYSDATE,'yyyy"년"') FROM dual; 
SELECT TO_CHAR(SYSDATE,'mm"월"') FROM dual; 
SELECT TO_CHAR(SYSDATE,'dd"일"') FROM dual;

-- yyyy-mm-dd hh24:mi:ss 24시간 기준
-- yyyy-mm-dd hh:mi:ss am 12시간 기준(am 대신에 pm 도 가능)

-- TBL_MEMBER 테이블에 JOIN_DATE 컬럼 insert
-- 자동 캐스팅 패턴 yyyy-mm-dd 만 가능합니다.
INSERT INTO TBL_MEMBER VALUES (2,'박나연','parkny@gmail.com','2022-10-24','2022-10-24 13:24:55');		-- error
-- 저장할 날짜 문자열을 날짜패턴을 알려주고 날짜형식으로 변경하기
INSERT INTO TBL_MEMBER VALUES (2,'박나연','parkny@gmail.com',to_date('2022-10-24 13:24:55','yyyy-mm-dd hh24:mi:ss'));

INSERT INTO TBL_MEMBER VALUES (10,'홍길동','gdHong@daum.net',to_date('20240109','yyyymmdd'));

SELECT * FROM TBL_MEMBER tm ;

SELECT ADD_MONTHS(SYSDATE,3) FROM dual;		-- 오늘 날짜 3개월 이후. 첫번째 인자는 날짜 형식. 두번쨰 더해지는 값

SELECT TO_CHAR(ADD_MONTHS(SYSDATE,3),'yyyy/mm/dd') FROM dual;		-- 문자열 패턴 기호 - 또는 / 또는 구분기호 없음 가능

SELECT MONTHS_BETWEEN(SYSDATE	, TO_DATE('2022-09-23')) FROM dual;		-- 지정된 2개의 날짜 사이에 간격(월). 결과는 소수점

SELECT TRUNC(SYSDATE) - TO_DATE('20171110','yyyymmdd') FROM dual;	-- 2개의 날짜형식 값 간격(일), 2개의 날짜의 간격(일), TRUNC(SYSDATE)는 일(day)까지로 변환 

SELECT TRUNC(SYSDATE) FROM dual;
SELECT SYSDATE + 5 FROM dual;
SELECT SYSDATE + 15 FROM dual;

-- 2. 숫자 함수(정수 또는 실수 number를 대상으로 하는 함수)
-- abs(n) : 절대값
-- trunc(숫자, 자리수) : 자리수 맞추기 위해서 버림	3.177567	-> 3.17
SELECT TRUNC(3.177567, 2) FROM dual;

-- round(숫자, 자리수) : 					반올림 3.177567	-> 3.18
SELECT ROUND(3.177567, 2) FROM dual;

-- ceil(숫자) : 실수를 정수로 올림으로 변환 ceil(천장)
SELECT CEIL(3.177567) FROM dual;	-- 결과 값 : 4

-- floor(숫자) : 실수를 정수로 내림으로 변환 floor(바닥)
SELECT FLOOR(3.177567) FROM dual;	-- 결과 값 : 3


-- 3. 문자열 함수
SELECT INITCAP('hello') FROM dual;		-- 예상 : hello	-- initail capital : 첫번째 대문자
										
SELECT UPPER('hello') FROM dual;		-- 대문자로 변환. HELLO
										
SELECT LOWER('Oracle') FROM dual;		-- 소문자로 변환. oracle

SELECT LENGTH('Oracle') FROM dual;		-- 문자열 길이. 6

SELECT SUBSTR('java program', 3, 5) FROM dual;		-- 부분 추출(문자열, 위치, 길이) 결과 : va pr
-- *오라클에서 문자열 위치 인덱스는 1부터 시작.*
SELECT SUBSTR('java program', -5, 3) FROM dual;		-- 부분 추출 결과 : 위치음수이면 뒤에서 부터

SELECT REPLACE('java program', 'pro', '프로') FROM dual;		-- 문자열 바꾸기. java 프로gram

SELECT INSTR('java program', 'og') FROM dual;		-- 자바의 indexOf		-- 결과 8. 해당 문자열이 없으면 결과 0

SELECT TRIM('java program	') FROM dual;		-- 공백(불필요한 앞뒤 공백)제거

SELECT LENGTH(' java program	') FROM dual;		-- 공백포함 16

SELECT LENGTH(TRIM(' java program	')) FROM dual;		-- 공백제거 후에는 12