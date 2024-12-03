package com.withpersona.sdk2.inquiry.governmentid.nfc;

import com.squareup.workflow1.ui.f;
import com.squareup.workflow1.ui.p;
import com.withpersona.sdk2.inquiry.steps.ui.UiScreen;
import com.withpersona.sdk2.inquiry.steps.ui.j;
import com.withpersona.sdk2.inquiry.steps.ui.m;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import pk.o;
import vi.b;

public final class PassportNfcConfirmDetailsView$special$$inlined$getViewFactoryForScreen$2 extends Lambda implements Function1<b, f<PassportNfcConfirmDetailsView>> {
    final /* synthetic */ Function2 $initialRendering;
    final /* synthetic */ o $showRendering;
    final /* synthetic */ UiScreen $uiScreen;

    public static final class a<RenderingT> implements f {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ o f25924b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ b f25925c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ j f25926d;

        public a(o oVar, b bVar, j jVar) {
            this.f25924b = oVar;
            this.f25925c = bVar;
            this.f25926d = jVar;
        }

        public final void a(RenderingT renderingt, p pVar) {
            kotlin.jvm.internal.j.g(renderingt, "rendering");
            kotlin.jvm.internal.j.g(pVar, "viewEnvironment");
            o oVar = this.f25924b;
            b bVar = this.f25925c;
            kotlin.jvm.internal.j.f(bVar, "binding");
            oVar.g(bVar, renderingt, pVar, this.f25926d.c().a());
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PassportNfcConfirmDetailsView$special$$inlined$getViewFactoryForScreen$2(UiScreen uiScreen, Function2 function2, o oVar) {
        super(1);
        this.$uiScreen = uiScreen;
        this.$initialRendering = function2;
        this.$showRendering = oVar;
    }

    /* renamed from: a */
    public final f<PassportNfcConfirmDetailsView> invoke(b bVar) {
        kotlin.jvm.internal.j.g(bVar, "binding");
        return new a(this.$showRendering, bVar, m.f27597a.k(bVar, this.$uiScreen, this.$initialRendering));
    }
}
