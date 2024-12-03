package com.facebook.internal;

import java.io.File;

public final /* synthetic */ class k implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ File[] f37859a;

    public /* synthetic */ k(File[] fileArr) {
        this.f37859a = fileArr;
    }

    public final void run() {
        FileLruCache.m120clearCache$lambda1(this.f37859a);
    }
}
