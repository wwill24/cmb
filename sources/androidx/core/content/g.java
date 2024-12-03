package androidx.core.content;

import android.content.Context;
import android.os.Process;
import androidx.annotation.NonNull;
import androidx.core.app.e;
import androidx.core.util.c;

public final class g {
    public static int a(@NonNull Context context, @NonNull String str, int i10, int i11, String str2) {
        boolean z10;
        int i12;
        if (context.checkPermission(str, i10, i11) == -1) {
            return -1;
        }
        String c10 = e.c(str);
        if (c10 == null) {
            return 0;
        }
        if (str2 == null) {
            String[] packagesForUid = context.getPackageManager().getPackagesForUid(i11);
            if (packagesForUid == null || packagesForUid.length <= 0) {
                return -1;
            }
            str2 = packagesForUid[0];
        }
        int myUid = Process.myUid();
        String packageName = context.getPackageName();
        if (myUid != i11 || !c.a(packageName, str2)) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (z10) {
            i12 = e.a(context, i11, c10, str2);
        } else {
            i12 = e.b(context, c10, str2);
        }
        if (i12 == 0) {
            return 0;
        }
        return -2;
    }

    public static int b(@NonNull Context context, @NonNull String str) {
        return a(context, str, Process.myPid(), Process.myUid(), context.getPackageName());
    }
}
