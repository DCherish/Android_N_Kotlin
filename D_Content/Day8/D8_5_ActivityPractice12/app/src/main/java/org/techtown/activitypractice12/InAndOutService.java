package org.techtown.activitypractice12;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

public class InAndOutService extends Service {
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
            processCommand(intent);
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

        for (int i = 0; i < 3; i++)
        {
            try
            {
                Thread.sleep(1000);
            } catch (Exception e) {};
        }

        Intent showIntent = new Intent(getApplicationContext(), MainActivity.class);

        showIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|
                Intent.FLAG_ACTIVITY_SINGLE_TOP|Intent.FLAG_ACTIVITY_CLEAR_TOP);

        showIntent.putExtra("command", command);
        showIntent.putExtra("text", text + "\n\nfrom Service :)");

        startActivity(showIntent);
    }
}