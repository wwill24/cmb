package com.google.android.gms.internal.p003firebaseauthapi;

import android.app.Activity;
import androidx.annotation.NonNull;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseError;
import com.google.firebase.auth.ActionCodeSettings;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.EmailAuthCredential;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.auth.PhoneMultiFactorAssertion;
import com.google.firebase.auth.PhoneMultiFactorInfo;
import com.google.firebase.auth.TotpMultiFactorAssertion;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.auth.internal.zzag;
import com.google.firebase.auth.internal.zzan;
import com.google.firebase.auth.internal.zzbc;
import com.google.firebase.auth.internal.zzbx;
import com.google.firebase.auth.internal.zzg;
import com.google.firebase.auth.internal.zzt;
import com.google.firebase.auth.internal.zzx;
import com.google.firebase.auth.internal.zzz;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzadv  reason: invalid package */
public final class zzadv extends zzafc {
    public zzadv(FirebaseApp firebaseApp, Executor executor, ScheduledExecutorService scheduledExecutorService) {
        this.zza = new zzady(firebaseApp, scheduledExecutorService);
        this.zzb = executor;
    }

    @NonNull
    static zzx zzS(FirebaseApp firebaseApp, zzags zzags) {
        p.k(firebaseApp);
        p.k(zzags);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new zzt(zzags, "firebase"));
        List zzr = zzags.zzr();
        if (zzr != null && !zzr.isEmpty()) {
            for (int i10 = 0; i10 < zzr.size(); i10++) {
                arrayList.add(new zzt((zzahg) zzr.get(i10)));
            }
        }
        zzx zzx = new zzx(firebaseApp, arrayList);
        zzx.zzr(new zzz(zzags.zzb(), zzags.zza()));
        zzx.zzq(zzags.zzt());
        zzx.zzp(zzags.zzd());
        zzx.zzi(zzbc.zzb(zzags.zzq()));
        return zzx;
    }

    @NonNull
    public final Task zzA(String str) {
        return zzU(new zzadb(str));
    }

    public final Task zzB(FirebaseApp firebaseApp, zzg zzg, String str) {
        zzadc zzadc = new zzadc(str);
        zzadc.zzf(firebaseApp);
        zzadc.zzd(zzg);
        return zzU(zzadc);
    }

    public final Task zzC(FirebaseApp firebaseApp, AuthCredential authCredential, String str, zzg zzg) {
        zzadd zzadd = new zzadd(authCredential, str);
        zzadd.zzf(firebaseApp);
        zzadd.zzd(zzg);
        return zzU(zzadd);
    }

    public final Task zzD(FirebaseApp firebaseApp, String str, String str2, zzg zzg) {
        zzade zzade = new zzade(str, str2);
        zzade.zzf(firebaseApp);
        zzade.zzd(zzg);
        return zzU(zzade);
    }

    public final Task zzE(FirebaseApp firebaseApp, String str, String str2, String str3, String str4, zzg zzg) {
        zzadf zzadf = new zzadf(str, str2, str3, str4);
        zzadf.zzf(firebaseApp);
        zzadf.zzd(zzg);
        return zzU(zzadf);
    }

    public final Task zzF(FirebaseApp firebaseApp, EmailAuthCredential emailAuthCredential, String str, zzg zzg) {
        zzadg zzadg = new zzadg(emailAuthCredential, str);
        zzadg.zzf(firebaseApp);
        zzadg.zzd(zzg);
        return zzU(zzadg);
    }

    public final Task zzG(FirebaseApp firebaseApp, PhoneAuthCredential phoneAuthCredential, String str, zzg zzg) {
        zzafn.zzc();
        zzadh zzadh = new zzadh(phoneAuthCredential, str);
        zzadh.zzf(firebaseApp);
        zzadh.zzd(zzg);
        return zzU(zzadh);
    }

    public final Task zzH(zzag zzag, String str, String str2, long j10, boolean z10, boolean z11, String str3, String str4, boolean z12, PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks, Executor executor, Activity activity) {
        zzadi zzadi = new zzadi(zzag, str, str2, j10, z10, z11, str3, str4, z12);
        String str5 = str;
        zzadi.zzh(onVerificationStateChangedCallbacks, activity, executor, str);
        return zzU(zzadi);
    }

    public final Task zzI(zzag zzag, String str) {
        return zzU(new zzadj(zzag, str));
    }

    public final Task zzJ(zzag zzag, PhoneMultiFactorInfo phoneMultiFactorInfo, String str, long j10, boolean z10, boolean z11, String str2, String str3, boolean z12, PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks, Executor executor, Activity activity) {
        zzadk zzadk = new zzadk(phoneMultiFactorInfo, p.g(zzag.zze()), str, j10, z10, z11, str2, str3, z12);
        Activity activity2 = activity;
        zzadk.zzh(onVerificationStateChangedCallbacks, activity2, executor, phoneMultiFactorInfo.getUid());
        return zzU(zzadk);
    }

    public final Task zzK(FirebaseApp firebaseApp, FirebaseUser firebaseUser, String str, String str2, zzbx zzbx) {
        zzadl zzadl = new zzadl(firebaseUser.zzf(), str, str2);
        zzadl.zzf(firebaseApp);
        zzadl.zzg(firebaseUser);
        zzadl.zzd(zzbx);
        zzadl.zze(zzbx);
        return zzU(zzadl);
    }

    public final Task zzL(FirebaseApp firebaseApp, FirebaseUser firebaseUser, String str, zzbx zzbx) {
        char c10;
        p.k(firebaseApp);
        p.g(str);
        p.k(firebaseUser);
        p.k(zzbx);
        List zzg = firebaseUser.zzg();
        if ((zzg != null && !zzg.contains(str)) || firebaseUser.isAnonymous()) {
            return Tasks.forException(zzadz.zza(new Status((int) FirebaseError.ERROR_NO_SUCH_PROVIDER, str)));
        }
        if (str.hashCode() == 1216985755 && str.equals("password")) {
            c10 = 0;
        } else {
            c10 = 65535;
        }
        if (c10 != 0) {
            zzadn zzadn = new zzadn(str);
            zzadn.zzf(firebaseApp);
            zzadn.zzg(firebaseUser);
            zzadn.zzd(zzbx);
            zzadn.zze(zzbx);
            return zzU(zzadn);
        }
        zzadm zzadm = new zzadm();
        zzadm.zzf(firebaseApp);
        zzadm.zzg(firebaseUser);
        zzadm.zzd(zzbx);
        zzadm.zze(zzbx);
        return zzU(zzadm);
    }

    public final Task zzM(FirebaseApp firebaseApp, FirebaseUser firebaseUser, String str, zzbx zzbx) {
        zzado zzado = new zzado(str);
        zzado.zzf(firebaseApp);
        zzado.zzg(firebaseUser);
        zzado.zzd(zzbx);
        zzado.zze(zzbx);
        return zzU(zzado);
    }

    public final Task zzN(FirebaseApp firebaseApp, FirebaseUser firebaseUser, String str, zzbx zzbx) {
        zzadp zzadp = new zzadp(str);
        zzadp.zzf(firebaseApp);
        zzadp.zzg(firebaseUser);
        zzadp.zzd(zzbx);
        zzadp.zze(zzbx);
        return zzU(zzadp);
    }

    public final Task zzO(FirebaseApp firebaseApp, FirebaseUser firebaseUser, PhoneAuthCredential phoneAuthCredential, zzbx zzbx) {
        zzafn.zzc();
        zzadq zzadq = new zzadq(phoneAuthCredential);
        zzadq.zzf(firebaseApp);
        zzadq.zzg(firebaseUser);
        zzadq.zzd(zzbx);
        zzadq.zze(zzbx);
        return zzU(zzadq);
    }

    public final Task zzP(FirebaseApp firebaseApp, FirebaseUser firebaseUser, UserProfileChangeRequest userProfileChangeRequest, zzbx zzbx) {
        zzadr zzadr = new zzadr(userProfileChangeRequest);
        zzadr.zzf(firebaseApp);
        zzadr.zzg(firebaseUser);
        zzadr.zzd(zzbx);
        zzadr.zze(zzbx);
        return zzU(zzadr);
    }

    public final Task zzQ(String str, String str2, ActionCodeSettings actionCodeSettings) {
        actionCodeSettings.zzg(7);
        return zzU(new zzads(str, str2, actionCodeSettings));
    }

    public final Task zzR(FirebaseApp firebaseApp, String str, String str2) {
        zzadt zzadt = new zzadt(str, str2);
        zzadt.zzf(firebaseApp);
        return zzU(zzadt);
    }

    public final void zzT(FirebaseApp firebaseApp, zzahl zzahl, PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks, Activity activity, Executor executor) {
        zzadu zzadu = new zzadu(zzahl);
        zzadu.zzf(firebaseApp);
        zzadu.zzh(onVerificationStateChangedCallbacks, activity, executor, zzahl.zzd());
        zzU(zzadu);
    }

    public final Task zza(FirebaseApp firebaseApp, String str, String str2) {
        zzacb zzacb = new zzacb(str, str2);
        zzacb.zzf(firebaseApp);
        return zzU(zzacb);
    }

    public final Task zzb(FirebaseApp firebaseApp, String str, String str2) {
        zzacc zzacc = new zzacc(str, str2);
        zzacc.zzf(firebaseApp);
        return zzU(zzacc);
    }

    public final Task zzc(FirebaseApp firebaseApp, String str, String str2, String str3) {
        zzacd zzacd = new zzacd(str, str2, str3);
        zzacd.zzf(firebaseApp);
        return zzU(zzacd);
    }

    public final Task zzd(FirebaseApp firebaseApp, String str, String str2, String str3, String str4, zzg zzg) {
        zzace zzace = new zzace(str, str2, str3, str4);
        zzace.zzf(firebaseApp);
        zzace.zzd(zzg);
        return zzU(zzace);
    }

    @NonNull
    public final Task zze(FirebaseUser firebaseUser, zzan zzan) {
        zzacf zzacf = new zzacf();
        zzacf.zzg(firebaseUser);
        zzacf.zzd(zzan);
        zzacf.zze(zzan);
        return zzU(zzacf);
    }

    public final Task zzf(FirebaseApp firebaseApp, String str, String str2) {
        zzacg zzacg = new zzacg(str, str2);
        zzacg.zzf(firebaseApp);
        return zzU(zzacg);
    }

    public final Task zzg(FirebaseApp firebaseApp, PhoneMultiFactorAssertion phoneMultiFactorAssertion, FirebaseUser firebaseUser, String str, zzg zzg) {
        zzafn.zzc();
        zzach zzach = new zzach(phoneMultiFactorAssertion, firebaseUser.zzf(), str, (String) null);
        zzach.zzf(firebaseApp);
        zzach.zzd(zzg);
        return zzU(zzach);
    }

    public final Task zzh(FirebaseApp firebaseApp, TotpMultiFactorAssertion totpMultiFactorAssertion, FirebaseUser firebaseUser, String str, String str2, zzg zzg) {
        zzach zzach = new zzach(totpMultiFactorAssertion, firebaseUser.zzf(), str, str2);
        zzach.zzf(firebaseApp);
        zzach.zzd(zzg);
        return zzU(zzach);
    }

    public final Task zzi(FirebaseApp firebaseApp, FirebaseUser firebaseUser, PhoneMultiFactorAssertion phoneMultiFactorAssertion, String str, zzg zzg) {
        zzafn.zzc();
        zzaci zzaci = new zzaci(phoneMultiFactorAssertion, str, (String) null);
        zzaci.zzf(firebaseApp);
        zzaci.zzd(zzg);
        if (firebaseUser != null) {
            zzaci.zzg(firebaseUser);
        }
        return zzU(zzaci);
    }

    public final Task zzj(FirebaseApp firebaseApp, FirebaseUser firebaseUser, TotpMultiFactorAssertion totpMultiFactorAssertion, String str, String str2, zzg zzg) {
        zzaci zzaci = new zzaci(totpMultiFactorAssertion, str, str2);
        zzaci.zzf(firebaseApp);
        zzaci.zzd(zzg);
        if (firebaseUser != null) {
            zzaci.zzg(firebaseUser);
        }
        return zzU(zzaci);
    }

    public final Task zzk(FirebaseApp firebaseApp, FirebaseUser firebaseUser, String str, zzbx zzbx) {
        zzacj zzacj = new zzacj(str);
        zzacj.zzf(firebaseApp);
        zzacj.zzg(firebaseUser);
        zzacj.zzd(zzbx);
        zzacj.zze(zzbx);
        return zzU(zzacj);
    }

    public final Task zzl() {
        return zzU(new zzack());
    }

    public final Task zzm(String str, String str2) {
        return zzU(new zzacl(str, "RECAPTCHA_ENTERPRISE"));
    }

    public final Task zzn(FirebaseApp firebaseApp, FirebaseUser firebaseUser, AuthCredential authCredential, zzbx zzbx) {
        p.k(firebaseApp);
        p.k(authCredential);
        p.k(firebaseUser);
        p.k(zzbx);
        List zzg = firebaseUser.zzg();
        if (zzg != null && zzg.contains(authCredential.getProvider())) {
            return Tasks.forException(zzadz.zza(new Status(FirebaseError.ERROR_PROVIDER_ALREADY_LINKED)));
        }
        if (authCredential instanceof EmailAuthCredential) {
            EmailAuthCredential emailAuthCredential = (EmailAuthCredential) authCredential;
            if (!emailAuthCredential.zzg()) {
                zzacm zzacm = new zzacm(emailAuthCredential);
                zzacm.zzf(firebaseApp);
                zzacm.zzg(firebaseUser);
                zzacm.zzd(zzbx);
                zzacm.zze(zzbx);
                return zzU(zzacm);
            }
            zzacp zzacp = new zzacp(emailAuthCredential);
            zzacp.zzf(firebaseApp);
            zzacp.zzg(firebaseUser);
            zzacp.zzd(zzbx);
            zzacp.zze(zzbx);
            return zzU(zzacp);
        } else if (authCredential instanceof PhoneAuthCredential) {
            zzafn.zzc();
            zzaco zzaco = new zzaco((PhoneAuthCredential) authCredential);
            zzaco.zzf(firebaseApp);
            zzaco.zzg(firebaseUser);
            zzaco.zzd(zzbx);
            zzaco.zze(zzbx);
            return zzU(zzaco);
        } else {
            p.k(firebaseApp);
            p.k(authCredential);
            p.k(firebaseUser);
            p.k(zzbx);
            zzacn zzacn = new zzacn(authCredential);
            zzacn.zzf(firebaseApp);
            zzacn.zzg(firebaseUser);
            zzacn.zzd(zzbx);
            zzacn.zze(zzbx);
            return zzU(zzacn);
        }
    }

    public final Task zzo(FirebaseApp firebaseApp, FirebaseUser firebaseUser, AuthCredential authCredential, String str, zzbx zzbx) {
        zzacq zzacq = new zzacq(authCredential, str);
        zzacq.zzf(firebaseApp);
        zzacq.zzg(firebaseUser);
        zzacq.zzd(zzbx);
        zzacq.zze(zzbx);
        return zzU(zzacq);
    }

    public final Task zzp(FirebaseApp firebaseApp, FirebaseUser firebaseUser, AuthCredential authCredential, String str, zzbx zzbx) {
        zzacr zzacr = new zzacr(authCredential, str);
        zzacr.zzf(firebaseApp);
        zzacr.zzg(firebaseUser);
        zzacr.zzd(zzbx);
        zzacr.zze(zzbx);
        return zzU(zzacr);
    }

    public final Task zzq(FirebaseApp firebaseApp, FirebaseUser firebaseUser, EmailAuthCredential emailAuthCredential, String str, zzbx zzbx) {
        zzacs zzacs = new zzacs(emailAuthCredential, str);
        zzacs.zzf(firebaseApp);
        zzacs.zzg(firebaseUser);
        zzacs.zzd(zzbx);
        zzacs.zze(zzbx);
        return zzU(zzacs);
    }

    public final Task zzr(FirebaseApp firebaseApp, FirebaseUser firebaseUser, EmailAuthCredential emailAuthCredential, String str, zzbx zzbx) {
        zzact zzact = new zzact(emailAuthCredential, str);
        zzact.zzf(firebaseApp);
        zzact.zzg(firebaseUser);
        zzact.zzd(zzbx);
        zzact.zze(zzbx);
        return zzU(zzact);
    }

    public final Task zzs(FirebaseApp firebaseApp, FirebaseUser firebaseUser, String str, String str2, String str3, String str4, zzbx zzbx) {
        zzacu zzacu = new zzacu(str, str2, str3, str4);
        zzacu.zzf(firebaseApp);
        zzacu.zzg(firebaseUser);
        zzacu.zzd(zzbx);
        zzacu.zze(zzbx);
        return zzU(zzacu);
    }

    public final Task zzt(FirebaseApp firebaseApp, FirebaseUser firebaseUser, String str, String str2, String str3, String str4, zzbx zzbx) {
        zzacv zzacv = new zzacv(str, str2, str3, str4);
        zzacv.zzf(firebaseApp);
        zzacv.zzg(firebaseUser);
        zzacv.zzd(zzbx);
        zzacv.zze(zzbx);
        return zzU(zzacv);
    }

    public final Task zzu(FirebaseApp firebaseApp, FirebaseUser firebaseUser, PhoneAuthCredential phoneAuthCredential, String str, zzbx zzbx) {
        zzafn.zzc();
        zzacw zzacw = new zzacw(phoneAuthCredential, str);
        zzacw.zzf(firebaseApp);
        zzacw.zzg(firebaseUser);
        zzacw.zzd(zzbx);
        zzacw.zze(zzbx);
        return zzU(zzacw);
    }

    public final Task zzv(FirebaseApp firebaseApp, FirebaseUser firebaseUser, PhoneAuthCredential phoneAuthCredential, String str, zzbx zzbx) {
        zzafn.zzc();
        zzacx zzacx = new zzacx(phoneAuthCredential, str);
        zzacx.zzf(firebaseApp);
        zzacx.zzg(firebaseUser);
        zzacx.zzd(zzbx);
        zzacx.zze(zzbx);
        return zzU(zzacx);
    }

    @NonNull
    public final Task zzw(FirebaseApp firebaseApp, FirebaseUser firebaseUser, zzbx zzbx) {
        zzacy zzacy = new zzacy();
        zzacy.zzf(firebaseApp);
        zzacy.zzg(firebaseUser);
        zzacy.zzd(zzbx);
        zzacy.zze(zzbx);
        return zzU(zzacy);
    }

    public final Task zzx(FirebaseApp firebaseApp, ActionCodeSettings actionCodeSettings, String str) {
        zzacz zzacz = new zzacz(str, actionCodeSettings);
        zzacz.zzf(firebaseApp);
        return zzU(zzacz);
    }

    public final Task zzy(FirebaseApp firebaseApp, String str, ActionCodeSettings actionCodeSettings, String str2, String str3) {
        actionCodeSettings.zzg(1);
        zzada zzada = new zzada(str, actionCodeSettings, str2, str3, "sendPasswordResetEmail");
        zzada.zzf(firebaseApp);
        return zzU(zzada);
    }

    public final Task zzz(FirebaseApp firebaseApp, String str, ActionCodeSettings actionCodeSettings, String str2, String str3) {
        actionCodeSettings.zzg(6);
        zzada zzada = new zzada(str, actionCodeSettings, str2, str3, "sendSignInLinkToEmail");
        zzada.zzf(firebaseApp);
        return zzU(zzada);
    }
}
