package androidx.room;

import kotlin.Metadata;
import kotlin.jvm.internal.j;
import t1.m;

@Metadata(bv = {}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u001c\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b'\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00028\u0000H$¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00028\u0000¢\u0006\u0004\b\n\u0010\u000bJ\u0014\u0010\u000e\u001a\u00020\t2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\f¨\u0006\u0013"}, d2 = {"Landroidx/room/g;", "T", "Landroidx/room/SharedSQLiteStatement;", "Lt1/m;", "statement", "entity", "", "i", "(Lt1/m;Ljava/lang/Object;)V", "", "j", "(Ljava/lang/Object;)I", "", "entities", "k", "Landroidx/room/RoomDatabase;", "database", "<init>", "(Landroidx/room/RoomDatabase;)V", "room-runtime_release"}, k = 1, mv = {1, 7, 1})
public abstract class g<T> extends SharedSQLiteStatement {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public g(RoomDatabase roomDatabase) {
        super(roomDatabase);
        j.g(roomDatabase, "database");
    }

    /* access modifiers changed from: protected */
    public abstract void i(m mVar, T t10);

    public final int j(T t10) {
        m b10 = b();
        try {
            i(b10, t10);
            return b10.H();
        } finally {
            h(b10);
        }
    }

    public final int k(Iterable<? extends T> iterable) {
        j.g(iterable, "entities");
        m b10 = b();
        int i10 = 0;
        try {
            for (Object i11 : iterable) {
                i(b10, i11);
                i10 += b10.H();
            }
            return i10;
        } finally {
            h(b10);
        }
    }
}
