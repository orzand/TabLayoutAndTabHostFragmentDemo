package com.orzand.tablayoutandtabhostfragmentdemo;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
	private final static String[] TAB_TITLES = {"Tab 1", "Tab 2", "Tab 3", "Tab 4"};
	private final int[] TAB_ICON_IDS = {R.drawable.tab1_icon, R.drawable.tab2_icon, R.drawable.tab3_icon, R.drawable
			.tab4_icon,};
	private Class[] TAB_FRAGMENT_CLASS = {Tab1Fragment.class, Tab1Fragment.class, Tab1Fragment.class, Tab1Fragment
			.class};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		initView();
	}

	private void initView() {
		FragmentTabHost tabhost = (FragmentTabHost) findViewById(android.R.id.tabhost);

		tabhost.setup(this, getSupportFragmentManager(), android.R.id.tabcontent);
		tabhost.getTabWidget().setDividerDrawable(null);

		for (int i = 0; i < TAB_TITLES.length; i++) {
			TabHost.TabSpec tabSpec = tabhost.newTabSpec(TAB_TITLES[i]).setIndicator(getIndicatorView(i));
			tabhost.addTab(tabSpec, TAB_FRAGMENT_CLASS[i], null);
		}
	}

	private View getIndicatorView(int index) {
		@SuppressLint("InflateParams")
		View view = getLayoutInflater().inflate(R.layout.tabwidget_item, null);
		ImageView imageView = (ImageView) view.findViewById(R.id.iv_icon);
		imageView.setImageResource(TAB_ICON_IDS[index]);

		TextView textView = (TextView) view.findViewById(R.id.tv_title);
		textView.setText(TAB_TITLES[index]);
		return view;
	}
}
