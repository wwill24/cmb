package androidx.work.impl.background.systemalarm;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.work.impl.background.systemalarm.ConstraintProxy;
import androidx.work.impl.e0;
import b2.f;
import h2.n;

public class ConstraintProxyUpdateReceiver extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    static final String f7421a = f.i("ConstrntProxyUpdtRecvr");

    class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Intent f7422a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f7423b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ BroadcastReceiver.PendingResult f7424c;

        a(Intent intent, Context context, BroadcastReceiver.PendingResult pendingResult) {
            this.f7422a = intent;
            this.f7423b = context;
            this.f7424c = pendingResult;
        }

        public void run() {
            try {
                boolean booleanExtra = this.f7422a.getBooleanExtra("KEY_BATTERY_NOT_LOW_PROXY_ENABLED", false);
                boolean booleanExtra2 = this.f7422a.getBooleanExtra("KEY_BATTERY_CHARGING_PROXY_ENABLED", false);
                boolean booleanExtra3 = this.f7422a.getBooleanExtra("KEY_STORAGE_NOT_LOW_PROXY_ENABLED", false);
                boolean booleanExtra4 = this.f7422a.getBooleanExtra("KEY_NETWORK_STATE_PROXY_ENABLED", false);
                f.e().a(ConstraintProxyUpdateReceiver.f7421a, "Updating proxies: (BatteryNotLowProxy (" + booleanExtra + "), BatteryChargingProxy (" + booleanExtra2 + "), StorageNotLowProxy (" + booleanExtra3 + "), NetworkStateProxy (" + booleanExtra4 + "), ");
                n.a(this.f7423b, ConstraintProxy.BatteryNotLowProxy.class, booleanExtra);
                n.a(this.f7423b, ConstraintProxy.BatteryChargingProxy.class, booleanExtra2);
                n.a(this.f7423b, ConstraintProxy.StorageNotLowProxy.class, booleanExtra3);
                n.a(this.f7423b, ConstraintProxy.NetworkStateProxy.class, booleanExtra4);
            } finally {
                this.f7424c.finish();
            }
        }
    }

    @NonNull
    public static Intent a(@NonNull Context context, boolean z10, boolean z11, boolean z12, boolean z13) {
        Intent intent = new Intent("androidx.work.impl.background.systemalarm.UpdateProxies");
        intent.setComponent(new ComponentName(context, ConstraintProxyUpdateReceiver.class));
        intent.putExtra("KEY_BATTERY_NOT_LOW_PROXY_ENABLED", z10).putExtra("KEY_BATTERY_CHARGING_PROXY_ENABLED", z11).putExtra("KEY_STORAGE_NOT_LOW_PROXY_ENABLED", z12).putExtra("KEY_NETWORK_STATE_PROXY_ENABLED", z13);
        return intent;
    }

    public void onReceive(@NonNull Context context, Intent intent) {
        String str;
        if (intent != null) {
            str = intent.getAction();
        } else {
            str = null;
        }
        if (!"androidx.work.impl.background.systemalarm.UpdateProxies".equals(str)) {
            f e10 = f.e();
            String str2 = f7421a;
            e10.a(str2, "Ignoring unknown action " + str);
            return;
        }
        e0.j(context).p().c(new a(intent, context, goAsync()));
    }
}
