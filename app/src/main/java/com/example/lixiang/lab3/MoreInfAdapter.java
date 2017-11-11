package com.example.lixiang.lab3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class MoreInfAdapter extends BaseAdapter {

    private Context context;
    List<String> mDatas;

    public MoreInfAdapter(Context context, List<String> mDatas) {
        this.context = context;
        this.mDatas = mDatas;
    }
    @Override
    public int getCount() {
        if (mDatas != null) {
            return mDatas.size();
        } else return 0;
    }
    @Override
    public Object getItem(int i) {
        if (mDatas == null) {
            return null;
        } else {
            return mDatas.get(i);
        }
    }
    @Override
    public long getItemId(int i) {
        return i;
    }
    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        View convertView;
        ViewHolder holder;
        if (view == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.more, null);
            holder = new ViewHolder();
            holder.tv = (TextView) convertView.findViewById(R.id.more);
            convertView.setTag(holder);
        } else {
            convertView = view;
            holder = (ViewHolder) convertView.getTag();
        }
        holder.tv.setText(mDatas.get(position));
        return convertView;
    }

    private class ViewHolder {
        public TextView tv;
    }
}