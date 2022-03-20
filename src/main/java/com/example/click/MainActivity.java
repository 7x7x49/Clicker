package com.example.click;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Integer count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickGet2(View view){
        count++;
        TextView textView = findViewById(R.id.countView);
        ViewGroup.LayoutParams params = textView.getLayoutParams();
        params.height += 1;
        params.width += 1;
        textView.setLayoutParams(params);
        textView.setText(count.toString());
    }

    @Override
    protected void onSaveInstanceState(Bundle outState)
    {
        TextView countView = findViewById(R.id.countView);
        ViewGroup.LayoutParams params = countView.getLayoutParams();
        super.onSaveInstanceState(outState);
        outState.putInt("count", count);
        outState.putInt("height", params.height);
        outState.putInt("width", params.width);
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        TextView countView = findViewById(R.id.countView);
        countView.setText(count.toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState)
    {
        super.onRestoreInstanceState(savedInstanceState);
        TextView countView = findViewById(R.id.countView);
        ViewGroup.LayoutParams params = countView.getLayoutParams();
        count = savedInstanceState.getInt("count");
        params.width = savedInstanceState.getInt("width");
        params.height = savedInstanceState.getInt("height");
    }
}