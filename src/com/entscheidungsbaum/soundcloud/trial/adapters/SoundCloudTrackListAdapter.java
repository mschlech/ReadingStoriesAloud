package com.entscheidungsbaum.soundcloud.trial.adapters;

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
import java.util.List;

/**
 * marcus
 * SoundCloudTrial
 * <p/>
 * 30.04.2012
 */
public class SoundCloudTrackListAdapter extends BaseAdapter {

    private static final String LOG_TAG = "SoundCloudTrackListAdapter.class";

    private List<Tracks> trackList;
    private LayoutInflater inflater;

    public SoundCloudTrackListAdapter(Context context, List<Tracks> aTrackList) {
        trackList = new ArrayList<Tracks>(aTrackList);
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //  super(context, R.layout.soundcloudtracklist,aTrackList);
    }

    @Override
    public int getCount() {
        return trackList.size();  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Object getItem(int i) {
        return trackList.get(i);  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public long getItemId(int i) {
        return i;  //To change body of implemented methods use File | Settings | File Templates.
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
//            holder.trackDetails = (TextView) convertView.findViewById(R.id.trackdetails);

//            holder.lastCheckin = (TextView) convertView
//                    .findViewById(R.id.lastcheckin);

            convertView.setTag(holder);

        } else
            holder = (ViewHolder) convertView.getTag();

        Tracks track = (Tracks) getItem(position);

        holder.userIcon.setImageResource(track.userIcon);

        holder.trackName.setText(track.trackName);
        //  holder.trackOwner.setText(track.trackOwner);

        //      holder.lastCheckin.setText(String.valueOf(track.dateUpdatedStamp));
        //	holder.distance.setText(track.getDistance());
        /*
               * more to follow here
               */

        return convertView;
    }


    /**
     * avoid invoking findViewById(int)
     */
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


