package lc;

import android.content.Context;
import com.mparticle.identity.IdentityHttpResponse;
import kotlin.jvm.internal.j;

public final class m {

    /* renamed from: a  reason: collision with root package name */
    public static final m f41114a = new m();

    private m() {
    }

    public final int a(Context context, float f10) {
        j.g(context, IdentityHttpResponse.CONTEXT);
        return c.b(f10 * context.getResources().getDisplayMetrics().density);
    }
}
