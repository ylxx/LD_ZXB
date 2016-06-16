package com.ld_zxb.fragment.informationpage;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.handmark.pulltorefresh.library.ILoadingLayout;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.ld_zxb.R;
import com.ld_zxb.activity.InformationContext;
import com.ld_zxb.application.DCApplication;
import com.ld_zxb.config.Constants;
import com.ld_zxb.controller.BaseHandler;
import com.ld_zxb.controller.RequestCommant;
import com.ld_zxb.entity.infor;
import com.ld_zxb.fragment.BaseBackFragment;
import com.nostra13.universalimageloader.core.DisplayImageOptions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VpSimpleFragmentA extends BaseBackFragment {

	private View view;
	private String mTitle;
	private int position;
	private static final String BUNDLE_TITLE = "title";
	private List<Map<String, Object>> data;
	private PullToRefreshListView mPullToRefreshListView;
	private DCApplication mApplication;
	infor info;
	List<infor.EntityBean.NewsBean> infordata;
	mApdater mapdater ;
	private DisplayImageOptions options = new DisplayImageOptions.Builder()
			.cacheInMemory(true).cacheOnDisk(true)
			.showImageForEmptyUri(R.drawable.default_picture)
			.showImageOnFail(R.drawable.default_picture)
			.showImageOnLoading(R.drawable.default_picture).build();

	private class requetHandle extends BaseHandler {
		public requetHandle(Activity activity) {
			super(activity);
			// TODO Auto-generated constructor stub
		}
		@Override
		public void handleMessage(Message msg) {
			super.handleMessage(msg);
			if(msg.what == Constants.INFORMATION){
				mPullToRefreshListView.onRefreshComplete();
				if(command.success){
					info = (infor) command.resData;
					infordata = info.getEntity().getNews();
					mapdater = new mApdater(getActivity(),infordata);
					mPullToRefreshListView.setAdapter(mapdater);
					mPullToRefreshListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
						@Override
						public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
							Intent in = new Intent(getActivity(),InformationContext.class);
							in.putExtra("InforID",infordata.get(position-1).getZj());
							in.putExtra("InforTitle",infordata.get(position-1).getTitle());
							in.putExtra("InforContext",infordata.get(position-1).getContent());
							in.putExtra("InforAuthor",infordata.get(position-1).getAuthor());
							in.putExtra("InforSource",infordata.get(position-1).getSource());
							in.putExtra("inforTimer", infordata.get(position-1).getColstr10());
							startActivity(in);
						}
					});
				}
			}
		}
	}

	private void initData() {
		HashMap<String, String> hashmap = new HashMap<String, String>();

//		hashmap.put("currentPage", "1");
//		hashmap.put("pageSize", "3");

		new RequestCommant().requestInformation(new requetHandle(getActivity()), getActivity(), hashmap);
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

		view = inflater.inflate(R.layout.information_pull, null);
		bindViews();
		initData();
		return view;
	}

	private void bindViews() {
		//下拉刷新
		mApplication = (DCApplication) getActivity().getApplication();
		mPullToRefreshListView = (PullToRefreshListView) view
				.findViewById(R.id.gridview);
		//mPullToRefreshListView.getRefreshableView().addHeaderView(View.inflate(getActivity(),R.layout.fragment_information,null));
		mPullToRefreshListView.setMode(PullToRefreshBase.Mode.BOTH);
		ILoadingLayout loadingLayoutProxy = mPullToRefreshListView
				.getLoadingLayoutProxy(true, false);
		loadingLayoutProxy.setPullLabel("下拉刷新...");// 刚下拉时，显示的提示
		loadingLayoutProxy.setRefreshingLabel("正在刷新...");// 刷新时
		loadingLayoutProxy.setReleaseLabel("放开刷新...");// 下来达到一定距离时，显示的提示
		ILoadingLayout loadingLayoutProxyBottom = mPullToRefreshListView
				.getLoadingLayoutProxy(false, true);
		loadingLayoutProxyBottom.setPullLabel("上拉加载更多...");// 刚下拉时，显示的提示
		loadingLayoutProxyBottom.setRefreshingLabel("正在载入...");// 刷新时
		loadingLayoutProxyBottom.setReleaseLabel("放开加载更多...");// 下来达到一定距离时，显示的提示

		mPullToRefreshListView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2() {

			@Override
			public void onPullDownToRefresh(PullToRefreshBase refreshView) {
				initData();
			}

			@Override
			public void onPullUpToRefresh(PullToRefreshBase refreshView) {
				initData();
			}
		});
	}

	public static VpSimpleFragmentA newInstance(String title,int position) {
		Bundle bundle = new Bundle();
		bundle.putString(BUNDLE_TITLE, title);
		bundle.putInt("position", position);
		VpSimpleFragmentA fragment = new VpSimpleFragmentA();
		fragment.setArguments(bundle);
		return fragment;

	}



	class mApdater extends BaseAdapter {
		List<infor.EntityBean.NewsBean> infos;
		private LayoutInflater mInflater = null;
		private mApdater(Context context,List<infor.EntityBean.NewsBean> infor){
			this.mInflater = LayoutInflater.from(context);
			this.infos = infor;
		}
		@Override
		public int getCount() {
			return infos.size();
		}

		@Override
		public Object getItem(int position) {
			return infos.get(position);
		}

		@Override
		public long getItemId(int position) {
			return position;
		}

		@TargetApi(Build.VERSION_CODES.JELLY_BEAN)
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
//			viewHolder.info_icon.setImageBitmap(infos.get(position).getPicture());
//			ImageLoader.getInstance().displayImage(infos.get(position).getPicture(),viewHolder.info_icon,options);
			viewHolder.tv_title.setText(infos.get(position).getTitle());
			viewHolder.tv_time.setText(infos.get(position).getColstr10());
			return view;
		}
	}
	class ViewHolder {
		ImageView info_icon;
		TextView tv_title;
		TextView tv_time;
	}

}
