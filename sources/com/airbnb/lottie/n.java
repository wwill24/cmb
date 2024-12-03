package com.airbnb.lottie;

import android.content.Context;
import java.util.concurrent.Callable;

public final /* synthetic */ class n implements Callable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f8782a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f8783b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f8784c;

    public /* synthetic */ n(Context context, String str, String str2) {
        this.f8782a = context;
        this.f8783b = str;
        this.f8784c = str2;
    }

    public final Object call() {
        return p.m(this.f8782a, this.f8783b, this.f8784c);
    }
}
