package org.techtown.sampleorientation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String name;
    EditText editText;
    EditText editText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showToast("onCreate 호출됨.");

        editText = findViewById(R.id.editText);
        editText2 = findViewById(R.id.editText2);

        Button button = findViewById(R.id.button);
        Button button2 = findViewById(R.id.button2);

        if (button != null) {
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    name = editText.getText().toString();
                    showToast("입력된 값을 변수에 저장했습니다. : " + name);
                }
            });
        }

        if (button2 != null) {
            button2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    name = editText2.getText().toString();
                    showToast("입력된 값을 변수에 저장했습니다. : " + name);
                }
            });
        }

        if (savedInstanceState != null)
        {
            name = savedInstanceState.getString("name");

            if (editText != null)
            {
                editText.setText(name);
            }

            if (editText2 != null)
            {
                editText2.setText(name);
            }

            showToast("값을 복원했습니다. : " + name);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        //showToast("onStart 호출됨.");
    }

    @Override
    protected void onStop() {
        super.onStop();
        //showToast("onStop 호출됨.");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //showToast("onDestroy 호출됨.");
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString("name", name);
    }

    public void showToast(String data)
    {
        Toast.makeText(this, data, Toast.LENGTH_LONG).show();
    }
}