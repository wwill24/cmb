package com.google.android.gms.internal.gtm;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

final class zzwo<T> implements zzwx<T> {
    private final zzwk zza;
    private final zzxo<?, ?> zzb;
    private final boolean zzc;
    private final zzuk<?> zzd;

    private zzwo(zzxo<?, ?> zzxo, zzuk<?> zzuk, zzwk zzwk) {
        this.zzb = zzxo;
        this.zzc = zzuk.zzi(zzwk);
        this.zzd = zzuk;
        this.zza = zzwk;
    }

    static <T> zzwo<T> zzc(zzxo<?, ?> zzxo, zzuk<?> zzuk, zzwk zzwk) {
        return new zzwo<>(zzxo, zzuk, zzwk);
    }

    public final int zza(T t10) {
        zzxo<?, ?> zzxo = this.zzb;
        int zzb2 = zzxo.zzb(zzxo.zzd(t10));
        if (this.zzc) {
            return zzb2 + this.zzd.zzb(t10).zzb();
        }
        return zzb2;
    }

    public final int zzb(T t10) {
        int hashCode = this.zzb.zzd(t10).hashCode();
        if (this.zzc) {
            return (hashCode * 53) + this.zzd.zzb(t10).zza.hashCode();
        }
        return hashCode;
    }

    public final T zze() {
        return this.zza.zzao().zzD();
    }

    public final void zzf(T t10) {
        this.zzb.zzm(t10);
        this.zzd.zzf(t10);
    }

    public final void zzg(T t10, T t11) {
        zzwz.zzF(this.zzb, t10, t11);
        if (this.zzc) {
            zzwz.zzE(this.zzd, t10, t11);
        }
    }

    public final void zzh(T t10, zzww zzww, zzuj zzuj) throws IOException {
        boolean z10;
        zzxo<?, ?> zzxo = this.zzb;
        zzuk<?> zzuk = this.zzd;
        Object zzc2 = zzxo.zzc(t10);
        zzuo<?> zzc3 = zzuk.zzc(t10);
        while (zzww.zzc() != Integer.MAX_VALUE) {
            int zzd2 = zzww.zzd();
            if (zzd2 != 11) {
                if ((zzd2 & 7) == 2) {
                    Object zzd3 = zzuk.zzd(zzuj, this.zza, zzd2 >>> 3);
                    if (zzd3 != null) {
                        zzuk.zzg(zzww, zzd3, zzuj, zzc3);
                    } else {
                        z10 = zzxo.zzp(zzc2, zzww);
                    }
                } else {
                    z10 = zzww.zzT();
                }
                if (!z10) {
                    zzxo.zzn(t10, zzc2);
                    return;
                }
            } else {
                int i10 = 0;
                Object obj = null;
                zztd zztd = null;
                while (true) {
                    try {
                        if (zzww.zzc() == Integer.MAX_VALUE) {
                            break;
                        }
                        int zzd4 = zzww.zzd();
                        if (zzd4 == 16) {
                            i10 = zzww.zzj();
                            obj = zzuk.zzd(zzuj, this.zza, i10);
                        } else if (zzd4 == 26) {
                            if (obj != null) {
                                zzuk.zzg(zzww, obj, zzuj, zzc3);
                            } else {
                                zztd = zzww.zzq();
                            }
                        } else if (!zzww.zzT()) {
                            break;
                        }
                    } catch (Throwable th2) {
                        zzxo.zzn(t10, zzc2);
                        throw th2;
                    }
                }
                if (zzww.zzd() != 12) {
                    throw zzvk.zzb();
                } else if (zztd != null) {
                    if (obj != null) {
                        zzuk.zzh(zztd, obj, zzuj, zzc3);
                    } else {
                        zzxo.zzk(zzc2, i10, zztd);
                    }
                }
            }
        }
        zzxo.zzn(t10, zzc2);
    }

    public final void zzi(T t10, byte[] bArr, int i10, int i11, zzsl zzsl) throws IOException {
        zzuz zzuz = (zzuz) t10;
        zzxp zzxp = zzuz.zzc;
        if (zzxp == zzxp.zzc()) {
            zzxp = zzxp.zze();
            zzuz.zzc = zzxp;
        }
        zzuo<zzuw> zzU = ((zzuv) t10).zzU();
        Object obj = null;
        while (i10 < i11) {
            int zzj = zzsm.zzj(bArr, i10, zzsl);
            int i12 = zzsl.zza;
            if (i12 == 11) {
                int i13 = 0;
                zztd zztd = null;
                while (zzj < i11) {
                    zzj = zzsm.zzj(bArr, zzj, zzsl);
                    int i14 = zzsl.zza;
                    int i15 = i14 & 7;
                    int i16 = i14 >>> 3;
                    if (i16 != 2) {
                        if (i16 == 3) {
                            if (obj != null) {
                                zzux zzux = (zzux) obj;
                                zzj = zzsm.zzd(zzwt.zza().zzb(zzux.zzc.getClass()), bArr, zzj, i11, zzsl);
                                zzU.zzi(zzux.zzd, zzsl.zzc);
                            } else if (i15 == 2) {
                                zzj = zzsm.zza(bArr, zzj, zzsl);
                                zztd = (zztd) zzsl.zzc;
                            }
                        }
                    } else if (i15 == 0) {
                        zzj = zzsm.zzj(bArr, zzj, zzsl);
                        i13 = zzsl.zza;
                        obj = this.zzd.zzd(zzsl.zzd, this.zza, i13);
                    }
                    if (i14 == 12) {
                        break;
                    }
                    zzj = zzsm.zzn(i14, bArr, zzj, i11, zzsl);
                }
                if (zztd != null) {
                    zzxp.zzh((i13 << 3) | 2, zztd);
                }
                i10 = zzj;
            } else if ((i12 & 7) == 2) {
                Object zzd2 = this.zzd.zzd(zzsl.zzd, this.zza, i12 >>> 3);
                if (zzd2 != null) {
                    zzux zzux2 = (zzux) zzd2;
                    i10 = zzsm.zzd(zzwt.zza().zzb(zzux2.zzc.getClass()), bArr, zzj, i11, zzsl);
                    zzU.zzi(zzux2.zzd, zzsl.zzc);
                } else {
                    i10 = zzsm.zzi(i12, bArr, zzj, i11, zzxp, zzsl);
                }
                obj = zzd2;
            } else {
                i10 = zzsm.zzn(i12, bArr, zzj, i11, zzsl);
            }
        }
        if (i10 != i11) {
            throw zzvk.zzg();
        }
    }

    public final boolean zzj(T t10, T t11) {
        if (!this.zzb.zzd(t10).equals(this.zzb.zzd(t11))) {
            return false;
        }
        if (this.zzc) {
            return this.zzd.zzb(t10).equals(this.zzd.zzb(t11));
        }
        return true;
    }

    public final boolean zzk(T t10) {
        return this.zzd.zzb(t10).zzk();
    }

    public final void zzn(T t10, zztp zztp) throws IOException {
        Iterator<Map.Entry<?, Object>> zzf = this.zzd.zzb(t10).zzf();
        while (zzf.hasNext()) {
            Map.Entry next = zzf.next();
            zzun zzun = (zzun) next.getKey();
            if (zzun.zze() == zzyf.MESSAGE) {
                zzun.zzg();
                zzun.zzf();
                if (next instanceof zzvn) {
                    zztp.zzw(zzun.zza(), ((zzvn) next).zza().zzb());
                } else {
                    zztp.zzw(zzun.zza(), next.getValue());
                }
            } else {
                throw new IllegalStateException("Found invalid MessageSet item.");
            }
        }
        zzxo<?, ?> zzxo = this.zzb;
        zzxo.zzr(zzxo.zzd(t10), zztp);
    }
}
