package tn;

import com.google.gson.d;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import okhttp3.b0;
import okhttp3.z;
import retrofit2.f;
import retrofit2.s;

public final class a extends f.a {

    /* renamed from: a  reason: collision with root package name */
    private final d f42469a;

    private a(d dVar) {
        this.f42469a = dVar;
    }

    public static a f(d dVar) {
        if (dVar != null) {
            return new a(dVar);
        }
        throw new NullPointerException("gson == null");
    }

    public f<?, z> c(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, s sVar) {
        return new b(this.f42469a, this.f42469a.o(qg.a.b(type)));
    }

    public f<b0, ?> d(Type type, Annotation[] annotationArr, s sVar) {
        return new c(this.f42469a, this.f42469a.o(qg.a.b(type)));
    }
}
