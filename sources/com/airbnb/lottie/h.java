package com.airbnb.lottie;

import android.graphics.Rect;
import androidx.annotation.NonNull;
import androidx.collection.e;
import c3.f;
import c3.i;
import com.airbnb.lottie.model.layer.Layer;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import w2.b;
import w2.c;
import w2.g;

public class h {

    /* renamed from: a  reason: collision with root package name */
    private final m0 f8550a = new m0();

    /* renamed from: b  reason: collision with root package name */
    private final HashSet<String> f8551b = new HashSet<>();

    /* renamed from: c  reason: collision with root package name */
    private Map<String, List<Layer>> f8552c;

    /* renamed from: d  reason: collision with root package name */
    private Map<String, d0> f8553d;

    /* renamed from: e  reason: collision with root package name */
    private Map<String, b> f8554e;

    /* renamed from: f  reason: collision with root package name */
    private List<g> f8555f;

    /* renamed from: g  reason: collision with root package name */
    private androidx.collection.h<c> f8556g;

    /* renamed from: h  reason: collision with root package name */
    private e<Layer> f8557h;

    /* renamed from: i  reason: collision with root package name */
    private List<Layer> f8558i;

    /* renamed from: j  reason: collision with root package name */
    private Rect f8559j;

    /* renamed from: k  reason: collision with root package name */
    private float f8560k;

    /* renamed from: l  reason: collision with root package name */
    private float f8561l;

    /* renamed from: m  reason: collision with root package name */
    private float f8562m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f8563n;

    /* renamed from: o  reason: collision with root package name */
    private int f8564o = 0;

    public void a(String str) {
        f.c(str);
        this.f8551b.add(str);
    }

    public Rect b() {
        return this.f8559j;
    }

    public androidx.collection.h<c> c() {
        return this.f8556g;
    }

    public float d() {
        return (float) ((long) ((e() / this.f8562m) * 1000.0f));
    }

    public float e() {
        return this.f8561l - this.f8560k;
    }

    public float f() {
        return this.f8561l;
    }

    public Map<String, b> g() {
        return this.f8554e;
    }

    public float h(float f10) {
        return i.i(this.f8560k, this.f8561l, f10);
    }

    public float i() {
        return this.f8562m;
    }

    public Map<String, d0> j() {
        return this.f8553d;
    }

    public List<Layer> k() {
        return this.f8558i;
    }

    public g l(String str) {
        int size = this.f8555f.size();
        for (int i10 = 0; i10 < size; i10++) {
            g gVar = this.f8555f.get(i10);
            if (gVar.a(str)) {
                return gVar;
            }
        }
        return null;
    }

    public int m() {
        return this.f8564o;
    }

    public m0 n() {
        return this.f8550a;
    }

    public List<Layer> o(String str) {
        return this.f8552c.get(str);
    }

    public float p() {
        return this.f8560k;
    }

    public boolean q() {
        return this.f8563n;
    }

    public void r(int i10) {
        this.f8564o += i10;
    }

    public void s(Rect rect, float f10, float f11, float f12, List<Layer> list, e<Layer> eVar, Map<String, List<Layer>> map, Map<String, d0> map2, androidx.collection.h<c> hVar, Map<String, b> map3, List<g> list2) {
        this.f8559j = rect;
        this.f8560k = f10;
        this.f8561l = f11;
        this.f8562m = f12;
        this.f8558i = list;
        this.f8557h = eVar;
        this.f8552c = map;
        this.f8553d = map2;
        this.f8556g = hVar;
        this.f8554e = map3;
        this.f8555f = list2;
    }

    public Layer t(long j10) {
        return this.f8557h.e(j10);
    }

    @NonNull
    public String toString() {
        StringBuilder sb2 = new StringBuilder("LottieComposition:\n");
        for (Layer y10 : this.f8558i) {
            sb2.append(y10.y("\t"));
        }
        return sb2.toString();
    }

    public void u(boolean z10) {
        this.f8563n = z10;
    }

    public void v(boolean z10) {
        this.f8550a.b(z10);
    }
}
