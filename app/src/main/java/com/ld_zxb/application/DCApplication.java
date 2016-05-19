package com.ld_zxb.application;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;

import com.ld_zxb.config.Constants;
import com.ld_zxb.utils.ImageDownLoader;
import com.ld_zxb.utils.Logge;
import com.ld_zxb.utils.SPUtils;
import com.ld_zxb.vo.UserLoginBodyVo;
import com.ld_zxb.vo.UserLoginVo;
import com.nostra13.universalimageloader.cache.memory.impl.UsingFreqLimitedMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import java.io.File;

/**
 * Created by cuiyinglai on 16/5/10.
 */
public class DCApplication extends Application{

    private File saveDir;
    public static Context appContext;
    public final String PREF_USERNAME = "username";
    public static String  userName;

    private static final String PREF_PWD = "pwd";
    public static String password;
    private static DCApplication instance;

    private UserLoginBodyVo userloginbodyvo;
    private UserLoginVo userLoginInfo;

    private String sessionId;
    private String uuid;
    public static boolean timeOutOrLoginCrowdOut = false;
    public static boolean isShowingDialog = false;
    private boolean login = false;//是否登录状态的字符串默认为否
    public static DCApplication isdekushuapplication;
    private  String[] business=new String[]{"p2pMobile","quickpayMobile"};
    public DCApplication() {
        // TODO Auto-generated constructor stub
    }
    @Override
    public void onTerminate(){
        super.onTerminate();
       /* PolyvSDKClient client = PolyvSDKClient.getInstance();
        client.stopService(getApplicationContext(), PolyvDemoService.class);*/
    }






    @Override
    public void onCreate() {
        super.onCreate();


        //获取手机屏幕参数
        DisplayMetrics metric = getApplicationContext().getResources().getDisplayMetrics();
        Constants.SCREEN_WIDTH = metric.widthPixels;

        Constants.SCREEN_HEIGHT = metric.heightPixels;

        Logge.LogE("屏幕宽度为：" + Constants.SCREEN_WIDTH);

        initImageLoader();

        // 获取版本号
        PackageManager mPckManager = this.getPackageManager();
        try {
            PackageInfo info = mPckManager.getPackageInfo(
                    this.getPackageName(), 0);
            Constants.VERSIONCODE = info.versionCode;
            Constants.VERSIONNAME = info.versionName;
            Logge.LogE("版本号为：" + Constants.VERSIONNAME);

        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

        // 获取系统版本
        Constants.SYSTEM_VERSION = android.os.Build.VERSION.SDK_INT;
        Logge.LogE("系统版本号为：" + Constants.SYSTEM_VERSION);
        //		//丰付 pay 初始化
        //		sdk=SumaPaySDK.defaultService();
        //		//0代表正式环境，1代表测试环境
        //		sdk.initService(this, "CSSH", business,"1");
        //sdk.initService(this, "CSSH", business,"0");
        getSIMInfo();
        //		startDownloadService();



    }

    /**
     * 初始化imageLoader
     */

    private void initImageLoader() {
        DisplayMetrics displayMetrics = getApplicationContext().getResources()
                .getDisplayMetrics();
        DisplayImageOptions options = new DisplayImageOptions.Builder()
                // .showImageOnLoading(R.drawable._0000_6) // 设置图片在下载期间显示的图片
                // .showImageForEmptyUri(R.drawable._0000_6)//
                // 设置图片Uri为空或是错误的时候显示的图片
                // .showImageOnFail(R.drawable._0000_6) // 设置图片加载/解码过程中错误时候显示的图片
                .cacheInMemory(true)// 设置下载的图片是否缓存在内存中
                .cacheOnDisc(true).bitmapConfig(Bitmap.Config.RGB_565)// 设置下载的图片是否缓存在SD卡中ß
                .build();// 构建完成
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(
                this)
                .memoryCache(new UsingFreqLimitedMemoryCache(4 * 1024 * 1024))
                // You can pass your own memory cache
                // implementation/你可以通过自己的内存缓存实现
                .memoryCacheSize(5 * 1024 * 1024)
                .discCacheSize(50 * 1024 * 1024)
                .memoryCacheExtraOptions(
                        (int) (displayMetrics.widthPixels
                                / displayMetrics.density * 0.8),
                        (int) (displayMetrics.heightPixels
                                / displayMetrics.density * 0.8))
                .imageDownloader(new ImageDownLoader(getApplicationContext())) // connectTimeout
                // (5
                // s),
                // readTimeout
                // (30
                // s)超时时间
                .defaultDisplayImageOptions(options).build();// 开始构建
        ImageLoader.getInstance().init(config);// 全局初始化此配置

    }
    public File getImgDir() {
		/* 不做判断的话，如果手机支持扩展内存，并且没有装sd卡会报错 */
		/*if (sdCardExist) {
			return getExternalCacheDir();
		} else {
			return Environment.getDataDirectory();
		}*/
        return Environment.getDataDirectory();
    }

    /**
     * 获取运营商
     *
     * void
     */
    private void getSIMInfo() {
        // TODO Auto-generated method stub
        TelephonyManager tm = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
        String operator = tm.getSimOperator();

        if (null != operator) {
            if (operator.equals("46000") || operator.equals("46002")) {
                Constants.OPERATOR = 0;
                // 中国移动
            } else if (operator.equals("46001")) {
                // 中国联通
                Constants.OPERATOR = 1;
            } else if (operator.equals("46003")) {
                // 中国电信
                Constants.OPERATOR = 2;
            }
        }
    }


    public UserLoginBodyVo getUserloginbodyvo() {
        return userloginbodyvo;
    }

    public void setUserloginbodyvo(UserLoginBodyVo person) {
        this.userloginbodyvo = person;
        SPUtils.put(this, "person", person);
    }


    public static DCApplication getInstance() {
        return instance;
    }
    public UserLoginVo getUserLoginInfo() {
        return userLoginInfo;
    }

    public void setUserLoginInfo(UserLoginVo loginInfo) {
        this.userLoginInfo = loginInfo;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    //是否登录的字符串
    public boolean getLogin() {
        return login;
    }
    public void setLogin(boolean login) {
        this.login = login;
    }


    public boolean modifyPassWSuccess = false;
    /*
     * 用户信息操作类
     */
    public String getUserName() {
        if (userName == null) {
            SharedPreferences preferences = PreferenceManager
                    .getDefaultSharedPreferences(appContext);
            userName = preferences.getString(PREF_USERNAME, null);
        }
        return userName;
    }
    public String getPassword() {
        if (password == null) {
            SharedPreferences preferences = PreferenceManager
                    .getDefaultSharedPreferences(appContext);
            password = preferences.getString(PREF_PWD, null);
        }
        return password;
    }


    /**
     * 设置用户名
     *
     * @param username
     */
    public void setUserName(String username) {
        if (username != null) {
            SharedPreferences preferences = PreferenceManager
                    .getDefaultSharedPreferences(appContext);
            SharedPreferences.Editor editor = preferences.edit();
            if (editor.putString(PREF_USERNAME, username).commit()) {
                userName = username;
            }
        }
    }

    /**
     * 设置密码 下面的实例代码 只是demo，实际的应用中需要加password 加密后存入 preference 环信sdk
     * 内部的自动登录需要的密码，已经加密存储了
     *
     * @param pwd
     */
    public void setPassword(String pwd) {
        SharedPreferences preferences = PreferenceManager
                .getDefaultSharedPreferences(appContext);
        SharedPreferences.Editor editor = preferences.edit();
        if (editor.putString(PREF_PWD, pwd).commit()) {
            password = pwd;
        }
    }



}
