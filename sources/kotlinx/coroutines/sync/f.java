package kotlinx.coroutines.sync;

import kotlin.Metadata;
import kotlinx.coroutines.internal.f0;

@Metadata(bv = {}, d1 = {"\u0000$\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0011\u001a\u0018\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0000\u001a\u001a\u0010\t\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002\"\u001a\u0010\r\u001a\u00020\u00008\u0002X\u0004¢\u0006\f\n\u0004\b\u0004\u0010\n\u0012\u0004\b\u000b\u0010\f\"\u001a\u0010\u0012\u001a\u00020\u000e8\u0002X\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u0012\u0004\b\u0011\u0010\f\"\u001a\u0010\u0015\u001a\u00020\u000e8\u0002X\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0010\u0012\u0004\b\u0014\u0010\f\"\u001a\u0010\u0018\u001a\u00020\u000e8\u0002X\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0010\u0012\u0004\b\u0017\u0010\f\"\u001a\u0010\u001b\u001a\u00020\u000e8\u0002X\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u0010\u0012\u0004\b\u001a\u0010\f\"\u001a\u0010\u001e\u001a\u00020\u00008\u0002X\u0004¢\u0006\f\n\u0004\b\u001c\u0010\n\u0012\u0004\b\u001d\u0010\f¨\u0006\u001f"}, d2 = {"", "permits", "acquiredPermits", "Lkotlinx/coroutines/sync/e;", "a", "", "id", "Lkotlinx/coroutines/sync/g;", "prev", "j", "I", "getMAX_SPIN_CYCLES$annotations", "()V", "MAX_SPIN_CYCLES", "Lkotlinx/coroutines/internal/f0;", "b", "Lkotlinx/coroutines/internal/f0;", "getPERMIT$annotations", "PERMIT", "c", "getTAKEN$annotations", "TAKEN", "d", "getBROKEN$annotations", "BROKEN", "e", "getCANCELLED$annotations", "CANCELLED", "f", "getSEGMENT_SIZE$annotations", "SEGMENT_SIZE", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0})
public final class f {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final int f32713a = i0.d("kotlinx.coroutines.semaphore.maxSpinCycles", 100, 0, 0, 12, (Object) null);
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static final f0 f32714b = new f0("PERMIT");
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public static final f0 f32715c = new f0("TAKEN");
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public static final f0 f32716d = new f0("BROKEN");
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public static final f0 f32717e = new f0("CANCELLED");
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public static final int f32718f = i0.d("kotlinx.coroutines.semaphore.segmentSize", 16, 0, 0, 12, (Object) null);

    public static final e a(int i10, int i11) {
        return new SemaphoreImpl(i10, i11);
    }

    public static /* synthetic */ e b(int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i11 = 0;
        }
        return a(i10, i11);
    }

    /* access modifiers changed from: private */
    public static final g j(long j10, g gVar) {
        return new g(j10, gVar, 0);
    }
}
