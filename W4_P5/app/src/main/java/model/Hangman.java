package model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class Hangman {
    public static int DEFAULT_GUESSES = 6;
    private String[] wordlist = {"CREEK", "CLOCK", "FIND", "JAIL", "BAR", "ACTION"};
    private String word;
    private boolean[] guessedIndices;
    private int allowedGuesses;
    private int leftGuesses;
    private HashSet<Character> usedLetters;

    public Hangman(int numGuesses) {
        if (numGuesses > 0) allowedGuesses = numGuesses;
        else allowedGuesses = DEFAULT_GUESSES;
        leftGuesses = allowedGuesses;
        Random random = new Random();
        word = wordlist[random.nextInt(wordlist.length)];
        guessedIndices = new boolean[word.length()];
        usedLetters = new HashSet<>();

    }

    public int getAllowedGuesses() {
        return allowedGuesses;
    }

    public int getLeftGuesses() {
        return leftGuesses;
    }

    public void guess(char c) {
        boolean correct = false;
        if (usedLetters.contains(c)){
            return;
        }else{
            usedLetters.add(c);
        }
        for (int i = 0; i< word.length();i++){
            if(!guessedIndices[i]&& c == word.charAt(i)){
                guessedIndices[i]= true;
                correct =true;
            }
        }
        if(!correct) leftGuesses--;

    }

    public String currentIncompleteWord(){
        String guess = "";
        for(int i =0 ; i< word.length();i++){
            if (guessedIndices[i]){
                guess += word.charAt(i) + " ";
            }
            else{
                guess += "_ ";
            }
        }
        return guess;
    }


    public int gameOver(){
        boolean won = true;

        for(int i = 0;i<guessedIndices.length;i++){
            if(!guessedIndices[i] ){
                won= false;
                break;
            }
        }

        if(won) return 1;
        else if(leftGuesses == 0) return -1;
        else return 0;
    }


    public void reset(){
        leftGuesses = allowedGuesses;
        Random random = new Random();
        word = wordlist[random.nextInt(wordlist.length)];
        guessedIndices = new boolean[word.length()];
        usedLetters = new HashSet<>();

    }




}
