package com.bumptech.glide;

import android.content.Context;
import androidx.annotation.NonNull;
import com.bumptech.glide.c;
import com.bumptech.glide.load.engine.h;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import m3.b;
import m3.e;
import m3.j;
import n3.a;
import n3.g;
import n3.i;
import y3.f;
import y3.l;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    private final Map<Class<?>, i<?, ?>> f9165a = new androidx.collection.a();

    /* renamed from: b  reason: collision with root package name */
    private h f9166b;

    /* renamed from: c  reason: collision with root package name */
    private m3.d f9167c;

    /* renamed from: d  reason: collision with root package name */
    private b f9168d;

    /* renamed from: e  reason: collision with root package name */
    private n3.h f9169e;

    /* renamed from: f  reason: collision with root package name */
    private o3.a f9170f;

    /* renamed from: g  reason: collision with root package name */
    private o3.a f9171g;

    /* renamed from: h  reason: collision with root package name */
    private a.C0176a f9172h;

    /* renamed from: i  reason: collision with root package name */
    private i f9173i;

    /* renamed from: j  reason: collision with root package name */
    private y3.d f9174j;

    /* renamed from: k  reason: collision with root package name */
    private int f9175k = 4;

    /* renamed from: l  reason: collision with root package name */
    private c.a f9176l = new a();

    /* renamed from: m  reason: collision with root package name */
    private l.b f9177m;

    /* renamed from: n  reason: collision with root package name */
    private o3.a f9178n;

    /* renamed from: o  reason: collision with root package name */
    private boolean f9179o;

    /* renamed from: p  reason: collision with root package name */
    private List<b4.b<Object>> f9180p;

    /* renamed from: q  reason: collision with root package name */
    private boolean f9181q;

    /* renamed from: r  reason: collision with root package name */
    private boolean f9182r;

    class a implements c.a {
        a() {
        }

        @NonNull
        public b4.c build() {
            return new b4.c();
        }
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public c a(@NonNull Context context) {
        Context context2 = context;
        if (this.f9170f == null) {
            this.f9170f = o3.a.g();
        }
        if (this.f9171g == null) {
            this.f9171g = o3.a.e();
        }
        if (this.f9178n == null) {
            this.f9178n = o3.a.c();
        }
        if (this.f9173i == null) {
            this.f9173i = new i.a(context2).a();
        }
        if (this.f9174j == null) {
            this.f9174j = new f();
        }
        if (this.f9167c == null) {
            int b10 = this.f9173i.b();
            if (b10 > 0) {
                this.f9167c = new j((long) b10);
            } else {
                this.f9167c = new e();
            }
        }
        if (this.f9168d == null) {
            this.f9168d = new m3.i(this.f9173i.a());
        }
        if (this.f9169e == null) {
            this.f9169e = new g((long) this.f9173i.d());
        }
        if (this.f9172h == null) {
            this.f9172h = new n3.f(context2);
        }
        if (this.f9166b == null) {
            this.f9166b = new h(this.f9169e, this.f9172h, this.f9171g, this.f9170f, o3.a.h(), this.f9178n, this.f9179o);
        }
        List<b4.b<Object>> list = this.f9180p;
        if (list == null) {
            this.f9180p = Collections.emptyList();
        } else {
            this.f9180p = Collections.unmodifiableList(list);
        }
        return new c(context, this.f9166b, this.f9169e, this.f9167c, this.f9168d, new l(this.f9177m), this.f9174j, this.f9175k, this.f9176l, this.f9165a, this.f9180p, this.f9181q, this.f9182r);
    }

    /* access modifiers changed from: package-private */
    public void b(l.b bVar) {
        this.f9177m = bVar;
    }
}
