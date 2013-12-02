package com.jezewski.uicontrolsoverview;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends Activity implements OnClickListener {
	
	private TextView mTextView;
	private Button mSampleButton;
	private ToggleButton mToggleButton;
	private EditText mEditText;
	private CheckBox mCheckBox;
	private ImageView mImageView;
	private RadioGroup mRadioGroup;
	private Spinner mSpinner;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mTextView = (TextView) findViewById(R.id.textView1);
		mSampleButton = (Button) findViewById(R.id.button1);
		mToggleButton = (ToggleButton) findViewById(R.id.toggleButton1);
		mEditText = (EditText) findViewById(R.id.editText1);
		mCheckBox = (CheckBox) findViewById(R.id.checkBox1);
		mImageView = (ImageView) findViewById(R.id.imageView1);
		mRadioGroup = (RadioGroup) findViewById(R.id.radioGroup1);
			
		// Setting OnClickListener for "Go to list activity" button.
		findViewById(R.id.button3).setOnClickListener(this);
		
		//Handling long click events.
		mTextView.setOnLongClickListener(new View.OnLongClickListener() {
			@Override
			public boolean onLongClick(View v) {
				showToast("TextView long clicked");
				return false;
			}
		});
		
		//Handling toggle button state changes.
		mToggleButton.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				showToast("Toggle button " + (isChecked ? " on" : "off"));
			}
		});
		
		/* Checking toggle button state.
		mToggleButton.isChecked();
		
		Same method can be used to check state of the checkbox:
		
		mCheckBox.isChecked();
		*/
		
		mCheckBox.setChecked(true);
		
		mEditText.setTextColor(Color.YELLOW);
		
		mImageView.setRotationX(20f);
		
		mSampleButton.setClickable(false);
		
		// Performs Spinner initialization.
		initializeSpinner();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void onShowAlertDialogClick(View v) {
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setMessage("You mad?!?");
		builder.setTitle("Sample alert dialog");
		builder.setIcon(android.R.drawable.ic_delete);
		builder.setPositiveButton("Yes", null);
		builder.setNegativeButton("No", null);
		builder.setNeutralButton("Maybe", null);
		builder.create().show();
	}

	@Override
	public void onClick(View v) {
		startActivity(new Intent(this, ListActivity.class));
	}
	
	private void initializeSpinner() {
		mSpinner = (Spinner) findViewById(R.id.spinner1);
		final ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.planets_array, android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		mSpinner.setAdapter(adapter);
		
		mSpinner.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				showToast("Selected: " + (String)adapter.getItem(position));
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
			}
			
		});
	}
	
	private void showToast(String msg) {
		Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
	}
	
}
