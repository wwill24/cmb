package com.google.android.gms.internal.gtm;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Map;

final class zzul extends zzuk<zzuw> {
    zzul() {
    }

    /* access modifiers changed from: package-private */
    public final int zza(Map.Entry<?, ?> entry) {
        return ((zzuw) entry.getKey()).zzb;
    }

    /* access modifiers changed from: package-private */
    public final zzuo<zzuw> zzb(Object obj) {
        return ((zzuv) obj).zza;
    }

    /* access modifiers changed from: package-private */
    public final zzuo<zzuw> zzc(Object obj) {
        return ((zzuv) obj).zzU();
    }

    /* access modifiers changed from: package-private */
    public final Object zzd(zzuj zzuj, zzwk zzwk, int i10) {
        return zzuj.zzc(zzwk, i10);
    }

    /* access modifiers changed from: package-private */
    public final <UT, UB> UB zze(zzww zzww, Object obj, zzuj zzuj, zzuo<zzuw> zzuo, UB ub2, zzxo<UT, UB> zzxo) throws IOException {
        Object obj2;
        Object zze;
        zzux zzux = (zzux) obj;
        zzuw zzuw = zzux.zzd;
        int i10 = zzuw.zzb;
        zzye zzye = zzuw.zzc;
        if (zzye != zzye.ENUM) {
            switch (zzye.ordinal()) {
                case 0:
                    obj2 = Double.valueOf(zzww.zza());
                    break;
                case 1:
                    obj2 = Float.valueOf(zzww.zzb());
                    break;
                case 2:
                    obj2 = Long.valueOf(zzww.zzl());
                    break;
                case 3:
                    obj2 = Long.valueOf(zzww.zzo());
                    break;
                case 4:
                    obj2 = Integer.valueOf(zzww.zzg());
                    break;
                case 5:
                    obj2 = Long.valueOf(zzww.zzk());
                    break;
                case 6:
                    obj2 = Integer.valueOf(zzww.zzf());
                    break;
                case 7:
                    obj2 = Boolean.valueOf(zzww.zzS());
                    break;
                case 8:
                    obj2 = zzww.zzv();
                    break;
                case 9:
                    obj2 = zzww.zzr(zzux.zzc.getClass(), zzuj);
                    break;
                case 10:
                    obj2 = zzww.zzt(zzux.zzc.getClass(), zzuj);
                    break;
                case 11:
                    obj2 = zzww.zzq();
                    break;
                case 12:
                    obj2 = Integer.valueOf(zzww.zzj());
                    break;
                case 13:
                    throw new IllegalStateException("Shouldn't reach here.");
                case 14:
                    obj2 = Integer.valueOf(zzww.zzh());
                    break;
                case 15:
                    obj2 = Long.valueOf(zzww.zzm());
                    break;
                case 16:
                    obj2 = Integer.valueOf(zzww.zzi());
                    break;
                case 17:
                    obj2 = Long.valueOf(zzww.zzn());
                    break;
                default:
                    obj2 = null;
                    break;
            }
        } else {
            int zzg = zzww.zzg();
            zzvc<?> zzvc = zzux.zzd.zza;
            if (zzyl.zzc(zzg) == null) {
                return zzwz.zzD(i10, zzg, ub2, zzxo);
            }
            obj2 = Integer.valueOf(zzg);
        }
        zzux.zza();
        int ordinal = zzux.zzd.zzc.ordinal();
        if ((ordinal == 9 || ordinal == 10) && (zze = zzuo.zze(zzux.zzd)) != null) {
            obj2 = zzvi.zzg(zze, obj2);
        }
        zzuo.zzi(zzux.zzd, obj2);
        return ub2;
    }

    /* access modifiers changed from: package-private */
    public final void zzf(Object obj) {
        ((zzuv) obj).zza.zzg();
    }

    /* access modifiers changed from: package-private */
    public final void zzg(zzww zzww, Object obj, zzuj zzuj, zzuo<zzuw> zzuo) throws IOException {
        zzux zzux = (zzux) obj;
        zzuo.zzi(zzux.zzd, zzww.zzt(zzux.zzc.getClass(), zzuj));
    }

    /* access modifiers changed from: package-private */
    public final void zzh(zztd zztd, Object obj, zzuj zzuj, zzuo<zzuw> zzuo) throws IOException {
        byte[] bArr;
        zzux zzux = (zzux) obj;
        zzwk zzD = zzux.zzc.zzao().zzD();
        int zzd = zztd.zzd();
        if (zzd == 0) {
            bArr = zzvi.zzc;
        } else {
            byte[] bArr2 = new byte[zzd];
            zztd.zze(bArr2, 0, 0, zzd);
            bArr = bArr2;
        }
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        if (wrap.hasArray()) {
            zzsn zzsn = new zzsn(wrap, true);
            zzwt.zza().zzb(zzD.getClass()).zzh(zzD, zzsn, zzuj);
            zzuo.zzi(zzux.zzd, zzD);
            if (zzsn.zzc() != Integer.MAX_VALUE) {
                throw zzvk.zzb();
            }
            return;
        }
        throw new IllegalArgumentException("Direct buffers not yet supported");
    }

    /* access modifiers changed from: package-private */
    public final boolean zzi(zzwk zzwk) {
        return zzwk instanceof zzuv;
    }

    /* access modifiers changed from: package-private */
    public final void zzj(zztp zztp, Map.Entry<?, ?> entry) throws IOException {
        zzuw zzuw = (zzuw) entry.getKey();
        zzye zzye = zzye.DOUBLE;
        switch (zzuw.zzc.ordinal()) {
            case 0:
                zztp.zzf(zzuw.zzb, ((Double) entry.getValue()).doubleValue());
                return;
            case 1:
                zztp.zzo(zzuw.zzb, ((Float) entry.getValue()).floatValue());
                return;
            case 2:
                zztp.zzt(zzuw.zzb, ((Long) entry.getValue()).longValue());
                return;
            case 3:
                zztp.zzK(zzuw.zzb, ((Long) entry.getValue()).longValue());
                return;
            case 4:
                zztp.zzr(zzuw.zzb, ((Integer) entry.getValue()).intValue());
                return;
            case 5:
                zztp.zzm(zzuw.zzb, ((Long) entry.getValue()).longValue());
                return;
            case 6:
                zztp.zzk(zzuw.zzb, ((Integer) entry.getValue()).intValue());
                return;
            case 7:
                zztp.zzb(zzuw.zzb, ((Boolean) entry.getValue()).booleanValue());
                return;
            case 8:
                zztp.zzG(zzuw.zzb, (String) entry.getValue());
                return;
            case 9:
                zztp.zzq(zzuw.zzb, entry.getValue(), zzwt.zza().zzb(entry.getValue().getClass()));
                return;
            case 10:
                zztp.zzv(zzuw.zzb, entry.getValue(), zzwt.zza().zzb(entry.getValue().getClass()));
                return;
            case 11:
                zztp.zzd(zzuw.zzb, (zztd) entry.getValue());
                return;
            case 12:
                zztp.zzI(zzuw.zzb, ((Integer) entry.getValue()).intValue());
                return;
            case 13:
                zztp.zzr(zzuw.zzb, ((Integer) entry.getValue()).intValue());
                return;
            case 14:
                zztp.zzx(zzuw.zzb, ((Integer) entry.getValue()).intValue());
                return;
            case 15:
                zztp.zzz(zzuw.zzb, ((Long) entry.getValue()).longValue());
                return;
            case 16:
                zztp.zzB(zzuw.zzb, ((Integer) entry.getValue()).intValue());
                return;
            case 17:
                zztp.zzD(zzuw.zzb, ((Long) entry.getValue()).longValue());
                return;
            default:
                return;
        }
    }
}
