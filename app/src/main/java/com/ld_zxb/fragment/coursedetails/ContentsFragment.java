package com.ld_zxb.fragment.coursedetails;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.media.MediaBrowserCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ld_zxb.R;
import com.ld_zxb.fragment.BaseBackFragment;

/**
 * Created by cuiyinglai on 16/6/1.
 */
public class ContentsFragment extends Fragment {

    private View view;

    private String mTitle;
    private int position;
    private static final String BUNDLE_TITLE = "title";
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        Bundle bundle = getArguments();
        if (bundle != null) {
            mTitle = bundle.getString(BUNDLE_TITLE);
            position=bundle.getInt("position");
        }
        view = inflater.inflate(R.layout.fragment_course_contents,null);
        return view;
    }


    /*public static ContentsFragment newInstance(String title){
        Bundle bundle = new Bundle();
        bundle.putString(BUNDLE_TITLE, title);

        ContentsFragment fragment = new ContentsFragment();
        fragment.setArguments(bundle);

        return fragment;

    }*/

    public static ContentsFragment newInstance(String title,int position) {
        Bundle bundle = new Bundle();
        bundle.putString(BUNDLE_TITLE, title);
        bundle.putInt("position", position);
        ContentsFragment fragment = new ContentsFragment();
        fragment.setArguments(bundle);
        return fragment;

    }
}
