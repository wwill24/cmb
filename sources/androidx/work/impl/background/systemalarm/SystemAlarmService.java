package androidx.work.impl.background.systemalarm;

import android.content.Intent;
import androidx.lifecycle.p;
import androidx.work.impl.background.systemalarm.g;
import b2.f;
import h2.u;

public class SystemAlarmService extends p implements g.c {

    /* renamed from: d  reason: collision with root package name */
    private static final String f7427d = f.i("SystemAlarmService");

    /* renamed from: b  reason: collision with root package name */
    private g f7428b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f7429c;

    private void e() {
        g gVar = new g(this);
        this.f7428b = gVar;
        gVar.l(this);
    }

    public void b() {
        this.f7429c = true;
        f.e().a(f7427d, "All commands completed in dispatcher");
        u.a();
        stopSelf();
    }

    public void onCreate() {
        super.onCreate();
        e();
        this.f7429c = false;
    }

    public void onDestroy() {
        super.onDestroy();
        this.f7429c = true;
        this.f7428b.j();
    }

    public int onStartCommand(Intent intent, int i10, int i11) {
        super.onStartCommand(intent, i10, i11);
        if (this.f7429c) {
            f.e().f(f7427d, "Re-initializing SystemAlarmDispatcher after a request to shut-down.");
            this.f7428b.j();
            e();
            this.f7429c = false;
        }
        if (intent == null) {
            return 3;
        }
        this.f7428b.b(intent, i11);
        return 3;
    }
}
