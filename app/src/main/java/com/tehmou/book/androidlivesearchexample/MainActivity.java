package com.tehmou.book.androidlivesearchexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import com.jakewharton.rxbinding2.widget.RxTextView;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.android.schedulers.AndroidSchedulers;

public class MainActivity extends AppCompatActivity {
    ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);
        ListView listView = (ListView) findViewById(R.id.search_results);
        listView.setAdapter(arrayAdapter);

        EditText editText = (EditText) findViewById(R.id.edit_text);
        RxTextView.textChanges(editText)
                .doOnNext(text -> this.clearSearchResults())
                .filter(text -> text.length() >= 3)
                .debounce(500, TimeUnit.MILLISECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::updateSearchResults);
    }

    private void clearSearchResults() {
        arrayAdapter.clear();
    }

    private void updateSearchResults(CharSequence text) {
        // Create some random results
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            list.add("" + text + Math.random());
        }

        arrayAdapter.clear();
        arrayAdapter.addAll(list);
    }
}
