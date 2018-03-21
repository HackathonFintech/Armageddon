package com.edge.weather.armageddon;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class MonthlyFragment extends Fragment implements View.OnClickListener {

    private Button buttonPreviousMonth, buttonNextMonth;
    private TextView textViewCurrentMonth;
    private BarChart barChart;
    private BarData data;
    private ArrayList<BarEntry> bargroup1,bargroup2;
    private BarDataSet barDataSet1,barDataSet2;
    private ArrayList<BarDataSet> dataSets;
    final private String[] monthList={"1월","2월","3월","4월","5월","6월","7월","8월","9월","10월","11월","12월"};
    private int index;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View myView = inflater.inflate(R.layout.fragment_monthly, container, false);

        index=2;

        buttonPreviousMonth=(Button)myView.findViewById(R.id.buttonPreviousMonth);
        buttonNextMonth=(Button)myView.findViewById(R.id.buttonNextMonth);
        buttonPreviousMonth.setOnClickListener(this);
        buttonNextMonth.setOnClickListener(this);
        textViewCurrentMonth=(TextView)myView.findViewById(R.id.textViewCurrentMonth);

        textViewCurrentMonth.setText(monthList[index]);


        barChart = (BarChart) myView.findViewById(R.id.barChart);
        rePaintChart(new int[][]{{0,20},{1,30},{2,30},{3,40},{0,2},{1,3},{2,5},{3,6}});
        return myView;
    }


    private void rePaintChart(int[][] xValues){
        barChart.clear();
        bargroup1= new ArrayList<>();
        bargroup1.add(new BarEntry(xValues[0][0], xValues[0][1]));
        bargroup1.add(new BarEntry(xValues[1][0], xValues[1][1]));
        bargroup1.add(new BarEntry(xValues[2][0], xValues[2][1]));
        bargroup1.add(new BarEntry(xValues[3][0], xValues[3][1]));

        bargroup2= new ArrayList<>();
        bargroup2.add(new BarEntry(xValues[4][0], xValues[4][1]));
        bargroup2.add(new BarEntry(xValues[5][0], xValues[5][1]));
        bargroup2.add(new BarEntry(xValues[6][0], xValues[6][1]));
        bargroup2.add(new BarEntry(xValues[7][0], xValues[7][1]));
        barDataSet1= new BarDataSet(bargroup1, "납부 총액");
        barDataSet2 = new BarDataSet(bargroup2, "미납 총액");
        barDataSet2.setColors(ColorTemplate.COLORFUL_COLORS[0]);
        final ArrayList<String> labels = new ArrayList<String>();
        labels.add("곽승혁");
        labels.add("김건영");
        labels.add("신지인");
        labels.add("정승현");
        dataSets = new ArrayList<BarDataSet>();  // combined all dataset into an arraylist
        dataSets.add(barDataSet1);
        dataSets.add(barDataSet2);
        data=new BarData(barDataSet1,barDataSet2);

        barChart.setData(data);
        XAxis xAxis = barChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setDrawGridLines(false);
        xAxis.setValueFormatter(new IAxisValueFormatter() {
            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                return labels.get((int)value);
            }

            @Override
            public int getDecimalDigits() {  return 0; }
        });
        barChart.invalidate();
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.buttonNextMonth:
                index++;
                textViewCurrentMonth.setText(monthList[index]);
                rePaintChart(new int[][]{{0,30},{1,40},{2,35},{3,55},{0,4},{1,3},{2,8},{3,15}});


                break;
            case R.id.buttonPreviousMonth:
                index--;
                textViewCurrentMonth.setText(monthList[index]);

                rePaintChart(new int[][]{{0,15},{1,20},{2,25},{3,35},{0,1},{1,3},{2,3},{3,4}});
                break;
        }
    }
}
