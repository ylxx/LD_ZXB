package com.ld_zxb.fragment.coursedetails;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ld_zxb.R;

/**
 * Created by cuiyinglai on 16/6/1.
 */
public class CommentFragment extends Fragment {

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

        view = inflater.inflate(R.layout.fragment_course_comment,null);
        return view;
    }

    /*public static CommentFragment newInstance(String title){
        Bundle bundle = new Bundle();
        bundle.putString(BUNDLE_TITLE, title);

        CommentFragment fragment = new CommentFragment();
        fragment.setArguments(bundle);

        return fragment;

    }*/

    public static CommentFragment newInstance(String title,int position) {
        Bundle bundle = new Bundle();
        bundle.putString(BUNDLE_TITLE, title);
        bundle.putInt("position", position);
        CommentFragment fragment = new CommentFragment();
        fragment.setArguments(bundle);
        return fragment;

    }
}
