package com.example.mymusicplayer.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.example.mymusicplayer.R;
import com.example.mymusicplayer.activities.PlayMusicActivity;

public class MusicListAdapter extends RecyclerView.Adapter<MusicListAdapter.ViewHolder> {

    private Context mContext;
    private View mItemView;
    private RecyclerView mRv;
    private boolean isCalcaulationRvHeight;

    public MusicListAdapter(Context context, RecyclerView recyclerView){
        mContext = context;
        mRv = recyclerView;
    }

    @Override
    public ViewHolder onCreateViewHolder( ViewGroup viewGroup, int i) {
        mItemView = LayoutInflater.from(mContext).inflate(R.layout.item_list_music, viewGroup, false);
        return new ViewHolder(mItemView);
    }

    @Override
    public void onBindViewHolder( ViewHolder viewHolder, int i) {
        setRecyclerViewHeight();

        Glide.with(mContext)
                .load("http://res.lgdsunday.club/poster-1.png")
                .into(viewHolder.ivIcon);

        //点击进入音乐播放界面
        viewHolder.musicItemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, PlayMusicActivity.class);
                mContext.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return 8;
    }

    /**
     * 当RecyclerView和SrcollView一起使用的时候，就需要计算RecyclerView的高度
     * 1、获取itemView的高度
     * 2、获取itemView的数量
     * 3、使用itemViewHeight * itemViewNum = recyclerViewHeight
     * */
    private void setRecyclerViewHeight(){
        //只计算一次
        if(isCalcaulationRvHeight || mRv == null) return;

        isCalcaulationRvHeight = true;

        //获取itemView的高度
        RecyclerView.LayoutParams itemViewLp = (RecyclerView.LayoutParams) mItemView.getLayoutParams();
        //获取itemView的数量
        int itemCount = getItemCount();
        //获取recyclerView的高度recyclerViewHeight
        int recyclerViewHeight = itemViewLp.height * itemCount;

        LinearLayout.LayoutParams rvLp = (LinearLayout.LayoutParams) mRv.getLayoutParams();
        rvLp.height = recyclerViewHeight;
        mRv.setLayoutParams(rvLp);
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        View musicItemView;
        ImageView ivIcon;

        public ViewHolder(View itemView) {
            super(itemView);

            musicItemView = itemView;
            ivIcon = (ImageView) itemView.findViewById(R.id.iv_icon);
        }
    }
}
