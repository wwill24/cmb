package com.google.android.gms.internal.auth;

final class zzhm {
    private static final zzhk zza = new zzhl();

    static {
        if (zzhi.zzu() && zzhi.zzv()) {
            int i10 = zzdr.zza;
        }
    }

    static /* bridge */ /* synthetic */ int zza(byte[] bArr, int i10, int i11) {
        byte b10 = bArr[i10 - 1];
        int i12 = i11 - i10;
        if (i12 != 0) {
            if (i12 == 1) {
                byte b11 = bArr[i10];
                if (b10 <= -12 && b11 <= -65) {
                    return b10 ^ (b11 << 8);
                }
            } else if (i12 == 2) {
                byte b12 = bArr[i10];
                byte b13 = bArr[i10 + 1];
                if (b10 <= -12 && b12 <= -65 && b13 <= -65) {
                    return ((b12 << 8) ^ b10) ^ (b13 << Tnaf.POW_2_WIDTH);
                }
            } else {
                throw new AssertionError();
            }
        } else if (b10 <= -12) {
            return b10;
        }
        return -1;
    }

    static String zzb(byte[] bArr, int i10, int i11) throws zzfa {
        int i12;
        int length = bArr.length;
        if ((i10 | i11 | ((length - i10) - i11)) >= 0) {
            int i13 = i10 + i11;
            char[] cArr = new char[i11];
            int i14 = 0;
            while (r11 < i13) {
                byte b10 = bArr[r11];
                if (!zzhj.zzd(b10)) {
                    break;
                }
                i10 = r11 + 1;
                cArr[i12] = (char) b10;
                i14 = i12 + 1;
            }
            while (r11 < i13) {
                int i15 = r11 + 1;
                byte b11 = bArr[r11];
                if (zzhj.zzd(b11)) {
                    int i16 = i12 + 1;
                    cArr[i12] = (char) b11;
                    r11 = i15;
                    while (true) {
                        i12 = i16;
                        if (r11 >= i13) {
                            break;
                        }
                        byte b12 = bArr[r11];
                        if (!zzhj.zzd(b12)) {
                            break;
                        }
                        r11++;
                        i16 = i12 + 1;
                        cArr[i12] = (char) b12;
                    }
                } else if (b11 < -32) {
                    if (i15 < i13) {
                        zzhj.zzc(b11, bArr[i15], cArr, i12);
                        r11 = i15 + 1;
                        i12++;
                    } else {
                        throw zzfa.zzb();
                    }
                } else if (b11 < -16) {
                    if (i15 < i13 - 1) {
                        int i17 = i15 + 1;
                        zzhj.zzb(b11, bArr[i15], bArr[i17], cArr, i12);
                        r11 = i17 + 1;
                        i12++;
                    } else {
                        throw zzfa.zzb();
                    }
                } else if (i15 < i13 - 2) {
                    int i18 = i15 + 1;
                    int i19 = i18 + 1;
                    zzhj.zza(b11, bArr[i15], bArr[i18], bArr[i19], cArr, i12);
                    i12 += 2;
                    r11 = i19 + 1;
                } else {
                    throw zzfa.zzb();
                }
            }
            return new String(cArr, 0, i12);
        }
        throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", new Object[]{Integer.valueOf(length), Integer.valueOf(i10), Integer.valueOf(i11)}));
    }

    static boolean zzc(byte[] bArr) {
        return zza.zzb(bArr, 0, bArr.length);
    }

    static boolean zzd(byte[] bArr, int i10, int i11) {
        return zza.zzb(bArr, i10, i11);
    }
}
