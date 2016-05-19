package com.ld_zxb.utils;

import java.util.List;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.Log;

//跟App相关的辅助类
public class AppUtils {

	private AppUtils() {
		/* cannot be instantiated */
		throw new UnsupportedOperationException("cannot be instantiated");

	}

	/**
	 * 获取应用程序名称
	 */
	public static String getAppName(Context context) {
		try {
			PackageManager packageManager = context.getPackageManager();
			PackageInfo packageInfo = packageManager.getPackageInfo(
					context.getPackageName(), 0);
			int labelRes = packageInfo.applicationInfo.labelRes;
			return context.getResources().getString(labelRes);
		} catch (NameNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * [获取应用程序版本名称信息]
	 * 
	 * @param context
	 * @return 当前应用的版本名称
	 */
	public static String getVersionName(Context context) {
		try {
			PackageManager packageManager = context.getPackageManager();
			PackageInfo packageInfo = packageManager.getPackageInfo(
					context.getPackageName(), 0);
			return packageInfo.versionName;

		} catch (NameNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 是否在后台运行
	 * @param @param context
	 * @param @return
	 * @return boolean
	 * @throws
	 */
	public static boolean isRunningBackground(Context context) {
		ActivityManager activityManager = (ActivityManager) context
				.getSystemService(Context.ACTIVITY_SERVICE);
		List<RunningTaskInfo> tasks = activityManager.getRunningTasks(1);

		if (!tasks.isEmpty()) {
			ComponentName topActivity = tasks.get(0).topActivity;
			if (!topActivity.getPackageName().equals(context.getPackageName())) {
				Log.d("allen", "isBackground");
				return true;
			}
			Log.d("allen", "isnotBackground");
		}

		return false;
	}
	
	
	
	/**
	 * 获取屏幕尺寸与密度.
	 * 
	 * @param context
	 *            the context
	 * @return mDisplayMetrics
	 */
	public static DisplayMetrics getDisplayMetrics(Context context) {
		Resources mResources;
		if (context == null) {
			mResources = Resources.getSystem();

		} else {
			mResources = context.getResources();
		}
		// DisplayMetrics{density=1.5, width=480, height=854, scaledDensity=1.5,
		// xdpi=160.421, ydpi=159.497}
		// DisplayMetrics{density=2.0, width=720, height=1280,
		// scaledDensity=2.0, xdpi=160.42105, ydpi=160.15764}
		DisplayMetrics mDisplayMetrics = mResources.getDisplayMetrics();
		return mDisplayMetrics;
	}

}
