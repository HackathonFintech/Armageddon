package com.example.jeong.hackerton;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.edge.weather.armageddon.R;

/**
 * Created by Jeong on 2018-03-22.
 */

public class page_2 extends android.support.v4.app.Fragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        RelativeLayout relativeLayout = (RelativeLayout) inflater.inflate(R.layout.history_listview, container, false);
        ListView listview;
        history_ListviewAdapter adapter;

        // Adapter 생성
        adapter = new history_ListviewAdapter();

        // 리스트뷰 참조 및 Adapter달기
        listview = (ListView) relativeLayout.findViewById(R.id.listview1);
        listview.setAdapter(adapter);

        // 첫 번째 아이템 추가.
        adapter.addItem(ContextCompat.getDrawable(super.getContext(), R.drawable.ib), "아마..계돈", "5000000(2.5)", "2018/03/22");
        adapter.addItem(ContextCompat.getDrawable(super.getContext(), R.drawable.ib), "서경대 계모임", "2500000(1.8)", "2018/03/22");
        adapter.addItem(ContextCompat.getDrawable(super.getContext(), R.drawable.chul), "여행 계", "1500000", "2018/03/22");

        return relativeLayout;
    }
}
