package com.google.android.gms.internal.p003firebaseauthapi;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.p;
import com.google.firebase.auth.PhoneAuthCredential;
import he.a;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzadx  reason: invalid package */
public class zzadx {
    private final zzadw zza;
    private final a zzb;

    public zzadx(zzadw zzadw, a aVar) {
        this.zza = (zzadw) p.k(zzadw);
        this.zzb = (a) p.k(aVar);
    }

    public final void zza(String str) {
        try {
            this.zza.zza(str);
        } catch (RemoteException e10) {
            this.zzb.b("RemoteException when sending auto retrieval timeout response.", e10, new Object[0]);
        }
    }

    public void zzb(String str) {
        try {
            this.zza.zzb(str);
        } catch (RemoteException e10) {
            this.zzb.b("RemoteException when sending send verification code response.", e10, new Object[0]);
        }
    }

    public final void zzc(zzagc zzagc) {
        try {
            this.zza.zzc(zzagc);
        } catch (RemoteException e10) {
            this.zzb.b("RemoteException when sending create auth uri response.", e10, new Object[0]);
        }
    }

    public final void zzd() {
        try {
            this.zza.zzd();
        } catch (RemoteException e10) {
            this.zzb.b("RemoteException when sending delete account response.", e10, new Object[0]);
        }
    }

    public final void zze(zzaae zzaae) {
        try {
            this.zza.zze(zzaae);
        } catch (RemoteException e10) {
            this.zzb.b("RemoteException when sending failure result with credential", e10, new Object[0]);
        }
    }

    public final void zzf(zzaaf zzaaf) {
        try {
            this.zza.zzf(zzaaf);
        } catch (RemoteException e10) {
            this.zzb.b("RemoteException when sending failure result for mfa", e10, new Object[0]);
        }
    }

    public final void zzg(Status status, PhoneAuthCredential phoneAuthCredential) {
        try {
            this.zza.zzg(status, phoneAuthCredential);
        } catch (RemoteException e10) {
            this.zzb.b("RemoteException when sending failure result.", e10, new Object[0]);
        }
    }

    public void zzh(Status status) {
        try {
            this.zza.zzh(status);
        } catch (RemoteException e10) {
            this.zzb.b("RemoteException when sending failure result.", e10, new Object[0]);
        }
    }

    public final void zzi(zzagx zzagx) {
        try {
            this.zza.zzi(zzagx);
        } catch (RemoteException e10) {
            this.zzb.b("RemoteException when sending Play Integrity Producer project response.", e10, new Object[0]);
        }
    }

    public final void zzj(zzaha zzaha) {
        try {
            this.zza.zzj(zzaha);
        } catch (RemoteException e10) {
            this.zzb.b("RemoteException when sending get recaptcha config response.", e10, new Object[0]);
        }
    }

    public final void zzk(zzahb zzahb, zzags zzags) {
        try {
            this.zza.zzk(zzahb, zzags);
        } catch (RemoteException e10) {
            this.zzb.b("RemoteException when sending get token and account info user response", e10, new Object[0]);
        }
    }

    public final void zzl(zzahk zzahk) {
        try {
            this.zza.zzl(zzahk);
        } catch (RemoteException e10) {
            this.zzb.b("RemoteException when sending password reset response.", e10, new Object[0]);
        }
    }

    public final void zzm() {
        try {
            this.zza.zzm();
        } catch (RemoteException e10) {
            this.zzb.b("RemoteException when sending email verification response.", e10, new Object[0]);
        }
    }

    public final void zzn(String str) {
        try {
            this.zza.zzn(str);
        } catch (RemoteException e10) {
            this.zzb.b("RemoteException when sending set account info response.", e10, new Object[0]);
        }
    }

    public final void zzo() {
        try {
            this.zza.zzo();
        } catch (RemoteException e10) {
            this.zzb.b("RemoteException when setting FirebaseUI Version", e10, new Object[0]);
        }
    }

    public final void zzp(zzahs zzahs) {
        try {
            this.zza.zzp(zzahs);
        } catch (RemoteException e10) {
            this.zzb.b("RemoteException when sending start mfa enrollment response.", e10, new Object[0]);
        }
    }

    public final void zzq(zzahb zzahb) {
        try {
            this.zza.zzq(zzahb);
        } catch (RemoteException e10) {
            this.zzb.b("RemoteException when sending token result.", e10, new Object[0]);
        }
    }

    public final void zzr(PhoneAuthCredential phoneAuthCredential) {
        try {
            this.zza.zzr(phoneAuthCredential);
        } catch (RemoteException e10) {
            this.zzb.b("RemoteException when sending verification completed response.", e10, new Object[0]);
        }
    }

    public zzadx(zzadx zzadx) {
        this(zzadx.zza, zzadx.zzb);
    }
}
