package com.akioss.swippagedemo;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    
    private static String TAG = "SwipeDemo";

    private List<Map<String, String>> datas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        StatusBarUtils.setColorNoTranslucent(this, getResources().getColor(R.color.colorAccent));

        initData();

        ViewPager mViewPager = (ViewPager) findViewById(R.id.viewPager);
        assert mViewPager != null;
        mViewPager.setAdapter(new SwipAdapter(getSupportFragmentManager(), datas));
        mViewPager.setPageTransformer(true, new SwipeTransformer());
    }

    private void initData() {
        datas = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Map<String, String> data = new HashMap<>();
            data.put("title", "BARATO");
            data.put("desc", "BAROLO DI CASTIGLION FALLETTO");
            datas.add(data);
        }
    }
}
