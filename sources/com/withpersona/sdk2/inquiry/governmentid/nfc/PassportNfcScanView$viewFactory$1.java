package com.withpersona.sdk2.inquiry.governmentid.nfc;

import com.squareup.workflow1.ui.p;
import com.withpersona.sdk2.inquiry.steps.ui.a;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.j;
import pk.o;
import vi.b;

/* synthetic */ class PassportNfcScanView$viewFactory$1 extends FunctionReferenceImpl implements o<b, PassportNfcScanView, p, Map<String, ? extends a>, Unit> {
    PassportNfcScanView$viewFactory$1(Object obj) {
        super(4, obj, PassportNfcScanView.class, "showRendering", "showRendering(Lcom/withpersona/sdk2/inquiry/shared/databinding/Pi2GenericUiStepScreenBinding;Lcom/withpersona/sdk2/inquiry/governmentid/nfc/PassportNfcScanView;Lcom/squareup/workflow1/ui/ViewEnvironment;Ljava/util/Map;)V", 0);
    }

    public final void c(b bVar, PassportNfcScanView passportNfcScanView, p pVar, Map<String, a> map) {
        j.g(bVar, "p0");
        j.g(passportNfcScanView, "p1");
        j.g(pVar, "p2");
        j.g(map, "p3");
        ((PassportNfcScanView) this.receiver).g(bVar, passportNfcScanView, pVar, map);
    }

    public /* bridge */ /* synthetic */ Object g(Object obj, Object obj2, Object obj3, Object obj4) {
        c((b) obj, (PassportNfcScanView) obj2, (p) obj3, (Map) obj4);
        return Unit.f32013a;
    }
}
