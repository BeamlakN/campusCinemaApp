package com.example.cinema;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class SettingsAdapter extends ArrayAdapter<String> {

    private Context context;
    private String[] settingNames;
    private int[] settingIcons;

    public SettingsAdapter(Context context, String[] settingNames, int[] settingIcons) {
        super(context, R.layout.setting_item, settingNames);
        this.context = context;
        this.settingNames = settingNames;
        this.settingIcons = settingIcons;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.setting_item, parent, false);

        ImageView icon = rowView.findViewById(R.id.settings_icon);
        TextView name = rowView.findViewById(R.id.settings_name);

        icon.setImageResource(settingIcons[position]);
        name.setText(settingNames[position]);

        return rowView;
    }
}
