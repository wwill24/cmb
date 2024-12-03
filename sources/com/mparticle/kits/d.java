package com.mparticle.kits;

import com.mparticle.UserAttributeListener;
import java.util.Map;

public final /* synthetic */ class d implements UserAttributeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GoogleAnalyticsFirebaseKit f22599a;

    public /* synthetic */ d(GoogleAnalyticsFirebaseKit googleAnalyticsFirebaseKit) {
        this.f22599a = googleAnalyticsFirebaseKit;
    }

    public final void onUserAttributesReceived(Map map, Map map2, Long l10) {
        GoogleAnalyticsFirebaseKit.onLoginCompleted$lambda$2(this.f22599a, map, map2, l10);
    }
}
