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

    private int seekvalue;

    private EditText editText;

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
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        seekvalue = progress;
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}