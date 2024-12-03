package androidx.room;

import androidx.room.RoomDatabase;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import net.bytebuddy.implementation.MethodDelegation;
import t1.i;
import t1.j;

@Metadata(bv = {}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u001f\u0012\u0006\u0010\u000b\u001a\u00020\u0001\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\u0006\u0010\u0013\u001a\u00020\u0010¢\u0006\u0004\b\u001c\u0010\u001dJ\t\u0010\u0004\u001a\u00020\u0003H\u0001J\u0011\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0001R\u001a\u0010\u000b\u001a\u00020\u00018\u0016X\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\b\u0010\nR\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u0004\u0018\u00010\u00148\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u001b\u001a\u00020\u00188VX\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001e"}, d2 = {"Landroidx/room/b0;", "Lt1/j;", "Landroidx/room/f;", "", "close", "", "enabled", "setWriteAheadLoggingEnabled", "a", "Lt1/j;", "()Lt1/j;", "delegate", "Ljava/util/concurrent/Executor;", "b", "Ljava/util/concurrent/Executor;", "queryCallbackExecutor", "Landroidx/room/RoomDatabase$f;", "c", "Landroidx/room/RoomDatabase$f;", "queryCallback", "", "getDatabaseName", "()Ljava/lang/String;", "databaseName", "Lt1/i;", "n1", "()Lt1/i;", "writableDatabase", "<init>", "(Lt1/j;Ljava/util/concurrent/Executor;Landroidx/room/RoomDatabase$f;)V", "room-runtime_release"}, k = 1, mv = {1, 7, 1})
public final class b0 implements j, f {

    /* renamed from: a  reason: collision with root package name */
    private final j f6807a;

    /* renamed from: b  reason: collision with root package name */
    private final Executor f6808b;

    /* renamed from: c  reason: collision with root package name */
    private final RoomDatabase.f f6809c;

    public b0(j jVar, Executor executor, RoomDatabase.f fVar) {
        kotlin.jvm.internal.j.g(jVar, MethodDelegation.ImplementationDelegate.FIELD_NAME_PREFIX);
        kotlin.jvm.internal.j.g(executor, "queryCallbackExecutor");
        kotlin.jvm.internal.j.g(fVar, "queryCallback");
        this.f6807a = jVar;
        this.f6808b = executor;
        this.f6809c = fVar;
    }

    public j a() {
        return this.f6807a;
    }

    public void close() {
        this.f6807a.close();
    }

    public String getDatabaseName() {
        return this.f6807a.getDatabaseName();
    }

    public i n1() {
        return new a0(a().n1(), this.f6808b, this.f6809c);
    }

    public void setWriteAheadLoggingEnabled(boolean z10) {
        this.f6807a.setWriteAheadLoggingEnabled(z10);
    }
}
