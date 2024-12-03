package com.google.android.gms.internal.p003firebaseauthapi;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.p;
import com.google.firebase.FirebaseApp;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaem  reason: invalid package */
final class zzaem extends zzaff implements zzafw {
    zzaen zza;
    private zzaeg zzb;
    private zzaeh zzc;
    private zzafk zzd;
    private final zzael zze;
    private final FirebaseApp zzf;
    private final String zzg;

    zzaem(FirebaseApp firebaseApp, zzael zzael, zzafk zzafk, zzaeg zzaeg, zzaeh zzaeh) {
        this.zzf = firebaseApp;
        String apiKey = firebaseApp.getOptions().getApiKey();
        this.zzg = apiKey;
        this.zze = (zzael) p.k(zzael);
        zzy((zzafk) null, (zzaeg) null, (zzaeh) null);
        zzafx.zze(apiKey, this);
    }

    @NonNull
    private final zzaen zzx() {
        if (this.zza == null) {
            FirebaseApp firebaseApp = this.zzf;
            this.zza = new zzaen(firebaseApp.getApplicationContext(), firebaseApp, this.zze.zzb());
        }
        return this.zza;
    }

    private final void zzy(zzafk zzafk, zzaeg zzaeg, zzaeh zzaeh) {
        this.zzd = null;
        this.zzb = null;
        this.zzc = null;
        String zza2 = zzafu.zza("firebear.secureToken");
        if (TextUtils.isEmpty(zza2)) {
            zza2 = zzafx.zzd(this.zzg);
        } else {
            "Found hermetic configuration for secureToken URL: ".concat(String.valueOf(zza2));
        }
        if (this.zzd == null) {
            this.zzd = new zzafk(zza2, zzx());
        }
        String zza3 = zzafu.zza("firebear.identityToolkit");
        if (TextUtils.isEmpty(zza3)) {
            zza3 = zzafx.zzb(this.zzg);
        } else {
            "Found hermetic configuration for identityToolkit URL: ".concat(String.valueOf(zza3));
        }
        if (this.zzb == null) {
            this.zzb = new zzaeg(zza3, zzx());
        }
        String zza4 = zzafu.zza("firebear.identityToolkitV2");
        if (TextUtils.isEmpty(zza4)) {
            zza4 = zzafx.zzc(this.zzg);
        } else {
            "Found hermetic configuration for identityToolkitV2 URL: ".concat(String.valueOf(zza4));
        }
        if (this.zzc == null) {
            this.zzc = new zzaeh(zza4, zzx());
        }
    }

    public final void zza(zzagb zzagb, zzafe zzafe) {
        p.k(zzagb);
        p.k(zzafe);
        zzaeg zzaeg = this.zzb;
        zzafh.zzb(zzaeg.zza("/createAuthUri", this.zzg), zzagb, zzafe, zzagc.class, zzaeg.zzb);
    }

    public final void zzb(zzagd zzagd, zzafe zzafe) {
        p.k(zzagd);
        p.k(zzafe);
        zzaeg zzaeg = this.zzb;
        zzafh.zzb(zzaeg.zza("/deleteAccount", this.zzg), zzagd, zzafe, Void.class, zzaeg.zzb);
    }

    public final void zzc(zzage zzage, zzafe zzafe) {
        p.k(zzage);
        p.k(zzafe);
        zzaeg zzaeg = this.zzb;
        zzafh.zzb(zzaeg.zza("/emailLinkSignin", this.zzg), zzage, zzafe, zzagf.class, zzaeg.zzb);
    }

    public final void zzd(zzagg zzagg, zzafe zzafe) {
        p.k(zzagg);
        p.k(zzafe);
        zzaeh zzaeh = this.zzc;
        zzafh.zzb(zzaeh.zza("/accounts/mfaEnrollment:finalize", this.zzg), zzagg, zzafe, zzagh.class, zzaeh.zzb);
    }

    public final void zze(zzagi zzagi, zzafe zzafe) {
        p.k(zzagi);
        p.k(zzafe);
        zzaeh zzaeh = this.zzc;
        zzafh.zzb(zzaeh.zza("/accounts/mfaSignIn:finalize", this.zzg), zzagi, zzafe, zzagj.class, zzaeh.zzb);
    }

    public final void zzf(zzagp zzagp, zzafe zzafe) {
        p.k(zzagp);
        p.k(zzafe);
        zzafk zzafk = this.zzd;
        zzafh.zzb(zzafk.zza("/token", this.zzg), zzagp, zzafe, zzahb.class, zzafk.zzb);
    }

    public final void zzg(zzagq zzagq, zzafe zzafe) {
        p.k(zzagq);
        p.k(zzafe);
        zzaeg zzaeg = this.zzb;
        zzafh.zzb(zzaeg.zza("/getAccountInfo", this.zzg), zzagq, zzafe, zzagr.class, zzaeg.zzb);
    }

    public final void zzh(zzagu zzagu, zzafe zzafe) {
        p.k(zzagu);
        p.k(zzafe);
        if (zzagu.zzb() != null) {
            zzx().zzc(zzagu.zzb().zze());
        }
        zzaeg zzaeg = this.zzb;
        zzafh.zzb(zzaeg.zza("/getOobConfirmationCode", this.zzg), zzagu, zzafe, zzagv.class, zzaeg.zzb);
    }

    public final void zzi(zzagw zzagw, zzafe zzafe) {
        p.k(zzagw);
        p.k(zzafe);
        zzaeg zzaeg = this.zzb;
        zzafh.zza(zzaeg.zza("/getRecaptchaParam", this.zzg), zzafe, zzagx.class, zzaeg.zzb);
    }

    public final void zzj(zzagz zzagz, zzafe zzafe) {
        p.k(zzagz);
        p.k(zzafe);
        zzaeh zzaeh = this.zzc;
        String zza2 = zzaeh.zza("/recaptchaConfig", this.zzg);
        String zzc2 = zzagz.zzc();
        String zzd2 = zzagz.zzd();
        zzafh.zza(zza2 + "&clientType=" + zzc2 + "&version=" + zzd2, zzafe, zzaha.class, zzaeh.zzb);
    }

    public final void zzk() {
        zzy((zzafk) null, (zzaeg) null, (zzaeh) null);
    }

    public final void zzl(zzahj zzahj, zzafe zzafe) {
        p.k(zzahj);
        p.k(zzafe);
        zzaeg zzaeg = this.zzb;
        zzafh.zzb(zzaeg.zza("/resetPassword", this.zzg), zzahj, zzafe, zzahk.class, zzaeg.zzb);
    }

    public final void zzm(zzahl zzahl, zzafe zzafe) {
        p.k(zzahl);
        p.k(zzafe);
        if (!TextUtils.isEmpty(zzahl.zzc())) {
            zzx().zzc(zzahl.zzc());
        }
        zzaeg zzaeg = this.zzb;
        zzafh.zzb(zzaeg.zza("/sendVerificationCode", this.zzg), zzahl, zzafe, zzahm.class, zzaeg.zzb);
    }

    public final void zzn(zzahn zzahn, zzafe zzafe) {
        p.k(zzahn);
        p.k(zzafe);
        zzaeg zzaeg = this.zzb;
        zzafh.zzb(zzaeg.zza("/setAccountInfo", this.zzg), zzahn, zzafe, zzaho.class, zzaeg.zzb);
    }

    public final void zzo(String str, zzafe zzafe) {
        p.k(zzafe);
        zzx().zzb(str);
        ((zzabq) zzafe).zza.zzo();
    }

    public final void zzp(zzahp zzahp, zzafe zzafe) {
        p.k(zzahp);
        p.k(zzafe);
        zzaeg zzaeg = this.zzb;
        zzafh.zzb(zzaeg.zza("/signupNewUser", this.zzg), zzahp, zzafe, zzahq.class, zzaeg.zzb);
    }

    public final void zzq(zzahr zzahr, zzafe zzafe) {
        p.k(zzahr);
        p.k(zzafe);
        if (zzahr instanceof zzahv) {
            zzahv zzahv = (zzahv) zzahr;
            if (!TextUtils.isEmpty(zzahv.zzc())) {
                zzx().zzc(zzahv.zzc());
            }
        }
        zzaeh zzaeh = this.zzc;
        zzafh.zzb(zzaeh.zza("/accounts/mfaEnrollment:start", this.zzg), zzahr, zzafe, zzahs.class, zzaeh.zzb);
    }

    public final void zzr(zzaht zzaht, zzafe zzafe) {
        p.k(zzaht);
        p.k(zzafe);
        if (!TextUtils.isEmpty(zzaht.zzc())) {
            zzx().zzc(zzaht.zzc());
        }
        zzaeh zzaeh = this.zzc;
        zzafh.zzb(zzaeh.zza("/accounts/mfaSignIn:start", this.zzg), zzaht, zzafe, zzahu.class, zzaeh.zzb);
    }

    public final void zzs(zzaic zzaic, zzafe zzafe) {
        p.k(zzaic);
        p.k(zzafe);
        zzaeg zzaeg = this.zzb;
        zzafh.zzb(zzaeg.zza("/verifyAssertion", this.zzg), zzaic, zzafe, zzaie.class, zzaeg.zzb);
    }

    public final void zzt(zzaif zzaif, zzafe zzafe) {
        p.k(zzaif);
        p.k(zzafe);
        zzaeg zzaeg = this.zzb;
        zzafh.zzb(zzaeg.zza("/verifyCustomToken", this.zzg), zzaif, zzafe, zzaig.class, zzaeg.zzb);
    }

    public final void zzu(zzaih zzaih, zzafe zzafe) {
        p.k(zzaih);
        p.k(zzafe);
        zzaeg zzaeg = this.zzb;
        zzafh.zzb(zzaeg.zza("/verifyPassword", this.zzg), zzaih, zzafe, zzaii.class, zzaeg.zzb);
    }

    public final void zzv(zzaij zzaij, zzafe zzafe) {
        p.k(zzaij);
        p.k(zzafe);
        zzaeg zzaeg = this.zzb;
        zzafh.zzb(zzaeg.zza("/verifyPhoneNumber", this.zzg), zzaij, zzafe, zzaik.class, zzaeg.zzb);
    }

    public final void zzw(zzail zzail, zzafe zzafe) {
        p.k(zzail);
        p.k(zzafe);
        zzaeh zzaeh = this.zzc;
        zzafh.zzb(zzaeh.zza("/accounts/mfaEnrollment:withdraw", this.zzg), zzail, zzafe, zzaim.class, zzaeh.zzb);
    }
}
