package com.hycreate.llwx.fragment;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.hycreate.llwx.activity.R;
import com.hycreate.llwx.adapter.LeftListAdapter;
import com.hycreate.llwx.bean.LeftMenu;

public class LeftFragment extends Fragment {
	

	private View view=null;
	
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.left, null);
		
		return view;
	}

	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		Context contex = getActivity();
		ListView lv1 =(ListView) view.findViewById(R.id.left_list1);
		ListView lv2 =(ListView) view.findViewById(R.id.left_list2);
		ListView lv3 =(ListView) view.findViewById(R.id.left_list3);
		ArrayList<LeftMenu> leftMenuList1 = (ArrayList<LeftMenu>) getLeftMenu1();
		LeftListAdapter leftListAdapter1 = new LeftListAdapter((ArrayList<LeftMenu>)leftMenuList1, contex);
		leftListAdapter1.notifyDataSetChanged();		
		lv1.setAdapter(leftListAdapter1);
		lv1.setOnItemClickListener(listItemListener);
		
		ArrayList<LeftMenu> leftMenuList2 = (ArrayList<LeftMenu>) getLeftMenu2();
		LeftListAdapter leftListAdapter2 = new LeftListAdapter((ArrayList<LeftMenu>)leftMenuList2, contex);
		leftListAdapter2.notifyDataSetChanged();		
		lv2.setAdapter(leftListAdapter2);
		lv2.setOnItemClickListener(listItemListener);
		
		ArrayList<LeftMenu> leftMenuList3= (ArrayList<LeftMenu>) getLeftMenu1();
		LeftListAdapter leftListAdapter3 = new LeftListAdapter((ArrayList<LeftMenu>)leftMenuList3, contex);
		leftListAdapter3.notifyDataSetChanged();		
		lv3.setAdapter(leftListAdapter3);
		lv3.setOnItemClickListener(listItemListener);
	}
	private OnItemClickListener listItemListener = new OnItemClickListener() {

		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			ListView lView = (ListView) parent;
		}
	};
	
	private List<LeftMenu> getLeftMenu1() {
		List<LeftMenu> menuList1 = new ArrayList<LeftMenu>();
		LeftMenu menu1 = new LeftMenu();
		menu1.setName("我的资料");
		LeftMenu menu2 = new LeftMenu();
		menu2.setName("赚币记录");
		LeftMenu menu3 = new LeftMenu();
		menu3.setName("中奖记录");
		LeftMenu menu4 = new LeftMenu();
		menu4.setName("我的收藏");
		menuList1.add(menu1);
		menuList1.add(menu2);
		menuList1.add(menu3);
		menuList1.add(menu4);
		return menuList1;
	}
	private List<LeftMenu> getLeftMenu2() {
		List<LeftMenu> menuList1 = new ArrayList<LeftMenu>();
		LeftMenu menu1 = new LeftMenu();
		menu1.setName("新手教学");
		LeftMenu menu2 = new LeftMenu();
		menu2.setName("常见问题");
		LeftMenu menu3 = new LeftMenu();
		menu3.setName("在线反馈");
		menuList1.add(menu1);
		menuList1.add(menu2);
		menuList1.add(menu3);
		return menuList1;
	}
	private List<LeftMenu> getLeftMenu3() {
		List<LeftMenu> menuList1 = new ArrayList<LeftMenu>();
		LeftMenu menu1 = new LeftMenu();
		menu1.setName("系统设置");
		LeftMenu menu2 = new LeftMenu();
		menu2.setName("版本更新");
		LeftMenu menu3 = new LeftMenu();
		menu3.setName("关于我们");
		menuList1.add(menu1);
		menuList1.add(menu2);
		menuList1.add(menu3);
		return menuList1;
	}
}
