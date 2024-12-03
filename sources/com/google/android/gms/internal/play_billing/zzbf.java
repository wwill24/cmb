package com.google.android.gms.internal.play_billing;

import java.io.IOException;
import net.bytebuddy.jar.asm.Opcodes;

final class zzbf extends zzbi {
    private final byte[] zzc;
    private final int zzd;
    private int zze;

    zzbf(byte[] bArr, int i10, int i11) {
        super((zzbh) null);
        if (bArr != null) {
            int length = bArr.length;
            if (((length - i11) | i11) >= 0) {
                this.zzc = bArr;
                this.zze = 0;
                this.zzd = i11;
                return;
            }
            throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", new Object[]{Integer.valueOf(length), 0, Integer.valueOf(i11)}));
        }
        throw new NullPointerException("buffer");
    }

    public final int zza() {
        return this.zzd - this.zze;
    }

    public final void zzb(byte b10) throws IOException {
        try {
            byte[] bArr = this.zzc;
            int i10 = this.zze;
            this.zze = i10 + 1;
            bArr[i10] = b10;
        } catch (IndexOutOfBoundsException e10) {
            throw new zzbg(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.zze), Integer.valueOf(this.zzd), 1}), e10);
        }
    }

    public final void zzc(byte[] bArr, int i10, int i11) throws IOException {
        try {
            System.arraycopy(bArr, 0, this.zzc, this.zze, i11);
            this.zze += i11;
        } catch (IndexOutOfBoundsException e10) {
            throw new zzbg(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.zze), Integer.valueOf(this.zzd), Integer.valueOf(i11)}), e10);
        }
    }

    public final void zzd(int i10, boolean z10) throws IOException {
        zzq(i10 << 3);
        zzb(z10 ? (byte) 1 : 0);
    }

    public final void zze(int i10, zzba zzba) throws IOException {
        zzq((i10 << 3) | 2);
        zzq(zzba.zzd());
        zzba.zzh(this);
    }

    public final void zzf(int i10, int i11) throws IOException {
        zzq((i10 << 3) | 5);
        zzg(i11);
    }

    public final void zzg(int i10) throws IOException {
        try {
            byte[] bArr = this.zzc;
            int i11 = this.zze;
            int i12 = i11 + 1;
            bArr[i11] = (byte) (i10 & 255);
            int i13 = i12 + 1;
            bArr[i12] = (byte) ((i10 >> 8) & 255);
            int i14 = i13 + 1;
            bArr[i13] = (byte) ((i10 >> 16) & 255);
            this.zze = i14 + 1;
            bArr[i14] = (byte) ((i10 >> 24) & 255);
        } catch (IndexOutOfBoundsException e10) {
            throw new zzbg(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.zze), Integer.valueOf(this.zzd), 1}), e10);
        }
    }

    public final void zzh(int i10, long j10) throws IOException {
        zzq((i10 << 3) | 1);
        zzi(j10);
    }

    public final void zzi(long j10) throws IOException {
        try {
            byte[] bArr = this.zzc;
            int i10 = this.zze;
            int i11 = i10 + 1;
            bArr[i10] = (byte) (((int) j10) & 255);
            int i12 = i11 + 1;
            bArr[i11] = (byte) (((int) (j10 >> 8)) & 255);
            int i13 = i12 + 1;
            bArr[i12] = (byte) (((int) (j10 >> 16)) & 255);
            int i14 = i13 + 1;
            bArr[i13] = (byte) (((int) (j10 >> 24)) & 255);
            int i15 = i14 + 1;
            bArr[i14] = (byte) (((int) (j10 >> 32)) & 255);
            int i16 = i15 + 1;
            bArr[i15] = (byte) (((int) (j10 >> 40)) & 255);
            int i17 = i16 + 1;
            bArr[i16] = (byte) (((int) (j10 >> 48)) & 255);
            this.zze = i17 + 1;
            bArr[i17] = (byte) (((int) (j10 >> 56)) & 255);
        } catch (IndexOutOfBoundsException e10) {
            throw new zzbg(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.zze), Integer.valueOf(this.zzd), 1}), e10);
        }
    }

    public final void zzj(int i10, int i11) throws IOException {
        zzq(i10 << 3);
        zzk(i11);
    }

    public final void zzk(int i10) throws IOException {
        if (i10 >= 0) {
            zzq(i10);
        } else {
            zzs((long) i10);
        }
    }

    public final void zzl(byte[] bArr, int i10, int i11) throws IOException {
        zzc(bArr, 0, i11);
    }

    public final void zzm(int i10, String str) throws IOException {
        zzq((i10 << 3) | 2);
        zzn(str);
    }

    public final void zzn(String str) throws IOException {
        int i10 = this.zze;
        try {
            int zzx = zzbi.zzx(str.length() * 3);
            int zzx2 = zzbi.zzx(str.length());
            if (zzx2 == zzx) {
                int i11 = i10 + zzx2;
                this.zze = i11;
                int zzb = zzev.zzb(str, this.zzc, i11, this.zzd - i11);
                this.zze = i10;
                zzq((zzb - i10) - zzx2);
                this.zze = zzb;
                return;
            }
            zzq(zzev.zzc(str));
            byte[] bArr = this.zzc;
            int i12 = this.zze;
            this.zze = zzev.zzb(str, bArr, i12, this.zzd - i12);
        } catch (zzeu e10) {
            this.zze = i10;
            zzB(str, e10);
        } catch (IndexOutOfBoundsException e11) {
            throw new zzbg(e11);
        }
    }

    public final void zzo(int i10, int i11) throws IOException {
        zzq((i10 << 3) | i11);
    }

    public final void zzp(int i10, int i11) throws IOException {
        zzq(i10 << 3);
        zzq(i11);
    }

    public final void zzq(int i10) throws IOException {
        while ((i10 & -128) != 0) {
            byte[] bArr = this.zzc;
            int i11 = this.zze;
            this.zze = i11 + 1;
            bArr[i11] = (byte) ((i10 & Opcodes.LAND) | 128);
            i10 >>>= 7;
        }
        try {
            byte[] bArr2 = this.zzc;
            int i12 = this.zze;
            this.zze = i12 + 1;
            bArr2[i12] = (byte) i10;
        } catch (IndexOutOfBoundsException e10) {
            throw new zzbg(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.zze), Integer.valueOf(this.zzd), 1}), e10);
        }
    }

    public final void zzr(int i10, long j10) throws IOException {
        zzq(i10 << 3);
        zzs(j10);
    }

    public final void zzs(long j10) throws IOException {
        if (!zzbi.zzd || this.zzd - this.zze < 10) {
            while ((j10 & -128) != 0) {
                byte[] bArr = this.zzc;
                int i10 = this.zze;
                this.zze = i10 + 1;
                bArr[i10] = (byte) ((((int) j10) & Opcodes.LAND) | 128);
                j10 >>>= 7;
            }
            try {
                byte[] bArr2 = this.zzc;
                int i11 = this.zze;
                this.zze = i11 + 1;
                bArr2[i11] = (byte) ((int) j10);
            } catch (IndexOutOfBoundsException e10) {
                throw new zzbg(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.zze), Integer.valueOf(this.zzd), 1}), e10);
            }
        } else {
            while ((j10 & -128) != 0) {
                byte[] bArr3 = this.zzc;
                int i12 = this.zze;
                this.zze = i12 + 1;
                zzeq.zzn(bArr3, (long) i12, (byte) ((((int) j10) & Opcodes.LAND) | 128));
                j10 >>>= 7;
            }
            byte[] bArr4 = this.zzc;
            int i13 = this.zze;
            this.zze = i13 + 1;
            zzeq.zzn(bArr4, (long) i13, (byte) ((int) j10));
        }
    }
}
