package bj;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.withpersona.sdk2.inquiry.shared.ResourceType;
import ti.n;

public final class a {
    /* access modifiers changed from: private */
    public static final Drawable b(Context context, String str) {
        Integer g10;
        if (str == null || (g10 = n.g(context, str, ResourceType.drawable)) == null) {
            return null;
        }
        return androidx.core.content.a.getDrawable(context, g10.intValue());
    }
}
