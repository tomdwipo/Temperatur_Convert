package com.example.android.temperaturconvert;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private EditText tempEditText;
    private Button buttonC;
    private Button buttonF;
    private TextView showTemperature;
    private ImageView klikGambar;
    private TextView showText;

    DecimalFormat round = new DecimalFormat("0.0");

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tempEditText = (EditText)findViewById(R.id.editText);
        buttonC = (Button)findViewById(R.id.buttonC);
        buttonF = (Button)findViewById(R.id.buttonF);
        showTemperature = (TextView)findViewById(R.id.hasil);
        klikGambar = (ImageView)findViewById(R.id.imageView);
        showText = (TextView)findViewById(R.id.showtext);

        klikGambar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showText.setText("barang hilang");
                Log.d(TAG,"Hello from here");
                Log.v(TAG,"another String");
            }
        });

        buttonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String tempEditTextVal = tempEditText.getText().toString();
                if (tempEditTextVal.isEmpty()){
                    Toast.makeText(getApplicationContext(),"masukan value",Toast.LENGTH_LONG).show();
                }else{
                    double editTextInt = Double.parseDouble(tempEditTextVal);

                    double resultcel = convertToCelcius(editTextInt);
                    String stringResultCel = String.valueOf(round.format(resultcel));
                    showTemperature.setText(stringResultCel +" C");
                }

            }
        });

        buttonF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String temEditTextVal = tempEditText.getText().toString();
                if (temEditTextVal.isEmpty()){
                    Toast.makeText(getApplicationContext(),"masukan value",Toast.LENGTH_LONG).show();
                }else{
                    double editTextInt = Double.parseDouble(temEditTextVal);
                   double resultfah = convertToFahrenheit(editTextInt);
                    String StringResultFah = String.valueOf(round.format(resultfah));
                    showTemperature.setText(StringResultFah +" F" );
                }

            }
        });

    }

    public double convertToCelcius(Double fahval){
        double resultCel;
        resultCel = (fahval - 32) *5/9;
        return resultCel;
    }
    public double convertToFahrenheit(Double celval){
        double resultFah;
        resultFah =( celval *9/5 )+ 32;
        return resultFah;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
