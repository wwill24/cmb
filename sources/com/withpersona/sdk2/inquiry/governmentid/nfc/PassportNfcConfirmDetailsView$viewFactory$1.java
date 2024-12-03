package com.withpersona.sdk2.inquiry.governmentid.nfc;

import com.withpersona.sdk2.inquiry.steps.ui.a;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.j;
import vi.b;

/* synthetic */ class PassportNfcConfirmDetailsView$viewFactory$1 extends FunctionReferenceImpl implements Function2<b, Map<String, ? extends a>, Unit> {
    PassportNfcConfirmDetailsView$viewFactory$1(Object obj) {
        super(2, obj, PassportNfcConfirmDetailsView.class, "initialRendering", "initialRendering(Lcom/withpersona/sdk2/inquiry/shared/databinding/Pi2GenericUiStepScreenBinding;Ljava/util/Map;)V", 0);
    }

    public final void c(b bVar, Map<String, a> map) {
        j.g(bVar, "p0");
        j.g(map, "p1");
        ((PassportNfcConfirmDetailsView) this.receiver).h(bVar, map);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        c((b) obj, (Map) obj2);
        return Unit.f32013a;
    }
}
