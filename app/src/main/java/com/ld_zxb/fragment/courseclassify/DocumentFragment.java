package com.ld_zxb.fragment.courseclassify;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ld_zxb.R;

/**
 * Created by cuiyinglai on 16/6/8.
 */
public class DocumentFragment extends Fragment{

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

        view = inflater.inflate(R.layout.fragment_course_document,null);
        return view;
    }

    public static DocumentFragment newInstance(String title,int position){

        Bundle bundle = new Bundle();
        bundle.putString(BUNDLE_TITLE, title);
        bundle.putInt("position", position);
        DocumentFragment fragment = new DocumentFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

}
