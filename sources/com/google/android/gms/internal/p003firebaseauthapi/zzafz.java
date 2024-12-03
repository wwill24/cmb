package com.google.android.gms.internal.p003firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzafz  reason: invalid package */
final class zzafz extends zzahi {
    private final String zza;
    private final String zzb;

    zzafz(String str, String str2) {
        this.zza = str;
        this.zzb = str2;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzahi) {
            zzahi zzahi = (zzahi) obj;
            String str = this.zza;
            if (str != null ? str.equals(zzahi.zzb()) : zzahi.zzb() == null) {
                String str2 = this.zzb;
                if (str2 != null ? str2.equals(zzahi.zza()) : zzahi.zza() == null) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        int i10;
        String str = this.zza;
        int i11 = 0;
        if (str == null) {
            i10 = 0;
        } else {
            i10 = str.hashCode();
        }
        String str2 = this.zzb;
        if (str2 != null) {
            i11 = str2.hashCode();
        }
        return ((i10 ^ 1000003) * 1000003) ^ i11;
    }

    public final String toString() {
        return "RecaptchaEnforcementState{provider=" + this.zza + ", enforcementState=" + this.zzb + "}";
    }

    /* access modifiers changed from: package-private */
    public final String zza() {
        return this.zzb;
    }

    /* access modifiers changed from: package-private */
    public final String zzb() {
        return this.zza;
    }
}
