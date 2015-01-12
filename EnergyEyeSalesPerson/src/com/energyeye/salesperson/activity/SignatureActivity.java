package com.energyeye.salesperson.activity;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Date;
import java.util.Calendar;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.energyeye.salesperson.R;
import com.energyeye.salesperson.properties.SignatureView;
import com.energyeye.salesperson.webservice.FileUploadService;



public class SignatureActivity extends Activity {
	private SignatureView signView;
	private Button clear,Save;
	private File file;
	private FileUploadService upload = new FileUploadService();
	
	
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_signature);
		init();
		
	}
	
	
	private void init()
	{
		signView = (SignatureView)findViewById(R.id.signature);
		clear = (Button)findViewById(R.id.clear);
		clear.setOnClickListener(clearOnClickListrner);
		Save = (Button)findViewById(R.id.save);
		Save.setOnClickListener(SaveOnClickListrner);		
		
	//	signatureProgressBar.
		//signatureProgressBar.setMax(100);
	//	signatureProgressBar.setSecondaryProgress(ProgressDialog.THEME_HOLO_DARK);
		//signatureProgressBar.
	}
	
	
	View.OnClickListener clearOnClickListrner = new OnClickListener() {
		@Override
		public void onClick(View v) {
			signView.clear();
		}
	};
	
	View.OnClickListener SaveOnClickListrner = new OnClickListener() {
		@Override
		public void onClick(View v) {
			Calendar c = Calendar.getInstance();
			 Date date1 = new Date(c.getTimeInMillis());
			 
			 
			
		 	
			 

			//Log.e("date1",date1.toGMTString());
			String date = date1.toString();
			Log.e("date",date);
			signView.setDrawingCacheEnabled(true);
			signView.buildDrawingCache();
			signView.buildDrawingCache(true);
			Bitmap bitmap = Bitmap.createBitmap(signView.getDrawingCache());
			int BUFFER_SIZE = 1024 * 8;
			file = new File(getFilesDir() + "/" + date
					+ "_sign.jpg");
			try {
				file.createNewFile();
				FileOutputStream fos = new FileOutputStream(file);
				final BufferedOutputStream bos = new BufferedOutputStream(fos,
						BUFFER_SIZE);
				bitmap.compress(CompressFormat.JPEG, 100, bos);
				bos.flush();
				bos.close();
				fos.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {

			}
			bitmap.recycle();
			Log.i("Path", "Path" + file.getAbsolutePath());
			upload.setSourceFileUri(file.getAbsolutePath());
			upload.uploadFile();
			signView.setDrawingCacheEnabled(false);

		}
	};
	
	
}
