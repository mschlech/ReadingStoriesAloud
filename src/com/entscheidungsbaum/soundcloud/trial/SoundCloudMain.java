package com.entscheidungsbaum.soundcloud.trial;

import android.app.TabActivity;
import android.content.Intent;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;
import com.entscheidungsbaum.soundcloud.trial.service.ReadingStoriesAloudAuthService;

/**
 * @author marcus 29.04.2012
 */
public class SoundCloudMain extends TabActivity {

    private final String LOG_TAG = "SoundCloudMain";

    // private RecordButton mRecordButton = null;
    private MediaRecorder mRecorder = null;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.soundcloudmain);
        try {
          //  ReadingStoriesAloudAuthService.getMe();
          // ReadingStoriesAloudAuthService.getJsonStrings("me/tracks","title");
           ReadingStoriesAloudAuthService.getMyTracksFromSoundCloud();
        } catch (Exception e) {
            Log.e(LOG_TAG, "Exception in main activity getMe() " + e);
        }
        setTabs();
    }

    private void setTabs() {
        addTab("record", R.drawable.tab_home,
                SoundCloudRecord.class);
        addTab("my Tracks", R.drawable.tab_search, SoundCloudRecordList.class);
        addTab("My Profile", R.drawable.tab_search, SoundCloudProfile.class);
    }

    private void addTab(String labelId, int drawableId, Class<?> c) {
        Log.i(LOG_TAG, "label id = " + labelId + " drawable id = " + drawableId);
        TabHost tabHost = getTabHost();
        Intent intent = new Intent(this, c);
        TabHost.TabSpec spec = tabHost.newTabSpec("tab" + labelId);

        View tabIndicator = LayoutInflater.from(this).inflate(
                R.layout.tab_indicator, getTabWidget(), false);
        TextView title = (TextView) tabIndicator.findViewById(R.id.title);
        Log.i(LOG_TAG, " title " + title.getId());
        title.setText(labelId);
        ImageView icon = (ImageView) tabIndicator.findViewById(R.id.icon);
        icon.setImageResource(drawableId);

        spec.setIndicator(tabIndicator);
        spec.setContent(intent);
        tabHost.addTab(spec);
    }

}