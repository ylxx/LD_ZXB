package com.ld_zxb.activity.secondary;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Message;
import android.support.v7.app.ActionBar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.ld_zxb.R;
import com.ld_zxb.activity.BaseFragmentActivity;
import com.ld_zxb.config.Constants;
import com.ld_zxb.controller.BaseHandler;
import com.ld_zxb.controller.RequestCommant;
import com.ld_zxb.entity.SearchEntity;
import com.ld_zxb.utils.ClickUtil;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

public class SearchActivity extends BaseFragmentActivity {
    private TextView tv_search,tv_ifm,tv_zhiyedaode,tv_caiwuguanli,tv_gaojicaiwu,tv_yusuan,tv_qiye,tv_nashui,tv_jinrong,tv_gongsi,tv_fengxian,tv_caiwufenxi;
    private EditText et_context;
    ListView lv_search;
    private String ifm,zhiyedaode,caiwuguanli,gaojicaiwu,yusuan,qiye,nashui,jinrong,gongsi,fengxian,caiwufenxi;
    List<SearchEntity.EntityBean.CourseListBean> cours;
    private DisplayImageOptions options = new DisplayImageOptions.Builder()
            .cacheInMemory(true).cacheOnDisk(true)
            .showImageForEmptyUri(R.drawable.default_picture)
            .showImageOnFail(R.drawable.default_picture)
            .showImageOnLoading(R.drawable.default_picture).build();

    private class requetHandle extends BaseHandler {
        public requetHandle(Activity activity) {
            super(activity);
            // TODO Auto-generated constructor stub
        }
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == Constants.SEARCH){
                if(command.success){
                    SearchEntity s = (SearchEntity) command.resData;
                    cours = s.getEntity().getCourseList();
                    mApdater adapter = new mApdater(SearchActivity.this,cours);
                    lv_search.setAdapter(adapter);
                    Toast.makeText(SearchActivity.this, ""+ s.getEntity().toString(), Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent();
                    intent.setClass(SearchActivity.this, SearchContent.class);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("searchEntity", (Serializable) cours);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
            }
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentViewWithActionBar(R.layout.activity_search,"课程","搜索");
        setupActionBar();
        initView();
//        lv_search = (ListView) findViewById(R.id.search_Listview);

    }

    private void initView() {
        tv_search = (TextView) findViewById(R.id.tv_search);
        et_context = (EditText) findViewById(R.id.et_context);
        tv_ifm = (TextView) findViewById(R.id.tv_ifm);
        tv_zhiyedaode = (TextView) findViewById(R.id.tv_zhiyedaode);
        tv_caiwuguanli = (TextView) findViewById(R.id.tv_lilun);
        tv_gaojicaiwu = (TextView) findViewById(R.id.tv_gjcwgl);
        tv_yusuan = (TextView) findViewById(R.id.tv_yusuan);
        tv_qiye = (TextView) findViewById(R.id.tv_qiye);
        tv_nashui = (TextView) findViewById(R.id.tv_nashui);
        tv_jinrong = (TextView) findViewById(R.id.tv_jinrong);
        tv_gongsi = (TextView) findViewById(R.id.tv_gongsi);
        tv_fengxian = (TextView) findViewById(R.id.tv_fengxian);
        tv_caiwufenxi = (TextView) findViewById(R.id.tv_caiwufenxi);

        ClickUtil.setClickListener(listener,tv_search,et_context,tv_ifm,tv_zhiyedaode,tv_caiwuguanli,tv_gaojicaiwu,tv_yusuan,tv_qiye,tv_nashui,tv_jinrong,tv_gongsi,tv_fengxian,tv_caiwufenxi);
        et_context.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                //这个应该是在改变的时候会做的动作吧，具体还没用到过。
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //这是文本框改变之前会执行的动作
//                String data = et_context.getText().toString().trim();
//                HashMap<String, String> hashmap = new HashMap<String, String>();
//                hashmap.put("currentPage", "1");
//                hashmap.put("courseName", ""+data);//搜索内容
//                new RequestCommant().requestSearch(new requetHandle(SearchActivity.this),SearchActivity.this, hashmap);
            }

            @Override
            public void afterTextChanged(Editable s) {
                /**这是文本框改变之后 会执行的动作
                 * 因为我们要做的就是，在文本框改变的同时，我们的listview的数据也进行相应的变动，并且如一的显示在界面上。
                 * 所以这里我们就需要加上数据的修改的动作了。
                 */
            }
        });
    }

    private void initdata(String s) {
        HashMap<String, String> hashmap = new HashMap<String, String>();
        String ct  =  et_context.getText().toString().trim();
        hashmap.put("currentPage", "1");
        hashmap.put("courseName", ""+s);//搜索内容
        new RequestCommant().requestSearch(new requetHandle(SearchActivity.this),SearchActivity.this, hashmap);
    }

    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.tv_search:
                        Toast.makeText(SearchActivity.this, "开始搜索", Toast.LENGTH_SHORT).show();
                        String content = et_context.getText().toString().trim();
                        Intent in = new Intent(SearchActivity.this,SearchContent.class);
                        in.putExtra("Content",""+content);
                        startActivity(in);
                    break;
                case R.id.tv_ifm:
                        ifm = "IFM";
                        et_context.setText(ifm);
//                        Intent in_ifm = new Intent(SearchActivity.this,SearchContent.class);
//                        in_ifm.putExtra("Search_ifm",""+ifm);
//                        startActivity(in_ifm);
                    break;
                case R.id.tv_zhiyedaode:
                        zhiyedaode ="职业道德";
                    et_context.setText(zhiyedaode);
//                        Intent in_daode = new Intent(SearchActivity.this,SearchContent.class);
//                        in_daode.putExtra("Search_daode",""+zhiyedaode);
//                        startActivity(in_daode);
                    break;
                case R.id.tv_lilun:
                        caiwuguanli = "财务管理理论";
                    et_context.setText(caiwuguanli);
//                        Intent in_caiwulilun = new Intent(SearchActivity.this,SearchContent.class);
//                        in_caiwulilun.putExtra("Search_caiwulilun",""+caiwuguanli);
//                        startActivity(in_caiwulilun);
                    break;
                case R.id.tv_gjcwgl:
                        gaojicaiwu = "高级财务管理";
                    et_context.setText(caiwuguanli);
//                        Intent in_gcgl = new Intent(SearchActivity.this,SearchContent.class);
//                        in_gcgl.putExtra("Search_gcgl",""+gaojicaiwu);
//                        startActivity(in_gcgl);
                    break;
                case R.id.tv_yusuan:
                        yusuan = "预算管理";
                    et_context.setText(yusuan);
//                        Intent in_yusuan = new Intent(SearchActivity.this,SearchContent.class);
//                        in_yusuan.putExtra("Search_yusuan",""+yusuan);
//                        startActivity(in_yusuan);
                    break;
                case R.id.tv_qiye:
                        qiye = "企业并购与重组";
                    et_context.setText(qiye);
//                        Intent in_qiye = new Intent(SearchActivity.this,SearchContent.class);
//                        in_qiye.putExtra("Search_qiye",""+qiye);
//                        startActivity(in_qiye);
                    break;
                case R.id.tv_nashui:
                        nashui = "纳税管理";
                    et_context.setText(nashui);
//                        Intent in_nashui = new Intent(SearchActivity.this,SearchContent.class);
//                        in_nashui.putExtra("Search_nashui",""+nashui);
//                        startActivity(in_nashui);
                    break;
                case R.id.tv_gongsi:
                        gongsi = "公司战略";
                    et_context.setText(gongsi);
//                        Intent in_gongsi = new Intent(SearchActivity.this,SearchContent.class);
//                        in_gongsi.putExtra("Search_gongsi",""+gongsi);
//                        startActivity(in_gongsi);
                    break;
                case R.id.tv_jinrong:
                        jinrong = "金融工具";
                    et_context.setText(jinrong);
//                        Intent in_jinrong = new Intent(SearchActivity.this,SearchContent.class);
//                        in_jinrong.putExtra("Search_jinrong",""+jinrong);
//                        startActivity(in_jinrong);
                    break;
                case R.id.tv_fengxian:
                        fengxian = "风险管理";
                    et_context.setText(fengxian);
//                        Intent in_fengxian = new Intent(SearchActivity.this,SearchContent.class);
//                        in_fengxian.putExtra("Search_fengxian",""+fengxian);
//                        startActivity(in_fengxian);
                    break;
                case R.id.tv_caiwufenxi:
                        caiwufenxi = "财务分析";
                    et_context.setText(caiwufenxi);
//                        Intent in_caiwufenxi = new Intent(SearchActivity.this,SearchContent.class);
//                        in_caiwufenxi.putExtra("Search_caiwufenxi",""+caiwufenxi);
//                        startActivity(in_caiwufenxi);
                    break;
            }
        }
    };

    class mApdater extends BaseAdapter {
        List<SearchEntity.EntityBean.CourseListBean> entity;
        private LayoutInflater mInflater = null;
        private mApdater(Context context, List<SearchEntity.EntityBean.CourseListBean> entity){
            this.mInflater = LayoutInflater.from(context);
            this.entity = entity;
        }
        @Override
        public int getCount() {
            return entity.size();
        }

        @Override
        public Object getItem(int position) {
            return entity.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
        @Override
        public View getView(int position, View view, ViewGroup parent) {
            ViewHolder viewHolder = null;
            if(view ==null){
                viewHolder = new ViewHolder();
                view = mInflater.inflate(R.layout.informationitem,null);
                viewHolder.search_icon = (ImageView) view.findViewById(R.id.img_icon);
                viewHolder.search_title = (TextView) view.findViewById(R.id.tv_title);
                viewHolder.search_time = (TextView) view.findViewById(R.id.tv_time);
                view.setTag(viewHolder);
            }else{
                viewHolder = (ViewHolder) view.getTag();

            }
            ImageLoader.getInstance().displayImage("http://static.langdunzx.com/"+entity.get(position).getLogo(),viewHolder.search_icon,options);
            viewHolder.search_title.setText(entity.get(position).getTitle());
            viewHolder.search_time.setText(entity.get(position).getTeacherList().get(position));
            return view;
        }
    }
    class ViewHolder {
        ImageView search_icon;
        TextView search_title;
        TextView search_time;
    }
    /**
     * Set up the {@link android.app.ActionBar}, if the API is available.
     */
    private void setupActionBar() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            // Show the Up button in the action bar.
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }
}
