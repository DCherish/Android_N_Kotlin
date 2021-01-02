package org.techtown.sampleintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(); // 1
                intent.putExtra("name", "mike"); // 2
                // 1 & 2 ; intent 객체 생성, name의 값을 mike로 설정
                setResult(RESULT_OK, intent); // 응답 보내기
                finish(); // 현재 액티비티 없애기
            }
        });
    }
}