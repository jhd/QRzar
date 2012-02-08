package com.javazombies.qrzar;

public class Player {
	
	private boolean loggedIn;
	private int Fauth; /* Facebook authentication token */
	
	public Player(){
		/* TODO read from file from previous login */
		loggedIn = false;
	}
	
	public boolean loggedIn(){
		return loggedIn;
	}
	
	public void setLoggedIn(boolean option){
		loggedIn = option;
	}
	public int Fauth(){
		return Fauth;
	}
}
