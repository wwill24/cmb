package com.airbnb.lottie;

import android.content.Context;
import java.lang.ref.WeakReference;
import java.util.concurrent.Callable;

public final /* synthetic */ class o implements Callable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ WeakReference f8788a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Context f8789b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f8790c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f8791d;

    public /* synthetic */ o(WeakReference weakReference, Context context, int i10, String str) {
        this.f8788a = weakReference;
        this.f8789b = context;
        this.f8790c = i10;
        this.f8791d = str;
    }

    public final Object call() {
        return p.H(this.f8788a, this.f8789b, this.f8790c, this.f8791d);
    }
}
