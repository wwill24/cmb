package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.p;
import fe.a;

public class PhoneAuthCredential extends AuthCredential implements Cloneable {
    @NonNull
    public static final Parcelable.Creator<PhoneAuthCredential> CREATOR = new zzaq();
    private final String zza;
    private final String zzb;
    private final String zzc;
    private boolean zzd;
    private final String zze;

    PhoneAuthCredential(String str, String str2, String str3, boolean z10, String str4) {
        boolean z11 = true;
        if ((TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) && (TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4))) {
            z11 = false;
        }
        p.b(z11, "Cannot create PhoneAuthCredential without either sessionInfo + smsCode or temporary proof + phoneNumber.");
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
        this.zzd = z10;
        this.zze = str4;
    }

    @NonNull
    public static PhoneAuthCredential zzc(@NonNull String str, @NonNull String str2) {
        return new PhoneAuthCredential(str, str2, (String) null, true, (String) null);
    }

    @NonNull
    public static PhoneAuthCredential zzd(@NonNull String str, @NonNull String str2) {
        return new PhoneAuthCredential((String) null, (String) null, str, true, str2);
    }

    @NonNull
    public String getProvider() {
        return "phone";
    }

    @NonNull
    public String getSignInMethod() {
        return "phone";
    }

    public String getSmsCode() {
        return this.zzb;
    }

    public final void writeToParcel(@NonNull Parcel parcel, int i10) {
        String str = this.zza;
        int a10 = a.a(parcel);
        a.C(parcel, 1, str, false);
        a.C(parcel, 2, getSmsCode(), false);
        a.C(parcel, 4, this.zzc, false);
        a.g(parcel, 5, this.zzd);
        a.C(parcel, 6, this.zze, false);
        a.b(parcel, a10);
    }

    @NonNull
    public final AuthCredential zza() {
        return clone();
    }

    @NonNull
    /* renamed from: zzb */
    public final PhoneAuthCredential clone() {
        return new PhoneAuthCredential(this.zza, getSmsCode(), this.zzc, this.zzd, this.zze);
    }

    @NonNull
    public final PhoneAuthCredential zze(boolean z10) {
        this.zzd = false;
        return this;
    }

    public final String zzf() {
        return this.zzc;
    }

    public final String zzg() {
        return this.zza;
    }

    public final String zzh() {
        return this.zze;
    }

    public final boolean zzi() {
        return this.zzd;
    }
}
