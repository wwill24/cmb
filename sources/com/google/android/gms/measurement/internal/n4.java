package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzo;
import java.util.Map;

final class n4 implements zzo {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f40057a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ o4 f40058b;

    n4(o4 o4Var, String str) {
        this.f40058b = o4Var;
        this.f40057a = str;
    }

    public final String zza(String str) {
        Map map = (Map) this.f40058b.f40103d.get(this.f40057a);
        if (map == null || !map.containsKey(str)) {
            return null;
        }
        return (String) map.get(str);
    }
}
