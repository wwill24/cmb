package com.facebook;

import com.facebook.GraphRequest;

public final /* synthetic */ class p implements GraphRequest.Callback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GraphRequest.Callback f37924a;

    public /* synthetic */ p(GraphRequest.Callback callback) {
        this.f37924a = callback;
    }

    public final void onCompleted(GraphResponse graphResponse) {
        GraphRequest.m27_set_callback_$lambda0(this.f37924a, graphResponse);
    }
}
