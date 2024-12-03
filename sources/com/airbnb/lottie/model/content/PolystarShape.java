package com.airbnb.lottie.model.content;

import android.graphics.PointF;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.h;
import com.airbnb.lottie.model.layer.a;
import t2.n;
import x2.b;
import x2.m;
import y2.c;

public class PolystarShape implements c {

    /* renamed from: a  reason: collision with root package name */
    private final String f8653a;

    /* renamed from: b  reason: collision with root package name */
    private final Type f8654b;

    /* renamed from: c  reason: collision with root package name */
    private final b f8655c;

    /* renamed from: d  reason: collision with root package name */
    private final m<PointF, PointF> f8656d;

    /* renamed from: e  reason: collision with root package name */
    private final b f8657e;

    /* renamed from: f  reason: collision with root package name */
    private final b f8658f;

    /* renamed from: g  reason: collision with root package name */
    private final b f8659g;

    /* renamed from: h  reason: collision with root package name */
    private final b f8660h;

    /* renamed from: i  reason: collision with root package name */
    private final b f8661i;

    /* renamed from: j  reason: collision with root package name */
    private final boolean f8662j;

    /* renamed from: k  reason: collision with root package name */
    private final boolean f8663k;

    public enum Type {
        STAR(1),
        POLYGON(2);
        
        private final int value;

        private Type(int i10) {
            this.value = i10;
        }

        public static Type b(int i10) {
            for (Type type : values()) {
                if (type.value == i10) {
                    return type;
                }
            }
            return null;
        }
    }

    public PolystarShape(String str, Type type, b bVar, m<PointF, PointF> mVar, b bVar2, b bVar3, b bVar4, b bVar5, b bVar6, boolean z10, boolean z11) {
        this.f8653a = str;
        this.f8654b = type;
        this.f8655c = bVar;
        this.f8656d = mVar;
        this.f8657e = bVar2;
        this.f8658f = bVar3;
        this.f8659g = bVar4;
        this.f8660h = bVar5;
        this.f8661i = bVar6;
        this.f8662j = z10;
        this.f8663k = z11;
    }

    public t2.c a(LottieDrawable lottieDrawable, h hVar, a aVar) {
        return new n(lottieDrawable, aVar, this);
    }

    public b b() {
        return this.f8658f;
    }

    public b c() {
        return this.f8660h;
    }

    public String d() {
        return this.f8653a;
    }

    public b e() {
        return this.f8659g;
    }

    public b f() {
        return this.f8661i;
    }

    public b g() {
        return this.f8655c;
    }

    public m<PointF, PointF> h() {
        return this.f8656d;
    }

    public b i() {
        return this.f8657e;
    }

    public Type j() {
        return this.f8654b;
    }

    public boolean k() {
        return this.f8662j;
    }

    public boolean l() {
        return this.f8663k;
    }
}
