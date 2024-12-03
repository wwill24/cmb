package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;

@Metadata(bv = {}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00060\u0001j\u0002`\u00022\b\u0012\u0004\u0012\u00020\u00000\u0003B\u001b\b\u0000\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\n\u0010\u000bB\u0011\b\u0010\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\fR\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0000X\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006¨\u0006\r"}, d2 = {"Lkotlinx/coroutines/TimeoutCancellationException;", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "", "Lkotlinx/coroutines/s1;", "a", "Lkotlinx/coroutines/s1;", "coroutine", "", "message", "<init>", "(Ljava/lang/String;Lkotlinx/coroutines/s1;)V", "(Ljava/lang/String;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public final class TimeoutCancellationException extends CancellationException {

    /* renamed from: a  reason: collision with root package name */
    public final transient s1 f32266a;

    public TimeoutCancellationException(String str, s1 s1Var) {
        super(str);
        this.f32266a = s1Var;
    }

    public TimeoutCancellationException(String str) {
        this(str, (s1) null);
    }
}
