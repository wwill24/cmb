package com.withpersona.sdk2.camera;

import android.content.Context;
import android.content.ContextWrapper;
import androidx.appcompat.app.c;
import kotlin.jvm.internal.j;

public final class p {
    public static final c a(Context context) {
        j.g(context, "<this>");
        if (context instanceof c) {
            return (c) context;
        }
        if (!(context instanceof ContextWrapper)) {
            return null;
        }
        Context baseContext = ((ContextWrapper) context).getBaseContext();
        j.f(baseContext, "baseContext");
        return a(baseContext);
    }

    public static final c b(Context context) {
        j.g(context, "<this>");
        c a10 = a(context);
        if (a10 != null) {
            return a10;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }
}
