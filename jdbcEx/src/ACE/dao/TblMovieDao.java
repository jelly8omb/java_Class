package ACE.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ACE.vo.MovieVo;
import jdbc.day1.OracleConnectionUtil;

public class TblMovieDao {
    public static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
    public static final String URL ="jdbc:oracle:thin:@//localhost:1521/xe";
    public static final String USERNAME = "c##idex";
    private static final String PASSWORD = "12345";

    private Connection getConnection() throws SQLException{
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    public List<MovieVo> getMovieVO(String category){
        List<MovieVo> list = new ArrayList<>();
        Connection connection = OracleConnectionUtil.getConnection();
        String sql = "SELECT * FROM TBL_MOVIE WHERE TITLE = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, category);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                MovieVo mv = new MovieVo(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4));
                list.add(mv);
            }
        } catch (SQLException e) {
            System.out.println("getMovieVO ERROR : " + e.getMessage());
        }
        return list;
    }

    public List<MovieVo> selectByPcode(String category){
        List<MovieVo> list = new ArrayList<>();
        Connection connection = OracleConnectionUtil.getConnection();
        String sql = "SELECT * FROM TBL_MOVIE WHERE CATEGORY LIKE '%'|| ? ||'%' ORDER BY TITLE";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, category);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                MovieVo mv = new MovieVo(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4));
                list.add(mv);
            }
        } catch (SQLException e) {
            System.out.println("selectByPcode ERROR : " + e.getMessage());
        }
        return list;
    }

    public Map<String, Integer> getPrice(){
        Map<String, Integer> map = new HashMap<>();
        String sql = "SELECT TITLE, PRICE FROM TBL_MOVIE";
        try (Connection connection = getConnection();
            PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    String title = rs.getString("TITLE");
                    int price = rs.getInt("PRICE");
                    map.put(title, price);
                    System.out.println("영화 제목 : " + title + ", 가격 : " + price);
                }
        } catch (SQLException e) {
            System.out.println("getPrice ERROR : " + e.getMessage());
        }
        return map;
    }
}
