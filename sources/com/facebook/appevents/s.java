package com.facebook.appevents;

public final /* synthetic */ class s implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f37772a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f37773b;

    public /* synthetic */ s(String str, String str2) {
        this.f37772a = str;
        this.f37773b = str2;
    }

    public final void run() {
        UserDataStore.m53writeDataIntoCache$lambda0(this.f37772a, this.f37773b);
    }
}
