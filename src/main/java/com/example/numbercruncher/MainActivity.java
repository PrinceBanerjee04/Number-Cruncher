package com.example.numbercruncher;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;


public class MainActivity extends AppCompatActivity {

    TextView resultTv, solutionTv;
    String workings = "";
    boolean flag=true;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();
        initTextViews();
    }

    private void initTextViews() {
        solutionTv = (TextView) findViewById(R.id.input);
        resultTv = (TextView) findViewById(R.id.result);
    }

    private void setWorkings(String givenValue) {
        workings = workings + givenValue;
        solutionTv.setText(workings);
    }

    public void equalsOnClick(View view) {
        Double result = null;
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("rhino");

        try {
            result = (double) engine.eval(workings);
        } catch (ScriptException e) {
            Toast.makeText(this, "Invalid Input", Toast.LENGTH_SHORT).show();
        }
        if (result != null) {
            resultTv.setText(String.valueOf(result.doubleValue()));
        }
    }

    public void clearOnClick(View view) {
        solutionTv.setText("");
        workings = "";
        resultTv.setText("");
        leftBracket = true;
    }

    boolean leftBracket = true;

    public void bracketsOnClick(View view) {
        if (leftBracket) {
            setWorkings("(");
            leftBracket = false;
        } else {
            setWorkings(")");
            leftBracket = true;
        }
    }

    public void sevenOnClick(View view) {
        setWorkings("7");
    }

    public void zeroOnClick(View view) {
        setWorkings("0");
    }

    public void eightOnClick(View view) {
        setWorkings("8");
    }

    public void nineOnClick(View view) {
        setWorkings("9");
    }

    public void oneOnClick(View view) {
        setWorkings("1");
    }

    public void twoOnClick(View view) {
        setWorkings("2");
    }

    public void threeOnClick(View view) {
        setWorkings("3");
    }

    public void fourOnClick(View view) {
        setWorkings("4");
    }

    public void fiveOnClick(View view) {
        setWorkings("5");
    }

    public void sixOnClick(View view) {
        setWorkings("6");
    }

    public void AddOnClick(View view) {
        if(flag==true){
            setWorkings("+");
            flag=false;
        }
        else {
            flag = true;
            return;

        }
    }

    public void SubOnClick(View view) {
        setWorkings("-");
    }

    public void DivOnClick(View view) {

        if(flag==true){
            setWorkings("/");
            flag=false;
        }
        else {
            flag = true;
            return;
        }
    }

    public void ModOnClick(View view) {
        if(flag==true){
            setWorkings("%");
            flag=false;
        }
        else {
            flag = true;
            return;
        }
    }

    public void ProdOnClick(View view) {
        if(flag==true){
            setWorkings("*");
            flag=false;
        }
        else {
            flag = true;
            return;
        }
    }

    public void DecOnClick(View view) {
        if(flag==true){
            setWorkings(".");
            flag=false;
        }
        else {
            flag = true;
            return;
        }
    }

    public void SignOnClick(View view) {
        setWorkings("(-");
        leftBracket = false;
    }

    public void DeleteOnClick(View view) {
        if (workings.length() == 0) {
            return;
        }
        String w = workings.substring(0, workings.length() - 1);
        solutionTv.setText("");
        workings = "";
        resultTv.setText("");
        setWorkings(w);
    }

}