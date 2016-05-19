package com.ld_zxb.activity;




import com.ld_zxb.R;
import com.ld_zxb.application.DCApplication;
import com.ld_zxb.config.Constants;
import com.ld_zxb.utils.CustomTitleBar;
import com.ld_zxb.utils.SerialUtils;
import com.ld_zxb.utils.ShowErrorDialogUtil;
import com.ld_zxb.vo.UserLoginVo;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * <pre>
 * 业务名:
 * 功能说明: 
 * 编写日期:	2015年5月6日
 * 作者:	zgz
 * 
 * 历史记录
 * 1、修改日期：
 *    修改人：
 *    修改内容：
 * </pre>
 */


public class BaseFragmentActivity extends AppCompatActivity implements OnClickListener {


	protected FragmentManager mFragmentManager;
	protected FragmentTransaction mFragmentTransaction;

	protected DCApplication mApplication;
	protected CustomTitleBar customTitleBar;

	protected SharedPreferences userInfo;
	private SerialUtils serialutols;
	public static boolean insideTopUpWebView = false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		mFragmentManager = getSupportFragmentManager();
		mApplication = (DCApplication) getApplication();
		userInfo = getSharedPreferences(Constants.INIT_USER_INFO,
				Context.MODE_PRIVATE);
		serialutols = new SerialUtils();
		if (null != savedInstanceState) {
			mApplication = (DCApplication) getApplication();
			if (savedInstanceState.containsKey("UserLoginInfo")) {
				UserLoginVo loginInfo = (UserLoginVo) savedInstanceState
						.getSerializable("UserLoginInfo");
				mApplication.setUserLoginInfo(loginInfo);
			}
			if (savedInstanceState.containsKey("timeOutOrLoginCrowdOut")) {
				DCApplication.timeOutOrLoginCrowdOut = savedInstanceState
						.getBoolean("timeOutOrLoginCrowdOut");
			}
			if (savedInstanceState.containsKey("sessionId")) {
				mApplication.setSessionId(savedInstanceState
						.getString("sessionId"));
			}
//			if (savedInstanceState.containsKey("myAccountBodyVO")) {
//				mApplication.myAccountBodyVO = (MyAccountBodyVO) savedInstanceState
//						.getSerializable("myAccountBodyVO");
//			}
		}
	}
    
	/**
	 * 添加title的方法
	 * @param layoutId
	 * @param str
	 */
	public void setContentViewWithActionBar(int layoutId,String str1,String str2){
		//获取一个LayoutInflater实例
		LayoutInflater inflater = getLayoutInflater();
		//设置一个viewGroup
		ViewGroup contentV = (ViewGroup) inflater.inflate(R.layout.activity_base, null);
		inflater.inflate(layoutId, contentV);
		setContentView(contentV);
		//初始化customTitleBar
		customTitleBar = (CustomTitleBar) findViewById(R.id.title_bar);
		//初始化initViewBar方法，获得里面的id
		customTitleBar.initViewBar(contentV);
		customTitleBar.setLeftBar(str1);
		customTitleBar.setMiddleBar(str2);
		//为leftBar添加点击事件
		customTitleBar.getLeftBar().setOnClickListener(this);
		customTitleBar.getLefttext().setOnClickListener(this);
	}
	 
	 
	protected OnClickListener backListener = new OnClickListener() {
		@Override
		public void onClick(View view) {
			// TODO Auto-generated method stub
			finish();
		}
	};

	protected OnClickListener backTextListener = new OnClickListener() {
		@Override
		public void onClick(View view) {
			// TODO Auto-generated method stub
			finish();
		}
	};

	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);

		if (null != mApplication.getUserLoginInfo()) {
			outState.putSerializable("UserLoginInfo",
					mApplication.getUserLoginInfo());
		}
		outState.putBoolean("timeOutOrLoginCrowdOut",
				DCApplication.timeOutOrLoginCrowdOut);
		if (null != mApplication.getSessionId()) {
			outState.putString("sessionId", mApplication.getSessionId());
		}
	};

	protected void showError(int errResource) {
		ShowErrorDialogUtil.showErrorDialog(this, getString(errResource));
	}
	protected void showError(String errStr) {
		ShowErrorDialogUtil.showErrorDialog(this, errStr); 
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(v.getId() == R.id.left_bar){
			finish();
		}else if(v.getId() == R.id.left_bar_text){
			finish();
		}
	}
	
	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
//		Object object = false;
//		if((Boolean)SPUtils.get(this, "isbackground", false)){
//			//SPUtils.put(this, "isbackground", false);
//			Intent  intent = new Intent(this, GestureVerifyActivity.class);
//			startActivity(intent);
//		}
	}
	
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
//		SPUtils.put(this, "isbackground", true);
//		ActivityCollector.removeActivity(this);
	}
	
	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();

		
//		if(AppUtils.isRunningBackground(this)){
//			String gesturePsd = SPUtils.get(mApplication, "gesturePsd", "").toString();
//			if("".equals(gesturePsd)){
//				SPUtils.put(this, "isbackground", false);
//			}else{
//				SPUtils.put(this, "isbackground", true);
//			}
//			System.out.println("是否跟后台运行（activity）"+(Boolean) SPUtils.get(mApplication, "isbackground", false));
//		}
	}
	
	
}
