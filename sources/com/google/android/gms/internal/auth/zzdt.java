package com.google.android.gms.internal.auth;

import java.io.IOException;
import net.bytebuddy.jar.asm.Opcodes;

final class zzdt {
    static int zza(byte[] bArr, int i10, zzds zzds) throws zzfa {
        int zzj = zzj(bArr, i10, zzds);
        int i11 = zzds.zza;
        if (i11 < 0) {
            throw zzfa.zzc();
        } else if (i11 > bArr.length - zzj) {
            throw zzfa.zzf();
        } else if (i11 == 0) {
            zzds.zzc = zzee.zzb;
            return zzj;
        } else {
            zzds.zzc = zzee.zzk(bArr, zzj, i11);
            return zzj + i11;
        }
    }

    static int zzb(byte[] bArr, int i10) {
        return ((bArr[i10 + 3] & 255) << 24) | (bArr[i10] & 255) | ((bArr[i10 + 1] & 255) << 8) | ((bArr[i10 + 2] & 255) << Tnaf.POW_2_WIDTH);
    }

    static int zzc(zzgh zzgh, byte[] bArr, int i10, int i11, int i12, zzds zzds) throws IOException {
        zzfz zzfz = (zzfz) zzgh;
        Object zzd = zzfz.zzd();
        int zzb = zzfz.zzb(zzd, bArr, i10, i11, i12, zzds);
        zzfz.zze(zzd);
        zzds.zzc = zzd;
        return zzb;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v6, resolved type: byte} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static int zzd(com.google.android.gms.internal.auth.zzgh r6, byte[] r7, int r8, int r9, com.google.android.gms.internal.auth.zzds r10) throws java.io.IOException {
        /*
            int r0 = r8 + 1
            byte r8 = r7[r8]
            if (r8 >= 0) goto L_0x000c
            int r0 = zzk(r8, r7, r0, r10)
            int r8 = r10.zza
        L_0x000c:
            r3 = r0
            if (r8 < 0) goto L_0x0025
            int r9 = r9 - r3
            if (r8 > r9) goto L_0x0025
            java.lang.Object r9 = r6.zzd()
            int r8 = r8 + r3
            r0 = r6
            r1 = r9
            r2 = r7
            r4 = r8
            r5 = r10
            r0.zzg(r1, r2, r3, r4, r5)
            r6.zze(r9)
            r10.zzc = r9
            return r8
        L_0x0025:
            com.google.android.gms.internal.auth.zzfa r6 = com.google.android.gms.internal.auth.zzfa.zzf()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.auth.zzdt.zzd(com.google.android.gms.internal.auth.zzgh, byte[], int, int, com.google.android.gms.internal.auth.zzds):int");
    }

    static int zze(zzgh zzgh, int i10, byte[] bArr, int i11, int i12, zzey zzey, zzds zzds) throws IOException {
        int zzd = zzd(zzgh, bArr, i11, i12, zzds);
        zzey.add(zzds.zzc);
        while (zzd < i12) {
            int zzj = zzj(bArr, zzd, zzds);
            if (i10 != zzds.zza) {
                break;
            }
            zzd = zzd(zzgh, bArr, zzj, i12, zzds);
            zzey.add(zzds.zzc);
        }
        return zzd;
    }

    static int zzf(byte[] bArr, int i10, zzey zzey, zzds zzds) throws IOException {
        zzev zzev = (zzev) zzey;
        int zzj = zzj(bArr, i10, zzds);
        int i11 = zzds.zza + zzj;
        while (zzj < i11) {
            zzj = zzj(bArr, zzj, zzds);
            zzev.zze(zzds.zza);
        }
        if (zzj == i11) {
            return zzj;
        }
        throw zzfa.zzf();
    }

    static int zzg(byte[] bArr, int i10, zzds zzds) throws zzfa {
        int zzj = zzj(bArr, i10, zzds);
        int i11 = zzds.zza;
        if (i11 < 0) {
            throw zzfa.zzc();
        } else if (i11 == 0) {
            zzds.zzc = "";
            return zzj;
        } else {
            zzds.zzc = new String(bArr, zzj, i11, zzez.zzb);
            return zzj + i11;
        }
    }

    static int zzh(byte[] bArr, int i10, zzds zzds) throws zzfa {
        int zzj = zzj(bArr, i10, zzds);
        int i11 = zzds.zza;
        if (i11 < 0) {
            throw zzfa.zzc();
        } else if (i11 == 0) {
            zzds.zzc = "";
            return zzj;
        } else {
            zzds.zzc = zzhm.zzb(bArr, zzj, i11);
            return zzj + i11;
        }
    }

    static int zzi(int i10, byte[] bArr, int i11, int i12, zzgz zzgz, zzds zzds) throws zzfa {
        if ((i10 >>> 3) != 0) {
            int i13 = i10 & 7;
            if (i13 == 0) {
                int zzm = zzm(bArr, i11, zzds);
                zzgz.zzf(i10, Long.valueOf(zzds.zzb));
                return zzm;
            } else if (i13 == 1) {
                zzgz.zzf(i10, Long.valueOf(zzn(bArr, i11)));
                return i11 + 8;
            } else if (i13 == 2) {
                int zzj = zzj(bArr, i11, zzds);
                int i14 = zzds.zza;
                if (i14 < 0) {
                    throw zzfa.zzc();
                } else if (i14 <= bArr.length - zzj) {
                    if (i14 == 0) {
                        zzgz.zzf(i10, zzee.zzb);
                    } else {
                        zzgz.zzf(i10, zzee.zzk(bArr, zzj, i14));
                    }
                    return zzj + i14;
                } else {
                    throw zzfa.zzf();
                }
            } else if (i13 == 3) {
                int i15 = (i10 & -8) | 4;
                zzgz zzc = zzgz.zzc();
                int i16 = 0;
                while (true) {
                    if (i11 >= i12) {
                        break;
                    }
                    int zzj2 = zzj(bArr, i11, zzds);
                    int i17 = zzds.zza;
                    if (i17 == i15) {
                        i16 = i17;
                        i11 = zzj2;
                        break;
                    }
                    i16 = i17;
                    i11 = zzi(i17, bArr, zzj2, i12, zzc, zzds);
                }
                if (i11 > i12 || i16 != i15) {
                    throw zzfa.zzd();
                }
                zzgz.zzf(i10, zzc);
                return i11;
            } else if (i13 == 5) {
                zzgz.zzf(i10, Integer.valueOf(zzb(bArr, i11)));
                return i11 + 4;
            } else {
                throw zzfa.zza();
            }
        } else {
            throw zzfa.zza();
        }
    }

    static int zzj(byte[] bArr, int i10, zzds zzds) {
        int i11 = i10 + 1;
        byte b10 = bArr[i10];
        if (b10 < 0) {
            return zzk(b10, bArr, i11, zzds);
        }
        zzds.zza = b10;
        return i11;
    }

    static int zzk(int i10, byte[] bArr, int i11, zzds zzds) {
        int i12 = i10 & Opcodes.LAND;
        int i13 = i11 + 1;
        byte b10 = bArr[i11];
        if (b10 >= 0) {
            zzds.zza = i12 | (b10 << 7);
            return i13;
        }
        int i14 = i12 | ((b10 & Byte.MAX_VALUE) << 7);
        int i15 = i13 + 1;
        byte b11 = bArr[i13];
        if (b11 >= 0) {
            zzds.zza = i14 | (b11 << 14);
            return i15;
        }
        int i16 = i14 | ((b11 & Byte.MAX_VALUE) << 14);
        int i17 = i15 + 1;
        byte b12 = bArr[i15];
        if (b12 >= 0) {
            zzds.zza = i16 | (b12 << 21);
            return i17;
        }
        int i18 = i16 | ((b12 & Byte.MAX_VALUE) << 21);
        int i19 = i17 + 1;
        byte b13 = bArr[i17];
        if (b13 >= 0) {
            zzds.zza = i18 | (b13 << 28);
            return i19;
        }
        int i20 = i18 | ((b13 & Byte.MAX_VALUE) << 28);
        while (true) {
            int i21 = i19 + 1;
            if (bArr[i19] < 0) {
                i19 = i21;
            } else {
                zzds.zza = i20;
                return i21;
            }
        }
    }

    static int zzl(int i10, byte[] bArr, int i11, int i12, zzey zzey, zzds zzds) {
        zzev zzev = (zzev) zzey;
        int zzj = zzj(bArr, i11, zzds);
        zzev.zze(zzds.zza);
        while (zzj < i12) {
            int zzj2 = zzj(bArr, zzj, zzds);
            if (i10 != zzds.zza) {
                break;
            }
            zzj = zzj(bArr, zzj2, zzds);
            zzev.zze(zzds.zza);
        }
        return zzj;
    }

    static int zzm(byte[] bArr, int i10, zzds zzds) {
        int i11 = i10 + 1;
        long j10 = (long) bArr[i10];
        if (j10 >= 0) {
            zzds.zzb = j10;
            return i11;
        }
        int i12 = i11 + 1;
        byte b10 = bArr[i11];
        long j11 = (j10 & 127) | (((long) (b10 & Byte.MAX_VALUE)) << 7);
        int i13 = 7;
        while (b10 < 0) {
            int i14 = i12 + 1;
            byte b11 = bArr[i12];
            i13 += 7;
            j11 |= ((long) (b11 & Byte.MAX_VALUE)) << i13;
            int i15 = i14;
            b10 = b11;
            i12 = i15;
        }
        zzds.zzb = j11;
        return i12;
    }

    static long zzn(byte[] bArr, int i10) {
        return ((((long) bArr[i10 + 7]) & 255) << 56) | (((long) bArr[i10]) & 255) | ((((long) bArr[i10 + 1]) & 255) << 8) | ((((long) bArr[i10 + 2]) & 255) << 16) | ((((long) bArr[i10 + 3]) & 255) << 24) | ((((long) bArr[i10 + 4]) & 255) << 32) | ((((long) bArr[i10 + 5]) & 255) << 40) | ((((long) bArr[i10 + 6]) & 255) << 48);
    }
}
