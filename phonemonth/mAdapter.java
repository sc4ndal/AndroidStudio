package com.example.myproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


import java.util.ArrayList;

public class mAdapter extends BaseAdapter {
    ArrayList<mListViteItem> list = new ArrayList<mListViteItem>();
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
            convertview = inflater.inflate(R.layout.mlistitem,parent,false);
        }
        TextView txtMname = (TextView) convertview.findViewById(R.id.txtMname);
        TextView txtMprice = (TextView) convertview.findViewById(R.id.txtMprice);
        mListViteItem item = (mListViteItem) list.get(pos);

        txtMname.setText(item.getTxtMname());
        txtMprice.setText(item.getTxtMprice());
        return convertview;
    }
    public void maddItem(String txtMname, String txtMprice){
        final mListViteItem item = new mListViteItem();
        item.setTxtMname(txtMname);
        item.setTxtMprice(txtMprice);
        list.add(item);
    }

}
