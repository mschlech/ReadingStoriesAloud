package com.entscheidungsbaum.soundcloud.trial;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.AsyncTaskLoader;
import android.support.v4.content.Loader;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.entscheidungsbaum.soundcloud.trial.adapters.SoundCloudTrackListAdapter;
import com.entscheidungsbaum.soundcloud.trial.data.Tracks;

import java.util.ArrayList;
import java.util.List;

/**
 * marcus
 * SoundCloudTrial
 * <p/>
 * 30.04.2012
 */
public class SoundCloudRecord extends FragmentActivity implements  View.OnClickListener {

    final String LOG_TAG = "SoundCloudRecord";
    SoundCloudTrackListAdapter sctla;
    private  List<Tracks> trackList;

    /* (non-Javadoc)
      * @see android.app.Activity#onCreate(android.os.Bundle)
      */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.soundcloudmain);
        ViewPager pager = (ViewPager) findViewById(R.id.pager);


        setContentView(R.layout.soundcloudlist);
    }

    @Override
    public void onClick(View view) {

    }


    /**
     * take async task loader
     * wenn nicht context verwendet wird dann ok. wenn einwaende dann static class SearchTask
     * wenn nicht asyn task loader benutzt wird
     */
//    private static class SearchTask extends AsyncTask<Void, String, ArrayList<Tracks>> {
//
//        @Override
//        protected ArrayList<Tracks> doInBackground(Void... strings) {
//            return null;
//
//        }
//    }

    private static class TrackUploaderLoader  extends AsyncTaskLoader<List<Tracks>> {
        
        public TrackUploaderLoader(final Context context) {
            super(context);
        }
        @Override
        public List<Tracks> loadInBackground() {
            return null;  //To change body of implemented methods use File | Settings | File Templates.
        }
    }
}

