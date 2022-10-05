package com.example.w4_p5;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import model.Hangman;


public class Keyboard extends Fragment implements View.OnClickListener {


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private String mParam1;
    private String mParam2;

    //Do not touch the constructor
    public Keyboard() {
    }


    public static Keyboard newInstance(String param1, String param2) {
        Keyboard fragment = new Keyboard();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_keyboard, container, false);
    }

    @Override
    public void onClick(View v) {
        v.setVisibility(View.INVISIBLE);
        MainActivity activity = (MainActivity) getActivity();
        activity.play(v);

//        switch (v.getId()) {
//            case R.id.buttonA:
//                break;
//            case R.id.buttonB:
//                break;
//            case R.id.buttonC:
//                break;
//            case R.id.buttonD:
//                break;
//            case R.id.buttonE:
//                break;
//            case R.id.buttonF:
//                break;
//            case R.id.buttonG:
//                break;
//            case R.id.buttonH:
//                break;
//            case R.id.buttonI:
//                break;
//            case R.id.buttonJ:
//                break;
//            case R.id.buttonK:
//                break;
//            case R.id.buttonL:
//                break;
//            case R.id.buttonM:
//                break;
//            case R.id.buttonN:
//                break;
//            case R.id.buttonO:
//                break;
//            case R.id.buttonP:
//                break;
//            case R.id.buttonQ:
//                break;
//            case R.id.buttonR:
//                break;
//            case R.id.buttonS:
//                break;
//            case R.id.buttonT:
//                break;
//            case R.id.buttonU:
//                break;
//            case R.id.buttonV:
//                break;
//            case R.id.buttonW:
//                break;
//            case R.id.buttonX:
//                break;
//            case R.id.buttonY:
//                break;
//            case R.id.buttonZ:
//                break;
//        }


    }

    @Override
    public void onStart() {
        super.onStart();
        View fragmentView = getView();

        Button aButton = (Button) fragmentView.findViewById(R.id.buttonA);
        aButton.setOnClickListener(this);
        Button bButton = (Button) fragmentView.findViewById(R.id.buttonB);
        bButton.setOnClickListener(this);
        Button cButton = (Button) fragmentView.findViewById(R.id.buttonC);
        cButton.setOnClickListener(this);
        Button dButton = (Button) fragmentView.findViewById(R.id.buttonD);
        dButton.setOnClickListener(this);
        Button eButton = (Button) fragmentView.findViewById(R.id.buttonE);
        eButton.setOnClickListener(this);
        Button fButton = (Button) fragmentView.findViewById(R.id.buttonF);
        fButton.setOnClickListener(this);
        Button gButton = (Button) fragmentView.findViewById(R.id.buttonG);
        gButton.setOnClickListener(this);
        Button hButton = (Button) fragmentView.findViewById(R.id.buttonH);
        hButton.setOnClickListener(this);
        Button iButton = (Button) fragmentView.findViewById(R.id.buttonI);
        iButton.setOnClickListener(this);
        Button jButton = (Button) fragmentView.findViewById(R.id.buttonJ);
        jButton.setOnClickListener(this);
        Button kButton = (Button) fragmentView.findViewById(R.id.buttonK);
        kButton.setOnClickListener(this);
        Button lButton = (Button) fragmentView.findViewById(R.id.buttonL);
        lButton.setOnClickListener(this);
        Button mButton = (Button) fragmentView.findViewById(R.id.buttonM);
        mButton.setOnClickListener(this);
        Button nButton = (Button) fragmentView.findViewById(R.id.buttonN);
        nButton.setOnClickListener(this);
        Button oButton = (Button) fragmentView.findViewById(R.id.buttonO);
        oButton.setOnClickListener(this);
        Button pButton = (Button) fragmentView.findViewById(R.id.buttonP);
        pButton.setOnClickListener(this);
        Button qButton = (Button) fragmentView.findViewById(R.id.buttonQ);
        qButton.setOnClickListener(this);
        Button rButton = (Button) fragmentView.findViewById(R.id.buttonR);
        rButton.setOnClickListener(this);
        Button sButton = (Button) fragmentView.findViewById(R.id.buttonS);
        sButton.setOnClickListener(this);
        Button tButton = (Button) fragmentView.findViewById(R.id.buttonT);
        tButton.setOnClickListener(this);
        Button uButton = (Button) fragmentView.findViewById(R.id.buttonU);
        uButton.setOnClickListener(this);
        Button vButton = (Button) fragmentView.findViewById(R.id.buttonV);
        vButton.setOnClickListener(this);
        Button wButton = (Button) fragmentView.findViewById(R.id.buttonW);
        wButton.setOnClickListener(this);
        Button xButton = (Button) fragmentView.findViewById(R.id.buttonX);
        xButton.setOnClickListener(this);
        Button yButton = (Button) fragmentView.findViewById(R.id.buttonY);
        yButton.setOnClickListener(this);
        Button zButton = (Button) fragmentView.findViewById(R.id.buttonZ);
        zButton.setOnClickListener(this);



    }
}