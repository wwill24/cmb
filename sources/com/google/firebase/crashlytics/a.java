package com.google.firebase.crashlytics;

import com.google.firebase.crashlytics.internal.breadcrumbs.BreadcrumbHandler;
import com.google.firebase.crashlytics.internal.breadcrumbs.BreadcrumbSource;

public final /* synthetic */ class a implements BreadcrumbSource {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsDeferredProxy f21003a;

    public /* synthetic */ a(AnalyticsDeferredProxy analyticsDeferredProxy) {
        this.f21003a = analyticsDeferredProxy;
    }

    public final void registerBreadcrumbHandler(BreadcrumbHandler breadcrumbHandler) {
        this.f21003a.lambda$getDeferredBreadcrumbSource$0(breadcrumbHandler);
    }
}
