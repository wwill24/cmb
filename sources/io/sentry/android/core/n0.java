package io.sentry.android.core;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Environment;
import android.os.LocaleList;
import android.os.StatFs;
import android.os.SystemClock;
import android.provider.Settings;
import android.util.DisplayMetrics;
import com.facebook.internal.ServerProtocol;
import com.google.firebase.analytics.FirebaseAnalytics;
import io.sentry.SentryLevel;
import io.sentry.android.core.internal.util.ConnectivityChecker;
import io.sentry.android.core.internal.util.b;
import io.sentry.android.core.internal.util.e;
import io.sentry.android.core.internal.util.f;
import io.sentry.android.core.internal.util.j;
import io.sentry.g;
import io.sentry.p2;
import io.sentry.p3;
import io.sentry.protocol.Device;
import io.sentry.protocol.i;
import io.sentry.protocol.u;
import io.sentry.protocol.v;
import io.sentry.protocol.x;
import io.sentry.t;
import io.sentry.util.l;
import io.sentry.w;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import net.bytebuddy.jar.asm.Opcodes;

final class n0 implements t {

    /* renamed from: a  reason: collision with root package name */
    final Context f31068a;

    /* renamed from: b  reason: collision with root package name */
    final Future<Map<String, Object>> f31069b;

    /* renamed from: c  reason: collision with root package name */
    private final i0 f31070c;

    /* renamed from: d  reason: collision with root package name */
    private final j f31071d;

    /* renamed from: e  reason: collision with root package name */
    private final SentryAndroidOptions f31072e;

    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f31073a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                io.sentry.android.core.internal.util.ConnectivityChecker$Status[] r0 = io.sentry.android.core.internal.util.ConnectivityChecker.Status.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f31073a = r0
                io.sentry.android.core.internal.util.ConnectivityChecker$Status r1 = io.sentry.android.core.internal.util.ConnectivityChecker.Status.NOT_CONNECTED     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f31073a     // Catch:{ NoSuchFieldError -> 0x001d }
                io.sentry.android.core.internal.util.ConnectivityChecker$Status r1 = io.sentry.android.core.internal.util.ConnectivityChecker.Status.CONNECTED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.sentry.android.core.n0.a.<clinit>():void");
        }
    }

    public n0(Context context, i0 i0Var, SentryAndroidOptions sentryAndroidOptions) {
        this(context, i0Var, new j(context, i0Var, sentryAndroidOptions.getLogger()), sentryAndroidOptions);
    }

    private String A() {
        BufferedReader bufferedReader;
        String property = System.getProperty("os.version");
        File file = new File("/proc/version");
        if (!file.canRead()) {
            return property;
        }
        try {
            bufferedReader = new BufferedReader(new FileReader(file));
            String readLine = bufferedReader.readLine();
            bufferedReader.close();
            return readLine;
        } catch (IOException e10) {
            this.f31072e.getLogger().b(SentryLevel.ERROR, "Exception while attempting to read kernel information", e10);
            return property;
        } catch (Throwable th2) {
            th.addSuppressed(th2);
        }
        throw th;
    }

    private ActivityManager.MemoryInfo B() {
        try {
            ActivityManager activityManager = (ActivityManager) this.f31068a.getSystemService("activity");
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            if (activityManager != null) {
                activityManager.getMemoryInfo(memoryInfo);
                return memoryInfo;
            }
            this.f31072e.getLogger().c(SentryLevel.INFO, "Error getting MemoryInfo.", new Object[0]);
            return null;
        } catch (Throwable th2) {
            this.f31072e.getLogger().b(SentryLevel.ERROR, "Error getting MemoryInfo.", th2);
            return null;
        }
    }

    private Long C(ActivityManager.MemoryInfo memoryInfo) {
        if (this.f31070c.d() >= 16) {
            return Long.valueOf(memoryInfo.totalMem);
        }
        return Long.valueOf(Runtime.getRuntime().totalMemory());
    }

    private i D() {
        i iVar = new i();
        iVar.j("Android");
        iVar.m(Build.VERSION.RELEASE);
        iVar.h(Build.DISPLAY);
        try {
            Object obj = this.f31069b.get().get("kernelVersion");
            if (obj != null) {
                iVar.i((String) obj);
            }
            Object obj2 = this.f31069b.get().get("rooted");
            if (obj2 != null) {
                iVar.k((Boolean) obj2);
            }
        } catch (Throwable th2) {
            this.f31072e.getLogger().b(SentryLevel.ERROR, "Error getting OperatingSystem.", th2);
        }
        return iVar;
    }

    private Device.DeviceOrientation E() {
        Device.DeviceOrientation deviceOrientation;
        Throwable th2;
        try {
            deviceOrientation = f.a(this.f31068a.getResources().getConfiguration().orientation);
            if (deviceOrientation == null) {
                try {
                    this.f31072e.getLogger().c(SentryLevel.INFO, "No device orientation available (ORIENTATION_SQUARE|ORIENTATION_UNDEFINED)", new Object[0]);
                    return null;
                } catch (Throwable th3) {
                    th2 = th3;
                    this.f31072e.getLogger().b(SentryLevel.ERROR, "Error getting device orientation.", th2);
                    return deviceOrientation;
                }
            }
        } catch (Throwable th4) {
            Throwable th5 = th4;
            deviceOrientation = null;
            th2 = th5;
            this.f31072e.getLogger().b(SentryLevel.ERROR, "Error getting device orientation.", th2);
            return deviceOrientation;
        }
        return deviceOrientation;
    }

    private Map<String, String> F() {
        String str;
        try {
            PackageInfo c10 = j0.c(this.f31068a, this.f31072e.getLogger(), this.f31070c);
            PackageManager packageManager = this.f31068a.getPackageManager();
            if (!(c10 == null || packageManager == null)) {
                str = c10.packageName;
                try {
                    String installerPackageName = packageManager.getInstallerPackageName(str);
                    HashMap hashMap = new HashMap();
                    if (installerPackageName != null) {
                        hashMap.put("isSideLoaded", "false");
                        hashMap.put("installerStore", installerPackageName);
                    } else {
                        hashMap.put("isSideLoaded", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
                    }
                    return hashMap;
                } catch (IllegalArgumentException unused) {
                    this.f31072e.getLogger().c(SentryLevel.DEBUG, "%s package isn't installed.", str);
                    return null;
                }
            }
        } catch (IllegalArgumentException unused2) {
            str = null;
            this.f31072e.getLogger().c(SentryLevel.DEBUG, "%s package isn't installed.", str);
            return null;
        }
        return null;
    }

    private TimeZone G() {
        if (this.f31070c.d() >= 24) {
            LocaleList locales = this.f31068a.getResources().getConfiguration().getLocales();
            if (!locales.isEmpty()) {
                return Calendar.getInstance(locales.get(0)).getTimeZone();
            }
        }
        return Calendar.getInstance().getTimeZone();
    }

    private Long H(StatFs statFs) {
        try {
            return Long.valueOf(n(statFs) * p(statFs));
        } catch (Throwable th2) {
            this.f31072e.getLogger().b(SentryLevel.ERROR, "Error getting total external storage amount.", th2);
            return null;
        }
    }

    private Long I(StatFs statFs) {
        try {
            return Long.valueOf(n(statFs) * p(statFs));
        } catch (Throwable th2) {
            this.f31072e.getLogger().b(SentryLevel.ERROR, "Error getting total internal storage amount.", th2);
            return null;
        }
    }

    private Long J(StatFs statFs) {
        try {
            return Long.valueOf(i(statFs) * p(statFs));
        } catch (Throwable th2) {
            this.f31072e.getLogger().b(SentryLevel.ERROR, "Error getting unused external storage amount.", th2);
            return null;
        }
    }

    private Long K(StatFs statFs) {
        try {
            return Long.valueOf(i(statFs) * p(statFs));
        } catch (Throwable th2) {
            this.f31072e.getLogger().b(SentryLevel.ERROR, "Error getting unused internal storage amount.", th2);
            return null;
        }
    }

    private Boolean L(Intent intent) {
        try {
            int intExtra = intent.getIntExtra("plugged", -1);
            boolean z10 = true;
            if (intExtra != 1) {
                if (intExtra != 2) {
                    z10 = false;
                }
            }
            return Boolean.valueOf(z10);
        } catch (Throwable th2) {
            this.f31072e.getLogger().b(SentryLevel.ERROR, "Error getting device charging state.", th2);
            return null;
        }
    }

    private boolean M() {
        String externalStorageState = Environment.getExternalStorageState();
        if (("mounted".equals(externalStorageState) || "mounted_ro".equals(externalStorageState)) && !Environment.isExternalStorageEmulated()) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    /* renamed from: P */
    public Map<String, Object> N() {
        HashMap hashMap = new HashMap();
        hashMap.put("rooted", Boolean.valueOf(this.f31071d.e()));
        String A = A();
        if (A != null) {
            hashMap.put("kernelVersion", A);
        }
        hashMap.put("emulator", this.f31070c.f());
        Map<String, String> F = F();
        if (F != null) {
            hashMap.put("sideLoaded", F);
        }
        return hashMap;
    }

    private void Q(p2 p2Var) {
        String str;
        i c10 = p2Var.C().c();
        p2Var.C().k(D());
        if (c10 != null) {
            String g10 = c10.g();
            if (g10 == null || g10.isEmpty()) {
                str = "os_1";
            } else {
                str = "os_" + g10.trim().toLowerCase(Locale.ROOT);
            }
            p2Var.C().put(str, c10);
        }
    }

    private void R(p2 p2Var) {
        x Q = p2Var.Q();
        if (Q == null) {
            p2Var.e0(r());
        } else if (Q.l() == null) {
            Q.p(t());
        }
    }

    private void S(p2 p2Var, w wVar) {
        io.sentry.protocol.a a10 = p2Var.C().a();
        if (a10 == null) {
            a10 = new io.sentry.protocol.a();
        }
        T(a10, wVar);
        a0(p2Var, a10);
        p2Var.C().f(a10);
    }

    private void T(io.sentry.protocol.a aVar, w wVar) {
        Boolean b10;
        aVar.m(g());
        aVar.n(g.n(g0.e().d()));
        if (!io.sentry.util.i.h(wVar) && aVar.j() == null && (b10 = h0.a().b()) != null) {
            aVar.p(Boolean.valueOf(!b10.booleanValue()));
        }
    }

    @SuppressLint({"NewApi"})
    private void U(io.sentry.protocol.a aVar, PackageInfo packageInfo) {
        String str;
        aVar.l(packageInfo.packageName);
        aVar.o(packageInfo.versionName);
        aVar.k(j0.d(packageInfo, this.f31070c));
        if (this.f31070c.d() >= 16) {
            HashMap hashMap = new HashMap();
            String[] strArr = packageInfo.requestedPermissions;
            int[] iArr = packageInfo.requestedPermissionsFlags;
            if (strArr != null && strArr.length > 0 && iArr != null && iArr.length > 0) {
                for (int i10 = 0; i10 < strArr.length; i10++) {
                    String str2 = strArr[i10];
                    boolean z10 = true;
                    String substring = str2.substring(str2.lastIndexOf(46) + 1);
                    if ((iArr[i10] & 2) != 2) {
                        z10 = false;
                    }
                    if (z10) {
                        str = "granted";
                    } else {
                        str = "not_granted";
                    }
                    hashMap.put(substring, str);
                }
            }
            aVar.q(hashMap);
        }
    }

    private void V(Device device) {
        device.M(this.f31070c.d() >= 21 ? Build.SUPPORTED_ABIS : new String[]{e(), f()});
    }

    private void W(p2 p2Var, boolean z10, boolean z11) {
        R(p2Var);
        X(p2Var, z10, z11);
        Q(p2Var);
        b0(p2Var);
    }

    private void X(p2 p2Var, boolean z10, boolean z11) {
        if (p2Var.C().b() == null) {
            p2Var.C().h(s(z10, z11));
        }
    }

    private void Y(Device device, boolean z10) {
        Boolean bool;
        Intent j10 = j();
        if (j10 != null) {
            device.N(k(j10));
            device.R(L(j10));
            device.O(l(j10));
        }
        int i10 = a.f31073a[ConnectivityChecker.b(this.f31068a, this.f31072e.getLogger()).ordinal()];
        if (i10 == 1) {
            bool = Boolean.FALSE;
        } else if (i10 != 2) {
            bool = null;
        } else {
            bool = Boolean.TRUE;
        }
        device.h0(bool);
        ActivityManager.MemoryInfo B = B();
        if (B != null) {
            device.d0(C(B));
            if (z10) {
                device.W(Long.valueOf(B.availMem));
                device.b0(Boolean.valueOf(B.lowMemory));
            }
        }
        File externalFilesDir = this.f31068a.getExternalFilesDir((String) null);
        if (externalFilesDir != null) {
            StatFs statFs = new StatFs(externalFilesDir.getPath());
            device.q0(I(statFs));
            device.X(K(statFs));
        }
        StatFs y10 = y(externalFilesDir);
        if (y10 != null) {
            device.U(H(y10));
            device.T(J(y10));
        }
        if (device.I() == null) {
            device.S(ConnectivityChecker.c(this.f31068a, this.f31072e.getLogger(), this.f31070c));
        }
    }

    private void Z(p2 p2Var, String str) {
        if (p2Var.E() == null) {
            p2Var.T(str);
        }
    }

    private void a0(p2 p2Var, io.sentry.protocol.a aVar) {
        PackageInfo b10 = j0.b(this.f31068a, Opcodes.ACC_SYNTHETIC, this.f31072e.getLogger(), this.f31070c);
        if (b10 != null) {
            Z(p2Var, j0.d(b10, this.f31070c));
            U(aVar, b10);
        }
    }

    private void b0(p2 p2Var) {
        try {
            Object obj = this.f31069b.get().get("sideLoaded");
            if (obj instanceof Map) {
                for (Map.Entry entry : ((Map) obj).entrySet()) {
                    p2Var.c0((String) entry.getKey(), (String) entry.getValue());
                }
            }
        } catch (Throwable th2) {
            this.f31072e.getLogger().b(SentryLevel.ERROR, "Error getting side loaded info.", th2);
        }
    }

    private void c0(p3 p3Var, w wVar) {
        if (p3Var.r0() != null) {
            boolean h10 = io.sentry.util.i.h(wVar);
            for (u next : p3Var.r0()) {
                boolean c10 = b.e().c(next);
                if (next.k() == null) {
                    next.n(Boolean.valueOf(c10));
                }
                if (!h10 && next.l() == null) {
                    next.q(Boolean.valueOf(c10));
                }
            }
        }
    }

    private boolean d0(p2 p2Var, w wVar) {
        if (io.sentry.util.i.s(wVar)) {
            return true;
        }
        this.f31072e.getLogger().c(SentryLevel.DEBUG, "Event was cached so not applying data relevant to the current app execution/version: %s", p2Var.G());
        return false;
    }

    private String e() {
        return Build.CPU_ABI;
    }

    private String f() {
        return Build.CPU_ABI2;
    }

    private String g() {
        try {
            ApplicationInfo applicationInfo = this.f31068a.getApplicationInfo();
            int i10 = applicationInfo.labelRes;
            if (i10 != 0) {
                return this.f31068a.getString(i10);
            }
            CharSequence charSequence = applicationInfo.nonLocalizedLabel;
            if (charSequence != null) {
                return charSequence.toString();
            }
            return this.f31068a.getPackageManager().getApplicationLabel(applicationInfo).toString();
        } catch (Throwable th2) {
            this.f31072e.getLogger().b(SentryLevel.ERROR, "Error getting application name.", th2);
            return null;
        }
    }

    private int h(StatFs statFs) {
        return statFs.getAvailableBlocks();
    }

    private long i(StatFs statFs) {
        if (this.f31070c.d() >= 18) {
            return statFs.getAvailableBlocksLong();
        }
        return (long) h(statFs);
    }

    private Intent j() {
        return this.f31068a.registerReceiver((BroadcastReceiver) null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
    }

    private Float k(Intent intent) {
        try {
            int intExtra = intent.getIntExtra(FirebaseAnalytics.Param.LEVEL, -1);
            int intExtra2 = intent.getIntExtra("scale", -1);
            if (intExtra != -1) {
                if (intExtra2 != -1) {
                    return Float.valueOf((((float) intExtra) / ((float) intExtra2)) * 100.0f);
                }
            }
            return null;
        } catch (Throwable th2) {
            this.f31072e.getLogger().b(SentryLevel.ERROR, "Error getting device battery level.", th2);
            return null;
        }
    }

    private Float l(Intent intent) {
        try {
            int intExtra = intent.getIntExtra("temperature", -1);
            if (intExtra != -1) {
                return Float.valueOf(((float) intExtra) / 10.0f);
            }
            return null;
        } catch (Throwable th2) {
            this.f31072e.getLogger().b(SentryLevel.ERROR, "Error getting battery temperature.", th2);
            return null;
        }
    }

    private int m(StatFs statFs) {
        return statFs.getBlockCount();
    }

    private long n(StatFs statFs) {
        if (this.f31070c.d() >= 18) {
            return statFs.getBlockCountLong();
        }
        return (long) m(statFs);
    }

    private int o(StatFs statFs) {
        return statFs.getBlockSize();
    }

    private long p(StatFs statFs) {
        if (this.f31070c.d() >= 18) {
            return statFs.getBlockSizeLong();
        }
        return (long) o(statFs);
    }

    private Date q() {
        try {
            return g.d(System.currentTimeMillis() - SystemClock.elapsedRealtime());
        } catch (IllegalArgumentException e10) {
            this.f31072e.getLogger().a(SentryLevel.ERROR, e10, "Error getting the device's boot time.", new Object[0]);
            return null;
        }
    }

    private Device s(boolean z10, boolean z11) {
        Device device = new Device();
        if (this.f31072e.isSendDefaultPii()) {
            device.g0(u());
        }
        device.c0(Build.MANUFACTURER);
        device.Q(Build.BRAND);
        device.V(z());
        device.e0(Build.MODEL);
        device.f0(Build.ID);
        V(device);
        if (z10 && this.f31072e.isCollectAdditionalContext()) {
            Y(device, z11);
        }
        device.i0(E());
        try {
            Object obj = this.f31069b.get().get("emulator");
            if (obj != null) {
                device.p0((Boolean) obj);
            }
        } catch (Throwable th2) {
            this.f31072e.getLogger().b(SentryLevel.ERROR, "Error getting emulator.", th2);
        }
        DisplayMetrics v10 = v();
        if (v10 != null) {
            device.o0(Integer.valueOf(v10.widthPixels));
            device.n0(Integer.valueOf(v10.heightPixels));
            device.l0(Float.valueOf(v10.density));
            device.m0(Integer.valueOf(v10.densityDpi));
        }
        device.P(q());
        device.r0(G());
        if (device.J() == null) {
            device.Y(t());
        }
        Locale locale = Locale.getDefault();
        if (device.K() == null) {
            device.Z(locale.getLanguage());
        }
        if (device.L() == null) {
            device.a0(locale.toString());
        }
        List<Integer> c10 = e.a().c();
        if (!c10.isEmpty()) {
            device.k0(Double.valueOf(((Integer) Collections.max(c10)).doubleValue()));
            device.j0(Integer.valueOf(c10.size()));
        }
        return device;
    }

    private String t() {
        try {
            return r0.a(this.f31068a);
        } catch (Throwable th2) {
            this.f31072e.getLogger().b(SentryLevel.ERROR, "Error getting installationId.", th2);
            return null;
        }
    }

    private String u() {
        if (this.f31070c.d() >= 17) {
            return Settings.Global.getString(this.f31068a.getContentResolver(), "device_name");
        }
        return null;
    }

    private DisplayMetrics v() {
        try {
            return this.f31068a.getResources().getDisplayMetrics();
        } catch (Throwable th2) {
            this.f31072e.getLogger().b(SentryLevel.ERROR, "Error getting DisplayMetrics.", th2);
            return null;
        }
    }

    private File[] w() {
        if (this.f31070c.d() >= 19) {
            return this.f31068a.getExternalFilesDirs((String) null);
        }
        File externalFilesDir = this.f31068a.getExternalFilesDir((String) null);
        if (externalFilesDir == null) {
            return null;
        }
        return new File[]{externalFilesDir};
    }

    private File x(File file) {
        String str;
        File[] w10 = w();
        if (w10 != null) {
            if (file != null) {
                str = file.getAbsolutePath();
            } else {
                str = null;
            }
            for (File file2 : w10) {
                if (file2 != null && (str == null || str.isEmpty() || !file2.getAbsolutePath().contains(str))) {
                    return file2;
                }
            }
        } else {
            this.f31072e.getLogger().c(SentryLevel.INFO, "Not possible to read getExternalFilesDirs", new Object[0]);
        }
        return null;
    }

    private StatFs y(File file) {
        if (!M()) {
            File x10 = x(file);
            if (x10 != null) {
                return new StatFs(x10.getPath());
            }
            this.f31072e.getLogger().c(SentryLevel.INFO, "Not possible to read external files directory", new Object[0]);
            return null;
        }
        this.f31072e.getLogger().c(SentryLevel.INFO, "External storage is not mounted or emulated.", new Object[0]);
        return null;
    }

    private String z() {
        try {
            return Build.MODEL.split(" ", -1)[0];
        } catch (Throwable th2) {
            this.f31072e.getLogger().b(SentryLevel.ERROR, "Error getting device family.", th2);
            return null;
        }
    }

    public p3 a(p3 p3Var, w wVar) {
        boolean d02 = d0(p3Var, wVar);
        if (d02) {
            S(p3Var, wVar);
            c0(p3Var, wVar);
        }
        W(p3Var, true, d02);
        return p3Var;
    }

    public v b(v vVar, w wVar) {
        boolean d02 = d0(vVar, wVar);
        if (d02) {
            S(vVar, wVar);
        }
        W(vVar, false, d02);
        return vVar;
    }

    public x r() {
        x xVar = new x();
        xVar.p(t());
        return xVar;
    }

    n0(Context context, i0 i0Var, j jVar, SentryAndroidOptions sentryAndroidOptions) {
        this.f31068a = (Context) l.c(context, "The application context is required.");
        this.f31070c = (i0) l.c(i0Var, "The BuildInfoProvider is required.");
        this.f31071d = (j) l.c(jVar, "The RootChecker is required.");
        this.f31072e = (SentryAndroidOptions) l.c(sentryAndroidOptions, "The options object is required.");
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
        this.f31069b = newSingleThreadExecutor.submit(new l0(this));
        newSingleThreadExecutor.submit(new m0());
        newSingleThreadExecutor.shutdown();
    }
}
