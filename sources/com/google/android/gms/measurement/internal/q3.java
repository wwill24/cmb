package com.google.android.gms.measurement.internal;

import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.internal.measurement.zzpe;
import org.apache.commons.cli.HelpFormatter;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

public final class q3 extends o5 {
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public char f40159c = 0;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public long f40160d = -1;

    /* renamed from: e  reason: collision with root package name */
    private String f40161e;

    /* renamed from: f  reason: collision with root package name */
    private final o3 f40162f = new o3(this, 6, false, false);

    /* renamed from: g  reason: collision with root package name */
    private final o3 f40163g = new o3(this, 6, true, false);

    /* renamed from: h  reason: collision with root package name */
    private final o3 f40164h = new o3(this, 6, false, true);

    /* renamed from: i  reason: collision with root package name */
    private final o3 f40165i = new o3(this, 5, false, false);

    /* renamed from: j  reason: collision with root package name */
    private final o3 f40166j = new o3(this, 5, true, false);

    /* renamed from: k  reason: collision with root package name */
    private final o3 f40167k = new o3(this, 5, false, true);

    /* renamed from: l  reason: collision with root package name */
    private final o3 f40168l = new o3(this, 4, false, false);

    /* renamed from: m  reason: collision with root package name */
    private final o3 f40169m = new o3(this, 3, false, false);

    /* renamed from: n  reason: collision with root package name */
    private final o3 f40170n = new o3(this, 2, false, false);

    q3(u4 u4Var) {
        super(u4Var);
    }

    static String A(boolean z10, String str, Object obj, Object obj2, Object obj3) {
        String B = B(z10, obj);
        String B2 = B(z10, obj2);
        String B3 = B(z10, obj3);
        StringBuilder sb2 = new StringBuilder();
        String str2 = "";
        if (str == null) {
            str = str2;
        }
        if (!TextUtils.isEmpty(str)) {
            sb2.append(str);
            str2 = ": ";
        }
        String str3 = ", ";
        if (!TextUtils.isEmpty(B)) {
            sb2.append(str2);
            sb2.append(B);
            str2 = str3;
        }
        if (!TextUtils.isEmpty(B2)) {
            sb2.append(str2);
            sb2.append(B2);
        } else {
            str3 = str2;
        }
        if (!TextUtils.isEmpty(B3)) {
            sb2.append(str3);
            sb2.append(B3);
        }
        return sb2.toString();
    }

    static String B(boolean z10, Object obj) {
        String str;
        String className;
        String str2 = "";
        if (obj == null) {
            return str2;
        }
        if (obj instanceof Integer) {
            obj = Long.valueOf((long) ((Integer) obj).intValue());
        }
        int i10 = 0;
        if (obj instanceof Long) {
            if (!z10) {
                return obj.toString();
            }
            Long l10 = (Long) obj;
            if (Math.abs(l10.longValue()) < 100) {
                return obj.toString();
            }
            char charAt = obj.toString().charAt(0);
            String valueOf = String.valueOf(Math.abs(l10.longValue()));
            long round = Math.round(Math.pow(10.0d, (double) (valueOf.length() - 1)));
            long round2 = Math.round(Math.pow(10.0d, (double) valueOf.length()) - 4.0d);
            StringBuilder sb2 = new StringBuilder();
            if (charAt == '-') {
                str2 = HelpFormatter.DEFAULT_OPT_PREFIX;
            }
            sb2.append(str2);
            sb2.append(round);
            sb2.append("...");
            sb2.append(str2);
            sb2.append(round2);
            return sb2.toString();
        } else if (obj instanceof Boolean) {
            return obj.toString();
        } else {
            if (obj instanceof Throwable) {
                Throwable th2 = (Throwable) obj;
                if (z10) {
                    str = th2.getClass().getName();
                } else {
                    str = th2.toString();
                }
                StringBuilder sb3 = new StringBuilder(str);
                String C = C(u4.class.getCanonicalName());
                StackTraceElement[] stackTrace = th2.getStackTrace();
                int length = stackTrace.length;
                while (true) {
                    if (i10 >= length) {
                        break;
                    }
                    StackTraceElement stackTraceElement = stackTrace[i10];
                    if (!stackTraceElement.isNativeMethod() && (className = stackTraceElement.getClassName()) != null && C(className).equals(C)) {
                        sb3.append(": ");
                        sb3.append(stackTraceElement);
                        break;
                    }
                    i10++;
                }
                return sb3.toString();
            } else if (obj instanceof p3) {
                return ((p3) obj).f40131a;
            } else {
                if (z10) {
                    return HelpFormatter.DEFAULT_OPT_PREFIX;
                }
                return obj.toString();
            }
        }
    }

    static String C(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf != -1) {
            return str.substring(0, lastIndexOf);
        }
        zzpe.zzc();
        if (((Boolean) g3.A0.a((Object) null)).booleanValue()) {
            return "";
        }
        return str;
    }

    protected static Object z(String str) {
        if (str == null) {
            return null;
        }
        return new p3(str);
    }

    /* access modifiers changed from: protected */
    @EnsuresNonNull({"logTagDoNotUseDirectly"})
    public final String D() {
        String str;
        synchronized (this) {
            if (this.f40161e == null) {
                if (this.f40059a.Q() != null) {
                    this.f40161e = this.f40059a.Q();
                } else {
                    this.f40161e = this.f40059a.z().w();
                }
            }
            p.k(this.f40161e);
            str = this.f40161e;
        }
        return str;
    }

    /* access modifiers changed from: protected */
    public final void G(int i10, boolean z10, boolean z11, String str, Object obj, Object obj2, Object obj3) {
        if (!z10 && Log.isLoggable(D(), i10)) {
            Log.println(i10, D(), A(false, str, obj, obj2, obj3));
        }
        if (!z11 && i10 >= 5) {
            p.k(str);
            s4 G = this.f40059a.G();
            if (G == null) {
                Log.println(6, D(), "Scheduler not set. Not logging error/warn");
            } else if (!G.n()) {
                Log.println(6, D(), "Scheduler not initialized. Not logging error/warn");
            } else {
                if (i10 >= 9) {
                    i10 = 8;
                }
                G.z(new n3(this, i10, str, obj, obj2, obj3));
            }
        }
    }

    /* access modifiers changed from: protected */
    public final boolean j() {
        return false;
    }

    public final o3 q() {
        return this.f40169m;
    }

    public final o3 r() {
        return this.f40162f;
    }

    public final o3 s() {
        return this.f40164h;
    }

    public final o3 t() {
        return this.f40163g;
    }

    public final o3 u() {
        return this.f40168l;
    }

    public final o3 v() {
        return this.f40170n;
    }

    public final o3 w() {
        return this.f40165i;
    }

    public final o3 x() {
        return this.f40167k;
    }

    public final o3 y() {
        return this.f40166j;
    }
}
