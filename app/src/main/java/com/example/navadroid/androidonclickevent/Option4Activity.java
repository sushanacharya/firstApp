package com.example.navadroid.androidonclickevent;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

// TODO: View.OnClickListener as class attribute
public class Option4Activity extends AppCompatActivity {

    private EditText etInput;
    private TextView tvOutput;
    private View.OnClickListener onClickListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option4);
        bindView();
        initView();
    }

    // To bind views to this activity
    private void bindView(){
        etInput = (EditText) findViewById(R.id.et_input_4);
        tvOutput = (TextView) findViewById(R.id.tv_body_4);
    }

    private void initView(){
        initOnClickListener();
        // To register click event to view
        findViewById(R.id.btn_process_4).setOnClickListener(onClickListener);
    }

    // You don't have to bind any functions to "android:onClick" in layout XML file.
    private void initOnClickListener(){
        onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.btn_process_4:
                        greet();
                        break;
                }
                hideKeyboardInput(v);
            }
        };
    }

    // To greet the user
    private void greet(){
        tvOutput.setText(getString(R.string.greeting) + " " + etInput.getText().toString());
    }

    // To hide Android soft keyboard
    private void hideKeyboardInput(View v){
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
    }
}
