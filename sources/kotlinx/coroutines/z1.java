package kotlinx.coroutines;

import kotlin.Metadata;
import kotlinx.coroutines.internal.f0;

@Metadata(bv = {}, d1 = {"\u0000\u0018\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u0010\u0010\u0001\u001a\u0004\u0018\u00010\u0000*\u0004\u0018\u00010\u0000H\u0000\u001a\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0000*\u0004\u0018\u00010\u0000H\u0000\"\u001a\u0010\b\u001a\u00020\u00038\u0002X\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u0012\u0004\b\u0006\u0010\u0007\"\u001a\u0010\u000b\u001a\u00020\u00038\u0000X\u0004¢\u0006\f\n\u0004\b\t\u0010\u0005\u0012\u0004\b\n\u0010\u0007\"\u001a\u0010\u000e\u001a\u00020\u00038\u0002X\u0004¢\u0006\f\n\u0004\b\f\u0010\u0005\u0012\u0004\b\r\u0010\u0007\"\u001a\u0010\u0011\u001a\u00020\u00038\u0002X\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0005\u0012\u0004\b\u0010\u0010\u0007\"\u001a\u0010\u0014\u001a\u00020\u00038\u0002X\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0005\u0012\u0004\b\u0013\u0010\u0007\"\u001a\u0010\u0019\u001a\u00020\u00158\u0002X\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u0012\u0004\b\u0018\u0010\u0007\"\u001a\u0010\u001b\u001a\u00020\u00158\u0002X\u0004¢\u0006\f\n\u0004\b\u0001\u0010\u0017\u0012\u0004\b\u001a\u0010\u0007¨\u0006\u001c"}, d2 = {"", "g", "h", "Lkotlinx/coroutines/internal/f0;", "a", "Lkotlinx/coroutines/internal/f0;", "getCOMPLETING_ALREADY$annotations", "()V", "COMPLETING_ALREADY", "b", "getCOMPLETING_WAITING_CHILDREN$annotations", "COMPLETING_WAITING_CHILDREN", "c", "getCOMPLETING_RETRY$annotations", "COMPLETING_RETRY", "d", "getTOO_LATE_TO_CANCEL$annotations", "TOO_LATE_TO_CANCEL", "e", "getSEALED$annotations", "SEALED", "Lkotlinx/coroutines/c1;", "f", "Lkotlinx/coroutines/c1;", "getEMPTY_NEW$annotations", "EMPTY_NEW", "getEMPTY_ACTIVE$annotations", "EMPTY_ACTIVE", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0})
public final class z1 {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final f0 f32741a = new f0("COMPLETING_ALREADY");

    /* renamed from: b  reason: collision with root package name */
    public static final f0 f32742b = new f0("COMPLETING_WAITING_CHILDREN");
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public static final f0 f32743c = new f0("COMPLETING_RETRY");
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public static final f0 f32744d = new f0("TOO_LATE_TO_CANCEL");
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public static final f0 f32745e = new f0("SEALED");
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public static final c1 f32746f = new c1(false);
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public static final c1 f32747g = new c1(true);

    public static final Object g(Object obj) {
        return obj instanceof n1 ? new o1((n1) obj) : obj;
    }

    public static final Object h(Object obj) {
        n1 n1Var;
        o1 o1Var = obj instanceof o1 ? (o1) obj : null;
        return (o1Var == null || (n1Var = o1Var.f32593a) == null) ? obj : n1Var;
    }
}
