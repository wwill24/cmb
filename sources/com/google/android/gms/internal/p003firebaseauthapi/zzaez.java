package com.google.android.gms.internal.p003firebaseauthapi;

import android.app.Activity;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.p;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.auth.internal.zzao;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaez  reason: invalid package */
abstract class zzaez implements zzafb {
    Object zzA;
    Status zzB;
    /* access modifiers changed from: private */
    public boolean zza;
    protected final int zze;
    protected final zzaew zzf = new zzaew(this);
    protected FirebaseApp zzg;
    protected FirebaseUser zzh;
    protected Object zzi;
    protected zzao zzj;
    protected zzaep zzk;
    protected final List zzl = new ArrayList();
    protected Executor zzm;
    protected zzahb zzn;
    protected zzags zzo;
    protected zzagc zzp;
    protected zzahk zzq;
    protected String zzr;
    protected String zzs;
    protected AuthCredential zzt;
    protected String zzu;
    protected String zzv;
    protected zzaaf zzw;
    protected zzaha zzx;
    protected zzagx zzy;
    protected zzahs zzz;

    public zzaez(int i10) {
        this.zze = i10;
    }

    static /* bridge */ /* synthetic */ void zzj(zzaez zzaez) {
        zzaez.zzb();
        p.p(zzaez.zza, "no success or failure set on method implementation");
    }

    static /* bridge */ /* synthetic */ void zzk(zzaez zzaez, Status status) {
        zzao zzao = zzaez.zzj;
        if (zzao != null) {
            zzao.zzb(status);
        }
    }

    public abstract void zzb();

    public final zzaez zzd(Object obj) {
        this.zzi = p.l(obj, "external callback cannot be null");
        return this;
    }

    public final zzaez zze(zzao zzao) {
        this.zzj = (zzao) p.l(zzao, "external failure callback cannot be null");
        return this;
    }

    public final zzaez zzf(FirebaseApp firebaseApp) {
        this.zzg = (FirebaseApp) p.l(firebaseApp, "firebaseApp cannot be null");
        return this;
    }

    public final zzaez zzg(FirebaseUser firebaseUser) {
        this.zzh = (FirebaseUser) p.l(firebaseUser, "firebaseUser cannot be null");
        return this;
    }

    public final zzaez zzh(PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks, Activity activity, Executor executor, String str) {
        List list = this.zzl;
        PhoneAuthProvider.OnVerificationStateChangedCallbacks zza2 = zzafn.zza(str, onVerificationStateChangedCallbacks, this);
        synchronized (list) {
            this.zzl.add((PhoneAuthProvider.OnVerificationStateChangedCallbacks) p.k(zza2));
        }
        if (activity != null) {
            zzaeq.zza(activity, this.zzl);
        }
        this.zzm = (Executor) p.k(executor);
        return this;
    }

    public final void zzl(Status status) {
        this.zza = true;
        this.zzB = status;
        this.zzk.zza((Object) null, status);
    }

    public final void zzm(Object obj) {
        this.zza = true;
        this.zzA = obj;
        this.zzk.zza(obj, (Status) null);
    }
}
