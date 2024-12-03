package com.squareup.workflow1.ui;

import android.content.Context;
import android.view.View;
import androidx.activity.l;
import androidx.activity.n;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.j;

@Metadata(bv = {}, d1 = {"\u00007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0006*\u0001\u0016\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B!\u0012\u0006\u0010\u0010\u001a\u00020\u0006\u0012\u0010\u0010\u0015\u001a\f\u0012\u0004\u0012\u00020\u00030\u0011j\u0002`\u0012¢\u0006\u0004\b\u0019\u0010\u001aJ\u0006\u0010\u0004\u001a\u00020\u0003J\u0006\u0010\u0005\u001a\u00020\u0003J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0006H\u0016J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000bH\u0016R\u0014\u0010\u0010\u001a\u00020\u00068\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR!\u0010\u0015\u001a\f\u0012\u0004\u0012\u00020\u00030\u0011j\u0002`\u00128\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0013\u001a\u0004\b\u000e\u0010\u0014R\u0014\u0010\u0018\u001a\u00020\u00168\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0017¨\u0006\u001b"}, d2 = {"Lcom/squareup/workflow1/ui/HandleBackPressWhenAttached;", "Landroid/view/View$OnAttachStateChangeListener;", "Landroidx/lifecycle/DefaultLifecycleObserver;", "", "b", "c", "Landroid/view/View;", "attachedView", "onViewAttachedToWindow", "detachedView", "onViewDetachedFromWindow", "Landroidx/lifecycle/l;", "owner", "onDestroy", "a", "Landroid/view/View;", "view", "Lkotlin/Function0;", "Lcom/squareup/workflow1/ui/BackPressHandler;", "Lkotlin/jvm/functions/Function0;", "()Lkotlin/jvm/functions/Function0;", "handler", "com/squareup/workflow1/ui/HandleBackPressWhenAttached$a", "Lcom/squareup/workflow1/ui/HandleBackPressWhenAttached$a;", "onBackPressedCallback", "<init>", "(Landroid/view/View;Lkotlin/jvm/functions/Function0;)V", "wf1-core-android"}, k = 1, mv = {1, 6, 0})
final class HandleBackPressWhenAttached implements View.OnAttachStateChangeListener, DefaultLifecycleObserver {

    /* renamed from: a  reason: collision with root package name */
    private final View f23167a;

    /* renamed from: b  reason: collision with root package name */
    private final Function0<Unit> f23168b;

    /* renamed from: c  reason: collision with root package name */
    private final a f23169c = new a(this);

    @Metadata(bv = {}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0004"}, d2 = {"com/squareup/workflow1/ui/HandleBackPressWhenAttached$a", "Landroidx/activity/l;", "", "b", "wf1-core-android"}, k = 1, mv = {1, 6, 0})
    public static final class a extends l {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ HandleBackPressWhenAttached f23170d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(HandleBackPressWhenAttached handleBackPressWhenAttached) {
            super(false);
            this.f23170d = handleBackPressWhenAttached;
        }

        public void b() {
            this.f23170d.a().invoke();
        }
    }

    public HandleBackPressWhenAttached(View view, Function0<Unit> function0) {
        j.g(view, "view");
        j.g(function0, "handler");
        this.f23167a = view;
        this.f23168b = function0;
    }

    public final Function0<Unit> a() {
        return this.f23168b;
    }

    public final void b() {
        Lifecycle lifecycle;
        Context context = this.f23167a.getContext();
        j.f(context, "view.context");
        n b10 = b.b(context);
        if (b10 != null) {
            b10.getOnBackPressedDispatcher().b(b10, this.f23169c);
            this.f23167a.addOnAttachStateChangeListener(this);
            if (this.f23167a.isAttachedToWindow()) {
                onViewAttachedToWindow(this.f23167a);
            }
            androidx.lifecycle.l a10 = ViewTreeLifecycleOwner.a(this.f23167a);
            if (a10 != null && (lifecycle = a10.getLifecycle()) != null) {
                lifecycle.a(this);
            }
        }
    }

    public final void c() {
        Lifecycle lifecycle;
        this.f23169c.d();
        this.f23167a.removeOnAttachStateChangeListener(this);
        androidx.lifecycle.l a10 = ViewTreeLifecycleOwner.a(this.f23167a);
        if (a10 != null && (lifecycle = a10.getLifecycle()) != null) {
            lifecycle.d(this);
        }
    }

    public void onDestroy(androidx.lifecycle.l lVar) {
        j.g(lVar, "owner");
        c();
    }

    public void onViewAttachedToWindow(View view) {
        boolean z10;
        j.g(view, "attachedView");
        if (this.f23167a == view) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            this.f23169c.f(true);
            return;
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    public void onViewDetachedFromWindow(View view) {
        boolean z10;
        j.g(view, "detachedView");
        if (this.f23167a == view) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            this.f23169c.f(false);
            return;
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }
}
