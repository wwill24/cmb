package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import com.mparticle.identity.IdentityHttpResponse;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.j;

public final class h {

    /* renamed from: a  reason: collision with root package name */
    public static final h f6026a = new h();

    /* renamed from: b  reason: collision with root package name */
    private static final AtomicBoolean f6027b = new AtomicBoolean(false);

    public static final class a extends d {
        public void onActivityCreated(Activity activity, Bundle bundle) {
            j.g(activity, "activity");
            y.f6069b.c(activity);
        }
    }

    private h() {
    }

    public static final void a(Context context) {
        j.g(context, IdentityHttpResponse.CONTEXT);
        if (!f6027b.getAndSet(true)) {
            Context applicationContext = context.getApplicationContext();
            j.e(applicationContext, "null cannot be cast to non-null type android.app.Application");
            ((Application) applicationContext).registerActivityLifecycleCallbacks(new a());
        }
    }
}
