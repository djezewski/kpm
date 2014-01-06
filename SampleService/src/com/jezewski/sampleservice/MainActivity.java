package com.jezewski.sampleservice;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;

public class MainActivity extends Activity {
	
	private static final String TAG = MainActivity.class.getSimpleName();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	
	public void startService(View v) {
		startService(new Intent(this, MyService.class));
	}
	
	public void stopService(View v) {
		stopService(new Intent(this, MyService.class));		
	}
	
	public void bindService(View v) {
		bindService(new Intent(this, MyService.class), mConnection, Context.BIND_AUTO_CREATE);
		mIsBound = true;
	}
	
	public void unbindService(View v) {
		doUnbindService();
	}
	
	void doUnbindService() {
		if (mIsBound) {
			unbindService(mConnection);
			mIsBound = false;
		}
	}
	
	public void getMessage(View v) {
		if (mIsBound) {
			Log.d(TAG, "Message from service: " + mBoundService.getMessage());
		} else {
			Log.d(TAG, "Service not bound. Cannot obtain message");
		}
	}
	
	// Starts MyIntentService to perform some operation.
	public void sendIntent(View v) {
		startService(new Intent(this, MyIntentService.class));
		Log.d(TAG, "sendIntent called on a thread: " + Thread.currentThread().getName());
	}
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
		doUnbindService();
	}
	
	private MyService mBoundService;
	private boolean mIsBound;
	
	private ServiceConnection mConnection = new ServiceConnection() {
		
		@Override
		public void onServiceDisconnected(ComponentName name) {
			mBoundService = null;
		}
		
		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			mBoundService = ((MyService.MyBinder) service).getService();
		}
	};

}
