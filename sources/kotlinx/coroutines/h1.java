package kotlinx.coroutines;

import kotlin.Metadata;
import kotlinx.coroutines.internal.f0;

@Metadata(bv = {}, d1 = {"\u0000\u0018\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0010\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0000\"\u001a\u0010\b\u001a\u00020\u00038\u0002X\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u0012\u0004\b\u0006\u0010\u0007\"\u001a\u0010\u000b\u001a\u00020\u00038\u0002X\u0004¢\u0006\f\n\u0004\b\t\u0010\u0005\u0012\u0004\b\n\u0010\u0007*\u001e\b\u0002\u0010\u000e\u001a\u0004\b\u0000\u0010\f\"\b\u0012\u0004\u0012\u00028\u00000\r2\b\u0012\u0004\u0012\u00028\u00000\r¨\u0006\u000f"}, d2 = {"", "timeMillis", "c", "Lkotlinx/coroutines/internal/f0;", "a", "Lkotlinx/coroutines/internal/f0;", "getDISPOSED_TASK$annotations", "()V", "DISPOSED_TASK", "b", "getCLOSED_EMPTY$annotations", "CLOSED_EMPTY", "T", "Lkotlinx/coroutines/internal/t;", "Queue", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0})
public final class h1 {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final f0 f32492a = new f0("REMOVED_TASK");
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static final f0 f32493b = new f0("CLOSED_EMPTY");

    public static final long c(long j10) {
        if (j10 <= 0) {
            return 0;
        }
        if (j10 >= 9223372036854L) {
            return Long.MAX_VALUE;
        }
        return 1000000 * j10;
    }
}
