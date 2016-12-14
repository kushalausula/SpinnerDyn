package com.koderz.spinnerdyn;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final EditText etTest= (EditText) findViewById(R.id.etTest);
        final LinearLayout ll= (LinearLayout) findViewById(R.id.activity_main);

        etTest.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                ll.removeAllViews();

                String data=etTest.getText().toString();
                if(data!=null && data.isEmpty())
                    data="1";

                int dataInt= Integer.parseInt(data);
                for(int i=0;i<dataInt;i++){

                    addSpinnerToLayout(ll,i);


                }
            }
        });

    }

    private void addSpinnerToLayout(LinearLayout ll, int i) {


        final Spinner spinner=new Spinner(this);
        String strings[]={"test"+i,"test2"+i,"test3"+i};
        spinner.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item,strings));

        spinner.setId(i);
        ll.addView(spinner);


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Log.i("TAG", "onItemClick: "+spinner.getSelectedItem().toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


    }
}
