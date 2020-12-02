package org.techtown.activitypractice13;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.techtown.activitypractice13.InAndOutService;
import org.techtown.activitypractice13.R;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    TextView textView;

    MyReceiver receiver;

    public static final String str = "org.techtown.broadcast.SHOW";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        textView = findViewById(R.id.textView);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), InAndOutService.class);

                Toast.makeText(getApplicationContext(), "Send Success to Service :)\nplz Wait a second XD",
                        Toast.LENGTH_SHORT).show();

                String text = editText.getText().toString();

                editText.setText("");

                intent.putExtra("command", "show");
                intent.putExtra("text", text);

                startService(intent);
            }
        });

        receiver = new MyReceiver();

        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(str);
        registerReceiver(receiver, intentFilter);
    }

    class MyReceiver extends BroadcastReceiver
    {
        @Override
        public void onReceive(Context context, Intent intent) {
            processIntent(intent);
        }
    }

    private void processIntent(Intent intent)
    {
        Toast.makeText(getApplicationContext(), "Receive from service :)", Toast.LENGTH_SHORT).show();

        if (intent != null)
        {
            String command = intent.getStringExtra("command");

            if (command != null)
            {
                if (command.equals("show"))
                {
                    String text = intent.getStringExtra("text");;
                    textView.setText(text);
                }
            }
        }
    }
}