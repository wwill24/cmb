package com.google.android.gms.internal.p003firebaseauthapi;

import java.io.IOException;
import java.util.Arrays;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzamw  reason: invalid package */
public final class zzamw {
    private static final zzamw zza = new zzamw(0, new int[0], new Object[0], false);
    private int zzb;
    private int[] zzc;
    private Object[] zzd;
    private int zze;
    private boolean zzf;

    private zzamw() {
        this(0, new int[8], new Object[8], true);
    }

    private zzamw(int i10, int[] iArr, Object[] objArr, boolean z10) {
        this.zze = -1;
        this.zzb = i10;
        this.zzc = iArr;
        this.zzd = objArr;
        this.zzf = z10;
    }

    public static zzamw zzc() {
        return zza;
    }

    static zzamw zze(zzamw zzamw, zzamw zzamw2) {
        int i10 = zzamw.zzb + zzamw2.zzb;
        int[] copyOf = Arrays.copyOf(zzamw.zzc, i10);
        System.arraycopy(zzamw2.zzc, 0, copyOf, zzamw.zzb, zzamw2.zzb);
        Object[] copyOf2 = Arrays.copyOf(zzamw.zzd, i10);
        System.arraycopy(zzamw2.zzd, 0, copyOf2, zzamw.zzb, zzamw2.zzb);
        return new zzamw(i10, copyOf, copyOf2, true);
    }

    static zzamw zzf() {
        return new zzamw(0, new int[8], new Object[8], true);
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
        if (obj == null || !(obj instanceof zzamw)) {
            return false;
        }
        zzamw zzamw = (zzamw) obj;
        int i10 = this.zzb;
        if (i10 == zzamw.zzb) {
            int[] iArr = this.zzc;
            int[] iArr2 = zzamw.zzc;
            int i11 = 0;
            while (true) {
                if (i11 >= i10) {
                    Object[] objArr = this.zzd;
                    Object[] objArr2 = zzamw.zzd;
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
        int i15 = ((i11 * 31) + i13) * 31;
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
                    i10 = zzajs.zzA(i17 << 3) + 8;
                } else if (i18 == 2) {
                    int i19 = i17 << 3;
                    int i20 = zzajs.zzf;
                    int zzd2 = ((zzajf) this.zzd[i15]).zzd();
                    i10 = zzajs.zzA(i19) + zzajs.zzA(zzd2) + zzd2;
                } else if (i18 == 3) {
                    int i21 = i17 << 3;
                    int i22 = zzajs.zzf;
                    i11 = ((zzamw) this.zzd[i15]).zza();
                    int zzA = zzajs.zzA(i21);
                    i12 = zzA + zzA;
                } else if (i18 == 5) {
                    ((Integer) this.zzd[i15]).intValue();
                    i10 = zzajs.zzA(i17 << 3) + 4;
                } else {
                    throw new IllegalStateException(zzaks.zza());
                }
                i14 += i10;
            } else {
                int i23 = i17 << 3;
                i11 = zzajs.zzB(((Long) this.zzd[i15]).longValue());
                i12 = zzajs.zzA(i23);
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
            int i13 = zzajs.zzf;
            int zzd2 = ((zzajf) this.zzd[i12]).zzd();
            int zzA = zzajs.zzA(zzd2) + zzd2;
            int zzA2 = zzajs.zzA(16);
            int zzA3 = zzajs.zzA(this.zzc[i12] >>> 3);
            int zzA4 = zzajs.zzA(8);
            i11 += zzA4 + zzA4 + zzA2 + zzA3 + zzajs.zzA(24) + zzA;
        }
        this.zze = i11;
        return i11;
    }

    /* access modifiers changed from: package-private */
    public final zzamw zzd(zzamw zzamw) {
        if (zzamw.equals(zza)) {
            return this;
        }
        zzg();
        int i10 = this.zzb + zzamw.zzb;
        zzl(i10);
        System.arraycopy(zzamw.zzc, 0, this.zzc, this.zzb, zzamw.zzb);
        System.arraycopy(zzamw.zzd, 0, this.zzd, this.zzb, zzamw.zzb);
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
        if (this.zzf) {
            this.zzf = false;
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzi(StringBuilder sb2, int i10) {
        for (int i11 = 0; i11 < this.zzb; i11++) {
            zzalr.zzb(sb2, i10, String.valueOf(this.zzc[i11] >>> 3), this.zzd[i11]);
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

    public final void zzk(zzajt zzajt) throws IOException {
        if (this.zzb != 0) {
            for (int i10 = 0; i10 < this.zzb; i10++) {
                int i11 = this.zzc[i10];
                Object obj = this.zzd[i10];
                int i12 = i11 & 7;
                int i13 = i11 >>> 3;
                if (i12 == 0) {
                    zzajt.zzt(i13, ((Long) obj).longValue());
                } else if (i12 == 1) {
                    zzajt.zzm(i13, ((Long) obj).longValue());
                } else if (i12 == 2) {
                    zzajt.zzd(i13, (zzajf) obj);
                } else if (i12 == 3) {
                    zzajt.zzE(i13);
                    ((zzamw) obj).zzk(zzajt);
                    zzajt.zzh(i13);
                } else if (i12 == 5) {
                    zzajt.zzk(i13, ((Integer) obj).intValue());
                } else {
                    throw new RuntimeException(zzaks.zza());
                }
            }
        }
    }
}
