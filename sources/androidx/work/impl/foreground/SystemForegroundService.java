package androidx.work.impl.foreground;

import android.app.ForegroundServiceStartNotAllowedException;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.lifecycle.p;
import androidx.work.impl.foreground.b;
import b2.f;

public class SystemForegroundService extends p implements b.C0085b {
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public static final String f7504f = f.i("SystemFgService");

    /* renamed from: g  reason: collision with root package name */
    private static SystemForegroundService f7505g = null;

    /* renamed from: b  reason: collision with root package name */
    private Handler f7506b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f7507c;

    /* renamed from: d  reason: collision with root package name */
    b f7508d;

    /* renamed from: e  reason: collision with root package name */
    NotificationManager f7509e;

    class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f7510a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Notification f7511b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f7512c;

        a(int i10, Notification notification, int i11) {
            this.f7510a = i10;
            this.f7511b = notification;
            this.f7512c = i11;
        }

        public void run() {
            int i10 = Build.VERSION.SDK_INT;
            if (i10 >= 31) {
                e.a(SystemForegroundService.this, this.f7510a, this.f7511b, this.f7512c);
            } else if (i10 >= 29) {
                d.a(SystemForegroundService.this, this.f7510a, this.f7511b, this.f7512c);
            } else {
                SystemForegroundService.this.startForeground(this.f7510a, this.f7511b);
            }
        }
    }

    class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f7514a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Notification f7515b;

        b(int i10, Notification notification) {
            this.f7514a = i10;
            this.f7515b = notification;
        }

        public void run() {
            SystemForegroundService.this.f7509e.notify(this.f7514a, this.f7515b);
        }
    }

    class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f7517a;

        c(int i10) {
            this.f7517a = i10;
        }

        public void run() {
            SystemForegroundService.this.f7509e.cancel(this.f7517a);
        }
    }

    static class d {
        static void a(Service service, int i10, Notification notification, int i11) {
            service.startForeground(i10, notification, i11);
        }
    }

    static class e {
        static void a(Service service, int i10, Notification notification, int i11) {
            try {
                service.startForeground(i10, notification, i11);
            } catch (ForegroundServiceStartNotAllowedException e10) {
                f.e().l(SystemForegroundService.f7504f, "Unable to start foreground service", e10);
            }
        }
    }

    private void f() {
        this.f7506b = new Handler(Looper.getMainLooper());
        this.f7509e = (NotificationManager) getApplicationContext().getSystemService("notification");
        b bVar = new b(getApplicationContext());
        this.f7508d = bVar;
        bVar.n(this);
    }

    public void a(int i10, @NonNull Notification notification) {
        this.f7506b.post(new b(i10, notification));
    }

    public void c(int i10, int i11, @NonNull Notification notification) {
        this.f7506b.post(new a(i10, notification, i11));
    }

    public void d(int i10) {
        this.f7506b.post(new c(i10));
    }

    public void onCreate() {
        super.onCreate();
        f7505g = this;
        f();
    }

    public void onDestroy() {
        super.onDestroy();
        this.f7508d.l();
    }

    public int onStartCommand(Intent intent, int i10, int i11) {
        super.onStartCommand(intent, i10, i11);
        if (this.f7507c) {
            f.e().f(f7504f, "Re-initializing SystemForegroundService after a request to shut-down.");
            this.f7508d.l();
            f();
            this.f7507c = false;
        }
        if (intent == null) {
            return 3;
        }
        this.f7508d.m(intent);
        return 3;
    }

    public void stop() {
        this.f7507c = true;
        f.e().a(f7504f, "All commands completed.");
        if (Build.VERSION.SDK_INT >= 26) {
            stopForeground(true);
        }
        f7505g = null;
        stopSelf();
    }
}
