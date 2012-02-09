package com.javazombies.qrzar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.facebook.android.*;
import com.facebook.android.Facebook.*;

public class SignInActivity extends Activity{
	/* Android facebook key
	 * ga0RGNYHvNM5d0SLGQfpQWAPGJ8= 
	 * */

	Facebook facebook = new Facebook("YOUR_APP_ID"); //Needs ADD_ID from facebook
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        /* Initialise facebook api */
        
        facebook.authorize(this, new DialogListener() {
            @Override
            public void onComplete(Bundle values) {}

            @Override
            public void onFacebookError(FacebookError error) {}

            @Override
            public void onError(DialogError e) {}

            @Override
            public void onCancel() {}
        });
        
    }
	
	public void onStart(){
		super.onStart();
		/* Set up login screen */
		
		/* Load XML file "login" as the layout*/
		setContentView(R.layout.login);
        
        Button loginB = (Button)findViewById(R.id.login_button);
    
        loginB.setOnClickListener(new OnClickListener(){

        	public void onClick(View viewParam) {
        		/* On click switch to MainScreenActivity and set loggedIn to true*/
        		QrzarActivity.player.setLoggedIn(true);
        		Intent intent = new Intent(viewParam.getContext(), MainScreenActivity.class);
                startActivity(intent);
        	}
    	
        });
	}

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);

		facebook.authorizeCallback(requestCode, resultCode, data);
	}
}
