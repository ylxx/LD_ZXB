package com.ld_zxb.activity.course;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ld_zxb.R;
import com.ld_zxb.activity.BaseFragmentActivity;
import com.ld_zxb.application.DCApplication;
import com.ld_zxb.fragment.informationpage.VpSimpleFragment;
import com.ld_zxb.view.ViewPagerIndictor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CourseDetailsActivty extends BaseFragmentActivity {

    private DCApplication mApplication;
    private ViewPager mViewPager;
    private ViewPagerIndictor mIndictor;
    private List<String> mTitles = Arrays.asList("目录", "评论");
    private List<VpSimpleFragment> mContents = new ArrayList<VpSimpleFragment>();
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_details_activty);
        initView();
        mIndictor.setVisiableTabCount(2);
        mIndictor.setTabItemTitles(mTitles);
    }

    private void initView() {
        mViewPager = (ViewPager) findViewById(R.id.id_coursedetail_viewPager);
        mIndictor = (ViewPagerIndictor) findViewById(R.id.id_coursedetail_indictor);
    }


}
