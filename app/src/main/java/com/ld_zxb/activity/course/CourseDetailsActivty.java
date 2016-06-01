package com.ld_zxb.activity.course;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.ld_zxb.R;
import com.ld_zxb.activity.BaseFragmentActivity;
import com.ld_zxb.application.DCApplication;
import com.ld_zxb.fragment.coursedetails.CommentFragment;
import com.ld_zxb.fragment.coursedetails.ContentsFragment;
import com.ld_zxb.fragment.informationpage.VpSimpleFragment;
import com.ld_zxb.fragment.informationpage.VpSimpleFragmentA;
import com.ld_zxb.fragment.informationpage.VpSimpleFragmentB;
import com.ld_zxb.view.ViewPagerIndictor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CourseDetailsActivty extends FragmentActivity {

    private DCApplication mApplication;
    private ViewPager mViewPager;
    private ViewPagerIndictor mIndictor;
    private List<String> mTitles = Arrays.asList("目录", "评论");
    private List<CommentFragment> mContents = new ArrayList<CommentFragment>();
    private FragmentPagerAdapter mAdapter;

    private ImageView ivDown;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_details_activty);
        initView();
        initDatas();
        mIndictor.setVisiableTabCount(2);
        mIndictor.setTabItemTitles(mTitles);

        mViewPager.setAdapter(mAdapter);
        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int position) {
                // TODO Auto-generated method stub
//                Toast.makeText(getActivity(), "position"+position,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onPageScrollStateChanged(int arg0) {
                // TODO Auto-generated method stub

            }
        });

        mIndictor.setViewPager(mViewPager, 0);
        //自定义监听
        mIndictor.setOnPageChangeListener(new ViewPagerIndictor.PageOnChangeListener() {

            @Override
            public void onPageSelected(int position) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onPageScrolledStateChanged(int state) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onPageScrolled(int position, float positionOffect,
                                       int positionOffectPixels) {
                // TODO Auto-generated method stub

            }
        });
    }



    private void initView() {
        mViewPager = (ViewPager) findViewById(R.id.id_coursedetail_viewPager);
        mIndictor = (ViewPagerIndictor) findViewById(R.id.id_coursedetail_indictor);

        ivDown = (ImageView) findViewById(R.id.iv_coursedetails_down);

        ivDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(CourseDetailsActivty.this,"1111", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initDatas() {

        mAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {

                switch (position) {
                    // 根据 position 设置每个Fragment View
                    case 0:
                        return ContentsFragment.newInstance("a",1);
                    case 1:
                        return CommentFragment.newInstance("b",2);
                    default:
                        return null;
                }
            }
            @Override
            public int getCount() {
                return mTitles.size();
            }
        };
    }

}
