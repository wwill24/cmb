package com.google.android.recaptcha.internal;

import com.google.android.recaptcha.RecaptchaErrorCode;
import com.google.android.recaptcha.RecaptchaException;
import gk.h;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;

public final class zzh extends Exception {
    public static final zzg zza = new zzg((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final Map zzb;
    private final zzf zzc;
    private final zzd zzd;
    private final Map zze = h0.l(h.a(zzf.zze, new RecaptchaException(RecaptchaErrorCode.NETWORK_ERROR, (String) null, 2, (DefaultConstructorMarker) null)), h.a(zzf.zzf, new RecaptchaException(RecaptchaErrorCode.INVALID_SITEKEY, (String) null, 2, (DefaultConstructorMarker) null)), h.a(zzf.zzg, new RecaptchaException(RecaptchaErrorCode.INVALID_KEYTYPE, (String) null, 2, (DefaultConstructorMarker) null)), h.a(zzf.zzh, new RecaptchaException(RecaptchaErrorCode.INVALID_PACKAGE_NAME, (String) null, 2, (DefaultConstructorMarker) null)), h.a(zzf.zzi, new RecaptchaException(RecaptchaErrorCode.INVALID_ACTION, (String) null, 2, (DefaultConstructorMarker) null)), h.a(zzf.zzc, new RecaptchaException(RecaptchaErrorCode.INTERNAL_ERROR, (String) null, 2, (DefaultConstructorMarker) null)));

    static {
        zzmf zzmf = zzmf.JS_INTERNAL_ERROR;
        zzf zzf = zzf.zzc;
        zzb = h0.l(h.a(zzmf.JS_NETWORK_ERROR, new zzh(zzf.zze, zzd.zzm)), h.a(zzmf, new zzh(zzf, zzd.zzk)), h.a(zzmf.JS_INVALID_SITE_KEY, new zzh(zzf.zzf, zzd.zzn)), h.a(zzmf.JS_INVALID_SITE_KEY_TYPE, new zzh(zzf.zzg, zzd.zzo)), h.a(zzmf.JS_THIRD_PARTY_APP_PACKAGE_NAME_NOT_ALLOWED, new zzh(zzf.zzh, zzd.zzp)), h.a(zzmf.JS_INVALID_ACTION, new zzh(zzf.zzi, zzd.zzq)), h.a(zzmf.JS_PROGRAM_ERROR, new zzh(zzf, zzd.zzv)));
    }

    public zzh(zzf zzf, zzd zzd2) {
        this.zzc = zzf;
        this.zzd = zzd2;
    }

    public final zzd zza() {
        return this.zzd;
    }

    public final zzf zzb() {
        return this.zzc;
    }

    public final RecaptchaException zzc() {
        RecaptchaException recaptchaException = (RecaptchaException) this.zze.get(this.zzc);
        if (recaptchaException == null) {
            return new RecaptchaException(RecaptchaErrorCode.UNKNOWN_ERROR, (String) null, 2, (DefaultConstructorMarker) null);
        }
        return recaptchaException;
    }
}
