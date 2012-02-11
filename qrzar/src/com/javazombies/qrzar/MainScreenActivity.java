package com.javazombies.qrzar;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainScreenActivity extends Activity{
	
	public IntentResult lastScanResult;
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
	
	public void onStart(){
		super.onStart();
		
		setContentView(R.layout.main);
		
		IntentIntegrator integrator = new IntentIntegrator(this);
		integrator.initiateScan();
		
	}
	
	public void onResume(){
		super.onResume();
		
		SignInActivity.facebook.extendAccessTokenIfNeeded(this, null);
	}
	
	/* Handle return from QR scanner */ 
	public void onActivityResult(int requestCode, int resultCode, Intent intent) {
		  IntentResult scanResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);
		  if (scanResult != null) {
		    // handle scan result
			  lastScanResult = scanResult;
		  }
		  // else continue with any other code you need in the method
		}
}
