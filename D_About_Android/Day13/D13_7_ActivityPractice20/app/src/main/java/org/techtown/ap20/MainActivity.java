package org.techtown.ap20;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    EditText editText2;
    EditText editText3;

    DatabaseHelper dbHelper;
    SQLiteDatabase database;

    String tableName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        editText2 = findViewById(R.id.editText2);
        editText3 = findViewById(R.id.editText3);

        dbHelper = new DatabaseHelper(this);
        database = dbHelper.getWritableDatabase();

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editText.getText().toString().equals(""))
                {
                    Toast.makeText(MainActivity.this, "저장 실패 :(\n제목을 입력해주세요 :/", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    if (editText2.getText().toString().equals(""))
                    {
                        Toast.makeText(MainActivity.this, "저장 실패 :(\n저자를 입력해주세요 :/", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        if (editText3.getText().toString().equals(""))
                        {
                            Toast.makeText(MainActivity.this, "저장 실패 :(\n내용을 입력해주세요 :/", Toast.LENGTH_SHORT).show();
                        }
                        else
                        {
                            database.execSQL("insert into bk_info(title, writer, context) values " +"('"
                            + editText.getText().toString().trim() + "', '"
                                    + editText2.getText().toString().trim() + "', '"
                                    + editText3.getText().toString().trim() + "')");

                            editText.setText("");
                            editText2.setText("");
                            editText3.setText("");

                            Toast.makeText(MainActivity.this, "저장 성공 :)", Toast.LENGTH_SHORT).show();
                        }
                    }
                }

                InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);

                getCurrentFocus().clearFocus();
            }
        });
    }
}