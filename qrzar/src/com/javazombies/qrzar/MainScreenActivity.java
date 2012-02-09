package com.javazombies.qrzar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainScreenActivity extends Activity{
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
	
	public void onStart(){
		super.onStart();
		
		setContentView(R.layout.main);
		
	}
	
	public void onResume(){
		super.onResume();
		
		SignInActivity.facebook.extendAccessTokenIfNeeded(this, null);
	}
}
