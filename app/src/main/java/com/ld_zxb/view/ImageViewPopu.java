package com.ld_zxb.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import com.ld_zxb.R;

/**
 * Created by 派大星 on 2016/5/16 0016.
 */
public class ImageViewPopu extends PopupWindow implements View.OnClickListener{
    private Context mcontext;

    public ImageViewPopu(Context context){
        this.mcontext = context;
    }
    public void ImageViewPopuShow(){
        View view = LayoutInflater.from(mcontext).inflate(R.layout.popu_imageview,
                null);
        LinearLayout crame = (LinearLayout) view.findViewById(R.id.crame);
        LinearLayout photo = (LinearLayout) view.findViewById(R.id.select_photo);
        LinearLayout image_close = (LinearLayout) view.findViewById(R.id.imageView_close);
        crame.setOnClickListener(this);
        photo.setOnClickListener(this);
        image_close.setOnClickListener(this);
        // 添加布局
        this.setContentView(view);
        // 设置SharePopupWindow宽度
        this.setWidth(LinearLayout.LayoutParams.FILL_PARENT);
        // 设置SharePopupWindow高度
        this.setHeight(LinearLayout.LayoutParams.WRAP_CONTENT);
        // 设置setFocusable可获取焦点
        this.setFocusable(true);
        // 设置setFocusable动画风格
        this.setAnimationStyle(R.style.popuShareAnimation);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.crame:
                //自拍
                this.dismiss();
                break;
            case R.id.select_photo:
                //打开相册，选取图片
                this.dismiss();
                break;
            case R.id.imageView_close:
                //关闭状态栏
                this.dismiss();
                break;
            default:
                break;
        }
    }

}
