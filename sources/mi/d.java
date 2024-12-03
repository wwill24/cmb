package mi;

import android.content.Context;
import com.mparticle.identity.IdentityHttpResponse;
import kotlin.jvm.internal.j;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    private static b f32796a;

    public static final void a(Context context) {
        j.g(context, IdentityHttpResponse.CONTEXT);
        c(context).b();
    }

    private static final synchronized b b(Context context) {
        synchronized (d.class) {
            b bVar = f32796a;
            if (bVar != null) {
                return bVar;
            }
            b bVar2 = new b(context);
            f32796a = bVar2;
            return bVar2;
        }
    }

    public static final b c(Context context) {
        j.g(context, IdentityHttpResponse.CONTEXT);
        b bVar = f32796a;
        if (bVar == null) {
            return b(context);
        }
        return bVar;
    }

    public static final void d(Context context) {
        j.g(context, IdentityHttpResponse.CONTEXT);
        c(context).e();
    }

    public static final void e(Context context) {
        j.g(context, IdentityHttpResponse.CONTEXT);
        c(context).g();
    }
}
