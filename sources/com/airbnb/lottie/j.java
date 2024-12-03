package com.airbnb.lottie;

import java.io.InputStream;
import java.util.concurrent.Callable;

public final /* synthetic */ class j implements Callable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ InputStream f8596a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f8597b;

    public /* synthetic */ j(InputStream inputStream, String str) {
        this.f8596a = inputStream;
        this.f8597b = str;
    }

    public final Object call() {
        return p.o(this.f8596a, this.f8597b);
    }
}
