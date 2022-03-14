package com.example.clicker;

import static android.content.ContentValues.TAG;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    int btc = 0;
    int initialFactor = 1;
    int goalBtc=100;
    int addingAMultiplier = initialFactor;
    double factor = 1;

    Button addCoin;
    TextView TabloСoins, Xfactor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addCoin = (Button)findViewById(R.id.addCoin);
        TabloСoins = (TextView)findViewById(R.id.TabloСoins);
        Xfactor = (TextView)findViewById(R.id.xfactor);
        addCoin();
        Toast.makeText(this, "onCreate()", Toast.LENGTH_LONG).show();
        Log.d(TAG, "onCreate");
    }

    @Override
    public void onStart(){
        super.onStart();
        Toast.makeText(this, "onStart()", Toast.LENGTH_LONG).show();
        Log.d(TAG, "onStart");
        resetUI();
    }

    void addCoin(){
        addCoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btc == goalBtc) {
                    factor += 0.5;
                    goalBtc*=5;
                    addingAMultiplier += 0.01;
                }
                btc += addingAMultiplier;
                TabloСoins.setText("BTC: "+btc);
                Xfactor.setText("Множитель: "+factor);
            }});
        Toast.makeText(this, "onClick()", Toast.LENGTH_LONG).show();
        Log.d(TAG, "onClick");
    }
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("count", (int) btc);
        Toast.makeText(this, "onRestoreInstanceState()", Toast.LENGTH_LONG).show();
        Log.d(TAG, "onSaveInstanceState");
    }
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        btc = savedInstanceState.getInt("count");
        Log.d(TAG, "onRestoreInstanceState");
    }

    @Override
    public void onPause(){
        super.onPause();
        Toast.makeText(this, "onPause()", Toast.LENGTH_LONG).show();
        Log.d(TAG, "onPause");
    }

    @Override
    public void onStop(){
        super.onStop();
        Toast.makeText(this, "onStop()", Toast.LENGTH_LONG).show();
        Log.d(TAG, "onStop");
    }
    @Override
    public void onDestroy(){
        super.onDestroy();
        Toast.makeText(this, "onDestroy()", Toast.LENGTH_LONG).show();
        Log.d(TAG, "onDestroy");
    }

    private void resetUI() {
        ((TextView) findViewById(R.id.TabloСoins)).setText(String.valueOf(btc));
        Toast.makeText(this, "resetUI()", Toast.LENGTH_LONG).show();
        Log.d(TAG, "resetUI");
    }
    @Override
    public void onResume(){
        super.onResume();
        Toast.makeText(this, "onResume()", Toast.LENGTH_LONG).show();
        Log.d(TAG, "onResume");
    }
}
