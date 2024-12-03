package com.coffeemeetsbagel.models.responses;

public class FacebookAlbumsResponse {
    private UsersFacebookAlbumsResponse albums;
    private UsersFacebookAlbumsResponse photos;

    public FacebookAlbumsResponse(UsersFacebookAlbumsResponse usersFacebookAlbumsResponse, UsersFacebookAlbumsResponse usersFacebookAlbumsResponse2) {
        this.albums = usersFacebookAlbumsResponse;
        this.photos = usersFacebookAlbumsResponse2;
    }

    public UsersFacebookAlbumsResponse getAlbums() {
        return this.albums;
    }

    public UsersFacebookAlbumsResponse getPhotos() {
        return this.photos;
    }
}
