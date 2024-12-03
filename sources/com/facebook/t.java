package com.facebook;

import com.facebook.GraphRequest;

public final /* synthetic */ class t implements GraphRequest.Callback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GraphRequest.GraphJSONArrayCallback f37944a;

    public /* synthetic */ t(GraphRequest.GraphJSONArrayCallback graphJSONArrayCallback) {
        this.f37944a = graphJSONArrayCallback;
    }

    public final void onCompleted(GraphResponse graphResponse) {
        GraphRequest.Companion.m29newPlacesSearchRequest$lambda1(this.f37944a, graphResponse);
    }
}
