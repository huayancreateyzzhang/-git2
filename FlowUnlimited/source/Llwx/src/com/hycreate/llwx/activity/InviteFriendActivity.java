package com.hycreate.llwx.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.ViewPager.LayoutParams;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.Toast;

public class InviteFriendActivity extends Activity {

	private Integer[] mps = { R.drawable.invite_garrery1, R.drawable.invite_garrery2,
			R.drawable.invite_garrery3, R.drawable.invite_garrery4, R.drawable.invite_garrery5 };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.invite_main);
		Gallery gallery = (Gallery) findViewById(R.id.invite_gallery);
		gallery.setAdapter(new ImageAdapter(this));
		gallery.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> parent, View v,
					int position, long id) {
				Toast.makeText(InviteFriendActivity.this, "请先安装客户端.", Toast.LENGTH_SHORT).show();
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// 这里不做响应
			}
		});
	}

	class ImageAdapter extends BaseAdapter {
		private Context mContext;

		public ImageAdapter(Context context) {
			mContext = context;
		}

		public int getCount() {
			return mps.length;
		}

		public Object getItem(int position) {
			return position;
		}

		public long getItemId(int position) {
			return position;
		}

		public View getView(int position, View convertView, ViewGroup parent) {
			ImageView image = new ImageView(mContext);
			image.setImageResource(mps[position]);
			image.setAdjustViewBounds(true);
			image.setLayoutParams(new Gallery.LayoutParams(
					LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
			return image;
		}
	}
	
	public void back(View view) {
		InviteFriendActivity.this.finish();
	}
}
