package project.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import project.vo.CustomerVo;


public class TblCustomerDao {
    public static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
    public static final String URL ="jdbc:oracle:thin:@//localhost:1521/xe";
    public static final String USERNAME = "c##idex";
    private static final String PASSWORD = "12345";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
    //회원가입
    public void join(CustomerVo vo){
        String sql = "INSERT INTO TBL_CUSTOM VALUES(?,?,?,?,SYSDATE)";
        try (Connection connection = getConnection();
            PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setString(1, vo.getCustomId());
            pstmt.setString(2, vo.getName());
            pstmt.setString(3, vo.getEmail());
            pstmt.setInt(4, vo.getAge());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Join 실행 예외 발생 : " + e.getMessage());
        }//close는 자동으로 합니다. finally X
    }
    //회원정보수정
    public void modify(CustomerVo vo){
        String sql = "UPDATE TBL_CUSTOM SET email = ?, age = ? where custom_id = ?";
        try (Connection connection = getConnection();
            PreparedStatement pstmt = connection.prepareStatement(sql)) {

                pstmt.setString(1, vo.getEmail());
                pstmt.setInt(2, vo.getAge());
                pstmt.setString(3, vo.getCustomId());
                pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("modify 실행 예외 발생 : " + e.getMessage());
        }
    }
    //회원탈퇴
    public void delete(String customerId){
        String sql = "DELETE FROM TBL_CUSTOM WHERE custom_id = ?";
        try (Connection connection = getConnection();
            PreparedStatement pstmt = connection.prepareStatement(sql)) {
                pstmt.setString(1, customerId);
                pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("delete 실행 예외 발생 : " + e.getMessage());
        }
    }
    //회원정보 ※PK※ 조회 - 조회 결과 행 개수는 ? : select * from tbl_custom where custom_id = ?;
    //                                      ㄴ 0개 : 조회 결과 없음, 조회 결과가 있다면 무조건 1개.
    //                                      ㄴ 리턴 타입은 CustomerVo
    public CustomerVo getCustomer(String customerId){
        CustomerVo vo = null;
        String sql = "SELECT * FROM TBL_CUSTOM WHERE custom_id = ?";
        try (Connection connection = getConnection();
            PreparedStatement pstmt = connection.prepareStatement(sql)) {
                pstmt.setString(1, customerId);
                ResultSet rs = pstmt.executeQuery();

                if (rs.next()) {    //조회 결과가 있으면 True 없으면 false
                    vo = new CustomerVo(rs.getString(1), 
                                        rs.getString(2), 
                                        rs.getString(3), 
                                        rs.getInt(4), 
                                        rs.getDate(5));
                }
        } catch (SQLException e) {
            System.out.println("ERROR : " + e.getMessage());
        }
        return vo;
    }
    //관리자를 위한 기능 : 모든 회원정보 조회
    public List<CustomerVo> allCustomer(){
        List<CustomerVo> list = new ArrayList<>();
        String sql = "SELECT * FROM TBL_CUSTOM";
        try (Connection connection = getConnection();
            PreparedStatement pstmt = connection.prepareStatement(sql)) {
                ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                list.add(new CustomerVo(rs.getString(1), 
                                        rs.getString(2), 
                                        rs.getString(3), 
                                        rs.getInt(4), 
                                        rs.getDate(5)));
            }
        } catch (SQLException e) {
            System.out.println("ERROR : " + e.getMessage());
        }
        return list;
    }
}
