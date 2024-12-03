package com.withpersona.sdk2.inquiry.modal;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.mparticle.identity.IdentityHttpResponse;
import com.squareup.workflow1.ui.c;
import com.squareup.workflow1.ui.modal.ModalViewContainer;
import com.squareup.workflow1.ui.p;
import com.squareup.workflow1.ui.r;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import kotlin.jvm.internal.l;

public final class CustomModalViewContainer extends ModalViewContainer {

    /* renamed from: f  reason: collision with root package name */
    public static final Companion f26994f = new Companion((DefaultConstructorMarker) null);

    public static final class Companion implements r<b<?, ?>> {

        /* renamed from: a  reason: collision with root package name */
        private final /* synthetic */ c<b<?, ?>> f26995a;

        private Companion() {
            this.f26995a = new c<>(l.b(b.class), AnonymousClass1.f26996a);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: b */
        public View a(b<?, ?> bVar, p pVar, Context context, ViewGroup viewGroup) {
            j.g(bVar, "initialRendering");
            j.g(pVar, "initialViewEnvironment");
            j.g(context, "contextForNewView");
            return this.f26995a.a(bVar, pVar, context, viewGroup);
        }

        public wk.c<? super b<?, ?>> getType() {
            return this.f26995a.getType();
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CustomModalViewContainer(Context context, AttributeSet attributeSet, int i10, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i10, (i12 & 8) != 0 ? 0 : i11);
    }

    public Dialog g(View view) {
        j.g(view, "view");
        Dialog dialog = new Dialog(getContext());
        dialog.setContentView(view);
        Window window = dialog.getWindow();
        if (window != null) {
            window.setBackgroundDrawable((Drawable) null);
            window.setLayout(-1, -1);
            window.clearFlags(2);
        }
        return dialog;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CustomModalViewContainer(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        j.g(context, IdentityHttpResponse.CONTEXT);
    }
}
