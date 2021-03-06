package com.ld_zxb.fragment.homepage;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.handmark.pulltorefresh.library.ILoadingLayout;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshBase.Mode;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.ld_zxb.R;
import com.ld_zxb.activity.course.CourseClassifyActivity;
import com.ld_zxb.activity.login.LoginActivity;
import com.ld_zxb.activity.secondary.SearchActivity;
import com.ld_zxb.activity.secondary.WebEmbedActivity;
import com.ld_zxb.adapter.HomePageAdapter;
import com.ld_zxb.application.DCApplication;
import com.ld_zxb.config.Constants;
import com.ld_zxb.controller.BaseHandler;
import com.ld_zxb.controller.RequestCommant;
import com.ld_zxb.fragment.BaseBackFragment;
import com.ld_zxb.utils.ClickUtil;
import com.ld_zxb.utils.SerialUtils;
import com.ld_zxb.utils.ShowErrorDialogUtil;
import com.ld_zxb.view.FlashView;
import com.ld_zxb.view.FlashViewListener;
import com.ld_zxb.vo.HomePageBodyVo;
import com.ld_zxb.vo.HomePageBottomEntityBodyVo;
import com.ld_zxb.vo.HomePageBottomEntityBodyVo.CourseList;
import com.ld_zxb.vo.HomePageBottomEntityVo;
import com.ld_zxb.vo.HomePageImageVo;
import com.ld_zxb.vo.UserLoginBodyVo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HomePageFragment extends BaseBackFragment {

    private static final String TYPE_ONE = "1";
    private static final String TYPE_TWO = "2";
    private static final String TYPE_THREE = "3";
    private DCApplication application;
    private SerialUtils serialutols;
    private boolean logIn;
    private Context mContext;
    private DCApplication mApplication;
    private RelativeLayout rlOne,rlTwo,rlThree;
    private View view;
    static final int MENU_SET_MODE = 0;
    private PullToRefreshListView mPullToRefreshListView;
    private FlashView mFlashView;
    //轮播图地址
    private List<String> urls = new ArrayList<String>();
    //点击轮播图跳转路径
    private List<String> gotoUrls = new ArrayList<String>();
    private ImageView ivSearch,ivToLogin;
    private TextView tv_text;
    private HomePageAdapter adapter;

    private List<HomePageImageVo> lsBanner;
    private int userId;
    //bottom轮播图相关
    private List<CourseList> courseLists = new ArrayList<CourseList>();
    private List<CourseList> courseList = new ArrayList<CourseList>();

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        serialutols = new SerialUtils();
        application = (DCApplication) getActivity().getApplication();
        if(serialutols.getObject(getActivity())==null){
            startActivity(new Intent(getActivity(),LoginActivity.class));
        }else{
            try {
                UserLoginBodyVo userinfo = serialutols.deSerialization(serialutols.getObject(getActivity()));
                //用户Id(非268)
                userId=userinfo.getBody().getId();

            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        logIn = application.getLogin();

        view = inflater.inflate(R.layout.fragment_homepage,null);


        initView();
        return view;
    }

    private void initView() {
        ivSearch = (ImageView) view.findViewById(R.id.homepage_left_bar);
        ivToLogin = (ImageView) view.findViewById(R.id.homepage_right_bar);
        mApplication = (DCApplication) getActivity().getApplication();
        mPullToRefreshListView = (PullToRefreshListView) view
                .findViewById(R.id.gridview);
        mPullToRefreshListView.getRefreshableView().addHeaderView(View.inflate(getActivity(),R.layout.header_homepagefragmen,null));
        mPullToRefreshListView.setMode(Mode.BOTH);
        rlOne = (RelativeLayout) view.findViewById(R.id.rl_homepage_1);
        rlTwo = (RelativeLayout) view.findViewById(R.id.rl_homepage_2);
        rlThree = (RelativeLayout) view.findViewById(R.id.rl_homepage_3);


        ClickUtil.setClickListener(clicklistener,ivSearch,ivToLogin,rlOne,rlTwo,rlThree);

        ILoadingLayout loadingLayoutProxy = mPullToRefreshListView
                .getLoadingLayoutProxy(true, false);
        loadingLayoutProxy.setPullLabel("下拉刷新...");// 刚下拉时，显示的提示
        loadingLayoutProxy.setRefreshingLabel("正在刷新...");// 刷新时
        loadingLayoutProxy.setReleaseLabel("放开刷新...");// 下来达到一定距离时，显示的提示

        ILoadingLayout endLabels = mPullToRefreshListView.getLoadingLayoutProxy(false,
                true);
        endLabels.setPullLabel("上拉加载...");// 刚下拉时，显示的提示
        endLabels.setRefreshingLabel("正在载入...");// 刷新时
        endLabels.setReleaseLabel("屏幕上拉,显示更多");// 下来达到一定距离时，显示的提示


        mPullToRefreshListView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2() {

            @Override
            public void onPullDownToRefresh(PullToRefreshBase refreshView) {
                reSetPullToRefreshGridView();
                getData();

            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase refreshView) {

                reSetPullToRefreshGridView();
                getData();
            }
        });

        mFlashView = (FlashView) view.findViewById(R.id.flashview);
        mFlashView.setOnFlashViewListener(new FlashViewListener() {
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
        );


        reSetPullToRefreshGridView();

        getData();


    }

    private void getData() {
        //访问轮播图接口
        requestHomeData();
        //访问推荐课程接口
        requestKaoZheng();


    }


    private void addList() {
        courseList.clear();
        courseLists.clear();
        List<String> l1 = new ArrayList<String>();
        l1.add("赵国宇");
        HomePageBottomEntityBodyVo.CourseList course1 = new HomePageBottomEntityBodyVo.CourseList();
        course1.setCourseId(173);
        course1.setName("赵国宇");
        course1.setTitle("企业并购与重组");
        course1.setLogo("/upload/mavendemo/course/20150820/1440073290946797266.jpg");
        course1.setTeacherList(l1);
        courseList.add(course1);

        List<String> l2 = new ArrayList<String>();
        l2.add("雷宇，佟爱琴");
        HomePageBottomEntityBodyVo.CourseList course2 = new HomePageBottomEntityBodyVo.CourseList();
        course2.setCourseId(172);
        course2.setName("雷宇，佟爱琴");
        course2.setTitle("公司战略与财务");
        course2.setLogo("/upload/mavendemo/course/20150820/1440073211538233379.jpg");
        course2.setTeacherList(l2);
        courseList.add(course2);

        List<String> l3 = new ArrayList<String>();
        l3.add("郭剑花，曹中");
        HomePageBottomEntityBodyVo.CourseList course3 = new HomePageBottomEntityBodyVo.CourseList();
        course3.setCourseId(171);
        course3.setName("郭剑花，曹中");
        course3.setTitle("财务分析工具");
        course3.setLogo("/upload/mavendemo/course/20150820/1440072627737519719.jpg");
        course3.setTeacherList(l3);
        courseList.add(course3);

        List<String> l4 = new ArrayList<String>();
        l4.add("黄金波，高慧");
        HomePageBottomEntityBodyVo.CourseList course4 = new HomePageBottomEntityBodyVo.CourseList();
        course4.setCourseId(157);
        course4.setName("黄金波，高慧");
        course4.setTitle("金融工具");
        course4.setLogo("/upload/mavendemo/course/20150819/1439948730322647415.jpg");
        course4.setTeacherList(l4);
        courseList.add(course4);

        List<String> l5 = new ArrayList<String>();
        l5.add("闵岳，徐习兵");
        HomePageBottomEntityBodyVo.CourseList course5 = new HomePageBottomEntityBodyVo.CourseList();
        course5.setCourseId(156);
        course5.setName("闵岳，徐习兵");
        course5.setTitle("全面预算管理");
        course5.setLogo("/upload/mavendemo/course/20150818/1439888374802858802.jpg");
        course5.setTeacherList(l5);
        courseList.add(course5);

        List<String> l6 = new ArrayList<String>();
        l4.add("郭葆春");
        HomePageBottomEntityBodyVo.CourseList course6 = new HomePageBottomEntityBodyVo.CourseList();
        course6.setCourseId(155);
        course6.setName("郭葆春");
        course6.setTitle("财务管理法规与职业道德");
        course6.setLogo("/upload/mavendemo/course/20150818/1439887623304361079.jpg");
        course6.setTeacherList(l6);
        courseList.add(course6);

        List<String> l7 = new ArrayList<String>();
        l4.add("沈雅琴，潘敏虹");
        HomePageBottomEntityBodyVo.CourseList course7 = new HomePageBottomEntityBodyVo.CourseList();
        course7.setCourseId(159);
        course7.setName("沈雅琴，潘敏虹");
        course7.setTitle("风险管理");
        course7.setLogo("/upload/mavendemo/course/20150820/1440043014076009235.jpg");
        course7.setTeacherList(l7);
        courseList.add(course7);

        courseLists.addAll(courseList);

    }




    /**
     * 监听事件
     */
    private View.OnClickListener clicklistener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.homepage_left_bar:
                    startActivity(new Intent(getActivity(),SearchActivity.class));
                    break;
                case R.id.homepage_right_bar:
                    if(logIn){
                        startActivity(new Intent(getActivity(),LoginActivity.class));
                    }else{
                        startActivity(new Intent(getActivity(),LoginActivity.class));
                    }
                    break;
                case R.id.rl_homepage_1:
                    Intent intentOne = new Intent(getActivity(), CourseClassifyActivity.class);
                    intentOne.putExtra("type",TYPE_ONE);
                    startActivity(intentOne);
                    break;
                case R.id.rl_homepage_2:
                    Intent intentTwo = new Intent(getActivity(), CourseClassifyActivity.class);
                    intentTwo.putExtra("type",TYPE_TWO);
                    startActivity(intentTwo);
                    break;
                case R.id.rl_homepage_3:
                    Intent intentThree = new Intent(getActivity(), CourseClassifyActivity.class);
                    intentThree.putExtra("type",TYPE_THREE);
                    startActivity(intentThree);
                    break;
                default:
                    break;
            }
        }
    };


    // private CircleIndicator mCiBanner;

    private void reSetPullToRefreshGridView() {
        urls.clear();
        courseLists.clear();
//        mPullToRefreshListView.setMode(Mode.BOTH);

    }


    /**
     * 加载轮播数据
     */
    private void requestHomeData(){


        HashMap<String, String>  hashmap = new HashMap<String, String>();
        hashmap.put("userId", "1234567");
        new RequestCommant().requestHomeData(new ReauestHandler(this), getActivity(), hashmap);
    }

    /**
     * 加载考证分类信息
     */
    private void requestKaoZheng() {
        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("currentPage", "1");
        hashMap.put("sellType", "PACKAGE");
        new RequestCommant().requestClassyExam(new ReauestHandler(this),getActivity(),hashMap);
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
                            }
                        }
                    } else {
                        ShowErrorDialogUtil.showErrorDialog(getActivity(),(String) command.message);; // 請求失敗
                    }
                }
                if (msg.what == Constants.CLASSY_EXAM) {
                    if (command.success) {
                        mPullToRefreshListView.onRefreshComplete();
                        if(null != command.resData){
                            /*HomePageBottomEntityVo homePageBottomEntityVo = (HomePageBottomEntityVo)command.resData;
                            courseLists = homePageBottomEntityVo.getEntity().getCourseList();*/

                            addList();

                            adapter = new HomePageAdapter(getActivity(), courseLists);
                            mPullToRefreshListView.setAdapter(adapter);
                        }
                    } else {
                        ShowErrorDialogUtil.showErrorDialog(getActivity(),(String) command.message);; // 請求失敗
                    }
                }
            }
        }
    }



}
