package com.squareup.workflow1.ui.androidx;

import android.view.View;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.i;
import androidx.lifecycle.l;
import androidx.lifecycle.n;
import com.mparticle.kits.ReportingMessage;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;

@Metadata(bv = {}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0001\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B%\u0012\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000f0\u0015\u0012\b\b\u0002\u0010&\u001a\u00020\u0011¢\u0006\u0004\b'\u0010(J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\r\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\u000e\u001a\u00020\u0007H\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\u0019\u0010\u0013\u001a\u00020\u00072\b\b\u0002\u0010\u0012\u001a\u00020\u0011H\u0001¢\u0006\u0004\b\u0013\u0010\u0014R \u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000f0\u00158\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0016R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001e\u001a\u00020\u001b8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010!\u001a\u00020\u00118\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0018\u0010#\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\r\u0010\"R\u0016\u0010%\u001a\u00020\u00118\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b$\u0010 ¨\u0006)"}, d2 = {"Lcom/squareup/workflow1/ui/androidx/RealWorkflowLifecycleOwner;", "Lcom/squareup/workflow1/ui/androidx/WorkflowLifecycleOwner;", "Landroidx/lifecycle/l;", "Landroid/view/View$OnAttachStateChangeListener;", "Landroidx/lifecycle/i;", "Landroid/view/View;", "v", "", "onViewAttachedToWindow", "onViewDetachedFromWindow", "source", "Landroidx/lifecycle/Lifecycle$Event;", "event", "e", "P", "Landroidx/lifecycle/Lifecycle;", "getLifecycle", "", "isAttached", "a", "(Z)V", "Lkotlin/Function1;", "Lkotlin/jvm/functions/Function1;", "findParentLifecycle", "b", "Landroid/view/View;", "view", "Landroidx/lifecycle/n;", "c", "Landroidx/lifecycle/n;", "localLifecycle", "d", "Z", "hasBeenDestroyed", "Landroidx/lifecycle/Lifecycle;", "parentLifecycle", "f", "destroyOnDetach", "enforceMainThread", "<init>", "(Lkotlin/jvm/functions/Function1;Z)V", "wf1-core-android"}, k = 1, mv = {1, 6, 0})
public final class RealWorkflowLifecycleOwner implements WorkflowLifecycleOwner, l, View.OnAttachStateChangeListener, i {

    /* renamed from: a  reason: collision with root package name */
    private final Function1<View, Lifecycle> f23200a;

    /* renamed from: b  reason: collision with root package name */
    private View f23201b;

    /* renamed from: c  reason: collision with root package name */
    private final n f23202c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f23203d;

    /* renamed from: e  reason: collision with root package name */
    private Lifecycle f23204e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f23205f;

    public RealWorkflowLifecycleOwner(Function1<? super View, ? extends Lifecycle> function1, boolean z10) {
        n nVar;
        j.g(function1, "findParentLifecycle");
        this.f23200a = function1;
        if (z10) {
            nVar = new n(this);
        } else {
            nVar = n.g(this);
            j.f(nVar, "createUnsafe(this)");
        }
        this.f23202c = nVar;
    }

    public static /* synthetic */ void b(RealWorkflowLifecycleOwner realWorkflowLifecycleOwner, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            View view = realWorkflowLifecycleOwner.f23201b;
            z10 = view == null ? false : view.isAttachedToWindow();
        }
        realWorkflowLifecycleOwner.a(z10);
    }

    public void P() {
        if (!this.f23205f) {
            this.f23205f = true;
            b(this, false, 1, (Object) null);
        }
    }

    public final void a(boolean z10) {
        Lifecycle.State state;
        Lifecycle lifecycle = this.f23204e;
        if (lifecycle == null) {
            state = null;
        } else {
            state = lifecycle.b();
        }
        Lifecycle.State b10 = this.f23202c.b();
        j.f(b10, "localLifecycle.currentState");
        Lifecycle.State state2 = Lifecycle.State.DESTROYED;
        if (b10 == state2 || this.f23203d) {
            this.f23201b = null;
            return;
        }
        n nVar = this.f23202c;
        if (this.f23205f && !z10) {
            state = state2;
        } else if (state == null && b10 != (state = Lifecycle.State.INITIALIZED)) {
            throw new AssertionError("Must have a parent lifecycle after attaching and until being destroyed.");
        }
        if (state == state2) {
            this.f23203d = true;
            Lifecycle lifecycle2 = this.f23204e;
            if (lifecycle2 != null) {
                lifecycle2.d(this);
            }
            this.f23204e = null;
            View view = this.f23201b;
            if (view != null) {
                this.f23201b = null;
                view.removeOnAttachStateChangeListener(this);
            }
            Lifecycle.State state3 = Lifecycle.State.INITIALIZED;
            if (b10 == state3) {
                state2 = state3;
            }
        } else {
            state2 = state;
        }
        nVar.p(state2);
    }

    public void e(l lVar, Lifecycle.Event event) {
        j.g(lVar, "source");
        j.g(event, "event");
        b(this, false, 1, (Object) null);
    }

    public Lifecycle getLifecycle() {
        return this.f23202c;
    }

    public void onViewAttachedToWindow(View view) {
        j.g(view, ReportingMessage.MessageType.SCREEN_VIEW);
        if (this.f23202c.b() != Lifecycle.State.DESTROYED && !this.f23203d) {
            this.f23201b = view;
            Lifecycle lifecycle = this.f23204e;
            Lifecycle invoke = this.f23200a.invoke(view);
            this.f23204e = invoke;
            if (invoke != lifecycle) {
                if (lifecycle != null) {
                    lifecycle.d(this);
                }
                Lifecycle lifecycle2 = this.f23204e;
                if (lifecycle2 != null) {
                    lifecycle2.a(this);
                }
            }
            a(true);
        }
    }

    public void onViewDetachedFromWindow(View view) {
        j.g(view, ReportingMessage.MessageType.SCREEN_VIEW);
        a(false);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RealWorkflowLifecycleOwner(Function1 function1, boolean z10, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(function1, (i10 & 2) != 0 ? true : z10);
    }
}
