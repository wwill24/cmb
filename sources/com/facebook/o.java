package com.facebook;

import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import org.json.b;

public final /* synthetic */ class o implements FacebookSdk.GraphRequestCreator {
    public final GraphRequest createPostRequest(AccessToken accessToken, String str, b bVar, GraphRequest.Callback callback) {
        return FacebookSdk.m18graphRequestCreator$lambda0(accessToken, str, bVar, callback);
    }
}
