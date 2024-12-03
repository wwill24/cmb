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

public final class PassportNfcInstructionsView$special$$inlined$getViewFactoryForScreen$default$2 extends Lambda implements Function1<b, f<PassportNfcInstructionsView>> {
    final /* synthetic */ Function2 $initialRendering;
    final /* synthetic */ o $showRendering;
    final /* synthetic */ UiScreen $uiScreen;

    public static final class a<RenderingT> implements f {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ o f25939b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ b f25940c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ j f25941d;

        public a(o oVar, b bVar, j jVar) {
            this.f25939b = oVar;
            this.f25940c = bVar;
            this.f25941d = jVar;
        }

        public final void a(RenderingT renderingt, p pVar) {
            kotlin.jvm.internal.j.g(renderingt, "rendering");
            kotlin.jvm.internal.j.g(pVar, "viewEnvironment");
            o oVar = this.f25939b;
            b bVar = this.f25940c;
            kotlin.jvm.internal.j.f(bVar, "binding");
            oVar.g(bVar, renderingt, pVar, this.f25941d.c().a());
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PassportNfcInstructionsView$special$$inlined$getViewFactoryForScreen$default$2(UiScreen uiScreen, Function2 function2, o oVar) {
        super(1);
        this.$uiScreen = uiScreen;
        this.$initialRendering = function2;
        this.$showRendering = oVar;
    }

    /* renamed from: a */
    public final f<PassportNfcInstructionsView> invoke(b bVar) {
        kotlin.jvm.internal.j.g(bVar, "binding");
        return new a(this.$showRendering, bVar, m.f27597a.k(bVar, this.$uiScreen, this.$initialRendering));
    }
}
