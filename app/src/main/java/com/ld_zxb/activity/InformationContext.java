package com.ld_zxb.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.ld_zxb.R;

public class InformationContext extends AppCompatActivity {
    String ID,Title,mContext,inforAuthor,inforTimer,inforSource;
    TextView tv_Title,tv_Context,tv_date,tv_Source;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information_context);
        initData();
        initView();
    }
    /**初始化view*/
    private void initView()  {

            tv_Title = (TextView) findViewById(R.id.infor_title);
            tv_Context = (TextView) findViewById(R.id.infor_context);
            tv_date = (TextView) findViewById(R.id.infor_timer);
            tv_Source = (TextView) findViewById(R.id.infor_source);
            tv_Title.setText(Title);
            tv_Source.setText(inforSource);
            tv_date.setText(inforTimer);
//            String data = mContext.replace("\r\n","");
//            String datas = Base64Decoder.decode(data);
//            String s = URLDecoder.decode(data,"utf-8");
//            LogUtil.e("info","datas"+datas);
//            Toast.makeText(InformationContext.this, "指定编码"+ mContext, Toast.LENGTH_SHORT).show();
            tv_Context.setText(mContext);

    }

    /**获取Intent中的数据*/
    private void initData() {
        Intent in = getIntent();
        ID = in.getStringExtra("InforID");
        Title = in.getStringExtra("InforTitle");
        mContext = in.getStringExtra("InforContext");
        inforAuthor= in.getStringExtra("InforAuthor");
        inforSource = in.getStringExtra("InforSource");
        inforTimer = in.getStringExtra("inforTimer");
    }
}
