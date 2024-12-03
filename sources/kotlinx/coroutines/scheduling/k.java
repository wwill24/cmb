package kotlinx.coroutines.scheduling;

import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlinx.coroutines.internal.g0;

@Metadata(bv = {}, d1 = {"\u0000 \n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\"\u0014\u0010\u0003\u001a\u00020\u00008\u0000X\u0004¢\u0006\u0006\n\u0004\b\u0001\u0010\u0002\"\u0014\u0010\u0007\u001a\u00020\u00048\u0000X\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006\"\u0014\u0010\t\u001a\u00020\u00048\u0000X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0006\"\u0014\u0010\u000b\u001a\u00020\u00008\u0000X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u0002\"\u0016\u0010\u000f\u001a\u00020\f8\u0000@\u0000X\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000e\"\u0014\u0010\u0013\u001a\u00020\u00108\u0000X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012\"\u0014\u0010\u0015\u001a\u00020\u00108\u0000X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0012¨\u0006\u0016"}, d2 = {"", "a", "J", "WORK_STEALING_TIME_RESOLUTION_NS", "", "b", "I", "CORE_POOL_SIZE", "c", "MAX_POOL_SIZE", "d", "IDLE_WORKER_KEEP_ALIVE_NS", "Lkotlinx/coroutines/scheduling/f;", "e", "Lkotlinx/coroutines/scheduling/f;", "schedulerTimeSource", "Lkotlinx/coroutines/scheduling/h;", "f", "Lkotlinx/coroutines/scheduling/h;", "NonBlockingContext", "g", "BlockingContext", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0})
public final class k {

    /* renamed from: a  reason: collision with root package name */
    public static final long f32660a = i0.e("kotlinx.coroutines.scheduler.resolution.ns", 100000, 0, 0, 12, (Object) null);

    /* renamed from: b  reason: collision with root package name */
    public static final int f32661b = i0.d("kotlinx.coroutines.scheduler.core.pool.size", j.c(g0.a(), 2), 1, 0, 8, (Object) null);

    /* renamed from: c  reason: collision with root package name */
    public static final int f32662c = i0.d("kotlinx.coroutines.scheduler.max.pool.size", 2097150, 0, 2097150, 4, (Object) null);

    /* renamed from: d  reason: collision with root package name */
    public static final long f32663d = TimeUnit.SECONDS.toNanos(i0.e("kotlinx.coroutines.scheduler.keep.alive.sec", 60, 0, 0, 12, (Object) null));

    /* renamed from: e  reason: collision with root package name */
    public static f f32664e = d.f32650a;

    /* renamed from: f  reason: collision with root package name */
    public static final h f32665f = new i(0);

    /* renamed from: g  reason: collision with root package name */
    public static final h f32666g = new i(1);
}
