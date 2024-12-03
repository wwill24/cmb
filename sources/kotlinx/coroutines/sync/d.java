package kotlinx.coroutines.sync;

import kotlin.Metadata;
import kotlinx.coroutines.internal.f0;

@Metadata(bv = {}, d1 = {"\u0000\u001c\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\b\u001a\u0010\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0001\u001a\u00020\u0000\"\u001a\u0010\b\u001a\u00020\u00048\u0002X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0005\u0012\u0004\b\u0006\u0010\u0007\"\u001a\u0010\u000b\u001a\u00020\u00048\u0002X\u0004¢\u0006\f\n\u0004\b\t\u0010\u0005\u0012\u0004\b\n\u0010\u0007\"\u001a\u0010\u000e\u001a\u00020\u00048\u0002X\u0004¢\u0006\f\n\u0004\b\f\u0010\u0005\u0012\u0004\b\r\u0010\u0007\"\u001a\u0010\u0011\u001a\u00020\u00048\u0002X\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0005\u0012\u0004\b\u0010\u0010\u0007\"\u001a\u0010\u0016\u001a\u00020\u00128\u0002X\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u0012\u0004\b\u0015\u0010\u0007\"\u001a\u0010\u0019\u001a\u00020\u00128\u0002X\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0014\u0012\u0004\b\u0018\u0010\u0007¨\u0006\u001a"}, d2 = {"", "locked", "Lkotlinx/coroutines/sync/c;", "a", "Lkotlinx/coroutines/internal/f0;", "Lkotlinx/coroutines/internal/f0;", "getLOCK_FAIL$annotations", "()V", "LOCK_FAIL", "b", "getUNLOCK_FAIL$annotations", "UNLOCK_FAIL", "c", "getLOCKED$annotations", "LOCKED", "d", "getUNLOCKED$annotations", "UNLOCKED", "Lkotlinx/coroutines/sync/b;", "e", "Lkotlinx/coroutines/sync/b;", "getEMPTY_LOCKED$annotations", "EMPTY_LOCKED", "f", "getEMPTY_UNLOCKED$annotations", "EMPTY_UNLOCKED", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0})
public final class d {

    /* renamed from: a  reason: collision with root package name */
    private static final f0 f32707a = new f0("LOCK_FAIL");
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static final f0 f32708b = new f0("UNLOCK_FAIL");
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public static final f0 f32709c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public static final f0 f32710d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public static final b f32711e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public static final b f32712f;

    static {
        f0 f0Var = new f0("LOCKED");
        f32709c = f0Var;
        f0 f0Var2 = new f0("UNLOCKED");
        f32710d = f0Var2;
        f32711e = new b(f0Var);
        f32712f = new b(f0Var2);
    }

    public static final c a(boolean z10) {
        return new MutexImpl(z10);
    }

    public static /* synthetic */ c b(boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        return a(z10);
    }
}
