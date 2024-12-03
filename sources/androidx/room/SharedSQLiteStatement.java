package androidx.room;

import gk.f;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.j;
import t1.m;

@Metadata(bv = {}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b'\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u000e¢\u0006\u0004\b\u0019\u0010\u001aJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0007H$J\b\u0010\n\u001a\u00020\tH\u0014J\b\u0010\u000b\u001a\u00020\u0002H\u0016J\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u0002H\u0016R\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0014\u001a\u00020\u00128\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u0013R\u001b\u0010\u0018\u001a\u00020\u00028BX\u0002¢\u0006\f\n\u0004\b\n\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001b"}, d2 = {"Landroidx/room/SharedSQLiteStatement;", "", "Lt1/m;", "d", "", "canUseCached", "g", "", "e", "", "c", "b", "statement", "h", "Landroidx/room/RoomDatabase;", "a", "Landroidx/room/RoomDatabase;", "database", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "lock", "Lgk/f;", "f", "()Lt1/m;", "stmt", "<init>", "(Landroidx/room/RoomDatabase;)V", "room-runtime_release"}, k = 1, mv = {1, 7, 1})
public abstract class SharedSQLiteStatement {

    /* renamed from: a  reason: collision with root package name */
    private final RoomDatabase f6799a;

    /* renamed from: b  reason: collision with root package name */
    private final AtomicBoolean f6800b = new AtomicBoolean(false);

    /* renamed from: c  reason: collision with root package name */
    private final f f6801c = b.b(new SharedSQLiteStatement$stmt$2(this));

    public SharedSQLiteStatement(RoomDatabase roomDatabase) {
        j.g(roomDatabase, "database");
        this.f6799a = roomDatabase;
    }

    /* access modifiers changed from: private */
    public final m d() {
        return this.f6799a.g(e());
    }

    private final m f() {
        return (m) this.f6801c.getValue();
    }

    private final m g(boolean z10) {
        if (z10) {
            return f();
        }
        return d();
    }

    public m b() {
        c();
        return g(this.f6800b.compareAndSet(false, true));
    }

    /* access modifiers changed from: protected */
    public void c() {
        this.f6799a.c();
    }

    /* access modifiers changed from: protected */
    public abstract String e();

    public void h(m mVar) {
        j.g(mVar, "statement");
        if (mVar == f()) {
            this.f6800b.set(false);
        }
    }
}
