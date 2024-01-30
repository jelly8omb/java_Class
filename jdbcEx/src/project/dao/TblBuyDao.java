package project.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbc.day1.OracleConnectionUtil;
import project.vo.BuyVo;
import project.vo.CustomerBuyVo;

public class TblBuyDao {
    public static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
    public static final String URL ="jdbc:oracle:thin:@//localhost:1521/xe";
    public static final String USERNAME = "c##idex";
    private static final String PASSWORD = "12345";

    private Connection getConnection() throws SQLException{
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    public void buyInsert(BuyVo bv){
        String sql = "INSERT INTO TBL_BUY VALUES (buy_pk_seq.nextval,?,?,?,SYSDATE)";
        try (Connection connection = getConnection();
            PreparedStatement pstmt = connection.prepareStatement(sql)) {

                pstmt.setString(1, bv.getCUSTOMID());
                pstmt.setString(2, bv.getPCODE());
                pstmt.setInt(3, bv.getQUANTITY());
                pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Insert 실행 예외 발생 : " + e.getMessage());
        }
    }

    //구매 수량 수정 - PK 는 행 식별합니다. 특정 행을 수정하려면 where 조건 컬럼은 buy_idx(PK)
    public void buyUpdate(BuyVo bv){
        String sql = "UPDATE TBL_BUY SET QUANTITY = ? WHERE BUY_IDX = ?";
        try (Connection connection = getConnection();
            PreparedStatement pstmt = connection.prepareStatement(sql)) {
                pstmt.setInt(1, bv.getQUANTITY());
                pstmt.setInt(2, bv.getBuy_idx());
                pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Update 실행 예외 발생 : " + e.getMessage());
        }
    }

    //구매 취소 - PK 는 행 식별합니다. 특정 행을 삭제하려면 where 조건 컬럼은 buy_idx(PK)
    public List<CustomerBuyVo> buyDelete(int idx){
        String sql = "DELETE FROM TBL_BUY WHERE BUY_IDX = ?";
        try (Connection connection = getConnection();
            PreparedStatement pstmt = connection.prepareStatement(sql)) {
                pstmt.setInt(1, idx);
                pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Delete 실행 예외 발생 : " + e.getMessage());
        }
        return null;
    }

    //mypage 기능의 메소드
    public List<CustomerBuyVo> selectCustomerBuyList(String customid){
        List<CustomerBuyVo> list = new ArrayList<>();
        String sql = "SELECT BUY_IDX, tb.PCODE, PNAME, PRICE, QUANTITY, BUY_DATE FROM TBL_BUY tb JOIN TBL_PRODUCT ON tb.PCODE = tp.PCODE WHERE tb.CUSTOMID = ?";
        Connection connection = OracleConnectionUtil.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, customid);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                CustomerBuyVo vo = new CustomerBuyVo(rs.getInt(1), 
                                                        rs.getString(2), 
                                                        rs.getString(3), 
                                                        rs.getInt(4), 
                                                        rs.getInt(5), rs.getTimestamp(6));
                list.add(vo); 
            }
        } catch (SQLException e) {
            System.out.println("ERROR : " + e.getMessage());
        }
        return list;
    }
}
