package com.google.firebase.messaging;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import fe.a;

public class RemoteMessageCreator implements Parcelable.Creator<RemoteMessage> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void writeToParcel(RemoteMessage remoteMessage, Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.j(parcel, 2, remoteMessage.bundle, false);
        a.b(parcel, a10);
    }

    public RemoteMessage createFromParcel(Parcel parcel) {
        int K = SafeParcelReader.K(parcel);
        Bundle bundle = null;
        while (parcel.dataPosition() < K) {
            int B = SafeParcelReader.B(parcel);
            if (SafeParcelReader.u(B) != 2) {
                SafeParcelReader.J(parcel, B);
            } else {
                bundle = SafeParcelReader.f(parcel, B);
            }
        }
        SafeParcelReader.t(parcel, K);
        return new RemoteMessage(bundle);
    }

    public RemoteMessage[] newArray(int i10) {
        return new RemoteMessage[i10];
    }
}
