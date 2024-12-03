package com.google.firebase.auth;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.internal.p003firebaseauthapi.zzaia;
import com.google.android.gms.internal.p003firebaseauthapi.zzzr;
import fe.a;
import org.json.JSONException;
import org.json.b;

public class TotpMultiFactorInfo extends MultiFactorInfo {
    @NonNull
    public static final Parcelable.Creator<TotpMultiFactorInfo> CREATOR = new zzau();
    private final String zza;
    private final String zzb;
    private final long zzc;
    private final zzaia zzd;

    public TotpMultiFactorInfo(String str, String str2, long j10, zzaia zzaia) {
        this.zza = p.g(str);
        this.zzb = str2;
        this.zzc = j10;
        this.zzd = (zzaia) p.l(zzaia, "totpInfo cannot be null.");
    }

    public String getDisplayName() {
        return this.zzb;
    }

    public long getEnrollmentTimestamp() {
        return this.zzc;
    }

    @NonNull
    public String getFactorId() {
        return TotpMultiFactorGenerator.FACTOR_ID;
    }

    @NonNull
    public String getUid() {
        return this.zza;
    }

    public final b toJson() {
        b bVar = new b();
        try {
            bVar.putOpt(MultiFactorInfo.FACTOR_ID_KEY, TotpMultiFactorGenerator.FACTOR_ID);
            bVar.putOpt("uid", this.zza);
            bVar.putOpt("displayName", this.zzb);
            bVar.putOpt("enrollmentTimestamp", Long.valueOf(this.zzc));
            bVar.putOpt("totpInfo", this.zzd);
            return bVar;
        } catch (JSONException e10) {
            throw new zzzr(e10);
        }
    }

    @SuppressLint({"FirebaseUnknownNullness"})
    public final void writeToParcel(@NonNull Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.C(parcel, 1, getUid(), false);
        a.C(parcel, 2, getDisplayName(), false);
        a.v(parcel, 3, getEnrollmentTimestamp());
        a.A(parcel, 4, this.zzd, i10, false);
        a.b(parcel, a10);
    }
}
