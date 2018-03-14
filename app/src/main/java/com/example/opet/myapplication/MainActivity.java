package com.example.opet.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends Activity {

    private Spinner grupoSpinner;

    private TextView grupoItem1;
    private TextView grupoItem2;
    private TextView grupoItem3;
    private TextView grupoItem4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        grupoSpinner = findViewById(R.id.grupoSeletor);

        grupoItem1 = findViewById(R.id.grupoItem1);
        grupoItem2 = findViewById(R.id.grupoItem2);
        grupoItem3 = findViewById(R.id.grupoItem3);
        grupoItem4 = findViewById(R.id.grupoItem4);

        grupoSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                int selectedIndex = grupoSpinner.getSelectedItemPosition();
                // Log.d("Index", ""+selectedIndex);
                String val = getResources().getStringArray(R.array.gruposValues)[selectedIndex];
                // Log.d("Value", val);
                int resourceId = getResources().getIdentifier("@array/"+val, "id", getPackageName());
                Log.d("resourceId", ""+resourceId);

                grupoItem1.setText(getResources().getStringArray(resourceId)[0]);
                grupoItem2.setText(getResources().getStringArray(resourceId)[1]);
                grupoItem3.setText(getResources().getStringArray(resourceId)[2]);
                grupoItem4.setText(getResources().getStringArray(resourceId)[3]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}
