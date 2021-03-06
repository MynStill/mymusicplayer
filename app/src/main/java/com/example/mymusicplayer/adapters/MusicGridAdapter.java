package com.example.mymusicplayer.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.mymusicplayer.R;
import com.example.mymusicplayer.activities.AlbumListActivity;

public class MusicGridAdapter extends RecyclerView.Adapter<MusicGridAdapter.ViewHolder> {

    private Context mContext;

    public MusicGridAdapter(Context context){
        mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder( ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_grid, viewGroup, false));
    }

    @Override
    public void onBindViewHolder( ViewHolder viewHolder, int i) {
        Glide.with(mContext)
                .load("http://res.lgdsunday.club/poster-1.png")
                .into(viewHolder.ivIcon);

        viewHolder.albumView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, AlbumListActivity.class);
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return 6;
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        ImageView ivIcon;
        View albumView;

        public ViewHolder( View itemView) {
            super(itemView);

            albumView = itemView;
            ivIcon = (ImageView) itemView.findViewById(R.id.iv_icon);
        }
    }
}
