package org.techtown.album;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.InputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] permission = { Manifest.permission.READ_EXTERNAL_STORAGE };

        imageView = findViewById(R.id.imageView);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int permissionCheck = ContextCompat.checkSelfPermission(getApplicationContext(), permission[0]);

                if (permissionCheck == PackageManager.PERMISSION_GRANTED)
                {
                    openGallery();
                }
                else
                {
                    if (ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this, permission[0])) // 물어본 적 있으면 true // 아니면 false
                    {
                        Toast.makeText(getApplicationContext(), "설정에서 권한을 허용해주세요 :)", Toast.LENGTH_LONG).show();
                    }
                    else
                    {
                        ActivityCompat.requestPermissions(MainActivity.this, permission, 101);
                    }
                }
            }
        });
    }

    public void openGallery()
    {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);

        startActivityForResult(intent, 101);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 101)
        {
            if (resultCode == RESULT_OK)
            {
                Uri fileUri = data.getData();

                ContentResolver resolver = getContentResolver();

                try
                {
                    InputStream instream = resolver.openInputStream(fileUri);
                    Bitmap imgBitmap = BitmapFactory.decodeStream(instream);
                    imageView.setImageBitmap(imgBitmap);

                    instream.close();
                } catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        }
    }

    /*@Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        switch (requestCode)
        {
            case 101: {
                if (grantResults.length > 0) {
                    for (int i = 0; i < grantResults.length; i++) {
                        if (grantResults[i] == PackageManager.PERMISSION_GRANTED) {
                            Toast.makeText(this, String.valueOf(i + 1) + "번째 권한 승인함", Toast.LENGTH_SHORT).show();
                        }
                    }
                }

                return;
            }
        }
    }*/
}