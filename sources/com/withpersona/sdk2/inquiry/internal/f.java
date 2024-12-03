package com.withpersona.sdk2.inquiry.internal;

import android.content.Context;
import coil.ImageLoader;
import fj.d;
import fj.g;
import fk.a;

public final class f implements d<ImageLoader> {

    /* renamed from: a  reason: collision with root package name */
    private final d f26330a;

    /* renamed from: b  reason: collision with root package name */
    private final a<Context> f26331b;

    public f(d dVar, a<Context> aVar) {
        this.f26330a = dVar;
        this.f26331b = aVar;
    }

    public static f a(d dVar, a<Context> aVar) {
        return new f(dVar, aVar);
    }

    public static ImageLoader c(d dVar, Context context) {
        return (ImageLoader) g.e(dVar.b(context));
    }

    /* renamed from: b */
    public ImageLoader get() {
        return c(this.f26330a, this.f26331b.get());
    }
}
