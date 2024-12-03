package kotlinx.coroutines.scheduling;

import kotlin.Metadata;
import kotlinx.coroutines.m0;
import org.apache.commons.beanutils.PropertyUtils;

@Metadata(bv = {}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B#\u0012\n\u0010\n\u001a\u00060\u0006j\u0002`\u0007\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016R\u0018\u0010\n\u001a\u00060\u0006j\u0002`\u00078\u0006X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\u0011"}, d2 = {"Lkotlinx/coroutines/scheduling/j;", "Lkotlinx/coroutines/scheduling/g;", "", "run", "", "toString", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "c", "Ljava/lang/Runnable;", "block", "", "submissionTime", "Lkotlinx/coroutines/scheduling/h;", "taskContext", "<init>", "(Ljava/lang/Runnable;JLkotlinx/coroutines/scheduling/h;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public final class j extends g {

    /* renamed from: c  reason: collision with root package name */
    public final Runnable f32659c;

    public j(Runnable runnable, long j10, h hVar) {
        super(j10, hVar);
        this.f32659c = runnable;
    }

    public void run() {
        try {
            this.f32659c.run();
        } finally {
            this.f32657b.a();
        }
    }

    public String toString() {
        return "Task[" + m0.a(this.f32659c) + '@' + m0.b(this.f32659c) + ", " + this.f32656a + ", " + this.f32657b + PropertyUtils.INDEXED_DELIM2;
    }
}
