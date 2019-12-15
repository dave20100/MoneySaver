package com.example.moneysaver;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GraphActivity extends AppCompatActivity {

    HashMap<String, Integer> categoriesSum;
    HashMap<String, Integer> typesSum;

    Set<String> keysCategories;

    Set<String> keysTypes;

    List<PieEntry> categoryEntries;
    List<PieEntry> typesEntries;


    PieChart chart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph);

        categoriesSum = new HashMap<>();
        typesSum = new HashMap<>();

        new Thread(new Runnable() {
            @Override
            public void run() {
                PaymentDatabase db = Room.databaseBuilder(getApplicationContext(),
                        PaymentDatabase.class, "payment-database").build();
                for (PaymentHistory pH: db.paymentDao().getAll()) {
                    if(categoriesSum.containsKey(pH.category)) {
                        categoriesSum.put(pH.category, categoriesSum.get(pH.category) + pH.price);
                    }
                    else {
                        categoriesSum.put(pH.category, pH.price);
                    }
                    if(typesSum.containsKey(pH.type)) {
                        typesSum.put(pH.type, typesSum.get(pH.type) + pH.price);
                    }
                    else {
                        typesSum.put(pH.type, pH.price);
                    }
                }


                chart = findViewById(R.id.chart);

                categoryEntries = new ArrayList<>();

                typesEntries = new ArrayList<>();

                keysCategories = categoriesSum.keySet();

                keysTypes = typesSum.keySet();

                for (String key: keysCategories) {
                    categoryEntries.add(new PieEntry(categoriesSum.get(key), key));
                }

                for(String key: keysTypes) {
                    typesEntries.add(new PieEntry(typesSum.get(key), key));
                }

                PieDataSet set = new PieDataSet(categoryEntries, "");

                final int[] MY_COLORS = {Color.rgb(120,0,0), Color.rgb(0,120,0), Color.rgb(0,0,120),
                        Color.rgb(120,120, 0), Color.rgb(0,120,120), Color.rgb(120,0,120), Color.rgb(120,120,120)};
                ArrayList<Integer> colors = new ArrayList<>();

                for(int c: MY_COLORS) colors.add(c);

                set.setColors(colors);

                PieData data = new PieData(set);
                chart.setData(data);
                chart.invalidate(); // refresh
            }
        }).start();


    }

    public void changeToTypeGraph(View view)
    {
        PieDataSet set = new PieDataSet(typesEntries, "");

        final int[] MY_COLORS = {Color.rgb(120,0,0), Color.rgb(0,120,0), Color.rgb(0,0,120),
                Color.rgb(120,120, 0), Color.rgb(0,120,120), Color.rgb(120,0,120), Color.rgb(120,120,120)};
        ArrayList<Integer> colors = new ArrayList<>();

        for(int c: MY_COLORS) colors.add(c);

        set.setColors(colors);

        PieData data = new PieData(set);
        chart.setData(data);
        chart.invalidate(); // refresh
    }

    public void changeToCategoryGraph(View view)
    {
        PieDataSet set = new PieDataSet(categoryEntries, "");

        final int[] MY_COLORS = {Color.rgb(120,0,0), Color.rgb(0,120,0), Color.rgb(0,0,120),
                Color.rgb(120,120, 0), Color.rgb(0,120,120), Color.rgb(120,0,120), Color.rgb(120,120,120)};
        ArrayList<Integer> colors = new ArrayList<>();

        for(int c: MY_COLORS) colors.add(c);

        set.setColors(colors);

        PieData data = new PieData(set);
        chart.setData(data);
        chart.invalidate(); // refresh
    }
}
