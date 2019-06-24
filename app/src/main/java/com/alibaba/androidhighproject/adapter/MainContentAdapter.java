package com.alibaba.androidhighproject.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.alibaba.androidhighproject.R;

import java.util.List;

/**
 * *******************************************
 * 标题 :                                     *
 * 编辑 : 向绍谷                               *
 * 日期 : 2019/6/24                             *
 * 描述 :                                     *
 * *******************************************
 */
public class MainContentAdapter extends BaseAdapter {

    private List<String> mData;
    private LayoutInflater mInflater;
    private Context mContext;

    public MainContentAdapter(Context context, List<String> mData) {
        this.mContext = context;
        this.mData = mData;
        mInflater = LayoutInflater.from(mContext);

    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int i) {
        return mData.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        ViewHolder viewHolder;

        if (view ==null){
            view = mInflater.inflate(R.layout.item_main,viewGroup,false);
            viewHolder = new ViewHolder();
            viewHolder.vTvTitle = view.findViewById(R.id.tv_title);
            view.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) view.getTag();
        }

        viewHolder.vTvTitle.setText(mData.get(i));

        return view;
    }

    class  ViewHolder{

        private TextView vTvTitle;
    }
}
