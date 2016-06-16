package com.ld_zxb.activity.course;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.ld_zxb.R;
import com.ld_zxb.activity.BaseFragmentActivity;
import com.ld_zxb.fragment.courseclassify.DocumentFragment;
import com.ld_zxb.fragment.courseclassify.DoubleFragment;
import com.ld_zxb.view.ViewPagerIndictor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CourseClassifyActivity extends BaseFragmentActivity {

    private Intent mIntent;
    private ViewPager mViewPager;
    private ViewPagerIndictor mIndictor;
    private List<String> mTitles = Arrays.asList("单证考试", "双证考试");
    private List<Fragment> mContents = new ArrayList<Fragment>();
    private FragmentPagerAdapter mAdapter;
    private RelativeLayout rl3;
    private ImageView iv_courseclass_down;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_classify);

        mIntent = getIntent();
        String type = mIntent.getStringExtra("type");

        initView();
        initDatas();

        mIndictor.setVisiableTabCount(2);
        mIndictor.setTabItemTitles(mTitles);

        mViewPager.setAdapter(mAdapter);
        mIndictor.setViewPager(mViewPager,0);
    }
    int i=0;
    private void initView() {
        mIndictor = (ViewPagerIndictor) findViewById(R.id.id_courseclassify_indictor);
        mViewPager = (ViewPager) findViewById(R.id.id_courseclassify_viewPager);
        iv_courseclass_down = (ImageView) findViewById(R.id.iv_courseclass_down);
        rl3 = (RelativeLayout) findViewById(R.id.course_rl3);
        iv_courseclass_down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(i==0){
                    rl3.setVisibility(View.GONE);i++;
                }else{
                    rl3.setVisibility(View.VISIBLE);i=0;
                }
            }
        });
    }

    private void initDatas() {
        mContents.clear();
        mAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {

            @Override
            public int getCount() {
                // TODO Auto-generated method stub
                return 2;
            }

            @Override
            public Fragment getItem(int position) {
                // TODO Auto-generated method stub
                switch (position){
                    case 0:
                        return DoubleFragment.newInstance("a",1);
                    case 1:
                        return DocumentFragment.newInstance("b",2);
                    default:
                        return null;
                }

            }
        };

    }
}
