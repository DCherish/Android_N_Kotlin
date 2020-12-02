package org.techtown.activitypractice12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        textView = findViewById(R.id.textView);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), InAndOutService.class);

                Toast.makeText(getApplicationContext(), "Send Success to Service :)\nplz Wait for 3 seconds",
                        Toast.LENGTH_SHORT).show();

                String text = editText.getText().toString();

                editText.setText("");

                intent.putExtra("command", "show");
                intent.putExtra("text", text);

                startService(intent);
            }
        });

        Intent passedIntent = getIntent();
        processIntent(passedIntent);
    }

    @Override
    protected void onNewIntent(Intent intent) {

        processIntent(intent);

        super.onNewIntent(intent);
    }

    private void processIntent(Intent intent)
    {
        if (intent != null)
        {
            String text = intent.getStringExtra("text");;

            textView.setText(text);
        }
    }
}