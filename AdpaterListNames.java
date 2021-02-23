package com.example.database;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class AdpaterListNames extends BaseAdapter {

    List<ACCOUNT> list;
    Context context;

    public AdpaterListNames(List<ACCOUNT> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = LayoutInflater.from(context).inflate(R.layout.custom_name,parent,false);

        TextView tv_name = v.findViewById(R.id.custom_tv_name);


        tv_name.setText(list.get(position).getName());
        return v;
    }
}
