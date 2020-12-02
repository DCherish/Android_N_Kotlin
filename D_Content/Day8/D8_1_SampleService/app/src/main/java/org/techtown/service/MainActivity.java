package org.techtown.service;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editText.getText().toString();

                Intent intent = new Intent(getApplicationContext(), MyService.class);
                intent.putExtra("command", "show"); // 서비스로 보낼 인텐트 객체의 데이터 어떤 목적으로 ?
                intent.putExtra("name", name);

                startService(intent);
            }
        });

        Intent passedIntent = getIntent();
        processIntent(passedIntent); // 액티비티가 새로 만들어질 때 전달된 인텐트 처리
    }

    @Override
    protected void onNewIntent(Intent intent) {
        processIntent(intent); // 액티비티가 메모리에 있을 때 전달된 인텐트 처리

        super.onNewIntent(intent);
    }

    private void processIntent(Intent intent)
    {
        if (intent != null)
        {
            String command = intent.getStringExtra("command");
            String name = intent.getStringExtra("name");

            Toast.makeText(this, "command : " + command + ", name : " + name, Toast.LENGTH_SHORT).show();
        }
    }
}