package com.google.android.gms.internal.fido;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.ParcelFileDescriptor;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.c;
import com.google.android.gms.common.api.internal.v;
import com.google.android.gms.fido.sourcedevice.SourceDirectTransferResult;
import com.google.android.gms.fido.sourcedevice.SourceStartDirectTransferOptions;
import com.google.android.gms.tasks.Task;
import fe.b;

public final class zzy extends c {
    private static final a.g zza;
    private static final a zzb;

    static {
        a.g gVar = new a.g();
        zza = gVar;
        zzb = new a("Fido.FIDO_SOURCE_DIRECT_TRANSFER_API", new zzz(), gVar);
    }

    public zzy(Activity activity) {
        super(activity, zzb, a.d.f38515i, c.a.f38516c);
    }

    public final SourceDirectTransferResult getSourceDirectTransferResultFromIntent(Intent intent) throws ApiException {
        if (intent != null) {
            SourceDirectTransferResult sourceDirectTransferResult = (SourceDirectTransferResult) b.b(intent, "source_direct_transfer_result", SourceDirectTransferResult.CREATOR);
            if (sourceDirectTransferResult != null) {
                return sourceDirectTransferResult;
            }
            throw new ApiException(Status.f38502j);
        }
        throw new ApiException(Status.f38502j);
    }

    public final Task<PendingIntent> startDirectTransfer(SourceStartDirectTransferOptions sourceStartDirectTransferOptions, ParcelFileDescriptor parcelFileDescriptor, ParcelFileDescriptor parcelFileDescriptor2) {
        return doRead(v.a().b(new zzw(this, sourceStartDirectTransferOptions, parcelFileDescriptor, parcelFileDescriptor2)).e(5421).a());
    }

    public zzy(Context context) {
        super(context, zzb, a.d.f38515i, c.a.f38516c);
    }
}
