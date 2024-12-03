package com.google.android.play.core.integrity;

import android.content.Context;

final class l {

    /* renamed from: a  reason: collision with root package name */
    private static j f20486a;

    static synchronized j a(Context context) {
        j jVar;
        synchronized (l.class) {
            if (f20486a == null) {
                h hVar = new h((g) null);
                Context applicationContext = context.getApplicationContext();
                if (applicationContext != null) {
                    context = applicationContext;
                }
                hVar.a(context);
                f20486a = hVar.b();
            }
            jVar = f20486a;
        }
        return jVar;
    }
}
