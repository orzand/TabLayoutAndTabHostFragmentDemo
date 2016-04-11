package com.orzand.tablayoutandtabhostfragmentdemo;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class MyViewPagerAdapter extends FragmentPagerAdapter {
    private static final String TITLE = "TITLE";
//	private static final String ICON = "ICON";

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
        // just text
        if (fragments.get(position).getArguments() != null) {
            return fragments.get(position).getArguments().getString(TITLE);
        }

        return "";

        // both text and icon
//		Fragment fragment = fragments.get(position);
//		if (fragment.getArguments() != null) {
//			Drawable image = context.getResources().getDrawable(fragment.getArguments().getInt(ICON));
//			image.setBounds(0, 0, image.getIntrinsicWidth() * 2, image.getIntrinsicHeight() * 2);
//			SpannableString sb = new SpannableString(fragment.getArguments().getString(TITLE));
//			ImageSpan imageSpan = new ImageSpan(image, ImageSpan.ALIGN_BOTTOM);
//			sb.setSpan(imageSpan, 0, 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
//			return sb;
//		}
//
//		return "";
    }

//	public View getTabView(int position) {
//		View view = LayoutInflater.from(getContext()).inflate(R.layout.tab_title, null);
//
//		TextView textView = (TextView) view.findViewById(R.id.tv_tab_title);
//		textView.setText(VIEW_PAGER_TITLES[position]);
//
//		ImageView imageView = (ImageView) view.findViewById(R.id.iv_tab_icon);
//		imageView.setImageResource(R.drawable.tab1_icon);
//
////        if (0 == position){
////            imageView.setSelected(true);
////            textView.setSelected(true);
////        } else {
////            imageView.setSelected(false);
////            textView.setSelected(false);
////        }
//
//		return view;
//	}
}
