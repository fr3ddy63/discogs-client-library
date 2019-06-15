package de.home.discogs;

import com.google.gson.JsonObject;

public class Release {

    private final Integer id;
    private final String artist;
    private final String title;
    private final Integer year;
    private final Integer main;
    private final String type;

    private Release(Integer id, String artist, String title, Integer year, Integer main, String type) {
        this.id = id;
        this.artist = artist;
        this.title = title;
        this.year = year;
        this.main = main;
        this.type = type;
    }

    public static Release create(Integer id, String artist, String title, Integer year, Integer main, String type) {
       return new Release(id, artist, title, year, main, type);
    }

    public static Release create(JsonObject json) {
        return new Release(
                json.get("id").getAsInt(),
                json.get("artist").getAsString(),
                json.get("title").getAsString(),
                json.get("year").getAsInt(),
                json.get("main").getAsInt(),
                json.get("type").getAsString()
        );
    }

    public Integer getId() {
        return id;
    }

    public String getArtist() {
        return artist;
    }

    public String getTitle() {
        return title;
    }

    public Integer getYear() {
        return year;
    }

    public Integer getMain() {
        return main;
    }

    public String getType() {
        return type;
    }
}
