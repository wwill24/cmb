package com.facebook.appevents.codeless;

public final /* synthetic */ class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f37745a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ViewIndexer f37746b;

    public /* synthetic */ f(String str, ViewIndexer viewIndexer) {
        this.f37745a = str;
        this.f37746b = viewIndexer;
    }

    public final void run() {
        ViewIndexer.m64sendToServer$lambda1(this.f37745a, this.f37746b);
    }
}
