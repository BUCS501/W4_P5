package com.example.w4_p5;

import androidx.appcompat.app.AppCompatActivity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;

import model.Hangman;

public class MainActivity extends AppCompatActivity {
    private Hangman hangman;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(hangman == null){
            hangman = new Hangman(Hangman.DEFAULT_GUESSES);
        }
        setContentView(R.layout.activity_main);
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction( );
    }
}