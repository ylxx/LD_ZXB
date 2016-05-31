package com.ld_zxb.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import com.ld_zxb.R;
import com.ld_zxb.activity.scrollview.PullToZoomScrollActivity;
import com.ld_zxb.fragment.homepage.MineFragment;

public class LikeClassPopupWindow extends PopupWindow implements View.OnClickListener{
	private Activity activity;
	private View contentView;

	// 用于保存PopupWindows的宽度
	private int width;
	// 用于保存PopupWindows的高度
	private int height;

	public LikeClassPopupWindow(Activity activity) {
		super();
		this.activity = activity;
		this.initPopupWindow();
	}

	private void initPopupWindow() {
		// TODO Auto-generated method stub
		LayoutInflater inflater = (LayoutInflater) activity
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View view = inflater.inflate(R.layout.popupwindow_likeclass, null);
		LinearLayout lovekecheng = (LinearLayout) view.findViewById(R.id.lovekecheng);
		LinearLayout meStrings = (LinearLayout) view.findViewById(R.id.meStrings);
		lovekecheng.setOnClickListener(this);
		meStrings.setOnClickListener(this);
		this.contentView =view;
		this.setContentView(contentView);
		this.setWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
		this.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
		this.setTouchable(true);
		this.setFocusable(true);
		this.setOutsideTouchable(true);
		this.setAnimationStyle(R.style.PopupAnimation);
		ColorDrawable background = new ColorDrawable(0x4f000000);
		this.setBackgroundDrawable(background);
		this.mandatorDraw();
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
			case R.id.lovekecheng:
				//报读的课程
				activity.startActivity(new Intent(activity,MineFragment.class));
				this.dismiss();
				break;
			case R.id.meStrings:
				//个人资料
				activity.startActivity(new Intent(activity,PullToZoomScrollActivity.class));
				this.dismiss();
				break;

			default:
				break;
		}
	}

	private void mandatorDraw() {
		this.contentView.measure(View.MeasureSpec.UNSPECIFIED,
				View.MeasureSpec.UNSPECIFIED);
		this.width = this.contentView.getMeasuredWidth();
		this.height = this.contentView.getMeasuredHeight();
	}

	/* 显示在控件下右方 */
	public void showAtDropDownRight(View parent) {
		if (parent.getVisibility() == View.GONE) {
			this.showAtLocation(parent, 0, 0, 0);
		} else {
			int[] location = new int[2];
			parent.getLocationOnScreen(location);
			this.showAtLocation(parent, 0, location[0] + parent.getWidth()
					- this.getWidth(), location[1] + parent.getHeight());
		}
	}

	/**
	 * 显示在控件的下左方
	 *
	 * @param parent parent
	 */
    public void showAtDropDownLeft(View parent) {
        if (parent.getVisibility() == View.GONE) {
            this.showAtLocation(parent, 0, 0, 0);
        } else {
            // x y
            int[] location = new int[2];
			//获取在整个屏幕内的绝对坐标
            parent.getLocationOnScreen(location);
            this.showAtLocation(parent, 0, location[0], location[1] + parent.getHeight());
        }
    }

	/**
	 * 显示在控件的下中方
	 *
	 * @param parent parent
	 */
    public void showAtDropDownCenter(View parent) {
        if (parent.getVisibility() == View.GONE) {
            this.showAtLocation(parent, 0, 0, 0);
        } else {
            // x y
            int[] location = new int[2];
			//获取在整个屏幕内的绝对坐标
            parent.getLocationOnScreen(location);
            this.showAtLocation(parent, 0, location[0] / 2 + parent.getWidth() / 2 - this.width / 6, location[1] + parent.getHeight());
        }
    }
    
    public static class PopupWindowBuilder{
    	private static String activityHashCode;
    	private static LikeClassPopupWindow popupWindow;
    	public static PopupWindowBuilder ourInstance;
    	
    	 public static PopupWindowBuilder getInstance(Activity activity) {
             if (ourInstance == null) ourInstance = new PopupWindowBuilder();
             String hashCode = String.valueOf(activity.hashCode());
			 /**
			  * 不同一个Activity
			  */
             if (!hashCode.equals(String.valueOf(activityHashCode))) {
                 activityHashCode = hashCode;
                 popupWindow = new LikeClassPopupWindow(activity);
             }
             return ourInstance;
         }

         public PopupWindowBuilder setTouchable(boolean touchable) {
             popupWindow.setTouchable(touchable);
             return this;
         }

         public PopupWindowBuilder setAnimationStyle(int animationStyle) {
             popupWindow.setAnimationStyle(animationStyle);
             return this;
         }

         public PopupWindowBuilder setBackgroundDrawable(Drawable background) {
             popupWindow.setBackgroundDrawable(background);
             return this;
         }

         public LikeClassPopupWindow getPopupWindow() {
             popupWindow.update();
             return popupWindow;
         }

     }
}
