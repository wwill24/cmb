package com.google.firebase.crashlytics;

import android.os.Bundle;
import com.google.firebase.crashlytics.internal.analytics.AnalyticsEventLogger;

public final /* synthetic */ class b implements AnalyticsEventLogger {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsDeferredProxy f21004a;

    public /* synthetic */ b(AnalyticsDeferredProxy analyticsDeferredProxy) {
        this.f21004a = analyticsDeferredProxy;
    }

    public final void logEvent(String str, Bundle bundle) {
        this.f21004a.lambda$getAnalyticsEventLogger$1(str, bundle);
    }
}
