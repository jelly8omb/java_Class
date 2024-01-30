/*
 *  프로시저 직접 만들어 보기 : money_of_day
 *  매개변수 IN : 고객ID, 날짜(패턴은 'yyyy-mm-dd')
 *  매개변수 OUT : IN으로 받은 값들을 tbl_buy에서 상품코드를 조회하여 '총 구매 금액'을 구합니다.
 *    ※주의 : 매개 변수 선언에는 varchar2 또는 number만 씁니다.            
 *    ※ 단, 고객은 1일 1품목만 구매 가능합니다. ※
 * 
 *    1) 고객ID, 날짜 값으로 구매 테이블에서 수량과 pcode 조회하고 변수에 저장하기
 *    2) 1)에서 구한 pcode의 가격을 조회하여 저장하기
 *  3) 2)번 가격과 1)번 수량을 곱하기 하여 결과값을 변수에 저장 => 출력변수
 *       곱셈 수식만 계산할 때에는 dual 임시 테이블로 합니다. 
 * 
 */
SELECT PCODE,QUANTITY 
   FROM TBL_BUY tb 
   WHERE CUSTOMID = 'mina012' AND TO_CHAR(BUY_DATE,'yyyy-mm-dd') = '2023-11-10'; 


CREATE OR REPLACE PROCEDURE "C##IDEX".money_of_day(
   p_id IN tbl_custom.custom_id %TYPE,      -- 출력(리턴) 변수
   p_date IN varchar2,      -- 출력(리턴) 변수
   p_money OUT NUMBER
)
IS
   v_pcode TBL_BUY.PCODE %TYPE;
   v_quantity TBL_BUY.QUANTITY %TYPE;
   v_price TBL_PRODUCT.PRICE %TYPE;
BEGIN
   SELECT PCODE, QUANTITY      -- 1일 1구매 조건으로 오직 1개의 행이 조회됩니다.
      INTO v_pcode , v_quantity   -- 조회 결과가 n개의 행이면 프로시저의 커서 기능을 이용합니다. (나중에 진도 나갑니다.)
     -- into는 프로시저에서만 사용합니다. 조회 결과를 변수에 저장합니다.
   FROM TBL_BUY
   WHERE CUSTOMID = p_id AND TO_CHAR(buy_date,'yyyy-mm-dd') = '2023-11-10';
   
   DBMS_OUTPUT.PUT_LINE('* p : ' || v_pcode || ',' || v_quantity );
   SELECT PRICE
      INTO v_price
   FROM TBL_PRODUCT
   WHERE PCODE = v_pcode;
   DBMS_OUTPUT.PUT_LINE('* p : ' || v_price);
   SELECT v_quantity * v_price
      INTO p_money
   FROM dual;      -- 수량 * 가격 수식 연산결과를 출력 매개변수 p_money에 저장
                  -- 특정 테이블과 상관 없으므로 dual 임시 테이블 사용하여 연산합니다.
   DBMS_OUTPUT.PUT_LINE('* m : ' || p_money);
   EXCEPTION
   WHEN no_data_found THEN
   DBMS_OUTPUT.PUT_LINE(CHR(10) || '조건에 맞는 데이터가 없습니다.');
   p_money := 0;
END;
   

--   프로시저 실행
  
     DECLARE               
   vmoney NUMBER(10);   --프로시저 실행결과 OUT 매개변수값 저장
   vid tbl_custom.custom_id %TYPE;   --프로시저 실행에 필요한 IN매개변수값 저장변수
   vdate varchar2(20);   --없어도 되지만 출력 등 편의상 선언함.

BEGIN
   vid :='mina012';
   vdate := '2024-01-29';
   money_of_day(vid,vdate,vmoney);   
   --vid, vdate IN 매개변수 값으로 프로시저를 실행
   --OUT 매개변수에 저장된 프로시저 실행 결과를 vmoney에 전달
   dbms_output.put_line(CHR(10) || '고객ID : '|| vid || ' 날짜: '||vdate);
   dbms_output.put_line('고객님의 구매금액은' || vmoney || '입니다.');
END;