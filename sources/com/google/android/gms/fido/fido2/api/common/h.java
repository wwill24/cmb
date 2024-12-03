package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.fido.fido2.api.common.TokenBinding;

final class h implements Parcelable.Creator {
    h() {
    }

    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        try {
            return TokenBinding.TokenBindingStatus.a(parcel.readString());
        } catch (TokenBinding.UnsupportedTokenBindingStatusException e10) {
            throw new RuntimeException(e10);
        }
    }

    public final /* synthetic */ Object[] newArray(int i10) {
        return new TokenBinding.TokenBindingStatus[i10];
    }
}
