package com.withpersona.sdk2.inquiry.shared.device;

import android.content.Context;
import android.content.SharedPreferences;
import com.mparticle.identity.IdentityHttpResponse;
import gk.f;
import kotlin.jvm.internal.j;

public final class RealDeviceIdProvider implements b {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final Context f27501a;

    /* renamed from: b  reason: collision with root package name */
    private final f f27502b = b.b(new RealDeviceIdProvider$prefs$2(this));

    /* renamed from: c  reason: collision with root package name */
    private String f27503c;

    public RealDeviceIdProvider(Context context) {
        j.g(context, IdentityHttpResponse.CONTEXT);
        this.f27501a = context;
    }

    private final SharedPreferences d() {
        return (SharedPreferences) this.f27502b.getValue();
    }

    public void a(String str) {
        String str2;
        if (!j.b(str, this.f27503c)) {
            str2 = str;
        } else {
            str2 = null;
        }
        if (str2 != null) {
            this.f27503c = str;
            d().edit().putString("DEVICE_ID", this.f27503c).apply();
        }
    }

    public String b() {
        String str = this.f27503c;
        return str == null ? d().getString("DEVICE_ID", (String) null) : str;
    }
}
