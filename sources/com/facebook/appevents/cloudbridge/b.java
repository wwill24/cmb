package com.facebook.appevents.cloudbridge;

import com.facebook.GraphRequest;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GraphRequest f37734a;

    public /* synthetic */ b(GraphRequest graphRequest) {
        this.f37734a = graphRequest;
    }

    public final void run() {
        AppEventsConversionsAPITransformerWebRequests.m57transformGraphRequestAndSendToCAPIGEndPoint$lambda0(this.f37734a);
    }
}
