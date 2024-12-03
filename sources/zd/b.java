package zd;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.c;
import com.google.android.gms.internal.p001authapiphone.zzw;
import com.google.android.gms.tasks.Task;

public abstract class b extends c<a.d.c> {
    private static final a.g<zzw> zza;
    private static final a.C0480a<zzw, a.d.c> zzb;
    private static final a<a.d.c> zzc;

    static {
        a.g<zzw> gVar = new a.g<>();
        zza = gVar;
        c cVar = new c();
        zzb = cVar;
        zzc = new a<>("SmsRetriever.API", cVar, gVar);
    }

    public b(@NonNull Activity activity) {
        super(activity, zzc, a.d.f38515i, c.a.f38516c);
    }

    @NonNull
    public abstract Task<Void> startSmsRetriever();

    @NonNull
    public abstract Task<Void> startSmsUserConsent(String str);

    public b(@NonNull Context context) {
        super(context, zzc, a.d.f38515i, c.a.f38516c);
    }
}
