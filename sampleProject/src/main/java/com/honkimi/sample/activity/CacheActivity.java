package com.honkimi.sample.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.honkimi.bootroid.pref.ObjectStorage;
import com.honkimi.sample.R;

import java.util.ArrayList;

/**
 * Created by honkimi on 14/11/28.
 */
public class CacheActivity extends DetailActivity {
    private static final String CACHE_KEY = "cache";

    private static class Sample {
        public int id;
        public String name;
        private Sample(int id, String name) {
            this.id = id;
            this.name = name;
        }
    }

    private ArrayList<Sample> samples = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cache);

        samples.add(new Sample(1, "one"));
        samples.add(new Sample(2, "two"));
        samples.add(new Sample(3, "three"));

        setListeners();
    }

    private void setListeners() {
        findViewById(R.id.saveCache).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ObjectStorage.save(samples, CACHE_KEY);
            }
        });

        findViewById(R.id.removeCache).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ObjectStorage.remove(CACHE_KEY);
            }
        });

        findViewById(R.id.showCache).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Sample[] cache = ObjectStorage.get(CACHE_KEY, Sample[].class);
                String txt = "";
                if (cache != null) {
                    for (Sample sample : cache) {
                        txt += "id: " + sample.id + ", name: " + sample.name + "\n";
                    }
                }
                Toast.makeText(CacheActivity.this, txt, Toast.LENGTH_LONG).show();
            }
        });
    }
}
