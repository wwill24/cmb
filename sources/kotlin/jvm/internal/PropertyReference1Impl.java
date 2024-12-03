package kotlin.jvm.internal;

import wk.c;
import wk.f;

public class PropertyReference1Impl extends PropertyReference1 {
    public PropertyReference1Impl(f fVar, String str, String str2) {
        super(CallableReference.NO_RECEIVER, ((c) fVar).c(), str, str2, (fVar instanceof c) ^ true ? 1 : 0);
    }

    public Object get(Object obj) {
        return b().call(obj);
    }

    public PropertyReference1Impl(Class cls, String str, String str2, int i10) {
        super(CallableReference.NO_RECEIVER, cls, str, str2, i10);
    }
}
