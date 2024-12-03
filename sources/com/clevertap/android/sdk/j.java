package com.clevertap.android.sdk;

import android.app.Activity;
import android.location.Location;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import org.json.b;

public class j extends h {
    private static int A = 0;
    private static int B = 0;

    /* renamed from: y  reason: collision with root package name */
    private static boolean f10564y = false;

    /* renamed from: z  reason: collision with root package name */
    private static WeakReference<Activity> f10565z;

    /* renamed from: a  reason: collision with root package name */
    private long f10566a = 0;

    /* renamed from: b  reason: collision with root package name */
    private boolean f10567b = false;

    /* renamed from: c  reason: collision with root package name */
    private final Object f10568c = new Object();

    /* renamed from: d  reason: collision with root package name */
    private String f10569d = null;

    /* renamed from: e  reason: collision with root package name */
    private int f10570e = 0;

    /* renamed from: f  reason: collision with root package name */
    private boolean f10571f = false;

    /* renamed from: g  reason: collision with root package name */
    private boolean f10572g = false;

    /* renamed from: h  reason: collision with root package name */
    private boolean f10573h = false;

    /* renamed from: i  reason: collision with root package name */
    private int f10574i = 0;

    /* renamed from: j  reason: collision with root package name */
    private boolean f10575j = false;

    /* renamed from: k  reason: collision with root package name */
    private boolean f10576k = false;

    /* renamed from: l  reason: collision with root package name */
    private boolean f10577l = false;

    /* renamed from: m  reason: collision with root package name */
    private boolean f10578m;

    /* renamed from: n  reason: collision with root package name */
    private int f10579n = 0;

    /* renamed from: o  reason: collision with root package name */
    private Location f10580o = null;

    /* renamed from: p  reason: collision with root package name */
    private boolean f10581p;

    /* renamed from: q  reason: collision with root package name */
    private String f10582q;

    /* renamed from: r  reason: collision with root package name */
    private final Object f10583r = new Object();

    /* renamed from: s  reason: collision with root package name */
    private HashMap<String, Integer> f10584s = new HashMap<>();

    /* renamed from: t  reason: collision with root package name */
    private long f10585t = 0;

    /* renamed from: u  reason: collision with root package name */
    private String f10586u = null;

    /* renamed from: v  reason: collision with root package name */
    private String f10587v = null;

    /* renamed from: w  reason: collision with root package name */
    private String f10588w = null;

    /* renamed from: x  reason: collision with root package name */
    private b f10589x = null;

    public static void H(int i10) {
        A = i10;
    }

    public static void I(boolean z10) {
        f10564y = z10;
    }

    public static void N(Activity activity) {
        if (activity == null) {
            f10565z = null;
        } else if (!activity.getLocalClassName().contains("InAppNotificationActivity")) {
            f10565z = new WeakReference<>(activity);
        }
    }

    static void T(int i10) {
        B = i10;
    }

    public static int e() {
        return A;
    }

    public static Activity i() {
        WeakReference<Activity> weakReference = f10565z;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public static String j() {
        Activity i10 = i();
        if (i10 != null) {
            return i10.getLocalClassName();
        }
        return null;
    }

    static int m() {
        return B;
    }

    static void w() {
        A++;
    }

    public static boolean x() {
        return f10564y;
    }

    public boolean A() {
        boolean z10;
        synchronized (this.f10583r) {
            z10 = this.f10571f;
        }
        return z10;
    }

    public boolean B() {
        return this.f10572g;
    }

    public boolean C() {
        return this.f10573h;
    }

    public boolean D() {
        return this.f10575j;
    }

    public boolean E() {
        return this.f10577l;
    }

    public boolean F() {
        return this.f10581p;
    }

    public boolean G() {
        return this.f10578m;
    }

    public void J(long j10) {
        this.f10566a = j10;
    }

    /* access modifiers changed from: package-private */
    public void K(boolean z10) {
        synchronized (this.f10568c) {
            this.f10567b = z10;
        }
    }

    public void L(boolean z10) {
        this.f10576k = z10;
    }

    /* access modifiers changed from: package-private */
    public synchronized void M(String str) {
        if (this.f10588w == null) {
            this.f10588w = str;
        }
    }

    /* access modifiers changed from: package-private */
    public void O(int i10) {
        this.f10570e = i10;
    }

    public void P(boolean z10) {
        synchronized (this.f10583r) {
            this.f10571f = z10;
        }
    }

    public void Q(boolean z10) {
        this.f10572g = z10;
    }

    /* access modifiers changed from: package-private */
    public void R(boolean z10) {
        this.f10573h = z10;
    }

    public void S(int i10) {
        this.f10574i = i10;
    }

    /* access modifiers changed from: package-private */
    public void U(boolean z10) {
        this.f10575j = z10;
    }

    /* access modifiers changed from: package-private */
    public void V(String str) {
        this.f10582q = str;
    }

    /* access modifiers changed from: package-private */
    public void W(int i10) {
        this.f10579n = i10;
    }

    public void X(boolean z10) {
        this.f10577l = z10;
    }

    /* access modifiers changed from: package-private */
    public synchronized void Y(String str) {
        if (this.f10587v == null) {
            this.f10587v = str;
        }
    }

    public void Z(boolean z10) {
        this.f10578m = z10;
    }

    /* access modifiers changed from: package-private */
    public synchronized void a() {
        this.f10588w = null;
    }

    /* access modifiers changed from: package-private */
    public void a0(long j10) {
        this.f10585t = j10;
    }

    /* access modifiers changed from: package-private */
    public synchronized void b() {
        this.f10587v = null;
    }

    /* access modifiers changed from: package-private */
    public synchronized void b0(String str) {
        if (this.f10586u == null) {
            this.f10586u = str;
        }
    }

    /* access modifiers changed from: package-private */
    public synchronized void c() {
        this.f10586u = null;
    }

    public synchronized void c0(b bVar) {
        if (this.f10589x == null) {
            this.f10589x = bVar;
        }
    }

    /* access modifiers changed from: package-private */
    public synchronized void d() {
        this.f10589x = null;
    }

    public HashMap<String, Integer> f() {
        return this.f10584s;
    }

    public long g() {
        return this.f10566a;
    }

    public synchronized String h() {
        return this.f10588w;
    }

    public int k() {
        return this.f10570e;
    }

    public int l() {
        return this.f10574i;
    }

    public String n() {
        return this.f10582q;
    }

    public int o() {
        return this.f10579n;
    }

    public Location p() {
        return this.f10580o;
    }

    public synchronized String q() {
        return this.f10587v;
    }

    public long r() {
        return this.f10585t;
    }

    public String s() {
        return this.f10569d;
    }

    public synchronized String t() {
        return this.f10586u;
    }

    public synchronized b u() {
        return this.f10589x;
    }

    public boolean v() {
        return this.f10570e > 0;
    }

    public boolean y() {
        boolean z10;
        synchronized (this.f10568c) {
            z10 = this.f10567b;
        }
        return z10;
    }

    public boolean z() {
        return this.f10576k;
    }
}
