package com.google.android.gms.auth.api.credentials;

import android.os.Parcelable;

public final class d implements Parcelable.Creator {
    /* JADX WARNING: type inference failed for: r1v3, types: [android.os.Parcelable] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* bridge */ /* synthetic */ java.lang.Object createFromParcel(android.os.Parcel r13) {
        /*
            r12 = this;
            int r0 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.K(r13)
            r1 = 0
            r2 = 0
            r4 = r1
            r6 = r4
            r7 = r6
            r9 = r7
            r5 = r2
            r8 = r5
            r10 = r8
            r11 = r10
        L_0x000e:
            int r1 = r13.dataPosition()
            if (r1 >= r0) goto L_0x0054
            int r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.B(r13)
            int r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.u(r1)
            r3 = 1000(0x3e8, float:1.401E-42)
            if (r2 == r3) goto L_0x004f
            switch(r2) {
                case 1: goto L_0x0045;
                case 2: goto L_0x0040;
                case 3: goto L_0x003b;
                case 4: goto L_0x0036;
                case 5: goto L_0x0031;
                case 6: goto L_0x002c;
                case 7: goto L_0x0027;
                default: goto L_0x0023;
            }
        L_0x0023:
            com.google.android.gms.common.internal.safeparcel.SafeParcelReader.J(r13, r1)
            goto L_0x000e
        L_0x0027:
            java.lang.String r11 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.o(r13, r1)
            goto L_0x000e
        L_0x002c:
            java.lang.String r10 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.o(r13, r1)
            goto L_0x000e
        L_0x0031:
            boolean r9 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.v(r13, r1)
            goto L_0x000e
        L_0x0036:
            java.lang.String[] r8 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.p(r13, r1)
            goto L_0x000e
        L_0x003b:
            boolean r7 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.v(r13, r1)
            goto L_0x000e
        L_0x0040:
            boolean r6 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.v(r13, r1)
            goto L_0x000e
        L_0x0045:
            android.os.Parcelable$Creator<com.google.android.gms.auth.api.credentials.CredentialPickerConfig> r2 = com.google.android.gms.auth.api.credentials.CredentialPickerConfig.CREATOR
            android.os.Parcelable r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.n(r13, r1, r2)
            r5 = r1
            com.google.android.gms.auth.api.credentials.CredentialPickerConfig r5 = (com.google.android.gms.auth.api.credentials.CredentialPickerConfig) r5
            goto L_0x000e
        L_0x004f:
            int r4 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.D(r13, r1)
            goto L_0x000e
        L_0x0054:
            com.google.android.gms.common.internal.safeparcel.SafeParcelReader.t(r13, r0)
            com.google.android.gms.auth.api.credentials.HintRequest r13 = new com.google.android.gms.auth.api.credentials.HintRequest
            r3 = r13
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11)
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.auth.api.credentials.d.createFromParcel(android.os.Parcel):java.lang.Object");
    }

    public final /* synthetic */ Object[] newArray(int i10) {
        return new HintRequest[i10];
    }
}
