package com.ld_zxb.fragment.homepage;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.ld_zxb.R;
import com.ld_zxb.activity.login.LoginActivity;
import com.ld_zxb.fragment.BaseBackFragment;
import com.ld_zxb.utils.ClickUtil;

public class MineFragment extends BaseBackFragment {
    private Context mContext;
    Button but_login;
    private ImageView ivSearch,ivToLogin;
    TextView tv_text;
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_me,null);
        but_login = (Button) view.findViewById(R.id.but_login);
        ivSearch = (ImageView) getActivity().findViewById(R.id.main_left_bar);
        ivToLogin = (ImageView) getActivity().findViewById(R.id.main_right_bar);
        tv_text = (TextView) getActivity().findViewById(R.id.main_title_bar);
        ivToLogin.setVisibility(View.INVISIBLE);
        ivSearch.setVisibility(View.INVISIBLE);
        tv_text.setText("我的");
        ClickUtil.setClickListener(listener, but_login);
        return view;
    }
    /**
     * 监听事件
     */
    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.but_login:
                    startActivity(new Intent(getActivity(),LoginActivity.class));
                    break;
                default:
                    break;
            }
        }
    };
}
