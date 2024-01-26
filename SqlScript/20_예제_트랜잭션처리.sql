CREATE OR REPLACE PROCEDURE "C##IDEX".proc_set_money(     
   acustom_id IN p_buy.CUSTOMID %TYPE, --  회원ID      -- 입력 매개변수 IN
   apcode IN p_buy.PCODE %TYPE,    -- 상품코드
   acnt IN p_buy.QUANTITY %TYPE ,       -- 수량
   isSuccess OUT varchar2  -- 출력 매개변수 OUT. 트랜잭션 처리 성공여부 저장.
)
IS 
   vseq NUMBER;   --변수선언
   vprice NUMBER;
BEGIN 
   INSERT INTO p_buy(buy_idx,CUSTOMID,PCODE,QUANTITY,BUY_DATE)
      values (pbuy_seq.nextval, acustom_id,apcode,acnt,sysdate);   -- 매개변수값으로 INSERT
   SELECT pbuy_seq.currval       -- 방금 insert 한 현재 시퀀스 값 조회
      INTO vseq
      FROM dual;
   DBMS_OUTPUT.PUT_LINE('방금 insert 한 현재 시퀸스 값 : ' || vseq);
   SELECT price 
      INTO vprice  
      FROM tbl_product tp WHERE pcode=apcode;      -- 상품코드에 대한 가격 조회
   DBMS_OUTPUT.PUT_LINE('방금 insert 한 현재 시퀸스 값 : ' || vprice);
   UPDATE p_buy SET money = vprice * QUANTITY 
      WHERE BUY_IDX = vseq;                           -- 방금 INSERT 한 데이터로 가격*수량 값 구해서 money 컬럼값 수정
   dbms_output.put_line('실행 성공');      -- 가격*수량 값이 10000원 이상일 때만 성공
   isSuccess :='success';         -- 프로시저에서 일반변수 대입문 기호 :=
   commit ;
   EXCEPTION          -- EXCEPTION 추가하여 처리 -> 메시지 출력, rollback 
      WHEN OTHERS THEN 
      dbms_output.put_line('실행 실패'); -- 가격*수량 값이 10000원 이상일 때만 실패
      rollback ;      -- 오류가 발생한 sql 앞의 insert,update,delete를 취소.
      isSuccess :='fail';
END;

DECLARE 
	VRESULT varchar2(20);
BEGIN
	proc_set_money('mina012','SNACK99','')
END
