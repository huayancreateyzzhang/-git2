package com.hycreate.llwx.adapter;

import java.util.ArrayList;

import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import com.hycreate.llwx.activity.R;

public class GuidePageAdapter extends PagerAdapter {

	private static final String TAG = "GuidePageAdapter";
	private ArrayList<View> pageViews;
	private ImageView[] imageViews;

	public GuidePageAdapter(ArrayList<View> pageViews, ImageView[] imageViews) {
		this.pageViews = pageViews;
		this.imageViews = imageViews;

		Log.d(TAG, this.pageViews.size() + "");
	}

	@Override
	public int getCount() {
		return pageViews.size();
	}

	@Override
	public boolean isViewFromObject(View arg0, Object arg1) {
		return arg0 == arg1;
	}

	@Override
	public int getItemPosition(Object object) {
		// TODO Auto-generated method stub
		return super.getItemPosition(object);
	}

	@Override
	public void destroyItem(View arg0, int arg1, Object arg2) {
		// TODO Auto-generated method stub
		((ViewPager) arg0).removeView(pageViews.get(arg1));
	}

	@Override
	public Object instantiateItem(View arg0, int arg1) {
		// TODO Auto-generated method stub
		((ViewPager) arg0).addView(pageViews.get(arg1));
		return pageViews.get(arg1);
	}

	@Override
	public void restoreState(Parcelable arg0, ClassLoader arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public Parcelable saveState() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void startUpdate(View arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void finishUpdate(View arg0) {
		// TODO Auto-generated method stub

	}

	/** 指引页面改监听器 */
	public class GuidePageChangeListener implements OnPageChangeListener {

		@Override
		public void onPageScrollStateChanged(int arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2) {
			// TODO Auto-generated method stub

		}

		@Override
		public void onPageSelected(int arg0) {
			for (int i = 0; i < imageViews.length; i++) {
				imageViews[arg0]
						.setBackgroundResource(R.drawable.page_indicator_focused);
				if (arg0 != i) {
					imageViews[i]
							.setBackgroundResource(R.drawable.page_indicator);
				}
			}

		}

	}

}