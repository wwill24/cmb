package yi;

import kotlinx.coroutines.flow.b;
import kotlinx.coroutines.flow.d;
import kotlinx.coroutines.flow.i;
import kotlinx.coroutines.flow.s;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    private final i<Boolean> f33991a;

    /* renamed from: b  reason: collision with root package name */
    private final b<Boolean> f33992b;

    public c(boolean z10) {
        i<Boolean> a10 = s.a(Boolean.valueOf(z10));
        this.f33991a = a10;
        this.f33992b = d.n(a10, 1);
    }

    public final b<Boolean> a() {
        return this.f33992b;
    }

    public final void b(boolean z10) {
        this.f33991a.setValue(Boolean.valueOf(z10));
    }
}
