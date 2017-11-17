package com.example.mat.developingapplicationtp;

import android.Manifest;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;

public class Activity3Download extends AppCompatActivity {
    public static String TAG = "ThirdActivity";
    public static final int PERMISSIONS_REQUEST = 0;
    public static final String REQUEST_URL = "url";
    public static final String URL_PATH = "https://goo.gl/WQQfyP";
    public static final String INTENT_FILTER = "filter";
    public static String EVENTS_FILE_PATH = "";
    public static String EVENT_EXTRA = "event";
    Button downloadButton;
    //private DatabaseHandler db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity3_download);
        downloadButton = (Button) findViewById(R.id.downloadButton);

        EVENTS_FILE_PATH = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS) + "/events.txt";

    }

    public void downloadFile(View view) {
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {

            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.READ_EXTERNAL_STORAGE)) {

                // Show an explanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.

            } else {

                // No explanation needed, we can request the permission.
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                        PERMISSIONS_REQUEST);

                // MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE is an
                // app-defined int constant. The callback method gets the
                // result of the request.

            }

        } else {

            // Permission already granted, Do the
            // storage-related task you need to do.
            if (!new File(EVENTS_FILE_PATH).exists()) {
                downloadEvents();
            } else {
                Log.d(TAG,"File exist");
                //parseEvents();
                //printEvents();
                //listEvents();
            }
        }

    }
    private void downloadEvents() {
        Log.d(TAG, "Downloading events...");
        Intent intent = new Intent(this, DownloadService.class);
        intent.putExtra(REQUEST_URL, URL_PATH);
        startService(intent);
    }
}

    /*
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity3_download);

        EVENTS_FILE_PATH = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS) + "/events.txt";

        //db = new DatabaseHandler(this);
        //db.clear();

        // Ask for permission.
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {

            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.READ_EXTERNAL_STORAGE)) {

                // Show an explanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.

            } else {

                // No explanation needed, we can request the permission.
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                        PERMISSIONS_REQUEST);

                // MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE is an
                // app-defined int constant. The callback method gets the
                // result of the request.

            }

        } else {

            // Permission already granted, Do the
            // storage-related task you need to do.
            if (!new File(EVENTS_FILE_PATH).exists()) {
                downloadEvents();
            } else {
                Log.d(TAG,"File exist");
                parseEvents();
                printEvents();
                listEvents();
            }
        }
    }

    @Override
    public void onResume() {
        super.onResume();

        // Register the eventReceiver
        LocalBroadcastManager.getInstance(this).registerReceiver(eventReceiver,
                new IntentFilter(INTENT_FILTER));

    }

    private BroadcastReceiver eventReceiver = new BroadcastReceiver() {

        @Override
        public void onReceive(Context context, Intent intent) {
            Log.d(TAG, "Event receiveds...");

            ////////////////////////////////////////////////////////////////////////////////////////
            // TODO                                                                               //
            // The activity is notified by the DownloadService.                                   //
            // Run the post download related functions here:                                      //
            // - parseEvents();                                                                   //
            // - printEvents();                                                                   //
            // - listEvents();                                                                    //
            ////////////////////////////////////////////////////////////////////////////////////////

        }

    };

    @Override
    public void onRequestPermissionsResult(int request, String permissions[], int[] results) {
        switch (request) {
            case PERMISSIONS_REQUEST: {
                // If request is cancelled, the result arrays are empty.
                if (results.length > 0 && results[0] == PackageManager.PERMISSION_GRANTED) {

                    // permission was granted, yay! Do the
                    // storage-related task you need to do.
                    downloadEvents();
                } else {

                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                    Toast.makeText(this, "Permission denied to read your external storage", Toast.LENGTH_SHORT).show();
                }
                return;
            }

            // other 'case' lines to check for other
            // permissions this app might request
        }
    }

    private void downloadEvents() {
        Log.d(TAG, "Downloading events...");
        Intent intent = new Intent(this, DownloadService.class);
        intent.putExtra(REQUEST_URL, URL_PATH);
        startService(intent);
    }

    private void parseEvents() {
        Log.d(TAG, "Parsing...");

        ////////////////////////////////////////////////////////////////////////////////////////////
        // TODO                                                                                   //
        // Parse the downloaded file line by line and add all the parsed data to the database.    //
        ////////////////////////////////////////////////////////////////////////////////////////////

    }

    private void printEvents() {
        Log.d(TAG, "Printing...");

        ////////////////////////////////////////////////////////////////////////////////////////////
        // TODO                                                                                   //
        // Get all the rows from the database and print the data in the console.                  //
        ////////////////////////////////////////////////////////////////////////////////////////////

    }

    private void listEvents() {
        Log.d(TAG, "Listing...");

        ////////////////////////////////////////////////////////////////////////////////////////////
        // TODO                                                                                   //
        // Visualize the database data with a ListView:                                           //
        // - Get the list from database                                                           //
        // - Copy to a new list                                                                   //
        // - Create the ListView                                                                  //
        // - Handle onClick event                                                                 //
        ////////////////////////////////////////////////////////////////////////////////////////////

    }

    public void back(View view) {
        finish();
    }

}
    */