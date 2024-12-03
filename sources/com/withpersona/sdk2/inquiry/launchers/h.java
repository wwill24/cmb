package com.withpersona.sdk2.inquiry.launchers;

import android.net.Uri;
import androidx.activity.result.c;
import fj.d;
import fj.g;

public final class h implements d<c<Uri>> {

    /* renamed from: a  reason: collision with root package name */
    private final a f26955a;

    public h(a aVar) {
        this.f26955a = aVar;
    }

    public static h a(a aVar) {
        return new h(aVar);
    }

    public static c<Uri> c(a aVar) {
        return (c) g.e(aVar.c());
    }

    /* renamed from: b */
    public c<Uri> get() {
        return c(this.f26955a);
    }
}
