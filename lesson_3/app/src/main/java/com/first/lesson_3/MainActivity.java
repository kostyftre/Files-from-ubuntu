package com.first.lesson_3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.media.audiofx.BassBoost;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.first.lesson_3.business_logic.CounterInfo;

public class MainActivity extends AppCompatActivity {

    private Button increaseBtn;
    private TextView counterTextView;

    private CounterInfo counterInfo = new CounterInfo();

    private String counterInfoKey = "counterInfoKey";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        findVies();

        setIncreaseCounterButtonBehaviour();
    }


    private void findVies(){
        increaseBtn=findViewById(R.id.increaseCounterBtn);
        counterTextView = findViewById(R.id.counterTextView);

    }




    @Override
    protected void onStart(){
        super.onStart();

        showMessage(getString(R.string.onStart));

    }


    @Override
    protected void onResume() {
        super.onResume();

        showMessage("onResume");

    }


    @Override
    protected void onPause() {
        super.onPause();
        showMessage("onPause");
    }


    @Override
    protected void onStop() {
        super.onStop();

        showMessage("onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        showMessage("onRestart");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        showMessage("onDestroy");

    }


    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {

        outState.putSerializable(counterInfoKey, counterInfo);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {

        super.onRestoreInstanceState(savedInstanceState);

        counterInfo = (CounterInfo)savedInstanceState.getSerializable(counterInfoKey);
        updateTextcounter();

    }



    private void setIncreaseCounterButtonBehaviour(){
        increaseBtn.setOnClickListener(v -> {

            counterInfo.increaseCounter();

            updateTextcounter();
        });
    }

    private void updateTextcounter(){

        String text = String.valueOf(counterInfo.getCounter());
        counterTextView.setText(text);
    }


    private void showMessage(String message){

//        Toast.makeText(getApplicationContext(),message,Toast.LENGTH_SHORT)
//                .show(); уведомления ввиде облачка

        Log.i("Lifecycle",message);




    }


}