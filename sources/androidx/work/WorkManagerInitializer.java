package androidx.work;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.work.a;
import b2.f;
import b2.m;
import java.util.Collections;
import java.util.List;
import v1.a;

public final class WorkManagerInitializer implements a<m> {

    /* renamed from: a  reason: collision with root package name */
    private static final String f7350a = f.i("WrkMgrInitializer");

    @NonNull
    public List<Class<? extends a<?>>> a() {
        return Collections.emptyList();
    }

    @NonNull
    /* renamed from: c */
    public m b(@NonNull Context context) {
        f.e().a(f7350a, "Initializing WorkManager with default configuration.");
        m.d(context, new a.b().a());
        return m.c(context);
    }
}
