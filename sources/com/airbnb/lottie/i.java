package com.airbnb.lottie;

import android.content.Context;
import java.util.concurrent.Callable;

public final /* synthetic */ class i implements Callable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f8591a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f8592b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f8593c;

    public /* synthetic */ i(Context context, String str, String str2) {
        this.f8591a = context;
        this.f8592b = str;
        this.f8593c = str2;
    }

    public final Object call() {
        return p.I(this.f8591a, this.f8592b, this.f8593c);
    }
}
