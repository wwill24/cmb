package com.coffeemeetsbagel.feature.instagram.api.models;

public class InstagramMediaItem {
    public Image images;

    public static class Image {
        public Details lowResolution;
        public Details standardResolution;
        public Details thumbnail;

        public static class Details {
            public String height;
            public String url;
            public String width;
        }
    }

    public String toString() {
        String str;
        Image image = this.images;
        if (image != null) {
            str = image.standardResolution.url;
        } else {
            str = null;
        }
        return "url=" + str;
    }
}
