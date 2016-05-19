package com.ld_zxb.fragment.informationpage;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.ld_zxb.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VpSimpleFragment extends Fragment {

	private View view;
	private String mTitle;
	private int position;
	private static final String BUNDLE_TITLE = "title";
	private List<Map<String, Object>> data;

	//	@Override
	//	public void onAttach(Activity activity) {
	//		// TODO Auto-generated method stub
	//		super.onAttach(activity);
	//		LogUtil.e("VpSimpleFragment", "onAttach()");
	//	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		//LogUtil.e("VpSimpleFragment", "onCreate()");
	}


		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			super.onCreateView(inflater, container, savedInstanceState);
			Bundle bundle = getArguments();
			if (bundle != null) {
				mTitle = bundle.getString(BUNDLE_TITLE);
				position=bundle.getInt("position");
			}
			data = getData();
			view = inflater.inflate(R.layout.information_data, null);
			ListView li = (ListView) view.findViewById(R.id.informationdata);
			mApdater mapdater = new mApdater(getActivity());
			li.setAdapter(mapdater);
		return view;
	}

	public static VpSimpleFragment newInstance(String title,int position) {
		Bundle bundle = new Bundle();
		bundle.putString(BUNDLE_TITLE, title);
		bundle.putInt("position", position);
		VpSimpleFragment fragment = new VpSimpleFragment();
		fragment.setArguments(bundle);

		return fragment;
	}
	private List<Map<String, Object>> getData()
	{
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		Map<String, Object> map;
		for(int i=0;i<10;i++)
		{
			map = new HashMap<String, Object>();
			map.put("img", R.drawable.ic_img_profile_bg);
			map.put("title", "我家酸奶没了  面都没见着");
			map.put("info", "2016.5.18 13:00");
			list.add(map);
		}
		return list;
	}


	class mApdater extends BaseAdapter {
		private LayoutInflater mInflater = null;
		private mApdater(Context context){
			this.mInflater = LayoutInflater.from(context);
		}
		@Override
		public int getCount() {
			return data.size();
		}

		@Override
		public Object getItem(int position) {
			return position;
		}

		@Override
		public long getItemId(int position) {
			return position;
		}

		@Override
		public View getView(int position, View view, ViewGroup parent) {
			ViewHolder viewHolder = null;
			if(view ==null){
				viewHolder = new ViewHolder();
				view = mInflater.inflate(R.layout.informationitem,null);
				viewHolder.info_icon = (ImageView) view.findViewById(R.id.img_icon);
				viewHolder.tv_title = (TextView) view.findViewById(R.id.tv_title);
				viewHolder.tv_time = (TextView) view.findViewById(R.id.tv_time);
				view.setTag(viewHolder);
			}else{
				viewHolder = (ViewHolder) view.getTag();

			}
			viewHolder.info_icon.setBackgroundResource((Integer)data.get(position).get("img"));
			viewHolder.tv_title.setText((String)data.get(position).get("title"));
			viewHolder.tv_time.setText((String)data.get(position).get("info"));
			return view;
		}
	}
	class ViewHolder {
		ImageView info_icon;
		TextView tv_title;
		TextView tv_time;
	}


}
