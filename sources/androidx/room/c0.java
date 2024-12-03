package androidx.room;

import androidx.room.RoomDatabase;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import net.bytebuddy.implementation.MethodDelegation;
import t1.j;

@Metadata(bv = {}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0007\u001a\u00020\u0001\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010\u000f\u001a\u00020\f¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\u0007\u001a\u00020\u00018\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Landroidx/room/c0;", "Lt1/j$c;", "Lt1/j$b;", "configuration", "Lt1/j;", "a", "Lt1/j$c;", "delegate", "Ljava/util/concurrent/Executor;", "b", "Ljava/util/concurrent/Executor;", "queryCallbackExecutor", "Landroidx/room/RoomDatabase$f;", "c", "Landroidx/room/RoomDatabase$f;", "queryCallback", "<init>", "(Lt1/j$c;Ljava/util/concurrent/Executor;Landroidx/room/RoomDatabase$f;)V", "room-runtime_release"}, k = 1, mv = {1, 7, 1})
public final class c0 implements j.c {

    /* renamed from: a  reason: collision with root package name */
    private final j.c f6823a;

    /* renamed from: b  reason: collision with root package name */
    private final Executor f6824b;

    /* renamed from: c  reason: collision with root package name */
    private final RoomDatabase.f f6825c;

    public c0(j.c cVar, Executor executor, RoomDatabase.f fVar) {
        kotlin.jvm.internal.j.g(cVar, MethodDelegation.ImplementationDelegate.FIELD_NAME_PREFIX);
        kotlin.jvm.internal.j.g(executor, "queryCallbackExecutor");
        kotlin.jvm.internal.j.g(fVar, "queryCallback");
        this.f6823a = cVar;
        this.f6824b = executor;
        this.f6825c = fVar;
    }

    public j a(j.b bVar) {
        kotlin.jvm.internal.j.g(bVar, "configuration");
        return new b0(this.f6823a.a(bVar), this.f6824b, this.f6825c);
    }
}
