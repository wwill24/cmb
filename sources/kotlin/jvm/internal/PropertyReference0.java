package kotlin.jvm.internal;

import wk.b;
import wk.i;

public abstract class PropertyReference0 extends PropertyReference implements i {
    public PropertyReference0() {
    }

    public i.a b() {
        return ((i) getReflected()).b();
    }

    /* access modifiers changed from: protected */
    public b computeReflected() {
        return l.f(this);
    }

    public Object invoke() {
        return get();
    }

    public PropertyReference0(Object obj, Class cls, String str, String str2, int i10) {
        super(obj, cls, str, str2, i10);
    }
}
