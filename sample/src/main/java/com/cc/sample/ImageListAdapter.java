package com.cc.sample;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cc.ninegridview.NineBaseAdapter;
import com.cc.ninegridview.NineGridView;

import java.util.Random;

/**
 * Created by chasonchen on 2017/8/10.
 */

public class ImageListAdapter extends RecyclerView.Adapter {
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ItemHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view,parent,false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ItemHolder itemHolder = (ItemHolder) holder;
        itemHolder.setAdapter();
    }

    @Override
    public int getItemCount() {
        return 15;
    }

    private class ItemHolder extends RecyclerView.ViewHolder{

        NineGridView ngvImages;
        Random random = new Random();

        public ItemHolder(View itemView) {
            super(itemView);
            ngvImages = (NineGridView) itemView.findViewById(R.id.ngv_images);

        }

        public void setAdapter(){
            NineBaseAdapter adapter = new ImagesAdapter(random.nextInt(8)+1);
            ngvImages.setAdapter(adapter);
        }
    }
}
