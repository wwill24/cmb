package com.withpersona.sdk2.camera.camera2;

import kotlin.jvm.internal.DefaultConstructorMarker;
import org.apache.commons.beanutils.PropertyUtils;

public final class g {

    /* renamed from: a  reason: collision with root package name */
    private final long f14338a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f14339b;

    public g() {
        this(0, false, 3, (DefaultConstructorMarker) null);
    }

    public g(long j10, boolean z10) {
        this.f14338a = j10;
        this.f14339b = z10;
    }

    public final long a() {
        return this.f14338a;
    }

    public final boolean b() {
        return this.f14339b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return this.f14338a == gVar.f14338a && this.f14339b == gVar.f14339b;
    }

    public int hashCode() {
        int hashCode = Long.hashCode(this.f14338a) * 31;
        boolean z10 = this.f14339b;
        if (z10) {
            z10 = true;
        }
        return hashCode + (z10 ? 1 : 0);
    }

    public String toString() {
        return "ExtraCameraOptions(dynamicRange=" + this.f14338a + ", previewStabilization=" + this.f14339b + PropertyUtils.MAPPED_DELIM2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ g(long j10, boolean z10, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? 1 : j10, (i10 & 2) != 0 ? false : z10);
    }
}
