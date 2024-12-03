package com.facebook;

import com.facebook.AccessToken;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AccessTokenManager f37729a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AccessToken.AccessTokenRefreshCallback f37730b;

    public /* synthetic */ a(AccessTokenManager accessTokenManager, AccessToken.AccessTokenRefreshCallback accessTokenRefreshCallback) {
        this.f37729a = accessTokenManager;
        this.f37730b = accessTokenRefreshCallback;
    }

    public final void run() {
        AccessTokenManager.m12refreshCurrentAccessToken$lambda0(this.f37729a, this.f37730b);
    }
}
