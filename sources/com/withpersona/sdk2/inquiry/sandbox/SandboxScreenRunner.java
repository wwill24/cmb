package com.withpersona.sdk2.inquiry.sandbox;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.squareup.workflow1.ui.ViewBindingViewFactory;
import com.squareup.workflow1.ui.f;
import com.squareup.workflow1.ui.p;
import com.squareup.workflow1.ui.r;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import kotlin.jvm.internal.l;
import qi.g;
import ri.a;
import wk.c;

public final class SandboxScreenRunner implements f<b<?>> {

    /* renamed from: c  reason: collision with root package name */
    public static final Companion f27156c = new Companion((DefaultConstructorMarker) null);

    /* renamed from: b  reason: collision with root package name */
    private final a f27157b;

    public static final class Companion implements r<b<?>> {

        /* renamed from: a  reason: collision with root package name */
        private final /* synthetic */ r<b<?>> f27158a;

        private Companion() {
            f.a aVar = f.f23238a;
            this.f27158a = new ViewBindingViewFactory(l.b(b.class), AnonymousClass1.f27159a, AnonymousClass2.f27160a);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: b */
        public View a(b<?> bVar, p pVar, Context context, ViewGroup viewGroup) {
            j.g(bVar, "initialRendering");
            j.g(pVar, "initialViewEnvironment");
            j.g(context, "contextForNewView");
            return this.f27158a.a(bVar, pVar, context, viewGroup);
        }

        public c<? super b<?>> getType() {
            return this.f27158a.getType();
        }
    }

    public SandboxScreenRunner(a aVar) {
        j.g(aVar, "binding");
        this.f27157b = aVar;
    }

    /* access modifiers changed from: private */
    public static final void d(b bVar, a aVar, View view) {
        j.g(bVar, "$rendering");
        j.g(aVar, "$this_apply");
        bVar.c().invoke();
        Toast.makeText(aVar.f33799c.getRootView().getContext(), "Setting the debug flag to: " + SandboxFlags.f27148c.a(bVar.a().invoke()), 0).show();
    }

    /* renamed from: c */
    public void a(b<?> bVar, p pVar) {
        j.g(bVar, "rendering");
        j.g(pVar, "viewEnvironment");
        a aVar = this.f27157b;
        aVar.f33799c.setOnClickListener(new g(bVar, aVar));
        aVar.f33798b.c(bVar.b(), pVar);
    }
}
