package com.ld_zxb.activity.scrollview;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.ecloud.pulltozoomview.PullToZoomScrollViewEx;
import com.ld_zxb.R;
import com.ld_zxb.view.CustomPopupWindow;
import com.ld_zxb.view.ImageViewPopu;

/**
 * Author:    ZhuWenWu
 * Version    V1.0
 * Date:      2014/9/4  17:30.
 * Description:
 * Modification  History:
 * Date         	Author        		Version        	Description
 * -----------------------------------------------------------------------------------
 * 2014/9/4        ZhuWenWu            1.0                    1.0
 * Why & What is modified:
 */
public class PullToZoomScrollActivity extends ActionBarActivity {

    private PullToZoomScrollViewEx scrollView;
    ImageView ivShow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pull_to_zoom_scroll_view);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        loadViewForCode();
        scrollView = (PullToZoomScrollViewEx) findViewById(R.id.scroll_view);
        ivShow  = (ImageView) findViewById(R.id.iv_Show);
        ivShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CustomPopupWindow popupWindow = new CustomPopupWindow(PullToZoomScrollActivity.this);
                popupWindow.showAtDropDownRight(ivShow);
            }
        });
//        scrollView.getPullRootView().findViewById(R.id.tv_test1).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Log.e("zhuwenwu", "onClick -->");
//            }
//        });
        scrollView.getPullRootView().findViewById(R.id.iv_user_photo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageViewPopu imageViewPopu = new ImageViewPopu(PullToZoomScrollActivity.this);
                imageViewPopu.ImageViewPopuShow();
                imageViewPopu.showAtLocation(View.inflate(PullToZoomScrollActivity.this,
                        R.layout.activity_pull_to_zoom_scroll_view, null), Gravity.BOTTOM
                        | Gravity.CENTER_HORIZONTAL, 0, 0);
            }
        });


        DisplayMetrics localDisplayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
        int mScreenHeight = localDisplayMetrics.heightPixels;
        int mScreenWidth = localDisplayMetrics.widthPixels;
        LinearLayout.LayoutParams localObject = new LinearLayout.LayoutParams(mScreenWidth, (int) (9.0F * (mScreenWidth / 16.0F)));
        scrollView.setHeaderLayoutParams(localObject);
    }



    private void loadViewForCode() {
        PullToZoomScrollViewEx scrollView = (PullToZoomScrollViewEx) findViewById(R.id.scroll_view);
        View headView = LayoutInflater.from(this).inflate(R.layout.profile_head_view, null, false);
        View zoomView = LayoutInflater.from(this).inflate(R.layout.profile_zoom_view, null, false);
        View contentView = LayoutInflater.from(this).inflate(R.layout.profile_content_view, null, false);
        scrollView.setHeaderView(headView);
        scrollView.setZoomView(zoomView);
        scrollView.setScrollContentView(contentView);
    }
}
