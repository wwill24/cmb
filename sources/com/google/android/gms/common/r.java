package com.google.android.gms.common;

import android.os.RemoteException;
import com.google.android.gms.common.internal.a2;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.common.internal.z1;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import org.bouncycastle.i18n.LocalizedMessage;
import pe.a;
import pe.b;

abstract class r extends z1 {

    /* renamed from: a  reason: collision with root package name */
    private final int f39129a;

    protected r(byte[] bArr) {
        boolean z10;
        if (bArr.length == 25) {
            z10 = true;
        } else {
            z10 = false;
        }
        p.a(z10);
        this.f39129a = Arrays.hashCode(bArr);
    }

    protected static byte[] f(String str) {
        try {
            return str.getBytes(LocalizedMessage.DEFAULT_ENCODING);
        } catch (UnsupportedEncodingException e10) {
            throw new AssertionError(e10);
        }
    }

    public final boolean equals(Object obj) {
        a zzd;
        if (obj != null && (obj instanceof a2)) {
            try {
                a2 a2Var = (a2) obj;
                if (a2Var.zzc() != this.f39129a || (zzd = a2Var.zzd()) == null) {
                    return false;
                }
                return Arrays.equals(g(), (byte[]) b.f(zzd));
            } catch (RemoteException unused) {
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public abstract byte[] g();

    public final int hashCode() {
        return this.f39129a;
    }

    public final int zzc() {
        return this.f39129a;
    }

    public final a zzd() {
        return b.g(g());
    }
}
