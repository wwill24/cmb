package io.sentry.android.core.internal.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import io.sentry.SentryLevel;
import io.sentry.android.core.i0;
import io.sentry.h0;
import io.sentry.util.l;
import java.io.File;
import java.nio.charset.Charset;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
public final class j {

    /* renamed from: g  reason: collision with root package name */
    private static final Charset f31031g = Charset.forName("UTF-8");

    /* renamed from: a  reason: collision with root package name */
    private final Context f31032a;

    /* renamed from: b  reason: collision with root package name */
    private final i0 f31033b;

    /* renamed from: c  reason: collision with root package name */
    private final h0 f31034c;

    /* renamed from: d  reason: collision with root package name */
    private final String[] f31035d;

    /* renamed from: e  reason: collision with root package name */
    private final String[] f31036e;

    /* renamed from: f  reason: collision with root package name */
    private final Runtime f31037f;

    public j(Context context, i0 i0Var, h0 h0Var) {
        this(context, i0Var, h0Var, new String[]{"/system/app/Superuser.apk", "/sbin/su", "/system/bin/su", "/system/xbin/su", "/data/local/xbin/su", "/data/local/bin/su", "/system/sd/xbin/su", "/system/bin/failsafe/su", "/data/local/su", "/su/bin/su", "/su/bin", "/system/xbin/daemonsu"}, new String[]{"com.devadvance.rootcloak", "com.devadvance.rootcloakplus", "com.koushikdutta.superuser", "com.thirdparty.superuser", "eu.chainfire.supersu", "com.noshufou.android.su"}, Runtime.getRuntime());
    }

    private boolean a() {
        String[] strArr = this.f31035d;
        int length = strArr.length;
        int i10 = 0;
        while (i10 < length) {
            String str = strArr[i10];
            try {
                if (new File(str).exists()) {
                    return true;
                }
                i10++;
            } catch (RuntimeException e10) {
                this.f31034c.a(SentryLevel.ERROR, e10, "Error when trying to check if root file %s exists.", str);
            }
        }
        return false;
    }

    @SuppressLint({"NewApi"})
    private boolean b(h0 h0Var) {
        i0 i0Var = new i0(h0Var);
        PackageManager packageManager = this.f31032a.getPackageManager();
        if (packageManager != null) {
            String[] strArr = this.f31036e;
            int length = strArr.length;
            int i10 = 0;
            while (i10 < length) {
                String str = strArr[i10];
                try {
                    if (i0Var.d() >= 33) {
                        packageManager.getPackageInfo(str, PackageManager.PackageInfoFlags.of(0));
                        return true;
                    }
                    packageManager.getPackageInfo(str, 0);
                    return true;
                } catch (PackageManager.NameNotFoundException unused) {
                    i10++;
                }
            }
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0055, code lost:
        if (r2 == null) goto L_0x0058;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0058, code lost:
        return false;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:24:0x004a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean c() {
        /*
            r6 = this;
            java.lang.String r0 = "/system/xbin/which"
            java.lang.String r1 = "su"
            java.lang.String[] r0 = new java.lang.String[]{r0, r1}
            r1 = 0
            r2 = 0
            java.lang.Runtime r3 = r6.f31037f     // Catch:{ IOException -> 0x004a, all -> 0x003a }
            java.lang.Process r2 = r3.exec(r0)     // Catch:{ IOException -> 0x004a, all -> 0x003a }
            java.io.BufferedReader r0 = new java.io.BufferedReader     // Catch:{ IOException -> 0x004a, all -> 0x003a }
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x004a, all -> 0x003a }
            java.io.InputStream r4 = r2.getInputStream()     // Catch:{ IOException -> 0x004a, all -> 0x003a }
            java.nio.charset.Charset r5 = f31031g     // Catch:{ IOException -> 0x004a, all -> 0x003a }
            r3.<init>(r4, r5)     // Catch:{ IOException -> 0x004a, all -> 0x003a }
            r0.<init>(r3)     // Catch:{ IOException -> 0x004a, all -> 0x003a }
            java.lang.String r3 = r0.readLine()     // Catch:{ all -> 0x0030 }
            if (r3 == 0) goto L_0x0028
            r3 = 1
            goto L_0x0029
        L_0x0028:
            r3 = r1
        L_0x0029:
            r0.close()     // Catch:{ IOException -> 0x004a, all -> 0x003a }
            r2.destroy()
            return r3
        L_0x0030:
            r3 = move-exception
            r0.close()     // Catch:{ all -> 0x0035 }
            goto L_0x0039
        L_0x0035:
            r0 = move-exception
            r3.addSuppressed(r0)     // Catch:{ IOException -> 0x004a, all -> 0x003a }
        L_0x0039:
            throw r3     // Catch:{ IOException -> 0x004a, all -> 0x003a }
        L_0x003a:
            r0 = move-exception
            io.sentry.h0 r3 = r6.f31034c     // Catch:{ all -> 0x0059 }
            io.sentry.SentryLevel r4 = io.sentry.SentryLevel.DEBUG     // Catch:{ all -> 0x0059 }
            java.lang.String r5 = "Error when trying to check if SU exists."
            r3.b(r4, r5, r0)     // Catch:{ all -> 0x0059 }
            if (r2 == 0) goto L_0x0058
        L_0x0046:
            r2.destroy()
            goto L_0x0058
        L_0x004a:
            io.sentry.h0 r0 = r6.f31034c     // Catch:{ all -> 0x0059 }
            io.sentry.SentryLevel r3 = io.sentry.SentryLevel.DEBUG     // Catch:{ all -> 0x0059 }
            java.lang.String r4 = "SU isn't found on this Device."
            java.lang.Object[] r5 = new java.lang.Object[r1]     // Catch:{ all -> 0x0059 }
            r0.c(r3, r4, r5)     // Catch:{ all -> 0x0059 }
            if (r2 == 0) goto L_0x0058
            goto L_0x0046
        L_0x0058:
            return r1
        L_0x0059:
            r0 = move-exception
            if (r2 == 0) goto L_0x005f
            r2.destroy()
        L_0x005f:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.android.core.internal.util.j.c():boolean");
    }

    private boolean d() {
        String a10 = this.f31033b.a();
        if (a10 == null || !a10.contains("test-keys")) {
            return false;
        }
        return true;
    }

    public boolean e() {
        return d() || a() || c() || b(this.f31034c);
    }

    j(Context context, i0 i0Var, h0 h0Var, String[] strArr, String[] strArr2, Runtime runtime) {
        this.f31032a = (Context) l.c(context, "The application context is required.");
        this.f31033b = (i0) l.c(i0Var, "The BuildInfoProvider is required.");
        this.f31034c = (h0) l.c(h0Var, "The Logger is required.");
        this.f31035d = (String[]) l.c(strArr, "The root Files are required.");
        this.f31036e = (String[]) l.c(strArr2, "The root packages are required.");
        this.f31037f = (Runtime) l.c(runtime, "The Runtime is required.");
    }
}
