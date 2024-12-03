package androidx.work.impl;

import androidx.room.RoomDatabase;
import com.facebook.appevents.UserDataStore;
import kotlin.Metadata;
import kotlin.jvm.internal.j;
import t1.i;

@Metadata(bv = {}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\t\u001a\u00020\u00068BX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\r\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Landroidx/work/impl/c;", "Landroidx/room/RoomDatabase$b;", "Lt1/i;", "db", "", "c", "", "e", "()Ljava/lang/String;", "pruneSQL", "", "d", "()J", "pruneDate", "<init>", "()V", "work-runtime_release"}, k = 1, mv = {1, 7, 1})
public final class c extends RoomDatabase.b {

    /* renamed from: a  reason: collision with root package name */
    public static final c f7484a = new c();

    private c() {
    }

    private final String e() {
        return "DELETE FROM workspec WHERE state IN (2, 3, 5) AND (last_enqueue_time + minimum_retention_duration) < " + d() + " AND (SELECT COUNT(*)=0 FROM dependency WHERE     prerequisite_id=id AND     work_spec_id NOT IN         (SELECT id FROM workspec WHERE state IN (2, 3, 5)))";
    }

    public void c(i iVar) {
        j.g(iVar, UserDataStore.DATE_OF_BIRTH);
        super.c(iVar);
        iVar.beginTransaction();
        try {
            iVar.D(e());
            iVar.setTransactionSuccessful();
        } finally {
            iVar.endTransaction();
        }
    }

    public final long d() {
        return System.currentTimeMillis() - z.f7656a;
    }
}
