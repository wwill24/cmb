package t1;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.j;

@Metadata(bv = {}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ(\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u000e\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006H\u0007J\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¨\u0006\u000e"}, d2 = {"Lt1/h;", "", "Landroid/database/Cursor;", "cursor", "Landroid/content/ContentResolver;", "cr", "", "Landroid/net/Uri;", "uris", "", "b", "a", "<init>", "()V", "sqlite_release"}, k = 1, mv = {1, 7, 1})
public final class h {

    /* renamed from: a  reason: collision with root package name */
    public static final h f17633a = new h();

    private h() {
    }

    public static final List<Uri> a(Cursor cursor) {
        j.g(cursor, "cursor");
        List<Uri> a10 = cursor.getNotificationUris();
        j.d(a10);
        return a10;
    }

    public static final void b(Cursor cursor, ContentResolver contentResolver, List<? extends Uri> list) {
        j.g(cursor, "cursor");
        j.g(contentResolver, "cr");
        j.g(list, "uris");
        cursor.setNotificationUris(contentResolver, list);
    }
}
