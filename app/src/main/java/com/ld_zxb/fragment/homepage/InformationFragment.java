package com.ld_zxb.fragment.homepage;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.handmark.pulltorefresh.library.ILoadingLayout;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.ld_zxb.R;
import com.ld_zxb.application.DCApplication;
import com.ld_zxb.fragment.BaseBackFragment;
import com.ld_zxb.fragment.informationpage.VpSimpleFragment;
import com.ld_zxb.fragment.informationpage.VpSimpleFragmentA;
import com.ld_zxb.fragment.informationpage.VpSimpleFragmentB;
import com.ld_zxb.view.ViewPagerIndictor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InformationFragment extends BaseBackFragment {

    private DCApplication mApplication;
    private Context mContext;
    private View view;
    private ViewPager mViewPager;
    private ViewPagerIndictor mIndictor;
    private List<String> mTitles = Arrays.asList("政策解读", "行业新闻", "IFM考试资讯");
    private List<VpSimpleFragment> mContents = new ArrayList<VpSimpleFragment>();
    private FragmentPagerAdapter mAdapter;
    private PullToRefreshListView mPullToRefreshListView;
    private ImageView ivSearch,ivToLogin;
    TextView tv_text;
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.information_pull,null);
        ivSearch = (ImageView) getActivity().findViewById(R.id.main_left_bar);
        ivToLogin = (ImageView) getActivity().findViewById(R.id.main_right_bar);
        tv_text = (TextView) getActivity().findViewById(R.id.main_title_bar);
        ivToLogin.setVisibility(View.INVISIBLE);
        ivSearch.setVisibility(View.INVISIBLE);
        tv_text.setText("资讯");
        //
        mApplication = (DCApplication) getActivity().getApplication();
        mPullToRefreshListView = (PullToRefreshListView) view
                .findViewById(R.id.gridview);
        mPullToRefreshListView.getRefreshableView().addHeaderView(View.inflate(getActivity(),R.layout.fragment_information,null));
        mPullToRefreshListView.setMode(PullToRefreshBase.Mode.BOTH);
        ILoadingLayout loadingLayoutProxy = mPullToRefreshListView
                .getLoadingLayoutProxy(true, false);
        loadingLayoutProxy.setPullLabel("下拉刷新...");// 刚下拉时，显示的提示
        loadingLayoutProxy.setRefreshingLabel("正在刷新...");// 刷新时
        loadingLayoutProxy.setReleaseLabel("放开刷新...");// 下来达到一定距离时，显示的提示
        ILoadingLayout loadingLayoutProxyBottom = mPullToRefreshListView
                .getLoadingLayoutProxy(false, true);
        loadingLayoutProxyBottom.setPullLabel("上拉加载更多...");// 刚下拉时，显示的提示
        loadingLayoutProxyBottom.setRefreshingLabel("正在载入...");// 刷新时
        loadingLayoutProxyBottom.setReleaseLabel("放开加载更多...");// 下来达到一定距离时，显示的提示

        mPullToRefreshListView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2() {

            @Override
            public void onPullDownToRefresh(PullToRefreshBase refreshView) {
//                reSetPullToRefreshGridView();
//                requestDoctorListpageNo();

            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase refreshView) {
//                urls.clear();
//                requestDoctorListpageNo();

            }
        });
        initViews();
        initDatas();
        mIndictor.setVisiableTabCount(3);
        mIndictor.setTabItemTitles(mTitles);

        mViewPager.setAdapter(mAdapter);
        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int position) {
                // TODO Auto-generated method stub
                Toast.makeText(getActivity(), "position"+position,Toast.LENGTH_SHORT).show();
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
        // 自定义监听
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

        return view;
    }
    /**切换到其他视图时，销毁当前视图*/
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mContents.removeAll(mContents);
    }
    /**初始化控件*/
    private void initViews() {
        mViewPager = (ViewPager) view.findViewById(R.id.id_viewPager);
        mIndictor = (ViewPagerIndictor) view.findViewById(R.id.id_indictor);

    }
    /**初始化系统自带adapter*/
    private void initDatas() {
        mAdapter = new FragmentPagerAdapter(getChildFragmentManager()) {
            @Override
            public int getCount() {
                return  3;
            }

            @Override
            public Fragment getItem(int position) {
                //return VpSimpleFragment.newInstance(title);
                switch (position) {
                    // 根据 position 设置每个Fragment View
                    case 0:
                        return VpSimpleFragmentA.newInstance("a",1);
                    case 1:
                        return VpSimpleFragmentB.newInstance("b",2);
                    case 2:
                        return VpSimpleFragment.newInstance("c",3);
                    default:
                        return null;
                }
            }
        };
    }
    /**自定义的Adapter，可操纵性强*/
//    class FragmentAdapter extends FragmentPagerAdapter{
//
//        public FragmentAdapter(FragmentManager fm) {
//            super(fm);
//        }
//
//        @Override
//        public Fragment getItem(int position) {
//            switch (position) {
//                // 根据 position 设置每个Fragment View
//                case 0:
//                    return VpSimpleFragmentA.newInstance("a",1);
//                case 1:
//                    return VpSimpleFragmentB.newInstance("b",2);
//                case 2:
//                    return VpSimpleFragment.newInstance("c",3);
//                default:
//                    return null;
//            }
//        }
//
//        @Override
//        public int getCount() {
//            return 3;
//        }
//    }

}
