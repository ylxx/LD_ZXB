package com.ld_zxb.activity;

import android.app.Activity;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.ld_zxb.R;
import com.ld_zxb.config.Constants;
import com.ld_zxb.controller.BaseHandler;
import com.ld_zxb.controller.RequestCommant;
import com.ld_zxb.utils.CheckUtil;
import com.ld_zxb.utils.ClickUtil;

import java.util.HashMap;

public class RegistActivity extends BaseFragmentActivity {
    EditText edUser,edPhone,edpwd,edpassword,edPhoneCode;
    Button butPhoneCode,butReagist;
    String Phone,User,Pwd,PassWord,PhoneCode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentViewWithActionBar(R.layout.activity_regst,"登录","注册");
        initView();
    }
    private void initView() {
        edUser = (EditText) findViewById(R.id.et_regst_email);
        edPhone = (EditText) findViewById(R.id.et_regst_phone);
        edpwd = (EditText) findViewById(R.id.et_regst_pwd);
        edpassword = (EditText) findViewById(R.id.et_regst_queren_pwd);
        edPhoneCode = (EditText) findViewById(R.id.et_phoneCode);
        butPhoneCode = (Button) findViewById(R.id.butPhoneCode);
        butReagist= (Button) findViewById(R.id.but_Regist);
        ClickUtil.setClickListener(listener, butPhoneCode,butReagist);

    }
    /**
     * 监听事件
     */
    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.butPhoneCode:
                    //获取手机号访问后台请求数据
                    getPhoneVertifyCode();
                    break;
                case R.id.but_Regist:
                    registe();
                    break;
                default:
                    break;
            }
        }
    };
    /*用户注册*/
    private void registe() {
        User = edUser.getText().toString();
        Phone = edPhone.getText().toString();
        Pwd = edpwd.getText().toString();
        PassWord = edpassword.getText().toString();
        PhoneCode = edPhoneCode.getText().toString();

        HashMap<String, String> map = new HashMap<String, String>();
        if (User.length()== 0){
            showError("用户名不能为空");
            return;
        }
        if (Phone.length()== 0){
            showError(R.string.findpwd_phone);
            return;
        }
        if(PhoneCode.length()==0){
            showError(R.string.input_auth_code);
            return;
        }
        if(Pwd.length()==0){
            showError(R.string.input_login_psw);
            return;
        }
        if(PassWord.length()==0){
            showError(R.string.input_login_psw);
            return;
        }
        if(!CheckUtil.isPassword(Pwd)){
            showError("密码长度6-16，至少包含数字、字母、符号组合任意两种");
            return;
        }
        if(!CheckUtil.isPassword(PassWord)){
            showError("密码长度6-16，至少包含数字、字母、符号组合任意两种");
            return;
        }
        if(!CheckUtil.isPhoneNum(Phone)){
            showError(R.string.input_right_phone);
            return;
        }
        if(! Pwd.equals(PassWord)){
            showError(R.string.two_password_different);
            return;
        }
        //传递参数
        map.put("mobile", Phone);
        map.put("email", User);
        map.put("userPassword", Pwd);
        map.put("confirmPwd", PassWord);
        map.put("randomCode", PhoneCode);

        new RequestCommant().requestRegiste(new requestHandler(RegistActivity.this), this, map);

    }

    //获取验证码
    private void getPhoneVertifyCode() {
        // TODO Auto-generated method stub
        Phone=edPhone.getText().toString();
        HashMap<String, String> map = new HashMap<String, String>();
        if (Phone.length()== 0){
            showError(R.string.findpwd_phone);
            return;
        }
        if(!CheckUtil.isPhoneNum(Phone)){
            showError(R.string.input_right_phone);
            return;
        }
        map.put("phone", Phone);
        new RequestCommant().requestGetPhoneCode(new requestHandler(RegistActivity.this), this, map);
    }
    private class requestHandler extends BaseHandler {

        public requestHandler(Activity activity) {
            super(activity);
            // TODO Auto-generated constructor stub
        }

        @Override
        public void handleMessage(Message msg) {
            // TODO Auto-generated method stub
            super.handleMessage(msg);
            if (msg.what == Constants.GET_PHONE_VERRIFYCODE){
                if(command.success){
                    showError("验证码发送成功");
                }else{
                    showError("失败");
                }
            }
            if (msg.what == Constants.REGISTER){
                if(command.success){
                    showError("成功");
                }else{
                    showError("失败");
                }
            }
        }
    }

}
