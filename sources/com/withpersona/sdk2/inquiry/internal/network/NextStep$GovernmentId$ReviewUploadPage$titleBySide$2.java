package com.withpersona.sdk2.inquiry.internal.network;

import com.withpersona.sdk2.inquiry.governmentid.IdConfig;
import com.withpersona.sdk2.inquiry.internal.network.NextStep;
import gk.h;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

final class NextStep$GovernmentId$ReviewUploadPage$titleBySide$2 extends Lambda implements Function0<Map<IdConfig.Side, ? extends String>> {
    final /* synthetic */ NextStep.GovernmentId.ReviewUploadPage this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NextStep$GovernmentId$ReviewUploadPage$titleBySide$2(NextStep.GovernmentId.ReviewUploadPage reviewUploadPage) {
        super(0);
        this.this$0 = reviewUploadPage;
    }

    public final Map<IdConfig.Side, String> invoke() {
        return h0.l(h.a(IdConfig.Side.Front, this.this$0.k()), h.a(IdConfig.Side.Back, this.this$0.i()), h.a(IdConfig.Side.BarcodePdf417, this.this$0.m()), h.a(IdConfig.Side.PassportSignature, this.this$0.l()));
    }
}
