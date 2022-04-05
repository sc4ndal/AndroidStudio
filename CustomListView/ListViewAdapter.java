package com.example.customlistview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ListViewAdapter extends BaseAdapter {
    private ArrayList<ListViewItem> list = new ArrayList<ListViewItem>();

    @Override
    public int getCount() { return list.size(); }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final int pos = position;
        final Context context = parent.getContext();

        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_item, parent, false);
        }

        ImageView icon = (ImageView) convertView.findViewById(R.id.imageView);
        TextView txtName = (TextView) convertView.findViewById(R.id.txtName);
        TextView txtTelNo = (TextView) convertView.findViewById(R.id.txtTelNo);

        ListViewItem item = (ListViewItem) list.get(pos);

        icon.setImageDrawable(item.getDrawableIcon());
        txtName.setText(item.getName());
        txtTelNo.setText(item.getTelNo());

        return convertView;
    }

    public void addItem(Drawable icon, String txtName, String txtTelNo){
        ListViewItem item = new ListViewItem();

        item.setDrawableIcon(icon);
        item.setName(txtName);
        item.setTelNo(txtTelNo);

        list.add(item);
    }
}
