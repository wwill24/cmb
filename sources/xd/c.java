package xd;

import android.app.PendingIntent;
import android.content.Context;
import androidx.annotation.NonNull;
import com.google.android.gms.auth.api.credentials.HintRequest;
import com.google.android.gms.common.api.internal.t;
import com.google.android.gms.internal.p002authapi.zbn;
import vd.a;

@Deprecated
public class c extends com.google.android.gms.common.api.c<a.C0509a> {
    c(@NonNull Context context, @NonNull a.C0509a aVar) {
        super(context, a.f42079b, aVar, (t) new com.google.android.gms.common.api.internal.a());
    }

    @NonNull
    @Deprecated
    public PendingIntent d(@NonNull HintRequest hintRequest) {
        return zbn.zba(getApplicationContext(), (a.C0509a) getApiOptions(), hintRequest, ((a.C0509a) getApiOptions()).d());
    }
}
