package com.google.android.gms.internal.p003firebaseauthapi;

import java.io.IOException;
import net.bytebuddy.jar.asm.Opcodes;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzait  reason: invalid package */
final class zzait {
    static int zza(byte[] bArr, int i10, zzais zzais) throws zzaks {
        int zzh = zzh(bArr, i10, zzais);
        int i11 = zzais.zza;
        if (i11 < 0) {
            throw zzaks.zzf();
        } else if (i11 > bArr.length - zzh) {
            throw zzaks.zzj();
        } else if (i11 == 0) {
            zzais.zzc = zzajf.zzb;
            return zzh;
        } else {
            zzais.zzc = zzajf.zzn(bArr, zzh, i11);
            return zzh + i11;
        }
    }

    static int zzb(byte[] bArr, int i10) {
        int i11 = (bArr[i10 + 1] & 255) << 8;
        return ((bArr[i10 + 3] & 255) << 24) | i11 | (bArr[i10] & 255) | ((bArr[i10 + 2] & 255) << Tnaf.POW_2_WIDTH);
    }

    static int zzc(zzamb zzamb, byte[] bArr, int i10, int i11, int i12, zzais zzais) throws IOException {
        Object zze = zzamb.zze();
        int zzl = zzl(zze, zzamb, bArr, i10, i11, i12, zzais);
        zzamb.zzf(zze);
        zzais.zzc = zze;
        return zzl;
    }

    static int zzd(zzamb zzamb, byte[] bArr, int i10, int i11, zzais zzais) throws IOException {
        Object zze = zzamb.zze();
        int zzm = zzm(zze, zzamb, bArr, i10, i11, zzais);
        zzamb.zzf(zze);
        zzais.zzc = zze;
        return zzm;
    }

    static int zze(zzamb zzamb, int i10, byte[] bArr, int i11, int i12, zzakp zzakp, zzais zzais) throws IOException {
        int zzd = zzd(zzamb, bArr, i11, i12, zzais);
        zzakp.add(zzais.zzc);
        while (zzd < i12) {
            int zzh = zzh(bArr, zzd, zzais);
            if (i10 != zzais.zza) {
                break;
            }
            zzd = zzd(zzamb, bArr, zzh, i12, zzais);
            zzakp.add(zzais.zzc);
        }
        return zzd;
    }

    static int zzf(byte[] bArr, int i10, zzakp zzakp, zzais zzais) throws IOException {
        zzakl zzakl = (zzakl) zzakp;
        int zzh = zzh(bArr, i10, zzais);
        int i11 = zzais.zza + zzh;
        while (zzh < i11) {
            zzh = zzh(bArr, zzh, zzais);
            zzakl.zzf(zzais.zza);
        }
        if (zzh == i11) {
            return zzh;
        }
        throw zzaks.zzj();
    }

    static int zzg(int i10, byte[] bArr, int i11, int i12, zzamw zzamw, zzais zzais) throws zzaks {
        if ((i10 >>> 3) != 0) {
            int i13 = i10 & 7;
            if (i13 == 0) {
                int zzk = zzk(bArr, i11, zzais);
                zzamw.zzj(i10, Long.valueOf(zzais.zzb));
                return zzk;
            } else if (i13 == 1) {
                zzamw.zzj(i10, Long.valueOf(zzn(bArr, i11)));
                return i11 + 8;
            } else if (i13 == 2) {
                int zzh = zzh(bArr, i11, zzais);
                int i14 = zzais.zza;
                if (i14 < 0) {
                    throw zzaks.zzf();
                } else if (i14 <= bArr.length - zzh) {
                    if (i14 == 0) {
                        zzamw.zzj(i10, zzajf.zzb);
                    } else {
                        zzamw.zzj(i10, zzajf.zzn(bArr, zzh, i14));
                    }
                    return zzh + i14;
                } else {
                    throw zzaks.zzj();
                }
            } else if (i13 == 3) {
                int i15 = (i10 & -8) | 4;
                zzamw zzf = zzamw.zzf();
                int i16 = 0;
                while (true) {
                    if (i11 >= i12) {
                        break;
                    }
                    int zzh2 = zzh(bArr, i11, zzais);
                    int i17 = zzais.zza;
                    i16 = i17;
                    if (i17 == i15) {
                        i11 = zzh2;
                        break;
                    }
                    int zzg = zzg(i16, bArr, zzh2, i12, zzf, zzais);
                    i16 = i17;
                    i11 = zzg;
                }
                if (i11 > i12 || i16 != i15) {
                    throw zzaks.zzg();
                }
                zzamw.zzj(i10, zzf);
                return i11;
            } else if (i13 == 5) {
                zzamw.zzj(i10, Integer.valueOf(zzb(bArr, i11)));
                return i11 + 4;
            } else {
                throw zzaks.zzc();
            }
        } else {
            throw zzaks.zzc();
        }
    }

    static int zzh(byte[] bArr, int i10, zzais zzais) {
        int i11 = i10 + 1;
        byte b10 = bArr[i10];
        if (b10 < 0) {
            return zzi(b10, bArr, i11, zzais);
        }
        zzais.zza = b10;
        return i11;
    }

    static int zzi(int i10, byte[] bArr, int i11, zzais zzais) {
        byte b10 = bArr[i11];
        int i12 = i11 + 1;
        int i13 = i10 & Opcodes.LAND;
        if (b10 >= 0) {
            zzais.zza = i13 | (b10 << 7);
            return i12;
        }
        int i14 = i13 | ((b10 & Byte.MAX_VALUE) << 7);
        int i15 = i12 + 1;
        byte b11 = bArr[i12];
        if (b11 >= 0) {
            zzais.zza = i14 | (b11 << 14);
            return i15;
        }
        int i16 = i14 | ((b11 & Byte.MAX_VALUE) << 14);
        int i17 = i15 + 1;
        byte b12 = bArr[i15];
        if (b12 >= 0) {
            zzais.zza = i16 | (b12 << 21);
            return i17;
        }
        int i18 = i16 | ((b12 & Byte.MAX_VALUE) << 21);
        int i19 = i17 + 1;
        byte b13 = bArr[i17];
        if (b13 >= 0) {
            zzais.zza = i18 | (b13 << 28);
            return i19;
        }
        int i20 = i18 | ((b13 & Byte.MAX_VALUE) << 28);
        while (true) {
            int i21 = i19 + 1;
            if (bArr[i19] < 0) {
                i19 = i21;
            } else {
                zzais.zza = i20;
                return i21;
            }
        }
    }

    static int zzj(int i10, byte[] bArr, int i11, int i12, zzakp zzakp, zzais zzais) {
        zzakl zzakl = (zzakl) zzakp;
        int zzh = zzh(bArr, i11, zzais);
        zzakl.zzf(zzais.zza);
        while (zzh < i12) {
            int zzh2 = zzh(bArr, zzh, zzais);
            if (i10 != zzais.zza) {
                break;
            }
            zzh = zzh(bArr, zzh2, zzais);
            zzakl.zzf(zzais.zza);
        }
        return zzh;
    }

    static int zzk(byte[] bArr, int i10, zzais zzais) {
        long j10 = (long) bArr[i10];
        int i11 = i10 + 1;
        if (j10 >= 0) {
            zzais.zzb = j10;
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
            byte b12 = b11;
            i12 = i14;
            b10 = b12;
        }
        zzais.zzb = j11;
        return i12;
    }

    static int zzl(Object obj, zzamb zzamb, byte[] bArr, int i10, int i11, int i12, zzais zzais) throws IOException {
        int zzc = ((zzals) zzamb).zzc(obj, bArr, i10, i11, i12, zzais);
        zzais.zzc = obj;
        return zzc;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v6, resolved type: byte} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static int zzm(java.lang.Object r6, com.google.android.gms.internal.p003firebaseauthapi.zzamb r7, byte[] r8, int r9, int r10, com.google.android.gms.internal.p003firebaseauthapi.zzais r11) throws java.io.IOException {
        /*
            int r0 = r9 + 1
            byte r9 = r8[r9]
            if (r9 >= 0) goto L_0x000c
            int r0 = zzi(r9, r8, r0, r11)
            int r9 = r11.zza
        L_0x000c:
            r3 = r0
            if (r9 < 0) goto L_0x001e
            int r10 = r10 - r3
            if (r9 > r10) goto L_0x001e
            int r9 = r9 + r3
            r0 = r7
            r1 = r6
            r2 = r8
            r4 = r9
            r5 = r11
            r0.zzi(r1, r2, r3, r4, r5)
            r11.zzc = r6
            return r9
        L_0x001e:
            com.google.android.gms.internal.firebase-auth-api.zzaks r6 = com.google.android.gms.internal.p003firebaseauthapi.zzaks.zzj()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p003firebaseauthapi.zzait.zzm(java.lang.Object, com.google.android.gms.internal.firebase-auth-api.zzamb, byte[], int, int, com.google.android.gms.internal.firebase-auth-api.zzais):int");
    }

    static long zzn(byte[] bArr, int i10) {
        return (((long) bArr[i10]) & 255) | ((((long) bArr[i10 + 1]) & 255) << 8) | ((((long) bArr[i10 + 2]) & 255) << 16) | ((((long) bArr[i10 + 3]) & 255) << 24) | ((((long) bArr[i10 + 4]) & 255) << 32) | ((((long) bArr[i10 + 5]) & 255) << 40) | ((((long) bArr[i10 + 6]) & 255) << 48) | ((((long) bArr[i10 + 7]) & 255) << 56);
    }
}
