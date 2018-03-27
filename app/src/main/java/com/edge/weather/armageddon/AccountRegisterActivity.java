package com.edge.weather.armageddon;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class AccountRegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_register);

        Button b = (Button)findViewById(R.id.backMainbtn);
        Button b1 = (Button)findViewById(R.id.accountRegisterbtn);

        addAccount("신한은행","신지인","110-8751-554247");
        addAccount("국민은행","김지민","1985-4478522-5421");

        b.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(AccountRegisterActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
        b1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                AlertDialog.Builder ad = new AlertDialog.Builder(AccountRegisterActivity.this);
                LayoutInflater inflater = getLayoutInflater();
                View vv = inflater.inflate(R.layout.dialog_acc, null);
                ad.setView(vv);
                ad.setTitle("계좌 등록");

                final EditText accountbank = (EditText) vv.findViewById(R.id.aa);
                final EditText accountname = (EditText) vv.findViewById(R.id.aaa);
                final EditText accountnum = (EditText) vv.findViewById(R.id.aaaa);

                final AlertDialog dialog = ad.create();
                ad.setPositiveButton("등록", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Text 값 받아서 로그 남기기
                        String accountbankValue = accountbank.getText().toString();
                        String accountnameValue = accountname.getText().toString();
                        String accountnumValue = accountnum.getText().toString();

                        addAccount(accountbankValue,accountnameValue,accountnumValue);
                        dialog.dismiss();     //닫기
                        // Event
                    }
                });
                ad.show();
            }
        });
    }

    public void addAccount(String a, String b, String c){
        LinearLayout inLayout = (LinearLayout)findViewById(R.id.accountRegister);
        LayoutInflater inflater = (LayoutInflater) getSystemService        (Context.LAYOUT_INFLATER_SERVICE);
        LinearLayout route_info_tab = (LinearLayout) inflater.inflate(R.layout.accountregisterlayout, null);

        route_info_tab.setBackgroundColor(Color.LTGRAY);

        TextView bb = (TextView)route_info_tab.findViewById(R.id.bankNametxt);
        bb.setText(bb.getText()+" : "+a);
        TextView bbb = (TextView)route_info_tab.findViewById(R.id.accountNametxt);
        bbb.setText(bbb.getText()+" : "+b);
        TextView bbbb = (TextView)route_info_tab.findViewById(R.id.accountNumbertxt);
        bbbb.setText(bbbb.getText()+" : "+c);
//        route_info_tab.findViewById(R.id.accountNametxt);
//        route_info_tab.findViewById(R.id.accountNumbertxt);

        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, 200);
        lp.setMargins(30,30,30,0);
        route_info_tab.setLayoutParams(lp);

        inLayout.addView(route_info_tab);
    }
}
