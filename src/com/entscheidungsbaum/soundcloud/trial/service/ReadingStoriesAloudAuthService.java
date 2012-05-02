package com.entscheidungsbaum.soundcloud.trial.service;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.util.Log;
import com.entscheidungsbaum.soundcloud.trial.data.Tracks;
import com.soundcloud.api.*;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.params.HttpParams;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * marcus SoundCloudTrial
 * <p/>
 * 30.04.2012
 */
public class ReadingStoriesAloudAuthService {

    final static String LOG_TAG = "ReadingStoriesAloudAuthService";

    final static String CLIENT_ID = "d88a5f695232355d8413e8392a8ecb21";
    final static String CLIENT_SECRET = "c8ee69e777a64346401cbb4c8c4cf1d1";
    private static String username = "mschlech";
    private static String passwd = "linus123";

    final String END_USER_AUTHORIZATON_URL = "https://soundcloud.com/connect";
    final String TOKEN = "https://api.soundcloud.com/oauth2/token";

    static String TAG = "";

    static JSONObject jsonObject;
    static JSONArray jsonArray;
    private static String id;
    
    AccountManager mAccountManager;
    Account mAccount;


    public static Token authenticate() throws Exception {

        ApiWrapper mWrapper = new ApiWrapper(CLIENT_ID, CLIENT_SECRET, null, null, Env.LIVE);
        Token token;
        Log.d(LOG_TAG, "got a wrapper ");
        if (mWrapper.debugRequests) {
            Log.d(LOG_TAG, "Debug request");
        }
        Log.d(LOG_TAG, "get a token " + mWrapper.getToken().valid());
        token = mWrapper.login(username, passwd);

        Log.d(LOG_TAG, " getToken in authenticate" + token);
        return token;
    }


    /**
     * get an ApiWrapper of soundcloud
     *
     * @return
     * @throws Exception
     */
    private static ApiWrapper getApiWrapper() throws Exception {
        ApiWrapper mWrapper = new ApiWrapper(CLIENT_ID, CLIENT_SECRET, null, authenticate(), Env.LIVE);

        Log.d(LOG_TAG, "got a api wrapper ");
        if (mWrapper.debugRequests) {
            Log.d(LOG_TAG, "Debug request");
        }

        Log.d(LOG_TAG, " getApiWrapper getApiWrapper" + mWrapper);
        return mWrapper;
    }


    /**
     * /me request and the appropriate response of soundcloud
     *
     * @throws Exception
     */
    public static void getMe() throws Exception {
        final Request requestResource = Request.to("/me");
        ApiWrapper apiWrapper = getApiWrapper();
        try {
            HttpResponse soundCloudResponse = apiWrapper.get(requestResource);
            // soundCloudResponse.getStatusLine().getStatusCode()
            jsonObject = Http.getJSON(soundCloudResponse);
             id=jsonObject.get("id").toString();
            Log.d(LOG_TAG, "got the response of soundcloud " +jsonObject);

        } catch (Exception e) {
            Log.e(LOG_TAG, "exception  in httpresponse" + e);
        }
    }

    /**
     * i wish i could be scala
     *
     * @param resource
     * @throws Exception
     */
    public static void getJsonStrings(String resource) throws Exception {
        ApiWrapper apiWrapper = getApiWrapper();

        final Request requestResource = Request.to(resource);

        try {
            HttpResponse soundCloudResponse = apiWrapper.get(requestResource);
            final String jsonString = Http.getString(soundCloudResponse);
            jsonArray = new JSONArray(jsonString);
           Log.d(LOG_TAG, "got the response of soundcloud " + jsonArray);
        } catch (Exception e) {
            Log.e(LOG_TAG, "exception  in httpresponse" + e);
        }
        //Log.d(LOG_TAG, " KEY -  " + key + " VALUE " + jsonObject.get("title"));
    }


    /**
     * the track list of the authenticated user to be displayed on the tracklist view
     *
     * @return
     */
    public static List<Tracks> getMyTracksFromSoundCloud() throws Exception {
        ApiWrapper apiWrapper = getApiWrapper();

        final Request requestResource = Request.to("/me/tracks");
        Log.e(LOG_TAG, "json Response" + requestResource.toUrl());
        List<Tracks> trackList = new ArrayList<Tracks>();
        try {
           
            HttpResponse soundCloudResponse = apiWrapper.get(requestResource);

            if(soundCloudResponse.getStatusLine().getStatusCode()== HttpStatus.SC_OK) {
                final String jsonString = Http.getString(soundCloudResponse);
                jsonArray = new JSONArray(jsonString);
                for(int i = 0 ; i<jsonArray.length() ; i++  ){
                    Tracks tracks = new Tracks();
                    tracks.trackName=(String)jsonArray.getJSONObject(i).get("title");
                    trackList.add(tracks);
                }
            }  else {
                Log.e(LOG_TAG, "no valid json Response");
            }
           
        } catch (Exception e) {
            Log.e(LOG_TAG, "exception  in http track response " + e);
        }
          return trackList;

    }

}
