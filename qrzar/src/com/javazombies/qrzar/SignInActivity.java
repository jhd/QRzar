package com.javazombies.qrzar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class SignInActivity extends Activity{
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
}
