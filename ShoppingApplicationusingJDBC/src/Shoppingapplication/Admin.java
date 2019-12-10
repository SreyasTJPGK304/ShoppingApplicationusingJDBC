package Shoppingapplication;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.jdbc.Statement;



public class Admin {
	Connectionshopping con=new Connectionshopping();

	public void adminData() throws SQLException, ClassNotFoundException {
		
		
		
		Scanner s=new Scanner(System.in);
		System.out.println("Enter the Username");
		String username=s.next();
		System.out.println("Enter the Password");
		String password=s.next();
		int n;
		
		
		Statement stmt=(Statement) con.getConnection().createStatement();
		ResultSet rt=stmt.executeQuery("select * from adminlogin");
		while(rt.next()) {
			//System.out.println(rt.getString(1)+" "+rt.getString(2)+" ");
			
		
		if((rt.getString(1).equals(username)) && rt.getString(2).equals(password)) {
			System.out.println("Successfully Verified");
			do {
			System.out.println("Enter the choice");
			System.out.println("1)Add product\n2)Display\n3)Remove\n4)Update\n5)LogOut");
			n=s.nextInt();
			switch(n) {
			case 1:
				System.out.println("Enter the product id");
				int id=s.nextInt();
				System.out.println("Enter the product name");
				String name=s.next();
				System.out.println("Enter the minsellquantity");
				int quantity=s.nextInt();
				System.out.println("Enter the price");
				int price=s.nextInt();
				PreparedStatement ps=con.getConnection().prepareStatement("insert into addproduct (Productid,productname,Productquantity,Productprice) values(?,?,?,?);");
				ps.setInt(1,id);
				ps.setString(2, name);
				ps.setInt(3, quantity);
				ps.setInt(4, price);
				ps.executeUpdate();
				con.getConnection().close();
				System.out.println("Data Saved");
				break;
			case 2:
				Statement sta2=(Statement) con.getConnection().createStatement();
				ResultSet rsp=sta2.executeQuery("select * from addproduct");
				while(rsp.next()) {
					System.out.println("Product ID->  "+rsp.getInt(1)+" "+"\nProduct Name ->  "+rsp.getString(2)+" "+"\nProduct Quantity ->  "+rsp.getInt(3)+" "+"\nProduct Price ->  "+rsp.getInt(4)+" ");
					System.out.println("*********************************");
				}
				con.getConnection().close();
					break;
				
				
			case 3:
				System.out.println("Enter the id");
				int id1=s.nextInt();
				PreparedStatement pst=(PreparedStatement)con.getConnection().prepareStatement("delete from addproduct where Productid= "+id1);
				pst.executeUpdate();
			      System.out.println("Deleted Successfully");
			      
			      Statement stat=(Statement) con.getConnection().createStatement();
					ResultSet rst=stat.executeQuery("select * from addproduct");
					while(rst.next()) {
						System.out.println("Product ID->  "+rst.getInt(1)+" "+"\nProduct Name ->  "+rst.getString(2)+" "+"\nProduct Quantity ->  "+rst.getInt(3)+" "+"\nProduct Price ->  "+rst.getInt(4)+" ");
						System.out.println("*********************************");
					}
			      con.getConnection().close();
			      break;
			case 4:
				Statement str1=(Statement) con.getConnection().createStatement();
				ResultSet rs1=str1.executeQuery("select * from addproduct");
				while(rs1.next()) {
					System.out.println("Product ID->  "+rs1.getInt(1)+" "+"\nProduct Name ->  "+rs1.getString(2)+" "+"\nProduct Quantity ->  "+rs1.getInt(3)+" "+"\nProduct Price ->  "+rs1.getInt(4)+" ");
					System.out.println("*********************************");
					con.getConnection().close();
				}
				
				System.out.println("Enter the ID to Update");
				int id2=s.nextInt();
				System.out.println("Enter the Add Quantity");
				int quan=s.nextInt();
				int q=0;
				
				ResultSet rs2=str1.executeQuery("select * from addproduct");
				while(rs2.next()) {
					if(rs2.getInt(1)==id2) {
						q=rs2.getInt(3);
						break;
					}
				}
				int total=q+quan;
				
				PreparedStatement ps1=(PreparedStatement)con.getConnection().prepareStatement("update addproduct set Productquantity=? where Productid= ?");
		        ps1.setInt(1, total);
		        ps1.setInt(2, id2);
		        ps1.executeUpdate();
		        
		        System.out.println("Quantity Update Successful");
				
				break;
			case 5:
				System.out.println("Admin Account Logout");
				Thirdclass third=new Thirdclass();
				third.choice();
				break;
				
			}
			
				
			
			}while(n!=0);
		}
		else {
			System.out.println("Not Verified");
			Thirdclass third=new Thirdclass();
			third.choice();
		}
		
		}
		
		

	}

	

}
