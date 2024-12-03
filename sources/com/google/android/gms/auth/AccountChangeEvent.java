package com.google.android.gms.auth;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.mparticle.identity.IdentityHttpResponse;
import fe.a;

public class AccountChangeEvent extends AbstractSafeParcelable {
    @NonNull
    public static final Parcelable.Creator<AccountChangeEvent> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    final int f38173a;

    /* renamed from: b  reason: collision with root package name */
    final long f38174b;

    /* renamed from: c  reason: collision with root package name */
    final String f38175c;

    /* renamed from: d  reason: collision with root package name */
    final int f38176d;

    /* renamed from: e  reason: collision with root package name */
    final int f38177e;

    /* renamed from: f  reason: collision with root package name */
    final String f38178f;

    AccountChangeEvent(int i10, long j10, String str, int i11, int i12, String str2) {
        this.f38173a = i10;
        this.f38174b = j10;
        this.f38175c = (String) p.k(str);
        this.f38176d = i11;
        this.f38177e = i12;
        this.f38178f = str2;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof AccountChangeEvent)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        AccountChangeEvent accountChangeEvent = (AccountChangeEvent) obj;
        if (this.f38173a == accountChangeEvent.f38173a && this.f38174b == accountChangeEvent.f38174b && n.b(this.f38175c, accountChangeEvent.f38175c) && this.f38176d == accountChangeEvent.f38176d && this.f38177e == accountChangeEvent.f38177e && n.b(this.f38178f, accountChangeEvent.f38178f)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return n.c(Integer.valueOf(this.f38173a), Long.valueOf(this.f38174b), this.f38175c, Integer.valueOf(this.f38176d), Integer.valueOf(this.f38177e), this.f38178f);
    }

    @NonNull
    public String toString() {
        int i10 = this.f38176d;
        String str = i10 != 1 ? i10 != 2 ? i10 != 3 ? i10 != 4 ? IdentityHttpResponse.UNKNOWN : "RENAMED_TO" : "RENAMED_FROM" : "REMOVED" : "ADDED";
        String str2 = this.f38175c;
        String str3 = this.f38178f;
        int i11 = this.f38177e;
        return "AccountChangeEvent {accountName = " + str2 + ", changeType = " + str + ", changeData = " + str3 + ", eventIndex = " + i11 + "}";
    }

    public void writeToParcel(@NonNull Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.s(parcel, 1, this.f38173a);
        a.v(parcel, 2, this.f38174b);
        a.C(parcel, 3, this.f38175c, false);
        a.s(parcel, 4, this.f38176d);
        a.s(parcel, 5, this.f38177e);
        a.C(parcel, 6, this.f38178f, false);
        a.b(parcel, a10);
    }
}
