package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.internal.p003firebaseauthapi.zzaic;
import fe.a;

public class GithubAuthCredential extends AuthCredential {
    @NonNull
    public static final Parcelable.Creator<GithubAuthCredential> CREATOR = new zzal();
    private final String zza;

    GithubAuthCredential(String str) {
        this.zza = p.g(str);
    }

    public static zzaic zzb(@NonNull GithubAuthCredential githubAuthCredential, String str) {
        p.k(githubAuthCredential);
        return new zzaic((String) null, githubAuthCredential.zza, githubAuthCredential.getProvider(), (String) null, (String) null, (String) null, str, (String) null, (String) null);
    }

    @NonNull
    public String getProvider() {
        return "github.com";
    }

    @NonNull
    public String getSignInMethod() {
        return "github.com";
    }

    public final void writeToParcel(@NonNull Parcel parcel, int i10) {
        String str = this.zza;
        int a10 = a.a(parcel);
        a.C(parcel, 1, str, false);
        a.b(parcel, a10);
    }

    @NonNull
    public final AuthCredential zza() {
        return new GithubAuthCredential(this.zza);
    }
}
