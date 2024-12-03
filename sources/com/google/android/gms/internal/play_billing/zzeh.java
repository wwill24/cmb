package com.google.android.gms.internal.play_billing;

import java.io.IOException;
import java.util.Arrays;

public final class zzeh {
    private static final zzeh zza = new zzeh(0, new int[0], new Object[0], false);
    private int zzb;
    private int[] zzc;
    private Object[] zzd;
    private int zze;
    private boolean zzf;

    private zzeh() {
        this(0, new int[8], new Object[8], true);
    }

    private zzeh(int i10, int[] iArr, Object[] objArr, boolean z10) {
        this.zze = -1;
        this.zzb = i10;
        this.zzc = iArr;
        this.zzd = objArr;
        this.zzf = z10;
    }

    public static zzeh zzc() {
        return zza;
    }

    static zzeh zze(zzeh zzeh, zzeh zzeh2) {
        int i10 = zzeh.zzb + zzeh2.zzb;
        int[] copyOf = Arrays.copyOf(zzeh.zzc, i10);
        System.arraycopy(zzeh2.zzc, 0, copyOf, zzeh.zzb, zzeh2.zzb);
        Object[] copyOf2 = Arrays.copyOf(zzeh.zzd, i10);
        System.arraycopy(zzeh2.zzd, 0, copyOf2, zzeh.zzb, zzeh2.zzb);
        return new zzeh(i10, copyOf, copyOf2, true);
    }

    static zzeh zzf() {
        return new zzeh(0, new int[8], new Object[8], true);
    }

    private final void zzl(int i10) {
        int[] iArr = this.zzc;
        if (i10 > iArr.length) {
            int i11 = this.zzb;
            int i12 = i11 + (i11 / 2);
            if (i12 >= i10) {
                i10 = i12;
            }
            if (i10 < 8) {
                i10 = 8;
            }
            this.zzc = Arrays.copyOf(iArr, i10);
            this.zzd = Arrays.copyOf(this.zzd, i10);
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof zzeh)) {
            return false;
        }
        zzeh zzeh = (zzeh) obj;
        int i10 = this.zzb;
        if (i10 == zzeh.zzb) {
            int[] iArr = this.zzc;
            int[] iArr2 = zzeh.zzc;
            int i11 = 0;
            while (true) {
                if (i11 >= i10) {
                    Object[] objArr = this.zzd;
                    Object[] objArr2 = zzeh.zzd;
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
        int i11 = i10 + 527;
        int[] iArr = this.zzc;
        int i12 = 17;
        int i13 = 17;
        for (int i14 = 0; i14 < i10; i14++) {
            i13 = (i13 * 31) + iArr[i14];
        }
        int i15 = (i11 * 31) + i13;
        Object[] objArr = this.zzd;
        int i16 = this.zzb;
        for (int i17 = 0; i17 < i16; i17++) {
            i12 = (i12 * 31) + objArr[i17].hashCode();
        }
        return (i15 * 31) + i12;
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
                    i10 = zzbi.zzx(i17 << 3) + 8;
                } else if (i18 == 2) {
                    int i19 = zzbi.zzb;
                    int zzd2 = ((zzba) this.zzd[i15]).zzd();
                    i10 = zzbi.zzx(i17 << 3) + zzbi.zzx(zzd2) + zzd2;
                } else if (i18 == 3) {
                    int i20 = i17 << 3;
                    int i21 = zzbi.zzb;
                    i11 = ((zzeh) this.zzd[i15]).zza();
                    int zzx = zzbi.zzx(i20);
                    i12 = zzx + zzx;
                } else if (i18 == 5) {
                    ((Integer) this.zzd[i15]).intValue();
                    i10 = zzbi.zzx(i17 << 3) + 4;
                } else {
                    throw new IllegalStateException(zzci.zza());
                }
                i14 += i10;
            } else {
                int i22 = i17 << 3;
                i11 = zzbi.zzy(((Long) this.zzd[i15]).longValue());
                i12 = zzbi.zzx(i22);
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
            int i13 = zzbi.zzb;
            int zzd2 = ((zzba) this.zzd[i12]).zzd();
            int zzx = zzbi.zzx(zzd2) + zzd2;
            int zzx2 = zzbi.zzx(16);
            int zzx3 = zzbi.zzx(this.zzc[i12] >>> 3);
            int zzx4 = zzbi.zzx(8);
            i11 += zzx4 + zzx4 + zzx2 + zzx3 + zzbi.zzx(24) + zzx;
        }
        this.zze = i11;
        return i11;
    }

    /* access modifiers changed from: package-private */
    public final zzeh zzd(zzeh zzeh) {
        if (zzeh.equals(zza)) {
            return this;
        }
        zzg();
        int i10 = this.zzb + zzeh.zzb;
        zzl(i10);
        System.arraycopy(zzeh.zzc, 0, this.zzc, this.zzb, zzeh.zzb);
        System.arraycopy(zzeh.zzd, 0, this.zzd, this.zzb, zzeh.zzb);
        this.zzb = i10;
        return this;
    }

    /* access modifiers changed from: package-private */
    public final void zzg() {
        if (!this.zzf) {
            throw new UnsupportedOperationException();
        }
    }

    public final void zzh() {
        this.zzf = false;
    }

    /* access modifiers changed from: package-private */
    public final void zzi(StringBuilder sb2, int i10) {
        for (int i11 = 0; i11 < this.zzb; i11++) {
            zzdh.zzb(sb2, i10, String.valueOf(this.zzc[i11] >>> 3), this.zzd[i11]);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzj(int i10, Object obj) {
        zzg();
        zzl(this.zzb + 1);
        int[] iArr = this.zzc;
        int i11 = this.zzb;
        iArr[i11] = i10;
        this.zzd[i11] = obj;
        this.zzb = i11 + 1;
    }

    public final void zzk(zzey zzey) throws IOException {
        if (this.zzb != 0) {
            for (int i10 = 0; i10 < this.zzb; i10++) {
                int i11 = this.zzc[i10];
                Object obj = this.zzd[i10];
                int i12 = i11 & 7;
                int i13 = i11 >>> 3;
                if (i12 == 0) {
                    zzey.zzt(i13, ((Long) obj).longValue());
                } else if (i12 == 1) {
                    zzey.zzm(i13, ((Long) obj).longValue());
                } else if (i12 == 2) {
                    zzey.zzd(i13, (zzba) obj);
                } else if (i12 == 3) {
                    zzey.zzE(i13);
                    ((zzeh) obj).zzk(zzey);
                    zzey.zzh(i13);
                } else if (i12 == 5) {
                    zzey.zzk(i13, ((Integer) obj).intValue());
                } else {
                    throw new RuntimeException(zzci.zza());
                }
            }
        }
    }
}
