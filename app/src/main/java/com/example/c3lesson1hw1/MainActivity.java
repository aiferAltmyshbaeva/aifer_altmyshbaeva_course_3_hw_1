package com.example.c3lesson1hw1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText etTo;
    private EditText etSubject;
    private EditText etMessage;

    private Button btnSend;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etTo = findViewById(R.id.et_to);
        etSubject = findViewById(R.id.et_subject);
        etMessage = findViewById(R.id.et_message);
        btnSend = findViewById(R.id.btn_send);
        btnSend.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_SENDTO);
            intent.setData(Uri.parse("mailto:")); // only email apps should handle this
            intent.putExtra(Intent.EXTRA_EMAIL, new String[]{etTo.getText().toString()});
            intent.putExtra(Intent.EXTRA_SUBJECT, etSubject.getText().toString());
            intent.putExtra(Intent.EXTRA_TEXT,etMessage.getText().toString());
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            }
        });

    }
}