package com.ervr.respuestausuario;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    private TextView greetingTextView;
    private ImageView logoImageView;
    private RadioGroup answersRadioGroup;
    private Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        greetingTextView = findViewById(R.id.greetingTextView);
        logoImageView = findViewById(R.id.logoImageView);
        answersRadioGroup = findViewById(R.id.answersRadioGroup);
        submitButton = findViewById(R.id.submitButton);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");

        String greeting = "Hola, " + name + "!";
        greetingTextView.setText(greeting);

        logoImageView.setImageResource(R.drawable.twitch_logo);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = answersRadioGroup.getCheckedRadioButtonId();
                RadioButton selectedRadioButton = findViewById(selectedId);

                if (selectedRadioButton != null) {
                    String answer = selectedRadioButton.getText().toString();

                    if (answer.equals("Twitch")) {
                        Intent correctIntent = new Intent(SecondActivity.this, CorrectActivity.class);
                        startActivity(correctIntent);
                    } else {
                        Intent incorrectIntent = new Intent(SecondActivity.this, IncorrectActivity.class);
                        startActivity(incorrectIntent);
                    }
                }
            }
        });
    }
}

