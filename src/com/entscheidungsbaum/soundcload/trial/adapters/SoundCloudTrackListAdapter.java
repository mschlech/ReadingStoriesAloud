package com.entscheidungsbaum.soundcload.trial.adapters;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.entscheidungsbaum.soundcload.trial.R;
import com.entscheidungsbaum.soundcload.trial.data.Tracks;

/**
 * marcus
 * SoundCloudTrial
 *
 * 30.04.2012
 **/
public class SoundCloudTrackListAdapter extends BaseAdapter{


		
		private static final String LOG_TAG = "SoundCloudTrackListAdapter.class";


		ArrayList<Tracks> aTrackList;

		public Activity anActivityContext;
		public LayoutInflater inflater;

		public SoundCloudTrackListAdapter(Activity activityContext,
				ArrayList<Tracks> stationsList) {
			super();
//			super(context ,R.layout.fuel_station_list,stationsList);
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
				convertView = inflater.inflate(R.layout.foxstationslist, null);

				holder.brandIcon = (ImageView) convertView
						.findViewById(R.id.brandIcon);

				holder.brand = (TextView) convertView.findViewById(R.id.brand);

				holder.fueltype = (TextView) convertView
						.findViewById(R.id.fueltype);

				holder.price = (TextView) convertView.findViewById(R.id.price);

				holder.city = (TextView) convertView.findViewById(R.id.city);
				holder.street = (TextView) convertView.findViewById(R.id.street);
				holder.lastCheckin = (TextView) convertView
						.findViewById(R.id.lastcheckin);

				holder.distance = (TextView) convertView
						.findViewById(R.id.distance);
				convertView.setTag(holder);

			} else
				holder = (ViewHolder) convertView.getTag();

			Tracks track = (Tracks) aTrackList.get(position);
			holder.brandIcon.setImageResource(track.brandIcon);
			holder.brand.setText(track.brand);
			holder.street.setText(track.street);
//			holder.fueltype.setText(track.getFuelType1());
//		@TODO select fuelprice and type on preference base overlay menue selection
			holder.price.setText(String.valueOf(track.fuelprice1));
			holder.city.setText(track.city);
			holder.lastCheckin.setText(String.valueOf(track.dateUpdatedStamp));
		//	holder.distance.setText(track.getDistance());
			/*
			 * more to follow here
			 */

			return convertView;
		}

		/**
		 * for further purposes String brand; int brandIcon; String street; String
		 * city; String phonenumber; double longitude; double latitude; double
		 * altitude; double accuracy; String locationName; int areaCode; String
		 * lastCheckin;
		 **/
		public static class ViewHolder {
			TextView trackname;
			
			TextView duration;
			TextView fueltype;
			TextView price;
			TextView street;
			TextView city;
			TextView phonenumber;
			TextView longitude;
			TextView lastCheckin;

			/**
			 * not necessary to be displayed
			 */
			TextView latitude;
			TextView altitude;
			TextView accuracy;
			TextView locationName;
			TextView areaCode;
		}

}


