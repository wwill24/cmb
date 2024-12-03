package com.withpersona.sdk2.camera.camera2;

import android.util.Range;
import android.util.Size;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class f {

    /* renamed from: a  reason: collision with root package name */
    private final String f14333a;

    /* renamed from: b  reason: collision with root package name */
    private final Size f14334b;

    /* renamed from: c  reason: collision with root package name */
    private final double f14335c;

    /* renamed from: d  reason: collision with root package name */
    private final Range<Integer> f14336d;

    /* renamed from: e  reason: collision with root package name */
    private final g f14337e;

    public f(String str, Size size, double d10, Range<Integer> range, g gVar) {
        j.g(str, "id");
        j.g(size, "size");
        j.g(range, "targetFpsRange");
        j.g(gVar, "additionalOptions");
        this.f14333a = str;
        this.f14334b = size;
        this.f14335c = d10;
        this.f14336d = range;
        this.f14337e = gVar;
    }

    public final g a() {
        return this.f14337e;
    }

    public final String b() {
        return this.f14333a;
    }

    public final Size c() {
        return this.f14334b;
    }

    public final Range<Integer> d() {
        return this.f14336d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return j.b(this.f14333a, fVar.f14333a) && j.b(this.f14334b, fVar.f14334b) && Double.compare(this.f14335c, fVar.f14335c) == 0 && j.b(this.f14336d, fVar.f14336d) && j.b(this.f14337e, fVar.f14337e);
    }

    public int hashCode() {
        return (((((((this.f14333a.hashCode() * 31) + this.f14334b.hashCode()) * 31) + Double.hashCode(this.f14335c)) * 31) + this.f14336d.hashCode()) * 31) + this.f14337e.hashCode();
    }

    public String toString() {
        return "CameraChoice(id=" + this.f14333a + ", size=" + this.f14334b + ", maxFps=" + this.f14335c + ", targetFpsRange=" + this.f14336d + ", additionalOptions=" + this.f14337e + PropertyUtils.MAPPED_DELIM2;
    }
}
