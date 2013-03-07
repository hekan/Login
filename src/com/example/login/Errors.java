package com.example.login;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.widget.TextView;

public class Errors extends Activity {
	TextView login;
	TextView mail;
	TextView pass;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_errors);
		Intent i = getIntent();
		String [] errors = i.getStringExtra("keyword").split("*");
		login = (TextView)findViewById(R.id.error1);
		mail = (TextView)findViewById(R.id.error3);
		pass = (TextView)findViewById(R.id.error2);
		if(errors.length==3){
			login.setText(errors[0]);
			pass.setText(errors[1]);
			mail.setText(errors[2]);
		}
		if(errors.length==2){
			login.setText(errors[0]);
			pass.setText(errors[1]);
			
		}
		if(errors.length==3){
			login.setText(errors[0]);
			
		}
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_errors, menu);
		return true;
	}

}
