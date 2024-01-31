package ACE.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ACE.vo.MovieVo;
import ACE.vo.RevMvVo;
import ACE.vo.ViewerVo;
import jdbc.day1.OracleConnectionUtil;

public class TblMovieDao {
    public static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
    public static final String URL ="jdbc:oracle:thin:@//localhost:1521/xe";
    public static final String USERNAME = "c##idex";
    private static final String PASSWORD = "12345";

    private Connection getConnection() throws SQLException{
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    public int insert(List<RevMvVo> cart){
        String sql = "INSERT INTO tbl_reserve VALUES (res_pk_seq.nextval,?,?,SYSDATE)";
        Connection connection = null;
        PreparedStatement ps = null;
        int count = 0;
        try {
            connection = getConnection();
            ps = connection.prepareStatement(sql);
            for(RevMvVo vo : cart){
                ps.setString(1, vo.getCustom_id());
                ps.setString(2, vo.getTitle());
                ps.setTimestamp(3, vo.getRes_date());
                ps.addBatch();
                count++;
            }
            ps.executeBatch();
            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException e1) {

            }
            count=-1;
            System.out.println("예매 불가능한 항목이 있습니다.");
            System.out.println("예매 실행 예외 발생 : " + e.getMessage());
        }finally{
            try {
                ps.close();
                connection.close();
            } catch (SQLException e1) {

            }
        }
        return count;
    }

    public List<RevMvVo> selectviewMovieList(String custom_id){
        List<RevMvVo> list = new ArrayList<>();
        String sql = "SELECT tr.custom_id, title, price, res_date FROM tbl_reserve tr JOIN tbl_movie tm ON tr.custom_id = tm.custom_id WHERE custom_id = ?";
        Connection connection = OracleConnectionUtil.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, custom_id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                
            }
        } catch (SQLException e) {
            System.out.println("Mypage : " + e.getMessage());
        }

        return list;
    }
}
