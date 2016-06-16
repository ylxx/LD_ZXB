package com.ld_zxb.activity.secondary;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.ld_zxb.R;
import com.ld_zxb.entity.SearchEntity;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

public class SearchContent extends AppCompatActivity {
    SearchEntity searchEntity;
    ListView lv_search;
    List<SearchEntity.EntityBean.CourseListBean> cours;
    private DisplayImageOptions options = new DisplayImageOptions.Builder()
            .cacheInMemory(true).cacheOnDisk(true)
            .showImageForEmptyUri(R.drawable.default_picture)
            .showImageOnFail(R.drawable.default_picture)
            .showImageOnLoading(R.drawable.default_picture).build();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_content);
        initView();
    }

    private void initView() {
        cours = (List<SearchEntity.EntityBean.CourseListBean>) getIntent().getSerializableExtra("searchEntity");
        lv_search = (ListView) findViewById(R.id.search_listview);
        mApdater adapter = new mApdater(this,cours);
        lv_search.setAdapter(adapter);
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
                view = mInflater.inflate(R.layout.informationitem,null);
                viewHolder.search_icon = (ImageView) view.findViewById(R.id.img_icon);
                viewHolder.search_title = (TextView) view.findViewById(R.id.tv_title);
                viewHolder.search_time = (TextView) view.findViewById(R.id.tv_time);
                view.setTag(viewHolder);
            }else{
                viewHolder = (ViewHolder) view.getTag();

            }
			ImageLoader.getInstance().displayImage("http://static.langdunzx.com/"+entity.get(position).getLogo(),viewHolder.search_icon,options);
            viewHolder.search_title.setText(entity.get(position).getTitle());
//            viewHolder.search_time.setText(entity.get(position).getTeacherList().get(position));
            return view;
        }
    }
    class ViewHolder {
        ImageView search_icon;
        TextView search_title;
        TextView search_time;
    }
}
