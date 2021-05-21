package com.zh.toturial.Fragment;

import android.graphics.Color;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.zh.toturial.R;

/**
 * Create by HuangZhiHao on 2021-03-11
 */
public class ThirdpartyFragment extends BaseFragment {

    @Override
    protected View initView() {

        return LayoutInflater.from(mContext).inflate(R.layout.thirdparty_fragment,null);
    }
}
