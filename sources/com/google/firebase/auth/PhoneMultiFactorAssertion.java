package com.google.firebase.auth;

import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.p;

public class PhoneMultiFactorAssertion extends MultiFactorAssertion {
    private final PhoneAuthCredential zza;

    public PhoneMultiFactorAssertion(@NonNull PhoneAuthCredential phoneAuthCredential) {
        p.k(phoneAuthCredential);
        this.zza = phoneAuthCredential;
    }

    @NonNull
    public String getFactorId() {
        return "phone";
    }

    @NonNull
    public final PhoneAuthCredential zza() {
        return this.zza;
    }
}
