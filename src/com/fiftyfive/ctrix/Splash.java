package com.fiftyfive.ctrix;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;

import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.Window;


public class Splash extends SherlockActivity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		
		setContentView(R.layout.splash);
		
		Thread timer = new Thread() {
			public void run() {

				try {

					sleep(1000); // 5 seconds
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {

					Intent doc = new Intent();
					doc.setClass(Splash.this, MainActivity.class);
					startActivity(doc);
				}
			}
		};

		timer.start();
	}

	@Override
	protected void onPause() {
		super.onPause();
		finish();
	}
	

}
