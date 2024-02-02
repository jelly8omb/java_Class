package ACE.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ACE.vo.MovieVo;
import ACE.vo.ReserveVo;
import ACE.vo.RevVwVo;
import jdbc.day1.OracleConnectionUtil;

public class TblReserveDao {
    public static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
    public static final String URL ="jdbc:oracle:thin:@//localhost:1521/xe";
    public static final String USERNAME = "c##idex";
    private static final String PASSWORD = "12345";

    private Connection getConnection() throws SQLException{
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    public int resInsert(MovieVo mv){
        String sql = "INSERT INTO TBL_MOVIE VALUES (?,?,?,?)";
        int result = 0;
        try (Connection connection = getConnection();
            PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setString(1, mv.getTitle());
                ps.setString(2, mv.getCategory());
                ps.setInt(3, mv.getView_age());
                ps.setInt(4, mv.getPrice());
                result = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("regInsert ERROR : " + e.getMessage());
        }
        return result;
    }

    public int resAll(List<ReserveVo> cart){
        String sql = "INSERT INTO TBL_RESERVE VALUES (res_pk_seq.nextval,?,?,SYSDATE)";
        Connection connection = null;
        PreparedStatement ps = null;
        int count = 0;
        try {
            connection = getConnection();
            ps = connection.prepareStatement(sql);
            connection.setAutoCommit(false);
            for(ReserveVo vo : cart){
                ps.setString(1, vo.getCustom_id());
                ps.setString(2, vo.getTitle());
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
            count =- 1;
            System.out.println("입력 오류");
            System.out.println("예매 실행 오류 발생 : " + e.getMessage());
        }finally{
            try {
                ps.close();
                connection.close();
            } catch (Exception e) {

            }
        }
        return count;
    }
    
    

    public int regDelete(int idx){
        int result = 0;
        String sql = "DELETE FROM TBL_RESERVE WHERE res_idx = ?";
        try (Connection connection = getConnection();
            PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, idx);
                result = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("regDelete ERROR : " + e.getMessage());
        }
        return result;
    }

    public List<RevVwVo> myPage(String cid){
        List<RevVwVo> list = new ArrayList<>();
        String sql = "SELECT RES_IDX , tv.CUSTOM_ID , NAME , TITLE , RES_DATE FROM TBL_RESERVE tr JOIN TBL_VIEWER tv ON tr.CUSTOM_ID = tv.CUSTOM_ID WHERE tv.CUSTOM_ID = ?";
        Connection connection = OracleConnectionUtil.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, cid);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                RevVwVo vo = new RevVwVo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getTimestamp(5));
                list.add(vo);
            }
        } catch (SQLException e) {
            System.out.println("myPage ERROR : " + e.getMessage());
        }
        return list;
    }
}
