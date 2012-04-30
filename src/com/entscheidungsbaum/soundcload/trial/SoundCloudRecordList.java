package com.entscheidungsbaum.soundcload.trial;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

/**
 * marcus
 * SoundCloudTrial
 *
 * 30.04.2012
 **/
public class SoundCloudRecordList extends Activity implements OnClickListener {

	ListView mySoundCloudTracks;
	
	SoundCloudTrackListAdapter = mSoundCloudListAdapter;
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
		setContentView(R.layout.main);
	}



	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub

	}

}


