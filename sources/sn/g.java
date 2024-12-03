package sn;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import qj.a;
import qj.h;
import qj.m;
import qj.q;
import qj.v;
import qj.w;
import retrofit2.c;
import retrofit2.r;
import retrofit2.s;

public final class g extends c.a {

    /* renamed from: a  reason: collision with root package name */
    private final v f42467a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f42468b;

    private g(v vVar, boolean z10) {
        this.f42467a = vVar;
        this.f42468b = z10;
    }

    public static g d() {
        return new g((v) null, false);
    }

    public c<?, ?> a(Type type, Annotation[] annotationArr, s sVar) {
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        Type type2;
        String str;
        Class<?> c10 = c.a.c(type);
        if (c10 == a.class) {
            return new f(Void.class, this.f42467a, this.f42468b, false, true, false, false, false, true);
        }
        if (c10 == h.class) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (c10 == w.class) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (c10 == m.class) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (c10 != q.class && !z10 && !z11 && !z12) {
            return null;
        }
        if (!(type instanceof ParameterizedType)) {
            if (z10) {
                str = "Flowable";
            } else if (z11) {
                str = "Single";
            } else if (z12) {
                str = "Maybe";
            } else {
                str = "Observable";
            }
            throw new IllegalStateException(str + " return type must be parameterized as " + str + "<Foo> or " + str + "<? extends Foo>");
        }
        Type b10 = c.a.b(0, (ParameterizedType) type);
        Class<?> c11 = c.a.c(b10);
        if (c11 == r.class) {
            if (b10 instanceof ParameterizedType) {
                type2 = c.a.b(0, (ParameterizedType) b10);
                z14 = false;
                z13 = false;
            } else {
                throw new IllegalStateException("Response must be parameterized as Response<Foo> or Response<? extends Foo>");
            }
        } else if (c11 != d.class) {
            type2 = b10;
            z13 = true;
            z14 = false;
        } else if (b10 instanceof ParameterizedType) {
            type2 = c.a.b(0, (ParameterizedType) b10);
            z14 = true;
            z13 = false;
        } else {
            throw new IllegalStateException("Result must be parameterized as Result<Foo> or Result<? extends Foo>");
        }
        return new f(type2, this.f42467a, this.f42468b, z14, z13, z10, z11, z12, false);
    }
}
