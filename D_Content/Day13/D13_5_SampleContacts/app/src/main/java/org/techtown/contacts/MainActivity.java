package org.techtown.contacts;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    boolean init = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] permissions = { Manifest.permission.READ_CONTACTS, Manifest.permission.WRITE_CONTACTS };

        textView = findViewById(R.id.textView);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkPermissions(permissions);
            }
        });
    }

    public void checkPermissions(String[] permissions)
    {
        ArrayList<String> targetList = new ArrayList<String>();

        for (int i = 0; i < permissions.length; i++)
        {
            String curPermission = permissions[i];

            int permissionCheck = ContextCompat.checkSelfPermission(this, curPermission);

            if (permissionCheck == PackageManager.PERMISSION_DENIED)
            {
                targetList.add(curPermission);
            }
        }

        if (targetList.size() == 0)
        {
            chooseContacts();
        }
        else
        {
            String[] targets = new String[targetList.size()];
            targetList.toArray(targets);

            ActivityCompat.requestPermissions(this, targets, 101);
        }
    }

    public void chooseContacts()
    {
        Intent contactPickerIntent = new Intent(Intent.ACTION_PICK,
                ContactsContract.Contacts.CONTENT_URI);
        startActivityForResult(contactPickerIntent, 101);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK)
        {
            if (requestCode == 101)
            {
                try {
                    Uri contactsUri = data.getData();
                    String id = contactsUri.getLastPathSegment();

                    getContacts(id);
                } catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        }
    }

    public void println(String str)
    {
        textView.append(str + "\n");
    }

    public void getContacts(String id)
    {
        Cursor cursor = null;
        String name = "";

        try {
            cursor = getContentResolver().query(ContactsContract.Data.CONTENT_URI,
                    null, ContactsContract.Data.CONTACT_ID + "=?", new String[] { id }, null);

            if (cursor.moveToFirst())
            {
                name = cursor.getString(cursor.getColumnIndex(ContactsContract.Data.DISPLAY_NAME));
                println("Name : " + name);

                String columns[] = cursor.getColumnNames();

                for (String column : columns)
                {
                    int index = cursor.getColumnIndex(column);
                    String columnOutput = ("#" + index + " -> [" + column + "] " + cursor.getString(index));
                    println(columnOutput);
                }

                cursor.close();
            }
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        boolean state = true;

        switch (requestCode){
            case 101:{
                if (grantResults.length > 0)
                {
                    for (int i = 0; i < grantResults.length; i++)
                    {
                        if (grantResults[i] == PackageManager.PERMISSION_DENIED)
                        {
                            state = false;
                            break;
                        }
                    }

                    if (state)
                    {
                        chooseContacts();
                    }
                }
            }

            return;
        }
    }
}