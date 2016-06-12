package com.ld_zxb.activity.course;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.ld_zxb.R;
import com.ld_zxb.activity.BaseFragmentActivity;
import com.ld_zxb.fragment.coursedetails.CommentFragment;
import com.ld_zxb.fragment.coursedetails.ContentsFragment;
import com.ld_zxb.view.ViewPagerIndictor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CourseDetailsActivty extends BaseFragmentActivity {

    private ViewPager mViewPager;
    private ViewPagerIndictor mIndictor;
    private List<String> mTitles = Arrays.asList("目录", "评论");
    private List<Fragment> mContents = new ArrayList<Fragment>();
    private FragmentPagerAdapter mAdapter;

    private ImageView ivDown;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_details);
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

        ivDown = (ImageView) findViewById(R.id.iv_coursedetails_down);

        ivDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(CourseDetailsActivty.this,"1111", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initDatas() {
        mContents.clear();
        mAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {

                switch (position) {
                    // 根据 position 设置每个Fragment View
                    case 0:
                        return ContentsFragment.newInstance("c",1);
                    case 1:
                        return CommentFragment.newInstance("d",2);
                    default:
                        return null;
                }
            }
            @Override
            public int getCount() {
                return 2;
            }
        };
    }

}
