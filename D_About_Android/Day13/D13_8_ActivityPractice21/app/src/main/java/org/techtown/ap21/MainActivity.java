package org.techtown.ap21;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements OnDatabaseCallback{

    InputFragment inputFragment;
    QueryFragment queryFragment;

    DatabaseHelper dbHelper;
    SQLiteDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // open database
        if (database != null) {
            database.close();
            database = null;
        }

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

    @Override
    protected void onDestroy() {
        // close database
        if (database != null) {
            database.close();
            database = null;
        }

        super.onDestroy();
    }

    @Override
    public void insert(String title, String writer, String context) {
        database.execSQL("insert into bk_info(title, writer, context) values ('"
                + title + "', '" + writer + "', '" + context + "')");
    }

    @Override
    public ArrayList<Book> accessAll() {
        ArrayList<Book> result = new ArrayList<Book>();

        try{
            Cursor cursor = database.rawQuery("select _id, title, writer, context from bk_info", null);

            for (int i = 0; i < cursor.getCount(); i++)
            {
                cursor.moveToNext();

                String title = cursor.getString(1);
                String writer = cursor.getString(2);
                String context = cursor.getString(3);

                Book book = new Book(title, writer, context);

                result.add(book);
            }

            cursor.close();
        } catch (Exception e)
        {
            Log.d("DDDDDDDDDD", e.toString());
        }

        return result;
    }
}