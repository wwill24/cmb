package com.appsflyer.internal;

public final /* synthetic */ class h implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AFc1wSDK f9070a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Throwable f9071b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f9072c;

    public /* synthetic */ h(AFc1wSDK aFc1wSDK, Throwable th2, String str) {
        this.f9070a = aFc1wSDK;
        this.f9071b = th2;
        this.f9072c = str;
    }

    public final void run() {
        AFc1wSDK.AFInAppEventType(this.f9070a, this.f9071b, this.f9072c);
    }
}
