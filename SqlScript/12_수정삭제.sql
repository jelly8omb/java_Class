/*
 * DML : select, insert, update, delete
 * 	   : 테이블의 데이터에 대한 조작.
 * 
 * 여기서 한 번 더 생각할 것은 기본키가 필요한 이유 : 행식별
 * */

-- update 테이블명 
-- 				set 컬럼명2 = 변경할 값.....
--				where 조건식;

-- 예시 : 'mina012' 회원이 구매한 상품 'CJBAb12g' 의 수량을 모두 10으로 변경하기
UPDATE EXBUY SET PQ = 10 WHERE customer_id = 'mina012' AND pd_code = 'CJBAb12g';
SELECT * FROM EXBUY e ;

-- 예시 : buy_idx 값이 1001 인 행의 수량을 5로 변경하기
--	   : 조건식 컬럼이 pk 컬럼(행식별)일 때에는 반드시 1개의 행만 수정이 적용됩니다.
UPDATE EXBUY SET PQ = 5 WHERE BUY_IDX = 1001;

UPDATE EXBUY SET PQ = 5; -- WHERE 조건없는 SQL은 신중하게. 꼭 필요할 때만 사용합니다.


SELECT * FROM EXBUY e ;

-- delete from where 조건식; : 행 전체를 삭제
-- WHERE 조건없는 SQL은 신중하게. 꼭 필요할 때만 사용합니다.
--	   : 조건식 컬럼이 pk 컬럼(행식별)일 때에는 반드시 1개의 행만 삭제이 적용됩니다.
DELETE FROM EXBUY WHERE buy_idx = 1001;


-- 최종결론 : PK컬럼은 응용프로그램 개발할때에는 없으면 기능을 만들수가 없습니다.
-- 		    행 식별을 하여 조회 select, 수정 update, 삭제 delete 에 반영되는 행을 지정할수 있다.


------------------------------------------------------------------------------------------------------

-- 트랜젝션 : insert, update, delete 에서 반드시 하나의 단위로 처리해야할 작업.
-- 			모모가 미나에게 5만원 빌림. 모모 계좌는 -5만	 미나 계좌는 +5만
-- update 2개의 명령어로 실행할 때 2개 모두 실행 2개 모두 실행이 안되거나 해야하는 트랜잭션입니다.
-- 자동 커밋 : insert, update, delete 명령이 바로 반영되지 않고 commit 명령을 통해서 실행된다.
-- 수동 커밋 : insert, update, delete 명령 트랜잭션 취소는 rollback 으로 합니다.

-- sqlPlus 명령 
-- show auto commit;
-- set auto commit on(off);


-- 디비버의 auto commit 해제하기 : 데이터베이스 -> 트랜잭션 모드 -> Manual Commit(수동 커밋)
INSERT INTO EXBUY (buy_idx, customer_id, pd_code, pq, pd) VALUES (exbuy_pk_seq.nextval, 'mina012' , 'CJBAb12g' , 5, '2022-03-10 14:33:15');-- 현재 트랜잭션 명령 1.

SELECT * FROM EXBUY e ;		-- 현재 트랜잭션 명령 2.

-- 수동 커밋 상태에서 sqlPlus 실행 c##idex 접속
-- 		디비버 사용자가 추가한 insert 는 커밋을 해야 sqlplus 사용자에게 보인다(반영됌).
UPDATE EXBUY SET PQ = 13 WHERE BUY_IDX = 1002;			-- 현재 트랜잭션 명령 3.
-- 트랜잭션 취소 명령
ROLLBACK;
SELECT * FROM EXBUY e ;		-- 새로운 트랜잭션 명령
-- insert 와 update 를 다시하고 commit 테스트

UPDATE EXBUY SET PQ = 12 WHERE customer_id = 'mina012' AND pd_code = 'CJBAb12g';
SELECT * FROM EXBUY e ;

-- 트랜잭션 처리완료
COMMIT;










