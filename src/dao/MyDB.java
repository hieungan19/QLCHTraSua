package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;




public class MyDB {
	private static MyDB instance = null; 
    private Connection connection;
    private static final String URL = "jdbc:oracle:thin:@localhost:1521/doanpdb"; 
    private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
    private static final String USER_NAME = "admindoan";
    private static final String PASSWORD = "adminpass";
    
    public MyDB() throws SQLException {
    	try {
            Class.forName(DRIVER);
            this.connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
            
        } catch (ClassNotFoundException ex) {
            System.out.println("Database Connection Creation Failed : " + ex.getMessage());
        }
    	
	}
    public Connection getConnection() {
        return connection;
    }
    
    public static MyDB getInstance() throws SQLException {
    	 if (instance == null) {
             instance = new MyDB();
         } else if (instance.getConnection().isClosed()) {
             instance = new MyDB();
         }
         return instance;
    }

}
