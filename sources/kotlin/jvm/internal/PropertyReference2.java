package kotlin.jvm.internal;

import wk.b;
import wk.k;

public abstract class PropertyReference2 extends PropertyReference implements k {
    public PropertyReference2(Class cls, String str, String str2, int i10) {
        super(CallableReference.NO_RECEIVER, cls, str, str2, i10);
    }

    public k.a b() {
        return ((k) getReflected()).b();
    }

    /* access modifiers changed from: protected */
    public b computeReflected() {
        return l.h(this);
    }

    public Object invoke(Object obj, Object obj2) {
        return x(obj, obj2);
    }
}
