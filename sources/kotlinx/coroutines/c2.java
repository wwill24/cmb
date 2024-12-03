package kotlinx.coroutines;

import kotlin.Metadata;
import kotlinx.coroutines.internal.o;

@Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0005R\u0014\u0010\n\u001a\u00020\u00008&X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lkotlinx/coroutines/c2;", "Lkotlinx/coroutines/CoroutineDispatcher;", "", "toString", "", "parallelism", "S", "c0", "Y", "()Lkotlinx/coroutines/c2;", "immediate", "<init>", "()V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public abstract class c2 extends CoroutineDispatcher {
    public CoroutineDispatcher S(int i10) {
        o.a(i10);
        return this;
    }

    public abstract c2 Y();

    /* access modifiers changed from: protected */
    public final String c0() {
        c2 c2Var;
        c2 c10 = x0.c();
        if (this == c10) {
            return "Dispatchers.Main";
        }
        try {
            c2Var = c10.Y();
        } catch (UnsupportedOperationException unused) {
            c2Var = null;
        }
        if (this == c2Var) {
            return "Dispatchers.Main.immediate";
        }
        return null;
    }

    public String toString() {
        String c02 = c0();
        if (c02 != null) {
            return c02;
        }
        return m0.a(this) + '@' + m0.b(this);
    }
}
