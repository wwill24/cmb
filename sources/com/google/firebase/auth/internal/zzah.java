package com.google.firebase.auth.internal;

import android.os.Parcelable;

public final class zzah implements Parcelable.Creator {
    /* JADX WARNING: type inference failed for: r1v3, types: [android.os.Parcelable] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* bridge */ /* synthetic */ java.lang.Object createFromParcel(android.os.Parcel r10) {
        /*
            r9 = this;
            int r0 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.K(r10)
            r1 = 0
            r3 = r1
            r4 = r3
            r5 = r4
            r6 = r5
            r7 = r6
        L_0x000a:
            int r1 = r10.dataPosition()
            if (r1 >= r0) goto L_0x004d
            int r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.B(r10)
            int r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.u(r1)
            r8 = 1
            if (r2 == r8) goto L_0x0048
            r8 = 2
            if (r2 == r8) goto L_0x0043
            r8 = 3
            if (r2 == r8) goto L_0x003c
            r8 = 4
            if (r2 == r8) goto L_0x0035
            r8 = 5
            if (r2 == r8) goto L_0x002b
            com.google.android.gms.common.internal.safeparcel.SafeParcelReader.J(r10, r1)
            goto L_0x000a
        L_0x002b:
            android.os.Parcelable$Creator<com.google.firebase.auth.internal.zzx> r2 = com.google.firebase.auth.internal.zzx.CREATOR
            android.os.Parcelable r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.n(r10, r1, r2)
            r7 = r1
            com.google.firebase.auth.internal.zzx r7 = (com.google.firebase.auth.internal.zzx) r7
            goto L_0x000a
        L_0x0035:
            android.os.Parcelable$Creator<com.google.firebase.auth.TotpMultiFactorInfo> r2 = com.google.firebase.auth.TotpMultiFactorInfo.CREATOR
            java.util.ArrayList r6 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.s(r10, r1, r2)
            goto L_0x000a
        L_0x003c:
            android.os.Parcelable$Creator<com.google.firebase.auth.PhoneMultiFactorInfo> r2 = com.google.firebase.auth.PhoneMultiFactorInfo.CREATOR
            java.util.ArrayList r5 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.s(r10, r1, r2)
            goto L_0x000a
        L_0x0043:
            java.lang.String r4 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.o(r10, r1)
            goto L_0x000a
        L_0x0048:
            java.lang.String r3 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.o(r10, r1)
            goto L_0x000a
        L_0x004d:
            com.google.android.gms.common.internal.safeparcel.SafeParcelReader.t(r10, r0)
            com.google.firebase.auth.internal.zzag r10 = new com.google.firebase.auth.internal.zzag
            r2 = r10
            r2.<init>(r3, r4, r5, r6, r7)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.auth.internal.zzah.createFromParcel(android.os.Parcel):java.lang.Object");
    }

    public final /* synthetic */ Object[] newArray(int i10) {
        return new zzag[i10];
    }
}
