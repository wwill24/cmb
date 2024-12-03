package com.coffeemeetsbagel.models.responses;

public class FacebookAlbumResponse {
    private FacebookDataResponse[] data;
    private FacebookPagingResponse paging;

    public FacebookDataResponse[] getData() {
        return this.data;
    }

    public FacebookPagingResponse getPaging() {
        return this.paging;
    }
}
