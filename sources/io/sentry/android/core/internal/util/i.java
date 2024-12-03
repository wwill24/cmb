package io.sentry.android.core.internal.util;

import android.content.Context;
import android.os.Process;
import io.sentry.util.l;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
public final class i {
    public static boolean a(Context context, String str) {
        l.c(context, "The application context is required.");
        if (context.checkPermission(str, Process.myPid(), Process.myUid()) == 0) {
            return true;
        }
        return false;
    }
}
