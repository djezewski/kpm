package com.jezewski.sampleservice;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

public class MyService extends Service {
	
	private static final String TAG = MyService.class.getSimpleName();
	private final IBinder mBinder = new MyBinder();
	private NotificationManager mNotificationManager;
	private int NOTIFICATION_ID = 21337;
	
	@Override
	public void onCreate() {
		mNotificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
		Log.d(TAG, "onCreate");
		showNotification();
	}
	
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		Log.d(TAG, "onStartCommand");
		return super.onStartCommand(intent, flags, startId);
	}
	
	@Override
	public IBinder onBind(Intent intent) {
		Log.d(TAG, "onBind");
		return mBinder;
	}
		
	@Override
	public void onDestroy() {
		Log.d(TAG, "onDestroy");
		mNotificationManager.cancel(NOTIFICATION_ID);
		super.onDestroy();
	}
	
	public String getMessage() {
		return "SOME MSG";
	}

	public class MyBinder extends Binder {
		MyService getService() {
			return MyService.this;
		}
	}
	
	private void showNotification() {
		PendingIntent contentIntent = PendingIntent.getActivity(this, 0, new Intent(this, MainActivity.class), 0);

		Notification notification = new NotificationCompat.Builder(this)
			.setContentTitle("Sample notification")
			.setContentText("MyService started")
			.setContentIntent(contentIntent)
			.setSmallIcon(android.R.drawable.star_on)
			.build();
		
		mNotificationManager.notify(NOTIFICATION_ID, notification);
	}

}
