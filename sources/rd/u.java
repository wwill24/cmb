package rd;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.internal.gtm.zzav;
import com.google.android.gms.internal.gtm.zzba;
import com.google.android.gms.internal.gtm.zzfs;
import java.lang.Thread;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Callable;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

@SuppressLint({"StaticFieldLeak"})
public final class u {

    /* renamed from: g  reason: collision with root package name */
    private static volatile u f41875g;

    /* renamed from: a  reason: collision with root package name */
    private final Context f41876a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final List<v> f41877b = new CopyOnWriteArrayList();

    /* renamed from: c  reason: collision with root package name */
    private final j f41878c = new j();

    /* renamed from: d  reason: collision with root package name */
    private final q f41879d = new q(this);

    /* renamed from: e  reason: collision with root package name */
    private volatile zzav f41880e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public Thread.UncaughtExceptionHandler f41881f;

    u(Context context) {
        Context applicationContext = context.getApplicationContext();
        p.k(applicationContext);
        this.f41876a = applicationContext;
    }

    public static u b(Context context) {
        p.k(context);
        if (f41875g == null) {
            synchronized (u.class) {
                if (f41875g == null) {
                    f41875g = new u(context);
                }
            }
        }
        return f41875g;
    }

    public static void h() {
        if (!(Thread.currentThread() instanceof t)) {
            throw new IllegalStateException("Call expected from worker thread");
        }
    }

    public final Context a() {
        return this.f41876a;
    }

    public final zzav c() {
        if (this.f41880e == null) {
            synchronized (this) {
                if (this.f41880e == null) {
                    zzav zzav = new zzav();
                    PackageManager packageManager = this.f41876a.getPackageManager();
                    String packageName = this.f41876a.getPackageName();
                    zzav.zzi(packageName);
                    zzav.zzj(packageManager.getInstallerPackageName(packageName));
                    String str = null;
                    try {
                        PackageInfo packageInfo = packageManager.getPackageInfo(this.f41876a.getPackageName(), 0);
                        if (packageInfo != null) {
                            CharSequence applicationLabel = packageManager.getApplicationLabel(packageInfo.applicationInfo);
                            if (!TextUtils.isEmpty(applicationLabel)) {
                                packageName = applicationLabel.toString();
                            }
                            str = packageInfo.versionName;
                        }
                    } catch (PackageManager.NameNotFoundException unused) {
                        String valueOf = String.valueOf(packageName);
                        if (valueOf.length() != 0) {
                            "Error retrieving package info: appName set to ".concat(valueOf);
                        }
                    }
                    zzav.zzk(packageName);
                    zzav.zzl(str);
                    this.f41880e = zzav;
                }
            }
        }
        return this.f41880e;
    }

    public final zzba d() {
        DisplayMetrics displayMetrics = this.f41876a.getResources().getDisplayMetrics();
        zzba zzba = new zzba();
        zzba.zze(zzfs.zzd(Locale.getDefault()));
        zzba.zza = displayMetrics.widthPixels;
        zzba.zzb = displayMetrics.heightPixels;
        return zzba;
    }

    public final <V> Future<V> g(Callable<V> callable) {
        p.k(callable);
        if (!(Thread.currentThread() instanceof t)) {
            return this.f41879d.submit(callable);
        }
        FutureTask futureTask = new FutureTask(callable);
        futureTask.run();
        return futureTask;
    }

    public final void i(Runnable runnable) {
        p.k(runnable);
        this.f41879d.submit(runnable);
    }

    public final void j(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.f41881f = uncaughtExceptionHandler;
    }

    /* access modifiers changed from: package-private */
    public final void k(k kVar) {
        if (kVar.l()) {
            throw new IllegalStateException("Measurement prototype can't be submitted");
        } else if (!kVar.m()) {
            k kVar2 = new k(kVar);
            kVar2.i();
            this.f41879d.execute(new o(this, kVar2));
        } else {
            throw new IllegalStateException("Measurement can only be submitted once");
        }
    }
}
