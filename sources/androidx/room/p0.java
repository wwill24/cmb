package androidx.room;

import java.util.ArrayDeque;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.j;
import org.jivesoftware.smackx.commands.packet.AdHocCommandData;

@Metadata(bv = {}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\t\u001a\u00020\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0006\u0010\u0006\u001a\u00020\u0004R\u0014\u0010\t\u001a\u00020\u00018\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\n8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u000eR\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Landroidx/room/p0;", "Ljava/util/concurrent/Executor;", "Ljava/lang/Runnable;", "command", "", "execute", "c", "a", "Ljava/util/concurrent/Executor;", "executor", "Ljava/util/ArrayDeque;", "b", "Ljava/util/ArrayDeque;", "tasks", "Ljava/lang/Runnable;", "active", "", "d", "Ljava/lang/Object;", "syncLock", "<init>", "(Ljava/util/concurrent/Executor;)V", "room-runtime_release"}, k = 1, mv = {1, 7, 1})
public final class p0 implements Executor {

    /* renamed from: a  reason: collision with root package name */
    private final Executor f6949a;

    /* renamed from: b  reason: collision with root package name */
    private final ArrayDeque<Runnable> f6950b = new ArrayDeque<>();

    /* renamed from: c  reason: collision with root package name */
    private Runnable f6951c;

    /* renamed from: d  reason: collision with root package name */
    private final Object f6952d = new Object();

    public p0(Executor executor) {
        j.g(executor, "executor");
        this.f6949a = executor;
    }

    /* access modifiers changed from: private */
    public static final void b(Runnable runnable, p0 p0Var) {
        j.g(runnable, "$command");
        j.g(p0Var, "this$0");
        try {
            runnable.run();
        } finally {
            p0Var.c();
        }
    }

    public final void c() {
        synchronized (this.f6952d) {
            Runnable poll = this.f6950b.poll();
            Runnable runnable = poll;
            this.f6951c = runnable;
            if (poll != null) {
                this.f6949a.execute(runnable);
            }
            Unit unit = Unit.f32013a;
        }
    }

    public void execute(Runnable runnable) {
        j.g(runnable, AdHocCommandData.ELEMENT);
        synchronized (this.f6952d) {
            this.f6950b.offer(new o0(runnable, this));
            if (this.f6951c == null) {
                c();
            }
            Unit unit = Unit.f32013a;
        }
    }
}
