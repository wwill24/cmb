package com.airbnb.lottie.model.content;

import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.h;
import com.airbnb.lottie.model.content.ShapeStroke;
import java.util.List;
import t2.i;
import x2.b;
import x2.d;
import x2.f;
import y2.c;

public class a implements c {

    /* renamed from: a  reason: collision with root package name */
    private final String f8696a;

    /* renamed from: b  reason: collision with root package name */
    private final GradientType f8697b;

    /* renamed from: c  reason: collision with root package name */
    private final x2.c f8698c;

    /* renamed from: d  reason: collision with root package name */
    private final d f8699d;

    /* renamed from: e  reason: collision with root package name */
    private final f f8700e;

    /* renamed from: f  reason: collision with root package name */
    private final f f8701f;

    /* renamed from: g  reason: collision with root package name */
    private final b f8702g;

    /* renamed from: h  reason: collision with root package name */
    private final ShapeStroke.LineCapType f8703h;

    /* renamed from: i  reason: collision with root package name */
    private final ShapeStroke.LineJoinType f8704i;

    /* renamed from: j  reason: collision with root package name */
    private final float f8705j;

    /* renamed from: k  reason: collision with root package name */
    private final List<b> f8706k;

    /* renamed from: l  reason: collision with root package name */
    private final b f8707l;

    /* renamed from: m  reason: collision with root package name */
    private final boolean f8708m;

    public a(String str, GradientType gradientType, x2.c cVar, d dVar, f fVar, f fVar2, b bVar, ShapeStroke.LineCapType lineCapType, ShapeStroke.LineJoinType lineJoinType, float f10, List<b> list, b bVar2, boolean z10) {
        this.f8696a = str;
        this.f8697b = gradientType;
        this.f8698c = cVar;
        this.f8699d = dVar;
        this.f8700e = fVar;
        this.f8701f = fVar2;
        this.f8702g = bVar;
        this.f8703h = lineCapType;
        this.f8704i = lineJoinType;
        this.f8705j = f10;
        this.f8706k = list;
        this.f8707l = bVar2;
        this.f8708m = z10;
    }

    public t2.c a(LottieDrawable lottieDrawable, h hVar, com.airbnb.lottie.model.layer.a aVar) {
        return new i(lottieDrawable, aVar, this);
    }

    public ShapeStroke.LineCapType b() {
        return this.f8703h;
    }

    public b c() {
        return this.f8707l;
    }

    public f d() {
        return this.f8701f;
    }

    public x2.c e() {
        return this.f8698c;
    }

    public GradientType f() {
        return this.f8697b;
    }

    public ShapeStroke.LineJoinType g() {
        return this.f8704i;
    }

    public List<b> h() {
        return this.f8706k;
    }

    public float i() {
        return this.f8705j;
    }

    public String j() {
        return this.f8696a;
    }

    public d k() {
        return this.f8699d;
    }

    public f l() {
        return this.f8700e;
    }

    public b m() {
        return this.f8702g;
    }

    public boolean n() {
        return this.f8708m;
    }
}
