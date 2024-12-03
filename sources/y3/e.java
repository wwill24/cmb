package y3;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import androidx.annotation.NonNull;
import f4.j;
import y3.c;

final class e implements c {

    /* renamed from: a  reason: collision with root package name */
    private final Context f18634a;

    /* renamed from: b  reason: collision with root package name */
    final c.a f18635b;

    /* renamed from: c  reason: collision with root package name */
    boolean f18636c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f18637d;

    /* renamed from: e  reason: collision with root package name */
    private final BroadcastReceiver f18638e = new a();

    class a extends BroadcastReceiver {
        a() {
        }

        public void onReceive(@NonNull Context context, Intent intent) {
            e eVar = e.this;
            boolean z10 = eVar.f18636c;
            eVar.f18636c = eVar.e(context);
            if (z10 != e.this.f18636c) {
                if (Log.isLoggable("ConnectivityMonitor", 3)) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("connectivity changed, isConnected: ");
                    sb2.append(e.this.f18636c);
                }
                e eVar2 = e.this;
                eVar2.f18635b.a(eVar2.f18636c);
            }
        }
    }

    e(@NonNull Context context, @NonNull c.a aVar) {
        this.f18634a = context.getApplicationContext();
        this.f18635b = aVar;
    }

    private void h() {
        if (!this.f18637d) {
            this.f18636c = e(this.f18634a);
            try {
                this.f18634a.registerReceiver(this.f18638e, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                this.f18637d = true;
            } catch (SecurityException unused) {
                Log.isLoggable("ConnectivityMonitor", 5);
            }
        }
    }

    private void n() {
        if (this.f18637d) {
            this.f18634a.unregisterReceiver(this.f18638e);
            this.f18637d = false;
        }
    }

    public void b() {
        h();
    }

    public void d() {
    }

    /* access modifiers changed from: package-private */
    @SuppressLint({"MissingPermission"})
    public boolean e(@NonNull Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) j.d((ConnectivityManager) context.getSystemService("connectivity"))).getActiveNetworkInfo();
            if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                return false;
            }
            return true;
        } catch (RuntimeException unused) {
            Log.isLoggable("ConnectivityMonitor", 5);
            return true;
        }
    }

    public void m() {
        n();
    }
}
