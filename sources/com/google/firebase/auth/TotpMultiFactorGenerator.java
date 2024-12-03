package com.google.firebase.auth;

import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.internal.zzag;

public final class TotpMultiFactorGenerator {
    @NonNull
    public static final String FACTOR_ID = "totp";

    private TotpMultiFactorGenerator() {
    }

    @NonNull
    public static Task<TotpSecret> generateSecret(@NonNull MultiFactorSession multiFactorSession) {
        p.k(multiFactorSession);
        zzag zzag = (zzag) multiFactorSession;
        return FirebaseAuth.getInstance(zzag.zza().zza()).zzn(zzag);
    }

    @NonNull
    public static TotpMultiFactorAssertion getAssertionForEnrollment(@NonNull TotpSecret totpSecret, @NonNull String str) {
        return new TotpMultiFactorAssertion((String) p.k(str), (TotpSecret) p.k(totpSecret), (String) null);
    }

    @NonNull
    public static TotpMultiFactorAssertion getAssertionForSignIn(@NonNull String str, @NonNull String str2) {
        return new TotpMultiFactorAssertion((String) p.k(str2), (TotpSecret) null, (String) p.k(str));
    }
}
