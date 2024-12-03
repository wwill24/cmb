package com.google.android.gms.common;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.RemoteException;
import android.os.StrictMode;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.common.internal.w0;
import com.google.android.gms.common.internal.x0;
import com.google.android.gms.dynamite.DynamiteModule;
import java.security.MessageDigest;
import me.a;
import me.k;
import pe.b;

final class v {

    /* renamed from: a  reason: collision with root package name */
    static final t f39188a = new n(r.f("0\u0005È0\u0003° \u0003\u0002\u0001\u0002\u0002\u0014\u0010e\bsù/Qí"));

    /* renamed from: b  reason: collision with root package name */
    static final t f39189b = new o(r.f("0\u0006\u00040\u0003ì \u0003\u0002\u0001\u0002\u0002\u0014\u0003£²­×árÊkì"));

    /* renamed from: c  reason: collision with root package name */
    static final t f39190c = new p(r.f("0\u0004C0\u0003+ \u0003\u0002\u0001\u0002\u0002\t\u0000ÂàFdJ00"));

    /* renamed from: d  reason: collision with root package name */
    static final t f39191d = new q(r.f("0\u0004¨0\u0003 \u0003\u0002\u0001\u0002\u0002\t\u0000Õ¸l}ÓNõ0"));

    /* renamed from: e  reason: collision with root package name */
    private static volatile x0 f39192e;

    /* renamed from: f  reason: collision with root package name */
    private static final Object f39193f = new Object();

    /* renamed from: g  reason: collision with root package name */
    private static Context f39194g;

    static c0 a(String str, r rVar, boolean z10, boolean z11) {
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            return f(str, rVar, z10, z11);
        } finally {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
        }
    }

    static c0 b(String str, boolean z10, boolean z11, boolean z12) {
        return g(str, z10, false, false, true);
    }

    static /* synthetic */ String c(boolean z10, String str, r rVar) throws Exception {
        boolean z11;
        String str2;
        if (z10 || !f(str, rVar, true, false).f38870a) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (true != z11) {
            str2 = "not allowed";
        } else {
            str2 = "debug cert rejected";
        }
        MessageDigest b10 = a.b("SHA-256");
        p.k(b10);
        return String.format("%s: pkg=%s, sha256=%s, atk=%s, ver=%s", new Object[]{str2, str, k.a(b10.digest(rVar.g())), Boolean.valueOf(z10), "12451000.false"});
    }

    static synchronized void d(Context context) {
        synchronized (v.class) {
            if (f39194g != null) {
                return;
            }
            if (context != null) {
                f39194g = context.getApplicationContext();
            }
        }
    }

    /* JADX INFO: finally extract failed */
    static boolean e() {
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            h();
            boolean zzi = f39192e.zzi();
            StrictMode.setThreadPolicy(allowThreadDiskReads);
            return zzi;
        } catch (RemoteException | DynamiteModule.LoadingException unused) {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
            return false;
        } catch (Throwable th2) {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
            throw th2;
        }
    }

    private static c0 f(String str, r rVar, boolean z10, boolean z11) {
        try {
            h();
            p.k(f39194g);
            try {
                if (f39192e.k(new zzs(str, rVar, z10, z11), b.g(f39194g.getPackageManager()))) {
                    return c0.b();
                }
                return new a0(new m(z10, str, rVar), (z) null);
            } catch (RemoteException e10) {
                return c0.d("module call", e10);
            }
        } catch (DynamiteModule.LoadingException e11) {
            return c0.d("module init: ".concat(String.valueOf(e11.getMessage())), e11);
        }
    }

    /* JADX WARNING: type inference failed for: r4v0, types: [pe.a, android.os.IBinder] */
    private static c0 g(String str, boolean z10, boolean z11, boolean z12, boolean z13) {
        c0 c0Var;
        zzq zzq;
        PackageManager.NameNotFoundException nameNotFoundException;
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            p.k(f39194g);
            try {
                h();
                zzo zzo = new zzo(str, z10, false, b.g(f39194g), false);
                if (z13) {
                    zzq = f39192e.V(zzo);
                } else {
                    zzq = f39192e.d0(zzo);
                }
                if (zzq.zzb()) {
                    c0Var = c0.f(zzq.zzc());
                } else {
                    String zza = zzq.zza();
                    if (zzq.zzd() == 4) {
                        nameNotFoundException = new PackageManager.NameNotFoundException();
                    } else {
                        nameNotFoundException = null;
                    }
                    if (zza == null) {
                        zza = "error checking package certificate";
                    }
                    c0Var = c0.g(zzq.zzc(), zzq.zzd(), zza, nameNotFoundException);
                }
            } catch (DynamiteModule.LoadingException e10) {
                c0Var = c0.d("module init: ".concat(String.valueOf(e10.getMessage())), e10);
            }
        } catch (RemoteException e11) {
            c0Var = c0.d("module call", e11);
        } catch (Throwable th2) {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
            throw th2;
        }
        StrictMode.setThreadPolicy(allowThreadDiskReads);
        return c0Var;
    }

    private static void h() throws DynamiteModule.LoadingException {
        if (f39192e == null) {
            p.k(f39194g);
            synchronized (f39193f) {
                if (f39192e == null) {
                    f39192e = w0.c(DynamiteModule.d(f39194g, DynamiteModule.f39212f, "com.google.android.gms.googlecertificates").c("com.google.android.gms.common.GoogleCertificatesImpl"));
                }
            }
        }
    }
}
