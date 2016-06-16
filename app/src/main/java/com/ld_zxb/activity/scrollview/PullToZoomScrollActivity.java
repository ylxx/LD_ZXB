package com.ld_zxb.activity.scrollview;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Message;
import android.provider.MediaStore;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.ecloud.pulltozoomview.PullToZoomScrollViewEx;
import com.ld_zxb.R;
import com.ld_zxb.activity.BaseFragmentActivity;
import com.ld_zxb.activity.login.LoginActivity;
import com.ld_zxb.config.Constants;
import com.ld_zxb.controller.BaseHandler;
import com.ld_zxb.controller.RequestCommant;
import com.ld_zxb.entity.MineEntity;
import com.ld_zxb.utils.SerialUtils;
import com.ld_zxb.vo.UserLoginBodyVo;

import java.io.File;
import java.util.HashMap;

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
public class PullToZoomScrollActivity extends BaseFragmentActivity implements View.OnClickListener{

    private PullToZoomScrollViewEx scrollView;
    ImageView mine_right_bar,mine_Left_back;
    private static final int PHOTO_REQUEST_CAMERA = 1;// 拍照
    private static final int PHOTO_REQUEST_GALLERY = 2;// 从相册中选择
    private static final int PHOTO_REQUEST_CUT = 3;// 结果
    private Bitmap bitmap;
    /* 头像名称 */
    private static final String PHOTO_FILE_NAME = "temp_photo.jpg";
    private File tempFile;
    private MineEntity mineEntity;
    private TextView pullMine_phone,pullMine_email,pullMine_nickname,head_username;
    private SerialUtils serialutols;
    private int userId;
    private class requetHandle extends BaseHandler {
        public requetHandle(Activity activity) {
            super(activity);
            // TODO Auto-generated constructor stub
        }
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == Constants.USER_INFO){
                if(command.success){
                    mineEntity = (MineEntity) command.resData;
                    pullMine_email.setText(mineEntity.getEntity().getEmail().toString());
                    pullMine_nickname.setText("小样");
                    pullMine_phone.setText(mineEntity.getEntity().getMobile().toString());
                    head_username.setText("小样");
                }
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pull_to_zoom_scroll_view);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        serialutols = new SerialUtils();
        if(serialutols.getObject(this)==null){
            Toast.makeText(this, "收藏的课程！", Toast.LENGTH_LONG).show();
            startActivity(new Intent(this,LoginActivity.class));
        }else{
            try {
                UserLoginBodyVo userinfo = serialutols.deSerialization(serialutols.getObject(this));
                //用户Id(非268)
                userId=userinfo.getBody().getId();

            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        initView();
        loadViewForCode();
        scrollView = (PullToZoomScrollViewEx) findViewById(R.id.scroll_view);
        mine_Left_back = (ImageView) findViewById(R.id.mine_Left_back);
        mine_Left_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PullToZoomScrollActivity.this.finish();
            }
        });
        scrollView.getPullRootView().findViewById(R.id.iv_user_photo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageViewPopuWindow imageViewPopu = new ImageViewPopuWindow(PullToZoomScrollActivity.this);
                imageViewPopu.showAtLocation(View.inflate(PullToZoomScrollActivity.this,
                        R.layout.activity_pull_to_zoom_scroll_view, null), Gravity.BOTTOM
                        | Gravity.CENTER_HORIZONTAL, 0, 0);
            }
        });
        pullMine_email = (TextView) scrollView.getPullRootView().findViewById(R.id.pull_mine_email);
        pullMine_nickname = (TextView) scrollView.getPullRootView().findViewById(R.id.pull_mine_nickname);
        pullMine_phone = (TextView) scrollView.getPullRootView().findViewById(R.id.pull_mine_phone);
        head_username = (TextView) scrollView.getPullRootView().findViewById(R.id.head_user_name);
        DisplayMetrics localDisplayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
        int mScreenHeight = localDisplayMetrics.heightPixels;
        int mScreenWidth = localDisplayMetrics.widthPixels;
        LinearLayout.LayoutParams localObject = new LinearLayout.LayoutParams(mScreenWidth, (int) (9.0F * (mScreenWidth / 16.0F)));
        scrollView.setHeaderLayoutParams(localObject);
    }
    /*加载身体view*/
    private void loadViewForCode() {
        PullToZoomScrollViewEx scrollView = (PullToZoomScrollViewEx) findViewById(R.id.scroll_view);
        View headView = LayoutInflater.from(this).inflate(R.layout.profile_head_view, null, false);
        View zoomView = LayoutInflater.from(this).inflate(R.layout.profile_zoom_view, null, false);
        View contentView = LayoutInflater.from(this).inflate(R.layout.profile_content_view, null, false);
        scrollView.setHeaderView(headView);
        scrollView.setZoomView(zoomView);
        scrollView.setScrollContentView(contentView);
    }

    private void initView() {
        getUserinfo();
    }
    public void getUserinfo() {
        HashMap<String, String> hashmap = new HashMap<String, String>();
        hashmap.put("userId", ""+userId);//用户id
        new RequestCommant().requestUserInfo(new requetHandle(this),this,hashmap);
    }
    public void chagePhoto(){
        HashMap<String, String> hashmap = new HashMap<String, String>();
        hashmap.put("avatar", "1");//用户头像地址
        hashmap.put("userId", ""+userId);//用户id
        new RequestCommant().requestUserPhoto(new requetHandle(this),this,hashmap);
    }


    /*
     * 从相册获取
     */
    public void gallery(View view) {
        // 激活系统图库，选择一张图片
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        startActivityForResult(intent, PHOTO_REQUEST_GALLERY);
    }

    /*
     * 从相机获取
     */
    public void camera(View view) {
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        // 判断存储卡是否可以用，可用进行存储
        if (hasSdcard()) {
            intent.putExtra(MediaStore.EXTRA_OUTPUT,
                    Uri.fromFile(new File(Environment
                            .getExternalStorageDirectory(), PHOTO_FILE_NAME)));
        }
        startActivityForResult(intent, PHOTO_REQUEST_CAMERA);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == PHOTO_REQUEST_GALLERY) {
            if (data != null) {
                // 得到图片的全路径
                Uri uri = data.getData();
                crop(uri);
            }

        } else if (requestCode == PHOTO_REQUEST_CAMERA) {
            if (hasSdcard()) {
                tempFile = new File(Environment.getExternalStorageDirectory(),
                        PHOTO_FILE_NAME);
                crop(Uri.fromFile(tempFile));
            } else {

            }

        } else if (requestCode == PHOTO_REQUEST_CUT) {
            try {
                chagePhoto();
                bitmap = data.getParcelableExtra("data");
//                boolean delete = tempFile.delete();
//                this.mFace.setImageBitmap(bitmap);
//                System.out.println("delete = " + delete);

            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        super.onActivityResult(requestCode, resultCode, data);
    }

    /**
     * 剪切图片
     *
     * @function:
     * @author:Jerry
     * @date:2013-12-30
     * @param uri
     */
    private void crop(Uri uri) {
        // 裁剪图片意图
        Intent intent = new Intent("com.android.camera.action.CROP");
        intent.setDataAndType(uri, "image/*");
        intent.putExtra("crop", "true");
        // 裁剪框的比例，1：1
        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY", 1);
        // 裁剪后输出图片的尺寸大小
        intent.putExtra("outputX", 250);
        intent.putExtra("outputY", 250);
        // 图片格式
        intent.putExtra("outputFormat", "JPEG");
        intent.putExtra("noFaceDetection", true);// 取消人脸识别
        intent.putExtra("return-data", true);// true:不返回uri，false：返回uri
        startActivityForResult(intent, PHOTO_REQUEST_CUT);
    }
    /**获取SDCARD*/
    private boolean hasSdcard() {
        if (Environment.getExternalStorageState().equals(
                Environment.MEDIA_MOUNTED)) {
            return true;
        } else {
            return false;
        }
    }


    class ImageViewPopuWindow extends PopupWindow implements View.OnClickListener{

        private Activity activity;
        private static final int PHOTO_REQUEST_CAMERA = 1;// 拍照
        private static final int PHOTO_REQUEST_GALLERY = 2;// 从相册中选择
        private static final int PHOTO_REQUEST_CUT = 3;// 结果/* 头像名称 */
        private static final String PHOTO_FILE_NAME = "temp_photo.jpg";
        private File tempFile;
        private Bitmap bitmap;
        public ImageViewPopuWindow(Activity activity){
            this.activity = activity;
            this.ImageViewPopuShow();
        }
        public void ImageViewPopuShow(){
            View view = LayoutInflater.from(activity).inflate(R.layout.popu_imageview,
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
                    camera(v);
                    this.dismiss();
                    break;
                case R.id.select_photo:
                    //打开相册，选取图片
                    gallery(v);
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
}
