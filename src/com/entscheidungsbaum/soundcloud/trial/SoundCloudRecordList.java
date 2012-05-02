package com.entscheidungsbaum.soundcloud.trial;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.AsyncTaskLoader;
import android.support.v4.content.Loader;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import com.entscheidungsbaum.soundcloud.trial.adapters.SoundCloudTrackListAdapter;
import com.entscheidungsbaum.soundcloud.trial.data.Tracks;
import com.entscheidungsbaum.soundcloud.trial.service.ReadingStoriesAloudAuthService;

import java.util.ArrayList;
import java.util.List;

/**
 * marcus
 * SoundCloudTrial
 * <p/>
 * 30.04.2012
 */
public class SoundCloudRecordList extends Fragment implements LoaderManager.LoaderCallbacks<List<Tracks>>, View.OnClickListener {

    final String LOG_TAG = "SoundCloudRecordList";
    SoundCloudTrackListAdapter sctla;
    private List<Tracks> trackList;


    private ListView lv;



    /* (non-Javadoc)
      * @see android.app.Activity#onCreate(android.os.Bundle)
      */
    @Override
     public View  onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        Log.i(LOG_TAG, "oncreate ");
        if(viewGroup == null) {
            return null;
        }
        // trackList = new SearchTask().doInBackground();
        // sctla = new SoundCloudTrackListAdapter(this, trackList);

        this.getActivity().getSupportLoaderManager().initLoader(0, null, SoundCloudRecordList.this).forceLoad();

//        setContentView(R.layout.soundcloudlist);
        View v =  inflater.inflate(R.layout.soundcloudlist,viewGroup,false) ;
        lv = (ListView) v.findViewById(R.id.soundcloudlist);
        return v;
//        Button b = (Button) findViewById(R.id.button);
//        b.setOnClickListener(new OnClickListener() {
//            @Override
//            public void onClick(View view) {
//            }
//        });
    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public Loader<List<Tracks>> onCreateLoader(int i, Bundle bundle) {
        Log.i(LOG_TAG, "onCreateLoader ");

        return new TrackListLoader(getActivity().getApplicationContext());
    }

    @Override
    public void onLoadFinished(Loader<List<Tracks>> listLoader, List<Tracks> tracks) {
       // ArrayAdapter<Tracks> trackList = new ArrayAdapter<Tracks>(this, R.layout.soundcloudtracklist, tracks);

        lv.setAdapter(new SoundCloudTrackListAdapter(getActivity().getApplicationContext(),tracks));

    }

    @Override
    public void onLoaderReset(Loader<List<Tracks>> listLoader) {
        lv.setAdapter(null);
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

    private static class TrackListLoader extends AsyncTaskLoader<List<Tracks>> {

        public TrackListLoader(final Context context) {
            super(context);
            Log.i("TracklistLoader", "Constructore invoked");

        }

        @Override
        public List<Tracks> loadInBackground() {
            Log.i("TracklistLoader", "load in Backround ");
                       List<Tracks> tracks = new ArrayList<Tracks>();

            try {
                return ReadingStoriesAloudAuthService.getMyTracksFromSoundCloud();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return tracks;
        }
    }
}


