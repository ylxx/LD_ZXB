package com.ld_zxb.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.ld_zxb.R;
import com.ld_zxb.vo.HomePageBottomEntityBodyVo;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

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

            holder.ll = (LinearLayout) view.findViewById(R.id.ll);
            holder.courseName1 = (TextView) view.findViewById(R.id.course_name1);
            holder.ivCourse1 =(ImageView) view.findViewById(R.id.course_iv1);
            holder.courseTeacher1 =(TextView) view.findViewById(R.id.course_teacher1);
            holder.ll.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context,"11111",Toast.LENGTH_SHORT).show();
                }
            });

            holder.ll2 = (LinearLayout) view.findViewById(R.id.ll2);
            holder.courseName2 = (TextView) view.findViewById(R.id.course_name2);
            holder.ivCourse2 =(ImageView) view.findViewById(R.id.course_iv2);
            holder.courseTeacher2 =(TextView) view.findViewById(R.id.course_teacher2);
            holder.ll2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context,"22222",Toast.LENGTH_SHORT).show();
                }
            });

            //view 事件的观察者，根据图片宽度设置图片高度
            ViewTreeObserver vto = holder.ivCourse1.getViewTreeObserver();
            ViewTreeObserver vto2 = holder.ivCourse2.getViewTreeObserver();

            vto.addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
                @Override
                public boolean onPreDraw() {
                    width = holder.ivCourse1.getMeasuredWidth();
                    LinearLayout.LayoutParams linearParams = (LinearLayout.LayoutParams) holder.ivCourse1
                            .getLayoutParams();
                    linearParams.height = width*22/35;

                    linearParams.width = width;
                    holder.ivCourse1.setLayoutParams(linearParams);

                    return true;
                }
            });

            vto2.addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
                public boolean onPreDraw() {
                    width = holder.ivCourse1.getMeasuredWidth();

                    LinearLayout.LayoutParams linearParams = (LinearLayout.LayoutParams) holder.ivCourse1
                            .getLayoutParams();
                    linearParams.height = width*22/35;
                    linearParams.width = width;
                    holder.ivCourse2.setLayoutParams(linearParams);
                    return true;
                }
            });
            view.setTag(holder);
        }else{
            holder = (ViewHolder) view.getTag();
        }
        holder.position = position;

        HomePageBottomEntityBodyVo.CourseList courseList1 = courseLists.get(position * 2);
        String url = courseList1.getLogo();
        ImageLoader.getInstance().displayImage("http://static.langdunzx.com/"+url,holder.ivCourse1,options);
        holder.courseTeacher1.setText("主讲："+courseList1.getTeacherList().get(0));
        holder.courseName1.setText(courseList1.getName());
        if (position * 2 + 1 < courseLists.size()) {
            holder.ll2.setVisibility(View.VISIBLE);
            HomePageBottomEntityBodyVo.CourseList courseList2 = courseLists.get(position * 2 + 1);
            // String url =
            ImageLoader.getInstance().displayImage(
                    "http://static.langdunzx.com/"+courseList2.getLogo(), holder.ivCourse2, options);
            holder.courseTeacher2.setText("主讲："+courseList2.getTeacherList().get(0));
            holder.courseName2.setText(courseList2.getName());

        } else {
            holder.ll2.setVisibility(View.INVISIBLE);
        }

        return view;
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
