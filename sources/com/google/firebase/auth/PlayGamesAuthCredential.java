package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.internal.p003firebaseauthapi.zzaic;
import fe.a;

public class PlayGamesAuthCredential extends AuthCredential {
    @NonNull
    public static final Parcelable.Creator<PlayGamesAuthCredential> CREATOR = new zzat();
    private final String zza;

    PlayGamesAuthCredential(@NonNull String str) {
        this.zza = p.g(str);
    }

    public static zzaic zzb(@NonNull PlayGamesAuthCredential playGamesAuthCredential, String str) {
        p.k(playGamesAuthCredential);
        return new zzaic((String) null, (String) null, playGamesAuthCredential.getProvider(), (String) null, (String) null, playGamesAuthCredential.zza, str, (String) null, (String) null);
    }

    @NonNull
    public String getProvider() {
        return "playgames.google.com";
    }

    @NonNull
    public String getSignInMethod() {
        return "playgames.google.com";
    }

    public final void writeToParcel(@NonNull Parcel parcel, int i10) {
        String str = this.zza;
        int a10 = a.a(parcel);
        a.C(parcel, 1, str, false);
        a.b(parcel, a10);
    }

    @NonNull
    public final AuthCredential zza() {
        return new PlayGamesAuthCredential(this.zza);
    }
}
