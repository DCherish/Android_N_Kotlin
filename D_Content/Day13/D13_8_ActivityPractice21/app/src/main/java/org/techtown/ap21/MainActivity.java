package org.techtown.ap21;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    InputFragment inputFragment;
    QueryFragment queryFragment;

    DatabaseHelper dbHelper;
    SQLiteDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHelper = new DatabaseHelper(this);
        database = dbHelper.getWritableDatabase();

        inputFragment = new InputFragment();
        queryFragment = new QueryFragment();

        getSupportFragmentManager().beginTransaction().replace(R.id.container, inputFragment).commit();

        Button button = findViewById(R.id.button);
        Button button2 = findViewById(R.id.button2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button.setBackgroundResource(R.drawable.rect_1_selected);
                button.setTypeface(button.getTypeface(), Typeface.BOLD);
                button.setTextSize(TypedValue.COMPLEX_UNIT_SP, 22);

                button2.setBackgroundResource(R.drawable.rect_2_unselected);
                button2.setTypeface(null, Typeface.NORMAL);
                button2.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);

                getSupportFragmentManager().beginTransaction().replace(R.id.container, inputFragment).commit();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button.setBackgroundResource(R.drawable.rect_1_unselected);
                button.setTypeface(null, Typeface.NORMAL);
                button.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);

                button2.setBackgroundResource(R.drawable.rect_2_selected);
                button2.setTypeface(button2.getTypeface(), Typeface.BOLD);
                button2.setTextSize(TypedValue.COMPLEX_UNIT_SP, 22);

                getSupportFragmentManager().beginTransaction().replace(R.id.container, queryFragment).commit();
            }
        });
    }

    public void saveBookInformation(int num, String str, String str2, String str3)
    {
        database.execSQL("insert into bk_info(i_num, title, writer, context) values "
                + "(" + num + ", '" + str + "', '" + str2 + "', '" + str3 + "')");
    }
}