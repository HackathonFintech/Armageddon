package com.example.jeong.hackerton;

import android.graphics.drawable.Drawable;

/**
 * Created by Jeong on 2018-03-21.
 */

public class history_ListViewItem {
        private Drawable icon ;
        private String groupname;
        private String money;
        private String date;
        public void setGroupname(String text) {
        this.groupname =text ;
    }
        public void setIcon(Drawable icon) {
            this.icon = icon ;
        }
        public void setMoney(String text) {
            this.money = text ;
        }
        public void setDate(String text) {
        this.date = text ;
    }
        public Drawable getIcon() {return this.icon ;}
        public String getGroupname (){return this.groupname;}
        public String getMoney(){return this.money;}
        public String getDate(){return this.date;}
    }
