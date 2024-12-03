package com.facebook;

import com.facebook.AccessTokenManager;
import com.facebook.GraphRequest;

public final /* synthetic */ class c implements GraphRequest.Callback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AccessTokenManager.RefreshResult f37811a;

    public /* synthetic */ c(AccessTokenManager.RefreshResult refreshResult) {
        this.f37811a = refreshResult;
    }

    public final void onCompleted(GraphResponse graphResponse) {
        AccessTokenManager.m14refreshCurrentAccessTokenImpl$lambda2(this.f37811a, graphResponse);
    }
}
