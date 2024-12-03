package com.google.android.gms.internal.p003firebaseauthapi;

import com.google.android.gms.tasks.TaskCompletionSource;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaey  reason: invalid package */
public final class zzaey implements zzaep {
    private final zzaez zza;
    private final TaskCompletionSource zzb;

    public zzaey(zzaez zzaez, TaskCompletionSource taskCompletionSource) {
        this.zza = zzaez;
        this.zzb = taskCompletionSource;
    }

    /* JADX WARNING: type inference failed for: r0v8, types: [com.google.firebase.auth.FirebaseUser] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(java.lang.Object r14, com.google.android.gms.common.api.Status r15) {
        /*
            r13 = this;
            com.google.android.gms.tasks.TaskCompletionSource r0 = r13.zzb
            java.lang.String r1 = "completion source cannot be null"
            com.google.android.gms.common.internal.p.l(r0, r1)
            if (r15 == 0) goto L_0x00e4
            com.google.android.gms.internal.firebase-auth-api.zzaez r14 = r13.zza
            com.google.android.gms.internal.firebase-auth-api.zzaaf r0 = r14.zzw
            if (r0 == 0) goto L_0x00c8
            com.google.android.gms.tasks.TaskCompletionSource r15 = r13.zzb
            com.google.firebase.FirebaseApp r14 = r14.zzg
            com.google.firebase.auth.FirebaseAuth r14 = com.google.firebase.auth.FirebaseAuth.getInstance(r14)
            com.google.android.gms.internal.firebase-auth-api.zzaez r0 = r13.zza
            com.google.android.gms.internal.firebase-auth-api.zzaaf r1 = r0.zzw
            java.lang.String r0 = r0.zza()
            java.lang.String r2 = "reauthenticateWithCredential"
            boolean r0 = r2.equals(r0)
            if (r0 != 0) goto L_0x0038
            com.google.android.gms.internal.firebase-auth-api.zzaez r0 = r13.zza
            java.lang.String r0 = r0.zza()
            java.lang.String r2 = "reauthenticateWithCredentialWithData"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x0036
            goto L_0x0038
        L_0x0036:
            r0 = 0
            goto L_0x003c
        L_0x0038:
            com.google.android.gms.internal.firebase-auth-api.zzaez r0 = r13.zza
            com.google.firebase.auth.FirebaseUser r0 = r0.zzh
        L_0x003c:
            int r2 = com.google.android.gms.internal.p003firebaseauthapi.zzadz.zzb
            r14.getClass()
            r1.getClass()
            android.util.SparseArray r2 = com.google.android.gms.internal.p003firebaseauthapi.zzadz.zza
            r3 = 17078(0x42b6, float:2.3931E-41)
            java.lang.Object r2 = r2.get(r3)
            android.util.Pair r2 = (android.util.Pair) r2
            com.google.firebase.auth.FirebaseAuthMultiFactorException r3 = new com.google.firebase.auth.FirebaseAuthMultiFactorException
            java.lang.Object r4 = r2.first
            java.lang.String r4 = (java.lang.String) r4
            java.lang.Object r2 = r2.second
            java.lang.String r2 = (java.lang.String) r2
            android.os.Parcelable$Creator<com.google.firebase.auth.internal.zzae> r5 = com.google.firebase.auth.internal.zzae.CREATOR
            java.util.List r5 = r1.zzc()
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            java.util.Iterator r5 = r5.iterator()
        L_0x0067:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L_0x007d
            java.lang.Object r6 = r5.next()
            com.google.firebase.auth.MultiFactorInfo r6 = (com.google.firebase.auth.MultiFactorInfo) r6
            boolean r8 = r6 instanceof com.google.firebase.auth.PhoneMultiFactorInfo
            if (r8 == 0) goto L_0x0067
            com.google.firebase.auth.PhoneMultiFactorInfo r6 = (com.google.firebase.auth.PhoneMultiFactorInfo) r6
            r7.add(r6)
            goto L_0x0067
        L_0x007d:
            java.util.List r5 = r1.zzc()
            java.util.ArrayList r12 = new java.util.ArrayList
            r12.<init>()
            java.util.Iterator r5 = r5.iterator()
        L_0x008a:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L_0x00a0
            java.lang.Object r6 = r5.next()
            com.google.firebase.auth.MultiFactorInfo r6 = (com.google.firebase.auth.MultiFactorInfo) r6
            boolean r8 = r6 instanceof com.google.firebase.auth.TotpMultiFactorInfo
            if (r8 == 0) goto L_0x008a
            com.google.firebase.auth.TotpMultiFactorInfo r6 = (com.google.firebase.auth.TotpMultiFactorInfo) r6
            r12.add(r6)
            goto L_0x008a
        L_0x00a0:
            java.util.List r5 = r1.zzc()
            java.lang.String r6 = r1.zzb()
            com.google.firebase.auth.internal.zzag r8 = com.google.firebase.auth.internal.zzag.zzc(r5, r6)
            com.google.firebase.auth.internal.zzae r5 = new com.google.firebase.auth.internal.zzae
            com.google.firebase.FirebaseApp r14 = r14.getApp()
            java.lang.String r9 = r14.getName()
            com.google.firebase.auth.zze r10 = r1.zza()
            r11 = r0
            com.google.firebase.auth.internal.zzx r11 = (com.google.firebase.auth.internal.zzx) r11
            r6 = r5
            r6.<init>(r7, r8, r9, r10, r11, r12)
            r3.<init>(r4, r2, r5)
            r15.setException(r3)
            return
        L_0x00c8:
            com.google.firebase.auth.AuthCredential r0 = r14.zzt
            if (r0 == 0) goto L_0x00da
            com.google.android.gms.tasks.TaskCompletionSource r1 = r13.zzb
            java.lang.String r2 = r14.zzu
            java.lang.String r14 = r14.zzv
            com.google.firebase.FirebaseException r14 = com.google.android.gms.internal.p003firebaseauthapi.zzadz.zzb(r15, r0, r2, r14)
            r1.setException(r14)
            return
        L_0x00da:
            com.google.android.gms.tasks.TaskCompletionSource r14 = r13.zzb
            com.google.firebase.FirebaseException r15 = com.google.android.gms.internal.p003firebaseauthapi.zzadz.zza(r15)
            r14.setException(r15)
            return
        L_0x00e4:
            com.google.android.gms.tasks.TaskCompletionSource r15 = r13.zzb
            r15.setResult(r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p003firebaseauthapi.zzaey.zza(java.lang.Object, com.google.android.gms.common.api.Status):void");
    }
}
