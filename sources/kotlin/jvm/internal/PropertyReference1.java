package kotlin.jvm.internal;

import wk.b;
import wk.j;

public abstract class PropertyReference1 extends PropertyReference implements j {
    public PropertyReference1(Object obj, Class cls, String str, String str2, int i10) {
        super(obj, cls, str, str2, i10);
    }

    public j.a b() {
        return ((j) getReflected()).b();
    }

    /* access modifiers changed from: protected */
    public b computeReflected() {
        return l.g(this);
    }

    public Object invoke(Object obj) {
        return get(obj);
    }
}
