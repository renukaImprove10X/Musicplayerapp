package com.example.musicplayerapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.SeekBar;

import com.example.musicplayerapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private MediaPlayer mediaPlayer;

    private MainViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Initialize MediaPlayer
        mediaPlayer = MediaPlayer.create(this, R.raw.sample_track);
        viewModel = new ViewModelProvider(this).get(MainViewModel.class);
        viewModel.setMediaPlayer(mediaPlayer);
        viewModel.title.postValue("Oh Baby");
        viewModel.artist.postValue("Renuka");
        viewModel.albumCoverImageUrl.postValue("https://c.saavncdn.com/461/Oh-Baby-Samantha-Hits-Telugu-2019-20190617192201-500x500.jpg");

        // Set up SeekBar
        binding.progressBar.setMax(mediaPlayer.getDuration());
        binding.progressBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (fromUser) {
                    mediaPlayer.seekTo(progress);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // Pause the music when user starts seeking
                mediaPlayer.pause();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // Resume the music when user stops seeking
                mediaPlayer.start();
            }
        });

        // Set up DataBinding
        binding.setLifecycleOwner(this);
        binding.setViewModel(viewModel);
    }
}

