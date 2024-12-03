package com.google.android.gms.internal.p003firebaseauthapi;

import java.io.IOException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzalt  reason: invalid package */
final class zzalt implements zzamb {
    private final zzalp zza;
    private final zzamv zzb;
    private final boolean zzc;
    private final zzajy zzd;

    private zzalt(zzamv zzamv, zzajy zzajy, zzalp zzalp) {
        this.zzb = zzamv;
        this.zzc = zzajy.zzh(zzalp);
        this.zzd = zzajy;
        this.zza = zzalp;
    }

    static zzalt zzc(zzamv zzamv, zzajy zzajy, zzalp zzalp) {
        return new zzalt(zzamv, zzajy, zzalp);
    }

    public final int zza(Object obj) {
        zzamv zzamv = this.zzb;
        int zzb2 = zzamv.zzb(zzamv.zzd(obj));
        if (!this.zzc) {
            return zzb2;
        }
        this.zzd.zza(obj);
        throw null;
    }

    public final int zzb(Object obj) {
        int hashCode = this.zzb.zzd(obj).hashCode();
        if (!this.zzc) {
            return hashCode;
        }
        this.zzd.zza(obj);
        throw null;
    }

    public final Object zze() {
        zzalp zzalp = this.zza;
        if (zzalp instanceof zzakk) {
            return ((zzakk) zzalp).zzw();
        }
        return zzalp.zzC().zzk();
    }

    public final void zzf(Object obj) {
        this.zzb.zzm(obj);
        this.zzd.zze(obj);
    }

    public final void zzg(Object obj, Object obj2) {
        zzamd.zzq(this.zzb, obj, obj2);
        if (this.zzc) {
            this.zzd.zza(obj2);
            throw null;
        }
    }

    public final void zzh(Object obj, zzama zzama, zzajx zzajx) throws IOException {
        boolean z10;
        zzamv zzamv = this.zzb;
        Object zzc2 = zzamv.zzc(obj);
        zzajy zzajy = this.zzd;
        zzakc zzb2 = zzajy.zzb(obj);
        while (zzama.zzc() != Integer.MAX_VALUE) {
            int zzd2 = zzama.zzd();
            if (zzd2 != 11) {
                if ((zzd2 & 7) == 2) {
                    Object zzc3 = zzajy.zzc(zzajx, this.zza, zzd2 >>> 3);
                    if (zzc3 != null) {
                        zzajy.zzf(zzama, zzc3, zzajx, zzb2);
                    } else {
                        z10 = zzamv.zzp(zzc2, zzama);
                    }
                } else {
                    z10 = zzama.zzO();
                }
                if (!z10) {
                    zzamv.zzn(obj, zzc2);
                    return;
                }
            } else {
                int i10 = 0;
                Object obj2 = null;
                zzajf zzajf = null;
                while (true) {
                    try {
                        if (zzama.zzc() == Integer.MAX_VALUE) {
                            break;
                        }
                        int zzd3 = zzama.zzd();
                        if (zzd3 == 16) {
                            i10 = zzama.zzj();
                            obj2 = zzajy.zzc(zzajx, this.zza, i10);
                        } else if (zzd3 == 26) {
                            if (obj2 != null) {
                                zzajy.zzf(zzama, obj2, zzajx, zzb2);
                            } else {
                                zzajf = zzama.zzp();
                            }
                        } else if (!zzama.zzO()) {
                            break;
                        }
                    } catch (Throwable th2) {
                        zzamv.zzn(obj, zzc2);
                        throw th2;
                    }
                }
                if (zzama.zzd() != 12) {
                    throw zzaks.zzb();
                } else if (zzajf != null) {
                    if (obj2 != null) {
                        zzajy.zzg(zzajf, obj2, zzajx, zzb2);
                    } else {
                        zzamv.zzk(zzc2, i10, zzajf);
                    }
                }
            }
        }
        zzamv.zzn(obj, zzc2);
    }

    public final void zzi(Object obj, byte[] bArr, int i10, int i11, zzais zzais) throws IOException {
        zzakk zzakk = (zzakk) obj;
        if (zzakk.zzc == zzamw.zzc()) {
            zzakk.zzc = zzamw.zzf();
        }
        zzakh zzakh = (zzakh) obj;
        throw null;
    }

    public final boolean zzj(Object obj, Object obj2) {
        zzamv zzamv = this.zzb;
        if (!zzamv.zzd(obj).equals(zzamv.zzd(obj2))) {
            return false;
        }
        if (!this.zzc) {
            return true;
        }
        this.zzd.zza(obj);
        this.zzd.zza(obj2);
        throw null;
    }

    public final boolean zzk(Object obj) {
        this.zzd.zza(obj);
        throw null;
    }

    public final void zzm(Object obj, zzajt zzajt) throws IOException {
        this.zzd.zza(obj);
        throw null;
    }
}
