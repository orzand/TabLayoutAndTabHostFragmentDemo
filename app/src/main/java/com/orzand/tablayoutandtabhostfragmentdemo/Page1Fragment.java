package com.orzand.tablayoutandtabhostfragmentdemo;

import android.support.v4.app.Fragment;
import android.view.View;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.os.Bundle;
import android.widget.TextView;

public class Page1Fragment extends Fragment  {
	private static final String TITLE = "TITLE";
//    private static final String ICON = "ICON";

    private TextView tvText;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.page1_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tvText = (TextView) view.findViewById(R.id.tv_text);
    }

	public static Page1Fragment getInstance(String title) {
		Page1Fragment fragment = new Page1Fragment();
		Bundle bundle = new Bundle();
		bundle.putString(TITLE, title);
//        bundle.putInt(ICON, resId);
		fragment.setArguments(bundle);
		return fragment;
	}
}
