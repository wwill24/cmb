package kotlinx.coroutines.scheduling;

import kotlin.Metadata;

@Metadata(bv = {}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b \u0018\u00002\u00060\u0001j\u0002`\u0002B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\fB\t\b\u0016¢\u0006\u0004\b\u000b\u0010\rR\u0016\u0010\u0006\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u0016\u0010\n\u001a\u00020\u00078\u0006@\u0006X\u000e¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\u000e"}, d2 = {"Lkotlinx/coroutines/scheduling/g;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "", "a", "J", "submissionTime", "Lkotlinx/coroutines/scheduling/h;", "b", "Lkotlinx/coroutines/scheduling/h;", "taskContext", "<init>", "(JLkotlinx/coroutines/scheduling/h;)V", "()V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public abstract class g implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public long f32656a;

    /* renamed from: b  reason: collision with root package name */
    public h f32657b;

    public g(long j10, h hVar) {
        this.f32656a = j10;
        this.f32657b = hVar;
    }

    public g() {
        this(0, k.f32665f);
    }
}
