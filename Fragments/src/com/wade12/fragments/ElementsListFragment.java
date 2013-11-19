package com.wade12.fragments;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ElementsListFragment extends Fragment implements OnItemClickListener {

	String TAG = this.getClass().getSimpleName();
	ListView elementsList;
	ArrayAdapter<String> adapter;
	Context context;
	ElementsListClickHandler handler;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		Log.i(TAG, "onCreate");
		super.onCreate(savedInstanceState);
		// The activity is being created.
	} // end method onCreate
	
	
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		
		try {
			handler = (ElementsListClickHandler) getActivity();
		} // end try
		catch (ClassCastException exception){
			Log.i(TAG, "Activity " + getActivity().getClass().getSimpleName() + 
					" activity does not implement the ElementsListClickHandler interface");
		} // end catch
	} // end method onAttach
	
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// Log.i(TAG, "onCreateView");
		
		context = getActivity();
		View view;
		view = inflater.inflate(R.layout.elements_list_fragment, container, false);
		
		String[] elements = context.getResources().getStringArray(R.array.ElementsArray);
		
		elementsList = (ListView) view.findViewById(R.id.elementsList);
		adapter = new ArrayAdapter<String>(context, R.layout.elements_row, R.id.elementsListText, elements);
		
		elementsList.setAdapter(adapter);
		elementsList.setOnItemClickListener(this);
		
		return view;
	} // end method onCreateView
	
	
	public interface ElementsListClickHandler {
		
		public void onHandleElementClick (int position);
		// end method onHandleElementClick
	} // end interface ElementsListClickHandler


	@Override
	public void onItemClick(AdapterView<?> arg0, View view, int position, long arg3) {
		
		handler.onHandleElementClick(position);
	} // end method onItemClick
	
	
	/*
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		Log.i(TAG, "onActivityCreated");
		super.onActivityCreated(savedInstanceState);
	} // end method onActivityCreated

	@Override
	public void onAttach(Activity activity) {
		Log.i(TAG, "onAttach");
		super.onAttach(activity);
	} // end method onAttach
	
	@Override
	public void onStart() {
		Log.i(TAG, "onStart");
		super.onStart();
		// The activity is about to become visible.
	} // end method onStart
	
	@Override
	public void onResume() {
		Log.i(TAG, "onResume");
		super.onResume();
		// The activity has become visible (it is now "resumed").
	} // end method onResume
	
	@Override
	public void onPause() {
		Log.i(TAG, "onPause");
		super.onPause();
		// Another activity is taking focus (this activity is about to be "paused").
	} // end method onPause
	
	@Override
	public void onStop() {
		Log.i(TAG, "onStop");
		super.onStart();
		// The activity is no longer visible (it is now "stopped")
	} // end method onStop

	@Override
	public void onDestroyView() {
		Log.i(TAG, "onDestroyView");
		super.onDestroyView();
	} // end method onDestroyView
	
	@Override
	public void onDestroy() {
		Log.i(TAG, "onDestroy");
		super.onDestroy();
		// The activity is about to be destroyed.
	} // end method onDestroy

	@Override
	public void onDetach() {
		Log.i(TAG, "onDetach");
		super.onDetach();
	} // end method onDetach
	*/

} // end Class ElementsListFragment
