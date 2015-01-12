package com.energyeye.salesperson.activity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.energyeye.salesperson.R;
import com.energyeye.salesperson.properties.SalesPerson;
import com.energyeye.salesperson.webservice.LoginService;

public class LoginActivity  extends Activity {
	
	private EditText email,password;
	private Button loginButton;
	private LoginService loginService;
	private static SalesPerson user;
	private SharedPreferences pref;
	//private ProgressDialog  loginProgressBar;
//	public static int progressBarStatus = 0;
	//private Handler handler = new Handler();
	


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		 
		  
		  setContentView(R.layout.activity_login);
		  
		

		  
		Log.e("onCreate", "chekLogin");
		checkLoginStatus();				
		init();			
		loginButton.setOnClickListener(new OnClickListener() 
		{
			String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
			@Override
			public void onClick(View arg0) {
				
				 if (email.getText().toString().matches(emailPattern) && email.getText().toString().length() > 0)
			        { 
					 	if(!(password.getText().toString().length()>0))
				 		Toast.makeText(getApplicationContext(),"Password cannot be null",Toast.LENGTH_SHORT).show();					 
			          	 				 	
					 	Log.e("Login Activity", "dfsdfs");
			            user = SalesPerson.getUser();
			            user.setEmailId(email.getText().toString());
			            user.setPassword(password.getText().toString());			              
			         	loginService.doLogin();					 
			        }
			        else
			        {
			             Toast.makeText(getApplicationContext(),"Invalid email address",Toast.LENGTH_SHORT).show();
			            
			           
			        }
				
			
			}
		});
		}
				
			
			
	

	

	private void init() {
		// TODO Auto-generated method stub
		email =(EditText)findViewById(R.id.email);
		password=(EditText)findViewById(R.id.password);
		loginButton =(Button)findViewById(R.id.loginButton);
		loginService = new LoginService(this);
		
	}



	@Override
	protected void onRestart() {
		// TODO Auto-generated method stub
		super.onRestart();
		Log.e("onRestart", "chekLogin");
		checkLoginStatus();
	}



	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		 email.setText("");
         password.setText("");   
		checkLoginStatus();
	}



	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		Log.e("onStart", "chekLogin");
		//checkLoginStatus();
	}



	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
	}
	
	private void checkLoginStatus() {

		pref = getApplicationContext().getSharedPreferences(
				"localdiskchildlocator", 0);
		int statusTemp = pref.getInt("loginstatus", 0);
		
		Log.e("checkLoginStatus","LoginStatus: "+String.valueOf(statusTemp)
				+"\nuserKey: "+pref.getString("userKey", "")
				+"\nemailID: "+pref.getString("emailID", "")
				+"\nPassword: "+pref.getString("password", ""));
		
		if (statusTemp == 100) {

			Intent intent = new Intent(getApplicationContext(),
			PostLoginActivity.class);
			intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(intent);
			
		}
	}



	
}
