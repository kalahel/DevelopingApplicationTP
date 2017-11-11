package com.example.mat.developingapplicationtp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText nameField, mailField;
    private Button validationButton;

    public final static String NAME = "NAME";
    public final static String MAIL = "MAIL";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nameField = (EditText) findViewById(R.id.nameEditText);
        mailField = (EditText) findViewById(R.id.mailEditText);
        validationButton = (Button) findViewById(R.id.validationButton);
    }

    public void submit(View view) {
        Intent intent = new Intent(this, Activity2.class);

        String name = nameField.getText().toString();
        String mail = mailField.getText().toString();

        intent.putExtra(NAME, name);
        intent.putExtra(MAIL,mail);
        startActivity(intent);
    }
}
