package ACE.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TblViewerDao {
    public static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
    public static final String URL ="jdbc:oracle:thin:@//localhost:1521/xe";
    public static final String USERNAME = "c##idex";
    private static final String PASSWORD = "12345";

    private Connection getConnection() throws SQLException{
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
}
