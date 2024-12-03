package com.google.android.gms.internal.mlkit_common;

import androidx.annotation.NonNull;
import com.google.firebase.encoders.EncodingException;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ValueEncoderContext;
import java.io.IOException;

final class zzbu implements ValueEncoderContext {
    private boolean zza = false;
    private boolean zzb = false;
    private FieldDescriptor zzc;
    private final zzbq zzd;

    zzbu(zzbq zzbq) {
        this.zzd = zzbq;
    }

    private final void zzb() {
        if (!this.zza) {
            this.zza = true;
            return;
        }
        throw new EncodingException("Cannot encode a second value in the ValueEncoderContext");
    }

    @NonNull
    public final ValueEncoderContext add(double d10) throws IOException {
        zzb();
        this.zzd.zza(this.zzc, d10, this.zzb);
        return this;
    }

    /* access modifiers changed from: package-private */
    public final void zza(FieldDescriptor fieldDescriptor, boolean z10) {
        this.zza = false;
        this.zzc = fieldDescriptor;
        this.zzb = z10;
    }

    @NonNull
    public final ValueEncoderContext add(float f10) throws IOException {
        zzb();
        this.zzd.zzb(this.zzc, f10, this.zzb);
        return this;
    }

    @NonNull
    public final ValueEncoderContext add(int i10) throws IOException {
        zzb();
        this.zzd.zzd(this.zzc, i10, this.zzb);
        return this;
    }

    @NonNull
    public final ValueEncoderContext add(long j10) throws IOException {
        zzb();
        this.zzd.zze(this.zzc, j10, this.zzb);
        return this;
    }

    @NonNull
    public final ValueEncoderContext add(String str) throws IOException {
        zzb();
        this.zzd.zzc(this.zzc, str, this.zzb);
        return this;
    }

    @NonNull
    public final ValueEncoderContext add(boolean z10) throws IOException {
        zzb();
        this.zzd.zzd(this.zzc, z10 ? 1 : 0, this.zzb);
        return this;
    }

    @NonNull
    public final ValueEncoderContext add(@NonNull byte[] bArr) throws IOException {
        zzb();
        this.zzd.zzc(this.zzc, bArr, this.zzb);
        return this;
    }
}
