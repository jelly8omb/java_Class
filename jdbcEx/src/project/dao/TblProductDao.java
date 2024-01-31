package project.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jdbc.day1.OracleConnectionUtil;
import project.vo.ProductVo;

public class TblProductDao {
    public static final String URL ="jdbc:oracle:thin:@//localhost:1521/xe";
    public static final String USERNAME = "c##idex";
    private static final String PASSWORD = "12345";

    public Connection getConnection() throws SQLException{
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    public List<ProductVo> getProductVo(String category){
        List<ProductVo> list = new ArrayList<>();
        Connection connection = OracleConnectionUtil.getConnection();
        String sql = "SELECT * FROM TBL_PRODUCT WHERE CATEGORY = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, category);
            ResultSet rc = pstmt.executeQuery();
            if (rc.next()) {
                ProductVo pv = new ProductVo(rc.getString(1), 
                                    rc.getString(2), 
                                    rc.getString(3), 
                                    rc.getInt(4));
            list.add(pv);
            }
        } catch (SQLException e) {
            System.out.println("ERROR : " + e.getMessage());
        }

        return list;
    }

    public List<ProductVo> selectByPname(String pname){
        List<ProductVo> list = new ArrayList<>();
        Connection connection = OracleConnectionUtil.getConnection();
        String sql = "SELECT * FROM TBL_PRODUCT WHERE PNAME LIKE '%'|| ? ||'%' ORDER BY CATEGORY";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, pname);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                ProductVo pv = new ProductVo(rs.getString(1), 
                                            rs.getString(2), 
                                            rs.getString(3), 
                                            rs.getInt(4));
                list.add(pv);
            }
        } catch (SQLException e) {
            System.out.println("ERROR : " + e.getMessage());
        }
        return list;
    }

    public Map<String, Integer> getPriceTable(){
        Map<String, Integer> map = new HashMap<>();
        String sql = "select pcode, price from tbl_product";
        try (Connection connection = getConnection();
            PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    map.put(rs.getString(1), rs.getInt(2));
                }
        } catch (SQLException e) {
            System.out.println("getPriceTable 예외 발생 : " + e.getMessage());
        }
        return map;
        
    }
}
