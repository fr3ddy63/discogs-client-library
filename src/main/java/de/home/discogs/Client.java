package de.home.discogs;

import jdk.incubator.http.HttpClient;

public class Client {
    private HttpClient client;

    public Client() {
        client = HttpClient.newHttpClient();
    }
}
