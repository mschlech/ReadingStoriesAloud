package com.entscheidungsbaum.soundcloud.trial;

import android.media.MediaRecorder;
import android.os.Bundle;
import android.support.v4.app.*;
import android.support.v4.view.ViewPager;
import android.util.Log;
import com.viewpagerindicator.TitlePageIndicator;

import java.util.ArrayList;
import java.util.List;

/**
 * @author marcus 29.04.2012
 */
public class SoundCloudMain extends FragmentActivity {

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
        ViewPager pager = (ViewPager) findViewById(R.id.pager);
        List<Fragment> fragmentList = new ArrayList<Fragment>();
        //FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        /**
         * for each tab
         */
        fragmentList.add(Fragment.instantiate(this, SoundCloudRecordList.class.getName()));

       // getSupportFragmentManager().executePendingTransactions();
        PagerAdapter pagerAdapter = new PagerAdapter(getSupportFragmentManager(),fragmentList );
        pager.setAdapter(pagerAdapter);

        TitlePageIndicator titleIndicator = (TitlePageIndicator)findViewById(R.id.titles);
        titleIndicator.setViewPager(pager);

        /**
         * from android 4 no networking task in ui thread
         */
//        try {
//          //  ReadingStoriesAloudAuthService.getMe();
//          ReadingStoriesAloudAuthService.getJsonStrings("me");
//           //ReadingStoriesAloudAuthService.getMyTracksFromSoundCloud();
//        } catch (Exception e) {
//            Log.e(LOG_TAG, "Exception in main activity getMe() " + e);
//        }
        //setTabs();
    }

    //    private void setTabs() {
//        addTab("record list", R.drawable.tab_home,
//                SoundCloudRecordList.class);
//        addTab("my Tracks", R.drawable.tab_search, SoundCloudRecord.class);
//        addTab("My Profile", R.drawable.tab_search, SoundCloudProfile.class);
//    }
//
//    private void addTab(String labelId, int drawableId, Class<?> c) {
//        Log.i(LOG_TAG, "label id = " + labelId + " drawable id = " + drawableId);
//        TabHost tabHost = getTabHost();
//        Intent intent = new Intent(this, c);
//        TabHost.TabSpec spec = tabHost.newTabSpec("tab" + labelId);
//
//        View tabIndicator = LayoutInflater.from(this).inflate(
//                R.layout.tab_indicator, getTabWidget(), false);
//        TextView title = (TextView) tabIndicator.findViewById(R.id.title);
//        Log.i(LOG_TAG, " title " + title.getId());
//        title.setText(labelId);
//        ImageView icon = (ImageView) tabIndicator.findViewById(R.id.icon);
//        icon.setImageResource(drawableId);
//
//        spec.setIndicator(tabIndicator);
//        spec.setContent(intent);
//        tabHost.addTab(spec);
//    }
    static class PagerAdapter extends FragmentPagerAdapter {

        List<Fragment> mFragmentList;

        static String LOG_TAG="PageAdapter";
        
        PagerAdapter(FragmentManager fm, List<Fragment> fragments) {
            super(fm);

            this.mFragmentList = fragments;
        }

        @Override
        public Fragment getItem(int i) {
            Log.i(LOG_TAG, " you hit " + i);
            return mFragmentList.get(i);
        }

        @Override
        public int getCount() {
            Log.i(LOG_TAG, " size "  + mFragmentList.size());
            return mFragmentList.size();
        }
    }
}