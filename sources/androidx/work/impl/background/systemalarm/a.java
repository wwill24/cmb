package androidx.work.impl.background.systemalarm;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.work.impl.WorkDatabase;
import b2.f;
import g2.i;
import g2.j;
import g2.l;
import g2.m;

class a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f7430a = f.i("Alarms");

    /* renamed from: androidx.work.impl.background.systemalarm.a$a  reason: collision with other inner class name */
    static class C0084a {
        static void a(AlarmManager alarmManager, int i10, long j10, PendingIntent pendingIntent) {
            alarmManager.setExact(i10, j10, pendingIntent);
        }
    }

    public static void a(@NonNull Context context, @NonNull WorkDatabase workDatabase, @NonNull m mVar) {
        j H = workDatabase.H();
        i c10 = H.c(mVar);
        if (c10 != null) {
            b(context, mVar, c10.f15050c);
            f e10 = f.e();
            String str = f7430a;
            e10.a(str, "Removing SystemIdInfo for workSpecId (" + mVar + ")");
            H.a(mVar);
        }
    }

    private static void b(@NonNull Context context, @NonNull m mVar, int i10) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        PendingIntent service = PendingIntent.getService(context, i10, b.c(context, mVar), 603979776);
        if (service != null && alarmManager != null) {
            f e10 = f.e();
            String str = f7430a;
            e10.a(str, "Cancelling existing alarm with (workSpecId, systemId) (" + mVar + ", " + i10 + ")");
            alarmManager.cancel(service);
        }
    }

    public static void c(@NonNull Context context, @NonNull WorkDatabase workDatabase, @NonNull m mVar, long j10) {
        j H = workDatabase.H();
        i c10 = H.c(mVar);
        if (c10 != null) {
            b(context, mVar, c10.f15050c);
            d(context, mVar, c10.f15050c, j10);
            return;
        }
        int c11 = new h2.i(workDatabase).c();
        H.b(l.a(mVar, c11));
        d(context, mVar, c11, j10);
    }

    private static void d(@NonNull Context context, @NonNull m mVar, int i10, long j10) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        PendingIntent service = PendingIntent.getService(context, i10, b.c(context, mVar), 201326592);
        if (alarmManager != null) {
            C0084a.a(alarmManager, 0, j10, service);
        }
    }
}
