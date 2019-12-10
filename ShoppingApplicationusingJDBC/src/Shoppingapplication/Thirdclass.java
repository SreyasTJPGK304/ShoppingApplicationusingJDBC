package Shoppingapplication;

import java.sql.SQLException;
import java.util.Scanner;

//import CRUD.Firstapp;

public class Thirdclass {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Thirdclass third=new Thirdclass();
		third.choice();
	}
	public void choice() throws ClassNotFoundException, SQLException {
		Scanner s=new Scanner(System.in);
		System.out.println("Enter the choice");
		System.out.println("1)Admin Login\n2)Agent Login\n3)Exit");
		int n=s.nextInt();
		switch(n) {
		case 1:
			Admin admin=new Admin();
			admin.adminData();
			break;
		case 2:
			Agent agent=new Agent();
			agent.agentData();
			break;
		case 3:
			System.out.println("Process will be complete");
			System.exit(0);
			break;
		}
		
		

	}

}
