package m1;

import androidx.lifecycle.f0;
import androidx.lifecycle.i0;
import kotlin.jvm.internal.j;

public final class b implements i0.b {

    /* renamed from: b  reason: collision with root package name */
    private final f<?>[] f16280b;

    public b(f<?>... fVarArr) {
        j.g(fVarArr, "initializers");
        this.f16280b = fVarArr;
    }

    public <T extends f0> T b(Class<T> cls, a aVar) {
        j.g(cls, "modelClass");
        j.g(aVar, "extras");
        T t10 = null;
        for (f<?> fVar : this.f16280b) {
            if (j.b(fVar.a(), cls)) {
                T invoke = fVar.b().invoke(aVar);
                if (invoke instanceof f0) {
                    t10 = (f0) invoke;
                } else {
                    t10 = null;
                }
            }
        }
        if (t10 != null) {
            return t10;
        }
        throw new IllegalArgumentException("No initializer set for given class " + cls.getName());
    }
}
