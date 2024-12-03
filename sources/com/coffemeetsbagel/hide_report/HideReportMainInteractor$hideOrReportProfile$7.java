package com.coffemeetsbagel.hide_report;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class HideReportMainInteractor$hideOrReportProfile$7 extends Lambda implements Function1<String, Unit> {
    final /* synthetic */ String $details;
    final /* synthetic */ String $profileId;
    final /* synthetic */ String $reasonCategory;
    final /* synthetic */ HideReportMainInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HideReportMainInteractor$hideOrReportProfile$7(HideReportMainInteractor hideReportMainInteractor, String str, String str2, String str3) {
        super(1);
        this.this$0 = hideReportMainInteractor;
        this.$reasonCategory = str;
        this.$details = str2;
        this.$profileId = str3;
    }

    public final void a(String str) {
        this.this$0.r2(this.$reasonCategory, this.$details);
        if (j.b(this.$reasonCategory, "remove")) {
            ((w) this.this$0.B1()).o(this.$profileId, true, this.this$0.f37635f);
        } else {
            ((w) this.this$0.B1()).o(this.$profileId, false, this.this$0.f37635f);
        }
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((String) obj);
        return Unit.f32013a;
    }
}
