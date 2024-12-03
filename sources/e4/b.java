package e4;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import androidx.annotation.NonNull;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    private static final ConcurrentMap<String, i3.b> f14575a = new ConcurrentHashMap();

    private static PackageInfo a(@NonNull Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException unused) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Cannot resolve info for");
            sb2.append(context.getPackageName());
            return null;
        }
    }

    @NonNull
    private static String b(PackageInfo packageInfo) {
        if (packageInfo != null) {
            return String.valueOf(packageInfo.versionCode);
        }
        return UUID.randomUUID().toString();
    }

    @NonNull
    public static i3.b c(@NonNull Context context) {
        String packageName = context.getPackageName();
        ConcurrentMap<String, i3.b> concurrentMap = f14575a;
        i3.b bVar = concurrentMap.get(packageName);
        if (bVar != null) {
            return bVar;
        }
        i3.b d10 = d(context);
        i3.b putIfAbsent = concurrentMap.putIfAbsent(packageName, d10);
        if (putIfAbsent == null) {
            return d10;
        }
        return putIfAbsent;
    }

    @NonNull
    private static i3.b d(@NonNull Context context) {
        return new d(b(a(context)));
    }
}
