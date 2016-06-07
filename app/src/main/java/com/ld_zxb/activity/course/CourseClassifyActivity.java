package com.ld_zxb.activity.course;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.ld_zxb.R;
import com.ld_zxb.activity.BaseFragmentActivity;
import com.ld_zxb.utils.LogUtil;
import com.ld_zxb.view.ViewPagerIndictor;

import java.util.Arrays;
import java.util.List;

public class CourseClassifyActivity extends BaseFragmentActivity {

    private Intent mIntent;
    private ViewPager mViewPager;
    private ViewPagerIndictor mIndictor;
    private List<String> mTitles = Arrays.asList("单证考试", "双证考试");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_classify);

        mIntent = getIntent();
        String TYPE = mIntent.getStringExtra("type");
//        LogUtil.e("TYPE",TYPE);
//        Toast.makeText(this,TYPE,Toast.LENGTH_SHORT).show();
        initView();
        initDatas();

        mIndictor.setVisiableTabCount(2);
        mIndictor.setTabItemTitles(mTitles);
    }

    private void initView() {
        mIndictor = (ViewPagerIndictor) findViewById(R.id.id_courseclassify_indictor);
        mViewPager = (ViewPager) findViewById(R.id.id_courseclassify_viewPager);
    }

    private void initDatas() {
    }
}
