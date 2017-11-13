package com.example.mat.developingapplicationtp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText nameField, mailField;
    private Button validationButton;
    private TextView savedInfo;

    public final static String NAME = "NAME";
    public final static String MAIL = "MAIL";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nameField = (EditText) findViewById(R.id.nameEditText);
        mailField = (EditText) findViewById(R.id.mailEditText);
        validationButton = (Button) findViewById(R.id.validationButton);
        savedInfo = (TextView) findViewById(R.id.savedInfoTextView);

        // Retrieving data from shared preferences
        SharedPreferences sharedPreferences = this.getSharedPreferences("DevelopingApplication.Pref1", Context.MODE_PRIVATE);
        String name = sharedPreferences.getString("DevelopingApplication.Pref1", "");
        name = "Hello " + name;
        savedInfo.setText(name);
    }
    //  Passing informations and starting the next activity
    public void submit(View view) {
        Intent intent = new Intent(this, Activity2.class);

        String name = nameField.getText().toString();
        String mail = mailField.getText().toString();

        // Saving data in sharedfile
        SharedPreferences sharedPref = this.getSharedPreferences("DevelopingApplication.Pref1", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("DevelopingApplication.Pref1", nameField.getText().toString());
        editor.commit();

        intent.putExtra(NAME, name);
        intent.putExtra(MAIL,mail);
        startActivity(intent);
    }
}
