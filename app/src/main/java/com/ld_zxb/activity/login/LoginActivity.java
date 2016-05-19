package com.ld_zxb.activity.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.ld_zxb.R;
import com.ld_zxb.activity.RegistActivity;
import com.ld_zxb.activity.scrollview.PullToZoomScrollActivity;
import com.ld_zxb.utils.ClickUtil;

public class LoginActivity extends AppCompatActivity {
    Button but_login,but_Regst;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        but_login = (Button) findViewById(R.id.bt_login);
        but_Regst = (Button) findViewById(R.id.bt_Regst);
        ClickUtil.setClickListener(listener, but_login,but_Regst);
    }
    /**
     * 监听事件
     */
    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.bt_login:
                    startActivity(new Intent(LoginActivity.this,PullToZoomScrollActivity.class));
                    break;
                case R.id.bt_Regst:
                    startActivity(new Intent(LoginActivity.this,RegistActivity.class));
                    break;
                default:
                    break;
            }
        }
    };
}
