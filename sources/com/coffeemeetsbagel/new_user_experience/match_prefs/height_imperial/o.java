package com.coffeemeetsbagel.new_user_experience.match_prefs.height_imperial;

import kotlin.jvm.internal.j;

public final class o {

    /* renamed from: a  reason: collision with root package name */
    private final int f35415a;

    /* renamed from: b  reason: collision with root package name */
    private final int f35416b;

    public o(int i10, int i11) {
        this.f35415a = i10;
        this.f35416b = i11;
    }

    public final int a(o oVar) {
        j.g(oVar, "other");
        int i10 = this.f35415a;
        int i11 = oVar.f35415a;
        if (i10 > i11) {
            return 1;
        }
        if (i10 == i11 && this.f35416b > oVar.f35416b) {
            return 1;
        }
        if (i10 == i11 && this.f35416b == oVar.f35416b) {
            return 0;
        }
        return -1;
    }

    public final int b() {
        return this.f35415a;
    }

    public final int c() {
        return this.f35416b;
    }

    public final float d() {
        return (((float) this.f35415a) * 30.48f) + (((float) this.f35416b) * 2.54f);
    }

    public boolean equals(Object obj) {
        if (obj instanceof o) {
            o oVar = (o) obj;
            return oVar.f35415a == this.f35415a && oVar.f35416b == this.f35416b;
        }
    }

    public int hashCode() {
        return (this.f35415a * 31) + this.f35416b;
    }

    public String toString() {
        int i10 = this.f35415a;
        int i11 = this.f35416b;
        return "ImperialUnitsHeight(feet=" + i10 + ", inches=" + i11 + ")";
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public o(float r7) {
        /*
            r6 = this;
            double r0 = (double) r7
            r2 = 4584889009772262342(0x3fa0cc433a1173c6, double:0.0328084)
            double r2 = r2 * r0
            double r4 = java.lang.Math.floor(r2)
            int r7 = (int) r4
            r4 = 4600763906625487487(0x3fd93265add9c27f, double:0.393701)
            double r0 = r0 * r4
            double r2 = java.lang.Math.floor(r2)
            int r2 = (int) r2
            int r2 = r2 * 12
            double r2 = (double) r2
            double r0 = r0 - r2
            int r0 = sk.c.a(r0)
            r6.<init>(r7, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coffeemeetsbagel.new_user_experience.match_prefs.height_imperial.o.<init>(float):void");
    }
}
