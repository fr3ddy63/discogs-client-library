package de.home.discogs;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import jdk.incubator.http.HttpClient;
import jdk.incubator.http.HttpRequest;
import jdk.incubator.http.HttpResponse;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class Artist {

    public static Artist getArtist(Integer id) {
        String uri = Settings.BASE_URI + "artists/" + id;
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder(new URI(uri)).GET().build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandler.asString());
            String responseBody = response.body();
            if (response.statusCode() == 404) {
                return null;
            }
            // System.out.println(responseBody);
            JsonParser parser = new JsonParser();
            JsonObject json = parser.parse(responseBody).getAsJsonObject();
            json.keySet().forEach(System.out::println);
        } catch (URISyntaxException | IOException | InterruptedException e) {
            e.printStackTrace();
            return null;
        }

        return null;
    }

    public static Artist getReleases(Integer id) {
        String uri = Settings.BASE_URI + "artists/" + id + "/releases";
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder(new URI(uri)).GET().build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandler.asString());
            String responseBody = response.body();
            if (response.statusCode() == 404) {
                return null;
            }
            // System.out.println(responseBody);
            JsonParser parser = new JsonParser();
            JsonObject json = parser.parse(responseBody).getAsJsonObject();
            json.keySet().forEach(System.out::println);

            Pagination pagination = Pagination.create(json.getAsJsonObject("pagination"));

            List<Release> releases = new ArrayList<>();
            json.getAsJsonArray("releases").forEach((release) -> {
                releases.add(Release.create(release.getAsJsonObject()));
            });
        } catch (URISyntaxException | IOException | InterruptedException e) {
            e.printStackTrace();
            return null;
        }

        return null;
    }
}
