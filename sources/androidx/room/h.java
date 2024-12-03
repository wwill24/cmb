package androidx.room;

import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.j;
import t1.m;

@Metadata(bv = {}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u001c\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b'\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017J!\u0010\u0007\u001a\u00020\u00062\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0005\u001a\u00028\u0000H$¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00028\u0000¢\u0006\u0004\b\t\u0010\nJ\u0014\u0010\r\u001a\u00020\u00062\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bJ\u0015\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00028\u0000¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00122\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011¨\u0006\u0018"}, d2 = {"Landroidx/room/h;", "T", "Landroidx/room/SharedSQLiteStatement;", "Lt1/m;", "statement", "entity", "", "i", "(Lt1/m;Ljava/lang/Object;)V", "k", "(Ljava/lang/Object;)V", "", "entities", "j", "", "l", "(Ljava/lang/Object;)J", "", "", "m", "Landroidx/room/RoomDatabase;", "database", "<init>", "(Landroidx/room/RoomDatabase;)V", "room-runtime_release"}, k = 1, mv = {1, 7, 1})
public abstract class h<T> extends SharedSQLiteStatement {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public h(RoomDatabase roomDatabase) {
        super(roomDatabase);
        j.g(roomDatabase, "database");
    }

    /* access modifiers changed from: protected */
    public abstract void i(m mVar, T t10);

    public final void j(Iterable<? extends T> iterable) {
        j.g(iterable, "entities");
        m b10 = b();
        try {
            for (Object i10 : iterable) {
                i(b10, i10);
                b10.K0();
            }
        } finally {
            h(b10);
        }
    }

    public final void k(T t10) {
        m b10 = b();
        try {
            i(b10, t10);
            b10.K0();
        } finally {
            h(b10);
        }
    }

    public final long l(T t10) {
        m b10 = b();
        try {
            i(b10, t10);
            return b10.K0();
        } finally {
            h(b10);
        }
    }

    public final List<Long> m(Collection<? extends T> collection) {
        j.g(collection, "entities");
        m b10 = b();
        try {
            List c10 = p.c();
            for (T i10 : collection) {
                i(b10, i10);
                c10.add(Long.valueOf(b10.K0()));
            }
            return p.a(c10);
        } finally {
            h(b10);
        }
    }
}
