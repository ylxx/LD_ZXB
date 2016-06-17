package com.ld_zxb.activity.secondary;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.handmark.pulltorefresh.library.ILoadingLayout;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.ld_zxb.R;
import com.ld_zxb.activity.BaseFragmentActivity;
import com.ld_zxb.application.DCApplication;
import com.ld_zxb.config.Constants;
import com.ld_zxb.controller.BaseHandler;
import com.ld_zxb.controller.RequestCommant;
import com.ld_zxb.entity.SearchEntity;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.HashMap;
import java.util.List;

public class SearchContent extends BaseFragmentActivity {
    private String Content;
    private TextView search_content_title;
    private ImageView iv_back;
//    private ListView lv_search;
    private PullToRefreshListView mPullToRefreshListView;
    private DCApplication mApplication;
    private List<SearchEntity.EntityBean.CourseListBean> cours;
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
            if(msg.what == Constants.SEARCH){
                mPullToRefreshListView.onRefreshComplete();
                if(command.success){
                    try{
                        SearchEntity s = (SearchEntity) command.resData;
                        cours = s.getEntity().getCourseList();
                        mApdater adapter = new mApdater(SearchContent.this,cours);
                        mPullToRefreshListView.setAdapter(adapter);
                        Toast.makeText(SearchContent.this, ""+Content, Toast.LENGTH_SHORT).show();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_content);
        Content =  getIntent().getStringExtra("Content");
        search_content_title = (TextView) findViewById(R.id.search_content_title);
        search_content_title.setText(Content);
        bindViews();
        initView();
    }

    private void bindViews() {
        //下拉刷新
        mApplication = (DCApplication) this.getApplication();
        mPullToRefreshListView = (PullToRefreshListView)findViewById(R.id.gridview);
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
                initdata(Content);
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase refreshView) {
                initdata(Content);
            }
        });
    }

    private void initView() {
//        lv_search = (ListView) findViewById(R.id.search_listview);
        iv_back = (ImageView) findViewById(R.id.search_content_back);
        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchContent.this.finish();
            }
        });
        initdata(Content);
    }

    private void initdata(String s) {
        HashMap<String, String> hashmap = new HashMap<String, String>();
        hashmap.put("currentPage", "1");
        hashmap.put("courseName", ""+s);//搜索内容
        new RequestCommant().requestSearch(new requetHandle(SearchContent.this),SearchContent.this, hashmap);
    }

    class mApdater extends BaseAdapter {
        List<SearchEntity.EntityBean.CourseListBean> entity;
        private LayoutInflater mInflater = null;
        private mApdater(Context context, List<SearchEntity.EntityBean.CourseListBean> entity){
            this.mInflater = LayoutInflater.from(context);
            this.entity = entity;
        }
        @Override
        public int getCount() {
            return entity.size();
        }

        @Override
        public Object getItem(int position) {
            return entity.get(position);
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
                view = mInflater.inflate(R.layout.search_content_item,null);
                viewHolder.search_icon = (ImageView) view.findViewById(R.id.search_img_icon);
                viewHolder.search_title = (TextView) view.findViewById(R.id.search_item_title);
                viewHolder.search_time = (TextView) view.findViewById(R.id.search_item_laoshi);
                view.setTag(viewHolder);
            }else{
                viewHolder = (ViewHolder) view.getTag();

            }
			ImageLoader.getInstance().displayImage("http://static.langdunzx.com/"+entity.get(position).getLogo(),viewHolder.search_icon,options);
            viewHolder.search_title.setText(entity.get(position).getTitle());
            viewHolder.search_time.setText("讲师:"+entity.get(position).getTeacherList());
            return view;
        }
    }
    class ViewHolder {
        ImageView search_icon;
        TextView search_title;
        TextView search_time;
    }
}
