package jdbc.day1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OracleConnectionUtil {
    public static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
    public static final String URL = "jdbc:oracle:thin:@//localhost:1521/xe";
    public static final String USERNAME = "c##idex";
    public static final String PASSWORD = "12345";

    //Connection 타입 객체 생성 메소드. 
    //Connection conn = OracleConnectionUtil.getConnection(); 로 사용할 것입니다.
    public static Connection getConnection(){
        Connection conn = null;
        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (Exception e) {
            System.out.println("데이터베이스 연결 예외 발생. \n\t : " + e.getMessage());
        }
        return conn;
    }
    //실행순서 : 1. getConnection       2. Sql 실행     3. close
    //SQL 실행 : 개발 프로그램에서 가장 많이 실행하는 SQL은 DML입니다. (select, insert, update, delete)
    //          OracleConnectionUtil 은 1, 3 에서 사용될 것 입니다.
    //인자로 전달된 Connnection 객체를 close.sql 실행이 종료되면 close 해야합니다.
    public static void close(Connection conn){
        try {
            if (conn != null) conn.close();
        } catch (SQLException e) {
            System.out.println("데이터베이스 연결 해제 예외 발생 \n\t : " + e.getMessage());
        }
    }
}

