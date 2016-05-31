package com.ld_zxb.view;

import android.app.Activity;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import com.ld_zxb.R;

import java.io.File;

/**
 * Created by 派大星 on 2016/5/16 0016.
 */
public class ImageViewPopu extends PopupWindow implements View.OnClickListener{

    private Activity activity;
    private static final int PHOTO_REQUEST_CAMERA = 1;// 拍照
    private static final int PHOTO_REQUEST_GALLERY = 2;// 从相册中选择
    private static final int PHOTO_REQUEST_CUT = 3;// 结果/* 头像名称 */
    private static final String PHOTO_FILE_NAME = "temp_photo.jpg";
    private File tempFile;
    private Bitmap bitmap;
    public ImageViewPopu(Activity activity,View view){
        this.activity = activity;
        this.ImageViewPopuShow(view);
    }
    public void ImageViewPopuShow(View view){
         view = LayoutInflater.from(activity).inflate(R.layout.popu_imageview,
                null);
        LinearLayout crame = (LinearLayout) view.findViewById(R.id.crame);
        LinearLayout photo = (LinearLayout) view.findViewById(R.id.select_photo);
        LinearLayout image_close = (LinearLayout) view.findViewById(R.id.View_close);
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
            case R.id.View_close:
                //关闭状态栏
                this.dismiss();
                break;
            default:
                break;
        }
    }

}
