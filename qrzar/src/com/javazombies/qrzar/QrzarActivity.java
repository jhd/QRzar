package com.javazombies.qrzar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class QrzarActivity extends Activity {
	
	public Player player;

	/* Called when the activity is first created. */

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		/* Load the player */
		player = new Player();

		if (player.loggedIn()) {
			/* Switch to main screen */
			
			Intent intent = new Intent(this, MainScreenActivity.class);
			startActivity(intent);
			
		} else {
			/* Switch to login activity */

			Intent intent = new Intent(this, SignInActivity.class);
			startActivity(intent);
		}
	}
}