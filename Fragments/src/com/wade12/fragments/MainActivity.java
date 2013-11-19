package com.wade12.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.FrameLayout;

public class MainActivity extends FragmentActivity implements ElementsListFragment.ElementsListClickHandler {

	String TAG = this.getClass().getSimpleName();
	boolean dualPane;
	FrameLayout infoFrame;
	int lastPosition = -1;
	Bundle element = new Bundle();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.i(TAG, "onCreate");
		setContentView(R.layout.main_activity);
		infoFrame = (FrameLayout) findViewById(R.id.infoFrame);
		dualPane = ( (infoFrame != null) && (infoFrame.getVisibility() == View.VISIBLE) );
		
		if(savedInstanceState!=null) {
			int restoredPosition = savedInstanceState.getInt("position");
			
			if(restoredPosition!=-1) {
				onHandleElementClick(restoredPosition);
			} // end inner if
		} // end outer if
	} // end method onCreate

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	} // end method onCreateOptionsMenu

	
	@Override
	public void onHandleElementClick(int position) {

		this.lastPosition = position;
		Log.i(TAG, "Clicked at position: " + position);
		element.putInt("position", position);
		
		if (dualPane) {
			Fragment ElementDetails = new ElementsDetailsFragment();
			FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
			
			ElementDetails.setArguments(element);

			// Replace whatever is in the fragment_container view with this fragment,
			// and add the transaction to the back stack so the user can navigate back
			transaction.replace(R.id.infoFrame, ElementDetails);
			transaction.addToBackStack(null);
			// Commit the transaction
			transaction.commit();
		} // end if
		else {
			Intent intent = new Intent(this, ElementsDetailsActivity.class);
			intent.putExtra("bundle", element);
			startActivity(intent);
		} // end else
	} // end method onHandleElementClick

	
	@Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		outState.putInt("position", lastPosition);
	} // end method onSaveInstanceState
	
	
	/*
	@Override
	protected void onStart() {
		Log.i(TAG, "onStart");
		super.onStart();
	} // end method onStart
	
	@Override
	protected void onPause() {
		Log.i(TAG, "onPause");
		super.onPause();
	} // end method onPause

	@Override
	protected void onResume() {
		Log.i(TAG, "onResume");
		super.onResume();
	} // end method onResume

	@Override
	protected void onStop() {
		Log.i(TAG, "onStop");
		super.onStop();
	} // end method onStop
	
	@Override
	protected void onDestroy() {
		Log.i(TAG, "onDestroy");
		super.onDestroy();
	} // end method onDestroy
	*/
	
} // end Class MainActivity
