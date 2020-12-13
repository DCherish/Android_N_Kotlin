package org.techtown.ap17;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    boolean isButtonActivate = true;

    Animation translateLeftAnim;
    Animation translateRightAnim;
    Animation translateUpAnim;
    Animation translateDownAnim;

    EditText editText;
    Button button;

    WebView webView;

    /*long pressedStartTime;
    float pressedX;
    float pressedY;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        translateLeftAnim = AnimationUtils.loadAnimation(this, R.anim.translate_left);
        translateRightAnim = AnimationUtils.loadAnimation(this, R.anim.translate_right);
        translateUpAnim = AnimationUtils.loadAnimation(this, R.anim.translate_up);
        translateDownAnim = AnimationUtils.loadAnimation(this, R.anim.translate_down);

        SlidingButtonAnimationListener animationListener = new SlidingButtonAnimationListener();

        translateLeftAnim.setAnimationListener(animationListener);
        translateRightAnim.setAnimationListener(animationListener);
        /*translateUpAnim.setAnimationListener(animationListener);
        translateDownAnim.setAnimationListener(animationListener);*/

        editText = findViewById(R.id.editText);
        webView = findViewById(R.id.webView);

        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        webView.setWebViewClient(new ViewClient());

        editText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    String_editText();
                } else {
                    button.setText("이동");
                }
            }
        });

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (editText.isFocused()) {
                    String_editText();
                } else {
                    button.setText("이동");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isButtonActivate) {
                    if (!editText.getText().toString().equals("")) {
                        webView.loadUrl(editText.getText().toString());
                    }

                    button.startAnimation(translateRightAnim);
                    editText.startAnimation(translateUpAnim);
                    clearFocus_hideKeyboard();
                } else {
                    editText.setVisibility(View.VISIBLE);

                    button.startAnimation(translateLeftAnim);
                    editText.startAnimation(translateDownAnim);
                }
            }
        });

        /*webView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int action = event.getAction();

                switch (action) {
                    case MotionEvent.ACTION_DOWN:
                        pressedStartTime = System.currentTimeMillis();
                        pressedX = event.getX();
                        pressedY = event.getY();

                        break;

                    case MotionEvent.ACTION_UP:

                        long calTime = System.currentTimeMillis() - pressedStartTime;
                        float nowX = event.getX();
                        float nowY = event.getY();

                        float distance = (float) Math.sqrt((nowX - pressedX) * (nowX - pressedX) + (nowY - pressedY) * (nowY - pressedY));

                        Log.d("DDDDDD", "Time : " + String.valueOf(calTime) + ", dist : " + String.valueOf(distance));

                        if (calTime < 1000) {
                            if (distance < 15) {
                                clearFocus_hideKeyboard();
                            }
                        }

                        break;
                }

                return true;
            }
        });*/
    }

    private class SlidingButtonAnimationListener implements Animation.AnimationListener {

        public void onAnimationEnd(Animation animation) {
            if (isButtonActivate) {
                editText.setVisibility(View.INVISIBLE);
                isButtonActivate = false;
            } else {
                button.setGravity(Gravity.CENTER);
                String_editText();
                isButtonActivate = true;
            }
        }

        @Override
        public void onAnimationStart(Animation animation) {
            if (isButtonActivate) {
                button.setText("<");
                button.setGravity(Gravity.LEFT);
            }
        }

        @Override
        public void onAnimationRepeat(Animation animation) {
        }
    }

    private class ViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(final WebView view, final String url) {
            view.loadUrl(url);

            return true;
        }
    }

    private void clearFocus_hideKeyboard() {
        if (getCurrentFocus() != null) {
            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);

            editText.clearFocus();
        }
    }

    private void String_editText()
    {
        if (editText.getText().toString().equals("")) {
            button.setText("닫기");
        } else {
            button.setText("이동");
        }
    }
}