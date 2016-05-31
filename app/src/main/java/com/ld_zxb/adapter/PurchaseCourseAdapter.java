package com.ld_zxb.adapter;

import java.util.List;

import com.ld_zxb.R;
import com.ld_zxb.vo.MyPurchaseCourseEntityVo.PurchaseCourseBody;
import com.nostra13.universalimageloader.core.ImageLoader;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class PurchaseCourseAdapter extends BaseAdapter{

	private Context context;
	private List<PurchaseCourseBody> courseListVo;
	private String name;

	public PurchaseCourseAdapter (Context context,List<PurchaseCourseBody> courseListVo) {
		super();
		this.context = context;
		this.courseListVo = courseListVo;

	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		if(courseListVo!=null){
			return courseListVo.size();
		}else{
			return 0;
		}
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		if (courseListVo == null)
			return null;
		else if (position >= courseListVo.size())
			return null;
		else
			return courseListVo.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View view, ViewGroup parent) {
		// TODO Auto-generated method stub
		ViewHolder holder;
		/*if (view == null) {
			holder= new ViewHolder();
			view = LayoutInflater.from(context).inflate(R.layout.item_purchase_lv,null);
			holder.ivLogo = (ImageView) view.findViewById(R.id.item_purchase_iv);
			holder.tvTitle = (TextView) view.findViewById(R.id.item_purchase_title);
			holder.tvContent = (TextView) view.findViewById(R.id.item_purchase_content);
			holder.tvTeacher = (TextView) view.findViewById(R.id.item_purchase_teacher);
			view.setTag(holder);
		} else {
			holder = (ViewHolder) view.getTag();
		}
		//给holder中的控件进行赋值
		PurchaseCourseBody courseList = courseListVo.get(position);
		holder.tvTitle.setText(courseList.getName());
		holder.tvContent.setText("简介："+courseList.getTitle());
		int len = courseList.getTeacherList().size();
		if (len!=0){
			for (int i=0;i<len;i++){
				if (name == null) {
					name = courseList.getTeacherList().get(i).getName() + "、";
				}else{
					name = name + courseList.getTeacherList().get(i).getName() + "、";
				}
			}
			name = name.substring(0,name.length()-1);
		}
		holder.tvTeacher.setText("讲师："+name);
		ImageLoader.getInstance().displayImage("http://static.langdunzx.com/"+courseList.getLogo(), holder.ivLogo);*/
		return view;
	}

	private class ViewHolder{
		public  TextView tvTitle,tvContent,tvTeacher;
		public 	ImageView ivLogo;
	}

}
