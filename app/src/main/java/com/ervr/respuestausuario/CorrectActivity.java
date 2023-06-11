package com.ervr.respuestausuario;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CorrectActivity extends AppCompatActivity {

    private TextView messageTextView;
    private Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_correct);

        messageTextView = findViewById(R.id.messageTextView);
        backButton = findViewById(R.id.backButton);

        messageTextView.setText("Ganaste");

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CorrectActivity.this, SecondActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}