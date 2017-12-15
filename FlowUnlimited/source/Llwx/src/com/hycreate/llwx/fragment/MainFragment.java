package com.hycreate.llwx.fragment;

import java.util.ArrayList;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;

import com.hycreate.jyz.activity.JyzMainActivity;
import com.hycreate.kxwyy.activity.AppMainActivity;
import com.hycreate.llwx.activity.InviteFriendActivity;
import com.hycreate.llwx.activity.R;
import com.hycreate.llwx.adapter.GuidePageAdapter;
import com.hycreate.nlp.activity.NlpMainActivity;

public class MainFragment extends Fragment {

	private ViewPager viewPager;
	private ArrayList<View> pageViews;
	private ViewGroup group;
	private ImageView imageView;
	private ImageView[] imageViews;

	private Context context = null;

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		context = getActivity();
		View view = inflater.inflate(R.layout.main_fragment_page, null);

		Button btn1 = (Button) view.findViewById(R.id.button1);
		btn1.setOnClickListener(btnClickListener);

		Button btn2 = (Button) view.findViewById(R.id.button2);
		btn2.setOnClickListener(btnClickListener);

		Button btn3 = (Button) view.findViewById(R.id.button3);
		btn3.setOnClickListener(btnClickListener);

		Button btn4 = (Button) view.findViewById(R.id.button4);
		btn4.setOnClickListener(btnClickListener);

		Button btn5 = (Button) view.findViewById(R.id.button5);
		btn5.setOnClickListener(btnClickListener);

		Button btn6 = (Button) view.findViewById(R.id.button6);
		btn6.setOnClickListener(btnClickListener);

		pageViews = new ArrayList<View>();
		pageViews.add(inflater.inflate(R.layout.item01, null));
		pageViews.add(inflater.inflate(R.layout.item02, null));
		pageViews.add(inflater.inflate(R.layout.item03, null));

		imageViews = new ImageView[pageViews.size()];
		// main = (ViewGroup) inflater.inflate(R.layout.page1, null);

		// group是R.layou.main中的负责包裹小圆点的LinearLayout.
		group = (ViewGroup) view.findViewById(R.id.viewGroup);

		viewPager = (ViewPager) view.findViewById(R.id.guidePages);

		for (int i = 0; i < pageViews.size(); i++) {
			imageView = new ImageView(getActivity());
			imageView.setLayoutParams(new LayoutParams(20, 20));
			imageView.setPadding(20, 0, 20, 0);
			imageViews[i] = imageView;
			if (i == 0) {
				// 默认选中第一张图片
				imageViews[i].setBackgroundResource(R.drawable.page_indicator_focused);
			} else {
				imageViews[i].setBackgroundResource(R.drawable.page_indicator);
			}
			group.addView(imageViews[i]);
		}

		viewPager.setAdapter(new GuidePageAdapter(pageViews, imageViews));
		viewPager.setOnPageChangeListener(new GuidePageAdapter(pageViews,imageViews).new GuidePageChangeListener());
		return view;
	}

	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);

	}

	OnClickListener btnClickListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			
			Intent intent = new Intent();
			switch (v.getId()) {
			
			case R.id.button1:
				intent.setClass(context, NlpMainActivity.class);
				context.startActivity(intent);
				break;
				
			case R.id.button2:
				intent.setClass(context, JyzMainActivity.class);
				context.startActivity(intent);
				break;
			case R.id.button3:

				break;
			case R.id.button4:
				intent.setClass(context, InviteFriendActivity.class);
				context.startActivity(intent);
				break;
			case R.id.button5:
				intent.setClass(context, AppMainActivity.class);
				context.startActivity(intent);
				break;
			case R.id.button6:

				break;

			default:
				break;
			}
		}
	};

	public boolean onTouch(View v, MotionEvent event) {
		switch (event.getAction()) {

		case MotionEvent.ACTION_MOVE:
			viewPager.requestDisallowInterceptTouchEvent(true);
			break;
		case MotionEvent.ACTION_UP:
		case MotionEvent.ACTION_CANCEL:
			viewPager.requestDisallowInterceptTouchEvent(false);
			break;
		}
		return false;
	}

}
