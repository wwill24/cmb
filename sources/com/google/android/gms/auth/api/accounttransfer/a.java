package com.google.android.gms.auth.api.accounttransfer;

import android.os.Parcelable;

public final class a implements Parcelable.Creator {
    /* JADX WARNING: type inference failed for: r1v9, types: [android.os.Parcelable] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* bridge */ /* synthetic */ java.lang.Object createFromParcel(android.os.Parcel r10) {
        /*
            r9 = this;
            int r0 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.K(r10)
            java.util.HashSet r2 = new java.util.HashSet
            r2.<init>()
            r1 = 0
            r3 = 0
            r4 = r1
            r6 = r4
            r5 = r3
        L_0x000e:
            int r1 = r10.dataPosition()
            if (r1 >= r0) goto L_0x0063
            int r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.B(r10)
            int r7 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.u(r1)
            r8 = 1
            if (r7 == r8) goto L_0x0057
            r8 = 2
            if (r7 == r8) goto L_0x0049
            r8 = 3
            if (r7 == r8) goto L_0x003d
            r8 = 4
            if (r7 == r8) goto L_0x002c
            com.google.android.gms.common.internal.safeparcel.SafeParcelReader.J(r10, r1)
            goto L_0x000e
        L_0x002c:
            android.os.Parcelable$Creator<com.google.android.gms.auth.api.accounttransfer.zzs> r6 = com.google.android.gms.auth.api.accounttransfer.zzs.CREATOR
            android.os.Parcelable r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.n(r10, r1, r6)
            r6 = r1
            com.google.android.gms.auth.api.accounttransfer.zzs r6 = (com.google.android.gms.auth.api.accounttransfer.zzs) r6
            java.lang.Integer r1 = java.lang.Integer.valueOf(r8)
            r2.add(r1)
            goto L_0x000e
        L_0x003d:
            int r5 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.D(r10, r1)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r8)
            r2.add(r1)
            goto L_0x000e
        L_0x0049:
            android.os.Parcelable$Creator<com.google.android.gms.auth.api.accounttransfer.zzu> r4 = com.google.android.gms.auth.api.accounttransfer.zzu.CREATOR
            java.util.ArrayList r4 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.s(r10, r1, r4)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r8)
            r2.add(r1)
            goto L_0x000e
        L_0x0057:
            int r3 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.D(r10, r1)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r8)
            r2.add(r1)
            goto L_0x000e
        L_0x0063:
            int r1 = r10.dataPosition()
            if (r1 != r0) goto L_0x0070
            com.google.android.gms.auth.api.accounttransfer.zzo r10 = new com.google.android.gms.auth.api.accounttransfer.zzo
            r1 = r10
            r1.<init>(r2, r3, r4, r5, r6)
            return r10
        L_0x0070:
            com.google.android.gms.common.internal.safeparcel.SafeParcelReader$ParseException r1 = new com.google.android.gms.common.internal.safeparcel.SafeParcelReader$ParseException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Overread allowed size end="
            r2.append(r3)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.<init>(r0, r10)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.auth.api.accounttransfer.a.createFromParcel(android.os.Parcel):java.lang.Object");
    }

    public final /* synthetic */ Object[] newArray(int i10) {
        return new zzo[i10];
    }
}
