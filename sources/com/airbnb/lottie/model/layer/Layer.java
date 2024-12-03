package com.airbnb.lottie.model.layer;

import com.airbnb.lottie.h;
import com.airbnb.lottie.model.content.Mask;
import d3.a;
import java.util.List;
import java.util.Locale;
import x2.b;
import x2.j;
import x2.k;
import x2.l;
import y2.c;

public class Layer {

    /* renamed from: a  reason: collision with root package name */
    private final List<c> f8709a;

    /* renamed from: b  reason: collision with root package name */
    private final h f8710b;

    /* renamed from: c  reason: collision with root package name */
    private final String f8711c;

    /* renamed from: d  reason: collision with root package name */
    private final long f8712d;

    /* renamed from: e  reason: collision with root package name */
    private final LayerType f8713e;

    /* renamed from: f  reason: collision with root package name */
    private final long f8714f;

    /* renamed from: g  reason: collision with root package name */
    private final String f8715g;

    /* renamed from: h  reason: collision with root package name */
    private final List<Mask> f8716h;

    /* renamed from: i  reason: collision with root package name */
    private final l f8717i;

    /* renamed from: j  reason: collision with root package name */
    private final int f8718j;

    /* renamed from: k  reason: collision with root package name */
    private final int f8719k;

    /* renamed from: l  reason: collision with root package name */
    private final int f8720l;

    /* renamed from: m  reason: collision with root package name */
    private final float f8721m;

    /* renamed from: n  reason: collision with root package name */
    private final float f8722n;

    /* renamed from: o  reason: collision with root package name */
    private final float f8723o;

    /* renamed from: p  reason: collision with root package name */
    private final float f8724p;

    /* renamed from: q  reason: collision with root package name */
    private final j f8725q;

    /* renamed from: r  reason: collision with root package name */
    private final k f8726r;

    /* renamed from: s  reason: collision with root package name */
    private final b f8727s;

    /* renamed from: t  reason: collision with root package name */
    private final List<a<Float>> f8728t;

    /* renamed from: u  reason: collision with root package name */
    private final MatteType f8729u;

    /* renamed from: v  reason: collision with root package name */
    private final boolean f8730v;

    /* renamed from: w  reason: collision with root package name */
    private final y2.a f8731w;

    /* renamed from: x  reason: collision with root package name */
    private final b3.j f8732x;

    public enum LayerType {
        PRE_COMP,
        SOLID,
        IMAGE,
        NULL,
        SHAPE,
        TEXT,
        UNKNOWN
    }

    public enum MatteType {
        NONE,
        ADD,
        INVERT,
        LUMA,
        LUMA_INVERTED,
        UNKNOWN
    }

    public Layer(List<c> list, h hVar, String str, long j10, LayerType layerType, long j11, String str2, List<Mask> list2, l lVar, int i10, int i11, int i12, float f10, float f11, float f12, float f13, j jVar, k kVar, List<a<Float>> list3, MatteType matteType, b bVar, boolean z10, y2.a aVar, b3.j jVar2) {
        this.f8709a = list;
        this.f8710b = hVar;
        this.f8711c = str;
        this.f8712d = j10;
        this.f8713e = layerType;
        this.f8714f = j11;
        this.f8715g = str2;
        this.f8716h = list2;
        this.f8717i = lVar;
        this.f8718j = i10;
        this.f8719k = i11;
        this.f8720l = i12;
        this.f8721m = f10;
        this.f8722n = f11;
        this.f8723o = f12;
        this.f8724p = f13;
        this.f8725q = jVar;
        this.f8726r = kVar;
        this.f8728t = list3;
        this.f8729u = matteType;
        this.f8727s = bVar;
        this.f8730v = z10;
        this.f8731w = aVar;
        this.f8732x = jVar2;
    }

    public y2.a a() {
        return this.f8731w;
    }

    /* access modifiers changed from: package-private */
    public h b() {
        return this.f8710b;
    }

    public b3.j c() {
        return this.f8732x;
    }

    public long d() {
        return this.f8712d;
    }

    /* access modifiers changed from: package-private */
    public List<a<Float>> e() {
        return this.f8728t;
    }

    public LayerType f() {
        return this.f8713e;
    }

    /* access modifiers changed from: package-private */
    public List<Mask> g() {
        return this.f8716h;
    }

    /* access modifiers changed from: package-private */
    public MatteType h() {
        return this.f8729u;
    }

    public String i() {
        return this.f8711c;
    }

    /* access modifiers changed from: package-private */
    public long j() {
        return this.f8714f;
    }

    /* access modifiers changed from: package-private */
    public float k() {
        return this.f8724p;
    }

    /* access modifiers changed from: package-private */
    public float l() {
        return this.f8723o;
    }

    public String m() {
        return this.f8715g;
    }

    /* access modifiers changed from: package-private */
    public List<c> n() {
        return this.f8709a;
    }

    /* access modifiers changed from: package-private */
    public int o() {
        return this.f8720l;
    }

    /* access modifiers changed from: package-private */
    public int p() {
        return this.f8719k;
    }

    /* access modifiers changed from: package-private */
    public int q() {
        return this.f8718j;
    }

    /* access modifiers changed from: package-private */
    public float r() {
        return this.f8722n / this.f8710b.e();
    }

    /* access modifiers changed from: package-private */
    public j s() {
        return this.f8725q;
    }

    /* access modifiers changed from: package-private */
    public k t() {
        return this.f8726r;
    }

    public String toString() {
        return y("");
    }

    /* access modifiers changed from: package-private */
    public b u() {
        return this.f8727s;
    }

    /* access modifiers changed from: package-private */
    public float v() {
        return this.f8721m;
    }

    /* access modifiers changed from: package-private */
    public l w() {
        return this.f8717i;
    }

    public boolean x() {
        return this.f8730v;
    }

    public String y(String str) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append(i());
        sb2.append("\n");
        Layer t10 = this.f8710b.t(j());
        if (t10 != null) {
            sb2.append("\t\tParents: ");
            sb2.append(t10.i());
            Layer t11 = this.f8710b.t(t10.j());
            while (t11 != null) {
                sb2.append("->");
                sb2.append(t11.i());
                t11 = this.f8710b.t(t11.j());
            }
            sb2.append(str);
            sb2.append("\n");
        }
        if (!g().isEmpty()) {
            sb2.append(str);
            sb2.append("\tMasks: ");
            sb2.append(g().size());
            sb2.append("\n");
        }
        if (!(q() == 0 || p() == 0)) {
            sb2.append(str);
            sb2.append("\tBackground: ");
            sb2.append(String.format(Locale.US, "%dx%d %X\n", new Object[]{Integer.valueOf(q()), Integer.valueOf(p()), Integer.valueOf(o())}));
        }
        if (!this.f8709a.isEmpty()) {
            sb2.append(str);
            sb2.append("\tShapes:\n");
            for (c next : this.f8709a) {
                sb2.append(str);
                sb2.append("\t\t");
                sb2.append(next);
                sb2.append("\n");
            }
        }
        return sb2.toString();
    }
}
