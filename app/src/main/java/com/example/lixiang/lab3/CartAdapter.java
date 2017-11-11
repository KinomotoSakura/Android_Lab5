package com.example.lixiang.lab3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class CartAdapter extends BaseAdapter {
    private Context context;
    private List<GoodsInfo> cargood;

    public CartAdapter(Context context, List<GoodsInfo> cargood) {
        this.context = context;
        this.cargood=cargood;
    }
    @Override
    public int getCount() {
        if (cargood != null) {
            return cargood.size();
        } else return 0;
    }
    @Override
    public Object getItem(int i) {
        if (cargood == null) {
            return null;
        } else {
            return cargood.get(i);
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
            convertView = LayoutInflater.from(context).inflate(R.layout.cart_item, null);
            holder = new ViewHolder();
            holder.fir = (TextView) convertView.findViewById(R.id.firstLetter);
            holder.nam = (TextView) convertView.findViewById(R.id.name);
            holder.pri = (TextView) convertView.findViewById(R.id.price);
            convertView.setTag(holder);
        } else {
            convertView = view;
            holder = (ViewHolder) convertView.getTag();
        }
        holder.fir.setText(cargood.get(position).getName().substring(0,1).toUpperCase());
        holder.nam.setText(cargood.get(position).getName());
        holder.pri.setText(cargood.get(position).getPrice());
        return convertView;
    }
    private class ViewHolder {
        public TextView fir;
        public TextView nam;
        public TextView pri;
    }

}
