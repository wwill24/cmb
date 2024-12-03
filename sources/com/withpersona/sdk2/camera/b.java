package com.withpersona.sdk2.camera;

import kotlin.Result;
import org.apache.commons.beanutils.PropertyUtils;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    private final Object f14250a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f14251b;

    public b(Object obj, boolean z10) {
        this.f14250a = obj;
        this.f14251b = z10;
    }

    public final Object a() {
        return this.f14250a;
    }

    public final boolean b() {
        return this.f14251b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return Result.d(this.f14250a, bVar.f14250a) && this.f14251b == bVar.f14251b;
    }

    public int hashCode() {
        int f10 = Result.f(this.f14250a) * 31;
        boolean z10 = this.f14251b;
        if (z10) {
            z10 = true;
        }
        return f10 + (z10 ? 1 : 0);
    }

    public String toString() {
        return "AnalyzerResult(result=" + Result.i(this.f14250a) + ", isActiveAnalyzer=" + this.f14251b + PropertyUtils.MAPPED_DELIM2;
    }
}
