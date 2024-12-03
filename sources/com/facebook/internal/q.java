package com.facebook.internal;

import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.internal.Utility;

public final /* synthetic */ class q implements GraphRequest.Callback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Utility.GraphMeRequestWithCacheCallback f37867a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f37868b;

    public /* synthetic */ q(Utility.GraphMeRequestWithCacheCallback graphMeRequestWithCacheCallback, String str) {
        this.f37867a = graphMeRequestWithCacheCallback;
        this.f37868b = str;
    }

    public final void onCompleted(GraphResponse graphResponse) {
        Utility.m127getGraphMeRequestWithCacheAsync$lambda3(this.f37867a, this.f37868b, graphResponse);
    }
}
