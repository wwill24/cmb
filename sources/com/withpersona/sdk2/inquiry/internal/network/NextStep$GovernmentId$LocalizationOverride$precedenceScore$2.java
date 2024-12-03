package com.withpersona.sdk2.inquiry.internal.network;

import com.withpersona.sdk2.inquiry.internal.network.NextStep;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

final class NextStep$GovernmentId$LocalizationOverride$precedenceScore$2 extends Lambda implements Function0<Integer> {
    final /* synthetic */ NextStep.GovernmentId.LocalizationOverride this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NextStep$GovernmentId$LocalizationOverride$precedenceScore$2(NextStep.GovernmentId.LocalizationOverride localizationOverride) {
        super(0);
        this.this$0 = localizationOverride;
    }

    /* renamed from: a */
    public final Integer invoke() {
        int i10;
        if (this.this$0.c() != null) {
            i10 = 1;
        } else {
            i10 = 0;
        }
        int i11 = i10 * 2;
        if (this.this$0.d() != null) {
            i11++;
        }
        int i12 = i11 * 2;
        if (this.this$0.j() != null) {
            i12++;
        }
        return Integer.valueOf(i12);
    }
}
