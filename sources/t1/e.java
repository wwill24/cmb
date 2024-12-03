package t1;

import android.database.Cursor;
import android.os.Bundle;
import kotlin.Metadata;
import kotlin.jvm.internal.j;

@Metadata(bv = {}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¨\u0006\n"}, d2 = {"Lt1/e;", "", "Landroid/database/Cursor;", "cursor", "Landroid/os/Bundle;", "extras", "", "a", "<init>", "()V", "sqlite_release"}, k = 1, mv = {1, 7, 1})
public final class e {

    /* renamed from: a  reason: collision with root package name */
    public static final e f17632a = new e();

    private e() {
    }

    public static final void a(Cursor cursor, Bundle bundle) {
        j.g(cursor, "cursor");
        j.g(bundle, "extras");
        cursor.setExtras(bundle);
    }
}
