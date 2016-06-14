package com.ld_zxb.fragment.coursedetails;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.media.MediaBrowserCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.ld_zxb.R;
import com.ld_zxb.adapter.ContentsAdapter;
import com.ld_zxb.fragment.BaseBackFragment;
import com.ld_zxb.vo.ParticularCourseEntityVo;
import com.ld_zxb.vo.ParticularCourseEntityVo.ParticularCourseBodyVo;
import com.ld_zxb.vo.ParticularCourseEntityVo.ParticularCourseBodyVo.CatalogList;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by cuiyinglai on 16/6/1.
 */
public class ContentsFragment extends Fragment {

    private View view;

    private ListView lvContents;
    private String mTitle;
    private int position;
    private static final String BUNDLE_TITLE = "title";
    private ParticularCourseBodyVo particularCourseBodyVo;
    private List<List<CatalogList>> catalogLists;
    private List<CatalogList.ChildList> childLists;
    private ContentsAdapter adapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        Bundle bundle = getArguments();
        if (bundle != null) {
            mTitle = bundle.getString(BUNDLE_TITLE);
            position=bundle.getInt("position");
        }
        view = inflater.inflate(R.layout.fragment_course_contents,null);

        initView();

        setCourseBody(childLists);


        if(childLists!=null||childLists.size()==0){
            lvContents.setAdapter(adapter);
        }else{
            Toast.makeText(getActivity(),"hahah",Toast.LENGTH_SHORT).show();
        }


        return view;
    }

    private void initView() {
        catalogLists = new ArrayList<List<CatalogList>>();
        childLists = new ArrayList<CatalogList.ChildList>();
        lvContents = (ListView) view.findViewById(R.id.lv_contents);

        adapter = new ContentsAdapter(getActivity(),childLists);

    }

    /**供activity调用,获取CourseBody**/
    public void  setCourseBody(List<CatalogList.ChildList> childLists){
        /**如果activity-fragment值为空，空操作***/
        if(childLists == null){
            return;
        }else{
            this.childLists = childLists;
        }


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
