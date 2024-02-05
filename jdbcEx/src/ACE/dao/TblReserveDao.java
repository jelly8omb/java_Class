package ACE.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

    public int resInsert(ReserveVo mv){
        String sql = "INSERT INTO TBL_RESERVE VALUES (buy2_pk_seq.nextval,?,?,SYSDATE)";
        int result = 0;
        try (Connection connection = getConnection();
            PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setString(1, mv.getCustom_id());
                ps.setString(2, mv.getTitle());
                result = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("regInsert ERROR : " + e.getMessage());
        }
        return result;
    }

    

    public int resUpdate(String custom_id, ReserveVo mv) {
        int result = 0;

        if (checkRes(custom_id, mv.getRes_idx())) {
            String sql = "UPDATE TBL_RESERVE SET TITLE = ? WHERE RES_IDX = ?";
            try (Connection connection = getConnection();
                 PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setString(1, mv.getTitle());
                ps.setInt(2, mv.getRes_idx());
                result = ps.executeUpdate();
            } catch (SQLException e) {
                System.out.println("resUpdate ERROR : " + e.getMessage());
            }
        } else {
            System.out.println("예매 수정 권한이 없습니다.");
        }

        return result;
    }
    
    /*
     * public ViewerVO login(String customid){
    ViewerVO vo = null;
    String sql = "SELECT CUSTOM_ID,NAME,AGE FROM TBL_VIEWER tv WHERE CUSTOM_ID = ?";
    try(Connection connection = getConnection();
    PreparedStatement pstmt = connection.prepareStatement(sql)) {
    pstmt.setString(1, customid);
    ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            vo = new ViewerVO(rs.getString(1),
                            rs.getString(2),
                            rs.getInt(3));
        }
    } catch (SQLException e) {
        System.out.println("Viewer 에외 발생 : " + e.getMessage());
    }return vo;
}
     */

    public boolean checkRes(String customid, int res_idx){
        String sql = "SELECT COUNT(*) FROM TBL_RESERVE WHERE CUSTOM_ID = ? AND RES_IDX = ?";
        try (Connection connection = getConnection();
            PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setString(1, customid);
                ps.setInt(2, res_idx);
                ResultSet rs = ps.executeQuery();
                    if (rs.next()) {
                        return rs.getInt(1) > 0;
                    }
                
        } catch (SQLException e) {
            System.out.println("checkRes ERROR : " + e.getMessage());
        }
        return false;
    }
    

    public int regDelete(String custom_id, int res_idx) {
        int result = 0;

        if (checkRes(custom_id, res_idx)) {
            String sql = "DELETE FROM TBL_RESERVE WHERE RES_IDX = ?";
            try (Connection connection = getConnection();
                 PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, res_idx);
                result = ps.executeUpdate();
            } catch (SQLException e) {
                System.out.println("regDelete ERROR : " + e.getMessage());
            }
        } else {
            System.out.println("예매 삭제 권한이 없습니다.");
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
