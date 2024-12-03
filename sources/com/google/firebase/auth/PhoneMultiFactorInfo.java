package com.google.firebase.auth;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.internal.p003firebaseauthapi.zzzr;
import fe.a;
import org.json.JSONException;
import org.json.b;

public class PhoneMultiFactorInfo extends MultiFactorInfo {
    @NonNull
    public static final Parcelable.Creator<PhoneMultiFactorInfo> CREATOR = new zzas();
    private final String zza;
    private final String zzb;
    private final long zzc;
    private final String zzd;

    public PhoneMultiFactorInfo(@NonNull String str, String str2, long j10, @NonNull String str3) {
        this.zza = p.g(str);
        this.zzb = str2;
        this.zzc = j10;
        this.zzd = p.g(str3);
    }

    public String getDisplayName() {
        return this.zzb;
    }

    public long getEnrollmentTimestamp() {
        return this.zzc;
    }

    @NonNull
    public String getFactorId() {
        return "phone";
    }

    @NonNull
    public String getPhoneNumber() {
        return this.zzd;
    }

    @NonNull
    public String getUid() {
        return this.zza;
    }

    public b toJson() {
        b bVar = new b();
        try {
            bVar.putOpt(MultiFactorInfo.FACTOR_ID_KEY, "phone");
            bVar.putOpt("uid", this.zza);
            bVar.putOpt("displayName", this.zzb);
            bVar.putOpt("enrollmentTimestamp", Long.valueOf(this.zzc));
            bVar.putOpt("phoneNumber", this.zzd);
            return bVar;
        } catch (JSONException e10) {
            throw new zzzr(e10);
        }
    }

    @SuppressLint({"FirebaseUnknownNullness"})
    public void writeToParcel(@NonNull Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.C(parcel, 1, getUid(), false);
        a.C(parcel, 2, getDisplayName(), false);
        a.v(parcel, 3, getEnrollmentTimestamp());
        a.C(parcel, 4, getPhoneNumber(), false);
        a.b(parcel, a10);
    }
}
