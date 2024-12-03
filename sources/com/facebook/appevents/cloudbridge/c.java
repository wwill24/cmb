package com.facebook.appevents.cloudbridge;

import java.util.List;

public final /* synthetic */ class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Integer f37735a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ List f37736b;

    public /* synthetic */ c(Integer num, List list) {
        this.f37735a = num;
        this.f37736b = list;
    }

    public final void run() {
        AppEventsConversionsAPITransformerWebRequests$transformGraphRequestAndSendToCAPIGEndPoint$1$1.m58invoke$lambda0(this.f37735a, this.f37736b);
    }
}
