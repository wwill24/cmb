package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.i;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public class GetServiceRequest extends AbstractSafeParcelable {
    @NonNull
    public static final Parcelable.Creator<GetServiceRequest> CREATOR = new m1();

    /* renamed from: q  reason: collision with root package name */
    static final Scope[] f38929q = new Scope[0];

    /* renamed from: t  reason: collision with root package name */
    static final Feature[] f38930t = new Feature[0];

    /* renamed from: a  reason: collision with root package name */
    final int f38931a;

    /* renamed from: b  reason: collision with root package name */
    final int f38932b;

    /* renamed from: c  reason: collision with root package name */
    int f38933c;

    /* renamed from: d  reason: collision with root package name */
    String f38934d;

    /* renamed from: e  reason: collision with root package name */
    IBinder f38935e;

    /* renamed from: f  reason: collision with root package name */
    Scope[] f38936f;

    /* renamed from: g  reason: collision with root package name */
    Bundle f38937g;

    /* renamed from: h  reason: collision with root package name */
    Account f38938h;

    /* renamed from: j  reason: collision with root package name */
    Feature[] f38939j;

    /* renamed from: k  reason: collision with root package name */
    Feature[] f38940k;

    /* renamed from: l  reason: collision with root package name */
    boolean f38941l;

    /* renamed from: m  reason: collision with root package name */
    int f38942m;

    /* renamed from: n  reason: collision with root package name */
    boolean f38943n;

    /* renamed from: p  reason: collision with root package name */
    private String f38944p;

    GetServiceRequest(int i10, int i11, int i12, String str, IBinder iBinder, Scope[] scopeArr, Bundle bundle, Account account, Feature[] featureArr, Feature[] featureArr2, boolean z10, int i13, boolean z11, String str2) {
        Account account2;
        scopeArr = scopeArr == null ? f38929q : scopeArr;
        bundle = bundle == null ? new Bundle() : bundle;
        featureArr = featureArr == null ? f38930t : featureArr;
        featureArr2 = featureArr2 == null ? f38930t : featureArr2;
        this.f38931a = i10;
        this.f38932b = i11;
        this.f38933c = i12;
        if ("com.google.android.gms".equals(str)) {
            this.f38934d = "com.google.android.gms";
        } else {
            this.f38934d = str;
        }
        if (i10 < 2) {
            if (iBinder != null) {
                account2 = a.f(i.a.c(iBinder));
            } else {
                account2 = null;
            }
            this.f38938h = account2;
        } else {
            this.f38935e = iBinder;
            this.f38938h = account;
        }
        this.f38936f = scopeArr;
        this.f38937g = bundle;
        this.f38939j = featureArr;
        this.f38940k = featureArr2;
        this.f38941l = z10;
        this.f38942m = i13;
        this.f38943n = z11;
        this.f38944p = str2;
    }

    public final void writeToParcel(@NonNull Parcel parcel, int i10) {
        m1.a(this, parcel, i10);
    }

    public final String zza() {
        return this.f38944p;
    }
}
