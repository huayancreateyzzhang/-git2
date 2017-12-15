package com.hycreate.llwx.adapter;

import java.util.ArrayList;

import android.content.Context;
import android.renderscript.Program;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.hycreate.llwx.activity.R;
import com.hycreate.llwx.bean.LeftMenu;

public class LeftListAdapter extends BaseAdapter {

	private static final String TAG="LeftListAdapter";
	private ArrayList<LeftMenu> menuList;
	private Context context;

	private LayoutInflater inflater;
	private LayoutHolder layoutHolder;
	private RelativeLayout layout = null;

	private TextView menu_name;
	private ImageView menu_image;
	
	public LeftListAdapter(ArrayList<LeftMenu> menuList, Context context) {
		this.menuList = menuList;
		this.context = context;
		
		inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	public int getCount() {
		return menuList.size();
	}

	public Object getItem(int position) {
		return menuList.get(position);
	}

	public long getItemId(int position) {
		return position;
	}

	public View getView(int position, View view, ViewGroup parent) {
		if (view == null) {
			view = inflater.inflate(R.layout.left_listview_itme, null, false);
		}
		
		layoutHolder = (LayoutHolder) view.getTag();
		if (layoutHolder == null) {
			layoutHolder = new LayoutHolder();
			
			layoutHolder.layout = (RelativeLayout) view
					.findViewById(R.id.menu_item_id);
			layoutHolder.menu_image = (ImageView) view
					.findViewById(R.id.menu_image);
			layoutHolder.menu_name = (TextView) view
					.findViewById(R.id.menu_name);

			view.setTag(layoutHolder);
		}
		this.layout = layoutHolder.layout;
		this.menu_name = layoutHolder.menu_name;
		this.menu_image = layoutHolder.menu_image;

		Log.d(TAG, menuList.get(position).getName());
		this.menu_name.setText(menuList.get(position).getName());
//		this.menu_image.setBackgroundResource();
		return view;
	}

	private static final class LayoutHolder {
		RelativeLayout layout;
		TextView menu_name;
		ImageView menu_image;
	}
}
