package io.sentry.android.core;

import android.app.Activity;
import android.view.View;
import android.view.Window;
import io.sentry.SentryLevel;
import io.sentry.android.core.internal.gestures.i;
import io.sentry.b;
import io.sentry.h0;
import io.sentry.p3;
import io.sentry.protocol.y;
import io.sentry.protocol.z;
import io.sentry.t;
import io.sentry.util.l;
import io.sentry.w;
import java.util.ArrayList;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
public final class f1 implements t {

    /* renamed from: a  reason: collision with root package name */
    private final SentryAndroidOptions f30971a;

    public f1(SentryAndroidOptions sentryAndroidOptions) {
        this.f30971a = (SentryAndroidOptions) l.c(sentryAndroidOptions, "SentryAndroidOptions is required");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0005, code lost:
        r5 = (android.view.ViewGroup) r5;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void c(android.view.View r5, io.sentry.protocol.z r6) {
        /*
            boolean r0 = r5 instanceof android.view.ViewGroup
            if (r0 != 0) goto L_0x0005
            return
        L_0x0005:
            android.view.ViewGroup r5 = (android.view.ViewGroup) r5
            int r0 = r5.getChildCount()
            if (r0 != 0) goto L_0x000e
            return
        L_0x000e:
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>(r0)
            r2 = 0
        L_0x0014:
            if (r2 >= r0) goto L_0x0029
            android.view.View r3 = r5.getChildAt(r2)
            if (r3 == 0) goto L_0x0026
            io.sentry.protocol.z r4 = f(r3)
            r1.add(r4)
            c(r3, r4)
        L_0x0026:
            int r2 = r2 + 1
            goto L_0x0014
        L_0x0029:
            r6.m(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.android.core.f1.c(android.view.View, io.sentry.protocol.z):void");
    }

    public static y d(Activity activity, h0 h0Var) {
        if (activity == null) {
            h0Var.c(SentryLevel.INFO, "Missing activity for view hierarchy snapshot.", new Object[0]);
            return null;
        }
        Window window = activity.getWindow();
        if (window == null) {
            h0Var.c(SentryLevel.INFO, "Missing window for view hierarchy snapshot.", new Object[0]);
            return null;
        }
        View peekDecorView = window.peekDecorView();
        if (peekDecorView == null) {
            h0Var.c(SentryLevel.INFO, "Missing decor view for view hierarchy snapshot.", new Object[0]);
            return null;
        }
        try {
            return e(peekDecorView);
        } catch (Throwable th2) {
            h0Var.b(SentryLevel.ERROR, "Failed to process view hierarchy.", th2);
            return null;
        }
    }

    public static y e(View view) {
        ArrayList arrayList = new ArrayList(1);
        y yVar = new y("android_view_system", arrayList);
        z f10 = f(view);
        arrayList.add(f10);
        c(view, f10);
        return yVar;
    }

    private static z f(View view) {
        z zVar = new z();
        String canonicalName = view.getClass().getCanonicalName();
        if (canonicalName == null) {
            canonicalName = view.getClass().getSimpleName();
        }
        zVar.p(canonicalName);
        try {
            zVar.o(i.b(view));
        } catch (Throwable unused) {
        }
        zVar.t(Double.valueOf((double) view.getX()));
        zVar.u(Double.valueOf((double) view.getY()));
        zVar.s(Double.valueOf((double) view.getWidth()));
        zVar.n(Double.valueOf((double) view.getHeight()));
        zVar.l(Double.valueOf((double) view.getAlpha()));
        int visibility = view.getVisibility();
        if (visibility == 0) {
            zVar.r("visible");
        } else if (visibility == 4) {
            zVar.r("invisible");
        } else if (visibility == 8) {
            zVar.r("gone");
        }
        return zVar;
    }

    public p3 a(p3 p3Var, w wVar) {
        y d10;
        if (!p3Var.u0()) {
            return p3Var;
        }
        if (!this.f30971a.isAttachViewHierarchy()) {
            this.f30971a.getLogger().c(SentryLevel.DEBUG, "attachViewHierarchy is disabled.", new Object[0]);
            return p3Var;
        }
        if (!io.sentry.util.i.h(wVar) && (d10 = d(k0.c().b(), this.f30971a.getLogger())) != null) {
            wVar.k(b.b(d10));
        }
        return p3Var;
    }
}
