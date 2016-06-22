package me.academeg.api.dataSet;

import org.json.simple.JSONObject;

public class Audio {

    private String artist;
    private String title;
    private long duration;
    private String url;
    private String lyricsId;

    public Audio() {
    }

    public String getArtist() {
        return artist;
    }

    public String getTitle() {
        return title;
    }

    public long getDuration() {
        return duration;
    }

    public String getUrl() {
        return url;
    }

    public String getLyricsId() {
        return lyricsId;
    }

    @Override
    public String toString() {
        return "Audio{" +
                "artist='" + artist + '\'' +
                ", title='" + title + '\'' +
                ", duration=" + duration +
                ", url='" + url + '\'' +
                ", lyricsId='" + lyricsId + '\'' +
                '}';
    }

    public static Audio parse(JSONObject json) {
        Audio res = new Audio();
        res.artist = (String) json.get("artist");
        res.title = (String) json.get("title");
        res.duration = (Long) json.get("duration");
        res.url = (String) json.get("url");
        res.lyricsId = (String) json.get("lyrics_id");
        return res;
    }
}
