package com.example.sillyconvertor;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import java.util.ArrayList;

public class FirstFragment extends Fragment {
    ArrayList<String> mItems;
    Integer selectedUnit=0;
    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


      final  EditText editFrom=view.findViewById(R.id.editFrom);
       final EditText editTo =view.findViewById(R.id.editTo);
        Button btnConvert= view.findViewById(R.id.btnConvert);


        Spinner spinner= view.findViewById(R.id.spinUnit);
        mItems= new ArrayList<String>();
        mItems.add("F to C");
        mItems.add("C to F");
        mItems.add("Km to miles");
        mItems.add("Miles to Km");
        ArrayAdapter<String> arrayAdapter= new ArrayAdapter<String>(this.getContext(),
                android.R.layout.simple_spinner_item,mItems);

        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view,int i, long l) {
               selectedUnit=i;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

            btnConvert.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Double fromValue=0.0;
                    Double result=0.0;
                    try {
                        fromValue = Double.parseDouble(editFrom.getText().toString());
                    }
                    catch (NumberFormatException ex){
                        Toast.makeText(getContext(),"Incorret Number",Toast.LENGTH_LONG).show();
                        return;
                    }

                    if( selectedUnit==0){
                        result= (fromValue-32)*5/9;

                    }else if(selectedUnit==1)
                    {
                        result= (fromValue/5)*9 + 32;

                    }
                    else if(selectedUnit==2){
                        result= fromValue * 0.621371;
                    }
                    else{
                        result= fromValue /0.621371;
                    }
                    editTo.setText(result.toString());
                }
            });




    }
}