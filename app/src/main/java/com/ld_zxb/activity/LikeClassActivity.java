package com.ld_zxb.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.ld_zxb.R;
import com.ld_zxb.utils.ClickUtil;
import com.ld_zxb.view.CircleImageView;

public class LikeClassActivity extends AppCompatActivity {
    CircleImageView circleImageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_likeclass);

        ClickUtil.setClickListener(listener);
    }
    /**
     * 监听事件
     */
    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {

                default:
                    break;
            }
        }
    };
}
