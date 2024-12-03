package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import com.google.android.gms.common.internal.p;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;
import org.apache.commons.validator.Field;
import we.e;
import we.q;
import we.r;

public final class l3 {

    /* renamed from: b  reason: collision with root package name */
    protected static final AtomicReference f40002b = new AtomicReference();

    /* renamed from: c  reason: collision with root package name */
    protected static final AtomicReference f40003c = new AtomicReference();

    /* renamed from: d  reason: collision with root package name */
    protected static final AtomicReference f40004d = new AtomicReference();

    /* renamed from: a  reason: collision with root package name */
    private final e f40005a;

    public l3(e eVar) {
        this.f40005a = eVar;
    }

    private static final String g(String str, String[] strArr, String[] strArr2, AtomicReference atomicReference) {
        boolean z10;
        String str2;
        p.k(strArr);
        p.k(strArr2);
        p.k(atomicReference);
        if (strArr.length == strArr2.length) {
            z10 = true;
        } else {
            z10 = false;
        }
        p.a(z10);
        for (int i10 = 0; i10 < strArr.length; i10++) {
            String str3 = strArr[i10];
            if (str == str3 || str.equals(str3)) {
                synchronized (atomicReference) {
                    String[] strArr3 = (String[]) atomicReference.get();
                    if (strArr3 == null) {
                        strArr3 = new String[strArr2.length];
                        atomicReference.set(strArr3);
                    }
                    str2 = strArr3[i10];
                    if (str2 == null) {
                        str2 = strArr2[i10] + "(" + strArr[i10] + ")";
                        strArr3[i10] = str2;
                    }
                }
                return str2;
            }
        }
        return str;
    }

    /* access modifiers changed from: protected */
    public final String a(Object[] objArr) {
        String str;
        if (objArr == null) {
            return Field.TOKEN_INDEXED;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("[");
        for (Bundle bundle : objArr) {
            if (bundle instanceof Bundle) {
                str = b(bundle);
            } else {
                str = String.valueOf(bundle);
            }
            if (str != null) {
                if (sb2.length() != 1) {
                    sb2.append(", ");
                }
                sb2.append(str);
            }
        }
        sb2.append("]");
        return sb2.toString();
    }

    /* access modifiers changed from: protected */
    public final String b(Bundle bundle) {
        String str;
        if (bundle == null) {
            return null;
        }
        if (!this.f40005a.zza()) {
            return bundle.toString();
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Bundle[{");
        for (String next : bundle.keySet()) {
            if (sb2.length() != 8) {
                sb2.append(", ");
            }
            sb2.append(e(next));
            sb2.append("=");
            Object obj = bundle.get(next);
            if (obj instanceof Bundle) {
                str = a(new Object[]{obj});
            } else if (obj instanceof Object[]) {
                str = a((Object[]) obj);
            } else if (obj instanceof ArrayList) {
                str = a(((ArrayList) obj).toArray());
            } else {
                str = String.valueOf(obj);
            }
            sb2.append(str);
        }
        sb2.append("}]");
        return sb2.toString();
    }

    /* access modifiers changed from: protected */
    public final String c(zzau zzau) {
        String str;
        if (!this.f40005a.zza()) {
            return zzau.toString();
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("origin=");
        sb2.append(zzau.f40493c);
        sb2.append(",name=");
        sb2.append(d(zzau.f40491a));
        sb2.append(",params=");
        zzas zzas = zzau.f40492b;
        if (zzas == null) {
            str = null;
        } else if (!this.f40005a.zza()) {
            str = zzas.toString();
        } else {
            str = b(zzas.Y());
        }
        sb2.append(str);
        return sb2.toString();
    }

    /* access modifiers changed from: protected */
    public final String d(String str) {
        if (str == null) {
            return null;
        }
        if (!this.f40005a.zza()) {
            return str;
        }
        return g(str, we.p.f42127c, we.p.f42125a, f40002b);
    }

    /* access modifiers changed from: protected */
    public final String e(String str) {
        if (str == null) {
            return null;
        }
        if (!this.f40005a.zza()) {
            return str;
        }
        return g(str, q.f42130b, q.f42129a, f40003c);
    }

    /* access modifiers changed from: protected */
    public final String f(String str) {
        if (str == null) {
            return null;
        }
        if (!this.f40005a.zza()) {
            return str;
        }
        if (!str.startsWith("_exp_")) {
            return g(str, r.f42134b, r.f42133a, f40004d);
        }
        return "experiment_id(" + str + ")";
    }
}
