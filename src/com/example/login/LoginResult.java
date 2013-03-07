package com.example.login;

import android.os.Bundle;
import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.widget.TextView;

public class LoginResult extends Activity {
	TextView login;
	TextView pass;
	TextView email;
	TextView birth;
	TextView gender;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login_result);
		String [] data = getIntent().getStringExtra("keyword").split("*");
		login = (TextView)findViewById(R.id.res_login);
		pass = (TextView)findViewById(R.id.res_pass);
		email = (TextView)findViewById(R.id.res_mail);
		gender = (TextView)findViewById(R.id.res_gender);
		birth = (TextView)findViewById(R.id.res_birth);
		login.setText(data[0]);
		pass.setText(data[1]);
		birth.setText(data[2]);
		email.setText(data[3]);
		gender.setText(data[4]);
		SQLiteDatabase db = openOrCreateDatabase("User", MODE_PRIVATE, null);
		db.execSQL("CREATE TABLE IF NOT EXIST users (login VARCHAR, password VARCHAR, birth VARCHAR, mail VARCHAR, gender VARCHAR);");
		db.execSQL("INSERT INTO users VALUES ("+data[0]+"," + data[1]+"," + data[2]+"," +  data[3]+"," +  data[4]+");");
		db.close();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_login_result, menu);
		return true;
	}

}
