package com.coffeemeetsbagel.match_view;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.h;
import androidx.recyclerview.widget.q;
import k6.x;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import org.jivesoftware.smack.packet.Message;

public final class d extends q<Pair<? extends String, ? extends String>, b> {

    /* renamed from: f  reason: collision with root package name */
    public static final a f34661f = new a((DefaultConstructorMarker) null);

    public static final class a extends h.f<Pair<? extends String, ? extends String>> {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: d */
        public boolean a(Pair<String, String> pair, Pair<String, String> pair2) {
            j.g(pair, "oldItem");
            j.g(pair2, "newItem");
            return j.b(pair, pair2);
        }

        /* renamed from: e */
        public boolean b(Pair<String, String> pair, Pair<String, String> pair2) {
            j.g(pair, "oldItem");
            j.g(pair2, "newItem");
            return j.b(pair.c(), pair2.c());
        }
    }

    public static final class b extends RecyclerView.d0 {

        /* renamed from: u  reason: collision with root package name */
        private final x f34662u;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(x xVar) {
            super(xVar.getRoot());
            j.g(xVar, "binding");
            this.f34662u = xVar;
        }

        public final void V(Pair<String, String> pair) {
            j.g(pair, "item");
            this.f34662u.f15856b.setText(pair.c());
            this.f34662u.f15857c.setText(pair.d());
        }
    }

    public d() {
        super(f34661f);
    }

    /* renamed from: L */
    public void v(b bVar, int i10) {
        j.g(bVar, "holder");
        Object H = H(i10);
        j.f(H, "getItem(position)");
        bVar.V((Pair) H);
    }

    /* renamed from: M */
    public b x(ViewGroup viewGroup, int i10) {
        j.g(viewGroup, Message.Thread.PARENT_ATTRIBUTE_NAME);
        x c10 = x.c(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        j.f(c10, "inflate(inflator, parent, false)");
        return new b(c10);
    }
}
