package com.orzand.tablayoutandtabhostfragmentdemo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Page1Fragment extends Fragment {
	private static final String TAG = "Page1Fragment";
	private static final String TITLE = "TITLE";

	public static Page1Fragment getInstance(String title) {
		Page1Fragment fragment = new Page1Fragment();
		Bundle bundle = new Bundle();
		bundle.putString(TITLE, title);
		fragment.setArguments(bundle);
		return fragment;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		return inflater.inflate(R.layout.page1_fragment, container, false);
	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);

		TextView tvText = (TextView) view.findViewById(R.id.tv_text);
		tvText.setText(getParentFragment().getTag() + " " + getArguments().getString(TITLE));

		Log.d(TAG, "" + tvText.getText());
	}
}
