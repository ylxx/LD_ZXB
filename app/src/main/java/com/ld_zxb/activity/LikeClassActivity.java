package com.ld_zxb.activity;

import android.app.Activity;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.handmark.pulltorefresh.library.ILoadingLayout;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.ld_zxb.R;
import com.ld_zxb.adapter.PurchaseCourseAdapter;
import com.ld_zxb.application.DCApplication;
import com.ld_zxb.config.Constants;
import com.ld_zxb.controller.BaseHandler;
import com.ld_zxb.controller.RequestCommant;
import com.ld_zxb.utils.ClickUtil;
import com.ld_zxb.utils.ShowErrorDialogUtil;
import com.ld_zxb.view.CircleImageView;
import com.ld_zxb.view.LikeClassPopupWindow;
import com.ld_zxb.vo.MyPurchaseCourseEntityVo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LikeClassActivity extends BaseFragmentActivity {
    private DCApplication mApplication;
    CircleImageView circleImageView;
    private PullToRefreshListView plListview;
    private PurchaseCourseAdapter adapter;
    private LinearLayout noPurchaseCourse;
    ImageView likeclass_right_bar, likeclass_Left_back;
    private List<MyPurchaseCourseEntityVo.PurchaseCourseBody> purchaseCourseBodies = new ArrayList<MyPurchaseCourseEntityVo.PurchaseCourseBody>();
    private List<MyPurchaseCourseEntityVo.PurchaseCourseBody> purchaseCourseBody = new ArrayList<MyPurchaseCourseEntityVo.PurchaseCourseBody>();
    private int currentPage = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_likeclass);
        initView();
    }

    private void initView() {
        likeclass_right_bar = (ImageView) findViewById(R.id.likeclass_right_bar);
        likeclass_Left_back = (ImageView) findViewById(R.id.likeclass_Left_back);
        mApplication = (DCApplication) this.getApplication();
        plListview = (PullToRefreshListView) findViewById(R.id.like_gridview);
        noPurchaseCourse = (LinearLayout) findViewById(R.id.like_purchase_course);
        plListview.getRefreshableView().addHeaderView(View.inflate(this, R.layout.header_minepagefragment, null));
        plListview.setMode(PullToRefreshBase.Mode.BOTH);
        ClickUtil.setClickListener(listener, likeclass_right_bar, likeclass_Left_back);

        ILoadingLayout loadingLayoutProxy = plListview
                .getLoadingLayoutProxy(true, false);
        loadingLayoutProxy.setPullLabel("下拉刷新...");// 刚下拉时，显示的提示
        loadingLayoutProxy.setRefreshingLabel("正在刷新...");// 刷新时
        loadingLayoutProxy.setReleaseLabel("放开刷新...");// 下来达到一定距离时，显示的提示
        ILoadingLayout endLabels = plListview.getLoadingLayoutProxy(false,
                true);
        endLabels.setPullLabel("上拉加载...");// 刚下拉时，显示的提示
        endLabels.setRefreshingLabel("正在载入...");// 刷新时
        endLabels.setReleaseLabel("屏幕上拉,显示更多");// 下来达到一定距离时，显示的提示


        plListview.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2() {

            @Override
            public void onPullDownToRefresh(PullToRefreshBase refreshView) {
                purchaseCourseBodies.clear();
                currentPage = 1;
                getMyPurchaseCourse();

            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase refreshView) {
                plListview.setMode(PullToRefreshBase.Mode.BOTH);
                getMyPurchaseCourse();
            }


        });

        reSetPullToRefreshGridView();
        getMyPurchaseCourse();
    }

    private void reSetPullToRefreshGridView() {
        purchaseCourseBodies.clear();
        plListview.setMode(PullToRefreshBase.Mode.BOTH);
    }
    private void getMyPurchaseCourse() {
        HashMap<String, String> hashmap = new HashMap<String, String>();
        hashmap.put("userId", String.valueOf("1706"));
        new RequestCommant().getPurchaseCourse(new ReauestHandler(this), this, hashmap);

    }

    /**
     * 监听事件
     */
    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.likeclass_right_bar:
                    LikeClassPopupWindow likeClassPopupWindow = new LikeClassPopupWindow(LikeClassActivity.this);
                    likeClassPopupWindow.showAtDropDownLeft(likeclass_right_bar);
                    break;
                case R.id.likeclass_Left_back:
                    LikeClassActivity.this.finish();
                    break;
                default:
                    break;
            }
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
            if (msg.what == Constants.GET_PURCHASE_COURSE) {
                System.out.println(command.success);
                plListview.onRefreshComplete();
                if (command.success) {
                    MyPurchaseCourseEntityVo purchaseCourseEntityVo = (MyPurchaseCourseEntityVo) command.resData;
                    purchaseCourseBody = purchaseCourseEntityVo.getPurchaseCourseBody();
                    purchaseCourseBodies.addAll(purchaseCourseBody);

                    if (purchaseCourseBodies.size() <= 0) {
                        plListview.setVisibility(View.GONE);
                        noPurchaseCourse.setVisibility(View.VISIBLE);
                    } else {
                        plListview.setVisibility(View.VISIBLE);
                        noPurchaseCourse.setVisibility(View.GONE);
                    }
//                    adapter.notifyDataSetChanged();
                    currentPage++;
                    if (currentPage > 0) {
                        plListview.setMode(PullToRefreshBase.Mode.PULL_FROM_START);
                    }

                } else {
                    ShowErrorDialogUtil.showErrorDialog(LikeClassActivity.this, (String) command.message);
                    ; // 請求失敗
                }
            }
        }
    }
}