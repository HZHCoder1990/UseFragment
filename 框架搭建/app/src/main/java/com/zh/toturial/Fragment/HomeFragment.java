package com.zh.toturial.Fragment;

import android.graphics.Color;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.zh.toturial.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Create by HuangZhiHao on 2021-03-11
 */
public class HomeFragment extends BaseFragment {

    private ListView mListView;
    private List<String> data = new ArrayList<>();


    @Override
    protected View initView() {

        Log.d("Huang","HomeFragment被初始化了");
        // 默认填充帧布局 FrameLayout
        View view = LayoutInflater.from(mContext).inflate(R.layout.home_list,null);
        mListView = view.findViewById(R.id.home_list);
        return view;
    }

    @Override
    protected void initData() {

       // data.clear();

       // String[] strs = {"1","2","3"}; 这样定义数组也可以

        for (int i = 0;i < 5;i ++){
            data.add("今日头条");
            data.add("小红书");
            data.add("微博");
        }

        ArrayAdapter adapter = new ArrayAdapter(mContext, android.R.layout.simple_list_item_1,data);
        mListView.setAdapter(adapter);

    }
}
