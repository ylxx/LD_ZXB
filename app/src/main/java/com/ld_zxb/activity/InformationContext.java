package com.ld_zxb.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.ld_zxb.R;

public class InformationContext extends AppCompatActivity {
    String ID,Title,mContext;
    TextView inforTitle,inforContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information_context);
        initData();
        initView();
    }
    /**初始化view*/
    private void initView() {
        inforTitle = (TextView) findViewById(R.id.infor_title);
        inforContext = (TextView) findViewById(R.id.infor_context);
        inforTitle.setText(Title);
        inforContext.setText(mContext);
    }

    /**获取Intent中的数据*/
    private void initData() {
        Intent in = getIntent();
        ID = in.getStringExtra("InforID");
        Title = in.getStringExtra("InforTitle");
        mContext = in.getStringExtra("InforContext");
    }
}
