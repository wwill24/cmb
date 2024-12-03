package com.google.android.recaptcha.internal;

import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.k0;

final class zzcy extends SuspendLambda implements Function2 {
    Object zza;
    Object zzb;
    Object zzc;
    int zzd;
    final /* synthetic */ zzda zze;
    final /* synthetic */ String zzf;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzcy(zzda zzda, String str, c cVar) {
        super(2, cVar);
        this.zze = zzda;
        this.zzf = str;
    }

    public final c create(Object obj, c cVar) {
        return new zzcy(this.zze, this.zzf, cVar);
    }

    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzcy) create((k0) obj, (c) obj2)).invokeSuspend(Unit.f32013a);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: kotlinx.coroutines.sync.c} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v0, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: com.google.android.recaptcha.internal.zzda} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v1, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v4, resolved type: com.google.android.recaptcha.internal.zzda} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: kotlinx.coroutines.sync.c} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v5, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v2, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v0, resolved type: kotlinx.coroutines.sync.c} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v7, resolved type: kotlinx.coroutines.sync.c} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v8, resolved type: kotlinx.coroutines.sync.c} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v6, resolved type: com.google.android.recaptcha.internal.zzda} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v10, resolved type: kotlinx.coroutines.sync.c} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v11, resolved type: kotlinx.coroutines.sync.c} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v12, resolved type: kotlinx.coroutines.sync.c} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r15) {
        /*
            r14 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.b.d()
            int r1 = r14.zzd
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L_0x0022
            if (r1 == r2) goto L_0x0015
            java.lang.Object r0 = r14.zza
            gk.g.b(r15)     // Catch:{ all -> 0x0012 }
            goto L_0x007d
        L_0x0012:
            r15 = move-exception
            goto L_0x0088
        L_0x0015:
            java.lang.Object r1 = r14.zzc
            java.lang.Object r2 = r14.zzb
            java.lang.Object r4 = r14.zza
            gk.g.b(r15)
            r13 = r4
            r4 = r1
            r1 = r13
            goto L_0x003c
        L_0x0022:
            gk.g.b(r15)
            com.google.android.recaptcha.internal.zzda r15 = r14.zze
            kotlinx.coroutines.sync.c r1 = r15.zzo
            java.lang.String r4 = r14.zzf
            r14.zza = r1
            r14.zzb = r15
            r14.zzc = r4
            r14.zzd = r2
            java.lang.Object r2 = r1.b(r3, r14)
            if (r2 == r0) goto L_0x008c
            r2 = r15
        L_0x003c:
            r15 = r2
            com.google.android.recaptcha.internal.zzda r15 = (com.google.android.recaptcha.internal.zzda) r15     // Catch:{ all -> 0x0086 }
            com.google.android.recaptcha.internal.zzr r15 = r15.zzf     // Catch:{ all -> 0x0086 }
            java.lang.String r5 = r15.zzb()     // Catch:{ all -> 0x0086 }
            r15 = r2
            com.google.android.recaptcha.internal.zzda r15 = (com.google.android.recaptcha.internal.zzda) r15     // Catch:{ all -> 0x0086 }
            java.lang.String r6 = r15.zzd     // Catch:{ all -> 0x0086 }
            r15 = r2
            com.google.android.recaptcha.internal.zzda r15 = (com.google.android.recaptcha.internal.zzda) r15     // Catch:{ all -> 0x0086 }
            java.lang.String r8 = r15.zzh     // Catch:{ all -> 0x0086 }
            r15 = r2
            com.google.android.recaptcha.internal.zzda r15 = (com.google.android.recaptcha.internal.zzda) r15     // Catch:{ all -> 0x0086 }
            java.lang.String r9 = r15.zzg     // Catch:{ all -> 0x0086 }
            r15 = r2
            com.google.android.recaptcha.internal.zzda r15 = (com.google.android.recaptcha.internal.zzda) r15     // Catch:{ all -> 0x0086 }
            android.content.Context r10 = r15.zze     // Catch:{ all -> 0x0086 }
            com.google.android.recaptcha.internal.zzda r2 = (com.google.android.recaptcha.internal.zzda) r2     // Catch:{ all -> 0x0086 }
            com.google.android.recaptcha.internal.zzr r11 = r2.zzf     // Catch:{ all -> 0x0086 }
            r14.zza = r1     // Catch:{ all -> 0x0086 }
            r14.zzb = r3     // Catch:{ all -> 0x0086 }
            r14.zzc = r3     // Catch:{ all -> 0x0086 }
            r15 = 2
            r14.zzd = r15     // Catch:{ all -> 0x0086 }
            r7 = r4
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ all -> 0x0086 }
            r12 = r14
            java.lang.Object r15 = com.google.android.recaptcha.internal.zzbj.zzb(r5, r6, r7, r8, r9, r10, r11, r12)     // Catch:{ all -> 0x0086 }
            if (r15 == r0) goto L_0x0085
            r0 = r1
        L_0x007d:
            kotlin.Unit r15 = kotlin.Unit.f32013a     // Catch:{ all -> 0x0012 }
            r0.c(r3)
            kotlin.Unit r15 = kotlin.Unit.f32013a
            return r15
        L_0x0085:
            return r0
        L_0x0086:
            r15 = move-exception
            r0 = r1
        L_0x0088:
            r0.c(r3)
            throw r15
        L_0x008c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzcy.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
