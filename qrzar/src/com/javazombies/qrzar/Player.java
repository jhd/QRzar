package com.javazombies.qrzar;

public class Player {
	
	private boolean loggedIn;
	private Player target;
	
	public Player(){
		loggedIn = false;
	}
	
	public boolean loggedIn(){
		return loggedIn;
	}
	
	public void setLoggedIn(boolean value){
		loggedIn = value;
	}
	
	public String[] getGames(){
		/*
		 * Return String[] of the player's current games
		 */
		return new String[1];		
	}
	
	public Player getTarget(){
		/*
		 * Return a Player class of the local player's current target
		 */
		return new Player();
	}
}
