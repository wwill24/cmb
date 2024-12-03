package com.facebook.appevents;

public final /* synthetic */ class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AccessTokenAppIdPair f37732a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SessionEventsState f37733b;

    public /* synthetic */ c(AccessTokenAppIdPair accessTokenAppIdPair, SessionEventsState sessionEventsState) {
        this.f37732a = accessTokenAppIdPair;
        this.f37733b = sessionEventsState;
    }

    public final void run() {
        AppEventQueue.m41handleResponse$lambda5(this.f37732a, this.f37733b);
    }
}
