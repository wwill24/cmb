package com.facebook;

import com.facebook.GraphRequest;

public final /* synthetic */ class s implements GraphRequest.Callback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GraphRequest.GraphJSONObjectCallback f37927a;

    public /* synthetic */ s(GraphRequest.GraphJSONObjectCallback graphJSONObjectCallback) {
        this.f37927a = graphJSONObjectCallback;
    }

    public final void onCompleted(GraphResponse graphResponse) {
        GraphRequest.Companion.m28newMeRequest$lambda0(this.f37927a, graphResponse);
    }
}
