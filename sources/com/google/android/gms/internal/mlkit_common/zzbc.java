package com.google.android.gms.internal.mlkit_common;

final class zzbc extends zzau {
    static final zzau zza = new zzbc((Object) null, new Object[0], 0);
    final transient Object[] zzb;
    private final transient Object zzc;
    private final transient int zzd;

    private zzbc(Object obj, Object[] objArr, int i10) {
        this.zzc = obj;
        this.zzb = objArr;
        this.zzd = i10;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v3, resolved type: short[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v6, resolved type: java.lang.Object[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v25, resolved type: short[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static com.google.android.gms.internal.mlkit_common.zzbc zzg(int r16, java.lang.Object[] r17, com.google.android.gms.internal.mlkit_common.zzat r18) {
        /*
            r0 = r16
            r1 = r17
            r2 = r18
            if (r0 != 0) goto L_0x000d
            com.google.android.gms.internal.mlkit_common.zzau r0 = zza
            com.google.android.gms.internal.mlkit_common.zzbc r0 = (com.google.android.gms.internal.mlkit_common.zzbc) r0
            return r0
        L_0x000d:
            r3 = 0
            r4 = 0
            r5 = 1
            if (r0 != r5) goto L_0x0025
            r0 = r1[r4]
            r0.getClass()
            r2 = r1[r5]
            r2.getClass()
            com.google.android.gms.internal.mlkit_common.zzai.zza(r0, r2)
            com.google.android.gms.internal.mlkit_common.zzbc r0 = new com.google.android.gms.internal.mlkit_common.zzbc
            r0.<init>(r3, r1, r5)
            return r0
        L_0x0025:
            int r6 = r1.length
            int r6 = r6 >> r5
            java.lang.String r7 = "index"
            com.google.android.gms.internal.mlkit_common.zzaf.zzb(r0, r6, r7)
            r6 = 2
            int r7 = java.lang.Math.max(r0, r6)
            r8 = 751619276(0x2ccccccc, float:5.8207657E-12)
            r9 = 1073741824(0x40000000, float:2.0)
            if (r7 >= r8) goto L_0x004e
            int r8 = r7 + -1
            int r8 = java.lang.Integer.highestOneBit(r8)
            int r8 = r8 + r8
            r9 = r8
        L_0x0040:
            double r10 = (double) r9
            r12 = 4604480259023595110(0x3fe6666666666666, double:0.7)
            double r10 = r10 * r12
            double r12 = (double) r7
            int r8 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r8 >= 0) goto L_0x0050
            int r9 = r9 + r9
            goto L_0x0040
        L_0x004e:
            if (r7 >= r9) goto L_0x01e7
        L_0x0050:
            if (r0 != r5) goto L_0x0063
            r7 = r1[r4]
            r7.getClass()
            r8 = r1[r5]
            r8.getClass()
            com.google.android.gms.internal.mlkit_common.zzai.zza(r7, r8)
            r7 = r5
            r5 = r6
            goto L_0x01ba
        L_0x0063:
            int r7 = r9 + -1
            r8 = 128(0x80, float:1.794E-43)
            r10 = 3
            r11 = -1
            if (r9 > r8) goto L_0x00dd
            byte[] r8 = new byte[r9]
            java.util.Arrays.fill(r8, r11)
            r9 = r4
            r11 = r9
        L_0x0072:
            if (r9 >= r0) goto L_0x00c5
            int r12 = r11 + r11
            int r13 = r9 + r9
            r14 = r1[r13]
            r14.getClass()
            r13 = r13 ^ r5
            r13 = r1[r13]
            r13.getClass()
            com.google.android.gms.internal.mlkit_common.zzai.zza(r14, r13)
            int r15 = r14.hashCode()
            int r15 = com.google.android.gms.internal.mlkit_common.zzak.zza(r15)
        L_0x008e:
            r15 = r15 & r7
            byte r6 = r8[r15]
            r5 = 255(0xff, float:3.57E-43)
            r6 = r6 & r5
            if (r6 != r5) goto L_0x00a4
            byte r5 = (byte) r12
            r8[r15] = r5
            if (r11 >= r9) goto L_0x00a1
            r1[r12] = r14
            r5 = r12 ^ 1
            r1[r5] = r13
        L_0x00a1:
            int r11 = r11 + 1
            goto L_0x00bb
        L_0x00a4:
            r5 = r1[r6]
            boolean r5 = r14.equals(r5)
            if (r5 == 0) goto L_0x00c0
            r3 = r6 ^ 1
            com.google.android.gms.internal.mlkit_common.zzas r5 = new com.google.android.gms.internal.mlkit_common.zzas
            r6 = r1[r3]
            r6.getClass()
            r5.<init>(r14, r13, r6)
            r1[r3] = r13
            r3 = r5
        L_0x00bb:
            int r9 = r9 + 1
            r5 = 1
            r6 = 2
            goto L_0x0072
        L_0x00c0:
            int r15 = r15 + 1
            r5 = 1
            r6 = 2
            goto L_0x008e
        L_0x00c5:
            if (r11 != r0) goto L_0x00ca
            r3 = r8
        L_0x00c8:
            r5 = 2
            goto L_0x00da
        L_0x00ca:
            java.lang.Object[] r5 = new java.lang.Object[r10]
            r5[r4] = r8
            java.lang.Integer r6 = java.lang.Integer.valueOf(r11)
            r7 = 1
            r5[r7] = r6
            r6 = 2
            r5[r6] = r3
            r3 = r5
            r5 = r6
        L_0x00da:
            r7 = 1
            goto L_0x01ba
        L_0x00dd:
            r5 = 32768(0x8000, float:4.5918E-41)
            if (r9 > r5) goto L_0x0150
            short[] r5 = new short[r9]
            java.util.Arrays.fill(r5, r11)
            r6 = r4
            r8 = r6
        L_0x00e9:
            if (r6 >= r0) goto L_0x013a
            int r9 = r8 + r8
            int r11 = r6 + r6
            r12 = r1[r11]
            r12.getClass()
            r13 = 1
            r11 = r11 ^ r13
            r11 = r1[r11]
            r11.getClass()
            com.google.android.gms.internal.mlkit_common.zzai.zza(r12, r11)
            int r13 = r12.hashCode()
            int r13 = com.google.android.gms.internal.mlkit_common.zzak.zza(r13)
        L_0x0106:
            r13 = r13 & r7
            short r14 = r5[r13]
            char r14 = (char) r14
            r15 = 65535(0xffff, float:9.1834E-41)
            if (r14 != r15) goto L_0x011d
            short r14 = (short) r9
            r5[r13] = r14
            if (r8 >= r6) goto L_0x011a
            r1[r9] = r12
            r9 = r9 ^ 1
            r1[r9] = r11
        L_0x011a:
            int r8 = r8 + 1
            goto L_0x0134
        L_0x011d:
            r15 = r1[r14]
            boolean r15 = r12.equals(r15)
            if (r15 == 0) goto L_0x0137
            r3 = r14 ^ 1
            com.google.android.gms.internal.mlkit_common.zzas r9 = new com.google.android.gms.internal.mlkit_common.zzas
            r13 = r1[r3]
            r13.getClass()
            r9.<init>(r12, r11, r13)
            r1[r3] = r11
            r3 = r9
        L_0x0134:
            int r6 = r6 + 1
            goto L_0x00e9
        L_0x0137:
            int r13 = r13 + 1
            goto L_0x0106
        L_0x013a:
            if (r8 != r0) goto L_0x013e
            goto L_0x01a8
        L_0x013e:
            java.lang.Object[] r6 = new java.lang.Object[r10]
            r6[r4] = r5
            java.lang.Integer r5 = java.lang.Integer.valueOf(r8)
            r8 = 1
            r6[r8] = r5
            r5 = 2
            r6[r5] = r3
            r3 = r6
            r7 = r8
            goto L_0x01ba
        L_0x0150:
            r8 = 1
            int[] r5 = new int[r9]
            java.util.Arrays.fill(r5, r11)
            r6 = r4
            r9 = r6
        L_0x0158:
            if (r6 >= r0) goto L_0x01a6
            int r12 = r9 + r9
            int r13 = r6 + r6
            r14 = r1[r13]
            r14.getClass()
            r13 = r13 ^ r8
            r8 = r1[r13]
            r8.getClass()
            com.google.android.gms.internal.mlkit_common.zzai.zza(r14, r8)
            int r13 = r14.hashCode()
            int r13 = com.google.android.gms.internal.mlkit_common.zzak.zza(r13)
        L_0x0174:
            r13 = r13 & r7
            r15 = r5[r13]
            if (r15 != r11) goto L_0x0186
            r5[r13] = r12
            if (r9 >= r6) goto L_0x0183
            r1[r12] = r14
            r12 = r12 ^ 1
            r1[r12] = r8
        L_0x0183:
            int r9 = r9 + 1
            goto L_0x019d
        L_0x0186:
            r11 = r1[r15]
            boolean r11 = r14.equals(r11)
            if (r11 == 0) goto L_0x01a2
            r3 = r15 ^ 1
            com.google.android.gms.internal.mlkit_common.zzas r11 = new com.google.android.gms.internal.mlkit_common.zzas
            r12 = r1[r3]
            r12.getClass()
            r11.<init>(r14, r8, r12)
            r1[r3] = r8
            r3 = r11
        L_0x019d:
            int r6 = r6 + 1
            r8 = 1
            r11 = -1
            goto L_0x0158
        L_0x01a2:
            int r13 = r13 + 1
            r11 = -1
            goto L_0x0174
        L_0x01a6:
            if (r9 != r0) goto L_0x01ab
        L_0x01a8:
            r3 = r5
            goto L_0x00c8
        L_0x01ab:
            java.lang.Object[] r6 = new java.lang.Object[r10]
            r6[r4] = r5
            java.lang.Integer r5 = java.lang.Integer.valueOf(r9)
            r7 = 1
            r6[r7] = r5
            r5 = 2
            r6[r5] = r3
            r3 = r6
        L_0x01ba:
            boolean r6 = r3 instanceof java.lang.Object[]
            if (r6 == 0) goto L_0x01e1
            java.lang.Object[] r3 = (java.lang.Object[]) r3
            r0 = r3[r5]
            com.google.android.gms.internal.mlkit_common.zzas r0 = (com.google.android.gms.internal.mlkit_common.zzas) r0
            if (r2 == 0) goto L_0x01dc
            r2.zzc = r0
            r0 = r3[r4]
            r2 = r3[r7]
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r2 = r2.intValue()
            int r3 = r2 + r2
            java.lang.Object[] r1 = java.util.Arrays.copyOf(r1, r3)
            r3 = r0
            r0 = r2
            goto L_0x01e1
        L_0x01dc:
            java.lang.IllegalArgumentException r0 = r0.zza()
            throw r0
        L_0x01e1:
            com.google.android.gms.internal.mlkit_common.zzbc r2 = new com.google.android.gms.internal.mlkit_common.zzbc
            r2.<init>(r3, r1, r0)
            return r2
        L_0x01e7:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "collection too large"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_common.zzbc.zzg(int, java.lang.Object[], com.google.android.gms.internal.mlkit_common.zzat):com.google.android.gms.internal.mlkit_common.zzbc");
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x009e A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x009f A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object get(java.lang.Object r10) {
        /*
            r9 = this;
            java.lang.Object r0 = r9.zzc
            java.lang.Object[] r1 = r9.zzb
            int r2 = r9.zzd
            r3 = 0
            if (r10 != 0) goto L_0x000c
        L_0x0009:
            r10 = r3
            goto L_0x009c
        L_0x000c:
            r4 = 1
            if (r2 != r4) goto L_0x0022
            r0 = 0
            r0 = r1[r0]
            r0.getClass()
            boolean r10 = r0.equals(r10)
            if (r10 == 0) goto L_0x0009
            r10 = r1[r4]
            r10.getClass()
            goto L_0x009c
        L_0x0022:
            if (r0 != 0) goto L_0x0025
            goto L_0x0009
        L_0x0025:
            boolean r2 = r0 instanceof byte[]
            r5 = -1
            if (r2 == 0) goto L_0x0051
            r2 = r0
            byte[] r2 = (byte[]) r2
            int r0 = r2.length
            int r6 = r0 + -1
            int r0 = r10.hashCode()
            int r0 = com.google.android.gms.internal.mlkit_common.zzak.zza(r0)
        L_0x0038:
            r0 = r0 & r6
            byte r5 = r2[r0]
            r7 = 255(0xff, float:3.57E-43)
            r5 = r5 & r7
            if (r5 != r7) goto L_0x0041
            goto L_0x0009
        L_0x0041:
            r7 = r1[r5]
            boolean r7 = r10.equals(r7)
            if (r7 == 0) goto L_0x004e
            r10 = r5 ^ 1
            r10 = r1[r10]
            goto L_0x009c
        L_0x004e:
            int r0 = r0 + 1
            goto L_0x0038
        L_0x0051:
            boolean r2 = r0 instanceof short[]
            if (r2 == 0) goto L_0x007d
            r2 = r0
            short[] r2 = (short[]) r2
            int r0 = r2.length
            int r6 = r0 + -1
            int r0 = r10.hashCode()
            int r0 = com.google.android.gms.internal.mlkit_common.zzak.zza(r0)
        L_0x0063:
            r0 = r0 & r6
            short r5 = r2[r0]
            char r5 = (char) r5
            r7 = 65535(0xffff, float:9.1834E-41)
            if (r5 != r7) goto L_0x006d
            goto L_0x0009
        L_0x006d:
            r7 = r1[r5]
            boolean r7 = r10.equals(r7)
            if (r7 == 0) goto L_0x007a
            r10 = r5 ^ 1
            r10 = r1[r10]
            goto L_0x009c
        L_0x007a:
            int r0 = r0 + 1
            goto L_0x0063
        L_0x007d:
            int[] r0 = (int[]) r0
            int r2 = r0.length
            int r2 = r2 + r5
            int r6 = r10.hashCode()
            int r6 = com.google.android.gms.internal.mlkit_common.zzak.zza(r6)
        L_0x0089:
            r6 = r6 & r2
            r7 = r0[r6]
            if (r7 != r5) goto L_0x0090
            goto L_0x0009
        L_0x0090:
            r8 = r1[r7]
            boolean r8 = r10.equals(r8)
            if (r8 == 0) goto L_0x00a0
            r10 = r7 ^ 1
            r10 = r1[r10]
        L_0x009c:
            if (r10 != 0) goto L_0x009f
            return r3
        L_0x009f:
            return r10
        L_0x00a0:
            int r6 = r6 + 1
            goto L_0x0089
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_common.zzbc.get(java.lang.Object):java.lang.Object");
    }

    public final int size() {
        return this.zzd;
    }

    /* access modifiers changed from: package-private */
    public final zzan zza() {
        return new zzbb(this.zzb, 1, this.zzd);
    }

    /* access modifiers changed from: package-private */
    public final zzav zzd() {
        return new zzaz(this, this.zzb, 0, this.zzd);
    }

    /* access modifiers changed from: package-private */
    public final zzav zze() {
        return new zzba(this, new zzbb(this.zzb, 0, this.zzd));
    }
}
