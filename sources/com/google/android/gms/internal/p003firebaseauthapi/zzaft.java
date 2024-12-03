package com.google.android.gms.internal.p003firebaseauthapi;

import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Build;
import android.util.Base64;
import com.google.firebase.auth.PhoneAuthCredential;
import he.a;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import oe.d;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaft  reason: invalid package */
final class zzaft {
    /* access modifiers changed from: private */
    public static final a zza = new a("FirebaseAuth", "SmsRetrieverHelper");
    private final Context zzb;
    private final ScheduledExecutorService zzc;
    /* access modifiers changed from: private */
    public final HashMap zzd = new HashMap();

    zzaft(Context context, ScheduledExecutorService scheduledExecutorService) {
        this.zzb = context;
        this.zzc = scheduledExecutorService;
    }

    static /* bridge */ /* synthetic */ void zzd(zzaft zzaft, String str) {
        zzafs zzafs = (zzafs) zzaft.zzd.get(str);
        if (zzafs != null && !zzac.zzd(zzafs.zzd) && !zzac.zzd(zzafs.zze) && !zzafs.zzb.isEmpty()) {
            for (zzadx zzr : zzafs.zzb) {
                zzr.zzr(PhoneAuthCredential.zzc(zzafs.zzd, zzafs.zze));
            }
            zzafs.zzh = true;
        }
    }

    private static String zzl(String str, String str2) {
        String str3 = str + " " + str2;
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA-256");
            instance.update(str3.getBytes(zzk.zzc));
            String substring = Base64.encodeToString(Arrays.copyOf(instance.digest(), 9), 3).substring(0, 11);
            zza.a("Package: " + str + " -- Hash: " + substring, new Object[0]);
            return substring;
        } catch (NoSuchAlgorithmException e10) {
            zza.c("NoSuchAlgorithm: ".concat(String.valueOf(e10.getMessage())), new Object[0]);
            return null;
        }
    }

    /* access modifiers changed from: private */
    public final void zzm(String str) {
        zzafs zzafs = (zzafs) this.zzd.get(str);
        if (zzafs != null && !zzafs.zzh && !zzac.zzd(zzafs.zzd)) {
            zza.h("Timed out waiting for SMS.", new Object[0]);
            for (zzadx zza2 : zzafs.zzb) {
                zza2.zza(zzafs.zzd);
            }
            zzafs.zzi = true;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: zzn */
    public final void zzg(String str) {
        zzafs zzafs = (zzafs) this.zzd.get(str);
        if (zzafs != null) {
            if (!zzafs.zzi) {
                zzm(str);
            }
            zzi(str);
        }
    }

    /* access modifiers changed from: package-private */
    public final String zzb() {
        Signature[] signatureArr;
        try {
            String packageName = this.zzb.getPackageName();
            if (Build.VERSION.SDK_INT < 28) {
                signatureArr = d.a(this.zzb).e(packageName, 64).signatures;
            } else {
                signatureArr = d.a(this.zzb).e(packageName, 134217728).signingInfo.getApkContentsSigners();
            }
            String zzl = zzl(packageName, signatureArr[0].toCharsString());
            if (zzl != null) {
                return zzl;
            }
            zza.c("Hash generation failed.", new Object[0]);
            return null;
        } catch (PackageManager.NameNotFoundException unused) {
            zza.c("Unable to find package to obtain hash.", new Object[0]);
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzh(zzadx zzadx, String str) {
        zzafs zzafs = (zzafs) this.zzd.get(str);
        if (zzafs != null) {
            zzafs.zzb.add(zzadx);
            if (zzafs.zzg) {
                zzadx.zzb(zzafs.zzd);
            }
            if (zzafs.zzh) {
                zzadx.zzr(PhoneAuthCredential.zzc(zzafs.zzd, zzafs.zze));
            }
            if (zzafs.zzi) {
                zzadx.zza(zzafs.zzd);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzi(String str) {
        zzafs zzafs = (zzafs) this.zzd.get(str);
        if (zzafs != null) {
            ScheduledFuture scheduledFuture = zzafs.zzf;
            if (scheduledFuture != null && !scheduledFuture.isDone()) {
                zzafs.zzf.cancel(false);
            }
            zzafs.zzb.clear();
            this.zzd.remove(str);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzj(String str, zzadx zzadx, long j10, boolean z10) {
        this.zzd.put(str, new zzafs(j10, z10));
        zzh(zzadx, str);
        zzafs zzafs = (zzafs) this.zzd.get(str);
        long j11 = zzafs.zza;
        if (j11 <= 0) {
            zza.h("Timeout of 0 specified; SmsRetriever will not start.", new Object[0]);
            return;
        }
        zzafs.zzf = this.zzc.schedule(new zzafo(this, str), j11, TimeUnit.SECONDS);
        if (!zzafs.zzc) {
            zza.h("SMS auto-retrieval unavailable; SmsRetriever will not start.", new Object[0]);
            return;
        }
        zzafr zzafr = new zzafr(this, str);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.google.android.gms.auth.api.phone.SMS_RETRIEVED");
        zzb.zza(this.zzb.getApplicationContext(), zzafr, intentFilter);
        zd.a.b(this.zzb).startSmsRetriever().addOnFailureListener(new zzafp(this));
    }

    /* access modifiers changed from: package-private */
    public final boolean zzk(String str) {
        return this.zzd.get(str) != null;
    }
}
