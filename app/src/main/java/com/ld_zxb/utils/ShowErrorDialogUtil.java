/*******************************************************************************
 * Copyright (c) 2015 by dennis Corporation all right reserved.
 * 2015年5月13日 
 * 
 *******************************************************************************/ 
package com.ld_zxb.utils;



import com.ld_zxb.R;
import com.ld_zxb.application.DCApplication;
import com.ld_zxb.dialog.LDDialog;
import com.ld_zxb.dialog.LDDialog.DCDialogListener;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

/**
 * <pre>
 * 业务名:
 * 功能说明: 提示dialog
 * 编写日期:	2015年5月13日
 * 作者:	zgz
 * 
 * 历史记录
 * 1、修改日期：
 *    修改人：
 *    修改内容：
 * </pre>
 */
public class ShowErrorDialogUtil {

	public static void showErrorDialog(Context context, String errString) {
		if (DCApplication.isShowingDialog)
			return;
		LDDialog dialog= new LDDialog(context, listener);
		dialog.show();
		dialog.getDialogContentTxt().setText(errString);
		dialog.getPreviousBtn().setText("确定");
		dialog.getDialogImage().setBackgroundResource(
				R.drawable.dialog_error_icon);

	}

	public static void showErrorDialog(Context context, String errString,
			DCDialogListener listener) {
		if (DCApplication.isShowingDialog)
			return;
		LDDialog dialog = null;
		dialog = new LDDialog(context, listener);
		dialog.show();
		dialog.getDialogContentTxt().setText(errString);
		dialog.getPreviousBtn().setText("确定");
		dialog.getDialogImage().setBackgroundResource(
				R.drawable.alert_dialog_right);
	}
	public static void showSuccesDialog(Context context, String errString,
			DCDialogListener listener) {
		if (DCApplication.isShowingDialog)
			return;
		LDDialog dialog = null;
		dialog = new LDDialog(context, listener);
		dialog.show();
		dialog.getDialogContentTxt().setText(errString);
		dialog.getPreviousBtn().setText("确定");
		dialog.getDialogImage().setBackgroundResource(
				R.drawable.alert_dialog_right);
	}
	public static Dialog showDoubleSelect(Context context, String content, final OnDialogClickListener cancel,
			final OnDialogClickListener sure) {
		final Dialog dialog = new Dialog(context, R.style.DialogTheme);
		dialog.setCancelable(false);
		dialog.setContentView(R.layout.dialog_package_payment);
		dialog.getWindow().getDecorView().setBackgroundColor(0x00FFFFFF);

		dialog.findViewById(R.id.btn_cancel).setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				cancel.onDialogClick(dialog, v);
			}
		});
		dialog.findViewById(R.id.btn_sure).setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				sure.onDialogClick(dialog, v);

			}
		});
		((TextView) dialog.findViewById(R.id.tv_content)).setText(content);
		if (DCApplication.isShowingDialog)
			return dialog;
		dialog.show();
		return dialog;
	}
	public static void showAlertDialog(Context context, String errString, String buttonString,
			DCDialogListener listener) {
		if (DCApplication.isShowingDialog)
			return;
		DCApplication.isShowingDialog = true;
		LDDialog dialog = new LDDialog(context, listener);
		dialog.show();
		dialog.getDialogContentTxt().setText(errString);
		dialog.getPreviousBtn().setText(buttonString);
		dialog.getDialogImage().setBackgroundResource(R.drawable.dialog_error_icon);

	}
	public static void showAlertInfoDialog(Context context, String errString, String cancelString,String confirmString,
			DCDialogListener listener) {


		LDDialog dialog = new LDDialog(context, listener);
		dialog.show();
		dialog.getDialogContentTxt().setText(errString);
		dialog.getPreviousBtn().setText(cancelString);
		dialog.getNextBtn().setText(confirmString);
		dialog.getDialogImage().setBackgroundResource(R.drawable.dialog_error_icon);

	}

	private static DCDialogListener listener = new DCDialogListener() {

		@Override
		public void OnPreviousButtonClicked(LDDialog dialog) {
			// TODO Auto-generated method stub
			if (null != dialog && dialog.isShowing()) {
				dialog.dismiss();
				dialog=null;
			}
		}

		@Override
		public void OnMiddleButtonClicked(LDDialog dialog) {
			// TODO Auto-generated method stub

		}

		@Override
		public void OnNextButtonClicked(LDDialog dialog) {
			// TODO Auto-generated method stub

		}

	};
	public interface OnDialogClickListener {
		public void onDialogClick(Dialog dialog, View v);
	}
}
