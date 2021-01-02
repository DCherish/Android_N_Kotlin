package org.techtown.activitypractice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    TextView textView;
    Button button1;
    Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice4);

        editText = findViewById(R.id.editText);
        textView = findViewById(R.id.textView);
        button1 = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);

        textView.setText("0");
        editText.setTextSize(TypedValue.COMPLEX_UNIT_SP, 30);

        editText.addTextChangedListener(textWatcher);
    }

    TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            int len = editText.getText().length();
            textView.setText(len+"");
        }

        @Override
        public void afterTextChanged(Editable s) {
            if (editText.getText().length() == 0)
            {
                editText.setTextSize(TypedValue.COMPLEX_UNIT_SP, 30);
            }
            else
            {
                editText.setTextSize(TypedValue.COMPLEX_UNIT_SP, 50);
            }
        }
    };

    public void onButton1Clicked(View v)
    {
        toastMSG();
    }

    public void onButton2Clicked(View v)
    {
        processExit();
    }

    private void toastMSG()
    {
        Toast.makeText(this, editText.getText(), Toast.LENGTH_SHORT).show();
    }

    private void processExit()
    {
        finish();
    }
}