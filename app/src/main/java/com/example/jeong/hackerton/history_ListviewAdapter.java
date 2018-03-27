package com.example.jeong.hackerton;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Jeong on 2018-03-22.
 */

public class history_ListviewAdapter extends BaseAdapter{
    private ArrayList<history_ListViewItem> listViewItemList = new ArrayList<history_ListViewItem>();

    public history_ListviewAdapter(){

    }
    @Override
    public int getCount() {
        return listViewItemList.size();
    }

    @Override
    public View getView(int position, View convertView , ViewGroup parent){
        final int pos = position;
        final Context context = parent.getContext();

        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView  = inflater.inflate(R.layout.history_list_item,parent,false);
        }

        ImageView iconImageView = (ImageView) convertView.findViewById(R.id.imageView2);
        TextView group_name_tv = (TextView)convertView.findViewById(R.id.Group_name_TV);
        TextView money_tv = (TextView)convertView.findViewById(R.id.Money_TV);
        TextView date_tv = (TextView) convertView.findViewById(R.id.Date_TV);

        history_ListViewItem history_listviewitem = listViewItemList.get(position);

        iconImageView.setImageDrawable(history_listviewitem.getIcon());
        group_name_tv.setText(history_listviewitem.getGroupname());
        money_tv.setText(history_listviewitem.getMoney());
        date_tv.setText(history_listviewitem.getDate());

        return convertView;
    }

    @Override
    public long getItemId(int position){
        return position;
    }
    @Override
    public Object getItem(int position){
        return listViewItemList.get(position);
    }
    public void addItem(Drawable icon, String groupname, String money, String date){
        history_ListViewItem item = new history_ListViewItem();

        item.setIcon(icon);
        item.setGroupname(groupname);
        item.setMoney(money);
        item.setDate(date);

        listViewItemList.add(item);
    }
}

