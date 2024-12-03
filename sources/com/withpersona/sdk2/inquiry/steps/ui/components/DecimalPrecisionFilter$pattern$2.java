package com.withpersona.sdk2.inquiry.steps.ui.components;

import java.util.regex.Pattern;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

final class DecimalPrecisionFilter$pattern$2 extends Lambda implements Function0<Pattern> {
    final /* synthetic */ DecimalPrecisionFilter this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DecimalPrecisionFilter$pattern$2(DecimalPrecisionFilter decimalPrecisionFilter) {
        super(0);
        this.this$0 = decimalPrecisionFilter;
    }

    /* renamed from: a */
    public final Pattern invoke() {
        return Pattern.compile("-?[0-9]*+((\\.[0-9]{0," + this.this$0.f27563a + "})?)||(\\.)?");
    }
}
