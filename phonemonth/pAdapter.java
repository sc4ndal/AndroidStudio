package com.example.myproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


import java.util.ArrayList;

public class pAdapter extends BaseAdapter {
    ArrayList<pListViewItem> list = new ArrayList<pListViewItem>();
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
            convertview = inflater.inflate(R.layout.plistitem,parent,false);
        }
        TextView txtPname = (TextView) convertview.findViewById(R.id.txtPname);
        TextView txtPprice = (TextView) convertview.findViewById(R.id.txtPprice);
        TextView txtPsup = (TextView) convertview.findViewById(R.id.txtPsup);
        pListViewItem item = (pListViewItem) list.get(pos);

        txtPname.setText(item.getTxtPname());
        txtPprice.setText(item.getTxtPprice());
        txtPsup.setText(item.getTxtPsup());
        return convertview;
    }
    public void paddItem(String txtPname, String txtPprice, String txtPsup){
        final pListViewItem item = new pListViewItem();
        item.setTxtPname(txtPname);
        item.setTxtPprice(txtPprice);
        item.setTxtPsup(txtPsup);
        list.add(item);
    }
}
