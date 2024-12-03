package com.google.android.gms.internal.gtm;

import java.io.IOException;
import java.util.List;

final class zztp {
    private final zzto zza;

    private zztp(zzto zzto) {
        zzvi.zzf(zzto, "output");
        this.zza = zzto;
        zzto.zza = this;
    }

    public static zztp zza(zzto zzto) {
        zztp zztp = zzto.zza;
        return zztp != null ? zztp : new zztp(zzto);
    }

    public final void zzA(int i10, List<Long> list, boolean z10) throws IOException {
        int i11 = 0;
        if (z10) {
            this.zza.zzo(i10, 2);
            int i12 = 0;
            for (int i13 = 0; i13 < list.size(); i13++) {
                list.get(i13).longValue();
                i12 += 8;
            }
            this.zza.zzq(i12);
            while (i11 < list.size()) {
                this.zza.zzi(list.get(i11).longValue());
                i11++;
            }
            return;
        }
        while (i11 < list.size()) {
            this.zza.zzh(i10, list.get(i11).longValue());
            i11++;
        }
    }

    public final void zzB(int i10, int i11) throws IOException {
        this.zza.zzp(i10, (i11 >> 31) ^ (i11 + i11));
    }

    public final void zzC(int i10, List<Integer> list, boolean z10) throws IOException {
        int i11 = 0;
        if (z10) {
            this.zza.zzo(i10, 2);
            int i12 = 0;
            for (int i13 = 0; i13 < list.size(); i13++) {
                int intValue = list.get(i13).intValue();
                i12 += zzto.zzD((intValue >> 31) ^ (intValue + intValue));
            }
            this.zza.zzq(i12);
            while (i11 < list.size()) {
                zzto zzto = this.zza;
                int intValue2 = list.get(i11).intValue();
                zzto.zzq((intValue2 >> 31) ^ (intValue2 + intValue2));
                i11++;
            }
            return;
        }
        while (i11 < list.size()) {
            zzto zzto2 = this.zza;
            int intValue3 = list.get(i11).intValue();
            zzto2.zzp(i10, (intValue3 >> 31) ^ (intValue3 + intValue3));
            i11++;
        }
    }

    public final void zzD(int i10, long j10) throws IOException {
        this.zza.zzr(i10, (j10 >> 63) ^ (j10 + j10));
    }

    public final void zzE(int i10, List<Long> list, boolean z10) throws IOException {
        int i11 = 0;
        if (z10) {
            this.zza.zzo(i10, 2);
            int i12 = 0;
            for (int i13 = 0; i13 < list.size(); i13++) {
                long longValue = list.get(i13).longValue();
                i12 += zzto.zzE((longValue >> 63) ^ (longValue + longValue));
            }
            this.zza.zzq(i12);
            while (i11 < list.size()) {
                zzto zzto = this.zza;
                long longValue2 = list.get(i11).longValue();
                zzto.zzs((longValue2 >> 63) ^ (longValue2 + longValue2));
                i11++;
            }
            return;
        }
        while (i11 < list.size()) {
            zzto zzto2 = this.zza;
            long longValue3 = list.get(i11).longValue();
            zzto2.zzr(i10, (longValue3 >> 63) ^ (longValue3 + longValue3));
            i11++;
        }
    }

    public final void zzF(int i10) throws IOException {
        this.zza.zzo(i10, 3);
    }

    public final void zzG(int i10, String str) throws IOException {
        this.zza.zzm(i10, str);
    }

    public final void zzH(int i10, List<String> list) throws IOException {
        int i11 = 0;
        if (list instanceof zzvs) {
            zzvs zzvs = (zzvs) list;
            while (i11 < list.size()) {
                Object zzf = zzvs.zzf(i11);
                if (zzf instanceof String) {
                    this.zza.zzm(i10, (String) zzf);
                } else {
                    this.zza.zze(i10, (zztd) zzf);
                }
                i11++;
            }
            return;
        }
        while (i11 < list.size()) {
            this.zza.zzm(i10, list.get(i11));
            i11++;
        }
    }

    public final void zzI(int i10, int i11) throws IOException {
        this.zza.zzp(i10, i11);
    }

    public final void zzJ(int i10, List<Integer> list, boolean z10) throws IOException {
        int i11 = 0;
        if (z10) {
            this.zza.zzo(i10, 2);
            int i12 = 0;
            for (int i13 = 0; i13 < list.size(); i13++) {
                i12 += zzto.zzD(list.get(i13).intValue());
            }
            this.zza.zzq(i12);
            while (i11 < list.size()) {
                this.zza.zzq(list.get(i11).intValue());
                i11++;
            }
            return;
        }
        while (i11 < list.size()) {
            this.zza.zzp(i10, list.get(i11).intValue());
            i11++;
        }
    }

    public final void zzK(int i10, long j10) throws IOException {
        this.zza.zzr(i10, j10);
    }

    public final void zzL(int i10, List<Long> list, boolean z10) throws IOException {
        int i11 = 0;
        if (z10) {
            this.zza.zzo(i10, 2);
            int i12 = 0;
            for (int i13 = 0; i13 < list.size(); i13++) {
                i12 += zzto.zzE(list.get(i13).longValue());
            }
            this.zza.zzq(i12);
            while (i11 < list.size()) {
                this.zza.zzs(list.get(i11).longValue());
                i11++;
            }
            return;
        }
        while (i11 < list.size()) {
            this.zza.zzr(i10, list.get(i11).longValue());
            i11++;
        }
    }

    public final void zzb(int i10, boolean z10) throws IOException {
        this.zza.zzd(i10, z10);
    }

    public final void zzc(int i10, List<Boolean> list, boolean z10) throws IOException {
        int i11 = 0;
        if (z10) {
            this.zza.zzo(i10, 2);
            int i12 = 0;
            for (int i13 = 0; i13 < list.size(); i13++) {
                list.get(i13).booleanValue();
                i12++;
            }
            this.zza.zzq(i12);
            while (i11 < list.size()) {
                this.zza.zzb(list.get(i11).booleanValue() ? (byte) 1 : 0);
                i11++;
            }
            return;
        }
        while (i11 < list.size()) {
            this.zza.zzd(i10, list.get(i11).booleanValue());
            i11++;
        }
    }

    public final void zzd(int i10, zztd zztd) throws IOException {
        this.zza.zze(i10, zztd);
    }

    public final void zze(int i10, List<zztd> list) throws IOException {
        for (int i11 = 0; i11 < list.size(); i11++) {
            this.zza.zze(i10, list.get(i11));
        }
    }

    public final void zzf(int i10, double d10) throws IOException {
        this.zza.zzh(i10, Double.doubleToRawLongBits(d10));
    }

    public final void zzg(int i10, List<Double> list, boolean z10) throws IOException {
        int i11 = 0;
        if (z10) {
            this.zza.zzo(i10, 2);
            int i12 = 0;
            for (int i13 = 0; i13 < list.size(); i13++) {
                list.get(i13).doubleValue();
                i12 += 8;
            }
            this.zza.zzq(i12);
            while (i11 < list.size()) {
                this.zza.zzi(Double.doubleToRawLongBits(list.get(i11).doubleValue()));
                i11++;
            }
            return;
        }
        while (i11 < list.size()) {
            this.zza.zzh(i10, Double.doubleToRawLongBits(list.get(i11).doubleValue()));
            i11++;
        }
    }

    public final void zzh(int i10) throws IOException {
        this.zza.zzo(i10, 4);
    }

    public final void zzi(int i10, int i11) throws IOException {
        this.zza.zzj(i10, i11);
    }

    public final void zzj(int i10, List<Integer> list, boolean z10) throws IOException {
        int i11 = 0;
        if (z10) {
            this.zza.zzo(i10, 2);
            int i12 = 0;
            for (int i13 = 0; i13 < list.size(); i13++) {
                i12 += zzto.zzx(list.get(i13).intValue());
            }
            this.zza.zzq(i12);
            while (i11 < list.size()) {
                this.zza.zzk(list.get(i11).intValue());
                i11++;
            }
            return;
        }
        while (i11 < list.size()) {
            this.zza.zzj(i10, list.get(i11).intValue());
            i11++;
        }
    }

    public final void zzk(int i10, int i11) throws IOException {
        this.zza.zzf(i10, i11);
    }

    public final void zzl(int i10, List<Integer> list, boolean z10) throws IOException {
        int i11 = 0;
        if (z10) {
            this.zza.zzo(i10, 2);
            int i12 = 0;
            for (int i13 = 0; i13 < list.size(); i13++) {
                list.get(i13).intValue();
                i12 += 4;
            }
            this.zza.zzq(i12);
            while (i11 < list.size()) {
                this.zza.zzg(list.get(i11).intValue());
                i11++;
            }
            return;
        }
        while (i11 < list.size()) {
            this.zza.zzf(i10, list.get(i11).intValue());
            i11++;
        }
    }

    public final void zzm(int i10, long j10) throws IOException {
        this.zza.zzh(i10, j10);
    }

    public final void zzn(int i10, List<Long> list, boolean z10) throws IOException {
        int i11 = 0;
        if (z10) {
            this.zza.zzo(i10, 2);
            int i12 = 0;
            for (int i13 = 0; i13 < list.size(); i13++) {
                list.get(i13).longValue();
                i12 += 8;
            }
            this.zza.zzq(i12);
            while (i11 < list.size()) {
                this.zza.zzi(list.get(i11).longValue());
                i11++;
            }
            return;
        }
        while (i11 < list.size()) {
            this.zza.zzh(i10, list.get(i11).longValue());
            i11++;
        }
    }

    public final void zzo(int i10, float f10) throws IOException {
        this.zza.zzf(i10, Float.floatToRawIntBits(f10));
    }

    public final void zzp(int i10, List<Float> list, boolean z10) throws IOException {
        int i11 = 0;
        if (z10) {
            this.zza.zzo(i10, 2);
            int i12 = 0;
            for (int i13 = 0; i13 < list.size(); i13++) {
                list.get(i13).floatValue();
                i12 += 4;
            }
            this.zza.zzq(i12);
            while (i11 < list.size()) {
                this.zza.zzg(Float.floatToRawIntBits(list.get(i11).floatValue()));
                i11++;
            }
            return;
        }
        while (i11 < list.size()) {
            this.zza.zzf(i10, Float.floatToRawIntBits(list.get(i11).floatValue()));
            i11++;
        }
    }

    public final void zzq(int i10, Object obj, zzwx zzwx) throws IOException {
        zzto zzto = this.zza;
        zzto.zzo(i10, 3);
        zzwx.zzn((zzwk) obj, zzto.zza);
        zzto.zzo(i10, 4);
    }

    public final void zzr(int i10, int i11) throws IOException {
        this.zza.zzj(i10, i11);
    }

    public final void zzs(int i10, List<Integer> list, boolean z10) throws IOException {
        int i11 = 0;
        if (z10) {
            this.zza.zzo(i10, 2);
            int i12 = 0;
            for (int i13 = 0; i13 < list.size(); i13++) {
                i12 += zzto.zzx(list.get(i13).intValue());
            }
            this.zza.zzq(i12);
            while (i11 < list.size()) {
                this.zza.zzk(list.get(i11).intValue());
                i11++;
            }
            return;
        }
        while (i11 < list.size()) {
            this.zza.zzj(i10, list.get(i11).intValue());
            i11++;
        }
    }

    public final void zzt(int i10, long j10) throws IOException {
        this.zza.zzr(i10, j10);
    }

    public final void zzu(int i10, List<Long> list, boolean z10) throws IOException {
        int i11 = 0;
        if (z10) {
            this.zza.zzo(i10, 2);
            int i12 = 0;
            for (int i13 = 0; i13 < list.size(); i13++) {
                i12 += zzto.zzE(list.get(i13).longValue());
            }
            this.zza.zzq(i12);
            while (i11 < list.size()) {
                this.zza.zzs(list.get(i11).longValue());
                i11++;
            }
            return;
        }
        while (i11 < list.size()) {
            this.zza.zzr(i10, list.get(i11).longValue());
            i11++;
        }
    }

    public final void zzv(int i10, Object obj, zzwx zzwx) throws IOException {
        zzwk zzwk = (zzwk) obj;
        zztl zztl = (zztl) this.zza;
        zztl.zzq((i10 << 3) | 2);
        zzsh zzsh = (zzsh) zzwk;
        int zzQ = zzsh.zzQ();
        if (zzQ == -1) {
            zzQ = zzwx.zza(zzsh);
            zzsh.zzT(zzQ);
        }
        zztl.zzq(zzQ);
        zzwx.zzn(zzwk, zztl.zza);
    }

    public final void zzw(int i10, Object obj) throws IOException {
        if (obj instanceof zztd) {
            zztl zztl = (zztl) this.zza;
            zztl.zzq(11);
            zztl.zzp(2, i10);
            zztl.zze(3, (zztd) obj);
            zztl.zzq(12);
            return;
        }
        zzto zzto = this.zza;
        zzwk zzwk = (zzwk) obj;
        zztl zztl2 = (zztl) zzto;
        zztl2.zzq(11);
        zztl2.zzp(2, i10);
        zztl2.zzq(26);
        zztl2.zzq(zzwk.zzX());
        zzwk.zzaq(zzto);
        zztl2.zzq(12);
    }

    public final void zzx(int i10, int i11) throws IOException {
        this.zza.zzf(i10, i11);
    }

    public final void zzy(int i10, List<Integer> list, boolean z10) throws IOException {
        int i11 = 0;
        if (z10) {
            this.zza.zzo(i10, 2);
            int i12 = 0;
            for (int i13 = 0; i13 < list.size(); i13++) {
                list.get(i13).intValue();
                i12 += 4;
            }
            this.zza.zzq(i12);
            while (i11 < list.size()) {
                this.zza.zzg(list.get(i11).intValue());
                i11++;
            }
            return;
        }
        while (i11 < list.size()) {
            this.zza.zzf(i10, list.get(i11).intValue());
            i11++;
        }
    }

    public final void zzz(int i10, long j10) throws IOException {
        this.zza.zzh(i10, j10);
    }
}
