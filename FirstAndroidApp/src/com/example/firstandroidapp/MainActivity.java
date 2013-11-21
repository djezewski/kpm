package com.example.firstandroidapp;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	private Button mBtnSayHello;
	private Button mBtnNext;
	private View mRectangle;

	/**
	 * The onCreate(...) method is automatically invoked upon Activity's creation.
	 * It is used to set root view for the Activity.
	 * Any additional initialisation of the Activity also goes here.
	 */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        mBtnSayHello = (Button) findViewById(R.id.btn_say_hello);
        mBtnNext = (Button) findViewById(R.id.btn_next);
        mRectangle = findViewById(R.id.rectangle);
        
        // Many attributes can be set in two ways i.e. in XML files and programmatically.
        mBtnNext.setText(getString(R.string.next));
      
        mBtnSayHello.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// Toasts are used to show some short messages to the users. The disappear after delay.
				Toast.makeText(MainActivity.this, getString(R.string.hello_world), Toast.LENGTH_LONG).show();
			}
		});
    }
    
    public void onNextClick(View v) {
    	startActivity(new Intent(this, SecondActivity.class));
    }
    
    public void onShowHideClick(View v) {
    	mRectangle.setVisibility((mRectangle.getVisibility() == View.VISIBLE) ? View.INVISIBLE : View.VISIBLE);
    }
    
    public void onChangeColorClick(View v) {
    	int red = (int) (Math.random() * 255);
    	int green = (int) (Math.random() * 255);
    	int blue = (int) (Math.random() * 255);
    	mRectangle.setBackgroundColor(Color.argb(255, red, green, blue));
    }

    
}
