package com.google.firebase.crashlytics.internal.common;

import com.google.firebase.crashlytics.internal.breadcrumbs.BreadcrumbHandler;

public final /* synthetic */ class d implements BreadcrumbHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CrashlyticsCore f21013a;

    public /* synthetic */ d(CrashlyticsCore crashlyticsCore) {
        this.f21013a = crashlyticsCore;
    }

    public final void handleBreadcrumb(String str) {
        this.f21013a.log(str);
    }
}
