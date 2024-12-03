package androidx.browser.customtabs;

import a.a;
import a.b;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import java.util.List;

public final class f {

    /* renamed from: a  reason: collision with root package name */
    private final Object f1554a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private final b f1555b;

    /* renamed from: c  reason: collision with root package name */
    private final a f1556c;

    /* renamed from: d  reason: collision with root package name */
    private final ComponentName f1557d;

    /* renamed from: e  reason: collision with root package name */
    private final PendingIntent f1558e;

    f(b bVar, a aVar, ComponentName componentName, PendingIntent pendingIntent) {
        this.f1555b = bVar;
        this.f1556c = aVar;
        this.f1557d = componentName;
        this.f1558e = pendingIntent;
    }

    private void a(Bundle bundle) {
        PendingIntent pendingIntent = this.f1558e;
        if (pendingIntent != null) {
            bundle.putParcelable("android.support.customtabs.extra.SESSION_ID", pendingIntent);
        }
    }

    private Bundle b(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        if (bundle != null) {
            bundle2.putAll(bundle);
        }
        a(bundle2);
        return bundle2;
    }

    /* access modifiers changed from: package-private */
    public IBinder c() {
        return this.f1556c.asBinder();
    }

    /* access modifiers changed from: package-private */
    public ComponentName d() {
        return this.f1557d;
    }

    /* access modifiers changed from: package-private */
    public PendingIntent e() {
        return this.f1558e;
    }

    public boolean f(Uri uri, Bundle bundle, List<Bundle> list) {
        try {
            return this.f1555b.g0(this.f1556c, uri, b(bundle), list);
        } catch (RemoteException unused) {
            return false;
        }
    }
}
