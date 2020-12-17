package org.techtown.ap21;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static String NAME = "book_information.db";
    public static int VERSION = 1;

    public DatabaseHelper(@Nullable Context context) {
        super(context, NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table if not exists bk_info"
                + "(_id integer PRIMARY KEY autoincrement, "
                + "title text, writer text, context text)";

        db.execSQL(sql);

        init_Information(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void init_Information(SQLiteDatabase db)
    {
        db.execSQL("insert into bk_info(title, writer, context) values "
                + "('Love', 'James', '어느 겨울.. 차가운 마음을 녹여줄 로맨스 이야기..')");

        db.execSQL("insert into bk_info(title, writer, context) values "
                + "('Who', 'Homes', '늦은 밤.. 완벽한 밀실살인 사건이 일어났다!')");

        db.execSQL("insert into bk_info(title, writer, context) values "
                + "('Safe, Save', 'Dr. G', '1분 1초가 골든타임! 꼭 살려야만 한다!')");
    }
}
