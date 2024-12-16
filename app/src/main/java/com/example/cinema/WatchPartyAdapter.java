package com.example.cinema;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import java.util.List;

public class WatchPartyAdapter extends BaseAdapter {
    private Context context;
    private List<WatchParty> watchPartyList;
    private OnJoinClickListener joinClickListener;

    public WatchPartyAdapter(Context context, List<WatchParty> watchPartyList, OnJoinClickListener joinClickListener) {
        this.context = context;
        this.watchPartyList = watchPartyList;
        this.joinClickListener = joinClickListener;
    }

    @Override
    public int getCount() {
        return watchPartyList.size();
    }

    @Override
    public Object getItem(int position) {
        return watchPartyList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    private Drawable getImageDrawable(Context context, String imageName) {
        int resourceId = context.getResources().getIdentifier(imageName, "drawable", context.getPackageName());
        Log.d("WatchPartyAdapter", "Image name: " + imageName + ", Resource ID: " + resourceId);
        if (resourceId != 0) {
            return ContextCompat.getDrawable(context, resourceId);
        } else {
            return null;
        }
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.watchparties, parent, false);
            holder = new ViewHolder();
            holder.imageViewPoster = convertView.findViewById(R.id.imageViewPoster);
            holder.textViewShowTime = convertView.findViewById(R.id.textViewShowTime);
            holder.textViewDate = convertView.findViewById(R.id.textViewDate);
            holder.textViewRuntime = convertView.findViewById(R.id.textViewRuntime);
            holder.buttonJoin = convertView.findViewById(R.id.buttonJoin);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        WatchParty watchParty = watchPartyList.get(position);

        Drawable imageDrawable = getImageDrawable(context, watchParty.getImageResId());
        if (imageDrawable != null) {
            holder.imageViewPoster.setImageDrawable(imageDrawable);
        } else {
            holder.imageViewPoster.setImageResource(R.drawable.wish); // Set a default image or handle accordingly
        }

        holder.textViewShowTime.setText("Show Time: "+watchParty.getShowTime());
        holder.textViewDate.setText("Show Date: "+watchParty.getDate());
        holder.textViewRuntime.setText("Run Time: "+watchParty.getRuntime());

        holder.buttonJoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (joinClickListener != null) {
                    joinClickListener.onJoinClick(watchParty);
                }
            }
        });

        return convertView;
    }

    static class ViewHolder {
        ImageView imageViewPoster;
        TextView textViewShowTime;
        TextView textViewDate;
        TextView textViewRuntime;
        Button buttonJoin;
    }

    public interface OnJoinClickListener {
        void onJoinClick(WatchParty watchParty);
    }
}
