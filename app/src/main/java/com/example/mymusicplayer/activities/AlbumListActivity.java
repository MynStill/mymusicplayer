package com.example.mymusicplayer.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.mymusicplayer.R;
import com.example.mymusicplayer.adapters.MusicListAdapter;

public class AlbumListActivity extends BaseActivity {

    private RecyclerView mRvList;
    private MusicListAdapter mMusicAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album_list);

        initView();
    }

    /**
     * 初始化View
     * */
    private void initView(){
        initNavBar(true, "专辑列表", false);

        mRvList = (RecyclerView) findViewById(R.id.rv_album_list);
        mRvList.setLayoutManager(new LinearLayoutManager(this));
        mRvList.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        mMusicAdapter = new MusicListAdapter(this, null);
        mRvList.setAdapter(mMusicAdapter);
    }
}
