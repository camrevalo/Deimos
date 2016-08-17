package com.example.carevaloe.deimos;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import java.util.*;
import android.widget.Button;
import android.content.pm.PackageManager;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Add padding to button because I have no fucking clue to do it otherwise
        formatButton((Button) findViewById(R.id.callEmergencyButton), R.drawable.emergency_call);
        formatButton((Button) findViewById(R.id.contactsButton), R.drawable.contacts);
        formatButton((Button) findViewById(R.id.mapButton), R.drawable.map);
        formatButton((Button) findViewById(R.id.facebookButton), R.drawable.facebook);
        formatButton((Button) findViewById(R.id.lockButton), R.drawable.lock);
        formatButton((Button) findViewById(R.id.messageButton), R.drawable.message);
        formatButton((Button) findViewById(R.id.emergencyButton), R.drawable.emergency);
        formatButton((Button) findViewById(R.id.helpButton), R.drawable.help);
        formatButton((Button) findViewById(R.id.legalButton), R.drawable.legal);
    }

    /**
     * Formats main activity buttons by adding padding, setting background resource, and disabling
     * auto-capitalization of string resources.
     * @param value The button object being formatted
     * @param resid 9patch bitmapped drawable resource for background image (includes padding)
     */
    private void formatButton(Button value, int resid) {
        /* Setting padding value does not do anything I don't think. leave commented out in case
           we figure this out
        int pL = value.getPaddingLeft();
        int pT = value.getPaddingTop();
        int pR = value.getPaddingRight();
        int pB = value.getPaddingBottom(); */

        value.setBackgroundResource(resid);
        value.setTransformationMethod(null);
        // value.setPadding(0, 0, 0, 0);
    }

    /**
     *
     * @param view
     */
    public void callEmergency_button_click(View view) {
        // TODO: swap out Joi's phone number for 911 (or whatever specified by Inseong)
        /* Design suggestion - get rid of "911" on button icon since it's not scaleable in regions
            where 911 is not the emeregency response number */
        Uri number = Uri.parse("tel:4088261594"); // joi's number for testing :p
        Intent callIntent = new Intent(Intent.ACTION_DIAL, number);

        // Verify a phone dial app is available to launch
        PackageManager packageManager = getPackageManager();
        List activities = packageManager.queryIntentActivities(callIntent,
                PackageManager.MATCH_DEFAULT_ONLY);
        boolean isIntentSafe = activities.size() > 0;

        if (isIntentSafe) {
            startActivity(callIntent);
        }
    }

    /**
     *
     * @param view
     */
    public void contacts_button_click(View view) {
        // TODO: get functionality guidance from Inseong

        // Likely will be launching another activity in-app
    }

    /**
     *
     * @param view
     */
    public void map_button_click(View view) {
        // TODO: swap out location for funcitonality specified by Inseong
        Uri location = Uri.parse("geo:0,0?q=1600+Amphitheatre+Parkway,+Mountain+View,+California");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, location);

        // Verify a maps app is available to launch
        PackageManager packageManager = getPackageManager();
        List activities = packageManager.queryIntentActivities(mapIntent,
                PackageManager.MATCH_DEFAULT_ONLY);
        boolean isIntentSafe = activities.size() > 0;

        if (isIntentSafe) {
            startActivity(mapIntent);
        }
    }

    /**
     *
     * @param view
     */
    public void facebook_button_click(View view) {
        // TODO: get functionality guidance from Inseong (what kind of fb navigation do we want?)
        Uri launchScreen = Uri.parse("facebook:/newsfeed");
        Intent fbIntent = new Intent("android.intent.category.LAUNCHER", launchScreen);
        fbIntent.setClassName("com.facebook.katana", "com.facebook.katana.LoginActivity");

        // Verify a maps app is available to launch
        PackageManager packageManager = getPackageManager();
        List activities = packageManager.queryIntentActivities(fbIntent,
                PackageManager.MATCH_DEFAULT_ONLY);
        boolean isIntentSafe = activities.size() > 0;

        if (isIntentSafe) {
            startActivity(fbIntent);
        }
    }

    /**
     *
     * @param view
     */
    public void lock_button_click(View view) {
        // TODO: get functionality guidance from Inseong
    }

    /**
     *
     * @param view
     */
    public void message_button_click(View view) {
        // TODO: get functionality guidance from Inseong (launch Messenger / messaging app interface?)
    }

    /**
     *
     * @param view
     */
    public void emergency_button_click(View view) {
        // TODO: get functionality guidance from Inseong

    }

    /**
     *
     * @param view
     */
    public void help_button_click(View view) {
        // TODO: get functionality guidance from Inseong; likely launch annother activity with a text view that describes what's going on

    }

    /**
     *
     * @param view
     */
    public void legal_button_click(View view) {
        // TODO: get functionality guidance from Inseong; likely launch annother activity with a text view that describes what's going on

    }


}
