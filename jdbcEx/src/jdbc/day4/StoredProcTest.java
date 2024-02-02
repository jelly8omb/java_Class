package jdbc.day4;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

import jdbc.day1.OracleConnectionUtil;

public class StoredProcTest {
    public static void main(String[] args) {
        exec_max_customer();
        exec_money_of_day();
    }

    private static void exec_max_customer(){
        Connection connection = OracleConnectionUtil.getConnection();
        String sql = "{call max_custom(?,?)}";        //프로시저 SQL 형식 "{call 프로시저 이름(?,?...)}" 매개변수는 정의된 개수만큼 ? 나열
        try (
            CallableStatement cs = connection.prepareCall(sql)
            //프로시저 실행 및 관리 인터페이스 CallableStatement 의 메소드 prepareCall 로 객체 생성하기
            ) {
            //프로시저 실행결과 OUT 파라미터 1번 인덱스 타입 지정하기 - 고객 이름
            cs.registerOutParameter(1, Types.VARCHAR);

            //프로시저 실행결과 OUT 파라미터 2번 인덱스 타입 지정하기 - 고객 나이
            cs.registerOutParameter(2, Types.NUMERIC);
            cs.executeQuery();
            //프로시저 실행결과 OUT 파리미터 값은 cs 객체에 저장됩니다.
            //쇼핑몰 관리자(일반사용자)가 원하는 정보
            System.out.println("구매 수량이 가장 많은 고객 정보 조회한 결과입니다.");
            //인덱스 1번 OUT 실행 결과값 가져오기
            System.out.println("고객 이름 : " + cs.getString(1));
            System.out.println("고객 나이 : " + cs.getInt(2));
        } catch (SQLException e) {
            System.out.println("exec_max_customer : " + e.getMessage());
        }
    }

    private static void exec_money_of_day(){
        System.out.println("고객ID와 날짜를 입력하면 총 구매금액을 조회합니다.");
        System.out.print("고객 ID 입력_");
        String customid = System.console().readLine();

        System.out.print("구매 날짜 입력_");
        String buydate = System.console().readLine();



        Connection connection = OracleConnectionUtil.getConnection();
        String sql = "{call money_of_day(?,?,?)}";
        try (CallableStatement cs = connection.prepareCall(sql)) {
            //프로시저의 IN 매개변수값 전달 : setXXX
            cs.setString(1, customid);
            cs.setString(2, buydate);

            //프로시저 OUT 매개변수 1. 타입 설정
            cs.registerOutParameter(3, Types.NUMERIC);
            cs.executeQuery();
            //OUT 매개변수 2. 결과값 가져오기 : getXXX
            String result = String.format("%s 고객님이 %s 에 구매한 총 구매 금액 : %,8d", customid, buydate,cs.getInt(3));
            System.out.println(result);
        } catch (SQLException e) {
            System.out.println("exec_money_of_day : " + e.getMessage());
        }

    }
}
