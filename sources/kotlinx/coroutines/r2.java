package kotlinx.coroutines;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public final /* synthetic */ class r2 implements ThreadFactory {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f32602a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f32603b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ AtomicInteger f32604c;

    public /* synthetic */ r2(int i10, String str, AtomicInteger atomicInteger) {
        this.f32602a = i10;
        this.f32603b = str;
        this.f32604c = atomicInteger;
    }

    public final Thread newThread(Runnable runnable) {
        return s2.c(this.f32602a, this.f32603b, this.f32604c, runnable);
    }
}
