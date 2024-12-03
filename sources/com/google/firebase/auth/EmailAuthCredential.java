package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.p;
import fe.a;

public class EmailAuthCredential extends AuthCredential {
    @NonNull
    public static final Parcelable.Creator<EmailAuthCredential> CREATOR = new zzg();
    private final String zza;
    private String zzb;
    private final String zzc;
    private String zzd;
    private boolean zze;

    EmailAuthCredential(String str, String str2, String str3, String str4, boolean z10) {
        this.zza = p.g(str);
        if (!TextUtils.isEmpty(str2) || !TextUtils.isEmpty(str3)) {
            this.zzb = str2;
            this.zzc = str3;
            this.zzd = str4;
            this.zze = z10;
            return;
        }
        throw new IllegalArgumentException("Cannot create an EmailAuthCredential without a password or emailLink.");
    }

    public static boolean zzi(@NonNull String str) {
        ActionCodeUrl parseLink;
        if (!TextUtils.isEmpty(str) && (parseLink = ActionCodeUrl.parseLink(str)) != null && parseLink.getOperation() == 4) {
            return true;
        }
        return false;
    }

    @NonNull
    public String getProvider() {
        return "password";
    }

    @NonNull
    public String getSignInMethod() {
        return !TextUtils.isEmpty(this.zzb) ? "password" : EmailAuthProvider.EMAIL_LINK_SIGN_IN_METHOD;
    }

    public final void writeToParcel(@NonNull Parcel parcel, int i10) {
        String str = this.zza;
        int a10 = a.a(parcel);
        a.C(parcel, 1, str, false);
        a.C(parcel, 2, this.zzb, false);
        a.C(parcel, 3, this.zzc, false);
        a.C(parcel, 4, this.zzd, false);
        a.g(parcel, 5, this.zze);
        a.b(parcel, a10);
    }

    @NonNull
    public final AuthCredential zza() {
        return new EmailAuthCredential(this.zza, this.zzb, this.zzc, this.zzd, this.zze);
    }

    @NonNull
    public final EmailAuthCredential zzb(@NonNull FirebaseUser firebaseUser) {
        this.zzd = firebaseUser.zzf();
        this.zze = true;
        return this;
    }

    public final String zzc() {
        return this.zzd;
    }

    @NonNull
    public final String zzd() {
        return this.zza;
    }

    public final String zze() {
        return this.zzb;
    }

    public final String zzf() {
        return this.zzc;
    }

    public final boolean zzg() {
        return !TextUtils.isEmpty(this.zzc);
    }

    public final boolean zzh() {
        return this.zze;
    }
}
