package com.fta.testdatabinding.higher;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fta.testdatabinding.R;
import com.fta.testdatabinding.moudle.NameMoudle;
import com.android.databinding.library.baseAdapters.BR;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FtaListAdapter extends RecyclerView.Adapter<BindingViewHolder> {

    private static final int ITEM_VIEW_TYPE_ON = 1;
    private static final int ITEM_VIEW_TYPE_OFF = 2;

    private final LayoutInflater mLayoutInflater;

    private OnItemClickListener onItemClickListener;


    private List<NameMoudle> mNameMoudles;

    public interface OnItemClickListener {
        void onFtaClick(NameMoudle nameMoudle);
    }

    public FtaListAdapter(Context context) {
        mLayoutInflater = LayoutInflater.from(context);
        mNameMoudles = new ArrayList<>();
    }

    @Override
    public int getItemViewType(int position) {
        final NameMoudle nameMoudle = mNameMoudles.get(position);
        if (nameMoudle.mIsFired.get()) {
            return ITEM_VIEW_TYPE_OFF;
        } else {
            return ITEM_VIEW_TYPE_ON;
        }
    }

    @NonNull
    @Override
    public BindingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ViewDataBinding binding;
        if (viewType == ITEM_VIEW_TYPE_ON) {
            binding = DataBindingUtil.inflate(mLayoutInflater, R.layout.item_normal, parent, false);
        } else {
            binding = DataBindingUtil.inflate(mLayoutInflater, R.layout.item_off, parent, false);
        }

        return new BindingViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull BindingViewHolder holder, int position) {
        final NameMoudle nameMoudle = mNameMoudles.get(position);
        holder.getBinding().setVariable(BR.item, nameMoudle);
        holder.getBinding().executePendingBindings();
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemClickListener != null) {
                    onItemClickListener.onFtaClick(nameMoudle);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mNameMoudles.size();
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public void addAll(List<NameMoudle> nameMoudles) {
        mNameMoudles.addAll(nameMoudles);
    }

    Random mRandom = new Random(System.currentTimeMillis());

    public void add(NameMoudle nameMoudle) {
        int position = mRandom.nextInt(mNameMoudles.size() + 1);
        mNameMoudles.add(position, nameMoudle);
        notifyItemInserted(position);
    }

    public void remove() {
        if (mNameMoudles.size() == 0) {
            return;
        }
        int position = mRandom.nextInt(mNameMoudles.size());
        mNameMoudles.remove(position);
        notifyItemRemoved(position);
    }
}
