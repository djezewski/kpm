package com.jezewski.uicontrolsoverview;

import java.util.Arrays;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ListViewAdapter extends BaseAdapter {
	
	private String[] mObjects;
	private Context mContext;
	
	ListViewAdapter(Context context, String[] objects) {
		this.mObjects = Arrays.copyOf(objects, objects.length);
		this.mContext = context;
	}

	@Override
	public int getCount() {
		return mObjects.length;
	}

	@Override
	public Object getItem(int position) {
		return mObjects[position];
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
		View view = inflater.inflate(android.R.layout.simple_list_item_1, null);
		TextView tv = (TextView) view.findViewById(android.R.id.text1);
		tv.setText(mObjects[position]);
		return view;
	}

}
