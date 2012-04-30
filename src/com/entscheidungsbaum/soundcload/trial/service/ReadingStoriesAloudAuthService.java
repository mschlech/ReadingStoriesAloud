package com.entscheidungsbaum.soundcload.trial.service;

import android.app.Service;
import android.content.Intent;
import android.net.Uri;
import android.os.IBinder;

/**
 * marcus SoundCloudTrial
 * 
 * 30.04.2012
 **/
public class ReadingStoriesAloudAuthService extends Service {

	final String CLIENT_ID = "d88a5f695232355d8413e8392a8ecb21";
	final String CLIENT_SECRET = "d88a5f695232355d8413e8392a8ecb21";

	final String END_USER_AUTHORIZATON_URL = "https://soundcloud.com/connect";
	final String TOKEN = "https://api.soundcloud.com/oauth2/token";
	
	final String TAG="";
	
	@Override
	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
		return null;
	}

}
