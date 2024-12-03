package lc;

import android.content.Context;
import android.util.TypedValue;
import com.mparticle.identity.IdentityHttpResponse;

public final class j {

    /* renamed from: a  reason: collision with root package name */
    public static final j f41113a = new j();

    private j() {
    }

    public final int a(Context context, int i10) {
        kotlin.jvm.internal.j.g(context, IdentityHttpResponse.CONTEXT);
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(i10, typedValue, true);
        return typedValue.data;
    }
}
