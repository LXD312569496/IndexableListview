package com.example.administrator.test5;

/**
 * Created by Administrator on 2016/9/23.
 */

public class StringMatcher {

    /**
     *
     * @param value  listview中每一项item的文本
     * @param keyword   索引条的字符文本
     * @return
     */
    public static boolean match(String value,String keyword){
        //value和keyword都不能为空
        if (value==null||keyword==null){
            return false;
        }
        if (keyword.length()>value.length()){
            return false;
        }

        //进行匹配,i是value的指针，j是keyword的指针
        int i=0,j=0;

        do{
            if (keyword.charAt(j)==value.charAt(i)){
                i++;
                j++;
            }else if (j>0){
                break;
            }else {
                i++;
            }


        }while (i<value.length()&&j<keyword.length());

        return (j==keyword.length()?true:false);
    }

}
