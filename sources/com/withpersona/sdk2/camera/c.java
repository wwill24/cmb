package com.withpersona.sdk2.camera;

import org.apache.commons.beanutils.PropertyUtils;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    private final int f14252a;

    /* renamed from: b  reason: collision with root package name */
    private final int f14253b;

    /* renamed from: c  reason: collision with root package name */
    private final int f14254c;

    /* renamed from: d  reason: collision with root package name */
    private final int f14255d;

    public c(int i10, int i11, int i12, int i13) {
        this.f14252a = i10;
        this.f14253b = i11;
        this.f14254c = i12;
        this.f14255d = i13;
    }

    public final int a() {
        return this.f14252a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return this.f14252a == cVar.f14252a && this.f14253b == cVar.f14253b && this.f14254c == cVar.f14254c && this.f14255d == cVar.f14255d;
    }

    public int hashCode() {
        return (((((Integer.hashCode(this.f14252a) * 31) + Integer.hashCode(this.f14253b)) * 31) + Integer.hashCode(this.f14254c)) * 31) + Integer.hashCode(this.f14255d);
    }

    public String toString() {
        return "AudioConfiguration(sampleRateInHz=" + this.f14252a + ", channelConfig=" + this.f14253b + ", audioFormat=" + this.f14254c + ", bufferSizeInBytes=" + this.f14255d + PropertyUtils.MAPPED_DELIM2;
    }
}
