package com.zh.toturial.Activity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.widget.RadioGroup;

import com.zh.toturial.Fragment.BaseFragment;
import com.zh.toturial.Fragment.CustomFragment;
import com.zh.toturial.Fragment.HomeFragment;
import com.zh.toturial.Fragment.OtherFragment;
import com.zh.toturial.Fragment.ThirdpartyFragment;
import com.zh.toturial.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity {

    private RadioGroup mRadioGroup;
    private List<BaseFragment> mFragments;
    private int position;
    private Fragment lastFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        // 初始化Fragment
        initFragment();

        // 设置监听
        setListener();

        //设置默认选中 一定要放在设置监听的下面 先设置监听 check才去回调选中的操作
        mRadioGroup.check(R.id.rb_home);
    }

    private void setListener() {

        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
              switch (checkedId){
                  case R.id.rb_home:
                      position = 0;
                      break;
                  case R.id.rb_thirdparty:
                      position = 1;
                      break;
                  case R.id.rb_custom:
                      position = 2;
                      break;
                  case R.id.rb_other:
                      position = 3;
                      break;
                 default:
                     position = 0;
                     break;
              }
                Log.d("Huang",""+position);
              BaseFragment to = mFragments.get(position);
              switchFragment(lastFragment,to);
               // switchFragment(to);
            }
        });
    }

    /**
     * 切换fragment
     * @param from 上一次的fragment
     * @param to 将要被选中的fragment
     * @param position 位置
     */
    private void switchFragment(Fragment from,Fragment to){

        if (from != to){ // 防止重复点击
            lastFragment = to; // 保存上次选中的fragment
            FragmentTransaction fm = getSupportFragmentManager().beginTransaction();
            // 判断是否添加过了
            if (!to.isAdded()){
                // 隐藏from
                if (from != null){
                    fm.hide(from);
                }
                //添加to
                if (to != null){
                    fm.add(R.id.fl_main,to).commit();
                }
            }else{
                // 隐藏from
                if (from != null){
                    fm.hide(from);
                }
                //添加to
                if (to != null) {
                    fm.show(to).commit();
                }
            }
        }
    }


    /**
     * 如果使用replace fragment会被多次加载
     * @param fragment
     */
//    private void switchFragment(BaseFragment fragment) {
//        // 1. 得到manager
//        FragmentManager manager = getSupportFragmentManager();
//        // 2.开启事务
//        FragmentTransaction transaction = manager.beginTransaction();
//        // 3.替换(使用后面的替换帧布局)
//        transaction.replace(R.id.fl_main,fragment);
//        // 4.提交事务
//        transaction.commit();
//    }


    private void initFragment() {

        // 把4个fragment放入数组中保存
        mFragments = new ArrayList<>();
        mFragments.add(new HomeFragment());
        mFragments.add(new ThirdpartyFragment());
        mFragments.add(new CustomFragment());
        mFragments.add(new OtherFragment());
    }

    private void initView() {

        mRadioGroup = findViewById(R.id.rg_main);
    }
}
