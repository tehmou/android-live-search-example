package com.tehmou.book.androidlivesearchexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import com.jakewharton.rxbinding.widget.RxCompoundButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Make the textView1 change text according to whether switchButton is "checked" or not
        Switch switchButton = (Switch) findViewById(R.id.switch_button);
        TextView textView1 = (TextView) findViewById(R.id.text_view_1);

        // Set the textView2 to say the text is too long if editText is more than 7 characters
        EditText editText = (EditText) findViewById(R.id.edit_text);
        TextView textView2 = (TextView) findViewById(R.id.text_view_1);
    }
}
