package com.javazombies.qrzar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.net.http.AndroidHttpClient;


public class MainScreenActivity extends Activity{
	
	public IntentResult lastScanResult;
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
	
	public void onStart(){
		super.onStart();
		
		setContentView(R.layout.main);
		/* Beginning of test http setup
		 * Remove asap
		 */
		HttpResponse response = null;
		try{
			HttpClient client = new DefaultHttpClient();
	        HttpGet request = new HttpGet();
	        request.setURI(new URI("http://dld.kevinbluett.ie/v1/games"));
	        response = client.execute(request);
		}
		catch(URISyntaxException e){
			
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		 BufferedReader in = null;
		try {
			in = new BufferedReader
			            (new InputStreamReader(response.getEntity().getContent()));
		} catch (IllegalStateException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 StringBuffer sb = new StringBuffer("");
		 String line = "";
		 String NL = System.getProperty("line.separator");
		 try {
			while ((line = in.readLine()) != null) {
				 sb.append(line + NL);
			 }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 try {
			in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 Log.v("QRzar", sb.toString());
		 
		/* End of terrible code
		 * Delete between these comments
		 */
		 
		/* Switch to scanning app */
		IntentIntegrator integrator = new IntentIntegrator(this);
		integrator.initiateScan();
		
	}
	
	public void onResume(){
		super.onResume();
		
		//SignInActivity.facebook.extendAccessTokenIfNeeded(this, null);
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
