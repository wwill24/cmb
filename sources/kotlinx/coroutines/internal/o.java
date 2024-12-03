package kotlinx.coroutines.internal;

import kotlin.Metadata;

@Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\f\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0000¨\u0006\u0003"}, d2 = {"", "", "a", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0})
public final class o {
    public static final void a(int i10) {
        boolean z10 = true;
        if (i10 < 1) {
            z10 = false;
        }
        if (!z10) {
            throw new IllegalArgumentException(("Expected positive parallelism level, but got " + i10).toString());
        }
    }
}
