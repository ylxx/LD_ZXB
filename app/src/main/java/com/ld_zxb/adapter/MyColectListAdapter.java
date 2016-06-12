package com.ld_zxb.adapter;

import java.util.List;

import com.ld_zxb.R;
import com.ld_zxb.activity.course.CourseDetailsActivty;
import com.ld_zxb.vo.CollectCourseEntityVo.Entity.CourseList;
import com.ld_zxb.vo.HomePageBottomEntityBodyVo;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MyColectListAdapter extends BaseAdapter{

	private Context context;
	private int width = 0;
	private List<CourseList> courseListVo;
	private DisplayImageOptions options = new DisplayImageOptions.Builder()
			.cacheInMemory(true).cacheOnDisk(true)
			.showImageForEmptyUri(R.drawable.default_picture)
			.showImageOnFail(R.drawable.default_picture)
			.showImageOnLoading(R.drawable.default_picture).build();

	public MyColectListAdapter (Context context,List<CourseList> courseListVo) {
		super();
		this.context = context;
		this.courseListVo = courseListVo;
	}

	public List<CourseList> getCourseListVo()
	{
		return courseListVo;
	}

	public void setCourseListVo(List<CourseList> courseListVo)
	{
		this.courseListVo = courseListVo;
	}

	@Override
	public int getCount() {
		if (null != courseListVo) {
			// double d =2;
			return (int) Math.ceil(courseListVo.size() / 2d);
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
	public View getView(int position, View view, ViewGroup parent) {

		final ViewHolder holder;
		if(view == null){
			holder = new ViewHolder();
			view = LayoutInflater.from(context).inflate(
					R.layout.listitem_collect, null);

			holder.ll = (LinearLayout) view.findViewById(R.id.ll_colect);
			holder.courseName1 = (TextView) view.findViewById(R.id.colect_course_name1);
			holder.ivCourse1 =(ImageView) view.findViewById(R.id.colect_course_iv1);
			holder.courseTeacher1 =(TextView) view.findViewById(R.id.colect_course_teacher1);


			holder.ll2 = (LinearLayout) view.findViewById(R.id.ll2_colect);
			holder.courseName2 = (TextView) view.findViewById(R.id.colect_course_name2);
			holder.ivCourse2 =(ImageView) view.findViewById(R.id.colect_course_iv2);
			holder.courseTeacher2 =(TextView) view.findViewById(R.id.colect_course_teacher2);

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

		if(position*2 < courseListVo.size()){
			CourseList courseList1 = courseListVo.get(position*2);
			ImageLoader.getInstance().displayImage("http://static.langdunzx.com/" + courseList1.getLogo(),
					holder.ivCourse1, options);
			holder.courseTeacher1.setText(courseList1.getTitle());
			holder.courseName1.setText(courseList1.getName());
		}
		if (position * 2 + 1 < courseListVo.size()) {
			holder.ll2.setVisibility(View.VISIBLE);
			CourseList courseList2 = courseListVo.get(position * 2 + 1);
			ImageLoader.getInstance().displayImage(
					"http://static.langdunzx.com/"+courseList2.getLogo(), holder.ivCourse2, options);
			holder.courseTeacher2.setText(courseList2.getTitle());
			holder.courseName2.setText(courseList2.getName());

		} else {
			holder.ll2.setVisibility(View.INVISIBLE);
		}
		holder.ll.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
                Toast.makeText(context,"111",Toast.LENGTH_SHORT).show();
				/*Intent intent1 = new Intent(context,CourseDetailsActivty.class);
				String courseId1 = String.valueOf(courseLists.get(position*2).getCourseId());
				intent1.putExtra("courseId",courseId1);
				context.startActivity(intent1);*/
			}
		});

		holder.ll2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Toast.makeText(context,"222",Toast.LENGTH_SHORT).show();
				/*Intent intent2 = new Intent(context,CourseDetailsActivty.class);
				String courseId2 = String.valueOf(courseLists.get(position*2+1).getCourseId());
				intent2.putExtra("courseId",courseId2);
				context.startActivity(intent2);*/
			}
		});



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
