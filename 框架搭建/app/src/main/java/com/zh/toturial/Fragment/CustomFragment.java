package com.zh.toturial.Fragment;

import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

/**
 * Create by HuangZhiHao on 2021-03-11
 */
public class CustomFragment extends BaseFragment {
    private TextView mTextView;
    @Override
    protected View initView() {

        mTextView = new TextView(mContext);
        mTextView.setText("自定义");
        mTextView.setTextSize(20);
        mTextView.setGravity(Gravity.CENTER);
        mTextView.setTextColor(Color.RED);
        return mTextView;
    }
}
