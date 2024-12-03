package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.internal.p003firebaseauthapi.zzaic;
import fe.a;

public class GoogleAuthCredential extends AuthCredential {
    @NonNull
    public static final Parcelable.Creator<GoogleAuthCredential> CREATOR = new zzam();
    private final String zza;
    private final String zzb;

    GoogleAuthCredential(String str, String str2) {
        if (str == null && str2 == null) {
            throw new IllegalArgumentException("Must specify an idToken or an accessToken.");
        } else if (str != null && str.length() == 0) {
            throw new IllegalArgumentException("idToken cannot be empty");
        } else if (str2 == null || str2.length() != 0) {
            this.zza = str;
            this.zzb = str2;
        } else {
            throw new IllegalArgumentException("accessToken cannot be empty");
        }
    }

    public static zzaic zzb(@NonNull GoogleAuthCredential googleAuthCredential, String str) {
        p.k(googleAuthCredential);
        return new zzaic(googleAuthCredential.zza, googleAuthCredential.zzb, googleAuthCredential.getProvider(), (String) null, (String) null, (String) null, str, (String) null, (String) null);
    }

    @NonNull
    public String getProvider() {
        return "google.com";
    }

    @NonNull
    public String getSignInMethod() {
        return "google.com";
    }

    public final void writeToParcel(@NonNull Parcel parcel, int i10) {
        String str = this.zza;
        int a10 = a.a(parcel);
        a.C(parcel, 1, str, false);
        a.C(parcel, 2, this.zzb, false);
        a.b(parcel, a10);
    }

    @NonNull
    public final AuthCredential zza() {
        return new GoogleAuthCredential(this.zza, this.zzb);
    }
}
