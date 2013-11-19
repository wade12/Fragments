package com.wade12.fragments;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;

public class ElementsDetailsActivity extends FragmentActivity {

	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		setContentView(R.layout.elements_details_activity);
		
		if(this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
			
			finish();
		} // end if
		
		Intent intent = this.getIntent();
		Bundle element = intent.getBundleExtra("bundle");
		
		
		Fragment ElementDetails = new ElementsDetailsFragment();
		FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
		
		ElementDetails.setArguments(element);

		// Replace whatever is in the fragment_container view with this fragment,
		// and add the transaction to the back stack so the user can navigate back
		transaction.replace(R.id.elementDetailsFrame, ElementDetails);
		// Commit the transaction
		transaction.commit();
		
	} // end method onCreate

} // end Class ElementsDetailsActivity
