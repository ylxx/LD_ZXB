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
import com.ld_zxb.vo.HomePageBottomEntityBodyVo;
import com.nostra13.universalimageloader.core.DisplayImageOptions;

import java.util.List;

/**
 * Created by cuiyinglai on 16/5/24.
 */
public class HomePageAdapter extends BaseAdapter{

    private Context context;
    private int width = 0;
    private List<HomePageBottomEntityBodyVo.CourseList> courseLists;
    private DisplayImageOptions options = new DisplayImageOptions.Builder()
            .cacheInMemory(true).cacheOnDisk(true)
            .showImageForEmptyUri(R.drawable.default_picture)
            .showImageOnFail(R.drawable.default_picture)
            .showImageOnLoading(R.drawable.default_picture).build();

    public HomePageAdapter(Context context, List<HomePageBottomEntityBodyVo.CourseList> courseLists)
    {
        super();
        this.context = context;
        this.courseLists = courseLists;
    }

    public List<HomePageBottomEntityBodyVo.CourseList> getCourseLists()
    {
        return courseLists;
    }

    public void setCourseLists(List<HomePageBottomEntityBodyVo.CourseList> courseLists)
    {
        this.courseLists = courseLists;
    }


    @Override
    public int getCount() {
        if (null != courseLists) {
            // double d =2;
            return (int) Math.ceil(courseLists.size() / 2d);
        } else {
            return 0;
        }
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
    public View getView(int position, View view, ViewGroup parent)
    {
        final ViewHolder holder;
        if (view == null) {
            holder = new ViewHolder();
            view = LayoutInflater.from(context).inflate(
                    R.layout.listitem_homepage, null);




        }



        return null;
    }



    private class ViewHolder {
        int position;
        private LinearLayout ll;
        private LinearLayout ll2;
        private ImageView ivCourse1;
        private ImageView ivCourse2;
        private TextView courseName1, courseTeacher1;
        // ；doc_type类别
        private TextView courseName2, courseTeacher2;
    }
}
