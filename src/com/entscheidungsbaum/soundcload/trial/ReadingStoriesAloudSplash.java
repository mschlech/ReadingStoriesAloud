package com.entscheidungsbaum.soundcload.trial;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.MotionEvent;
import com.entscheidungsbaum.soundcload.trial.service.ReadingStoriesAloudAuthService;

/**
 * marcus
 * SoundCloudTrial
 * <p/>
 * 30.04.2012
 */
public class ReadingStoriesAloudSplash extends Activity {

    private SharedPreferences prefs;

    final String LOG_TAG = "ReadingStoriesAloadSplash";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        prefs = PreferenceManager.getDefaultSharedPreferences(this);

        setContentView(R.layout.soundcloudsplash);
        initPrefs();
    }

    private void initPrefs() {
        boolean debugEnabled = prefs.getBoolean("debugenabled", false);

        boolean splashSeenOnce = prefs.getBoolean("splashseenonce", false);
        if (!splashSeenOnce) {
            SharedPreferences.Editor editor = prefs.edit();
            editor.putBoolean("splashseenonce", true);
            editor.commit();
        }

        // TODO debug this, the JIT might somehow roll on past even when splash
        // enabled?
//        boolean showSplash = prefs.getBoolean("showsplash", false);
//        if (!showSplash && splashSeenOnce) {
//            Log.i(LOG_TAG, " Splash has already seen once ");
//            startActivity(new Intent(ReadingStoriesAloudSplash.this,
//                   SoundCloudMain.class));
//        } else {
//
//            // @TODO get the location
//            Log.i(LOG_TAG, "");
//            if (ProximityServiceHelper.lastLocation != null) {
//
//                Log.i(LOG_TAG, "last location not null ");
//               } else {
//                Log.i(LOG_TAG, "last location  null invoking onPreExecute ");
//
//            }
//         }

    }

    /**
     * fool the user starting backround tasks upfront to gain some time to do login , location updates and stuff
     */
    @Override
    public boolean onTouchEvent(final MotionEvent e) {
        if (e.getAction() == MotionEvent.ACTION_DOWN) {
            /**
             * log in into soundcloud using java wrapper api
             */
            ReadingStoriesAloudAuthService rsaas = new ReadingStoriesAloudAuthService();
            rsaas.authenticate();

            startActivity(new Intent(ReadingStoriesAloudSplash.this, SoundCloudMain.class));
        }
        return true;
    }
}


