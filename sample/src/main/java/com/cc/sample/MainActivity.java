package com.cc.sample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.cc.ninegridview.NineBaseAdapter;
import com.cc.ninegridview.NineGridView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView rvContent = (RecyclerView) findViewById(R.id.rv_content);
        ImageListAdapter adapter = new ImageListAdapter();
        rvContent.setLayoutManager(new LinearLayoutManager(this));
        rvContent.setAdapter(adapter);
    }
}
