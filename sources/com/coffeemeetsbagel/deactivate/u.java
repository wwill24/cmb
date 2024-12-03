package com.coffeemeetsbagel.deactivate;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.h;
import androidx.recyclerview.widget.q;
import com.coffeemeetsbagel.models.DeactivateReason;
import k6.e0;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smackx.jingle.element.JingleReason;

public final class u extends q<DeactivateReason, c> {

    /* renamed from: g  reason: collision with root package name */
    public static final b f12033g = new b((DefaultConstructorMarker) null);

    /* renamed from: f  reason: collision with root package name */
    private final a f12034f;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final Function1<Integer, Unit> f12035a;

        public a(Function1<? super Integer, Unit> function1) {
            j.g(function1, "clickListener");
            this.f12035a = function1;
        }

        public final void a(int i10) {
            this.f12035a.invoke(Integer.valueOf(i10));
        }
    }

    public static final class b extends h.f<DeactivateReason> {
        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: d */
        public boolean a(DeactivateReason deactivateReason, DeactivateReason deactivateReason2) {
            j.g(deactivateReason, "oldItem");
            j.g(deactivateReason2, "newItem");
            return j.b(deactivateReason, deactivateReason2);
        }

        /* renamed from: e */
        public boolean b(DeactivateReason deactivateReason, DeactivateReason deactivateReason2) {
            j.g(deactivateReason, "oldItem");
            j.g(deactivateReason2, "newItem");
            return deactivateReason.getReasonId() == deactivateReason2.getReasonId();
        }
    }

    public static final class c extends RecyclerView.d0 {

        /* renamed from: u  reason: collision with root package name */
        private final e0 f12036u;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(e0 e0Var) {
            super(e0Var.getRoot());
            j.g(e0Var, "binding");
            this.f12036u = e0Var;
        }

        public final void V(DeactivateReason deactivateReason) {
            int i10;
            j.g(deactivateReason, "item");
            e0 e0Var = this.f12036u;
            e0Var.f15736d.setText(deactivateReason.getDescription());
            ImageView imageView = e0Var.f15735c;
            if (deactivateReason.getChecked()) {
                i10 = 0;
            } else {
                i10 = 4;
            }
            imageView.setVisibility(i10);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public u(a aVar) {
        super(f12033g);
        j.g(aVar, "clickListener");
        this.f12034f = aVar;
    }

    /* access modifiers changed from: private */
    public static final void N(u uVar, int i10, View view) {
        j.g(uVar, "this$0");
        uVar.f12034f.a(i10);
    }

    /* renamed from: M */
    public void v(c cVar, int i10) {
        j.g(cVar, "holder");
        DeactivateReason deactivateReason = (DeactivateReason) H(i10);
        cVar.f6302a.setOnClickListener(new t(this, i10));
        j.f(deactivateReason, JingleReason.ELEMENT);
        cVar.V(deactivateReason);
    }

    /* renamed from: O */
    public c x(ViewGroup viewGroup, int i10) {
        j.g(viewGroup, Message.Thread.PARENT_ATTRIBUTE_NAME);
        e0 c10 = e0.c(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        j.f(c10, "inflate(\n               …      false\n            )");
        return new c(c10);
    }
}
