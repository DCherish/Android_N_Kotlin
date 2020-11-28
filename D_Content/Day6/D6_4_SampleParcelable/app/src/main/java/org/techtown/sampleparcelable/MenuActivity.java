package org.techtown.sampleparcelable;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MenuActivity extends AppCompatActivity {

    TextView textView;
    public static final String KEY_SIMPLE_DATA = "data";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        textView = findViewById(R.id.textView);
        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("name", "mike");
                setResult(RESULT_OK, intent);

                finish();
            }
        });

        Intent intent = getIntent(); // 메인 액티비티로부터 전달받은 intent 참조하기 위해 onCreate() 메소드 안에서 getIntent() 메소드 호출
        processIntent(intent); // intent 객체 안에 bundle 객체 있으므로 참조 가능
    }

    private void processIntent(Intent intent)
    {
        if (intent != null)
        {
            Bundle bundle = intent.getExtras();
            SimpleData data = bundle.getParcelable(KEY_SIMPLE_DATA);

            if (intent != null)
            {
                textView.setText("전달 받은 데이터\nNumber : " + data.number + "\nMessage : " + data.message);
            }
        }
    }
}