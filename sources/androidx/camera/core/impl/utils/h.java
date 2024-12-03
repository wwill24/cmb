package androidx.camera.core.impl.utils;

import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import androidx.annotation.NonNull;

public final class h {

    private static class a {
        @NonNull
        static Context a(@NonNull Context context, String str) {
            return context.createAttributionContext(str);
        }

        static String b(@NonNull Context context) {
            return context.getAttributionTag();
        }
    }

    @NonNull
    public static Context a(@NonNull Context context) {
        String b10;
        Context applicationContext = context.getApplicationContext();
        if (Build.VERSION.SDK_INT < 30 || (b10 = a.b(context)) == null) {
            return applicationContext;
        }
        return a.a(applicationContext, b10);
    }

    public static Application b(@NonNull Context context) {
        for (Context a10 = a(context); a10 instanceof ContextWrapper; a10 = c((ContextWrapper) a10)) {
            if (a10 instanceof Application) {
                return (Application) a10;
            }
        }
        return null;
    }

    @NonNull
    public static Context c(@NonNull ContextWrapper contextWrapper) {
        String b10;
        Context baseContext = contextWrapper.getBaseContext();
        if (Build.VERSION.SDK_INT < 30 || (b10 = a.b(contextWrapper)) == null) {
            return baseContext;
        }
        return a.a(baseContext, b10);
    }
}
