package androidx.work.impl;

import com.facebook.appevents.UserDataStore;
import kotlin.Metadata;
import p1.b;
import t1.i;

@Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\b"}, d2 = {"Landroidx/work/impl/j;", "Lp1/b;", "Lt1/i;", "db", "", "a", "<init>", "()V", "work-runtime_release"}, k = 1, mv = {1, 7, 1})
public final class j extends b {

    /* renamed from: c  reason: collision with root package name */
    public static final j f7570c = new j();

    private j() {
        super(3, 4);
    }

    public void a(i iVar) {
        kotlin.jvm.internal.j.g(iVar, UserDataStore.DATE_OF_BIRTH);
        iVar.D("\n    UPDATE workspec SET schedule_requested_at = 0\n    WHERE state NOT IN (2, 3, 5)\n        AND schedule_requested_at = -1\n        AND interval_duration <> 0\n    ");
    }
}
