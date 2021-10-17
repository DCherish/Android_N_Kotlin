package org.techtown.activitypractice10;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    EditText editText2;
    EditText editText3;

    InfoFragment infoFragment;
    DateFragment dateFragment;
    int state;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Date currentTime = Calendar.getInstance().getTime();
        SimpleDateFormat dayFormat = new SimpleDateFormat("dd", Locale.KOREA);
        SimpleDateFormat monthFormat = new SimpleDateFormat("MM", Locale.KOREA); // mm은 minute
        SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy", Locale.KOREA);

        String year = yearFormat.format(currentTime);
        String month = monthFormat.format(currentTime);
        String day = dayFormat.format(currentTime);

        Button button = findViewById(R.id.button_date);
        button.setText(year + month + day);

        editText = findViewById(R.id.editText);
        editText2 = findViewById(R.id.editText2);

        infoFragment = (InfoFragment) getSupportFragmentManager().findFragmentById(R.id.infoFragment);
        dateFragment = new DateFragment();
    }

    public void onFragmentChanged(int index)
    {
        if (index == 0 && state == 0)
        {
            ChangeClickable(false);
            getSupportFragmentManager().beginTransaction().replace(R.id.container, dateFragment).commit();
        }
        else if (index == 1 && state == 1)
        {
            editText3 = findViewById(R.id.editText3);
            editText3.clearFocus();

            String str = editText3.getText().toString();

            Bundle bundle = new Bundle();
            bundle.putString("date", str);
            infoFragment.setArguments(bundle);

            ChangeClickable(true);
            getSupportFragmentManager().beginTransaction().replace(R.id.container, infoFragment).commit();
        }
    }

    public void onChangeState(int index)
    {
        state = index;
    }

    public void ChangeClickable(boolean value)
    {
        if (value == true)
        {
            editText.setClickable(true);
            editText.setFocusable(true);

            editText2.setClickable(true);
            editText2.setFocusable(true);
        }
        else
        {
            editText.setClickable(false);
            editText.setFocusable(false);

            editText2.setClickable(false);
            editText2.setFocusable(false);
        }
    }
}