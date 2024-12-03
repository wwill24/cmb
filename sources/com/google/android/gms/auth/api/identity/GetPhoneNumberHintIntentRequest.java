package com.google.android.gms.auth.api.identity;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import fe.a;

public class GetPhoneNumberHintIntentRequest extends AbstractSafeParcelable {
    @NonNull
    public static final Parcelable.Creator<GetPhoneNumberHintIntentRequest> CREATOR = new b();

    /* renamed from: a  reason: collision with root package name */
    private final int f38304a;

    GetPhoneNumberHintIntentRequest(int i10) {
        this.f38304a = i10;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof GetPhoneNumberHintIntentRequest)) {
            return false;
        }
        return n.b(Integer.valueOf(this.f38304a), Integer.valueOf(((GetPhoneNumberHintIntentRequest) obj).f38304a));
    }

    public int hashCode() {
        return n.c(Integer.valueOf(this.f38304a));
    }

    public void writeToParcel(@NonNull Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.s(parcel, 1, this.f38304a);
        a.b(parcel, a10);
    }
}
