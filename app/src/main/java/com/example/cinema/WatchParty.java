package com.example.cinema;

public class WatchParty {
    private String imageResId;
    private String showTime;
    private String date;
    private String runtime;
    private String videoUrl;
    private String title;

    public WatchParty() {
    }

    public WatchParty(String imageResId, String showTime, String date, String runtime) {
        this.imageResId = imageResId;
        this.showTime = showTime;
        this.date = date;
        this.runtime = runtime;
    }
    public WatchParty(String imageResId, String showTime, String date, String runtime, String videoUrl) {
        this.imageResId = imageResId;
        this.showTime = showTime;
        this.date = date;
        this.runtime = runtime;
        this.videoUrl = videoUrl;
    }
    public WatchParty(String title, String videoUrl) {
        this.title = title;
        this.videoUrl = videoUrl;
    }
    public String getImageResId() {
        return imageResId;
    }

    public String getShowTime() {
        return showTime;
    }


    public String getDate() {
        return date;
    }

    public String getRuntime() {
        return runtime;
    }
    public String getVideoUrl() {
        return videoUrl;
    }

    public void setMovieUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }
    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title=title;
    }
}
