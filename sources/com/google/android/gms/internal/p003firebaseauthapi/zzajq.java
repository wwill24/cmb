package com.google.android.gms.internal.p003firebaseauthapi;

import java.io.IOException;
import java.io.OutputStream;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzajq  reason: invalid package */
final class zzajq extends zzajn {
    private final OutputStream zzg;

    zzajq(OutputStream outputStream, int i10) {
        super(i10);
        this.zzg = outputStream;
    }

    private final void zzG() throws IOException {
        this.zzg.write(this.zza, 0, this.zzc);
        this.zzc = 0;
    }

    private final void zzH(int i10) throws IOException {
        if (this.zzb - this.zzc < i10) {
            zzG();
        }
    }

    public final void zzI() throws IOException {
        if (this.zzc > 0) {
            zzG();
        }
    }

    public final void zzJ(byte b10) throws IOException {
        if (this.zzc == this.zzb) {
            zzG();
        }
        zzc(b10);
    }

    public final void zzK(int i10, boolean z10) throws IOException {
        zzH(11);
        zzf(i10 << 3);
        zzc(z10 ? (byte) 1 : 0);
    }

    public final void zzL(int i10, zzajf zzajf) throws IOException {
        zzs((i10 << 3) | 2);
        zzs(zzajf.zzd());
        zzajf.zzj(this);
    }

    public final void zza(byte[] bArr, int i10, int i11) throws IOException {
        zzp(bArr, 0, i11);
    }

    public final void zzh(int i10, int i11) throws IOException {
        zzH(14);
        zzf((i10 << 3) | 5);
        zzd(i11);
    }

    public final void zzi(int i10) throws IOException {
        zzH(4);
        zzd(i10);
    }

    public final void zzj(int i10, long j10) throws IOException {
        zzH(18);
        zzf((i10 << 3) | 1);
        zze(j10);
    }

    public final void zzk(long j10) throws IOException {
        zzH(8);
        zze(j10);
    }

    public final void zzl(int i10, int i11) throws IOException {
        zzH(20);
        zzf(i10 << 3);
        if (i11 >= 0) {
            zzf(i11);
        } else {
            zzg((long) i11);
        }
    }

    public final void zzm(int i10) throws IOException {
        if (i10 >= 0) {
            zzs(i10);
        } else {
            zzu((long) i10);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzn(int i10, zzalp zzalp, zzamb zzamb) throws IOException {
        zzs((i10 << 3) | 2);
        zzs(((zzaip) zzalp).zzn(zzamb));
        zzamb.zzm(zzalp, this.zze);
    }

    public final void zzo(int i10, String str) throws IOException {
        zzs((i10 << 3) | 2);
        zzv(str);
    }

    public final void zzp(byte[] bArr, int i10, int i11) throws IOException {
        int i12 = this.zzb;
        int i13 = this.zzc;
        int i14 = i12 - i13;
        if (i14 >= i11) {
            System.arraycopy(bArr, 0, this.zza, i13, i11);
            this.zzc += i11;
            this.zzd += i11;
            return;
        }
        System.arraycopy(bArr, 0, this.zza, i13, i14);
        this.zzc = this.zzb;
        this.zzd += i14;
        zzG();
        int i15 = i11 - i14;
        if (i15 <= this.zzb) {
            System.arraycopy(bArr, i14, this.zza, 0, i15);
            this.zzc = i15;
        } else {
            this.zzg.write(bArr, i14, i15);
        }
        this.zzd += i15;
    }

    public final void zzq(int i10, int i11) throws IOException {
        zzs((i10 << 3) | i11);
    }

    public final void zzr(int i10, int i11) throws IOException {
        zzH(20);
        zzf(i10 << 3);
        zzf(i11);
    }

    public final void zzs(int i10) throws IOException {
        zzH(5);
        zzf(i10);
    }

    public final void zzt(int i10, long j10) throws IOException {
        zzH(20);
        zzf(i10 << 3);
        zzg(j10);
    }

    public final void zzu(long j10) throws IOException {
        zzH(10);
        zzg(j10);
    }

    public final void zzv(String str) throws IOException {
        int i10;
        int i11;
        try {
            int length = str.length() * 3;
            int zzA = zzajs.zzA(length);
            int i12 = zzA + length;
            int i13 = this.zzb;
            if (i12 > i13) {
                byte[] bArr = new byte[length];
                int zzb = zzank.zzb(str, bArr, 0, length);
                zzs(zzb);
                zzp(bArr, 0, zzb);
                return;
            }
            if (i12 > i13 - this.zzc) {
                zzG();
            }
            int zzA2 = zzajs.zzA(str.length());
            i10 = this.zzc;
            if (zzA2 == zzA) {
                int i14 = i10 + zzA2;
                this.zzc = i14;
                int zzb2 = zzank.zzb(str, this.zza, i14, this.zzb - i14);
                this.zzc = i10;
                i11 = (zzb2 - i10) - zzA2;
                zzf(i11);
                this.zzc = zzb2;
            } else {
                i11 = zzank.zzc(str);
                zzf(i11);
                this.zzc = zzank.zzb(str, this.zza, this.zzc, i11);
            }
            this.zzd += i11;
        } catch (zzanj e10) {
            this.zzd -= this.zzc - i10;
            this.zzc = i10;
            throw e10;
        } catch (ArrayIndexOutOfBoundsException e11) {
            throw new zzajp(e11);
        } catch (zzanj e12) {
            zzE(str, e12);
        }
    }
}
