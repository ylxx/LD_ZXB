package com.ld_zxb.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ld_zxb.R;
import com.ld_zxb.vo.ParticularCourseEntityVo.ParticularCourseBodyVo.CatalogList;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cuiyinglai on 16/6/14.
 */
public class ContentsAdapter extends BaseAdapter{

    private Context context;
    private List<CatalogList.ChildList> childLists = new ArrayList<CatalogList.ChildList>();

    public ContentsAdapter (Context context, List<CatalogList.ChildList> childLists){
        super();
        this.childLists = childLists;
        this.context = context;

    }

    @Override
    public int getCount() {

            return 0;


    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        final ViewHolder holder;
        if(view == null){
            holder = new ViewHolder();
            view = LayoutInflater.from(context).inflate(
                    R.layout.item_contents, null);

            holder.tvTime = (TextView) view.findViewById(R.id.tv_contents_long);
            holder.tvTitle = (TextView) view.findViewById(R.id.tv_contents_title);

            holder.tvTime.setText(childLists.get(position).getListenSeconds());
            holder.tvTitle.setText(childLists.get(position).getVideoName());

        }else{
            holder = (ViewHolder) view.getTag();
        }

        return view;
    }

    private class ViewHolder {
        int position;
        private TextView tvTitle, tvTime;
    }
}
