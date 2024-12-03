package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzet;

final class ea extends da {

    /* renamed from: g  reason: collision with root package name */
    private final zzet f39772g;

    /* renamed from: h  reason: collision with root package name */
    final /* synthetic */ b f39773h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ea(b bVar, String str, int i10, zzet zzet) {
        super(str, i10);
        this.f39773h = bVar;
        this.f39772g = zzet;
    }

    /* access modifiers changed from: package-private */
    public final int a() {
        return this.f39772g.zza();
    }

    /* access modifiers changed from: package-private */
    public final boolean b() {
        return false;
    }

    /* access modifiers changed from: package-private */
    public final boolean c() {
        return true;
    }

    /* JADX WARNING: type inference failed for: r2v18, types: [java.lang.Integer] */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean k(java.lang.Long r11, java.lang.Long r12, com.google.android.gms.internal.measurement.zzgm r13, boolean r14) {
        /*
            r10 = this;
            com.google.android.gms.internal.measurement.zzoy.zzc()
            com.google.android.gms.measurement.internal.b r0 = r10.f39773h
            com.google.android.gms.measurement.internal.u4 r0 = r0.f40059a
            com.google.android.gms.measurement.internal.g r0 = r0.z()
            java.lang.String r1 = r10.f39726a
            com.google.android.gms.measurement.internal.f3 r2 = com.google.android.gms.measurement.internal.g3.Y
            boolean r0 = r0.B(r1, r2)
            com.google.android.gms.internal.measurement.zzet r1 = r10.f39772g
            boolean r1 = r1.zzg()
            com.google.android.gms.internal.measurement.zzet r2 = r10.f39772g
            boolean r2 = r2.zzh()
            com.google.android.gms.internal.measurement.zzet r3 = r10.f39772g
            boolean r3 = r3.zzi()
            r4 = 0
            r5 = 1
            if (r1 != 0) goto L_0x0030
            if (r2 != 0) goto L_0x0030
            if (r3 == 0) goto L_0x002e
            goto L_0x0030
        L_0x002e:
            r1 = r4
            goto L_0x0031
        L_0x0030:
            r1 = r5
        L_0x0031:
            r2 = 0
            if (r14 == 0) goto L_0x0060
            if (r1 != 0) goto L_0x0060
            com.google.android.gms.measurement.internal.b r11 = r10.f39773h
            com.google.android.gms.measurement.internal.u4 r11 = r11.f40059a
            com.google.android.gms.measurement.internal.q3 r11 = r11.d()
            com.google.android.gms.measurement.internal.o3 r11 = r11.v()
            int r12 = r10.f39727b
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)
            com.google.android.gms.internal.measurement.zzet r13 = r10.f39772g
            boolean r13 = r13.zzj()
            if (r13 == 0) goto L_0x005a
            com.google.android.gms.internal.measurement.zzet r13 = r10.f39772g
            int r13 = r13.zza()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r13)
        L_0x005a:
            java.lang.String r13 = "Property filter already evaluated true and it is not associated with an enhanced audience. audience ID, filter ID"
            r11.c(r13, r12, r2)
            return r5
        L_0x0060:
            com.google.android.gms.internal.measurement.zzet r6 = r10.f39772g
            com.google.android.gms.internal.measurement.zzem r6 = r6.zzb()
            boolean r7 = r6.zzg()
            boolean r8 = r13.zzr()
            if (r8 == 0) goto L_0x00ab
            boolean r8 = r6.zzi()
            if (r8 != 0) goto L_0x0099
            com.google.android.gms.measurement.internal.b r6 = r10.f39773h
            com.google.android.gms.measurement.internal.u4 r6 = r6.f40059a
            com.google.android.gms.measurement.internal.q3 r6 = r6.d()
            com.google.android.gms.measurement.internal.o3 r6 = r6.w()
            com.google.android.gms.measurement.internal.b r7 = r10.f39773h
            com.google.android.gms.measurement.internal.u4 r7 = r7.f40059a
            com.google.android.gms.measurement.internal.l3 r7 = r7.D()
            java.lang.String r8 = r13.zzf()
            java.lang.String r7 = r7.f(r8)
            java.lang.String r8 = "No number filter for long property. property"
            r6.b(r8, r7)
            goto L_0x019c
        L_0x0099:
            long r8 = r13.zzb()
            com.google.android.gms.internal.measurement.zzer r2 = r6.zzc()
            java.lang.Boolean r2 = com.google.android.gms.measurement.internal.da.h(r8, r2)
            java.lang.Boolean r2 = com.google.android.gms.measurement.internal.da.j(r2, r7)
            goto L_0x019c
        L_0x00ab:
            boolean r8 = r13.zzq()
            if (r8 == 0) goto L_0x00ec
            boolean r8 = r6.zzi()
            if (r8 != 0) goto L_0x00da
            com.google.android.gms.measurement.internal.b r6 = r10.f39773h
            com.google.android.gms.measurement.internal.u4 r6 = r6.f40059a
            com.google.android.gms.measurement.internal.q3 r6 = r6.d()
            com.google.android.gms.measurement.internal.o3 r6 = r6.w()
            com.google.android.gms.measurement.internal.b r7 = r10.f39773h
            com.google.android.gms.measurement.internal.u4 r7 = r7.f40059a
            com.google.android.gms.measurement.internal.l3 r7 = r7.D()
            java.lang.String r8 = r13.zzf()
            java.lang.String r7 = r7.f(r8)
            java.lang.String r8 = "No number filter for double property. property"
            r6.b(r8, r7)
            goto L_0x019c
        L_0x00da:
            double r8 = r13.zza()
            com.google.android.gms.internal.measurement.zzer r2 = r6.zzc()
            java.lang.Boolean r2 = com.google.android.gms.measurement.internal.da.g(r8, r2)
            java.lang.Boolean r2 = com.google.android.gms.measurement.internal.da.j(r2, r7)
            goto L_0x019c
        L_0x00ec:
            boolean r8 = r13.zzt()
            if (r8 == 0) goto L_0x017b
            boolean r8 = r6.zzk()
            if (r8 != 0) goto L_0x0162
            boolean r8 = r6.zzi()
            if (r8 != 0) goto L_0x0121
            com.google.android.gms.measurement.internal.b r6 = r10.f39773h
            com.google.android.gms.measurement.internal.u4 r6 = r6.f40059a
            com.google.android.gms.measurement.internal.q3 r6 = r6.d()
            com.google.android.gms.measurement.internal.o3 r6 = r6.w()
            com.google.android.gms.measurement.internal.b r7 = r10.f39773h
            com.google.android.gms.measurement.internal.u4 r7 = r7.f40059a
            com.google.android.gms.measurement.internal.l3 r7 = r7.D()
            java.lang.String r8 = r13.zzf()
            java.lang.String r7 = r7.f(r8)
            java.lang.String r8 = "No string or number filter defined. property"
            r6.b(r8, r7)
            goto L_0x019c
        L_0x0121:
            java.lang.String r8 = r13.zzg()
            boolean r8 = com.google.android.gms.measurement.internal.p9.P(r8)
            if (r8 == 0) goto L_0x013c
            java.lang.String r2 = r13.zzg()
            com.google.android.gms.internal.measurement.zzer r6 = r6.zzc()
            java.lang.Boolean r2 = com.google.android.gms.measurement.internal.da.i(r2, r6)
            java.lang.Boolean r2 = com.google.android.gms.measurement.internal.da.j(r2, r7)
            goto L_0x019c
        L_0x013c:
            com.google.android.gms.measurement.internal.b r6 = r10.f39773h
            com.google.android.gms.measurement.internal.u4 r6 = r6.f40059a
            com.google.android.gms.measurement.internal.q3 r6 = r6.d()
            com.google.android.gms.measurement.internal.o3 r6 = r6.w()
            com.google.android.gms.measurement.internal.b r7 = r10.f39773h
            com.google.android.gms.measurement.internal.u4 r7 = r7.f40059a
            com.google.android.gms.measurement.internal.l3 r7 = r7.D()
            java.lang.String r8 = r13.zzf()
            java.lang.String r7 = r7.f(r8)
            java.lang.String r8 = r13.zzg()
            java.lang.String r9 = "Invalid user property value for Numeric number filter. property, value"
            r6.c(r9, r7, r8)
            goto L_0x019c
        L_0x0162:
            java.lang.String r2 = r13.zzg()
            com.google.android.gms.internal.measurement.zzey r6 = r6.zzd()
            com.google.android.gms.measurement.internal.b r8 = r10.f39773h
            com.google.android.gms.measurement.internal.u4 r8 = r8.f40059a
            com.google.android.gms.measurement.internal.q3 r8 = r8.d()
            java.lang.Boolean r2 = com.google.android.gms.measurement.internal.da.f(r2, r6, r8)
            java.lang.Boolean r2 = com.google.android.gms.measurement.internal.da.j(r2, r7)
            goto L_0x019c
        L_0x017b:
            com.google.android.gms.measurement.internal.b r6 = r10.f39773h
            com.google.android.gms.measurement.internal.u4 r6 = r6.f40059a
            com.google.android.gms.measurement.internal.q3 r6 = r6.d()
            com.google.android.gms.measurement.internal.o3 r6 = r6.w()
            com.google.android.gms.measurement.internal.b r7 = r10.f39773h
            com.google.android.gms.measurement.internal.u4 r7 = r7.f40059a
            com.google.android.gms.measurement.internal.l3 r7 = r7.D()
            java.lang.String r8 = r13.zzf()
            java.lang.String r7 = r7.f(r8)
            java.lang.String r8 = "User property has no value, property"
            r6.b(r8, r7)
        L_0x019c:
            com.google.android.gms.measurement.internal.b r6 = r10.f39773h
            com.google.android.gms.measurement.internal.u4 r6 = r6.f40059a
            com.google.android.gms.measurement.internal.q3 r6 = r6.d()
            com.google.android.gms.measurement.internal.o3 r6 = r6.v()
            if (r2 != 0) goto L_0x01ad
            java.lang.String r7 = "null"
            goto L_0x01ae
        L_0x01ad:
            r7 = r2
        L_0x01ae:
            java.lang.String r8 = "Property filter result"
            r6.b(r8, r7)
            if (r2 != 0) goto L_0x01b6
            return r4
        L_0x01b6:
            java.lang.Boolean r4 = java.lang.Boolean.TRUE
            r10.f39728c = r4
            if (r3 == 0) goto L_0x01c4
            boolean r3 = r2.booleanValue()
            if (r3 == 0) goto L_0x01c3
            goto L_0x01c4
        L_0x01c3:
            return r5
        L_0x01c4:
            if (r14 == 0) goto L_0x01ce
            com.google.android.gms.internal.measurement.zzet r14 = r10.f39772g
            boolean r14 = r14.zzg()
            if (r14 == 0) goto L_0x01d0
        L_0x01ce:
            r10.f39729d = r2
        L_0x01d0:
            boolean r14 = r2.booleanValue()
            if (r14 == 0) goto L_0x0215
            if (r1 == 0) goto L_0x0215
            boolean r14 = r13.zzs()
            if (r14 == 0) goto L_0x0215
            long r13 = r13.zzc()
            if (r11 == 0) goto L_0x01e8
            long r13 = r11.longValue()
        L_0x01e8:
            if (r0 == 0) goto L_0x0200
            com.google.android.gms.internal.measurement.zzet r11 = r10.f39772g
            boolean r11 = r11.zzg()
            if (r11 == 0) goto L_0x0200
            com.google.android.gms.internal.measurement.zzet r11 = r10.f39772g
            boolean r11 = r11.zzh()
            if (r11 != 0) goto L_0x0200
            if (r12 == 0) goto L_0x0200
            long r13 = r12.longValue()
        L_0x0200:
            com.google.android.gms.internal.measurement.zzet r11 = r10.f39772g
            boolean r11 = r11.zzh()
            if (r11 == 0) goto L_0x020f
            java.lang.Long r11 = java.lang.Long.valueOf(r13)
            r10.f39731f = r11
            goto L_0x0215
        L_0x020f:
            java.lang.Long r11 = java.lang.Long.valueOf(r13)
            r10.f39730e = r11
        L_0x0215:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.ea.k(java.lang.Long, java.lang.Long, com.google.android.gms.internal.measurement.zzgm, boolean):boolean");
    }
}
