package com.alibaba.androidhighproject.recyclerrefresh;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.recyclerview.extensions.AsyncListDiffer;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.alibaba.androidhighproject.R;

import java.util.List;

/**
 * *******************************************
 * 标题 :                                     *
 * 编辑 : 向绍谷                               *
 * 日期 : 2019/10/11                             *
 * 描述 :                                     *
 * *******************************************
 */
public class DiffUserRecyclerAdapter extends RecyclerView.Adapter<DiffUserRecyclerAdapter.UserViewHolder> {

    private AsyncListDiffer<UserTestBean> mDiffer;

    public DiffUserRecyclerAdapter() {
        MyDiffItemCallback myDiffItemCallback = new MyDiffItemCallback();
        mDiffer = new AsyncListDiffer<>(this, myDiffItemCallback);
    }


    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_diff_recycler, viewGroup, false);
        return new UserViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder userViewHolder, int i) {
        userViewHolder.setData(getItem(i));
    }

    /**
     * 局部刷新数据
     */
    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position, @NonNull List<Object> payloads) {
//        super.onBindViewHolder(holder, position, payloads);
        if (payloads.isEmpty()){
            onBindViewHolder(holder,position);
        }else{
            Bundle bundle = (Bundle) payloads.get(0);
            String subName = bundle.getString("subName");
            String userName = bundle.getString("userName");
            int age = bundle.getInt("age");
            holder.tvName.setText(userName);
            holder.tvSubName.setText(subName);
            holder.tvAge.setText(String.valueOf(age));


        }
    }

    public UserTestBean getItem(int position) {
        return mDiffer.getCurrentList().get(position);
    }

    public void submitList(List<UserTestBean> data) {
        mDiffer.submitList(data);
    }


    @Override
    public int getItemCount() {
        return  mDiffer.getCurrentList().size();
    }

    class UserViewHolder extends RecyclerView.ViewHolder {

        private TextView tvName;
        private TextView tvSubName;
        private TextView tvAge;


        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_name);
            tvSubName = itemView.findViewById(R.id.tv_sub_name);
            tvAge = itemView.findViewById(R.id.tv_age);
        }

        public void setData(UserTestBean data) {
            tvName.setText(data.getUserName());
            tvSubName.setText(data.getSubName());
            tvAge.setText(String.valueOf(data.getAge()));
        }

    }
}
