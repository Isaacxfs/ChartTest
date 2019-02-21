package com.example.isa.charttest.activity;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.isa.charttest.R;
import com.example.isa.charttest.util.FullScreenStyleUtils;
import com.example.isa.charttest.view.XYaxisMarkerView;
import com.example.isa.charttest.axisformat.BaseValueFormatter;
import com.example.isa.charttest.axisformat.YaxisValueFormatter;
import com.example.isa.charttest.entity.DummyDataStructure;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.ChartTouchListener;
import com.github.mikephil.charting.listener.OnChartGestureListener;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fangsxu
 */
public class ChartTestActivity extends AppCompatActivity implements View.OnClickListener {
    private BarChart chart;
    private Button btnGo,btnReset;
    private TextView tvWeekSelectMon, tvWeekSelectTue, tvWeekSelectWed, tvWeekSelectThu, tvWeekSelectFri, tvWeekSelectSat, tvWeekSelectSun;
    private List<DummyDataStructure> dummyDataStructureList;
    private List<TextView> textViewList;
    private TextView tvStatus;
    private SeekBar seekBar;
    private Entry selectedEntry;
    private XYaxisMarkerView mv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initWindowSettings();
        setContentView(R.layout.activity_main);
        initDummyData();
        initViews();
    }


    private void initDummyData() {
        dummyDataStructureList = new ArrayList<>();

        DummyDataStructure d = new DummyDataStructure();
        d.setDayOfWeek("Mon");
        d.setSelected(false);
        List<BarEntry> entries = new ArrayList<BarEntry>();
        entries.add(new BarEntry(1.0f, 20.0f));
        entries.add(new BarEntry(2.0f, 45.0f));
        entries.add(new BarEntry(3.0f, 66.0f));
        entries.add(new BarEntry(4.0f, 80.0f));

        entries.add(new BarEntry(5.0f, 10.0f));
        entries.add(new BarEntry(6.0f, 15.0f));
        entries.add(new BarEntry(7.0f, 16.0f));
        entries.add(new BarEntry(8.0f, 10.0f));

        entries.add(new BarEntry(9.0f, 80.0f));
        entries.add(new BarEntry(10.0f, 99.0f));
        entries.add(new BarEntry(11.0f, 76.0f));
        entries.add(new BarEntry(12.0f, 60.0f));

        entries.add(new BarEntry(13.0f, 10.0f));
        entries.add(new BarEntry(14.0f, 15.0f));
        entries.add(new BarEntry(15.0f, 96.0f));
        entries.add(new BarEntry(16.0f, 80.0f));

        entries.add(new BarEntry(17.0f, 10.0f));
        entries.add(new BarEntry(18.0f, 65.0f));
        entries.add(new BarEntry(19.0f, 76.0f));
        entries.add(new BarEntry(20.0f, 80.0f));

        entries.add(new BarEntry(21.0f, 40.0f));
        entries.add(new BarEntry(22.0f, 15.0f));
        entries.add(new BarEntry(23.0f, 86.0f));
        entries.add(new BarEntry(24.0f, 80.0f));

        d.setEntries(entries);
        dummyDataStructureList.add(d);

        d = new DummyDataStructure();
        d.setDayOfWeek("Tue");
        d.setSelected(true);
        entries = new ArrayList<BarEntry>();
        entries.add(new BarEntry(1.0f, 6.0f));
        entries.add(new BarEntry(2.0f, 5.0f));
        entries.add(new BarEntry(3.0f, 26.0f));
        entries.add(new BarEntry(4.0f, 10.0f));

        entries.add(new BarEntry(5.0f, 30.0f));
        entries.add(new BarEntry(6.0f, 15.0f));
        entries.add(new BarEntry(7.0f, 16.0f));
        entries.add(new BarEntry(8.0f, 20.0f));

        entries.add(new BarEntry(9.0f, 10.0f));
        entries.add(new BarEntry(10.0f, 8.0f));
        entries.add(new BarEntry(11.0f, 6.0f));
        entries.add(new BarEntry(12.0f, 6.0f));

        entries.add(new BarEntry(13.0f, 1.0f));
        entries.add(new BarEntry(14.0f, 5.0f));
        entries.add(new BarEntry(15.0f, 6.0f));
        entries.add(new BarEntry(16.0f, 8.0f));

        entries.add(new BarEntry(17.0f, 1.0f));
        entries.add(new BarEntry(18.0f, 5.0f));
        entries.add(new BarEntry(19.0f, 6.0f));
        entries.add(new BarEntry(20.0f, 10.0f));

        entries.add(new BarEntry(21.0f, 4.0f));
        entries.add(new BarEntry(22.0f, 1.0f));
        entries.add(new BarEntry(23.0f, 6.0f));
        entries.add(new BarEntry(24.0f, 8.0f));

        d.setEntries(entries);
        dummyDataStructureList.add(d);

        d = new DummyDataStructure();
        d.setDayOfWeek("Wed");
        d.setSelected(false);
        entries = new ArrayList<BarEntry>();
        entries.add(new BarEntry(1.0f, 40.0f));
        entries.add(new BarEntry(2.0f, 45.0f));
        entries.add(new BarEntry(3.0f, 66.0f));
        entries.add(new BarEntry(4.0f, 80.0f));

        entries.add(new BarEntry(5.0f, 10.0f));
        entries.add(new BarEntry(6.0f, 95.0f));
        entries.add(new BarEntry(7.0f, 16.0f));
        entries.add(new BarEntry(8.0f, 10.0f));

        entries.add(new BarEntry(9.0f, 80.0f));
        entries.add(new BarEntry(10.0f, 85.0f));
        entries.add(new BarEntry(11.0f, 36.0f));
        entries.add(new BarEntry(12.0f, 60.0f));

        entries.add(new BarEntry(13.0f, 10.0f));
        entries.add(new BarEntry(14.0f, 15.0f));
        entries.add(new BarEntry(15.0f, 26.0f));
        entries.add(new BarEntry(16.0f, 80.0f));

        entries.add(new BarEntry(17.0f, 10.0f));
        entries.add(new BarEntry(18.0f, 95.0f));
        entries.add(new BarEntry(19.0f, 76.0f));
        entries.add(new BarEntry(20.0f, 20.0f));

        entries.add(new BarEntry(21.0f, 40.0f));
        entries.add(new BarEntry(22.0f, 15.0f));
        entries.add(new BarEntry(23.0f, 36.0f));
        entries.add(new BarEntry(24.0f, 80.0f));

        d.setEntries(entries);
        dummyDataStructureList.add(d);

        d = new DummyDataStructure();
        d.setDayOfWeek("Thu");
        d.setSelected(false);
        entries = new ArrayList<BarEntry>();
        entries.add(new BarEntry(1.0f, 40.0f));
        entries.add(new BarEntry(2.0f, 45.0f));
        entries.add(new BarEntry(3.0f, 26.0f));
        entries.add(new BarEntry(4.0f, 10.0f));

        entries.add(new BarEntry(5.0f, 10.0f));
        entries.add(new BarEntry(6.0f, 15.0f));
        entries.add(new BarEntry(7.0f, 66.0f));
        entries.add(new BarEntry(8.0f, 60.0f));

        entries.add(new BarEntry(9.0f, 80.0f));
        entries.add(new BarEntry(10.0f, 85.0f));
        entries.add(new BarEntry(11.0f, 76.0f));
        entries.add(new BarEntry(12.0f, 40.0f));

        entries.add(new BarEntry(13.0f, 10.0f));
        entries.add(new BarEntry(14.0f, 15.0f));
        entries.add(new BarEntry(15.0f, 96.0f));
        entries.add(new BarEntry(16.0f, 30.0f));

        entries.add(new BarEntry(17.0f, 10.0f));
        entries.add(new BarEntry(18.0f, 65.0f));
        entries.add(new BarEntry(19.0f, 26.0f));
        entries.add(new BarEntry(20.0f, 80.0f));

        entries.add(new BarEntry(21.0f, 90.0f));
        entries.add(new BarEntry(22.0f, 15.0f));
        entries.add(new BarEntry(23.0f, 86.0f));
        entries.add(new BarEntry(24.0f, 40.0f));

        d.setEntries(entries);
        dummyDataStructureList.add(d);

        d = new DummyDataStructure();
        d.setDayOfWeek("Fri");
        d.setSelected(false);
        entries = new ArrayList<BarEntry>();
        entries.add(new BarEntry(1.0f, 20.0f));
        entries.add(new BarEntry(2.0f, 45.0f));
        entries.add(new BarEntry(3.0f, 55.0f));
        entries.add(new BarEntry(4.0f, 80.0f));

        entries.add(new BarEntry(5.0f, 10.0f));
        entries.add(new BarEntry(6.0f, 88.0f));
        entries.add(new BarEntry(7.0f, 16.0f));
        entries.add(new BarEntry(8.0f, 10.0f));

        entries.add(new BarEntry(9.0f, 80.0f));
        entries.add(new BarEntry(10.0f, 35.0f));
        entries.add(new BarEntry(11.0f, 76.0f));
        entries.add(new BarEntry(12.0f, 60.0f));

        entries.add(new BarEntry(13.0f, 20.0f));
        entries.add(new BarEntry(14.0f, 15.0f));
        entries.add(new BarEntry(15.0f, 26.0f));
        entries.add(new BarEntry(16.0f, 80.0f));

        entries.add(new BarEntry(17.0f, 90.0f));
        entries.add(new BarEntry(18.0f, 65.0f));
        entries.add(new BarEntry(19.0f, 36.0f));
        entries.add(new BarEntry(20.0f, 80.0f));

        entries.add(new BarEntry(21.0f, 40.0f));
        entries.add(new BarEntry(22.0f, 75.0f));
        entries.add(new BarEntry(23.0f, 86.0f));
        entries.add(new BarEntry(24.0f, 80.0f));

        d.setEntries(entries);
        dummyDataStructureList.add(d);

        d = new DummyDataStructure();
        d.setDayOfWeek("Sat");
        d.setSelected(false);
        entries = new ArrayList<BarEntry>();
        entries.add(new BarEntry(1.0f, 20.0f));
        entries.add(new BarEntry(2.0f, 44.0f));
        entries.add(new BarEntry(3.0f, 66.0f));
        entries.add(new BarEntry(4.0f, 80.0f));

        entries.add(new BarEntry(5.0f, 40.0f));
        entries.add(new BarEntry(6.0f, 45.0f));
        entries.add(new BarEntry(7.0f, 16.0f));
        entries.add(new BarEntry(8.0f, 70.0f));

        entries.add(new BarEntry(9.0f, 90.0f));
        entries.add(new BarEntry(10.0f, 85.0f));
        entries.add(new BarEntry(11.0f, 36.0f));
        entries.add(new BarEntry(12.0f, 20.0f));

        entries.add(new BarEntry(13.0f, 20.0f));
        entries.add(new BarEntry(14.0f, 25.0f));
        entries.add(new BarEntry(15.0f, 56.0f));
        entries.add(new BarEntry(16.0f, 80.0f));

        entries.add(new BarEntry(17.0f, 80.0f));
        entries.add(new BarEntry(18.0f, 55.0f));
        entries.add(new BarEntry(19.0f, 46.0f));
        entries.add(new BarEntry(20.0f, 30.0f));

        entries.add(new BarEntry(21.0f, 40.0f));
        entries.add(new BarEntry(22.0f, 15.0f));
        entries.add(new BarEntry(23.0f, 86.0f));
        entries.add(new BarEntry(24.0f, 80.0f));

        d.setEntries(entries);
        dummyDataStructureList.add(d);

        d = new DummyDataStructure();
        d.setDayOfWeek("Sun");
        d.setSelected(false);
        entries = new ArrayList<BarEntry>();
        entries.add(new BarEntry(1.0f, 50.0f));
        entries.add(new BarEntry(2.0f, 85.0f));
        entries.add(new BarEntry(3.0f, 46.0f));
        entries.add(new BarEntry(4.0f, 10.0f));

        entries.add(new BarEntry(5.0f, 20.0f));
        entries.add(new BarEntry(6.0f, 75.0f));
        entries.add(new BarEntry(7.0f, 36.0f));
        entries.add(new BarEntry(8.0f, 60.0f));

        entries.add(new BarEntry(9.0f, 10.0f));
        entries.add(new BarEntry(10.0f, 25.0f));
        entries.add(new BarEntry(11.0f, 16.0f));
        entries.add(new BarEntry(12.0f, 80.0f));

        entries.add(new BarEntry(13.0f, 20.0f));
        entries.add(new BarEntry(14.0f, 65.0f));
        entries.add(new BarEntry(15.0f, 36.0f));
        entries.add(new BarEntry(16.0f, 50.0f));

        entries.add(new BarEntry(17.0f, 10.0f));
        entries.add(new BarEntry(18.0f, 35.0f));
        entries.add(new BarEntry(19.0f, 56.0f));
        entries.add(new BarEntry(20.0f, 30.0f));

        entries.add(new BarEntry(21.0f, 20.0f));
        entries.add(new BarEntry(22.0f, 45.0f));
        entries.add(new BarEntry(23.0f, 66.0f));
        entries.add(new BarEntry(24.0f, 30.0f));

        d.setEntries(entries);
        dummyDataStructureList.add(d);
    }

    private void initWindowSettings() {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        FullScreenStyleUtils.setTranslateStatusBar(this);
        FullScreenStyleUtils.setStatusBarMode(this, true);
    }

    private void startAnim() {
        chart.animateY(500);
        chart.invalidate();
    }

    private void initSeekBar(){
        seekBar.setMax(100);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                selectedEntry.setY(i);
                chart.notifyDataSetChanged();
                chart.invalidate();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) { }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) { }
        });
    }

    private void initViews() {
        seekBar = findViewById(R.id.seekbar);
        chart = findViewById(R.id.barchart);
        btnReset = findViewById(R.id.btn_reset);
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chart.fitScreen();
            }
        });
        btnGo = findViewById(R.id.btn);
        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startAnim();
            }
        });
        textViewList = new ArrayList<>();
        tvWeekSelectMon = findViewById(R.id.tv_day_of_week_mon);
        tvWeekSelectMon.setOnClickListener(this);
        textViewList.add(tvWeekSelectMon);
        tvWeekSelectTue = findViewById(R.id.tv_day_of_week_tue);
        tvWeekSelectTue.setOnClickListener(this);
        textViewList.add(tvWeekSelectTue);
        tvWeekSelectWed = findViewById(R.id.tv_day_of_week_wed);
        tvWeekSelectWed.setOnClickListener(this);
        textViewList.add(tvWeekSelectWed);
        tvWeekSelectThu = findViewById(R.id.tv_day_of_week_Thu);
        tvWeekSelectThu.setOnClickListener(this);
        textViewList.add(tvWeekSelectThu);
        tvWeekSelectFri = findViewById(R.id.tv_day_of_week_Fri);
        tvWeekSelectFri.setOnClickListener(this);
        textViewList.add(tvWeekSelectFri);
        tvWeekSelectSat = findViewById(R.id.tv_day_of_week_sat);
        tvWeekSelectSat.setOnClickListener(this);
        textViewList.add(tvWeekSelectSat);
        tvWeekSelectSun = findViewById(R.id.tv_day_of_week_sun);
        tvWeekSelectSun.setOnClickListener(this);
        textViewList.add(tvWeekSelectSun);
        tvStatus = findViewById(R.id.tv_status);
        initSeekBar();
        initChartForWeekDays();
    }

    private void initChartForWeekDays() {
        int index = 0;
        for (int i = 0; i < dummyDataStructureList.size(); i++) {
            if (dummyDataStructureList.get(i).isSelected()) {
                index = i;
                break;
            }
        }
        drawChart(dummyDataStructureList.get(index).getEntries());
    }

    private void drawChart(List<BarEntry> entries) {
        BarDataSet dataSet = new BarDataSet(entries, "");
        dataSet.setGradientColor(Color.rgb(89, 157, 134), Color.rgb(135, 202, 187));
        dataSet.setDrawValues(false);

        BarData data = new BarData(dataSet);
        chart.getLegend().setEnabled(false);
        chart.setDescription(null);
        chart.setData(data);

        chart.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
            @Override
            public void onValueSelected(Entry e, Highlight h) {
                selectedEntry = e;
                seekBar.setVisibility(View.VISIBLE);
                Toast.makeText(ChartTestActivity.this,"Info: X-"+e.getX()+"  Y-"+e.getY()+"  Data: "+e.getData(),Toast.LENGTH_SHORT).show();
                seekBar.setProgress((int) e.getY());
            }

            @Override
            public void onNothingSelected() {
                seekBar.setVisibility(View.INVISIBLE);
            }
        });

        initYAxis();
        initXAxis();

        // chart.setScaleXEnabled(false);
        chart.setDragEnabled(true);
        chart.setDoubleTapToZoomEnabled(false);
        chart.setTouchEnabled(true);
        chart.animateY(500);
        chart.invalidate();
    }

    @Override
    public void onClick(View view) {
        getSelectedView(view.getId());
    }

    private void getSelectedView(int id) {
        chart.highlightValues(null);
        seekBar.setVisibility(View.GONE);
        for (int i = 0; i < textViewList.size(); i++) {
            int temp = textViewList.get(i).getId();
            if (id == temp) {
                dummyDataStructureList.get(i).setSelected(true);
                textViewList.get(i).setBackgroundResource(R.drawable.shape_roundconer_day_of_week_selected);
                textViewList.get(i).setTextColor(Color.WHITE);
                drawChart(dummyDataStructureList.get(i).getEntries());
                startAnim();
            } else {
                dummyDataStructureList.get(i).setSelected(false);
                textViewList.get(i).setTextColor(Color.parseColor("#8A000000"));
                textViewList.get(i).setBackgroundResource(R.drawable.shape_roundconer_day_of_week);
            }
        }

    }

    private void initYAxis(){
        BaseValueFormatter custom = new YaxisValueFormatter("%");
        YAxis left = chart.getAxisLeft();
        // no axis labels
        left.setDrawLabels(true);
        // no axis line
        left.setDrawAxisLine(false);
        // no grid lines
        left.setDrawGridLines(true);
        left.enableGridDashedLine(10f, 10f, 0f);
        left.setTextSize(8f);
        left.setTextColor(Color.rgb(153, 153, 153));
        left.setGridColor(Color.rgb(229, 229, 229));
        left.setValueFormatter(custom);
        left.setAxisMinimum(0);
        left.setAxisMaximum(100);
        left.setLabelCount(6,false);
        // draw a zero line
        left.setDrawZeroLine(true);
        left.setAxisMinimum(0);
        left.setGranularity(10);
        left.setGranularityEnabled(true);
        // no right axis
        chart.getAxisRight().setEnabled(false);
        //chart.getAxisLeft().setEnabled(false);
    }

    private void initXAxis(){
        BaseValueFormatter customDecimal = new YaxisValueFormatter("");
        XAxis xAxis = chart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setValueFormatter(customDecimal);
        // xAxis.setTextSize(10f);
        //xAxis.setTextColor(Color.RED);
        xAxis.setTextColor(Color.rgb(153, 153, 153));
        xAxis.setDrawAxisLine(false);
        xAxis.setTextSize(10f);
        xAxis.setDrawGridLines(false);
//        xAxis.setAxisMaximum(23);
//        xAxis.setAxisMinimum(1);
        xAxis.setGranularity(1);
        xAxis.setGranularityEnabled(true);
        //xAxis.draw
        xAxis.setLabelCount(12);

        chart.setOnChartGestureListener(new OnChartGestureListener() {
            @Override
            public void onChartGestureStart(MotionEvent me, ChartTouchListener.ChartGesture lastPerformedGesture) {
                tvStatus.setText("onChartGestureStart: "+ me.toString());
            }

            @Override
            public void onChartGestureEnd(MotionEvent me, ChartTouchListener.ChartGesture lastPerformedGesture) {
                tvStatus.setText("onChartGestureEnd: "+ me.toString());
            }

            @Override
            public void onChartLongPressed(MotionEvent me) {
                tvStatus.setText("onChartLongPressed: "+ me.toString());
            }

            @Override
            public void onChartDoubleTapped(MotionEvent me) {
                tvStatus.setText("onChartDoubleTapped: "+ me.toString());
            }

            @Override
            public void onChartSingleTapped(MotionEvent me) {
                tvStatus.setText("onChartSingleTapped: "+ me.toString());
            }

            @Override
            public void onChartFling(MotionEvent me1, MotionEvent me2, float velocityX, float velocityY) {
                tvStatus.setText("onChartFling: "+ "x: "+velocityX+" y: "+velocityY);
            }

            @Override
            public void onChartScale(MotionEvent me, float scaleX, float scaleY) {
                tvStatus.setText("onChartScale: "+ "x: "+scaleX+" y: "+scaleY);
            }

            @Override
            public void onChartTranslate(MotionEvent me, float dX, float dY) {
                tvStatus.setText("onChartTranslate: "+ "x: "+dX+" y: "+dY);
            }
        });

        mv = new XYaxisMarkerView(this, customDecimal);
        mv.setChartView(chart); // For bounds control
        chart.setMarker(mv); // Set the marker to the chart
    }
}
