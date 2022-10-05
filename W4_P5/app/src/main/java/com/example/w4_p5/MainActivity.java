package com.example.w4_p5;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.graphics.Color;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashSet;

import model.Hangman;

public class MainActivity extends AppCompatActivity {
    private Hangman hangman;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (hangman == null) {
            hangman = new Hangman(Hangman.DEFAULT_GUESSES);
        }
//        if(savedInstanceState !=null){
//            hangman.word =  savedInstanceState.getString("guessed");
//            hangman.guessedIndices=  savedInstanceState.getBooleanArray("word");
//            hangman.leftGuesses =  savedInstanceState.getInt("leftGuesses");
//            hangman.allowedGuesses =  savedInstanceState.getInt("allowed");
//        }
        setContentView(R.layout.activity_main);
        FragmentManager fragmentManager = getSupportFragmentManager();
        if (savedInstanceState == null) {
            fragmentManager.beginTransaction()
                    .setReorderingAllowed(true)
                    .add(R.id.fragmentKeyboard, Keyboard.class, null)
                    .add(R.id.fragmentState, State.class, null)
                    .commit();
        }

    }

    public Hangman getHangman() {
        return hangman;
    }

    public void play(View view) {
        Button clickedButton = (Button) view;
        char letter = clickedButton.getText().toString().charAt(0);
        int correct = hangman.guess(letter);
        render();
        if (correct == -1) {
            updateImage();
        }

        int result = hangman.gameOver();
        if (result != 0) {

            if (result == 1) {

                Toast toast = Toast.makeText(getBaseContext(), "YOU WIN!", Toast.LENGTH_LONG);
                toast.show();

            } else if (result == -1) {
                Toast toast = Toast.makeText(getBaseContext(), "YOU LOSE!", Toast.LENGTH_LONG);
                toast.show();

            }

            render();

        }

    }

    private Fragment recreateFragment(Fragment f) {
        try {


            Fragment newInstance = f.getClass().newInstance();


            return newInstance;
        } catch (Exception e) // InstantiationException, IllegalAccessException
        {
            throw new RuntimeException("Cannot reinstantiate fragment " + f.getClass().getName(), e);
        }
    }

    public void render() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        State state = (State) fragmentManager.findFragmentById(R.id.fragmentState);
        View stateView = state.getView();
        TextView word = stateView.findViewById(R.id.word);
        word.setText(hangman.currentIncompleteWord());

    }

    public void updateImage() {

        FragmentManager fragmentManager = getSupportFragmentManager();
        State state = (State) fragmentManager.findFragmentById(R.id.fragmentState);
        View stateView = state.getView();
        ImageView imageView = (ImageView) stateView.findViewById(R.id.hangmanPic);
        int leftGuesses = hangman.getLeftGuesses();
        switch (leftGuesses) {
            case 6:
                imageView.setImageResource(R.drawable.hangman0);
                break;
            case 5:
                imageView.setImageResource(R.drawable.hangman1);
                break;
            case 4:
                imageView.setImageResource(R.drawable.hangman2);
                break;
            case 3:
                imageView.setImageResource(R.drawable.hangman3);
                break;
            case 2:
                imageView.setImageResource(R.drawable.hangman4);
                break;
            case 1:
                imageView.setImageResource(R.drawable.hangman5);
                break;
            case 0:
                imageView.setImageResource(R.drawable.hangman6);
                stateView.setBackgroundColor(Color.RED);
                break;

        }

    }


    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putBooleanArray("GUESSED", hangman.guessedIndices);
        outState.putString("word", hangman.word);
        outState.putInt("leftGuesses",hangman.leftGuesses);
        outState.putInt("allowed",hangman.allowedGuesses);
        super.onSaveInstanceState(outState);




    }
}