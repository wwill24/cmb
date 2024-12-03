package androidx.browser.customtabs;

import a.a;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import androidx.annotation.NonNull;

public class c {

    /* renamed from: a  reason: collision with root package name */
    private final a.b f1536a;

    /* renamed from: b  reason: collision with root package name */
    private final ComponentName f1537b;

    /* renamed from: c  reason: collision with root package name */
    private final Context f1538c;

    class a extends e {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f1539a;

        a(Context context) {
            this.f1539a = context;
        }

        public final void onCustomTabsServiceConnected(@NonNull ComponentName componentName, @NonNull c cVar) {
            cVar.f(0);
            this.f1539a.unbindService(this);
        }

        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    class b extends a.C0000a {

        /* renamed from: a  reason: collision with root package name */
        private Handler f1540a = new Handler(Looper.getMainLooper());

        b(b bVar) {
        }

        public void h0(int i10, Bundle bundle) {
        }

        public void n0(String str, Bundle bundle) throws RemoteException {
        }

        public void o0(Bundle bundle) throws RemoteException {
        }

        public Bundle q(@NonNull String str, Bundle bundle) throws RemoteException {
            return null;
        }

        public void q0(int i10, Uri uri, boolean z10, Bundle bundle) throws RemoteException {
        }

        public void x(String str, Bundle bundle) throws RemoteException {
        }
    }

    c(a.b bVar, ComponentName componentName, Context context) {
        this.f1536a = bVar;
        this.f1537b = componentName;
        this.f1538c = context;
    }

    public static boolean a(@NonNull Context context, String str, @NonNull e eVar) {
        eVar.setApplicationContext(context.getApplicationContext());
        Intent intent = new Intent("android.support.customtabs.action.CustomTabsService");
        if (!TextUtils.isEmpty(str)) {
            intent.setPackage(str);
        }
        return context.bindService(intent, eVar, 33);
    }

    public static boolean b(@NonNull Context context, @NonNull String str) {
        if (str == null) {
            return false;
        }
        Context applicationContext = context.getApplicationContext();
        try {
            return a(applicationContext, str, new a(applicationContext));
        } catch (SecurityException unused) {
            return false;
        }
    }

    private a.C0000a c(b bVar) {
        return new b(bVar);
    }

    private f e(b bVar, PendingIntent pendingIntent) {
        boolean z10;
        a.C0000a c10 = c(bVar);
        if (pendingIntent != null) {
            try {
                Bundle bundle = new Bundle();
                bundle.putParcelable("android.support.customtabs.extra.SESSION_ID", pendingIntent);
                z10 = this.f1536a.Y(c10, bundle);
            } catch (RemoteException unused) {
                return null;
            }
        } else {
            z10 = this.f1536a.S(c10);
        }
        if (!z10) {
            return null;
        }
        return new f(this.f1536a, c10, this.f1537b, pendingIntent);
    }

    public f d(b bVar) {
        return e(bVar, (PendingIntent) null);
    }

    public boolean f(long j10) {
        try {
            return this.f1536a.U(j10);
        } catch (RemoteException unused) {
            return false;
        }
    }
}
