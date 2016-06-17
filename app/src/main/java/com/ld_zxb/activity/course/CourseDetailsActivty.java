package com.ld_zxb.activity.course;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.ld_zxb.R;
import com.ld_zxb.activity.BaseFragmentActivity;
import com.ld_zxb.config.Constants;
import com.ld_zxb.controller.BaseHandler;
import com.ld_zxb.controller.RequestCommant;
import com.ld_zxb.fragment.coursedetails.CommentFragment;
import com.ld_zxb.fragment.coursedetails.ContentsFragment;
import com.ld_zxb.utils.ClickUtil;
import com.ld_zxb.utils.Logge;
import com.ld_zxb.utils.SerialUtils;
import com.ld_zxb.view.ViewPagerIndictor;
import com.ld_zxb.vo.UserLoginBodyVo;
import com.ld_zxb.vo.ParticularCourseEntityVo;
import com.ld_zxb.vo.ParticularCourseEntityVo.ParticularCourseBodyVo;
import com.ld_zxb.vo.ParticularCourseEntityVo.ParticularCourseBodyVo.CatalogList;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class CourseDetailsActivty extends BaseFragmentActivity {

    private SerialUtils serialutols;
    private ViewPager mViewPager;
    private ViewPagerIndictor mIndictor;
    private List<String> mTitles = Arrays.asList("目录", "评论");
    private List<Fragment> mContents = new ArrayList<Fragment>();
    private FragmentPagerAdapter mAdapter;
    private Intent intent;
    private ImageView ivDown, ivLogo;
    private TextView tvCourseName, tvTeacher, tvCourseDescript;
    private FrameLayout fl;
    private String courseId, vid, kpointId, teacherName;
    private int userId;
    private int width = 0;
    private List<List<CatalogList>> catalogLists = new ArrayList<List<CatalogList>>();
    private List<CatalogList.ChildList> childList = new ArrayList<CatalogList.ChildList>();
    private List<CatalogList.ChildList> childLists = new ArrayList<CatalogList.ChildList>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_details);
        serialutols = new SerialUtils();
        try {
            UserLoginBodyVo userinfo = serialutols.deSerialization(serialutols.getObject(CourseDetailsActivty.this));
            userId = userinfo.getBody().getId();
        } catch (Exception e) {
            e.printStackTrace();
        }

        intent = getIntent();
        if (intent.getStringExtra("courseId") != null) {
            courseId = intent.getStringExtra("courseId");
        }
        /*if(intent.getStringExtra("vid")!=null){
            vid = intent.getStringExtra("vid");
        }
        if(intent.getStringExtra("kpointId")!=null){
            kpointId = intent.getStringExtra("kpointId");
        }*/

        initView();
        initDatas();
        mIndictor.setVisiableTabCount(2);
        mIndictor.setTabItemTitles(mTitles);

        mViewPager.setAdapter(mAdapter);
        mIndictor.setViewPager(mViewPager, 0);
    }


    private void initView() {
        mViewPager = (ViewPager) findViewById(R.id.id_coursedetail_viewPager);
        mIndictor = (ViewPagerIndictor) findViewById(R.id.id_coursedetail_indictor);
        tvCourseName = (TextView) findViewById(R.id.tv_coursedetails_course_name);
        tvTeacher = (TextView) findViewById(R.id.tv_coursedetail_teacher);
        ivLogo = (ImageView) findViewById(R.id.course_details_iv_logo);
        ivDown = (ImageView) findViewById(R.id.iv_coursedetails_down);
        fl = (FrameLayout) findViewById(R.id.fl_course_details);
        tvCourseDescript = (TextView) findViewById(R.id.tv_coursedetails_descript);

        ClickUtil.setClickListener(listener, ivDown);
    }

    private void initDatas() {
        mContents.clear();
        mAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {

                switch (position) {
                    // 根据 position 设置每个Fragment View
                    case 0:
                        return ContentsFragment.newInstance("c", 1);
                    case 1:
                        return CommentFragment.newInstance("d", 2);
                    default:
                        return null;
                }
            }

            @Override
            public int getCount() {
                return 2;
            }
        };


        /**
         * 获取课程详情
         */
        getCourseParticular();
    }

    private void getCourseParticular() {

        Logge.LogI("访问课程详情接口");
        HashMap<String, String> hashmap = new HashMap<String, String>();
        hashmap.put("courseId", courseId);
        hashmap.put("userId", String.valueOf(userId));
        new RequestCommant().requestParticularCourse(new ReauestHandler(this), this, hashmap);
    }


    /**
     * 监听事件
     */
    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        }
    };


    private class ReauestHandler extends BaseHandler {
        public ReauestHandler(Activity activity) {
            super(activity);
        }

        @Override
        public void handleMessage(Message msg) {
            // TODO Auto-generated method stub
            super.handleMessage(msg);

            if (msg.what == Constants.GET_PARTICULAR_COURSE) {
                System.out.println(command.success);
                //				plListview.onRefreshComplete();
                if (command.success) {
                    ParticularCourseEntityVo particularCourseEntityVo = (ParticularCourseEntityVo) command.resData;
                    ParticularCourseBodyVo particularCourseBodyVo = particularCourseEntityVo.getEntity();
                    catalogLists = particularCourseBodyVo.getCatalogList();

                    childList.clear();
                    for (int i = 1; i < catalogLists.get(0).size(); i++) {
                        for (int j = 0; j < catalogLists.get(0).get(i).getChildList().size(); j++) {
                            childList.add(catalogLists.get(0).get(i).getChildList().get(j));
                        }
                    }
                    childLists.addAll(childList);

                    ContentsFragment contentsFragment = new ContentsFragment();
                    contentsFragment.setCourseBody(childLists);
                    /**
                     * 利用imageloader实现设置background
                     */
                    ImageLoader.getInstance().loadImage("http://static.langdunzx.com/"
                                    + particularCourseBodyVo.getCourse().getCourseLogo(),
                            new SimpleImageLoadingListener() {
                                @Override
                                public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
                                    super.onLoadingComplete(imageUri, view, loadedImage);
                                    fl.setBackgroundDrawable(new BitmapDrawable(loadedImage));
                                }
                            });

                    /**
                     * 教师字段处理
                     */
                    for (int i = 0; i < particularCourseBodyVo.getCourse().getTeacherList().size(); i++) {
                        if (particularCourseBodyVo.getCourse().getTeacherList().get(i).getName() == "null" ||
                                particularCourseBodyVo.getCourse().getTeacherList().get(i).getName().equals(null)) {
                            return;
                        } else {
                            if (teacherName == null) {
                                teacherName = particularCourseBodyVo.getCourse().getTeacherList().get(i).getName() + "、";
                            } else {
                                teacherName = teacherName + particularCourseBodyVo
                                        .getCourse()
                                        .getTeacherList()
                                        .get(i)
                                        .getName()
                                        + "、";
                            }
                        }
                    }
                    teacherName = teacherName.substring(0, teacherName.length() - 1);
                    tvTeacher.setText("讲师：" + teacherName);
                    tvCourseName.setText(particularCourseBodyVo.getCourse().getName());
                    tvCourseDescript.setText(Html.fromHtml(particularCourseBodyVo.getCourse().getContext()));
                } else {
                    showError((String) command.message); // 請求失敗
                }
            }
            //收藏课程
            if (msg.what == Constants.REQUEST_COLLECT_COURSE) {
                System.out.println(command.success);
                if (command.success) {
//                    Toast.makeText(PlayActivity.this, "收藏成功！", 3).show();
                } else {
                    showError((String) command.message); // 請求失敗
                }
            }
        }

    }

}
