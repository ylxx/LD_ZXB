package com.ld_zxb.activity.secondary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ld_zxb.R;
import com.ld_zxb.activity.BaseFragmentActivity;

public class WebEmbedActivity extends BaseFragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentViewWithActionBar(R.layout.activity_web_embed,"课程","web");
    }
}
