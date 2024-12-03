package com.google.android.gms.internal.p003firebaseauthapi;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.firebase.auth.internal.zzi;
import fe.a;
import org.json.JSONException;
import org.json.b;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaic  reason: invalid package */
public final class zzaic extends AbstractSafeParcelable implements zzaej {
    public static final Parcelable.Creator<zzaic> CREATOR = new zzaid();
    private String zza;
    private String zzb;
    private String zzc;
    private String zzd;
    private String zze;
    private String zzf;
    private String zzg;
    private String zzh;
    private boolean zzi;
    private boolean zzj;
    private String zzk;
    private String zzl;
    private String zzm;
    private String zzn;
    private boolean zzo;
    private String zzp;

    public zzaic() {
        this.zzi = true;
        this.zzj = true;
    }

    public final void writeToParcel(@NonNull Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.C(parcel, 2, this.zza, false);
        a.C(parcel, 3, this.zzb, false);
        a.C(parcel, 4, this.zzc, false);
        a.C(parcel, 5, this.zzd, false);
        a.C(parcel, 6, this.zze, false);
        a.C(parcel, 7, this.zzf, false);
        a.C(parcel, 8, this.zzg, false);
        a.C(parcel, 9, this.zzh, false);
        a.g(parcel, 10, this.zzi);
        a.g(parcel, 11, this.zzj);
        a.C(parcel, 12, this.zzk, false);
        a.C(parcel, 13, this.zzl, false);
        a.C(parcel, 14, this.zzm, false);
        a.C(parcel, 15, this.zzn, false);
        a.g(parcel, 16, this.zzo);
        a.C(parcel, 17, this.zzp, false);
        a.b(parcel, a10);
    }

    public final String zza() throws JSONException {
        b bVar = new b();
        bVar.put("autoCreate", this.zzj);
        bVar.put("returnSecureToken", this.zzi);
        String str = this.zzb;
        if (str != null) {
            bVar.put("idToken", (Object) str);
        }
        String str2 = this.zzg;
        if (str2 != null) {
            bVar.put("postBody", (Object) str2);
        }
        String str3 = this.zzn;
        if (str3 != null) {
            bVar.put("tenantId", (Object) str3);
        }
        String str4 = this.zzp;
        if (str4 != null) {
            bVar.put("pendingToken", (Object) str4);
        }
        if (!TextUtils.isEmpty(this.zzl)) {
            bVar.put("sessionId", (Object) this.zzl);
        }
        if (!TextUtils.isEmpty(this.zzm)) {
            bVar.put("requestUri", (Object) this.zzm);
        } else {
            String str5 = this.zza;
            if (str5 != null) {
                bVar.put("requestUri", (Object) str5);
            }
        }
        bVar.put("returnIdpCredential", this.zzo);
        return bVar.toString();
    }

    public final zzaic zzb(boolean z10) {
        this.zzj = false;
        return this;
    }

    public final zzaic zzc(String str) {
        this.zzb = p.g(str);
        return this;
    }

    public final zzaic zzd(boolean z10) {
        this.zzo = true;
        return this;
    }

    public final zzaic zze(boolean z10) {
        this.zzi = true;
        return this;
    }

    public final zzaic zzf(String str) {
        this.zzn = str;
        return this;
    }

    public zzaic(zzi zzi2, String str) {
        p.k(zzi2);
        this.zzl = p.g(zzi2.zzd());
        this.zzm = p.g(str);
        String g10 = p.g(zzi2.zzc());
        this.zze = g10;
        this.zzi = true;
        this.zzg = "providerId=".concat(String.valueOf(g10));
    }

    public zzaic(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        this.zza = "http://localhost";
        this.zzc = str;
        this.zzd = str2;
        this.zzh = str5;
        this.zzk = str6;
        this.zzn = str7;
        this.zzp = str8;
        this.zzi = true;
        if (!TextUtils.isEmpty(str) || !TextUtils.isEmpty(this.zzd) || !TextUtils.isEmpty(this.zzk)) {
            this.zze = p.g(str3);
            this.zzf = null;
            StringBuilder sb2 = new StringBuilder();
            if (!TextUtils.isEmpty(this.zzc)) {
                sb2.append("id_token=");
                sb2.append(this.zzc);
                sb2.append("&");
            }
            if (!TextUtils.isEmpty(this.zzd)) {
                sb2.append("access_token=");
                sb2.append(this.zzd);
                sb2.append("&");
            }
            if (!TextUtils.isEmpty(this.zzf)) {
                sb2.append("identifier=");
                sb2.append(this.zzf);
                sb2.append("&");
            }
            if (!TextUtils.isEmpty(this.zzh)) {
                sb2.append("oauth_token_secret=");
                sb2.append(this.zzh);
                sb2.append("&");
            }
            if (!TextUtils.isEmpty(this.zzk)) {
                sb2.append("code=");
                sb2.append(this.zzk);
                sb2.append("&");
            }
            if (!TextUtils.isEmpty(str9)) {
                sb2.append("nonce=");
                sb2.append(str9);
                sb2.append("&");
            }
            sb2.append("providerId=");
            sb2.append(this.zze);
            this.zzg = sb2.toString();
            this.zzj = true;
            return;
        }
        throw new IllegalArgumentException("idToken, accessToken and authCode cannot all be null");
    }

    zzaic(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z10, boolean z11, String str9, String str10, String str11, String str12, boolean z12, String str13) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
        this.zzd = str4;
        this.zze = str5;
        this.zzf = str6;
        this.zzg = str7;
        this.zzh = str8;
        this.zzi = z10;
        this.zzj = z11;
        this.zzk = str9;
        this.zzl = str10;
        this.zzm = str11;
        this.zzn = str12;
        this.zzo = z12;
        this.zzp = str13;
    }
}
