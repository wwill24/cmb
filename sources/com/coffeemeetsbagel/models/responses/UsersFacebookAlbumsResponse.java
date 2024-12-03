package com.coffeemeetsbagel.models.responses;

public class UsersFacebookAlbumsResponse {
    private FacebookDataResponse[] data;

    public UsersFacebookAlbumsResponse(FacebookDataResponse[] facebookDataResponseArr) {
        this.data = facebookDataResponseArr;
    }

    public FacebookDataResponse[] getData() {
        return this.data;
    }
}
