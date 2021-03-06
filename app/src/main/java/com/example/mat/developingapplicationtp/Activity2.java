package com.example.mat.developingapplicationtp;

import android.content.Intent;
import android.net.MailTo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {

    private TextView nameTextView, mailTextView;
    private Button nextActivityButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        nameTextView = (TextView) findViewById(R.id.nameTextView);
        mailTextView = (TextView) findViewById(R.id.mailTextView);
        Intent intent = getIntent();
        nameTextView.setText(intent.getStringExtra(MainActivity.NAME));
        mailTextView.setText(intent.getStringExtra(MainActivity.MAIL));
        nextActivityButton = (Button) findViewById(R.id.nextActivityButton);

    }

    public void nextActivity(View view) {
        Intent intent = new Intent(this,Activity3Download.class);
        startActivity(intent);
    }
}
