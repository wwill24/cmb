package com.google.android.gms.internal.p003firebaseauthapi;

import android.content.Context;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.p;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.MultiFactorAssertion;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneMultiFactorAssertion;
import com.google.firebase.auth.TotpMultiFactorAssertion;
import com.google.firebase.auth.TotpSecret;
import com.google.firebase.auth.UserProfileChangeRequest;
import he.a;
import java.util.concurrent.ScheduledExecutorService;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzady  reason: invalid package */
public final class zzady {
    private static final a zza = new a("FirebaseAuth", "FirebaseAuthFallback:");
    private final zzabz zzb;
    private final zzaft zzc;

    zzady(FirebaseApp firebaseApp, ScheduledExecutorService scheduledExecutorService) {
        p.k(firebaseApp);
        Context applicationContext = firebaseApp.getApplicationContext();
        p.k(applicationContext);
        this.zzb = new zzabz(new zzaem(firebaseApp, zzael.zza(), (zzafk) null, (zzaeg) null, (zzaeh) null));
        this.zzc = new zzaft(applicationContext, scheduledExecutorService);
    }

    private static boolean zzJ(long j10, boolean z10) {
        if (j10 > 0 && z10) {
            return true;
        }
        zza.h("App hash will not be appended to the request.", new Object[0]);
        return false;
    }

    public final void zzA(zzaab zzaab, zzadw zzadw) {
        p.k(zzadw);
        p.k(zzaab);
        this.zzb.zzG(zzafj.zza((PhoneAuthCredential) p.k(zzaab.zza())), new zzadx(zzadw, zza));
    }

    public final void zzB(String str, String str2, String str3, long j10, boolean z10, boolean z11, String str4, String str5, boolean z12, zzadw zzadw) {
        String str6 = str2;
        String str7 = str;
        p.h(str, "idToken should not be empty.");
        p.k(zzadw);
        zzadx zzadx = new zzadx(zzadw, zza);
        if (this.zzc.zzk(str2)) {
            if (z10) {
                this.zzc.zzi(str2);
            } else {
                this.zzc.zzh(zzadx, str2);
                return;
            }
        }
        zzahv zzb2 = zzahv.zzb(str, str2, str3, str4, str5, (String) null);
        long j11 = j10;
        if (zzJ(j10, z12)) {
            zzb2.zzd(new zzafy(this.zzc.zzb()));
        }
        this.zzc.zzj(str2, zzadx, j10, z12);
        this.zzb.zzH(zzb2, new zzafq(this.zzc, zzadx, str2));
    }

    public final void zzC(zzaac zzaac, zzadw zzadw) {
        p.k(zzaac);
        p.k(zzadw);
        String phoneNumber = zzaac.zzb().getPhoneNumber();
        zzadx zzadx = new zzadx(zzadw, zza);
        if (this.zzc.zzk(phoneNumber)) {
            if (zzaac.zzg()) {
                this.zzc.zzi(phoneNumber);
            } else {
                this.zzc.zzh(zzadx, phoneNumber);
                return;
            }
        }
        long zza2 = zzaac.zza();
        boolean zzh = zzaac.zzh();
        zzaht zzb2 = zzaht.zzb(zzaac.zzd(), zzaac.zzb().getUid(), zzaac.zzb().getPhoneNumber(), zzaac.zzc(), zzaac.zzf(), zzaac.zze());
        if (zzJ(zza2, zzh)) {
            zzb2.zzd(new zzafy(this.zzc.zzb()));
        }
        this.zzc.zzj(phoneNumber, zzadx, zza2, zzh);
        this.zzb.zzI(zzb2, new zzafq(this.zzc, zzadx, phoneNumber));
    }

    public final void zzD(zzahx zzahx, zzadw zzadw) {
        this.zzb.zzH(zzahx, new zzadx((zzadw) p.k(zzadw), zza));
    }

    public final void zzE(String str, String str2, String str3, zzadw zzadw) {
        p.h(str, "cachedTokenState should not be empty.");
        p.h(str2, "uid should not be empty.");
        p.k(zzadw);
        this.zzb.zzJ(str, str2, str3, new zzadx(zzadw, zza));
    }

    public final void zzF(String str, zzadw zzadw) {
        p.g(str);
        p.k(zzadw);
        this.zzb.zzK(str, new zzadx(zzadw, zza));
    }

    public final void zzG(String str, String str2, zzadw zzadw) {
        p.g(str);
        p.g(str2);
        p.k(zzadw);
        this.zzb.zzL(str, str2, new zzadx(zzadw, zza));
    }

    public final void zzH(String str, UserProfileChangeRequest userProfileChangeRequest, zzadw zzadw) {
        p.g(str);
        p.k(userProfileChangeRequest);
        p.k(zzadw);
        this.zzb.zzM(str, userProfileChangeRequest, new zzadx(zzadw, zza));
    }

    public final void zzI(zzaad zzaad, zzadw zzadw) {
        p.k(zzaad);
        this.zzb.zzN(zzagu.zzc(zzaad.zza(), zzaad.zzb(), zzaad.zzc()), new zzadx(zzadw, zza));
    }

    public final void zza(String str, String str2, zzadw zzadw) {
        p.g(str);
        p.k(zzadw);
        this.zzb.zzg(str, str2, new zzadx(zzadw, zza));
    }

    public final void zzb(String str, String str2, zzadw zzadw) {
        p.g(str);
        p.g(str2);
        p.k(zzadw);
        this.zzb.zzh(str, str2, new zzadx(zzadw, zza));
    }

    public final void zzc(String str, String str2, zzadw zzadw) {
        p.g(str);
        p.g(str2);
        p.k(zzadw);
        this.zzb.zzi(str, str2, new zzadx(zzadw, zza));
    }

    public final void zzd(String str, String str2, zzadw zzadw) {
        p.g(str);
        p.k(zzadw);
        this.zzb.zzj(str, str2, new zzadx(zzadw, zza));
    }

    public final void zze(zzzs zzzs, zzadw zzadw) {
        p.k(zzzs);
        p.g(zzzs.zza());
        p.g(zzzs.zzb());
        p.k(zzadw);
        this.zzb.zzk(zzzs.zza(), zzzs.zzb(), zzzs.zzc(), new zzadx(zzadw, zza));
    }

    public final void zzf(String str, String str2, String str3, String str4, zzadw zzadw) {
        p.g(str);
        p.g(str2);
        p.k(zzadw);
        this.zzb.zzl(str, str2, str3, str4, new zzadx(zzadw, zza));
    }

    public final void zzg(String str, zzadw zzadw) {
        p.g(str);
        p.k(zzadw);
        this.zzb.zzm(str, new zzadx(zzadw, zza));
    }

    public final void zzh(MultiFactorAssertion multiFactorAssertion, String str, String str2, String str3, zzadw zzadw) {
        zzagg zzagg;
        p.k(multiFactorAssertion);
        p.h(str, "cachedTokenState should not be empty.");
        p.k(zzadw);
        if (multiFactorAssertion instanceof PhoneMultiFactorAssertion) {
            PhoneAuthCredential zza2 = ((PhoneMultiFactorAssertion) multiFactorAssertion).zza();
            zzagg = zzagk.zzc(str, (String) p.k(zza2.zzg()), (String) p.k(zza2.getSmsCode()), str2, str3);
        } else if (multiFactorAssertion instanceof TotpMultiFactorAssertion) {
            TotpMultiFactorAssertion totpMultiFactorAssertion = (TotpMultiFactorAssertion) multiFactorAssertion;
            zzagg = zzagm.zzc(str, p.g(str2), p.g(((TotpSecret) p.k(totpMultiFactorAssertion.zza())).getSessionInfo()), p.g(totpMultiFactorAssertion.zzc()), str3);
        } else {
            throw new IllegalArgumentException("multiFactorAssertion must be either PhoneMultiFactorAssertion or TotpMultiFactorAssertion.");
        }
        this.zzb.zzn(zzagg, str, new zzadx(zzadw, zza));
    }

    public final void zzi(String str, MultiFactorAssertion multiFactorAssertion, String str2, zzadw zzadw) {
        p.g(str);
        p.k(multiFactorAssertion);
        p.k(zzadw);
        if (multiFactorAssertion instanceof PhoneMultiFactorAssertion) {
            PhoneAuthCredential zza2 = ((PhoneMultiFactorAssertion) multiFactorAssertion).zza();
            this.zzb.zzo(zzagl.zzb(str, (String) p.k(zza2.zzg()), (String) p.k(zza2.getSmsCode()), str2), new zzadx(zzadw, zza));
        } else if (multiFactorAssertion instanceof TotpMultiFactorAssertion) {
            TotpMultiFactorAssertion totpMultiFactorAssertion = (TotpMultiFactorAssertion) multiFactorAssertion;
            this.zzb.zzo(zzagn.zzb(str, p.g(totpMultiFactorAssertion.zzc()), str2, p.g(totpMultiFactorAssertion.zzb())), new zzadx(zzadw, zza));
        } else {
            throw new IllegalArgumentException("multiFactorAssertion must be either PhoneMultiFactorAssertion or TotpMultiFactorAssertion.");
        }
    }

    public final void zzj(String str, zzadw zzadw) {
        p.g(str);
        p.k(zzadw);
        this.zzb.zzp(str, new zzadx(zzadw, zza));
    }

    public final void zzk(zzzt zzzt, zzadw zzadw) {
        p.k(zzzt);
        this.zzb.zzq(zzagw.zzb(), new zzadx(zzadw, zza));
    }

    public final void zzl(String str, String str2, zzadw zzadw) {
        p.g(str);
        this.zzb.zzr(str, str2, new zzadx(zzadw, zza));
    }

    public final void zzm(zzzu zzzu, zzadw zzadw) {
        p.k(zzzu);
        this.zzb.zzs(zzagz.zzb(zzzu.zzb(), zzzu.zza()), new zzadx(zzadw, zza));
    }

    public final void zzn(String str, String str2, String str3, zzadw zzadw) {
        p.g(str);
        p.g(str2);
        p.g(str3);
        p.k(zzadw);
        this.zzb.zzt(str, str2, str3, new zzadx(zzadw, zza));
    }

    public final void zzo(String str, zzaic zzaic, zzadw zzadw) {
        p.g(str);
        p.k(zzaic);
        p.k(zzadw);
        this.zzb.zzu(str, zzaic, new zzadx(zzadw, zza));
    }

    public final void zzp(zzzv zzzv, zzadw zzadw) {
        p.k(zzadw);
        p.k(zzzv);
        this.zzb.zzv(p.g(zzzv.zzb()), zzafj.zza((PhoneAuthCredential) p.k(zzzv.zza())), new zzadx(zzadw, zza));
    }

    public final void zzq(String str, zzadw zzadw) {
        p.g(str);
        p.k(zzadw);
        this.zzb.zzw(str, new zzadx(zzadw, zza));
    }

    public final void zzr(@NonNull zzzw zzzw, zzadw zzadw) {
        p.k(zzzw);
        p.g(zzzw.zzb());
        p.k(zzadw);
        this.zzb.zzx(zzzw.zzb(), zzzw.zza(), new zzadx(zzadw, zza));
    }

    public final void zzs(@NonNull zzzx zzzx, zzadw zzadw) {
        p.k(zzzx);
        p.g(zzzx.zzc());
        p.k(zzadw);
        this.zzb.zzy(zzzx.zzc(), zzzx.zza(), zzzx.zzd(), zzzx.zzb(), new zzadx(zzadw, zza));
    }

    public final void zzt(zzzy zzzy, zzadw zzadw) {
        p.k(zzadw);
        p.k(zzzy);
        zzahl zzahl = (zzahl) p.k(zzzy.zza());
        String zzd = zzahl.zzd();
        zzadx zzadx = new zzadx(zzadw, zza);
        if (this.zzc.zzk(zzd)) {
            if (zzahl.zzf()) {
                this.zzc.zzi(zzd);
            } else {
                this.zzc.zzh(zzadx, zzd);
                return;
            }
        }
        long zzb2 = zzahl.zzb();
        boolean zzg = zzahl.zzg();
        if (zzJ(zzb2, zzg)) {
            zzahl.zze(new zzafy(this.zzc.zzb()));
        }
        this.zzc.zzj(zzd, zzadx, zzb2, zzg);
        this.zzb.zzz(zzahl, new zzafq(this.zzc, zzadx, zzd));
    }

    public final void zzu(zzzz zzzz, zzadw zzadw) {
        p.k(zzzz);
        p.k(zzadw);
        this.zzb.zzA(zzzz.zza(), new zzadx(zzadw, zza));
    }

    public final void zzv(String str, zzadw zzadw) {
        p.k(zzadw);
        this.zzb.zzB(str, new zzadx(zzadw, zza));
    }

    public final void zzw(zzaic zzaic, zzadw zzadw) {
        p.k(zzaic);
        p.k(zzadw);
        this.zzb.zzC(zzaic, new zzadx(zzadw, zza));
    }

    public final void zzx(zzaif zzaif, zzadw zzadw) {
        p.k(zzaif);
        p.k(zzadw);
        this.zzb.zzD(zzaif, new zzadx(zzadw, zza));
    }

    public final void zzy(String str, String str2, String str3, String str4, zzadw zzadw) {
        p.g(str);
        p.g(str2);
        p.k(zzadw);
        p.k(zzadw);
        this.zzb.zzE(str, str2, str3, str4, new zzadx(zzadw, zza));
    }

    public final void zzz(zzaaa zzaaa, zzadw zzadw) {
        p.k(zzaaa);
        p.k(zzaaa.zza());
        p.k(zzadw);
        this.zzb.zzF(zzaaa.zza(), zzaaa.zzb(), new zzadx(zzadw, zza));
    }
}
