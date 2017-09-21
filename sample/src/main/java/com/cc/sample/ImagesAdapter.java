package com.cc.sample;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.cc.ninegridview.NineBaseAdapter;
import com.squareup.picasso.Picasso;

/**
 * Created by chasonchen on 2017/8/3.
 */

public class ImagesAdapter implements NineBaseAdapter {
    String[] images = {
            "http://img2.imgtn.bdimg.com/it/u=2856186227,1546267997&fm=214&gp=0.jpg",
            "http://img2.imgtn.bdimg.com/it/u=836766427,2517598507&fm=26&gp=0.jpg",
            "http://img2.imgtn.bdimg.com/it/u=2856186227,1546267997&fm=214&gp=0.jpg",
            "http://img2.imgtn.bdimg.com/it/u=836766427,2517598507&fm=26&gp=0.jpg",
            "http://img2.imgtn.bdimg.com/it/u=2856186227,1546267997&fm=214&gp=0.jpg",
            "http://img2.imgtn.bdimg.com/it/u=836766427,2517598507&fm=26&gp=0.jpg",
            "http://img2.imgtn.bdimg.com/it/u=2856186227,1546267997&fm=214&gp=0.jpg",
            "http://img2.imgtn.bdimg.com/it/u=836766427,2517598507&fm=26&gp=0.jpg",
            "http://img2.imgtn.bdimg.com/it/u=2856186227,1546267997&fm=214&gp=0.jpg"
    };

    int imageCount;

    public ImagesAdapter(int imageCount) {
        this.imageCount = imageCount;
    }

    @Override
    public View getView(ViewGroup parent, int position) {
        ImageView child = new ImageView(parent.getContext());
        child.setScaleType(ImageView.ScaleType.CENTER_CROP);
        Picasso.with(parent.getContext())
                .load(images[position])
                .error(R.color.colorAccent)
                .into(child);
        return child;
    }

    @Override
    public int getItemCount() {
        return imageCount;
    }

    @Override
    public Object getItem() {
        return null;
    }

    @Override
    public int getItemPosition() {
        return 0;
    }
}
