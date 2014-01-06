package com.jezewski.sampleservice;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

public class MyIntentService extends IntentService {
	
	private static final String TAG = MyIntentService.class.getSimpleName();

	public MyIntentService() {
		super("MyIntentService");
	}

	@Override
	protected void onHandleIntent(Intent intent) {
		Log.d(TAG, "onHandleIntent");
		Log.d(TAG, "onHandleIntent called on a thread: " + Thread.currentThread().getName());
	}

}
