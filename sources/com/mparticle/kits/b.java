package com.mparticle.kits;

import com.mparticle.UserAttributeListener;
import java.util.Map;

public final /* synthetic */ class b implements UserAttributeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GoogleAnalyticsFirebaseKit f22597a;

    public /* synthetic */ b(GoogleAnalyticsFirebaseKit googleAnalyticsFirebaseKit) {
        this.f22597a = googleAnalyticsFirebaseKit;
    }

    public final void onUserAttributesReceived(Map map, Map map2, Long l10) {
        GoogleAnalyticsFirebaseKit.onModifyCompleted$lambda$3(this.f22597a, map, map2, l10);
    }
}
