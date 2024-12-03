package kotlinx.coroutines;

import kotlin.Metadata;

@Metadata(bv = {}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0011\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0004\u001a\u00020\u0003H\u0003R\u001a\u0010\t\u001a\u00020\u00038\u0010X\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u000b\u001a\u00020\u00038PX\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\b¨\u0006\u0010"}, d2 = {"Lkotlinx/coroutines/u1;", "Lkotlinx/coroutines/JobSupport;", "Lkotlinx/coroutines/z;", "", "e1", "b", "Z", "m0", "()Z", "handlesException", "n0", "onCancelComplete", "Lkotlinx/coroutines/s1;", "parent", "<init>", "(Lkotlinx/coroutines/s1;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public class u1 extends JobSupport implements z {

    /* renamed from: b  reason: collision with root package name */
    private final boolean f32729b = e1();

    public u1(s1 s1Var) {
        super(true);
        w0(s1Var);
    }

    private final boolean e1() {
        u uVar;
        JobSupport Y;
        u uVar2;
        t p02 = p0();
        if (p02 instanceof u) {
            uVar = (u) p02;
        } else {
            uVar = null;
        }
        if (!(uVar == null || (Y = uVar.Y()) == null)) {
            while (!Y.m0()) {
                t p03 = Y.p0();
                if (p03 instanceof u) {
                    uVar2 = (u) p03;
                } else {
                    uVar2 = null;
                }
                if (uVar2 != null) {
                    Y = uVar2.Y();
                    if (Y == null) {
                    }
                }
            }
            return true;
        }
        return false;
    }

    public boolean m0() {
        return this.f32729b;
    }

    public boolean n0() {
        return true;
    }
}
