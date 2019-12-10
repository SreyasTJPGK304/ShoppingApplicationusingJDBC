package Shoppingapplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connectionshopping {
	private static Connection NULL;

	public Connection getConnection() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=null;
		con=DriverManager.getConnection("jdbc:Mysql://localhost:3306/Shopping","root","");
		if(con!=NULL) {
			return con;
		}
		else {
			return null;
		}
		
				
		

	}

}
