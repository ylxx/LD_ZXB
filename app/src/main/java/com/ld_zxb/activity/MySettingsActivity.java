

package com.ld_zxb.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.ld_zxb.R;
import com.ld_zxb.utils.ClickUtil;
import com.ld_zxb.view.CircleImageView;

public class MySettingsActivity extends AppCompatActivity {
    CircleImageView circleImageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_me_stings);
        circleImageView = (CircleImageView) findViewById(R.id.Myphoto);
        ClickUtil.setClickListener(listener,circleImageView);
    }
    /**
     * 监听事件
     */
    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.Myphoto:
//                    ImageViewPopu imageViewPopu = new ImageViewPopu(MySettingsActivity.this);
//                    imageViewPopu.ImageViewPopuShow();
//                    imageViewPopu.showAtLocation(View.inflate(MySettingsActivity.this,
//                            R.layout.activity_me_stings, null), Gravity.BOTTOM
//                            | Gravity.CENTER_HORIZONTAL, 0, 0);
                    break;
                default:
                    break;
            }
        }
    };
}
