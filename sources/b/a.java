package b;

import android.content.Context;
import com.mparticle.identity.IdentityHttpResponse;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.jvm.internal.j;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private final Set<b> f7672a = new CopyOnWriteArraySet();

    /* renamed from: b  reason: collision with root package name */
    private volatile Context f7673b;

    public final void a(b bVar) {
        j.g(bVar, "listener");
        Context context = this.f7673b;
        if (context != null) {
            bVar.a(context);
        }
        this.f7672a.add(bVar);
    }

    public final void b() {
        this.f7673b = null;
    }

    public final void c(Context context) {
        j.g(context, IdentityHttpResponse.CONTEXT);
        this.f7673b = context;
        for (b a10 : this.f7672a) {
            a10.a(context);
        }
    }

    public final Context d() {
        return this.f7673b;
    }

    public final void e(b bVar) {
        j.g(bVar, "listener");
        this.f7672a.remove(bVar);
    }
}
