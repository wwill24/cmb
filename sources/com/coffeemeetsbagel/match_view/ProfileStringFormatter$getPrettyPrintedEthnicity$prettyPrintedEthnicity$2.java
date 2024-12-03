package com.coffeemeetsbagel.match_view;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

final class ProfileStringFormatter$getPrettyPrintedEthnicity$prettyPrintedEthnicity$2 extends Lambda implements Function1<Integer, CharSequence> {
    final /* synthetic */ String[] $ethnicities;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ProfileStringFormatter$getPrettyPrintedEthnicity$prettyPrintedEthnicity$2(String[] strArr) {
        super(1);
        this.$ethnicities = strArr;
    }

    public final CharSequence a(int i10) {
        return this.$ethnicities[i10];
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return a(((Number) obj).intValue());
    }
}
