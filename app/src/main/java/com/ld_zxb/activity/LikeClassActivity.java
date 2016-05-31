package com.ld_zxb.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.ld_zxb.R;
import com.ld_zxb.utils.ClickUtil;
import com.ld_zxb.view.CircleImageView;
import com.ld_zxb.view.LikeClassPopupWindow;

public class LikeClassActivity extends BaseFragmentActivity {
    CircleImageView circleImageView;
    ImageView likeclass_right_bar,likeclass_Left_back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_likeclass);
        initView();
    }

    private void initView() {
        likeclass_right_bar = (ImageView) findViewById(R.id.likeclass_right_bar);
        likeclass_Left_back = (ImageView) findViewById(R.id.likeclass_Left_back);
        ClickUtil.setClickListener(listener,likeclass_right_bar,likeclass_Left_back);
    }

    /**
     * 监听事件
     */
    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.likeclass_right_bar:
                    LikeClassPopupWindow likeClassPopupWindow = new LikeClassPopupWindow(LikeClassActivity.this);
                    likeClassPopupWindow.showAtDropDownLeft(likeclass_right_bar);
                    break;
                case R.id.likeclass_Left_back:
                    LikeClassActivity.this.finish();
                    break;
                default:
                    break;
            }
        }
    };
}
