package le;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.common.internal.t1;
import java.util.NoSuchElementException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import oe.d;

public class b {

    /* renamed from: b  reason: collision with root package name */
    private static final Object f41176b = new Object();

    /* renamed from: c  reason: collision with root package name */
    private static volatile b f41177c;
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    public ConcurrentHashMap f41178a = new ConcurrentHashMap();

    private b() {
    }

    @NonNull
    public static b b() {
        if (f41177c == null) {
            synchronized (f41176b) {
                if (f41177c == null) {
                    f41177c = new b();
                }
            }
        }
        b bVar = f41177c;
        p.k(bVar);
        return bVar;
    }

    private static void e(Context context, ServiceConnection serviceConnection) {
        try {
            context.unbindService(serviceConnection);
        } catch (IllegalArgumentException | IllegalStateException | NoSuchElementException unused) {
        }
    }

    private final boolean f(Context context, String str, Intent intent, ServiceConnection serviceConnection, int i10, boolean z10, Executor executor) {
        ComponentName component = intent.getComponent();
        if (component != null) {
            String packageName = component.getPackageName();
            "com.google.android.gms".equals(packageName);
            try {
                if ((d.a(context).c(packageName, 0).flags & 2097152) != 0) {
                    return false;
                }
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        if (!g(serviceConnection)) {
            return h(context, intent, serviceConnection, i10, executor);
        }
        ServiceConnection serviceConnection2 = (ServiceConnection) this.f41178a.putIfAbsent(serviceConnection, serviceConnection);
        if (!(serviceConnection2 == null || serviceConnection == serviceConnection2)) {
            String.format("Duplicate binding with the same ServiceConnection: %s, %s, %s.", new Object[]{serviceConnection, str, intent.getAction()});
        }
        try {
            boolean h10 = h(context, intent, serviceConnection, i10, executor);
            if (h10) {
                return h10;
            }
            return false;
        } finally {
            this.f41178a.remove(serviceConnection, serviceConnection);
        }
    }

    private static boolean g(ServiceConnection serviceConnection) {
        return !(serviceConnection instanceof t1);
    }

    private static final boolean h(Context context, Intent intent, ServiceConnection serviceConnection, int i10, Executor executor) {
        if (!me.p.j() || executor == null) {
            return context.bindService(intent, serviceConnection, i10);
        }
        return context.bindService(intent, i10, executor, serviceConnection);
    }

    public boolean a(@NonNull Context context, @NonNull Intent intent, @NonNull ServiceConnection serviceConnection, int i10) {
        return f(context, context.getClass().getName(), intent, serviceConnection, i10, true, (Executor) null);
    }

    public void c(@NonNull Context context, @NonNull ServiceConnection serviceConnection) {
        if (!g(serviceConnection) || !this.f41178a.containsKey(serviceConnection)) {
            e(context, serviceConnection);
            return;
        }
        try {
            e(context, (ServiceConnection) this.f41178a.get(serviceConnection));
        } finally {
            this.f41178a.remove(serviceConnection);
        }
    }

    public final boolean d(@NonNull Context context, @NonNull String str, @NonNull Intent intent, @NonNull ServiceConnection serviceConnection, int i10, Executor executor) {
        return f(context, str, intent, serviceConnection, i10, true, executor);
    }
}
