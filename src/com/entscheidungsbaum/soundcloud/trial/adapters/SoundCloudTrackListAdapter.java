package com.entscheidungsbaum.soundcloud.trial.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.entscheidungsbaum.soundcloud.trial.R;
import com.entscheidungsbaum.soundcloud.trial.data.Tracks;

import java.util.ArrayList;

/**
 * marcus
 * SoundCloudTrial
 * <p/>
 * 30.04.2012
 */
public class SoundCloudTrackListAdapter extends BaseAdapter {

    private static final String LOG_TAG = "SoundCloudTrackListAdapter.class";


    ArrayList<Tracks> aTrackList;

    public Activity anActivityContext;
    public LayoutInflater inflater;

    public SoundCloudTrackListAdapter(Activity activityContext,
                                      ArrayList<Tracks> stationsList) {
        super();
        this.anActivityContext = activityContext;
        this.aTrackList = stationsList;
        this.inflater = (LayoutInflater) activityContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public int getCount() {
        // TODO Auto-generated method stub
        return aTrackList.size();
    }

    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return aTrackList.get(position);
    }

    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;

    }


    /* (non-Javadoc)
          * @see android.widget.BaseAdapter#notifyDataSetChanged()
          */
    @Override
    public void notifyDataSetChanged() {
        // TODO Auto-generated method stub
        super.notifyDataSetChanged();
    }

    /**
     * @TODO implement the holder referring to the viewId
     */
    /* (non-Javadoc)
          * @see android.widget.Adapter#getView(int, android.view.View, android.view.ViewGroup)
          */
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.soundcloudtracklist, null);

            holder.userIcon = (ImageView) convertView
                    .findViewById(R.id.userIcon);
           holder.trackName = (TextView) convertView.findViewById(R.id.trackname);
            holder.trackDetails = (TextView) convertView.findViewById(R.id.trackdetails);

//            holder.lastCheckin = (TextView) convertView
//                    .findViewById(R.id.lastcheckin);

            convertView.setTag(holder);

        } else
            holder = (ViewHolder) convertView.getTag();

        Tracks track = (Tracks) aTrackList.get(position);

        holder.userIcon.setImageResource(track.userIcon);
        holder.trackName.setText(track.trackName);
      //  holder.trackOwner.setText(track.trackOwner);

        holder.lastCheckin.setText(String.valueOf(track.dateUpdatedStamp));
        //	holder.distance.setText(track.getDistance());
        /*
               * more to follow here
               */

        return convertView;
    }

    public static class ViewHolder {

        ImageView userIcon;
        TextView trackName;
        TextView trackDetails;
     //   TextView trackOwner;

        TextView duration;
        TextView set;

        TextView lastCheckin;
    }

}


