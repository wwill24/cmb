package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import fe.a;

public final class m1 implements Parcelable.Creator {
    static void a(GetServiceRequest getServiceRequest, Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.s(parcel, 1, getServiceRequest.f38931a);
        a.s(parcel, 2, getServiceRequest.f38932b);
        a.s(parcel, 3, getServiceRequest.f38933c);
        a.C(parcel, 4, getServiceRequest.f38934d, false);
        a.r(parcel, 5, getServiceRequest.f38935e, false);
        a.F(parcel, 6, getServiceRequest.f38936f, i10, false);
        a.j(parcel, 7, getServiceRequest.f38937g, false);
        a.A(parcel, 8, getServiceRequest.f38938h, i10, false);
        a.F(parcel, 10, getServiceRequest.f38939j, i10, false);
        a.F(parcel, 11, getServiceRequest.f38940k, i10, false);
        a.g(parcel, 12, getServiceRequest.f38941l);
        a.s(parcel, 13, getServiceRequest.f38942m);
        a.g(parcel, 14, getServiceRequest.f38943n);
        a.C(parcel, 15, getServiceRequest.zza(), false);
        a.b(parcel, a10);
    }

    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int K = SafeParcelReader.K(parcel);
        Scope[] scopeArr = GetServiceRequest.f38929q;
        Bundle bundle = new Bundle();
        Feature[] featureArr = GetServiceRequest.f38930t;
        Feature[] featureArr2 = featureArr;
        String str = null;
        IBinder iBinder = null;
        Account account = null;
        String str2 = null;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        boolean z10 = false;
        int i13 = 0;
        boolean z11 = false;
        while (parcel.dataPosition() < K) {
            int B = SafeParcelReader.B(parcel);
            switch (SafeParcelReader.u(B)) {
                case 1:
                    i10 = SafeParcelReader.D(parcel2, B);
                    break;
                case 2:
                    i11 = SafeParcelReader.D(parcel2, B);
                    break;
                case 3:
                    i12 = SafeParcelReader.D(parcel2, B);
                    break;
                case 4:
                    str = SafeParcelReader.o(parcel2, B);
                    break;
                case 5:
                    iBinder = SafeParcelReader.C(parcel2, B);
                    break;
                case 6:
                    scopeArr = (Scope[]) SafeParcelReader.r(parcel2, B, Scope.CREATOR);
                    break;
                case 7:
                    bundle = SafeParcelReader.f(parcel2, B);
                    break;
                case 8:
                    account = (Account) SafeParcelReader.n(parcel2, B, Account.CREATOR);
                    break;
                case 10:
                    featureArr = (Feature[]) SafeParcelReader.r(parcel2, B, Feature.CREATOR);
                    break;
                case 11:
                    featureArr2 = (Feature[]) SafeParcelReader.r(parcel2, B, Feature.CREATOR);
                    break;
                case 12:
                    z10 = SafeParcelReader.v(parcel2, B);
                    break;
                case 13:
                    i13 = SafeParcelReader.D(parcel2, B);
                    break;
                case 14:
                    z11 = SafeParcelReader.v(parcel2, B);
                    break;
                case 15:
                    str2 = SafeParcelReader.o(parcel2, B);
                    break;
                default:
                    SafeParcelReader.J(parcel2, B);
                    break;
            }
        }
        SafeParcelReader.t(parcel2, K);
        return new GetServiceRequest(i10, i11, i12, str, iBinder, scopeArr, bundle, account, featureArr, featureArr2, z10, i13, z11, str2);
    }

    public final /* synthetic */ Object[] newArray(int i10) {
        return new GetServiceRequest[i10];
    }
}
