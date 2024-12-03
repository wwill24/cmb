package com.facebook;

import com.facebook.AccessToken;
import com.facebook.AccessTokenManager;
import com.facebook.GraphRequestBatch;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

public final /* synthetic */ class d implements GraphRequestBatch.Callback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AccessTokenManager.RefreshResult f37813a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AccessToken f37814b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ AccessToken.AccessTokenRefreshCallback f37815c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ AtomicBoolean f37816d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Set f37817e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ Set f37818f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Set f37819g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ AccessTokenManager f37820h;

    public /* synthetic */ d(AccessTokenManager.RefreshResult refreshResult, AccessToken accessToken, AccessToken.AccessTokenRefreshCallback accessTokenRefreshCallback, AtomicBoolean atomicBoolean, Set set, Set set2, Set set3, AccessTokenManager accessTokenManager) {
        this.f37813a = refreshResult;
        this.f37814b = accessToken;
        this.f37815c = accessTokenRefreshCallback;
        this.f37816d = atomicBoolean;
        this.f37817e = set;
        this.f37818f = set2;
        this.f37819g = set3;
        this.f37820h = accessTokenManager;
    }

    public final void onBatchCompleted(GraphRequestBatch graphRequestBatch) {
        AccessTokenManager.m15refreshCurrentAccessTokenImpl$lambda3(this.f37813a, this.f37814b, this.f37815c, this.f37816d, this.f37817e, this.f37818f, this.f37819g, this.f37820h, graphRequestBatch);
    }
}
