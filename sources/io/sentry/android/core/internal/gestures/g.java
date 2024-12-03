package io.sentry.android.core.internal.gestures;

import android.app.Activity;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import io.sentry.SentryLevel;
import io.sentry.SpanStatus;
import io.sentry.android.core.SentryAndroidOptions;
import io.sentry.d;
import io.sentry.e2;
import io.sentry.g0;
import io.sentry.h0;
import io.sentry.internal.gestures.UiElement;
import io.sentry.n0;
import io.sentry.protocol.TransactionNameSource;
import io.sentry.s4;
import io.sentry.u4;
import io.sentry.w;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.Map;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.VisibleForTesting;

@ApiStatus.Internal
public final class g implements GestureDetector.OnGestureListener {

    /* renamed from: a  reason: collision with root package name */
    private final WeakReference<Activity> f31002a;

    /* renamed from: b  reason: collision with root package name */
    private final g0 f31003b;

    /* renamed from: c  reason: collision with root package name */
    private final SentryAndroidOptions f31004c;

    /* renamed from: d  reason: collision with root package name */
    private UiElement f31005d = null;

    /* renamed from: e  reason: collision with root package name */
    private n0 f31006e = null;

    /* renamed from: f  reason: collision with root package name */
    private String f31007f = null;

    /* renamed from: g  reason: collision with root package name */
    private final b f31008g = new b();

    private static final class b {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public String f31009a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public UiElement f31010b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public float f31011c;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public float f31012d;

        private b() {
            this.f31009a = null;
            this.f31011c = 0.0f;
            this.f31012d = 0.0f;
        }

        /* access modifiers changed from: private */
        public String i(MotionEvent motionEvent) {
            float x10 = motionEvent.getX() - this.f31011c;
            float y10 = motionEvent.getY() - this.f31012d;
            if (Math.abs(x10) > Math.abs(y10)) {
                if (x10 > 0.0f) {
                    return "right";
                }
                return ViewHierarchyConstants.DIMENSION_LEFT_KEY;
            } else if (y10 > 0.0f) {
                return "down";
            } else {
                return "up";
            }
        }

        /* access modifiers changed from: private */
        public void j() {
            this.f31010b = null;
            this.f31009a = null;
            this.f31011c = 0.0f;
            this.f31012d = 0.0f;
        }

        /* access modifiers changed from: private */
        public void k(UiElement uiElement) {
            this.f31010b = uiElement;
        }
    }

    public g(Activity activity, g0 g0Var, SentryAndroidOptions sentryAndroidOptions) {
        this.f31002a = new WeakReference<>(activity);
        this.f31003b = g0Var;
        this.f31004c = sentryAndroidOptions;
    }

    private void e(UiElement uiElement, String str, Map<String, Object> map, MotionEvent motionEvent) {
        if (this.f31004c.isEnableUserInteractionBreadcrumbs()) {
            w wVar = new w();
            wVar.i("android:motionEvent", motionEvent);
            wVar.i("android:view", uiElement.e());
            this.f31003b.t(d.r(str, uiElement.c(), uiElement.a(), uiElement.d(), map), wVar);
        }
    }

    private View h(String str) {
        Activity activity = this.f31002a.get();
        if (activity == null) {
            h0 logger = this.f31004c.getLogger();
            SentryLevel sentryLevel = SentryLevel.DEBUG;
            logger.c(sentryLevel, "Activity is null in " + str + ". No breadcrumb captured.", new Object[0]);
            return null;
        }
        Window window = activity.getWindow();
        if (window == null) {
            h0 logger2 = this.f31004c.getLogger();
            SentryLevel sentryLevel2 = SentryLevel.DEBUG;
            logger2.c(sentryLevel2, "Window is null in " + str + ". No breadcrumb captured.", new Object[0]);
            return null;
        }
        View decorView = window.getDecorView();
        if (decorView != null) {
            return decorView;
        }
        h0 logger3 = this.f31004c.getLogger();
        SentryLevel sentryLevel3 = SentryLevel.DEBUG;
        logger3.c(sentryLevel3, "DecorView is null in " + str + ". No breadcrumb captured.", new Object[0]);
        return null;
    }

    private String i(Activity activity) {
        return activity.getClass().getSimpleName();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void j(e2 e2Var, n0 n0Var, n0 n0Var2) {
        if (n0Var2 == null) {
            e2Var.u(n0Var);
            return;
        }
        this.f31004c.getLogger().c(SentryLevel.DEBUG, "Transaction '%s' won't be bound to the Scope since there's one already in there.", n0Var.getName());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void k(e2 e2Var, n0 n0Var) {
        if (n0Var == this.f31006e) {
            e2Var.b();
        }
    }

    private void o(UiElement uiElement, String str) {
        if (this.f31004c.isTracingEnabled() && this.f31004c.isEnableUserInteractionTracing()) {
            Activity activity = this.f31002a.get();
            if (activity == null) {
                this.f31004c.getLogger().c(SentryLevel.DEBUG, "Activity is null, no transaction captured.", new Object[0]);
                return;
            }
            String b10 = uiElement.b();
            UiElement uiElement2 = this.f31005d;
            if (this.f31006e != null) {
                if (!uiElement.equals(uiElement2) || !str.equals(this.f31007f) || this.f31006e.a()) {
                    p(SpanStatus.OK);
                } else {
                    this.f31004c.getLogger().c(SentryLevel.DEBUG, "The view with id: " + b10 + " already has an ongoing transaction assigned. Rescheduling finish", new Object[0]);
                    if (this.f31004c.getIdleTimeout() != null) {
                        this.f31006e.l();
                        return;
                    }
                    return;
                }
            }
            u4 u4Var = new u4();
            u4Var.m(true);
            u4Var.j(this.f31004c.getIdleTimeout());
            u4Var.d(true);
            n0 y10 = this.f31003b.y(new s4(i(activity) + "." + b10, TransactionNameSource.COMPONENT, "ui.action." + str), u4Var);
            this.f31003b.u(new d(this, y10));
            this.f31006e = y10;
            this.f31005d = uiElement;
            this.f31007f = str;
        }
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    /* renamed from: f */
    public void l(e2 e2Var, n0 n0Var) {
        e2Var.y(new f(this, e2Var, n0Var));
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    /* renamed from: g */
    public void m(e2 e2Var) {
        e2Var.y(new e(this, e2Var));
    }

    public void n(MotionEvent motionEvent) {
        View h10 = h("onUp");
        UiElement a10 = this.f31008g.f31010b;
        if (h10 != null && a10 != null) {
            if (this.f31008g.f31009a == null) {
                this.f31004c.getLogger().c(SentryLevel.DEBUG, "Unable to define scroll type. No breadcrumb captured.", new Object[0]);
                return;
            }
            e(a10, this.f31008g.f31009a, Collections.singletonMap("direction", this.f31008g.i(motionEvent)), motionEvent);
            o(a10, this.f31008g.f31009a);
            this.f31008g.j();
        }
    }

    public boolean onDown(MotionEvent motionEvent) {
        if (motionEvent == null) {
            return false;
        }
        this.f31008g.j();
        float unused = this.f31008g.f31011c = motionEvent.getX();
        float unused2 = this.f31008g.f31012d = motionEvent.getY();
        return false;
    }

    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f10, float f11) {
        String unused = this.f31008g.f31009a = "swipe";
        return false;
    }

    public void onLongPress(MotionEvent motionEvent) {
    }

    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f10, float f11) {
        View h10 = h("onScroll");
        if (!(h10 == null || motionEvent == null || this.f31008g.f31009a != null)) {
            UiElement a10 = i.a(this.f31004c, h10, motionEvent.getX(), motionEvent.getY(), UiElement.Type.SCROLLABLE);
            if (a10 == null) {
                this.f31004c.getLogger().c(SentryLevel.DEBUG, "Unable to find scroll target. No breadcrumb captured.", new Object[0]);
                return false;
            }
            h0 logger = this.f31004c.getLogger();
            SentryLevel sentryLevel = SentryLevel.DEBUG;
            logger.c(sentryLevel, "Scroll target found: " + a10.b(), new Object[0]);
            this.f31008g.k(a10);
            String unused = this.f31008g.f31009a = "scroll";
        }
        return false;
    }

    public void onShowPress(MotionEvent motionEvent) {
    }

    public boolean onSingleTapUp(MotionEvent motionEvent) {
        View h10 = h("onSingleTapUp");
        if (!(h10 == null || motionEvent == null)) {
            UiElement a10 = i.a(this.f31004c, h10, motionEvent.getX(), motionEvent.getY(), UiElement.Type.CLICKABLE);
            if (a10 == null) {
                this.f31004c.getLogger().c(SentryLevel.DEBUG, "Unable to find click target. No breadcrumb captured.", new Object[0]);
                return false;
            }
            e(a10, "click", Collections.emptyMap(), motionEvent);
            o(a10, "click");
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public void p(SpanStatus spanStatus) {
        n0 n0Var = this.f31006e;
        if (n0Var != null) {
            n0Var.h(spanStatus);
        }
        this.f31003b.u(new c(this));
        this.f31006e = null;
        if (this.f31005d != null) {
            this.f31005d = null;
        }
        this.f31007f = null;
    }
}
