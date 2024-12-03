package com.google.android.gms.internal.gtm;

import java.io.IOException;
import java.util.Arrays;

public final class zzxp {
    private static final zzxp zza = new zzxp(0, new int[0], new Object[0], false);
    private int zzb;
    private int[] zzc;
    private Object[] zzd;
    private int zze;
    private boolean zzf;

    private zzxp() {
        this(0, new int[8], new Object[8], true);
    }

    private zzxp(int i10, int[] iArr, Object[] objArr, boolean z10) {
        this.zze = -1;
        this.zzb = i10;
        this.zzc = iArr;
        this.zzd = objArr;
        this.zzf = z10;
    }

    public static zzxp zzc() {
        return zza;
    }

    static zzxp zzd(zzxp zzxp, zzxp zzxp2) {
        int i10 = zzxp.zzb + zzxp2.zzb;
        int[] copyOf = Arrays.copyOf(zzxp.zzc, i10);
        System.arraycopy(zzxp2.zzc, 0, copyOf, zzxp.zzb, zzxp2.zzb);
        Object[] copyOf2 = Arrays.copyOf(zzxp.zzd, i10);
        System.arraycopy(zzxp2.zzd, 0, copyOf2, zzxp.zzb, zzxp2.zzb);
        return new zzxp(i10, copyOf, copyOf2, true);
    }

    static zzxp zze() {
        return new zzxp(0, new int[8], new Object[8], true);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof zzxp)) {
            return false;
        }
        zzxp zzxp = (zzxp) obj;
        int i10 = this.zzb;
        if (i10 == zzxp.zzb) {
            int[] iArr = this.zzc;
            int[] iArr2 = zzxp.zzc;
            int i11 = 0;
            while (true) {
                if (i11 >= i10) {
                    Object[] objArr = this.zzd;
                    Object[] objArr2 = zzxp.zzd;
                    int i12 = this.zzb;
                    int i13 = 0;
                    while (i13 < i12) {
                        if (objArr[i13].equals(objArr2[i13])) {
                            i13++;
                        }
                    }
                    return true;
                } else if (iArr[i11] != iArr2[i11]) {
                    break;
                } else {
                    i11++;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        int i10 = this.zzb;
        int i11 = (i10 + 527) * 31;
        int[] iArr = this.zzc;
        int i12 = 17;
        int i13 = 17;
        for (int i14 = 0; i14 < i10; i14++) {
            i13 = (i13 * 31) + iArr[i14];
        }
        int i15 = (i11 + i13) * 31;
        Object[] objArr = this.zzd;
        int i16 = this.zzb;
        for (int i17 = 0; i17 < i16; i17++) {
            i12 = (i12 * 31) + objArr[i17].hashCode();
        }
        return i15 + i12;
    }

    public final int zza() {
        int i10;
        int i11;
        int i12;
        int i13 = this.zze;
        if (i13 != -1) {
            return i13;
        }
        int i14 = 0;
        for (int i15 = 0; i15 < this.zzb; i15++) {
            int i16 = this.zzc[i15];
            int i17 = i16 >>> 3;
            int i18 = i16 & 7;
            if (i18 != 0) {
                if (i18 == 1) {
                    ((Long) this.zzd[i15]).longValue();
                    i10 = zzto.zzD(i17 << 3) + 8;
                } else if (i18 == 2) {
                    int zzD = zzto.zzD(i17 << 3);
                    int zzd2 = ((zztd) this.zzd[i15]).zzd();
                    i14 += zzD + zzto.zzD(zzd2) + zzd2;
                } else if (i18 == 3) {
                    int zzC = zzto.zzC(i17);
                    i12 = zzC + zzC;
                    i11 = ((zzxp) this.zzd[i15]).zza();
                } else if (i18 == 5) {
                    ((Integer) this.zzd[i15]).intValue();
                    i10 = zzto.zzD(i17 << 3) + 4;
                } else {
                    throw new IllegalStateException(zzvk.zza());
                }
                i14 += i10;
            } else {
                long longValue = ((Long) this.zzd[i15]).longValue();
                i12 = zzto.zzD(i17 << 3);
                i11 = zzto.zzE(longValue);
            }
            i10 = i12 + i11;
            i14 += i10;
        }
        this.zze = i14;
        return i14;
    }

    public final int zzb() {
        int i10 = this.zze;
        if (i10 != -1) {
            return i10;
        }
        int i11 = 0;
        for (int i12 = 0; i12 < this.zzb; i12++) {
            int i13 = this.zzc[i12];
            int zzD = zzto.zzD(8);
            int zzd2 = ((zztd) this.zzd[i12]).zzd();
            i11 += zzD + zzD + zzto.zzD(16) + zzto.zzD(i13 >>> 3) + zzto.zzD(24) + zzto.zzD(zzd2) + zzd2;
        }
        this.zze = i11;
        return i11;
    }

    public final void zzf() {
        this.zzf = false;
    }

    /* access modifiers changed from: package-private */
    public final void zzg(StringBuilder sb2, int i10) {
        for (int i11 = 0; i11 < this.zzb; i11++) {
            zzwm.zzb(sb2, i10, String.valueOf(this.zzc[i11] >>> 3), this.zzd[i11]);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzh(int i10, Object obj) {
        int i11;
        if (this.zzf) {
            int i12 = this.zzb;
            int[] iArr = this.zzc;
            if (i12 == iArr.length) {
                if (i12 < 4) {
                    i11 = 8;
                } else {
                    i11 = i12 >> 1;
                }
                int i13 = i12 + i11;
                this.zzc = Arrays.copyOf(iArr, i13);
                this.zzd = Arrays.copyOf(this.zzd, i13);
            }
            int[] iArr2 = this.zzc;
            int i14 = this.zzb;
            iArr2[i14] = i10;
            this.zzd[i14] = obj;
            this.zzb = i14 + 1;
            return;
        }
        throw new UnsupportedOperationException();
    }

    /* access modifiers changed from: package-private */
    public final void zzi(zztp zztp) throws IOException {
        for (int i10 = 0; i10 < this.zzb; i10++) {
            zztp.zzw(this.zzc[i10] >>> 3, this.zzd[i10]);
        }
    }

    public final void zzj(zztp zztp) throws IOException {
        if (this.zzb != 0) {
            for (int i10 = 0; i10 < this.zzb; i10++) {
                int i11 = this.zzc[i10];
                Object obj = this.zzd[i10];
                int i12 = i11 >>> 3;
                int i13 = i11 & 7;
                if (i13 == 0) {
                    zztp.zzt(i12, ((Long) obj).longValue());
                } else if (i13 == 1) {
                    zztp.zzm(i12, ((Long) obj).longValue());
                } else if (i13 == 2) {
                    zztp.zzd(i12, (zztd) obj);
                } else if (i13 == 3) {
                    zztp.zzF(i12);
                    ((zzxp) obj).zzj(zztp);
                    zztp.zzh(i12);
                } else if (i13 == 5) {
                    zztp.zzk(i12, ((Integer) obj).intValue());
                } else {
                    throw new RuntimeException(zzvk.zza());
                }
            }
        }
    }
}
