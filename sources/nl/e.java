package nl;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import ml.b;
import p004do.a;

public final class e implements b {

    /* renamed from: a  reason: collision with root package name */
    private final Function1<Object, Unit> f32810a;

    public e(Function1<Object, Unit> function1) {
        this.f32810a = function1;
    }

    public Object f(Object obj, Object obj2) {
        Object P = CollectionsKt___CollectionsKt.P(a.c(obj));
        Function1<Object, Unit> function1 = this.f32810a;
        if (function1 != null) {
            function1.invoke(P);
        }
        return P;
    }
}
