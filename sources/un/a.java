package un;

import com.squareup.moshi.h;
import com.squareup.moshi.j;
import com.squareup.moshi.s;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;
import okhttp3.b0;
import okhttp3.z;
import retrofit2.f;

public final class a extends f.a {

    /* renamed from: a  reason: collision with root package name */
    private final s f42476a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f42477b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f42478c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f42479d;

    private a(s sVar, boolean z10, boolean z11, boolean z12) {
        this.f42476a = sVar;
        this.f42477b = z10;
        this.f42478c = z11;
        this.f42479d = z12;
    }

    public static a f(s sVar) {
        if (sVar != null) {
            return new a(sVar, false, false, false);
        }
        throw new NullPointerException("moshi == null");
    }

    private static Set<? extends Annotation> g(Annotation[] annotationArr) {
        LinkedHashSet linkedHashSet = null;
        for (Annotation annotation : annotationArr) {
            if (annotation.annotationType().isAnnotationPresent(j.class)) {
                if (linkedHashSet == null) {
                    linkedHashSet = new LinkedHashSet();
                }
                linkedHashSet.add(annotation);
            }
        }
        if (linkedHashSet != null) {
            return Collections.unmodifiableSet(linkedHashSet);
        }
        return Collections.emptySet();
    }

    public f<?, z> c(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, retrofit2.s sVar) {
        h<T> e10 = this.f42476a.e(type, g(annotationArr));
        if (this.f42477b) {
            e10 = e10.lenient();
        }
        if (this.f42478c) {
            e10 = e10.failOnUnknown();
        }
        if (this.f42479d) {
            e10 = e10.serializeNulls();
        }
        return new b(e10);
    }

    public f<b0, ?> d(Type type, Annotation[] annotationArr, retrofit2.s sVar) {
        h<T> e10 = this.f42476a.e(type, g(annotationArr));
        if (this.f42477b) {
            e10 = e10.lenient();
        }
        if (this.f42478c) {
            e10 = e10.failOnUnknown();
        }
        if (this.f42479d) {
            e10 = e10.serializeNulls();
        }
        return new c(e10);
    }
}
