package com.cdx.example.scroller;

import android.view.View;

import com.cdx.example.scroller.activity.Test1Activity;

import java.util.ArrayList;

import apis.amapv2.com.listviewlibrary.activity.BaseListActivty;
import apis.amapv2.com.listviewlibrary.bean.ItemObject;

public class MainActivity extends BaseListActivty {

    @Override
    protected void initData() {
        //设置标题
        mTvTitle.setText("Scroller的相关例子");
        mTvTitle.setVisibility(View.VISIBLE);

        //设置列表及跳转的项
        ArrayList<ItemObject> data = new ArrayList<>();
        data.add(new ItemObject("Scroller实现弹性滑动",Test1Activity.class));
        mMyListView.setData(data);
    }
}
