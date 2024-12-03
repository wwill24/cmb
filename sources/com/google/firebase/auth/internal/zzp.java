package com.google.firebase.auth.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.p;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.auth.AdditionalUserInfo;
import fe.a;
import java.util.Map;

public final class zzp implements AdditionalUserInfo {
    public static final Parcelable.Creator<zzp> CREATOR = new zzq();
    private final String zza;
    private final String zzb;
    private final Map zzc;
    private final boolean zzd;

    public zzp(String str, String str2, boolean z10) {
        p.g(str);
        p.g(str2);
        this.zza = str;
        this.zzb = str2;
        this.zzc = zzbb.zzc(str2);
        this.zzd = z10;
    }

    public zzp(boolean z10) {
        this.zzd = z10;
        this.zzb = null;
        this.zza = null;
        this.zzc = null;
    }

    public final int describeContents() {
        return 0;
    }

    public final Map<String, Object> getProfile() {
        return this.zzc;
    }

    public final String getProviderId() {
        return this.zza;
    }

    public final String getUsername() {
        if ("github.com".equals(this.zza)) {
            return (String) this.zzc.get(FirebaseAnalytics.Event.LOGIN);
        }
        if ("twitter.com".equals(this.zza)) {
            return (String) this.zzc.get(FirebaseAnalytics.Param.SCREEN_NAME);
        }
        return null;
    }

    public final boolean isNewUser() {
        return this.zzd;
    }

    public final void writeToParcel(Parcel parcel, int i10) {
        String str = this.zza;
        int a10 = a.a(parcel);
        a.C(parcel, 1, str, false);
        a.C(parcel, 2, this.zzb, false);
        a.g(parcel, 3, this.zzd);
        a.b(parcel, a10);
    }
}
