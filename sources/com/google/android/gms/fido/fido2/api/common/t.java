package com.google.android.gms.fido.fido2.api.common;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class t implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int K = SafeParcelReader.K(parcel);
        PublicKeyCredentialCreationOptions publicKeyCredentialCreationOptions = null;
        Uri uri = null;
        byte[] bArr = null;
        while (parcel.dataPosition() < K) {
            int B = SafeParcelReader.B(parcel);
            int u10 = SafeParcelReader.u(B);
            if (u10 == 2) {
                publicKeyCredentialCreationOptions = (PublicKeyCredentialCreationOptions) SafeParcelReader.n(parcel, B, PublicKeyCredentialCreationOptions.CREATOR);
            } else if (u10 == 3) {
                uri = (Uri) SafeParcelReader.n(parcel, B, Uri.CREATOR);
            } else if (u10 != 4) {
                SafeParcelReader.J(parcel, B);
            } else {
                bArr = SafeParcelReader.g(parcel, B);
            }
        }
        SafeParcelReader.t(parcel, K);
        return new BrowserPublicKeyCredentialCreationOptions(publicKeyCredentialCreationOptions, uri, bArr);
    }

    public final /* synthetic */ Object[] newArray(int i10) {
        return new BrowserPublicKeyCredentialCreationOptions[i10];
    }
}
