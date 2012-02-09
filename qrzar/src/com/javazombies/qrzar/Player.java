package com.javazombies.qrzar;

public class Player {
	
	private boolean loggedIn;
	
	public Player(){
		loggedIn = false;
	}
	
	public boolean loggedIn(){
		return loggedIn;
	}
	
	public void setLoggedIn(boolean value){
		loggedIn = value;
	}
	
}
