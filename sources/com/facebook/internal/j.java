package com.facebook.internal;

public final /* synthetic */ class j implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FileLruCache f37858a;

    public /* synthetic */ j(FileLruCache fileLruCache) {
        this.f37858a = fileLruCache;
    }

    public final void run() {
        FileLruCache.m121postTrim$lambda3$lambda2(this.f37858a);
    }
}
