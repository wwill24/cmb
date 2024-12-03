package m1;

import androidx.lifecycle.f0;
import androidx.lifecycle.i0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.j;
import ok.a;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    private final List<f<?>> f16281a = new ArrayList();

    public final <T extends f0> void a(wk.c<T> cVar, Function1<? super a, ? extends T> function1) {
        j.g(cVar, "clazz");
        j.g(function1, "initializer");
        this.f16281a.add(new f(a.a(cVar), function1));
    }

    public final i0.b b() {
        f[] fVarArr = (f[]) this.f16281a.toArray(new f[0]);
        return new b((f[]) Arrays.copyOf(fVarArr, fVarArr.length));
    }
}
