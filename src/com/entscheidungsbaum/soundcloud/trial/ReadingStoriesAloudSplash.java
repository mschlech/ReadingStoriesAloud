package com.entscheidungsbaum.soundcloud.trial;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.TextView;
import com.entscheidungsbaum.soundcloud.trial.service.ReadingStoriesAloudAuthService;
import com.soundcloud.api.ApiWrapper;
import com.soundcloud.api.Env;
import com.soundcloud.api.Token;

/**
 * marcus
 * SoundCloudTrial
 * <p/>
 * 30.04.2012
 */
public class ReadingStoriesAloudSplash extends Activity {

    private SharedPreferences prefs;

    final String LOG_TAG = "ReadingStoriesAloadSplash";
    final String CLIENT_ID = "d88a5f695232355d8413e8392a8ecb21";
    final String CLIENT_SECRET = "c8ee69e777a64346401cbb4c8c4cf1d1";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        prefs = PreferenceManager.getDefaultSharedPreferences(this);

        setContentView(R.layout.soundcloudsplash);

        final ApiWrapper mWrapper = new ApiWrapper(CLIENT_ID.trim(), CLIENT_SECRET.trim(), null, null, Env.LIVE);
        Log.d(LOG_TAG, "got a wrapper ");
//        TextView tv = (TextView) findViewById(R.id.token);
//       Token token;
        try
        {
//         token = ReadingStoriesAloudAuthService.authenticate();
//         Log.d(LOG_TAG, "got token  = " + token.toString());
//         tv.setText(token.toString());

        }
        catch (Exception e) {
            
        }
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
    public boolean onTouchEvent(final MotionEvent motionEvent) {
        if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
            /**
             * log in into soundcloud using java wrapper api
             */
            ReadingStoriesAloudAuthService rsaas = new ReadingStoriesAloudAuthService();
           try{
            rsaas.authenticate();
           } catch (Exception e){
                Log.e(LOG_TAG, "Exception in authentication occured" +  e);
               e.printStackTrace();
            }
            startActivity(new Intent(ReadingStoriesAloudSplash.this, SoundCloudMain.class));
        }
        return true;
    }
}


