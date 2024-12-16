package com.example.cinema;

public class SettingItem {
    private int iconResId;
    private String name;

    public SettingItem(int iconResId, String name) {
        this.iconResId = iconResId;
        this.name = name;
    }

    public int getIconResId() {
        return iconResId;
    }

    public String getName() {
        return name;
    }
}
