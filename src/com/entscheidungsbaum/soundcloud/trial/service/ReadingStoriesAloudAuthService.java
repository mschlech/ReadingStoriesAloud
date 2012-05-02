package com.entscheidungsbaum.soundcloud.trial.service;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import com.soundcloud.api.ApiWrapper;
import com.soundcloud.api.Env;
import com.soundcloud.api.Token;

/**
 * marcus SoundCloudTrial
 * <p/>
 * 30.04.2012
 */
public class ReadingStoriesAloudAuthService extends Service {

    final String LOG_TAG = "ReadingStoriesAloudAuthService";

    final String CLIENT_ID = "d88a5f695232355d8413e8392a8ecb21";
    final String CLIENT_SECRET = "c8ee69e777a64346401cbb4c8c4cf1d1";


    final String END_USER_AUTHORIZATON_URL = "https://soundcloud.com/connect";
    final String TOKEN = "https://api.soundcloud.com/oauth2/token";

    final String TAG = "";

    AccountManager mAccountManager;
    Account mAccount;


    ApiWrapper mWrapper;
    Token token;

    public void authenticate() throws Exception {
        String username = "mschlech";
        String passwd = "linus123";
        mWrapper = new ApiWrapper(CLIENT_ID, CLIENT_SECRET, null, null, Env.LIVE);
        Token token;
        Log.d(LOG_TAG, "got a wrapper " );
        if (mWrapper.debugRequests) {
            Log.d(LOG_TAG, "Debug request");
        }
        Log.d(LOG_TAG, "get a token " + mWrapper.getToken().valid() );
        token=mWrapper.login(username, passwd);

        Log.d(LOG_TAG, " getToken in authenticate" + token);

    }

    @Override
    public IBinder onBind(Intent arg0) {
        // TODO Auto-generated method stub
        return null;
    }

}
