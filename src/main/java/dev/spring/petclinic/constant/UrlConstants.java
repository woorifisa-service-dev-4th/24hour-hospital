package dev.spring.petclinic.constant;

import java.util.List;

public class UrlConstants {
    private UrlConstants() {}

    public static final List<String> LOCAL_CLIENT_URLS = List.of("https://localhost:3000", "https://localhost:5173");
    public static final String LOCAL_SERVER_URL = "http://localhost:8080";
}
