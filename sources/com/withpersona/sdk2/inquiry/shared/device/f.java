package com.withpersona.sdk2.inquiry.shared.device;

import android.content.Context;
import fj.d;
import fk.a;

public final class f implements d<RealDeviceIdProvider> {

    /* renamed from: a  reason: collision with root package name */
    private final a<Context> f27506a;

    public f(a<Context> aVar) {
        this.f27506a = aVar;
    }

    public static f a(a<Context> aVar) {
        return new f(aVar);
    }

    public static RealDeviceIdProvider c(Context context) {
        return new RealDeviceIdProvider(context);
    }

    /* renamed from: b */
    public RealDeviceIdProvider get() {
        return c(this.f27506a.get());
    }
}
