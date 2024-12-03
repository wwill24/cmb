package com.withpersona.sdk2.inquiry.steps.ui.components;

import android.content.Context;
import android.graphics.Typeface;
import androidx.core.content.res.h;
import com.mparticle.identity.IdentityHttpResponse;
import com.withpersona.sdk2.inquiry.shared.ResourceType;
import com.withpersona.sdk2.inquiry.shared.ui.a;
import kotlin.jvm.internal.j;

public final class n {
    public static final Typeface a(Context context, String str) {
        Typeface typeface;
        j.g(context, IdentityHttpResponse.CONTEXT);
        j.g(str, "fontName");
        String str2 = str + ".ttf";
        a.C0331a aVar = a.f27525a;
        if (aVar.a().containsKey(str2)) {
            typeface = aVar.a().get(str2);
        } else {
            String[] list = context.getAssets().list("fonts/");
            boolean z10 = true;
            if (list == null || !l.v(list, str2)) {
                z10 = false;
            }
            if (z10) {
                typeface = Typeface.createFromAsset(context.getAssets(), "fonts/" + str2);
            } else {
                Integer g10 = ti.n.g(context, str, ResourceType.font);
                if (g10 != null) {
                    typeface = h.h(context, g10.intValue());
                } else {
                    typeface = null;
                }
            }
        }
        aVar.a().put(str2, typeface);
        return typeface;
    }
}
