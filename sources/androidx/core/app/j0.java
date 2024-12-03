package androidx.core.app;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import androidx.annotation.NonNull;
import java.util.HashSet;
import java.util.Set;

public final class j0 {

    /* renamed from: c  reason: collision with root package name */
    private static final Object f4452c = new Object();

    /* renamed from: d  reason: collision with root package name */
    private static Set<String> f4453d = new HashSet();

    /* renamed from: e  reason: collision with root package name */
    private static final Object f4454e = new Object();

    /* renamed from: a  reason: collision with root package name */
    private final Context f4455a;

    /* renamed from: b  reason: collision with root package name */
    private final NotificationManager f4456b;

    private j0(Context context) {
        this.f4455a = context;
        this.f4456b = (NotificationManager) context.getSystemService("notification");
    }

    @NonNull
    public static j0 b(@NonNull Context context) {
        return new j0(context);
    }

    public boolean a() {
        return this.f4456b.areNotificationsEnabled();
    }

    public NotificationChannel c(@NonNull String str) {
        if (Build.VERSION.SDK_INT >= 26) {
            return this.f4456b.getNotificationChannel(str);
        }
        return null;
    }
}
