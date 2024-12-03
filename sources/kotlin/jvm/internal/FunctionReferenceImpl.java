package kotlin.jvm.internal;

import wk.c;
import wk.f;

public class FunctionReferenceImpl extends FunctionReference {
    public FunctionReferenceImpl(int i10, f fVar, String str, String str2) {
        super(i10, CallableReference.NO_RECEIVER, ((c) fVar).c(), str, str2, (fVar instanceof c) ^ true ? 1 : 0);
    }

    public FunctionReferenceImpl(int i10, Class cls, String str, String str2, int i11) {
        super(i10, CallableReference.NO_RECEIVER, cls, str, str2, i11);
    }

    public FunctionReferenceImpl(int i10, Object obj, Class cls, String str, String str2, int i11) {
        super(i10, obj, cls, str, str2, i11);
    }
}
