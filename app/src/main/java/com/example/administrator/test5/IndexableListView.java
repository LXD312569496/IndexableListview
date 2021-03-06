package com.example.administrator.test5;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.ListAdapter;
import android.widget.ListView;

/**
 * Created by Administrator on 2016/9/23.
 */

//封装了右侧的索引条
public class IndexableListView extends ListView {
    public IndexableListView(Context context) {
        super(context);
    }

    public IndexableListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public IndexableListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    private boolean mIsFastScrollEnabled = false;
    private IndexScroller mScroller = null;//负责绘制索引条
    private GestureDetector mGestureDetector = null;


    public boolean ifFastScrollEnabled() {
        return mIsFastScrollEnabled;
    }


    @Override
    public void setFastScrollEnabled(boolean enabled) {
        mIsFastScrollEnabled = enabled;
        //如果允许快速滚动
        if (mIsFastScrollEnabled) {
            if (mScroller == null) {
                //创建IndexScroller对象
                mScroller = new IndexScroller(getContext(), this);
            }
        } else {
            if (mScroller != null) {
                mScroller.hide();
                mScroller = null;
            }
        }

    }

    //用于绘制右侧的索引条
    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);

        if (mScroller != null) {
            mScroller.draw(canvas);
        }


    }


    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        //如果mScroller自己来处理触摸事件，该方法返回真
        if (mScroller != null && mScroller.onTouchEvent(ev)) {
            return true;
        }
        if (mGestureDetector == null) {
            //使用手势处理触摸事件
            mGestureDetector = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener() {
                @Override
                public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
                    mScroller.show();
                    return super.onFling(e1, e2, velocityX, velocityY);
                }
            });


        }

        mGestureDetector.onTouchEvent(ev);
        return super.onTouchEvent(ev);

    }


    @Override
    public void setAdapter(ListAdapter adapter) {
        super.setAdapter(adapter);
        if (mScroller!=null){
            mScroller.setAdapter(adapter);
        }
    }


    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        if (mScroller!=null){
            mScroller.onSizeChanged(w,h,oldw,oldh);
        }

    }
}
