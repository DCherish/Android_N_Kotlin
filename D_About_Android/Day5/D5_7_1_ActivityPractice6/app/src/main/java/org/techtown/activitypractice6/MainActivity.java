package org.techtown.activitypractice6;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.SeekBar;
public class MainActivity extends AppCompatActivity {

    SeekBar seekBar;
    ProgressBar progressBar;
    EditText editText;

    @SuppressLint("ClickableViewAccessibility") // Cuz of TouchListener // blind or visually impaired people

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seekBar = findViewById(R.id.seekBar);
        progressBar = findViewById(R.id.progressBar);
        editText = findViewById(R.id.editText);

        seekBar.setIndeterminate(false);
        seekBar.setProgress(80);
        progressBar.setIndeterminate(false);
        progressBar.setProgress(80);
        editText.setText(String.valueOf(80));

        editText.addTextChangedListener(textWatcher);

        ConstraintLayout col = (ConstraintLayout) findViewById(R.id.C_layout);
        col.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                hideKeyboard();
                hideCursor();

                return false;
            }
        });
    }

    TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            if (editText.getText().length() == 0)
            {
                progressBar.setProgress(0);
                seekBar.setProgress(0);
            }
            else if (Integer.parseInt(editText.getText().toString()) > 100)
            {
                String str = "100";
                editText.setText(str);
                editText.setSelection(editText.length());

                progressBar.setProgress(100);
                seekBar.setProgress(100);
            }
            else
            {
                if (editText.length() > 1) {
                    if (editText.getText().toString().charAt(0) == '0') {
                        String str = editText.getText().toString();
                        editText.setText(str.substring(1));
                        editText.setSelection(editText.length());
                    }
                }

                int value = Integer.parseInt(editText.getText().toString());
                progressBar.setProgress(value);
                seekBar.setProgress(value);
            }
        }

        @Override
        public void afterTextChanged(Editable s) {
        }
    };

    private void hideCursor()
    {
        editText.clearFocus();
    }

    private void hideKeyboard()
    {
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(this.getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
    }
}