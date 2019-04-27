package com.example.mymusicplayer.activities;

import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import com.bumptech.glide.request.RequestOptions;
import com.example.mymusicplayer.R;

import java.io.IOException;
import java.net.URL;

import jp.wasabeef.glide.transformations.BlurTransformation;

public class PlayMusicActivity extends AppCompatActivity {

    private ImageView mIvBg, mIvPlay;
    private boolean isPlaying;

    private MediaPlayer mMediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //隐藏statusbar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_play_music);

        initView();
    }

    private void initView(){

        //实现背景图片的高斯模糊   Glide-transformations
        mIvBg = (ImageView) findViewById(R.id.iv_bg);
        Glide.with(this)
                .load("http://res.lgdsunday.club/poster-1.png")
                .apply(RequestOptions.bitmapTransform(new BlurTransformation(25, 10)))
                .into(mIvBg);

        mIvPlay = (ImageView) findViewById(R.id.iv_play_music);
        mMediaPlayer = new MediaPlayer();
        try{
            mMediaPlayer.setDataSource(this, Uri.parse("http://res.lgdsunday.club/Nostalgic%20Piano.mp3"));
            mMediaPlayer.prepare();
        }catch (IOException e){
            e.printStackTrace();
        }

        playMusic();

    }

    /**
     * 后退点击事件
     * */
    public void onBackClick(View v) {
        onBackPressed();
    }

    /**
     * 播放或暂停音乐点击事件
     * */
    public void onPlayOrPauseMusicClick(View v) {
        if(isPlaying) {
            //正在播放 则停止
            pausePlayMusic();
        } else{
            //停止中 则播放
            playMusic();
        }
    }

    /**
     * 播放音乐 把图片换成暂停
     * */
    private void playMusic() {
        isPlaying = true;
        mIvPlay.setImageResource(R.mipmap.pause_music_white_img);
        if(!mMediaPlayer.isPlaying()){
            mMediaPlayer.start();
        }
        Toast.makeText(PlayMusicActivity.this, "正在播放音乐", Toast.LENGTH_SHORT).show();
    }

    /**
     * 暂停播放音乐 把图片换成播放
     * */
    private void pausePlayMusic() {
        isPlaying = false;
        mIvPlay.setImageResource(R.mipmap.play_music_white_img);
        if(mMediaPlayer.isPlaying()){
            mMediaPlayer.pause();
        }
        Toast.makeText(PlayMusicActivity.this, "暂停播放音乐", Toast.LENGTH_SHORT).show();
    }

    /**
     * 停止播放音乐
     * */
    public void onStopPlayMusicClick(View v) {
        isPlaying = false;
        mIvPlay.setImageResource(R.mipmap.play_music_white_img);
        if(mMediaPlayer.isPlaying()){
            mMediaPlayer.reset();
        }
        Toast.makeText(PlayMusicActivity.this, "停止播放音乐", Toast.LENGTH_SHORT).show();
    }
}
