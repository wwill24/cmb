package com.google.firebase.concurrent;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CustomThreadFactory f20955a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Runnable f20956b;

    public /* synthetic */ a(CustomThreadFactory customThreadFactory, Runnable runnable) {
        this.f20955a = customThreadFactory;
        this.f20956b = runnable;
    }

    public final void run() {
        this.f20955a.lambda$newThread$0(this.f20956b);
    }
}
