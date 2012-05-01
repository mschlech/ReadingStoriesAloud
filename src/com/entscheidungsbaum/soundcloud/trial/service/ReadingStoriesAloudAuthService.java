package com.entscheidungsbaum.soundcloud.trial.service;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import com.soundcloud.api.ApiWrapper;
import com.soundcloud.api.Env;

/**
 * marcus SoundCloudTrial
 * 
 * 30.04.2012
 **/
public class ReadingStoriesAloudAuthService extends Service {

    final String LOG_TAG = "ReadingStoriesAloudAuthService";

	final String CLIENT_ID = "d88a5f695232355d8413e8392a8ecb21";
	final String CLIENT_SECRET = "d88a5f695232355d8413e8392a8ecb21";


	final String END_USER_AUTHORIZATON_URL = "https://soundcloud.com/connect";
	final String TOKEN = "https://api.soundcloud.com/oauth2/token";
	
	final String TAG="";

    AccountManager mAccountManager ;
    Account mAccount;

    ApiWrapper mWrapper;

    public void authenticate(){
        String username ="marcus.schlechter@yahoo.de";
        String passwd ="linus123";
        mWrapper = new ApiWrapper(CLIENT_ID,CLIENT_SECRET, null, null, Env.LIVE);
        Log.d(LOG_TAG, " getToken in authenticate" + mWrapper.getToken());


    }

	@Override
	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
		return null;
	}

}
