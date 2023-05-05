package view;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestJDBCClass {
	public static void main(String[] args) throws SQLException {
		java.sql.Statement st = null;
		Connection con = null; 
		String user = "c##java";
		String password = "doan"; 
		try {
			//Link and load driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//establish a connection
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl",user,password);
			//create a statement object 
			st = con.createStatement();

			String createHuman = "create table HUMAN(name varchar(20), humanID integer primary key)";
			boolean isSuccess = st.execute(createHuman); 
			System.out.println("Table has created: "+ isSuccess);
			
			String insertSql = "insert into human values('Ngân', 20)"; 
			boolean result = st.execute(insertSql);
			System.out.println("Insert successfully!");
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				if (st!=null) st.close();
				if (con!=null) con.close(); 
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
}
