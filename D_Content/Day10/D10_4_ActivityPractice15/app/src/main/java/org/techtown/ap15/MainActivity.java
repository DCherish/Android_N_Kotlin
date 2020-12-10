package org.techtown.ap15;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);

        LayoutParams params = (LayoutParams) imageView.getLayoutParams();
        params.height = params.width;
        imageView.setLayoutParams(params);


    }
}