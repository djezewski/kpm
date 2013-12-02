package com.jezewski.locationexample;

import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends Activity {
	
	private static final String TAG = "LocationUpdate";
	private LocationManager mLocationManager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		mLocationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
		mLocationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000, 0, locationListener);
		
		Location lastKnownLocation = mLocationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);		
		Log.i(TAG, "Last known location: " + lastKnownLocation);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {
		mLocationManager.removeUpdates(locationListener);
		return true;
	}
		
	final LocationListener locationListener = new LocationListener() {
		
		@Override
		public void onStatusChanged(String provider, int status, Bundle extras) {
			Log.i(TAG, "Status of the provider : [" + provider + "] changed to: " + status);
		}
		
		@Override
		public void onProviderEnabled(String provider) {
			Log.i(TAG, "Provider: [" + provider + "] enabled");
		}
		
		@Override
		public void onProviderDisabled(String provider) {
			Log.i(TAG, "Provider: [" + provider + "] disabled");
		}
		
		@Override
		public void onLocationChanged(Location location) {
			Log.i(TAG, "Current location: " + location.toString());
		}
	};

}
