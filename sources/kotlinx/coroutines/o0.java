package kotlinx.coroutines;

import kotlin.Metadata;
import kotlinx.coroutines.internal.g0;
import kotlinx.coroutines.internal.w;

@Metadata(bv = {}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\u001a\b\u0010\u0001\u001a\u00020\u0000H\u0002\"\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004\"\u001a\u0010\b\u001a\u00020\u00008\u0000X\u0004¢\u0006\f\n\u0004\b\u0001\u0010\u0006\u001a\u0004\b\u0003\u0010\u0007¨\u0006\t"}, d2 = {"Lkotlinx/coroutines/r0;", "b", "", "a", "Z", "defaultMainDelayOptIn", "Lkotlinx/coroutines/r0;", "()Lkotlinx/coroutines/r0;", "DefaultDelay", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0})
public final class o0 {

    /* renamed from: a  reason: collision with root package name */
    private static final boolean f32591a = g0.e("kotlinx.coroutines.main.delay", false);

    /* renamed from: b  reason: collision with root package name */
    private static final r0 f32592b = b();

    public static final r0 a() {
        return f32592b;
    }

    private static final r0 b() {
        if (!f32591a) {
            return n0.f32584h;
        }
        c2 c10 = x0.c();
        if (w.c(c10) || !(c10 instanceof r0)) {
            return n0.f32584h;
        }
        return (r0) c10;
    }
}
