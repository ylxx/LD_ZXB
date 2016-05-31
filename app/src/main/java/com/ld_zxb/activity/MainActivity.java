package com.ld_zxb.activity;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.ld_zxb.R;
import com.ld_zxb.activity.login.LoginActivity;
import com.ld_zxb.activity.secondary.SearchActivity;
import com.ld_zxb.fragment.homepage.HomePageFragment;
import com.ld_zxb.fragment.homepage.InformationFragment;
import com.ld_zxb.fragment.homepage.MineFragment;
import com.ld_zxb.utils.ClickUtil;

import java.util.ArrayList;
import java.util.List;

import me.majiajie.pagerbottomtabstrip.Controller;
import me.majiajie.pagerbottomtabstrip.PagerBottomTabLayout;
import me.majiajie.pagerbottomtabstrip.TabItemBuilder;
import me.majiajie.pagerbottomtabstrip.listener.OnTabItemSelectListener;

public class MainActivity extends BaseFragmentActivity {
    int[] testColors = {00000000};

    private Controller controller;

    private List<Fragment> mFragments;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setLogo(R.drawable.dialog_error_icon);
        toolbar.setLogoDescription("sousuo");
        toolbar.setTitle("课程");*/

        //这里这样使用Fragment仅用于测试，请勿模仿！
//        initView();
        initFragment();
        BottomTabTest();
    }

    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings1) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
*/

    /**
     * 初始化
     */
    private  void initView()
    {



    }



        private void initFragment()
    {
        mFragments = new ArrayList<>();

        mFragments.add(createFragment1(""));
        mFragments.add(createFragment2(""));
        mFragments.add(createFragment3(""));

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.setCustomAnimations(R.anim.push_up_in,R.anim.push_up_out);
        transaction.add(R.id.frameLayout,mFragments.get(0));
        transaction.commit();
    }

    private void BottomTabTest()
        {
            PagerBottomTabLayout pagerBottomTabLayout = (PagerBottomTabLayout) findViewById(R.id.tab);

            //用TabItemBuilder构建一个导航按钮
            TabItemBuilder tabItemBuilder = new TabItemBuilder(this).create()
                    .setDefaultIcon(R.drawable.course_tb_course)
                    .setDefaultColor(0xFF000000)
                    .setText("课程")
                    .setSelectedColor(0xFFF9B23E)
                .setTag("A")
                .build();

        //构建导航栏,得到Controller进行后续控制
        controller = pagerBottomTabLayout.builder()
                .addTabItem(tabItemBuilder)
                .addTabItem(R.drawable.course_tb_news, "资讯",0xFFF9B23E)
                .addTabItem(R.drawable.course_tb_mine, "我的",0xFFF9B23E)
                .setDefaultColor(0xFF000000)
//                .setMode(TabLayoutMode.HIDE_TEXT)
//                .setMode(TabLayoutMode.CHANGE_BACKGROUND_COLOR)
                .build();
//        controller.setMessageNumber("A",2);
//        controller.setDisplayOval(0,true);

        controller.addTabItemClickListener(listener);
    }
    OnTabItemSelectListener listener = new OnTabItemSelectListener() {
        @Override
        public void onSelected(int index, Object tag)
        {
            Log.i("asd","onSelected:"+index+"   TAG: "+tag.toString());

            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.setCustomAnimations(R.anim.push_up_in,R.anim.push_up_out);
            transaction.replace(R.id.frameLayout,mFragments.get(index));
            transaction.commit();
        }

        @Override
        public void onRepeatClick(int index, Object tag) {
            Log.i("asd","onRepeatClick:"+index+"   TAG: "+tag.toString());
        }
    };

    private Fragment createFragment1(String content)
    {
        HomePageFragment fragment = new HomePageFragment();
        Bundle bundle = new Bundle();
        bundle.putString("content",content);
        fragment.setArguments(bundle);

        return fragment;
    }
    private Fragment createFragment2(String content)
    {
        InformationFragment fragment = new InformationFragment();
        Bundle bundle = new Bundle();
        bundle.putString("content",content);
        fragment.setArguments(bundle);

        return fragment;
    }
    private Fragment createFragment3(String content)
    {
        MineFragment fragment = new MineFragment();
        Bundle bundle = new Bundle();
        bundle.putString("content",content);
        fragment.setArguments(bundle);

        return fragment;
    }

}
