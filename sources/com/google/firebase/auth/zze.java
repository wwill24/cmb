package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.internal.p003firebaseauthapi.zzac;
import com.google.android.gms.internal.p003firebaseauthapi.zzaic;
import fe.a;

public final class zze extends OAuthCredential {
    public static final Parcelable.Creator<zze> CREATOR = new zzf();
    private final String zza;
    private final String zzb;
    private final String zzc;
    private final zzaic zzd;
    private final String zze;
    private final String zzf;
    private final String zzg;

    zze(String str, String str2, String str3, zzaic zzaic, String str4, String str5, String str6) {
        this.zza = zzac.zzc(str);
        this.zzb = str2;
        this.zzc = str3;
        this.zzd = zzaic;
        this.zze = str4;
        this.zzf = str5;
        this.zzg = str6;
    }

    public static zze zzb(zzaic zzaic) {
        p.l(zzaic, "Must specify a non-null webSignInCredential");
        return new zze((String) null, (String) null, (String) null, zzaic, (String) null, (String) null, (String) null);
    }

    public static zze zzc(String str, String str2, String str3, String str4, String str5) {
        p.h(str, "Must specify a non-empty providerId");
        if (!TextUtils.isEmpty(str2) || !TextUtils.isEmpty(str3)) {
            return new zze(str, str2, str3, (zzaic) null, str4, str5, (String) null);
        }
        throw new IllegalArgumentException("Must specify an idToken or an accessToken.");
    }

    public static zzaic zzd(zze zze2, String str) {
        p.k(zze2);
        zzaic zzaic = zze2.zzd;
        if (zzaic != null) {
            return zzaic;
        }
        return new zzaic(zze2.zzb, zze2.zzc, zze2.zza, (String) null, zze2.zzf, (String) null, str, zze2.zze, zze2.zzg);
    }

    public final String getAccessToken() {
        return this.zzc;
    }

    public final String getIdToken() {
        return this.zzb;
    }

    public final String getProvider() {
        return this.zza;
    }

    public final String getSecret() {
        return this.zzf;
    }

    public final String getSignInMethod() {
        return this.zza;
    }

    public final void writeToParcel(Parcel parcel, int i10) {
        String str = this.zza;
        int a10 = a.a(parcel);
        a.C(parcel, 1, str, false);
        a.C(parcel, 2, this.zzb, false);
        a.C(parcel, 3, this.zzc, false);
        a.A(parcel, 4, this.zzd, i10, false);
        a.C(parcel, 5, this.zze, false);
        a.C(parcel, 6, this.zzf, false);
        a.C(parcel, 7, this.zzg, false);
        a.b(parcel, a10);
    }

    public final AuthCredential zza() {
        return new zze(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, this.zzg);
    }
}
