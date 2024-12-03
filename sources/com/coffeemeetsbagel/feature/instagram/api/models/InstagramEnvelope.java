package com.coffeemeetsbagel.feature.instagram.api.models;

public class InstagramEnvelope<T> {
    public T data;
    public Meta meta;
    public Pagination pagination;

    public static class Meta {
        public int code;
        public String errorMessage;
        public String errorType;
    }

    public static class Pagination {
        public String nextMaxId;
        public String nextUrl;
    }
}
