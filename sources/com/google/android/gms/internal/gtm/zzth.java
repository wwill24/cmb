package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.api.a;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import net.bytebuddy.jar.asm.Opcodes;

final class zzth extends zztj {
    private final InputStream zze;
    private final byte[] zzf;
    private int zzg;
    private int zzh;
    private int zzi;
    private int zzj;
    private int zzk;
    private int zzl = a.e.API_PRIORITY_OTHER;

    /* synthetic */ zzth(InputStream inputStream, int i10, zztg zztg) {
        super((zzti) null);
        zzvi.zzf(inputStream, "input");
        this.zze = inputStream;
        this.zzf = new byte[Opcodes.ACC_SYNTHETIC];
        this.zzg = 0;
        this.zzi = 0;
        this.zzk = 0;
    }

    private final List<byte[]> zzu(int i10) throws IOException {
        ArrayList arrayList = new ArrayList();
        while (i10 > 0) {
            int min = Math.min(i10, Opcodes.ACC_SYNTHETIC);
            byte[] bArr = new byte[min];
            int i11 = 0;
            while (i11 < min) {
                int read = this.zze.read(bArr, i11, min - i11);
                if (read != -1) {
                    this.zzk += read;
                    i11 += read;
                } else {
                    throw zzvk.zzj();
                }
            }
            i10 -= min;
            arrayList.add(bArr);
        }
        return arrayList;
    }

    private final void zzv() {
        int i10 = this.zzg + this.zzh;
        this.zzg = i10;
        int i11 = this.zzk + i10;
        int i12 = this.zzl;
        if (i11 > i12) {
            int i13 = i11 - i12;
            this.zzh = i13;
            this.zzg = i10 - i13;
            return;
        }
        this.zzh = 0;
    }

    private final void zzw(int i10) throws IOException {
        if (zzx(i10)) {
            return;
        }
        if (i10 > (a.e.API_PRIORITY_OTHER - this.zzk) - this.zzi) {
            throw zzvk.zzi();
        }
        throw zzvk.zzj();
    }

    private final boolean zzx(int i10) throws IOException {
        int i11 = this.zzi;
        int i12 = this.zzg;
        if (i11 + i10 > i12) {
            int i13 = this.zzk;
            if (i10 > (a.e.API_PRIORITY_OTHER - i13) - i11 || i13 + i11 + i10 > this.zzl) {
                return false;
            }
            if (i11 > 0) {
                if (i12 > i11) {
                    byte[] bArr = this.zzf;
                    System.arraycopy(bArr, i11, bArr, 0, i12 - i11);
                }
                i13 = this.zzk + i11;
                this.zzk = i13;
                i12 = this.zzg - i11;
                this.zzg = i12;
                this.zzi = 0;
            }
            try {
                int read = this.zze.read(this.zzf, i12, Math.min(4096 - i12, (a.e.API_PRIORITY_OTHER - i13) - i12));
                if (read == 0 || read < -1 || read > 4096) {
                    String valueOf = String.valueOf(this.zze.getClass());
                    StringBuilder sb2 = new StringBuilder(valueOf.length() + 91);
                    sb2.append(valueOf);
                    sb2.append("#read(byte[]) returned invalid result: ");
                    sb2.append(read);
                    sb2.append("\nThe InputStream implementation is buggy.");
                    throw new IllegalStateException(sb2.toString());
                } else if (read <= 0) {
                    return false;
                } else {
                    this.zzg += read;
                    zzv();
                    if (this.zzg >= i10) {
                        return true;
                    }
                    return zzx(i10);
                }
            } catch (zzvk e10) {
                e10.zzk();
                throw e10;
            }
        } else {
            StringBuilder sb3 = new StringBuilder(77);
            sb3.append("refillBuffer() called when ");
            sb3.append(i10);
            sb3.append(" bytes were already available in buffer");
            throw new IllegalStateException(sb3.toString());
        }
    }

    private final byte[] zzy(int i10, boolean z10) throws IOException {
        byte[] zzz = zzz(i10);
        if (zzz != null) {
            return zzz;
        }
        int i11 = this.zzi;
        int i12 = this.zzg;
        int i13 = i12 - i11;
        this.zzk += i12;
        this.zzi = 0;
        this.zzg = 0;
        List<byte[]> zzu = zzu(i10 - i13);
        byte[] bArr = new byte[i10];
        System.arraycopy(this.zzf, i11, bArr, 0, i13);
        for (byte[] next : zzu) {
            int length = next.length;
            System.arraycopy(next, 0, bArr, i13, length);
            i13 += length;
        }
        return bArr;
    }

    private final byte[] zzz(int i10) throws IOException {
        if (i10 == 0) {
            return zzvi.zzc;
        }
        if (i10 >= 0) {
            int i11 = this.zzk;
            int i12 = this.zzi;
            int i13 = i11 + i12 + i10;
            if (-2147483647 + i13 <= 0) {
                int i14 = this.zzl;
                if (i13 <= i14) {
                    int i15 = this.zzg - i12;
                    int i16 = i10 - i15;
                    if (i16 >= 4096) {
                        try {
                            if (i16 > this.zze.available()) {
                                return null;
                            }
                        } catch (zzvk e10) {
                            e10.zzk();
                            throw e10;
                        }
                    }
                    byte[] bArr = new byte[i10];
                    System.arraycopy(this.zzf, this.zzi, bArr, 0, i15);
                    this.zzk += this.zzg;
                    this.zzi = 0;
                    this.zzg = 0;
                    while (i15 < i10) {
                        try {
                            int read = this.zze.read(bArr, i15, i10 - i15);
                            if (read != -1) {
                                this.zzk += read;
                                i15 += read;
                            } else {
                                throw zzvk.zzj();
                            }
                        } catch (zzvk e11) {
                            e11.zzk();
                            throw e11;
                        }
                    }
                    return bArr;
                }
                zzr((i14 - i11) - i12);
                throw zzvk.zzj();
            }
            throw zzvk.zzi();
        }
        throw zzvk.zzf();
    }

    public final int zza() {
        return this.zzk + this.zzi;
    }

    public final int zzb(int i10) throws zzvk {
        if (i10 >= 0) {
            int i11 = i10 + this.zzk + this.zzi;
            int i12 = this.zzl;
            if (i11 <= i12) {
                this.zzl = i11;
                zzv();
                return i12;
            }
            throw zzvk.zzj();
        }
        throw zzvk.zzf();
    }

    public final int zzc() throws IOException {
        if (zzi()) {
            this.zzj = 0;
            return 0;
        }
        int zzn = zzn();
        this.zzj = zzn;
        if ((zzn >>> 3) != 0) {
            return zzn;
        }
        throw zzvk.zzc();
    }

    public final zztd zzd() throws IOException {
        int zzn = zzn();
        int i10 = this.zzg;
        int i11 = this.zzi;
        if (zzn <= i10 - i11 && zzn > 0) {
            zztd zzn2 = zztd.zzn(this.zzf, i11, zzn);
            this.zzi += zzn;
            return zzn2;
        } else if (zzn == 0) {
            return zztd.zzb;
        } else {
            byte[] zzz = zzz(zzn);
            if (zzz != null) {
                return zztd.zzm(zzz);
            }
            int i12 = this.zzi;
            int i13 = this.zzg;
            int i14 = i13 - i12;
            this.zzk += i13;
            this.zzi = 0;
            this.zzg = 0;
            List<byte[]> zzu = zzu(zzn - i14);
            byte[] bArr = new byte[zzn];
            System.arraycopy(this.zzf, i12, bArr, 0, i14);
            for (byte[] next : zzu) {
                int length = next.length;
                System.arraycopy(next, 0, bArr, i14, length);
                i14 += length;
            }
            return zztd.zzp(bArr);
        }
    }

    public final String zze() throws IOException {
        int zzn = zzn();
        if (zzn > 0) {
            int i10 = this.zzg;
            int i11 = this.zzi;
            if (zzn <= i10 - i11) {
                String str = new String(this.zzf, i11, zzn, zzvi.zza);
                this.zzi += zzn;
                return str;
            }
        }
        if (zzn == 0) {
            return "";
        }
        if (zzn > this.zzg) {
            return new String(zzy(zzn, false), zzvi.zza);
        }
        zzw(zzn);
        String str2 = new String(this.zzf, this.zzi, zzn, zzvi.zza);
        this.zzi += zzn;
        return str2;
    }

    public final String zzf() throws IOException {
        byte[] bArr;
        int zzn = zzn();
        int i10 = this.zzi;
        int i11 = this.zzg;
        if (zzn <= i11 - i10 && zzn > 0) {
            bArr = this.zzf;
            this.zzi = i10 + zzn;
        } else if (zzn == 0) {
            return "";
        } else {
            if (zzn <= i11) {
                zzw(zzn);
                bArr = this.zzf;
                this.zzi = zzn;
            } else {
                bArr = zzy(zzn, false);
            }
            i10 = 0;
        }
        return zzyd.zzd(bArr, i10, zzn);
    }

    public final void zzg(int i10) throws zzvk {
        if (this.zzj != i10) {
            throw zzvk.zzb();
        }
    }

    public final void zzh(int i10) {
        this.zzl = i10;
        zzv();
    }

    public final boolean zzi() throws IOException {
        return this.zzi == this.zzg && !zzx(1);
    }

    public final boolean zzj() throws IOException {
        return zzp() != 0;
    }

    public final boolean zzk(int i10) throws IOException {
        int zzc;
        int i11 = i10 & 7;
        int i12 = 0;
        if (i11 == 0) {
            if (this.zzg - this.zzi >= 10) {
                while (i12 < 10) {
                    byte[] bArr = this.zzf;
                    int i13 = this.zzi;
                    this.zzi = i13 + 1;
                    if (bArr[i13] < 0) {
                        i12++;
                    }
                }
                throw zzvk.zze();
            }
            while (i12 < 10) {
                if (zzl() < 0) {
                    i12++;
                }
            }
            throw zzvk.zze();
            return true;
        } else if (i11 == 1) {
            zzr(8);
            return true;
        } else if (i11 == 2) {
            zzr(zzn());
            return true;
        } else if (i11 == 3) {
            do {
                zzc = zzc();
                if (zzc == 0 || !zzk(zzc)) {
                    zzg(((i10 >>> 3) << 3) | 4);
                }
                zzc = zzc();
                break;
            } while (!zzk(zzc));
            zzg(((i10 >>> 3) << 3) | 4);
            return true;
        } else if (i11 == 4) {
            return false;
        } else {
            if (i11 == 5) {
                zzr(4);
                return true;
            }
            throw zzvk.zza();
        }
    }

    public final byte zzl() throws IOException {
        if (this.zzi == this.zzg) {
            zzw(1);
        }
        byte[] bArr = this.zzf;
        int i10 = this.zzi;
        this.zzi = i10 + 1;
        return bArr[i10];
    }

    public final int zzm() throws IOException {
        int i10 = this.zzi;
        if (this.zzg - i10 < 4) {
            zzw(4);
            i10 = this.zzi;
        }
        byte[] bArr = this.zzf;
        this.zzi = i10 + 4;
        return ((bArr[i10 + 3] & 255) << 24) | (bArr[i10] & 255) | ((bArr[i10 + 1] & 255) << 8) | ((bArr[i10 + 2] & 255) << Tnaf.POW_2_WIDTH);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0067, code lost:
        if (r2[r3] >= 0) goto L_0x0069;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zzn() throws java.io.IOException {
        /*
            r5 = this;
            int r0 = r5.zzi
            int r1 = r5.zzg
            if (r1 != r0) goto L_0x0007
            goto L_0x006c
        L_0x0007:
            byte[] r2 = r5.zzf
            int r3 = r0 + 1
            byte r0 = r2[r0]
            if (r0 < 0) goto L_0x0012
            r5.zzi = r3
            return r0
        L_0x0012:
            int r1 = r1 - r3
            r4 = 9
            if (r1 < r4) goto L_0x006c
            int r1 = r3 + 1
            byte r3 = r2[r3]
            int r3 = r3 << 7
            r0 = r0 ^ r3
            if (r0 >= 0) goto L_0x0023
            r0 = r0 ^ -128(0xffffffffffffff80, float:NaN)
            goto L_0x0069
        L_0x0023:
            int r3 = r1 + 1
            byte r1 = r2[r1]
            int r1 = r1 << 14
            r0 = r0 ^ r1
            if (r0 < 0) goto L_0x0030
            r0 = r0 ^ 16256(0x3f80, float:2.278E-41)
        L_0x002e:
            r1 = r3
            goto L_0x0069
        L_0x0030:
            int r1 = r3 + 1
            byte r3 = r2[r3]
            int r3 = r3 << 21
            r0 = r0 ^ r3
            if (r0 >= 0) goto L_0x003e
            r2 = -2080896(0xffffffffffe03f80, float:NaN)
            r0 = r0 ^ r2
            goto L_0x0069
        L_0x003e:
            int r3 = r1 + 1
            byte r1 = r2[r1]
            int r4 = r1 << 28
            r0 = r0 ^ r4
            r4 = 266354560(0xfe03f80, float:2.2112565E-29)
            r0 = r0 ^ r4
            if (r1 >= 0) goto L_0x002e
            int r1 = r3 + 1
            byte r3 = r2[r3]
            if (r3 >= 0) goto L_0x0069
            int r3 = r1 + 1
            byte r1 = r2[r1]
            if (r1 >= 0) goto L_0x002e
            int r1 = r3 + 1
            byte r3 = r2[r3]
            if (r3 >= 0) goto L_0x0069
            int r3 = r1 + 1
            byte r1 = r2[r1]
            if (r1 >= 0) goto L_0x002e
            int r1 = r3 + 1
            byte r2 = r2[r3]
            if (r2 < 0) goto L_0x006c
        L_0x0069:
            r5.zzi = r1
            return r0
        L_0x006c:
            long r0 = r5.zzq()
            int r0 = (int) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.gtm.zzth.zzn():int");
    }

    public final long zzo() throws IOException {
        int i10 = this.zzi;
        if (this.zzg - i10 < 8) {
            zzw(8);
            i10 = this.zzi;
        }
        byte[] bArr = this.zzf;
        this.zzi = i10 + 8;
        return ((((long) bArr[i10 + 7]) & 255) << 56) | (((long) bArr[i10]) & 255) | ((((long) bArr[i10 + 1]) & 255) << 8) | ((((long) bArr[i10 + 2]) & 255) << 16) | ((((long) bArr[i10 + 3]) & 255) << 24) | ((((long) bArr[i10 + 4]) & 255) << 32) | ((((long) bArr[i10 + 5]) & 255) << 40) | ((((long) bArr[i10 + 6]) & 255) << 48);
    }

    public final long zzp() throws IOException {
        long j10;
        long j11;
        long j12;
        long j13;
        byte b10;
        int i10 = this.zzi;
        int i11 = this.zzg;
        if (i11 != i10) {
            byte[] bArr = this.zzf;
            int i12 = i10 + 1;
            byte b11 = bArr[i10];
            if (b11 >= 0) {
                this.zzi = i12;
                return (long) b11;
            } else if (i11 - i12 >= 9) {
                int i13 = i12 + 1;
                byte b12 = b11 ^ (bArr[i12] << 7);
                if (b12 < 0) {
                    b10 = b12 ^ Byte.MIN_VALUE;
                } else {
                    int i14 = i13 + 1;
                    byte b13 = b12 ^ (bArr[i13] << 14);
                    if (b13 >= 0) {
                        j11 = (long) (b13 ^ 16256);
                    } else {
                        i13 = i14 + 1;
                        byte b14 = b13 ^ (bArr[i14] << 21);
                        if (b14 < 0) {
                            b10 = b14 ^ -2080896;
                        } else {
                            i14 = i13 + 1;
                            long j14 = (((long) bArr[i13]) << 28) ^ ((long) b14);
                            if (j14 >= 0) {
                                j13 = 266354560;
                            } else {
                                int i15 = i14 + 1;
                                long j15 = j14 ^ (((long) bArr[i14]) << 35);
                                if (j15 < 0) {
                                    j12 = -34093383808L;
                                } else {
                                    i14 = i15 + 1;
                                    j14 = j15 ^ (((long) bArr[i15]) << 42);
                                    if (j14 >= 0) {
                                        j13 = 4363953127296L;
                                    } else {
                                        i15 = i14 + 1;
                                        j15 = j14 ^ (((long) bArr[i14]) << 49);
                                        if (j15 < 0) {
                                            j12 = -558586000294016L;
                                        } else {
                                            i14 = i15 + 1;
                                            j11 = (j15 ^ (((long) bArr[i15]) << 56)) ^ 71499008037633920L;
                                            if (j11 < 0) {
                                                i15 = i14 + 1;
                                                if (((long) bArr[i14]) >= 0) {
                                                    j10 = j11;
                                                    i13 = i15;
                                                    this.zzi = i13;
                                                    return j10;
                                                }
                                            }
                                        }
                                    }
                                }
                                j10 = j12 ^ j15;
                                i13 = i15;
                                this.zzi = i13;
                                return j10;
                            }
                            j11 = j14 ^ j13;
                        }
                    }
                    i13 = i14;
                    j10 = j11;
                    this.zzi = i13;
                    return j10;
                }
                j10 = (long) b10;
                this.zzi = i13;
                return j10;
            }
        }
        return zzq();
    }

    /* access modifiers changed from: package-private */
    public final long zzq() throws IOException {
        long j10 = 0;
        for (int i10 = 0; i10 < 64; i10 += 7) {
            byte zzl2 = zzl();
            j10 |= ((long) (zzl2 & Byte.MAX_VALUE)) << i10;
            if ((zzl2 & 128) == 0) {
                return j10;
            }
        }
        throw zzvk.zze();
    }

    public final void zzr(int i10) throws IOException {
        int i11 = this.zzg;
        int i12 = this.zzi;
        int i13 = i11 - i12;
        if (i10 <= i13 && i10 >= 0) {
            this.zzi = i12 + i10;
        } else if (i10 >= 0) {
            int i14 = this.zzk;
            int i15 = i14 + i12;
            int i16 = this.zzl;
            if (i15 + i10 <= i16) {
                this.zzk = i15;
                this.zzg = 0;
                this.zzi = 0;
                while (i13 < i10) {
                    try {
                        long j10 = (long) (i10 - i13);
                        long skip = this.zze.skip(j10);
                        int i17 = (skip > 0 ? 1 : (skip == 0 ? 0 : -1));
                        if (i17 < 0 || skip > j10) {
                            String valueOf = String.valueOf(this.zze.getClass());
                            StringBuilder sb2 = new StringBuilder(valueOf.length() + 92);
                            sb2.append(valueOf);
                            sb2.append("#skip returned invalid result: ");
                            sb2.append(skip);
                            sb2.append("\nThe InputStream implementation is buggy.");
                            throw new IllegalStateException(sb2.toString());
                        } else if (i17 == 0) {
                            break;
                        } else {
                            i13 += (int) skip;
                        }
                    } catch (zzvk e10) {
                        e10.zzk();
                        throw e10;
                    } catch (Throwable th2) {
                        this.zzk += i13;
                        zzv();
                        throw th2;
                    }
                }
                this.zzk += i13;
                zzv();
                if (i13 < i10) {
                    int i18 = this.zzg;
                    int i19 = i18 - this.zzi;
                    this.zzi = i18;
                    zzw(1);
                    while (true) {
                        int i20 = i10 - i19;
                        int i21 = this.zzg;
                        if (i20 > i21) {
                            i19 += i21;
                            this.zzi = i21;
                            zzw(1);
                        } else {
                            this.zzi = i20;
                            return;
                        }
                    }
                }
            } else {
                zzr((i16 - i14) - i12);
                throw zzvk.zzj();
            }
        } else {
            throw zzvk.zzf();
        }
    }
}
