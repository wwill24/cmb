package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.api.a;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.List;

final class zzsn extends zzsp {
    private final byte[] zza;
    private int zzb;
    private int zzc;
    private int zzd;
    private int zze;

    public zzsn(ByteBuffer byteBuffer, boolean z10) {
        super((zzso) null);
        this.zza = byteBuffer.array();
        this.zzb = byteBuffer.arrayOffset() + byteBuffer.position();
        this.zzc = byteBuffer.arrayOffset() + byteBuffer.limit();
    }

    private final byte zzU() throws IOException {
        int i10 = this.zzb;
        if (i10 != this.zzc) {
            byte[] bArr = this.zza;
            this.zzb = i10 + 1;
            return bArr[i10];
        }
        throw zzvk.zzj();
    }

    private final int zzV() throws IOException {
        zzad(4);
        return zzW();
    }

    private final int zzW() {
        int i10 = this.zzb;
        byte[] bArr = this.zza;
        this.zzb = i10 + 4;
        return ((bArr[i10 + 3] & 255) << 24) | (bArr[i10] & 255) | ((bArr[i10 + 1] & 255) << 8) | ((bArr[i10 + 2] & 255) << Tnaf.POW_2_WIDTH);
    }

    private final int zzX() throws IOException {
        byte b10;
        int i10 = this.zzb;
        int i11 = this.zzc;
        if (i11 != i10) {
            byte[] bArr = this.zza;
            int i12 = i10 + 1;
            byte b11 = bArr[i10];
            if (b11 >= 0) {
                this.zzb = i12;
                return b11;
            } else if (i11 - i12 < 9) {
                return (int) zzaa();
            } else {
                int i13 = i12 + 1;
                byte b12 = b11 ^ (bArr[i12] << 7);
                if (b12 < 0) {
                    b10 = b12 ^ Byte.MIN_VALUE;
                } else {
                    int i14 = i13 + 1;
                    byte b13 = b12 ^ (bArr[i13] << 14);
                    if (b13 >= 0) {
                        b10 = b13 ^ 16256;
                    } else {
                        i13 = i14 + 1;
                        byte b14 = b13 ^ (bArr[i14] << 21);
                        if (b14 < 0) {
                            b10 = b14 ^ -2080896;
                        } else {
                            i14 = i13 + 1;
                            byte b15 = bArr[i13];
                            b10 = (b14 ^ (b15 << 28)) ^ 266354560;
                            if (b15 < 0) {
                                i13 = i14 + 1;
                                if (bArr[i14] < 0) {
                                    i14 = i13 + 1;
                                    if (bArr[i13] < 0) {
                                        i13 = i14 + 1;
                                        if (bArr[i14] < 0) {
                                            i14 = i13 + 1;
                                            if (bArr[i13] < 0) {
                                                i13 = i14 + 1;
                                                if (bArr[i14] < 0) {
                                                    throw zzvk.zze();
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    i13 = i14;
                }
                this.zzb = i13;
                return b10;
            }
        } else {
            throw zzvk.zzj();
        }
    }

    private final long zzY() throws IOException {
        zzad(8);
        return zzZ();
    }

    private final long zzZ() {
        int i10 = this.zzb;
        byte[] bArr = this.zza;
        this.zzb = i10 + 8;
        return ((((long) bArr[i10 + 7]) & 255) << 56) | (((long) bArr[i10]) & 255) | ((((long) bArr[i10 + 1]) & 255) << 8) | ((((long) bArr[i10 + 2]) & 255) << 16) | ((((long) bArr[i10 + 3]) & 255) << 24) | ((((long) bArr[i10 + 4]) & 255) << 32) | ((((long) bArr[i10 + 5]) & 255) << 40) | ((((long) bArr[i10 + 6]) & 255) << 48);
    }

    private final long zzaa() throws IOException {
        long j10 = 0;
        for (int i10 = 0; i10 < 64; i10 += 7) {
            byte zzU = zzU();
            j10 |= ((long) (zzU & Byte.MAX_VALUE)) << i10;
            if ((zzU & 128) == 0) {
                return j10;
            }
        }
        throw zzvk.zze();
    }

    private final <T> T zzab(zzwx<T> zzwx, zzuj zzuj) throws IOException {
        int i10 = this.zze;
        this.zze = ((this.zzd >>> 3) << 3) | 4;
        try {
            T zze2 = zzwx.zze();
            zzwx.zzh(zze2, this, zzuj);
            zzwx.zzf(zze2);
            if (this.zzd == this.zze) {
                return zze2;
            }
            throw zzvk.zzg();
        } finally {
            this.zze = i10;
        }
    }

    private final <T> T zzac(zzwx<T> zzwx, zzuj zzuj) throws IOException {
        int zzX = zzX();
        zzad(zzX);
        int i10 = this.zzc;
        int i11 = this.zzb + zzX;
        this.zzc = i11;
        try {
            T zze2 = zzwx.zze();
            zzwx.zzh(zze2, this, zzuj);
            zzwx.zzf(zze2);
            if (this.zzb == i11) {
                return zze2;
            }
            throw zzvk.zzg();
        } finally {
            this.zzc = i10;
        }
    }

    private final void zzad(int i10) throws IOException {
        if (i10 < 0 || i10 > this.zzc - this.zzb) {
            throw zzvk.zzj();
        }
    }

    private final void zzae(int i10) throws IOException {
        if (this.zzb != i10) {
            throw zzvk.zzj();
        }
    }

    private final void zzaf(int i10) throws IOException {
        if ((this.zzd & 7) != i10) {
            throw zzvk.zza();
        }
    }

    private final void zzag(int i10) throws IOException {
        zzad(i10);
        this.zzb += i10;
    }

    private final void zzah(int i10) throws IOException {
        zzad(i10);
        if ((i10 & 3) != 0) {
            throw zzvk.zzg();
        }
    }

    private final void zzai(int i10) throws IOException {
        zzad(i10);
        if ((i10 & 7) != 0) {
            throw zzvk.zzg();
        }
    }

    private final boolean zzaj() {
        return this.zzb == this.zzc;
    }

    public final void zzA(List<Double> list) throws IOException {
        int i10;
        int i11;
        if (list instanceof zzug) {
            zzug zzug = (zzug) list;
            int i12 = this.zzd & 7;
            if (i12 == 1) {
                do {
                    zzug.zze(zza());
                    if (!zzaj()) {
                        i11 = this.zzb;
                    } else {
                        return;
                    }
                } while (zzX() == this.zzd);
                this.zzb = i11;
            } else if (i12 == 2) {
                int zzX = zzX();
                zzai(zzX);
                int i13 = this.zzb + zzX;
                while (this.zzb < i13) {
                    zzug.zze(Double.longBitsToDouble(zzZ()));
                }
            } else {
                throw zzvk.zza();
            }
        } else {
            int i14 = this.zzd & 7;
            if (i14 == 1) {
                do {
                    list.add(Double.valueOf(zza()));
                    if (!zzaj()) {
                        i10 = this.zzb;
                    } else {
                        return;
                    }
                } while (zzX() == this.zzd);
                this.zzb = i10;
            } else if (i14 == 2) {
                int zzX2 = zzX();
                zzai(zzX2);
                int i15 = this.zzb + zzX2;
                while (this.zzb < i15) {
                    list.add(Double.valueOf(Double.longBitsToDouble(zzZ())));
                }
            } else {
                throw zzvk.zza();
            }
        }
    }

    public final void zzB(List<Integer> list) throws IOException {
        int i10;
        int i11;
        if (list instanceof zzva) {
            zzva zzva = (zzva) list;
            int i12 = this.zzd & 7;
            if (i12 == 0) {
                do {
                    zzva.zzh(zze());
                    if (!zzaj()) {
                        i11 = this.zzb;
                    } else {
                        return;
                    }
                } while (zzX() == this.zzd);
                this.zzb = i11;
            } else if (i12 == 2) {
                int zzX = this.zzb + zzX();
                while (this.zzb < zzX) {
                    zzva.zzh(zzX());
                }
            } else {
                throw zzvk.zza();
            }
        } else {
            int i13 = this.zzd & 7;
            if (i13 == 0) {
                do {
                    list.add(Integer.valueOf(zze()));
                    if (!zzaj()) {
                        i10 = this.zzb;
                    } else {
                        return;
                    }
                } while (zzX() == this.zzd);
                this.zzb = i10;
            } else if (i13 == 2) {
                int zzX2 = this.zzb + zzX();
                while (this.zzb < zzX2) {
                    list.add(Integer.valueOf(zzX()));
                }
            } else {
                throw zzvk.zza();
            }
        }
    }

    public final void zzC(List<Integer> list) throws IOException {
        int i10;
        int i11;
        if (list instanceof zzva) {
            zzva zzva = (zzva) list;
            int i12 = this.zzd & 7;
            if (i12 == 2) {
                int zzX = zzX();
                zzah(zzX);
                int i13 = this.zzb + zzX;
                while (this.zzb < i13) {
                    zzva.zzh(zzW());
                }
            } else if (i12 == 5) {
                do {
                    zzva.zzh(zzf());
                    if (!zzaj()) {
                        i11 = this.zzb;
                    } else {
                        return;
                    }
                } while (zzX() == this.zzd);
                this.zzb = i11;
            } else {
                throw zzvk.zza();
            }
        } else {
            int i14 = this.zzd & 7;
            if (i14 == 2) {
                int zzX2 = zzX();
                zzah(zzX2);
                int i15 = this.zzb + zzX2;
                while (this.zzb < i15) {
                    list.add(Integer.valueOf(zzW()));
                }
            } else if (i14 == 5) {
                do {
                    list.add(Integer.valueOf(zzf()));
                    if (!zzaj()) {
                        i10 = this.zzb;
                    } else {
                        return;
                    }
                } while (zzX() == this.zzd);
                this.zzb = i10;
            } else {
                throw zzvk.zza();
            }
        }
    }

    public final void zzD(List<Long> list) throws IOException {
        int i10;
        int i11;
        if (list instanceof zzvz) {
            zzvz zzvz = (zzvz) list;
            int i12 = this.zzd & 7;
            if (i12 == 1) {
                do {
                    zzvz.zzf(zzk());
                    if (!zzaj()) {
                        i11 = this.zzb;
                    } else {
                        return;
                    }
                } while (zzX() == this.zzd);
                this.zzb = i11;
            } else if (i12 == 2) {
                int zzX = zzX();
                zzai(zzX);
                int i13 = this.zzb + zzX;
                while (this.zzb < i13) {
                    zzvz.zzf(zzZ());
                }
            } else {
                throw zzvk.zza();
            }
        } else {
            int i14 = this.zzd & 7;
            if (i14 == 1) {
                do {
                    list.add(Long.valueOf(zzk()));
                    if (!zzaj()) {
                        i10 = this.zzb;
                    } else {
                        return;
                    }
                } while (zzX() == this.zzd);
                this.zzb = i10;
            } else if (i14 == 2) {
                int zzX2 = zzX();
                zzai(zzX2);
                int i15 = this.zzb + zzX2;
                while (this.zzb < i15) {
                    list.add(Long.valueOf(zzZ()));
                }
            } else {
                throw zzvk.zza();
            }
        }
    }

    public final void zzE(List<Float> list) throws IOException {
        int i10;
        int i11;
        if (list instanceof zzuq) {
            zzuq zzuq = (zzuq) list;
            int i12 = this.zzd & 7;
            if (i12 == 2) {
                int zzX = zzX();
                zzah(zzX);
                int i13 = this.zzb + zzX;
                while (this.zzb < i13) {
                    zzuq.zze(Float.intBitsToFloat(zzW()));
                }
            } else if (i12 == 5) {
                do {
                    zzuq.zze(zzb());
                    if (!zzaj()) {
                        i11 = this.zzb;
                    } else {
                        return;
                    }
                } while (zzX() == this.zzd);
                this.zzb = i11;
            } else {
                throw zzvk.zza();
            }
        } else {
            int i14 = this.zzd & 7;
            if (i14 == 2) {
                int zzX2 = zzX();
                zzah(zzX2);
                int i15 = this.zzb + zzX2;
                while (this.zzb < i15) {
                    list.add(Float.valueOf(Float.intBitsToFloat(zzW())));
                }
            } else if (i14 == 5) {
                do {
                    list.add(Float.valueOf(zzb()));
                    if (!zzaj()) {
                        i10 = this.zzb;
                    } else {
                        return;
                    }
                } while (zzX() == this.zzd);
                this.zzb = i10;
            } else {
                throw zzvk.zza();
            }
        }
    }

    public final <T> void zzF(List<T> list, zzwx<T> zzwx, zzuj zzuj) throws IOException {
        int i10;
        int i11 = this.zzd;
        if ((i11 & 7) == 3) {
            do {
                list.add(zzab(zzwx, zzuj));
                if (!zzaj()) {
                    i10 = this.zzb;
                } else {
                    return;
                }
            } while (zzX() == i11);
            this.zzb = i10;
            return;
        }
        throw zzvk.zza();
    }

    public final void zzG(List<Integer> list) throws IOException {
        int i10;
        int i11;
        if (list instanceof zzva) {
            zzva zzva = (zzva) list;
            int i12 = this.zzd & 7;
            if (i12 == 0) {
                do {
                    zzva.zzh(zzg());
                    if (!zzaj()) {
                        i11 = this.zzb;
                    } else {
                        return;
                    }
                } while (zzX() == this.zzd);
                this.zzb = i11;
            } else if (i12 == 2) {
                int zzX = this.zzb + zzX();
                while (this.zzb < zzX) {
                    zzva.zzh(zzX());
                }
                zzae(zzX);
            } else {
                throw zzvk.zza();
            }
        } else {
            int i13 = this.zzd & 7;
            if (i13 == 0) {
                do {
                    list.add(Integer.valueOf(zzg()));
                    if (!zzaj()) {
                        i10 = this.zzb;
                    } else {
                        return;
                    }
                } while (zzX() == this.zzd);
                this.zzb = i10;
            } else if (i13 == 2) {
                int zzX2 = this.zzb + zzX();
                while (this.zzb < zzX2) {
                    list.add(Integer.valueOf(zzX()));
                }
                zzae(zzX2);
            } else {
                throw zzvk.zza();
            }
        }
    }

    public final void zzH(List<Long> list) throws IOException {
        int i10;
        int i11;
        if (list instanceof zzvz) {
            zzvz zzvz = (zzvz) list;
            int i12 = this.zzd & 7;
            if (i12 == 0) {
                do {
                    zzvz.zzf(zzl());
                    if (!zzaj()) {
                        i11 = this.zzb;
                    } else {
                        return;
                    }
                } while (zzX() == this.zzd);
                this.zzb = i11;
            } else if (i12 == 2) {
                int zzX = this.zzb + zzX();
                while (this.zzb < zzX) {
                    zzvz.zzf(zzp());
                }
                zzae(zzX);
            } else {
                throw zzvk.zza();
            }
        } else {
            int i13 = this.zzd & 7;
            if (i13 == 0) {
                do {
                    list.add(Long.valueOf(zzl()));
                    if (!zzaj()) {
                        i10 = this.zzb;
                    } else {
                        return;
                    }
                } while (zzX() == this.zzd);
                this.zzb = i10;
            } else if (i13 == 2) {
                int zzX2 = this.zzb + zzX();
                while (this.zzb < zzX2) {
                    list.add(Long.valueOf(zzp()));
                }
                zzae(zzX2);
            } else {
                throw zzvk.zza();
            }
        }
    }

    public final <T> void zzI(List<T> list, zzwx<T> zzwx, zzuj zzuj) throws IOException {
        int i10;
        int i11 = this.zzd;
        if ((i11 & 7) == 2) {
            do {
                list.add(zzac(zzwx, zzuj));
                if (!zzaj()) {
                    i10 = this.zzb;
                } else {
                    return;
                }
            } while (zzX() == i11);
            this.zzb = i10;
            return;
        }
        throw zzvk.zza();
    }

    public final void zzJ(List<Integer> list) throws IOException {
        int i10;
        int i11;
        if (list instanceof zzva) {
            zzva zzva = (zzva) list;
            int i12 = this.zzd & 7;
            if (i12 == 2) {
                int zzX = zzX();
                zzah(zzX);
                int i13 = this.zzb + zzX;
                while (this.zzb < i13) {
                    zzva.zzh(zzW());
                }
            } else if (i12 == 5) {
                do {
                    zzva.zzh(zzh());
                    if (!zzaj()) {
                        i11 = this.zzb;
                    } else {
                        return;
                    }
                } while (zzX() == this.zzd);
                this.zzb = i11;
            } else {
                throw zzvk.zza();
            }
        } else {
            int i14 = this.zzd & 7;
            if (i14 == 2) {
                int zzX2 = zzX();
                zzah(zzX2);
                int i15 = this.zzb + zzX2;
                while (this.zzb < i15) {
                    list.add(Integer.valueOf(zzW()));
                }
            } else if (i14 == 5) {
                do {
                    list.add(Integer.valueOf(zzh()));
                    if (!zzaj()) {
                        i10 = this.zzb;
                    } else {
                        return;
                    }
                } while (zzX() == this.zzd);
                this.zzb = i10;
            } else {
                throw zzvk.zza();
            }
        }
    }

    public final void zzK(List<Long> list) throws IOException {
        int i10;
        int i11;
        if (list instanceof zzvz) {
            zzvz zzvz = (zzvz) list;
            int i12 = this.zzd & 7;
            if (i12 == 1) {
                do {
                    zzvz.zzf(zzm());
                    if (!zzaj()) {
                        i11 = this.zzb;
                    } else {
                        return;
                    }
                } while (zzX() == this.zzd);
                this.zzb = i11;
            } else if (i12 == 2) {
                int zzX = zzX();
                zzai(zzX);
                int i13 = this.zzb + zzX;
                while (this.zzb < i13) {
                    zzvz.zzf(zzZ());
                }
            } else {
                throw zzvk.zza();
            }
        } else {
            int i14 = this.zzd & 7;
            if (i14 == 1) {
                do {
                    list.add(Long.valueOf(zzm()));
                    if (!zzaj()) {
                        i10 = this.zzb;
                    } else {
                        return;
                    }
                } while (zzX() == this.zzd);
                this.zzb = i10;
            } else if (i14 == 2) {
                int zzX2 = zzX();
                zzai(zzX2);
                int i15 = this.zzb + zzX2;
                while (this.zzb < i15) {
                    list.add(Long.valueOf(zzZ()));
                }
            } else {
                throw zzvk.zza();
            }
        }
    }

    public final void zzL(List<Integer> list) throws IOException {
        int i10;
        int i11;
        if (list instanceof zzva) {
            zzva zzva = (zzva) list;
            int i12 = this.zzd & 7;
            if (i12 == 0) {
                do {
                    zzva.zzh(zzi());
                    if (!zzaj()) {
                        i11 = this.zzb;
                    } else {
                        return;
                    }
                } while (zzX() == this.zzd);
                this.zzb = i11;
            } else if (i12 == 2) {
                int zzX = this.zzb + zzX();
                while (this.zzb < zzX) {
                    zzva.zzh(zztj.zzs(zzX()));
                }
            } else {
                throw zzvk.zza();
            }
        } else {
            int i13 = this.zzd & 7;
            if (i13 == 0) {
                do {
                    list.add(Integer.valueOf(zzi()));
                    if (!zzaj()) {
                        i10 = this.zzb;
                    } else {
                        return;
                    }
                } while (zzX() == this.zzd);
                this.zzb = i10;
            } else if (i13 == 2) {
                int zzX2 = this.zzb + zzX();
                while (this.zzb < zzX2) {
                    list.add(Integer.valueOf(zztj.zzs(zzX())));
                }
            } else {
                throw zzvk.zza();
            }
        }
    }

    public final void zzM(List<Long> list) throws IOException {
        int i10;
        int i11;
        if (list instanceof zzvz) {
            zzvz zzvz = (zzvz) list;
            int i12 = this.zzd & 7;
            if (i12 == 0) {
                do {
                    zzvz.zzf(zzn());
                    if (!zzaj()) {
                        i11 = this.zzb;
                    } else {
                        return;
                    }
                } while (zzX() == this.zzd);
                this.zzb = i11;
            } else if (i12 == 2) {
                int zzX = this.zzb + zzX();
                while (this.zzb < zzX) {
                    zzvz.zzf(zztj.zzt(zzp()));
                }
            } else {
                throw zzvk.zza();
            }
        } else {
            int i13 = this.zzd & 7;
            if (i13 == 0) {
                do {
                    list.add(Long.valueOf(zzn()));
                    if (!zzaj()) {
                        i10 = this.zzb;
                    } else {
                        return;
                    }
                } while (zzX() == this.zzd);
                this.zzb = i10;
            } else if (i13 == 2) {
                int zzX2 = this.zzb + zzX();
                while (this.zzb < zzX2) {
                    list.add(Long.valueOf(zztj.zzt(zzp())));
                }
            } else {
                throw zzvk.zza();
            }
        }
    }

    public final void zzN(List<String> list) throws IOException {
        zzO(list, false);
    }

    public final void zzO(List<String> list, boolean z10) throws IOException {
        int i10;
        int i11;
        if ((this.zzd & 7) != 2) {
            throw zzvk.zza();
        } else if ((list instanceof zzvs) && !z10) {
            zzvs zzvs = (zzvs) list;
            do {
                zzvs.zzi(zzq());
                if (!zzaj()) {
                    i11 = this.zzb;
                } else {
                    return;
                }
            } while (zzX() == this.zzd);
            this.zzb = i11;
        } else {
            do {
                list.add(zzw(z10));
                if (!zzaj()) {
                    i10 = this.zzb;
                } else {
                    return;
                }
            } while (zzX() == this.zzd);
            this.zzb = i10;
        }
    }

    public final void zzP(List<String> list) throws IOException {
        zzO(list, true);
    }

    public final void zzQ(List<Integer> list) throws IOException {
        int i10;
        int i11;
        if (list instanceof zzva) {
            zzva zzva = (zzva) list;
            int i12 = this.zzd & 7;
            if (i12 == 0) {
                do {
                    zzva.zzh(zzj());
                    if (!zzaj()) {
                        i11 = this.zzb;
                    } else {
                        return;
                    }
                } while (zzX() == this.zzd);
                this.zzb = i11;
            } else if (i12 == 2) {
                int zzX = this.zzb + zzX();
                while (this.zzb < zzX) {
                    zzva.zzh(zzX());
                }
            } else {
                throw zzvk.zza();
            }
        } else {
            int i13 = this.zzd & 7;
            if (i13 == 0) {
                do {
                    list.add(Integer.valueOf(zzj()));
                    if (!zzaj()) {
                        i10 = this.zzb;
                    } else {
                        return;
                    }
                } while (zzX() == this.zzd);
                this.zzb = i10;
            } else if (i13 == 2) {
                int zzX2 = this.zzb + zzX();
                while (this.zzb < zzX2) {
                    list.add(Integer.valueOf(zzX()));
                }
            } else {
                throw zzvk.zza();
            }
        }
    }

    public final void zzR(List<Long> list) throws IOException {
        int i10;
        int i11;
        if (list instanceof zzvz) {
            zzvz zzvz = (zzvz) list;
            int i12 = this.zzd & 7;
            if (i12 == 0) {
                do {
                    zzvz.zzf(zzo());
                    if (!zzaj()) {
                        i11 = this.zzb;
                    } else {
                        return;
                    }
                } while (zzX() == this.zzd);
                this.zzb = i11;
            } else if (i12 == 2) {
                int zzX = this.zzb + zzX();
                while (this.zzb < zzX) {
                    zzvz.zzf(zzp());
                }
                zzae(zzX);
            } else {
                throw zzvk.zza();
            }
        } else {
            int i13 = this.zzd & 7;
            if (i13 == 0) {
                do {
                    list.add(Long.valueOf(zzo()));
                    if (!zzaj()) {
                        i10 = this.zzb;
                    } else {
                        return;
                    }
                } while (zzX() == this.zzd);
                this.zzb = i10;
            } else if (i13 == 2) {
                int zzX2 = this.zzb + zzX();
                while (this.zzb < zzX2) {
                    list.add(Long.valueOf(zzp()));
                }
                zzae(zzX2);
            } else {
                throw zzvk.zza();
            }
        }
    }

    public final boolean zzS() throws IOException {
        zzaf(0);
        if (zzX() != 0) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x002e A[LOOP:0: B:18:0x002e->B:21:0x003b, LOOP_START] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzT() throws java.io.IOException {
        /*
            r7 = this;
            boolean r0 = r7.zzaj()
            r1 = 0
            if (r0 != 0) goto L_0x0085
            int r0 = r7.zzd
            int r2 = r7.zze
            if (r0 != r2) goto L_0x000f
            goto L_0x0085
        L_0x000f:
            r3 = r0 & 7
            r4 = 1
            if (r3 == 0) goto L_0x0059
            if (r3 == r4) goto L_0x0053
            r1 = 2
            if (r3 == r1) goto L_0x004b
            r1 = 4
            r5 = 3
            if (r3 == r5) goto L_0x0029
            r0 = 5
            if (r3 != r0) goto L_0x0024
            r7.zzag(r1)
            return r4
        L_0x0024:
            com.google.android.gms.internal.gtm.zzvj r0 = com.google.android.gms.internal.gtm.zzvk.zza()
            throw r0
        L_0x0029:
            int r0 = r0 >>> r5
            int r0 = r0 << r5
            r0 = r0 | r1
            r7.zze = r0
        L_0x002e:
            int r0 = r7.zzc()
            r1 = 2147483647(0x7fffffff, float:NaN)
            if (r0 == r1) goto L_0x003d
            boolean r0 = r7.zzT()
            if (r0 != 0) goto L_0x002e
        L_0x003d:
            int r0 = r7.zzd
            int r1 = r7.zze
            if (r0 != r1) goto L_0x0046
            r7.zze = r2
            return r4
        L_0x0046:
            com.google.android.gms.internal.gtm.zzvk r0 = com.google.android.gms.internal.gtm.zzvk.zzg()
            throw r0
        L_0x004b:
            int r0 = r7.zzX()
            r7.zzag(r0)
            return r4
        L_0x0053:
            r0 = 8
            r7.zzag(r0)
            return r4
        L_0x0059:
            int r0 = r7.zzc
            int r2 = r7.zzb
            int r0 = r0 - r2
            r3 = 10
            if (r0 < r3) goto L_0x0074
            byte[] r0 = r7.zza
            r5 = r1
        L_0x0065:
            if (r5 >= r3) goto L_0x0074
            int r6 = r2 + 1
            byte r2 = r0[r2]
            if (r2 < 0) goto L_0x0070
            r7.zzb = r6
            goto L_0x007f
        L_0x0070:
            int r5 = r5 + 1
            r2 = r6
            goto L_0x0065
        L_0x0074:
            if (r1 >= r3) goto L_0x0080
            byte r0 = r7.zzU()
            if (r0 >= 0) goto L_0x007f
            int r1 = r1 + 1
            goto L_0x0074
        L_0x007f:
            return r4
        L_0x0080:
            com.google.android.gms.internal.gtm.zzvk r0 = com.google.android.gms.internal.gtm.zzvk.zze()
            throw r0
        L_0x0085:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.gtm.zzsn.zzT():boolean");
    }

    public final double zza() throws IOException {
        zzaf(1);
        return Double.longBitsToDouble(zzY());
    }

    public final float zzb() throws IOException {
        zzaf(5);
        return Float.intBitsToFloat(zzV());
    }

    public final int zzc() throws IOException {
        if (zzaj()) {
            return a.e.API_PRIORITY_OTHER;
        }
        int zzX = zzX();
        this.zzd = zzX;
        return zzX == this.zze ? a.e.API_PRIORITY_OTHER : zzX >>> 3;
    }

    public final int zzd() {
        return this.zzd;
    }

    public final int zze() throws IOException {
        zzaf(0);
        return zzX();
    }

    public final int zzf() throws IOException {
        zzaf(5);
        return zzV();
    }

    public final int zzg() throws IOException {
        zzaf(0);
        return zzX();
    }

    public final int zzh() throws IOException {
        zzaf(5);
        return zzV();
    }

    public final int zzi() throws IOException {
        zzaf(0);
        return zztj.zzs(zzX());
    }

    public final int zzj() throws IOException {
        zzaf(0);
        return zzX();
    }

    public final long zzk() throws IOException {
        zzaf(1);
        return zzY();
    }

    public final long zzl() throws IOException {
        zzaf(0);
        return zzp();
    }

    public final long zzm() throws IOException {
        zzaf(1);
        return zzY();
    }

    public final long zzn() throws IOException {
        zzaf(0);
        return zztj.zzt(zzp());
    }

    public final long zzo() throws IOException {
        zzaf(0);
        return zzp();
    }

    public final long zzp() throws IOException {
        long j10;
        long j11;
        long j12;
        long j13;
        byte b10;
        int i10 = this.zzb;
        int i11 = this.zzc;
        if (i11 != i10) {
            byte[] bArr = this.zza;
            int i12 = i10 + 1;
            byte b11 = bArr[i10];
            if (b11 >= 0) {
                this.zzb = i12;
                return (long) b11;
            } else if (i11 - i12 < 9) {
                return zzaa();
            } else {
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
                                                    this.zzb = i13;
                                                    return j10;
                                                }
                                                throw zzvk.zze();
                                            }
                                        }
                                    }
                                }
                                j10 = j12 ^ j15;
                                i13 = i15;
                                this.zzb = i13;
                                return j10;
                            }
                            j11 = j14 ^ j13;
                        }
                    }
                    i13 = i14;
                    j10 = j11;
                    this.zzb = i13;
                    return j10;
                }
                j10 = (long) b10;
                this.zzb = i13;
                return j10;
            }
        } else {
            throw zzvk.zzj();
        }
    }

    public final zztd zzq() throws IOException {
        zzaf(2);
        int zzX = zzX();
        if (zzX == 0) {
            return zztd.zzb;
        }
        zzad(zzX);
        zztd zzq = zztd.zzq(this.zza, this.zzb, zzX);
        this.zzb += zzX;
        return zzq;
    }

    public final <T> T zzr(Class<T> cls, zzuj zzuj) throws IOException {
        zzaf(3);
        return zzab(zzwt.zza().zzb(cls), zzuj);
    }

    public final <T> T zzs(zzwx<T> zzwx, zzuj zzuj) throws IOException {
        zzaf(3);
        return zzab(zzwx, zzuj);
    }

    public final <T> T zzt(Class<T> cls, zzuj zzuj) throws IOException {
        zzaf(2);
        return zzac(zzwt.zza().zzb(cls), zzuj);
    }

    public final <T> T zzu(zzwx<T> zzwx, zzuj zzuj) throws IOException {
        zzaf(2);
        return zzac(zzwx, zzuj);
    }

    public final String zzv() throws IOException {
        return zzw(false);
    }

    public final String zzw(boolean z10) throws IOException {
        zzaf(2);
        int zzX = zzX();
        if (zzX == 0) {
            return "";
        }
        zzad(zzX);
        if (z10) {
            byte[] bArr = this.zza;
            int i10 = this.zzb;
            if (!zzyd.zzf(bArr, i10, i10 + zzX)) {
                throw zzvk.zzd();
            }
        }
        String str = new String(this.zza, this.zzb, zzX, zzvi.zza);
        this.zzb += zzX;
        return str;
    }

    public final String zzx() throws IOException {
        return zzw(true);
    }

    public final void zzy(List<Boolean> list) throws IOException {
        int i10;
        boolean z10;
        int i11;
        boolean z11;
        if (list instanceof zzsr) {
            zzsr zzsr = (zzsr) list;
            int i12 = this.zzd & 7;
            if (i12 == 0) {
                do {
                    zzsr.zze(zzS());
                    if (!zzaj()) {
                        i11 = this.zzb;
                    } else {
                        return;
                    }
                } while (zzX() == this.zzd);
                this.zzb = i11;
            } else if (i12 == 2) {
                int zzX = this.zzb + zzX();
                while (this.zzb < zzX) {
                    if (zzX() != 0) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    zzsr.zze(z11);
                }
                zzae(zzX);
            } else {
                throw zzvk.zza();
            }
        } else {
            int i13 = this.zzd & 7;
            if (i13 == 0) {
                do {
                    list.add(Boolean.valueOf(zzS()));
                    if (!zzaj()) {
                        i10 = this.zzb;
                    } else {
                        return;
                    }
                } while (zzX() == this.zzd);
                this.zzb = i10;
            } else if (i13 == 2) {
                int zzX2 = this.zzb + zzX();
                while (this.zzb < zzX2) {
                    if (zzX() != 0) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    list.add(Boolean.valueOf(z10));
                }
                zzae(zzX2);
            } else {
                throw zzvk.zza();
            }
        }
    }

    public final void zzz(List<zztd> list) throws IOException {
        int i10;
        if ((this.zzd & 7) == 2) {
            do {
                list.add(zzq());
                if (!zzaj()) {
                    i10 = this.zzb;
                } else {
                    return;
                }
            } while (zzX() == this.zzd);
            this.zzb = i10;
            return;
        }
        throw zzvk.zza();
    }
}
