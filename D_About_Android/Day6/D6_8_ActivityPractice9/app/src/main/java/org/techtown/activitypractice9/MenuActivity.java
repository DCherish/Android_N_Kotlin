package org.techtown.activitypractice9;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity {

    public static final int REQUEST_CODE_SUBMENU1 = 201;
    public static final int REQUEST_CODE_SUBMENU2 = 202;
    public static final int REQUEST_CODE_SUBMENU3 = 203;

    public static final int RESULT_HOME = 7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SubMenuActivity1.class);
                startActivityForResult(intent, REQUEST_CODE_SUBMENU1);
            }
        });

        Button button3 = findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SubMenuActivity2.class);
                startActivityForResult(intent, REQUEST_CODE_SUBMENU2);
            }
        });

        Button button4 = findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SubMenuActivity3.class);
                startActivityForResult(intent, REQUEST_CODE_SUBMENU3);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE_SUBMENU1 || requestCode == REQUEST_CODE_SUBMENU2 || requestCode == REQUEST_CODE_SUBMENU3)
        {
            if (resultCode == RESULT_HOME)
            {
                Intent intent = new Intent();

                setResult(RESULT_OK, intent);
                finish();
            }
        }
    }
}