package com.google.firebase.auth;

import android.app.Activity;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.p;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.auth.internal.zzag;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

public final class PhoneAuthOptions {
    private final FirebaseAuth zza;
    private final Long zzb;
    private final PhoneAuthProvider.OnVerificationStateChangedCallbacks zzc;
    private final Executor zzd;
    private final String zze;
    private final Activity zzf;
    private final PhoneAuthProvider.ForceResendingToken zzg;
    private final MultiFactorSession zzh;
    private final PhoneMultiFactorInfo zzi;
    private final boolean zzj;
    private boolean zzk;

    public static final class Builder {
        private final FirebaseAuth zza;
        private String zzb;
        private Long zzc;
        private PhoneAuthProvider.OnVerificationStateChangedCallbacks zzd;
        private Executor zze;
        private Activity zzf;
        private PhoneAuthProvider.ForceResendingToken zzg;
        private MultiFactorSession zzh;
        private PhoneMultiFactorInfo zzi;
        private boolean zzj;

        public Builder(@NonNull FirebaseAuth firebaseAuth) {
            this.zza = (FirebaseAuth) p.k(firebaseAuth);
        }

        @NonNull
        public PhoneAuthOptions build() {
            boolean z10;
            p.l(this.zza, "FirebaseAuth instance cannot be null");
            p.l(this.zzc, "You must specify an auto-retrieval timeout; please call #setTimeout()");
            p.l(this.zzd, "You must specify callbacks on your PhoneAuthOptions. Please call #setCallbacks()");
            this.zze = this.zza.zzN();
            if (this.zzc.longValue() < 0 || this.zzc.longValue() > 120) {
                throw new IllegalArgumentException("We only support 0-120 seconds for sms-auto-retrieval timeout");
            }
            MultiFactorSession multiFactorSession = this.zzh;
            boolean z11 = false;
            if (multiFactorSession == null) {
                p.h(this.zzb, "The given phoneNumber is empty. Please set a non-empty phone number with #setPhoneNumber()");
                p.b(!this.zzj, "You cannot require sms validation without setting a multi-factor session.");
                if (this.zzi == null) {
                    z11 = true;
                }
                p.b(z11, "A phoneMultiFactorInfo must be set for second factor sign-in.");
            } else if (((zzag) multiFactorSession).zzf()) {
                p.g(this.zzb);
                if (this.zzi == null) {
                    z11 = true;
                }
                p.b(z11, "Invalid MultiFactorSession - use the getSession method in MultiFactorResolver to get a valid sign-in session.");
            } else {
                if (this.zzi != null) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                p.b(z10, "A phoneMultiFactorInfo must be set for second factor sign-in.");
                if (this.zzb == null) {
                    z11 = true;
                }
                p.b(z11, "A phone number must not be set for MFA sign-in. A PhoneMultiFactorInfo should be set instead.");
            }
            return new PhoneAuthOptions(this.zza, this.zzc, this.zzd, this.zze, this.zzb, this.zzf, this.zzg, this.zzh, this.zzi, this.zzj, (zzar) null);
        }

        @NonNull
        public Builder requireSmsValidation(boolean z10) {
            this.zzj = z10;
            return this;
        }

        @NonNull
        public Builder setActivity(@NonNull Activity activity) {
            this.zzf = activity;
            return this;
        }

        @NonNull
        public Builder setCallbacks(@NonNull PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks) {
            this.zzd = onVerificationStateChangedCallbacks;
            return this;
        }

        @NonNull
        public Builder setForceResendingToken(@NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
            this.zzg = forceResendingToken;
            return this;
        }

        @NonNull
        public Builder setMultiFactorHint(@NonNull PhoneMultiFactorInfo phoneMultiFactorInfo) {
            this.zzi = phoneMultiFactorInfo;
            return this;
        }

        @NonNull
        public Builder setMultiFactorSession(@NonNull MultiFactorSession multiFactorSession) {
            this.zzh = multiFactorSession;
            return this;
        }

        @NonNull
        public Builder setPhoneNumber(@NonNull String str) {
            this.zzb = str;
            return this;
        }

        @NonNull
        public Builder setTimeout(@NonNull Long l10, @NonNull TimeUnit timeUnit) {
            this.zzc = Long.valueOf(TimeUnit.SECONDS.convert(l10.longValue(), timeUnit));
            return this;
        }
    }

    /* synthetic */ PhoneAuthOptions(FirebaseAuth firebaseAuth, Long l10, PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks, Executor executor, String str, Activity activity, PhoneAuthProvider.ForceResendingToken forceResendingToken, MultiFactorSession multiFactorSession, PhoneMultiFactorInfo phoneMultiFactorInfo, boolean z10, zzar zzar) {
        this.zza = firebaseAuth;
        this.zze = str;
        this.zzb = l10;
        this.zzc = onVerificationStateChangedCallbacks;
        this.zzf = activity;
        this.zzd = executor;
        this.zzg = forceResendingToken;
        this.zzh = multiFactorSession;
        this.zzi = phoneMultiFactorInfo;
        this.zzj = z10;
    }

    @NonNull
    public static Builder newBuilder() {
        return new Builder(FirebaseAuth.getInstance());
    }

    public final Activity zza() {
        return this.zzf;
    }

    @NonNull
    public final FirebaseAuth zzb() {
        return this.zza;
    }

    public final MultiFactorSession zzc() {
        return this.zzh;
    }

    public final PhoneAuthProvider.ForceResendingToken zzd() {
        return this.zzg;
    }

    @NonNull
    public final PhoneAuthProvider.OnVerificationStateChangedCallbacks zze() {
        return this.zzc;
    }

    public final PhoneMultiFactorInfo zzf() {
        return this.zzi;
    }

    @NonNull
    public final Long zzg() {
        return this.zzb;
    }

    public final String zzh() {
        return this.zze;
    }

    @NonNull
    public final Executor zzi() {
        return this.zzd;
    }

    public final void zzj(boolean z10) {
        this.zzk = true;
    }

    public final boolean zzk() {
        return this.zzk;
    }

    public final boolean zzl() {
        return this.zzj;
    }

    public final boolean zzm() {
        return this.zzh != null;
    }

    @NonNull
    public static Builder newBuilder(@NonNull FirebaseAuth firebaseAuth) {
        return new Builder(firebaseAuth);
    }
}
