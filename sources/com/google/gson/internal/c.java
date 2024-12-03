package com.google.gson.internal;

import com.google.gson.b;
import com.google.gson.d;
import com.google.gson.q;
import com.google.gson.r;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.List;
import lg.e;

public final class c implements r, Cloneable {

    /* renamed from: g  reason: collision with root package name */
    public static final c f21350g = new c();

    /* renamed from: a  reason: collision with root package name */
    private double f21351a = -1.0d;

    /* renamed from: b  reason: collision with root package name */
    private int f21352b = 136;

    /* renamed from: c  reason: collision with root package name */
    private boolean f21353c = true;

    /* renamed from: d  reason: collision with root package name */
    private boolean f21354d;

    /* renamed from: e  reason: collision with root package name */
    private List<com.google.gson.a> f21355e = Collections.emptyList();

    /* renamed from: f  reason: collision with root package name */
    private List<com.google.gson.a> f21356f = Collections.emptyList();

    class a extends q<T> {

        /* renamed from: a  reason: collision with root package name */
        private q<T> f21357a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ boolean f21358b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ boolean f21359c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ d f21360d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ qg.a f21361e;

        a(boolean z10, boolean z11, d dVar, qg.a aVar) {
            this.f21358b = z10;
            this.f21359c = z11;
            this.f21360d = dVar;
            this.f21361e = aVar;
        }

        private q<T> e() {
            q<T> qVar = this.f21357a;
            if (qVar != null) {
                return qVar;
            }
            q<T> p10 = this.f21360d.p(c.this, this.f21361e);
            this.f21357a = p10;
            return p10;
        }

        public T b(JsonReader jsonReader) throws IOException {
            if (!this.f21358b) {
                return e().b(jsonReader);
            }
            jsonReader.skipValue();
            return null;
        }

        public void d(JsonWriter jsonWriter, T t10) throws IOException {
            if (this.f21359c) {
                jsonWriter.nullValue();
            } else {
                e().d(jsonWriter, t10);
            }
        }
    }

    private boolean d(Class<?> cls) {
        if (this.f21351a != -1.0d && !p((lg.d) cls.getAnnotation(lg.d.class), (e) cls.getAnnotation(e.class))) {
            return true;
        }
        if (this.f21353c || !j(cls)) {
            return i(cls);
        }
        return true;
    }

    private boolean e(Class<?> cls, boolean z10) {
        List<com.google.gson.a> list;
        if (z10) {
            list = this.f21355e;
        } else {
            list = this.f21356f;
        }
        for (com.google.gson.a b10 : list) {
            if (b10.b(cls)) {
                return true;
            }
        }
        return false;
    }

    private boolean i(Class<?> cls) {
        if (Enum.class.isAssignableFrom(cls) || k(cls) || (!cls.isAnonymousClass() && !cls.isLocalClass())) {
            return false;
        }
        return true;
    }

    private boolean j(Class<?> cls) {
        return cls.isMemberClass() && !k(cls);
    }

    private boolean k(Class<?> cls) {
        return (cls.getModifiers() & 8) != 0;
    }

    private boolean l(lg.d dVar) {
        if (dVar == null) {
            return true;
        }
        if (this.f21351a >= dVar.value()) {
            return true;
        }
        return false;
    }

    private boolean o(e eVar) {
        if (eVar == null) {
            return true;
        }
        if (this.f21351a < eVar.value()) {
            return true;
        }
        return false;
    }

    private boolean p(lg.d dVar, e eVar) {
        return l(dVar) && o(eVar);
    }

    public <T> q<T> a(d dVar, qg.a<T> aVar) {
        boolean z10;
        boolean z11;
        Class<? super T> c10 = aVar.c();
        boolean d10 = d(c10);
        if (d10 || e(c10, true)) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (d10 || e(c10, false)) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z10 || z11) {
            return new a(z11, z10, dVar, aVar);
        }
        return null;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public c clone() {
        try {
            return (c) super.clone();
        } catch (CloneNotSupportedException e10) {
            throw new AssertionError(e10);
        }
    }

    public boolean c(Class<?> cls, boolean z10) {
        if (d(cls) || e(cls, z10)) {
            return true;
        }
        return false;
    }

    public boolean h(Field field, boolean z10) {
        List<com.google.gson.a> list;
        lg.a aVar;
        if ((this.f21352b & field.getModifiers()) != 0) {
            return true;
        }
        if ((this.f21351a != -1.0d && !p((lg.d) field.getAnnotation(lg.d.class), (e) field.getAnnotation(e.class))) || field.isSynthetic()) {
            return true;
        }
        if (this.f21354d && ((aVar = (lg.a) field.getAnnotation(lg.a.class)) == null || (!z10 ? !aVar.deserialize() : !aVar.serialize()))) {
            return true;
        }
        if ((!this.f21353c && j(field.getType())) || i(field.getType())) {
            return true;
        }
        if (z10) {
            list = this.f21355e;
        } else {
            list = this.f21356f;
        }
        if (list.isEmpty()) {
            return false;
        }
        b bVar = new b(field);
        for (com.google.gson.a a10 : list) {
            if (a10.a(bVar)) {
                return true;
            }
        }
        return false;
    }
}
