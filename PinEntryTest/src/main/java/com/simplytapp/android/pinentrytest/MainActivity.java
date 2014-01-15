package com.simplytapp.android.pinentrytest;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

import com.simplytapp.android.pinentrylib.PinDialog;


public class MainActivity extends Activity implements PinDialog.ResultHandler {

    private final static String TAG = "PINLIB_DEMO";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void displayPinDialog(View view) {
        new PinDialog("Enter Pin Code", "Cancel", view.getContext()).show(this);
    }

    @Override
    public void pinSet(String pin) {
        String message = "Pin Set: " + pin;
        Log.d(TAG, message);
        Toast toast = Toast.makeText(this, message, Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }

    @Override
    public void pinCancelled() {
        String message = "Pin Cancelled";
        Log.d(TAG, message);
        Toast toast = Toast.makeText(this, message, Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }
}
