package Shoppingapplication;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.jdbc.Statement;

public class Agent {

	public void agentData() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Scanner s=new Scanner(System.in);
		System.out.println("Enter the Username");
		String username=s.next();
		System.out.println("Enter the Password");
		String password=s.next();
		
		int n;
		int m=1,d;
         Connectionshopping con=new Connectionshopping();
		
		Statement st=(Statement) con.getConnection().createStatement();
		ResultSet r=st.executeQuery("select * from agentlogin");
		while(r.next()) {
			//System.out.println(r.getString(1)+" "+r.getString(2)+" ");
			
		
		if((r.getString(1).equals(username)) && r.getString(2).equals(password)) {
			System.out.println("Successfully Verified");
			do {
			System.out.println("1)BuySell\n2)View Product\n3)Logout");
			System.out.println("Enter the choice");
			 n=s.nextInt();
			 int quan=0,f=0,g=0;
			switch(n) {
			
			case 1:
				System.out.println("Enter the Id");
				int id=s.nextInt();
				System.out.println("Enter the Quantity");
				quan=s.nextInt();
				Statement st1=(Statement) con.getConnection().createStatement();
				ResultSet rs=st1.executeQuery("select Productprice from addproduct where Productid= "+id);
				while(rs.next()) {
					//System.out.println(rs.getInt(1)+" ");
				m=quan*rs.getInt(1);
				System.out.println("Cost is: "+m);
				
				}
				
					
					System.out.println("Enter 1 to confirm Booking");
					int c=s.nextInt();
					System.out.println("Your Booking is Confirmed");
					System.out.println("Thank you...!!!");
					break;
					
			case 2:
				
				Statement stamt=(Statement) con.getConnection().createStatement();
				ResultSet resu=stamt.executeQuery("select * from addproduct");
				while(resu.next()) 
				{
					 f=resu.getInt(3);
					 
					System.out.println("Product ID-> "+resu.getInt(1));
					System.out.println("Product Name -> "+resu.getString(2));
					System.out.println("Product Quantity -> "+(f-quan));
					System.out.println("Product price -> "+resu.getInt(4));
					System.out.println("*********************************");
				}
					//System.out.println(f);
					System.out.println("*********************************");
				
					break;
					
			case 3:
				System.out.println("Agent Account Logout");
				break;
				
				
			}
//			Thirdclass third=new Thirdclass();
//			third.choice();
			}while(n!=0);
			
		}
		else {
			System.out.println("Not Verified");
		}
		}
		
		
		
		

	}

}
