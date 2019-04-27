package com.example.mymusicplayer.views;

import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

public class GridSpaceItemDecoration extends RecyclerView.ItemDecoration {

    private int mSpace;

    public GridSpaceItemDecoration(int space) {
        mSpace = space;
    }

    @Override
    public void getItemOffsets( Rect outRect,  View view,  RecyclerView parent,  RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);

        //让每一个Item与左边偏移mSpace的距离
        outRect.left = mSpace;

        //判断每个item是不是每行的第一个item
        /*if(parent.getChildLayoutPosition(view) % 3 == 0){
            outRect.left = 0;
        }*/

        //View margin
        //margin 为 正，   则View 会距离边界产生一个距离
        //margin 为 负，   则View 会超出边界产生一个距离

        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) parent.getLayoutParams();
        layoutParams.leftMargin = -mSpace;
        parent.setLayoutParams(layoutParams);
    }
}
