package com.coffeemeetsbagel.feature.logout;

import com.withpersona.sdk2.inquiry.InquiryResponse;
import fa.a;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

final class BannedActivity$observeResponse$1 extends Lambda implements Function1<InquiryResponse, Unit> {
    final /* synthetic */ BannedActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BannedActivity$observeResponse$1(BannedActivity bannedActivity) {
        super(1);
        this.this$0 = bannedActivity;
    }

    public final void a(InquiryResponse inquiryResponse) {
        if (inquiryResponse == null) {
            return;
        }
        if (inquiryResponse instanceof InquiryResponse.Complete) {
            a.f40771d.a(this.this$0.f13062c, "Persona was a success.");
            this.this$0.setResult(73);
            this.this$0.finish();
        } else if (inquiryResponse instanceof InquiryResponse.Error) {
            a.C0491a aVar = a.f40771d;
            String L0 = this.this$0.f13062c;
            InquiryResponse.Error error = (InquiryResponse.Error) inquiryResponse;
            String debugMessage = error.getDebugMessage();
            aVar.c(L0, "Persona request failed. " + debugMessage, new Exception(error.getDebugMessage()));
            this.this$0.c1();
        } else {
            a.f40771d.a(this.this$0.f13062c, "Persona did not complete.");
            this.this$0.setResult(72);
            this.this$0.finish();
        }
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((InquiryResponse) obj);
        return Unit.f32013a;
    }
}
