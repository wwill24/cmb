package com.withpersona.sdk2.inquiry.internal.network;

import com.withpersona.sdk2.inquiry.governmentid.IdConfig;
import com.withpersona.sdk2.inquiry.internal.network.NextStep;
import gk.h;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

final class NextStep$GovernmentId$RequestPage$titleBySide$2 extends Lambda implements Function0<Map<Pair<? extends IdConfig.Side, ? extends String>, ? extends String>> {
    final /* synthetic */ NextStep.GovernmentId.RequestPage this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NextStep$GovernmentId$RequestPage$titleBySide$2(NextStep.GovernmentId.RequestPage requestPage) {
        super(0);
        this.this$0 = requestPage;
    }

    public final Map<Pair<IdConfig.Side, String>, String> invoke() {
        return h0.l(h.a(new Pair(IdConfig.Side.Front, "titleFront"), this.this$0.k()), h.a(new Pair(IdConfig.Side.Back, "titleBack"), this.this$0.i()), h.a(new Pair(IdConfig.Side.BarcodePdf417, "titlePdf417"), this.this$0.m()), h.a(new Pair(IdConfig.Side.PassportSignature, "titlePassportSignature"), this.this$0.l()));
    }
}
