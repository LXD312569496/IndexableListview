package com.example.administrator.test5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {


    private ArrayList<String> mItems;
    private IndexableListView mListView;

    private ContentAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
         * 1.初始化items
         * 2.根据section获取position
         */

        mItems=new ArrayList<>();
        mItems.add("12345");
        mItems.add("A 测试");
        mItems.add("B 测试");
        mItems.add("C 测试");
        mItems.add("D 测试");
        mItems.add("E 测试");
        mItems.add("F 测试");
        mItems.add("G 测试");
        mItems.add("H 测试");
        mItems.add("I 测试");
        mItems.add("J 测试");
        mItems.add("K 测试");
        mItems.add("L 测试");
        mItems.add("M 测试");
        mItems.add("N 测试");
        mItems.add("O 测试");
        mItems.add("P 测试");
        mItems.add("Q 测试");
        mItems.add("R 测试");
        mItems.add("S 测试");
        mItems.add("T 测试");
        mItems.add("U 测试");
        mItems.add("V 测试");
        mItems.add("W 测试");
        mItems.add("X 测试");
        mItems.add("Y 测试");
        mItems.add("Z 测试");

        //排序
        Collections.sort(mItems);

        //可以直接使用ArrayAdapter
        //利用android提供的接口SectionIndexer
        adapter=new ContentAdapter(this,android.R.layout.simple_list_item_1,mItems);

        mListView=(IndexableListView)findViewById(R.id.listview);
        mListView.setAdapter(adapter);
        mListView.setFastScrollEnabled(true);



    }


}
