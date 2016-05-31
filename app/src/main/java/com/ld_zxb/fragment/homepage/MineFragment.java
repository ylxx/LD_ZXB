package com.ld_zxb.fragment.homepage;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Message;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import com.ld_zxb.fragment.BaseBackFragment;
import com.ld_zxb.utils.ClickUtil;
import com.ld_zxb.utils.ShowErrorDialogUtil;
import com.ld_zxb.view.CustomPopupWindow;
import com.ld_zxb.vo.MyPurchaseCourseEntityVo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MineFragment extends BaseBackFragment {
    private DCApplication mApplication;
    private Context mContext;
    private List<MyPurchaseCourseEntityVo.PurchaseCourseBody> purchaseCourseBodies = new ArrayList<MyPurchaseCourseEntityVo.PurchaseCourseBody>();
    private List<MyPurchaseCourseEntityVo.PurchaseCourseBody> purchaseCourseBody = new ArrayList<MyPurchaseCourseEntityVo.PurchaseCourseBody>();
    private PullToRefreshListView plListview;
    private PurchaseCourseAdapter adapter;
    private LinearLayout noPurchaseCourse;
    private ImageView ivGetMenu;
    private View view;
    private int currentPage = 1;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_me, null);
        initView();
        ClickUtil.setClickListener(listener, ivGetMenu);
        return view;
    }

    private void initView() {
        ivGetMenu = (ImageView) view.findViewById(R.id.mainpage_right_bar);
        mApplication = (DCApplication) getActivity().getApplication();
        plListview = (PullToRefreshListView) view.findViewById(R.id.main_gridview);
        noPurchaseCourse =(LinearLayout) view.findViewById(R.id.no_purchase_course);
        plListview.getRefreshableView().addHeaderView(View.inflate(getActivity(), R.layout.header_minepagefragment, null));
        plListview.setMode(PullToRefreshBase.Mode.BOTH);

        ClickUtil.setClickListener(listener, ivGetMenu);

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

    /**
     * 监听事件
    */
    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.mainpage_right_bar:
                    CustomPopupWindow customPopupWindow = new CustomPopupWindow(getActivity());
                    customPopupWindow.showAtDropDownRight(ivGetMenu);
                    break;
                default:
                    break;
            }
        }
    };


    // private CircleIndicator mCiBanner;

    private void reSetPullToRefreshGridView() {
        purchaseCourseBodies.clear();
        plListview.setMode(PullToRefreshBase.Mode.BOTH);

    }

    private void getMyPurchaseCourse() {
        HashMap<String, String> hashmap = new HashMap<String, String>();
        hashmap.put("userId", String.valueOf("1706"));
        new RequestCommant().getPurchaseCourse(new ReauestHandler(getActivity()), getActivity(), hashmap);

    }

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
                    ShowErrorDialogUtil.showErrorDialog(getActivity(), (String) command.message);
                    ; // 請求失敗
                }
            }

        }
    }
}
