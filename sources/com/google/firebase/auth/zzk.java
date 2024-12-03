package com.google.firebase.auth;

import android.text.TextUtils;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.internal.p003firebaseauthapi.zzadv;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.auth.internal.zzag;
import com.google.firebase.auth.internal.zze;

final class zzk implements OnCompleteListener {
    final /* synthetic */ PhoneAuthOptions zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ FirebaseAuth zzc;

    zzk(FirebaseAuth firebaseAuth, PhoneAuthOptions phoneAuthOptions, String str) {
        this.zzc = firebaseAuth;
        this.zza = phoneAuthOptions;
        this.zzb = str;
    }

    public final void onComplete(Task task) {
        String str;
        String str2;
        boolean z10;
        boolean z11;
        if (!task.isSuccessful()) {
            Exception exception = task.getException();
            if (exception != null) {
                "Error while validating application identity: ".concat(String.valueOf(exception.getMessage()));
            }
            if (exception instanceof FirebaseAuthMissingActivityForRecaptchaException) {
                FirebaseAuth.zzX((FirebaseAuthMissingActivityForRecaptchaException) exception, this.zza, this.zzb);
                return;
            } else {
                str2 = null;
                str = null;
            }
        } else {
            String zzb2 = ((zze) task.getResult()).zzb();
            str = ((zze) task.getResult()).zza();
            str2 = zzb2;
        }
        long longValue = this.zza.zzg().longValue();
        FirebaseAuth firebaseAuth = this.zzc;
        PhoneAuthOptions phoneAuthOptions = this.zza;
        PhoneAuthProvider.OnVerificationStateChangedCallbacks zzx = firebaseAuth.zzab(phoneAuthOptions.zzh(), phoneAuthOptions.zze());
        if (TextUtils.isEmpty(str2)) {
            zzx = this.zzc.zzy(this.zza, zzx);
        }
        PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks = zzx;
        zzag zzag = (zzag) p.k(this.zza.zzc());
        if (zzag.zzf()) {
            FirebaseAuth firebaseAuth2 = this.zzc;
            PhoneAuthOptions phoneAuthOptions2 = this.zza;
            zzadv zzz = firebaseAuth2.zzf;
            String str3 = (String) p.k(phoneAuthOptions2.zzh());
            FirebaseAuth firebaseAuth3 = this.zzc;
            PhoneAuthOptions phoneAuthOptions3 = this.zza;
            String zzG = firebaseAuth3.zzj;
            if (phoneAuthOptions3.zzd() != null) {
                z11 = true;
            } else {
                z11 = false;
            }
            PhoneAuthOptions phoneAuthOptions4 = this.zza;
            zzz.zzH(zzag, str3, zzG, longValue, z11, phoneAuthOptions4.zzl(), str2, str, this.zzc.zzW(), onVerificationStateChangedCallbacks, phoneAuthOptions4.zzi(), phoneAuthOptions4.zza());
            return;
        }
        FirebaseAuth firebaseAuth4 = this.zzc;
        PhoneAuthOptions phoneAuthOptions5 = this.zza;
        zzadv zzz2 = firebaseAuth4.zzf;
        PhoneMultiFactorInfo phoneMultiFactorInfo = (PhoneMultiFactorInfo) p.k(phoneAuthOptions5.zzf());
        FirebaseAuth firebaseAuth5 = this.zzc;
        PhoneAuthOptions phoneAuthOptions6 = this.zza;
        String zzG2 = firebaseAuth5.zzj;
        if (phoneAuthOptions6.zzd() != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        PhoneAuthOptions phoneAuthOptions7 = this.zza;
        zzz2.zzJ(zzag, phoneMultiFactorInfo, zzG2, longValue, z10, phoneAuthOptions7.zzl(), str2, str, this.zzc.zzW(), onVerificationStateChangedCallbacks, phoneAuthOptions7.zzi(), phoneAuthOptions7.zza());
    }
}
