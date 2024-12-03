package com.google.gson;

import com.google.gson.internal.c;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    private c f21288a = c.f21350g;

    /* renamed from: b  reason: collision with root package name */
    private LongSerializationPolicy f21289b = LongSerializationPolicy.DEFAULT;

    /* renamed from: c  reason: collision with root package name */
    private c f21290c = FieldNamingPolicy.IDENTITY;

    /* renamed from: d  reason: collision with root package name */
    private final Map<Type, f<?>> f21291d = new HashMap();

    /* renamed from: e  reason: collision with root package name */
    private final List<r> f21292e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    private final List<r> f21293f = new ArrayList();

    /* renamed from: g  reason: collision with root package name */
    private boolean f21294g = false;

    /* renamed from: h  reason: collision with root package name */
    private String f21295h = d.f21257z;

    /* renamed from: i  reason: collision with root package name */
    private int f21296i = 2;

    /* renamed from: j  reason: collision with root package name */
    private int f21297j = 2;

    /* renamed from: k  reason: collision with root package name */
    private boolean f21298k = false;

    /* renamed from: l  reason: collision with root package name */
    private boolean f21299l = false;

    /* renamed from: m  reason: collision with root package name */
    private boolean f21300m = true;

    /* renamed from: n  reason: collision with root package name */
    private boolean f21301n = false;

    /* renamed from: o  reason: collision with root package name */
    private boolean f21302o = false;

    /* renamed from: p  reason: collision with root package name */
    private boolean f21303p = false;

    /* renamed from: q  reason: collision with root package name */
    private boolean f21304q = true;

    /* renamed from: r  reason: collision with root package name */
    private p f21305r = d.B;

    /* renamed from: s  reason: collision with root package name */
    private p f21306s = d.C;

    /* renamed from: t  reason: collision with root package name */
    private final LinkedList<ReflectionAccessFilter> f21307t = new LinkedList<>();

    /* JADX WARNING: Removed duplicated region for block: B:17:0x004a  */
    /* JADX WARNING: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(java.lang.String r5, int r6, int r7, java.util.List<com.google.gson.r> r8) {
        /*
            r4 = this;
            boolean r0 = pg.d.f24377a
            r1 = 0
            if (r5 == 0) goto L_0x0026
            java.lang.String r2 = r5.trim()
            boolean r2 = r2.isEmpty()
            if (r2 != 0) goto L_0x0026
            mg.d$b<java.util.Date> r6 = mg.d.b.f23667b
            com.google.gson.r r6 = r6.b(r5)
            if (r0 == 0) goto L_0x0024
            mg.d$b<? extends java.util.Date> r7 = pg.d.f24379c
            com.google.gson.r r1 = r7.b(r5)
            mg.d$b<? extends java.util.Date> r7 = pg.d.f24378b
            com.google.gson.r r5 = r7.b(r5)
            goto L_0x0045
        L_0x0024:
            r5 = r1
            goto L_0x0045
        L_0x0026:
            r5 = 2
            if (r6 == r5) goto L_0x0050
            if (r7 == r5) goto L_0x0050
            mg.d$b<java.util.Date> r5 = mg.d.b.f23667b
            com.google.gson.r r5 = r5.a(r6, r7)
            if (r0 == 0) goto L_0x0043
            mg.d$b<? extends java.util.Date> r1 = pg.d.f24379c
            com.google.gson.r r1 = r1.a(r6, r7)
            mg.d$b<? extends java.util.Date> r2 = pg.d.f24378b
            com.google.gson.r r6 = r2.a(r6, r7)
            r3 = r6
            r6 = r5
            r5 = r3
            goto L_0x0045
        L_0x0043:
            r6 = r5
            goto L_0x0024
        L_0x0045:
            r8.add(r6)
            if (r0 == 0) goto L_0x0050
            r8.add(r1)
            r8.add(r5)
        L_0x0050:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.e.a(java.lang.String, int, int, java.util.List):void");
    }

    public d b() {
        ArrayList arrayList = r1;
        ArrayList arrayList2 = new ArrayList(this.f21292e.size() + this.f21293f.size() + 3);
        arrayList2.addAll(this.f21292e);
        Collections.reverse(arrayList2);
        ArrayList arrayList3 = new ArrayList(this.f21293f);
        Collections.reverse(arrayList3);
        arrayList2.addAll(arrayList3);
        a(this.f21295h, this.f21296i, this.f21297j, arrayList2);
        c cVar = this.f21288a;
        c cVar2 = this.f21290c;
        HashMap hashMap = r5;
        HashMap hashMap2 = new HashMap(this.f21291d);
        boolean z10 = this.f21294g;
        boolean z11 = this.f21298k;
        boolean z12 = this.f21302o;
        boolean z13 = this.f21300m;
        boolean z14 = this.f21301n;
        boolean z15 = this.f21303p;
        boolean z16 = this.f21299l;
        boolean z17 = this.f21304q;
        LongSerializationPolicy longSerializationPolicy = this.f21289b;
        String str = this.f21295h;
        int i10 = this.f21296i;
        int i11 = this.f21297j;
        ArrayList arrayList4 = r1;
        c cVar3 = cVar;
        ArrayList arrayList5 = new ArrayList(this.f21292e);
        ArrayList arrayList6 = r1;
        ArrayList arrayList7 = new ArrayList(this.f21293f);
        p pVar = this.f21305r;
        p pVar2 = this.f21306s;
        ArrayList arrayList8 = r1;
        ArrayList arrayList9 = new ArrayList(this.f21307t);
        return new d(cVar3, cVar2, hashMap, z10, z11, z12, z13, z14, z15, z16, z17, longSerializationPolicy, str, i10, i11, arrayList4, arrayList6, arrayList, pVar, pVar2, arrayList8);
    }

    public e c(FieldNamingPolicy fieldNamingPolicy) {
        return d(fieldNamingPolicy);
    }

    public e d(c cVar) {
        Objects.requireNonNull(cVar);
        this.f21290c = cVar;
        return this;
    }
}
