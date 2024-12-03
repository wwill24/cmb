package com.squareup.workflow1.ui.modal;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.n;
import com.mparticle.identity.IdentityHttpResponse;
import com.squareup.workflow1.ui.BackButtonScreen;
import com.squareup.workflow1.ui.ViewRegistryKt;
import com.squareup.workflow1.ui.b;
import com.squareup.workflow1.ui.modal.ModalContainer;
import com.squareup.workflow1.ui.p;
import com.squareup.workflow1.ui.s;
import com.squareup.workflow1.ui.t;
import com.squareup.workflow1.ui.u;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;

@Metadata(bv = {}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0017\u0018\u0000 \u00182\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0019B1\b\u0007\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0013¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0004J\u0016\u0010\u000e\u001a\u00020\r2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\nH\u0014¨\u0006\u001a"}, d2 = {"Lcom/squareup/workflow1/ui/modal/ModalViewContainer;", "Lcom/squareup/workflow1/ui/modal/ModalContainer;", "", "Landroid/view/View;", "view", "Landroid/app/Dialog;", "g", "initialModalRendering", "Lcom/squareup/workflow1/ui/p;", "initialViewEnvironment", "Lcom/squareup/workflow1/ui/modal/ModalContainer$a;", "b", "dialogRef", "", "d", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attributeSet", "", "defStyle", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "e", "a", "wf1-container-android"}, k = 1, mv = {1, 6, 0})
public class ModalViewContainer extends ModalContainer<Object> {

    /* renamed from: e  reason: collision with root package name */
    public static final a f23279e = new a((DefaultConstructorMarker) null);

    @Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/squareup/workflow1/ui/modal/ModalViewContainer$a;", "", "<init>", "()V", "wf1-container-android"}, k = 1, mv = {1, 6, 0})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ModalViewContainer(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        j.g(context, IdentityHttpResponse.CONTEXT);
    }

    /* access modifiers changed from: private */
    public static final boolean f(View view, DialogInterface dialogInterface, int i10, KeyEvent keyEvent) {
        OnBackPressedDispatcher onBackPressedDispatcher;
        j.g(view, "$view");
        if (i10 != 4 || keyEvent.getAction() != 1) {
            return false;
        }
        Context context = view.getContext();
        j.f(context, "view.context");
        n b10 = b.b(context);
        if (b10 == null || (onBackPressedDispatcher = b10.getOnBackPressedDispatcher()) == null || !onBackPressedDispatcher.d()) {
            return true;
        }
        onBackPressedDispatcher.e();
        return true;
    }

    /* access modifiers changed from: protected */
    public final ModalContainer.a<Object> b(Object obj, p pVar) {
        j.g(obj, "initialModalRendering");
        j.g(pVar, "initialViewEnvironment");
        BackButtonScreen backButtonScreen = new BackButtonScreen(obj, false, ModalViewContainer$buildDialog$wrappedRendering$1.f23280a, 2, (DefaultConstructorMarker) null);
        Context context = getContext();
        j.f(context, "this.context");
        View d10 = ViewRegistryKt.d((s) pVar.a(s.f23293a), backButtonScreen, pVar, context, this, (u) null, 16, (Object) null);
        t.h(d10);
        Dialog g10 = g(d10);
        g10.setOnKeyListener(new f(d10));
        return new ModalContainer.a<>(obj, pVar, g10, d10);
    }

    /* access modifiers changed from: protected */
    public void d(ModalContainer.a<Object> aVar) {
        j.g(aVar, "dialogRef");
        BackButtonScreen backButtonScreen = new BackButtonScreen(aVar.f(), false, ModalViewContainer$updateDialog$1$wrappedRendering$1.f23281a, 2, (DefaultConstructorMarker) null);
        Object e10 = aVar.e();
        if (e10 != null) {
            t.g((View) e10, backButtonScreen, aVar.h());
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.View");
    }

    public Dialog g(View view) {
        j.g(view, "view");
        Dialog dialog = new Dialog(getContext());
        dialog.setCancelable(false);
        dialog.setContentView(view);
        Window window = dialog.getWindow();
        j.d(window);
        window.setLayout(-2, -2);
        Window window2 = dialog.getWindow();
        j.d(window2);
        window2.setBackgroundDrawable((Drawable) null);
        return dialog;
    }
}
