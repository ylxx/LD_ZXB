package com.ld_zxb.activity.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.ld_zxb.R;
import com.ld_zxb.activity.BaseFragmentActivity;
import com.ld_zxb.activity.MainActivity;
import com.ld_zxb.activity.RegistActivity;
import com.ld_zxb.application.DCApplication;
import com.ld_zxb.config.Constants;
import com.ld_zxb.controller.BaseHandler;
import com.ld_zxb.controller.RequestCommant;
import com.ld_zxb.utils.CheckUtil;
import com.ld_zxb.utils.ClickUtil;
import com.ld_zxb.utils.SPUtils;
import com.ld_zxb.utils.SerialUtils;
import com.ld_zxb.utils.UserID;
import com.ld_zxb.vo.UserLoginBodyVo;

import java.io.IOException;
import java.util.HashMap;

public class LoginActivity extends BaseFragmentActivity {

    private DCApplication application;
    private SerialUtils serialutols;
    private Button btLogin,btRegist;
    private EditText etUserN,etPassW;
    private int userId;
    /**
     * 用户名&密码
     */
    private String userName,password;
    private Intent intent;
    UserID userID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        serialutols = new SerialUtils();
//        if(serialutols.getObject(this)==null){
//            Toast.makeText(this, "请先登录再查看视频列表！", Toast.LENGTH_LONG).show();
//            startActivity(new Intent(this,LoginActivity.class));
//        }else{
//            try {
//                UserLoginBodyVo userinfo = serialutols.deSerialization(serialutols.getObject(this));
//                //用户Id(非268)
//                userId=userinfo.getBody().getId();
//
//            } catch (Exception e) {
//                // TODO Auto-generated catch block
//                e.printStackTrace();
//            }
//        }


        setContentViewWithActionBar(R.layout.activity_login,"课程","登录");
        userID = UserID.getInstance();
        userID.setUserName("");
        initview();
    }

    private void initview() {
        application = (DCApplication) getApplication();
        btLogin = (Button) findViewById(R.id.bt_login);
        btRegist = (Button) findViewById(R.id.bt_to_regist);
        etUserN = (EditText) findViewById(R.id.et_user_name);
        etPassW = (EditText) findViewById(R.id.et_passw);
        ClickUtil.setClickListener(listener, btLogin,btRegist);
    }

    /**
     * 监听事件
     */
    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.bt_login:
//                    startActivity(new Intent(LoginActivity.this,PullToZoomScrollActivity.class));
                    confirm();
                    break;
                case R.id.bt_to_regist:
                    startActivity(new Intent(LoginActivity.this,RegistActivity.class));
                    break;
                default:
                    break;
            }
        }
    };


    //提交登录
    private void confirm() {
        // TODO Auto-generated method stub
        userName = etUserN.getText().toString().trim();
        password = etPassW.getText().toString().trim();
        if (userName.length() == 0) {
            showError("请输入手机号或邮箱");
            return;
        }
        if (!(CheckUtil.isPhoneNum(userName)||CheckUtil.isEmail(userName))) {
            showError("请检查手机号码或邮箱格式是否正确");
            return;
        }
        if (password.length() == 0) {
            showError("请输入密码");
            return;
        }
        HashMap<String, String> hashmap = new HashMap<String, String>();

        //密码加密
        /*String psw = Base64Utils.encode(userpsdET.getText().toString()
        				.getBytes());*/
        hashmap.put("account", etUserN.getText().toString());
        hashmap.put("userPassword", etPassW.getText().toString());

        new RequestCommant().requestlogin(new requetHandle(this), this, hashmap);

    }

    private class requetHandle extends BaseHandler {
        public requetHandle(Activity activity) {
            super(activity);
            // TODO Auto-generated constructor stub
        }

        @Override
        public void handleMessage(Message msg) {
            // TODO Auto-generated method stub
            super.handleMessage(msg);
            //			LoginActivity activity = (LoginActivity) mActivity.get();
            if (msg.what == Constants.LOGIN) {
                System.out.println(command.success);
                if (command.success) {
                    UserLoginBodyVo person = (UserLoginBodyVo) command.resData;
                    person.getBody().setMobile(etUserN.getText().toString());
                    /**
                     * 将用户登录信息存入application中
                     */
                    SPUtils.put(getApplication(), "login", true);
                    application.setUserloginbodyvo(person);
                    application.setLogin(true);//将判断是否是登录状态的字符串存在application中
                    //若登录成功，则把信息存数到反序列对象中
                    try {
                        serialutols.saveObject(serialutols.serialize(person), LoginActivity.this);
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    //将用户登录信息存起来，完成完整的登录
                    intent = new Intent(LoginActivity.this, MainActivity.class);
                    intent.putExtra("person", person);
                    startActivity(intent);
                    finish();

                } else {
                    showError((String) command.message);
                }
            }
        }

    }
}
