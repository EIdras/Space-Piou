package com.example.android_project;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class GameActivity extends AppCompatActivity {

    private GameView gameView;
    private FrameLayout gameLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        prepareGame();
        setContentView(gameLayout);
        gameView.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        gameView.pause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        gameView.resume();
    }

    public GameView getGameView() {
        return gameView;
    }

    private void prepareGame(){
        gameLayout = new FrameLayout(this);
        gameView = new GameView(this);
        gameLayout.addView(gameView);
    }

    void endGame(int score){
        Intent intent = new Intent(getApplicationContext(), GameEnd.class);
        intent.putExtra("score",score);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {

    }
}
