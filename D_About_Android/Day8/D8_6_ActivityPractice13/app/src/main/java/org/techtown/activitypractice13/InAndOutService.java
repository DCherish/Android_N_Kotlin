package org.techtown.activitypractice13;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.widget.Toast;

import org.techtown.activitypractice13.MainActivity;

public class InAndOutService extends Service {

    public static final String str = "org.techtown.broadcast.SHOW";

    public InAndOutService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (intent == null)
        {
            return Service.START_STICKY;
        }
        else
        {
            String command = intent.getStringExtra("command");

            if (command != null)
            {
                if (command.equals("show"))
                {
                    processCommand(intent);
                }
            }
        }

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    private void processCommand(Intent intent)
    {
        String command = intent.getStringExtra("command");
        String text = intent.getStringExtra("text");

        for (int i = 0; i < 1; i++)
        {
            try
            {
                Thread.sleep(1500);
            } catch (Exception e) {};
        }

        Intent showIntent = new Intent();

        showIntent.setAction(str);
        showIntent.putExtra("command", command);
        showIntent.putExtra("text", text + "\n\nfrom Service :)");

        Toast.makeText(getApplicationContext(), "Success BroadCasting :)", Toast.LENGTH_SHORT).show();

        sendBroadcast(showIntent);
    }
}