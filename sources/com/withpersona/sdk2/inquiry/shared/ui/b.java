package com.withpersona.sdk2.inquiry.shared.ui;

import android.view.View;
import android.view.ViewTreeObserver;
import com.mparticle.kits.ReportingMessage;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;

public final class b implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {

    /* renamed from: d  reason: collision with root package name */
    public static final a f27527d = new a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final View f27528a;

    /* renamed from: b  reason: collision with root package name */
    private final Runnable f27529b;

    /* renamed from: c  reason: collision with root package name */
    private ViewTreeObserver f27530c;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final b a(View view, Runnable runnable) {
            j.g(view, "view");
            j.g(runnable, "runnable");
            b bVar = new b(view, runnable, (DefaultConstructorMarker) null);
            view.getViewTreeObserver().addOnPreDrawListener(bVar);
            view.addOnAttachStateChangeListener(bVar);
            return bVar;
        }
    }

    private b(View view, Runnable runnable) {
        this.f27528a = view;
        this.f27529b = runnable;
        ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
        j.f(viewTreeObserver, "view.viewTreeObserver");
        this.f27530c = viewTreeObserver;
    }

    public /* synthetic */ b(View view, Runnable runnable, DefaultConstructorMarker defaultConstructorMarker) {
        this(view, runnable);
    }

    private final void a() {
        if (this.f27530c.isAlive()) {
            this.f27530c.removeOnPreDrawListener(this);
        } else {
            this.f27528a.getViewTreeObserver().removeOnPreDrawListener(this);
        }
        this.f27528a.removeOnAttachStateChangeListener(this);
    }

    public boolean onPreDraw() {
        a();
        this.f27529b.run();
        return false;
    }

    public void onViewAttachedToWindow(View view) {
        j.g(view, ReportingMessage.MessageType.SCREEN_VIEW);
        ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
        j.f(viewTreeObserver, "v.viewTreeObserver");
        this.f27530c = viewTreeObserver;
    }

    public void onViewDetachedFromWindow(View view) {
        j.g(view, ReportingMessage.MessageType.SCREEN_VIEW);
        a();
    }
}
