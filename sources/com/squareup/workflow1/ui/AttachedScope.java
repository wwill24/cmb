package com.squareup.workflow1.ui;

import android.view.View;
import com.mparticle.kits.ReportingMessage;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.j;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.v1;
import kotlinx.coroutines.z;
import org.jivesoftware.smackx.blocking.element.BlockContactsIQ;

@Metadata(bv = {}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0016\u001a\u00020\u0012¢\u0006\u0004\b\u0017\u0010\u0018J\u0014\u0010\u0005\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0016R \u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\n8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0015\u001a\u00020\u00128\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u000f\u0010\u0014¨\u0006\u0019"}, d2 = {"Lcom/squareup/workflow1/ui/AttachedScope;", "Landroid/view/View$OnAttachStateChangeListener;", "Lkotlin/Function0;", "", "block", "c", "Landroid/view/View;", "v", "onViewAttachedToWindow", "onViewDetachedFromWindow", "", "a", "Ljava/util/List;", "attachHandlers", "Lkotlinx/coroutines/z;", "b", "Lkotlinx/coroutines/z;", "attachedJob", "Lkotlinx/coroutines/k0;", "Lkotlinx/coroutines/k0;", "()Lkotlinx/coroutines/k0;", "coroutineScope", "parentCoroutineScope", "<init>", "(Lkotlinx/coroutines/k0;)V", "wf1-core-android"}, k = 1, mv = {1, 6, 0})
final class AttachedScope implements View.OnAttachStateChangeListener {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final List<Function0<Unit>> f23154a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    private final z f23155b;

    /* renamed from: c  reason: collision with root package name */
    private final k0 f23156c;

    public AttachedScope(k0 k0Var) {
        j.g(k0Var, "parentCoroutineScope");
        z a10 = v1.a(v1.k(k0Var.G()));
        a10.y(new AttachedScope$attachedJob$1$1(this));
        this.f23155b = a10;
        this.f23156c = l0.j(k0Var, a10);
    }

    public final k0 b() {
        return this.f23156c;
    }

    public final void c(Function0<Unit> function0) {
        j.g(function0, BlockContactsIQ.ELEMENT);
        if (l0.i(this.f23156c)) {
            this.f23154a.add(function0);
            return;
        }
        throw new IllegalStateException("Expected AttachedScope to be active when adding attach handler.".toString());
    }

    public void onViewAttachedToWindow(View view) {
        j.g(view, ReportingMessage.MessageType.SCREEN_VIEW);
        List<Function0<Unit>> list = this.f23154a;
        for (Function0 invoke : list) {
            invoke.invoke();
        }
        list.clear();
    }

    public void onViewDetachedFromWindow(View view) {
        j.g(view, ReportingMessage.MessageType.SCREEN_VIEW);
        l0.e(this.f23156c, "View detached", (Throwable) null, 2, (Object) null);
        view.removeOnAttachStateChangeListener(this);
    }
}
