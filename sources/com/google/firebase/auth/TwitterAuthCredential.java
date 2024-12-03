package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.internal.p003firebaseauthapi.zzaic;
import fe.a;

public class TwitterAuthCredential extends AuthCredential {
    @NonNull
    public static final Parcelable.Creator<TwitterAuthCredential> CREATOR = new zzav();
    private final String zza;
    private final String zzb;

    TwitterAuthCredential(@NonNull String str, @NonNull String str2) {
        this.zza = p.g(str);
        this.zzb = p.g(str2);
    }

    public static zzaic zzb(@NonNull TwitterAuthCredential twitterAuthCredential, String str) {
        p.k(twitterAuthCredential);
        return new zzaic((String) null, twitterAuthCredential.zza, twitterAuthCredential.getProvider(), (String) null, twitterAuthCredential.zzb, (String) null, str, (String) null, (String) null);
    }

    @NonNull
    public String getProvider() {
        return "twitter.com";
    }

    @NonNull
    public String getSignInMethod() {
        return "twitter.com";
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
        return new TwitterAuthCredential(this.zza, this.zzb);
    }
}
