package com.example.login;

import com.example.login.R.color;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;

public class MainActivity extends Activity implements TextWatcher, OnClickListener {
	EditText login;
	EditText pass;
	EditText repass;
	EditText mail;
	RadioButton male;
	RadioButton female;
	CheckBox agree;
	Button confirm;
	Spinner day;
	Spinner month;
	Spinner year;
	boolean check;
	Intent i;
	String data = "";
	String errors = "";
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		login = (EditText)findViewById(R.id.login);
		pass = (EditText)findViewById(R.id.password);
		repass = (EditText)findViewById(R.id.repass);
		mail = (EditText)findViewById(R.id.email);
		male = (RadioButton)findViewById(R.id.male);
		female = (RadioButton)findViewById(R.id.female);
		agree = (CheckBox)findViewById(R.id.agree);
		confirm = (Button)findViewById(R.id.send);
		day = (Spinner)findViewById(R.id.spinner_day);
		month = (Spinner)findViewById(R.id.spinner_month);
		year = (Spinner)findViewById(R.id.spinner_year);
		confirm.setEnabled(false);
		confirm.setOnClickListener(this);
		agree.setOnClickListener(this);
		repass.addTextChangedListener(this);
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	@Override
	public void afterTextChanged(Editable arg0) {
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
			int arg3) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTextChanged(CharSequence s, int arg1, int arg2, int arg3) {
				
				
			
	}
	public void generate(){
		
		check = false;
		errors = "";
		data = "";
		String reslog = login.getText().toString();
		String resmail = mail.getText().toString();
		String respass = pass.getText().toString();
		String gender = "Gender: male";
		String db = day.toString();
		String mb = month.toString();
		String yb = year.toString();
		String birth = "Date of birth: " + db + "/" + mb + "/" + yb;
		
		if(!reslog.contains("@")  && !reslog.contains("!")&&!reslog.contains("$")&&!reslog.contains("^")&&!reslog.contains("&")&&!reslog.contains("*")&&!reslog.contains("/")&&!reslog.contains(" ")){ check = true; reslog = "Login: "+ reslog;} else errors = errors + "Your login contains irregular symbols*";
		if(resmail.contains("@") && resmail.contains(".")){ check = true; resmail = "E-mail: " + resmail; } else errors = errors + "Your e-mail is written irregularly*";
		if(respass.equals(repass.getText().toString())){check = true; respass = "Password: " + respass; }else errors = errors + "Your passwords doesn't match*";
		if(female.isSelected()) gender = "Gender: female";
		data = reslog + "*" + respass + "*" +  birth + "*" + resmail + "*" +  gender;
	}
	@Override
	public void onClick(View v) {
		
		
		
		
		
		switch(v.getId()){
		
		case R.id.send:
		generate();
		if(!check){
		
			i = new Intent(this, Errors.class);
			i.putExtra("keyword", errors);
			startActivity(i);
			
		}else{
			i = new Intent(this, LoginResult.class);
			i.putExtra("keyword", data);
			startActivity(i);
		}	
	
		break;
		case R.id.agree:
			confirm.setEnabled(true);
		// TODO Auto-generated method stub
		
	}

}
}
