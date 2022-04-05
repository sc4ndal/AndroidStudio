package com.example.gridview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter {
    private Context context;
    int[] imageId = {R.drawable.movie1, R.drawable.movie1, R.drawable.movie1, R.drawable.movie1, R.drawable.movie1, R.drawable.movie1, R.drawable.movie1,
            R.drawable.movie1, R.drawable.movie1, R.drawable.movie1, R.drawable.movie1, R.drawable.movie1, R.drawable.movie1, R.drawable.movie1,
            R.drawable.movie1, R.drawable.movie1, R.drawable.movie1, R.drawable.movie1, R.drawable.movie1, R.drawable.movie1, R.drawable.movie1,
            R.drawable.movie1, R.drawable.movie1, R.drawable.movie1, R.drawable.movie1, R.drawable.movie1, R.drawable.movie1, R.drawable.movie1};

    ImageAdapter(Context c){
        context = c;
    }
    @Override
    public int getCount() {
        return imageId.length;
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
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null){
            imageView = new ImageView(context);
//            imageView.setPadding(8,8,8,8);
//            imageView.setLayoutParams(new GridView.LayoutParams(85, 85));
        }else {
            imageView = (ImageView) convertView;
        }
        imageView.setImageResource(imageId[position]);
        return imageView;
    }

}
