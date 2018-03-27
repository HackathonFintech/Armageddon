package com.edge.weather.armageddon;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jeong.hackerton.Jsh_history;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private static final int RESULT_CODE=0;
    private LinearLayout linearLayout;
    private Button buttonCreateRoomActivity, buttonReferenceActivity,createGroupBtn;
    private Intent intent;
    private LinearLayout.LayoutParams params;
    private TextView txt_register,txt_search;
    private int index =0;
    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //스크롤뷰 안 리니어 레이아웃
        linearLayout=(LinearLayout) findViewById(R.id.linearLayout);

        //등록 액티비티 호출
        txt_register=(TextView)findViewById(R.id.txt_register);
        txt_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent=new Intent(MainActivity.this,AccountRegisterActivity.class);
                startActivity(intent);
            }
        });

        txt_search=(TextView)findViewById(R.id.txt_search);
        txt_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent=new Intent(MainActivity.this,Jsh_history.class);
                startActivity(intent);
            }
        });

        //그룹방 생성액티비티 호출
        createGroupBtn=(Button)findViewById(R.id.createGroupBtn);
        createGroupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent=new Intent(MainActivity.this,CreateRoomActivity.class);
                startActivityForResult(intent,0);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        //그룹방 생성 액티비티에서 전달 받음. -> 나중에 모델로 만들으면 편할듯. 우선 건들지 않음. 보이는 부분이 아님
        if(resultCode==RESULT_CODE){
            String groupName=data.getExtras().get("groupName").toString();
            String price=data.getExtras().get("price").toString();
            String withdrawDate=data.getExtras().get("withdrawDate").toString();
            String endDate=data.getExtras().get("endDate").toString();
            String editTextMaturityPrice=data.getExtras().get("editTextMaturityPrice").toString();
            String selectitem=data.getExtras().get("selectitem").toString();
            String editEtc=data.getExtras().get("editEtc").toString();

            //위에 찾은 리니어 레이아웃에 추가할 리니어 레이아웃
            LinearLayout groupLinear=new LinearLayout(this);
            groupLinear.setOrientation(LinearLayout.VERTICAL);

            params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            params.setMargins(0,140,0,0);
            groupLinear.setLayoutParams(params);

            //수직 리니어 레이아웃안에 수평레이아웃 첫번째
            LinearLayout oneLinear=new LinearLayout(this);
            oneLinear.setOrientation(LinearLayout.HORIZONTAL);

            //첫번째 수평레이아웃에 param 정의
            params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
            oneLinear.setLayoutParams(params);

            //첫번째 수평 레이아웃안에 있는 View들에 대한 param 정의
            params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

            //첫번째 수평 레이아웃 하위 View들
            TextView groupNameView=new TextView(this);
            groupNameView.setText(groupName);
            groupNameView.setLayoutParams(params);

            TextView CategoryView=new TextView(this);
            CategoryView.setText(selectitem);
            CategoryView.setLayoutParams(params);

            Button modify=new Button(this);
            modify.setText("수정");
            modify.setLayoutParams(params);

            //첫번째 수평 레이아웃에 추가
            oneLinear.addView(groupNameView);
            oneLinear.addView(CategoryView);
            oneLinear.addView(modify);

            //수직 리니어 레이아웃안에 수평레이아웃 두번째
            LinearLayout twoLinear=new LinearLayout(this);
            twoLinear.setOrientation(LinearLayout.HORIZONTAL);

            params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
            twoLinear.setLayoutParams(params);

            //두번째 수평 레이아웃안에 있는 View들에 대한 param 정의
            params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

            //두번째 수평 레이아웃 하위 View들
            TextView maturityPeriod=new TextView(this);
            maturityPeriod.setText("만기금액");
            maturityPeriod.setLayoutParams(params);

            TextView signature=new TextView(this);
            signature.setText("서명중");
            signature.setLayoutParams(params);

            //두번째 수평 레이아웃에 추가
            twoLinear.addView(maturityPeriod);
            twoLinear.addView(signature);

            //수직 리니어 레이아웃안에 수평레이아웃 세번째
            LinearLayout threeLinear=new LinearLayout(this);
            threeLinear.setOrientation(LinearLayout.HORIZONTAL);

            params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
            threeLinear.setLayoutParams(params);

            //세번째 수평 레이아웃안에 있는 View들에 대한 param 정의
            params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

            //세번째 수평 레이아웃 하위 View들
            TextView individualPrice=new TextView(this);
            individualPrice.setText("개인금액");
            individualPrice.setLayoutParams(params);

            TextView currentTotalPrice=new TextView(this);
            maturityPeriod.setText("현재 총 금액");
            maturityPeriod.setLayoutParams(params);

            //세번째 수평 레이아웃에 추가
            threeLinear.addView(individualPrice);
            threeLinear.addView(currentTotalPrice);

            //수직 레이아웃에 수평 레이아웃들 추가
            groupLinear.addView(oneLinear);
            groupLinear.addView(twoLinear);
            groupLinear.addView(threeLinear);

            //수직레이아웃 클릭 시 그룹방 상세 액티비티 호출
            groupLinear.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    intent=new Intent(MainActivity.this,LookupGroupActivity.class);
                    startActivity(intent);
                }
            });

            //수직레이아웃을 xml에서 정의한 스크롤뷰 안에 있는 리니어 레이아웃에 추가.
            linearLayout.addView(groupLinear,index);
            //버튼이 있던 자리에 생성한것처럼 보이기 위한 index
            index++;
        }
    }

    @Override
    public void onClick(View view) {


    }
}
