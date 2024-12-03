package androidx.work.impl.foreground;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.work.impl.e;
import androidx.work.impl.e0;
import b2.f;
import d2.c;
import d2.d;
import g2.m;
import g2.u;
import g2.x;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

public class b implements c, e {

    /* renamed from: l  reason: collision with root package name */
    static final String f7519l = f.i("SystemFgDispatcher");

    /* renamed from: a  reason: collision with root package name */
    private Context f7520a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public e0 f7521b;

    /* renamed from: c  reason: collision with root package name */
    private final i2.b f7522c;

    /* renamed from: d  reason: collision with root package name */
    final Object f7523d = new Object();

    /* renamed from: e  reason: collision with root package name */
    m f7524e;

    /* renamed from: f  reason: collision with root package name */
    final Map<m, b2.b> f7525f;

    /* renamed from: g  reason: collision with root package name */
    final Map<m, u> f7526g;

    /* renamed from: h  reason: collision with root package name */
    final Set<u> f7527h;

    /* renamed from: j  reason: collision with root package name */
    final d f7528j;

    /* renamed from: k  reason: collision with root package name */
    private C0085b f7529k;

    class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f7530a;

        a(String str) {
            this.f7530a = str;
        }

        public void run() {
            u h10 = b.this.f7521b.l().h(this.f7530a);
            if (h10 != null && h10.h()) {
                synchronized (b.this.f7523d) {
                    b.this.f7526g.put(x.a(h10), h10);
                    b.this.f7527h.add(h10);
                    b bVar = b.this;
                    bVar.f7528j.a(bVar.f7527h);
                }
            }
        }
    }

    /* renamed from: androidx.work.impl.foreground.b$b  reason: collision with other inner class name */
    interface C0085b {
        void a(int i10, @NonNull Notification notification);

        void c(int i10, int i11, @NonNull Notification notification);

        void d(int i10);

        void stop();
    }

    b(@NonNull Context context) {
        this.f7520a = context;
        e0 j10 = e0.j(context);
        this.f7521b = j10;
        this.f7522c = j10.p();
        this.f7524e = null;
        this.f7525f = new LinkedHashMap();
        this.f7527h = new HashSet();
        this.f7526g = new HashMap();
        this.f7528j = new d2.e(this.f7521b.n(), (c) this);
        this.f7521b.l().g(this);
    }

    @NonNull
    public static Intent d(@NonNull Context context, @NonNull m mVar, @NonNull b2.b bVar) {
        Intent intent = new Intent(context, SystemForegroundService.class);
        intent.setAction("ACTION_NOTIFY");
        intent.putExtra("KEY_NOTIFICATION_ID", bVar.c());
        intent.putExtra("KEY_FOREGROUND_SERVICE_TYPE", bVar.a());
        intent.putExtra("KEY_NOTIFICATION", bVar.b());
        intent.putExtra("KEY_WORKSPEC_ID", mVar.b());
        intent.putExtra("KEY_GENERATION", mVar.a());
        return intent;
    }

    @NonNull
    public static Intent e(@NonNull Context context, @NonNull m mVar, @NonNull b2.b bVar) {
        Intent intent = new Intent(context, SystemForegroundService.class);
        intent.setAction("ACTION_START_FOREGROUND");
        intent.putExtra("KEY_WORKSPEC_ID", mVar.b());
        intent.putExtra("KEY_GENERATION", mVar.a());
        intent.putExtra("KEY_NOTIFICATION_ID", bVar.c());
        intent.putExtra("KEY_FOREGROUND_SERVICE_TYPE", bVar.a());
        intent.putExtra("KEY_NOTIFICATION", bVar.b());
        return intent;
    }

    @NonNull
    public static Intent g(@NonNull Context context) {
        Intent intent = new Intent(context, SystemForegroundService.class);
        intent.setAction("ACTION_STOP_FOREGROUND");
        return intent;
    }

    private void h(@NonNull Intent intent) {
        f e10 = f.e();
        String str = f7519l;
        e10.f(str, "Stopping foreground work for " + intent);
        String stringExtra = intent.getStringExtra("KEY_WORKSPEC_ID");
        if (stringExtra != null && !TextUtils.isEmpty(stringExtra)) {
            this.f7521b.e(UUID.fromString(stringExtra));
        }
    }

    private void i(@NonNull Intent intent) {
        int i10 = 0;
        int intExtra = intent.getIntExtra("KEY_NOTIFICATION_ID", 0);
        int intExtra2 = intent.getIntExtra("KEY_FOREGROUND_SERVICE_TYPE", 0);
        String stringExtra = intent.getStringExtra("KEY_WORKSPEC_ID");
        m mVar = new m(stringExtra, intent.getIntExtra("KEY_GENERATION", 0));
        Notification notification = (Notification) intent.getParcelableExtra("KEY_NOTIFICATION");
        f e10 = f.e();
        String str = f7519l;
        e10.a(str, "Notifying with (id:" + intExtra + ", workSpecId: " + stringExtra + ", notificationType :" + intExtra2 + ")");
        if (notification != null && this.f7529k != null) {
            this.f7525f.put(mVar, new b2.b(intExtra, notification, intExtra2));
            if (this.f7524e == null) {
                this.f7524e = mVar;
                this.f7529k.c(intExtra, intExtra2, notification);
                return;
            }
            this.f7529k.a(intExtra, notification);
            if (intExtra2 != 0 && Build.VERSION.SDK_INT >= 29) {
                for (Map.Entry<m, b2.b> value : this.f7525f.entrySet()) {
                    i10 |= ((b2.b) value.getValue()).a();
                }
                b2.b bVar = this.f7525f.get(this.f7524e);
                if (bVar != null) {
                    this.f7529k.c(bVar.c(), i10, bVar.b());
                }
            }
        }
    }

    private void j(@NonNull Intent intent) {
        f e10 = f.e();
        String str = f7519l;
        e10.f(str, "Started foreground service " + intent);
        this.f7522c.c(new a(intent.getStringExtra("KEY_WORKSPEC_ID")));
    }

    public void a(@NonNull m mVar, boolean z10) {
        boolean z11;
        Map.Entry entry;
        synchronized (this.f7523d) {
            u remove = this.f7526g.remove(mVar);
            if (remove != null) {
                z11 = this.f7527h.remove(remove);
            } else {
                z11 = false;
            }
            if (z11) {
                this.f7528j.a(this.f7527h);
            }
        }
        b2.b remove2 = this.f7525f.remove(mVar);
        if (mVar.equals(this.f7524e) && this.f7525f.size() > 0) {
            Iterator it = this.f7525f.entrySet().iterator();
            Object next = it.next();
            while (true) {
                entry = (Map.Entry) next;
                if (!it.hasNext()) {
                    break;
                }
                next = it.next();
            }
            this.f7524e = (m) entry.getKey();
            if (this.f7529k != null) {
                b2.b bVar = (b2.b) entry.getValue();
                this.f7529k.c(bVar.c(), bVar.a(), bVar.b());
                this.f7529k.d(bVar.c());
            }
        }
        C0085b bVar2 = this.f7529k;
        if (remove2 != null && bVar2 != null) {
            f e10 = f.e();
            String str = f7519l;
            e10.a(str, "Removing Notification (id: " + remove2.c() + ", workSpecId: " + mVar + ", notificationType: " + remove2.a());
            bVar2.d(remove2.c());
        }
    }

    public void b(@NonNull List<u> list) {
        if (!list.isEmpty()) {
            for (u next : list) {
                String str = next.f15077a;
                f e10 = f.e();
                String str2 = f7519l;
                e10.a(str2, "Constraints unmet for WorkSpec " + str);
                this.f7521b.w(x.a(next));
            }
        }
    }

    public void f(@NonNull List<u> list) {
    }

    /* access modifiers changed from: package-private */
    public void k(@NonNull Intent intent) {
        f.e().f(f7519l, "Stopping foreground service");
        C0085b bVar = this.f7529k;
        if (bVar != null) {
            bVar.stop();
        }
    }

    /* access modifiers changed from: package-private */
    public void l() {
        this.f7529k = null;
        synchronized (this.f7523d) {
            this.f7528j.reset();
        }
        this.f7521b.l().n(this);
    }

    /* access modifiers changed from: package-private */
    public void m(@NonNull Intent intent) {
        String action = intent.getAction();
        if ("ACTION_START_FOREGROUND".equals(action)) {
            j(intent);
            i(intent);
        } else if ("ACTION_NOTIFY".equals(action)) {
            i(intent);
        } else if ("ACTION_CANCEL_WORK".equals(action)) {
            h(intent);
        } else if ("ACTION_STOP_FOREGROUND".equals(action)) {
            k(intent);
        }
    }

    /* access modifiers changed from: package-private */
    public void n(@NonNull C0085b bVar) {
        if (this.f7529k != null) {
            f.e().c(f7519l, "A callback already exists.");
        } else {
            this.f7529k = bVar;
        }
    }
}
