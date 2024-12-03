package androidx.room;

import kotlin.Metadata;
import kotlin.jvm.internal.j;

@Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¨\u0006\u0007"}, d2 = {"Landroidx/room/i0;", "", "", "hash", "a", "<init>", "()V", "room-common"}, k = 1, mv = {1, 7, 1})
public final class i0 {

    /* renamed from: a  reason: collision with root package name */
    public static final i0 f6857a = new i0();

    private i0() {
    }

    public static final String a(String str) {
        j.g(str, "hash");
        return "INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '" + str + "')";
    }
}
