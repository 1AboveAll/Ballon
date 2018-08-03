package com.example.andro.ballon;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText urlEditText;
    Button sumbitButton;

    public static final String KEY = "key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        urlEditText = findViewById(R.id.activity_main_url_edit_text);
        sumbitButton = findViewById(R.id.activity_main_submit_button);

        sumbitButton.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.activity_main_submit_button){
            Intent intent = new Intent(MainActivity.this,ViewActivity.class);
            intent.putExtra(KEY,urlEditText.getText().toString().trim());
            startActivity(intent);
        }
    }

}
