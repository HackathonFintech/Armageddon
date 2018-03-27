package com.example.jeong.hackerton;

import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.edge.weather.armageddon.R;
import com.example.user.newpintech.AgreeActivity;

public class Jsh_invite extends AppCompatActivity {

    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jsh_invite);

        ListView listview ;
        CustomChoiceListViewAdapter adapter;

        // Adapter 생성
        adapter = new CustomChoiceListViewAdapter() ;

        // 리스트뷰 참조 및 Adapter달기
        listview = (ListView) findViewById(R.id.listview1);
        listview.setAdapter(adapter);

        Button invite_btn = (Button) findViewById(R.id.invite_btn);
        Button cancel_btn = (Button) findViewById(R.id.cancel_btn);

        invite_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent=new Intent(Jsh_invite.this, AgreeActivity.class);
                startActivity(intent);
                Toast.makeText(Jsh_invite.this, "초대하였습니다", Toast.LENGTH_SHORT).show();
            }
        });

        cancel_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(Jsh_invite.this, "취소", Toast.LENGTH_SHORT).show();

            }
        });

        // 첫 번째 아이템 추가.
       adapter.addItem(ContextCompat.getDrawable(this, R.drawable.user_13230),"김철수");
        // 두 번째 아이템 추가.
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.user_13230),"덕칠이") ;
        // 세 번째 아이템 추가.
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.user_13230),"일칠이") ;
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.user_13230),"이칠이") ;
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.user_13230),"삼칠이") ;
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.user_13230),"사치리") ;
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.user_13230),"오취리") ;
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.user_13230),"육칠이") ;
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.user_13230),"칠칠이") ;
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.user_13230),"팔칠이") ;
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.user_13230),"구칠이") ;
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.user_13230),"십칠이") ;
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.user_13230),"덕배") ;


    }

}
