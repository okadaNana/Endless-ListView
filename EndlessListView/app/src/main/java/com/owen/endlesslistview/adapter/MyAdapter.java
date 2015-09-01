package com.owen.endlesslistview.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.owen.endlesslistview.R;

import java.util.List;

public class MyAdapter extends BaseAdapter {

    private Context mContext;
    private List<String> mData;
    private final LayoutInflater mInflater;

    public MyAdapter(Context context, List<String> data) {
        this.mContext = context;
        this.mData = data;
        mInflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return null == mData ? 0 : mData.size();
    }

    @Override
    public Object getItem(int position) {
        return null == mData ? null : mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (null == convertView) {
            holder = new ViewHolder();
            convertView = mInflater.inflate(R.layout.item_note, parent, false);
            holder.tvNoteTitle = (TextView) convertView.findViewById(R.id.tv_note_title);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.tvNoteTitle.setText(mData.get(position));

        return convertView;
    }

    public void setData(List<String> nextPageData) {
        mData.addAll(nextPageData);
        this.notifyDataSetChanged();
    }

    static class ViewHolder {
        TextView tvNoteTitle;
    }

}
