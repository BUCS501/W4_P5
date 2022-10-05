package com.example.w4_p5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import model.Hangman;

public class MainActivity extends AppCompatActivity {
    private Hangman hangman;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (hangman == null) {
            hangman = new Hangman(Hangman.DEFAULT_GUESSES);
        }
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
        hangman.guess(letter);
        render();

        int result = hangman.gameOver();
        if( result !=0){

            if(result ==1){
                Toast toast = Toast.makeText(getBaseContext(), "YOU WIN!", Toast.LENGTH_LONG);
                toast.show();

            }else if(result == -1){
                Toast toast = Toast.makeText(getBaseContext(), "YOU LOSE!", Toast.LENGTH_LONG);
                toast.show();

            }
            hangman.reset();
            render();
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction ft = fragmentManager.beginTransaction();
            Fragment state = fragmentManager.findFragmentById(R.id.fragmentState);
            ft.remove(state);
            Fragment newInstance = recreateFragment(state);
            ft.add(R.id.fragmentState, newInstance);
            ft.commit();

        }

    }

    private Fragment recreateFragment(Fragment f)
    {
        try {


            Fragment newInstance = f.getClass().newInstance();


            return newInstance;
        }
        catch (Exception e) // InstantiationException, IllegalAccessException
        {
            throw new RuntimeException("Cannot reinstantiate fragment " + f.getClass().getName(), e);
        }
    }

    public void render(){
        FragmentManager fragmentManager = getSupportFragmentManager();
        State state = (State) fragmentManager.findFragmentById(R.id.fragmentState);
        View stateView = state.getView();
        TextView word = stateView.findViewById(R.id.word);
        word.setText(hangman.currentIncompleteWord());

    }
}