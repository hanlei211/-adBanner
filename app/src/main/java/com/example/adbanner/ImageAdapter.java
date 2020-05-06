package com.example.adbanner;

import android.media.Image;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.adbanner.bean.DataBean;
import com.example.adbanner.viewholder.ImageHolder;
import com.hl.banner.adapter.BaseBannerAdapter;

import java.util.List;

public class ImageAdapter extends BaseBannerAdapter<DataBean, ImageHolder> {

    public ImageAdapter(List<DataBean> mDatas) {
        //设置数据，也可以调用banner提供的方法,或者自己在adapter中实现
        super(mDatas);
    }

    //更新数据
    public void updateData(List<DataBean> data) {
        //这里的代码自己发挥，比如如下的写法等等
        mLists.clear();
        mLists.addAll(data);
        notifyDataSetChanged();
    }

    @Override
    public ImageHolder onCreateHolder(ViewGroup parent, int viewType) {
        ImageView imageView = new ImageView(parent.getContext());
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT);
        imageView.setLayoutParams(params);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return new ImageHolder(imageView);
    }

    @Override
    public void onBindView(ImageHolder holder, DataBean data, int position, int size) {
          holder.imageView.setImageResource(data.imageRes);
    }
}
