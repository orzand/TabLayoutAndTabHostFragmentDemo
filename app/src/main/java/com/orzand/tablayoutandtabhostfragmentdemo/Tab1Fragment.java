package com.orzand.tablayoutandtabhostfragmentdemo;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Tab1Fragment extends Fragment {
	private static final String TAG = "Tab1Fragment";
	private static final String[] VIEW_PAGER_TITLES = {"Page 1", "Page 2", "Page 3", "Page 4", "Page 5"};

	private View view;
	private TabLayout tbl;
	private ViewPager vp;
	private boolean created = false;
	private ArrayList<Fragment> fragments;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		if (view == null) {
			Log.d(TAG, "onCreateView: " + getTag());
			view = inflater.inflate(R.layout.tab1_fragment, container, false);
		}

		return view;
	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);

		if (!created) {
			Log.d(TAG, "onViewCreated: " + getTag());
			initView();
			created = true;
		}
	}

	private void initView() {
		Log.d(TAG, "initView: " + getTag());

		tbl = (TabLayout) view.findViewById(R.id.tbl);
		vp = (ViewPager) view.findViewById(R.id.vp);

		fragments = new ArrayList<>();
		for (String title : VIEW_PAGER_TITLES) {
			fragments.add(Page1Fragment.getInstance(title));
		}

		MyViewPagerAdapter adapter = new MyViewPagerAdapter(getChildFragmentManager(), fragments, getContext());
		vp.setAdapter(adapter);

		tbl.setupWithViewPager(vp);
		tbl.setTabsFromPagerAdapter(adapter);

		// setup custom tab
		for (int i = 0; i < tbl.getTabCount(); i++) {
			TabLayout.Tab tab = tbl.getTabAt(i);

//            View view = getTabView(i);
//            if (i == 0) {
//                view.setSelected(true);
//            }

			tab.setCustomView(getTabView(i));
		}
	}

	private View getTabView(int position) {
		View view = LayoutInflater.from(getContext()).inflate(R.layout.tab_title, null);

		TextView textView = (TextView) view.findViewById(R.id.tv_tab_title);
		textView.setText(VIEW_PAGER_TITLES[position]);

		ImageView imageView = (ImageView) view.findViewById(R.id.iv_tab_icon);
		imageView.setImageResource(R.drawable.tab1_icon);

		if (0 == position) {
			view.setSelected(true);
		}

		return view;
	}
}
