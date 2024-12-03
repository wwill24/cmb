package com.withpersona.sdk2.inquiry.shared.device;

import android.content.SharedPreferences;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

final class RealDeviceIdProvider$prefs$2 extends Lambda implements Function0<SharedPreferences> {
    final /* synthetic */ RealDeviceIdProvider this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    RealDeviceIdProvider$prefs$2(RealDeviceIdProvider realDeviceIdProvider) {
        super(0);
        this.this$0 = realDeviceIdProvider;
    }

    /* renamed from: a */
    public final SharedPreferences invoke() {
        return this.this$0.f27501a.getSharedPreferences("com.withpersona.sdk2.prefs", 0);
    }
}
