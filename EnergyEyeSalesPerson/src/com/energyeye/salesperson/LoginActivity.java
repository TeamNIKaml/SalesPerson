package com.energyeye.salesperson;

import com.energyeye.sales.webservice.LoginService;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity  extends Activity {
	
	private EditText email,password;
	private Button login;
	private LoginService loginService;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		email =(EditText)findViewById(R.id.email);
		password=(EditText)findViewById(R.id.password);
		login =(Button)findViewById(R.id.login);
		loginService = new LoginService(this);
		
		
		
			
		login.setOnClickListener(new OnClickListener() {
			String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
			@Override
			public void onClick(View arg0) {
				
				 if (email.getText().toString().matches(emailPattern) && email.getText().toString().length() > 0)
			        { 
					 	if(!(password.getText().toString().length()>0))
					 		Toast.makeText(getApplicationContext(),"Password cannot be null",Toast.LENGTH_SHORT).show();					 
			           // Toast.makeText(getApplicationContext(),"valid email address",Toast.LENGTH_SHORT).show();
			            
			            loginService.setEmailId(email.getText().toString());
						loginService.setPassword(password.getText().toString());
						loginService.doLogin();
			        }
			        else
			        {
			             Toast.makeText(getApplicationContext(),"Invalid email address",Toast.LENGTH_SHORT).show();
			            
			           
			        }
				
				
				
				// TODO Auto-generated method stub
				
			}
		});
	}

	

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
