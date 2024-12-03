package com.airbnb.lottie.model;

import android.graphics.PointF;

public class DocumentData {

    /* renamed from: a  reason: collision with root package name */
    public String f8615a;

    /* renamed from: b  reason: collision with root package name */
    public String f8616b;

    /* renamed from: c  reason: collision with root package name */
    public float f8617c;

    /* renamed from: d  reason: collision with root package name */
    public Justification f8618d;

    /* renamed from: e  reason: collision with root package name */
    public int f8619e;

    /* renamed from: f  reason: collision with root package name */
    public float f8620f;

    /* renamed from: g  reason: collision with root package name */
    public float f8621g;

    /* renamed from: h  reason: collision with root package name */
    public int f8622h;

    /* renamed from: i  reason: collision with root package name */
    public int f8623i;

    /* renamed from: j  reason: collision with root package name */
    public float f8624j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f8625k;

    /* renamed from: l  reason: collision with root package name */
    public PointF f8626l;

    /* renamed from: m  reason: collision with root package name */
    public PointF f8627m;

    public enum Justification {
        LEFT_ALIGN,
        RIGHT_ALIGN,
        CENTER
    }

    public DocumentData(String str, String str2, float f10, Justification justification, int i10, float f11, float f12, int i11, int i12, float f13, boolean z10, PointF pointF, PointF pointF2) {
        a(str, str2, f10, justification, i10, f11, f12, i11, i12, f13, z10, pointF, pointF2);
    }

    public void a(String str, String str2, float f10, Justification justification, int i10, float f11, float f12, int i11, int i12, float f13, boolean z10, PointF pointF, PointF pointF2) {
        this.f8615a = str;
        this.f8616b = str2;
        this.f8617c = f10;
        this.f8618d = justification;
        this.f8619e = i10;
        this.f8620f = f11;
        this.f8621g = f12;
        this.f8622h = i11;
        this.f8623i = i12;
        this.f8624j = f13;
        this.f8625k = z10;
        this.f8626l = pointF;
        this.f8627m = pointF2;
    }

    public int hashCode() {
        int hashCode = (((((int) (((float) (((this.f8615a.hashCode() * 31) + this.f8616b.hashCode()) * 31)) + this.f8617c)) * 31) + this.f8618d.ordinal()) * 31) + this.f8619e;
        long floatToRawIntBits = (long) Float.floatToRawIntBits(this.f8620f);
        return (((hashCode * 31) + ((int) (floatToRawIntBits ^ (floatToRawIntBits >>> 32)))) * 31) + this.f8622h;
    }

    public DocumentData() {
    }
}
