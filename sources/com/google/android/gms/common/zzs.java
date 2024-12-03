package com.google.android.gms.common;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.z1;
import pe.a;
import pe.b;

public final class zzs extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzs> CREATOR = new y();

    /* renamed from: a  reason: collision with root package name */
    private final String f39204a;

    /* renamed from: b  reason: collision with root package name */
    private final r f39205b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f39206c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f39207d;

    zzs(String str, IBinder iBinder, boolean z10, boolean z11) {
        byte[] bArr;
        this.f39204a = str;
        s sVar = null;
        if (iBinder != null) {
            try {
                a zzd = z1.c(iBinder).zzd();
                if (zzd == null) {
                    bArr = null;
                } else {
                    bArr = (byte[]) b.f(zzd);
                }
                if (bArr != null) {
                    sVar = new s(bArr);
                }
            } catch (RemoteException unused) {
            }
        }
        this.f39205b = sVar;
        this.f39206c = z10;
        this.f39207d = z11;
    }

    zzs(String str, r rVar, boolean z10, boolean z11) {
        this.f39204a = str;
        this.f39205b = rVar;
        this.f39206c = z10;
        this.f39207d = z11;
    }

    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = fe.a.a(parcel);
        fe.a.C(parcel, 1, this.f39204a, false);
        r rVar = this.f39205b;
        if (rVar == null) {
            rVar = null;
        }
        fe.a.r(parcel, 2, rVar, false);
        fe.a.g(parcel, 3, this.f39206c);
        fe.a.g(parcel, 4, this.f39207d);
        fe.a.b(parcel, a10);
    }
}
