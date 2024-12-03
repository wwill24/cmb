package androidx.work.impl.background.systemalarm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.work.impl.e0;
import b2.f;

public class RescheduleReceiver extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    private static final String f7426a = f.i("RescheduleReceiver");

    public void onReceive(Context context, Intent intent) {
        f e10 = f.e();
        String str = f7426a;
        e10.a(str, "Received intent " + intent);
        try {
            e0.j(context).t(goAsync());
        } catch (IllegalStateException e11) {
            f.e().d(f7426a, "Cannot reschedule jobs. WorkManager needs to be initialized via a ContentProvider#onCreate() or an Application#onCreate().", e11);
        }
    }
}
