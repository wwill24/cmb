package androidx.work.impl.diagnostics;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.work.impl.workers.DiagnosticsWorker;
import b2.f;
import b2.g;
import b2.m;

public class DiagnosticsReceiver extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    private static final String f7487a = f.i("DiagnosticsRcvr");

    public void onReceive(@NonNull Context context, Intent intent) {
        if (intent != null) {
            f.e().a(f7487a, "Requesting diagnostics");
            try {
                m.c(context).a(g.e(DiagnosticsWorker.class));
            } catch (IllegalStateException e10) {
                f.e().d(f7487a, "WorkManager is not initialized", e10);
            }
        }
    }
}
