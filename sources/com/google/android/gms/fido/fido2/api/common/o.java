package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcelable;

public final class o implements Parcelable.Creator {
    /* JADX WARNING: type inference failed for: r1v3, types: [android.os.Parcelable] */
    /* JADX WARNING: type inference failed for: r1v4, types: [android.os.Parcelable] */
    /* JADX WARNING: type inference failed for: r1v5, types: [android.os.Parcelable] */
    /* JADX WARNING: type inference failed for: r1v6, types: [android.os.Parcelable] */
    /* JADX WARNING: type inference failed for: r1v7, types: [android.os.Parcelable] */
    /* JADX WARNING: type inference failed for: r1v8, types: [android.os.Parcelable] */
    /* JADX WARNING: type inference failed for: r1v9, types: [android.os.Parcelable] */
    /* JADX WARNING: type inference failed for: r1v10, types: [android.os.Parcelable] */
    /* JADX WARNING: type inference failed for: r1v11, types: [android.os.Parcelable] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* bridge */ /* synthetic */ java.lang.Object createFromParcel(android.os.Parcel r13) {
        /*
            r12 = this;
            int r0 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.K(r13)
            r1 = 0
            r3 = r1
            r4 = r3
            r5 = r4
            r6 = r5
            r7 = r6
            r8 = r7
            r9 = r8
            r10 = r9
            r11 = r10
        L_0x000e:
            int r1 = r13.dataPosition()
            if (r1 >= r0) goto L_0x007d
            int r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.B(r13)
            int r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.u(r1)
            switch(r2) {
                case 2: goto L_0x0073;
                case 3: goto L_0x0069;
                case 4: goto L_0x005f;
                case 5: goto L_0x0055;
                case 6: goto L_0x004b;
                case 7: goto L_0x0041;
                case 8: goto L_0x0037;
                case 9: goto L_0x002d;
                case 10: goto L_0x0023;
                default: goto L_0x001f;
            }
        L_0x001f:
            com.google.android.gms.common.internal.safeparcel.SafeParcelReader.J(r13, r1)
            goto L_0x000e
        L_0x0023:
            android.os.Parcelable$Creator<com.google.android.gms.fido.fido2.api.common.GoogleThirdPartyPaymentExtension> r2 = com.google.android.gms.fido.fido2.api.common.GoogleThirdPartyPaymentExtension.CREATOR
            android.os.Parcelable r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.n(r13, r1, r2)
            r11 = r1
            com.google.android.gms.fido.fido2.api.common.GoogleThirdPartyPaymentExtension r11 = (com.google.android.gms.fido.fido2.api.common.GoogleThirdPartyPaymentExtension) r11
            goto L_0x000e
        L_0x002d:
            android.os.Parcelable$Creator<com.google.android.gms.fido.fido2.api.common.zzad> r2 = com.google.android.gms.fido.fido2.api.common.zzad.CREATOR
            android.os.Parcelable r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.n(r13, r1, r2)
            r10 = r1
            com.google.android.gms.fido.fido2.api.common.zzad r10 = (com.google.android.gms.fido.fido2.api.common.zzad) r10
            goto L_0x000e
        L_0x0037:
            android.os.Parcelable$Creator<com.google.android.gms.fido.fido2.api.common.zzr> r2 = com.google.android.gms.fido.fido2.api.common.zzr.CREATOR
            android.os.Parcelable r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.n(r13, r1, r2)
            r9 = r1
            com.google.android.gms.fido.fido2.api.common.zzr r9 = (com.google.android.gms.fido.fido2.api.common.zzr) r9
            goto L_0x000e
        L_0x0041:
            android.os.Parcelable$Creator<com.google.android.gms.fido.fido2.api.common.zzaa> r2 = com.google.android.gms.fido.fido2.api.common.zzaa.CREATOR
            android.os.Parcelable r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.n(r13, r1, r2)
            r8 = r1
            com.google.android.gms.fido.fido2.api.common.zzaa r8 = (com.google.android.gms.fido.fido2.api.common.zzaa) r8
            goto L_0x000e
        L_0x004b:
            android.os.Parcelable$Creator<com.google.android.gms.fido.fido2.api.common.zzy> r2 = com.google.android.gms.fido.fido2.api.common.zzy.CREATOR
            android.os.Parcelable r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.n(r13, r1, r2)
            r7 = r1
            com.google.android.gms.fido.fido2.api.common.zzy r7 = (com.google.android.gms.fido.fido2.api.common.zzy) r7
            goto L_0x000e
        L_0x0055:
            android.os.Parcelable$Creator<com.google.android.gms.fido.fido2.api.common.zzw> r2 = com.google.android.gms.fido.fido2.api.common.zzw.CREATOR
            android.os.Parcelable r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.n(r13, r1, r2)
            r6 = r1
            com.google.android.gms.fido.fido2.api.common.zzw r6 = (com.google.android.gms.fido.fido2.api.common.zzw) r6
            goto L_0x000e
        L_0x005f:
            android.os.Parcelable$Creator<com.google.android.gms.fido.fido2.api.common.UserVerificationMethodExtension> r2 = com.google.android.gms.fido.fido2.api.common.UserVerificationMethodExtension.CREATOR
            android.os.Parcelable r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.n(r13, r1, r2)
            r5 = r1
            com.google.android.gms.fido.fido2.api.common.UserVerificationMethodExtension r5 = (com.google.android.gms.fido.fido2.api.common.UserVerificationMethodExtension) r5
            goto L_0x000e
        L_0x0069:
            android.os.Parcelable$Creator<com.google.android.gms.fido.fido2.api.common.zzp> r2 = com.google.android.gms.fido.fido2.api.common.zzp.CREATOR
            android.os.Parcelable r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.n(r13, r1, r2)
            r4 = r1
            com.google.android.gms.fido.fido2.api.common.zzp r4 = (com.google.android.gms.fido.fido2.api.common.zzp) r4
            goto L_0x000e
        L_0x0073:
            android.os.Parcelable$Creator<com.google.android.gms.fido.fido2.api.common.FidoAppIdExtension> r2 = com.google.android.gms.fido.fido2.api.common.FidoAppIdExtension.CREATOR
            android.os.Parcelable r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.n(r13, r1, r2)
            r3 = r1
            com.google.android.gms.fido.fido2.api.common.FidoAppIdExtension r3 = (com.google.android.gms.fido.fido2.api.common.FidoAppIdExtension) r3
            goto L_0x000e
        L_0x007d:
            com.google.android.gms.common.internal.safeparcel.SafeParcelReader.t(r13, r0)
            com.google.android.gms.fido.fido2.api.common.AuthenticationExtensions r13 = new com.google.android.gms.fido.fido2.api.common.AuthenticationExtensions
            r2 = r13
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11)
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.fido.fido2.api.common.o.createFromParcel(android.os.Parcel):java.lang.Object");
    }

    public final /* synthetic */ Object[] newArray(int i10) {
        return new AuthenticationExtensions[i10];
    }
}
