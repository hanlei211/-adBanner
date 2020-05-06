package com.hl.banner.adapter;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hl.banner.listener.OnBannerListener;
import com.hl.banner.util.BannerUtils;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseBannerAdapter <T,VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> implements IViewHolder<T,VH> {
    protected List<T> mLists = new ArrayList<>();
    private VH mViewHolder;
    OnBannerListener listener;
    private int increaseCount = 2;

    public BaseBannerAdapter(List<T> datas) {
        setDatas(datas);
    }

    public void setDatas(List<T> datas) {
        if (datas == null) {
            datas = new ArrayList<>();
        }
        mLists = datas;
    }

    public T getData(int position) {
        return mLists.get(position);
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return onCreateHolder(parent,viewType);
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, final int position) {
        mViewHolder = holder;
        final int real = getRealPosition(position);
        onBindView(holder, mLists.get(real), real, getRealCount());
        if (listener != null)
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onBannerClick(mLists.get(real), real);
                }
            });
    }

    public int getRealPosition(int position) {
        return BannerUtils.getRealPosition(increaseCount == 2, position, getRealCount());
    }

    @Override
    public int getItemCount() {
        return getRealCount() > 1 ? getRealCount() + increaseCount : getRealCount();
    }

    public int getRealCount() {
        return mLists == null ? 0 : mLists.size();
    }

    public void setOnBannerListener(OnBannerListener listener) {
        this.listener = listener;
    }

    public VH getViewHolder() {
        return mViewHolder;
    }

    public void setIncreaseCount(int increaseCount) {
        this.increaseCount = increaseCount;
    }

}
