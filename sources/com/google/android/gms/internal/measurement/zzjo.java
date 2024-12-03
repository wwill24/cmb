package com.google.android.gms.internal.measurement;

import java.io.IOException;
import net.bytebuddy.jar.asm.Opcodes;

final class zzjo {
    static int zza(byte[] bArr, int i10, zzjn zzjn) throws zzll {
        int zzj = zzj(bArr, i10, zzjn);
        int i11 = zzjn.zza;
        if (i11 < 0) {
            throw zzll.zzd();
        } else if (i11 > bArr.length - zzj) {
            throw zzll.zzf();
        } else if (i11 == 0) {
            zzjn.zzc = zzka.zzb;
            return zzj;
        } else {
            zzjn.zzc = zzka.zzl(bArr, zzj, i11);
            return zzj + i11;
        }
    }

    static int zzb(byte[] bArr, int i10) {
        int i11 = (bArr[i10 + 1] & 255) << 8;
        return ((bArr[i10 + 3] & 255) << 24) | i11 | (bArr[i10] & 255) | ((bArr[i10 + 2] & 255) << Tnaf.POW_2_WIDTH);
    }

    static int zzc(zzmt zzmt, byte[] bArr, int i10, int i11, int i12, zzjn zzjn) throws IOException {
        Object zze = zzmt.zze();
        int zzn = zzn(zze, zzmt, bArr, i10, i11, i12, zzjn);
        zzmt.zzf(zze);
        zzjn.zzc = zze;
        return zzn;
    }

    static int zzd(zzmt zzmt, byte[] bArr, int i10, int i11, zzjn zzjn) throws IOException {
        Object zze = zzmt.zze();
        int zzo = zzo(zze, zzmt, bArr, i10, i11, zzjn);
        zzmt.zzf(zze);
        zzjn.zzc = zze;
        return zzo;
    }

    static int zze(zzmt zzmt, int i10, byte[] bArr, int i11, int i12, zzli zzli, zzjn zzjn) throws IOException {
        int zzd = zzd(zzmt, bArr, i11, i12, zzjn);
        zzli.add(zzjn.zzc);
        while (zzd < i12) {
            int zzj = zzj(bArr, zzd, zzjn);
            if (i10 != zzjn.zza) {
                break;
            }
            zzd = zzd(zzmt, bArr, zzj, i12, zzjn);
            zzli.add(zzjn.zzc);
        }
        return zzd;
    }

    static int zzf(byte[] bArr, int i10, zzli zzli, zzjn zzjn) throws IOException {
        zzlc zzlc = (zzlc) zzli;
        int zzj = zzj(bArr, i10, zzjn);
        int i11 = zzjn.zza + zzj;
        while (zzj < i11) {
            zzj = zzj(bArr, zzj, zzjn);
            zzlc.zzh(zzjn.zza);
        }
        if (zzj == i11) {
            return zzj;
        }
        throw zzll.zzf();
    }

    static int zzg(byte[] bArr, int i10, zzjn zzjn) throws zzll {
        int zzj = zzj(bArr, i10, zzjn);
        int i11 = zzjn.zza;
        if (i11 < 0) {
            throw zzll.zzd();
        } else if (i11 == 0) {
            zzjn.zzc = "";
            return zzj;
        } else {
            zzjn.zzc = new String(bArr, zzj, i11, zzlj.zzb);
            return zzj + i11;
        }
    }

    static int zzh(byte[] bArr, int i10, zzjn zzjn) throws zzll {
        int i11;
        int i12;
        int zzj = zzj(bArr, i10, zzjn);
        int i13 = zzjn.zza;
        if (i13 < 0) {
            throw zzll.zzd();
        } else if (i13 == 0) {
            zzjn.zzc = "";
            return zzj;
        } else {
            int i14 = zznz.zza;
            int length = bArr.length;
            if ((((length - zzj) - i13) | zzj | i13) >= 0) {
                int i15 = zzj + i13;
                char[] cArr = new char[i13];
                int i16 = 0;
                while (i11 < i15) {
                    byte b10 = bArr[i11];
                    if (!zznv.zzd(b10)) {
                        break;
                    }
                    zzj = i11 + 1;
                    cArr[i12] = (char) b10;
                    i16 = i12 + 1;
                }
                while (i11 < i15) {
                    int i17 = i11 + 1;
                    byte b11 = bArr[i11];
                    if (zznv.zzd(b11)) {
                        int i18 = i12 + 1;
                        cArr[i12] = (char) b11;
                        i11 = i17;
                        while (true) {
                            i12 = i18;
                            if (i11 >= i15) {
                                break;
                            }
                            byte b12 = bArr[i11];
                            if (!zznv.zzd(b12)) {
                                break;
                            }
                            i11++;
                            i18 = i12 + 1;
                            cArr[i12] = (char) b12;
                        }
                    } else if (b11 < -32) {
                        if (i17 < i15) {
                            zznv.zzc(b11, bArr[i17], cArr, i12);
                            i11 = i17 + 1;
                            i12++;
                        } else {
                            throw zzll.zzc();
                        }
                    } else if (b11 < -16) {
                        if (i17 < i15 - 1) {
                            int i19 = i17 + 1;
                            zznv.zzb(b11, bArr[i17], bArr[i19], cArr, i12);
                            i11 = i19 + 1;
                            i12++;
                        } else {
                            throw zzll.zzc();
                        }
                    } else if (i17 < i15 - 2) {
                        int i20 = i17 + 1;
                        byte b13 = bArr[i17];
                        int i21 = i20 + 1;
                        zznv.zza(b11, b13, bArr[i20], bArr[i21], cArr, i12);
                        i12 += 2;
                        i11 = i21 + 1;
                    } else {
                        throw zzll.zzc();
                    }
                }
                zzjn.zzc = new String(cArr, 0, i12);
                return i15;
            }
            throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", new Object[]{Integer.valueOf(length), Integer.valueOf(zzj), Integer.valueOf(i13)}));
        }
    }

    static int zzi(int i10, byte[] bArr, int i11, int i12, zznl zznl, zzjn zzjn) throws zzll {
        if ((i10 >>> 3) != 0) {
            int i13 = i10 & 7;
            if (i13 == 0) {
                int zzm = zzm(bArr, i11, zzjn);
                zznl.zzj(i10, Long.valueOf(zzjn.zzb));
                return zzm;
            } else if (i13 == 1) {
                zznl.zzj(i10, Long.valueOf(zzp(bArr, i11)));
                return i11 + 8;
            } else if (i13 == 2) {
                int zzj = zzj(bArr, i11, zzjn);
                int i14 = zzjn.zza;
                if (i14 < 0) {
                    throw zzll.zzd();
                } else if (i14 <= bArr.length - zzj) {
                    if (i14 == 0) {
                        zznl.zzj(i10, zzka.zzb);
                    } else {
                        zznl.zzj(i10, zzka.zzl(bArr, zzj, i14));
                    }
                    return zzj + i14;
                } else {
                    throw zzll.zzf();
                }
            } else if (i13 == 3) {
                int i15 = (i10 & -8) | 4;
                zznl zzf = zznl.zzf();
                int i16 = 0;
                while (true) {
                    if (i11 >= i12) {
                        break;
                    }
                    int zzj2 = zzj(bArr, i11, zzjn);
                    int i17 = zzjn.zza;
                    i16 = i17;
                    if (i17 == i15) {
                        i11 = zzj2;
                        break;
                    }
                    int zzi = zzi(i16, bArr, zzj2, i12, zzf, zzjn);
                    i16 = i17;
                    i11 = zzi;
                }
                if (i11 > i12 || i16 != i15) {
                    throw zzll.zze();
                }
                zznl.zzj(i10, zzf);
                return i11;
            } else if (i13 == 5) {
                zznl.zzj(i10, Integer.valueOf(zzb(bArr, i11)));
                return i11 + 4;
            } else {
                throw zzll.zzb();
            }
        } else {
            throw zzll.zzb();
        }
    }

    static int zzj(byte[] bArr, int i10, zzjn zzjn) {
        int i11 = i10 + 1;
        byte b10 = bArr[i10];
        if (b10 < 0) {
            return zzk(b10, bArr, i11, zzjn);
        }
        zzjn.zza = b10;
        return i11;
    }

    static int zzk(int i10, byte[] bArr, int i11, zzjn zzjn) {
        byte b10 = bArr[i11];
        int i12 = i11 + 1;
        int i13 = i10 & Opcodes.LAND;
        if (b10 >= 0) {
            zzjn.zza = i13 | (b10 << 7);
            return i12;
        }
        int i14 = i13 | ((b10 & Byte.MAX_VALUE) << 7);
        int i15 = i12 + 1;
        byte b11 = bArr[i12];
        if (b11 >= 0) {
            zzjn.zza = i14 | (b11 << 14);
            return i15;
        }
        int i16 = i14 | ((b11 & Byte.MAX_VALUE) << 14);
        int i17 = i15 + 1;
        byte b12 = bArr[i15];
        if (b12 >= 0) {
            zzjn.zza = i16 | (b12 << 21);
            return i17;
        }
        int i18 = i16 | ((b12 & Byte.MAX_VALUE) << 21);
        int i19 = i17 + 1;
        byte b13 = bArr[i17];
        if (b13 >= 0) {
            zzjn.zza = i18 | (b13 << 28);
            return i19;
        }
        int i20 = i18 | ((b13 & Byte.MAX_VALUE) << 28);
        while (true) {
            int i21 = i19 + 1;
            if (bArr[i19] < 0) {
                i19 = i21;
            } else {
                zzjn.zza = i20;
                return i21;
            }
        }
    }

    static int zzl(int i10, byte[] bArr, int i11, int i12, zzli zzli, zzjn zzjn) {
        zzlc zzlc = (zzlc) zzli;
        int zzj = zzj(bArr, i11, zzjn);
        zzlc.zzh(zzjn.zza);
        while (zzj < i12) {
            int zzj2 = zzj(bArr, zzj, zzjn);
            if (i10 != zzjn.zza) {
                break;
            }
            zzj = zzj(bArr, zzj2, zzjn);
            zzlc.zzh(zzjn.zza);
        }
        return zzj;
    }

    static int zzm(byte[] bArr, int i10, zzjn zzjn) {
        long j10 = (long) bArr[i10];
        int i11 = i10 + 1;
        if (j10 >= 0) {
            zzjn.zzb = j10;
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
        zzjn.zzb = j11;
        return i12;
    }

    static int zzn(Object obj, zzmt zzmt, byte[] bArr, int i10, int i11, int i12, zzjn zzjn) throws IOException {
        int zzc = ((zzml) zzmt).zzc(obj, bArr, i10, i11, i12, zzjn);
        zzjn.zzc = obj;
        return zzc;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v6, resolved type: byte} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static int zzo(java.lang.Object r6, com.google.android.gms.internal.measurement.zzmt r7, byte[] r8, int r9, int r10, com.google.android.gms.internal.measurement.zzjn r11) throws java.io.IOException {
        /*
            int r0 = r9 + 1
            byte r9 = r8[r9]
            if (r9 >= 0) goto L_0x000c
            int r0 = zzk(r9, r8, r0, r11)
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
            r0.zzh(r1, r2, r3, r4, r5)
            r11.zzc = r6
            return r9
        L_0x001e:
            com.google.android.gms.internal.measurement.zzll r6 = com.google.android.gms.internal.measurement.zzll.zzf()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzjo.zzo(java.lang.Object, com.google.android.gms.internal.measurement.zzmt, byte[], int, int, com.google.android.gms.internal.measurement.zzjn):int");
    }

    static long zzp(byte[] bArr, int i10) {
        return (((long) bArr[i10]) & 255) | ((((long) bArr[i10 + 1]) & 255) << 8) | ((((long) bArr[i10 + 2]) & 255) << 16) | ((((long) bArr[i10 + 3]) & 255) << 24) | ((((long) bArr[i10 + 4]) & 255) << 32) | ((((long) bArr[i10 + 5]) & 255) << 40) | ((((long) bArr[i10 + 6]) & 255) << 48) | ((((long) bArr[i10 + 7]) & 255) << 56);
    }
}
