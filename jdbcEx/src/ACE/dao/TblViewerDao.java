package ACE.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ACE.vo.ViewerVo;
import jdbc.day1.OracleConnectionUtil;

public class TblViewerDao {
    public static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
    public static final String URL ="jdbc:oracle:thin:@//localhost:1521/xe";
    public static final String USERNAME = "c##idex";
    private static final String PASSWORD = "12345";

    private Connection getConnection() throws SQLException{
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    public Boolean checkId(String cid){
        String sql = "SELECT CUSTOM_ID FROM TBL_VIEWER WHERE CUSTOM_ID = ?";
        try (Connection connection = getConnection();
            PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, cid);
            try(ResultSet rs = ps.executeQuery()){
                return rs.next();
            }
        } catch (SQLException e) {
            System.out.println("checkId ERROR : " + e.getMessage());
        }
        return false;
    }

    public void join(ViewerVo vo){
        String sql = "INSERT INTO TBL_VIEWER VALUES(?,?,?)";
        Connection connection = OracleConnectionUtil.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, vo.getCustom_id());
            ps.setString(2, vo.getName());
            ps.setInt(3, vo.getAge());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Join 실행 오류 : " + e.getMessage());
        }
    }

    public void update(ViewerVo vo){
        String sql = "UPDATE TBL_VIEWER SET name = ?, age = ? where custom_id = ?";
        try (Connection connection = getConnection();
            PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setString(1, vo.getName());
                ps.setInt(2, vo.getAge());
                ps.setString(3, vo.getCustom_id());
                ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("update 오류 : " + e.getMessage());
        }
    }

    public void delete(String cid){
        String sql = "DELETE FROM TBL_VIEWER WHERE custom_id = ?";
        try (Connection connection = getConnection();
            PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setString(1, cid);
                ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("delete error : " + e.getMessage());
        }
    }

    public List<ViewerVo> allViewer(){
        List<ViewerVo> list = new ArrayList<>();
        String sql = "SELECT * FROM TBL_VIEWER";
        try (Connection connection = getConnection();
            PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                list.add(new ViewerVo(rs.getString(1), rs.getString(2), rs.getInt(3)));
            }
        } catch (SQLException e) {
            System.out.println("allViewer ERROR : " + e.getMessage());
        }
        return list;
    }

    public int getUserAge(String custom_id){
        int userAge = 0;
        String sql = "SELECT AGE FROM TBL_VIEWER WHERE CUSTOM_ID = ?";
        try (Connection connection = getConnection();
            PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setString(1, custom_id);
            try(ResultSet rs = ps.executeQuery()){
                if (rs.next()) {
                    userAge = rs.getInt("AGE");
                }
            }
        } catch (SQLException e) {
            System.out.println("getUserAge ERROR : " + e.getMessage());
        }
        return userAge;
    }

    public int getAgeLimit(String movietitle){
        int ageLimit = 0;
        String sql = "SELECT VIEW_AGE FROM TBL_MOVIE WHERE TITLE = ?";
        try (Connection connection = getConnection();
            PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setString(1, movietitle);
            try(ResultSet rs = ps.executeQuery()){
                if (rs.next()) {
                    ageLimit = rs.getInt("VIEW_AGE");
                }
            }
        } catch (SQLException e) {
            System.out.println("getAgeLimit ERROR : " + e.getMessage());
        }

        return ageLimit;
    }

    public boolean checkAgeLimit(String custom_id, String movietitle){
        int Limit = 19;

        int userAge = getUserAge(custom_id);
        int movieAge = getAgeLimit(movietitle);

        return userAge < Limit && userAge < movieAge;
        
    }
}
