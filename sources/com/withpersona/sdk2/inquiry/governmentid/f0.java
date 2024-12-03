package com.withpersona.sdk2.inquiry.governmentid;

import org.apache.commons.beanutils.PropertyUtils;

public final class f0 {

    /* renamed from: a  reason: collision with root package name */
    private final int f25774a;

    /* renamed from: b  reason: collision with root package name */
    private final int f25775b;

    public f0(int i10, int i11) {
        this.f25774a = i10;
        this.f25775b = i11;
    }

    public final int a() {
        return this.f25775b;
    }

    public final int b() {
        return this.f25774a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f0)) {
            return false;
        }
        f0 f0Var = (f0) obj;
        return this.f25774a == f0Var.f25774a && this.f25775b == f0Var.f25775b;
    }

    public int hashCode() {
        return (Integer.hashCode(this.f25774a) * 31) + Integer.hashCode(this.f25775b);
    }

    public String toString() {
        return "OverlayAssets(hintAnimation=" + this.f25774a + ", guideDrawable=" + this.f25775b + PropertyUtils.MAPPED_DELIM2;
    }
}
