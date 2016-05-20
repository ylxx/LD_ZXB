package com.ld_zxb.fragment.homepage;

import android.content.Context;
import android.os.Bundle;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.handmark.pulltorefresh.library.ILoadingLayout;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshBase.Mode;
import com.handmark.pulltorefresh.library.PullToRefreshBase.OnRefreshListener2;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.ld_zxb.R;
import com.ld_zxb.application.DCApplication;
import com.ld_zxb.config.Constants;
import com.ld_zxb.controller.BaseHandler;
import com.ld_zxb.controller.RequestCommant;
import com.ld_zxb.fragment.BaseBackFragment;
import com.ld_zxb.utils.ShowErrorDialogUtil;
import com.ld_zxb.view.FlashView;
import com.ld_zxb.vo.HomePageBodyVo;
import com.ld_zxb.vo.HomePageImageVo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HomePageFragment extends BaseBackFragment {

    private Context mContext;
    private DCApplication mApplication;
    private View view;
    static final int MENU_SET_MODE = 0;
    private PullToRefreshListView mPullToRefreshListView;
    private FlashView mFlashView;
    //轮播图地址
    private List<String> urls = new ArrayList<String>();
    //点击轮播图跳转路径
    private List<String> gotoUrls = new ArrayList<String>();

    private int currentPage = 1;

    private List<HomePageImageVo> lsBanner;
    private String userId;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_homepage,null);
        initView();
        return view;
    }

    private void initView() {
        requestHomeData();
        mApplication = (DCApplication) getActivity().getApplication();
        mPullToRefreshListView = (PullToRefreshListView) view
                .findViewById(R.id.gridview);
        mPullToRefreshListView.getRefreshableView().addHeaderView(View.inflate(getActivity(),R.layout.header_homepagefragmen,null));
        mPullToRefreshListView.setMode(Mode.BOTH);




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

        mPullToRefreshListView.setOnRefreshListener(new OnRefreshListener2() {

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

        mFlashView = (FlashView) view.findViewById(R.id.flashview);
        /*mFlashView.setOnFlashViewListener(new FlashViewListener() {
                                              @Override
                                              public void onClick(int position) {
                                                  String url = gotoUrls.get(position);

                                                  if (!url.contains("http://")) {
                                                      url = "http://" + url;
                                                  }
                                                  Uri content_url = Uri.parse(url);
                                                  Intent intent = new Intent(getActivity(), WebEmbedActivity.class);
                                                  intent.putExtra("url", String.valueOf(content_url));
                                                  intent.putExtra("title", "助学宝");
                                                  startActivity(intent);
                                              }
                                          }
        );*/

    }


    /**
     * 加载轮播数据
     */
    private void requestHomeData(){


        HashMap<String, String>  hashmap = new HashMap<String, String>();
        hashmap.put("userId", "1234567");
        new RequestCommant().requestHomeData(new ReauestHandler(this), getActivity(), hashmap);
    }

    private class ReauestHandler extends BaseHandler {

        public ReauestHandler(Fragment fragment) {
            super(fragment);
            // TODO Auto-generated constructor stub
        }

        @Override
        public void handleMessage(Message msg) {
            // TODO Auto-generated method stub
            super.handleMessage(msg);
            HomePageFragment fragment = (HomePageFragment) mFragment
                    .get();
            if (null != fragment) {

                if (msg.what == Constants.HOME_DATA) {
                    if (command.success) {
                        if(null != command.resData){
                            HomePageBodyVo body = (HomePageBodyVo)command.resData;
                            //轮播图
                            lsBanner =body.getBody();
                            if(lsBanner!=null){
                                for (int i = 0; i < lsBanner.size(); i++) {
                                    //轮播图地址
                                    String url = lsBanner.get(i).getUrl();
                                    urls.add(url);
                                    //跳转地址
                                    String gotoUrl=lsBanner.get(i).getPath();
                                    gotoUrls.add(gotoUrl);
                                }
                                mFlashView.setImageUris(urls);
                                //								mFlashView.setImagePaths(gotoUrls);
                            }

                        }
                    } else {
                        ShowErrorDialogUtil.showErrorDialog(getActivity(),(String) command.message);; // 請求失敗
                    }
                }
                /*if (msg.what == Constants.CLASSY_EXAM) {
                    if (command.success) {
                        if(null != command.resData){
                            HomePageBottomEntityVo homePageBottomEntityVo = (HomePageBottomEntityVo)command.resData;
                            courseLists = homePageBottomEntityVo.getEntity().getCourseList();
                            if(courseLists!=null){
                                for (int i = 0; i < courseLists.size(); i++) {
                                    //轮播图文字
                                    String titleString = courseLists.get(i).getName();
                                    //轮播图地址
                                    String url = "http://static.langdunzx.com/" + courseLists.get(i).getLogo();
                                    bottomUrls.add(url);
                                    //将获取的文字加入集合
                                    bottomTitles.add(titleString);
                                }
                                //								mFlashViewBottom.setImageUris(bottomUrls);
                                mFlashViewBottom.setBottomanImageUris(bottomUrls, bottomTitles);
                                System.out.println("bottomTitles"+bottomTitles);
                                //								mFlashViewBottom.setTitleString(bottomTitles);
                                //								flName.setText(bottomName);
                            }

                        }
                    } else {
                        ShowErrorDialogUtil.showErrorDialog(getActivity(),(String) command.message);; // 請求失敗
                    }
                }*/
            }
        }
    }



}
