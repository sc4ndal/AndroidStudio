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
    private ArrayList<ListViewItem> listViewItemList = new ArrayList<ListViewItem>();

    public ListViewAdapter(){

    }
    @Override
    public int getCount() {
        return listViewItemList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int positon, View convertView, ViewGroup parent) {
        final int pos = positon;
        final Context context = parent.getContext();

        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_item, parent, false);
        }

        ImageView iconImageView = (ImageView) convertView.findViewById(R.id.imageView);
        TextView titleTextView = (TextView) convertView.findViewById(R.id.txtV1);
        TextView descTextView = (TextView) convertView.findViewById(R.id.txtV2);

        ListViewItem listViewItem = listViewItemList.get(positon);

        iconImageView.setImageDrawable(listViewItem.getDrawableIcon());
        titleTextView.setText(listViewItem.getTitle());
        descTextView.setText(listViewItem.getDescription());

        return convertView;
    }

    public void addItem(Drawable icon, String title, String desc){
        ListViewItem item = new ListViewItem();

        item.setDrawableIcon(icon);
        item.setTitle(title);
        item.setDescription(desc);

        listViewItemList.add(item);
    }
}
