package com.google.android.gms.fido.u2f.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.internal.fido.zzap;
import com.google.android.gms.internal.fido.zzaq;
import fe.a;

@Deprecated
public class ErrorResponseData extends ResponseData {
    @NonNull
    public static final Parcelable.Creator<ErrorResponseData> CREATOR = new d();

    /* renamed from: a  reason: collision with root package name */
    private final ErrorCode f39415a;

    /* renamed from: b  reason: collision with root package name */
    private final String f39416b;

    ErrorResponseData(int i10, String str) {
        this.f39415a = ErrorCode.c(i10);
        this.f39416b = str;
    }

    public int S() {
        return this.f39415a.a();
    }

    @NonNull
    public String Y() {
        return this.f39416b;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ErrorResponseData)) {
            return false;
        }
        ErrorResponseData errorResponseData = (ErrorResponseData) obj;
        if (!n.b(this.f39415a, errorResponseData.f39415a) || !n.b(this.f39416b, errorResponseData.f39416b)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return n.c(this.f39415a, this.f39416b);
    }

    @NonNull
    public String toString() {
        zzap zza = zzaq.zza(this);
        zza.zza("errorCode", this.f39415a.a());
        String str = this.f39416b;
        if (str != null) {
            zza.zzb("errorMessage", str);
        }
        return zza.toString();
    }

    public void writeToParcel(@NonNull Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.s(parcel, 2, S());
        a.C(parcel, 3, Y(), false);
        a.b(parcel, a10);
    }
}
