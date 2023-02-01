package com.example.musicplayerapp;

import android.media.MediaPlayer;
import android.view.View;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {
    public MediaPlayer mediaPlayer;
    public MutableLiveData<String> title = new MutableLiveData<>();
    public MutableLiveData<String> artist = new MutableLiveData<>();
    public MutableLiveData<String> albumCoverImageUrl = new MutableLiveData<>();

    public void setMediaPlayer(MediaPlayer mediaPlayer) {
        this.mediaPlayer = mediaPlayer;
    }

    // Play the music
    public void playMusic(View view) {
        mediaPlayer.start();
    }

    // Pause the music
    public void pauseMusic(View view) {
        mediaPlayer.pause();
    }

    // Skip to the next track
    public void skipTrack(View view) {
        // Code to skip to the next track
    }

    // Repeat the current track
    public void repeatTrack(View view) {
        // Code to repeat the current track
    }
}
