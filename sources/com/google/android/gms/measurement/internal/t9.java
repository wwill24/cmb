package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.content.pm.Signature;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.text.TextUtils;
import com.coffeemeetsbagel.models.util.DateUtils;
import com.google.android.gms.common.e;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.internal.measurement.zzcf;
import com.google.android.gms.internal.measurement.zzpq;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.ByteArrayInputStream;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicLong;
import javax.security.auth.x500.X500Principal;
import me.g;
import net.bytebuddy.utility.JavaConstant;
import oe.d;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.jivesoftware.smack.sm.packet.StreamManagement;
import org.jivesoftware.smack.util.StringUtils;
import org.jivesoftware.smackx.csi.packet.ClientStateIndication;
import we.a0;
import we.n;
import we.q;
import we.r;

public final class t9 extends o5 {

    /* renamed from: g  reason: collision with root package name */
    private static final String[] f40285g = {"firebase_", "google_", "ga_"};

    /* renamed from: h  reason: collision with root package name */
    private static final String[] f40286h = {"_err"};

    /* renamed from: c  reason: collision with root package name */
    private SecureRandom f40287c;

    /* renamed from: d  reason: collision with root package name */
    private final AtomicLong f40288d = new AtomicLong(0);

    /* renamed from: e  reason: collision with root package name */
    private int f40289e;

    /* renamed from: f  reason: collision with root package name */
    private Integer f40290f = null;

    t9(u4 u4Var) {
        super(u4Var);
    }

    static boolean Y(String str) {
        return !TextUtils.isEmpty(str) && str.startsWith(JavaConstant.Dynamic.DEFAULT_NAME);
    }

    static boolean Z(String str) {
        p.g(str);
        if (str.charAt(0) != '_' || str.equals("_ep")) {
            return true;
        }
        return false;
    }

    static boolean a0(Context context) {
        ActivityInfo receiverInfo;
        p.k(context);
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null || (receiverInfo = packageManager.getReceiverInfo(new ComponentName(context, "com.google.android.gms.measurement.AppMeasurementReceiver"), 0)) == null || !receiverInfo.enabled) {
                return false;
            }
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
        }
    }

    static boolean b0(Context context, boolean z10) {
        p.k(context);
        return k0(context, "com.google.android.gms.measurement.AppMeasurementJobService");
    }

    public static boolean c0(String str) {
        return !f40286h[0].equals(str);
    }

    static final boolean f0(Bundle bundle, int i10) {
        if (bundle == null || bundle.getLong("_err") != 0) {
            return false;
        }
        bundle.putLong("_err", (long) i10);
        return true;
    }

    static final boolean g0(String str) {
        p.k(str);
        return str.matches("^(1:\\d+:android:[a-f0-9]+|ca-app-pub-.*)$");
    }

    private final int h0(String str) {
        if ("_ldl".equals(str)) {
            this.f40059a.z();
            return 2048;
        } else if ("_id".equals(str)) {
            this.f40059a.z();
            return 256;
        } else if ("_lgclid".equals(str)) {
            this.f40059a.z();
            return 100;
        } else {
            this.f40059a.z();
            return 36;
        }
    }

    private final Object i0(int i10, Object obj, boolean z10, boolean z11) {
        long j10;
        if (obj == null) {
            return null;
        }
        if ((obj instanceof Long) || (obj instanceof Double)) {
            return obj;
        }
        if (obj instanceof Integer) {
            return Long.valueOf((long) ((Integer) obj).intValue());
        }
        if (obj instanceof Byte) {
            return Long.valueOf((long) ((Byte) obj).byteValue());
        }
        if (obj instanceof Short) {
            return Long.valueOf((long) ((Short) obj).shortValue());
        }
        if (obj instanceof Boolean) {
            if (true != ((Boolean) obj).booleanValue()) {
                j10 = 0;
            } else {
                j10 = 1;
            }
            return Long.valueOf(j10);
        } else if (obj instanceof Float) {
            return Double.valueOf(((Float) obj).doubleValue());
        } else {
            if ((obj instanceof String) || (obj instanceof Character) || (obj instanceof CharSequence)) {
                return r(obj.toString(), i10, z10);
            }
            if (!z11 || (!(obj instanceof Bundle[]) && !(obj instanceof Parcelable[]))) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (Parcelable parcelable : (Parcelable[]) obj) {
                if (parcelable instanceof Bundle) {
                    Bundle w02 = w0((Bundle) parcelable);
                    if (!w02.isEmpty()) {
                        arrayList.add(w02);
                    }
                }
            }
            return arrayList.toArray(new Bundle[arrayList.size()]);
        }
    }

    private static boolean j0(String str, String[] strArr) {
        p.k(strArr);
        for (String a10 : strArr) {
            if (a0.a(str, a10)) {
                return true;
            }
        }
        return false;
    }

    private static boolean k0(Context context, String str) {
        ServiceInfo serviceInfo;
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null || (serviceInfo = packageManager.getServiceInfo(new ComponentName(context, str), 0)) == null || !serviceInfo.enabled) {
                return false;
            }
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
        }
    }

    static long s0(byte[] bArr) {
        boolean z10;
        p.k(bArr);
        int length = bArr.length;
        int i10 = 0;
        if (length > 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        p.o(z10);
        long j10 = 0;
        while (true) {
            length--;
            if (length < 0 || length < bArr.length - 8) {
                return j10;
            }
            j10 += (((long) bArr[length]) & 255) << i10;
            i10 += 8;
        }
        return j10;
    }

    static MessageDigest t() {
        int i10 = 0;
        while (i10 < 2) {
            try {
                MessageDigest instance = MessageDigest.getInstance(StringUtils.MD5);
                if (instance != null) {
                    return instance;
                }
                i10++;
            } catch (NoSuchAlgorithmException unused) {
            }
        }
        return null;
    }

    public static ArrayList v(List list) {
        if (list == null) {
            return new ArrayList(0);
        }
        ArrayList arrayList = new ArrayList(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            zzac zzac = (zzac) it.next();
            Bundle bundle = new Bundle();
            bundle.putString("app_id", zzac.f40479a);
            bundle.putString(FirebaseAnalytics.Param.ORIGIN, zzac.f40480b);
            bundle.putLong("creation_timestamp", zzac.f40482d);
            bundle.putString("name", zzac.f40481c.f40500b);
            n.b(bundle, p.k(zzac.f40481c.S()));
            bundle.putBoolean(ClientStateIndication.Active.ELEMENT, zzac.f40483e);
            String str = zzac.f40484f;
            if (str != null) {
                bundle.putString("trigger_event_name", str);
            }
            zzau zzau = zzac.f40485g;
            if (zzau != null) {
                bundle.putString("timed_out_event_name", zzau.f40491a);
                zzas zzas = zzau.f40492b;
                if (zzas != null) {
                    bundle.putBundle("timed_out_event_params", zzas.Y());
                }
            }
            bundle.putLong("trigger_timeout", zzac.f40486h);
            zzau zzau2 = zzac.f40487j;
            if (zzau2 != null) {
                bundle.putString("triggered_event_name", zzau2.f40491a);
                zzas zzas2 = zzau2.f40492b;
                if (zzas2 != null) {
                    bundle.putBundle("triggered_event_params", zzas2.Y());
                }
            }
            bundle.putLong("triggered_timestamp", zzac.f40481c.f40501c);
            bundle.putLong("time_to_live", zzac.f40488k);
            zzau zzau3 = zzac.f40489l;
            if (zzau3 != null) {
                bundle.putString("expired_event_name", zzau3.f40491a);
                zzas zzas3 = zzau3.f40492b;
                if (zzas3 != null) {
                    bundle.putBundle("expired_event_params", zzas3.Y());
                }
            }
            arrayList.add(bundle);
        }
        return arrayList;
    }

    public static void y(z6 z6Var, Bundle bundle, boolean z10) {
        if (!(bundle == null || z6Var == null)) {
            if (!bundle.containsKey("_sc") || z10) {
                String str = z6Var.f40463a;
                if (str != null) {
                    bundle.putString("_sn", str);
                } else {
                    bundle.remove("_sn");
                }
                String str2 = z6Var.f40464b;
                if (str2 != null) {
                    bundle.putString("_sc", str2);
                } else {
                    bundle.remove("_sc");
                }
                bundle.putLong("_si", z6Var.f40465c);
                return;
            }
            z10 = false;
        }
        if (bundle != null && z6Var == null && z10) {
            bundle.remove("_sn");
            bundle.remove("_sc");
            bundle.remove("_si");
        }
    }

    /* access modifiers changed from: package-private */
    public final void A(Parcelable[] parcelableArr, int i10, boolean z10) {
        p.k(parcelableArr);
        for (Bundle bundle : parcelableArr) {
            int i11 = 0;
            for (String str : new TreeSet(bundle.keySet())) {
                if (Z(str) && !j0(str, q.f42132d) && (i11 = i11 + 1) > i10) {
                    if (z10) {
                        this.f40059a.d().s().c("Param can't contain more than " + i10 + " item-scoped custom parameters", this.f40059a.D().e(str), this.f40059a.D().b(bundle));
                        f0(bundle, 28);
                    } else {
                        this.f40059a.d().s().c("Param cannot contain item-scoped custom parameters", this.f40059a.D().e(str), this.f40059a.D().b(bundle));
                        f0(bundle, 23);
                    }
                    bundle.remove(str);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void B(r3 r3Var, int i10) {
        int i11 = 0;
        for (String str : new TreeSet(r3Var.f40216d.keySet())) {
            if (Z(str) && (i11 = i11 + 1) > i10) {
                this.f40059a.d().s().c("Event can't contain more than " + i10 + " params", this.f40059a.D().d(r3Var.f40213a), this.f40059a.D().b(r3Var.f40216d));
                f0(r3Var.f40216d, 5);
                r3Var.f40216d.remove(str);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void C(s9 s9Var, String str, int i10, String str2, String str3, int i11) {
        Bundle bundle = new Bundle();
        f0(bundle, i10);
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            bundle.putString(str2, str3);
        }
        if (i10 == 6 || i10 == 7 || i10 == 2) {
            bundle.putLong("_el", (long) i11);
        }
        s9Var.a(str, "_err", bundle);
    }

    /* access modifiers changed from: package-private */
    public final void D(Bundle bundle, String str, Object obj) {
        String str2;
        if (bundle != null) {
            if (obj instanceof Long) {
                bundle.putLong(str, ((Long) obj).longValue());
            } else if (obj instanceof String) {
                bundle.putString(str, String.valueOf(obj));
            } else if (obj instanceof Double) {
                bundle.putDouble(str, ((Double) obj).doubleValue());
            } else if (obj instanceof Bundle[]) {
                bundle.putParcelableArray(str, (Bundle[]) obj);
            } else if (str != null) {
                if (obj != null) {
                    str2 = obj.getClass().getSimpleName();
                } else {
                    str2 = null;
                }
                this.f40059a.d().x().c("Not putting event parameter. Invalid value type. name, type", this.f40059a.D().e(str), str2);
            }
        }
    }

    public final void E(zzcf zzcf, boolean z10) {
        Bundle bundle = new Bundle();
        bundle.putBoolean(StreamManagement.AckRequest.ELEMENT, z10);
        try {
            zzcf.zze(bundle);
        } catch (RemoteException e10) {
            this.f40059a.d().w().b("Error returning boolean value to wrapper", e10);
        }
    }

    public final void F(zzcf zzcf, ArrayList arrayList) {
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList(StreamManagement.AckRequest.ELEMENT, arrayList);
        try {
            zzcf.zze(bundle);
        } catch (RemoteException e10) {
            this.f40059a.d().w().b("Error returning bundle list to wrapper", e10);
        }
    }

    public final void G(zzcf zzcf, Bundle bundle) {
        try {
            zzcf.zze(bundle);
        } catch (RemoteException e10) {
            this.f40059a.d().w().b("Error returning bundle value to wrapper", e10);
        }
    }

    public final void H(zzcf zzcf, byte[] bArr) {
        Bundle bundle = new Bundle();
        bundle.putByteArray(StreamManagement.AckRequest.ELEMENT, bArr);
        try {
            zzcf.zze(bundle);
        } catch (RemoteException e10) {
            this.f40059a.d().w().b("Error returning byte array to wrapper", e10);
        }
    }

    public final void I(zzcf zzcf, int i10) {
        Bundle bundle = new Bundle();
        bundle.putInt(StreamManagement.AckRequest.ELEMENT, i10);
        try {
            zzcf.zze(bundle);
        } catch (RemoteException e10) {
            this.f40059a.d().w().b("Error returning int value to wrapper", e10);
        }
    }

    public final void J(zzcf zzcf, long j10) {
        Bundle bundle = new Bundle();
        bundle.putLong(StreamManagement.AckRequest.ELEMENT, j10);
        try {
            zzcf.zze(bundle);
        } catch (RemoteException e10) {
            this.f40059a.d().w().b("Error returning long value to wrapper", e10);
        }
    }

    public final void K(zzcf zzcf, String str) {
        Bundle bundle = new Bundle();
        bundle.putString(StreamManagement.AckRequest.ELEMENT, str);
        try {
            zzcf.zze(bundle);
        } catch (RemoteException e10) {
            this.f40059a.d().w().b("Error returning string value to wrapper", e10);
        }
    }

    /* access modifiers changed from: package-private */
    public final void L(String str, String str2, String str3, Bundle bundle, List list, boolean z10) {
        int i10;
        int i11;
        String str4;
        int i12;
        int i13;
        String str5;
        int i14;
        String str6;
        int i15;
        String str7 = str2;
        Bundle bundle2 = bundle;
        List list2 = list;
        if (bundle2 != null) {
            g z11 = this.f40059a.z();
            zzpq.zzc();
            String str8 = null;
            if (!z11.f40059a.z().B((String) null, g3.B0) || !z11.f40059a.N().X(231100000, true)) {
                i10 = 0;
            } else {
                i10 = 35;
            }
            int i16 = 0;
            for (String str9 : new TreeSet(bundle.keySet())) {
                if (list2 == null || !list2.contains(str9)) {
                    if (!z10) {
                        i15 = o0(str9);
                    } else {
                        i15 = 0;
                    }
                    if (i15 == 0) {
                        i15 = n0(str9);
                    }
                    i11 = i15;
                } else {
                    i11 = 0;
                }
                if (i11 != 0) {
                    if (i11 == 3) {
                        str6 = str9;
                    } else {
                        str6 = str8;
                    }
                    x(bundle, i11, str9, str9, str6);
                    bundle2.remove(str9);
                    i12 = i10;
                    str4 = str8;
                } else {
                    if (V(bundle2.get(str9))) {
                        this.f40059a.d().x().d("Nested Bundle parameters are not allowed; discarded. event name, param name, child param name", str7, str3, str9);
                        i14 = 22;
                        str5 = str9;
                        i13 = i10;
                    } else {
                        String str10 = str3;
                        str5 = str9;
                        i13 = i10;
                        i14 = O(str, str2, str9, bundle2.get(str9), bundle, list, z10, false);
                    }
                    if (i14 != 0 && !"_ev".equals(str5)) {
                        x(bundle, i14, str5, str5, bundle2.get(str5));
                        bundle2.remove(str5);
                    } else if (Z(str5) && !j0(str5, q.f42132d)) {
                        int i17 = i16 + 1;
                        if (!X(231100000, true)) {
                            this.f40059a.d().s().c("Item array not supported on client's version of Google Play Services (Android Only)", this.f40059a.D().d(str7), this.f40059a.D().b(bundle2));
                            f0(bundle2, 23);
                            bundle2.remove(str5);
                            i12 = i13;
                        } else {
                            i12 = i13;
                            if (i17 > i12) {
                                zzpq.zzc();
                                str4 = null;
                                if (this.f40059a.z().B((String) null, g3.B0)) {
                                    this.f40059a.d().s().c("Item can't contain more than " + i12 + " item-scoped custom params", this.f40059a.D().d(str7), this.f40059a.D().b(bundle2));
                                    f0(bundle2, 28);
                                    bundle2.remove(str5);
                                } else {
                                    this.f40059a.d().s().c("Item cannot contain custom parameters", this.f40059a.D().d(str7), this.f40059a.D().b(bundle2));
                                    f0(bundle2, 23);
                                    bundle2.remove(str5);
                                }
                                i16 = i17;
                            }
                        }
                        str4 = null;
                        i16 = i17;
                    }
                    i12 = i13;
                    str4 = null;
                }
                i10 = i12;
                str8 = str4;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean M(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            if (g0(str)) {
                return true;
            }
            if (this.f40059a.q()) {
                this.f40059a.d().s().b("Invalid google_app_id. Firebase Analytics disabled. See https://goo.gl/NAOOOI. provided id", q3.z(str));
            }
            return false;
        } else if (TextUtils.isEmpty(str2)) {
            if (this.f40059a.q()) {
                this.f40059a.d().s().a("Missing google_app_id. Firebase Analytics disabled. See https://goo.gl/NAOOOI");
            }
            return false;
        } else if (g0(str2)) {
            return true;
        } else {
            this.f40059a.d().s().b("Invalid admob_app_id. Analytics disabled.", q3.z(str2));
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean N(String str, int i10, String str2) {
        if (str2 == null) {
            this.f40059a.d().s().b("Name is required and can't be null. Type", str);
            return false;
        } else if (str2.codePointCount(0, str2.length()) <= i10) {
            return true;
        } else {
            this.f40059a.d().s().d("Name is too long. Type, maximum supported length, name", str, Integer.valueOf(i10), str2);
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00ba  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00c2  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00cf A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00d0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int O(java.lang.String r14, java.lang.String r15, java.lang.String r16, java.lang.Object r17, android.os.Bundle r18, java.util.List r19, boolean r20, boolean r21) {
        /*
            r13 = this;
            r7 = r13
            r8 = r16
            r0 = r17
            r1 = r18
            r13.h()
            boolean r2 = r13.V(r0)
            java.lang.String r3 = "param"
            r4 = 17
            r5 = 0
            if (r2 == 0) goto L_0x00ac
            if (r21 == 0) goto L_0x00a9
            java.lang.String[] r2 = we.q.f42131c
            boolean r2 = j0(r8, r2)
            if (r2 != 0) goto L_0x0022
            r0 = 20
            return r0
        L_0x0022:
            com.google.android.gms.measurement.internal.u4 r2 = r7.f40059a
            com.google.android.gms.measurement.internal.g8 r2 = r2.L()
            r2.h()
            r2.i()
            boolean r6 = r2.B()
            if (r6 != 0) goto L_0x0035
            goto L_0x0047
        L_0x0035:
            com.google.android.gms.measurement.internal.u4 r2 = r2.f40059a
            com.google.android.gms.measurement.internal.t9 r2 = r2.N()
            int r2 = r2.q0()
            r6 = 200900(0x310c4, float:2.81521E-40)
            if (r2 >= r6) goto L_0x0047
            r0 = 25
            return r0
        L_0x0047:
            com.google.android.gms.measurement.internal.u4 r2 = r7.f40059a
            r2.z()
            boolean r2 = r0 instanceof android.os.Parcelable[]
            if (r2 == 0) goto L_0x0055
            r6 = r0
            android.os.Parcelable[] r6 = (android.os.Parcelable[]) r6
            int r6 = r6.length
            goto L_0x0060
        L_0x0055:
            boolean r6 = r0 instanceof java.util.ArrayList
            if (r6 == 0) goto L_0x00ac
            r6 = r0
            java.util.ArrayList r6 = (java.util.ArrayList) r6
            int r6 = r6.size()
        L_0x0060:
            r9 = 200(0xc8, float:2.8E-43)
            if (r6 <= r9) goto L_0x00ac
            com.google.android.gms.measurement.internal.u4 r10 = r7.f40059a
            com.google.android.gms.measurement.internal.q3 r10 = r10.d()
            com.google.android.gms.measurement.internal.o3 r10 = r10.x()
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            java.lang.String r11 = "Parameter array is too long; discarded. Value kind, name, array length"
            r10.d(r11, r3, r8, r6)
            com.google.android.gms.measurement.internal.u4 r6 = r7.f40059a
            r6.z()
            if (r2 == 0) goto L_0x008e
            r2 = r0
            android.os.Parcelable[] r2 = (android.os.Parcelable[]) r2
            int r6 = r2.length
            if (r6 <= r9) goto L_0x00a7
            java.lang.Object[] r2 = java.util.Arrays.copyOf(r2, r9)
            android.os.Parcelable[] r2 = (android.os.Parcelable[]) r2
            r1.putParcelableArray(r8, r2)
            goto L_0x00a7
        L_0x008e:
            boolean r2 = r0 instanceof java.util.ArrayList
            if (r2 == 0) goto L_0x00a7
            r2 = r0
            java.util.ArrayList r2 = (java.util.ArrayList) r2
            int r6 = r2.size()
            if (r6 <= r9) goto L_0x00a7
            java.util.ArrayList r6 = new java.util.ArrayList
            java.util.List r2 = r2.subList(r5, r9)
            r6.<init>(r2)
            r1.putParcelableArrayList(r8, r6)
        L_0x00a7:
            r9 = r4
            goto L_0x00ad
        L_0x00a9:
            r0 = 21
            return r0
        L_0x00ac:
            r9 = r5
        L_0x00ad:
            boolean r1 = Y(r15)
            if (r1 != 0) goto L_0x00c2
            boolean r1 = Y(r16)
            if (r1 == 0) goto L_0x00ba
            goto L_0x00c2
        L_0x00ba:
            com.google.android.gms.measurement.internal.u4 r1 = r7.f40059a
            r1.z()
            r1 = 100
            goto L_0x00c9
        L_0x00c2:
            com.google.android.gms.measurement.internal.u4 r1 = r7.f40059a
            r1.z()
            r1 = 256(0x100, float:3.59E-43)
        L_0x00c9:
            boolean r1 = r13.Q(r3, r8, r1, r0)
            if (r1 == 0) goto L_0x00d0
            return r9
        L_0x00d0:
            if (r21 == 0) goto L_0x0160
            boolean r1 = r0 instanceof android.os.Bundle
            if (r1 == 0) goto L_0x00e7
            r4 = r0
            android.os.Bundle r4 = (android.os.Bundle) r4
            r0 = r13
            r1 = r14
            r2 = r15
            r3 = r16
            r5 = r19
            r6 = r20
            r0.L(r1, r2, r3, r4, r5, r6)
            goto L_0x015f
        L_0x00e7:
            boolean r1 = r0 instanceof android.os.Parcelable[]
            if (r1 == 0) goto L_0x011e
            r10 = r0
            android.os.Parcelable[] r10 = (android.os.Parcelable[]) r10
            int r11 = r10.length
            r12 = r5
        L_0x00f0:
            if (r12 >= r11) goto L_0x015f
            r0 = r10[r12]
            boolean r1 = r0 instanceof android.os.Bundle
            if (r1 != 0) goto L_0x010c
            com.google.android.gms.measurement.internal.u4 r1 = r7.f40059a
            com.google.android.gms.measurement.internal.q3 r1 = r1.d()
            com.google.android.gms.measurement.internal.o3 r1 = r1.x()
            java.lang.Class r0 = r0.getClass()
            java.lang.String r2 = "All Parcelable[] elements must be of type Bundle. Value type, name"
            r1.c(r2, r0, r8)
            goto L_0x0160
        L_0x010c:
            r4 = r0
            android.os.Bundle r4 = (android.os.Bundle) r4
            r0 = r13
            r1 = r14
            r2 = r15
            r3 = r16
            r5 = r19
            r6 = r20
            r0.L(r1, r2, r3, r4, r5, r6)
            int r12 = r12 + 1
            goto L_0x00f0
        L_0x011e:
            boolean r1 = r0 instanceof java.util.ArrayList
            if (r1 == 0) goto L_0x0160
            r10 = r0
            java.util.ArrayList r10 = (java.util.ArrayList) r10
            int r11 = r10.size()
            r12 = r5
        L_0x012a:
            if (r12 >= r11) goto L_0x015f
            java.lang.Object r0 = r10.get(r12)
            boolean r1 = r0 instanceof android.os.Bundle
            if (r1 != 0) goto L_0x014d
            com.google.android.gms.measurement.internal.u4 r1 = r7.f40059a
            com.google.android.gms.measurement.internal.q3 r1 = r1.d()
            com.google.android.gms.measurement.internal.o3 r1 = r1.x()
            if (r0 == 0) goto L_0x0145
            java.lang.Class r0 = r0.getClass()
            goto L_0x0147
        L_0x0145:
            java.lang.String r0 = "null"
        L_0x0147:
            java.lang.String r2 = "All ArrayList elements must be of type Bundle. Value type, name"
            r1.c(r2, r0, r8)
            goto L_0x0160
        L_0x014d:
            r4 = r0
            android.os.Bundle r4 = (android.os.Bundle) r4
            r0 = r13
            r1 = r14
            r2 = r15
            r3 = r16
            r5 = r19
            r6 = r20
            r0.L(r1, r2, r3, r4, r5, r6)
            int r12 = r12 + 1
            goto L_0x012a
        L_0x015f:
            return r9
        L_0x0160:
            r0 = 4
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.t9.O(java.lang.String, java.lang.String, java.lang.String, java.lang.Object, android.os.Bundle, java.util.List, boolean, boolean):int");
    }

    /* access modifiers changed from: package-private */
    public final boolean P(String str, String[] strArr, String[] strArr2, String str2) {
        if (str2 == null) {
            this.f40059a.d().s().b("Name is required and can't be null. Type", str);
            return false;
        }
        p.k(str2);
        String[] strArr3 = f40285g;
        for (int i10 = 0; i10 < 3; i10++) {
            if (str2.startsWith(strArr3[i10])) {
                this.f40059a.d().s().c("Name starts with reserved prefix. Type, name", str, str2);
                return false;
            }
        }
        if (strArr == null || !j0(str2, strArr)) {
            return true;
        }
        if (strArr2 != null && j0(str2, strArr2)) {
            return true;
        }
        this.f40059a.d().s().c("Name is reserved. Type, name", str, str2);
        return false;
    }

    /* access modifiers changed from: package-private */
    public final boolean Q(String str, String str2, int i10, Object obj) {
        if (obj != null && !(obj instanceof Long) && !(obj instanceof Float) && !(obj instanceof Integer) && !(obj instanceof Byte) && !(obj instanceof Short) && !(obj instanceof Boolean) && !(obj instanceof Double)) {
            if (!(obj instanceof String) && !(obj instanceof Character) && !(obj instanceof CharSequence)) {
                return false;
            }
            String obj2 = obj.toString();
            if (obj2.codePointCount(0, obj2.length()) > i10) {
                this.f40059a.d().x().d("Value is too long; discarded. Value kind, name, value length", str, str2, Integer.valueOf(obj2.length()));
                return false;
            }
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public final boolean R(String str, String str2) {
        if (str2 == null) {
            this.f40059a.d().s().b("Name is required and can't be null. Type", str);
            return false;
        } else if (str2.length() == 0) {
            this.f40059a.d().s().b("Name is required and can't be empty. Type", str);
            return false;
        } else {
            int codePointAt = str2.codePointAt(0);
            if (!Character.isLetter(codePointAt)) {
                if (codePointAt == 95) {
                    codePointAt = 95;
                } else {
                    this.f40059a.d().s().c("Name must start with a letter or _ (underscore). Type, name", str, str2);
                    return false;
                }
            }
            int length = str2.length();
            int charCount = Character.charCount(codePointAt);
            while (charCount < length) {
                int codePointAt2 = str2.codePointAt(charCount);
                if (codePointAt2 == 95 || Character.isLetterOrDigit(codePointAt2)) {
                    charCount += Character.charCount(codePointAt2);
                } else {
                    this.f40059a.d().s().c("Name must consist of letters, digits or _ (underscores). Type, name", str, str2);
                    return false;
                }
            }
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean S(String str, String str2) {
        if (str2 == null) {
            this.f40059a.d().s().b("Name is required and can't be null. Type", str);
            return false;
        } else if (str2.length() == 0) {
            this.f40059a.d().s().b("Name is required and can't be empty. Type", str);
            return false;
        } else {
            int codePointAt = str2.codePointAt(0);
            if (!Character.isLetter(codePointAt)) {
                this.f40059a.d().s().c("Name must start with a letter. Type, name", str, str2);
                return false;
            }
            int length = str2.length();
            int charCount = Character.charCount(codePointAt);
            while (charCount < length) {
                int codePointAt2 = str2.codePointAt(charCount);
                if (codePointAt2 == 95 || Character.isLetterOrDigit(codePointAt2)) {
                    charCount += Character.charCount(codePointAt2);
                } else {
                    this.f40059a.d().s().c("Name must consist of letters, digits or _ (underscores). Type, name", str, str2);
                    return false;
                }
            }
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean T(String str) {
        h();
        if (d.a(this.f40059a.c()).a(str) == 0) {
            return true;
        }
        this.f40059a.d().q().b("Permission not granted", str);
        return false;
    }

    /* access modifiers changed from: package-private */
    public final boolean U(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String u10 = this.f40059a.z().u();
        this.f40059a.b();
        return u10.equals(str);
    }

    /* access modifiers changed from: package-private */
    public final boolean V(Object obj) {
        return (obj instanceof Parcelable[]) || (obj instanceof ArrayList) || (obj instanceof Bundle);
    }

    /* access modifiers changed from: package-private */
    public final boolean W(Context context, String str) {
        Signature[] signatureArr;
        X500Principal x500Principal = new X500Principal("CN=Android Debug,O=Android,C=US");
        try {
            PackageInfo e10 = d.a(context).e(str, 64);
            if (e10 == null || (signatureArr = e10.signatures) == null || signatureArr.length <= 0) {
                return true;
            }
            return ((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(signatureArr[0].toByteArray()))).getSubjectX500Principal().equals(x500Principal);
        } catch (CertificateException e11) {
            this.f40059a.d().r().b("Error obtaining certificate", e11);
            return true;
        } catch (PackageManager.NameNotFoundException e12) {
            this.f40059a.d().r().b("Package name not found", e12);
            return true;
        }
    }

    public final boolean X(int i10, boolean z10) {
        Boolean J = this.f40059a.L().J();
        if (q0() >= i10 / 1000 || (J != null && !J.booleanValue())) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public final boolean d0(String str, String str2, String str3, String str4) {
        boolean isEmpty = TextUtils.isEmpty(str);
        boolean isEmpty2 = TextUtils.isEmpty(str2);
        if (!isEmpty && !isEmpty2) {
            p.k(str);
            if (!str.equals(str2)) {
                return true;
            }
            return false;
        } else if (!isEmpty || !isEmpty2) {
            if (!isEmpty) {
                if (TextUtils.isEmpty(str4)) {
                    return false;
                }
                if (TextUtils.isEmpty(str3) || !str3.equals(str4)) {
                    return true;
                }
                return false;
            } else if (TextUtils.isEmpty(str3) || !str3.equals(str4)) {
                return true;
            } else {
                return false;
            }
        } else if (TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4)) {
            if (!TextUtils.isEmpty(str4)) {
                return true;
            }
            return false;
        } else if (!str3.equals(str4)) {
            return true;
        } else {
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public final byte[] e0(Parcelable parcelable) {
        if (parcelable == null) {
            return null;
        }
        Parcel obtain = Parcel.obtain();
        try {
            parcelable.writeToParcel(obtain, 0);
            return obtain.marshall();
        } finally {
            obtain.recycle();
        }
    }

    /* access modifiers changed from: protected */
    public final void i() {
        h();
        SecureRandom secureRandom = new SecureRandom();
        long nextLong = secureRandom.nextLong();
        if (nextLong == 0) {
            nextLong = secureRandom.nextLong();
            if (nextLong == 0) {
                this.f40059a.d().w().a("Utils falling back to Random for random id");
            }
        }
        this.f40288d.set(nextLong);
    }

    /* access modifiers changed from: protected */
    public final boolean j() {
        return true;
    }

    /* access modifiers changed from: package-private */
    public final int l0(String str, Object obj) {
        boolean z10;
        if ("_ldl".equals(str)) {
            z10 = Q("user property referrer", str, h0(str), obj);
        } else {
            z10 = Q("user property", str, h0(str), obj);
        }
        if (z10) {
            return 0;
        }
        return 7;
    }

    /* access modifiers changed from: package-private */
    public final int m0(String str) {
        if (!R("event", str)) {
            return 2;
        }
        if (!P("event", we.p.f42125a, we.p.f42126b, str)) {
            return 13;
        }
        this.f40059a.z();
        if (!N("event", 40, str)) {
            return 2;
        }
        return 0;
    }

    /* access modifiers changed from: package-private */
    public final int n0(String str) {
        if (!R("event param", str)) {
            return 3;
        }
        if (!P("event param", (String[]) null, (String[]) null, str)) {
            return 14;
        }
        this.f40059a.z();
        if (!N("event param", 40, str)) {
            return 3;
        }
        return 0;
    }

    /* access modifiers changed from: package-private */
    public final Object o(String str, Object obj) {
        int i10 = 256;
        if ("_ev".equals(str)) {
            this.f40059a.z();
            return i0(256, obj, true, true);
        }
        if (Y(str)) {
            this.f40059a.z();
        } else {
            this.f40059a.z();
            i10 = 100;
        }
        return i0(i10, obj, false, true);
    }

    /* access modifiers changed from: package-private */
    public final int o0(String str) {
        if (!S("event param", str)) {
            return 3;
        }
        if (!P("event param", (String[]) null, (String[]) null, str)) {
            return 14;
        }
        this.f40059a.z();
        if (!N("event param", 40, str)) {
            return 3;
        }
        return 0;
    }

    /* access modifiers changed from: package-private */
    public final Object p(String str, Object obj) {
        if ("_ldl".equals(str)) {
            return i0(h0(str), obj, true, false);
        }
        return i0(h0(str), obj, false, false);
    }

    /* access modifiers changed from: package-private */
    public final int p0(String str) {
        if (!R("user property", str)) {
            return 6;
        }
        if (!P("user property", r.f42133a, (String[]) null, str)) {
            return 15;
        }
        this.f40059a.z();
        if (!N("user property", 24, str)) {
            return 6;
        }
        return 0;
    }

    /* access modifiers changed from: package-private */
    public final String q() {
        byte[] bArr = new byte[16];
        u().nextBytes(bArr);
        return String.format(Locale.US, "%032x", new Object[]{new BigInteger(1, bArr)});
    }

    @EnsuresNonNull({"this.apkVersion"})
    public final int q0() {
        if (this.f40290f == null) {
            this.f40290f = Integer.valueOf(com.google.android.gms.common.d.h().b(this.f40059a.c()) / 1000);
        }
        return this.f40290f.intValue();
    }

    public final String r(String str, int i10, boolean z10) {
        if (str == null) {
            return null;
        }
        if (str.codePointCount(0, str.length()) <= i10) {
            return str;
        }
        if (z10) {
            return String.valueOf(str.substring(0, str.offsetByCodePoints(0, i10))).concat("...");
        }
        return null;
    }

    public final int r0(int i10) {
        return com.google.android.gms.common.d.h().j(this.f40059a.c(), e.GOOGLE_PLAY_SERVICES_VERSION_CODE);
    }

    public final URL s(long j10, String str, String str2, long j11) {
        try {
            p.g(str2);
            p.g(str);
            String format2 = String.format("https://www.googleadservices.com/pagead/conversion/app/deeplink?id_type=adid&sdk_version=%s&rdid=%s&bundleid=%s&retry=%s", new Object[]{String.format("v%s.%s", new Object[]{79000L, Integer.valueOf(q0())}), str2, str, Long.valueOf(j11)});
            if (str.equals(this.f40059a.z().v())) {
                format2 = format2.concat("&ddl_test=1");
            }
            return new URL(format2);
        } catch (IllegalArgumentException | MalformedURLException e10) {
            this.f40059a.d().r().b("Failed to create BOW URL for Deferred Deep Link. exception", e10.getMessage());
            return null;
        }
    }

    public final long t0() {
        long andIncrement;
        long j10;
        if (this.f40288d.get() == 0) {
            synchronized (this.f40288d) {
                long nextLong = new Random(System.nanoTime() ^ this.f40059a.a().currentTimeMillis()).nextLong();
                int i10 = this.f40289e + 1;
                this.f40289e = i10;
                j10 = nextLong + ((long) i10);
            }
            return j10;
        }
        synchronized (this.f40288d) {
            this.f40288d.compareAndSet(-1, 1);
            andIncrement = this.f40288d.getAndIncrement();
        }
        return andIncrement;
    }

    /* access modifiers changed from: package-private */
    @EnsuresNonNull({"this.secureRandom"})
    public final SecureRandom u() {
        h();
        if (this.f40287c == null) {
            this.f40287c = new SecureRandom();
        }
        return this.f40287c;
    }

    public final long u0(long j10, long j11) {
        return (j10 + (j11 * DateUtils.MILLIS_IN_MINUTE)) / 86400000;
    }

    /* access modifiers changed from: package-private */
    public final Bundle v0(Uri uri, boolean z10) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        Uri uri2 = uri;
        if (uri2 != null) {
            try {
                if (uri.isHierarchical()) {
                    str8 = uri2.getQueryParameter("utm_campaign");
                    str7 = uri2.getQueryParameter("utm_source");
                    str6 = uri2.getQueryParameter("utm_medium");
                    str5 = uri2.getQueryParameter("gclid");
                    str4 = uri2.getQueryParameter("utm_id");
                    str3 = uri2.getQueryParameter("dclid");
                    str2 = uri2.getQueryParameter("srsltid");
                    if (z10) {
                        str = uri2.getQueryParameter("sfmc_id");
                    } else {
                        str = null;
                    }
                } else {
                    str8 = null;
                    str7 = null;
                    str6 = null;
                    str5 = null;
                    str4 = null;
                    str3 = null;
                    str2 = null;
                    str = null;
                }
                if (TextUtils.isEmpty(str8) && TextUtils.isEmpty(str7) && TextUtils.isEmpty(str6) && TextUtils.isEmpty(str5) && TextUtils.isEmpty(str4) && TextUtils.isEmpty(str3) && TextUtils.isEmpty(str2) && (!z10 || TextUtils.isEmpty(str))) {
                    return null;
                }
                Bundle bundle = new Bundle();
                if (!TextUtils.isEmpty(str8)) {
                    bundle.putString("campaign", str8);
                }
                if (!TextUtils.isEmpty(str7)) {
                    bundle.putString("source", str7);
                }
                if (!TextUtils.isEmpty(str6)) {
                    bundle.putString("medium", str6);
                }
                if (!TextUtils.isEmpty(str5)) {
                    bundle.putString("gclid", str5);
                }
                String queryParameter = uri2.getQueryParameter("utm_term");
                if (!TextUtils.isEmpty(queryParameter)) {
                    bundle.putString(FirebaseAnalytics.Param.TERM, queryParameter);
                }
                String queryParameter2 = uri2.getQueryParameter("utm_content");
                if (!TextUtils.isEmpty(queryParameter2)) {
                    bundle.putString("content", queryParameter2);
                }
                String queryParameter3 = uri2.getQueryParameter(FirebaseAnalytics.Param.ACLID);
                if (!TextUtils.isEmpty(queryParameter3)) {
                    bundle.putString(FirebaseAnalytics.Param.ACLID, queryParameter3);
                }
                String queryParameter4 = uri2.getQueryParameter(FirebaseAnalytics.Param.CP1);
                if (!TextUtils.isEmpty(queryParameter4)) {
                    bundle.putString(FirebaseAnalytics.Param.CP1, queryParameter4);
                }
                String queryParameter5 = uri2.getQueryParameter("anid");
                if (!TextUtils.isEmpty(queryParameter5)) {
                    bundle.putString("anid", queryParameter5);
                }
                if (!TextUtils.isEmpty(str4)) {
                    bundle.putString(FirebaseAnalytics.Param.CAMPAIGN_ID, str4);
                }
                if (!TextUtils.isEmpty(str3)) {
                    bundle.putString("dclid", str3);
                }
                String queryParameter6 = uri2.getQueryParameter("utm_source_platform");
                if (!TextUtils.isEmpty(queryParameter6)) {
                    bundle.putString(FirebaseAnalytics.Param.SOURCE_PLATFORM, queryParameter6);
                }
                String queryParameter7 = uri2.getQueryParameter("utm_creative_format");
                if (!TextUtils.isEmpty(queryParameter7)) {
                    bundle.putString(FirebaseAnalytics.Param.CREATIVE_FORMAT, queryParameter7);
                }
                String queryParameter8 = uri2.getQueryParameter("utm_marketing_tactic");
                if (!TextUtils.isEmpty(queryParameter8)) {
                    bundle.putString(FirebaseAnalytics.Param.MARKETING_TACTIC, queryParameter8);
                }
                if (!TextUtils.isEmpty(str2)) {
                    bundle.putString("srsltid", str2);
                }
                if (z10 && !TextUtils.isEmpty(str)) {
                    bundle.putString("sfmc_id", str);
                }
                return bundle;
            } catch (UnsupportedOperationException e10) {
                this.f40059a.d().w().b("Install referrer url isn't a hierarchical URI", e10);
                return null;
            }
        } else {
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public final void w(Bundle bundle, long j10) {
        long j11 = bundle.getLong("_et");
        if (j11 != 0) {
            this.f40059a.d().w().b("Params already contained engagement", Long.valueOf(j11));
        } else {
            j11 = 0;
        }
        bundle.putLong("_et", j10 + j11);
    }

    /* access modifiers changed from: package-private */
    public final Bundle w0(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        if (bundle != null) {
            for (String next : bundle.keySet()) {
                Object o10 = o(next, bundle.get(next));
                if (o10 == null) {
                    this.f40059a.d().x().b("Param value can't be null", this.f40059a.D().e(next));
                } else {
                    D(bundle2, next, o10);
                }
            }
        }
        return bundle2;
    }

    /* access modifiers changed from: package-private */
    public final void x(Bundle bundle, int i10, String str, String str2, Object obj) {
        if (f0(bundle, i10)) {
            this.f40059a.z();
            bundle.putString("_ev", r(str, 40, true));
            if (obj != null) {
                p.k(bundle);
                if ((obj instanceof String) || (obj instanceof CharSequence)) {
                    bundle.putLong("_el", (long) obj.toString().length());
                }
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v0, resolved type: java.lang.String} */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00c4  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0108 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.os.Bundle x0(java.lang.String r21, java.lang.String r22, android.os.Bundle r23, java.util.List r24, boolean r25) {
        /*
            r20 = this;
            r9 = r20
            r10 = r22
            r11 = r23
            r12 = r24
            java.lang.String[] r0 = we.p.f42128d
            boolean r13 = j0(r10, r0)
            if (r11 == 0) goto L_0x010d
            android.os.Bundle r15 = new android.os.Bundle
            r15.<init>(r11)
            com.google.android.gms.measurement.internal.u4 r0 = r9.f40059a
            com.google.android.gms.measurement.internal.g r0 = r0.z()
            int r8 = r0.m()
            java.util.TreeSet r0 = new java.util.TreeSet
            java.util.Set r1 = r23.keySet()
            r0.<init>(r1)
            java.util.Iterator r16 = r0.iterator()
            r17 = 0
            r18 = r17
        L_0x0030:
            boolean r0 = r16.hasNext()
            if (r0 == 0) goto L_0x010b
            java.lang.Object r0 = r16.next()
            r7 = r0
            java.lang.String r7 = (java.lang.String) r7
            if (r12 == 0) goto L_0x0049
            boolean r0 = r12.contains(r7)
            if (r0 != 0) goto L_0x0046
            goto L_0x0049
        L_0x0046:
            r2 = r17
            goto L_0x0059
        L_0x0049:
            if (r25 != 0) goto L_0x0050
            int r0 = r9.o0(r7)
            goto L_0x0052
        L_0x0050:
            r0 = r17
        L_0x0052:
            if (r0 != 0) goto L_0x0058
            int r0 = r9.n0(r7)
        L_0x0058:
            r2 = r0
        L_0x0059:
            if (r2 == 0) goto L_0x006f
            r0 = 3
            if (r2 != r0) goto L_0x0060
            r5 = r7
            goto L_0x0061
        L_0x0060:
            r5 = 0
        L_0x0061:
            r0 = r20
            r1 = r15
            r3 = r7
            r4 = r7
            r0.x(r1, r2, r3, r4, r5)
            r15.remove(r7)
            r14 = r8
            goto L_0x0108
        L_0x006f:
            java.lang.Object r4 = r11.get(r7)
            r0 = r20
            r1 = r21
            r2 = r22
            r3 = r7
            r5 = r15
            r6 = r24
            r19 = r7
            r7 = r25
            r14 = r8
            r8 = r13
            int r2 = r0.O(r1, r2, r3, r4, r5, r6, r7, r8)
            r0 = 17
            if (r2 != r0) goto L_0x009a
            r2 = 17
            java.lang.Boolean r5 = java.lang.Boolean.FALSE
            r0 = r20
            r1 = r15
            r3 = r19
            r4 = r19
            r0.x(r1, r2, r3, r4, r5)
            goto L_0x00bc
        L_0x009a:
            if (r2 == 0) goto L_0x00bc
            java.lang.String r0 = "_ev"
            r6 = r19
            boolean r0 = r0.equals(r6)
            if (r0 != 0) goto L_0x00be
            r0 = 21
            if (r2 != r0) goto L_0x00ac
            r3 = r10
            goto L_0x00ad
        L_0x00ac:
            r3 = r6
        L_0x00ad:
            java.lang.Object r5 = r11.get(r6)
            r0 = r20
            r1 = r15
            r4 = r6
            r0.x(r1, r2, r3, r4, r5)
            r15.remove(r6)
            goto L_0x0108
        L_0x00bc:
            r6 = r19
        L_0x00be:
            boolean r0 = Z(r6)
            if (r0 == 0) goto L_0x0108
            int r0 = r18 + 1
            if (r0 <= r14) goto L_0x0106
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Event can't contain more than "
            r1.append(r2)
            r1.append(r14)
            java.lang.String r2 = " params"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            com.google.android.gms.measurement.internal.u4 r2 = r9.f40059a
            com.google.android.gms.measurement.internal.q3 r2 = r2.d()
            com.google.android.gms.measurement.internal.o3 r2 = r2.s()
            com.google.android.gms.measurement.internal.u4 r3 = r9.f40059a
            com.google.android.gms.measurement.internal.l3 r3 = r3.D()
            java.lang.String r3 = r3.d(r10)
            com.google.android.gms.measurement.internal.u4 r4 = r9.f40059a
            com.google.android.gms.measurement.internal.l3 r4 = r4.D()
            java.lang.String r4 = r4.b(r11)
            r2.c(r1, r3, r4)
            r1 = 5
            f0(r15, r1)
            r15.remove(r6)
        L_0x0106:
            r18 = r0
        L_0x0108:
            r8 = r14
            goto L_0x0030
        L_0x010b:
            r14 = r15
            goto L_0x010e
        L_0x010d:
            r14 = 0
        L_0x010e:
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.t9.x0(java.lang.String, java.lang.String, android.os.Bundle, java.util.List, boolean):android.os.Bundle");
    }

    /* access modifiers changed from: package-private */
    public final zzau y0(String str, String str2, Bundle bundle, String str3, long j10, boolean z10, boolean z11) {
        Bundle bundle2;
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        if (m0(str2) == 0) {
            if (bundle != null) {
                bundle2 = new Bundle(bundle);
            } else {
                bundle2 = new Bundle();
            }
            Bundle bundle3 = bundle2;
            bundle3.putString("_o", str3);
            Bundle x02 = x0(str, str2, bundle3, g.b("_o"), true);
            if (z10) {
                x02 = w0(x02);
            }
            p.k(x02);
            return new zzau(str2, new zzas(x02), str3, j10);
        }
        this.f40059a.d().r().b("Invalid conditional property event name", this.f40059a.D().f(str2));
        throw new IllegalArgumentException();
    }

    /* access modifiers changed from: package-private */
    public final void z(Bundle bundle, Bundle bundle2) {
        if (bundle2 != null) {
            for (String next : bundle2.keySet()) {
                if (!bundle.containsKey(next)) {
                    this.f40059a.N().D(bundle, next, bundle2.get(next));
                }
            }
        }
    }
}
