package com.cc.ninegridview;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;

/**
 * Created by chasonchen on 2017/7/18.
 */

public class NineGridView extends FrameLayout {

    private NineBaseAdapter mAdapter;

    public NineGridView(Context context) {
        super(context);
        init(context, null, -1);
    }

    public NineGridView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs, -1);
    }

    public NineGridView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr);
    }

    int width, height;
    int itemSize = 0;
    int gap = 0;
    int paddingLeft, paddingTop, paddingRight, paddingBottom;

    int itemCount = 0;
    int rowCount = 1;

    private void init(Context context, AttributeSet attrs, int defStyleAttr) {
        paddingBottom = getPaddingBottom();
        paddingTop = getPaddingTop();
        paddingLeft = getPaddingLeft();
        paddingRight = getPaddingRight();

        if (null != attrs) {
            TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.NineGridView);
            gap = (int) typedArray.getDimension(R.styleable.NineGridView_gap, 0);
            typedArray.recycle();
        }

    }

    public void setAdapter(NineBaseAdapter adapter) {
        removeAllViews();
        mAdapter = adapter;
        itemCount = adapter.getItemCount();

        for (int i = 0; i < itemCount; i++) {
            View child = mAdapter.getView(this, i);
            addView(child, itemSize, itemSize);
        }

        requestLayout();
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        if (null == mAdapter) return;

        int rowIndex = -1;
        int colIndex;
        for (int i = 0; i < itemCount; i++) {
            View child = getChildAt(i);
            colIndex = i % rowCount;
            if (colIndex == 0) {
                rowIndex++;
            }

            int left = colIndex * itemSize+gap*colIndex;
            int right = (colIndex + 1) * itemSize + gap *colIndex;

            int top = rowIndex * itemSize + gap *rowIndex;
            int bottom = (rowIndex + 1) * itemSize+gap * rowIndex;

            child.layout(left, top, right, bottom);
        }

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        width = getMeasuredWidth();
        height = getMeasuredHeight();

        if (null == mAdapter) return;

        if (itemCount < 2) {
            rowCount = 1;
        } else if (itemCount < 5) {
            rowCount = 2;
        } else {
            rowCount = 3;
        }
        int colCount = (itemCount - 1) / rowCount;
        itemSize = (width - (rowCount - 1) * gap) / rowCount;

        height = itemSize*(colCount+1) + gap*colCount;
        setMeasuredDimension(width, height);
    }


}
