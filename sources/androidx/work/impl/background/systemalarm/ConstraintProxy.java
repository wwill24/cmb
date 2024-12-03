package androidx.work.impl.background.systemalarm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.work.NetworkType;
import b2.a;
import b2.f;
import g2.u;
import java.util.List;

abstract class ConstraintProxy extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    private static final String f7420a = f.i("ConstraintProxy");

    public static class BatteryChargingProxy extends ConstraintProxy {
        public /* bridge */ /* synthetic */ void onReceive(Context context, Intent intent) {
            ConstraintProxy.super.onReceive(context, intent);
        }
    }

    public static class BatteryNotLowProxy extends ConstraintProxy {
        public /* bridge */ /* synthetic */ void onReceive(Context context, Intent intent) {
            ConstraintProxy.super.onReceive(context, intent);
        }
    }

    public static class NetworkStateProxy extends ConstraintProxy {
        public /* bridge */ /* synthetic */ void onReceive(Context context, Intent intent) {
            ConstraintProxy.super.onReceive(context, intent);
        }
    }

    public static class StorageNotLowProxy extends ConstraintProxy {
        public /* bridge */ /* synthetic */ void onReceive(Context context, Intent intent) {
            ConstraintProxy.super.onReceive(context, intent);
        }
    }

    ConstraintProxy() {
    }

    static void a(Context context, List<u> list) {
        boolean z10;
        boolean z11 = false;
        boolean z12 = false;
        boolean z13 = false;
        boolean z14 = false;
        for (u uVar : list) {
            a aVar = uVar.f15086j;
            z11 |= aVar.f();
            z12 |= aVar.g();
            z13 |= aVar.i();
            if (aVar.d() != NetworkType.NOT_REQUIRED) {
                z10 = true;
            } else {
                z10 = false;
            }
            z14 |= z10;
            if (z11 && z12 && z13 && z14) {
                break;
            }
        }
        context.sendBroadcast(ConstraintProxyUpdateReceiver.a(context, z11, z12, z13, z14));
    }

    public void onReceive(Context context, Intent intent) {
        f e10 = f.e();
        String str = f7420a;
        e10.a(str, "onReceive : " + intent);
        context.startService(b.b(context));
    }
}
