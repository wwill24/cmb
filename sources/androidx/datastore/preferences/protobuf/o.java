package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.s;
import androidx.datastore.preferences.protobuf.s.b;
import java.io.IOException;
import java.util.Map;

abstract class o<T extends s.b<T>> {
    o() {
    }

    /* access modifiers changed from: package-private */
    public abstract int a(Map.Entry<?, ?> entry);

    /* access modifiers changed from: package-private */
    public abstract Object b(n nVar, k0 k0Var, int i10);

    /* access modifiers changed from: package-private */
    public abstract s<T> c(Object obj);

    /* access modifiers changed from: package-private */
    public abstract s<T> d(Object obj);

    /* access modifiers changed from: package-private */
    public abstract boolean e(k0 k0Var);

    /* access modifiers changed from: package-private */
    public abstract void f(Object obj);

    /* access modifiers changed from: package-private */
    public abstract <UT, UB> UB g(x0 x0Var, Object obj, n nVar, s<T> sVar, UB ub2, e1<UT, UB> e1Var) throws IOException;

    /* access modifiers changed from: package-private */
    public abstract void h(x0 x0Var, Object obj, n nVar, s<T> sVar) throws IOException;

    /* access modifiers changed from: package-private */
    public abstract void i(ByteString byteString, Object obj, n nVar, s<T> sVar) throws IOException;

    /* access modifiers changed from: package-private */
    public abstract void j(Writer writer, Map.Entry<?, ?> entry) throws IOException;
}
