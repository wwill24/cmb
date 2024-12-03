package com.google.android.gms.internal.gtm;

import java.io.IOException;
import net.bytebuddy.jar.asm.Opcodes;

final class zztl extends zzto {
    private final byte[] zzb;
    private final int zzc;
    private int zzd;

    zztl(byte[] bArr, int i10, int i11) {
        super((zztn) null);
        if (bArr != null) {
            int length = bArr.length;
            if (((length - i11) | i11) >= 0) {
                this.zzb = bArr;
                this.zzd = 0;
                this.zzc = i11;
                return;
            }
            throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", new Object[]{Integer.valueOf(length), 0, Integer.valueOf(i11)}));
        }
        throw new NullPointerException("buffer");
    }

    public final int zza() {
        return this.zzc - this.zzd;
    }

    public final void zzb(byte b10) throws IOException {
        try {
            byte[] bArr = this.zzb;
            int i10 = this.zzd;
            this.zzd = i10 + 1;
            bArr[i10] = b10;
        } catch (IndexOutOfBoundsException e10) {
            throw new zztm(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.zzd), Integer.valueOf(this.zzc), 1}), e10);
        }
    }

    public final void zzc(byte[] bArr, int i10, int i11) throws IOException {
        try {
            System.arraycopy(bArr, i10, this.zzb, this.zzd, i11);
            this.zzd += i11;
        } catch (IndexOutOfBoundsException e10) {
            throw new zztm(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.zzd), Integer.valueOf(this.zzc), Integer.valueOf(i11)}), e10);
        }
    }

    public final void zzd(int i10, boolean z10) throws IOException {
        zzq(i10 << 3);
        zzb(z10 ? (byte) 1 : 0);
    }

    public final void zze(int i10, zztd zztd) throws IOException {
        zzq((i10 << 3) | 2);
        zzq(zztd.zzd());
        zztd.zzi(this);
    }

    public final void zzf(int i10, int i11) throws IOException {
        zzq((i10 << 3) | 5);
        zzg(i11);
    }

    public final void zzg(int i10) throws IOException {
        try {
            byte[] bArr = this.zzb;
            int i11 = this.zzd;
            int i12 = i11 + 1;
            bArr[i11] = (byte) (i10 & 255);
            int i13 = i12 + 1;
            bArr[i12] = (byte) ((i10 >> 8) & 255);
            int i14 = i13 + 1;
            bArr[i13] = (byte) ((i10 >> 16) & 255);
            this.zzd = i14 + 1;
            bArr[i14] = (byte) ((i10 >> 24) & 255);
        } catch (IndexOutOfBoundsException e10) {
            throw new zztm(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.zzd), Integer.valueOf(this.zzc), 1}), e10);
        }
    }

    public final void zzh(int i10, long j10) throws IOException {
        zzq((i10 << 3) | 1);
        zzi(j10);
    }

    public final void zzi(long j10) throws IOException {
        try {
            byte[] bArr = this.zzb;
            int i10 = this.zzd;
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
            this.zzd = i17 + 1;
            bArr[i17] = (byte) (((int) (j10 >> 56)) & 255);
        } catch (IndexOutOfBoundsException e10) {
            throw new zztm(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.zzd), Integer.valueOf(this.zzc), 1}), e10);
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
        int i10 = this.zzd;
        try {
            int zzD = zzto.zzD(str.length() * 3);
            int zzD2 = zzto.zzD(str.length());
            if (zzD2 == zzD) {
                int i11 = i10 + zzD2;
                this.zzd = i11;
                int zzb2 = zzyd.zzb(str, this.zzb, i11, this.zzc - i11);
                this.zzd = i10;
                zzq((zzb2 - i10) - zzD2);
                this.zzd = zzb2;
                return;
            }
            zzq(zzyd.zzc(str));
            byte[] bArr = this.zzb;
            int i12 = this.zzd;
            this.zzd = zzyd.zzb(str, bArr, i12, this.zzc - i12);
        } catch (zzyc e10) {
            this.zzd = i10;
            zzH(str, e10);
        } catch (IndexOutOfBoundsException e11) {
            throw new zztm(e11);
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
        if (zzto.zzc) {
            int i11 = zzsk.zza;
        }
        while ((i10 & -128) != 0) {
            byte[] bArr = this.zzb;
            int i12 = this.zzd;
            this.zzd = i12 + 1;
            bArr[i12] = (byte) ((i10 & Opcodes.LAND) | 128);
            i10 >>>= 7;
        }
        try {
            byte[] bArr2 = this.zzb;
            int i13 = this.zzd;
            this.zzd = i13 + 1;
            bArr2[i13] = (byte) i10;
        } catch (IndexOutOfBoundsException e10) {
            throw new zztm(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.zzd), Integer.valueOf(this.zzc), 1}), e10);
        }
    }

    public final void zzr(int i10, long j10) throws IOException {
        zzq(i10 << 3);
        zzs(j10);
    }

    public final void zzs(long j10) throws IOException {
        if (!zzto.zzc || this.zzc - this.zzd < 10) {
            while ((j10 & -128) != 0) {
                byte[] bArr = this.zzb;
                int i10 = this.zzd;
                this.zzd = i10 + 1;
                bArr[i10] = (byte) ((((int) j10) & Opcodes.LAND) | 128);
                j10 >>>= 7;
            }
            try {
                byte[] bArr2 = this.zzb;
                int i11 = this.zzd;
                this.zzd = i11 + 1;
                bArr2[i11] = (byte) ((int) j10);
            } catch (IndexOutOfBoundsException e10) {
                throw new zztm(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.zzd), Integer.valueOf(this.zzc), 1}), e10);
            }
        } else {
            while ((j10 & -128) != 0) {
                byte[] bArr3 = this.zzb;
                int i12 = this.zzd;
                this.zzd = i12 + 1;
                zzxy.zzn(bArr3, (long) i12, (byte) ((((int) j10) & Opcodes.LAND) | 128));
                j10 >>>= 7;
            }
            byte[] bArr4 = this.zzb;
            int i13 = this.zzd;
            this.zzd = i13 + 1;
            zzxy.zzn(bArr4, (long) i13, (byte) ((int) j10));
        }
    }
}
