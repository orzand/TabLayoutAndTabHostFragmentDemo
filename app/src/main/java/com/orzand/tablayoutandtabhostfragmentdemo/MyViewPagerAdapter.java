package com.orzand.tablayoutandtabhostfragmentdemo;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class MyViewPagerAdapter extends FragmentPagerAdapter {
	private static final String TITLE = "TITLE";

	private ArrayList<Fragment> fragments;
	//	private FragmentManager fragmentManager;
	private Context context;

	public MyViewPagerAdapter(FragmentManager fm, ArrayList<Fragment> fragments, Context context) {
		super(fm);
		this.fragments = fragments;
		//		this.fragmentManager = fm;
		this.context = context;
	}

	@Override
	public Fragment getItem(int position) {
		return fragments.get(position);
	}

	@Override
	public int getCount() {
		return fragments == null ? 0 : fragments.size();
	}

	@Override
	public CharSequence getPageTitle(int position) {
		if (fragments.get(position).getArguments() != null) {
			return fragments.get(position).getArguments().getString(TITLE);
		}

		return "";
	}

}
