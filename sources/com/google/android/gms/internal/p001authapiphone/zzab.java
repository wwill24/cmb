package com.google.android.gms.internal.p001authapiphone;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.common.api.internal.v;
import com.google.android.gms.tasks.Task;
import zd.b;

/* renamed from: com.google.android.gms.internal.auth-api-phone.zzab  reason: invalid package */
public final class zzab extends b {
    public zzab(Activity activity) {
        super(activity);
    }

    public final Task<Void> startSmsRetriever() {
        return doWrite(v.a().b(new zzx(this)).d(zzac.zzc).e(1567).a());
    }

    public final Task<Void> startSmsUserConsent(String str) {
        return doWrite(v.a().b(new zzy(this, str)).d(zzac.zzd).e(1568).a());
    }

    public zzab(Context context) {
        super(context);
    }
}
