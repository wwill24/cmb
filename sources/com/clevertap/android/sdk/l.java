package com.clevertap.android.sdk;

import android.annotation.SuppressLint;
import android.app.UiModeManager;
import android.app.usage.UsageStatsManager;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.graphics.Insets;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.view.WindowInsets$Type;
import android.view.WindowManager;
import android.view.WindowMetrics;
import androidx.core.app.j0;
import com.clevertap.android.sdk.task.Task;
import i4.s;
import i4.x;
import java.util.ArrayList;
import java.util.UUID;
import java.util.concurrent.Callable;
import org.apache.commons.cli.HelpFormatter;
import org.jivesoftware.smackx.csi.packet.ClientStateIndication;
import p4.g;

public class l {

    /* renamed from: m  reason: collision with root package name */
    static int f10610m = -1;

    /* renamed from: a  reason: collision with root package name */
    private final Object f10611a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private boolean f10612b = false;

    /* renamed from: c  reason: collision with root package name */
    private d f10613c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final CleverTapInstanceConfig f10614d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final Context f10615e;

    /* renamed from: f  reason: collision with root package name */
    private final Object f10616f = new Object();

    /* renamed from: g  reason: collision with root package name */
    private boolean f10617g = false;

    /* renamed from: h  reason: collision with root package name */
    private String f10618h = null;

    /* renamed from: i  reason: collision with root package name */
    private String f10619i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f10620j = false;

    /* renamed from: k  reason: collision with root package name */
    private final j f10621k;

    /* renamed from: l  reason: collision with root package name */
    private final ArrayList<w4.b> f10622l = new ArrayList<>();

    class a implements Callable<Void> {
        a() {
        }

        /* renamed from: a */
        public Void call() throws Exception {
            d unused = l.this.w();
            return null;
        }
    }

    class b implements u4.d<Void> {
        b() {
        }

        /* renamed from: a */
        public void onSuccess(Void voidR) {
            l.this.s().t(l.this.f10614d.e() + ":async_deviceID", "DeviceID initialized successfully!" + Thread.currentThread());
            CleverTapAPI.F(l.this.f10615e, l.this.f10614d).j(l.this.x());
        }
    }

    class c implements Callable<Void> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f10625a;

        c(String str) {
            this.f10625a = str;
        }

        /* renamed from: a */
        public Void call() throws Exception {
            l.this.P(this.f10625a);
            return null;
        }
    }

    private class d {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public final String f10627a = r();
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public final int f10628b = s();
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public final String f10629c = t();
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public final String f10630d = u();
        /* access modifiers changed from: private */

        /* renamed from: e  reason: collision with root package name */
        public final int f10631e = v();
        /* access modifiers changed from: private */

        /* renamed from: f  reason: collision with root package name */
        public final double f10632f = w();

        /* renamed from: g  reason: collision with root package name */
        private final int f10633g = x();
        /* access modifiers changed from: private */

        /* renamed from: h  reason: collision with root package name */
        public final String f10634h = y();
        /* access modifiers changed from: private */

        /* renamed from: i  reason: collision with root package name */
        public final String f10635i = z();
        /* access modifiers changed from: private */

        /* renamed from: j  reason: collision with root package name */
        public final String f10636j = A();
        /* access modifiers changed from: private */

        /* renamed from: k  reason: collision with root package name */
        public final boolean f10637k = B();
        /* access modifiers changed from: private */

        /* renamed from: l  reason: collision with root package name */
        public final String f10638l = C();
        /* access modifiers changed from: private */

        /* renamed from: m  reason: collision with root package name */
        public final String f10639m = D();
        /* access modifiers changed from: private */

        /* renamed from: n  reason: collision with root package name */
        public final int f10640n = E();
        /* access modifiers changed from: private */

        /* renamed from: o  reason: collision with root package name */
        public final String f10641o = F();
        /* access modifiers changed from: private */

        /* renamed from: p  reason: collision with root package name */
        public final double f10642p = G();

        /* renamed from: q  reason: collision with root package name */
        private final int f10643q = H();
        /* access modifiers changed from: private */

        /* renamed from: r  reason: collision with root package name */
        public String f10644r;

        d() {
            if (Build.VERSION.SDK_INT >= 28) {
                this.f10644r = q();
            }
        }

        @SuppressLint({"MissingPermission"})
        private String A() {
            return x.l(l.this.f10615e);
        }

        private boolean B() {
            try {
                return j0.b(l.this.f10615e).a();
            } catch (RuntimeException e10) {
                p.a("Runtime exception caused when checking whether notification are enabled or not");
                e10.printStackTrace();
                return true;
            }
        }

        private String C() {
            return "Android";
        }

        private String D() {
            return Build.VERSION.RELEASE;
        }

        private int E() {
            return BuildConfig.VERSION_CODE;
        }

        private String F() {
            try {
                return l.this.f10615e.getPackageManager().getPackageInfo(l.this.f10615e.getPackageName(), 0).versionName;
            } catch (PackageManager.NameNotFoundException unused) {
                p.a("Unable to get app version");
                return null;
            }
        }

        private double G() {
            float f10;
            int i10;
            WindowManager windowManager = (WindowManager) l.this.f10615e.getSystemService("window");
            if (windowManager == null) {
                return 0.0d;
            }
            if (Build.VERSION.SDK_INT >= 30) {
                WindowMetrics a10 = windowManager.getCurrentWindowMetrics();
                Configuration configuration = l.this.f10615e.getResources().getConfiguration();
                Insets a11 = a10.getWindowInsets().getInsetsIgnoringVisibility(WindowInsets$Type.systemGestures());
                i10 = (a10.getBounds().width() - a11.right) - a11.left;
                f10 = (float) configuration.densityDpi;
            } else {
                DisplayMetrics displayMetrics = new DisplayMetrics();
                windowManager.getDefaultDisplay().getMetrics(displayMetrics);
                i10 = displayMetrics.widthPixels;
                f10 = displayMetrics.xdpi;
            }
            return I((double) (((float) i10) / f10));
        }

        private int H() {
            WindowManager windowManager = (WindowManager) l.this.f10615e.getSystemService("window");
            if (windowManager == null) {
                return 0;
            }
            if (Build.VERSION.SDK_INT >= 30) {
                WindowMetrics a10 = windowManager.getCurrentWindowMetrics();
                Insets a11 = a10.getWindowInsets().getInsetsIgnoringVisibility(WindowInsets$Type.systemGestures());
                return (a10.getBounds().width() - a11.right) - a11.left;
            }
            DisplayMetrics displayMetrics = new DisplayMetrics();
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            return displayMetrics.widthPixels;
        }

        private double I(double d10) {
            return ((double) Math.round(d10 * 100.0d)) / 100.0d;
        }

        private String q() {
            int a10 = ((UsageStatsManager) l.this.f10615e.getSystemService("usagestats")).getAppStandbyBucket();
            if (a10 == 10) {
                return ClientStateIndication.Active.ELEMENT;
            }
            if (a10 == 20) {
                return "working_set";
            }
            if (a10 == 30) {
                return "frequent";
            }
            if (a10 == 40) {
                return "rare";
            }
            if (a10 != 45) {
                return "";
            }
            return "restricted";
        }

        private String r() {
            if (l.this.f10615e.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le")) {
                return "ble";
            }
            if (l.this.f10615e.getPackageManager().hasSystemFeature("android.hardware.bluetooth")) {
                return "classic";
            }
            return "none";
        }

        private int s() {
            try {
                return l.this.f10615e.getPackageManager().getPackageInfo(l.this.f10615e.getPackageName(), 0).versionCode;
            } catch (PackageManager.NameNotFoundException unused) {
                p.a("Unable to get app build");
                return 0;
            }
        }

        private String t() {
            try {
                TelephonyManager telephonyManager = (TelephonyManager) l.this.f10615e.getSystemService("phone");
                if (telephonyManager != null) {
                    return telephonyManager.getNetworkOperatorName();
                }
                return null;
            } catch (Exception unused) {
                return null;
            }
        }

        private String u() {
            try {
                TelephonyManager telephonyManager = (TelephonyManager) l.this.f10615e.getSystemService("phone");
                if (telephonyManager != null) {
                    return telephonyManager.getSimCountryIso();
                }
                return "";
            } catch (Throwable unused) {
                return "";
            }
        }

        private int v() {
            WindowManager windowManager = (WindowManager) l.this.f10615e.getSystemService("window");
            if (windowManager == null) {
                return 0;
            }
            if (Build.VERSION.SDK_INT >= 30) {
                return l.this.f10615e.getResources().getConfiguration().densityDpi;
            }
            DisplayMetrics displayMetrics = new DisplayMetrics();
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            return displayMetrics.densityDpi;
        }

        private double w() {
            float f10;
            int i10;
            WindowManager windowManager = (WindowManager) l.this.f10615e.getSystemService("window");
            if (windowManager == null) {
                return 0.0d;
            }
            if (Build.VERSION.SDK_INT >= 30) {
                WindowMetrics a10 = windowManager.getCurrentWindowMetrics();
                Configuration configuration = l.this.f10615e.getResources().getConfiguration();
                Insets a11 = a10.getWindowInsets().getInsetsIgnoringVisibility(WindowInsets$Type.systemGestures());
                i10 = (a10.getBounds().height() - a11.top) - a11.bottom;
                f10 = (float) configuration.densityDpi;
            } else {
                DisplayMetrics displayMetrics = new DisplayMetrics();
                windowManager.getDefaultDisplay().getMetrics(displayMetrics);
                i10 = displayMetrics.heightPixels;
                f10 = displayMetrics.ydpi;
            }
            return I((double) (((float) i10) / f10));
        }

        private int x() {
            WindowManager windowManager = (WindowManager) l.this.f10615e.getSystemService("window");
            if (windowManager == null) {
                return 0;
            }
            if (Build.VERSION.SDK_INT >= 30) {
                WindowMetrics a10 = windowManager.getCurrentWindowMetrics();
                Insets a11 = a10.getWindowInsets().getInsetsIgnoringVisibility(WindowInsets$Type.systemGestures());
                return (a10.getBounds().height() - a11.top) - a11.bottom;
            }
            DisplayMetrics displayMetrics = new DisplayMetrics();
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            return displayMetrics.heightPixels;
        }

        private String y() {
            return Build.MANUFACTURER;
        }

        private String z() {
            return Build.MODEL.replace(y(), "");
        }
    }

    l(Context context, CleverTapInstanceConfig cleverTapInstanceConfig, String str, j jVar) {
        this.f10615e = context;
        this.f10614d = cleverTapInstanceConfig;
        this.f10619i = null;
        this.f10621k = jVar;
        U(str);
        p s10 = s();
        s10.t(cleverTapInstanceConfig.e() + ":async_deviceID", "DeviceInfo() called");
    }

    private String A() {
        return s.i(this.f10615e, B(), (String) null);
    }

    private String B() {
        return "fallbackId:" + this.f10614d.e();
    }

    /* access modifiers changed from: private */
    public void P(String str) {
        p s10 = s();
        s10.t(this.f10614d.e() + ":async_deviceID", "Called initDeviceID()");
        if (this.f10614d.k()) {
            if (str == null) {
                this.f10614d.n().l(W(18, new String[0]));
            }
        } else if (str != null) {
            this.f10614d.n().l(W(19, new String[0]));
        }
        p s11 = s();
        s11.t(this.f10614d.e() + ":async_deviceID", "Calling _getDeviceID");
        String a10 = a();
        p s12 = s();
        s12.t(this.f10614d.e() + ":async_deviceID", "Called _getDeviceID");
        if (a10 != null && a10.trim().length() > 2) {
            s().t(this.f10614d.e(), "CleverTap ID already present for profile");
            if (str != null) {
                s().m(this.f10614d.e(), W(20, a10, str));
            }
        } else if (this.f10614d.k()) {
            i(str);
        } else if (!this.f10614d.z()) {
            p s13 = s();
            s13.t(this.f10614d.e() + ":async_deviceID", "Calling generateDeviceID()");
            k();
            p s14 = s();
            s14.t(this.f10614d.e() + ":async_deviceID", "Called generateDeviceID()");
        } else {
            g();
            k();
            p s15 = s();
            s15.t(this.f10614d.e() + ":async_deviceID", "initDeviceID() done executing!");
        }
    }

    private String W(int i10, String... strArr) {
        w4.b b10 = w4.c.b(514, i10, strArr);
        this.f10622l.add(b10);
        return b10.b();
    }

    private void X() {
        s.r(this.f10615e, y());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0022, code lost:
        return r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String a() {
        /*
            r4 = this;
            java.lang.Object r0 = r4.f10616f
            monitor-enter(r0)
            com.clevertap.android.sdk.CleverTapInstanceConfig r1 = r4.f10614d     // Catch:{ all -> 0x002f }
            boolean r1 = r1.t()     // Catch:{ all -> 0x002f }
            r2 = 0
            if (r1 == 0) goto L_0x0023
            android.content.Context r1 = r4.f10615e     // Catch:{ all -> 0x002f }
            java.lang.String r3 = r4.y()     // Catch:{ all -> 0x002f }
            java.lang.String r1 = com.clevertap.android.sdk.s.i(r1, r3, r2)     // Catch:{ all -> 0x002f }
            if (r1 == 0) goto L_0x0019
            goto L_0x0021
        L_0x0019:
            android.content.Context r1 = r4.f10615e     // Catch:{ all -> 0x002f }
            java.lang.String r3 = "deviceId"
            java.lang.String r1 = com.clevertap.android.sdk.s.i(r1, r3, r2)     // Catch:{ all -> 0x002f }
        L_0x0021:
            monitor-exit(r0)     // Catch:{ all -> 0x002f }
            return r1
        L_0x0023:
            android.content.Context r1 = r4.f10615e     // Catch:{ all -> 0x002f }
            java.lang.String r3 = r4.y()     // Catch:{ all -> 0x002f }
            java.lang.String r1 = com.clevertap.android.sdk.s.i(r1, r3, r2)     // Catch:{ all -> 0x002f }
            monitor-exit(r0)     // Catch:{ all -> 0x002f }
            return r1
        L_0x002f:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x002f }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.clevertap.android.sdk.l.a():java.lang.String");
    }

    private synchronized void b0() {
        if (A() == null) {
            synchronized (this.f10616f) {
                String str = "__i" + UUID.randomUUID().toString().replace(HelpFormatter.DEFAULT_OPT_PREFIX, "");
                if (str.trim().length() > 2) {
                    c0(str);
                } else {
                    s().t(this.f10614d.e(), "Unable to generate fallback error device ID");
                }
            }
        }
    }

    private void c0(String str) {
        p s10 = s();
        String e10 = this.f10614d.e();
        s10.t(e10, "Updating the fallback id - " + str);
        s.p(this.f10615e, B(), str);
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:598)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    private synchronized void g() {
        /*
            r8 = this;
            monitor-enter(r8)
            com.clevertap.android.sdk.p r0 = r8.s()     // Catch:{ all -> 0x017f }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x017f }
            r1.<init>()     // Catch:{ all -> 0x017f }
            com.clevertap.android.sdk.CleverTapInstanceConfig r2 = r8.f10614d     // Catch:{ all -> 0x017f }
            java.lang.String r2 = r2.e()     // Catch:{ all -> 0x017f }
            r1.append(r2)     // Catch:{ all -> 0x017f }
            java.lang.String r2 = ":async_deviceID"
            r1.append(r2)     // Catch:{ all -> 0x017f }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x017f }
            java.lang.String r2 = "fetchGoogleAdID() called!"
            r0.t(r1, r2)     // Catch:{ all -> 0x017f }
            java.lang.String r0 = r8.C()     // Catch:{ all -> 0x017f }
            if (r0 != 0) goto L_0x017d
            boolean r0 = r8.f10612b     // Catch:{ all -> 0x017f }
            if (r0 != 0) goto L_0x017d
            r0 = 0
            r1 = 1
            r8.f10612b = r1     // Catch:{ all -> 0x00cd }
            java.lang.Class<com.google.android.gms.ads.identifier.AdvertisingIdClient> r2 = com.google.android.gms.ads.identifier.AdvertisingIdClient.class
            java.lang.String r3 = "getAdvertisingIdInfo"
            java.lang.Class[] r4 = new java.lang.Class[r1]     // Catch:{ all -> 0x00cd }
            java.lang.Class<android.content.Context> r5 = android.content.Context.class
            r6 = 0
            r4[r6] = r5     // Catch:{ all -> 0x00cd }
            java.lang.reflect.Method r2 = r2.getMethod(r3, r4)     // Catch:{ all -> 0x00cd }
            java.lang.Object[] r3 = new java.lang.Object[r1]     // Catch:{ all -> 0x00cd }
            android.content.Context r4 = r8.f10615e     // Catch:{ all -> 0x00cd }
            r3[r6] = r4     // Catch:{ all -> 0x00cd }
            java.lang.Object r2 = r2.invoke(r0, r3)     // Catch:{ all -> 0x00cd }
            java.lang.Class r3 = r2.getClass()     // Catch:{ all -> 0x00cd }
            java.lang.String r4 = "isLimitAdTrackingEnabled"
            java.lang.Class[] r5 = new java.lang.Class[r6]     // Catch:{ all -> 0x00cd }
            java.lang.reflect.Method r3 = r3.getMethod(r4, r5)     // Catch:{ all -> 0x00cd }
            java.lang.Object[] r4 = new java.lang.Object[r6]     // Catch:{ all -> 0x00cd }
            java.lang.Object r3 = r3.invoke(r2, r4)     // Catch:{ all -> 0x00cd }
            java.lang.Boolean r3 = (java.lang.Boolean) r3     // Catch:{ all -> 0x00cd }
            java.lang.Object r4 = r8.f10611a     // Catch:{ all -> 0x00cd }
            monitor-enter(r4)     // Catch:{ all -> 0x00cd }
            if (r3 == 0) goto L_0x006a
            boolean r3 = r3.booleanValue()     // Catch:{ all -> 0x0068 }
            if (r3 == 0) goto L_0x006a
            goto L_0x006b
        L_0x0068:
            r1 = move-exception
            goto L_0x00cb
        L_0x006a:
            r1 = r6
        L_0x006b:
            r8.f10620j = r1     // Catch:{ all -> 0x0068 }
            com.clevertap.android.sdk.p r1 = r8.s()     // Catch:{ all -> 0x0068 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0068 }
            r3.<init>()     // Catch:{ all -> 0x0068 }
            com.clevertap.android.sdk.CleverTapInstanceConfig r5 = r8.f10614d     // Catch:{ all -> 0x0068 }
            java.lang.String r5 = r5.e()     // Catch:{ all -> 0x0068 }
            r3.append(r5)     // Catch:{ all -> 0x0068 }
            java.lang.String r5 = ":async_deviceID"
            r3.append(r5)     // Catch:{ all -> 0x0068 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0068 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0068 }
            r5.<init>()     // Catch:{ all -> 0x0068 }
            java.lang.String r7 = "limitAdTracking = "
            r5.append(r7)     // Catch:{ all -> 0x0068 }
            boolean r7 = r8.f10620j     // Catch:{ all -> 0x0068 }
            r5.append(r7)     // Catch:{ all -> 0x0068 }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x0068 }
            r1.t(r3, r5)     // Catch:{ all -> 0x0068 }
            boolean r1 = r8.f10620j     // Catch:{ all -> 0x0068 }
            if (r1 == 0) goto L_0x00b4
            com.clevertap.android.sdk.p r1 = r8.s()     // Catch:{ all -> 0x0068 }
            com.clevertap.android.sdk.CleverTapInstanceConfig r2 = r8.f10614d     // Catch:{ all -> 0x0068 }
            java.lang.String r2 = r2.e()     // Catch:{ all -> 0x0068 }
            java.lang.String r3 = "Device user has opted out of sharing Advertising ID, falling back to random UUID for CleverTap ID generation"
            r1.f(r2, r3)     // Catch:{ all -> 0x0068 }
            monitor-exit(r4)     // Catch:{ all -> 0x0068 }
            monitor-exit(r8)
            return
        L_0x00b4:
            monitor-exit(r4)     // Catch:{ all -> 0x0068 }
            java.lang.Class r1 = r2.getClass()     // Catch:{ all -> 0x00cd }
            java.lang.String r3 = "getId"
            java.lang.Class[] r4 = new java.lang.Class[r6]     // Catch:{ all -> 0x00cd }
            java.lang.reflect.Method r1 = r1.getMethod(r3, r4)     // Catch:{ all -> 0x00cd }
            java.lang.Object[] r3 = new java.lang.Object[r6]     // Catch:{ all -> 0x00cd }
            java.lang.Object r1 = r1.invoke(r2, r3)     // Catch:{ all -> 0x00cd }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ all -> 0x00cd }
            r0 = r1
            goto L_0x0124
        L_0x00cb:
            monitor-exit(r4)     // Catch:{ all -> 0x0068 }
            throw r1     // Catch:{ all -> 0x00cd }
        L_0x00cd:
            r1 = move-exception
            java.lang.Throwable r2 = r1.getCause()     // Catch:{ all -> 0x017f }
            if (r2 == 0) goto L_0x0102
            com.clevertap.android.sdk.p r2 = r8.s()     // Catch:{ all -> 0x017f }
            com.clevertap.android.sdk.CleverTapInstanceConfig r3 = r8.f10614d     // Catch:{ all -> 0x017f }
            java.lang.String r3 = r3.e()     // Catch:{ all -> 0x017f }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x017f }
            r4.<init>()     // Catch:{ all -> 0x017f }
            java.lang.String r5 = "Failed to get Advertising ID: "
            r4.append(r5)     // Catch:{ all -> 0x017f }
            java.lang.String r5 = r1.toString()     // Catch:{ all -> 0x017f }
            r4.append(r5)     // Catch:{ all -> 0x017f }
            java.lang.Throwable r1 = r1.getCause()     // Catch:{ all -> 0x017f }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x017f }
            r4.append(r1)     // Catch:{ all -> 0x017f }
            java.lang.String r1 = r4.toString()     // Catch:{ all -> 0x017f }
            r2.t(r3, r1)     // Catch:{ all -> 0x017f }
            goto L_0x0124
        L_0x0102:
            com.clevertap.android.sdk.p r2 = r8.s()     // Catch:{ all -> 0x017f }
            com.clevertap.android.sdk.CleverTapInstanceConfig r3 = r8.f10614d     // Catch:{ all -> 0x017f }
            java.lang.String r3 = r3.e()     // Catch:{ all -> 0x017f }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x017f }
            r4.<init>()     // Catch:{ all -> 0x017f }
            java.lang.String r5 = "Failed to get Advertising ID: "
            r4.append(r5)     // Catch:{ all -> 0x017f }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x017f }
            r4.append(r1)     // Catch:{ all -> 0x017f }
            java.lang.String r1 = r4.toString()     // Catch:{ all -> 0x017f }
            r2.t(r3, r1)     // Catch:{ all -> 0x017f }
        L_0x0124:
            if (r0 == 0) goto L_0x015d
            java.lang.String r1 = r0.trim()     // Catch:{ all -> 0x017f }
            int r1 = r1.length()     // Catch:{ all -> 0x017f }
            r2 = 2
            if (r1 <= r2) goto L_0x015d
            java.lang.Object r1 = r8.f10611a     // Catch:{ all -> 0x017f }
            monitor-enter(r1)     // Catch:{ all -> 0x017f }
            java.lang.String r2 = "00000000"
            boolean r2 = r0.contains(r2)     // Catch:{ all -> 0x015a }
            if (r2 == 0) goto L_0x014e
            com.clevertap.android.sdk.p r0 = r8.s()     // Catch:{ all -> 0x015a }
            com.clevertap.android.sdk.CleverTapInstanceConfig r2 = r8.f10614d     // Catch:{ all -> 0x015a }
            java.lang.String r2 = r2.e()     // Catch:{ all -> 0x015a }
            java.lang.String r3 = "Device user has opted out of sharing Advertising ID, falling back to random UUID for CleverTap ID generation"
            r0.f(r2, r3)     // Catch:{ all -> 0x015a }
            monitor-exit(r1)     // Catch:{ all -> 0x015a }
            monitor-exit(r8)
            return
        L_0x014e:
            java.lang.String r2 = "-"
            java.lang.String r3 = ""
            java.lang.String r0 = r0.replace(r2, r3)     // Catch:{ all -> 0x015a }
            r8.f10618h = r0     // Catch:{ all -> 0x015a }
            monitor-exit(r1)     // Catch:{ all -> 0x015a }
            goto L_0x015d
        L_0x015a:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x015a }
            throw r0     // Catch:{ all -> 0x017f }
        L_0x015d:
            com.clevertap.android.sdk.p r0 = r8.s()     // Catch:{ all -> 0x017f }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x017f }
            r1.<init>()     // Catch:{ all -> 0x017f }
            com.clevertap.android.sdk.CleverTapInstanceConfig r2 = r8.f10614d     // Catch:{ all -> 0x017f }
            java.lang.String r2 = r2.e()     // Catch:{ all -> 0x017f }
            r1.append(r2)     // Catch:{ all -> 0x017f }
            java.lang.String r2 = ":async_deviceID"
            r1.append(r2)     // Catch:{ all -> 0x017f }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x017f }
            java.lang.String r2 = "fetchGoogleAdID() done executing!"
            r0.t(r1, r2)     // Catch:{ all -> 0x017f }
        L_0x017d:
            monitor-exit(r8)
            return
        L_0x017f:
            r0 = move-exception
            monitor-exit(r8)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.clevertap.android.sdk.l.g():void");
    }

    private synchronized void k() {
        String str;
        String l10;
        s().t(this.f10614d.e() + ":async_deviceID", "generateDeviceID() called!");
        String C = C();
        if (C != null) {
            str = "__g" + C;
        } else {
            synchronized (this.f10616f) {
                l10 = l();
            }
            str = l10;
        }
        j(str);
        s().t(this.f10614d.e() + ":async_deviceID", "generateDeviceID() done executing!");
    }

    private String l() {
        return "__" + UUID.randomUUID().toString().replace(HelpFormatter.DEFAULT_OPT_PREFIX, "");
    }

    public static int n(Context context) {
        return context.getApplicationInfo().icon;
    }

    /* access modifiers changed from: private */
    public p s() {
        return this.f10614d.n();
    }

    /* access modifiers changed from: private */
    public d w() {
        if (this.f10613c == null) {
            this.f10613c = new d();
        }
        return this.f10613c;
    }

    private String y() {
        return "deviceId:" + this.f10614d.e();
    }

    public static int z(Context context) {
        int i10;
        if (f10610m == -1) {
            try {
                if (((UiModeManager) context.getSystemService("uimode")).getCurrentModeType() == 4) {
                    f10610m = 3;
                    return 3;
                }
            } catch (Exception e10) {
                p.a("Failed to decide whether device is a TV!");
                e10.printStackTrace();
            }
            try {
                if (context.getResources().getBoolean(s.ctIsTablet)) {
                    i10 = 2;
                } else {
                    i10 = 1;
                }
                f10610m = i10;
            } catch (Exception e11) {
                p.a("Failed to decide whether device is a smart phone or tablet!");
                e11.printStackTrace();
                f10610m = 0;
            }
        }
        return f10610m;
    }

    public String C() {
        String str;
        synchronized (this.f10611a) {
            str = this.f10618h;
        }
        return str;
    }

    public double D() {
        return w().f10632f;
    }

    public String E() {
        return this.f10619i;
    }

    public String F() {
        return w().f10634h;
    }

    public String G() {
        return w().f10635i;
    }

    public String H() {
        return w().f10636j;
    }

    public boolean I() {
        return w().f10637k;
    }

    public String J() {
        return w().f10638l;
    }

    public String K() {
        return w().f10639m;
    }

    public int L() {
        return w().f10640n;
    }

    public ArrayList<w4.b> M() {
        ArrayList<w4.b> arrayList = (ArrayList) this.f10622l.clone();
        this.f10622l.clear();
        return arrayList;
    }

    public String N() {
        return w().f10641o;
    }

    public double O() {
        return w().f10642p;
    }

    @SuppressLint({"MissingPermission"})
    public Boolean Q() {
        BluetoothAdapter defaultAdapter;
        try {
            if (this.f10615e.getPackageManager().checkPermission("android.permission.BLUETOOTH", this.f10615e.getPackageName()) != 0 || (defaultAdapter = BluetoothAdapter.getDefaultAdapter()) == null) {
                return null;
            }
            return Boolean.valueOf(defaultAdapter.isEnabled());
        } catch (Throwable unused) {
            return null;
        }
    }

    public boolean R() {
        return x() != null && x().startsWith("__i");
    }

    public boolean S() {
        boolean z10;
        synchronized (this.f10611a) {
            z10 = this.f10620j;
        }
        return z10;
    }

    public Boolean T() {
        ConnectivityManager connectivityManager;
        if (this.f10615e.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") != 0 || (connectivityManager = (ConnectivityManager) this.f10615e.getSystemService("connectivity")) == null) {
            return null;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        boolean z10 = true;
        if (activeNetworkInfo == null || activeNetworkInfo.getType() != 1 || !activeNetworkInfo.isConnected()) {
            z10 = false;
        }
        return Boolean.valueOf(z10);
    }

    /* access modifiers changed from: package-private */
    public void U(String str) {
        com.clevertap.android.sdk.task.a.a(this.f10614d).a().f("getDeviceCachedInfo", new a());
        Task a10 = com.clevertap.android.sdk.task.a.a(this.f10614d).a();
        a10.e(new b());
        a10.f("initDeviceID", new c(str));
    }

    /* access modifiers changed from: package-private */
    public String V() {
        String x10 = x();
        if (x10 == null) {
            return null;
        }
        return "OptOut:" + x10;
    }

    public void Y() {
        String V = V();
        if (V == null) {
            this.f10614d.n().t(this.f10614d.e(), "Unable to set current user OptOut state from storage: storage key is null");
            return;
        }
        boolean b10 = s.b(this.f10615e, this.f10614d, V);
        this.f10621k.P(b10);
        p n10 = this.f10614d.n();
        String e10 = this.f10614d.e();
        n10.t(e10, "Set current user OptOut state from storage to: " + b10 + " for key: " + V);
    }

    /* access modifiers changed from: package-private */
    public void Z() {
        boolean b10 = s.b(this.f10615e, this.f10614d, "NetworkInfo");
        p n10 = this.f10614d.n();
        String e10 = this.f10614d.e();
        n10.t(e10, "Setting device network info reporting state from storage to " + b10);
        this.f10617g = b10;
    }

    /* access modifiers changed from: package-private */
    public void a0(String str) {
        this.f10619i = str;
    }

    public void h() {
        j(l());
    }

    public void i(String str) {
        if (x.y(str)) {
            p s10 = s();
            String e10 = this.f10614d.e();
            s10.m(e10, "Setting CleverTap ID to custom CleverTap ID : " + str);
            j("__h" + str);
            return;
        }
        b0();
        X();
        s().m(this.f10614d.e(), W(21, str, A()));
    }

    @SuppressLint({"CommitPrefEdits"})
    public void j(String str) {
        p s10 = s();
        String e10 = this.f10614d.e();
        s10.t(e10, "Force updating the device ID to " + str);
        synchronized (this.f10616f) {
            s.p(this.f10615e, y(), str);
        }
    }

    public String m() {
        return w().f10644r;
    }

    public org.json.b o() {
        boolean z10 = false;
        try {
            if (C() != null) {
                z10 = new g(this.f10615e, this.f10614d, this).b();
            }
            return v4.a.b(this, this.f10621k.p(), this.f10617g, z10);
        } catch (Throwable th2) {
            this.f10614d.n().u(this.f10614d.e(), "Failed to construct App Launched event", th2);
            return new org.json.b();
        }
    }

    public String p() {
        return w().f10627a;
    }

    public int q() {
        return w().f10628b;
    }

    public String r() {
        return w().f10629c;
    }

    public Context t() {
        return this.f10615e;
    }

    public String u() {
        return w().f10630d;
    }

    public int v() {
        return w().f10631e;
    }

    public String x() {
        return a() != null ? a() : A();
    }
}
