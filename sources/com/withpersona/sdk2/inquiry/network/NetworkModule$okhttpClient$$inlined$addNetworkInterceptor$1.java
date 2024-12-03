package com.withpersona.sdk2.inquiry.network;

import android.content.Context;
import com.withpersona.sdk2.inquiry.shared.device.a;
import com.withpersona.sdk2.inquiry.shared.device.c;
import java.util.Locale;
import java.util.Map;
import kotlin.jvm.internal.j;
import okhttp3.a0;
import okhttp3.u;
import okhttp3.y;

/* renamed from: com.withpersona.sdk2.inquiry.network.NetworkModule$okhttpClient$$inlined$-addNetworkInterceptor$1  reason: invalid class name */
public final class NetworkModule$okhttpClient$$inlined$addNetworkInterceptor$1 implements u {
    final /* synthetic */ a $appSetIDHelper$inlined;
    final /* synthetic */ Context $context$inlined;
    final /* synthetic */ c $deviceInfoProvider$inlined;
    final /* synthetic */ Map $headers$inlined;

    public NetworkModule$okhttpClient$$inlined$addNetworkInterceptor$1(c cVar, a aVar, Context context, Map map) {
        this.$deviceInfoProvider$inlined = cVar;
        this.$appSetIDHelper$inlined = aVar;
        this.$context$inlined = context;
        this.$headers$inlined = map;
    }

    public final a0 intercept(u.a aVar) {
        String str;
        j.g(aVar, "chain");
        y.a h10 = aVar.g().h();
        if (!aVar.g().e().g().contains("Accept")) {
            h10 = h10.f("Accept", "application/json");
        }
        y.a f10 = h10.f("Persona-Version", "2021-10-01").f("Persona-Device-Manufacturer", this.$deviceInfoProvider$inlined.b()).f("Persona-Device-Model", this.$deviceInfoProvider$inlined.a()).f("Persona-Device-OS", "Android").f("Persona-Device-OS-Version", this.$deviceInfoProvider$inlined.c()).f("Persona-Device-Vendor-Id", this.$appSetIDHelper$inlined.b(this.$context$inlined));
        if ((this.$context$inlined.getResources().getConfiguration().uiMode & 48) == 32) {
            str = "dark";
        } else {
            str = "light";
        }
        y.a f11 = f10.f("Persona-Style-Variant", str);
        String locale = Locale.getDefault().toString();
        j.f(locale, "getDefault().toString()");
        y.a f12 = f11.f("Persona-Device-Locale", locale);
        for (Map.Entry entry : this.$headers$inlined.entrySet()) {
            f12.f((String) entry.getKey(), (String) entry.getValue());
        }
        return aVar.a(f12.b());
    }
}
