package com.google.android.gms.common.api.internal;

import androidx.annotation.NonNull;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.a.d;
import com.google.android.gms.common.internal.n;

public final class b<O extends a.d> {

    /* renamed from: a  reason: collision with root package name */
    private final int f38545a;

    /* renamed from: b  reason: collision with root package name */
    private final a f38546b;

    /* renamed from: c  reason: collision with root package name */
    private final a.d f38547c;

    /* renamed from: d  reason: collision with root package name */
    private final String f38548d;

    private b(a aVar, a.d dVar, String str) {
        this.f38546b = aVar;
        this.f38547c = dVar;
        this.f38548d = str;
        this.f38545a = n.c(aVar, dVar, str);
    }

    @NonNull
    public static <O extends a.d> b<O> a(@NonNull a<O> aVar, O o10, String str) {
        return new b<>(aVar, o10, str);
    }

    @NonNull
    public final String b() {
        return this.f38546b.d();
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        if (!n.b(this.f38546b, bVar.f38546b) || !n.b(this.f38547c, bVar.f38547c) || !n.b(this.f38548d, bVar.f38548d)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return this.f38545a;
    }
}
