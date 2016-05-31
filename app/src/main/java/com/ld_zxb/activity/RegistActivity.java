package com.ld_zxb.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.ld_zxb.R;

public class RegistActivity extends BaseFragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentViewWithActionBar(R.layout.activity_regst,"登录","注册");
    }
}
