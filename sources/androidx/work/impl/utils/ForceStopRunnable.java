package androidx.work.impl.utils;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.AlarmManager;
import android.app.ApplicationExitInfo;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteAccessPermException;
import android.database.sqlite.SQLiteCantOpenDatabaseException;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabaseCorruptException;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteDiskIOException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteTableLockedException;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.work.WorkInfo;
import androidx.work.a;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.a0;
import androidx.work.impl.background.systemjob.g;
import androidx.work.impl.e0;
import b2.f;
import g2.r;
import g2.u;
import g2.v;
import h2.o;
import h2.p;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ForceStopRunnable implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    private static final String f7601e = f.i("ForceStopRunnable");

    /* renamed from: f  reason: collision with root package name */
    private static final long f7602f = TimeUnit.DAYS.toMillis(3650);

    /* renamed from: a  reason: collision with root package name */
    private final Context f7603a;

    /* renamed from: b  reason: collision with root package name */
    private final e0 f7604b;

    /* renamed from: c  reason: collision with root package name */
    private final o f7605c;

    /* renamed from: d  reason: collision with root package name */
    private int f7606d = 0;

    public static class BroadcastReceiver extends android.content.BroadcastReceiver {

        /* renamed from: a  reason: collision with root package name */
        private static final String f7607a = f.i("ForceStopRunnable$Rcvr");

        public void onReceive(@NonNull Context context, Intent intent) {
            if (intent != null && "ACTION_FORCE_STOP_RESCHEDULE".equals(intent.getAction())) {
                f.e().j(f7607a, "Rescheduling alarm that keeps track of force-stops.");
                ForceStopRunnable.g(context);
            }
        }
    }

    public ForceStopRunnable(@NonNull Context context, @NonNull e0 e0Var) {
        this.f7603a = context.getApplicationContext();
        this.f7604b = e0Var;
        this.f7605c = e0Var.k();
    }

    static Intent c(Context context) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(context, BroadcastReceiver.class));
        intent.setAction("ACTION_FORCE_STOP_RESCHEDULE");
        return intent;
    }

    private static PendingIntent d(Context context, int i10) {
        return PendingIntent.getBroadcast(context, -1, c(context), i10);
    }

    @SuppressLint({"ClassVerificationFailure"})
    static void g(Context context) {
        int i10;
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        if (Build.VERSION.SDK_INT >= 31) {
            i10 = 167772160;
        } else {
            i10 = 134217728;
        }
        PendingIntent d10 = d(context, i10);
        long currentTimeMillis = System.currentTimeMillis() + f7602f;
        if (alarmManager != null) {
            alarmManager.setExact(0, currentTimeMillis, d10);
        }
    }

    public boolean a() {
        boolean z10;
        boolean i10 = g.i(this.f7603a, this.f7604b);
        WorkDatabase o10 = this.f7604b.o();
        v K = o10.K();
        r J = o10.J();
        o10.e();
        try {
            List<u> r10 = K.r();
            if (r10 == null || r10.isEmpty()) {
                z10 = false;
            } else {
                z10 = true;
            }
            if (z10) {
                for (u next : r10) {
                    K.p(WorkInfo.State.ENQUEUED, next.f15077a);
                    K.m(next.f15077a, -1);
                }
            }
            J.b();
            o10.C();
            if (z10 || i10) {
                return true;
            }
            return false;
        } finally {
            o10.j();
        }
    }

    public void b() {
        boolean a10 = a();
        if (h()) {
            f.e().a(f7601e, "Rescheduling Workers.");
            this.f7604b.s();
            this.f7604b.k().e(false);
        } else if (e()) {
            f.e().a(f7601e, "Application was force-stopped, rescheduling.");
            this.f7604b.s();
            this.f7605c.d(System.currentTimeMillis());
        } else if (a10) {
            f.e().a(f7601e, "Found unfinished work, scheduling it.");
            androidx.work.impl.u.b(this.f7604b.h(), this.f7604b.o(), this.f7604b.m());
        }
    }

    @SuppressLint({"ClassVerificationFailure"})
    public boolean e() {
        int i10 = 536870912;
        try {
            int i11 = Build.VERSION.SDK_INT;
            if (i11 >= 31) {
                i10 = 570425344;
            }
            PendingIntent d10 = d(this.f7603a, i10);
            if (i11 >= 30) {
                if (d10 != null) {
                    d10.cancel();
                }
                List a10 = ((ActivityManager) this.f7603a.getSystemService("activity")).getHistoricalProcessExitReasons((String) null, 0, 0);
                if (a10 != null && !a10.isEmpty()) {
                    long a11 = this.f7605c.a();
                    for (int i12 = 0; i12 < a10.size(); i12++) {
                        ApplicationExitInfo applicationExitInfo = (ApplicationExitInfo) a10.get(i12);
                        if (applicationExitInfo.getReason() == 10 && applicationExitInfo.getTimestamp() >= a11) {
                            return true;
                        }
                    }
                }
            } else if (d10 == null) {
                g(this.f7603a);
                return true;
            }
            return false;
        } catch (IllegalArgumentException | SecurityException e10) {
            f.e().l(f7601e, "Ignoring exception", e10);
            return true;
        }
    }

    public boolean f() {
        a h10 = this.f7604b.h();
        if (TextUtils.isEmpty(h10.c())) {
            f.e().a(f7601e, "The default process name was not specified.");
            return true;
        }
        boolean b10 = p.b(this.f7603a, h10);
        f e10 = f.e();
        String str = f7601e;
        e10.a(str, "Is default app process = " + b10);
        return b10;
    }

    public boolean h() {
        return this.f7604b.k().b();
    }

    public void i(long j10) {
        try {
            Thread.sleep(j10);
        } catch (InterruptedException unused) {
        }
    }

    public void run() {
        try {
            if (!f()) {
                this.f7604b.r();
                return;
            }
            while (true) {
                a0.d(this.f7603a);
                f.e().a(f7601e, "Performing cleanup operations.");
                b();
                break;
            }
            this.f7604b.r();
        } catch (SQLiteException e10) {
            f.e().c(f7601e, "Unexpected SQLite exception during migrations");
            IllegalStateException illegalStateException = new IllegalStateException("Unexpected SQLite exception during migrations", e10);
            androidx.core.util.a<Throwable> e11 = this.f7604b.h().e();
            if (e11 != null) {
                e11.accept(illegalStateException);
            } else {
                throw illegalStateException;
            }
        } catch (SQLiteAccessPermException | SQLiteCantOpenDatabaseException | SQLiteConstraintException | SQLiteDatabaseCorruptException | SQLiteDatabaseLockedException | SQLiteDiskIOException | SQLiteTableLockedException e12) {
            int i10 = this.f7606d + 1;
            this.f7606d = i10;
            if (i10 >= 3) {
                f e13 = f.e();
                String str = f7601e;
                e13.d(str, "The file system on the device is in a bad state. WorkManager cannot access the app's internal data store.", e12);
                IllegalStateException illegalStateException2 = new IllegalStateException("The file system on the device is in a bad state. WorkManager cannot access the app's internal data store.", e12);
                androidx.core.util.a<Throwable> e14 = this.f7604b.h().e();
                if (e14 != null) {
                    f.e().b(str, "Routing exception to the specified exception handler", illegalStateException2);
                    e14.accept(illegalStateException2);
                } else {
                    throw illegalStateException2;
                }
            } else {
                f e15 = f.e();
                String str2 = f7601e;
                e15.b(str2, "Retrying after " + (((long) i10) * 300), e12);
                i(((long) this.f7606d) * 300);
            }
        } catch (Throwable th2) {
            this.f7604b.r();
            throw th2;
        }
    }
}
