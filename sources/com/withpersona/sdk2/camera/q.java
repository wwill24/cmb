package com.withpersona.sdk2.camera;

import org.apache.commons.beanutils.PropertyUtils;

public final class q {

    /* renamed from: a  reason: collision with root package name */
    private final int f14372a;

    /* renamed from: b  reason: collision with root package name */
    private final int f14373b;

    /* renamed from: c  reason: collision with root package name */
    private final int f14374c;

    public q(int i10, int i11, int i12) {
        this.f14372a = i10;
        this.f14373b = i11;
        this.f14374c = i12;
    }

    public final int a() {
        return this.f14373b;
    }

    public final int b() {
        return this.f14374c;
    }

    public final int c() {
        return this.f14372a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof q)) {
            return false;
        }
        q qVar = (q) obj;
        return this.f14372a == qVar.f14372a && this.f14373b == qVar.f14373b && this.f14374c == qVar.f14374c;
    }

    public int hashCode() {
        return (((Integer.hashCode(this.f14372a) * 31) + Integer.hashCode(this.f14373b)) * 31) + Integer.hashCode(this.f14374c);
    }

    public String toString() {
        return "FrameMetadata(width=" + this.f14372a + ", height=" + this.f14373b + ", rotation=" + this.f14374c + PropertyUtils.MAPPED_DELIM2;
    }
}
