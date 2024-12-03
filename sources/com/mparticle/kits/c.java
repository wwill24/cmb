package com.mparticle.kits;

import com.mparticle.UserAttributeListener;
import java.util.Map;

public final /* synthetic */ class c implements UserAttributeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GoogleAnalyticsFirebaseKit f22598a;

    public /* synthetic */ c(GoogleAnalyticsFirebaseKit googleAnalyticsFirebaseKit) {
        this.f22598a = googleAnalyticsFirebaseKit;
    }

    public final void onUserAttributesReceived(Map map, Map map2, Long l10) {
        GoogleAnalyticsFirebaseKit.onIdentifyCompleted$lambda$1(this.f22598a, map, map2, l10);
    }
}
