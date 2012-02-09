package com.javazombies.qrzar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class QrzarActivity extends Activity {
	
	public static Player player;

	/* Called when the activity is first created. */

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		/* Load the player */
		player = new Player();

		/* Switch to login activity */

		Intent intent = new Intent(this, SignInActivity.class);
		startActivity(intent);
	}
}