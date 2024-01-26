/*
 * 프로시저 직접 만들어보기 : money_of_day
 * 매개변수 IN : 고객ID, 날짜(패턴은 'yyyy-mm-dd')
 * 매개변수 OUT : IN으로 받은 값들을 TBL_BUY에서 상품 코드를 조회하여 총 구매 금액을 구합니다.
 * 
 * 프로시저 실행
 * 
 * DECLARE
 * 		vmoney number(8);
 * BEGIN
 * 		money_of_day('mina012','2023-11-10',vmoney)
 * 		dbms_output_line('고객님의 구매 금액은 ' || vmoney || '입니다.');
 * END;
 * */
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
   SELECT PCODE, QUANTITY
      INTO v_pcode , v_quantity
   FROM TBL_BUY
   WHERE CUSTOMID = p_id AND BUY_DATE = p_date;
   
   DBMS_OUTPUT.PUT_LINE('* p : ' || v_pcode || v_quantity );
   SELECT PRICE
      INTO v_price
   FROM TBL_PRODUCT
   WHERE PCODE = v_pcode;
   DBMS_OUTPUT.PUT_LINE('* p : ' || v_price);
   SELECT v_quantity * v_price
      INTO p_money
   FROM dual;
   DBMS_OUTPUT.PUT_LINE('* m : ' || p_money);
   EXCEPTION
   WHEN no_data_found then
   DBMS_OUTPUT.PUT_LINE('조건에 맞는 데이터가 없습니다.');
END;