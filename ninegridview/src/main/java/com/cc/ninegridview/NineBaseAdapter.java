package com.cc.ninegridview;

import android.support.annotation.IntRange;
import android.support.annotation.Size;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by chasonchen on 2017/7/18.
 */

public interface NineBaseAdapter {

    View getView(ViewGroup parent, int position);

    @IntRange(from = 0,to = 9) int getItemCount();

    Object getItem();

    int getItemPosition();
}
