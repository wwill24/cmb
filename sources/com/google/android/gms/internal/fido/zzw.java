package com.google.android.gms.internal.fido;

import android.os.ParcelFileDescriptor;
import com.google.android.gms.common.api.internal.q;
import com.google.android.gms.fido.sourcedevice.SourceStartDirectTransferOptions;
import com.google.android.gms.tasks.TaskCompletionSource;

public final /* synthetic */ class zzw implements q {
    public final /* synthetic */ zzy zza;
    public final /* synthetic */ SourceStartDirectTransferOptions zzb;
    public final /* synthetic */ ParcelFileDescriptor zzc;
    public final /* synthetic */ ParcelFileDescriptor zzd;

    public /* synthetic */ zzw(zzy zzy, SourceStartDirectTransferOptions sourceStartDirectTransferOptions, ParcelFileDescriptor parcelFileDescriptor, ParcelFileDescriptor parcelFileDescriptor2) {
        this.zza = zzy;
        this.zzb = sourceStartDirectTransferOptions;
        this.zzc = parcelFileDescriptor;
        this.zzd = parcelFileDescriptor2;
    }

    public final void accept(Object obj, Object obj2) {
        zzy zzy = this.zza;
        SourceStartDirectTransferOptions sourceStartDirectTransferOptions = this.zzb;
        ParcelFileDescriptor parcelFileDescriptor = this.zzc;
        ParcelFileDescriptor parcelFileDescriptor2 = this.zzd;
        ((zzt) ((zzaa) obj).getService()).zzc(new zzx(zzy, (TaskCompletionSource) obj2), sourceStartDirectTransferOptions, parcelFileDescriptor, parcelFileDescriptor2);
    }
}
