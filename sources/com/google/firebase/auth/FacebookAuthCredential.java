package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.internal.p003firebaseauthapi.zzaic;
import fe.a;

public class FacebookAuthCredential extends AuthCredential {
    @NonNull
    public static final Parcelable.Creator<FacebookAuthCredential> CREATOR = new zzh();
    private final String zza;

    FacebookAuthCredential(String str) {
        this.zza = p.g(str);
    }

    @NonNull
    public static zzaic zzb(@NonNull FacebookAuthCredential facebookAuthCredential, String str) {
        p.k(facebookAuthCredential);
        return new zzaic((String) null, facebookAuthCredential.zza, facebookAuthCredential.getProvider(), (String) null, (String) null, (String) null, str, (String) null, (String) null);
    }

    @NonNull
    public String getProvider() {
        return "facebook.com";
    }

    @NonNull
    public String getSignInMethod() {
        return "facebook.com";
    }

    public final void writeToParcel(@NonNull Parcel parcel, int i10) {
        String str = this.zza;
        int a10 = a.a(parcel);
        a.C(parcel, 1, str, false);
        a.b(parcel, a10);
    }

    @NonNull
    public final AuthCredential zza() {
        return new FacebookAuthCredential(this.zza);
    }
}
