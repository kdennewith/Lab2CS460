package com.example.swipevideoapp;

import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.VideoViewHolder>{

    private List<VideoItem> videoItems;

    public VideoAdapter(List<VideoItem> videoItems){
        this.videoItems = videoItems;
    }

    @NonNull
    @Override
    public VideoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new VideoViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(R.layout.iterm_container_video,parent,false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull VideoViewHolder holder, int position) {
        holder.setVideoData(videoItems.get(position));
    }

    @Override
    public int getItemCount() {
        return videoItems.size();
    }

    static class VideoViewHolder extends RecyclerView.ViewHolder {

        TextView vidTitleA, vidDescriptionA;

        VideoView videoView;

        ProgressBar progressBar;

        /**
         * A Constructor method that takes in a View object and assigns variables from VideoItem Class
         * to new variables as 'Holders' to create a VideoViewHolder Object
         * @param itemView a View object, your video(s) to be held.
         */
        public VideoViewHolder(@NonNull View itemView) {
            super(itemView);
            videoView = itemView.findViewById(R.id.videoView);
            vidTitleA = itemView.findViewById(R.id.vidTitle);
            vidDescriptionA = itemView.findViewById(R.id.vidDescription);
            progressBar = itemView.findViewById(R.id.videoProgressBar);
        }

        void setVideoData(VideoItem videoItem){
            vidTitleA.setText(videoItem.vidTitle);
            vidDescriptionA.setText(videoItem.vidDescription);
            videoView.setVideoPath(videoItem.vidURL);

            videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mediaPlayer) {
                    progressBar.setVisibility(View.GONE);
                    mediaPlayer.start();

                    float videoRatio = mediaPlayer.getVideoWidth() / (float) mediaPlayer.getVideoHeight();
                    float screenRatio = videoView.getWidth() / (float) videoView.getHeight();

                    float scale = videoRatio / screenRatio;
                    if(scale >= 1f){
                        videoView.setScaleX(scale);
                    }else{
                        videoView.setScaleY(1f/ scale);
                    }
                }

            });

            videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mediaPlayer) {
                    mediaPlayer.start();
                }
            });

        }

    }

}
