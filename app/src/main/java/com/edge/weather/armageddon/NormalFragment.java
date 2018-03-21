package com.edge.weather.armageddon;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;


public class NormalFragment extends Fragment {

    private TextView normalGroupName,normalGroupPrice,normalWithdrawDate,normalMaturityType,normalSelectPound,
            normalCurrentSavingPrice,normalRemainPrice,normalSumPrice,normalTextEtc;
    private LineChart lineChart;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        final View myView = inflater.inflate(R.layout.fragment_normal, container, false);

        lineChart = (LineChart) myView.findViewById(R.id.lineChart);

        normalGroupName=(TextView)myView.findViewById(R.id.normalGroupName);
        normalGroupPrice=(TextView)myView.findViewById(R.id.normalGroupPrice);
        normalWithdrawDate=(TextView)myView.findViewById(R.id.normalWithdrawDate);
        normalMaturityType=(TextView)myView.findViewById(R.id.normalMaturityType);
        normalSelectPound=(TextView)myView.findViewById(R.id.normalSelectPound);
        normalCurrentSavingPrice=(TextView)myView.findViewById(R.id.normalCurrentSavingPrice);
        normalRemainPrice=(TextView)myView.findViewById(R.id.normalRemainPrice);
        normalSumPrice=(TextView)myView.findViewById(R.id.normalSumPrice);
        normalTextEtc=(TextView)myView.findViewById(R.id.normalTextEtc);



       final ArrayList<Entry> labels=new ArrayList<Entry>();

       labels.add(new Entry(0,10f));
        labels.add(new Entry(1,30f));
        labels.add(new Entry(2,40f));
        labels.add(new Entry(3,60f));
        labels.add(new Entry(4,90f));

        LineDataSet lineDataSet=new LineDataSet(labels,"수익률");
        lineDataSet.setAxisDependency(YAxis.AxisDependency.LEFT);

        final ArrayList<String> xLabel = new ArrayList<>();
        xLabel.add("3월");
        xLabel.add("4월");
        xLabel.add("5월");
        xLabel.add("6월");
        xLabel.add("7월");

        LineData data=new LineData(lineDataSet);

        lineChart.setData(data);
        XAxis xAxis = lineChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setDrawGridLines(false);
        xAxis.setValueFormatter(new IAxisValueFormatter() {

            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                Log.d("gggg0",value+"");

                return xLabel.get((int)value);
            }

            // we don't draw numbers, so no decimal digits needed
            @Override
            public int getDecimalDigits() {  return 0; }
        });



        lineChart.invalidate();


        return myView;
    }
}
