package androidx.lifecycle;

import android.content.Context;
import androidx.lifecycle.ProcessLifecycleOwner;
import com.mparticle.identity.IdentityHttpResponse;
import java.util.List;
import kotlin.jvm.internal.j;
import v1.a;

public final class ProcessLifecycleInitializer implements a<l> {
    public List<Class<? extends a<?>>> a() {
        return q.j();
    }

    /* renamed from: c */
    public l b(Context context) {
        j.g(context, IdentityHttpResponse.CONTEXT);
        androidx.startup.a e10 = androidx.startup.a.e(context);
        j.f(e10, "getInstance(context)");
        if (e10.g(ProcessLifecycleInitializer.class)) {
            h.a(context);
            ProcessLifecycleOwner.b bVar = ProcessLifecycleOwner.f5952j;
            bVar.b(context);
            return bVar.a();
        }
        throw new IllegalStateException("ProcessLifecycleInitializer cannot be initialized lazily.\n               Please ensure that you have:\n               <meta-data\n                   android:name='androidx.lifecycle.ProcessLifecycleInitializer'\n                   android:value='androidx.startup' />\n               under InitializationProvider in your AndroidManifest.xml".toString());
    }
}
