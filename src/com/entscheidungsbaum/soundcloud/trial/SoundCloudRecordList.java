package com.entscheidungsbaum.soundcloud.trial;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListView;
import com.entscheidungsbaum.soundcloud.trial.adapters.SoundCloudTrackListAdapter;
import com.entscheidungsbaum.soundcloud.trial.data.Tracks;

import java.util.ArrayList;

/**
 * marcus
 * SoundCloudTrial
 *
 * 30.04.2012
 **/
public class SoundCloudRecordList extends Activity implements OnClickListener {

	ListView mySoundCloudTracks;
	
	SoundCloudTrackListAdapter mListAdapter;
	private ArrayList<Tracks> soundCloudTracks;
	
	
	public SoundCloudRecordList() {
		// TODO Auto-generated constructor stub
	}

	
	
	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.soundcloudtracklist);
        ListView lv = (ListView) findViewById(R.id.soundcloudlist);

	}



	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub

	}

}


