package kotlin.jvm.internal;

import wk.b;
import wk.h;
import wk.j;

public abstract class MutablePropertyReference1 extends MutablePropertyReference implements h {
    public MutablePropertyReference1(Object obj, Class cls, String str, String str2, int i10) {
        super(obj, cls, str, str2, i10);
    }

    public j.a b() {
        return ((h) getReflected()).b();
    }

    /* access modifiers changed from: protected */
    public b computeReflected() {
        return l.d(this);
    }

    public Object invoke(Object obj) {
        return get(obj);
    }
}
