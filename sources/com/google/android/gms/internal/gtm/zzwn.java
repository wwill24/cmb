package com.google.android.gms.internal.gtm;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import sun.misc.Unsafe;

final class zzwn<T> implements zzwx<T> {
    private static final int[] zza = new int[0];
    private static final Unsafe zzb = zzxy.zzg();
    private final int[] zzc;
    private final Object[] zzd;
    private final int zze;
    private final int zzf;
    private final zzwk zzg;
    private final boolean zzh;
    private final boolean zzi;
    private final boolean zzj;
    private final int[] zzk;
    private final int zzl;
    private final int zzm;
    private final zzvy zzn;
    private final zzxo<?, ?> zzo;
    private final zzuk<?> zzp;
    private final zzwq zzq;
    private final zzwf zzr;

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: com.google.android.gms.internal.gtm.zzwk} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: java.lang.Object[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v8, resolved type: int[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v11, resolved type: com.google.android.gms.internal.gtm.zzwq} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: com.google.android.gms.internal.gtm.zzwf} */
    /* JADX WARNING: type inference failed for: r2v0, types: [com.google.android.gms.internal.gtm.zzuk<?>, com.google.android.gms.internal.gtm.zzuk] */
    /* JADX WARNING: type inference failed for: r3v2, types: [int] */
    /* JADX WARNING: type inference failed for: r3v9, types: [int] */
    /* JADX WARNING: type inference failed for: r3v12, types: [com.google.android.gms.internal.gtm.zzvy] */
    /* JADX WARNING: type inference failed for: r3v13, types: [com.google.android.gms.internal.gtm.zzxo<?, ?>] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private zzwn(int[] r6, int[] r7, java.lang.Object[] r8, int r9, int r10, com.google.android.gms.internal.gtm.zzwk r11, boolean r12, boolean r13, int[] r14, int r15, int r16, com.google.android.gms.internal.gtm.zzwq r17, com.google.android.gms.internal.gtm.zzvy r18, com.google.android.gms.internal.gtm.zzxo<?, ?> r19, com.google.android.gms.internal.gtm.zzuk<?> r20, com.google.android.gms.internal.gtm.zzwf r21) {
        /*
            r5 = this;
            r0 = r5
            r1 = r10
            r2 = r19
            r5.<init>()
            r3 = r6
            r0.zzc = r3
            r3 = r7
            r0.zzd = r3
            r3 = r8
            r0.zze = r3
            r3 = r9
            r0.zzf = r3
            boolean r3 = r1 instanceof com.google.android.gms.internal.gtm.zzuz
            r0.zzi = r3
            r3 = r11
            r0.zzj = r3
            r3 = 0
            if (r2 == 0) goto L_0x0024
            boolean r4 = r2.zzi(r10)
            if (r4 == 0) goto L_0x0024
            r3 = 1
        L_0x0024:
            r0.zzh = r3
            r3 = r13
            r0.zzk = r3
            r3 = r14
            r0.zzl = r3
            r3 = r15
            r0.zzm = r3
            r3 = r16
            r0.zzq = r3
            r3 = r17
            r0.zzn = r3
            r3 = r18
            r0.zzo = r3
            r0.zzp = r2
            r0.zzg = r1
            r1 = r20
            r0.zzr = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.gtm.zzwn.<init>(int[], java.lang.Object[], int, int, com.google.android.gms.internal.gtm.zzwk, boolean, boolean, int[], int, int, com.google.android.gms.internal.gtm.zzwq, com.google.android.gms.internal.gtm.zzvy, com.google.android.gms.internal.gtm.zzxo, com.google.android.gms.internal.gtm.zzuk, com.google.android.gms.internal.gtm.zzwf, byte[]):void");
    }

    private final int zzA(int i10, int i11) {
        int length = (this.zzc.length / 3) - 1;
        while (i11 <= length) {
            int i12 = (length + i11) >>> 1;
            int i13 = i12 * 3;
            int i14 = this.zzc[i13];
            if (i10 == i14) {
                return i13;
            }
            if (i10 < i14) {
                length = i12 - 1;
            } else {
                i11 = i12 + 1;
            }
        }
        return -1;
    }

    private static int zzB(int i10) {
        return (i10 >>> 20) & 255;
    }

    private final int zzC(int i10) {
        return this.zzc[i10 + 1];
    }

    private static <T> long zzD(T t10, long j10) {
        return ((Long) zzxy.zzf(t10, j10)).longValue();
    }

    private final zzvd zzE(int i10) {
        int i11 = i10 / 3;
        return (zzvd) this.zzd[i11 + i11 + 1];
    }

    private final zzwx zzF(int i10) {
        int i11 = i10 / 3;
        int i12 = i11 + i11;
        zzwx zzwx = (zzwx) this.zzd[i12];
        if (zzwx != null) {
            return zzwx;
        }
        zzwx zzb2 = zzwt.zza().zzb((Class) this.zzd[i12 + 1]);
        this.zzd[i12] = zzb2;
        return zzb2;
    }

    private final <UT, UB> UB zzG(Object obj, int i10, UB ub2, zzxo<UT, UB> zzxo) {
        int i11 = this.zzc[i10];
        Object zzf2 = zzxy.zzf(obj, (long) (zzC(i10) & 1048575));
        if (zzf2 == null || zzE(i10) == null) {
            return ub2;
        }
        zzwe zzwe = (zzwe) zzf2;
        zzwd zzwd = (zzwd) zzH(i10);
        throw null;
    }

    private final Object zzH(int i10) {
        int i11 = i10 / 3;
        return this.zzd[i11 + i11];
    }

    private static Field zzI(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            String name = cls.getName();
            String arrays = Arrays.toString(declaredFields);
            StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 40 + name.length() + String.valueOf(arrays).length());
            sb2.append("Field ");
            sb2.append(str);
            sb2.append(" for ");
            sb2.append(name);
            sb2.append(" not found. Known fields are ");
            sb2.append(arrays);
            throw new RuntimeException(sb2.toString());
        }
    }

    private final void zzJ(T t10, T t11, int i10) {
        long zzC = (long) (zzC(i10) & 1048575);
        if (zzQ(t11, i10)) {
            Object zzf2 = zzxy.zzf(t10, zzC);
            Object zzf3 = zzxy.zzf(t11, zzC);
            if (zzf2 != null && zzf3 != null) {
                zzxy.zzs(t10, zzC, zzvi.zzg(zzf2, zzf3));
                zzM(t10, i10);
            } else if (zzf3 != null) {
                zzxy.zzs(t10, zzC, zzf3);
                zzM(t10, i10);
            }
        }
    }

    private final void zzK(T t10, T t11, int i10) {
        Object obj;
        int zzC = zzC(i10);
        int i11 = this.zzc[i10];
        long j10 = (long) (zzC & 1048575);
        if (zzT(t11, i11, i10)) {
            if (zzT(t10, i11, i10)) {
                obj = zzxy.zzf(t10, j10);
            } else {
                obj = null;
            }
            Object zzf2 = zzxy.zzf(t11, j10);
            if (obj != null && zzf2 != null) {
                zzxy.zzs(t10, j10, zzvi.zzg(obj, zzf2));
                zzN(t10, i11, i10);
            } else if (zzf2 != null) {
                zzxy.zzs(t10, j10, zzf2);
                zzN(t10, i11, i10);
            }
        }
    }

    private final void zzL(Object obj, int i10, zzww zzww) throws IOException {
        if (zzP(i10)) {
            zzxy.zzs(obj, (long) (i10 & 1048575), zzww.zzx());
        } else if (this.zzi) {
            zzxy.zzs(obj, (long) (i10 & 1048575), zzww.zzv());
        } else {
            zzxy.zzs(obj, (long) (i10 & 1048575), zzww.zzq());
        }
    }

    private final void zzM(T t10, int i10) {
        int zzz = zzz(i10);
        long j10 = (long) (1048575 & zzz);
        if (j10 != 1048575) {
            zzxy.zzq(t10, j10, (1 << (zzz >>> 20)) | zzxy.zzc(t10, j10));
        }
    }

    private final void zzN(T t10, int i10, int i11) {
        zzxy.zzq(t10, (long) (zzz(i11) & 1048575), i10);
    }

    private final boolean zzO(T t10, T t11, int i10) {
        return zzQ(t10, i10) == zzQ(t11, i10);
    }

    private static boolean zzP(int i10) {
        return (i10 & 536870912) != 0;
    }

    private final boolean zzQ(T t10, int i10) {
        int zzz = zzz(i10);
        long j10 = (long) (zzz & 1048575);
        if (j10 == 1048575) {
            int zzC = zzC(i10);
            long j11 = (long) (zzC & 1048575);
            switch (zzB(zzC)) {
                case 0:
                    if (zzxy.zza(t10, j11) != 0.0d) {
                        return true;
                    }
                    return false;
                case 1:
                    if (zzxy.zzb(t10, j11) != 0.0f) {
                        return true;
                    }
                    return false;
                case 2:
                    if (zzxy.zzd(t10, j11) != 0) {
                        return true;
                    }
                    return false;
                case 3:
                    if (zzxy.zzd(t10, j11) != 0) {
                        return true;
                    }
                    return false;
                case 4:
                    if (zzxy.zzc(t10, j11) != 0) {
                        return true;
                    }
                    return false;
                case 5:
                    if (zzxy.zzd(t10, j11) != 0) {
                        return true;
                    }
                    return false;
                case 6:
                    if (zzxy.zzc(t10, j11) != 0) {
                        return true;
                    }
                    return false;
                case 7:
                    return zzxy.zzw(t10, j11);
                case 8:
                    Object zzf2 = zzxy.zzf(t10, j11);
                    if (zzf2 instanceof String) {
                        if (!((String) zzf2).isEmpty()) {
                            return true;
                        }
                        return false;
                    } else if (!(zzf2 instanceof zztd)) {
                        throw new IllegalArgumentException();
                    } else if (!zztd.zzb.equals(zzf2)) {
                        return true;
                    } else {
                        return false;
                    }
                case 9:
                    if (zzxy.zzf(t10, j11) != null) {
                        return true;
                    }
                    return false;
                case 10:
                    if (!zztd.zzb.equals(zzxy.zzf(t10, j11))) {
                        return true;
                    }
                    return false;
                case 11:
                    if (zzxy.zzc(t10, j11) != 0) {
                        return true;
                    }
                    return false;
                case 12:
                    if (zzxy.zzc(t10, j11) != 0) {
                        return true;
                    }
                    return false;
                case 13:
                    if (zzxy.zzc(t10, j11) != 0) {
                        return true;
                    }
                    return false;
                case 14:
                    if (zzxy.zzd(t10, j11) != 0) {
                        return true;
                    }
                    return false;
                case 15:
                    if (zzxy.zzc(t10, j11) != 0) {
                        return true;
                    }
                    return false;
                case 16:
                    if (zzxy.zzd(t10, j11) != 0) {
                        return true;
                    }
                    return false;
                case 17:
                    if (zzxy.zzf(t10, j11) != null) {
                        return true;
                    }
                    return false;
                default:
                    throw new IllegalArgumentException();
            }
        } else if ((zzxy.zzc(t10, j10) & (1 << (zzz >>> 20))) != 0) {
            return true;
        } else {
            return false;
        }
    }

    private final boolean zzR(T t10, int i10, int i11, int i12, int i13) {
        return i11 == 1048575 ? zzQ(t10, i10) : (i12 & i13) != 0;
    }

    private static boolean zzS(Object obj, int i10, zzwx zzwx) {
        return zzwx.zzk(zzxy.zzf(obj, (long) (i10 & 1048575)));
    }

    private final boolean zzT(T t10, int i10, int i11) {
        if (zzxy.zzc(t10, (long) (zzz(i11) & 1048575)) == i10) {
            return true;
        }
        return false;
    }

    private static <T> boolean zzU(T t10, long j10) {
        return ((Boolean) zzxy.zzf(t10, j10)).booleanValue();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:101:0x02e5, code lost:
        r15 = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:167:0x0483, code lost:
        r10 = r10 + 3;
        r8 = 1048575;
     */
    /* JADX WARNING: Removed duplicated region for block: B:169:0x048c  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0032  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzV(T r18, com.google.android.gms.internal.gtm.zztp r19) throws java.io.IOException {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            r2 = r19
            boolean r3 = r0.zzh
            if (r3 == 0) goto L_0x0023
            com.google.android.gms.internal.gtm.zzuk<?> r3 = r0.zzp
            com.google.android.gms.internal.gtm.zzuo r3 = r3.zzb(r1)
            com.google.android.gms.internal.gtm.zzxk<T, java.lang.Object> r5 = r3.zza
            boolean r5 = r5.isEmpty()
            if (r5 != 0) goto L_0x0023
            java.util.Iterator r3 = r3.zzf()
            java.lang.Object r5 = r3.next()
            java.util.Map$Entry r5 = (java.util.Map.Entry) r5
            goto L_0x0025
        L_0x0023:
            r3 = 0
            r5 = 0
        L_0x0025:
            int[] r6 = r0.zzc
            int r6 = r6.length
            sun.misc.Unsafe r7 = zzb
            r8 = 1048575(0xfffff, float:1.469367E-39)
            r11 = r8
            r10 = 0
            r12 = 0
        L_0x0030:
            if (r10 >= r6) goto L_0x048a
            int r13 = r0.zzC(r10)
            int[] r14 = r0.zzc
            r14 = r14[r10]
            int r15 = zzB(r13)
            r4 = 17
            if (r15 > r4) goto L_0x0058
            int[] r4 = r0.zzc
            int r16 = r10 + 2
            r4 = r4[r16]
            r9 = r4 & r8
            if (r9 == r11) goto L_0x0052
            long r11 = (long) r9
            int r12 = r7.getInt(r1, r11)
            r11 = r9
        L_0x0052:
            int r4 = r4 >>> 20
            r9 = 1
            int r4 = r9 << r4
            goto L_0x0059
        L_0x0058:
            r4 = 0
        L_0x0059:
            if (r5 == 0) goto L_0x0077
            com.google.android.gms.internal.gtm.zzuk<?> r9 = r0.zzp
            int r9 = r9.zza(r5)
            if (r9 > r14) goto L_0x0077
            com.google.android.gms.internal.gtm.zzuk<?> r9 = r0.zzp
            r9.zzj(r2, r5)
            boolean r5 = r3.hasNext()
            if (r5 == 0) goto L_0x0075
            java.lang.Object r5 = r3.next()
            java.util.Map$Entry r5 = (java.util.Map.Entry) r5
            goto L_0x0059
        L_0x0075:
            r5 = 0
            goto L_0x0059
        L_0x0077:
            r9 = r13 & r8
            long r8 = (long) r9
            switch(r15) {
                case 0: goto L_0x0478;
                case 1: goto L_0x046c;
                case 2: goto L_0x0460;
                case 3: goto L_0x0454;
                case 4: goto L_0x0448;
                case 5: goto L_0x043c;
                case 6: goto L_0x0430;
                case 7: goto L_0x0424;
                case 8: goto L_0x0418;
                case 9: goto L_0x0407;
                case 10: goto L_0x03f8;
                case 11: goto L_0x03eb;
                case 12: goto L_0x03de;
                case 13: goto L_0x03d1;
                case 14: goto L_0x03c4;
                case 15: goto L_0x03b7;
                case 16: goto L_0x03aa;
                case 17: goto L_0x0399;
                case 18: goto L_0x0389;
                case 19: goto L_0x0379;
                case 20: goto L_0x0369;
                case 21: goto L_0x0359;
                case 22: goto L_0x0349;
                case 23: goto L_0x0339;
                case 24: goto L_0x0329;
                case 25: goto L_0x0319;
                case 26: goto L_0x030a;
                case 27: goto L_0x02f7;
                case 28: goto L_0x02e8;
                case 29: goto L_0x02d7;
                case 30: goto L_0x02c8;
                case 31: goto L_0x02b9;
                case 32: goto L_0x02aa;
                case 33: goto L_0x029b;
                case 34: goto L_0x028c;
                case 35: goto L_0x027c;
                case 36: goto L_0x026c;
                case 37: goto L_0x025c;
                case 38: goto L_0x024c;
                case 39: goto L_0x023c;
                case 40: goto L_0x022c;
                case 41: goto L_0x021c;
                case 42: goto L_0x020c;
                case 43: goto L_0x01fc;
                case 44: goto L_0x01ec;
                case 45: goto L_0x01dc;
                case 46: goto L_0x01cc;
                case 47: goto L_0x01bc;
                case 48: goto L_0x01ac;
                case 49: goto L_0x0199;
                case 50: goto L_0x0190;
                case 51: goto L_0x0181;
                case 52: goto L_0x0172;
                case 53: goto L_0x0163;
                case 54: goto L_0x0154;
                case 55: goto L_0x0145;
                case 56: goto L_0x0136;
                case 57: goto L_0x0127;
                case 58: goto L_0x0118;
                case 59: goto L_0x0109;
                case 60: goto L_0x00f6;
                case 61: goto L_0x00e6;
                case 62: goto L_0x00d8;
                case 63: goto L_0x00ca;
                case 64: goto L_0x00bc;
                case 65: goto L_0x00ae;
                case 66: goto L_0x00a0;
                case 67: goto L_0x0092;
                case 68: goto L_0x0080;
                default: goto L_0x007d;
            }
        L_0x007d:
            r15 = 0
            goto L_0x0483
        L_0x0080:
            boolean r4 = r0.zzT(r1, r14, r10)
            if (r4 == 0) goto L_0x007d
            java.lang.Object r4 = r7.getObject(r1, r8)
            com.google.android.gms.internal.gtm.zzwx r8 = r0.zzF(r10)
            r2.zzq(r14, r4, r8)
            goto L_0x007d
        L_0x0092:
            boolean r4 = r0.zzT(r1, r14, r10)
            if (r4 == 0) goto L_0x007d
            long r8 = zzD(r1, r8)
            r2.zzD(r14, r8)
            goto L_0x007d
        L_0x00a0:
            boolean r4 = r0.zzT(r1, r14, r10)
            if (r4 == 0) goto L_0x007d
            int r4 = zzs(r1, r8)
            r2.zzB(r14, r4)
            goto L_0x007d
        L_0x00ae:
            boolean r4 = r0.zzT(r1, r14, r10)
            if (r4 == 0) goto L_0x007d
            long r8 = zzD(r1, r8)
            r2.zzz(r14, r8)
            goto L_0x007d
        L_0x00bc:
            boolean r4 = r0.zzT(r1, r14, r10)
            if (r4 == 0) goto L_0x007d
            int r4 = zzs(r1, r8)
            r2.zzx(r14, r4)
            goto L_0x007d
        L_0x00ca:
            boolean r4 = r0.zzT(r1, r14, r10)
            if (r4 == 0) goto L_0x007d
            int r4 = zzs(r1, r8)
            r2.zzi(r14, r4)
            goto L_0x007d
        L_0x00d8:
            boolean r4 = r0.zzT(r1, r14, r10)
            if (r4 == 0) goto L_0x007d
            int r4 = zzs(r1, r8)
            r2.zzI(r14, r4)
            goto L_0x007d
        L_0x00e6:
            boolean r4 = r0.zzT(r1, r14, r10)
            if (r4 == 0) goto L_0x007d
            java.lang.Object r4 = r7.getObject(r1, r8)
            com.google.android.gms.internal.gtm.zztd r4 = (com.google.android.gms.internal.gtm.zztd) r4
            r2.zzd(r14, r4)
            goto L_0x007d
        L_0x00f6:
            boolean r4 = r0.zzT(r1, r14, r10)
            if (r4 == 0) goto L_0x007d
            java.lang.Object r4 = r7.getObject(r1, r8)
            com.google.android.gms.internal.gtm.zzwx r8 = r0.zzF(r10)
            r2.zzv(r14, r4, r8)
            goto L_0x007d
        L_0x0109:
            boolean r4 = r0.zzT(r1, r14, r10)
            if (r4 == 0) goto L_0x007d
            java.lang.Object r4 = r7.getObject(r1, r8)
            zzX(r14, r4, r2)
            goto L_0x007d
        L_0x0118:
            boolean r4 = r0.zzT(r1, r14, r10)
            if (r4 == 0) goto L_0x007d
            boolean r4 = zzU(r1, r8)
            r2.zzb(r14, r4)
            goto L_0x007d
        L_0x0127:
            boolean r4 = r0.zzT(r1, r14, r10)
            if (r4 == 0) goto L_0x007d
            int r4 = zzs(r1, r8)
            r2.zzk(r14, r4)
            goto L_0x007d
        L_0x0136:
            boolean r4 = r0.zzT(r1, r14, r10)
            if (r4 == 0) goto L_0x007d
            long r8 = zzD(r1, r8)
            r2.zzm(r14, r8)
            goto L_0x007d
        L_0x0145:
            boolean r4 = r0.zzT(r1, r14, r10)
            if (r4 == 0) goto L_0x007d
            int r4 = zzs(r1, r8)
            r2.zzr(r14, r4)
            goto L_0x007d
        L_0x0154:
            boolean r4 = r0.zzT(r1, r14, r10)
            if (r4 == 0) goto L_0x007d
            long r8 = zzD(r1, r8)
            r2.zzK(r14, r8)
            goto L_0x007d
        L_0x0163:
            boolean r4 = r0.zzT(r1, r14, r10)
            if (r4 == 0) goto L_0x007d
            long r8 = zzD(r1, r8)
            r2.zzt(r14, r8)
            goto L_0x007d
        L_0x0172:
            boolean r4 = r0.zzT(r1, r14, r10)
            if (r4 == 0) goto L_0x007d
            float r4 = zzp(r1, r8)
            r2.zzo(r14, r4)
            goto L_0x007d
        L_0x0181:
            boolean r4 = r0.zzT(r1, r14, r10)
            if (r4 == 0) goto L_0x007d
            double r8 = zzo(r1, r8)
            r2.zzf(r14, r8)
            goto L_0x007d
        L_0x0190:
            java.lang.Object r4 = r7.getObject(r1, r8)
            r0.zzW(r2, r14, r4, r10)
            goto L_0x007d
        L_0x0199:
            int[] r4 = r0.zzc
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.gtm.zzwx r9 = r0.zzF(r10)
            com.google.android.gms.internal.gtm.zzwz.zzQ(r4, r8, r2, r9)
            goto L_0x007d
        L_0x01ac:
            int[] r4 = r0.zzc
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            r14 = 1
            com.google.android.gms.internal.gtm.zzwz.zzX(r4, r8, r2, r14)
            goto L_0x007d
        L_0x01bc:
            r14 = 1
            int[] r4 = r0.zzc
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.gtm.zzwz.zzW(r4, r8, r2, r14)
            goto L_0x007d
        L_0x01cc:
            r14 = 1
            int[] r4 = r0.zzc
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.gtm.zzwz.zzV(r4, r8, r2, r14)
            goto L_0x007d
        L_0x01dc:
            r14 = 1
            int[] r4 = r0.zzc
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.gtm.zzwz.zzU(r4, r8, r2, r14)
            goto L_0x007d
        L_0x01ec:
            r14 = 1
            int[] r4 = r0.zzc
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.gtm.zzwz.zzM(r4, r8, r2, r14)
            goto L_0x007d
        L_0x01fc:
            r14 = 1
            int[] r4 = r0.zzc
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.gtm.zzwz.zzZ(r4, r8, r2, r14)
            goto L_0x007d
        L_0x020c:
            r14 = 1
            int[] r4 = r0.zzc
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.gtm.zzwz.zzJ(r4, r8, r2, r14)
            goto L_0x007d
        L_0x021c:
            r14 = 1
            int[] r4 = r0.zzc
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.gtm.zzwz.zzN(r4, r8, r2, r14)
            goto L_0x007d
        L_0x022c:
            r14 = 1
            int[] r4 = r0.zzc
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.gtm.zzwz.zzO(r4, r8, r2, r14)
            goto L_0x007d
        L_0x023c:
            r14 = 1
            int[] r4 = r0.zzc
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.gtm.zzwz.zzR(r4, r8, r2, r14)
            goto L_0x007d
        L_0x024c:
            r14 = 1
            int[] r4 = r0.zzc
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.gtm.zzwz.zzaa(r4, r8, r2, r14)
            goto L_0x007d
        L_0x025c:
            r14 = 1
            int[] r4 = r0.zzc
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.gtm.zzwz.zzS(r4, r8, r2, r14)
            goto L_0x007d
        L_0x026c:
            r14 = 1
            int[] r4 = r0.zzc
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.gtm.zzwz.zzP(r4, r8, r2, r14)
            goto L_0x007d
        L_0x027c:
            r14 = 1
            int[] r4 = r0.zzc
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.gtm.zzwz.zzL(r4, r8, r2, r14)
            goto L_0x007d
        L_0x028c:
            int[] r4 = r0.zzc
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            r14 = 0
            com.google.android.gms.internal.gtm.zzwz.zzX(r4, r8, r2, r14)
            goto L_0x02e5
        L_0x029b:
            r14 = 0
            int[] r4 = r0.zzc
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.gtm.zzwz.zzW(r4, r8, r2, r14)
            goto L_0x02e5
        L_0x02aa:
            r14 = 0
            int[] r4 = r0.zzc
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.gtm.zzwz.zzV(r4, r8, r2, r14)
            goto L_0x02e5
        L_0x02b9:
            r14 = 0
            int[] r4 = r0.zzc
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.gtm.zzwz.zzU(r4, r8, r2, r14)
            goto L_0x02e5
        L_0x02c8:
            r14 = 0
            int[] r4 = r0.zzc
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.gtm.zzwz.zzM(r4, r8, r2, r14)
            goto L_0x02e5
        L_0x02d7:
            r14 = 0
            int[] r4 = r0.zzc
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.gtm.zzwz.zzZ(r4, r8, r2, r14)
        L_0x02e5:
            r15 = r14
            goto L_0x0483
        L_0x02e8:
            int[] r4 = r0.zzc
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.gtm.zzwz.zzK(r4, r8, r2)
            goto L_0x007d
        L_0x02f7:
            int[] r4 = r0.zzc
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.gtm.zzwx r9 = r0.zzF(r10)
            com.google.android.gms.internal.gtm.zzwz.zzT(r4, r8, r2, r9)
            goto L_0x007d
        L_0x030a:
            int[] r4 = r0.zzc
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.gtm.zzwz.zzY(r4, r8, r2)
            goto L_0x007d
        L_0x0319:
            int[] r4 = r0.zzc
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            r15 = 0
            com.google.android.gms.internal.gtm.zzwz.zzJ(r4, r8, r2, r15)
            goto L_0x0483
        L_0x0329:
            r15 = 0
            int[] r4 = r0.zzc
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.gtm.zzwz.zzN(r4, r8, r2, r15)
            goto L_0x0483
        L_0x0339:
            r15 = 0
            int[] r4 = r0.zzc
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.gtm.zzwz.zzO(r4, r8, r2, r15)
            goto L_0x0483
        L_0x0349:
            r15 = 0
            int[] r4 = r0.zzc
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.gtm.zzwz.zzR(r4, r8, r2, r15)
            goto L_0x0483
        L_0x0359:
            r15 = 0
            int[] r4 = r0.zzc
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.gtm.zzwz.zzaa(r4, r8, r2, r15)
            goto L_0x0483
        L_0x0369:
            r15 = 0
            int[] r4 = r0.zzc
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.gtm.zzwz.zzS(r4, r8, r2, r15)
            goto L_0x0483
        L_0x0379:
            r15 = 0
            int[] r4 = r0.zzc
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.gtm.zzwz.zzP(r4, r8, r2, r15)
            goto L_0x0483
        L_0x0389:
            r15 = 0
            int[] r4 = r0.zzc
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.gtm.zzwz.zzL(r4, r8, r2, r15)
            goto L_0x0483
        L_0x0399:
            r15 = 0
            r4 = r4 & r12
            if (r4 == 0) goto L_0x0483
            java.lang.Object r4 = r7.getObject(r1, r8)
            com.google.android.gms.internal.gtm.zzwx r8 = r0.zzF(r10)
            r2.zzq(r14, r4, r8)
            goto L_0x0483
        L_0x03aa:
            r15 = 0
            r4 = r4 & r12
            if (r4 == 0) goto L_0x0483
            long r8 = r7.getLong(r1, r8)
            r2.zzD(r14, r8)
            goto L_0x0483
        L_0x03b7:
            r15 = 0
            r4 = r4 & r12
            if (r4 == 0) goto L_0x0483
            int r4 = r7.getInt(r1, r8)
            r2.zzB(r14, r4)
            goto L_0x0483
        L_0x03c4:
            r15 = 0
            r4 = r4 & r12
            if (r4 == 0) goto L_0x0483
            long r8 = r7.getLong(r1, r8)
            r2.zzz(r14, r8)
            goto L_0x0483
        L_0x03d1:
            r15 = 0
            r4 = r4 & r12
            if (r4 == 0) goto L_0x0483
            int r4 = r7.getInt(r1, r8)
            r2.zzx(r14, r4)
            goto L_0x0483
        L_0x03de:
            r15 = 0
            r4 = r4 & r12
            if (r4 == 0) goto L_0x0483
            int r4 = r7.getInt(r1, r8)
            r2.zzi(r14, r4)
            goto L_0x0483
        L_0x03eb:
            r15 = 0
            r4 = r4 & r12
            if (r4 == 0) goto L_0x0483
            int r4 = r7.getInt(r1, r8)
            r2.zzI(r14, r4)
            goto L_0x0483
        L_0x03f8:
            r15 = 0
            r4 = r4 & r12
            if (r4 == 0) goto L_0x0483
            java.lang.Object r4 = r7.getObject(r1, r8)
            com.google.android.gms.internal.gtm.zztd r4 = (com.google.android.gms.internal.gtm.zztd) r4
            r2.zzd(r14, r4)
            goto L_0x0483
        L_0x0407:
            r15 = 0
            r4 = r4 & r12
            if (r4 == 0) goto L_0x0483
            java.lang.Object r4 = r7.getObject(r1, r8)
            com.google.android.gms.internal.gtm.zzwx r8 = r0.zzF(r10)
            r2.zzv(r14, r4, r8)
            goto L_0x0483
        L_0x0418:
            r15 = 0
            r4 = r4 & r12
            if (r4 == 0) goto L_0x0483
            java.lang.Object r4 = r7.getObject(r1, r8)
            zzX(r14, r4, r2)
            goto L_0x0483
        L_0x0424:
            r15 = 0
            r4 = r4 & r12
            if (r4 == 0) goto L_0x0483
            boolean r4 = com.google.android.gms.internal.gtm.zzxy.zzw(r1, r8)
            r2.zzb(r14, r4)
            goto L_0x0483
        L_0x0430:
            r15 = 0
            r4 = r4 & r12
            if (r4 == 0) goto L_0x0483
            int r4 = r7.getInt(r1, r8)
            r2.zzk(r14, r4)
            goto L_0x0483
        L_0x043c:
            r15 = 0
            r4 = r4 & r12
            if (r4 == 0) goto L_0x0483
            long r8 = r7.getLong(r1, r8)
            r2.zzm(r14, r8)
            goto L_0x0483
        L_0x0448:
            r15 = 0
            r4 = r4 & r12
            if (r4 == 0) goto L_0x0483
            int r4 = r7.getInt(r1, r8)
            r2.zzr(r14, r4)
            goto L_0x0483
        L_0x0454:
            r15 = 0
            r4 = r4 & r12
            if (r4 == 0) goto L_0x0483
            long r8 = r7.getLong(r1, r8)
            r2.zzK(r14, r8)
            goto L_0x0483
        L_0x0460:
            r15 = 0
            r4 = r4 & r12
            if (r4 == 0) goto L_0x0483
            long r8 = r7.getLong(r1, r8)
            r2.zzt(r14, r8)
            goto L_0x0483
        L_0x046c:
            r15 = 0
            r4 = r4 & r12
            if (r4 == 0) goto L_0x0483
            float r4 = com.google.android.gms.internal.gtm.zzxy.zzb(r1, r8)
            r2.zzo(r14, r4)
            goto L_0x0483
        L_0x0478:
            r15 = 0
            r4 = r4 & r12
            if (r4 == 0) goto L_0x0483
            double r8 = com.google.android.gms.internal.gtm.zzxy.zza(r1, r8)
            r2.zzf(r14, r8)
        L_0x0483:
            int r10 = r10 + 3
            r8 = 1048575(0xfffff, float:1.469367E-39)
            goto L_0x0030
        L_0x048a:
            if (r5 == 0) goto L_0x04a1
            com.google.android.gms.internal.gtm.zzuk<?> r4 = r0.zzp
            r4.zzj(r2, r5)
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x049f
            java.lang.Object r4 = r3.next()
            r5 = r4
            java.util.Map$Entry r5 = (java.util.Map.Entry) r5
            goto L_0x048a
        L_0x049f:
            r5 = 0
            goto L_0x048a
        L_0x04a1:
            com.google.android.gms.internal.gtm.zzxo<?, ?> r3 = r0.zzo
            java.lang.Object r1 = r3.zzd(r1)
            r3.zzs(r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.gtm.zzwn.zzV(java.lang.Object, com.google.android.gms.internal.gtm.zztp):void");
    }

    private final <K, V> void zzW(zztp zztp, int i10, Object obj, int i11) throws IOException {
        if (obj != null) {
            zzwd zzwd = (zzwd) zzH(i11);
            throw null;
        }
    }

    private static final void zzX(int i10, Object obj, zztp zztp) throws IOException {
        if (obj instanceof String) {
            zztp.zzG(i10, (String) obj);
        } else {
            zztp.zzd(i10, (zztd) obj);
        }
    }

    static zzxp zzd(Object obj) {
        zzuz zzuz = (zzuz) obj;
        zzxp zzxp = zzuz.zzc;
        if (zzxp != zzxp.zzc()) {
            return zzxp;
        }
        zzxp zze2 = zzxp.zze();
        zzuz.zzc = zze2;
        return zze2;
    }

    static <T> zzwn<T> zzl(Class<T> cls, zzwh zzwh, zzwq zzwq, zzvy zzvy, zzxo<?, ?> zzxo, zzuk<?> zzuk, zzwf zzwf) {
        if (zzwh instanceof zzwv) {
            return zzm((zzwv) zzwh, zzwq, zzvy, zzxo, zzuk, zzwf);
        }
        zzxl zzxl = (zzxl) zzwh;
        throw null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:120:0x025e  */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x0261  */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x0279  */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x027c  */
    /* JADX WARNING: Removed duplicated region for block: B:158:0x0330  */
    /* JADX WARNING: Removed duplicated region for block: B:171:0x0379  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static <T> com.google.android.gms.internal.gtm.zzwn<T> zzm(com.google.android.gms.internal.gtm.zzwv r34, com.google.android.gms.internal.gtm.zzwq r35, com.google.android.gms.internal.gtm.zzvy r36, com.google.android.gms.internal.gtm.zzxo<?, ?> r37, com.google.android.gms.internal.gtm.zzuk<?> r38, com.google.android.gms.internal.gtm.zzwf r39) {
        /*
            int r0 = r34.zzc()
            r1 = 0
            r3 = 2
            if (r0 != r3) goto L_0x000a
            r10 = 1
            goto L_0x000b
        L_0x000a:
            r10 = r1
        L_0x000b:
            java.lang.String r0 = r34.zzd()
            int r3 = r0.length()
            char r4 = r0.charAt(r1)
            r5 = 55296(0xd800, float:7.7486E-41)
            if (r4 < r5) goto L_0x0027
            r4 = 1
        L_0x001d:
            int r6 = r4 + 1
            char r4 = r0.charAt(r4)
            if (r4 < r5) goto L_0x0028
            r4 = r6
            goto L_0x001d
        L_0x0027:
            r6 = 1
        L_0x0028:
            int r4 = r6 + 1
            char r6 = r0.charAt(r6)
            if (r6 < r5) goto L_0x0047
            r6 = r6 & 8191(0x1fff, float:1.1478E-41)
            r8 = 13
        L_0x0034:
            int r9 = r4 + 1
            char r4 = r0.charAt(r4)
            if (r4 < r5) goto L_0x0044
            r4 = r4 & 8191(0x1fff, float:1.1478E-41)
            int r4 = r4 << r8
            r6 = r6 | r4
            int r8 = r8 + 13
            r4 = r9
            goto L_0x0034
        L_0x0044:
            int r4 = r4 << r8
            r6 = r6 | r4
            r4 = r9
        L_0x0047:
            if (r6 != 0) goto L_0x0057
            int[] r6 = zza
            r8 = r1
            r9 = r8
            r11 = r9
            r12 = r11
            r14 = r12
            r16 = r14
            r13 = r6
            r6 = r16
            goto L_0x0166
        L_0x0057:
            int r6 = r4 + 1
            char r4 = r0.charAt(r4)
            if (r4 < r5) goto L_0x0076
            r4 = r4 & 8191(0x1fff, float:1.1478E-41)
            r8 = 13
        L_0x0063:
            int r9 = r6 + 1
            char r6 = r0.charAt(r6)
            if (r6 < r5) goto L_0x0073
            r6 = r6 & 8191(0x1fff, float:1.1478E-41)
            int r6 = r6 << r8
            r4 = r4 | r6
            int r8 = r8 + 13
            r6 = r9
            goto L_0x0063
        L_0x0073:
            int r6 = r6 << r8
            r4 = r4 | r6
            r6 = r9
        L_0x0076:
            int r8 = r6 + 1
            char r6 = r0.charAt(r6)
            if (r6 < r5) goto L_0x0095
            r6 = r6 & 8191(0x1fff, float:1.1478E-41)
            r9 = 13
        L_0x0082:
            int r11 = r8 + 1
            char r8 = r0.charAt(r8)
            if (r8 < r5) goto L_0x0092
            r8 = r8 & 8191(0x1fff, float:1.1478E-41)
            int r8 = r8 << r9
            r6 = r6 | r8
            int r9 = r9 + 13
            r8 = r11
            goto L_0x0082
        L_0x0092:
            int r8 = r8 << r9
            r6 = r6 | r8
            r8 = r11
        L_0x0095:
            int r9 = r8 + 1
            char r8 = r0.charAt(r8)
            if (r8 < r5) goto L_0x00b4
            r8 = r8 & 8191(0x1fff, float:1.1478E-41)
            r11 = 13
        L_0x00a1:
            int r12 = r9 + 1
            char r9 = r0.charAt(r9)
            if (r9 < r5) goto L_0x00b1
            r9 = r9 & 8191(0x1fff, float:1.1478E-41)
            int r9 = r9 << r11
            r8 = r8 | r9
            int r11 = r11 + 13
            r9 = r12
            goto L_0x00a1
        L_0x00b1:
            int r9 = r9 << r11
            r8 = r8 | r9
            r9 = r12
        L_0x00b4:
            int r11 = r9 + 1
            char r9 = r0.charAt(r9)
            if (r9 < r5) goto L_0x00d3
            r9 = r9 & 8191(0x1fff, float:1.1478E-41)
            r12 = 13
        L_0x00c0:
            int r13 = r11 + 1
            char r11 = r0.charAt(r11)
            if (r11 < r5) goto L_0x00d0
            r11 = r11 & 8191(0x1fff, float:1.1478E-41)
            int r11 = r11 << r12
            r9 = r9 | r11
            int r12 = r12 + 13
            r11 = r13
            goto L_0x00c0
        L_0x00d0:
            int r11 = r11 << r12
            r9 = r9 | r11
            r11 = r13
        L_0x00d3:
            int r12 = r11 + 1
            char r11 = r0.charAt(r11)
            if (r11 < r5) goto L_0x00f2
            r11 = r11 & 8191(0x1fff, float:1.1478E-41)
            r13 = 13
        L_0x00df:
            int r14 = r12 + 1
            char r12 = r0.charAt(r12)
            if (r12 < r5) goto L_0x00ef
            r12 = r12 & 8191(0x1fff, float:1.1478E-41)
            int r12 = r12 << r13
            r11 = r11 | r12
            int r13 = r13 + 13
            r12 = r14
            goto L_0x00df
        L_0x00ef:
            int r12 = r12 << r13
            r11 = r11 | r12
            r12 = r14
        L_0x00f2:
            int r13 = r12 + 1
            char r12 = r0.charAt(r12)
            if (r12 < r5) goto L_0x0111
            r12 = r12 & 8191(0x1fff, float:1.1478E-41)
            r14 = 13
        L_0x00fe:
            int r15 = r13 + 1
            char r13 = r0.charAt(r13)
            if (r13 < r5) goto L_0x010e
            r13 = r13 & 8191(0x1fff, float:1.1478E-41)
            int r13 = r13 << r14
            r12 = r12 | r13
            int r14 = r14 + 13
            r13 = r15
            goto L_0x00fe
        L_0x010e:
            int r13 = r13 << r14
            r12 = r12 | r13
            r13 = r15
        L_0x0111:
            int r14 = r13 + 1
            char r13 = r0.charAt(r13)
            if (r13 < r5) goto L_0x0132
            r13 = r13 & 8191(0x1fff, float:1.1478E-41)
            r15 = 13
        L_0x011d:
            int r16 = r14 + 1
            char r14 = r0.charAt(r14)
            if (r14 < r5) goto L_0x012e
            r14 = r14 & 8191(0x1fff, float:1.1478E-41)
            int r14 = r14 << r15
            r13 = r13 | r14
            int r15 = r15 + 13
            r14 = r16
            goto L_0x011d
        L_0x012e:
            int r14 = r14 << r15
            r13 = r13 | r14
            r14 = r16
        L_0x0132:
            int r15 = r14 + 1
            char r14 = r0.charAt(r14)
            if (r14 < r5) goto L_0x0155
            r14 = r14 & 8191(0x1fff, float:1.1478E-41)
            r16 = 13
        L_0x013e:
            int r17 = r15 + 1
            char r15 = r0.charAt(r15)
            if (r15 < r5) goto L_0x0150
            r15 = r15 & 8191(0x1fff, float:1.1478E-41)
            int r15 = r15 << r16
            r14 = r14 | r15
            int r16 = r16 + 13
            r15 = r17
            goto L_0x013e
        L_0x0150:
            int r15 = r15 << r16
            r14 = r14 | r15
            r15 = r17
        L_0x0155:
            int r16 = r14 + r12
            int r13 = r16 + r13
            int[] r13 = new int[r13]
            int r16 = r4 + r4
            int r16 = r16 + r6
            r6 = r4
            r4 = r15
            r33 = r12
            r12 = r9
            r9 = r33
        L_0x0166:
            sun.misc.Unsafe r15 = zzb
            java.lang.Object[] r17 = r34.zze()
            com.google.android.gms.internal.gtm.zzwk r18 = r34.zza()
            java.lang.Class r1 = r18.getClass()
            int r7 = r11 * 3
            int[] r7 = new int[r7]
            int r11 = r11 + r11
            java.lang.Object[] r11 = new java.lang.Object[r11]
            int r21 = r14 + r9
            r22 = r14
            r23 = r21
            r9 = 0
            r20 = 0
        L_0x0184:
            if (r4 >= r3) goto L_0x03ca
            int r24 = r4 + 1
            char r4 = r0.charAt(r4)
            if (r4 < r5) goto L_0x01ac
            r4 = r4 & 8191(0x1fff, float:1.1478E-41)
            r2 = r24
            r24 = 13
        L_0x0194:
            int r26 = r2 + 1
            char r2 = r0.charAt(r2)
            if (r2 < r5) goto L_0x01a6
            r2 = r2 & 8191(0x1fff, float:1.1478E-41)
            int r2 = r2 << r24
            r4 = r4 | r2
            int r24 = r24 + 13
            r2 = r26
            goto L_0x0194
        L_0x01a6:
            int r2 = r2 << r24
            r4 = r4 | r2
            r2 = r26
            goto L_0x01ae
        L_0x01ac:
            r2 = r24
        L_0x01ae:
            int r24 = r2 + 1
            char r2 = r0.charAt(r2)
            if (r2 < r5) goto L_0x01db
            r2 = r2 & 8191(0x1fff, float:1.1478E-41)
            r5 = r24
            r24 = 13
        L_0x01bc:
            int r27 = r5 + 1
            char r5 = r0.charAt(r5)
            r28 = r3
            r3 = 55296(0xd800, float:7.7486E-41)
            if (r5 < r3) goto L_0x01d5
            r3 = r5 & 8191(0x1fff, float:1.1478E-41)
            int r3 = r3 << r24
            r2 = r2 | r3
            int r24 = r24 + 13
            r5 = r27
            r3 = r28
            goto L_0x01bc
        L_0x01d5:
            int r3 = r5 << r24
            r2 = r2 | r3
            r3 = r27
            goto L_0x01df
        L_0x01db:
            r28 = r3
            r3 = r24
        L_0x01df:
            r5 = r2 & 255(0xff, float:3.57E-43)
            r24 = r14
            r14 = r2 & 1024(0x400, float:1.435E-42)
            if (r14 == 0) goto L_0x01ed
            int r14 = r20 + 1
            r13[r20] = r9
            r20 = r14
        L_0x01ed:
            r14 = 51
            if (r5 < r14) goto L_0x0296
            int r14 = r3 + 1
            char r3 = r0.charAt(r3)
            r27 = r14
            r14 = 55296(0xd800, float:7.7486E-41)
            if (r3 < r14) goto L_0x0223
            r3 = r3 & 8191(0x1fff, float:1.1478E-41)
            r14 = r27
            r27 = 13
        L_0x0204:
            int r31 = r14 + 1
            char r14 = r0.charAt(r14)
            r32 = r12
            r12 = 55296(0xd800, float:7.7486E-41)
            if (r14 < r12) goto L_0x021d
            r12 = r14 & 8191(0x1fff, float:1.1478E-41)
            int r12 = r12 << r27
            r3 = r3 | r12
            int r27 = r27 + 13
            r14 = r31
            r12 = r32
            goto L_0x0204
        L_0x021d:
            int r12 = r14 << r27
            r3 = r3 | r12
            r14 = r31
            goto L_0x0227
        L_0x0223:
            r32 = r12
            r14 = r27
        L_0x0227:
            int r12 = r5 + -51
            r27 = r14
            r14 = 9
            if (r12 == r14) goto L_0x0248
            r14 = 17
            if (r12 != r14) goto L_0x0234
            goto L_0x0248
        L_0x0234:
            r14 = 12
            if (r12 != r14) goto L_0x0257
            if (r10 != 0) goto L_0x0257
            int r12 = r9 / 3
            int r14 = r16 + 1
            int r12 = r12 + r12
            r25 = 1
            int r12 = r12 + 1
            r16 = r17[r16]
            r11[r12] = r16
            goto L_0x0255
        L_0x0248:
            int r12 = r9 / 3
            int r14 = r16 + 1
            int r12 = r12 + r12
            r25 = 1
            int r12 = r12 + 1
            r16 = r17[r16]
            r11[r12] = r16
        L_0x0255:
            r16 = r14
        L_0x0257:
            int r3 = r3 + r3
            r12 = r17[r3]
            boolean r14 = r12 instanceof java.lang.reflect.Field
            if (r14 == 0) goto L_0x0261
            java.lang.reflect.Field r12 = (java.lang.reflect.Field) r12
            goto L_0x0269
        L_0x0261:
            java.lang.String r12 = (java.lang.String) r12
            java.lang.reflect.Field r12 = zzI(r1, r12)
            r17[r3] = r12
        L_0x0269:
            r31 = r7
            r14 = r8
            long r7 = r15.objectFieldOffset(r12)
            int r7 = (int) r7
            int r3 = r3 + 1
            r8 = r17[r3]
            boolean r12 = r8 instanceof java.lang.reflect.Field
            if (r12 == 0) goto L_0x027c
            java.lang.reflect.Field r8 = (java.lang.reflect.Field) r8
            goto L_0x0284
        L_0x027c:
            java.lang.String r8 = (java.lang.String) r8
            java.lang.reflect.Field r8 = zzI(r1, r8)
            r17[r3] = r8
        L_0x0284:
            r3 = r7
            long r7 = r15.objectFieldOffset(r8)
            int r7 = (int) r7
            r30 = r0
            r8 = r1
            r0 = r7
            r29 = r11
            r25 = 1
            r7 = r3
            r3 = 0
            goto L_0x0391
        L_0x0296:
            r31 = r7
            r14 = r8
            r32 = r12
            int r7 = r16 + 1
            r8 = r17[r16]
            java.lang.String r8 = (java.lang.String) r8
            java.lang.reflect.Field r8 = zzI(r1, r8)
            r12 = 9
            if (r5 == r12) goto L_0x030e
            r12 = 17
            if (r5 != r12) goto L_0x02ae
            goto L_0x030e
        L_0x02ae:
            r12 = 27
            if (r5 == r12) goto L_0x02fe
            r12 = 49
            if (r5 != r12) goto L_0x02b7
            goto L_0x02fe
        L_0x02b7:
            r12 = 12
            if (r5 == r12) goto L_0x02ee
            r12 = 30
            if (r5 == r12) goto L_0x02ee
            r12 = 44
            if (r5 != r12) goto L_0x02c4
            goto L_0x02ee
        L_0x02c4:
            r12 = 50
            if (r5 != r12) goto L_0x02e4
            int r12 = r22 + 1
            r13[r22] = r9
            int r22 = r9 / 3
            int r22 = r22 + r22
            int r27 = r7 + 1
            r7 = r17[r7]
            r11[r22] = r7
            r7 = r2 & 2048(0x800, float:2.87E-42)
            if (r7 == 0) goto L_0x02e7
            int r7 = r27 + 1
            int r22 = r22 + 1
            r27 = r17[r27]
            r11[r22] = r27
            r22 = r12
        L_0x02e4:
            r25 = 1
            goto L_0x031b
        L_0x02e7:
            r22 = r12
            r12 = r27
            r25 = 1
            goto L_0x031c
        L_0x02ee:
            if (r10 != 0) goto L_0x02e4
            int r12 = r9 / 3
            int r27 = r7 + 1
            int r12 = r12 + r12
            r25 = 1
            int r12 = r12 + 1
            r7 = r17[r7]
            r11[r12] = r7
            goto L_0x030b
        L_0x02fe:
            r25 = 1
            int r12 = r9 / 3
            int r27 = r7 + 1
            int r12 = r12 + r12
            int r12 = r12 + 1
            r7 = r17[r7]
            r11[r12] = r7
        L_0x030b:
            r12 = r27
            goto L_0x031c
        L_0x030e:
            r25 = 1
            int r12 = r9 / 3
            int r12 = r12 + r12
            int r12 = r12 + 1
            java.lang.Class r27 = r8.getType()
            r11[r12] = r27
        L_0x031b:
            r12 = r7
        L_0x031c:
            long r7 = r15.objectFieldOffset(r8)
            int r7 = (int) r7
            r8 = r2 & 4096(0x1000, float:5.74E-42)
            r27 = 1048575(0xfffff, float:1.469367E-39)
            r29 = r11
            r11 = 4096(0x1000, float:5.74E-42)
            if (r8 != r11) goto L_0x0379
            r8 = 17
            if (r5 > r8) goto L_0x0379
            int r8 = r3 + 1
            char r3 = r0.charAt(r3)
            r11 = 55296(0xd800, float:7.7486E-41)
            if (r3 < r11) goto L_0x0355
            r3 = r3 & 8191(0x1fff, float:1.1478E-41)
            r26 = 13
        L_0x033f:
            int r27 = r8 + 1
            char r8 = r0.charAt(r8)
            if (r8 < r11) goto L_0x0351
            r8 = r8 & 8191(0x1fff, float:1.1478E-41)
            int r8 = r8 << r26
            r3 = r3 | r8
            int r26 = r26 + 13
            r8 = r27
            goto L_0x033f
        L_0x0351:
            int r8 = r8 << r26
            r3 = r3 | r8
            goto L_0x0357
        L_0x0355:
            r27 = r8
        L_0x0357:
            int r8 = r6 + r6
            int r26 = r3 / 32
            int r8 = r8 + r26
            r11 = r17[r8]
            r30 = r0
            boolean r0 = r11 instanceof java.lang.reflect.Field
            if (r0 == 0) goto L_0x0368
            java.lang.reflect.Field r11 = (java.lang.reflect.Field) r11
            goto L_0x0370
        L_0x0368:
            java.lang.String r11 = (java.lang.String) r11
            java.lang.reflect.Field r11 = zzI(r1, r11)
            r17[r8] = r11
        L_0x0370:
            r8 = r1
            long r0 = r15.objectFieldOffset(r11)
            int r0 = (int) r0
            int r3 = r3 % 32
            goto L_0x0381
        L_0x0379:
            r30 = r0
            r8 = r1
            r0 = r27
            r27 = r3
            r3 = 0
        L_0x0381:
            r1 = 18
            if (r5 < r1) goto L_0x038f
            r1 = 49
            if (r5 > r1) goto L_0x038f
            int r1 = r23 + 1
            r13[r23] = r7
            r23 = r1
        L_0x038f:
            r16 = r12
        L_0x0391:
            int r1 = r9 + 1
            r31[r9] = r4
            int r4 = r1 + 1
            r9 = r2 & 512(0x200, float:7.175E-43)
            if (r9 == 0) goto L_0x039e
            r9 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x039f
        L_0x039e:
            r9 = 0
        L_0x039f:
            r2 = r2 & 256(0x100, float:3.59E-43)
            if (r2 == 0) goto L_0x03a6
            r2 = 268435456(0x10000000, float:2.5243549E-29)
            goto L_0x03a7
        L_0x03a6:
            r2 = 0
        L_0x03a7:
            r2 = r2 | r9
            int r5 = r5 << 20
            r2 = r2 | r5
            r2 = r2 | r7
            r31[r1] = r2
            int r9 = r4 + 1
            int r1 = r3 << 20
            r0 = r0 | r1
            r31[r4] = r0
            r1 = r8
            r8 = r14
            r14 = r24
            r4 = r27
            r3 = r28
            r11 = r29
            r0 = r30
            r7 = r31
            r12 = r32
            r5 = 55296(0xd800, float:7.7486E-41)
            goto L_0x0184
        L_0x03ca:
            r31 = r7
            r29 = r11
            r32 = r12
            r24 = r14
            r14 = r8
            com.google.android.gms.internal.gtm.zzwn r0 = new com.google.android.gms.internal.gtm.zzwn
            r4 = r0
            com.google.android.gms.internal.gtm.zzwk r9 = r34.zza()
            r11 = 0
            r1 = r29
            r20 = 0
            r5 = r31
            r6 = r1
            r7 = r14
            r8 = r32
            r12 = r13
            r13 = r24
            r14 = r21
            r15 = r35
            r16 = r36
            r17 = r37
            r18 = r38
            r19 = r39
            r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.gtm.zzwn.zzm(com.google.android.gms.internal.gtm.zzwv, com.google.android.gms.internal.gtm.zzwq, com.google.android.gms.internal.gtm.zzvy, com.google.android.gms.internal.gtm.zzxo, com.google.android.gms.internal.gtm.zzuk, com.google.android.gms.internal.gtm.zzwf):com.google.android.gms.internal.gtm.zzwn");
    }

    private static <T> double zzo(T t10, long j10) {
        return ((Double) zzxy.zzf(t10, j10)).doubleValue();
    }

    private static <T> float zzp(T t10, long j10) {
        return ((Float) zzxy.zzf(t10, j10)).floatValue();
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x0302, code lost:
        r8 = r8 + r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:155:0x0469, code lost:
        r8 = r8 + (r9 + r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:168:0x04b3, code lost:
        r7 = r7 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:178:0x04de, code lost:
        r8 = r8 + r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:179:0x04df, code lost:
        r4 = r4 + r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:186:0x0506, code lost:
        r7 = r7 + r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:190:0x0513, code lost:
        r7 = r7 + 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:194:0x0521, code lost:
        r7 = r7 + 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:195:0x0525, code lost:
        r3 = r3 + 3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int zzq(T r15) {
        /*
            r14 = this;
            sun.misc.Unsafe r0 = zzb
            r1 = 1048575(0xfffff, float:1.469367E-39)
            r2 = 0
            r6 = r1
            r3 = r2
            r4 = r3
            r5 = r4
        L_0x000a:
            int[] r7 = r14.zzc
            int r7 = r7.length
            if (r3 >= r7) goto L_0x0529
            int r7 = r14.zzC(r3)
            int[] r8 = r14.zzc
            r8 = r8[r3]
            int r9 = zzB(r7)
            r10 = 17
            r11 = 1
            if (r9 > r10) goto L_0x0035
            int[] r10 = r14.zzc
            int r12 = r3 + 2
            r10 = r10[r12]
            r12 = r10 & r1
            int r10 = r10 >>> 20
            int r10 = r11 << r10
            if (r12 == r6) goto L_0x0036
            long r5 = (long) r12
            int r5 = r0.getInt(r15, r5)
            r6 = r12
            goto L_0x0036
        L_0x0035:
            r10 = r2
        L_0x0036:
            r7 = r7 & r1
            long r12 = (long) r7
            r7 = 63
            switch(r9) {
                case 0: goto L_0x0517;
                case 1: goto L_0x0509;
                case 2: goto L_0x04f4;
                case 3: goto L_0x04e1;
                case 4: goto L_0x04cc;
                case 5: goto L_0x04c1;
                case 6: goto L_0x04b6;
                case 7: goto L_0x04a9;
                case 8: goto L_0x047f;
                case 9: goto L_0x046d;
                case 10: goto L_0x0451;
                case 11: goto L_0x043d;
                case 12: goto L_0x0429;
                case 13: goto L_0x041d;
                case 14: goto L_0x0411;
                case 15: goto L_0x03f8;
                case 16: goto L_0x03e0;
                case 17: goto L_0x03cd;
                case 18: goto L_0x03c0;
                case 19: goto L_0x03b5;
                case 20: goto L_0x03aa;
                case 21: goto L_0x039f;
                case 22: goto L_0x0394;
                case 23: goto L_0x0389;
                case 24: goto L_0x037e;
                case 25: goto L_0x0373;
                case 26: goto L_0x0368;
                case 27: goto L_0x0359;
                case 28: goto L_0x034d;
                case 29: goto L_0x0341;
                case 30: goto L_0x0335;
                case 31: goto L_0x0329;
                case 32: goto L_0x031d;
                case 33: goto L_0x0311;
                case 34: goto L_0x0305;
                case 35: goto L_0x02ee;
                case 36: goto L_0x02d9;
                case 37: goto L_0x02c4;
                case 38: goto L_0x02af;
                case 39: goto L_0x029a;
                case 40: goto L_0x0285;
                case 41: goto L_0x026f;
                case 42: goto L_0x0259;
                case 43: goto L_0x0243;
                case 44: goto L_0x022d;
                case 45: goto L_0x0217;
                case 46: goto L_0x0201;
                case 47: goto L_0x01eb;
                case 48: goto L_0x01d5;
                case 49: goto L_0x01c5;
                case 50: goto L_0x01b8;
                case 51: goto L_0x01aa;
                case 52: goto L_0x019c;
                case 53: goto L_0x0186;
                case 54: goto L_0x0170;
                case 55: goto L_0x015a;
                case 56: goto L_0x014c;
                case 57: goto L_0x013e;
                case 58: goto L_0x0130;
                case 59: goto L_0x0102;
                case 60: goto L_0x00ee;
                case 61: goto L_0x00d2;
                case 62: goto L_0x00bc;
                case 63: goto L_0x00a6;
                case 64: goto L_0x0098;
                case 65: goto L_0x008a;
                case 66: goto L_0x006f;
                case 67: goto L_0x0055;
                case 68: goto L_0x003f;
                default: goto L_0x003d;
            }
        L_0x003d:
            goto L_0x0525
        L_0x003f:
            boolean r7 = r14.zzT(r15, r8, r3)
            if (r7 == 0) goto L_0x0525
            java.lang.Object r7 = r0.getObject(r15, r12)
            com.google.android.gms.internal.gtm.zzwk r7 = (com.google.android.gms.internal.gtm.zzwk) r7
            com.google.android.gms.internal.gtm.zzwx r9 = r14.zzF(r3)
            int r7 = com.google.android.gms.internal.gtm.zzto.zzv(r8, r7, r9)
            goto L_0x03ca
        L_0x0055:
            boolean r9 = r14.zzT(r15, r8, r3)
            if (r9 == 0) goto L_0x0525
            long r9 = zzD(r15, r12)
            int r8 = r8 << 3
            int r8 = com.google.android.gms.internal.gtm.zzto.zzD(r8)
            long r11 = r9 + r9
            long r9 = r9 >> r7
            long r9 = r9 ^ r11
            int r7 = com.google.android.gms.internal.gtm.zzto.zzE(r9)
            goto L_0x04de
        L_0x006f:
            boolean r7 = r14.zzT(r15, r8, r3)
            if (r7 == 0) goto L_0x0525
            int r7 = zzs(r15, r12)
            int r8 = r8 << 3
            int r8 = com.google.android.gms.internal.gtm.zzto.zzD(r8)
            int r9 = r7 + r7
            int r7 = r7 >> 31
            r7 = r7 ^ r9
            int r7 = com.google.android.gms.internal.gtm.zzto.zzD(r7)
            goto L_0x04de
        L_0x008a:
            boolean r7 = r14.zzT(r15, r8, r3)
            if (r7 == 0) goto L_0x0525
            int r7 = r8 << 3
            int r7 = com.google.android.gms.internal.gtm.zzto.zzD(r7)
            goto L_0x0521
        L_0x0098:
            boolean r7 = r14.zzT(r15, r8, r3)
            if (r7 == 0) goto L_0x0525
            int r7 = r8 << 3
            int r7 = com.google.android.gms.internal.gtm.zzto.zzD(r7)
            goto L_0x0513
        L_0x00a6:
            boolean r7 = r14.zzT(r15, r8, r3)
            if (r7 == 0) goto L_0x0525
            int r7 = zzs(r15, r12)
            int r8 = r8 << 3
            int r8 = com.google.android.gms.internal.gtm.zzto.zzD(r8)
            int r7 = com.google.android.gms.internal.gtm.zzto.zzx(r7)
            goto L_0x04de
        L_0x00bc:
            boolean r7 = r14.zzT(r15, r8, r3)
            if (r7 == 0) goto L_0x0525
            int r7 = zzs(r15, r12)
            int r8 = r8 << 3
            int r8 = com.google.android.gms.internal.gtm.zzto.zzD(r8)
            int r7 = com.google.android.gms.internal.gtm.zzto.zzD(r7)
            goto L_0x04de
        L_0x00d2:
            boolean r7 = r14.zzT(r15, r8, r3)
            if (r7 == 0) goto L_0x0525
            java.lang.Object r7 = r0.getObject(r15, r12)
            com.google.android.gms.internal.gtm.zztd r7 = (com.google.android.gms.internal.gtm.zztd) r7
            int r8 = r8 << 3
            int r8 = com.google.android.gms.internal.gtm.zzto.zzD(r8)
            int r7 = r7.zzd()
            int r9 = com.google.android.gms.internal.gtm.zzto.zzD(r7)
            goto L_0x0469
        L_0x00ee:
            boolean r7 = r14.zzT(r15, r8, r3)
            if (r7 == 0) goto L_0x0525
            java.lang.Object r7 = r0.getObject(r15, r12)
            com.google.android.gms.internal.gtm.zzwx r9 = r14.zzF(r3)
            int r7 = com.google.android.gms.internal.gtm.zzwz.zzo(r8, r7, r9)
            goto L_0x03ca
        L_0x0102:
            boolean r7 = r14.zzT(r15, r8, r3)
            if (r7 == 0) goto L_0x0525
            java.lang.Object r7 = r0.getObject(r15, r12)
            boolean r9 = r7 instanceof com.google.android.gms.internal.gtm.zztd
            if (r9 == 0) goto L_0x0122
            com.google.android.gms.internal.gtm.zztd r7 = (com.google.android.gms.internal.gtm.zztd) r7
            int r8 = r8 << 3
            int r8 = com.google.android.gms.internal.gtm.zzto.zzD(r8)
            int r7 = r7.zzd()
            int r9 = com.google.android.gms.internal.gtm.zzto.zzD(r7)
            goto L_0x0469
        L_0x0122:
            java.lang.String r7 = (java.lang.String) r7
            int r8 = r8 << 3
            int r8 = com.google.android.gms.internal.gtm.zzto.zzD(r8)
            int r7 = com.google.android.gms.internal.gtm.zzto.zzB(r7)
            goto L_0x04de
        L_0x0130:
            boolean r7 = r14.zzT(r15, r8, r3)
            if (r7 == 0) goto L_0x0525
            int r7 = r8 << 3
            int r7 = com.google.android.gms.internal.gtm.zzto.zzD(r7)
            goto L_0x04b3
        L_0x013e:
            boolean r7 = r14.zzT(r15, r8, r3)
            if (r7 == 0) goto L_0x0525
            int r7 = r8 << 3
            int r7 = com.google.android.gms.internal.gtm.zzto.zzD(r7)
            goto L_0x0513
        L_0x014c:
            boolean r7 = r14.zzT(r15, r8, r3)
            if (r7 == 0) goto L_0x0525
            int r7 = r8 << 3
            int r7 = com.google.android.gms.internal.gtm.zzto.zzD(r7)
            goto L_0x0521
        L_0x015a:
            boolean r7 = r14.zzT(r15, r8, r3)
            if (r7 == 0) goto L_0x0525
            int r7 = zzs(r15, r12)
            int r8 = r8 << 3
            int r8 = com.google.android.gms.internal.gtm.zzto.zzD(r8)
            int r7 = com.google.android.gms.internal.gtm.zzto.zzx(r7)
            goto L_0x04de
        L_0x0170:
            boolean r7 = r14.zzT(r15, r8, r3)
            if (r7 == 0) goto L_0x0525
            long r9 = zzD(r15, r12)
            int r7 = r8 << 3
            int r7 = com.google.android.gms.internal.gtm.zzto.zzD(r7)
            int r8 = com.google.android.gms.internal.gtm.zzto.zzE(r9)
            goto L_0x0506
        L_0x0186:
            boolean r7 = r14.zzT(r15, r8, r3)
            if (r7 == 0) goto L_0x0525
            long r9 = zzD(r15, r12)
            int r7 = r8 << 3
            int r7 = com.google.android.gms.internal.gtm.zzto.zzD(r7)
            int r8 = com.google.android.gms.internal.gtm.zzto.zzE(r9)
            goto L_0x0506
        L_0x019c:
            boolean r7 = r14.zzT(r15, r8, r3)
            if (r7 == 0) goto L_0x0525
            int r7 = r8 << 3
            int r7 = com.google.android.gms.internal.gtm.zzto.zzD(r7)
            goto L_0x0513
        L_0x01aa:
            boolean r7 = r14.zzT(r15, r8, r3)
            if (r7 == 0) goto L_0x0525
            int r7 = r8 << 3
            int r7 = com.google.android.gms.internal.gtm.zzto.zzD(r7)
            goto L_0x0521
        L_0x01b8:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.lang.Object r9 = r14.zzH(r3)
            com.google.android.gms.internal.gtm.zzwf.zza(r8, r7, r9)
            goto L_0x0525
        L_0x01c5:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            com.google.android.gms.internal.gtm.zzwx r9 = r14.zzF(r3)
            int r7 = com.google.android.gms.internal.gtm.zzwz.zzj(r8, r7, r9)
            goto L_0x03ca
        L_0x01d5:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.gtm.zzwz.zzt(r7)
            if (r7 <= 0) goto L_0x0525
            int r8 = com.google.android.gms.internal.gtm.zzto.zzC(r8)
            int r9 = com.google.android.gms.internal.gtm.zzto.zzD(r7)
            goto L_0x0302
        L_0x01eb:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.gtm.zzwz.zzr(r7)
            if (r7 <= 0) goto L_0x0525
            int r8 = com.google.android.gms.internal.gtm.zzto.zzC(r8)
            int r9 = com.google.android.gms.internal.gtm.zzto.zzD(r7)
            goto L_0x0302
        L_0x0201:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.gtm.zzwz.zzi(r7)
            if (r7 <= 0) goto L_0x0525
            int r8 = com.google.android.gms.internal.gtm.zzto.zzC(r8)
            int r9 = com.google.android.gms.internal.gtm.zzto.zzD(r7)
            goto L_0x0302
        L_0x0217:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.gtm.zzwz.zzg(r7)
            if (r7 <= 0) goto L_0x0525
            int r8 = com.google.android.gms.internal.gtm.zzto.zzC(r8)
            int r9 = com.google.android.gms.internal.gtm.zzto.zzD(r7)
            goto L_0x0302
        L_0x022d:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.gtm.zzwz.zze(r7)
            if (r7 <= 0) goto L_0x0525
            int r8 = com.google.android.gms.internal.gtm.zzto.zzC(r8)
            int r9 = com.google.android.gms.internal.gtm.zzto.zzD(r7)
            goto L_0x0302
        L_0x0243:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.gtm.zzwz.zzw(r7)
            if (r7 <= 0) goto L_0x0525
            int r8 = com.google.android.gms.internal.gtm.zzto.zzC(r8)
            int r9 = com.google.android.gms.internal.gtm.zzto.zzD(r7)
            goto L_0x0302
        L_0x0259:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.gtm.zzwz.zzb(r7)
            if (r7 <= 0) goto L_0x0525
            int r8 = com.google.android.gms.internal.gtm.zzto.zzC(r8)
            int r9 = com.google.android.gms.internal.gtm.zzto.zzD(r7)
            goto L_0x0302
        L_0x026f:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.gtm.zzwz.zzg(r7)
            if (r7 <= 0) goto L_0x0525
            int r8 = com.google.android.gms.internal.gtm.zzto.zzC(r8)
            int r9 = com.google.android.gms.internal.gtm.zzto.zzD(r7)
            goto L_0x0302
        L_0x0285:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.gtm.zzwz.zzi(r7)
            if (r7 <= 0) goto L_0x0525
            int r8 = com.google.android.gms.internal.gtm.zzto.zzC(r8)
            int r9 = com.google.android.gms.internal.gtm.zzto.zzD(r7)
            goto L_0x0302
        L_0x029a:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.gtm.zzwz.zzl(r7)
            if (r7 <= 0) goto L_0x0525
            int r8 = com.google.android.gms.internal.gtm.zzto.zzC(r8)
            int r9 = com.google.android.gms.internal.gtm.zzto.zzD(r7)
            goto L_0x0302
        L_0x02af:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.gtm.zzwz.zzy(r7)
            if (r7 <= 0) goto L_0x0525
            int r8 = com.google.android.gms.internal.gtm.zzto.zzC(r8)
            int r9 = com.google.android.gms.internal.gtm.zzto.zzD(r7)
            goto L_0x0302
        L_0x02c4:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.gtm.zzwz.zzn(r7)
            if (r7 <= 0) goto L_0x0525
            int r8 = com.google.android.gms.internal.gtm.zzto.zzC(r8)
            int r9 = com.google.android.gms.internal.gtm.zzto.zzD(r7)
            goto L_0x0302
        L_0x02d9:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.gtm.zzwz.zzg(r7)
            if (r7 <= 0) goto L_0x0525
            int r8 = com.google.android.gms.internal.gtm.zzto.zzC(r8)
            int r9 = com.google.android.gms.internal.gtm.zzto.zzD(r7)
            goto L_0x0302
        L_0x02ee:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.gtm.zzwz.zzi(r7)
            if (r7 <= 0) goto L_0x0525
            int r8 = com.google.android.gms.internal.gtm.zzto.zzC(r8)
            int r9 = com.google.android.gms.internal.gtm.zzto.zzD(r7)
        L_0x0302:
            int r8 = r8 + r9
            goto L_0x04de
        L_0x0305:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.gtm.zzwz.zzs(r8, r7, r2)
            goto L_0x03ca
        L_0x0311:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.gtm.zzwz.zzq(r8, r7, r2)
            goto L_0x03ca
        L_0x031d:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.gtm.zzwz.zzh(r8, r7, r2)
            goto L_0x03ca
        L_0x0329:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.gtm.zzwz.zzf(r8, r7, r2)
            goto L_0x03ca
        L_0x0335:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.gtm.zzwz.zzd(r8, r7, r2)
            goto L_0x03ca
        L_0x0341:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.gtm.zzwz.zzv(r8, r7, r2)
            goto L_0x03ca
        L_0x034d:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.gtm.zzwz.zzc(r8, r7)
            goto L_0x03ca
        L_0x0359:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            com.google.android.gms.internal.gtm.zzwx r9 = r14.zzF(r3)
            int r7 = com.google.android.gms.internal.gtm.zzwz.zzp(r8, r7, r9)
            goto L_0x03ca
        L_0x0368:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.gtm.zzwz.zzu(r8, r7)
            goto L_0x03ca
        L_0x0373:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.gtm.zzwz.zza(r8, r7, r2)
            goto L_0x03ca
        L_0x037e:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.gtm.zzwz.zzf(r8, r7, r2)
            goto L_0x03ca
        L_0x0389:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.gtm.zzwz.zzh(r8, r7, r2)
            goto L_0x03ca
        L_0x0394:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.gtm.zzwz.zzk(r8, r7, r2)
            goto L_0x03ca
        L_0x039f:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.gtm.zzwz.zzx(r8, r7, r2)
            goto L_0x03ca
        L_0x03aa:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.gtm.zzwz.zzm(r8, r7, r2)
            goto L_0x03ca
        L_0x03b5:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.gtm.zzwz.zzf(r8, r7, r2)
            goto L_0x03ca
        L_0x03c0:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.gtm.zzwz.zzh(r8, r7, r2)
        L_0x03ca:
            int r4 = r4 + r7
            goto L_0x0525
        L_0x03cd:
            r7 = r5 & r10
            if (r7 == 0) goto L_0x0525
            java.lang.Object r7 = r0.getObject(r15, r12)
            com.google.android.gms.internal.gtm.zzwk r7 = (com.google.android.gms.internal.gtm.zzwk) r7
            com.google.android.gms.internal.gtm.zzwx r9 = r14.zzF(r3)
            int r7 = com.google.android.gms.internal.gtm.zzto.zzv(r8, r7, r9)
            goto L_0x03ca
        L_0x03e0:
            r9 = r5 & r10
            if (r9 == 0) goto L_0x0525
            long r9 = r0.getLong(r15, r12)
            int r8 = r8 << 3
            int r8 = com.google.android.gms.internal.gtm.zzto.zzD(r8)
            long r11 = r9 + r9
            long r9 = r9 >> r7
            long r9 = r9 ^ r11
            int r7 = com.google.android.gms.internal.gtm.zzto.zzE(r9)
            goto L_0x04de
        L_0x03f8:
            r7 = r5 & r10
            if (r7 == 0) goto L_0x0525
            int r7 = r0.getInt(r15, r12)
            int r8 = r8 << 3
            int r8 = com.google.android.gms.internal.gtm.zzto.zzD(r8)
            int r9 = r7 + r7
            int r7 = r7 >> 31
            r7 = r7 ^ r9
            int r7 = com.google.android.gms.internal.gtm.zzto.zzD(r7)
            goto L_0x04de
        L_0x0411:
            r7 = r5 & r10
            if (r7 == 0) goto L_0x0525
            int r7 = r8 << 3
            int r7 = com.google.android.gms.internal.gtm.zzto.zzD(r7)
            goto L_0x0521
        L_0x041d:
            r7 = r5 & r10
            if (r7 == 0) goto L_0x0525
            int r7 = r8 << 3
            int r7 = com.google.android.gms.internal.gtm.zzto.zzD(r7)
            goto L_0x0513
        L_0x0429:
            r7 = r5 & r10
            if (r7 == 0) goto L_0x0525
            int r7 = r0.getInt(r15, r12)
            int r8 = r8 << 3
            int r8 = com.google.android.gms.internal.gtm.zzto.zzD(r8)
            int r7 = com.google.android.gms.internal.gtm.zzto.zzx(r7)
            goto L_0x04de
        L_0x043d:
            r7 = r5 & r10
            if (r7 == 0) goto L_0x0525
            int r7 = r0.getInt(r15, r12)
            int r8 = r8 << 3
            int r8 = com.google.android.gms.internal.gtm.zzto.zzD(r8)
            int r7 = com.google.android.gms.internal.gtm.zzto.zzD(r7)
            goto L_0x04de
        L_0x0451:
            r7 = r5 & r10
            if (r7 == 0) goto L_0x0525
            java.lang.Object r7 = r0.getObject(r15, r12)
            com.google.android.gms.internal.gtm.zztd r7 = (com.google.android.gms.internal.gtm.zztd) r7
            int r8 = r8 << 3
            int r8 = com.google.android.gms.internal.gtm.zzto.zzD(r8)
            int r7 = r7.zzd()
            int r9 = com.google.android.gms.internal.gtm.zzto.zzD(r7)
        L_0x0469:
            int r9 = r9 + r7
            int r8 = r8 + r9
            goto L_0x04df
        L_0x046d:
            r7 = r5 & r10
            if (r7 == 0) goto L_0x0525
            java.lang.Object r7 = r0.getObject(r15, r12)
            com.google.android.gms.internal.gtm.zzwx r9 = r14.zzF(r3)
            int r7 = com.google.android.gms.internal.gtm.zzwz.zzo(r8, r7, r9)
            goto L_0x03ca
        L_0x047f:
            r7 = r5 & r10
            if (r7 == 0) goto L_0x0525
            java.lang.Object r7 = r0.getObject(r15, r12)
            boolean r9 = r7 instanceof com.google.android.gms.internal.gtm.zztd
            if (r9 == 0) goto L_0x049c
            com.google.android.gms.internal.gtm.zztd r7 = (com.google.android.gms.internal.gtm.zztd) r7
            int r8 = r8 << 3
            int r8 = com.google.android.gms.internal.gtm.zzto.zzD(r8)
            int r7 = r7.zzd()
            int r9 = com.google.android.gms.internal.gtm.zzto.zzD(r7)
            goto L_0x0469
        L_0x049c:
            java.lang.String r7 = (java.lang.String) r7
            int r8 = r8 << 3
            int r8 = com.google.android.gms.internal.gtm.zzto.zzD(r8)
            int r7 = com.google.android.gms.internal.gtm.zzto.zzB(r7)
            goto L_0x04de
        L_0x04a9:
            r7 = r5 & r10
            if (r7 == 0) goto L_0x0525
            int r7 = r8 << 3
            int r7 = com.google.android.gms.internal.gtm.zzto.zzD(r7)
        L_0x04b3:
            int r7 = r7 + r11
            goto L_0x03ca
        L_0x04b6:
            r7 = r5 & r10
            if (r7 == 0) goto L_0x0525
            int r7 = r8 << 3
            int r7 = com.google.android.gms.internal.gtm.zzto.zzD(r7)
            goto L_0x0513
        L_0x04c1:
            r7 = r5 & r10
            if (r7 == 0) goto L_0x0525
            int r7 = r8 << 3
            int r7 = com.google.android.gms.internal.gtm.zzto.zzD(r7)
            goto L_0x0521
        L_0x04cc:
            r7 = r5 & r10
            if (r7 == 0) goto L_0x0525
            int r7 = r0.getInt(r15, r12)
            int r8 = r8 << 3
            int r8 = com.google.android.gms.internal.gtm.zzto.zzD(r8)
            int r7 = com.google.android.gms.internal.gtm.zzto.zzx(r7)
        L_0x04de:
            int r8 = r8 + r7
        L_0x04df:
            int r4 = r4 + r8
            goto L_0x0525
        L_0x04e1:
            r7 = r5 & r10
            if (r7 == 0) goto L_0x0525
            long r9 = r0.getLong(r15, r12)
            int r7 = r8 << 3
            int r7 = com.google.android.gms.internal.gtm.zzto.zzD(r7)
            int r8 = com.google.android.gms.internal.gtm.zzto.zzE(r9)
            goto L_0x0506
        L_0x04f4:
            r7 = r5 & r10
            if (r7 == 0) goto L_0x0525
            long r9 = r0.getLong(r15, r12)
            int r7 = r8 << 3
            int r7 = com.google.android.gms.internal.gtm.zzto.zzD(r7)
            int r8 = com.google.android.gms.internal.gtm.zzto.zzE(r9)
        L_0x0506:
            int r7 = r7 + r8
            goto L_0x03ca
        L_0x0509:
            r7 = r5 & r10
            if (r7 == 0) goto L_0x0525
            int r7 = r8 << 3
            int r7 = com.google.android.gms.internal.gtm.zzto.zzD(r7)
        L_0x0513:
            int r7 = r7 + 4
            goto L_0x03ca
        L_0x0517:
            r7 = r5 & r10
            if (r7 == 0) goto L_0x0525
            int r7 = r8 << 3
            int r7 = com.google.android.gms.internal.gtm.zzto.zzD(r7)
        L_0x0521:
            int r7 = r7 + 8
            goto L_0x03ca
        L_0x0525:
            int r3 = r3 + 3
            goto L_0x000a
        L_0x0529:
            com.google.android.gms.internal.gtm.zzxo<?, ?> r0 = r14.zzo
            java.lang.Object r1 = r0.zzd(r15)
            int r0 = r0.zza(r1)
            int r4 = r4 + r0
            boolean r0 = r14.zzh
            if (r0 == 0) goto L_0x0586
            com.google.android.gms.internal.gtm.zzuk<?> r0 = r14.zzp
            com.google.android.gms.internal.gtm.zzuo r15 = r0.zzb(r15)
            r0 = r2
        L_0x053f:
            com.google.android.gms.internal.gtm.zzxk<T, java.lang.Object> r1 = r15.zza
            int r1 = r1.zzb()
            if (r2 >= r1) goto L_0x055f
            com.google.android.gms.internal.gtm.zzxk<T, java.lang.Object> r1 = r15.zza
            java.util.Map$Entry r1 = r1.zzg(r2)
            java.lang.Object r3 = r1.getKey()
            com.google.android.gms.internal.gtm.zzun r3 = (com.google.android.gms.internal.gtm.zzun) r3
            java.lang.Object r1 = r1.getValue()
            int r1 = com.google.android.gms.internal.gtm.zzuo.zza(r3, r1)
            int r0 = r0 + r1
            int r2 = r2 + 1
            goto L_0x053f
        L_0x055f:
            com.google.android.gms.internal.gtm.zzxk<T, java.lang.Object> r15 = r15.zza
            java.lang.Iterable r15 = r15.zzc()
            java.util.Iterator r15 = r15.iterator()
        L_0x0569:
            boolean r1 = r15.hasNext()
            if (r1 == 0) goto L_0x0585
            java.lang.Object r1 = r15.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            java.lang.Object r2 = r1.getKey()
            com.google.android.gms.internal.gtm.zzun r2 = (com.google.android.gms.internal.gtm.zzun) r2
            java.lang.Object r1 = r1.getValue()
            int r1 = com.google.android.gms.internal.gtm.zzuo.zza(r2, r1)
            int r0 = r0 + r1
            goto L_0x0569
        L_0x0585:
            int r4 = r4 + r0
        L_0x0586:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.gtm.zzwn.zzq(java.lang.Object):int");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x02fc, code lost:
        r5 = r5 + r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:154:0x0474, code lost:
        r5 = r5 + (r6 + r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:167:0x04c4, code lost:
        r4 = r4 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:177:0x04f6, code lost:
        r5 = r5 + r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:178:0x04f7, code lost:
        r3 = r3 + r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:185:0x0522, code lost:
        r3 = r3 + (r6 + r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:189:0x0531, code lost:
        r4 = r4 + 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:193:0x0541, code lost:
        r4 = r4 + 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:194:0x0545, code lost:
        r2 = r2 + 3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int zzr(T r12) {
        /*
            r11 = this;
            sun.misc.Unsafe r0 = zzb
            r1 = 0
            r2 = r1
            r3 = r2
        L_0x0005:
            int[] r4 = r11.zzc
            int r4 = r4.length
            if (r2 >= r4) goto L_0x0549
            int r4 = r11.zzC(r2)
            int r5 = zzB(r4)
            int[] r6 = r11.zzc
            r6 = r6[r2]
            r7 = 1048575(0xfffff, float:1.469367E-39)
            r4 = r4 & r7
            long r7 = (long) r4
            com.google.android.gms.internal.gtm.zzup r4 = com.google.android.gms.internal.gtm.zzup.DOUBLE_LIST_PACKED
            int r4 = r4.zza()
            if (r5 < r4) goto L_0x0031
            com.google.android.gms.internal.gtm.zzup r4 = com.google.android.gms.internal.gtm.zzup.SINT64_LIST_PACKED
            int r4 = r4.zza()
            if (r5 > r4) goto L_0x0031
            int[] r4 = r11.zzc
            int r9 = r2 + 2
            r4 = r4[r9]
        L_0x0031:
            r4 = 63
            switch(r5) {
                case 0: goto L_0x0535;
                case 1: goto L_0x0525;
                case 2: goto L_0x050e;
                case 3: goto L_0x04f9;
                case 4: goto L_0x04e2;
                case 5: goto L_0x04d5;
                case 6: goto L_0x04c8;
                case 7: goto L_0x04b8;
                case 8: goto L_0x048c;
                case 9: goto L_0x0478;
                case 10: goto L_0x045a;
                case 11: goto L_0x0444;
                case 12: goto L_0x042e;
                case 13: goto L_0x0420;
                case 14: goto L_0x0412;
                case 15: goto L_0x03f7;
                case 16: goto L_0x03dc;
                case 17: goto L_0x03c7;
                case 18: goto L_0x03ba;
                case 19: goto L_0x03af;
                case 20: goto L_0x03a4;
                case 21: goto L_0x0399;
                case 22: goto L_0x038e;
                case 23: goto L_0x0383;
                case 24: goto L_0x0378;
                case 25: goto L_0x036d;
                case 26: goto L_0x0362;
                case 27: goto L_0x0353;
                case 28: goto L_0x0347;
                case 29: goto L_0x033b;
                case 30: goto L_0x032f;
                case 31: goto L_0x0323;
                case 32: goto L_0x0317;
                case 33: goto L_0x030b;
                case 34: goto L_0x02ff;
                case 35: goto L_0x02e8;
                case 36: goto L_0x02d3;
                case 37: goto L_0x02be;
                case 38: goto L_0x02a9;
                case 39: goto L_0x0294;
                case 40: goto L_0x027f;
                case 41: goto L_0x0269;
                case 42: goto L_0x0253;
                case 43: goto L_0x023d;
                case 44: goto L_0x0227;
                case 45: goto L_0x0211;
                case 46: goto L_0x01fb;
                case 47: goto L_0x01e5;
                case 48: goto L_0x01cf;
                case 49: goto L_0x01bf;
                case 50: goto L_0x01b2;
                case 51: goto L_0x01a4;
                case 52: goto L_0x0196;
                case 53: goto L_0x0180;
                case 54: goto L_0x016a;
                case 55: goto L_0x0154;
                case 56: goto L_0x0146;
                case 57: goto L_0x0138;
                case 58: goto L_0x012a;
                case 59: goto L_0x00fc;
                case 60: goto L_0x00e8;
                case 61: goto L_0x00cc;
                case 62: goto L_0x00b6;
                case 63: goto L_0x00a0;
                case 64: goto L_0x0092;
                case 65: goto L_0x0084;
                case 66: goto L_0x0069;
                case 67: goto L_0x004e;
                case 68: goto L_0x0038;
                default: goto L_0x0036;
            }
        L_0x0036:
            goto L_0x0545
        L_0x0038:
            boolean r4 = r11.zzT(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            java.lang.Object r4 = com.google.android.gms.internal.gtm.zzxy.zzf(r12, r7)
            com.google.android.gms.internal.gtm.zzwk r4 = (com.google.android.gms.internal.gtm.zzwk) r4
            com.google.android.gms.internal.gtm.zzwx r5 = r11.zzF(r2)
            int r4 = com.google.android.gms.internal.gtm.zzto.zzv(r6, r4, r5)
            goto L_0x03c4
        L_0x004e:
            boolean r5 = r11.zzT(r12, r6, r2)
            if (r5 == 0) goto L_0x0545
            long r7 = zzD(r12, r7)
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.gtm.zzto.zzD(r5)
            long r9 = r7 + r7
            long r6 = r7 >> r4
            long r6 = r6 ^ r9
            int r4 = com.google.android.gms.internal.gtm.zzto.zzE(r6)
            goto L_0x04f6
        L_0x0069:
            boolean r4 = r11.zzT(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = zzs(r12, r7)
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.gtm.zzto.zzD(r5)
            int r6 = r4 + r4
            int r4 = r4 >> 31
            r4 = r4 ^ r6
            int r4 = com.google.android.gms.internal.gtm.zzto.zzD(r4)
            goto L_0x04f6
        L_0x0084:
            boolean r4 = r11.zzT(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.gtm.zzto.zzD(r4)
            goto L_0x0541
        L_0x0092:
            boolean r4 = r11.zzT(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.gtm.zzto.zzD(r4)
            goto L_0x0531
        L_0x00a0:
            boolean r4 = r11.zzT(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = zzs(r12, r7)
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.gtm.zzto.zzD(r5)
            int r4 = com.google.android.gms.internal.gtm.zzto.zzx(r4)
            goto L_0x04f6
        L_0x00b6:
            boolean r4 = r11.zzT(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = zzs(r12, r7)
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.gtm.zzto.zzD(r5)
            int r4 = com.google.android.gms.internal.gtm.zzto.zzD(r4)
            goto L_0x04f6
        L_0x00cc:
            boolean r4 = r11.zzT(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            java.lang.Object r4 = com.google.android.gms.internal.gtm.zzxy.zzf(r12, r7)
            com.google.android.gms.internal.gtm.zztd r4 = (com.google.android.gms.internal.gtm.zztd) r4
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.gtm.zzto.zzD(r5)
            int r4 = r4.zzd()
            int r6 = com.google.android.gms.internal.gtm.zzto.zzD(r4)
            goto L_0x0474
        L_0x00e8:
            boolean r4 = r11.zzT(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            java.lang.Object r4 = com.google.android.gms.internal.gtm.zzxy.zzf(r12, r7)
            com.google.android.gms.internal.gtm.zzwx r5 = r11.zzF(r2)
            int r4 = com.google.android.gms.internal.gtm.zzwz.zzo(r6, r4, r5)
            goto L_0x03c4
        L_0x00fc:
            boolean r4 = r11.zzT(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            java.lang.Object r4 = com.google.android.gms.internal.gtm.zzxy.zzf(r12, r7)
            boolean r5 = r4 instanceof com.google.android.gms.internal.gtm.zztd
            if (r5 == 0) goto L_0x011c
            com.google.android.gms.internal.gtm.zztd r4 = (com.google.android.gms.internal.gtm.zztd) r4
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.gtm.zzto.zzD(r5)
            int r4 = r4.zzd()
            int r6 = com.google.android.gms.internal.gtm.zzto.zzD(r4)
            goto L_0x0474
        L_0x011c:
            java.lang.String r4 = (java.lang.String) r4
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.gtm.zzto.zzD(r5)
            int r4 = com.google.android.gms.internal.gtm.zzto.zzB(r4)
            goto L_0x04f6
        L_0x012a:
            boolean r4 = r11.zzT(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.gtm.zzto.zzD(r4)
            goto L_0x04c4
        L_0x0138:
            boolean r4 = r11.zzT(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.gtm.zzto.zzD(r4)
            goto L_0x0531
        L_0x0146:
            boolean r4 = r11.zzT(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.gtm.zzto.zzD(r4)
            goto L_0x0541
        L_0x0154:
            boolean r4 = r11.zzT(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = zzs(r12, r7)
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.gtm.zzto.zzD(r5)
            int r4 = com.google.android.gms.internal.gtm.zzto.zzx(r4)
            goto L_0x04f6
        L_0x016a:
            boolean r4 = r11.zzT(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            long r4 = zzD(r12, r7)
            int r6 = r6 << 3
            int r6 = com.google.android.gms.internal.gtm.zzto.zzD(r6)
            int r4 = com.google.android.gms.internal.gtm.zzto.zzE(r4)
            goto L_0x0522
        L_0x0180:
            boolean r4 = r11.zzT(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            long r4 = zzD(r12, r7)
            int r6 = r6 << 3
            int r6 = com.google.android.gms.internal.gtm.zzto.zzD(r6)
            int r4 = com.google.android.gms.internal.gtm.zzto.zzE(r4)
            goto L_0x0522
        L_0x0196:
            boolean r4 = r11.zzT(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.gtm.zzto.zzD(r4)
            goto L_0x0531
        L_0x01a4:
            boolean r4 = r11.zzT(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.gtm.zzto.zzD(r4)
            goto L_0x0541
        L_0x01b2:
            java.lang.Object r4 = com.google.android.gms.internal.gtm.zzxy.zzf(r12, r7)
            java.lang.Object r5 = r11.zzH(r2)
            com.google.android.gms.internal.gtm.zzwf.zza(r6, r4, r5)
            goto L_0x0545
        L_0x01bf:
            java.lang.Object r4 = com.google.android.gms.internal.gtm.zzxy.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            com.google.android.gms.internal.gtm.zzwx r5 = r11.zzF(r2)
            int r4 = com.google.android.gms.internal.gtm.zzwz.zzj(r6, r4, r5)
            goto L_0x03c4
        L_0x01cf:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.gtm.zzwz.zzt(r4)
            if (r4 <= 0) goto L_0x0545
            int r5 = com.google.android.gms.internal.gtm.zzto.zzC(r6)
            int r6 = com.google.android.gms.internal.gtm.zzto.zzD(r4)
            goto L_0x02fc
        L_0x01e5:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.gtm.zzwz.zzr(r4)
            if (r4 <= 0) goto L_0x0545
            int r5 = com.google.android.gms.internal.gtm.zzto.zzC(r6)
            int r6 = com.google.android.gms.internal.gtm.zzto.zzD(r4)
            goto L_0x02fc
        L_0x01fb:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.gtm.zzwz.zzi(r4)
            if (r4 <= 0) goto L_0x0545
            int r5 = com.google.android.gms.internal.gtm.zzto.zzC(r6)
            int r6 = com.google.android.gms.internal.gtm.zzto.zzD(r4)
            goto L_0x02fc
        L_0x0211:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.gtm.zzwz.zzg(r4)
            if (r4 <= 0) goto L_0x0545
            int r5 = com.google.android.gms.internal.gtm.zzto.zzC(r6)
            int r6 = com.google.android.gms.internal.gtm.zzto.zzD(r4)
            goto L_0x02fc
        L_0x0227:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.gtm.zzwz.zze(r4)
            if (r4 <= 0) goto L_0x0545
            int r5 = com.google.android.gms.internal.gtm.zzto.zzC(r6)
            int r6 = com.google.android.gms.internal.gtm.zzto.zzD(r4)
            goto L_0x02fc
        L_0x023d:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.gtm.zzwz.zzw(r4)
            if (r4 <= 0) goto L_0x0545
            int r5 = com.google.android.gms.internal.gtm.zzto.zzC(r6)
            int r6 = com.google.android.gms.internal.gtm.zzto.zzD(r4)
            goto L_0x02fc
        L_0x0253:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.gtm.zzwz.zzb(r4)
            if (r4 <= 0) goto L_0x0545
            int r5 = com.google.android.gms.internal.gtm.zzto.zzC(r6)
            int r6 = com.google.android.gms.internal.gtm.zzto.zzD(r4)
            goto L_0x02fc
        L_0x0269:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.gtm.zzwz.zzg(r4)
            if (r4 <= 0) goto L_0x0545
            int r5 = com.google.android.gms.internal.gtm.zzto.zzC(r6)
            int r6 = com.google.android.gms.internal.gtm.zzto.zzD(r4)
            goto L_0x02fc
        L_0x027f:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.gtm.zzwz.zzi(r4)
            if (r4 <= 0) goto L_0x0545
            int r5 = com.google.android.gms.internal.gtm.zzto.zzC(r6)
            int r6 = com.google.android.gms.internal.gtm.zzto.zzD(r4)
            goto L_0x02fc
        L_0x0294:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.gtm.zzwz.zzl(r4)
            if (r4 <= 0) goto L_0x0545
            int r5 = com.google.android.gms.internal.gtm.zzto.zzC(r6)
            int r6 = com.google.android.gms.internal.gtm.zzto.zzD(r4)
            goto L_0x02fc
        L_0x02a9:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.gtm.zzwz.zzy(r4)
            if (r4 <= 0) goto L_0x0545
            int r5 = com.google.android.gms.internal.gtm.zzto.zzC(r6)
            int r6 = com.google.android.gms.internal.gtm.zzto.zzD(r4)
            goto L_0x02fc
        L_0x02be:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.gtm.zzwz.zzn(r4)
            if (r4 <= 0) goto L_0x0545
            int r5 = com.google.android.gms.internal.gtm.zzto.zzC(r6)
            int r6 = com.google.android.gms.internal.gtm.zzto.zzD(r4)
            goto L_0x02fc
        L_0x02d3:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.gtm.zzwz.zzg(r4)
            if (r4 <= 0) goto L_0x0545
            int r5 = com.google.android.gms.internal.gtm.zzto.zzC(r6)
            int r6 = com.google.android.gms.internal.gtm.zzto.zzD(r4)
            goto L_0x02fc
        L_0x02e8:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.gtm.zzwz.zzi(r4)
            if (r4 <= 0) goto L_0x0545
            int r5 = com.google.android.gms.internal.gtm.zzto.zzC(r6)
            int r6 = com.google.android.gms.internal.gtm.zzto.zzD(r4)
        L_0x02fc:
            int r5 = r5 + r6
            goto L_0x04f6
        L_0x02ff:
            java.lang.Object r4 = com.google.android.gms.internal.gtm.zzxy.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.gtm.zzwz.zzs(r6, r4, r1)
            goto L_0x03c4
        L_0x030b:
            java.lang.Object r4 = com.google.android.gms.internal.gtm.zzxy.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.gtm.zzwz.zzq(r6, r4, r1)
            goto L_0x03c4
        L_0x0317:
            java.lang.Object r4 = com.google.android.gms.internal.gtm.zzxy.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.gtm.zzwz.zzh(r6, r4, r1)
            goto L_0x03c4
        L_0x0323:
            java.lang.Object r4 = com.google.android.gms.internal.gtm.zzxy.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.gtm.zzwz.zzf(r6, r4, r1)
            goto L_0x03c4
        L_0x032f:
            java.lang.Object r4 = com.google.android.gms.internal.gtm.zzxy.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.gtm.zzwz.zzd(r6, r4, r1)
            goto L_0x03c4
        L_0x033b:
            java.lang.Object r4 = com.google.android.gms.internal.gtm.zzxy.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.gtm.zzwz.zzv(r6, r4, r1)
            goto L_0x03c4
        L_0x0347:
            java.lang.Object r4 = com.google.android.gms.internal.gtm.zzxy.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.gtm.zzwz.zzc(r6, r4)
            goto L_0x03c4
        L_0x0353:
            java.lang.Object r4 = com.google.android.gms.internal.gtm.zzxy.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            com.google.android.gms.internal.gtm.zzwx r5 = r11.zzF(r2)
            int r4 = com.google.android.gms.internal.gtm.zzwz.zzp(r6, r4, r5)
            goto L_0x03c4
        L_0x0362:
            java.lang.Object r4 = com.google.android.gms.internal.gtm.zzxy.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.gtm.zzwz.zzu(r6, r4)
            goto L_0x03c4
        L_0x036d:
            java.lang.Object r4 = com.google.android.gms.internal.gtm.zzxy.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.gtm.zzwz.zza(r6, r4, r1)
            goto L_0x03c4
        L_0x0378:
            java.lang.Object r4 = com.google.android.gms.internal.gtm.zzxy.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.gtm.zzwz.zzf(r6, r4, r1)
            goto L_0x03c4
        L_0x0383:
            java.lang.Object r4 = com.google.android.gms.internal.gtm.zzxy.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.gtm.zzwz.zzh(r6, r4, r1)
            goto L_0x03c4
        L_0x038e:
            java.lang.Object r4 = com.google.android.gms.internal.gtm.zzxy.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.gtm.zzwz.zzk(r6, r4, r1)
            goto L_0x03c4
        L_0x0399:
            java.lang.Object r4 = com.google.android.gms.internal.gtm.zzxy.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.gtm.zzwz.zzx(r6, r4, r1)
            goto L_0x03c4
        L_0x03a4:
            java.lang.Object r4 = com.google.android.gms.internal.gtm.zzxy.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.gtm.zzwz.zzm(r6, r4, r1)
            goto L_0x03c4
        L_0x03af:
            java.lang.Object r4 = com.google.android.gms.internal.gtm.zzxy.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.gtm.zzwz.zzf(r6, r4, r1)
            goto L_0x03c4
        L_0x03ba:
            java.lang.Object r4 = com.google.android.gms.internal.gtm.zzxy.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.gtm.zzwz.zzh(r6, r4, r1)
        L_0x03c4:
            int r3 = r3 + r4
            goto L_0x0545
        L_0x03c7:
            boolean r4 = r11.zzQ(r12, r2)
            if (r4 == 0) goto L_0x0545
            java.lang.Object r4 = com.google.android.gms.internal.gtm.zzxy.zzf(r12, r7)
            com.google.android.gms.internal.gtm.zzwk r4 = (com.google.android.gms.internal.gtm.zzwk) r4
            com.google.android.gms.internal.gtm.zzwx r5 = r11.zzF(r2)
            int r4 = com.google.android.gms.internal.gtm.zzto.zzv(r6, r4, r5)
            goto L_0x03c4
        L_0x03dc:
            boolean r5 = r11.zzQ(r12, r2)
            if (r5 == 0) goto L_0x0545
            long r7 = com.google.android.gms.internal.gtm.zzxy.zzd(r12, r7)
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.gtm.zzto.zzD(r5)
            long r9 = r7 + r7
            long r6 = r7 >> r4
            long r6 = r6 ^ r9
            int r4 = com.google.android.gms.internal.gtm.zzto.zzE(r6)
            goto L_0x04f6
        L_0x03f7:
            boolean r4 = r11.zzQ(r12, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = com.google.android.gms.internal.gtm.zzxy.zzc(r12, r7)
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.gtm.zzto.zzD(r5)
            int r6 = r4 + r4
            int r4 = r4 >> 31
            r4 = r4 ^ r6
            int r4 = com.google.android.gms.internal.gtm.zzto.zzD(r4)
            goto L_0x04f6
        L_0x0412:
            boolean r4 = r11.zzQ(r12, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.gtm.zzto.zzD(r4)
            goto L_0x0541
        L_0x0420:
            boolean r4 = r11.zzQ(r12, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.gtm.zzto.zzD(r4)
            goto L_0x0531
        L_0x042e:
            boolean r4 = r11.zzQ(r12, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = com.google.android.gms.internal.gtm.zzxy.zzc(r12, r7)
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.gtm.zzto.zzD(r5)
            int r4 = com.google.android.gms.internal.gtm.zzto.zzx(r4)
            goto L_0x04f6
        L_0x0444:
            boolean r4 = r11.zzQ(r12, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = com.google.android.gms.internal.gtm.zzxy.zzc(r12, r7)
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.gtm.zzto.zzD(r5)
            int r4 = com.google.android.gms.internal.gtm.zzto.zzD(r4)
            goto L_0x04f6
        L_0x045a:
            boolean r4 = r11.zzQ(r12, r2)
            if (r4 == 0) goto L_0x0545
            java.lang.Object r4 = com.google.android.gms.internal.gtm.zzxy.zzf(r12, r7)
            com.google.android.gms.internal.gtm.zztd r4 = (com.google.android.gms.internal.gtm.zztd) r4
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.gtm.zzto.zzD(r5)
            int r4 = r4.zzd()
            int r6 = com.google.android.gms.internal.gtm.zzto.zzD(r4)
        L_0x0474:
            int r6 = r6 + r4
            int r5 = r5 + r6
            goto L_0x04f7
        L_0x0478:
            boolean r4 = r11.zzQ(r12, r2)
            if (r4 == 0) goto L_0x0545
            java.lang.Object r4 = com.google.android.gms.internal.gtm.zzxy.zzf(r12, r7)
            com.google.android.gms.internal.gtm.zzwx r5 = r11.zzF(r2)
            int r4 = com.google.android.gms.internal.gtm.zzwz.zzo(r6, r4, r5)
            goto L_0x03c4
        L_0x048c:
            boolean r4 = r11.zzQ(r12, r2)
            if (r4 == 0) goto L_0x0545
            java.lang.Object r4 = com.google.android.gms.internal.gtm.zzxy.zzf(r12, r7)
            boolean r5 = r4 instanceof com.google.android.gms.internal.gtm.zztd
            if (r5 == 0) goto L_0x04ab
            com.google.android.gms.internal.gtm.zztd r4 = (com.google.android.gms.internal.gtm.zztd) r4
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.gtm.zzto.zzD(r5)
            int r4 = r4.zzd()
            int r6 = com.google.android.gms.internal.gtm.zzto.zzD(r4)
            goto L_0x0474
        L_0x04ab:
            java.lang.String r4 = (java.lang.String) r4
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.gtm.zzto.zzD(r5)
            int r4 = com.google.android.gms.internal.gtm.zzto.zzB(r4)
            goto L_0x04f6
        L_0x04b8:
            boolean r4 = r11.zzQ(r12, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.gtm.zzto.zzD(r4)
        L_0x04c4:
            int r4 = r4 + 1
            goto L_0x03c4
        L_0x04c8:
            boolean r4 = r11.zzQ(r12, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.gtm.zzto.zzD(r4)
            goto L_0x0531
        L_0x04d5:
            boolean r4 = r11.zzQ(r12, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.gtm.zzto.zzD(r4)
            goto L_0x0541
        L_0x04e2:
            boolean r4 = r11.zzQ(r12, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = com.google.android.gms.internal.gtm.zzxy.zzc(r12, r7)
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.gtm.zzto.zzD(r5)
            int r4 = com.google.android.gms.internal.gtm.zzto.zzx(r4)
        L_0x04f6:
            int r5 = r5 + r4
        L_0x04f7:
            int r3 = r3 + r5
            goto L_0x0545
        L_0x04f9:
            boolean r4 = r11.zzQ(r12, r2)
            if (r4 == 0) goto L_0x0545
            long r4 = com.google.android.gms.internal.gtm.zzxy.zzd(r12, r7)
            int r6 = r6 << 3
            int r6 = com.google.android.gms.internal.gtm.zzto.zzD(r6)
            int r4 = com.google.android.gms.internal.gtm.zzto.zzE(r4)
            goto L_0x0522
        L_0x050e:
            boolean r4 = r11.zzQ(r12, r2)
            if (r4 == 0) goto L_0x0545
            long r4 = com.google.android.gms.internal.gtm.zzxy.zzd(r12, r7)
            int r6 = r6 << 3
            int r6 = com.google.android.gms.internal.gtm.zzto.zzD(r6)
            int r4 = com.google.android.gms.internal.gtm.zzto.zzE(r4)
        L_0x0522:
            int r6 = r6 + r4
            int r3 = r3 + r6
            goto L_0x0545
        L_0x0525:
            boolean r4 = r11.zzQ(r12, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.gtm.zzto.zzD(r4)
        L_0x0531:
            int r4 = r4 + 4
            goto L_0x03c4
        L_0x0535:
            boolean r4 = r11.zzQ(r12, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.gtm.zzto.zzD(r4)
        L_0x0541:
            int r4 = r4 + 8
            goto L_0x03c4
        L_0x0545:
            int r2 = r2 + 3
            goto L_0x0005
        L_0x0549:
            com.google.android.gms.internal.gtm.zzxo<?, ?> r0 = r11.zzo
            java.lang.Object r12 = r0.zzd(r12)
            int r12 = r0.zza(r12)
            int r3 = r3 + r12
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.gtm.zzwn.zzr(java.lang.Object):int");
    }

    private static <T> int zzs(T t10, long j10) {
        return ((Integer) zzxy.zzf(t10, j10)).intValue();
    }

    private final <K, V> int zzt(T t10, byte[] bArr, int i10, int i11, int i12, long j10, zzsl zzsl) throws IOException {
        Unsafe unsafe = zzb;
        Object zzH = zzH(i12);
        Object object = unsafe.getObject(t10, j10);
        if (zzwf.zzb(object)) {
            zzwe zzb2 = zzwe.zza().zzb();
            zzwf.zzc(zzb2, object);
            unsafe.putObject(t10, j10, zzb2);
        }
        zzwd zzwd = (zzwd) zzH;
        throw null;
    }

    private final int zzu(T t10, byte[] bArr, int i10, int i11, int i12, int i13, int i14, int i15, int i16, long j10, int i17, zzsl zzsl) throws IOException {
        T t11 = t10;
        byte[] bArr2 = bArr;
        int i18 = i10;
        int i19 = i12;
        int i20 = i13;
        int i21 = i14;
        long j11 = j10;
        int i22 = i17;
        zzsl zzsl2 = zzsl;
        Unsafe unsafe = zzb;
        long j12 = (long) (this.zzc[i22 + 2] & 1048575);
        switch (i16) {
            case 51:
                if (i21 == 1) {
                    unsafe.putObject(t11, j11, Double.valueOf(Double.longBitsToDouble(zzsm.zzo(bArr, i10))));
                    unsafe.putInt(t11, j12, i20);
                    return i18 + 8;
                }
                break;
            case 52:
                if (i21 == 5) {
                    unsafe.putObject(t11, j11, Float.valueOf(Float.intBitsToFloat(zzsm.zzb(bArr, i10))));
                    unsafe.putInt(t11, j12, i20);
                    return i18 + 4;
                }
                break;
            case 53:
            case 54:
                if (i21 == 0) {
                    int zzm2 = zzsm.zzm(bArr2, i18, zzsl2);
                    unsafe.putObject(t11, j11, Long.valueOf(zzsl2.zzb));
                    unsafe.putInt(t11, j12, i20);
                    return zzm2;
                }
                break;
            case 55:
            case 62:
                if (i21 == 0) {
                    int zzj2 = zzsm.zzj(bArr2, i18, zzsl2);
                    unsafe.putObject(t11, j11, Integer.valueOf(zzsl2.zza));
                    unsafe.putInt(t11, j12, i20);
                    return zzj2;
                }
                break;
            case 56:
            case 65:
                if (i21 == 1) {
                    unsafe.putObject(t11, j11, Long.valueOf(zzsm.zzo(bArr, i10)));
                    unsafe.putInt(t11, j12, i20);
                    return i18 + 8;
                }
                break;
            case 57:
            case 64:
                if (i21 == 5) {
                    unsafe.putObject(t11, j11, Integer.valueOf(zzsm.zzb(bArr, i10)));
                    unsafe.putInt(t11, j12, i20);
                    return i18 + 4;
                }
                break;
            case 58:
                if (i21 == 0) {
                    int zzm3 = zzsm.zzm(bArr2, i18, zzsl2);
                    unsafe.putObject(t11, j11, Boolean.valueOf(zzsl2.zzb != 0));
                    unsafe.putInt(t11, j12, i20);
                    return zzm3;
                }
                break;
            case 59:
                if (i21 == 2) {
                    int zzj3 = zzsm.zzj(bArr2, i18, zzsl2);
                    int i23 = zzsl2.zza;
                    if (i23 == 0) {
                        unsafe.putObject(t11, j11, "");
                    } else if ((i15 & 536870912) == 0 || zzyd.zzf(bArr2, zzj3, zzj3 + i23)) {
                        unsafe.putObject(t11, j11, new String(bArr2, zzj3, i23, zzvi.zza));
                        zzj3 += i23;
                    } else {
                        throw zzvk.zzd();
                    }
                    unsafe.putInt(t11, j12, i20);
                    return zzj3;
                }
                break;
            case 60:
                if (i21 == 2) {
                    int zzd2 = zzsm.zzd(zzF(i22), bArr2, i18, i11, zzsl2);
                    Object object = unsafe.getInt(t11, j12) == i20 ? unsafe.getObject(t11, j11) : null;
                    if (object == null) {
                        unsafe.putObject(t11, j11, zzsl2.zzc);
                    } else {
                        unsafe.putObject(t11, j11, zzvi.zzg(object, zzsl2.zzc));
                    }
                    unsafe.putInt(t11, j12, i20);
                    return zzd2;
                }
                break;
            case 61:
                if (i21 == 2) {
                    int zza2 = zzsm.zza(bArr2, i18, zzsl2);
                    unsafe.putObject(t11, j11, zzsl2.zzc);
                    unsafe.putInt(t11, j12, i20);
                    return zza2;
                }
                break;
            case 63:
                if (i21 == 0) {
                    int zzj4 = zzsm.zzj(bArr2, i18, zzsl2);
                    int i24 = zzsl2.zza;
                    zzvd zzE = zzE(i22);
                    if (zzE == null || zzE.zza(i24)) {
                        unsafe.putObject(t11, j11, Integer.valueOf(i24));
                        unsafe.putInt(t11, j12, i20);
                    } else {
                        zzd(t10).zzh(i19, Long.valueOf((long) i24));
                    }
                    return zzj4;
                }
                break;
            case 66:
                if (i21 == 0) {
                    int zzj5 = zzsm.zzj(bArr2, i18, zzsl2);
                    unsafe.putObject(t11, j11, Integer.valueOf(zztj.zzs(zzsl2.zza)));
                    unsafe.putInt(t11, j12, i20);
                    return zzj5;
                }
                break;
            case 67:
                if (i21 == 0) {
                    int zzm4 = zzsm.zzm(bArr2, i18, zzsl2);
                    unsafe.putObject(t11, j11, Long.valueOf(zztj.zzt(zzsl2.zzb)));
                    unsafe.putInt(t11, j12, i20);
                    return zzm4;
                }
                break;
            case 68:
                if (i21 == 3) {
                    int zzc2 = zzsm.zzc(zzF(i22), bArr, i10, i11, (i19 & -8) | 4, zzsl);
                    Object object2 = unsafe.getInt(t11, j12) == i20 ? unsafe.getObject(t11, j11) : null;
                    if (object2 == null) {
                        unsafe.putObject(t11, j11, zzsl2.zzc);
                    } else {
                        unsafe.putObject(t11, j11, zzvi.zzg(object2, zzsl2.zzc));
                    }
                    unsafe.putInt(t11, j12, i20);
                    return zzc2;
                }
                break;
        }
        return i18;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v7, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v4, resolved type: byte} */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x02a9, code lost:
        if (r0 != r15) goto L_0x02ab;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x02c1, code lost:
        r2 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x02f4, code lost:
        if (r0 != r15) goto L_0x02ab;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:115:0x0317, code lost:
        if (r0 != r15) goto L_0x02ab;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00f9, code lost:
        r6 = r6 | r21;
        r9 = r10;
        r2 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00fd, code lost:
        r1 = r20;
        r8 = 1048575;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0186, code lost:
        r6 = r6 | r21;
        r9 = r10;
        r8 = r19;
        r1 = r20;
        r10 = -1;
        r29 = r13;
        r13 = r2;
        r2 = r29;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x020a, code lost:
        r6 = r6 | r21;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x020d, code lost:
        r2 = r4;
        r28 = r10;
        r19 = r13;
        r18 = -1;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int zzv(T r31, byte[] r32, int r33, int r34, com.google.android.gms.internal.gtm.zzsl r35) throws java.io.IOException {
        /*
            r30 = this;
            r15 = r30
            r14 = r31
            r12 = r32
            r13 = r34
            r11 = r35
            sun.misc.Unsafe r9 = zzb
            r10 = -1
            r16 = 0
            r8 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r33
            r7 = r8
            r1 = r10
            r2 = r16
            r6 = r2
        L_0x0019:
            if (r0 >= r13) goto L_0x0341
            int r3 = r0 + 1
            byte r0 = r12[r0]
            if (r0 >= 0) goto L_0x002b
            int r0 = com.google.android.gms.internal.gtm.zzsm.zzk(r0, r12, r3, r11)
            int r3 = r11.zza
            r4 = r0
            r17 = r3
            goto L_0x002e
        L_0x002b:
            r17 = r0
            r4 = r3
        L_0x002e:
            int r5 = r17 >>> 3
            r3 = r17 & 7
            if (r5 <= r1) goto L_0x003b
            int r2 = r2 / 3
            int r0 = r15.zzy(r5, r2)
            goto L_0x003f
        L_0x003b:
            int r0 = r15.zzx(r5)
        L_0x003f:
            r2 = r0
            if (r2 != r10) goto L_0x004d
            r2 = r4
            r20 = r5
            r28 = r9
            r18 = r10
            r19 = r16
            goto L_0x031a
        L_0x004d:
            int[] r0 = r15.zzc
            int r1 = r2 + 1
            r1 = r0[r1]
            int r0 = zzB(r1)
            r10 = r1 & r8
            r19 = r9
            long r8 = (long) r10
            r10 = 17
            r33 = r5
            if (r0 > r10) goto L_0x0216
            int[] r10 = r15.zzc
            int r21 = r2 + 2
            r10 = r10[r21]
            int r21 = r10 >>> 20
            r5 = 1
            int r21 = r5 << r21
            r13 = 1048575(0xfffff, float:1.469367E-39)
            r10 = r10 & r13
            if (r10 == r7) goto L_0x008f
            r23 = r1
            r20 = r2
            if (r7 == r13) goto L_0x0080
            long r1 = (long) r7
            r7 = r19
            r7.putInt(r14, r1, r6)
            goto L_0x0082
        L_0x0080:
            r7 = r19
        L_0x0082:
            if (r10 == r13) goto L_0x0089
            long r1 = (long) r10
            int r6 = r7.getInt(r14, r1)
        L_0x0089:
            r29 = r10
            r10 = r7
            r7 = r29
            goto L_0x0095
        L_0x008f:
            r23 = r1
            r20 = r2
            r10 = r19
        L_0x0095:
            r1 = 5
            switch(r0) {
                case 0: goto L_0x01f5;
                case 1: goto L_0x01df;
                case 2: goto L_0x01c2;
                case 3: goto L_0x01c2;
                case 4: goto L_0x01b0;
                case 5: goto L_0x0195;
                case 6: goto L_0x0173;
                case 7: goto L_0x0156;
                case 8: goto L_0x0136;
                case 9: goto L_0x0104;
                case 10: goto L_0x00e9;
                case 11: goto L_0x01b0;
                case 12: goto L_0x00d9;
                case 13: goto L_0x0173;
                case 14: goto L_0x0195;
                case 15: goto L_0x00c5;
                case 16: goto L_0x00a1;
                default: goto L_0x0099;
            }
        L_0x0099:
            r19 = r13
            r13 = r20
            r20 = r33
            goto L_0x020d
        L_0x00a1:
            if (r3 != 0) goto L_0x00bf
            int r17 = com.google.android.gms.internal.gtm.zzsm.zzm(r12, r4, r11)
            long r0 = r11.zzb
            long r4 = com.google.android.gms.internal.gtm.zztj.zzt(r0)
            r0 = r10
            r1 = r31
            r13 = r20
            r2 = r8
            r20 = r33
            r0.putLong(r1, r2, r4)
            r6 = r6 | r21
            r9 = r10
            r2 = r13
            r0 = r17
            goto L_0x00fd
        L_0x00bf:
            r13 = r20
            r20 = r33
            goto L_0x0131
        L_0x00c5:
            r13 = r20
            r20 = r33
            if (r3 != 0) goto L_0x0131
            int r0 = com.google.android.gms.internal.gtm.zzsm.zzj(r12, r4, r11)
            int r1 = r11.zza
            int r1 = com.google.android.gms.internal.gtm.zztj.zzs(r1)
            r10.putInt(r14, r8, r1)
            goto L_0x00f9
        L_0x00d9:
            r13 = r20
            r20 = r33
            if (r3 != 0) goto L_0x0131
            int r0 = com.google.android.gms.internal.gtm.zzsm.zzj(r12, r4, r11)
            int r1 = r11.zza
            r10.putInt(r14, r8, r1)
            goto L_0x00f9
        L_0x00e9:
            r13 = r20
            r0 = 2
            r20 = r33
            if (r3 != r0) goto L_0x0131
            int r0 = com.google.android.gms.internal.gtm.zzsm.zza(r12, r4, r11)
            java.lang.Object r1 = r11.zzc
            r10.putObject(r14, r8, r1)
        L_0x00f9:
            r6 = r6 | r21
            r9 = r10
            r2 = r13
        L_0x00fd:
            r1 = r20
            r8 = 1048575(0xfffff, float:1.469367E-39)
            goto L_0x025e
        L_0x0104:
            r13 = r20
            r0 = 2
            r20 = r33
            if (r3 != r0) goto L_0x012f
            com.google.android.gms.internal.gtm.zzwx r0 = r15.zzF(r13)
            r2 = r34
            r19 = 1048575(0xfffff, float:1.469367E-39)
            int r0 = com.google.android.gms.internal.gtm.zzsm.zzd(r0, r12, r4, r2, r11)
            java.lang.Object r1 = r10.getObject(r14, r8)
            if (r1 != 0) goto L_0x0125
            java.lang.Object r1 = r11.zzc
            r10.putObject(r14, r8, r1)
            goto L_0x0186
        L_0x0125:
            java.lang.Object r3 = r11.zzc
            java.lang.Object r1 = com.google.android.gms.internal.gtm.zzvi.zzg(r1, r3)
            r10.putObject(r14, r8, r1)
            goto L_0x0186
        L_0x012f:
            r2 = r34
        L_0x0131:
            r19 = 1048575(0xfffff, float:1.469367E-39)
            goto L_0x020d
        L_0x0136:
            r2 = r34
            r19 = r13
            r13 = r20
            r0 = 2
            r20 = r33
            if (r3 != r0) goto L_0x020d
            r0 = 536870912(0x20000000, float:1.0842022E-19)
            r0 = r23 & r0
            if (r0 != 0) goto L_0x014c
            int r0 = com.google.android.gms.internal.gtm.zzsm.zzg(r12, r4, r11)
            goto L_0x0150
        L_0x014c:
            int r0 = com.google.android.gms.internal.gtm.zzsm.zzh(r12, r4, r11)
        L_0x0150:
            java.lang.Object r1 = r11.zzc
            r10.putObject(r14, r8, r1)
            goto L_0x0186
        L_0x0156:
            r2 = r34
            r19 = r13
            r13 = r20
            r20 = r33
            if (r3 != 0) goto L_0x020d
            int r0 = com.google.android.gms.internal.gtm.zzsm.zzm(r12, r4, r11)
            long r3 = r11.zzb
            r22 = 0
            int r1 = (r3 > r22 ? 1 : (r3 == r22 ? 0 : -1))
            if (r1 == 0) goto L_0x016d
            goto L_0x016f
        L_0x016d:
            r5 = r16
        L_0x016f:
            com.google.android.gms.internal.gtm.zzxy.zzm(r14, r8, r5)
            goto L_0x0186
        L_0x0173:
            r2 = r34
            r19 = r13
            r13 = r20
            r20 = r33
            if (r3 != r1) goto L_0x020d
            int r0 = com.google.android.gms.internal.gtm.zzsm.zzb(r12, r4)
            r10.putInt(r14, r8, r0)
            int r0 = r4 + 4
        L_0x0186:
            r6 = r6 | r21
            r9 = r10
            r8 = r19
            r1 = r20
            r10 = -1
            r29 = r13
            r13 = r2
            r2 = r29
            goto L_0x0019
        L_0x0195:
            r2 = r34
            r19 = r13
            r13 = r20
            r20 = r33
            if (r3 != r5) goto L_0x020d
            long r22 = com.google.android.gms.internal.gtm.zzsm.zzo(r12, r4)
            r0 = r10
            r1 = r31
            r2 = r8
            r8 = r4
            r4 = r22
            r0.putLong(r1, r2, r4)
            int r0 = r8 + 8
            goto L_0x020a
        L_0x01b0:
            r19 = r13
            r13 = r20
            r20 = r33
            if (r3 != 0) goto L_0x020d
            int r0 = com.google.android.gms.internal.gtm.zzsm.zzj(r12, r4, r11)
            int r1 = r11.zza
            r10.putInt(r14, r8, r1)
            goto L_0x020a
        L_0x01c2:
            r19 = r13
            r13 = r20
            r20 = r33
            if (r3 != 0) goto L_0x020d
            int r17 = com.google.android.gms.internal.gtm.zzsm.zzm(r12, r4, r11)
            long r4 = r11.zzb
            r0 = r10
            r1 = r31
            r2 = r8
            r0.putLong(r1, r2, r4)
            r6 = r6 | r21
            r9 = r10
            r2 = r13
            r0 = r17
            goto L_0x025a
        L_0x01df:
            r19 = r13
            r13 = r20
            r20 = r33
            if (r3 != r1) goto L_0x020d
            int r0 = com.google.android.gms.internal.gtm.zzsm.zzb(r12, r4)
            float r0 = java.lang.Float.intBitsToFloat(r0)
            com.google.android.gms.internal.gtm.zzxy.zzp(r14, r8, r0)
            int r0 = r4 + 4
            goto L_0x020a
        L_0x01f5:
            r19 = r13
            r13 = r20
            r20 = r33
            if (r3 != r5) goto L_0x020d
            long r0 = com.google.android.gms.internal.gtm.zzsm.zzo(r12, r4)
            double r0 = java.lang.Double.longBitsToDouble(r0)
            com.google.android.gms.internal.gtm.zzxy.zzo(r14, r8, r0)
            int r0 = r4 + 8
        L_0x020a:
            r6 = r6 | r21
            goto L_0x0258
        L_0x020d:
            r2 = r4
            r28 = r10
            r19 = r13
            r18 = -1
            goto L_0x031a
        L_0x0216:
            r20 = r33
            r23 = r1
            r13 = r2
            r10 = r19
            r19 = 1048575(0xfffff, float:1.469367E-39)
            r1 = 27
            if (r0 != r1) goto L_0x0270
            r1 = 2
            if (r3 != r1) goto L_0x0263
            java.lang.Object r0 = r10.getObject(r14, r8)
            com.google.android.gms.internal.gtm.zzvh r0 = (com.google.android.gms.internal.gtm.zzvh) r0
            boolean r1 = r0.zzc()
            if (r1 != 0) goto L_0x0244
            int r1 = r0.size()
            if (r1 != 0) goto L_0x023c
            r1 = 10
            goto L_0x023d
        L_0x023c:
            int r1 = r1 + r1
        L_0x023d:
            com.google.android.gms.internal.gtm.zzvh r0 = r0.zzd(r1)
            r10.putObject(r14, r8, r0)
        L_0x0244:
            r5 = r0
            com.google.android.gms.internal.gtm.zzwx r0 = r15.zzF(r13)
            r1 = r17
            r2 = r32
            r3 = r4
            r4 = r34
            r8 = r6
            r6 = r35
            int r0 = com.google.android.gms.internal.gtm.zzsm.zze(r0, r1, r2, r3, r4, r5, r6)
            r6 = r8
        L_0x0258:
            r9 = r10
            r2 = r13
        L_0x025a:
            r8 = r19
            r1 = r20
        L_0x025e:
            r10 = -1
            r13 = r34
            goto L_0x0019
        L_0x0263:
            r15 = r4
            r24 = r6
            r25 = r7
            r28 = r10
            r19 = r13
            r18 = -1
            goto L_0x02f7
        L_0x0270:
            r1 = 49
            if (r0 > r1) goto L_0x02c3
            r1 = r23
            long r1 = (long) r1
            r5 = r0
            r0 = r30
            r21 = r1
            r1 = r31
            r2 = r32
            r33 = r3
            r3 = r4
            r15 = r4
            r4 = r34
            r23 = r5
            r5 = r17
            r24 = r6
            r6 = r20
            r25 = r7
            r7 = r33
            r26 = r8
            r9 = r19
            r8 = r13
            r28 = r10
            r18 = -1
            r9 = r21
            r11 = r23
            r19 = r13
            r12 = r26
            r14 = r35
            int r0 = r0.zzw(r1, r2, r3, r4, r5, r6, r7, r8, r9, r11, r12, r14)
            if (r0 == r15) goto L_0x02c1
        L_0x02ab:
            r15 = r30
            r14 = r31
            r12 = r32
            r13 = r34
            r11 = r35
            r10 = r18
            r2 = r19
            r1 = r20
            r6 = r24
            r7 = r25
            goto L_0x033a
        L_0x02c1:
            r2 = r0
            goto L_0x02f8
        L_0x02c3:
            r33 = r3
            r15 = r4
            r24 = r6
            r25 = r7
            r26 = r8
            r28 = r10
            r19 = r13
            r1 = r23
            r18 = -1
            r23 = r0
            r0 = 50
            r9 = r23
            if (r9 != r0) goto L_0x02fd
            r7 = r33
            r0 = 2
            if (r7 != r0) goto L_0x02f7
            r0 = r30
            r1 = r31
            r2 = r32
            r3 = r15
            r4 = r34
            r5 = r19
            r6 = r26
            r8 = r35
            int r0 = r0.zzt(r1, r2, r3, r4, r5, r6, r8)
            if (r0 == r15) goto L_0x02c1
            goto L_0x02ab
        L_0x02f7:
            r2 = r15
        L_0x02f8:
            r6 = r24
            r7 = r25
            goto L_0x031a
        L_0x02fd:
            r7 = r33
            r0 = r30
            r8 = r1
            r1 = r31
            r2 = r32
            r3 = r15
            r4 = r34
            r5 = r17
            r6 = r20
            r10 = r26
            r12 = r19
            r13 = r35
            int r0 = r0.zzu(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r12, r13)
            if (r0 == r15) goto L_0x02c1
            goto L_0x02ab
        L_0x031a:
            com.google.android.gms.internal.gtm.zzxp r4 = zzd(r31)
            r0 = r17
            r1 = r32
            r3 = r34
            r5 = r35
            int r0 = com.google.android.gms.internal.gtm.zzsm.zzi(r0, r1, r2, r3, r4, r5)
            r15 = r30
            r14 = r31
            r12 = r32
            r13 = r34
            r11 = r35
            r10 = r18
            r2 = r19
            r1 = r20
        L_0x033a:
            r9 = r28
            r8 = 1048575(0xfffff, float:1.469367E-39)
            goto L_0x0019
        L_0x0341:
            r24 = r6
            r1 = r8
            r28 = r9
            if (r7 == r1) goto L_0x0352
            long r1 = (long) r7
            r3 = r31
            r6 = r24
            r4 = r28
            r4.putInt(r3, r1, r6)
        L_0x0352:
            r1 = r34
            if (r0 != r1) goto L_0x0357
            return r0
        L_0x0357:
            com.google.android.gms.internal.gtm.zzvk r0 = com.google.android.gms.internal.gtm.zzvk.zzg()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.gtm.zzwn.zzv(java.lang.Object, byte[], int, int, com.google.android.gms.internal.gtm.zzsl):int");
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Removed duplicated region for block: B:255:0x0450 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x01cf  */
    private final int zzw(T r16, byte[] r17, int r18, int r19, int r20, int r21, int r22, int r23, long r24, int r26, long r27, com.google.android.gms.internal.gtm.zzsl r29) throws java.io.IOException {
        /*
            r15 = this;
            r0 = r15
            r1 = r16
            r3 = r17
            r4 = r18
            r5 = r19
            r2 = r20
            r6 = r22
            r8 = r23
            r9 = r27
            r7 = r29
            sun.misc.Unsafe r11 = zzb
            java.lang.Object r12 = r11.getObject(r1, r9)
            com.google.android.gms.internal.gtm.zzvh r12 = (com.google.android.gms.internal.gtm.zzvh) r12
            boolean r13 = r12.zzc()
            if (r13 != 0) goto L_0x0032
            int r13 = r12.size()
            if (r13 != 0) goto L_0x002a
            r13 = 10
            goto L_0x002b
        L_0x002a:
            int r13 = r13 + r13
        L_0x002b:
            com.google.android.gms.internal.gtm.zzvh r12 = r12.zzd(r13)
            r11.putObject(r1, r9, r12)
        L_0x0032:
            r9 = 5
            r10 = 0
            r13 = 1
            r14 = 2
            switch(r26) {
                case 18: goto L_0x03e1;
                case 19: goto L_0x0394;
                case 20: goto L_0x0351;
                case 21: goto L_0x0351;
                case 22: goto L_0x0336;
                case 23: goto L_0x02f5;
                case 24: goto L_0x02b4;
                case 25: goto L_0x025a;
                case 26: goto L_0x01a7;
                case 27: goto L_0x018c;
                case 28: goto L_0x0132;
                case 29: goto L_0x0336;
                case 30: goto L_0x00fa;
                case 31: goto L_0x02b4;
                case 32: goto L_0x02f5;
                case 33: goto L_0x00ab;
                case 34: goto L_0x005c;
                case 35: goto L_0x03e1;
                case 36: goto L_0x0394;
                case 37: goto L_0x0351;
                case 38: goto L_0x0351;
                case 39: goto L_0x0336;
                case 40: goto L_0x02f5;
                case 41: goto L_0x02b4;
                case 42: goto L_0x025a;
                case 43: goto L_0x0336;
                case 44: goto L_0x00fa;
                case 45: goto L_0x02b4;
                case 46: goto L_0x02f5;
                case 47: goto L_0x00ab;
                case 48: goto L_0x005c;
                default: goto L_0x003a;
            }
        L_0x003a:
            r1 = 3
            if (r6 != r1) goto L_0x044f
            com.google.android.gms.internal.gtm.zzwx r1 = r15.zzF(r8)
            r6 = r2 & -8
            r6 = r6 | 4
            r21 = r1
            r22 = r17
            r23 = r18
            r24 = r19
            r25 = r6
            r26 = r29
            int r4 = com.google.android.gms.internal.gtm.zzsm.zzc(r21, r22, r23, r24, r25, r26)
            java.lang.Object r8 = r7.zzc
            r12.add(r8)
            goto L_0x042d
        L_0x005c:
            if (r6 != r14) goto L_0x0080
            com.google.android.gms.internal.gtm.zzvz r12 = (com.google.android.gms.internal.gtm.zzvz) r12
            int r1 = com.google.android.gms.internal.gtm.zzsm.zzj(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x0067:
            if (r1 >= r2) goto L_0x0077
            int r1 = com.google.android.gms.internal.gtm.zzsm.zzm(r3, r1, r7)
            long r4 = r7.zzb
            long r4 = com.google.android.gms.internal.gtm.zztj.zzt(r4)
            r12.zzf(r4)
            goto L_0x0067
        L_0x0077:
            if (r1 != r2) goto L_0x007b
            goto L_0x0450
        L_0x007b:
            com.google.android.gms.internal.gtm.zzvk r1 = com.google.android.gms.internal.gtm.zzvk.zzj()
            throw r1
        L_0x0080:
            if (r6 != 0) goto L_0x044f
            com.google.android.gms.internal.gtm.zzvz r12 = (com.google.android.gms.internal.gtm.zzvz) r12
            int r1 = com.google.android.gms.internal.gtm.zzsm.zzm(r3, r4, r7)
            long r8 = r7.zzb
            long r8 = com.google.android.gms.internal.gtm.zztj.zzt(r8)
            r12.zzf(r8)
        L_0x0091:
            if (r1 >= r5) goto L_0x00aa
            int r4 = com.google.android.gms.internal.gtm.zzsm.zzj(r3, r1, r7)
            int r6 = r7.zza
            if (r2 == r6) goto L_0x009c
            goto L_0x00aa
        L_0x009c:
            int r1 = com.google.android.gms.internal.gtm.zzsm.zzm(r3, r4, r7)
            long r8 = r7.zzb
            long r8 = com.google.android.gms.internal.gtm.zztj.zzt(r8)
            r12.zzf(r8)
            goto L_0x0091
        L_0x00aa:
            return r1
        L_0x00ab:
            if (r6 != r14) goto L_0x00cf
            com.google.android.gms.internal.gtm.zzva r12 = (com.google.android.gms.internal.gtm.zzva) r12
            int r1 = com.google.android.gms.internal.gtm.zzsm.zzj(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x00b6:
            if (r1 >= r2) goto L_0x00c6
            int r1 = com.google.android.gms.internal.gtm.zzsm.zzj(r3, r1, r7)
            int r4 = r7.zza
            int r4 = com.google.android.gms.internal.gtm.zztj.zzs(r4)
            r12.zzh(r4)
            goto L_0x00b6
        L_0x00c6:
            if (r1 != r2) goto L_0x00ca
            goto L_0x0450
        L_0x00ca:
            com.google.android.gms.internal.gtm.zzvk r1 = com.google.android.gms.internal.gtm.zzvk.zzj()
            throw r1
        L_0x00cf:
            if (r6 != 0) goto L_0x044f
            com.google.android.gms.internal.gtm.zzva r12 = (com.google.android.gms.internal.gtm.zzva) r12
            int r1 = com.google.android.gms.internal.gtm.zzsm.zzj(r3, r4, r7)
            int r4 = r7.zza
            int r4 = com.google.android.gms.internal.gtm.zztj.zzs(r4)
            r12.zzh(r4)
        L_0x00e0:
            if (r1 >= r5) goto L_0x00f9
            int r4 = com.google.android.gms.internal.gtm.zzsm.zzj(r3, r1, r7)
            int r6 = r7.zza
            if (r2 == r6) goto L_0x00eb
            goto L_0x00f9
        L_0x00eb:
            int r1 = com.google.android.gms.internal.gtm.zzsm.zzj(r3, r4, r7)
            int r4 = r7.zza
            int r4 = com.google.android.gms.internal.gtm.zztj.zzs(r4)
            r12.zzh(r4)
            goto L_0x00e0
        L_0x00f9:
            return r1
        L_0x00fa:
            if (r6 != r14) goto L_0x0101
            int r2 = com.google.android.gms.internal.gtm.zzsm.zzf(r3, r4, r12, r7)
            goto L_0x0112
        L_0x0101:
            if (r6 != 0) goto L_0x044f
            r2 = r20
            r3 = r17
            r4 = r18
            r5 = r19
            r6 = r12
            r7 = r29
            int r2 = com.google.android.gms.internal.gtm.zzsm.zzl(r2, r3, r4, r5, r6, r7)
        L_0x0112:
            com.google.android.gms.internal.gtm.zzuz r1 = (com.google.android.gms.internal.gtm.zzuz) r1
            com.google.android.gms.internal.gtm.zzxp r3 = r1.zzc
            com.google.android.gms.internal.gtm.zzxp r4 = com.google.android.gms.internal.gtm.zzxp.zzc()
            if (r3 != r4) goto L_0x011d
            r3 = 0
        L_0x011d:
            com.google.android.gms.internal.gtm.zzvd r4 = r15.zzE(r8)
            com.google.android.gms.internal.gtm.zzxo<?, ?> r5 = r0.zzo
            r6 = r21
            java.lang.Object r3 = com.google.android.gms.internal.gtm.zzwz.zzC(r6, r12, r4, r3, r5)
            if (r3 != 0) goto L_0x012d
            goto L_0x027b
        L_0x012d:
            com.google.android.gms.internal.gtm.zzxp r3 = (com.google.android.gms.internal.gtm.zzxp) r3
            r1.zzc = r3
            return r2
        L_0x0132:
            if (r6 != r14) goto L_0x044f
            int r1 = com.google.android.gms.internal.gtm.zzsm.zzj(r3, r4, r7)
            int r4 = r7.zza
            if (r4 < 0) goto L_0x0187
            int r6 = r3.length
            int r6 = r6 - r1
            if (r4 > r6) goto L_0x0182
            if (r4 != 0) goto L_0x0148
            com.google.android.gms.internal.gtm.zztd r4 = com.google.android.gms.internal.gtm.zztd.zzb
            r12.add(r4)
            goto L_0x0150
        L_0x0148:
            com.google.android.gms.internal.gtm.zztd r6 = com.google.android.gms.internal.gtm.zztd.zzn(r3, r1, r4)
            r12.add(r6)
        L_0x014f:
            int r1 = r1 + r4
        L_0x0150:
            if (r1 >= r5) goto L_0x0181
            int r4 = com.google.android.gms.internal.gtm.zzsm.zzj(r3, r1, r7)
            int r6 = r7.zza
            if (r2 == r6) goto L_0x015b
            goto L_0x0181
        L_0x015b:
            int r1 = com.google.android.gms.internal.gtm.zzsm.zzj(r3, r4, r7)
            int r4 = r7.zza
            if (r4 < 0) goto L_0x017c
            int r6 = r3.length
            int r6 = r6 - r1
            if (r4 > r6) goto L_0x0177
            if (r4 != 0) goto L_0x016f
            com.google.android.gms.internal.gtm.zztd r4 = com.google.android.gms.internal.gtm.zztd.zzb
            r12.add(r4)
            goto L_0x0150
        L_0x016f:
            com.google.android.gms.internal.gtm.zztd r6 = com.google.android.gms.internal.gtm.zztd.zzn(r3, r1, r4)
            r12.add(r6)
            goto L_0x014f
        L_0x0177:
            com.google.android.gms.internal.gtm.zzvk r1 = com.google.android.gms.internal.gtm.zzvk.zzj()
            throw r1
        L_0x017c:
            com.google.android.gms.internal.gtm.zzvk r1 = com.google.android.gms.internal.gtm.zzvk.zzf()
            throw r1
        L_0x0181:
            return r1
        L_0x0182:
            com.google.android.gms.internal.gtm.zzvk r1 = com.google.android.gms.internal.gtm.zzvk.zzj()
            throw r1
        L_0x0187:
            com.google.android.gms.internal.gtm.zzvk r1 = com.google.android.gms.internal.gtm.zzvk.zzf()
            throw r1
        L_0x018c:
            if (r6 == r14) goto L_0x0190
            goto L_0x044f
        L_0x0190:
            com.google.android.gms.internal.gtm.zzwx r1 = r15.zzF(r8)
            r21 = r1
            r22 = r20
            r23 = r17
            r24 = r18
            r25 = r19
            r26 = r12
            r27 = r29
            int r1 = com.google.android.gms.internal.gtm.zzsm.zze(r21, r22, r23, r24, r25, r26, r27)
            return r1
        L_0x01a7:
            if (r6 != r14) goto L_0x044f
            r8 = 536870912(0x20000000, double:2.652494739E-315)
            long r8 = r24 & r8
            int r1 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            java.lang.String r6 = ""
            if (r1 != 0) goto L_0x01fa
            int r1 = com.google.android.gms.internal.gtm.zzsm.zzj(r3, r4, r7)
            int r4 = r7.zza
            if (r4 < 0) goto L_0x01f5
            if (r4 != 0) goto L_0x01c2
            r12.add(r6)
            goto L_0x01cd
        L_0x01c2:
            java.lang.String r8 = new java.lang.String
            java.nio.charset.Charset r9 = com.google.android.gms.internal.gtm.zzvi.zza
            r8.<init>(r3, r1, r4, r9)
            r12.add(r8)
        L_0x01cc:
            int r1 = r1 + r4
        L_0x01cd:
            if (r1 >= r5) goto L_0x0450
            int r4 = com.google.android.gms.internal.gtm.zzsm.zzj(r3, r1, r7)
            int r8 = r7.zza
            if (r2 != r8) goto L_0x0450
            int r1 = com.google.android.gms.internal.gtm.zzsm.zzj(r3, r4, r7)
            int r4 = r7.zza
            if (r4 < 0) goto L_0x01f0
            if (r4 != 0) goto L_0x01e5
            r12.add(r6)
            goto L_0x01cd
        L_0x01e5:
            java.lang.String r8 = new java.lang.String
            java.nio.charset.Charset r9 = com.google.android.gms.internal.gtm.zzvi.zza
            r8.<init>(r3, r1, r4, r9)
            r12.add(r8)
            goto L_0x01cc
        L_0x01f0:
            com.google.android.gms.internal.gtm.zzvk r1 = com.google.android.gms.internal.gtm.zzvk.zzf()
            throw r1
        L_0x01f5:
            com.google.android.gms.internal.gtm.zzvk r1 = com.google.android.gms.internal.gtm.zzvk.zzf()
            throw r1
        L_0x01fa:
            int r1 = com.google.android.gms.internal.gtm.zzsm.zzj(r3, r4, r7)
            int r4 = r7.zza
            if (r4 < 0) goto L_0x0255
            if (r4 != 0) goto L_0x0208
            r12.add(r6)
            goto L_0x021b
        L_0x0208:
            int r8 = r1 + r4
            boolean r9 = com.google.android.gms.internal.gtm.zzyd.zzf(r3, r1, r8)
            if (r9 == 0) goto L_0x0250
            java.lang.String r9 = new java.lang.String
            java.nio.charset.Charset r10 = com.google.android.gms.internal.gtm.zzvi.zza
            r9.<init>(r3, r1, r4, r10)
            r12.add(r9)
        L_0x021a:
            r1 = r8
        L_0x021b:
            if (r1 >= r5) goto L_0x0450
            int r4 = com.google.android.gms.internal.gtm.zzsm.zzj(r3, r1, r7)
            int r8 = r7.zza
            if (r2 != r8) goto L_0x0450
            int r1 = com.google.android.gms.internal.gtm.zzsm.zzj(r3, r4, r7)
            int r4 = r7.zza
            if (r4 < 0) goto L_0x024b
            if (r4 != 0) goto L_0x0233
            r12.add(r6)
            goto L_0x021b
        L_0x0233:
            int r8 = r1 + r4
            boolean r9 = com.google.android.gms.internal.gtm.zzyd.zzf(r3, r1, r8)
            if (r9 == 0) goto L_0x0246
            java.lang.String r9 = new java.lang.String
            java.nio.charset.Charset r10 = com.google.android.gms.internal.gtm.zzvi.zza
            r9.<init>(r3, r1, r4, r10)
            r12.add(r9)
            goto L_0x021a
        L_0x0246:
            com.google.android.gms.internal.gtm.zzvk r1 = com.google.android.gms.internal.gtm.zzvk.zzd()
            throw r1
        L_0x024b:
            com.google.android.gms.internal.gtm.zzvk r1 = com.google.android.gms.internal.gtm.zzvk.zzf()
            throw r1
        L_0x0250:
            com.google.android.gms.internal.gtm.zzvk r1 = com.google.android.gms.internal.gtm.zzvk.zzd()
            throw r1
        L_0x0255:
            com.google.android.gms.internal.gtm.zzvk r1 = com.google.android.gms.internal.gtm.zzvk.zzf()
            throw r1
        L_0x025a:
            r1 = 0
            if (r6 != r14) goto L_0x0283
            com.google.android.gms.internal.gtm.zzsr r12 = (com.google.android.gms.internal.gtm.zzsr) r12
            int r2 = com.google.android.gms.internal.gtm.zzsm.zzj(r3, r4, r7)
            int r4 = r7.zza
            int r4 = r4 + r2
        L_0x0266:
            if (r2 >= r4) goto L_0x0279
            int r2 = com.google.android.gms.internal.gtm.zzsm.zzm(r3, r2, r7)
            long r5 = r7.zzb
            int r5 = (r5 > r10 ? 1 : (r5 == r10 ? 0 : -1))
            if (r5 == 0) goto L_0x0274
            r5 = r13
            goto L_0x0275
        L_0x0274:
            r5 = r1
        L_0x0275:
            r12.zze(r5)
            goto L_0x0266
        L_0x0279:
            if (r2 != r4) goto L_0x027e
        L_0x027b:
            r1 = r2
            goto L_0x0450
        L_0x027e:
            com.google.android.gms.internal.gtm.zzvk r1 = com.google.android.gms.internal.gtm.zzvk.zzj()
            throw r1
        L_0x0283:
            if (r6 != 0) goto L_0x044f
            com.google.android.gms.internal.gtm.zzsr r12 = (com.google.android.gms.internal.gtm.zzsr) r12
            int r4 = com.google.android.gms.internal.gtm.zzsm.zzm(r3, r4, r7)
            long r8 = r7.zzb
            int r6 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r6 == 0) goto L_0x0293
            r6 = r13
            goto L_0x0294
        L_0x0293:
            r6 = r1
        L_0x0294:
            r12.zze(r6)
        L_0x0297:
            if (r4 >= r5) goto L_0x02b3
            int r6 = com.google.android.gms.internal.gtm.zzsm.zzj(r3, r4, r7)
            int r8 = r7.zza
            if (r2 == r8) goto L_0x02a2
            goto L_0x02b3
        L_0x02a2:
            int r4 = com.google.android.gms.internal.gtm.zzsm.zzm(r3, r6, r7)
            long r8 = r7.zzb
            int r6 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r6 == 0) goto L_0x02ae
            r6 = r13
            goto L_0x02af
        L_0x02ae:
            r6 = r1
        L_0x02af:
            r12.zze(r6)
            goto L_0x0297
        L_0x02b3:
            return r4
        L_0x02b4:
            if (r6 != r14) goto L_0x02d4
            com.google.android.gms.internal.gtm.zzva r12 = (com.google.android.gms.internal.gtm.zzva) r12
            int r1 = com.google.android.gms.internal.gtm.zzsm.zzj(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x02bf:
            if (r1 >= r2) goto L_0x02cb
            int r4 = com.google.android.gms.internal.gtm.zzsm.zzb(r3, r1)
            r12.zzh(r4)
            int r1 = r1 + 4
            goto L_0x02bf
        L_0x02cb:
            if (r1 != r2) goto L_0x02cf
            goto L_0x0450
        L_0x02cf:
            com.google.android.gms.internal.gtm.zzvk r1 = com.google.android.gms.internal.gtm.zzvk.zzj()
            throw r1
        L_0x02d4:
            if (r6 != r9) goto L_0x044f
            com.google.android.gms.internal.gtm.zzva r12 = (com.google.android.gms.internal.gtm.zzva) r12
            int r1 = com.google.android.gms.internal.gtm.zzsm.zzb(r17, r18)
            r12.zzh(r1)
        L_0x02df:
            int r1 = r4 + 4
            if (r1 >= r5) goto L_0x02f4
            int r4 = com.google.android.gms.internal.gtm.zzsm.zzj(r3, r1, r7)
            int r6 = r7.zza
            if (r2 == r6) goto L_0x02ec
            goto L_0x02f4
        L_0x02ec:
            int r1 = com.google.android.gms.internal.gtm.zzsm.zzb(r3, r4)
            r12.zzh(r1)
            goto L_0x02df
        L_0x02f4:
            return r1
        L_0x02f5:
            if (r6 != r14) goto L_0x0315
            com.google.android.gms.internal.gtm.zzvz r12 = (com.google.android.gms.internal.gtm.zzvz) r12
            int r1 = com.google.android.gms.internal.gtm.zzsm.zzj(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x0300:
            if (r1 >= r2) goto L_0x030c
            long r4 = com.google.android.gms.internal.gtm.zzsm.zzo(r3, r1)
            r12.zzf(r4)
            int r1 = r1 + 8
            goto L_0x0300
        L_0x030c:
            if (r1 != r2) goto L_0x0310
            goto L_0x0450
        L_0x0310:
            com.google.android.gms.internal.gtm.zzvk r1 = com.google.android.gms.internal.gtm.zzvk.zzj()
            throw r1
        L_0x0315:
            if (r6 != r13) goto L_0x044f
            com.google.android.gms.internal.gtm.zzvz r12 = (com.google.android.gms.internal.gtm.zzvz) r12
            long r8 = com.google.android.gms.internal.gtm.zzsm.zzo(r17, r18)
            r12.zzf(r8)
        L_0x0320:
            int r1 = r4 + 8
            if (r1 >= r5) goto L_0x0335
            int r4 = com.google.android.gms.internal.gtm.zzsm.zzj(r3, r1, r7)
            int r6 = r7.zza
            if (r2 == r6) goto L_0x032d
            goto L_0x0335
        L_0x032d:
            long r8 = com.google.android.gms.internal.gtm.zzsm.zzo(r3, r4)
            r12.zzf(r8)
            goto L_0x0320
        L_0x0335:
            return r1
        L_0x0336:
            if (r6 != r14) goto L_0x033e
            int r1 = com.google.android.gms.internal.gtm.zzsm.zzf(r3, r4, r12, r7)
            goto L_0x0450
        L_0x033e:
            if (r6 == 0) goto L_0x0342
            goto L_0x044f
        L_0x0342:
            r21 = r17
            r22 = r18
            r23 = r19
            r24 = r12
            r25 = r29
            int r1 = com.google.android.gms.internal.gtm.zzsm.zzl(r20, r21, r22, r23, r24, r25)
            return r1
        L_0x0351:
            if (r6 != r14) goto L_0x0371
            com.google.android.gms.internal.gtm.zzvz r12 = (com.google.android.gms.internal.gtm.zzvz) r12
            int r1 = com.google.android.gms.internal.gtm.zzsm.zzj(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x035c:
            if (r1 >= r2) goto L_0x0368
            int r1 = com.google.android.gms.internal.gtm.zzsm.zzm(r3, r1, r7)
            long r4 = r7.zzb
            r12.zzf(r4)
            goto L_0x035c
        L_0x0368:
            if (r1 != r2) goto L_0x036c
            goto L_0x0450
        L_0x036c:
            com.google.android.gms.internal.gtm.zzvk r1 = com.google.android.gms.internal.gtm.zzvk.zzj()
            throw r1
        L_0x0371:
            if (r6 != 0) goto L_0x044f
            com.google.android.gms.internal.gtm.zzvz r12 = (com.google.android.gms.internal.gtm.zzvz) r12
            int r1 = com.google.android.gms.internal.gtm.zzsm.zzm(r3, r4, r7)
            long r8 = r7.zzb
            r12.zzf(r8)
        L_0x037e:
            if (r1 >= r5) goto L_0x0393
            int r4 = com.google.android.gms.internal.gtm.zzsm.zzj(r3, r1, r7)
            int r6 = r7.zza
            if (r2 == r6) goto L_0x0389
            goto L_0x0393
        L_0x0389:
            int r1 = com.google.android.gms.internal.gtm.zzsm.zzm(r3, r4, r7)
            long r8 = r7.zzb
            r12.zzf(r8)
            goto L_0x037e
        L_0x0393:
            return r1
        L_0x0394:
            if (r6 != r14) goto L_0x03b8
            com.google.android.gms.internal.gtm.zzuq r12 = (com.google.android.gms.internal.gtm.zzuq) r12
            int r1 = com.google.android.gms.internal.gtm.zzsm.zzj(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x039f:
            if (r1 >= r2) goto L_0x03af
            int r4 = com.google.android.gms.internal.gtm.zzsm.zzb(r3, r1)
            float r4 = java.lang.Float.intBitsToFloat(r4)
            r12.zze(r4)
            int r1 = r1 + 4
            goto L_0x039f
        L_0x03af:
            if (r1 != r2) goto L_0x03b3
            goto L_0x0450
        L_0x03b3:
            com.google.android.gms.internal.gtm.zzvk r1 = com.google.android.gms.internal.gtm.zzvk.zzj()
            throw r1
        L_0x03b8:
            if (r6 != r9) goto L_0x044f
            com.google.android.gms.internal.gtm.zzuq r12 = (com.google.android.gms.internal.gtm.zzuq) r12
            int r1 = com.google.android.gms.internal.gtm.zzsm.zzb(r17, r18)
            float r1 = java.lang.Float.intBitsToFloat(r1)
            r12.zze(r1)
        L_0x03c7:
            int r1 = r4 + 4
            if (r1 >= r5) goto L_0x03e0
            int r4 = com.google.android.gms.internal.gtm.zzsm.zzj(r3, r1, r7)
            int r6 = r7.zza
            if (r2 == r6) goto L_0x03d4
            goto L_0x03e0
        L_0x03d4:
            int r1 = com.google.android.gms.internal.gtm.zzsm.zzb(r3, r4)
            float r1 = java.lang.Float.intBitsToFloat(r1)
            r12.zze(r1)
            goto L_0x03c7
        L_0x03e0:
            return r1
        L_0x03e1:
            if (r6 != r14) goto L_0x0404
            com.google.android.gms.internal.gtm.zzug r12 = (com.google.android.gms.internal.gtm.zzug) r12
            int r1 = com.google.android.gms.internal.gtm.zzsm.zzj(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x03ec:
            if (r1 >= r2) goto L_0x03fc
            long r4 = com.google.android.gms.internal.gtm.zzsm.zzo(r3, r1)
            double r4 = java.lang.Double.longBitsToDouble(r4)
            r12.zze(r4)
            int r1 = r1 + 8
            goto L_0x03ec
        L_0x03fc:
            if (r1 != r2) goto L_0x03ff
            goto L_0x0450
        L_0x03ff:
            com.google.android.gms.internal.gtm.zzvk r1 = com.google.android.gms.internal.gtm.zzvk.zzj()
            throw r1
        L_0x0404:
            if (r6 != r13) goto L_0x044f
            com.google.android.gms.internal.gtm.zzug r12 = (com.google.android.gms.internal.gtm.zzug) r12
            long r8 = com.google.android.gms.internal.gtm.zzsm.zzo(r17, r18)
            double r8 = java.lang.Double.longBitsToDouble(r8)
            r12.zze(r8)
        L_0x0413:
            int r1 = r4 + 8
            if (r1 >= r5) goto L_0x042c
            int r4 = com.google.android.gms.internal.gtm.zzsm.zzj(r3, r1, r7)
            int r6 = r7.zza
            if (r2 == r6) goto L_0x0420
            goto L_0x042c
        L_0x0420:
            long r8 = com.google.android.gms.internal.gtm.zzsm.zzo(r3, r4)
            double r8 = java.lang.Double.longBitsToDouble(r8)
            r12.zze(r8)
            goto L_0x0413
        L_0x042c:
            return r1
        L_0x042d:
            if (r4 >= r5) goto L_0x044e
            int r8 = com.google.android.gms.internal.gtm.zzsm.zzj(r3, r4, r7)
            int r9 = r7.zza
            if (r2 == r9) goto L_0x0438
            goto L_0x044e
        L_0x0438:
            r21 = r1
            r22 = r17
            r23 = r8
            r24 = r19
            r25 = r6
            r26 = r29
            int r4 = com.google.android.gms.internal.gtm.zzsm.zzc(r21, r22, r23, r24, r25, r26)
            java.lang.Object r8 = r7.zzc
            r12.add(r8)
            goto L_0x042d
        L_0x044e:
            return r4
        L_0x044f:
            r1 = r4
        L_0x0450:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.gtm.zzwn.zzw(java.lang.Object, byte[], int, int, int, int, int, int, long, int, long, com.google.android.gms.internal.gtm.zzsl):int");
    }

    private final int zzx(int i10) {
        if (i10 < this.zze || i10 > this.zzf) {
            return -1;
        }
        return zzA(i10, 0);
    }

    private final int zzy(int i10, int i11) {
        if (i10 < this.zze || i10 > this.zzf) {
            return -1;
        }
        return zzA(i10, i11);
    }

    private final int zzz(int i10) {
        return this.zzc[i10 + 2];
    }

    public final int zza(T t10) {
        return this.zzj ? zzr(t10) : zzq(t10);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x01c2, code lost:
        r2 = (r2 * 53) + r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x0226, code lost:
        r2 = r2 + r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x0227, code lost:
        r1 = r1 + 3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zzb(T r9) {
        /*
            r8 = this;
            int[] r0 = r8.zzc
            int r0 = r0.length
            r1 = 0
            r2 = r1
        L_0x0005:
            if (r1 >= r0) goto L_0x022b
            int r3 = r8.zzC(r1)
            int[] r4 = r8.zzc
            r4 = r4[r1]
            r5 = 1048575(0xfffff, float:1.469367E-39)
            r5 = r5 & r3
            long r5 = (long) r5
            int r3 = zzB(r3)
            r7 = 37
            switch(r3) {
                case 0: goto L_0x0218;
                case 1: goto L_0x020d;
                case 2: goto L_0x0202;
                case 3: goto L_0x01f7;
                case 4: goto L_0x01f0;
                case 5: goto L_0x01e5;
                case 6: goto L_0x01de;
                case 7: goto L_0x01d3;
                case 8: goto L_0x01c6;
                case 9: goto L_0x01b8;
                case 10: goto L_0x01ac;
                case 11: goto L_0x01a4;
                case 12: goto L_0x019c;
                case 13: goto L_0x0194;
                case 14: goto L_0x0188;
                case 15: goto L_0x0180;
                case 16: goto L_0x0174;
                case 17: goto L_0x0169;
                case 18: goto L_0x015d;
                case 19: goto L_0x015d;
                case 20: goto L_0x015d;
                case 21: goto L_0x015d;
                case 22: goto L_0x015d;
                case 23: goto L_0x015d;
                case 24: goto L_0x015d;
                case 25: goto L_0x015d;
                case 26: goto L_0x015d;
                case 27: goto L_0x015d;
                case 28: goto L_0x015d;
                case 29: goto L_0x015d;
                case 30: goto L_0x015d;
                case 31: goto L_0x015d;
                case 32: goto L_0x015d;
                case 33: goto L_0x015d;
                case 34: goto L_0x015d;
                case 35: goto L_0x015d;
                case 36: goto L_0x015d;
                case 37: goto L_0x015d;
                case 38: goto L_0x015d;
                case 39: goto L_0x015d;
                case 40: goto L_0x015d;
                case 41: goto L_0x015d;
                case 42: goto L_0x015d;
                case 43: goto L_0x015d;
                case 44: goto L_0x015d;
                case 45: goto L_0x015d;
                case 46: goto L_0x015d;
                case 47: goto L_0x015d;
                case 48: goto L_0x015d;
                case 49: goto L_0x015d;
                case 50: goto L_0x0151;
                case 51: goto L_0x013b;
                case 52: goto L_0x0129;
                case 53: goto L_0x0117;
                case 54: goto L_0x0105;
                case 55: goto L_0x00f7;
                case 56: goto L_0x00e5;
                case 57: goto L_0x00d7;
                case 58: goto L_0x00c5;
                case 59: goto L_0x00b1;
                case 60: goto L_0x009f;
                case 61: goto L_0x008d;
                case 62: goto L_0x007f;
                case 63: goto L_0x0071;
                case 64: goto L_0x0063;
                case 65: goto L_0x0051;
                case 66: goto L_0x0043;
                case 67: goto L_0x0031;
                case 68: goto L_0x001f;
                default: goto L_0x001d;
            }
        L_0x001d:
            goto L_0x0227
        L_0x001f:
            boolean r3 = r8.zzT(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.gtm.zzxy.zzf(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0226
        L_0x0031:
            boolean r3 = r8.zzT(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            long r3 = zzD(r9, r5)
            int r3 = com.google.android.gms.internal.gtm.zzvi.zzc(r3)
            goto L_0x0226
        L_0x0043:
            boolean r3 = r8.zzT(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            int r3 = zzs(r9, r5)
            goto L_0x0226
        L_0x0051:
            boolean r3 = r8.zzT(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            long r3 = zzD(r9, r5)
            int r3 = com.google.android.gms.internal.gtm.zzvi.zzc(r3)
            goto L_0x0226
        L_0x0063:
            boolean r3 = r8.zzT(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            int r3 = zzs(r9, r5)
            goto L_0x0226
        L_0x0071:
            boolean r3 = r8.zzT(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            int r3 = zzs(r9, r5)
            goto L_0x0226
        L_0x007f:
            boolean r3 = r8.zzT(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            int r3 = zzs(r9, r5)
            goto L_0x0226
        L_0x008d:
            boolean r3 = r8.zzT(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.gtm.zzxy.zzf(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0226
        L_0x009f:
            boolean r3 = r8.zzT(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.gtm.zzxy.zzf(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0226
        L_0x00b1:
            boolean r3 = r8.zzT(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.gtm.zzxy.zzf(r9, r5)
            java.lang.String r3 = (java.lang.String) r3
            int r3 = r3.hashCode()
            goto L_0x0226
        L_0x00c5:
            boolean r3 = r8.zzT(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            boolean r3 = zzU(r9, r5)
            int r3 = com.google.android.gms.internal.gtm.zzvi.zza(r3)
            goto L_0x0226
        L_0x00d7:
            boolean r3 = r8.zzT(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            int r3 = zzs(r9, r5)
            goto L_0x0226
        L_0x00e5:
            boolean r3 = r8.zzT(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            long r3 = zzD(r9, r5)
            int r3 = com.google.android.gms.internal.gtm.zzvi.zzc(r3)
            goto L_0x0226
        L_0x00f7:
            boolean r3 = r8.zzT(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            int r3 = zzs(r9, r5)
            goto L_0x0226
        L_0x0105:
            boolean r3 = r8.zzT(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            long r3 = zzD(r9, r5)
            int r3 = com.google.android.gms.internal.gtm.zzvi.zzc(r3)
            goto L_0x0226
        L_0x0117:
            boolean r3 = r8.zzT(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            long r3 = zzD(r9, r5)
            int r3 = com.google.android.gms.internal.gtm.zzvi.zzc(r3)
            goto L_0x0226
        L_0x0129:
            boolean r3 = r8.zzT(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            float r3 = zzp(r9, r5)
            int r3 = java.lang.Float.floatToIntBits(r3)
            goto L_0x0226
        L_0x013b:
            boolean r3 = r8.zzT(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            double r3 = zzo(r9, r5)
            long r3 = java.lang.Double.doubleToLongBits(r3)
            int r3 = com.google.android.gms.internal.gtm.zzvi.zzc(r3)
            goto L_0x0226
        L_0x0151:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.gtm.zzxy.zzf(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0226
        L_0x015d:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.gtm.zzxy.zzf(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0226
        L_0x0169:
            java.lang.Object r3 = com.google.android.gms.internal.gtm.zzxy.zzf(r9, r5)
            if (r3 == 0) goto L_0x01c2
            int r7 = r3.hashCode()
            goto L_0x01c2
        L_0x0174:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.gtm.zzxy.zzd(r9, r5)
            int r3 = com.google.android.gms.internal.gtm.zzvi.zzc(r3)
            goto L_0x0226
        L_0x0180:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.gtm.zzxy.zzc(r9, r5)
            goto L_0x0226
        L_0x0188:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.gtm.zzxy.zzd(r9, r5)
            int r3 = com.google.android.gms.internal.gtm.zzvi.zzc(r3)
            goto L_0x0226
        L_0x0194:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.gtm.zzxy.zzc(r9, r5)
            goto L_0x0226
        L_0x019c:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.gtm.zzxy.zzc(r9, r5)
            goto L_0x0226
        L_0x01a4:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.gtm.zzxy.zzc(r9, r5)
            goto L_0x0226
        L_0x01ac:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.gtm.zzxy.zzf(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0226
        L_0x01b8:
            java.lang.Object r3 = com.google.android.gms.internal.gtm.zzxy.zzf(r9, r5)
            if (r3 == 0) goto L_0x01c2
            int r7 = r3.hashCode()
        L_0x01c2:
            int r2 = r2 * 53
            int r2 = r2 + r7
            goto L_0x0227
        L_0x01c6:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.gtm.zzxy.zzf(r9, r5)
            java.lang.String r3 = (java.lang.String) r3
            int r3 = r3.hashCode()
            goto L_0x0226
        L_0x01d3:
            int r2 = r2 * 53
            boolean r3 = com.google.android.gms.internal.gtm.zzxy.zzw(r9, r5)
            int r3 = com.google.android.gms.internal.gtm.zzvi.zza(r3)
            goto L_0x0226
        L_0x01de:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.gtm.zzxy.zzc(r9, r5)
            goto L_0x0226
        L_0x01e5:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.gtm.zzxy.zzd(r9, r5)
            int r3 = com.google.android.gms.internal.gtm.zzvi.zzc(r3)
            goto L_0x0226
        L_0x01f0:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.gtm.zzxy.zzc(r9, r5)
            goto L_0x0226
        L_0x01f7:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.gtm.zzxy.zzd(r9, r5)
            int r3 = com.google.android.gms.internal.gtm.zzvi.zzc(r3)
            goto L_0x0226
        L_0x0202:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.gtm.zzxy.zzd(r9, r5)
            int r3 = com.google.android.gms.internal.gtm.zzvi.zzc(r3)
            goto L_0x0226
        L_0x020d:
            int r2 = r2 * 53
            float r3 = com.google.android.gms.internal.gtm.zzxy.zzb(r9, r5)
            int r3 = java.lang.Float.floatToIntBits(r3)
            goto L_0x0226
        L_0x0218:
            int r2 = r2 * 53
            double r3 = com.google.android.gms.internal.gtm.zzxy.zza(r9, r5)
            long r3 = java.lang.Double.doubleToLongBits(r3)
            int r3 = com.google.android.gms.internal.gtm.zzvi.zzc(r3)
        L_0x0226:
            int r2 = r2 + r3
        L_0x0227:
            int r1 = r1 + 3
            goto L_0x0005
        L_0x022b:
            int r2 = r2 * 53
            com.google.android.gms.internal.gtm.zzxo<?, ?> r0 = r8.zzo
            java.lang.Object r0 = r0.zzd(r9)
            int r0 = r0.hashCode()
            int r2 = r2 + r0
            boolean r0 = r8.zzh
            if (r0 == 0) goto L_0x024b
            int r2 = r2 * 53
            com.google.android.gms.internal.gtm.zzuk<?> r0 = r8.zzp
            com.google.android.gms.internal.gtm.zzuo r9 = r0.zzb(r9)
            com.google.android.gms.internal.gtm.zzxk<T, java.lang.Object> r9 = r9.zza
            int r9 = r9.hashCode()
            int r2 = r2 + r9
        L_0x024b:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.gtm.zzwn.zzb(java.lang.Object):int");
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:114:0x032d, code lost:
        if (r0 != r15) goto L_0x032f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x0349, code lost:
        r2 = r0;
        r6 = r23;
        r7 = r25;
        r0 = r36;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:122:0x037f, code lost:
        if (r0 != r15) goto L_0x032f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:125:0x03a4, code lost:
        if (r0 != r15) goto L_0x032f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:168:0x0522, code lost:
        r2 = r2 + 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:170:0x0535, code lost:
        r2 = r2 + 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x01bd, code lost:
        r5 = r6 | r27;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x01c1, code lost:
        r17 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x0237, code lost:
        r17 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x0239, code lost:
        r1 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x0251, code lost:
        r0 = r13 + 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x0253, code lost:
        r5 = r6 | r27;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x0255, code lost:
        r13 = r35;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x0257, code lost:
        r6 = r7;
        r3 = r8;
        r1 = r11;
        r2 = r26;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x025c, code lost:
        r11 = r36;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x0260, code lost:
        r17 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x0275, code lost:
        r0 = r36;
        r18 = r1;
        r22 = r6;
        r6 = r7;
        r29 = r10;
        r7 = r11;
        r2 = r17;
        r34 = r26;
        r26 = r21;
        r21 = r8;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zzc(T r32, byte[] r33, int r34, int r35, int r36, com.google.android.gms.internal.gtm.zzsl r37) throws java.io.IOException {
        /*
            r31 = this;
            r15 = r31
            r14 = r32
            r12 = r33
            r13 = r35
            r11 = r36
            r9 = r37
            sun.misc.Unsafe r10 = zzb
            r16 = 0
            r0 = r34
            r1 = r16
            r3 = r1
            r5 = r3
            r2 = -1
            r6 = 1048575(0xfffff, float:1.469367E-39)
        L_0x001a:
            if (r0 >= r13) goto L_0x0592
            int r1 = r0 + 1
            byte r0 = r12[r0]
            if (r0 >= 0) goto L_0x0029
            int r0 = com.google.android.gms.internal.gtm.zzsm.zzk(r0, r12, r1, r9)
            int r1 = r9.zza
            goto L_0x002e
        L_0x0029:
            r30 = r1
            r1 = r0
            r0 = r30
        L_0x002e:
            int r7 = r1 >>> 3
            r8 = r1 & 7
            r4 = 3
            if (r7 <= r2) goto L_0x003b
            int r3 = r3 / r4
            int r2 = r15.zzy(r7, r3)
            goto L_0x003f
        L_0x003b:
            int r2 = r15.zzx(r7)
        L_0x003f:
            r19 = 0
            r4 = -1
            if (r2 != r4) goto L_0x0055
            r2 = r0
            r26 = r4
            r22 = r5
            r34 = r7
            r29 = r10
            r0 = r11
            r21 = r16
            r18 = 1
            r7 = r1
            goto L_0x03a7
        L_0x0055:
            int[] r3 = r15.zzc
            int r23 = r2 + 1
            r3 = r3[r23]
            int r11 = zzB(r3)
            r17 = 1048575(0xfffff, float:1.469367E-39)
            r4 = r3 & r17
            r24 = r3
            long r3 = (long) r4
            r25 = r1
            r1 = 17
            r26 = r7
            if (r11 > r1) goto L_0x0289
            int[] r1 = r15.zzc
            int r27 = r2 + 2
            r1 = r1[r27]
            int r27 = r1 >>> 20
            r22 = 1
            int r27 = r22 << r27
            r7 = 1048575(0xfffff, float:1.469367E-39)
            r1 = r1 & r7
            if (r1 == r6) goto L_0x0090
            r17 = r8
            if (r6 == r7) goto L_0x0089
            long r7 = (long) r6
            r10.putInt(r14, r7, r5)
        L_0x0089:
            long r5 = (long) r1
            int r5 = r10.getInt(r14, r5)
            r7 = r1
            goto L_0x0093
        L_0x0090:
            r17 = r8
            r7 = r6
        L_0x0093:
            r6 = r5
            r1 = 5
            switch(r11) {
                case 0: goto L_0x023b;
                case 1: goto L_0x021f;
                case 2: goto L_0x01f9;
                case 3: goto L_0x01f9;
                case 4: goto L_0x01e4;
                case 5: goto L_0x01c5;
                case 6: goto L_0x01ab;
                case 7: goto L_0x0190;
                case 8: goto L_0x0171;
                case 9: goto L_0x0147;
                case 10: goto L_0x0132;
                case 11: goto L_0x01e4;
                case 12: goto L_0x0104;
                case 13: goto L_0x01ab;
                case 14: goto L_0x01c5;
                case 15: goto L_0x00ee;
                case 16: goto L_0x00c4;
                default: goto L_0x0098;
            }
        L_0x0098:
            r13 = r0
            r8 = r2
            r2 = r17
            r11 = r25
            r0 = 3
            r1 = 1
            r21 = -1
            if (r2 != r0) goto L_0x0260
            com.google.android.gms.internal.gtm.zzwx r0 = r15.zzF(r8)
            int r1 = r26 << 3
            r5 = r1 | 4
            r1 = r33
            r2 = r13
            r12 = r3
            r3 = r35
            r4 = r5
            r5 = r37
            int r0 = com.google.android.gms.internal.gtm.zzsm.zzc(r0, r1, r2, r3, r4, r5)
            r1 = r6 & r27
            if (r1 != 0) goto L_0x0263
            java.lang.Object r1 = r9.zzc
            r10.putObject(r14, r12, r1)
            goto L_0x0270
        L_0x00c4:
            if (r17 != 0) goto L_0x00e7
            int r8 = com.google.android.gms.internal.gtm.zzsm.zzm(r12, r0, r9)
            long r0 = r9.zzb
            long r17 = com.google.android.gms.internal.gtm.zztj.zzt(r0)
            r0 = r10
            r11 = r25
            r1 = r32
            r5 = r2
            r2 = r3
            r34 = r8
            r21 = -1
            r8 = r5
            r4 = r17
            r0.putLong(r1, r2, r4)
            r5 = r6 | r27
            r0 = r34
            goto L_0x0257
        L_0x00e7:
            r8 = r2
            r11 = r25
            r21 = -1
            goto L_0x01c1
        L_0x00ee:
            r8 = r2
            r11 = r25
            r21 = -1
            if (r17 != 0) goto L_0x01c1
            int r0 = com.google.android.gms.internal.gtm.zzsm.zzj(r12, r0, r9)
            int r1 = r9.zza
            int r1 = com.google.android.gms.internal.gtm.zztj.zzs(r1)
            r10.putInt(r14, r3, r1)
            goto L_0x01bd
        L_0x0104:
            r8 = r2
            r11 = r25
            r21 = -1
            if (r17 != 0) goto L_0x01c1
            int r0 = com.google.android.gms.internal.gtm.zzsm.zzj(r12, r0, r9)
            int r1 = r9.zza
            com.google.android.gms.internal.gtm.zzvd r2 = r15.zzE(r8)
            if (r2 == 0) goto L_0x012d
            boolean r2 = r2.zza(r1)
            if (r2 == 0) goto L_0x011e
            goto L_0x012d
        L_0x011e:
            com.google.android.gms.internal.gtm.zzxp r2 = zzd(r32)
            long r3 = (long) r1
            java.lang.Long r1 = java.lang.Long.valueOf(r3)
            r2.zzh(r11, r1)
            r5 = r6
            goto L_0x0257
        L_0x012d:
            r10.putInt(r14, r3, r1)
            goto L_0x01bd
        L_0x0132:
            r8 = r2
            r2 = r17
            r11 = r25
            r1 = 2
            r21 = -1
            if (r2 != r1) goto L_0x01c1
            int r0 = com.google.android.gms.internal.gtm.zzsm.zza(r12, r0, r9)
            java.lang.Object r1 = r9.zzc
            r10.putObject(r14, r3, r1)
            goto L_0x01bd
        L_0x0147:
            r8 = r2
            r2 = r17
            r11 = r25
            r1 = 2
            r21 = -1
            if (r2 != r1) goto L_0x01c1
            com.google.android.gms.internal.gtm.zzwx r1 = r15.zzF(r8)
            int r0 = com.google.android.gms.internal.gtm.zzsm.zzd(r1, r12, r0, r13, r9)
            r1 = r6 & r27
            if (r1 != 0) goto L_0x0163
            java.lang.Object r1 = r9.zzc
            r10.putObject(r14, r3, r1)
            goto L_0x01bd
        L_0x0163:
            java.lang.Object r1 = r10.getObject(r14, r3)
            java.lang.Object r2 = r9.zzc
            java.lang.Object r1 = com.google.android.gms.internal.gtm.zzvi.zzg(r1, r2)
            r10.putObject(r14, r3, r1)
            goto L_0x01bd
        L_0x0171:
            r8 = r2
            r2 = r17
            r11 = r25
            r1 = 2
            r21 = -1
            if (r2 != r1) goto L_0x01c1
            r1 = 536870912(0x20000000, float:1.0842022E-19)
            r1 = r24 & r1
            if (r1 != 0) goto L_0x0186
            int r0 = com.google.android.gms.internal.gtm.zzsm.zzg(r12, r0, r9)
            goto L_0x018a
        L_0x0186:
            int r0 = com.google.android.gms.internal.gtm.zzsm.zzh(r12, r0, r9)
        L_0x018a:
            java.lang.Object r1 = r9.zzc
            r10.putObject(r14, r3, r1)
            goto L_0x01bd
        L_0x0190:
            r8 = r2
            r2 = r17
            r11 = r25
            r21 = -1
            if (r2 != 0) goto L_0x01c1
            int r0 = com.google.android.gms.internal.gtm.zzsm.zzm(r12, r0, r9)
            long r1 = r9.zzb
            int r1 = (r1 > r19 ? 1 : (r1 == r19 ? 0 : -1))
            if (r1 == 0) goto L_0x01a5
            r1 = 1
            goto L_0x01a7
        L_0x01a5:
            r1 = r16
        L_0x01a7:
            com.google.android.gms.internal.gtm.zzxy.zzm(r14, r3, r1)
            goto L_0x01bd
        L_0x01ab:
            r8 = r2
            r2 = r17
            r11 = r25
            r21 = -1
            if (r2 != r1) goto L_0x01c1
            int r1 = com.google.android.gms.internal.gtm.zzsm.zzb(r12, r0)
            r10.putInt(r14, r3, r1)
            int r0 = r0 + 4
        L_0x01bd:
            r5 = r6 | r27
            goto L_0x0257
        L_0x01c1:
            r17 = r0
            goto L_0x0239
        L_0x01c5:
            r8 = r2
            r2 = r17
            r11 = r25
            r1 = 1
            r21 = -1
            if (r2 != r1) goto L_0x01e0
            long r17 = com.google.android.gms.internal.gtm.zzsm.zzo(r12, r0)
            r5 = r0
            r0 = r10
            r1 = r32
            r2 = r3
            r13 = r5
            r4 = r17
            r0.putLong(r1, r2, r4)
            goto L_0x0251
        L_0x01e0:
            r17 = r0
            goto L_0x0275
        L_0x01e4:
            r13 = r0
            r8 = r2
            r2 = r17
            r11 = r25
            r21 = -1
            if (r2 != 0) goto L_0x0237
            int r0 = com.google.android.gms.internal.gtm.zzsm.zzj(r12, r13, r9)
            int r1 = r9.zza
            r10.putInt(r14, r3, r1)
            goto L_0x0253
        L_0x01f9:
            r13 = r0
            r8 = r2
            r2 = r17
            r11 = r25
            r21 = -1
            if (r2 != 0) goto L_0x0237
            int r13 = com.google.android.gms.internal.gtm.zzsm.zzm(r12, r13, r9)
            long r1 = r9.zzb
            r0 = r10
            r17 = r1
            r1 = r32
            r2 = r3
            r4 = r17
            r0.putLong(r1, r2, r4)
            r5 = r6 | r27
            r6 = r7
            r3 = r8
            r1 = r11
            r0 = r13
            r2 = r26
            r13 = r35
            goto L_0x025c
        L_0x021f:
            r13 = r0
            r8 = r2
            r2 = r17
            r11 = r25
            r21 = -1
            if (r2 != r1) goto L_0x0237
            int r0 = com.google.android.gms.internal.gtm.zzsm.zzb(r12, r13)
            float r0 = java.lang.Float.intBitsToFloat(r0)
            com.google.android.gms.internal.gtm.zzxy.zzp(r14, r3, r0)
            int r0 = r13 + 4
            goto L_0x0253
        L_0x0237:
            r17 = r13
        L_0x0239:
            r1 = 1
            goto L_0x0275
        L_0x023b:
            r13 = r0
            r8 = r2
            r2 = r17
            r11 = r25
            r1 = 1
            r21 = -1
            if (r2 != r1) goto L_0x0260
            long r0 = com.google.android.gms.internal.gtm.zzsm.zzo(r12, r13)
            double r0 = java.lang.Double.longBitsToDouble(r0)
            com.google.android.gms.internal.gtm.zzxy.zzo(r14, r3, r0)
        L_0x0251:
            int r0 = r13 + 8
        L_0x0253:
            r5 = r6 | r27
        L_0x0255:
            r13 = r35
        L_0x0257:
            r6 = r7
            r3 = r8
            r1 = r11
            r2 = r26
        L_0x025c:
            r11 = r36
            goto L_0x001a
        L_0x0260:
            r17 = r13
            goto L_0x0275
        L_0x0263:
            java.lang.Object r1 = r10.getObject(r14, r12)
            java.lang.Object r2 = r9.zzc
            java.lang.Object r1 = com.google.android.gms.internal.gtm.zzvi.zzg(r1, r2)
            r10.putObject(r14, r12, r1)
        L_0x0270:
            r5 = r6 | r27
            r12 = r33
            goto L_0x0255
        L_0x0275:
            r0 = r36
            r18 = r1
            r22 = r6
            r6 = r7
            r29 = r10
            r7 = r11
            r2 = r17
            r34 = r26
            r26 = r21
            r21 = r8
            goto L_0x03a7
        L_0x0289:
            r17 = r0
            r12 = r3
            r7 = r25
            r1 = 1
            r21 = -1
            r30 = r8
            r8 = r2
            r2 = r30
            r0 = 27
            if (r11 != r0) goto L_0x02f5
            r0 = 2
            if (r2 != r0) goto L_0x02e1
            java.lang.Object r0 = r10.getObject(r14, r12)
            com.google.android.gms.internal.gtm.zzvh r0 = (com.google.android.gms.internal.gtm.zzvh) r0
            boolean r1 = r0.zzc()
            if (r1 != 0) goto L_0x02bb
            int r1 = r0.size()
            if (r1 != 0) goto L_0x02b2
            r3 = 10
            goto L_0x02b4
        L_0x02b2:
            int r3 = r1 + r1
        L_0x02b4:
            com.google.android.gms.internal.gtm.zzvh r0 = r0.zzd(r3)
            r10.putObject(r14, r12, r0)
        L_0x02bb:
            r11 = r0
            com.google.android.gms.internal.gtm.zzwx r0 = r15.zzF(r8)
            r1 = r7
            r2 = r33
            r3 = r17
            r4 = r35
            r22 = r5
            r5 = r11
            r23 = r6
            r6 = r37
            int r0 = com.google.android.gms.internal.gtm.zzsm.zze(r0, r1, r2, r3, r4, r5, r6)
            r12 = r33
            r13 = r35
            r11 = r36
            r3 = r8
            r5 = r22
            r6 = r23
            r2 = r26
            goto L_0x001a
        L_0x02e1:
            r22 = r5
            r23 = r6
            r18 = r1
            r25 = r7
            r29 = r10
            r15 = r17
            r34 = r26
            r26 = r21
            r21 = r8
            goto L_0x0382
        L_0x02f5:
            r22 = r5
            r23 = r6
            r0 = 49
            if (r11 > r0) goto L_0x0352
            r3 = r24
            long r5 = (long) r3
            r0 = r31
            r4 = r1
            r1 = r32
            r3 = r2
            r2 = r33
            r24 = r3
            r3 = r17
            r18 = r4
            r4 = r35
            r27 = r5
            r5 = r7
            r6 = r26
            r25 = r7
            r34 = r26
            r7 = r24
            r26 = r21
            r21 = r8
            r29 = r10
            r9 = r27
            r15 = r36
            r15 = r17
            r14 = r37
            int r0 = r0.zzw(r1, r2, r3, r4, r5, r6, r7, r8, r9, r11, r12, r14)
            if (r0 == r15) goto L_0x0349
        L_0x032f:
            r15 = r31
            r14 = r32
            r12 = r33
            r2 = r34
            r13 = r35
            r11 = r36
            r9 = r37
            r3 = r21
            r5 = r22
            r6 = r23
            r1 = r25
            r10 = r29
            goto L_0x001a
        L_0x0349:
            r2 = r0
            r6 = r23
            r7 = r25
            r0 = r36
            goto L_0x03a7
        L_0x0352:
            r18 = r1
            r25 = r7
            r29 = r10
            r15 = r17
            r3 = r24
            r34 = r26
            r24 = r2
            r26 = r21
            r21 = r8
            r0 = 50
            if (r11 != r0) goto L_0x038a
            r7 = r24
            r0 = 2
            if (r7 != r0) goto L_0x0382
            r0 = r31
            r1 = r32
            r2 = r33
            r3 = r15
            r4 = r35
            r5 = r21
            r6 = r12
            r8 = r37
            int r0 = r0.zzt(r1, r2, r3, r4, r5, r6, r8)
            if (r0 == r15) goto L_0x0349
            goto L_0x032f
        L_0x0382:
            r0 = r36
            r2 = r15
            r6 = r23
            r7 = r25
            goto L_0x03a7
        L_0x038a:
            r7 = r24
            r0 = r31
            r1 = r32
            r2 = r33
            r8 = r3
            r3 = r15
            r4 = r35
            r5 = r25
            r6 = r34
            r9 = r11
            r10 = r12
            r12 = r21
            r13 = r37
            int r0 = r0.zzu(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r12, r13)
            if (r0 == r15) goto L_0x0349
            goto L_0x032f
        L_0x03a7:
            if (r7 != r0) goto L_0x03bc
            if (r0 == 0) goto L_0x03bc
            r8 = r31
            r13 = r32
            r9 = r0
            r0 = r2
            r2 = r6
            r1 = r7
            r5 = r22
            r3 = 1048575(0xfffff, float:1.469367E-39)
            r6 = r35
            goto L_0x05a1
        L_0x03bc:
            r8 = r31
            r9 = r0
            boolean r0 = r8.zzh
            if (r0 == 0) goto L_0x0565
            r10 = r37
            com.google.android.gms.internal.gtm.zzuj r0 = r10.zzd
            com.google.android.gms.internal.gtm.zzuj r1 = com.google.android.gms.internal.gtm.zzuj.zza()
            if (r0 == r1) goto L_0x055e
            com.google.android.gms.internal.gtm.zzwk r0 = r8.zzg
            com.google.android.gms.internal.gtm.zzxo<?, ?> r1 = r8.zzo
            com.google.android.gms.internal.gtm.zzuj r3 = r10.zzd
            r11 = r34
            com.google.android.gms.internal.gtm.zzux r12 = r3.zzc(r0, r11)
            if (r12 != 0) goto L_0x03f4
            com.google.android.gms.internal.gtm.zzxp r4 = zzd(r32)
            r0 = r7
            r1 = r33
            r3 = r35
            r5 = r37
            int r0 = com.google.android.gms.internal.gtm.zzsm.zzi(r0, r1, r2, r3, r4, r5)
            r13 = r32
            r15 = r33
        L_0x03ee:
            r34 = r6
            r6 = r35
            goto L_0x0580
        L_0x03f4:
            r13 = r32
            r0 = r13
            com.google.android.gms.internal.gtm.zzuv r0 = (com.google.android.gms.internal.gtm.zzuv) r0
            r0.zzU()
            com.google.android.gms.internal.gtm.zzuo<com.google.android.gms.internal.gtm.zzuw> r14 = r0.zza
            com.google.android.gms.internal.gtm.zzuw r3 = r12.zzd
            com.google.android.gms.internal.gtm.zzye r3 = r3.zzc
            com.google.android.gms.internal.gtm.zzye r4 = com.google.android.gms.internal.gtm.zzye.ENUM
            if (r3 != r4) goto L_0x0434
            r15 = r33
            int r2 = com.google.android.gms.internal.gtm.zzsm.zzj(r15, r2, r10)
            com.google.android.gms.internal.gtm.zzuw r3 = r12.zzd
            com.google.android.gms.internal.gtm.zzvc<?> r3 = r3.zza
            int r3 = r10.zza
            com.google.android.gms.internal.gtm.zzyl r3 = com.google.android.gms.internal.gtm.zzyl.zzc(r3)
            if (r3 != 0) goto L_0x042d
            com.google.android.gms.internal.gtm.zzxp r3 = r0.zzc
            com.google.android.gms.internal.gtm.zzxp r4 = com.google.android.gms.internal.gtm.zzxp.zzc()
            if (r3 != r4) goto L_0x0426
            com.google.android.gms.internal.gtm.zzxp r3 = com.google.android.gms.internal.gtm.zzxp.zze()
            r0.zzc = r3
        L_0x0426:
            int r0 = r10.zza
            com.google.android.gms.internal.gtm.zzwz.zzD(r11, r0, r3, r1)
            r0 = r2
            goto L_0x03ee
        L_0x042d:
            int r0 = r10.zza
            java.lang.Integer r4 = java.lang.Integer.valueOf(r0)
            goto L_0x0470
        L_0x0434:
            r15 = r33
            int r0 = r3.ordinal()
            switch(r0) {
                case 0: goto L_0x0525;
                case 1: goto L_0x0512;
                case 2: goto L_0x0503;
                case 3: goto L_0x0503;
                case 4: goto L_0x04f4;
                case 5: goto L_0x04e7;
                case 6: goto L_0x04da;
                case 7: goto L_0x04c2;
                case 8: goto L_0x04b6;
                case 9: goto L_0x0491;
                case 10: goto L_0x0476;
                case 11: goto L_0x046a;
                case 12: goto L_0x04f4;
                case 13: goto L_0x0462;
                case 14: goto L_0x04da;
                case 15: goto L_0x04e7;
                case 16: goto L_0x0453;
                case 17: goto L_0x0444;
                default: goto L_0x043d;
            }
        L_0x043d:
            r34 = r6
            r6 = r35
            r4 = 0
            goto L_0x0537
        L_0x0444:
            int r2 = com.google.android.gms.internal.gtm.zzsm.zzm(r15, r2, r10)
            long r0 = r10.zzb
            long r0 = com.google.android.gms.internal.gtm.zztj.zzt(r0)
            java.lang.Long r4 = java.lang.Long.valueOf(r0)
            goto L_0x0470
        L_0x0453:
            int r2 = com.google.android.gms.internal.gtm.zzsm.zzj(r15, r2, r10)
            int r0 = r10.zza
            int r0 = com.google.android.gms.internal.gtm.zztj.zzs(r0)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r0)
            goto L_0x0470
        L_0x0462:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "Shouldn't reach here."
            r0.<init>(r1)
            throw r0
        L_0x046a:
            int r2 = com.google.android.gms.internal.gtm.zzsm.zza(r15, r2, r10)
            java.lang.Object r4 = r10.zzc
        L_0x0470:
            r34 = r6
            r6 = r35
            goto L_0x0537
        L_0x0476:
            com.google.android.gms.internal.gtm.zzwt r0 = com.google.android.gms.internal.gtm.zzwt.zza()
            com.google.android.gms.internal.gtm.zzwk r1 = r12.zzc
            java.lang.Class r1 = r1.getClass()
            com.google.android.gms.internal.gtm.zzwx r0 = r0.zzb(r1)
            r5 = r35
            int r2 = com.google.android.gms.internal.gtm.zzsm.zzd(r0, r15, r2, r5, r10)
            java.lang.Object r4 = r10.zzc
            r34 = r6
            r6 = r5
            goto L_0x0537
        L_0x0491:
            r5 = r35
            com.google.android.gms.internal.gtm.zzwt r0 = com.google.android.gms.internal.gtm.zzwt.zza()
            com.google.android.gms.internal.gtm.zzwk r1 = r12.zzc
            java.lang.Class r1 = r1.getClass()
            com.google.android.gms.internal.gtm.zzwx r0 = r0.zzb(r1)
            int r1 = r11 << 3
            r4 = r1 | 4
            r1 = r33
            r3 = r35
            r34 = r6
            r6 = r5
            r5 = r37
            int r2 = com.google.android.gms.internal.gtm.zzsm.zzc(r0, r1, r2, r3, r4, r5)
            java.lang.Object r4 = r10.zzc
            goto L_0x0537
        L_0x04b6:
            r34 = r6
            r6 = r35
            int r2 = com.google.android.gms.internal.gtm.zzsm.zzg(r15, r2, r10)
            java.lang.Object r4 = r10.zzc
            goto L_0x0537
        L_0x04c2:
            r34 = r6
            r6 = r35
            int r2 = com.google.android.gms.internal.gtm.zzsm.zzm(r15, r2, r10)
            long r0 = r10.zzb
            int r0 = (r0 > r19 ? 1 : (r0 == r19 ? 0 : -1))
            if (r0 == 0) goto L_0x04d3
            r4 = r18
            goto L_0x04d5
        L_0x04d3:
            r4 = r16
        L_0x04d5:
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)
            goto L_0x0537
        L_0x04da:
            r34 = r6
            r6 = r35
            int r0 = com.google.android.gms.internal.gtm.zzsm.zzb(r15, r2)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r0)
            goto L_0x0522
        L_0x04e7:
            r34 = r6
            r6 = r35
            long r0 = com.google.android.gms.internal.gtm.zzsm.zzo(r15, r2)
            java.lang.Long r4 = java.lang.Long.valueOf(r0)
            goto L_0x0535
        L_0x04f4:
            r34 = r6
            r6 = r35
            int r2 = com.google.android.gms.internal.gtm.zzsm.zzj(r15, r2, r10)
            int r0 = r10.zza
            java.lang.Integer r4 = java.lang.Integer.valueOf(r0)
            goto L_0x0537
        L_0x0503:
            r34 = r6
            r6 = r35
            int r2 = com.google.android.gms.internal.gtm.zzsm.zzm(r15, r2, r10)
            long r0 = r10.zzb
            java.lang.Long r4 = java.lang.Long.valueOf(r0)
            goto L_0x0537
        L_0x0512:
            r34 = r6
            r6 = r35
            int r0 = com.google.android.gms.internal.gtm.zzsm.zzb(r15, r2)
            float r0 = java.lang.Float.intBitsToFloat(r0)
            java.lang.Float r4 = java.lang.Float.valueOf(r0)
        L_0x0522:
            int r2 = r2 + 4
            goto L_0x0537
        L_0x0525:
            r34 = r6
            r6 = r35
            long r0 = com.google.android.gms.internal.gtm.zzsm.zzo(r15, r2)
            double r0 = java.lang.Double.longBitsToDouble(r0)
            java.lang.Double r4 = java.lang.Double.valueOf(r0)
        L_0x0535:
            int r2 = r2 + 8
        L_0x0537:
            r12.zza()
            com.google.android.gms.internal.gtm.zzuw r0 = r12.zzd
            com.google.android.gms.internal.gtm.zzye r0 = r0.zzc
            int r0 = r0.ordinal()
            r1 = 9
            if (r0 == r1) goto L_0x054b
            r1 = 10
            if (r0 == r1) goto L_0x054b
            goto L_0x0557
        L_0x054b:
            com.google.android.gms.internal.gtm.zzuw r0 = r12.zzd
            java.lang.Object r0 = r14.zze(r0)
            if (r0 == 0) goto L_0x0557
            java.lang.Object r4 = com.google.android.gms.internal.gtm.zzvi.zzg(r0, r4)
        L_0x0557:
            com.google.android.gms.internal.gtm.zzuw r0 = r12.zzd
            r14.zzi(r0, r4)
            r0 = r2
            goto L_0x0580
        L_0x055e:
            r13 = r32
            r15 = r33
            r11 = r34
            goto L_0x056d
        L_0x0565:
            r13 = r32
            r15 = r33
            r11 = r34
            r10 = r37
        L_0x056d:
            r34 = r6
            r6 = r35
            com.google.android.gms.internal.gtm.zzxp r4 = zzd(r32)
            r0 = r7
            r1 = r33
            r3 = r35
            r5 = r37
            int r0 = com.google.android.gms.internal.gtm.zzsm.zzi(r0, r1, r2, r3, r4, r5)
        L_0x0580:
            r1 = r7
            r2 = r11
            r14 = r13
            r12 = r15
            r3 = r21
            r5 = r22
            r13 = r6
            r15 = r8
            r11 = r9
            r9 = r10
            r10 = r29
            r6 = r34
            goto L_0x001a
        L_0x0592:
            r22 = r5
            r23 = r6
            r29 = r10
            r9 = r11
            r6 = r13
            r13 = r14
            r8 = r15
            r2 = r23
            r3 = 1048575(0xfffff, float:1.469367E-39)
        L_0x05a1:
            if (r2 == r3) goto L_0x05a9
            long r2 = (long) r2
            r4 = r29
            r4.putInt(r13, r2, r5)
        L_0x05a9:
            int r2 = r8.zzl
        L_0x05ab:
            int r3 = r8.zzm
            if (r2 >= r3) goto L_0x05bc
            int[] r3 = r8.zzk
            r3 = r3[r2]
            com.google.android.gms.internal.gtm.zzxo<?, ?> r4 = r8.zzo
            r5 = 0
            r8.zzG(r13, r3, r5, r4)
            int r2 = r2 + 1
            goto L_0x05ab
        L_0x05bc:
            if (r9 != 0) goto L_0x05c6
            if (r0 != r6) goto L_0x05c1
            goto L_0x05ca
        L_0x05c1:
            com.google.android.gms.internal.gtm.zzvk r0 = com.google.android.gms.internal.gtm.zzvk.zzg()
            throw r0
        L_0x05c6:
            if (r0 > r6) goto L_0x05cb
            if (r1 != r9) goto L_0x05cb
        L_0x05ca:
            return r0
        L_0x05cb:
            com.google.android.gms.internal.gtm.zzvk r0 = com.google.android.gms.internal.gtm.zzvk.zzg()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.gtm.zzwn.zzc(java.lang.Object, byte[], int, int, int, com.google.android.gms.internal.gtm.zzsl):int");
    }

    public final T zze() {
        return ((zzuz) this.zzg).zzb(4, (Object) null, (Object) null);
    }

    public final void zzf(T t10) {
        int i10;
        int i11 = this.zzl;
        while (true) {
            i10 = this.zzm;
            if (i11 >= i10) {
                break;
            }
            long zzC = (long) (zzC(this.zzk[i11]) & 1048575);
            Object zzf2 = zzxy.zzf(t10, zzC);
            if (zzf2 != null) {
                ((zzwe) zzf2).zzc();
                zzxy.zzs(t10, zzC, zzf2);
            }
            i11++;
        }
        int length = this.zzk.length;
        while (i10 < length) {
            this.zzn.zzb(t10, (long) this.zzk[i10]);
            i10++;
        }
        this.zzo.zzm(t10);
        if (this.zzh) {
            this.zzp.zzf(t10);
        }
    }

    public final void zzg(T t10, T t11) {
        t11.getClass();
        for (int i10 = 0; i10 < this.zzc.length; i10 += 3) {
            int zzC = zzC(i10);
            long j10 = (long) (1048575 & zzC);
            int i11 = this.zzc[i10];
            switch (zzB(zzC)) {
                case 0:
                    if (!zzQ(t11, i10)) {
                        break;
                    } else {
                        zzxy.zzo(t10, j10, zzxy.zza(t11, j10));
                        zzM(t10, i10);
                        break;
                    }
                case 1:
                    if (!zzQ(t11, i10)) {
                        break;
                    } else {
                        zzxy.zzp(t10, j10, zzxy.zzb(t11, j10));
                        zzM(t10, i10);
                        break;
                    }
                case 2:
                    if (!zzQ(t11, i10)) {
                        break;
                    } else {
                        zzxy.zzr(t10, j10, zzxy.zzd(t11, j10));
                        zzM(t10, i10);
                        break;
                    }
                case 3:
                    if (!zzQ(t11, i10)) {
                        break;
                    } else {
                        zzxy.zzr(t10, j10, zzxy.zzd(t11, j10));
                        zzM(t10, i10);
                        break;
                    }
                case 4:
                    if (!zzQ(t11, i10)) {
                        break;
                    } else {
                        zzxy.zzq(t10, j10, zzxy.zzc(t11, j10));
                        zzM(t10, i10);
                        break;
                    }
                case 5:
                    if (!zzQ(t11, i10)) {
                        break;
                    } else {
                        zzxy.zzr(t10, j10, zzxy.zzd(t11, j10));
                        zzM(t10, i10);
                        break;
                    }
                case 6:
                    if (!zzQ(t11, i10)) {
                        break;
                    } else {
                        zzxy.zzq(t10, j10, zzxy.zzc(t11, j10));
                        zzM(t10, i10);
                        break;
                    }
                case 7:
                    if (!zzQ(t11, i10)) {
                        break;
                    } else {
                        zzxy.zzm(t10, j10, zzxy.zzw(t11, j10));
                        zzM(t10, i10);
                        break;
                    }
                case 8:
                    if (!zzQ(t11, i10)) {
                        break;
                    } else {
                        zzxy.zzs(t10, j10, zzxy.zzf(t11, j10));
                        zzM(t10, i10);
                        break;
                    }
                case 9:
                    zzJ(t10, t11, i10);
                    break;
                case 10:
                    if (!zzQ(t11, i10)) {
                        break;
                    } else {
                        zzxy.zzs(t10, j10, zzxy.zzf(t11, j10));
                        zzM(t10, i10);
                        break;
                    }
                case 11:
                    if (!zzQ(t11, i10)) {
                        break;
                    } else {
                        zzxy.zzq(t10, j10, zzxy.zzc(t11, j10));
                        zzM(t10, i10);
                        break;
                    }
                case 12:
                    if (!zzQ(t11, i10)) {
                        break;
                    } else {
                        zzxy.zzq(t10, j10, zzxy.zzc(t11, j10));
                        zzM(t10, i10);
                        break;
                    }
                case 13:
                    if (!zzQ(t11, i10)) {
                        break;
                    } else {
                        zzxy.zzq(t10, j10, zzxy.zzc(t11, j10));
                        zzM(t10, i10);
                        break;
                    }
                case 14:
                    if (!zzQ(t11, i10)) {
                        break;
                    } else {
                        zzxy.zzr(t10, j10, zzxy.zzd(t11, j10));
                        zzM(t10, i10);
                        break;
                    }
                case 15:
                    if (!zzQ(t11, i10)) {
                        break;
                    } else {
                        zzxy.zzq(t10, j10, zzxy.zzc(t11, j10));
                        zzM(t10, i10);
                        break;
                    }
                case 16:
                    if (!zzQ(t11, i10)) {
                        break;
                    } else {
                        zzxy.zzr(t10, j10, zzxy.zzd(t11, j10));
                        zzM(t10, i10);
                        break;
                    }
                case 17:
                    zzJ(t10, t11, i10);
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    this.zzn.zzc(t10, t11, j10);
                    break;
                case 50:
                    zzwz.zzI(this.zzr, t10, t11, j10);
                    break;
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                    if (!zzT(t11, i11, i10)) {
                        break;
                    } else {
                        zzxy.zzs(t10, j10, zzxy.zzf(t11, j10));
                        zzN(t10, i11, i10);
                        break;
                    }
                case 60:
                    zzK(t10, t11, i10);
                    break;
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                    if (!zzT(t11, i11, i10)) {
                        break;
                    } else {
                        zzxy.zzs(t10, j10, zzxy.zzf(t11, j10));
                        zzN(t10, i11, i10);
                        break;
                    }
                case 68:
                    zzK(t10, t11, i10);
                    break;
            }
        }
        zzwz.zzF(this.zzo, t10, t11);
        if (this.zzh) {
            zzwz.zzE(this.zzp, t10, t11);
        }
    }

    /*  JADX ERROR: StackOverflow in pass: MarkFinallyVisitor
        jadx.core.utils.exceptions.JadxOverflowException: 
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    public final void zzh(T r13, com.google.android.gms.internal.gtm.zzww r14, com.google.android.gms.internal.gtm.zzuj r15) throws java.io.IOException {
        /*
            r12 = this;
            r15.getClass()
            com.google.android.gms.internal.gtm.zzxo<?, ?> r7 = r12.zzo
            com.google.android.gms.internal.gtm.zzuk<?> r8 = r12.zzp
            r9 = 0
            r0 = r9
            r10 = r0
        L_0x000a:
            int r1 = r14.zzc()     // Catch:{ all -> 0x0077 }
            int r2 = r12.zzx(r1)     // Catch:{ all -> 0x0077 }
            if (r2 >= 0) goto L_0x007a
            r2 = 2147483647(0x7fffffff, float:NaN)
            if (r1 != r2) goto L_0x002f
            int r14 = r12.zzl
        L_0x001b:
            int r15 = r12.zzm
            if (r14 >= r15) goto L_0x0029
            int[] r15 = r12.zzk
            r15 = r15[r14]
            r12.zzG(r13, r15, r10, r7)
            int r14 = r14 + 1
            goto L_0x001b
        L_0x0029:
            if (r10 == 0) goto L_0x05b6
            r7.zzn(r13, r10)
            return
        L_0x002f:
            boolean r2 = r12.zzh     // Catch:{ all -> 0x0077 }
            if (r2 != 0) goto L_0x0035
            r2 = r9
            goto L_0x003c
        L_0x0035:
            com.google.android.gms.internal.gtm.zzwk r2 = r12.zzg     // Catch:{ all -> 0x0077 }
            java.lang.Object r1 = r8.zzd(r15, r2, r1)     // Catch:{ all -> 0x0077 }
            r2 = r1
        L_0x003c:
            if (r2 == 0) goto L_0x0051
            if (r0 != 0) goto L_0x0044
            com.google.android.gms.internal.gtm.zzuo r0 = r8.zzc(r13)     // Catch:{ all -> 0x0077 }
        L_0x0044:
            r11 = r0
            r0 = r8
            r1 = r14
            r3 = r15
            r4 = r11
            r5 = r10
            r6 = r7
            java.lang.Object r10 = r0.zze(r1, r2, r3, r4, r5, r6)     // Catch:{ all -> 0x0077 }
            r0 = r11
            goto L_0x000a
        L_0x0051:
            r7.zzq(r14)     // Catch:{ all -> 0x0077 }
            if (r10 != 0) goto L_0x005b
            java.lang.Object r1 = r7.zzc(r13)     // Catch:{ all -> 0x0077 }
            r10 = r1
        L_0x005b:
            boolean r1 = r7.zzp(r10, r14)     // Catch:{ all -> 0x0077 }
            if (r1 != 0) goto L_0x000a
            int r14 = r12.zzl
        L_0x0063:
            int r15 = r12.zzm
            if (r14 >= r15) goto L_0x0071
            int[] r15 = r12.zzk
            r15 = r15[r14]
            r12.zzG(r13, r15, r10, r7)
            int r14 = r14 + 1
            goto L_0x0063
        L_0x0071:
            if (r10 == 0) goto L_0x05b6
            r7.zzn(r13, r10)
            return
        L_0x0077:
            r14 = move-exception
            goto L_0x05b7
        L_0x007a:
            int r3 = r12.zzC(r2)     // Catch:{ all -> 0x0077 }
            int r4 = zzB(r3)     // Catch:{ zzvj -> 0x0591 }
            r5 = 1048575(0xfffff, float:1.469367E-39)
            switch(r4) {
                case 0: goto L_0x0567;
                case 1: goto L_0x0558;
                case 2: goto L_0x0549;
                case 3: goto L_0x053a;
                case 4: goto L_0x052b;
                case 5: goto L_0x051c;
                case 6: goto L_0x050d;
                case 7: goto L_0x04fe;
                case 8: goto L_0x04f6;
                case 9: goto L_0x04c5;
                case 10: goto L_0x04b6;
                case 11: goto L_0x04a7;
                case 12: goto L_0x0485;
                case 13: goto L_0x0476;
                case 14: goto L_0x0467;
                case 15: goto L_0x0458;
                case 16: goto L_0x0449;
                case 17: goto L_0x0418;
                case 18: goto L_0x040a;
                case 19: goto L_0x03fc;
                case 20: goto L_0x03ee;
                case 21: goto L_0x03e0;
                case 22: goto L_0x03d2;
                case 23: goto L_0x03c4;
                case 24: goto L_0x03b6;
                case 25: goto L_0x03a8;
                case 26: goto L_0x0386;
                case 27: goto L_0x0374;
                case 28: goto L_0x0366;
                case 29: goto L_0x0358;
                case 30: goto L_0x0343;
                case 31: goto L_0x0335;
                case 32: goto L_0x0327;
                case 33: goto L_0x0319;
                case 34: goto L_0x030b;
                case 35: goto L_0x02fd;
                case 36: goto L_0x02ef;
                case 37: goto L_0x02e1;
                case 38: goto L_0x02d3;
                case 39: goto L_0x02c5;
                case 40: goto L_0x02b7;
                case 41: goto L_0x02a9;
                case 42: goto L_0x029b;
                case 43: goto L_0x028d;
                case 44: goto L_0x0278;
                case 45: goto L_0x026a;
                case 46: goto L_0x025c;
                case 47: goto L_0x024e;
                case 48: goto L_0x0240;
                case 49: goto L_0x022e;
                case 50: goto L_0x01f8;
                case 51: goto L_0x01e6;
                case 52: goto L_0x01d4;
                case 53: goto L_0x01c2;
                case 54: goto L_0x01b0;
                case 55: goto L_0x019e;
                case 56: goto L_0x018c;
                case 57: goto L_0x017a;
                case 58: goto L_0x0168;
                case 59: goto L_0x0160;
                case 60: goto L_0x012f;
                case 61: goto L_0x0121;
                case 62: goto L_0x010f;
                case 63: goto L_0x00ea;
                case 64: goto L_0x00d8;
                case 65: goto L_0x00c6;
                case 66: goto L_0x00b4;
                case 67: goto L_0x00a2;
                case 68: goto L_0x0090;
                default: goto L_0x0088;
            }     // Catch:{ zzvj -> 0x0591 }
        L_0x0088:
            if (r10 != 0) goto L_0x0577
            java.lang.Object r1 = r7.zzf()     // Catch:{ zzvj -> 0x0591 }
            goto L_0x0576
        L_0x0090:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzvj -> 0x0591 }
            com.google.android.gms.internal.gtm.zzwx r5 = r12.zzF(r2)     // Catch:{ zzvj -> 0x0591 }
            java.lang.Object r5 = r14.zzs(r5, r15)     // Catch:{ zzvj -> 0x0591 }
            com.google.android.gms.internal.gtm.zzxy.zzs(r13, r3, r5)     // Catch:{ zzvj -> 0x0591 }
            r12.zzN(r13, r1, r2)     // Catch:{ zzvj -> 0x0591 }
            goto L_0x000a
        L_0x00a2:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzvj -> 0x0591 }
            long r5 = r14.zzn()     // Catch:{ zzvj -> 0x0591 }
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ zzvj -> 0x0591 }
            com.google.android.gms.internal.gtm.zzxy.zzs(r13, r3, r5)     // Catch:{ zzvj -> 0x0591 }
            r12.zzN(r13, r1, r2)     // Catch:{ zzvj -> 0x0591 }
            goto L_0x000a
        L_0x00b4:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzvj -> 0x0591 }
            int r5 = r14.zzi()     // Catch:{ zzvj -> 0x0591 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ zzvj -> 0x0591 }
            com.google.android.gms.internal.gtm.zzxy.zzs(r13, r3, r5)     // Catch:{ zzvj -> 0x0591 }
            r12.zzN(r13, r1, r2)     // Catch:{ zzvj -> 0x0591 }
            goto L_0x000a
        L_0x00c6:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzvj -> 0x0591 }
            long r5 = r14.zzm()     // Catch:{ zzvj -> 0x0591 }
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ zzvj -> 0x0591 }
            com.google.android.gms.internal.gtm.zzxy.zzs(r13, r3, r5)     // Catch:{ zzvj -> 0x0591 }
            r12.zzN(r13, r1, r2)     // Catch:{ zzvj -> 0x0591 }
            goto L_0x000a
        L_0x00d8:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzvj -> 0x0591 }
            int r5 = r14.zzh()     // Catch:{ zzvj -> 0x0591 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ zzvj -> 0x0591 }
            com.google.android.gms.internal.gtm.zzxy.zzs(r13, r3, r5)     // Catch:{ zzvj -> 0x0591 }
            r12.zzN(r13, r1, r2)     // Catch:{ zzvj -> 0x0591 }
            goto L_0x000a
        L_0x00ea:
            int r4 = r14.zze()     // Catch:{ zzvj -> 0x0591 }
            com.google.android.gms.internal.gtm.zzvd r6 = r12.zzE(r2)     // Catch:{ zzvj -> 0x0591 }
            if (r6 == 0) goto L_0x0101
            boolean r6 = r6.zza(r4)     // Catch:{ zzvj -> 0x0591 }
            if (r6 == 0) goto L_0x00fb
            goto L_0x0101
        L_0x00fb:
            java.lang.Object r10 = com.google.android.gms.internal.gtm.zzwz.zzD(r1, r4, r10, r7)     // Catch:{ zzvj -> 0x0591 }
            goto L_0x000a
        L_0x0101:
            r3 = r3 & r5
            long r5 = (long) r3     // Catch:{ zzvj -> 0x0591 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r4)     // Catch:{ zzvj -> 0x0591 }
            com.google.android.gms.internal.gtm.zzxy.zzs(r13, r5, r3)     // Catch:{ zzvj -> 0x0591 }
            r12.zzN(r13, r1, r2)     // Catch:{ zzvj -> 0x0591 }
            goto L_0x000a
        L_0x010f:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzvj -> 0x0591 }
            int r5 = r14.zzj()     // Catch:{ zzvj -> 0x0591 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ zzvj -> 0x0591 }
            com.google.android.gms.internal.gtm.zzxy.zzs(r13, r3, r5)     // Catch:{ zzvj -> 0x0591 }
            r12.zzN(r13, r1, r2)     // Catch:{ zzvj -> 0x0591 }
            goto L_0x000a
        L_0x0121:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzvj -> 0x0591 }
            com.google.android.gms.internal.gtm.zztd r5 = r14.zzq()     // Catch:{ zzvj -> 0x0591 }
            com.google.android.gms.internal.gtm.zzxy.zzs(r13, r3, r5)     // Catch:{ zzvj -> 0x0591 }
            r12.zzN(r13, r1, r2)     // Catch:{ zzvj -> 0x0591 }
            goto L_0x000a
        L_0x012f:
            boolean r4 = r12.zzT(r13, r1, r2)     // Catch:{ zzvj -> 0x0591 }
            if (r4 == 0) goto L_0x014b
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzvj -> 0x0591 }
            java.lang.Object r5 = com.google.android.gms.internal.gtm.zzxy.zzf(r13, r3)     // Catch:{ zzvj -> 0x0591 }
            com.google.android.gms.internal.gtm.zzwx r6 = r12.zzF(r2)     // Catch:{ zzvj -> 0x0591 }
            java.lang.Object r6 = r14.zzu(r6, r15)     // Catch:{ zzvj -> 0x0591 }
            java.lang.Object r5 = com.google.android.gms.internal.gtm.zzvi.zzg(r5, r6)     // Catch:{ zzvj -> 0x0591 }
            com.google.android.gms.internal.gtm.zzxy.zzs(r13, r3, r5)     // Catch:{ zzvj -> 0x0591 }
            goto L_0x015b
        L_0x014b:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzvj -> 0x0591 }
            com.google.android.gms.internal.gtm.zzwx r5 = r12.zzF(r2)     // Catch:{ zzvj -> 0x0591 }
            java.lang.Object r5 = r14.zzu(r5, r15)     // Catch:{ zzvj -> 0x0591 }
            com.google.android.gms.internal.gtm.zzxy.zzs(r13, r3, r5)     // Catch:{ zzvj -> 0x0591 }
            r12.zzM(r13, r2)     // Catch:{ zzvj -> 0x0591 }
        L_0x015b:
            r12.zzN(r13, r1, r2)     // Catch:{ zzvj -> 0x0591 }
            goto L_0x000a
        L_0x0160:
            r12.zzL(r13, r3, r14)     // Catch:{ zzvj -> 0x0591 }
            r12.zzN(r13, r1, r2)     // Catch:{ zzvj -> 0x0591 }
            goto L_0x000a
        L_0x0168:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzvj -> 0x0591 }
            boolean r5 = r14.zzS()     // Catch:{ zzvj -> 0x0591 }
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r5)     // Catch:{ zzvj -> 0x0591 }
            com.google.android.gms.internal.gtm.zzxy.zzs(r13, r3, r5)     // Catch:{ zzvj -> 0x0591 }
            r12.zzN(r13, r1, r2)     // Catch:{ zzvj -> 0x0591 }
            goto L_0x000a
        L_0x017a:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzvj -> 0x0591 }
            int r5 = r14.zzf()     // Catch:{ zzvj -> 0x0591 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ zzvj -> 0x0591 }
            com.google.android.gms.internal.gtm.zzxy.zzs(r13, r3, r5)     // Catch:{ zzvj -> 0x0591 }
            r12.zzN(r13, r1, r2)     // Catch:{ zzvj -> 0x0591 }
            goto L_0x000a
        L_0x018c:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzvj -> 0x0591 }
            long r5 = r14.zzk()     // Catch:{ zzvj -> 0x0591 }
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ zzvj -> 0x0591 }
            com.google.android.gms.internal.gtm.zzxy.zzs(r13, r3, r5)     // Catch:{ zzvj -> 0x0591 }
            r12.zzN(r13, r1, r2)     // Catch:{ zzvj -> 0x0591 }
            goto L_0x000a
        L_0x019e:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzvj -> 0x0591 }
            int r5 = r14.zzg()     // Catch:{ zzvj -> 0x0591 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ zzvj -> 0x0591 }
            com.google.android.gms.internal.gtm.zzxy.zzs(r13, r3, r5)     // Catch:{ zzvj -> 0x0591 }
            r12.zzN(r13, r1, r2)     // Catch:{ zzvj -> 0x0591 }
            goto L_0x000a
        L_0x01b0:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzvj -> 0x0591 }
            long r5 = r14.zzo()     // Catch:{ zzvj -> 0x0591 }
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ zzvj -> 0x0591 }
            com.google.android.gms.internal.gtm.zzxy.zzs(r13, r3, r5)     // Catch:{ zzvj -> 0x0591 }
            r12.zzN(r13, r1, r2)     // Catch:{ zzvj -> 0x0591 }
            goto L_0x000a
        L_0x01c2:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzvj -> 0x0591 }
            long r5 = r14.zzl()     // Catch:{ zzvj -> 0x0591 }
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ zzvj -> 0x0591 }
            com.google.android.gms.internal.gtm.zzxy.zzs(r13, r3, r5)     // Catch:{ zzvj -> 0x0591 }
            r12.zzN(r13, r1, r2)     // Catch:{ zzvj -> 0x0591 }
            goto L_0x000a
        L_0x01d4:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzvj -> 0x0591 }
            float r5 = r14.zzb()     // Catch:{ zzvj -> 0x0591 }
            java.lang.Float r5 = java.lang.Float.valueOf(r5)     // Catch:{ zzvj -> 0x0591 }
            com.google.android.gms.internal.gtm.zzxy.zzs(r13, r3, r5)     // Catch:{ zzvj -> 0x0591 }
            r12.zzN(r13, r1, r2)     // Catch:{ zzvj -> 0x0591 }
            goto L_0x000a
        L_0x01e6:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzvj -> 0x0591 }
            double r5 = r14.zza()     // Catch:{ zzvj -> 0x0591 }
            java.lang.Double r5 = java.lang.Double.valueOf(r5)     // Catch:{ zzvj -> 0x0591 }
            com.google.android.gms.internal.gtm.zzxy.zzs(r13, r3, r5)     // Catch:{ zzvj -> 0x0591 }
            r12.zzN(r13, r1, r2)     // Catch:{ zzvj -> 0x0591 }
            goto L_0x000a
        L_0x01f8:
            java.lang.Object r1 = r12.zzH(r2)     // Catch:{ zzvj -> 0x0591 }
            int r2 = r12.zzC(r2)     // Catch:{ zzvj -> 0x0591 }
            r2 = r2 & r5
            long r2 = (long) r2     // Catch:{ zzvj -> 0x0591 }
            java.lang.Object r4 = com.google.android.gms.internal.gtm.zzxy.zzf(r13, r2)     // Catch:{ zzvj -> 0x0591 }
            if (r4 == 0) goto L_0x021e
            boolean r5 = com.google.android.gms.internal.gtm.zzwf.zzb(r4)     // Catch:{ zzvj -> 0x0591 }
            if (r5 == 0) goto L_0x0229
            com.google.android.gms.internal.gtm.zzwe r5 = com.google.android.gms.internal.gtm.zzwe.zza()     // Catch:{ zzvj -> 0x0591 }
            com.google.android.gms.internal.gtm.zzwe r5 = r5.zzb()     // Catch:{ zzvj -> 0x0591 }
            com.google.android.gms.internal.gtm.zzwf.zzc(r5, r4)     // Catch:{ zzvj -> 0x0591 }
            com.google.android.gms.internal.gtm.zzxy.zzs(r13, r2, r5)     // Catch:{ zzvj -> 0x0591 }
            r4 = r5
            goto L_0x0229
        L_0x021e:
            com.google.android.gms.internal.gtm.zzwe r4 = com.google.android.gms.internal.gtm.zzwe.zza()     // Catch:{ zzvj -> 0x0591 }
            com.google.android.gms.internal.gtm.zzwe r4 = r4.zzb()     // Catch:{ zzvj -> 0x0591 }
            com.google.android.gms.internal.gtm.zzxy.zzs(r13, r2, r4)     // Catch:{ zzvj -> 0x0591 }
        L_0x0229:
            com.google.android.gms.internal.gtm.zzwe r4 = (com.google.android.gms.internal.gtm.zzwe) r4     // Catch:{ zzvj -> 0x0591 }
            com.google.android.gms.internal.gtm.zzwd r1 = (com.google.android.gms.internal.gtm.zzwd) r1     // Catch:{ zzvj -> 0x0591 }
            throw r9     // Catch:{ zzvj -> 0x0591 }
        L_0x022e:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzvj -> 0x0591 }
            com.google.android.gms.internal.gtm.zzwx r1 = r12.zzF(r2)     // Catch:{ zzvj -> 0x0591 }
            com.google.android.gms.internal.gtm.zzvy r2 = r12.zzn     // Catch:{ zzvj -> 0x0591 }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzvj -> 0x0591 }
            r14.zzF(r2, r1, r15)     // Catch:{ zzvj -> 0x0591 }
            goto L_0x000a
        L_0x0240:
            com.google.android.gms.internal.gtm.zzvy r1 = r12.zzn     // Catch:{ zzvj -> 0x0591 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzvj -> 0x0591 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzvj -> 0x0591 }
            r14.zzM(r1)     // Catch:{ zzvj -> 0x0591 }
            goto L_0x000a
        L_0x024e:
            com.google.android.gms.internal.gtm.zzvy r1 = r12.zzn     // Catch:{ zzvj -> 0x0591 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzvj -> 0x0591 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzvj -> 0x0591 }
            r14.zzL(r1)     // Catch:{ zzvj -> 0x0591 }
            goto L_0x000a
        L_0x025c:
            com.google.android.gms.internal.gtm.zzvy r1 = r12.zzn     // Catch:{ zzvj -> 0x0591 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzvj -> 0x0591 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzvj -> 0x0591 }
            r14.zzK(r1)     // Catch:{ zzvj -> 0x0591 }
            goto L_0x000a
        L_0x026a:
            com.google.android.gms.internal.gtm.zzvy r1 = r12.zzn     // Catch:{ zzvj -> 0x0591 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzvj -> 0x0591 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzvj -> 0x0591 }
            r14.zzJ(r1)     // Catch:{ zzvj -> 0x0591 }
            goto L_0x000a
        L_0x0278:
            com.google.android.gms.internal.gtm.zzvy r4 = r12.zzn     // Catch:{ zzvj -> 0x0591 }
            r3 = r3 & r5
            long r5 = (long) r3     // Catch:{ zzvj -> 0x0591 }
            java.util.List r3 = r4.zza(r13, r5)     // Catch:{ zzvj -> 0x0591 }
            r14.zzB(r3)     // Catch:{ zzvj -> 0x0591 }
            com.google.android.gms.internal.gtm.zzvd r2 = r12.zzE(r2)     // Catch:{ zzvj -> 0x0591 }
            java.lang.Object r10 = com.google.android.gms.internal.gtm.zzwz.zzC(r1, r3, r2, r10, r7)     // Catch:{ zzvj -> 0x0591 }
            goto L_0x000a
        L_0x028d:
            com.google.android.gms.internal.gtm.zzvy r1 = r12.zzn     // Catch:{ zzvj -> 0x0591 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzvj -> 0x0591 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzvj -> 0x0591 }
            r14.zzQ(r1)     // Catch:{ zzvj -> 0x0591 }
            goto L_0x000a
        L_0x029b:
            com.google.android.gms.internal.gtm.zzvy r1 = r12.zzn     // Catch:{ zzvj -> 0x0591 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzvj -> 0x0591 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzvj -> 0x0591 }
            r14.zzy(r1)     // Catch:{ zzvj -> 0x0591 }
            goto L_0x000a
        L_0x02a9:
            com.google.android.gms.internal.gtm.zzvy r1 = r12.zzn     // Catch:{ zzvj -> 0x0591 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzvj -> 0x0591 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzvj -> 0x0591 }
            r14.zzC(r1)     // Catch:{ zzvj -> 0x0591 }
            goto L_0x000a
        L_0x02b7:
            com.google.android.gms.internal.gtm.zzvy r1 = r12.zzn     // Catch:{ zzvj -> 0x0591 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzvj -> 0x0591 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzvj -> 0x0591 }
            r14.zzD(r1)     // Catch:{ zzvj -> 0x0591 }
            goto L_0x000a
        L_0x02c5:
            com.google.android.gms.internal.gtm.zzvy r1 = r12.zzn     // Catch:{ zzvj -> 0x0591 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzvj -> 0x0591 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzvj -> 0x0591 }
            r14.zzG(r1)     // Catch:{ zzvj -> 0x0591 }
            goto L_0x000a
        L_0x02d3:
            com.google.android.gms.internal.gtm.zzvy r1 = r12.zzn     // Catch:{ zzvj -> 0x0591 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzvj -> 0x0591 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzvj -> 0x0591 }
            r14.zzR(r1)     // Catch:{ zzvj -> 0x0591 }
            goto L_0x000a
        L_0x02e1:
            com.google.android.gms.internal.gtm.zzvy r1 = r12.zzn     // Catch:{ zzvj -> 0x0591 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzvj -> 0x0591 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzvj -> 0x0591 }
            r14.zzH(r1)     // Catch:{ zzvj -> 0x0591 }
            goto L_0x000a
        L_0x02ef:
            com.google.android.gms.internal.gtm.zzvy r1 = r12.zzn     // Catch:{ zzvj -> 0x0591 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzvj -> 0x0591 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzvj -> 0x0591 }
            r14.zzE(r1)     // Catch:{ zzvj -> 0x0591 }
            goto L_0x000a
        L_0x02fd:
            com.google.android.gms.internal.gtm.zzvy r1 = r12.zzn     // Catch:{ zzvj -> 0x0591 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzvj -> 0x0591 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzvj -> 0x0591 }
            r14.zzA(r1)     // Catch:{ zzvj -> 0x0591 }
            goto L_0x000a
        L_0x030b:
            com.google.android.gms.internal.gtm.zzvy r1 = r12.zzn     // Catch:{ zzvj -> 0x0591 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzvj -> 0x0591 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzvj -> 0x0591 }
            r14.zzM(r1)     // Catch:{ zzvj -> 0x0591 }
            goto L_0x000a
        L_0x0319:
            com.google.android.gms.internal.gtm.zzvy r1 = r12.zzn     // Catch:{ zzvj -> 0x0591 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzvj -> 0x0591 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzvj -> 0x0591 }
            r14.zzL(r1)     // Catch:{ zzvj -> 0x0591 }
            goto L_0x000a
        L_0x0327:
            com.google.android.gms.internal.gtm.zzvy r1 = r12.zzn     // Catch:{ zzvj -> 0x0591 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzvj -> 0x0591 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzvj -> 0x0591 }
            r14.zzK(r1)     // Catch:{ zzvj -> 0x0591 }
            goto L_0x000a
        L_0x0335:
            com.google.android.gms.internal.gtm.zzvy r1 = r12.zzn     // Catch:{ zzvj -> 0x0591 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzvj -> 0x0591 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzvj -> 0x0591 }
            r14.zzJ(r1)     // Catch:{ zzvj -> 0x0591 }
            goto L_0x000a
        L_0x0343:
            com.google.android.gms.internal.gtm.zzvy r4 = r12.zzn     // Catch:{ zzvj -> 0x0591 }
            r3 = r3 & r5
            long r5 = (long) r3     // Catch:{ zzvj -> 0x0591 }
            java.util.List r3 = r4.zza(r13, r5)     // Catch:{ zzvj -> 0x0591 }
            r14.zzB(r3)     // Catch:{ zzvj -> 0x0591 }
            com.google.android.gms.internal.gtm.zzvd r2 = r12.zzE(r2)     // Catch:{ zzvj -> 0x0591 }
            java.lang.Object r10 = com.google.android.gms.internal.gtm.zzwz.zzC(r1, r3, r2, r10, r7)     // Catch:{ zzvj -> 0x0591 }
            goto L_0x000a
        L_0x0358:
            com.google.android.gms.internal.gtm.zzvy r1 = r12.zzn     // Catch:{ zzvj -> 0x0591 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzvj -> 0x0591 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzvj -> 0x0591 }
            r14.zzQ(r1)     // Catch:{ zzvj -> 0x0591 }
            goto L_0x000a
        L_0x0366:
            com.google.android.gms.internal.gtm.zzvy r1 = r12.zzn     // Catch:{ zzvj -> 0x0591 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzvj -> 0x0591 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzvj -> 0x0591 }
            r14.zzz(r1)     // Catch:{ zzvj -> 0x0591 }
            goto L_0x000a
        L_0x0374:
            com.google.android.gms.internal.gtm.zzwx r1 = r12.zzF(r2)     // Catch:{ zzvj -> 0x0591 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzvj -> 0x0591 }
            com.google.android.gms.internal.gtm.zzvy r4 = r12.zzn     // Catch:{ zzvj -> 0x0591 }
            java.util.List r2 = r4.zza(r13, r2)     // Catch:{ zzvj -> 0x0591 }
            r14.zzI(r2, r1, r15)     // Catch:{ zzvj -> 0x0591 }
            goto L_0x000a
        L_0x0386:
            boolean r1 = zzP(r3)     // Catch:{ zzvj -> 0x0591 }
            if (r1 == 0) goto L_0x039a
            com.google.android.gms.internal.gtm.zzvy r1 = r12.zzn     // Catch:{ zzvj -> 0x0591 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzvj -> 0x0591 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzvj -> 0x0591 }
            r14.zzP(r1)     // Catch:{ zzvj -> 0x0591 }
            goto L_0x000a
        L_0x039a:
            com.google.android.gms.internal.gtm.zzvy r1 = r12.zzn     // Catch:{ zzvj -> 0x0591 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzvj -> 0x0591 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzvj -> 0x0591 }
            r14.zzN(r1)     // Catch:{ zzvj -> 0x0591 }
            goto L_0x000a
        L_0x03a8:
            com.google.android.gms.internal.gtm.zzvy r1 = r12.zzn     // Catch:{ zzvj -> 0x0591 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzvj -> 0x0591 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzvj -> 0x0591 }
            r14.zzy(r1)     // Catch:{ zzvj -> 0x0591 }
            goto L_0x000a
        L_0x03b6:
            com.google.android.gms.internal.gtm.zzvy r1 = r12.zzn     // Catch:{ zzvj -> 0x0591 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzvj -> 0x0591 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzvj -> 0x0591 }
            r14.zzC(r1)     // Catch:{ zzvj -> 0x0591 }
            goto L_0x000a
        L_0x03c4:
            com.google.android.gms.internal.gtm.zzvy r1 = r12.zzn     // Catch:{ zzvj -> 0x0591 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzvj -> 0x0591 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzvj -> 0x0591 }
            r14.zzD(r1)     // Catch:{ zzvj -> 0x0591 }
            goto L_0x000a
        L_0x03d2:
            com.google.android.gms.internal.gtm.zzvy r1 = r12.zzn     // Catch:{ zzvj -> 0x0591 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzvj -> 0x0591 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzvj -> 0x0591 }
            r14.zzG(r1)     // Catch:{ zzvj -> 0x0591 }
            goto L_0x000a
        L_0x03e0:
            com.google.android.gms.internal.gtm.zzvy r1 = r12.zzn     // Catch:{ zzvj -> 0x0591 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzvj -> 0x0591 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzvj -> 0x0591 }
            r14.zzR(r1)     // Catch:{ zzvj -> 0x0591 }
            goto L_0x000a
        L_0x03ee:
            com.google.android.gms.internal.gtm.zzvy r1 = r12.zzn     // Catch:{ zzvj -> 0x0591 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzvj -> 0x0591 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzvj -> 0x0591 }
            r14.zzH(r1)     // Catch:{ zzvj -> 0x0591 }
            goto L_0x000a
        L_0x03fc:
            com.google.android.gms.internal.gtm.zzvy r1 = r12.zzn     // Catch:{ zzvj -> 0x0591 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzvj -> 0x0591 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzvj -> 0x0591 }
            r14.zzE(r1)     // Catch:{ zzvj -> 0x0591 }
            goto L_0x000a
        L_0x040a:
            com.google.android.gms.internal.gtm.zzvy r1 = r12.zzn     // Catch:{ zzvj -> 0x0591 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzvj -> 0x0591 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzvj -> 0x0591 }
            r14.zzA(r1)     // Catch:{ zzvj -> 0x0591 }
            goto L_0x000a
        L_0x0418:
            boolean r1 = r12.zzQ(r13, r2)     // Catch:{ zzvj -> 0x0591 }
            if (r1 == 0) goto L_0x0436
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzvj -> 0x0591 }
            java.lang.Object r1 = com.google.android.gms.internal.gtm.zzxy.zzf(r13, r3)     // Catch:{ zzvj -> 0x0591 }
            com.google.android.gms.internal.gtm.zzwx r2 = r12.zzF(r2)     // Catch:{ zzvj -> 0x0591 }
            java.lang.Object r2 = r14.zzs(r2, r15)     // Catch:{ zzvj -> 0x0591 }
            java.lang.Object r1 = com.google.android.gms.internal.gtm.zzvi.zzg(r1, r2)     // Catch:{ zzvj -> 0x0591 }
            com.google.android.gms.internal.gtm.zzxy.zzs(r13, r3, r1)     // Catch:{ zzvj -> 0x0591 }
            goto L_0x000a
        L_0x0436:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzvj -> 0x0591 }
            com.google.android.gms.internal.gtm.zzwx r1 = r12.zzF(r2)     // Catch:{ zzvj -> 0x0591 }
            java.lang.Object r1 = r14.zzs(r1, r15)     // Catch:{ zzvj -> 0x0591 }
            com.google.android.gms.internal.gtm.zzxy.zzs(r13, r3, r1)     // Catch:{ zzvj -> 0x0591 }
            r12.zzM(r13, r2)     // Catch:{ zzvj -> 0x0591 }
            goto L_0x000a
        L_0x0449:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzvj -> 0x0591 }
            long r5 = r14.zzn()     // Catch:{ zzvj -> 0x0591 }
            com.google.android.gms.internal.gtm.zzxy.zzr(r13, r3, r5)     // Catch:{ zzvj -> 0x0591 }
            r12.zzM(r13, r2)     // Catch:{ zzvj -> 0x0591 }
            goto L_0x000a
        L_0x0458:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzvj -> 0x0591 }
            int r1 = r14.zzi()     // Catch:{ zzvj -> 0x0591 }
            com.google.android.gms.internal.gtm.zzxy.zzq(r13, r3, r1)     // Catch:{ zzvj -> 0x0591 }
            r12.zzM(r13, r2)     // Catch:{ zzvj -> 0x0591 }
            goto L_0x000a
        L_0x0467:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzvj -> 0x0591 }
            long r5 = r14.zzm()     // Catch:{ zzvj -> 0x0591 }
            com.google.android.gms.internal.gtm.zzxy.zzr(r13, r3, r5)     // Catch:{ zzvj -> 0x0591 }
            r12.zzM(r13, r2)     // Catch:{ zzvj -> 0x0591 }
            goto L_0x000a
        L_0x0476:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzvj -> 0x0591 }
            int r1 = r14.zzh()     // Catch:{ zzvj -> 0x0591 }
            com.google.android.gms.internal.gtm.zzxy.zzq(r13, r3, r1)     // Catch:{ zzvj -> 0x0591 }
            r12.zzM(r13, r2)     // Catch:{ zzvj -> 0x0591 }
            goto L_0x000a
        L_0x0485:
            int r4 = r14.zze()     // Catch:{ zzvj -> 0x0591 }
            com.google.android.gms.internal.gtm.zzvd r6 = r12.zzE(r2)     // Catch:{ zzvj -> 0x0591 }
            if (r6 == 0) goto L_0x049c
            boolean r6 = r6.zza(r4)     // Catch:{ zzvj -> 0x0591 }
            if (r6 == 0) goto L_0x0496
            goto L_0x049c
        L_0x0496:
            java.lang.Object r10 = com.google.android.gms.internal.gtm.zzwz.zzD(r1, r4, r10, r7)     // Catch:{ zzvj -> 0x0591 }
            goto L_0x000a
        L_0x049c:
            r1 = r3 & r5
            long r5 = (long) r1     // Catch:{ zzvj -> 0x0591 }
            com.google.android.gms.internal.gtm.zzxy.zzq(r13, r5, r4)     // Catch:{ zzvj -> 0x0591 }
            r12.zzM(r13, r2)     // Catch:{ zzvj -> 0x0591 }
            goto L_0x000a
        L_0x04a7:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzvj -> 0x0591 }
            int r1 = r14.zzj()     // Catch:{ zzvj -> 0x0591 }
            com.google.android.gms.internal.gtm.zzxy.zzq(r13, r3, r1)     // Catch:{ zzvj -> 0x0591 }
            r12.zzM(r13, r2)     // Catch:{ zzvj -> 0x0591 }
            goto L_0x000a
        L_0x04b6:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzvj -> 0x0591 }
            com.google.android.gms.internal.gtm.zztd r1 = r14.zzq()     // Catch:{ zzvj -> 0x0591 }
            com.google.android.gms.internal.gtm.zzxy.zzs(r13, r3, r1)     // Catch:{ zzvj -> 0x0591 }
            r12.zzM(r13, r2)     // Catch:{ zzvj -> 0x0591 }
            goto L_0x000a
        L_0x04c5:
            boolean r1 = r12.zzQ(r13, r2)     // Catch:{ zzvj -> 0x0591 }
            if (r1 == 0) goto L_0x04e3
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzvj -> 0x0591 }
            java.lang.Object r1 = com.google.android.gms.internal.gtm.zzxy.zzf(r13, r3)     // Catch:{ zzvj -> 0x0591 }
            com.google.android.gms.internal.gtm.zzwx r2 = r12.zzF(r2)     // Catch:{ zzvj -> 0x0591 }
            java.lang.Object r2 = r14.zzu(r2, r15)     // Catch:{ zzvj -> 0x0591 }
            java.lang.Object r1 = com.google.android.gms.internal.gtm.zzvi.zzg(r1, r2)     // Catch:{ zzvj -> 0x0591 }
            com.google.android.gms.internal.gtm.zzxy.zzs(r13, r3, r1)     // Catch:{ zzvj -> 0x0591 }
            goto L_0x000a
        L_0x04e3:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzvj -> 0x0591 }
            com.google.android.gms.internal.gtm.zzwx r1 = r12.zzF(r2)     // Catch:{ zzvj -> 0x0591 }
            java.lang.Object r1 = r14.zzu(r1, r15)     // Catch:{ zzvj -> 0x0591 }
            com.google.android.gms.internal.gtm.zzxy.zzs(r13, r3, r1)     // Catch:{ zzvj -> 0x0591 }
            r12.zzM(r13, r2)     // Catch:{ zzvj -> 0x0591 }
            goto L_0x000a
        L_0x04f6:
            r12.zzL(r13, r3, r14)     // Catch:{ zzvj -> 0x0591 }
            r12.zzM(r13, r2)     // Catch:{ zzvj -> 0x0591 }
            goto L_0x000a
        L_0x04fe:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzvj -> 0x0591 }
            boolean r1 = r14.zzS()     // Catch:{ zzvj -> 0x0591 }
            com.google.android.gms.internal.gtm.zzxy.zzm(r13, r3, r1)     // Catch:{ zzvj -> 0x0591 }
            r12.zzM(r13, r2)     // Catch:{ zzvj -> 0x0591 }
            goto L_0x000a
        L_0x050d:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzvj -> 0x0591 }
            int r1 = r14.zzf()     // Catch:{ zzvj -> 0x0591 }
            com.google.android.gms.internal.gtm.zzxy.zzq(r13, r3, r1)     // Catch:{ zzvj -> 0x0591 }
            r12.zzM(r13, r2)     // Catch:{ zzvj -> 0x0591 }
            goto L_0x000a
        L_0x051c:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzvj -> 0x0591 }
            long r5 = r14.zzk()     // Catch:{ zzvj -> 0x0591 }
            com.google.android.gms.internal.gtm.zzxy.zzr(r13, r3, r5)     // Catch:{ zzvj -> 0x0591 }
            r12.zzM(r13, r2)     // Catch:{ zzvj -> 0x0591 }
            goto L_0x000a
        L_0x052b:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzvj -> 0x0591 }
            int r1 = r14.zzg()     // Catch:{ zzvj -> 0x0591 }
            com.google.android.gms.internal.gtm.zzxy.zzq(r13, r3, r1)     // Catch:{ zzvj -> 0x0591 }
            r12.zzM(r13, r2)     // Catch:{ zzvj -> 0x0591 }
            goto L_0x000a
        L_0x053a:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzvj -> 0x0591 }
            long r5 = r14.zzo()     // Catch:{ zzvj -> 0x0591 }
            com.google.android.gms.internal.gtm.zzxy.zzr(r13, r3, r5)     // Catch:{ zzvj -> 0x0591 }
            r12.zzM(r13, r2)     // Catch:{ zzvj -> 0x0591 }
            goto L_0x000a
        L_0x0549:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzvj -> 0x0591 }
            long r5 = r14.zzl()     // Catch:{ zzvj -> 0x0591 }
            com.google.android.gms.internal.gtm.zzxy.zzr(r13, r3, r5)     // Catch:{ zzvj -> 0x0591 }
            r12.zzM(r13, r2)     // Catch:{ zzvj -> 0x0591 }
            goto L_0x000a
        L_0x0558:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzvj -> 0x0591 }
            float r1 = r14.zzb()     // Catch:{ zzvj -> 0x0591 }
            com.google.android.gms.internal.gtm.zzxy.zzp(r13, r3, r1)     // Catch:{ zzvj -> 0x0591 }
            r12.zzM(r13, r2)     // Catch:{ zzvj -> 0x0591 }
            goto L_0x000a
        L_0x0567:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzvj -> 0x0591 }
            double r5 = r14.zza()     // Catch:{ zzvj -> 0x0591 }
            com.google.android.gms.internal.gtm.zzxy.zzo(r13, r3, r5)     // Catch:{ zzvj -> 0x0591 }
            r12.zzM(r13, r2)     // Catch:{ zzvj -> 0x0591 }
            goto L_0x000a
        L_0x0576:
            r10 = r1
        L_0x0577:
            boolean r1 = r7.zzp(r10, r14)     // Catch:{ zzvj -> 0x0591 }
            if (r1 != 0) goto L_0x000a
            int r14 = r12.zzl
        L_0x057f:
            int r15 = r12.zzm
            if (r14 >= r15) goto L_0x058d
            int[] r15 = r12.zzk
            r15 = r15[r14]
            r12.zzG(r13, r15, r10, r7)
            int r14 = r14 + 1
            goto L_0x057f
        L_0x058d:
            r7.zzn(r13, r10)
            return
        L_0x0591:
            r7.zzq(r14)     // Catch:{ all -> 0x0077 }
            if (r10 != 0) goto L_0x059b
            java.lang.Object r1 = r7.zzc(r13)     // Catch:{ all -> 0x0077 }
            r10 = r1
        L_0x059b:
            boolean r1 = r7.zzp(r10, r14)     // Catch:{ all -> 0x0077 }
            if (r1 != 0) goto L_0x000a
            int r14 = r12.zzl
        L_0x05a3:
            int r15 = r12.zzm
            if (r14 >= r15) goto L_0x05b1
            int[] r15 = r12.zzk
            r15 = r15[r14]
            r12.zzG(r13, r15, r10, r7)
            int r14 = r14 + 1
            goto L_0x05a3
        L_0x05b1:
            if (r10 == 0) goto L_0x05b6
            r7.zzn(r13, r10)
        L_0x05b6:
            return
        L_0x05b7:
            int r15 = r12.zzl
        L_0x05b9:
            int r0 = r12.zzm
            if (r15 >= r0) goto L_0x05c7
            int[] r0 = r12.zzk
            r0 = r0[r15]
            r12.zzG(r13, r0, r10, r7)
            int r15 = r15 + 1
            goto L_0x05b9
        L_0x05c7:
            if (r10 == 0) goto L_0x05cc
            r7.zzn(r13, r10)
        L_0x05cc:
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.gtm.zzwn.zzh(java.lang.Object, com.google.android.gms.internal.gtm.zzww, com.google.android.gms.internal.gtm.zzuj):void");
    }

    public final void zzi(T t10, byte[] bArr, int i10, int i11, zzsl zzsl) throws IOException {
        if (this.zzj) {
            zzv(t10, bArr, i10, i11, zzsl);
        } else {
            zzc(t10, bArr, i10, i11, 0, zzsl);
        }
    }

    public final boolean zzj(T t10, T t11) {
        boolean z10;
        int length = this.zzc.length;
        for (int i10 = 0; i10 < length; i10 += 3) {
            int zzC = zzC(i10);
            long j10 = (long) (zzC & 1048575);
            switch (zzB(zzC)) {
                case 0:
                    if (zzO(t10, t11, i10) && Double.doubleToLongBits(zzxy.zza(t10, j10)) == Double.doubleToLongBits(zzxy.zza(t11, j10))) {
                        continue;
                    }
                case 1:
                    if (zzO(t10, t11, i10) && Float.floatToIntBits(zzxy.zzb(t10, j10)) == Float.floatToIntBits(zzxy.zzb(t11, j10))) {
                        continue;
                    }
                case 2:
                    if (zzO(t10, t11, i10) && zzxy.zzd(t10, j10) == zzxy.zzd(t11, j10)) {
                        continue;
                    }
                case 3:
                    if (zzO(t10, t11, i10) && zzxy.zzd(t10, j10) == zzxy.zzd(t11, j10)) {
                        continue;
                    }
                case 4:
                    if (zzO(t10, t11, i10) && zzxy.zzc(t10, j10) == zzxy.zzc(t11, j10)) {
                        continue;
                    }
                case 5:
                    if (zzO(t10, t11, i10) && zzxy.zzd(t10, j10) == zzxy.zzd(t11, j10)) {
                        continue;
                    }
                case 6:
                    if (zzO(t10, t11, i10) && zzxy.zzc(t10, j10) == zzxy.zzc(t11, j10)) {
                        continue;
                    }
                case 7:
                    if (zzO(t10, t11, i10) && zzxy.zzw(t10, j10) == zzxy.zzw(t11, j10)) {
                        continue;
                    }
                case 8:
                    if (zzO(t10, t11, i10) && zzwz.zzH(zzxy.zzf(t10, j10), zzxy.zzf(t11, j10))) {
                        continue;
                    }
                case 9:
                    if (zzO(t10, t11, i10) && zzwz.zzH(zzxy.zzf(t10, j10), zzxy.zzf(t11, j10))) {
                        continue;
                    }
                case 10:
                    if (zzO(t10, t11, i10) && zzwz.zzH(zzxy.zzf(t10, j10), zzxy.zzf(t11, j10))) {
                        continue;
                    }
                case 11:
                    if (zzO(t10, t11, i10) && zzxy.zzc(t10, j10) == zzxy.zzc(t11, j10)) {
                        continue;
                    }
                case 12:
                    if (zzO(t10, t11, i10) && zzxy.zzc(t10, j10) == zzxy.zzc(t11, j10)) {
                        continue;
                    }
                case 13:
                    if (zzO(t10, t11, i10) && zzxy.zzc(t10, j10) == zzxy.zzc(t11, j10)) {
                        continue;
                    }
                case 14:
                    if (zzO(t10, t11, i10) && zzxy.zzd(t10, j10) == zzxy.zzd(t11, j10)) {
                        continue;
                    }
                case 15:
                    if (zzO(t10, t11, i10) && zzxy.zzc(t10, j10) == zzxy.zzc(t11, j10)) {
                        continue;
                    }
                case 16:
                    if (zzO(t10, t11, i10) && zzxy.zzd(t10, j10) == zzxy.zzd(t11, j10)) {
                        continue;
                    }
                case 17:
                    if (zzO(t10, t11, i10) && zzwz.zzH(zzxy.zzf(t10, j10), zzxy.zzf(t11, j10))) {
                        continue;
                    }
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    z10 = zzwz.zzH(zzxy.zzf(t10, j10), zzxy.zzf(t11, j10));
                    break;
                case 50:
                    z10 = zzwz.zzH(zzxy.zzf(t10, j10), zzxy.zzf(t11, j10));
                    break;
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                case 60:
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                case 68:
                    long zzz = (long) (zzz(i10) & 1048575);
                    if (zzxy.zzc(t10, zzz) == zzxy.zzc(t11, zzz) && zzwz.zzH(zzxy.zzf(t10, j10), zzxy.zzf(t11, j10))) {
                        continue;
                    }
            }
            if (!z10) {
                return false;
            }
        }
        if (!this.zzo.zzd(t10).equals(this.zzo.zzd(t11))) {
            return false;
        }
        if (this.zzh) {
            return this.zzp.zzb(t10).equals(this.zzp.zzb(t11));
        }
        return true;
    }

    public final boolean zzk(T t10) {
        int i10;
        int i11;
        T t11 = t10;
        int i12 = 1048575;
        int i13 = 0;
        int i14 = 0;
        while (i14 < this.zzl) {
            int i15 = this.zzk[i14];
            int i16 = this.zzc[i15];
            int zzC = zzC(i15);
            int i17 = this.zzc[i15 + 2];
            int i18 = i17 & 1048575;
            int i19 = 1 << (i17 >>> 20);
            if (i18 != i12) {
                if (i18 != 1048575) {
                    i13 = zzb.getInt(t11, (long) i18);
                }
                i10 = i13;
                i11 = i18;
            } else {
                i11 = i12;
                i10 = i13;
            }
            if ((268435456 & zzC) != 0 && !zzR(t10, i15, i11, i10, i19)) {
                return false;
            }
            int zzB = zzB(zzC);
            if (zzB != 9 && zzB != 17) {
                if (zzB != 27) {
                    if (zzB == 60 || zzB == 68) {
                        if (zzT(t11, i16, i15) && !zzS(t11, zzC, zzF(i15))) {
                            return false;
                        }
                    } else if (zzB != 49) {
                        if (zzB == 50 && !((zzwe) zzxy.zzf(t11, (long) (zzC & 1048575))).isEmpty()) {
                            zzwd zzwd = (zzwd) zzH(i15);
                            throw null;
                        }
                    }
                }
                List list = (List) zzxy.zzf(t11, (long) (zzC & 1048575));
                if (!list.isEmpty()) {
                    zzwx zzF = zzF(i15);
                    for (int i20 = 0; i20 < list.size(); i20++) {
                        if (!zzF.zzk(list.get(i20))) {
                            return false;
                        }
                    }
                    continue;
                } else {
                    continue;
                }
            } else if (zzR(t10, i15, i11, i10, i19) && !zzS(t11, zzC, zzF(i15))) {
                return false;
            }
            i14++;
            i12 = i11;
            i13 = i10;
        }
        if (!this.zzh || this.zzp.zzb(t11).zzk()) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x002b  */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x0507  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzn(T r13, com.google.android.gms.internal.gtm.zztp r14) throws java.io.IOException {
        /*
            r12 = this;
            boolean r0 = r12.zzj
            if (r0 == 0) goto L_0x0525
            boolean r0 = r12.zzh
            r1 = 0
            if (r0 == 0) goto L_0x0022
            com.google.android.gms.internal.gtm.zzuk<?> r0 = r12.zzp
            com.google.android.gms.internal.gtm.zzuo r0 = r0.zzb(r13)
            com.google.android.gms.internal.gtm.zzxk<T, java.lang.Object> r2 = r0.zza
            boolean r2 = r2.isEmpty()
            if (r2 != 0) goto L_0x0022
            java.util.Iterator r0 = r0.zzf()
            java.lang.Object r2 = r0.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            goto L_0x0024
        L_0x0022:
            r0 = r1
            r2 = r0
        L_0x0024:
            int[] r3 = r12.zzc
            int r3 = r3.length
            r4 = 0
            r5 = r4
        L_0x0029:
            if (r5 >= r3) goto L_0x0505
            int r6 = r12.zzC(r5)
            int[] r7 = r12.zzc
            r7 = r7[r5]
        L_0x0033:
            if (r2 == 0) goto L_0x0051
            com.google.android.gms.internal.gtm.zzuk<?> r8 = r12.zzp
            int r8 = r8.zza(r2)
            if (r8 > r7) goto L_0x0051
            com.google.android.gms.internal.gtm.zzuk<?> r8 = r12.zzp
            r8.zzj(r14, r2)
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x004f
            java.lang.Object r2 = r0.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            goto L_0x0033
        L_0x004f:
            r2 = r1
            goto L_0x0033
        L_0x0051:
            int r8 = zzB(r6)
            r9 = 1
            r10 = 1048575(0xfffff, float:1.469367E-39)
            switch(r8) {
                case 0: goto L_0x04f2;
                case 1: goto L_0x04e2;
                case 2: goto L_0x04d2;
                case 3: goto L_0x04c2;
                case 4: goto L_0x04b2;
                case 5: goto L_0x04a2;
                case 6: goto L_0x0492;
                case 7: goto L_0x0481;
                case 8: goto L_0x0470;
                case 9: goto L_0x045b;
                case 10: goto L_0x0448;
                case 11: goto L_0x0437;
                case 12: goto L_0x0426;
                case 13: goto L_0x0415;
                case 14: goto L_0x0404;
                case 15: goto L_0x03f3;
                case 16: goto L_0x03e2;
                case 17: goto L_0x03cd;
                case 18: goto L_0x03bc;
                case 19: goto L_0x03ab;
                case 20: goto L_0x039a;
                case 21: goto L_0x0389;
                case 22: goto L_0x0378;
                case 23: goto L_0x0367;
                case 24: goto L_0x0356;
                case 25: goto L_0x0345;
                case 26: goto L_0x0334;
                case 27: goto L_0x031f;
                case 28: goto L_0x030e;
                case 29: goto L_0x02fd;
                case 30: goto L_0x02ec;
                case 31: goto L_0x02db;
                case 32: goto L_0x02ca;
                case 33: goto L_0x02b9;
                case 34: goto L_0x02a8;
                case 35: goto L_0x0297;
                case 36: goto L_0x0286;
                case 37: goto L_0x0275;
                case 38: goto L_0x0264;
                case 39: goto L_0x0253;
                case 40: goto L_0x0242;
                case 41: goto L_0x0231;
                case 42: goto L_0x0220;
                case 43: goto L_0x020f;
                case 44: goto L_0x01fe;
                case 45: goto L_0x01ed;
                case 46: goto L_0x01dc;
                case 47: goto L_0x01cb;
                case 48: goto L_0x01ba;
                case 49: goto L_0x01a5;
                case 50: goto L_0x019a;
                case 51: goto L_0x0189;
                case 52: goto L_0x0178;
                case 53: goto L_0x0167;
                case 54: goto L_0x0156;
                case 55: goto L_0x0145;
                case 56: goto L_0x0134;
                case 57: goto L_0x0123;
                case 58: goto L_0x0112;
                case 59: goto L_0x0101;
                case 60: goto L_0x00ec;
                case 61: goto L_0x00d9;
                case 62: goto L_0x00c8;
                case 63: goto L_0x00b7;
                case 64: goto L_0x00a6;
                case 65: goto L_0x0095;
                case 66: goto L_0x0084;
                case 67: goto L_0x0073;
                case 68: goto L_0x005e;
                default: goto L_0x005c;
            }
        L_0x005c:
            goto L_0x0501
        L_0x005e:
            boolean r8 = r12.zzT(r13, r7, r5)
            if (r8 == 0) goto L_0x0501
            r6 = r6 & r10
            long r8 = (long) r6
            java.lang.Object r6 = com.google.android.gms.internal.gtm.zzxy.zzf(r13, r8)
            com.google.android.gms.internal.gtm.zzwx r8 = r12.zzF(r5)
            r14.zzq(r7, r6, r8)
            goto L_0x0501
        L_0x0073:
            boolean r8 = r12.zzT(r13, r7, r5)
            if (r8 == 0) goto L_0x0501
            r6 = r6 & r10
            long r8 = (long) r6
            long r8 = zzD(r13, r8)
            r14.zzD(r7, r8)
            goto L_0x0501
        L_0x0084:
            boolean r8 = r12.zzT(r13, r7, r5)
            if (r8 == 0) goto L_0x0501
            r6 = r6 & r10
            long r8 = (long) r6
            int r6 = zzs(r13, r8)
            r14.zzB(r7, r6)
            goto L_0x0501
        L_0x0095:
            boolean r8 = r12.zzT(r13, r7, r5)
            if (r8 == 0) goto L_0x0501
            r6 = r6 & r10
            long r8 = (long) r6
            long r8 = zzD(r13, r8)
            r14.zzz(r7, r8)
            goto L_0x0501
        L_0x00a6:
            boolean r8 = r12.zzT(r13, r7, r5)
            if (r8 == 0) goto L_0x0501
            r6 = r6 & r10
            long r8 = (long) r6
            int r6 = zzs(r13, r8)
            r14.zzx(r7, r6)
            goto L_0x0501
        L_0x00b7:
            boolean r8 = r12.zzT(r13, r7, r5)
            if (r8 == 0) goto L_0x0501
            r6 = r6 & r10
            long r8 = (long) r6
            int r6 = zzs(r13, r8)
            r14.zzi(r7, r6)
            goto L_0x0501
        L_0x00c8:
            boolean r8 = r12.zzT(r13, r7, r5)
            if (r8 == 0) goto L_0x0501
            r6 = r6 & r10
            long r8 = (long) r6
            int r6 = zzs(r13, r8)
            r14.zzI(r7, r6)
            goto L_0x0501
        L_0x00d9:
            boolean r8 = r12.zzT(r13, r7, r5)
            if (r8 == 0) goto L_0x0501
            r6 = r6 & r10
            long r8 = (long) r6
            java.lang.Object r6 = com.google.android.gms.internal.gtm.zzxy.zzf(r13, r8)
            com.google.android.gms.internal.gtm.zztd r6 = (com.google.android.gms.internal.gtm.zztd) r6
            r14.zzd(r7, r6)
            goto L_0x0501
        L_0x00ec:
            boolean r8 = r12.zzT(r13, r7, r5)
            if (r8 == 0) goto L_0x0501
            r6 = r6 & r10
            long r8 = (long) r6
            java.lang.Object r6 = com.google.android.gms.internal.gtm.zzxy.zzf(r13, r8)
            com.google.android.gms.internal.gtm.zzwx r8 = r12.zzF(r5)
            r14.zzv(r7, r6, r8)
            goto L_0x0501
        L_0x0101:
            boolean r8 = r12.zzT(r13, r7, r5)
            if (r8 == 0) goto L_0x0501
            r6 = r6 & r10
            long r8 = (long) r6
            java.lang.Object r6 = com.google.android.gms.internal.gtm.zzxy.zzf(r13, r8)
            zzX(r7, r6, r14)
            goto L_0x0501
        L_0x0112:
            boolean r8 = r12.zzT(r13, r7, r5)
            if (r8 == 0) goto L_0x0501
            r6 = r6 & r10
            long r8 = (long) r6
            boolean r6 = zzU(r13, r8)
            r14.zzb(r7, r6)
            goto L_0x0501
        L_0x0123:
            boolean r8 = r12.zzT(r13, r7, r5)
            if (r8 == 0) goto L_0x0501
            r6 = r6 & r10
            long r8 = (long) r6
            int r6 = zzs(r13, r8)
            r14.zzk(r7, r6)
            goto L_0x0501
        L_0x0134:
            boolean r8 = r12.zzT(r13, r7, r5)
            if (r8 == 0) goto L_0x0501
            r6 = r6 & r10
            long r8 = (long) r6
            long r8 = zzD(r13, r8)
            r14.zzm(r7, r8)
            goto L_0x0501
        L_0x0145:
            boolean r8 = r12.zzT(r13, r7, r5)
            if (r8 == 0) goto L_0x0501
            r6 = r6 & r10
            long r8 = (long) r6
            int r6 = zzs(r13, r8)
            r14.zzr(r7, r6)
            goto L_0x0501
        L_0x0156:
            boolean r8 = r12.zzT(r13, r7, r5)
            if (r8 == 0) goto L_0x0501
            r6 = r6 & r10
            long r8 = (long) r6
            long r8 = zzD(r13, r8)
            r14.zzK(r7, r8)
            goto L_0x0501
        L_0x0167:
            boolean r8 = r12.zzT(r13, r7, r5)
            if (r8 == 0) goto L_0x0501
            r6 = r6 & r10
            long r8 = (long) r6
            long r8 = zzD(r13, r8)
            r14.zzt(r7, r8)
            goto L_0x0501
        L_0x0178:
            boolean r8 = r12.zzT(r13, r7, r5)
            if (r8 == 0) goto L_0x0501
            r6 = r6 & r10
            long r8 = (long) r6
            float r6 = zzp(r13, r8)
            r14.zzo(r7, r6)
            goto L_0x0501
        L_0x0189:
            boolean r8 = r12.zzT(r13, r7, r5)
            if (r8 == 0) goto L_0x0501
            r6 = r6 & r10
            long r8 = (long) r6
            double r8 = zzo(r13, r8)
            r14.zzf(r7, r8)
            goto L_0x0501
        L_0x019a:
            r6 = r6 & r10
            long r8 = (long) r6
            java.lang.Object r6 = com.google.android.gms.internal.gtm.zzxy.zzf(r13, r8)
            r12.zzW(r14, r7, r6, r5)
            goto L_0x0501
        L_0x01a5:
            int[] r7 = r12.zzc
            r7 = r7[r5]
            r6 = r6 & r10
            long r8 = (long) r6
            java.lang.Object r6 = com.google.android.gms.internal.gtm.zzxy.zzf(r13, r8)
            java.util.List r6 = (java.util.List) r6
            com.google.android.gms.internal.gtm.zzwx r8 = r12.zzF(r5)
            com.google.android.gms.internal.gtm.zzwz.zzQ(r7, r6, r14, r8)
            goto L_0x0501
        L_0x01ba:
            int[] r7 = r12.zzc
            r7 = r7[r5]
            r6 = r6 & r10
            long r10 = (long) r6
            java.lang.Object r6 = com.google.android.gms.internal.gtm.zzxy.zzf(r13, r10)
            java.util.List r6 = (java.util.List) r6
            com.google.android.gms.internal.gtm.zzwz.zzX(r7, r6, r14, r9)
            goto L_0x0501
        L_0x01cb:
            int[] r7 = r12.zzc
            r7 = r7[r5]
            r6 = r6 & r10
            long r10 = (long) r6
            java.lang.Object r6 = com.google.android.gms.internal.gtm.zzxy.zzf(r13, r10)
            java.util.List r6 = (java.util.List) r6
            com.google.android.gms.internal.gtm.zzwz.zzW(r7, r6, r14, r9)
            goto L_0x0501
        L_0x01dc:
            int[] r7 = r12.zzc
            r7 = r7[r5]
            r6 = r6 & r10
            long r10 = (long) r6
            java.lang.Object r6 = com.google.android.gms.internal.gtm.zzxy.zzf(r13, r10)
            java.util.List r6 = (java.util.List) r6
            com.google.android.gms.internal.gtm.zzwz.zzV(r7, r6, r14, r9)
            goto L_0x0501
        L_0x01ed:
            int[] r7 = r12.zzc
            r7 = r7[r5]
            r6 = r6 & r10
            long r10 = (long) r6
            java.lang.Object r6 = com.google.android.gms.internal.gtm.zzxy.zzf(r13, r10)
            java.util.List r6 = (java.util.List) r6
            com.google.android.gms.internal.gtm.zzwz.zzU(r7, r6, r14, r9)
            goto L_0x0501
        L_0x01fe:
            int[] r7 = r12.zzc
            r7 = r7[r5]
            r6 = r6 & r10
            long r10 = (long) r6
            java.lang.Object r6 = com.google.android.gms.internal.gtm.zzxy.zzf(r13, r10)
            java.util.List r6 = (java.util.List) r6
            com.google.android.gms.internal.gtm.zzwz.zzM(r7, r6, r14, r9)
            goto L_0x0501
        L_0x020f:
            int[] r7 = r12.zzc
            r7 = r7[r5]
            r6 = r6 & r10
            long r10 = (long) r6
            java.lang.Object r6 = com.google.android.gms.internal.gtm.zzxy.zzf(r13, r10)
            java.util.List r6 = (java.util.List) r6
            com.google.android.gms.internal.gtm.zzwz.zzZ(r7, r6, r14, r9)
            goto L_0x0501
        L_0x0220:
            int[] r7 = r12.zzc
            r7 = r7[r5]
            r6 = r6 & r10
            long r10 = (long) r6
            java.lang.Object r6 = com.google.android.gms.internal.gtm.zzxy.zzf(r13, r10)
            java.util.List r6 = (java.util.List) r6
            com.google.android.gms.internal.gtm.zzwz.zzJ(r7, r6, r14, r9)
            goto L_0x0501
        L_0x0231:
            int[] r7 = r12.zzc
            r7 = r7[r5]
            r6 = r6 & r10
            long r10 = (long) r6
            java.lang.Object r6 = com.google.android.gms.internal.gtm.zzxy.zzf(r13, r10)
            java.util.List r6 = (java.util.List) r6
            com.google.android.gms.internal.gtm.zzwz.zzN(r7, r6, r14, r9)
            goto L_0x0501
        L_0x0242:
            int[] r7 = r12.zzc
            r7 = r7[r5]
            r6 = r6 & r10
            long r10 = (long) r6
            java.lang.Object r6 = com.google.android.gms.internal.gtm.zzxy.zzf(r13, r10)
            java.util.List r6 = (java.util.List) r6
            com.google.android.gms.internal.gtm.zzwz.zzO(r7, r6, r14, r9)
            goto L_0x0501
        L_0x0253:
            int[] r7 = r12.zzc
            r7 = r7[r5]
            r6 = r6 & r10
            long r10 = (long) r6
            java.lang.Object r6 = com.google.android.gms.internal.gtm.zzxy.zzf(r13, r10)
            java.util.List r6 = (java.util.List) r6
            com.google.android.gms.internal.gtm.zzwz.zzR(r7, r6, r14, r9)
            goto L_0x0501
        L_0x0264:
            int[] r7 = r12.zzc
            r7 = r7[r5]
            r6 = r6 & r10
            long r10 = (long) r6
            java.lang.Object r6 = com.google.android.gms.internal.gtm.zzxy.zzf(r13, r10)
            java.util.List r6 = (java.util.List) r6
            com.google.android.gms.internal.gtm.zzwz.zzaa(r7, r6, r14, r9)
            goto L_0x0501
        L_0x0275:
            int[] r7 = r12.zzc
            r7 = r7[r5]
            r6 = r6 & r10
            long r10 = (long) r6
            java.lang.Object r6 = com.google.android.gms.internal.gtm.zzxy.zzf(r13, r10)
            java.util.List r6 = (java.util.List) r6
            com.google.android.gms.internal.gtm.zzwz.zzS(r7, r6, r14, r9)
            goto L_0x0501
        L_0x0286:
            int[] r7 = r12.zzc
            r7 = r7[r5]
            r6 = r6 & r10
            long r10 = (long) r6
            java.lang.Object r6 = com.google.android.gms.internal.gtm.zzxy.zzf(r13, r10)
            java.util.List r6 = (java.util.List) r6
            com.google.android.gms.internal.gtm.zzwz.zzP(r7, r6, r14, r9)
            goto L_0x0501
        L_0x0297:
            int[] r7 = r12.zzc
            r7 = r7[r5]
            r6 = r6 & r10
            long r10 = (long) r6
            java.lang.Object r6 = com.google.android.gms.internal.gtm.zzxy.zzf(r13, r10)
            java.util.List r6 = (java.util.List) r6
            com.google.android.gms.internal.gtm.zzwz.zzL(r7, r6, r14, r9)
            goto L_0x0501
        L_0x02a8:
            int[] r7 = r12.zzc
            r7 = r7[r5]
            r6 = r6 & r10
            long r8 = (long) r6
            java.lang.Object r6 = com.google.android.gms.internal.gtm.zzxy.zzf(r13, r8)
            java.util.List r6 = (java.util.List) r6
            com.google.android.gms.internal.gtm.zzwz.zzX(r7, r6, r14, r4)
            goto L_0x0501
        L_0x02b9:
            int[] r7 = r12.zzc
            r7 = r7[r5]
            r6 = r6 & r10
            long r8 = (long) r6
            java.lang.Object r6 = com.google.android.gms.internal.gtm.zzxy.zzf(r13, r8)
            java.util.List r6 = (java.util.List) r6
            com.google.android.gms.internal.gtm.zzwz.zzW(r7, r6, r14, r4)
            goto L_0x0501
        L_0x02ca:
            int[] r7 = r12.zzc
            r7 = r7[r5]
            r6 = r6 & r10
            long r8 = (long) r6
            java.lang.Object r6 = com.google.android.gms.internal.gtm.zzxy.zzf(r13, r8)
            java.util.List r6 = (java.util.List) r6
            com.google.android.gms.internal.gtm.zzwz.zzV(r7, r6, r14, r4)
            goto L_0x0501
        L_0x02db:
            int[] r7 = r12.zzc
            r7 = r7[r5]
            r6 = r6 & r10
            long r8 = (long) r6
            java.lang.Object r6 = com.google.android.gms.internal.gtm.zzxy.zzf(r13, r8)
            java.util.List r6 = (java.util.List) r6
            com.google.android.gms.internal.gtm.zzwz.zzU(r7, r6, r14, r4)
            goto L_0x0501
        L_0x02ec:
            int[] r7 = r12.zzc
            r7 = r7[r5]
            r6 = r6 & r10
            long r8 = (long) r6
            java.lang.Object r6 = com.google.android.gms.internal.gtm.zzxy.zzf(r13, r8)
            java.util.List r6 = (java.util.List) r6
            com.google.android.gms.internal.gtm.zzwz.zzM(r7, r6, r14, r4)
            goto L_0x0501
        L_0x02fd:
            int[] r7 = r12.zzc
            r7 = r7[r5]
            r6 = r6 & r10
            long r8 = (long) r6
            java.lang.Object r6 = com.google.android.gms.internal.gtm.zzxy.zzf(r13, r8)
            java.util.List r6 = (java.util.List) r6
            com.google.android.gms.internal.gtm.zzwz.zzZ(r7, r6, r14, r4)
            goto L_0x0501
        L_0x030e:
            int[] r7 = r12.zzc
            r7 = r7[r5]
            r6 = r6 & r10
            long r8 = (long) r6
            java.lang.Object r6 = com.google.android.gms.internal.gtm.zzxy.zzf(r13, r8)
            java.util.List r6 = (java.util.List) r6
            com.google.android.gms.internal.gtm.zzwz.zzK(r7, r6, r14)
            goto L_0x0501
        L_0x031f:
            int[] r7 = r12.zzc
            r7 = r7[r5]
            r6 = r6 & r10
            long r8 = (long) r6
            java.lang.Object r6 = com.google.android.gms.internal.gtm.zzxy.zzf(r13, r8)
            java.util.List r6 = (java.util.List) r6
            com.google.android.gms.internal.gtm.zzwx r8 = r12.zzF(r5)
            com.google.android.gms.internal.gtm.zzwz.zzT(r7, r6, r14, r8)
            goto L_0x0501
        L_0x0334:
            int[] r7 = r12.zzc
            r7 = r7[r5]
            r6 = r6 & r10
            long r8 = (long) r6
            java.lang.Object r6 = com.google.android.gms.internal.gtm.zzxy.zzf(r13, r8)
            java.util.List r6 = (java.util.List) r6
            com.google.android.gms.internal.gtm.zzwz.zzY(r7, r6, r14)
            goto L_0x0501
        L_0x0345:
            int[] r7 = r12.zzc
            r7 = r7[r5]
            r6 = r6 & r10
            long r8 = (long) r6
            java.lang.Object r6 = com.google.android.gms.internal.gtm.zzxy.zzf(r13, r8)
            java.util.List r6 = (java.util.List) r6
            com.google.android.gms.internal.gtm.zzwz.zzJ(r7, r6, r14, r4)
            goto L_0x0501
        L_0x0356:
            int[] r7 = r12.zzc
            r7 = r7[r5]
            r6 = r6 & r10
            long r8 = (long) r6
            java.lang.Object r6 = com.google.android.gms.internal.gtm.zzxy.zzf(r13, r8)
            java.util.List r6 = (java.util.List) r6
            com.google.android.gms.internal.gtm.zzwz.zzN(r7, r6, r14, r4)
            goto L_0x0501
        L_0x0367:
            int[] r7 = r12.zzc
            r7 = r7[r5]
            r6 = r6 & r10
            long r8 = (long) r6
            java.lang.Object r6 = com.google.android.gms.internal.gtm.zzxy.zzf(r13, r8)
            java.util.List r6 = (java.util.List) r6
            com.google.android.gms.internal.gtm.zzwz.zzO(r7, r6, r14, r4)
            goto L_0x0501
        L_0x0378:
            int[] r7 = r12.zzc
            r7 = r7[r5]
            r6 = r6 & r10
            long r8 = (long) r6
            java.lang.Object r6 = com.google.android.gms.internal.gtm.zzxy.zzf(r13, r8)
            java.util.List r6 = (java.util.List) r6
            com.google.android.gms.internal.gtm.zzwz.zzR(r7, r6, r14, r4)
            goto L_0x0501
        L_0x0389:
            int[] r7 = r12.zzc
            r7 = r7[r5]
            r6 = r6 & r10
            long r8 = (long) r6
            java.lang.Object r6 = com.google.android.gms.internal.gtm.zzxy.zzf(r13, r8)
            java.util.List r6 = (java.util.List) r6
            com.google.android.gms.internal.gtm.zzwz.zzaa(r7, r6, r14, r4)
            goto L_0x0501
        L_0x039a:
            int[] r7 = r12.zzc
            r7 = r7[r5]
            r6 = r6 & r10
            long r8 = (long) r6
            java.lang.Object r6 = com.google.android.gms.internal.gtm.zzxy.zzf(r13, r8)
            java.util.List r6 = (java.util.List) r6
            com.google.android.gms.internal.gtm.zzwz.zzS(r7, r6, r14, r4)
            goto L_0x0501
        L_0x03ab:
            int[] r7 = r12.zzc
            r7 = r7[r5]
            r6 = r6 & r10
            long r8 = (long) r6
            java.lang.Object r6 = com.google.android.gms.internal.gtm.zzxy.zzf(r13, r8)
            java.util.List r6 = (java.util.List) r6
            com.google.android.gms.internal.gtm.zzwz.zzP(r7, r6, r14, r4)
            goto L_0x0501
        L_0x03bc:
            int[] r7 = r12.zzc
            r7 = r7[r5]
            r6 = r6 & r10
            long r8 = (long) r6
            java.lang.Object r6 = com.google.android.gms.internal.gtm.zzxy.zzf(r13, r8)
            java.util.List r6 = (java.util.List) r6
            com.google.android.gms.internal.gtm.zzwz.zzL(r7, r6, r14, r4)
            goto L_0x0501
        L_0x03cd:
            boolean r8 = r12.zzQ(r13, r5)
            if (r8 == 0) goto L_0x0501
            r6 = r6 & r10
            long r8 = (long) r6
            java.lang.Object r6 = com.google.android.gms.internal.gtm.zzxy.zzf(r13, r8)
            com.google.android.gms.internal.gtm.zzwx r8 = r12.zzF(r5)
            r14.zzq(r7, r6, r8)
            goto L_0x0501
        L_0x03e2:
            boolean r8 = r12.zzQ(r13, r5)
            if (r8 == 0) goto L_0x0501
            r6 = r6 & r10
            long r8 = (long) r6
            long r8 = com.google.android.gms.internal.gtm.zzxy.zzd(r13, r8)
            r14.zzD(r7, r8)
            goto L_0x0501
        L_0x03f3:
            boolean r8 = r12.zzQ(r13, r5)
            if (r8 == 0) goto L_0x0501
            r6 = r6 & r10
            long r8 = (long) r6
            int r6 = com.google.android.gms.internal.gtm.zzxy.zzc(r13, r8)
            r14.zzB(r7, r6)
            goto L_0x0501
        L_0x0404:
            boolean r8 = r12.zzQ(r13, r5)
            if (r8 == 0) goto L_0x0501
            r6 = r6 & r10
            long r8 = (long) r6
            long r8 = com.google.android.gms.internal.gtm.zzxy.zzd(r13, r8)
            r14.zzz(r7, r8)
            goto L_0x0501
        L_0x0415:
            boolean r8 = r12.zzQ(r13, r5)
            if (r8 == 0) goto L_0x0501
            r6 = r6 & r10
            long r8 = (long) r6
            int r6 = com.google.android.gms.internal.gtm.zzxy.zzc(r13, r8)
            r14.zzx(r7, r6)
            goto L_0x0501
        L_0x0426:
            boolean r8 = r12.zzQ(r13, r5)
            if (r8 == 0) goto L_0x0501
            r6 = r6 & r10
            long r8 = (long) r6
            int r6 = com.google.android.gms.internal.gtm.zzxy.zzc(r13, r8)
            r14.zzi(r7, r6)
            goto L_0x0501
        L_0x0437:
            boolean r8 = r12.zzQ(r13, r5)
            if (r8 == 0) goto L_0x0501
            r6 = r6 & r10
            long r8 = (long) r6
            int r6 = com.google.android.gms.internal.gtm.zzxy.zzc(r13, r8)
            r14.zzI(r7, r6)
            goto L_0x0501
        L_0x0448:
            boolean r8 = r12.zzQ(r13, r5)
            if (r8 == 0) goto L_0x0501
            r6 = r6 & r10
            long r8 = (long) r6
            java.lang.Object r6 = com.google.android.gms.internal.gtm.zzxy.zzf(r13, r8)
            com.google.android.gms.internal.gtm.zztd r6 = (com.google.android.gms.internal.gtm.zztd) r6
            r14.zzd(r7, r6)
            goto L_0x0501
        L_0x045b:
            boolean r8 = r12.zzQ(r13, r5)
            if (r8 == 0) goto L_0x0501
            r6 = r6 & r10
            long r8 = (long) r6
            java.lang.Object r6 = com.google.android.gms.internal.gtm.zzxy.zzf(r13, r8)
            com.google.android.gms.internal.gtm.zzwx r8 = r12.zzF(r5)
            r14.zzv(r7, r6, r8)
            goto L_0x0501
        L_0x0470:
            boolean r8 = r12.zzQ(r13, r5)
            if (r8 == 0) goto L_0x0501
            r6 = r6 & r10
            long r8 = (long) r6
            java.lang.Object r6 = com.google.android.gms.internal.gtm.zzxy.zzf(r13, r8)
            zzX(r7, r6, r14)
            goto L_0x0501
        L_0x0481:
            boolean r8 = r12.zzQ(r13, r5)
            if (r8 == 0) goto L_0x0501
            r6 = r6 & r10
            long r8 = (long) r6
            boolean r6 = com.google.android.gms.internal.gtm.zzxy.zzw(r13, r8)
            r14.zzb(r7, r6)
            goto L_0x0501
        L_0x0492:
            boolean r8 = r12.zzQ(r13, r5)
            if (r8 == 0) goto L_0x0501
            r6 = r6 & r10
            long r8 = (long) r6
            int r6 = com.google.android.gms.internal.gtm.zzxy.zzc(r13, r8)
            r14.zzk(r7, r6)
            goto L_0x0501
        L_0x04a2:
            boolean r8 = r12.zzQ(r13, r5)
            if (r8 == 0) goto L_0x0501
            r6 = r6 & r10
            long r8 = (long) r6
            long r8 = com.google.android.gms.internal.gtm.zzxy.zzd(r13, r8)
            r14.zzm(r7, r8)
            goto L_0x0501
        L_0x04b2:
            boolean r8 = r12.zzQ(r13, r5)
            if (r8 == 0) goto L_0x0501
            r6 = r6 & r10
            long r8 = (long) r6
            int r6 = com.google.android.gms.internal.gtm.zzxy.zzc(r13, r8)
            r14.zzr(r7, r6)
            goto L_0x0501
        L_0x04c2:
            boolean r8 = r12.zzQ(r13, r5)
            if (r8 == 0) goto L_0x0501
            r6 = r6 & r10
            long r8 = (long) r6
            long r8 = com.google.android.gms.internal.gtm.zzxy.zzd(r13, r8)
            r14.zzK(r7, r8)
            goto L_0x0501
        L_0x04d2:
            boolean r8 = r12.zzQ(r13, r5)
            if (r8 == 0) goto L_0x0501
            r6 = r6 & r10
            long r8 = (long) r6
            long r8 = com.google.android.gms.internal.gtm.zzxy.zzd(r13, r8)
            r14.zzt(r7, r8)
            goto L_0x0501
        L_0x04e2:
            boolean r8 = r12.zzQ(r13, r5)
            if (r8 == 0) goto L_0x0501
            r6 = r6 & r10
            long r8 = (long) r6
            float r6 = com.google.android.gms.internal.gtm.zzxy.zzb(r13, r8)
            r14.zzo(r7, r6)
            goto L_0x0501
        L_0x04f2:
            boolean r8 = r12.zzQ(r13, r5)
            if (r8 == 0) goto L_0x0501
            r6 = r6 & r10
            long r8 = (long) r6
            double r8 = com.google.android.gms.internal.gtm.zzxy.zza(r13, r8)
            r14.zzf(r7, r8)
        L_0x0501:
            int r5 = r5 + 3
            goto L_0x0029
        L_0x0505:
            if (r2 == 0) goto L_0x051b
            com.google.android.gms.internal.gtm.zzuk<?> r3 = r12.zzp
            r3.zzj(r14, r2)
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x0519
            java.lang.Object r2 = r0.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            goto L_0x0505
        L_0x0519:
            r2 = r1
            goto L_0x0505
        L_0x051b:
            com.google.android.gms.internal.gtm.zzxo<?, ?> r0 = r12.zzo
            java.lang.Object r13 = r0.zzd(r13)
            r0.zzs(r13, r14)
            return
        L_0x0525:
            r12.zzV(r13, r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.gtm.zzwn.zzn(java.lang.Object, com.google.android.gms.internal.gtm.zztp):void");
    }
}
