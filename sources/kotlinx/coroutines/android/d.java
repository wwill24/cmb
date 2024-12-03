package kotlinx.coroutines.android;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.c2;
import kotlinx.coroutines.r0;
import kotlinx.coroutines.z0;

@Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u00012\u00020\u0002B\t\b\u0004¢\u0006\u0004\b\u0003\u0010\u0004\u0001\u0001\u0005¨\u0006\u0006"}, d2 = {"Lkotlinx/coroutines/android/d;", "Lkotlinx/coroutines/c2;", "Lkotlinx/coroutines/r0;", "<init>", "()V", "Lkotlinx/coroutines/android/HandlerContext;", "kotlinx-coroutines-android"}, k = 1, mv = {1, 6, 0})
public abstract class d extends c2 implements r0 {
    private d() {
    }

    public /* synthetic */ d(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public z0 u(long j10, Runnable runnable, CoroutineContext coroutineContext) {
        return r0.a.a(this, j10, runnable, coroutineContext);
    }
}
