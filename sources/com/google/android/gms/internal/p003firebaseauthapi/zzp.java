package com.google.android.gms.internal.p003firebaseauthapi;

import java.io.Serializable;
import java.util.regex.Pattern;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzp  reason: invalid package */
final class zzp extends zzm implements Serializable {
    private final Pattern zza;

    zzp(Pattern pattern) {
        pattern.getClass();
        this.zza = pattern;
    }

    public final String toString() {
        return this.zza.toString();
    }

    public final zzl zza(CharSequence charSequence) {
        return new zzo(this.zza.matcher(charSequence));
    }
}
