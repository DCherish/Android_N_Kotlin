package org.techtown.ap16;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    public static final int REQUEST_CODE_INFO = 101;

    Animation translateLeftAnim;
    Animation translateRightAnim;

    ConstraintLayout page;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        page = findViewById(R.id.page_main);

        translateLeftAnim = AnimationUtils.loadAnimation(this, R.anim.translate_main_left);
        translateRightAnim = AnimationUtils.loadAnimation(this, R.anim.translate_main_right);

        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                page.startAnimation(translateLeftAnim);

                Intent intent = new Intent(getApplicationContext(), InfoActivity.class);
                startActivityForResult(intent, REQUEST_CODE_INFO);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE_INFO)
        {
            if (resultCode == RESULT_OK)
            {
                page.startAnimation(translateRightAnim);
            }
        }
    }
}