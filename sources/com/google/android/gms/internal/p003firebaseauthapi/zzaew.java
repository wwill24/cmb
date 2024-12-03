package com.google.android.gms.internal.p003firebaseauthapi;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.p;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.internal.zzai;
import com.google.firebase.auth.internal.zzao;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaew  reason: invalid package */
final class zzaew implements zzadw {
    final /* synthetic */ zzaez zza;

    zzaew(zzaez zzaez) {
        this.zza = zzaez;
    }

    private final void zzs(zzaex zzaex) {
        this.zza.zzm.execute(new zzaev(this, zzaex));
    }

    private final void zzt(Status status, AuthCredential authCredential, String str, String str2) {
        zzaez.zzk(this.zza, status);
        zzaez zzaez = this.zza;
        zzaez.zzt = authCredential;
        zzaez.zzu = str;
        zzaez.zzv = str2;
        zzao zzao = zzaez.zzj;
        if (zzao != null) {
            zzao.zzb(status);
        }
        this.zza.zzl(status);
    }

    public final void zza(String str) throws RemoteException {
        boolean z10;
        int i10 = this.zza.zze;
        String zzO = zzabz.zzO(this, "Unexpected response type ");
        if (i10 == 8) {
            z10 = true;
        } else {
            z10 = false;
        }
        p.p(z10, zzO);
        zzaez zzaez = this.zza;
        zzaez.zzs = str;
        zzaez.zza = true;
        zzs(new zzaet(this, str));
    }

    public final void zzb(String str) throws RemoteException {
        boolean z10;
        int i10 = this.zza.zze;
        String zzO = zzabz.zzO(this, "Unexpected response type ");
        if (i10 == 8) {
            z10 = true;
        } else {
            z10 = false;
        }
        p.p(z10, zzO);
        this.zza.zzs = str;
        zzs(new zzaer(this, str));
    }

    public final void zzc(zzagc zzagc) throws RemoteException {
        boolean z10;
        int i10 = this.zza.zze;
        String zzO = zzabz.zzO(this, "Unexpected response type ");
        if (i10 == 3) {
            z10 = true;
        } else {
            z10 = false;
        }
        p.p(z10, zzO);
        zzaez zzaez = this.zza;
        zzaez.zzp = zzagc;
        zzaez.zzj(zzaez);
    }

    public final void zzd() throws RemoteException {
        boolean z10;
        int i10 = this.zza.zze;
        String zzO = zzabz.zzO(this, "Unexpected response type ");
        if (i10 == 5) {
            z10 = true;
        } else {
            z10 = false;
        }
        p.p(z10, zzO);
        zzaez.zzj(this.zza);
    }

    public final void zze(zzaae zzaae) {
        zzt(zzaae.zza(), zzaae.zzb(), zzaae.zzc(), zzaae.zzd());
    }

    public final void zzf(zzaaf zzaaf) {
        zzaez zzaez = this.zza;
        zzaez.zzw = zzaaf;
        zzaez.zzl(zzai.zza("REQUIRES_SECOND_FACTOR_AUTH"));
    }

    public final void zzg(Status status, PhoneAuthCredential phoneAuthCredential) throws RemoteException {
        boolean z10;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Unexpected response type ");
        int i10 = this.zza.zze;
        sb2.append(i10);
        String sb3 = sb2.toString();
        if (i10 == 2) {
            z10 = true;
        } else {
            z10 = false;
        }
        p.p(z10, sb3);
        zzt(status, phoneAuthCredential, (String) null, (String) null);
    }

    public final void zzh(Status status) throws RemoteException {
        String c02 = status.c0();
        if (c02 != null) {
            if (c02.contains("MISSING_MFA_PENDING_CREDENTIAL")) {
                status = new Status(17081);
            } else if (c02.contains("MISSING_MFA_ENROLLMENT_ID")) {
                status = new Status(17082);
            } else if (c02.contains("INVALID_MFA_PENDING_CREDENTIAL")) {
                status = new Status(17083);
            } else if (c02.contains("MFA_ENROLLMENT_NOT_FOUND")) {
                status = new Status(17084);
            } else if (c02.contains("ADMIN_ONLY_OPERATION")) {
                status = new Status(17085);
            } else if (c02.contains("UNVERIFIED_EMAIL")) {
                status = new Status(17086);
            } else if (c02.contains("SECOND_FACTOR_EXISTS")) {
                status = new Status(17087);
            } else if (c02.contains("SECOND_FACTOR_LIMIT_EXCEEDED")) {
                status = new Status(17088);
            } else if (c02.contains("UNSUPPORTED_FIRST_FACTOR")) {
                status = new Status(17089);
            } else if (c02.contains("EMAIL_CHANGE_NEEDS_VERIFICATION")) {
                status = new Status(17090);
            }
        }
        zzaez zzaez = this.zza;
        if (zzaez.zze == 8) {
            zzaez.zza = true;
            zzs(new zzaeu(this, status));
            return;
        }
        zzaez.zzk(zzaez, status);
        this.zza.zzl(status);
    }

    public final void zzi(zzagx zzagx) throws RemoteException {
        zzaez zzaez = this.zza;
        zzaez.zzy = zzagx;
        zzaez.zzj(zzaez);
    }

    public final void zzj(zzaha zzaha) throws RemoteException {
        zzaez zzaez = this.zza;
        zzaez.zzx = zzaha;
        zzaez.zzj(zzaez);
    }

    public final void zzk(zzahb zzahb, zzags zzags) throws RemoteException {
        boolean z10;
        int i10 = this.zza.zze;
        String zzO = zzabz.zzO(this, "Unexpected response type: ");
        if (i10 == 2) {
            z10 = true;
        } else {
            z10 = false;
        }
        p.p(z10, zzO);
        zzaez zzaez = this.zza;
        zzaez.zzn = zzahb;
        zzaez.zzo = zzags;
        zzaez.zzj(zzaez);
    }

    public final void zzl(zzahk zzahk) throws RemoteException {
        boolean z10;
        int i10 = this.zza.zze;
        String zzO = zzabz.zzO(this, "Unexpected response type ");
        if (i10 == 4) {
            z10 = true;
        } else {
            z10 = false;
        }
        p.p(z10, zzO);
        zzaez zzaez = this.zza;
        zzaez.zzq = zzahk;
        zzaez.zzj(zzaez);
    }

    public final void zzm() throws RemoteException {
        boolean z10;
        int i10 = this.zza.zze;
        String zzO = zzabz.zzO(this, "Unexpected response type ");
        if (i10 == 6) {
            z10 = true;
        } else {
            z10 = false;
        }
        p.p(z10, zzO);
        zzaez.zzj(this.zza);
    }

    public final void zzn(String str) throws RemoteException {
        boolean z10;
        int i10 = this.zza.zze;
        String zzO = zzabz.zzO(this, "Unexpected response type ");
        if (i10 == 7) {
            z10 = true;
        } else {
            z10 = false;
        }
        p.p(z10, zzO);
        zzaez zzaez = this.zza;
        zzaez.zzr = str;
        zzaez.zzj(zzaez);
    }

    public final void zzo() throws RemoteException {
        boolean z10;
        int i10 = this.zza.zze;
        String zzO = zzabz.zzO(this, "Unexpected response type ");
        if (i10 == 9) {
            z10 = true;
        } else {
            z10 = false;
        }
        p.p(z10, zzO);
        zzaez.zzj(this.zza);
    }

    public final void zzp(zzahs zzahs) throws RemoteException {
        zzaez zzaez = this.zza;
        zzaez.zzz = zzahs;
        zzaez.zzj(zzaez);
    }

    public final void zzq(zzahb zzahb) throws RemoteException {
        int i10 = this.zza.zze;
        String zzO = zzabz.zzO(this, "Unexpected response type: ");
        boolean z10 = true;
        if (i10 != 1) {
            z10 = false;
        }
        p.p(z10, zzO);
        zzaez zzaez = this.zza;
        zzaez.zzn = zzahb;
        zzaez.zzj(zzaez);
    }

    public final void zzr(PhoneAuthCredential phoneAuthCredential) throws RemoteException {
        boolean z10;
        int i10 = this.zza.zze;
        String zzO = zzabz.zzO(this, "Unexpected response type ");
        if (i10 == 8) {
            z10 = true;
        } else {
            z10 = false;
        }
        p.p(z10, zzO);
        this.zza.zza = true;
        zzs(new zzaes(this, phoneAuthCredential));
    }
}
