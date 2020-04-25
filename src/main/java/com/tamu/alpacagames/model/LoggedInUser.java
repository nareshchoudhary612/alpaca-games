package com.tamu.alpacagames.model;


public class LoggedInUser{
	private static Users user;
	
	public static void setUser(Users user){
		LoggedInUser.user=user;
	}
	
	public static Users getUser() {
		return user;
	}	
	
}