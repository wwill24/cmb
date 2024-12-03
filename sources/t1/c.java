package t1;

import android.app.ActivityManager;
import android.database.Cursor;
import android.net.Uri;
import kotlin.Metadata;
import kotlin.jvm.internal.j;

@Metadata(bv = {}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¨\u0006\f"}, d2 = {"Lt1/c;", "", "Landroid/database/Cursor;", "cursor", "Landroid/net/Uri;", "a", "Landroid/app/ActivityManager;", "activityManager", "", "b", "<init>", "()V", "sqlite_release"}, k = 1, mv = {1, 7, 1})
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static final c f17630a = new c();

    private c() {
    }

    public static final Uri a(Cursor cursor) {
        j.g(cursor, "cursor");
        Uri notificationUri = cursor.getNotificationUri();
        j.f(notificationUri, "cursor.notificationUri");
        return notificationUri;
    }

    public static final boolean b(ActivityManager activityManager) {
        j.g(activityManager, "activityManager");
        return activityManager.isLowRamDevice();
    }
}
