package com.facebook.appevents;

import com.facebook.GraphRequest;
import com.facebook.GraphResponse;

public final /* synthetic */ class d implements GraphRequest.Callback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AccessTokenAppIdPair f37748a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ GraphRequest f37749b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ SessionEventsState f37750c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ FlushStatistics f37751d;

    public /* synthetic */ d(AccessTokenAppIdPair accessTokenAppIdPair, GraphRequest graphRequest, SessionEventsState sessionEventsState, FlushStatistics flushStatistics) {
        this.f37748a = accessTokenAppIdPair;
        this.f37749b = graphRequest;
        this.f37750c = sessionEventsState;
        this.f37751d = flushStatistics;
    }

    public final void onCompleted(GraphResponse graphResponse) {
        AppEventQueue.m38buildRequestForSession$lambda4(this.f37748a, this.f37749b, this.f37750c, this.f37751d, graphResponse);
    }
}
