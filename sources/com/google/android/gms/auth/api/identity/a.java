package com.google.android.gms.auth.api.identity;

import android.os.Parcelable;

public final class a implements Parcelable.Creator {
    /* JADX WARNING: type inference failed for: r1v3, types: [android.os.Parcelable] */
    /* JADX WARNING: type inference failed for: r1v4, types: [android.os.Parcelable] */
    /* JADX WARNING: type inference failed for: r1v5, types: [android.os.Parcelable] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* bridge */ /* synthetic */ java.lang.Object createFromParcel(android.os.Parcel r11) {
        /*
            r10 = this;
            int r0 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.K(r11)
            r1 = 0
            r2 = 0
            r7 = r1
            r8 = r7
            r4 = r2
            r5 = r4
            r6 = r5
            r9 = r6
        L_0x000c:
            int r1 = r11.dataPosition()
            if (r1 >= r0) goto L_0x004e
            int r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.B(r11)
            int r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.u(r1)
            switch(r2) {
                case 1: goto L_0x0044;
                case 2: goto L_0x003a;
                case 3: goto L_0x0035;
                case 4: goto L_0x0030;
                case 5: goto L_0x002b;
                case 6: goto L_0x0021;
                default: goto L_0x001d;
            }
        L_0x001d:
            com.google.android.gms.common.internal.safeparcel.SafeParcelReader.J(r11, r1)
            goto L_0x000c
        L_0x0021:
            android.os.Parcelable$Creator<com.google.android.gms.auth.api.identity.BeginSignInRequest$PasskeysRequestOptions> r2 = com.google.android.gms.auth.api.identity.BeginSignInRequest.PasskeysRequestOptions.CREATOR
            android.os.Parcelable r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.n(r11, r1, r2)
            r9 = r1
            com.google.android.gms.auth.api.identity.BeginSignInRequest$PasskeysRequestOptions r9 = (com.google.android.gms.auth.api.identity.BeginSignInRequest.PasskeysRequestOptions) r9
            goto L_0x000c
        L_0x002b:
            int r8 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.D(r11, r1)
            goto L_0x000c
        L_0x0030:
            boolean r7 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.v(r11, r1)
            goto L_0x000c
        L_0x0035:
            java.lang.String r6 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.o(r11, r1)
            goto L_0x000c
        L_0x003a:
            android.os.Parcelable$Creator<com.google.android.gms.auth.api.identity.BeginSignInRequest$GoogleIdTokenRequestOptions> r2 = com.google.android.gms.auth.api.identity.BeginSignInRequest.GoogleIdTokenRequestOptions.CREATOR
            android.os.Parcelable r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.n(r11, r1, r2)
            r5 = r1
            com.google.android.gms.auth.api.identity.BeginSignInRequest$GoogleIdTokenRequestOptions r5 = (com.google.android.gms.auth.api.identity.BeginSignInRequest.GoogleIdTokenRequestOptions) r5
            goto L_0x000c
        L_0x0044:
            android.os.Parcelable$Creator<com.google.android.gms.auth.api.identity.BeginSignInRequest$PasswordRequestOptions> r2 = com.google.android.gms.auth.api.identity.BeginSignInRequest.PasswordRequestOptions.CREATOR
            android.os.Parcelable r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.n(r11, r1, r2)
            r4 = r1
            com.google.android.gms.auth.api.identity.BeginSignInRequest$PasswordRequestOptions r4 = (com.google.android.gms.auth.api.identity.BeginSignInRequest.PasswordRequestOptions) r4
            goto L_0x000c
        L_0x004e:
            com.google.android.gms.common.internal.safeparcel.SafeParcelReader.t(r11, r0)
            com.google.android.gms.auth.api.identity.BeginSignInRequest r11 = new com.google.android.gms.auth.api.identity.BeginSignInRequest
            r3 = r11
            r3.<init>(r4, r5, r6, r7, r8, r9)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.auth.api.identity.a.createFromParcel(android.os.Parcel):java.lang.Object");
    }

    public final /* synthetic */ Object[] newArray(int i10) {
        return new BeginSignInRequest[i10];
    }
}
