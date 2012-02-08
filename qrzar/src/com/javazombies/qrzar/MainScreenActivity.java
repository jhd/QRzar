package com.javazombies.qrzar;

import android.app.Activity;
import android.os.Bundle;

public class MainScreenActivity extends Activity{
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
	
	public void onStart(){
		super.onStart();
		
		setContentView(R.layout.main);
		
	}
}
