package androidx.appcompat.app;

import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.IBinder;
import androidx.annotation.NonNull;

public final class l extends Service {

    private static class a {
        static int a() {
            return 512;
        }
    }

    @NonNull
    public static ServiceInfo a(@NonNull Context context) throws PackageManager.NameNotFoundException {
        return context.getPackageManager().getServiceInfo(new ComponentName(context, l.class), a.a() | 128);
    }

    @NonNull
    public IBinder onBind(@NonNull Intent intent) {
        throw new UnsupportedOperationException();
    }
}
