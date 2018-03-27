package com.edge.weather.armageddon;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.jeong.hackerton.Jsh_invite;

import java.util.ArrayList;
import java.util.Calendar;

public class CreateRoomActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editGroupName, edirPrice, editWithdrawDate, editEtc, editTextMaturityPrice;
    private Button btnEndDate, btnConfirm, btnCancel;
    private Spinner spinnerSelectPound;
    private CheckBox checkAgreeCreateRoom;
    private ArrayList<String> spinnerList;
    private String selectitem;
    private RadioGroup radioGroup;
    private FloatingActionButton buttonExplanePopup;
    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_room);

        spinnerList = new ArrayList<>();
        spinnerList.add("일반계");
        spinnerList.add("번호계");
        spinnerList.add("낙찰계");

        ArrayAdapter spinnerAdapter;
        spinnerAdapter = new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, spinnerList);

        editGroupName = (EditText) findViewById(R.id.groupName);
        edirPrice = (EditText) findViewById(R.id.price);
        editWithdrawDate = (EditText) findViewById(R.id.withdrawDate);
        editEtc = (EditText) findViewById(R.id.editTextEtc);
        btnEndDate = (Button) findViewById(R.id.endDate);
        btnConfirm = (Button) findViewById(R.id.btnConfirm);
        btnCancel = (Button) findViewById(R.id.btnCancel);
        spinnerSelectPound = (Spinner) findViewById(R.id.selectPound);
        checkAgreeCreateRoom = (CheckBox) findViewById(R.id.agreeCreateRoom);
        editTextMaturityPrice = (EditText) findViewById(R.id.editTextMaturityPrice);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        buttonExplanePopup = (FloatingActionButton) findViewById(R.id.buttonExplanePopup);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(i==R.id.radioButtonMaturityPeriod){
                    editTextMaturityPrice.setVisibility(View.GONE);
                    btnEndDate.setVisibility(View.VISIBLE);
                }else{
                    editTextMaturityPrice.setVisibility(View.VISIBLE);
                    btnEndDate.setVisibility(View.GONE);
                }
            }
        });



        spinnerSelectPound.setAdapter(spinnerAdapter);
        spinnerSelectPound.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                selectitem = spinnerSelectPound.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        btnConfirm.setOnClickListener(this);
        btnCancel.setOnClickListener(this);
        btnEndDate.setOnClickListener(this);
        buttonExplanePopup.setOnClickListener(this);



    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.buttonExplanePopup:
                new ExplaneTypeDialog(CreateRoomActivity.this);
                break;
            case R.id.btnCancel:
                finish();
                break;
            case R.id.btnConfirm:
                if (editGroupName.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "방명을 입력해주세요", Toast.LENGTH_SHORT).show();
                } else if (edirPrice.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "금액을 입력해주세요", Toast.LENGTH_SHORT).show();
                } else if (editWithdrawDate.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "회수일자를 지정해주세요", Toast.LENGTH_SHORT).show();
                } else if (btnEndDate.getText().toString().equals("Date")) {
                    Toast.makeText(getApplicationContext(), "종료 날짜를 지정해주세요", Toast.LENGTH_SHORT).show();
                } else if (checkAgreeCreateRoom.isChecked() == false) {
                    Toast.makeText(getApplicationContext(), "동의에 체크해주세요", Toast.LENGTH_SHORT).show();
                } else {
                    intent=getIntent();
                    intent.putExtra("groupName",editGroupName.getText().toString());
                    intent.putExtra("price",edirPrice.getText().toString());
                    intent.putExtra("withdrawDate",editWithdrawDate.getText().toString());
                    intent.putExtra("endDate",btnEndDate.getText().toString());
                    intent.putExtra("editTextMaturityPrice",editTextMaturityPrice.getText().toString());
                    intent.putExtra("selectitem",selectitem);
                    intent.putExtra("editEtc",editEtc.getText().toString());
                    setResult(0,intent);
                    finish();
                    intent=new Intent(CreateRoomActivity.this, Jsh_invite.class);
                    startActivity(intent);
                }
                break;
            case R.id.endDate:
                Calendar calendar = Calendar.getInstance();
                DatePickerDialog dpd = new DatePickerDialog(
                        this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        ((Button) findViewById(R.id.endDate)).setText(year + "년" + (monthOfYear + 1) + "월" + dayOfMonth + "일");
                    }
                }, calendar.get(calendar.YEAR), calendar.get(calendar.MONTH), calendar.get(calendar.DATE)
                );
                dpd.show();
                break;
        }
    }


}
