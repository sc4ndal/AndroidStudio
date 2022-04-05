package com.example.customlistview;

import android.graphics.drawable.Drawable;

public class ListViewItem {
    private Drawable drawableIcon;
    private String name;
    private String telNo;

    public Drawable getDrawableIcon() {return drawableIcon;}
    public void setDrawableIcon(Drawable drawableIcon) {this.drawableIcon = drawableIcon;}
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public String getTelNo() {return telNo;}
    public void setTelNo(String telNo) {this.telNo = telNo;}
}
