package com.example.namecard;

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
    ArrayList<ListViewItem> list = new ArrayList<ListViewItem>();
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
        return position;
    }

    @Override
    public View getView(int position, View convertview, ViewGroup parent) {
        final int pos = position;
        final Context context = parent.getContext();
        if(convertview==null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertview = inflater.inflate(R.layout.listitem, parent, false);
        }
        TextView txtItemName = (TextView) convertview.findViewById(R.id.txtItemName);
        TextView txtItemTel = (TextView) convertview.findViewById(R.id.txtItemTel);
        TextView txtItemEmail = (TextView) convertview.findViewById(R.id.txtItemEmail);
        ListViewItem item = (ListViewItem) list.get(pos);

        txtItemName.setText(item.getTxtItemName());
        txtItemTel.setText(item.getTxtItemTel());
        txtItemEmail.setText(item.getTxtItemEmail());

        return convertview;
    }

    public void addItem(String txtItemName, String txtItemTel, String txtItemEmail){
        final ListViewItem item = new ListViewItem();
        item.setTxtItemName(txtItemName);
        item.setTxtItemTel(txtItemTel);
        item.setTxtItemEmail(txtItemEmail);
        list.add(item);
        this.notifyDataSetChanged();
    }
}
