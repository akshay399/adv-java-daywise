package com.sunbeam;

import java.sql.Connection;
import java.util.Scanner;


public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] user = new String[2];
		
		try(DaoUser dao = new DaoUser()) {
		System.out.println("Enter username");
		user[0] = sc.next();
		System.out.println("Enter password");
		user[1] = sc.next();
		boolean res = dao.authenticateUser(user);
		if(res) System.out.println("User Authenticated");
		else System.out.println("Wrong password!");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
