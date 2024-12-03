package kotlin.jvm.internal;

import java.util.Collections;
import kotlin.reflect.KTypeProjection;
import wk.c;
import wk.f;
import wk.g;
import wk.h;
import wk.i;
import wk.j;
import wk.k;
import wk.m;

public class l {

    /* renamed from: a  reason: collision with root package name */
    private static final m f32138a;

    /* renamed from: b  reason: collision with root package name */
    private static final c[] f32139b = new c[0];

    static {
        m mVar = null;
        try {
            mVar = (m) Class.forName("kotlin.reflect.jvm.internal.ReflectionFactoryImpl").newInstance();
        } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | InstantiationException unused) {
        }
        if (mVar == null) {
            mVar = new m();
        }
        f32138a = mVar;
    }

    public static g a(FunctionReference functionReference) {
        return f32138a.a(functionReference);
    }

    public static c b(Class cls) {
        return f32138a.b(cls);
    }

    public static f c(Class cls) {
        return f32138a.c(cls, "");
    }

    public static h d(MutablePropertyReference1 mutablePropertyReference1) {
        return f32138a.d(mutablePropertyReference1);
    }

    public static m e(Class cls) {
        return f32138a.j(b(cls), Collections.emptyList(), true);
    }

    public static i f(PropertyReference0 propertyReference0) {
        return f32138a.e(propertyReference0);
    }

    public static j g(PropertyReference1 propertyReference1) {
        return f32138a.f(propertyReference1);
    }

    public static k h(PropertyReference2 propertyReference2) {
        return f32138a.g(propertyReference2);
    }

    public static String i(g gVar) {
        return f32138a.h(gVar);
    }

    public static String j(Lambda lambda) {
        return f32138a.i(lambda);
    }

    public static m k(Class cls) {
        return f32138a.j(b(cls), Collections.emptyList(), false);
    }

    public static m l(Class cls, KTypeProjection kTypeProjection) {
        return f32138a.j(b(cls), Collections.singletonList(kTypeProjection), false);
    }
}
