package com.withpersona.sdk2.camera;

import android.graphics.Rect;
import com.leanplum.internal.Constants;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

final class y {

    /* renamed from: a  reason: collision with root package name */
    private final Rect f14382a;

    /* renamed from: b  reason: collision with root package name */
    private final Rect f14383b;

    public y(Rect rect, Rect rect2) {
        j.g(rect, Constants.Keys.REGION);
        j.g(rect2, "viewport");
        this.f14382a = rect;
        this.f14383b = rect2;
    }

    public final Rect a() {
        return this.f14382a;
    }

    public final Rect b() {
        return this.f14383b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof y)) {
            return false;
        }
        y yVar = (y) obj;
        return j.b(this.f14382a, yVar.f14382a) && j.b(this.f14383b, yVar.f14383b);
    }

    public int hashCode() {
        return (this.f14382a.hashCode() * 31) + this.f14383b.hashCode();
    }

    public String toString() {
        return "ViewfinderInfo(region=" + this.f14382a + ", viewport=" + this.f14383b + PropertyUtils.MAPPED_DELIM2;
    }
}
