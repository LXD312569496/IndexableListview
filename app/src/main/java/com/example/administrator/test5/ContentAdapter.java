package com.example.administrator.test5;

import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.SectionIndexer;

import java.util.List;

/**
 * Created by Administrator on 2016/9/23.
 */

public class ContentAdapter extends ArrayAdapter<String> implements SectionIndexer{



    private String mSection="#ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public ContentAdapter(Context context, int resource, List<String> objects) {
        super(context, resource, objects);
    }

    @Override
    public Object[] getSections() {
        String[] sections=new String[mSection.length()];

        //将每个Section作为单个数组元素放到section中
        for (int i = 0; i <mSection.length() ; i++) {
            sections[i]=String.valueOf(mSection.charAt(i));
        }

        return sections;
    }

    @Override
    public int getPositionForSection(int sectionIndex) {

        //从当前的section往前查，直到遇到第一个有对应item为止，否则不进行定位
        for (int i = sectionIndex; i >=0 ; i--) {
            for (int j = 0; j <getCount() ; j++) {

                if (i==0){
                    //查询数字
                    for (int k = 0; k <=9 ; k++) {
                        if (StringMatcher.match(String.valueOf(getItem(j).charAt(0)),
                                String.valueOf(k))){
                            return j;
                        }
                    }

                }
                else {
                    //查询字母
                    if (StringMatcher.match(String.valueOf(getItem(j).charAt(0)),
                            String.valueOf(mSection.charAt(i))))
                    {
                        return j;
                    }

                }
            }
        }


        return 0;
    }

    @Override
    public int getSectionForPosition(int position) {
        return 0;
    }
}
