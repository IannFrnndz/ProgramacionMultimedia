package com.example.calculadora_ian;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;


public class ToolbarFragment extends Fragment implements SeekBar.OnSeekBarChangeListener{

    private int seek_value_ = 0 ;

    public ToolbarFragment(){}



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_toolbar,container,false);
        SeekBar bar = view.findViewById(R.id.seekBar);
        bar.setOnSeekBarChangeListener(this);
        Button button = view.findViewById(R.id.FragmentButton);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                ButtonClicked(view);
            }
        });
        return view;
    }

    public void ButtonClicked(View view){
        activity_callback_.onButtonClick(seek_value_);
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        seek_value_ = progress;
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar){}

    @Override
    public void onStopTrackingTouch(SeekBar seekBar){}

    // prepara un listener, esto va a permitir que el fragmento llame a la actividad cuando el boton se llame

    public interface ToolbarFragmentListener{
        public void onButtonClick(int value);
    }

    ToolbarFragmentListener activity_callback_;

    @Override
    public void onAttach(@NonNull @org.jetbrains.annotations.NotNull Context context){
        super.onAttach(context);
        try{
            activity_callback_ = (ToolbarFragmentListener)  context;

        }catch (ClassCastException e){
            throw new ClassCastException(context.toString() + "must implement ToolbarFragmentListener or it wont work");

        }
    }


   /* private EditText editText;

    public interface ToolbarListener{
        public void onButtonClick(int size, String text);
    }

    ToolbarListener activityCallback;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_toolbar, container, false);


        editText = v.findViewById(R.id.FragmentEditText);

        SeekBar seekBar = v.findViewById(R.id.seekBar);

        seekBar.setOnSeekBarChangeListener(this);

        Button button = v.findViewById(R.id.FragmentButton);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ButtonClicked(v);
            }
        });
        return v;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        try {
            activityCallback = (ToolbarListener) context;

        }catch(ClassCastException e){
            throw new ClassCastException(context.toString()+ ", oye debes implementar ToolbarListener, que la estas liando.");


        }
    }

    public void ButtonClicked(View v){
        activityCallback.onButtonClick(seekvalue, editText.getText().toString());

    }



    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }*/
}