package com.javazombies.qrzar;

import com.facebook.android.DialogError;
import com.facebook.android.Facebook;
import com.facebook.android.FacebookError;
import com.facebook.android.Facebook.DialogListener;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class SignInActivity extends Activity{
	/* Android facebook key
	 * ga0RGNYHvNM5d0SLGQfpQWAPGJ8= 
	 * */

	/* Initialise facebook api */
	public static Facebook facebook = new Facebook("YOUR_APP_ID"); //Needs ADD_ID from facebook

    private SharedPreferences mPrefs;
    private String access_token;
    private long expires;
    
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        /* Set up facebook preferences */

		mPrefs = getPreferences(MODE_PRIVATE);
		String access_token = mPrefs.getString("access_token", null);
		long expires = mPrefs.getLong("access_expires", 0);
        
    }
	
	public void onStart(){
		super.onStart();
		/* Set up login screen */
		
		/* Load XML file "login" as the layout*/
		setContentView(R.layout.login);
        
        Button loginB = (Button)findViewById(R.id.login_button);
    
        loginB.setOnClickListener(new OnClickListener(){

        	public void onClick(View viewParam) {
        		/* On click switch to MainScreenActivity*/
        		Intent intent = new Intent(viewParam.getContext(), MainScreenActivity.class);
                startActivity(intent);
        	}
    	
        });
        
		/* Connect player to facebook */
		
		if (access_token != null) {
			facebook.setAccessToken(access_token);
		}
		if (expires != 0) {
			facebook.setAccessExpires(expires);
		}
		
		if (!facebook.isSessionValid()) {
			facebook.authorize(this, new DialogListener() {
				@Override
				public void onComplete(Bundle values) {
					SharedPreferences.Editor editor = mPrefs.edit();
					editor.putString("access_token", facebook.getAccessToken());
					editor.putLong("access_expires",
					facebook.getAccessExpires());
					editor.commit();
				}

				@Override
				public void onFacebookError(FacebookError error) {
				}

				@Override
				public void onError(DialogError e) {
				}

				@Override
				public void onCancel() {
				}
			});
		}
		
		else{
			QrzarActivity.player.setLoggedIn(true);
		}

	}

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);

		facebook.authorizeCallback(requestCode, resultCode, data);
	}
}
