package com.google.firebase.database.util;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class GAuthToken {
    private static final String AUTH_KEY = "auth";
    private static final String TOKEN_KEY = "token";
    private static final String TOKEN_PREFIX = "gauth|";
    private final Map<String, Object> auth;
    private final String token;

    public GAuthToken(String str, Map<String, Object> map) {
        this.token = str;
        this.auth = map;
    }

    public static GAuthToken tryParseFromString(String str) {
        if (!str.startsWith(TOKEN_PREFIX)) {
            return null;
        }
        try {
            Map<String, Object> parseJson = JsonMapper.parseJson(str.substring(6));
            return new GAuthToken((String) parseJson.get("token"), (Map) parseJson.get("auth"));
        } catch (IOException e10) {
            throw new RuntimeException("Failed to parse gauth token", e10);
        }
    }

    public Map<String, Object> getAuth() {
        return this.auth;
    }

    public String getToken() {
        return this.token;
    }

    public String serializeToString() {
        HashMap hashMap = new HashMap();
        hashMap.put("token", this.token);
        hashMap.put("auth", this.auth);
        try {
            String serializeJson = JsonMapper.serializeJson(hashMap);
            return TOKEN_PREFIX + serializeJson;
        } catch (IOException e10) {
            throw new RuntimeException("Failed to serialize gauth token", e10);
        }
    }
}
