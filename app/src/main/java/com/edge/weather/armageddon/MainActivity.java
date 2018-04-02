package com.edge.weather.armageddon;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private static final int RESULT_CODE=0;
    private LinearLayout linearLayout;
    private Button buttonCreateRoomActivity, buttonReferenceActivity,createGroupBtn;
    private Intent intent;
    private LinearLayout.LayoutParams params;
    private RelativeLayout.LayoutParams paramss;
    private TextView txt_register;
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

        //그룹방 생성액티비티 호출
        createGroupBtn=(Button)findViewById(R.id.createGroupBtn);
        createGroupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final LayoutInflater vi = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                final LinearLayout chooseLinear = (LinearLayout)vi.inflate(R.layout.dialog_choose_savings_normal,null);
                final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("방 속성 선택");

                builder.setView(chooseLinear);
                final Button savingsBtn = (Button)chooseLinear.findViewById(R.id.savingsBtn);
                final Button normalBtn = (Button)chooseLinear.findViewById(R.id.normalBtn);
                savingsBtn.setBackgroundColor(Color.DKGRAY);
                normalBtn.setBackgroundColor(Color.LTGRAY);

                //false면 일반, true면 적금형
                final boolean[] chooseBtn = {false};

                normalBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        savingsBtn.setBackgroundColor(Color.DKGRAY);
                        normalBtn.setBackgroundColor(Color.LTGRAY);
                        chooseBtn[0] =false;
                    }
                });
                savingsBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        normalBtn.setBackgroundColor(Color.DKGRAY);
                        savingsBtn.setBackgroundColor(Color.LTGRAY);
                        chooseBtn[0] =true;
                    }
                });

                builder.setNeutralButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if(chooseBtn[0]){
                            Toast.makeText(getApplicationContext(), "적금 ", Toast.LENGTH_SHORT).show();
                        }else if(!chooseBtn[0]){
                            intent=new Intent(MainActivity.this,CreateRoomActivity.class);
                            startActivityForResult(intent,0);
                        }
                    }
                });

                builder.setPositiveButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
                builder.show();
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
            String radioDatePrice = data.getExtras().get("radioDatePrice").toString();

            //위에 찾은 리니어 레이아웃에 추가할 리니어 레이아웃
            LinearLayout groupLinear=new LinearLayout(this);
            groupLinear.setOrientation(LinearLayout.VERTICAL);
            groupLinear.setBackgroundColor(Color.YELLOW);

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
            params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

            //첫번째 수평 레이아웃 하위 View들
            TextView groupNameView=new TextView(this);
            groupNameView.setText(groupName);
            groupNameView.setTextSize(40);
            groupNameView.setLayoutParams(params);

            TextView CategoryView=new TextView(this);
            CategoryView.setText(selectitem);

            CategoryView.setPadding(250,10,0,10);
            CategoryView.setGravity(Gravity.CENTER);
            CategoryView.setLayoutParams(params);

            Button modify=new Button(this);
            modify.setText("수정");
            modify.setGravity(Gravity.RIGHT);
            modify.setLayoutParams(params);

            //첫번째 수평 레이아웃에 추가
            oneLinear.addView(groupNameView);
            oneLinear.addView(CategoryView);


            //수직 리니어 레이아웃안에 수평레이아웃 두번째
            LinearLayout twoLinear=new LinearLayout(this);
            twoLinear.setOrientation(LinearLayout.HORIZONTAL);

            params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
            twoLinear.setLayoutParams(params);

            //두번째 수평 레이아웃안에 있는 View들에 대한 param 정의
            params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            params.setMargins(10,0,10,0);

            //두번째 수평 레이아웃 하위 View들
            TextView maturityPeriod=new TextView(this);
            //만기 금액 선택시
            if(radioDatePrice.equals("true")){
                maturityPeriod.setText("만기 금액: ");
                maturityPeriod.append(editTextMaturityPrice);
            }
            else{
                maturityPeriod.setText("만기 기간: ");
                maturityPeriod.append(endDate);
            }
            maturityPeriod.setLayoutParams(params);

            TextView signature=new TextView(this);
            signature.setText("서명중");
            signature.setGravity(Gravity.RIGHT);
            paramss = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
            paramss.setMargins(0,0,20,0);
            signature.setLayoutParams(paramss);

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
            params.setMargins(10,0,10,0);

            //세번째 수평 레이아웃 하위 View들
            TextView individualPrice=new TextView(this);
            individualPrice.setText("개인금액");
            individualPrice.setLayoutParams(params);

            TextView currentTotalPrice=new TextView(this);
            currentTotalPrice.setText("현재 총 금액");
            currentTotalPrice.setGravity(Gravity.CENTER_HORIZONTAL);
            paramss = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
            currentTotalPrice.setLayoutParams(paramss);

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
