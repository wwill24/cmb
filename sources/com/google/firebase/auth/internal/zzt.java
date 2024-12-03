package com.google.firebase.auth.internal;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.internal.p003firebaseauthapi.zzags;
import com.google.android.gms.internal.p003firebaseauthapi.zzahg;
import com.google.android.gms.internal.p003firebaseauthapi.zzzr;
import com.google.firebase.auth.UserInfo;
import com.leanplum.internal.Constants;
import fe.a;
import org.json.JSONException;
import org.json.b;

public final class zzt extends AbstractSafeParcelable implements UserInfo {
    public static final Parcelable.Creator<zzt> CREATOR = new zzu();
    @NonNull
    private final String zza;
    @NonNull
    private final String zzb;
    private final String zzc;
    private String zzd;
    private Uri zze;
    private final String zzf;
    private final String zzg;
    private final boolean zzh;
    private final String zzi;

    public zzt(zzags zzags, String str) {
        p.k(zzags);
        p.g("firebase");
        this.zza = p.g(zzags.zzo());
        this.zzb = "firebase";
        this.zzf = zzags.zzn();
        this.zzc = zzags.zzm();
        Uri zzc2 = zzags.zzc();
        if (zzc2 != null) {
            this.zzd = zzc2.toString();
            this.zze = zzc2;
        }
        this.zzh = zzags.zzs();
        this.zzi = null;
        this.zzg = zzags.zzp();
    }

    public final String getDisplayName() {
        return this.zzc;
    }

    public final String getEmail() {
        return this.zzf;
    }

    public final String getPhoneNumber() {
        return this.zzg;
    }

    public final Uri getPhotoUrl() {
        if (!TextUtils.isEmpty(this.zzd) && this.zze == null) {
            this.zze = Uri.parse(this.zzd);
        }
        return this.zze;
    }

    @NonNull
    public final String getProviderId() {
        return this.zzb;
    }

    @NonNull
    public final String getUid() {
        return this.zza;
    }

    public final boolean isEmailVerified() {
        return this.zzh;
    }

    public final void writeToParcel(@NonNull Parcel parcel, int i10) {
        String str = this.zza;
        int a10 = a.a(parcel);
        a.C(parcel, 1, str, false);
        a.C(parcel, 2, this.zzb, false);
        a.C(parcel, 3, this.zzc, false);
        a.C(parcel, 4, this.zzd, false);
        a.C(parcel, 5, this.zzf, false);
        a.C(parcel, 6, this.zzg, false);
        a.g(parcel, 7, this.zzh);
        a.C(parcel, 8, this.zzi, false);
        a.b(parcel, a10);
    }

    public final String zza() {
        return this.zzi;
    }

    public final String zzb() {
        b bVar = new b();
        try {
            bVar.putOpt(Constants.Params.USER_ID, this.zza);
            bVar.putOpt("providerId", this.zzb);
            bVar.putOpt("displayName", this.zzc);
            bVar.putOpt("photoUrl", this.zzd);
            bVar.putOpt("email", this.zzf);
            bVar.putOpt("phoneNumber", this.zzg);
            bVar.putOpt("isEmailVerified", Boolean.valueOf(this.zzh));
            bVar.putOpt("rawUserInfo", this.zzi);
            return bVar.toString();
        } catch (JSONException e10) {
            throw new zzzr(e10);
        }
    }

    public zzt(zzahg zzahg) {
        p.k(zzahg);
        this.zza = zzahg.zzd();
        this.zzb = p.g(zzahg.zzf());
        this.zzc = zzahg.zzb();
        Uri zza2 = zzahg.zza();
        if (zza2 != null) {
            this.zzd = zza2.toString();
            this.zze = zza2;
        }
        this.zzf = zzahg.zzc();
        this.zzg = zzahg.zze();
        this.zzh = false;
        this.zzi = zzahg.zzg();
    }

    public zzt(@NonNull String str, @NonNull String str2, String str3, String str4, String str5, String str6, boolean z10, String str7) {
        this.zza = str;
        this.zzb = str2;
        this.zzf = str3;
        this.zzg = str4;
        this.zzc = str5;
        this.zzd = str6;
        if (!TextUtils.isEmpty(str6)) {
            this.zze = Uri.parse(this.zzd);
        }
        this.zzh = z10;
        this.zzi = str7;
    }
}
