package com.withpersona.sdk2.inquiry.nfc;

import androidx.activity.result.c;
import fj.d;
import fj.g;

public final class f implements d<c<PassportNfcReaderConfig>> {

    /* renamed from: a  reason: collision with root package name */
    private final c f27073a;

    public f(c cVar) {
        this.f27073a = cVar;
    }

    public static f a(c cVar) {
        return new f(cVar);
    }

    public static c<PassportNfcReaderConfig> c(c cVar) {
        return (c) g.e(cVar.a());
    }

    /* renamed from: b */
    public c<PassportNfcReaderConfig> get() {
        return c(this.f27073a);
    }
}
