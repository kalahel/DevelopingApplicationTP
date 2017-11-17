package com.example.mat.developingapplicationtp;

import android.app.IntentService;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Mathieu on 17/11/2017.
 */

public class DownloadService extends IntentService {

    public static String TAG = "DownloadService";

    public DownloadService() {
        super("DownloadService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            InputStream input = null;
            OutputStream output = null;
            HttpURLConnection connection = null;

            try {

                // Create connection with url
                Log.d(TAG, "Connecting...");
                URL url = new URL(intent.getStringExtra(Activity3Download.REQUEST_URL));
                connection = (HttpURLConnection) url.openConnection();
                connection.connect();

                // Get the input stream
                Log.d(TAG, "Downloading...");
                input = new BufferedInputStream(connection.getInputStream());

                // Write to file in sdcard/Download
                output = new FileOutputStream(Activity3Download.EVENTS_FILE_PATH);
                byte data[] = new byte[4096];
                while (input.read(data) != -1) {
                    output.write(data);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {

                // Close streams and connection
                try {
                    if (output != null) {
                        output.close();
                    }
                    if (input != null) {
                        input.close();
                    }
                } catch (IOException ignored) {
                }
                if (connection != null) {
                    connection.disconnect();
                }

                // Call the activity
                if(new File(Activity3Download.EVENTS_FILE_PATH).exists()) {
                    Log.d(TAG, "Done!");
                    Intent eventIntent = new Intent(Activity3Download.INTENT_FILTER);
                    LocalBroadcastManager.getInstance(this).sendBroadcast(eventIntent);
                }
            }

        }
    }

}
