package com.google.firebase.auth.internal;

import android.os.Parcelable;

public final class zzaf implements Parcelable.Creator {
    /* JADX WARNING: type inference failed for: r1v3, types: [android.os.Parcelable] */
    /* JADX WARNING: type inference failed for: r1v4, types: [android.os.Parcelable] */
    /* JADX WARNING: type inference failed for: r1v5, types: [android.os.Parcelable] */
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
            r8 = r7
        L_0x000b:
            int r1 = r10.dataPosition()
            if (r1 >= r0) goto L_0x0051
            int r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.B(r10)
            int r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.u(r1)
            switch(r2) {
                case 1: goto L_0x004a;
                case 2: goto L_0x0040;
                case 3: goto L_0x003b;
                case 4: goto L_0x0031;
                case 5: goto L_0x0027;
                case 6: goto L_0x0020;
                default: goto L_0x001c;
            }
        L_0x001c:
            com.google.android.gms.common.internal.safeparcel.SafeParcelReader.J(r10, r1)
            goto L_0x000b
        L_0x0020:
            android.os.Parcelable$Creator<com.google.firebase.auth.TotpMultiFactorInfo> r2 = com.google.firebase.auth.TotpMultiFactorInfo.CREATOR
            java.util.ArrayList r8 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.s(r10, r1, r2)
            goto L_0x000b
        L_0x0027:
            android.os.Parcelable$Creator<com.google.firebase.auth.internal.zzx> r2 = com.google.firebase.auth.internal.zzx.CREATOR
            android.os.Parcelable r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.n(r10, r1, r2)
            r7 = r1
            com.google.firebase.auth.internal.zzx r7 = (com.google.firebase.auth.internal.zzx) r7
            goto L_0x000b
        L_0x0031:
            android.os.Parcelable$Creator<com.google.firebase.auth.zze> r2 = com.google.firebase.auth.zze.CREATOR
            android.os.Parcelable r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.n(r10, r1, r2)
            r6 = r1
            com.google.firebase.auth.zze r6 = (com.google.firebase.auth.zze) r6
            goto L_0x000b
        L_0x003b:
            java.lang.String r5 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.o(r10, r1)
            goto L_0x000b
        L_0x0040:
            android.os.Parcelable$Creator<com.google.firebase.auth.internal.zzag> r2 = com.google.firebase.auth.internal.zzag.CREATOR
            android.os.Parcelable r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.n(r10, r1, r2)
            r4 = r1
            com.google.firebase.auth.internal.zzag r4 = (com.google.firebase.auth.internal.zzag) r4
            goto L_0x000b
        L_0x004a:
            android.os.Parcelable$Creator<com.google.firebase.auth.PhoneMultiFactorInfo> r2 = com.google.firebase.auth.PhoneMultiFactorInfo.CREATOR
            java.util.ArrayList r3 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.s(r10, r1, r2)
            goto L_0x000b
        L_0x0051:
            com.google.android.gms.common.internal.safeparcel.SafeParcelReader.t(r10, r0)
            com.google.firebase.auth.internal.zzae r10 = new com.google.firebase.auth.internal.zzae
            r2 = r10
            r2.<init>(r3, r4, r5, r6, r7, r8)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.auth.internal.zzaf.createFromParcel(android.os.Parcel):java.lang.Object");
    }

    public final /* synthetic */ Object[] newArray(int i10) {
        return new zzae[i10];
    }
}
