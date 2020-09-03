package com.example.rainlovepear;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class HeartAdapter extends BaseAdapter {

    private List<Integer>  HeartList;
    private LayoutInflater layoutInflater;

    public HeartAdapter(Context context,List<Integer> HeartList){
        this.HeartList = HeartList;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return HeartList.size();
    }

    @Override
    public Object getItem(int position) {
        return HeartList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        ViewHolder holder = null;
        if (convertView == null){
            convertView = layoutInflater.inflate(R.layout.adapter_show, null);
            holder = new ViewHolder();
            holder.imageView = (ImageView) convertView.findViewById(R.id.image_show);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        int i =  HeartList.get(position);
        if (i != 0) {
            holder.imageView.setImageResource(i);
        }
        return convertView;
    }

    class ViewHolder{
        ImageView imageView;
    }


}
