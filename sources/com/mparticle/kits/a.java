package com.mparticle.kits;

import com.appsflyer.deeplink.DeepLinkListener;
import com.appsflyer.deeplink.DeepLinkResult;

public final /* synthetic */ class a implements DeepLinkListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AppsFlyerKit f22596a;

    public /* synthetic */ a(AppsFlyerKit appsFlyerKit) {
        this.f22596a = appsFlyerKit;
    }

    public final void onDeepLinking(DeepLinkResult deepLinkResult) {
        AppsFlyerKit.deepLinkListener$lambda$7(this.f22596a, deepLinkResult);
    }
}
