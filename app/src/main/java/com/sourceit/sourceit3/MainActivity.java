package com.sourceit.sourceit3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText editText;
    Button btnHide;
    Button btnRestore;

    List<String> container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        container = new ArrayList<>(5);

        editText = (EditText) findViewById(R.id.editText);

        btnHide = (Button) findViewById(R.id.btnHide);
        btnHide.setOnClickListener(this);

        btnRestore = (Button) findViewById(R.id.btnRestore);
        btnRestore.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnHide:
                if (container.size() < 5) {
                    container.add(editText.getText().toString());
                    System.out.println(container);

                } else {

                    container.remove(0);
                    container.add(editText.getText().toString());

                    System.out.println(container);

                }
                editText.setText("");
                break;

            case R.id.btnRestore:
                if (container.size() != 0) {
                    editText.setText(container.get(container.size() - 1));
                    container.remove(container.size() - 1);
                } else {
                    editText.setText("NO DATA!");
                }


                break;
        }
    }
}
